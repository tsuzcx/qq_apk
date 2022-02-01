package com.tencent.mm.plugin.record.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ez;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class j
  extends ez
  implements c
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(140938);
    c.a locala = new c.a();
    locala.GvF = new Field[10];
    locala.columns = new String[11];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "localId";
    locala.GvH.put("localId", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" localId INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.GvG = "localId";
    locala.columns[1] = "msgId";
    locala.GvH.put("msgId", "LONG default '-1' ");
    localStringBuilder.append(" msgId LONG default '-1' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "oriMsgId";
    locala.GvH.put("oriMsgId", "LONG default '-1' ");
    localStringBuilder.append(" oriMsgId LONG default '-1' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "toUser";
    locala.GvH.put("toUser", "TEXT default '' ");
    localStringBuilder.append(" toUser TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[4] = "title";
    locala.GvH.put("title", "TEXT");
    localStringBuilder.append(" title TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "desc";
    locala.GvH.put("desc", "TEXT");
    localStringBuilder.append(" desc TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "dataProto";
    locala.GvH.put("dataProto", "BLOB");
    localStringBuilder.append(" dataProto BLOB");
    localStringBuilder.append(", ");
    locala.columns[7] = "type";
    locala.GvH.put("type", "INTEGER default '0' ");
    localStringBuilder.append(" type INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[8] = "status";
    locala.GvH.put("status", "INTEGER default '0' ");
    localStringBuilder.append(" status INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[9] = "favFrom";
    locala.GvH.put("favFrom", "TEXT");
    localStringBuilder.append(" favFrom TEXT");
    locala.columns[10] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(140938);
  }
  
  public final int dtI()
  {
    return this.field_localId;
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.record.a.j
 * JD-Core Version:    0.7.0.1
 */