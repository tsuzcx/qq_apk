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
    locala.IBL = new Field[10];
    locala.columns = new String[11];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "localId";
    locala.IBN.put("localId", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" localId INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "localId";
    locala.columns[1] = "msgId";
    locala.IBN.put("msgId", "LONG default '-1' ");
    localStringBuilder.append(" msgId LONG default '-1' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "oriMsgId";
    locala.IBN.put("oriMsgId", "LONG default '-1' ");
    localStringBuilder.append(" oriMsgId LONG default '-1' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "toUser";
    locala.IBN.put("toUser", "TEXT default '' ");
    localStringBuilder.append(" toUser TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[4] = "title";
    locala.IBN.put("title", "TEXT");
    localStringBuilder.append(" title TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "desc";
    locala.IBN.put("desc", "TEXT");
    localStringBuilder.append(" desc TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "dataProto";
    locala.IBN.put("dataProto", "BLOB");
    localStringBuilder.append(" dataProto BLOB");
    localStringBuilder.append(", ");
    locala.columns[7] = "type";
    locala.IBN.put("type", "INTEGER default '0' ");
    localStringBuilder.append(" type INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[8] = "status";
    locala.IBN.put("status", "INTEGER default '0' ");
    localStringBuilder.append(" status INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[9] = "favFrom";
    locala.IBN.put("favFrom", "TEXT");
    localStringBuilder.append(" favFrom TEXT");
    locala.columns[10] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(140938);
  }
  
  public final int dHw()
  {
    return this.field_localId;
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.record.a.k
 * JD-Core Version:    0.7.0.1
 */