package com.tencent.mm.plugin.websearch.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class b
  implements c
{
  Map<a, CountDownLatch> AHS;
  private l AHT;
  private l AHU;
  Map<a, c.a> mwx;
  
  public b()
  {
    AppMethodBeat.i(116556);
    this.AHS = new ConcurrentHashMap();
    this.mwx = new HashMap();
    this.AHT = new l()
    {
      public final void b(k paramAnonymousk)
      {
        AppMethodBeat.i(116554);
        a locala = (a)paramAnonymousk.rpP.roI;
        if (locala == null)
        {
          AppMethodBeat.o(116554);
          return;
        }
        CountDownLatch localCountDownLatch = (CountDownLatch)b.this.AHS.remove(locala);
        switch (paramAnonymousk.bRZ)
        {
        }
        for (;;)
        {
          localCountDownLatch.countDown();
          AppMethodBeat.o(116554);
          return;
          if ((paramAnonymousk.rpQ == null) || (paramAnonymousk.rpQ.size() == 0))
          {
            ad.i("FTSMatchContact", "local contact search size 0");
            locala.gu(Collections.emptyList());
            localCountDownLatch.countDown();
            AppMethodBeat.o(116554);
            return;
          }
          locala.gu(paramAnonymousk.rpQ);
          continue;
          locala.gu(Collections.emptyList());
        }
      }
    };
    this.AHU = new l()
    {
      public final void b(k paramAnonymousk)
      {
        AppMethodBeat.i(116555);
        a locala = (a)paramAnonymousk.rpP.roI;
        if (locala == null)
        {
          AppMethodBeat.o(116555);
          return;
        }
        c.a locala1 = (c.a)b.this.mwx.remove(locala);
        if (locala1 == null)
        {
          AppMethodBeat.o(116555);
          return;
        }
        switch (paramAnonymousk.bRZ)
        {
        }
        for (;;)
        {
          locala1.eis();
          AppMethodBeat.o(116555);
          return;
          if ((paramAnonymousk.rpQ == null) || (paramAnonymousk.rpQ.size() == 0))
          {
            ad.i("FTSMatchContact", "local contact search size 0");
            locala1.eis();
            AppMethodBeat.o(116555);
            return;
          }
          locala.gu(paramAnonymousk.rpQ);
          continue;
          locala.gu(Collections.emptyList());
        }
      }
    };
    AppMethodBeat.o(116556);
  }
  
  private static boolean a(a parama, l paraml)
  {
    AppMethodBeat.i(116559);
    if (bt.isNullOrNil(parama.query))
    {
      AppMethodBeat.o(116559);
      return false;
    }
    j localj = new j();
    localj.query = parama.query;
    localj.rpJ = new int[] { 131072 };
    localj.rpK = new int[] { 1, 5 };
    localj.rpL = parama.AHR;
    localj.rpN = com.tencent.mm.plugin.fts.a.c.b.rqn;
    localj.rpM = new HashSet();
    localj.rpO = paraml;
    localj.scene = 1;
    ((n)g.ad(n.class)).search(2, localj).roI = parama;
    AppMethodBeat.o(116559);
    return true;
  }
  
  public final void a(a parama, c.a parama1)
  {
    AppMethodBeat.i(116558);
    this.mwx.put(parama, parama1);
    a(parama, this.AHU);
    AppMethodBeat.o(116558);
  }
  
  public final a avl(String paramString)
  {
    AppMethodBeat.i(116557);
    e locale = new e(paramString);
    CountDownLatch localCountDownLatch = (CountDownLatch)this.AHS.get(locale);
    if (localCountDownLatch == null) {
      if (a(locale, this.AHT))
      {
        ad.i("FTSMatchContact", "not have a running task ,start new task, query %s,maxMatch %d", new Object[] { paramString, Integer.valueOf(2147483647) });
        paramString = new CountDownLatch(1);
        this.AHS.put(locale, paramString);
      }
    }
    for (;;)
    {
      if (paramString != null) {}
      try
      {
        paramString.await(2000L, TimeUnit.MILLISECONDS);
        this.AHS.remove(locale);
        AppMethodBeat.o(116557);
        return locale;
        ad.i("FTSMatchContact", "start new task fail, query %s,maxMatch %d", new Object[] { paramString, Integer.valueOf(2147483647) });
        paramString = localCountDownLatch;
        continue;
        ad.i("FTSMatchContact", "have a running task ,wait for result, query %s,maxMatch %d", new Object[] { paramString, Integer.valueOf(2147483647) });
        paramString = localCountDownLatch;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          ad.printErrStackTrace("FTSMatchContact", paramString, "", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.a.a.b
 * JD-Core Version:    0.7.0.1
 */