package com.tencent.mm.plugin.report.business;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.bj;

public final class a
{
  public static void a(long paramLong1, long paramLong2, long paramLong3, String paramString)
  {
    AppMethodBeat.i(261682);
    bj localbj = new bj();
    localbj.irg = paramLong1;
    localbj.irh = paramLong2;
    localbj.iri = paramLong3;
    localbj.irj = localbj.F("UserName", paramString, true);
    localbj.bMH();
    AppMethodBeat.o(261682);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.report.business.a
 * JD-Core Version:    0.7.0.1
 */