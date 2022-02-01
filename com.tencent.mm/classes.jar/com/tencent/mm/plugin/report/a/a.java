package com.tencent.mm.plugin.report.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.r;

public final class a
{
  public static void a(long paramLong1, long paramLong2, long paramLong3, String paramString)
  {
    AppMethodBeat.i(206465);
    r localr = new r();
    localr.dGa = paramLong1;
    localr.dGb = paramLong2;
    localr.dGc = paramLong3;
    localr.dGd = localr.t("UserName", paramString, true);
    localr.aHZ();
    AppMethodBeat.o(206465);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.report.a.a
 * JD-Core Version:    0.7.0.1
 */