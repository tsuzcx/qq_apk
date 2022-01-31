package com.tencent.mm.plugin.websearch.c.a;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class b
  implements c
{
  Map<a, c.a> hLB = new HashMap();
  Map<a, CountDownLatch> qWa = new ConcurrentHashMap();
  private l qWb = new b.1(this);
  private l qWc = new b.2(this);
  
  private static boolean a(a parama, l paraml)
  {
    if (bk.bl(parama.bVk)) {
      return false;
    }
    i locali = new i();
    locali.bVk = parama.bVk;
    locali.kxa = new int[] { 131072 };
    locali.kxb = new int[] { 1, 5 };
    locali.kxc = parama.qVZ;
    locali.kxe = com.tencent.mm.plugin.fts.a.c.b.kxE;
    locali.kxd = new HashSet();
    locali.kxf = paraml;
    locali.scene = 1;
    ((n)g.t(n.class)).search(2, locali).kwb = parama;
    return true;
  }
  
  public final a RA(String paramString)
  {
    e locale = new e(paramString);
    CountDownLatch localCountDownLatch = (CountDownLatch)this.qWa.get(locale);
    if (localCountDownLatch == null) {
      if (a(locale, this.qWb))
      {
        y.i("FTSMatchContact", "not have a running task ,start new task, query %s,maxMatch %d", new Object[] { paramString, Integer.valueOf(2147483647) });
        paramString = new CountDownLatch(1);
        this.qWa.put(locale, paramString);
      }
    }
    for (;;)
    {
      if (paramString != null) {}
      try
      {
        paramString.await(2000L, TimeUnit.MILLISECONDS);
        this.qWa.remove(locale);
        return locale;
        y.i("FTSMatchContact", "start new task fail, query %s,maxMatch %d", new Object[] { paramString, Integer.valueOf(2147483647) });
        paramString = localCountDownLatch;
        continue;
        y.i("FTSMatchContact", "have a running task ,wait for result, query %s,maxMatch %d", new Object[] { paramString, Integer.valueOf(2147483647) });
        paramString = localCountDownLatch;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          y.printErrStackTrace("FTSMatchContact", paramString, "", new Object[0]);
        }
      }
    }
  }
  
  public final void a(a parama, c.a parama1)
  {
    this.hLB.put(parama, parama1);
    a(parama, this.qWc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.c.a.b
 * JD-Core Version:    0.7.0.1
 */