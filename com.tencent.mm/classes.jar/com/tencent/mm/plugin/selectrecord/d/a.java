package com.tencent.mm.plugin.selectrecord.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fq;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends fq
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(194001);
    c.a locala = new c.a();
    locala.IBL = new Field[2];
    locala.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "historyId";
    locala.IBN.put("historyId", "TEXT");
    localStringBuilder.append(" historyId TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "msgId";
    locala.IBN.put("msgId", "LONG");
    localStringBuilder.append(" msgId LONG");
    locala.columns[2] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(194001);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.selectrecord.d.a
 * JD-Core Version:    0.7.0.1
 */