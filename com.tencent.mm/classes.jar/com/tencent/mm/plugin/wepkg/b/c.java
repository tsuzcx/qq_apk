package com.tencent.mm.plugin.wepkg.b;

import com.tencent.mm.h.c.fg;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class c
  extends fg
{
  public static final c.a dUa;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[25];
    locala.columns = new String[26];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "pkgId";
    locala.ujN.put("pkgId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" pkgId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "pkgId";
    locala.columns[1] = "appId";
    locala.ujN.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "version";
    locala.ujN.put("version", "TEXT");
    localStringBuilder.append(" version TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "pkgPath";
    locala.ujN.put("pkgPath", "TEXT");
    localStringBuilder.append(" pkgPath TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "disableWvCache";
    locala.ujN.put("disableWvCache", "INTEGER default 'true' ");
    localStringBuilder.append(" disableWvCache INTEGER default 'true' ");
    localStringBuilder.append(", ");
    locala.columns[5] = "clearPkgTime";
    locala.ujN.put("clearPkgTime", "LONG");
    localStringBuilder.append(" clearPkgTime LONG");
    localStringBuilder.append(", ");
    locala.columns[6] = "checkIntervalTime";
    locala.ujN.put("checkIntervalTime", "LONG");
    localStringBuilder.append(" checkIntervalTime LONG");
    localStringBuilder.append(", ");
    locala.columns[7] = "packMethod";
    locala.ujN.put("packMethod", "INTEGER");
    localStringBuilder.append(" packMethod INTEGER");
    localStringBuilder.append(", ");
    locala.columns[8] = "domain";
    locala.ujN.put("domain", "TEXT");
    localStringBuilder.append(" domain TEXT");
    localStringBuilder.append(", ");
    locala.columns[9] = "md5";
    locala.ujN.put("md5", "TEXT");
    localStringBuilder.append(" md5 TEXT");
    localStringBuilder.append(", ");
    locala.columns[10] = "downloadUrl";
    locala.ujN.put("downloadUrl", "TEXT");
    localStringBuilder.append(" downloadUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[11] = "pkgSize";
    locala.ujN.put("pkgSize", "INTEGER");
    localStringBuilder.append(" pkgSize INTEGER");
    localStringBuilder.append(", ");
    locala.columns[12] = "downloadNetType";
    locala.ujN.put("downloadNetType", "INTEGER");
    localStringBuilder.append(" downloadNetType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[13] = "nextCheckTime";
    locala.ujN.put("nextCheckTime", "LONG");
    localStringBuilder.append(" nextCheckTime LONG");
    localStringBuilder.append(", ");
    locala.columns[14] = "createTime";
    locala.ujN.put("createTime", "LONG");
    localStringBuilder.append(" createTime LONG");
    localStringBuilder.append(", ");
    locala.columns[15] = "accessTime";
    locala.ujN.put("accessTime", "LONG default '0' ");
    localStringBuilder.append(" accessTime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[16] = "charset";
    locala.ujN.put("charset", "TEXT default 'UTF-8' ");
    localStringBuilder.append(" charset TEXT default 'UTF-8' ");
    localStringBuilder.append(", ");
    locala.columns[17] = "bigPackageReady";
    locala.ujN.put("bigPackageReady", "INTEGER default 'false' ");
    localStringBuilder.append(" bigPackageReady INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[18] = "preloadFilesReady";
    locala.ujN.put("preloadFilesReady", "INTEGER default 'false' ");
    localStringBuilder.append(" preloadFilesReady INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[19] = "preloadFilesAtomic";
    locala.ujN.put("preloadFilesAtomic", "INTEGER default 'false' ");
    localStringBuilder.append(" preloadFilesAtomic INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[20] = "autoDownloadCount";
    locala.ujN.put("autoDownloadCount", "INTEGER default '0' ");
    localStringBuilder.append(" autoDownloadCount INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[21] = "disable";
    locala.ujN.put("disable", "INTEGER default 'false' ");
    localStringBuilder.append(" disable INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[22] = "totalDownloadCount";
    locala.ujN.put("totalDownloadCount", "INTEGER default '0' ");
    localStringBuilder.append(" totalDownloadCount INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[23] = "packageDownloadCount";
    locala.ujN.put("packageDownloadCount", "INTEGER default '0' ");
    localStringBuilder.append(" packageDownloadCount INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[24] = "downloadTriggerType";
    locala.ujN.put("downloadTriggerType", "INTEGER default '-1' ");
    localStringBuilder.append(" downloadTriggerType INTEGER default '-1' ");
    locala.columns[25] = "rowid";
    locala.sql = localStringBuilder.toString();
    dUa = locala;
  }
  
  protected final c.a rM()
  {
    return dUa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.b.c
 * JD-Core Version:    0.7.0.1
 */