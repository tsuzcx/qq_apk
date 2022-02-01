package com.tencent.mm.plugin.websearch.widget.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public class b
  extends j<a>
{
  public static final String[] SQL_CREATE;
  private e db;
  
  static
  {
    AppMethodBeat.i(116653);
    SQL_CREATE = new String[] { j.getCreateSQLs(a.info, "WidgetSafeMode") };
    AppMethodBeat.o(116653);
  }
  
  public b(e parame)
  {
    super(parame, a.info, "WidgetSafeMode", null);
    this.db = parame;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.a.b
 * JD-Core Version:    0.7.0.1
 */