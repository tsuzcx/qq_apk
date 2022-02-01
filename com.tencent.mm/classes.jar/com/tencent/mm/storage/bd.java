package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bs;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class bd
  extends bs
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(43198);
    c.a locala = new c.a();
    locala.GvF = new Field[8];
    locala.columns = new String[9];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "msgContent";
    locala.GvH.put("msgContent", "TEXT default '' ");
    localStringBuilder.append(" msgContent TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[1] = "isSend";
    locala.GvH.put("isSend", "INTEGER default '0' ");
    localStringBuilder.append(" isSend INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "talker";
    locala.GvH.put("talker", "TEXT default '' ");
    localStringBuilder.append(" talker TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "encryptTalker";
    locala.GvH.put("encryptTalker", "TEXT default '' ");
    localStringBuilder.append(" encryptTalker TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[4] = "svrId";
    locala.GvH.put("svrId", "LONG default '0' ");
    localStringBuilder.append(" svrId LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[5] = "type";
    locala.GvH.put("type", "INTEGER default '0' ");
    localStringBuilder.append(" type INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[6] = "createTime";
    locala.GvH.put("createTime", "LONG default '0' ");
    localStringBuilder.append(" createTime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[7] = "chatroomName";
    locala.GvH.put("chatroomName", "TEXT default '' ");
    localStringBuilder.append(" chatroomName TEXT default '' ");
    locala.columns[8] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(43198);
  }
  
  public final boolean fbj()
  {
    return this.field_isSend % 2 == 0;
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.bd
 * JD-Core Version:    0.7.0.1
 */