package com.tencent.mm.plugin.sport.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ab;

public final class d
{
  public static final void kS(int paramInt)
  {
    AppMethodBeat.i(55718);
    ab.v("MicroMsg.Sport.SportReportLogic", "report action=%d", new Object[] { Integer.valueOf(paramInt) });
    e.qrI.e(13168, new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(55718);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.a.d
 * JD-Core Version:    0.7.0.1
 */