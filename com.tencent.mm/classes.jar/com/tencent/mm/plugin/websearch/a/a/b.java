package com.tencent.mm.plugin.websearch.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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
  Map<a, CountDownLatch> Caj;
  private l Cak;
  private l Cal;
  Map<a, c.a> mYy;
  
  public b()
  {
    AppMethodBeat.i(116556);
    this.Caj = new ConcurrentHashMap();
    this.mYy = new HashMap();
    this.Cak = new l()
    {
      public final void b(k paramAnonymousk)
      {
        AppMethodBeat.i(116554);
        a locala = (a)paramAnonymousk.syJ.sxB;
        if (locala == null)
        {
          AppMethodBeat.o(116554);
          return;
        }
        CountDownLatch localCountDownLatch = (CountDownLatch)b.this.Caj.remove(locala);
        switch (paramAnonymousk.bPH)
        {
        }
        for (;;)
        {
          localCountDownLatch.countDown();
          AppMethodBeat.o(116554);
          return;
          if ((paramAnonymousk.syK == null) || (paramAnonymousk.syK.size() == 0))
          {
            ac.i("FTSMatchContact", "local contact search size 0");
            locala.gF(Collections.emptyList());
            localCountDownLatch.countDown();
            AppMethodBeat.o(116554);
            return;
          }
          locala.gF(paramAnonymousk.syK);
          continue;
          locala.gF(Collections.emptyList());
        }
      }
    };
    this.Cal = new l()
    {
      public final void b(k paramAnonymousk)
      {
        AppMethodBeat.i(116555);
        a locala = (a)paramAnonymousk.syJ.sxB;
        if (locala == null)
        {
          AppMethodBeat.o(116555);
          return;
        }
        c.a locala1 = (c.a)b.this.mYy.remove(locala);
        if (locala1 == null)
        {
          AppMethodBeat.o(116555);
          return;
        }
        switch (paramAnonymousk.bPH)
        {
        }
        for (;;)
        {
          locala1.exM();
          AppMethodBeat.o(116555);
          return;
          if ((paramAnonymousk.syK == null) || (paramAnonymousk.syK.size() == 0))
          {
            ac.i("FTSMatchContact", "local contact search size 0");
            locala1.exM();
            AppMethodBeat.o(116555);
            return;
          }
          locala.gF(paramAnonymousk.syK);
          continue;
          locala.gF(Collections.emptyList());
        }
      }
    };
    AppMethodBeat.o(116556);
  }
  
  private static boolean a(a parama, l paraml)
  {
    AppMethodBeat.i(116559);
    if (bs.isNullOrNil(parama.query))
    {
      AppMethodBeat.o(116559);
      return false;
    }
    j localj = new j();
    localj.query = parama.query;
    localj.syD = new int[] { 131072 };
    localj.syE = new int[] { 1, 5 };
    localj.syF = parama.Cai;
    localj.syH = com.tencent.mm.plugin.fts.a.c.b.szh;
    localj.syG = new HashSet();
    localj.syI = paraml;
    localj.scene = 1;
    ((n)g.ad(n.class)).search(2, localj).sxB = parama;
    AppMethodBeat.o(116559);
    return true;
  }
  
  public final void a(a parama, c.a parama1)
  {
    AppMethodBeat.i(116558);
    this.mYy.put(parama, parama1);
    a(parama, this.Cal);
    AppMethodBeat.o(116558);
  }
  
  public final a aAD(String paramString)
  {
    AppMethodBeat.i(116557);
    e locale = new e(paramString);
    CountDownLatch localCountDownLatch = (CountDownLatch)this.Caj.get(locale);
    if (localCountDownLatch == null) {
      if (a(locale, this.Cak))
      {
        ac.i("FTSMatchContact", "not have a running task ,start new task, query %s,maxMatch %d", new Object[] { paramString, Integer.valueOf(2147483647) });
        paramString = new CountDownLatch(1);
        this.Caj.put(locale, paramString);
      }
    }
    for (;;)
    {
      if (paramString != null) {}
      try
      {
        paramString.await(2000L, TimeUnit.MILLISECONDS);
        this.Caj.remove(locale);
        AppMethodBeat.o(116557);
        return locale;
        ac.i("FTSMatchContact", "start new task fail, query %s,maxMatch %d", new Object[] { paramString, Integer.valueOf(2147483647) });
        paramString = localCountDownLatch;
        continue;
        ac.i("FTSMatchContact", "have a running task ,wait for result, query %s,maxMatch %d", new Object[] { paramString, Integer.valueOf(2147483647) });
        paramString = localCountDownLatch;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          ac.printErrStackTrace("FTSMatchContact", paramString, "", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.a.a.b
 * JD-Core Version:    0.7.0.1
 */