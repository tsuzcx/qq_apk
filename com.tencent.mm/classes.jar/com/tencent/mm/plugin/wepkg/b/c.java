package com.tencent.mm.plugin.wepkg.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gv;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class c
  extends gv
{
  public static final c.a hlR;
  
  static
  {
    AppMethodBeat.i(110562);
    c.a locala = new c.a();
    locala.GvF = new Field[14];
    locala.columns = new String[15];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "key";
    locala.GvH.put("key", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" key TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.GvG = "key";
    locala.columns[1] = "pkgId";
    locala.GvH.put("pkgId", "TEXT");
    localStringBuilder.append(" pkgId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "version";
    locala.GvH.put("version", "TEXT");
    localStringBuilder.append(" version TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "filePath";
    locala.GvH.put("filePath", "TEXT");
    localStringBuilder.append(" filePath TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "rid";
    locala.GvH.put("rid", "TEXT");
    localStringBuilder.append(" rid TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "mimeType";
    locala.GvH.put("mimeType", "TEXT");
    localStringBuilder.append(" mimeType TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "md5";
    locala.GvH.put("md5", "TEXT");
    localStringBuilder.append(" md5 TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "downloadUrl";
    locala.GvH.put("downloadUrl", "TEXT");
    localStringBuilder.append(" downloadUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "size";
    locala.GvH.put("size", "INTEGER");
    localStringBuilder.append(" size INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "downloadNetType";
    locala.GvH.put("downloadNetType", "INTEGER");
    localStringBuilder.append(" downloadNetType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[10] = "completeDownload";
    locala.GvH.put("completeDownload", "INTEGER default 'false' ");
    localStringBuilder.append(" completeDownload INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[11] = "createTime";
    locala.GvH.put("createTime", "LONG");
    localStringBuilder.append(" createTime LONG");
    localStringBuilder.append(", ");
    locala.columns[12] = "autoDownloadCount";
    locala.GvH.put("autoDownloadCount", "INTEGER default '0' ");
    localStringBuilder.append(" autoDownloadCount INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[13] = "fileDownloadCount";
    locala.GvH.put("fileDownloadCount", "INTEGER default '0' ");
    localStringBuilder.append(" fileDownloadCount INTEGER default '0' ");
    locala.columns[14] = "rowid";
    locala.sql = localStringBuilder.toString();
    hlR = locala;
    AppMethodBeat.o(110562);
  }
  
  public final c.a getDBInfo()
  {
    return hlR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.b.c
 * JD-Core Version:    0.7.0.1
 */