package com.tencent.mm.plugin.report.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.j;

public final class b
  extends j<a>
{
  public static final String[] SQL_CREATE;
  
  static
  {
    AppMethodBeat.i(143780);
    SQL_CREATE = new String[] { j.getCreateSQLs(a.info, "DuplicateKVLog") };
    AppMethodBeat.o(143780);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.a.b
 * JD-Core Version:    0.7.0.1
 */