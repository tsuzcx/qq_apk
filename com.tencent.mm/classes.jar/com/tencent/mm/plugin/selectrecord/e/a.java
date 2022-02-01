package com.tencent.mm.plugin.selectrecord.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.hu;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends hu
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(221245);
    c.a locala = new c.a();
    locala.IhA = new Field[2];
    locala.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "historyId";
    locala.IhC.put("historyId", "TEXT");
    localStringBuilder.append(" historyId TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "msgId";
    locala.IhC.put("msgId", "LONG");
    localStringBuilder.append(" msgId LONG");
    locala.columns[2] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(221245);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.selectrecord.e.a
 * JD-Core Version:    0.7.0.1
 */