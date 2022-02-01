package com.tencent.mm.plugin.record.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fi;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class j
  extends fi
  implements c
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(140937);
    c.a locala = new c.a();
    locala.IBL = new Field[18];
    locala.columns = new String[19];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "localId";
    locala.IBN.put("localId", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" localId INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "localId";
    locala.columns[1] = "recordLocalId";
    locala.IBN.put("recordLocalId", "INTEGER");
    localStringBuilder.append(" recordLocalId INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "toUser";
    locala.IBN.put("toUser", "TEXT default '' ");
    localStringBuilder.append(" toUser TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "dataId";
    locala.IBN.put("dataId", "TEXT");
    localStringBuilder.append(" dataId TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "mediaId";
    locala.IBN.put("mediaId", "TEXT");
    localStringBuilder.append(" mediaId TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "path";
    locala.IBN.put("path", "TEXT");
    localStringBuilder.append(" path TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "cdnUrl";
    locala.IBN.put("cdnUrl", "TEXT");
    localStringBuilder.append(" cdnUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "cdnKey";
    locala.IBN.put("cdnKey", "TEXT");
    localStringBuilder.append(" cdnKey TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "totalLen";
    locala.IBN.put("totalLen", "INTEGER default '0' ");
    localStringBuilder.append(" totalLen INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[9] = "isThumb";
    locala.IBN.put("isThumb", "INTEGER default 'false' ");
    localStringBuilder.append(" isThumb INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[10] = "offset";
    locala.IBN.put("offset", "INTEGER default '0' ");
    localStringBuilder.append(" offset INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[11] = "type";
    locala.IBN.put("type", "INTEGER default '0' ");
    localStringBuilder.append(" type INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[12] = "fileType";
    locala.IBN.put("fileType", "INTEGER default '5' ");
    localStringBuilder.append(" fileType INTEGER default '5' ");
    localStringBuilder.append(", ");
    locala.columns[13] = "status";
    locala.IBN.put("status", "INTEGER default '0' ");
    localStringBuilder.append(" status INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[14] = "errCode";
    locala.IBN.put("errCode", "INTEGER default '0' ");
    localStringBuilder.append(" errCode INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[15] = "tpaeskey";
    locala.IBN.put("tpaeskey", "TEXT");
    localStringBuilder.append(" tpaeskey TEXT");
    localStringBuilder.append(", ");
    locala.columns[16] = "tpauthkey";
    locala.IBN.put("tpauthkey", "TEXT");
    localStringBuilder.append(" tpauthkey TEXT");
    localStringBuilder.append(", ");
    locala.columns[17] = "tpdataurl";
    locala.IBN.put("tpdataurl", "TEXT");
    localStringBuilder.append(" tpdataurl TEXT");
    locala.columns[18] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(140937);
  }
  
  public final int dHw()
  {
    return this.field_localId;
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(140936);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("localid[").append(this.field_localId).append("]\n");
    ((StringBuilder)localObject).append("recordId[").append(this.field_recordLocalId).append("]\n");
    ((StringBuilder)localObject).append("mediaId[").append(this.field_mediaId).append("]\n");
    ((StringBuilder)localObject).append("dataId[").append(this.field_dataId).append("]\n");
    ((StringBuilder)localObject).append("path[").append(this.field_path).append("]\n");
    ((StringBuilder)localObject).append("cdnurl[").append(this.field_cdnUrl).append("]\n");
    ((StringBuilder)localObject).append("cdnkey[").append(this.field_cdnKey).append("]\n");
    ((StringBuilder)localObject).append("type[").append(this.field_type).append("]\n");
    ((StringBuilder)localObject).append("errCode[").append(this.field_errCode).append("]\n");
    ((StringBuilder)localObject).append("fileType[").append(this.field_fileType).append("]\n");
    ((StringBuilder)localObject).append("isThumb[").append(this.field_isThumb).append("]\n");
    ((StringBuilder)localObject).append("status[").append(this.field_status).append("]\n");
    ((StringBuilder)localObject).append("totalLen[").append(this.field_totalLen).append("]\n");
    ((StringBuilder)localObject).append("offset[").append(this.field_offset).append("]\n");
    ((StringBuilder)localObject).append("toUser[").append(this.field_toUser).append("]\n");
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(140936);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.a.j
 * JD-Core Version:    0.7.0.1
 */