package com.tencent.mm.plugin.order.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ev;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends ev
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(66700);
    c.a locala = new c.a();
    locala.IBL = new Field[3];
    locala.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "msgId";
    locala.IBN.put("msgId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" msgId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "msgId";
    locala.columns[1] = "msgContentXml";
    locala.IBN.put("msgContentXml", "TEXT");
    localStringBuilder.append(" msgContentXml TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "isRead";
    locala.IBN.put("isRead", "TEXT");
    localStringBuilder.append(" isRead TEXT");
    locala.columns[3] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(66700);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.order.b.a
 * JD-Core Version:    0.7.0.1
 */