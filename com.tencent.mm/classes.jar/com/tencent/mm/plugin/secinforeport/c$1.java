package com.tencent.mm.plugin.secinforeport;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.y;

final class c$1
  implements w.a
{
  c$1(c paramc, int paramInt) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      y.i("MicroMsg.SecInfoReporterImpl", "cgireport succ, ctx: %d", new Object[] { Integer.valueOf(this.nQl) });
      f.nEG.a(416L, 1L, 1L, false);
    }
    for (;;)
    {
      return 0;
      y.w("MicroMsg.SecInfoReporterImpl", "cgireport failed, ctx: %d, err: %d:%d %s", new Object[] { Integer.valueOf(this.nQl), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      f.nEG.a(416L, 2L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.secinforeport.c.1
 * JD-Core Version:    0.7.0.1
 */