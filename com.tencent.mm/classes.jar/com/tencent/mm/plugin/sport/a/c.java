package com.tencent.mm.plugin.sport.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ac;

public final class c
{
  public static final void lA(int paramInt)
  {
    AppMethodBeat.i(116811);
    ac.v("MicroMsg.Sport.SportReportLogic", "report action=%d", new Object[] { Integer.valueOf(paramInt) });
    e.wTc.f(13168, new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(116811);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.a.c
 * JD-Core Version:    0.7.0.1
 */