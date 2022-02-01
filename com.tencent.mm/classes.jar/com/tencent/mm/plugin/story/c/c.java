package com.tencent.mm.plugin.story.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;

public final class c
{
  public static boolean vhf = false;
  
  public static long dGu()
  {
    long l1 = 0L;
    AppMethodBeat.i(118530);
    long l2 = g.afB().afk().a(ae.a.Fvt, 0L);
    if (l2 < 0L) {}
    for (;;)
    {
      l1 += 1L;
      g.afB().afk().set(ae.a.Fvt, Long.valueOf(l1));
      ad.i("MicroMsg.X264Config", "updateFailedTimes, cur:%s", new Object[] { Long.valueOf(l1) });
      AppMethodBeat.o(118530);
      return l1;
      l1 = l2;
    }
  }
  
  public static boolean isEnable()
  {
    AppMethodBeat.i(118528);
    if (vhf)
    {
      AppMethodBeat.o(118528);
      return true;
    }
    if (((b)g.ab(b.class)).a(b.a.pnZ, 0L) > 0L)
    {
      i = 1;
      if ((i == 0) || (!d.lf(28))) {
        break label97;
      }
      if (g.afB().afk().a(ae.a.Fvt, 0L) < 3L) {
        break label92;
      }
    }
    label92:
    for (int i = 0;; i = 1)
    {
      if (i == 0) {
        break label97;
      }
      AppMethodBeat.o(118528);
      return true;
      i = 0;
      break;
    }
    label97:
    AppMethodBeat.o(118528);
    return false;
  }
  
  public static long tD(long paramLong)
  {
    AppMethodBeat.i(118529);
    long l = ((b)g.ab(b.class)).a(b.a.pnZ, 40000L);
    ad.i("MicroMsg.X264Config", "updateByCostTime, costTime:%s, max:%s", new Object[] { Long.valueOf(paramLong), Long.valueOf(l) });
    if (paramLong > l)
    {
      paramLong = dGu();
      AppMethodBeat.o(118529);
      return paramLong;
    }
    l = g.afB().afk().a(ae.a.Fvt, 0L);
    if (l <= 0L) {}
    for (l = 0L;; l -= 1L)
    {
      g.afB().afk().set(ae.a.Fvt, Long.valueOf(l));
      ad.i("MicroMsg.X264Config", "update succ, costTime:%s, cur:%s", new Object[] { Long.valueOf(paramLong), Long.valueOf(l) });
      AppMethodBeat.o(118529);
      return l;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.c.c
 * JD-Core Version:    0.7.0.1
 */