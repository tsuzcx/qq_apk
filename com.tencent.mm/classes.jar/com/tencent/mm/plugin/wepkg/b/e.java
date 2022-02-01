package com.tencent.mm.plugin.wepkg.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gs;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class e
  extends gs
{
  public static final c.a gLr;
  
  static
  {
    AppMethodBeat.i(110570);
    c.a locala = new c.a();
    locala.EYt = new Field[25];
    locala.columns = new String[26];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "pkgId";
    locala.EYv.put("pkgId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" pkgId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.EYu = "pkgId";
    locala.columns[1] = "appId";
    locala.EYv.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "version";
    locala.EYv.put("version", "TEXT");
    localStringBuilder.append(" version TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "pkgPath";
    locala.EYv.put("pkgPath", "TEXT");
    localStringBuilder.append(" pkgPath TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "disableWvCache";
    locala.EYv.put("disableWvCache", "INTEGER default 'true' ");
    localStringBuilder.append(" disableWvCache INTEGER default 'true' ");
    localStringBuilder.append(", ");
    locala.columns[5] = "clearPkgTime";
    locala.EYv.put("clearPkgTime", "LONG");
    localStringBuilder.append(" clearPkgTime LONG");
    localStringBuilder.append(", ");
    locala.columns[6] = "checkIntervalTime";
    locala.EYv.put("checkIntervalTime", "LONG");
    localStringBuilder.append(" checkIntervalTime LONG");
    localStringBuilder.append(", ");
    locala.columns[7] = "packMethod";
    locala.EYv.put("packMethod", "INTEGER");
    localStringBuilder.append(" packMethod INTEGER");
    localStringBuilder.append(", ");
    locala.columns[8] = "domain";
    locala.EYv.put("domain", "TEXT");
    localStringBuilder.append(" domain TEXT");
    localStringBuilder.append(", ");
    locala.columns[9] = "md5";
    locala.EYv.put("md5", "TEXT");
    localStringBuilder.append(" md5 TEXT");
    localStringBuilder.append(", ");
    locala.columns[10] = "downloadUrl";
    locala.EYv.put("downloadUrl", "TEXT");
    localStringBuilder.append(" downloadUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[11] = "pkgSize";
    locala.EYv.put("pkgSize", "INTEGER");
    localStringBuilder.append(" pkgSize INTEGER");
    localStringBuilder.append(", ");
    locala.columns[12] = "downloadNetType";
    locala.EYv.put("downloadNetType", "INTEGER");
    localStringBuilder.append(" downloadNetType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[13] = "nextCheckTime";
    locala.EYv.put("nextCheckTime", "LONG");
    localStringBuilder.append(" nextCheckTime LONG");
    localStringBuilder.append(", ");
    locala.columns[14] = "createTime";
    locala.EYv.put("createTime", "LONG");
    localStringBuilder.append(" createTime LONG");
    localStringBuilder.append(", ");
    locala.columns[15] = "accessTime";
    locala.EYv.put("accessTime", "LONG default '0' ");
    localStringBuilder.append(" accessTime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[16] = "charset";
    locala.EYv.put("charset", "TEXT default 'UTF-8' ");
    localStringBuilder.append(" charset TEXT default 'UTF-8' ");
    localStringBuilder.append(", ");
    locala.columns[17] = "bigPackageReady";
    locala.EYv.put("bigPackageReady", "INTEGER default 'false' ");
    localStringBuilder.append(" bigPackageReady INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[18] = "preloadFilesReady";
    locala.EYv.put("preloadFilesReady", "INTEGER default 'false' ");
    localStringBuilder.append(" preloadFilesReady INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[19] = "preloadFilesAtomic";
    locala.EYv.put("preloadFilesAtomic", "INTEGER default 'false' ");
    localStringBuilder.append(" preloadFilesAtomic INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[20] = "autoDownloadCount";
    locala.EYv.put("autoDownloadCount", "INTEGER default '0' ");
    localStringBuilder.append(" autoDownloadCount INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[21] = "disable";
    locala.EYv.put("disable", "INTEGER default 'false' ");
    localStringBuilder.append(" disable INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[22] = "totalDownloadCount";
    locala.EYv.put("totalDownloadCount", "INTEGER default '0' ");
    localStringBuilder.append(" totalDownloadCount INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[23] = "packageDownloadCount";
    locala.EYv.put("packageDownloadCount", "INTEGER default '0' ");
    localStringBuilder.append(" packageDownloadCount INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[24] = "downloadTriggerType";
    locala.EYv.put("downloadTriggerType", "INTEGER default '-1' ");
    localStringBuilder.append(" downloadTriggerType INTEGER default '-1' ");
    locala.columns[25] = "rowid";
    locala.sql = localStringBuilder.toString();
    gLr = locala;
    AppMethodBeat.o(110570);
  }
  
  public final c.a getDBInfo()
  {
    return gLr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.b.e
 * JD-Core Version:    0.7.0.1
 */