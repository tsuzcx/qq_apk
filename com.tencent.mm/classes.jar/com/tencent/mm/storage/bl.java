package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bt;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class bl
  extends bt
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(43197);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[17];
    localMAutoDBInfo.columns = new String[18];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "talker";
    localMAutoDBInfo.colsMap.put("talker", "TEXT default '0'  PRIMARY KEY ");
    localStringBuilder.append(" talker TEXT default '0'  PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "talker";
    localMAutoDBInfo.columns[1] = "encryptTalker";
    localMAutoDBInfo.colsMap.put("encryptTalker", "TEXT default '' ");
    localStringBuilder.append(" encryptTalker TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "displayName";
    localMAutoDBInfo.colsMap.put("displayName", "TEXT default '' ");
    localStringBuilder.append(" displayName TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "state";
    localMAutoDBInfo.colsMap.put("state", "INTEGER default '0' ");
    localStringBuilder.append(" state INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "lastModifiedTime";
    localMAutoDBInfo.colsMap.put("lastModifiedTime", "LONG default '0' ");
    localStringBuilder.append(" lastModifiedTime LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "isNew";
    localMAutoDBInfo.colsMap.put("isNew", "INTEGER default '0' ");
    localStringBuilder.append(" isNew INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "addScene";
    localMAutoDBInfo.colsMap.put("addScene", "INTEGER default '0' ");
    localStringBuilder.append(" addScene INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "fmsgSysRowId";
    localMAutoDBInfo.colsMap.put("fmsgSysRowId", "LONG default '0' ");
    localStringBuilder.append(" fmsgSysRowId LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "fmsgIsSend";
    localMAutoDBInfo.colsMap.put("fmsgIsSend", "INTEGER default '0' ");
    localStringBuilder.append(" fmsgIsSend INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "fmsgType";
    localMAutoDBInfo.colsMap.put("fmsgType", "INTEGER default '0' ");
    localStringBuilder.append(" fmsgType INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "fmsgContent";
    localMAutoDBInfo.colsMap.put("fmsgContent", "TEXT default '' ");
    localStringBuilder.append(" fmsgContent TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "recvFmsgType";
    localMAutoDBInfo.colsMap.put("recvFmsgType", "INTEGER default '0' ");
    localStringBuilder.append(" recvFmsgType INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "contentFromUsername";
    localMAutoDBInfo.colsMap.put("contentFromUsername", "TEXT default '' ");
    localStringBuilder.append(" contentFromUsername TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "contentNickname";
    localMAutoDBInfo.colsMap.put("contentNickname", "TEXT default '' ");
    localStringBuilder.append(" contentNickname TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "contentPhoneNumMD5";
    localMAutoDBInfo.colsMap.put("contentPhoneNumMD5", "TEXT default '' ");
    localStringBuilder.append(" contentPhoneNumMD5 TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "contentFullPhoneNumMD5";
    localMAutoDBInfo.colsMap.put("contentFullPhoneNumMD5", "TEXT default '' ");
    localStringBuilder.append(" contentFullPhoneNumMD5 TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "contentVerifyContent";
    localMAutoDBInfo.colsMap.put("contentVerifyContent", "TEXT default '' ");
    localStringBuilder.append(" contentVerifyContent TEXT default '' ");
    localMAutoDBInfo.columns[17] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(43197);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.bl
 * JD-Core Version:    0.7.0.1
 */