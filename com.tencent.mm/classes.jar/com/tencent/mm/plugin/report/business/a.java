package com.tencent.mm.plugin.report.business;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.am;

public final class a
{
  public static void a(long paramLong1, long paramLong2, long paramLong3, String paramString)
  {
    AppMethodBeat.i(224152);
    am localam = new am();
    localam.eoH = paramLong1;
    localam.eoI = paramLong2;
    localam.eoJ = paramLong3;
    localam.eoK = localam.x("UserName", paramString, true);
    localam.bfK();
    AppMethodBeat.o(224152);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.report.business.a
 * JD-Core Version:    0.7.0.1
 */