package com.tencent.mm.plugin.story.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;

public final class c
{
  public static boolean xxH = false;
  
  public static long AE(long paramLong)
  {
    AppMethodBeat.i(118529);
    long l = ((b)g.ab(b.class)).a(b.a.qvW, 40000L);
    ad.i("MicroMsg.X264Config", "updateByCostTime, costTime:%s, max:%s", new Object[] { Long.valueOf(paramLong), Long.valueOf(l) });
    if (paramLong > l)
    {
      paramLong = ehk();
      AppMethodBeat.o(118529);
      return paramLong;
    }
    l = g.ajC().ajl().a(al.a.IFS, 0L);
    if (l <= 0L) {}
    for (l = 0L;; l -= 1L)
    {
      g.ajC().ajl().set(al.a.IFS, Long.valueOf(l));
      ad.i("MicroMsg.X264Config", "update succ, costTime:%s, cur:%s", new Object[] { Long.valueOf(paramLong), Long.valueOf(l) });
      AppMethodBeat.o(118529);
      return l;
    }
  }
  
  public static long ehk()
  {
    long l1 = 0L;
    AppMethodBeat.i(118530);
    long l2 = g.ajC().ajl().a(al.a.IFS, 0L);
    if (l2 < 0L) {}
    for (;;)
    {
      l1 += 1L;
      g.ajC().ajl().set(al.a.IFS, Long.valueOf(l1));
      ad.i("MicroMsg.X264Config", "updateFailedTimes, cur:%s", new Object[] { Long.valueOf(l1) });
      AppMethodBeat.o(118530);
      return l1;
      l1 = l2;
    }
  }
  
  public static boolean isEnable()
  {
    AppMethodBeat.i(118528);
    if (xxH)
    {
      AppMethodBeat.o(118528);
      return true;
    }
    if (((b)g.ab(b.class)).a(b.a.qvW, 0L) > 0L)
    {
      i = 1;
      if ((i == 0) || (!d.ly(28))) {
        break label97;
      }
      if (g.ajC().ajl().a(al.a.IFS, 0L) < 3L) {
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.c.c
 * JD-Core Version:    0.7.0.1
 */