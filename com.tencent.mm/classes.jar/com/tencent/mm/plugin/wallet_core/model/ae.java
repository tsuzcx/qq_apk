package com.tencent.mm.plugin.wallet_core.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.hi;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class ae
  extends hi
{
  public static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(70432);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[11];
    localMAutoDBInfo.columns = new String[12];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "mNativeUrl";
    localMAutoDBInfo.colsMap.put("mNativeUrl", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" mNativeUrl TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "mNativeUrl";
    localMAutoDBInfo.columns[1] = "hbType";
    localMAutoDBInfo.colsMap.put("hbType", "INTEGER");
    localStringBuilder.append(" hbType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "receiveAmount";
    localMAutoDBInfo.colsMap.put("receiveAmount", "LONG");
    localStringBuilder.append(" receiveAmount LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "receiveTime";
    localMAutoDBInfo.colsMap.put("receiveTime", "LONG");
    localStringBuilder.append(" receiveTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "receiveStatus";
    localMAutoDBInfo.colsMap.put("receiveStatus", "INTEGER");
    localStringBuilder.append(" receiveStatus INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "hbStatus";
    localMAutoDBInfo.colsMap.put("hbStatus", "INTEGER");
    localStringBuilder.append(" hbStatus INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "sender";
    localMAutoDBInfo.colsMap.put("sender", "TEXT");
    localStringBuilder.append(" sender TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "exclusiveUsername";
    localMAutoDBInfo.colsMap.put("exclusiveUsername", "TEXT");
    localStringBuilder.append(" exclusiveUsername TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "sendId";
    localMAutoDBInfo.colsMap.put("sendId", "TEXT");
    localStringBuilder.append(" sendId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "invalidtime";
    localMAutoDBInfo.colsMap.put("invalidtime", "INTEGER");
    localStringBuilder.append(" invalidtime INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "msgSvrId";
    localMAutoDBInfo.colsMap.put("msgSvrId", "LONG");
    localStringBuilder.append(" msgSvrId LONG");
    localMAutoDBInfo.columns[11] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(70432);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(70431);
    super.convertFrom(paramCursor);
    AppMethodBeat.o(70431);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.ae
 * JD-Core Version:    0.7.0.1
 */