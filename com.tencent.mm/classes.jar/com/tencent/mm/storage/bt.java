package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dh;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class bt
  extends dh
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(43199);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[13];
    localMAutoDBInfo.columns = new String[14];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "originSvrId";
    localMAutoDBInfo.colsMap.put("originSvrId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" originSvrId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "originSvrId";
    localMAutoDBInfo.columns[1] = "newMsgId";
    localMAutoDBInfo.colsMap.put("newMsgId", "LONG");
    localStringBuilder.append(" newMsgId LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "fromUserName";
    localMAutoDBInfo.colsMap.put("fromUserName", "TEXT default '' ");
    localStringBuilder.append(" fromUserName TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "toUserName";
    localMAutoDBInfo.colsMap.put("toUserName", "TEXT default '' ");
    localStringBuilder.append(" toUserName TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "createTime";
    localMAutoDBInfo.colsMap.put("createTime", "LONG default '0' ");
    localStringBuilder.append(" createTime LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "content";
    localMAutoDBInfo.colsMap.put("content", "TEXT default '' ");
    localStringBuilder.append(" content TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "msgSource";
    localMAutoDBInfo.colsMap.put("msgSource", "TEXT default '' ");
    localStringBuilder.append(" msgSource TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "msgSeq";
    localMAutoDBInfo.colsMap.put("msgSeq", "INTEGER");
    localStringBuilder.append(" msgSeq INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "flag";
    localMAutoDBInfo.colsMap.put("flag", "INTEGER");
    localStringBuilder.append(" flag INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "reserved1";
    localMAutoDBInfo.colsMap.put("reserved1", "INTEGER");
    localStringBuilder.append(" reserved1 INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "reserved2";
    localMAutoDBInfo.colsMap.put("reserved2", "LONG");
    localStringBuilder.append(" reserved2 LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "reserved3";
    localMAutoDBInfo.colsMap.put("reserved3", "TEXT default '' ");
    localStringBuilder.append(" reserved3 TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "reserved4";
    localMAutoDBInfo.colsMap.put("reserved4", "TEXT default '' ");
    localStringBuilder.append(" reserved4 TEXT default '' ");
    localMAutoDBInfo.columns[13] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(43199);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.bt
 * JD-Core Version:    0.7.0.1
 */