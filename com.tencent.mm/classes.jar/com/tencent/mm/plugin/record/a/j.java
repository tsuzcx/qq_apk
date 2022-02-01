package com.tencent.mm.plugin.record.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.fx;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class j
  extends fx
  implements c
{
  public static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(140937);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[18];
    localMAutoDBInfo.columns = new String[19];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "localId";
    localMAutoDBInfo.colsMap.put("localId", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" localId INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "localId";
    localMAutoDBInfo.columns[1] = "recordLocalId";
    localMAutoDBInfo.colsMap.put("recordLocalId", "INTEGER");
    localStringBuilder.append(" recordLocalId INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "toUser";
    localMAutoDBInfo.colsMap.put("toUser", "TEXT default '' ");
    localStringBuilder.append(" toUser TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "dataId";
    localMAutoDBInfo.colsMap.put("dataId", "TEXT");
    localStringBuilder.append(" dataId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "mediaId";
    localMAutoDBInfo.colsMap.put("mediaId", "TEXT");
    localStringBuilder.append(" mediaId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "path";
    localMAutoDBInfo.colsMap.put("path", "TEXT");
    localStringBuilder.append(" path TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "cdnUrl";
    localMAutoDBInfo.colsMap.put("cdnUrl", "TEXT");
    localStringBuilder.append(" cdnUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "cdnKey";
    localMAutoDBInfo.colsMap.put("cdnKey", "TEXT");
    localStringBuilder.append(" cdnKey TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "totalLen";
    localMAutoDBInfo.colsMap.put("totalLen", "INTEGER default '0' ");
    localStringBuilder.append(" totalLen INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "isThumb";
    localMAutoDBInfo.colsMap.put("isThumb", "INTEGER default 'false' ");
    localStringBuilder.append(" isThumb INTEGER default 'false' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "offset";
    localMAutoDBInfo.colsMap.put("offset", "INTEGER default '0' ");
    localStringBuilder.append(" offset INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "type";
    localMAutoDBInfo.colsMap.put("type", "INTEGER default '0' ");
    localStringBuilder.append(" type INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "fileType";
    localMAutoDBInfo.colsMap.put("fileType", "INTEGER default '5' ");
    localStringBuilder.append(" fileType INTEGER default '5' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "status";
    localMAutoDBInfo.colsMap.put("status", "INTEGER default '0' ");
    localStringBuilder.append(" status INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "errCode";
    localMAutoDBInfo.colsMap.put("errCode", "INTEGER default '0' ");
    localStringBuilder.append(" errCode INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "tpaeskey";
    localMAutoDBInfo.colsMap.put("tpaeskey", "TEXT");
    localStringBuilder.append(" tpaeskey TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "tpauthkey";
    localMAutoDBInfo.colsMap.put("tpauthkey", "TEXT");
    localStringBuilder.append(" tpauthkey TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[17] = "tpdataurl";
    localMAutoDBInfo.colsMap.put("tpdataurl", "TEXT");
    localStringBuilder.append(" tpdataurl TEXT");
    localMAutoDBInfo.columns[18] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(140937);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof j)) {}
    while (this.field_localId != ((j)paramObject).field_localId) {
      return false;
    }
    return true;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public final int getKey()
  {
    return this.field_localId;
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