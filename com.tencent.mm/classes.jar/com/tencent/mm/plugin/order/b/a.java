package com.tencent.mm.plugin.order.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dn;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends dn
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(43792);
    c.a locala = new c.a();
    locala.yrK = new Field[3];
    locala.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "msgId";
    locala.yrM.put("msgId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" msgId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.yrL = "msgId";
    locala.columns[1] = "msgContentXml";
    locala.yrM.put("msgContentXml", "TEXT");
    localStringBuilder.append(" msgContentXml TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "isRead";
    locala.yrM.put("isRead", "TEXT");
    localStringBuilder.append(" isRead TEXT");
    locala.columns[3] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(43792);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.order.b.a
 * JD-Core Version:    0.7.0.1
 */