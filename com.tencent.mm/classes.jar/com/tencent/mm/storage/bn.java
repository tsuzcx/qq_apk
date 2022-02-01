package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bu;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class bn
  extends bu
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(43198);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[8];
    localMAutoDBInfo.columns = new String[9];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "msgContent";
    localMAutoDBInfo.colsMap.put("msgContent", "TEXT default '' ");
    localStringBuilder.append(" msgContent TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "isSend";
    localMAutoDBInfo.colsMap.put("isSend", "INTEGER default '0' ");
    localStringBuilder.append(" isSend INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "talker";
    localMAutoDBInfo.colsMap.put("talker", "TEXT default '' ");
    localStringBuilder.append(" talker TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "encryptTalker";
    localMAutoDBInfo.colsMap.put("encryptTalker", "TEXT default '' ");
    localStringBuilder.append(" encryptTalker TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "svrId";
    localMAutoDBInfo.colsMap.put("svrId", "LONG default '0' ");
    localStringBuilder.append(" svrId LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "type";
    localMAutoDBInfo.colsMap.put("type", "INTEGER default '0' ");
    localStringBuilder.append(" type INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "createTime";
    localMAutoDBInfo.colsMap.put("createTime", "LONG default '0' ");
    localStringBuilder.append(" createTime LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "chatroomName";
    localMAutoDBInfo.colsMap.put("chatroomName", "TEXT default '' ");
    localStringBuilder.append(" chatroomName TEXT default '' ");
    localMAutoDBInfo.columns[8] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(43198);
  }
  
  public final boolean gCT()
  {
    return this.field_isSend % 2 == 0;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.bn
 * JD-Core Version:    0.7.0.1
 */