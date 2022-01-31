package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bl;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class ax
  extends bl
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(60137);
    c.a locala = new c.a();
    locala.yrK = new Field[8];
    locala.columns = new String[9];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "msgContent";
    locala.yrM.put("msgContent", "TEXT default '' ");
    localStringBuilder.append(" msgContent TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[1] = "isSend";
    locala.yrM.put("isSend", "INTEGER default '0' ");
    localStringBuilder.append(" isSend INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "talker";
    locala.yrM.put("talker", "TEXT default '' ");
    localStringBuilder.append(" talker TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "encryptTalker";
    locala.yrM.put("encryptTalker", "TEXT default '' ");
    localStringBuilder.append(" encryptTalker TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[4] = "svrId";
    locala.yrM.put("svrId", "LONG default '0' ");
    localStringBuilder.append(" svrId LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[5] = "type";
    locala.yrM.put("type", "INTEGER default '0' ");
    localStringBuilder.append(" type INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[6] = "createTime";
    locala.yrM.put("createTime", "LONG default '0' ");
    localStringBuilder.append(" createTime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[7] = "chatroomName";
    locala.yrM.put("chatroomName", "TEXT default '' ");
    localStringBuilder.append(" chatroomName TEXT default '' ");
    locala.columns[8] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(60137);
  }
  
  public final boolean dxA()
  {
    return this.field_isSend % 2 == 0;
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.ax
 * JD-Core Version:    0.7.0.1
 */