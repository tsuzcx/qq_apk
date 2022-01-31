package com.tencent.mm.plugin.websearch.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class b
  implements c
{
  Map<a, c.a> jFd;
  Map<a, CountDownLatch> uLm;
  private l uLn;
  private l uLo;
  
  public b()
  {
    AppMethodBeat.i(91370);
    this.uLm = new ConcurrentHashMap();
    this.jFd = new HashMap();
    this.uLn = new b.1(this);
    this.uLo = new b.2(this);
    AppMethodBeat.o(91370);
  }
  
  private static boolean a(a parama, l paraml)
  {
    AppMethodBeat.i(91373);
    if (bo.isNullOrNil(parama.query))
    {
      AppMethodBeat.o(91373);
      return false;
    }
    i locali = new i();
    locali.query = parama.query;
    locali.mSP = new int[] { 131072 };
    locali.mSQ = new int[] { 1, 5 };
    locali.mSR = parama.uLl;
    locali.mST = com.tencent.mm.plugin.fts.a.c.b.mTt;
    locali.mSS = new HashSet();
    locali.mSU = paraml;
    locali.scene = 1;
    ((n)g.G(n.class)).search(2, locali).mRQ = parama;
    AppMethodBeat.o(91373);
    return true;
  }
  
  public final void a(a parama, c.a parama1)
  {
    AppMethodBeat.i(91372);
    this.jFd.put(parama, parama1);
    a(parama, this.uLo);
    AppMethodBeat.o(91372);
  }
  
  public final a agB(String paramString)
  {
    AppMethodBeat.i(91371);
    e locale = new e(paramString);
    CountDownLatch localCountDownLatch = (CountDownLatch)this.uLm.get(locale);
    if (localCountDownLatch == null) {
      if (a(locale, this.uLn))
      {
        ab.i("FTSMatchContact", "not have a running task ,start new task, query %s,maxMatch %d", new Object[] { paramString, Integer.valueOf(2147483647) });
        paramString = new CountDownLatch(1);
        this.uLm.put(locale, paramString);
      }
    }
    for (;;)
    {
      if (paramString != null) {}
      try
      {
        paramString.await(2000L, TimeUnit.MILLISECONDS);
        this.uLm.remove(locale);
        AppMethodBeat.o(91371);
        return locale;
        ab.i("FTSMatchContact", "start new task fail, query %s,maxMatch %d", new Object[] { paramString, Integer.valueOf(2147483647) });
        paramString = localCountDownLatch;
        continue;
        ab.i("FTSMatchContact", "have a running task ,wait for result, query %s,maxMatch %d", new Object[] { paramString, Integer.valueOf(2147483647) });
        paramString = localCountDownLatch;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          ab.printErrStackTrace("FTSMatchContact", paramString, "", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.c.a.b
 * JD-Core Version:    0.7.0.1
 */