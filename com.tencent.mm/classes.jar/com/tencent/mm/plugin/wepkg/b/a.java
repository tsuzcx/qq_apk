package com.tencent.mm.plugin.wepkg.b;

import com.tencent.mm.h.c.ff;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends ff
{
  public static final c.a dUa;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[14];
    locala.columns = new String[15];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "key";
    locala.ujN.put("key", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" key TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "key";
    locala.columns[1] = "pkgId";
    locala.ujN.put("pkgId", "TEXT");
    localStringBuilder.append(" pkgId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "version";
    locala.ujN.put("version", "TEXT");
    localStringBuilder.append(" version TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "filePath";
    locala.ujN.put("filePath", "TEXT");
    localStringBuilder.append(" filePath TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "rid";
    locala.ujN.put("rid", "TEXT");
    localStringBuilder.append(" rid TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "mimeType";
    locala.ujN.put("mimeType", "TEXT");
    localStringBuilder.append(" mimeType TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "md5";
    locala.ujN.put("md5", "TEXT");
    localStringBuilder.append(" md5 TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "downloadUrl";
    locala.ujN.put("downloadUrl", "TEXT");
    localStringBuilder.append(" downloadUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "size";
    locala.ujN.put("size", "INTEGER");
    localStringBuilder.append(" size INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "downloadNetType";
    locala.ujN.put("downloadNetType", "INTEGER");
    localStringBuilder.append(" downloadNetType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[10] = "completeDownload";
    locala.ujN.put("completeDownload", "INTEGER default 'false' ");
    localStringBuilder.append(" completeDownload INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[11] = "createTime";
    locala.ujN.put("createTime", "LONG");
    localStringBuilder.append(" createTime LONG");
    localStringBuilder.append(", ");
    locala.columns[12] = "autoDownloadCount";
    locala.ujN.put("autoDownloadCount", "INTEGER default '0' ");
    localStringBuilder.append(" autoDownloadCount INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[13] = "fileDownloadCount";
    locala.ujN.put("fileDownloadCount", "INTEGER default '0' ");
    localStringBuilder.append(" fileDownloadCount INTEGER default '0' ");
    locala.columns[14] = "rowid";
    locala.sql = localStringBuilder.toString();
    dUa = locala;
  }
  
  protected final c.a rM()
  {
    return dUa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.b.a
 * JD-Core Version:    0.7.0.1
 */