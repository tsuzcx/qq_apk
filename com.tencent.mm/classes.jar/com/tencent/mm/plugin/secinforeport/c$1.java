package com.tencent.mm.plugin.secinforeport;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.z.a;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;

final class c$1
  implements z.a
{
  c$1(c paramc, int paramInt) {}
  
  public final int callback(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.c paramc, p paramp)
  {
    AppMethodBeat.i(89166);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      Log.i("MicroMsg.SecInfoReporterImpl", "cgireport succ, ctx: %d, stack: %s", new Object[] { Integer.valueOf(this.PlR), Util.getStack().toString() });
      f.Ozc.idkeyStat(416L, 1L, 1L, false);
    }
    for (;;)
    {
      AppMethodBeat.o(89166);
      return 0;
      Log.w("MicroMsg.SecInfoReporterImpl", "cgireport failed, ctx: %d, err: %d:%d %s, stack: %s", new Object[] { Integer.valueOf(this.PlR), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Util.getStack().toString() });
      f.Ozc.idkeyStat(416L, 2L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.secinforeport.c.1
 * JD-Core Version:    0.7.0.1
 */