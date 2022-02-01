package com.tencent.mm.plugin.record.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fr;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class k
  extends fr
  implements c
{
  public static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(140938);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[10];
    localMAutoDBInfo.columns = new String[11];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "localId";
    localMAutoDBInfo.colsMap.put("localId", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" localId INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "localId";
    localMAutoDBInfo.columns[1] = "msgId";
    localMAutoDBInfo.colsMap.put("msgId", "LONG default '-1' ");
    localStringBuilder.append(" msgId LONG default '-1' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "oriMsgId";
    localMAutoDBInfo.colsMap.put("oriMsgId", "LONG default '-1' ");
    localStringBuilder.append(" oriMsgId LONG default '-1' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "toUser";
    localMAutoDBInfo.colsMap.put("toUser", "TEXT default '' ");
    localStringBuilder.append(" toUser TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "title";
    localMAutoDBInfo.colsMap.put("title", "TEXT");
    localStringBuilder.append(" title TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "desc";
    localMAutoDBInfo.colsMap.put("desc", "TEXT");
    localStringBuilder.append(" desc TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "dataProto";
    localMAutoDBInfo.colsMap.put("dataProto", "BLOB");
    localStringBuilder.append(" dataProto BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "type";
    localMAutoDBInfo.colsMap.put("type", "INTEGER default '0' ");
    localStringBuilder.append(" type INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "status";
    localMAutoDBInfo.colsMap.put("status", "INTEGER default '0' ");
    localStringBuilder.append(" status INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "favFrom";
    localMAutoDBInfo.colsMap.put("favFrom", "TEXT");
    localStringBuilder.append(" favFrom TEXT");
    localMAutoDBInfo.columns[10] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(140938);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public final int getKey()
  {
    return this.field_localId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.record.a.k
 * JD-Core Version:    0.7.0.1
 */