package com.tencent.mm.plugin.wepkg.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fu;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class e
  extends fu
{
  public static final c.a fkk;
  
  static
  {
    AppMethodBeat.i(63399);
    c.a locala = new c.a();
    locala.yrK = new Field[25];
    locala.columns = new String[26];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "pkgId";
    locala.yrM.put("pkgId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" pkgId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.yrL = "pkgId";
    locala.columns[1] = "appId";
    locala.yrM.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "version";
    locala.yrM.put("version", "TEXT");
    localStringBuilder.append(" version TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "pkgPath";
    locala.yrM.put("pkgPath", "TEXT");
    localStringBuilder.append(" pkgPath TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "disableWvCache";
    locala.yrM.put("disableWvCache", "INTEGER default 'true' ");
    localStringBuilder.append(" disableWvCache INTEGER default 'true' ");
    localStringBuilder.append(", ");
    locala.columns[5] = "clearPkgTime";
    locala.yrM.put("clearPkgTime", "LONG");
    localStringBuilder.append(" clearPkgTime LONG");
    localStringBuilder.append(", ");
    locala.columns[6] = "checkIntervalTime";
    locala.yrM.put("checkIntervalTime", "LONG");
    localStringBuilder.append(" checkIntervalTime LONG");
    localStringBuilder.append(", ");
    locala.columns[7] = "packMethod";
    locala.yrM.put("packMethod", "INTEGER");
    localStringBuilder.append(" packMethod INTEGER");
    localStringBuilder.append(", ");
    locala.columns[8] = "domain";
    locala.yrM.put("domain", "TEXT");
    localStringBuilder.append(" domain TEXT");
    localStringBuilder.append(", ");
    locala.columns[9] = "md5";
    locala.yrM.put("md5", "TEXT");
    localStringBuilder.append(" md5 TEXT");
    localStringBuilder.append(", ");
    locala.columns[10] = "downloadUrl";
    locala.yrM.put("downloadUrl", "TEXT");
    localStringBuilder.append(" downloadUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[11] = "pkgSize";
    locala.yrM.put("pkgSize", "INTEGER");
    localStringBuilder.append(" pkgSize INTEGER");
    localStringBuilder.append(", ");
    locala.columns[12] = "downloadNetType";
    locala.yrM.put("downloadNetType", "INTEGER");
    localStringBuilder.append(" downloadNetType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[13] = "nextCheckTime";
    locala.yrM.put("nextCheckTime", "LONG");
    localStringBuilder.append(" nextCheckTime LONG");
    localStringBuilder.append(", ");
    locala.columns[14] = "createTime";
    locala.yrM.put("createTime", "LONG");
    localStringBuilder.append(" createTime LONG");
    localStringBuilder.append(", ");
    locala.columns[15] = "accessTime";
    locala.yrM.put("accessTime", "LONG default '0' ");
    localStringBuilder.append(" accessTime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[16] = "charset";
    locala.yrM.put("charset", "TEXT default 'UTF-8' ");
    localStringBuilder.append(" charset TEXT default 'UTF-8' ");
    localStringBuilder.append(", ");
    locala.columns[17] = "bigPackageReady";
    locala.yrM.put("bigPackageReady", "INTEGER default 'false' ");
    localStringBuilder.append(" bigPackageReady INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[18] = "preloadFilesReady";
    locala.yrM.put("preloadFilesReady", "INTEGER default 'false' ");
    localStringBuilder.append(" preloadFilesReady INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[19] = "preloadFilesAtomic";
    locala.yrM.put("preloadFilesAtomic", "INTEGER default 'false' ");
    localStringBuilder.append(" preloadFilesAtomic INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[20] = "autoDownloadCount";
    locala.yrM.put("autoDownloadCount", "INTEGER default '0' ");
    localStringBuilder.append(" autoDownloadCount INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[21] = "disable";
    locala.yrM.put("disable", "INTEGER default 'false' ");
    localStringBuilder.append(" disable INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[22] = "totalDownloadCount";
    locala.yrM.put("totalDownloadCount", "INTEGER default '0' ");
    localStringBuilder.append(" totalDownloadCount INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[23] = "packageDownloadCount";
    locala.yrM.put("packageDownloadCount", "INTEGER default '0' ");
    localStringBuilder.append(" packageDownloadCount INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[24] = "downloadTriggerType";
    locala.yrM.put("downloadTriggerType", "INTEGER default '-1' ");
    localStringBuilder.append(" downloadTriggerType INTEGER default '-1' ");
    locala.columns[25] = "rowid";
    locala.sql = localStringBuilder.toString();
    fkk = locala;
    AppMethodBeat.o(63399);
  }
  
  public final c.a getDBInfo()
  {
    return fkk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.b.e
 * JD-Core Version:    0.7.0.1
 */