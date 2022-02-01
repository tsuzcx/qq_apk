package com.tencent.mm.plugin.wepkg.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gr;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class c
  extends gr
{
  public static final c.a gLr;
  
  static
  {
    AppMethodBeat.i(110562);
    c.a locala = new c.a();
    locala.EYt = new Field[14];
    locala.columns = new String[15];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "key";
    locala.EYv.put("key", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" key TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.EYu = "key";
    locala.columns[1] = "pkgId";
    locala.EYv.put("pkgId", "TEXT");
    localStringBuilder.append(" pkgId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "version";
    locala.EYv.put("version", "TEXT");
    localStringBuilder.append(" version TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "filePath";
    locala.EYv.put("filePath", "TEXT");
    localStringBuilder.append(" filePath TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "rid";
    locala.EYv.put("rid", "TEXT");
    localStringBuilder.append(" rid TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "mimeType";
    locala.EYv.put("mimeType", "TEXT");
    localStringBuilder.append(" mimeType TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "md5";
    locala.EYv.put("md5", "TEXT");
    localStringBuilder.append(" md5 TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "downloadUrl";
    locala.EYv.put("downloadUrl", "TEXT");
    localStringBuilder.append(" downloadUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "size";
    locala.EYv.put("size", "INTEGER");
    localStringBuilder.append(" size INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "downloadNetType";
    locala.EYv.put("downloadNetType", "INTEGER");
    localStringBuilder.append(" downloadNetType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[10] = "completeDownload";
    locala.EYv.put("completeDownload", "INTEGER default 'false' ");
    localStringBuilder.append(" completeDownload INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[11] = "createTime";
    locala.EYv.put("createTime", "LONG");
    localStringBuilder.append(" createTime LONG");
    localStringBuilder.append(", ");
    locala.columns[12] = "autoDownloadCount";
    locala.EYv.put("autoDownloadCount", "INTEGER default '0' ");
    localStringBuilder.append(" autoDownloadCount INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[13] = "fileDownloadCount";
    locala.EYv.put("fileDownloadCount", "INTEGER default '0' ");
    localStringBuilder.append(" fileDownloadCount INTEGER default '0' ");
    locala.columns[14] = "rowid";
    locala.sql = localStringBuilder.toString();
    gLr = locala;
    AppMethodBeat.o(110562);
  }
  
  public final c.a getDBInfo()
  {
    return gLr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.b.c
 * JD-Core Version:    0.7.0.1
 */