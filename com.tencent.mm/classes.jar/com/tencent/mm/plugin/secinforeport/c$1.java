package com.tencent.mm.plugin.secinforeport;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bs;

final class c$1
  implements x.a
{
  c$1(c paramc, int paramInt) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, n paramn)
  {
    AppMethodBeat.i(89166);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ac.i("MicroMsg.SecInfoReporterImpl", "cgireport succ, ctx: %d, stack: %s", new Object[] { Integer.valueOf(this.xnH), bs.eWi().toString() });
      e.wTc.idkeyStat(416L, 1L, 1L, false);
    }
    for (;;)
    {
      AppMethodBeat.o(89166);
      return 0;
      ac.w("MicroMsg.SecInfoReporterImpl", "cgireport failed, ctx: %d, err: %d:%d %s, stack: %s", new Object[] { Integer.valueOf(this.xnH), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, bs.eWi().toString() });
      e.wTc.idkeyStat(416L, 2L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.secinforeport.c.1
 * JD-Core Version:    0.7.0.1
 */