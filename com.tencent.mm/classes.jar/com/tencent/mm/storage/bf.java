package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bs;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class bf
  extends bs
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(43197);
    c.a locala = new c.a();
    locala.IhA = new Field[17];
    locala.columns = new String[18];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "talker";
    locala.IhC.put("talker", "TEXT default '0'  PRIMARY KEY ");
    localStringBuilder.append(" talker TEXT default '0'  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "talker";
    locala.columns[1] = "encryptTalker";
    locala.IhC.put("encryptTalker", "TEXT default '' ");
    localStringBuilder.append(" encryptTalker TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "displayName";
    locala.IhC.put("displayName", "TEXT default '' ");
    localStringBuilder.append(" displayName TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "state";
    locala.IhC.put("state", "INTEGER default '0' ");
    localStringBuilder.append(" state INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[4] = "lastModifiedTime";
    locala.IhC.put("lastModifiedTime", "LONG default '0' ");
    localStringBuilder.append(" lastModifiedTime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[5] = "isNew";
    locala.IhC.put("isNew", "INTEGER default '0' ");
    localStringBuilder.append(" isNew INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[6] = "addScene";
    locala.IhC.put("addScene", "INTEGER default '0' ");
    localStringBuilder.append(" addScene INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[7] = "fmsgSysRowId";
    locala.IhC.put("fmsgSysRowId", "LONG default '0' ");
    localStringBuilder.append(" fmsgSysRowId LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[8] = "fmsgIsSend";
    locala.IhC.put("fmsgIsSend", "INTEGER default '0' ");
    localStringBuilder.append(" fmsgIsSend INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[9] = "fmsgType";
    locala.IhC.put("fmsgType", "INTEGER default '0' ");
    localStringBuilder.append(" fmsgType INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[10] = "fmsgContent";
    locala.IhC.put("fmsgContent", "TEXT default '' ");
    localStringBuilder.append(" fmsgContent TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[11] = "recvFmsgType";
    locala.IhC.put("recvFmsgType", "INTEGER default '0' ");
    localStringBuilder.append(" recvFmsgType INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[12] = "contentFromUsername";
    locala.IhC.put("contentFromUsername", "TEXT default '' ");
    localStringBuilder.append(" contentFromUsername TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[13] = "contentNickname";
    locala.IhC.put("contentNickname", "TEXT default '' ");
    localStringBuilder.append(" contentNickname TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[14] = "contentPhoneNumMD5";
    locala.IhC.put("contentPhoneNumMD5", "TEXT default '' ");
    localStringBuilder.append(" contentPhoneNumMD5 TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[15] = "contentFullPhoneNumMD5";
    locala.IhC.put("contentFullPhoneNumMD5", "TEXT default '' ");
    localStringBuilder.append(" contentFullPhoneNumMD5 TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[16] = "contentVerifyContent";
    locala.IhC.put("contentVerifyContent", "TEXT default '' ");
    localStringBuilder.append(" contentVerifyContent TEXT default '' ");
    locala.columns[17] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(43197);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.bf
 * JD-Core Version:    0.7.0.1
 */