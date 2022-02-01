package com.tencent.mm.plugin.websearch.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
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
  Map<a, CountDownLatch> DVc;
  private l DVd;
  private l DVe;
  Map<a, c.a> nEq;
  
  public b()
  {
    AppMethodBeat.i(116556);
    this.DVc = new ConcurrentHashMap();
    this.nEq = new HashMap();
    this.DVd = new l()
    {
      public final void b(k paramAnonymousk)
      {
        AppMethodBeat.i(116554);
        a locala = (a)paramAnonymousk.tGb.tET;
        if (locala == null)
        {
          AppMethodBeat.o(116554);
          return;
        }
        CountDownLatch localCountDownLatch = (CountDownLatch)b.this.DVc.remove(locala);
        switch (paramAnonymousk.bZU)
        {
        }
        for (;;)
        {
          localCountDownLatch.countDown();
          AppMethodBeat.o(116554);
          return;
          if ((paramAnonymousk.tGc == null) || (paramAnonymousk.tGc.size() == 0))
          {
            ae.i("FTSMatchContact", "local contact search size 0");
            locala.hb(Collections.emptyList());
            localCountDownLatch.countDown();
            AppMethodBeat.o(116554);
            return;
          }
          locala.hb(paramAnonymousk.tGc);
          continue;
          locala.hb(Collections.emptyList());
        }
      }
    };
    this.DVe = new l()
    {
      public final void b(k paramAnonymousk)
      {
        AppMethodBeat.i(116555);
        a locala = (a)paramAnonymousk.tGb.tET;
        if (locala == null)
        {
          AppMethodBeat.o(116555);
          return;
        }
        c.a locala1 = (c.a)b.this.nEq.remove(locala);
        if (locala1 == null)
        {
          AppMethodBeat.o(116555);
          return;
        }
        switch (paramAnonymousk.bZU)
        {
        }
        for (;;)
        {
          locala1.eQo();
          AppMethodBeat.o(116555);
          return;
          if ((paramAnonymousk.tGc == null) || (paramAnonymousk.tGc.size() == 0))
          {
            ae.i("FTSMatchContact", "local contact search size 0");
            locala1.eQo();
            AppMethodBeat.o(116555);
            return;
          }
          locala.hb(paramAnonymousk.tGc);
          continue;
          locala.hb(Collections.emptyList());
        }
      }
    };
    AppMethodBeat.o(116556);
  }
  
  private static boolean a(a parama, l paraml)
  {
    AppMethodBeat.i(116559);
    if (bu.isNullOrNil(parama.query))
    {
      AppMethodBeat.o(116559);
      return false;
    }
    j localj = new j();
    localj.query = parama.query;
    localj.tFV = new int[] { 131072 };
    localj.tFW = new int[] { 1, 5 };
    localj.tFX = parama.DVb;
    localj.tFZ = com.tencent.mm.plugin.fts.a.c.b.tGz;
    localj.tFY = new HashSet();
    localj.tGa = paraml;
    localj.scene = 1;
    ((n)g.ad(n.class)).search(2, localj).tET = parama;
    AppMethodBeat.o(116559);
    return true;
  }
  
  public final void a(a parama, c.a parama1)
  {
    AppMethodBeat.i(116558);
    this.nEq.put(parama, parama1);
    a(parama, this.DVe);
    AppMethodBeat.o(116558);
  }
  
  public final a aHr(String paramString)
  {
    AppMethodBeat.i(116557);
    e locale = new e(paramString);
    CountDownLatch localCountDownLatch = (CountDownLatch)this.DVc.get(locale);
    if (localCountDownLatch == null) {
      if (a(locale, this.DVd))
      {
        ae.i("FTSMatchContact", "not have a running task ,start new task, query %s,maxMatch %d", new Object[] { paramString, Integer.valueOf(2147483647) });
        paramString = new CountDownLatch(1);
        this.DVc.put(locale, paramString);
      }
    }
    for (;;)
    {
      if (paramString != null) {}
      try
      {
        paramString.await(2000L, TimeUnit.MILLISECONDS);
        this.DVc.remove(locale);
        AppMethodBeat.o(116557);
        return locale;
        ae.i("FTSMatchContact", "start new task fail, query %s,maxMatch %d", new Object[] { paramString, Integer.valueOf(2147483647) });
        paramString = localCountDownLatch;
        continue;
        ae.i("FTSMatchContact", "have a running task ,wait for result, query %s,maxMatch %d", new Object[] { paramString, Integer.valueOf(2147483647) });
        paramString = localCountDownLatch;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          ae.printErrStackTrace("FTSMatchContact", paramString, "", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.a.a.b
 * JD-Core Version:    0.7.0.1
 */