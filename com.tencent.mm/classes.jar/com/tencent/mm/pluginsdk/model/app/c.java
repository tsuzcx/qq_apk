package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.h;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class c
  extends h
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(151651);
    c.a locala = new c.a();
    locala.IBL = new Field[20];
    locala.columns = new String[21];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "appId";
    locala.IBN.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "sdkVer";
    locala.IBN.put("sdkVer", "LONG");
    localStringBuilder.append(" sdkVer LONG");
    localStringBuilder.append(", ");
    locala.columns[2] = "mediaSvrId";
    locala.IBN.put("mediaSvrId", "TEXT");
    localStringBuilder.append(" mediaSvrId TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "mediaId";
    locala.IBN.put("mediaId", "TEXT");
    localStringBuilder.append(" mediaId TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "clientAppDataId";
    locala.IBN.put("clientAppDataId", "TEXT");
    localStringBuilder.append(" clientAppDataId TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "type";
    locala.IBN.put("type", "LONG");
    localStringBuilder.append(" type LONG");
    localStringBuilder.append(", ");
    locala.columns[6] = "totalLen";
    locala.IBN.put("totalLen", "LONG");
    localStringBuilder.append(" totalLen LONG");
    localStringBuilder.append(", ");
    locala.columns[7] = "offset";
    locala.IBN.put("offset", "LONG");
    localStringBuilder.append(" offset LONG");
    localStringBuilder.append(", ");
    locala.columns[8] = "status";
    locala.IBN.put("status", "LONG");
    localStringBuilder.append(" status LONG");
    localStringBuilder.append(", ");
    locala.columns[9] = "isUpload";
    locala.IBN.put("isUpload", "INTEGER");
    localStringBuilder.append(" isUpload INTEGER");
    localStringBuilder.append(", ");
    locala.columns[10] = "createTime";
    locala.IBN.put("createTime", "LONG");
    localStringBuilder.append(" createTime LONG");
    localStringBuilder.append(", ");
    locala.columns[11] = "lastModifyTime";
    locala.IBN.put("lastModifyTime", "LONG");
    localStringBuilder.append(" lastModifyTime LONG");
    localStringBuilder.append(", ");
    locala.columns[12] = "fileFullPath";
    locala.IBN.put("fileFullPath", "TEXT");
    localStringBuilder.append(" fileFullPath TEXT");
    localStringBuilder.append(", ");
    locala.columns[13] = "fullXml";
    locala.IBN.put("fullXml", "TEXT");
    localStringBuilder.append(" fullXml TEXT");
    localStringBuilder.append(", ");
    locala.columns[14] = "msgInfoId";
    locala.IBN.put("msgInfoId", "LONG");
    localStringBuilder.append(" msgInfoId LONG");
    localStringBuilder.append(", ");
    locala.columns[15] = "netTimes";
    locala.IBN.put("netTimes", "LONG");
    localStringBuilder.append(" netTimes LONG");
    localStringBuilder.append(", ");
    locala.columns[16] = "isUseCdn";
    locala.IBN.put("isUseCdn", "INTEGER");
    localStringBuilder.append(" isUseCdn INTEGER");
    localStringBuilder.append(", ");
    locala.columns[17] = "signature";
    locala.IBN.put("signature", "TEXT");
    localStringBuilder.append(" signature TEXT");
    localStringBuilder.append(", ");
    locala.columns[18] = "fakeAeskey";
    locala.IBN.put("fakeAeskey", "TEXT");
    localStringBuilder.append(" fakeAeskey TEXT");
    localStringBuilder.append(", ");
    locala.columns[19] = "fakeSignature";
    locala.IBN.put("fakeSignature", "TEXT");
    localStringBuilder.append(" fakeSignature TEXT");
    locala.columns[20] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(151651);
  }
  
  public c()
  {
    this.field_netTimes = 0L;
  }
  
  public final boolean cZe()
  {
    if (this.field_totalLen <= 0L) {}
    while (this.field_offset != this.field_totalLen) {
      return false;
    }
    return true;
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.c
 * JD-Core Version:    0.7.0.1
 */