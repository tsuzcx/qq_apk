package com.tencent.mm.plugin.wepkg.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.hg;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class e
  extends hg
{
  public static final c.a hEe;
  
  static
  {
    AppMethodBeat.i(110570);
    c.a locala = new c.a();
    locala.IhA = new Field[25];
    locala.columns = new String[26];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "pkgId";
    locala.IhC.put("pkgId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" pkgId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "pkgId";
    locala.columns[1] = "appId";
    locala.IhC.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "version";
    locala.IhC.put("version", "TEXT");
    localStringBuilder.append(" version TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "pkgPath";
    locala.IhC.put("pkgPath", "TEXT");
    localStringBuilder.append(" pkgPath TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "disableWvCache";
    locala.IhC.put("disableWvCache", "INTEGER default 'true' ");
    localStringBuilder.append(" disableWvCache INTEGER default 'true' ");
    localStringBuilder.append(", ");
    locala.columns[5] = "clearPkgTime";
    locala.IhC.put("clearPkgTime", "LONG");
    localStringBuilder.append(" clearPkgTime LONG");
    localStringBuilder.append(", ");
    locala.columns[6] = "checkIntervalTime";
    locala.IhC.put("checkIntervalTime", "LONG");
    localStringBuilder.append(" checkIntervalTime LONG");
    localStringBuilder.append(", ");
    locala.columns[7] = "packMethod";
    locala.IhC.put("packMethod", "INTEGER");
    localStringBuilder.append(" packMethod INTEGER");
    localStringBuilder.append(", ");
    locala.columns[8] = "domain";
    locala.IhC.put("domain", "TEXT");
    localStringBuilder.append(" domain TEXT");
    localStringBuilder.append(", ");
    locala.columns[9] = "md5";
    locala.IhC.put("md5", "TEXT");
    localStringBuilder.append(" md5 TEXT");
    localStringBuilder.append(", ");
    locala.columns[10] = "downloadUrl";
    locala.IhC.put("downloadUrl", "TEXT");
    localStringBuilder.append(" downloadUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[11] = "pkgSize";
    locala.IhC.put("pkgSize", "INTEGER");
    localStringBuilder.append(" pkgSize INTEGER");
    localStringBuilder.append(", ");
    locala.columns[12] = "downloadNetType";
    locala.IhC.put("downloadNetType", "INTEGER");
    localStringBuilder.append(" downloadNetType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[13] = "nextCheckTime";
    locala.IhC.put("nextCheckTime", "LONG");
    localStringBuilder.append(" nextCheckTime LONG");
    localStringBuilder.append(", ");
    locala.columns[14] = "createTime";
    locala.IhC.put("createTime", "LONG");
    localStringBuilder.append(" createTime LONG");
    localStringBuilder.append(", ");
    locala.columns[15] = "accessTime";
    locala.IhC.put("accessTime", "LONG default '0' ");
    localStringBuilder.append(" accessTime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[16] = "charset";
    locala.IhC.put("charset", "TEXT default 'UTF-8' ");
    localStringBuilder.append(" charset TEXT default 'UTF-8' ");
    localStringBuilder.append(", ");
    locala.columns[17] = "bigPackageReady";
    locala.IhC.put("bigPackageReady", "INTEGER default 'false' ");
    localStringBuilder.append(" bigPackageReady INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[18] = "preloadFilesReady";
    locala.IhC.put("preloadFilesReady", "INTEGER default 'false' ");
    localStringBuilder.append(" preloadFilesReady INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[19] = "preloadFilesAtomic";
    locala.IhC.put("preloadFilesAtomic", "INTEGER default 'false' ");
    localStringBuilder.append(" preloadFilesAtomic INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[20] = "autoDownloadCount";
    locala.IhC.put("autoDownloadCount", "INTEGER default '0' ");
    localStringBuilder.append(" autoDownloadCount INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[21] = "disable";
    locala.IhC.put("disable", "INTEGER default 'false' ");
    localStringBuilder.append(" disable INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[22] = "totalDownloadCount";
    locala.IhC.put("totalDownloadCount", "INTEGER default '0' ");
    localStringBuilder.append(" totalDownloadCount INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[23] = "packageDownloadCount";
    locala.IhC.put("packageDownloadCount", "INTEGER default '0' ");
    localStringBuilder.append(" packageDownloadCount INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[24] = "downloadTriggerType";
    locala.IhC.put("downloadTriggerType", "INTEGER default '-1' ");
    localStringBuilder.append(" downloadTriggerType INTEGER default '-1' ");
    locala.columns[25] = "rowid";
    locala.sql = localStringBuilder.toString();
    hEe = locala;
    AppMethodBeat.o(110570);
  }
  
  public final c.a getDBInfo()
  {
    return hEe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.b.e
 * JD-Core Version:    0.7.0.1
 */