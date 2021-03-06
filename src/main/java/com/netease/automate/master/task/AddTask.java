package com.netease.automate.master.task;

import org.apache.zookeeper.ZooKeeper;

import com.netease.automate.meta.PackageMeta;
import com.netease.automate.utils.Utils;

/**
 * Task which will add a node after task done.
 * 
 * @author jiaozhihui@corp.netease.com
 */
public class AddTask extends CommonPackageTask {
    private ZooKeeper zk;
    private String pkgTargetPath;

    public AddTask(ZooKeeper zk, String projectName, String action, PackageMeta packageMeta, String target,
            String pkgTargetPath) {
        super(zk, projectName, action, packageMeta, target, pkgTargetPath);
        this.zk = zk;
        this.pkgTargetPath = pkgTargetPath;
    }

    @Override
    public boolean checkTask() {
        return Utils.checkNode(zk, pkgTargetPath);
    }
}
