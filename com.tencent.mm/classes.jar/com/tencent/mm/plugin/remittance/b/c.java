package com.tencent.mm.plugin.remittance.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fs;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class c
  extends fs
{
  public static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(67619);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[6];
    localMAutoDBInfo.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "transferId";
    localMAutoDBInfo.colsMap.put("transferId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" transferId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "transferId";
    localMAutoDBInfo.columns[1] = "locaMsgId";
    localMAutoDBInfo.colsMap.put("locaMsgId", "LONG");
    localStringBuilder.append(" locaMsgId LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "receiveStatus";
    localMAutoDBInfo.colsMap.put("receiveStatus", "INTEGER default '-1' ");
    localStringBuilder.append(" receiveStatus INTEGER default '-1' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "isSend";
    localMAutoDBInfo.colsMap.put("isSend", "INTEGER");
    localStringBuilder.append(" isSend INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "talker";
    localMAutoDBInfo.colsMap.put("talker", "TEXT");
    localStringBuilder.append(" talker TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "invalidtime";
    localMAutoDBInfo.colsMap.put("invalidtime", "LONG");
    localStringBuilder.append(" invalidtime LONG");
    localMAutoDBInfo.columns[6] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(67619);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.b.c
 * JD-Core Version:    0.7.0.1
 */