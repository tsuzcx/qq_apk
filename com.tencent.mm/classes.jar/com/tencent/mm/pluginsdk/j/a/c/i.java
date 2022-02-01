package com.tencent.mm.pluginsdk.j.a.c;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.List;

public final class i
  implements c
{
  private final aq FiW;
  public final SparseArray<List<d>> FiX;
  public final Object FiY;
  
  i(aq paramaq)
  {
    AppMethodBeat.i(152018);
    this.FiW = paramaq;
    this.FiX = new SparseArray();
    this.FiY = new Object();
    AppMethodBeat.o(152018);
  }
  
  private List<d> aNC(String arg1)
  {
    AppMethodBeat.i(152022);
    int i = ???.hashCode();
    synchronized (this.FiY)
    {
      List localList = (List)this.FiX.get(i);
      AppMethodBeat.o(152022);
      return localList;
    }
  }
  
  public final void C(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(152020);
    ae.i("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchRetry, urlKey = %s, max = %d, count = %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    paramString = q.a.feQ().aNE(paramString);
    if (paramString != null)
    {
      paramString.field_maxRetryTimes = paramInt1;
      paramString.field_retryTimes = paramInt2;
      q.a.feQ().h(paramString);
    }
    AppMethodBeat.o(152020);
  }
  
  public final void O(String paramString, long paramLong)
  {
    AppMethodBeat.i(152021);
    paramString = q.a.feQ().aNE(paramString);
    if (paramString != null)
    {
      paramString.field_contentLength = paramLong;
      q.a.feQ().h(paramString);
    }
    AppMethodBeat.o(152021);
  }
  
  public final void a(final e parame, final m paramm)
  {
    AppMethodBeat.i(152019);
    ae.i("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchResponse, response = ".concat(String.valueOf(paramm)));
    switch (paramm.status)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(152019);
      return;
      Object localObject = q.a.feQ().aNE(paramm.Fhz);
      if (localObject != null)
      {
        ((s)localObject).field_status = 4;
        q.a.feQ().h((s)localObject);
      }
      localObject = aNC(parame.afK());
      if (!bu.ht((List)localObject))
      {
        parame = parame.feq();
        this.FiW.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(152017);
            Iterator localIterator = this.FiZ.iterator();
            while (localIterator.hasNext())
            {
              d locald = (d)localIterator.next();
              if (bu.nullAsNil(locald.afK()).equals(paramm.groupId)) {
                locald.aNu(parame);
              }
            }
            AppMethodBeat.o(152017);
          }
        });
      }
      AppMethodBeat.o(152019);
      return;
      localObject = q.a.feQ().aNE(paramm.Fhz);
      if (localObject != null)
      {
        ((s)localObject).field_status = 2;
        q.a.feQ().h((s)localObject);
      }
      ae.d("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchComplete, groupId = " + parame.afK());
      localObject = aNC(parame.afK());
      if (bu.ht((List)localObject))
      {
        ae.d("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchComplete, listeners.size = null");
        AppMethodBeat.o(152019);
        return;
      }
      ae.d("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchComplete, listeners.size = " + ((List)localObject).size());
      parame = parame.feq();
      this.FiW.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(152016);
          Iterator localIterator = this.FiZ.iterator();
          while (localIterator.hasNext())
          {
            d locald = (d)localIterator.next();
            if (bu.nullAsNil(locald.afK()).equals(paramm.groupId)) {
              locald.aNt(parame);
            }
          }
          AppMethodBeat.o(152016);
        }
      });
      AppMethodBeat.o(152019);
      return;
      localObject = q.a.feQ().aNE(paramm.Fhz);
      if (localObject != null)
      {
        ((s)localObject).field_status = 3;
        q.a.feQ().h((s)localObject);
      }
      localObject = aNC(parame.afK());
      if (!bu.ht((List)localObject))
      {
        parame = parame.feq();
        this.FiW.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(152015);
            Iterator localIterator = this.FiZ.iterator();
            while (localIterator.hasNext())
            {
              d locald = (d)localIterator.next();
              if (bu.nullAsNil(locald.afK()).equals(paramm.groupId)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.a.c.i
 * JD-Core Version:    0.7.0.1
 */