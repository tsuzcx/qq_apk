package com.tencent.mm.plugin.report.business;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.u;

public final class a
{
  public static void a(long paramLong1, long paramLong2, long paramLong3, String paramString)
  {
    AppMethodBeat.i(197139);
    u localu = new u();
    localu.dTf = paramLong1;
    localu.dTg = paramLong2;
    localu.dTh = paramLong3;
    localu.dTi = localu.t("UserName", paramString, true);
    localu.aLk();
    AppMethodBeat.o(197139);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.report.business.a
 * JD-Core Version:    0.7.0.1
 */