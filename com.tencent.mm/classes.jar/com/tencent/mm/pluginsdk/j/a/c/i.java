package com.tencent.mm.pluginsdk.j.a.c;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.List;

public final class i
  implements c
{
  private final MMHandler JZQ;
  public final SparseArray<List<d>> JZR;
  public final Object JZS;
  
  i(MMHandler paramMMHandler)
  {
    AppMethodBeat.i(152018);
    this.JZQ = paramMMHandler;
    this.JZR = new SparseArray();
    this.JZS = new Object();
    AppMethodBeat.o(152018);
  }
  
  private List<d> bee(String arg1)
  {
    AppMethodBeat.i(152022);
    int i = ???.hashCode();
    synchronized (this.JZS)
    {
      List localList = (List)this.JZR.get(i);
      AppMethodBeat.o(152022);
      return localList;
    }
  }
  
  public final void C(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(152020);
    Log.i("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchRetry, urlKey = %s, max = %d, count = %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    paramString = q.a.goa().beg(paramString);
    if (paramString != null)
    {
      paramString.field_maxRetryTimes = paramInt1;
      paramString.field_retryTimes = paramInt2;
      q.a.goa().h(paramString);
    }
    AppMethodBeat.o(152020);
  }
  
  public final void O(String paramString, long paramLong)
  {
    AppMethodBeat.i(152021);
    paramString = q.a.goa().beg(paramString);
    if (paramString != null)
    {
      paramString.field_contentLength = paramLong;
      q.a.goa().h(paramString);
    }
    AppMethodBeat.o(152021);
  }
  
  public final void a(final e parame, final m paramm)
  {
    AppMethodBeat.i(152019);
    Log.i("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchResponse, response = ".concat(String.valueOf(paramm)));
    switch (paramm.status)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(152019);
      return;
      Object localObject = q.a.goa().beg(paramm.JYs);
      if (localObject != null)
      {
        ((s)localObject).field_status = 4;
        q.a.goa().h((s)localObject);
      }
      localObject = bee(parame.avy());
      if (!Util.isNullOrNil((List)localObject))
      {
        parame = parame.gnA();
        this.JZQ.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(152017);
            Iterator localIterator = this.JZT.iterator();
            while (localIterator.hasNext())
            {
              d locald = (d)localIterator.next();
              if (Util.nullAsNil(locald.avy()).equals(paramm.groupId)) {
                locald.bdW(parame);
              }
            }
            AppMethodBeat.o(152017);
          }
        });
      }
      AppMethodBeat.o(152019);
      return;
      localObject = q.a.goa().beg(paramm.JYs);
      if (localObject != null)
      {
        ((s)localObject).field_status = 2;
        q.a.goa().h((s)localObject);
      }
      Log.d("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchComplete, groupId = " + parame.avy());
      localObject = bee(parame.avy());
      if (Util.isNullOrNil((List)localObject))
      {
        Log.d("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchComplete, listeners.size = null");
        AppMethodBeat.o(152019);
        return;
      }
      Log.d("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchComplete, listeners.size = " + ((List)localObject).size());
      parame = parame.gnA();
      this.JZQ.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(152016);
          Iterator localIterator = this.JZT.iterator();
          while (localIterator.hasNext())
          {
            d locald = (d)localIterator.next();
            if (Util.nullAsNil(locald.avy()).equals(paramm.groupId)) {
              locald.bdV(parame);
            }
          }
          AppMethodBeat.o(152016);
        }
      });
      AppMethodBeat.o(152019);
      return;
      localObject = q.a.goa().beg(paramm.JYs);
      if (localObject != null)
      {
        ((s)localObject).field_status = 3;
        q.a.goa().h((s)localObject);
      }
      localObject = bee(parame.avy());
      if (!Util.isNullOrNil((List)localObject))
      {
        parame = parame.gnA();
        this.JZQ.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(152015);
            Iterator localIterator = this.JZT.iterator();
            while (localIterator.hasNext())
            {
              d locald = (d)localIterator.next();
              if (Util.nullAsNil(locald.avy()).equals(paramm.groupId)) {
                locald.a(parame, paramm);
              }
            }
            AppMethodBeat.o(152015);
          }
        });
      }
    }
  }
  
  public final void a(String paramString, k paramk) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.a.c.i
 * JD-Core Version:    0.7.0.1
 */