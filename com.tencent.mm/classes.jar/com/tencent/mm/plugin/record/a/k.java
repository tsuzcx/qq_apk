package com.tencent.mm.plugin.record.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fj;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class k
  extends fj
  implements c
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(140938);
    c.a locala = new c.a();
    locala.IhA = new Field[10];
    locala.columns = new String[11];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "localId";
    locala.IhC.put("localId", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" localId INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "localId";
    locala.columns[1] = "msgId";
    locala.IhC.put("msgId", "LONG default '-1' ");
    localStringBuilder.append(" msgId LONG default '-1' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "oriMsgId";
    locala.IhC.put("oriMsgId", "LONG default '-1' ");
    localStringBuilder.append(" oriMsgId LONG default '-1' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "toUser";
    locala.IhC.put("toUser", "TEXT default '' ");
    localStringBuilder.append(" toUser TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[4] = "title";
    locala.IhC.put("title", "TEXT");
    localStringBuilder.append(" title TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "desc";
    locala.IhC.put("desc", "TEXT");
    localStringBuilder.append(" desc TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "dataProto";
    locala.IhC.put("dataProto", "BLOB");
    localStringBuilder.append(" dataProto BLOB");
    localStringBuilder.append(", ");
    locala.columns[7] = "type";
    locala.IhC.put("type", "INTEGER default '0' ");
    localStringBuilder.append(" type INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[8] = "status";
    locala.IhC.put("status", "INTEGER default '0' ");
    localStringBuilder.append(" status INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[9] = "favFrom";
    locala.IhC.put("favFrom", "TEXT");
    localStringBuilder.append(" favFrom TEXT");
    locala.columns[10] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(140938);
  }
  
  public final int dEf()
  {
    return this.field_localId;
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.record.a.k
 * JD-Core Version:    0.7.0.1
 */