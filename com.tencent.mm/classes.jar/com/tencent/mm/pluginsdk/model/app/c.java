package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.h;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class c
  extends h
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(151651);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[20];
    localMAutoDBInfo.columns = new String[21];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "appId";
    localMAutoDBInfo.colsMap.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "sdkVer";
    localMAutoDBInfo.colsMap.put("sdkVer", "LONG");
    localStringBuilder.append(" sdkVer LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "mediaSvrId";
    localMAutoDBInfo.colsMap.put("mediaSvrId", "TEXT");
    localStringBuilder.append(" mediaSvrId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "mediaId";
    localMAutoDBInfo.colsMap.put("mediaId", "TEXT");
    localStringBuilder.append(" mediaId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "clientAppDataId";
    localMAutoDBInfo.colsMap.put("clientAppDataId", "TEXT");
    localStringBuilder.append(" clientAppDataId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "type";
    localMAutoDBInfo.colsMap.put("type", "LONG");
    localStringBuilder.append(" type LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "totalLen";
    localMAutoDBInfo.colsMap.put("totalLen", "LONG");
    localStringBuilder.append(" totalLen LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "offset";
    localMAutoDBInfo.colsMap.put("offset", "LONG");
    localStringBuilder.append(" offset LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "status";
    localMAutoDBInfo.colsMap.put("status", "LONG");
    localStringBuilder.append(" status LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "isUpload";
    localMAutoDBInfo.colsMap.put("isUpload", "INTEGER");
    localStringBuilder.append(" isUpload INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "createTime";
    localMAutoDBInfo.colsMap.put("createTime", "LONG");
    localStringBuilder.append(" createTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "lastModifyTime";
    localMAutoDBInfo.colsMap.put("lastModifyTime", "LONG");
    localStringBuilder.append(" lastModifyTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "fileFullPath";
    localMAutoDBInfo.colsMap.put("fileFullPath", "TEXT");
    localStringBuilder.append(" fileFullPath TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "fullXml";
    localMAutoDBInfo.colsMap.put("fullXml", "TEXT");
    localStringBuilder.append(" fullXml TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "msgInfoId";
    localMAutoDBInfo.colsMap.put("msgInfoId", "LONG");
    localStringBuilder.append(" msgInfoId LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "netTimes";
    localMAutoDBInfo.colsMap.put("netTimes", "LONG");
    localStringBuilder.append(" netTimes LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "isUseCdn";
    localMAutoDBInfo.colsMap.put("isUseCdn", "INTEGER");
    localStringBuilder.append(" isUseCdn INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[17] = "signature";
    localMAutoDBInfo.colsMap.put("signature", "TEXT");
    localStringBuilder.append(" signature TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[18] = "fakeAeskey";
    localMAutoDBInfo.colsMap.put("fakeAeskey", "TEXT");
    localStringBuilder.append(" fakeAeskey TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[19] = "fakeSignature";
    localMAutoDBInfo.colsMap.put("fakeSignature", "TEXT");
    localStringBuilder.append(" fakeSignature TEXT");
    localMAutoDBInfo.columns[20] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(151651);
  }
  
  public c()
  {
    this.field_netTimes = 0L;
  }
  
  public final boolean evg()
  {
    if (this.field_totalLen <= 0L) {}
    while (this.field_offset != this.field_totalLen) {
      return false;
    }
    return true;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.c
 * JD-Core Version:    0.7.0.1
 */