package com.tencent.mm.plugin.sport.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
{
  public static final void g(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(263897);
    f.Ozc.b(13168, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    AppMethodBeat.o(263897);
  }
  
  public static final void rG(int paramInt)
  {
    AppMethodBeat.i(116811);
    Log.v("MicroMsg.Sport.SportReportLogic", "report action=%d", new Object[] { Integer.valueOf(paramInt) });
    f.Ozc.b(13168, new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(116811);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.a.d
 * JD-Core Version:    0.7.0.1
 */