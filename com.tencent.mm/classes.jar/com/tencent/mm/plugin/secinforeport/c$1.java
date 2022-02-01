package com.tencent.mm.plugin.secinforeport;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x.a;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;

final class c$1
  implements x.a
{
  c$1(c paramc, int paramInt) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, n paramn)
  {
    AppMethodBeat.i(89166);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ad.i("MicroMsg.SecInfoReporterImpl", "cgireport succ, ctx: %d, stack: %s", new Object[] { Integer.valueOf(this.wcw), bt.eGN().toString() });
      e.vIY.idkeyStat(416L, 1L, 1L, false);
    }
    for (;;)
    {
      AppMethodBeat.o(89166);
      return 0;
      ad.w("MicroMsg.SecInfoReporterImpl", "cgireport failed, ctx: %d, err: %d:%d %s, stack: %s", new Object[] { Integer.valueOf(this.wcw), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, bt.eGN().toString() });
      e.vIY.idkeyStat(416L, 2L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.secinforeport.c.1
 * JD-Core Version:    0.7.0.1
 */