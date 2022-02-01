package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.db;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class bn
  extends db
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(43199);
    c.a locala = new c.a();
    locala.IhA = new Field[13];
    locala.columns = new String[14];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "originSvrId";
    locala.IhC.put("originSvrId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" originSvrId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "originSvrId";
    locala.columns[1] = "newMsgId";
    locala.IhC.put("newMsgId", "LONG");
    localStringBuilder.append(" newMsgId LONG");
    localStringBuilder.append(", ");
    locala.columns[2] = "fromUserName";
    locala.IhC.put("fromUserName", "TEXT default '' ");
    localStringBuilder.append(" fromUserName TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "toUserName";
    locala.IhC.put("toUserName", "TEXT default '' ");
    localStringBuilder.append(" toUserName TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[4] = "createTime";
    locala.IhC.put("createTime", "LONG default '0' ");
    localStringBuilder.append(" createTime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[5] = "content";
    locala.IhC.put("content", "TEXT default '' ");
    localStringBuilder.append(" content TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[6] = "msgSource";
    locala.IhC.put("msgSource", "TEXT default '' ");
    localStringBuilder.append(" msgSource TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[7] = "msgSeq";
    locala.IhC.put("msgSeq", "INTEGER");
    localStringBuilder.append(" msgSeq INTEGER");
    localStringBuilder.append(", ");
    locala.columns[8] = "flag";
    locala.IhC.put("flag", "INTEGER");
    localStringBuilder.append(" flag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "reserved1";
    locala.IhC.put("reserved1", "INTEGER");
    localStringBuilder.append(" reserved1 INTEGER");
    localStringBuilder.append(", ");
    locala.columns[10] = "reserved2";
    locala.IhC.put("reserved2", "LONG");
    localStringBuilder.append(" reserved2 LONG");
    localStringBuilder.append(", ");
    locala.columns[11] = "reserved3";
    locala.IhC.put("reserved3", "TEXT default '' ");
    localStringBuilder.append(" reserved3 TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[12] = "reserved4";
    locala.IhC.put("reserved4", "TEXT default '' ");
    localStringBuilder.append(" reserved4 TEXT default '' ");
    locala.columns[13] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(43199);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.bn
 * JD-Core Version:    0.7.0.1
 */