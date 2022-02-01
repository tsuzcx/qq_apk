package com.tencent.mm.plugin.report.business;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.au;

public final class a
{
  public static void a(long paramLong1, long paramLong2, long paramLong3, String paramString)
  {
    AppMethodBeat.i(193845);
    au localau = new au();
    localau.gjU = paramLong1;
    localau.gjV = paramLong2;
    localau.gjW = paramLong3;
    localau.gjX = localau.z("UserName", paramString, true);
    localau.bpa();
    AppMethodBeat.o(193845);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.report.business.a
 * JD-Core Version:    0.7.0.1
 */