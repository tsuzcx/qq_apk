package com.tencent.mm.plugin.websearch.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fts.a.a.m;
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
  Map<a, CountDownLatch> Wrf;
  private com.tencent.mm.plugin.fts.a.l Wrg;
  private com.tencent.mm.plugin.fts.a.l Wrh;
  Map<a, c.a> vcA;
  
  public b()
  {
    AppMethodBeat.i(116556);
    this.Wrf = new ConcurrentHashMap();
    this.vcA = new HashMap();
    this.Wrg = new com.tencent.mm.plugin.fts.a.l()
    {
      public final void b(m paramAnonymousm)
      {
        AppMethodBeat.i(116554);
        a locala = (a)paramAnonymousm.HtE.Hsv;
        if (locala == null)
        {
          AppMethodBeat.o(116554);
          return;
        }
        CountDownLatch localCountDownLatch = (CountDownLatch)b.this.Wrf.remove(locala);
        switch (paramAnonymousm.resultCode)
        {
        }
        for (;;)
        {
          localCountDownLatch.countDown();
          AppMethodBeat.o(116554);
          return;
          if ((paramAnonymousm.HtF == null) || (paramAnonymousm.HtF.size() == 0))
          {
            Log.i("FTSMatchContact", "local contact search size 0");
            locala.mf(Collections.emptyList());
            localCountDownLatch.countDown();
            AppMethodBeat.o(116554);
            return;
          }
          locala.mf(paramAnonymousm.HtF);
          continue;
          locala.mf(Collections.emptyList());
        }
      }
    };
    this.Wrh = new com.tencent.mm.plugin.fts.a.l()
    {
      public final void b(m paramAnonymousm)
      {
        AppMethodBeat.i(116555);
        a locala = (a)paramAnonymousm.HtE.Hsv;
        if (locala == null)
        {
          AppMethodBeat.o(116555);
          return;
        }
        c.a locala1 = (c.a)b.this.vcA.remove(locala);
        if (locala1 == null)
        {
          AppMethodBeat.o(116555);
          return;
        }
        switch (paramAnonymousm.resultCode)
        {
        }
        for (;;)
        {
          locala1.iqH();
          AppMethodBeat.o(116555);
          return;
          if ((paramAnonymousm.HtF == null) || (paramAnonymousm.HtF.size() == 0))
          {
            Log.i("FTSMatchContact", "local contact search size 0");
            locala1.iqH();
            AppMethodBeat.o(116555);
            return;
          }
          locala.mf(paramAnonymousm.HtF);
          continue;
          locala.mf(Collections.emptyList());
        }
      }
    };
    AppMethodBeat.o(116556);
  }
  
  private static boolean a(a parama, com.tencent.mm.plugin.fts.a.l paraml)
  {
    AppMethodBeat.i(116559);
    if (Util.isNullOrNil(parama.query))
    {
      AppMethodBeat.o(116559);
      return false;
    }
    com.tencent.mm.plugin.fts.a.a.l locall = new com.tencent.mm.plugin.fts.a.a.l();
    locall.query = parama.query;
    locall.Htx = new int[] { 131072 };
    locall.Hty = new int[] { 1, 5 };
    locall.Htz = parama.Wre;
    locall.HtB = com.tencent.mm.plugin.fts.a.c.b.Hue;
    locall.HtA = new HashSet();
    locall.HtC = paraml;
    locall.scene = 1;
    ((n)h.az(n.class)).search(2, locall).Hsv = parama;
    AppMethodBeat.o(116559);
    return true;
  }
  
  public final void a(a parama, c.a parama1)
  {
    AppMethodBeat.i(116558);
    this.vcA.put(parama, parama1);
    a(parama, this.Wrh);
    AppMethodBeat.o(116558);
  }
  
  public final a biG(String paramString)
  {
    AppMethodBeat.i(116557);
    e locale = new e(paramString);
    CountDownLatch localCountDownLatch = (CountDownLatch)this.Wrf.get(locale);
    if (localCountDownLatch == null) {
      if (a(locale, this.Wrg))
      {
        Log.i("FTSMatchContact", "not have a running task ,start new task, query %s,maxMatch %d", new Object[] { paramString, Integer.valueOf(2147483647) });
        paramString = new CountDownLatch(1);
        this.Wrf.put(locale, paramString);
      }
    }
    for (;;)
    {
      if (paramString != null) {}
      try
      {
        paramString.await(2000L, TimeUnit.MILLISECONDS);
        this.Wrf.remove(locale);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.c.a.b
 * JD-Core Version:    0.7.0.1
 */