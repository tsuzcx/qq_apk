package com.tencent.mm.plugin.record.a;

import com.tencent.mm.h.c.do;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class f
  extends do
  implements b
{
  public static c.a buS;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[18];
    locala.columns = new String[19];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "localId";
    locala.ujN.put("localId", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" localId INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "localId";
    locala.columns[1] = "recordLocalId";
    locala.ujN.put("recordLocalId", "INTEGER");
    localStringBuilder.append(" recordLocalId INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "toUser";
    locala.ujN.put("toUser", "TEXT default '' ");
    localStringBuilder.append(" toUser TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "dataId";
    locala.ujN.put("dataId", "TEXT");
    localStringBuilder.append(" dataId TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "mediaId";
    locala.ujN.put("mediaId", "TEXT");
    localStringBuilder.append(" mediaId TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "path";
    locala.ujN.put("path", "TEXT");
    localStringBuilder.append(" path TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "cdnUrl";
    locala.ujN.put("cdnUrl", "TEXT");
    localStringBuilder.append(" cdnUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "cdnKey";
    locala.ujN.put("cdnKey", "TEXT");
    localStringBuilder.append(" cdnKey TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "totalLen";
    locala.ujN.put("totalLen", "INTEGER default '0' ");
    localStringBuilder.append(" totalLen INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[9] = "isThumb";
    locala.ujN.put("isThumb", "INTEGER default 'false' ");
    localStringBuilder.append(" isThumb INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[10] = "offset";
    locala.ujN.put("offset", "INTEGER default '0' ");
    localStringBuilder.append(" offset INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[11] = "type";
    locala.ujN.put("type", "INTEGER default '0' ");
    localStringBuilder.append(" type INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[12] = "fileType";
    locala.ujN.put("fileType", "INTEGER default '5' ");
    localStringBuilder.append(" fileType INTEGER default '5' ");
    localStringBuilder.append(", ");
    locala.columns[13] = "status";
    locala.ujN.put("status", "INTEGER default '0' ");
    localStringBuilder.append(" status INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[14] = "errCode";
    locala.ujN.put("errCode", "INTEGER default '0' ");
    localStringBuilder.append(" errCode INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[15] = "tpaeskey";
    locala.ujN.put("tpaeskey", "TEXT");
    localStringBuilder.append(" tpaeskey TEXT");
    localStringBuilder.append(", ");
    locala.columns[16] = "tpauthkey";
    locala.ujN.put("tpauthkey", "TEXT");
    localStringBuilder.append(" tpauthkey TEXT");
    localStringBuilder.append(", ");
    locala.columns[17] = "tpdataurl";
    locala.ujN.put("tpdataurl", "TEXT");
    localStringBuilder.append(" tpdataurl TEXT");
    locala.columns[18] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
  }
  
  public final int bvs()
  {
    return this.field_localId;
  }
  
  protected final c.a rM()
  {
    return buS;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("localid[").append(this.field_localId).append("]\n");
    localStringBuilder.append("recordId[").append(this.field_recordLocalId).append("]\n");
    localStringBuilder.append("mediaId[").append(this.field_mediaId).append("]\n");
    localStringBuilder.append("dataId[").append(this.field_dataId).append("]\n");
    localStringBuilder.append("path[").append(this.field_path).append("]\n");
    localStringBuilder.append("cdnurl[").append(this.field_cdnUrl).append("]\n");
    localStringBuilder.append("cdnkey[").append(this.field_cdnKey).append("]\n");
    localStringBuilder.append("type[").append(this.field_type).append("]\n");
    localStringBuilder.append("errCode[").append(this.field_errCode).append("]\n");
    localStringBuilder.append("fileType[").append(this.field_fileType).append("]\n");
    localStringBuilder.append("isThumb[").append(this.field_isThumb).append("]\n");
    localStringBuilder.append("status[").append(this.field_status).append("]\n");
    localStringBuilder.append("totalLen[").append(this.field_totalLen).append("]\n");
    localStringBuilder.append("offset[").append(this.field_offset).append("]\n");
    localStringBuilder.append("toUser[").append(this.field_toUser).append("]\n");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.record.a.f
 * JD-Core Version:    0.7.0.1
 */