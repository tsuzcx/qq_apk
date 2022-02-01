package com.tencent.mm.plugin.report.business;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.u;

public final class a
{
  public static void a(long paramLong1, long paramLong2, long paramLong3, String paramString)
  {
    AppMethodBeat.i(221077);
    u localu = new u();
    localu.dUv = paramLong1;
    localu.dUw = paramLong2;
    localu.dUx = paramLong3;
    localu.dUy = localu.t("UserName", paramString, true);
    localu.aLH();
    AppMethodBeat.o(221077);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.report.business.a
 * JD-Core Version:    0.7.0.1
 */