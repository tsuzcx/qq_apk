package com.tencent.mm.plugin.websearch.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
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
  Map<a, CountDownLatch> IGx;
  private l IGy;
  private l IGz;
  Map<a, c.a> oPn;
  
  public b()
  {
    AppMethodBeat.i(116556);
    this.IGx = new ConcurrentHashMap();
    this.oPn = new HashMap();
    this.IGy = new l()
    {
      public final void b(k paramAnonymousk)
      {
        AppMethodBeat.i(116554);
        a locala = (a)paramAnonymousk.wXa.wVS;
        if (locala == null)
        {
          AppMethodBeat.o(116554);
          return;
        }
        CountDownLatch localCountDownLatch = (CountDownLatch)b.this.IGx.remove(locala);
        switch (paramAnonymousk.resultCode)
        {
        }
        for (;;)
        {
          localCountDownLatch.countDown();
          AppMethodBeat.o(116554);
          return;
          if ((paramAnonymousk.wXb == null) || (paramAnonymousk.wXb.size() == 0))
          {
            Log.i("FTSMatchContact", "local contact search size 0");
            locala.ih(Collections.emptyList());
            localCountDownLatch.countDown();
            AppMethodBeat.o(116554);
            return;
          }
          locala.ih(paramAnonymousk.wXb);
          continue;
          locala.ih(Collections.emptyList());
        }
      }
    };
    this.IGz = new l()
    {
      public final void b(k paramAnonymousk)
      {
        AppMethodBeat.i(116555);
        a locala = (a)paramAnonymousk.wXa.wVS;
        if (locala == null)
        {
          AppMethodBeat.o(116555);
          return;
        }
        c.a locala1 = (c.a)b.this.oPn.remove(locala);
        if (locala1 == null)
        {
          AppMethodBeat.o(116555);
          return;
        }
        switch (paramAnonymousk.resultCode)
        {
        }
        for (;;)
        {
          locala1.fYI();
          AppMethodBeat.o(116555);
          return;
          if ((paramAnonymousk.wXb == null) || (paramAnonymousk.wXb.size() == 0))
          {
            Log.i("FTSMatchContact", "local contact search size 0");
            locala1.fYI();
            AppMethodBeat.o(116555);
            return;
          }
          locala.ih(paramAnonymousk.wXb);
          continue;
          locala.ih(Collections.emptyList());
        }
      }
    };
    AppMethodBeat.o(116556);
  }
  
  private static boolean a(a parama, l paraml)
  {
    AppMethodBeat.i(116559);
    if (Util.isNullOrNil(parama.query))
    {
      AppMethodBeat.o(116559);
      return false;
    }
    j localj = new j();
    localj.query = parama.query;
    localj.wWU = new int[] { 131072 };
    localj.wWV = new int[] { 1, 5 };
    localj.wWW = parama.IGw;
    localj.wWY = com.tencent.mm.plugin.fts.a.c.b.wXy;
    localj.wWX = new HashSet();
    localj.wWZ = paraml;
    localj.scene = 1;
    ((n)g.ah(n.class)).search(2, localj).wVS = parama;
    AppMethodBeat.o(116559);
    return true;
  }
  
  public final void a(a parama, c.a parama1)
  {
    AppMethodBeat.i(116558);
    this.oPn.put(parama, parama1);
    a(parama, this.IGz);
    AppMethodBeat.o(116558);
  }
  
  public final a aXo(String paramString)
  {
    AppMethodBeat.i(116557);
    e locale = new e(paramString);
    CountDownLatch localCountDownLatch = (CountDownLatch)this.IGx.get(locale);
    if (localCountDownLatch == null) {
      if (a(locale, this.IGy))
      {
        Log.i("FTSMatchContact", "not have a running task ,start new task, query %s,maxMatch %d", new Object[] { paramString, Integer.valueOf(2147483647) });
        paramString = new CountDownLatch(1);
        this.IGx.put(locale, paramString);
      }
    }
    for (;;)
    {
      if (paramString != null) {}
      try
      {
        paramString.await(2000L, TimeUnit.MILLISECONDS);
        this.IGx.remove(locale);
        AppMethodBeat.o(116557);
        return locale;
        Log.i("FTSMatchContact", "start new task fail, query %s,maxMatch %d", new Object[] { paramString, Integer.valueOf(2147483647) });
        paramString = localCountDownLatch;
        continue;
        Log.i("FTSMatchContact", "have a running task ,wait for result, query %s,maxMatch %d", new Object[] { paramString, Integer.valueOf(2147483647) });
        paramString = localCountDownLatch;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          Log.printErrStackTrace("FTSMatchContact", paramString, "", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.b.a.b
 * JD-Core Version:    0.7.0.1
 */