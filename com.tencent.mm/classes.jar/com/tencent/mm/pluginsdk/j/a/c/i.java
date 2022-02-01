package com.tencent.mm.pluginsdk.j.a.c;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.List;

public final class i
  implements c
{
  private final ap EQB;
  public final SparseArray<List<d>> EQC;
  public final Object EQD;
  
  i(ap paramap)
  {
    AppMethodBeat.i(152018);
    this.EQB = paramap;
    this.EQC = new SparseArray();
    this.EQD = new Object();
    AppMethodBeat.o(152018);
  }
  
  private List<d> aMg(String arg1)
  {
    AppMethodBeat.i(152022);
    int i = ???.hashCode();
    synchronized (this.EQD)
    {
      List localList = (List)this.EQC.get(i);
      AppMethodBeat.o(152022);
      return localList;
    }
  }
  
  public final void C(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(152020);
    ad.i("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchRetry, urlKey = %s, max = %d, count = %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    paramString = q.a.fbc().aMi(paramString);
    if (paramString != null)
    {
      paramString.field_maxRetryTimes = paramInt1;
      paramString.field_retryTimes = paramInt2;
      q.a.fbc().h(paramString);
    }
    AppMethodBeat.o(152020);
  }
  
  public final void O(String paramString, long paramLong)
  {
    AppMethodBeat.i(152021);
    paramString = q.a.fbc().aMi(paramString);
    if (paramString != null)
    {
      paramString.field_contentLength = paramLong;
      q.a.fbc().h(paramString);
    }
    AppMethodBeat.o(152021);
  }
  
  public final void a(final e parame, final m paramm)
  {
    AppMethodBeat.i(152019);
    ad.i("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchResponse, response = ".concat(String.valueOf(paramm)));
    switch (paramm.status)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(152019);
      return;
      Object localObject = q.a.fbc().aMi(paramm.EPe);
      if (localObject != null)
      {
        ((s)localObject).field_status = 4;
        q.a.fbc().h((s)localObject);
      }
      localObject = aMg(parame.afw());
      if (!bt.hj((List)localObject))
      {
        parame = parame.faC();
        this.EQB.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(152017);
            Iterator localIterator = this.EQE.iterator();
            while (localIterator.hasNext())
            {
              d locald = (d)localIterator.next();
              if (bt.nullAsNil(locald.afw()).equals(paramm.groupId)) {
                locald.aLY(parame);
              }
            }
            AppMethodBeat.o(152017);
          }
        });
      }
      AppMethodBeat.o(152019);
      return;
      localObject = q.a.fbc().aMi(paramm.EPe);
      if (localObject != null)
      {
        ((s)localObject).field_status = 2;
        q.a.fbc().h((s)localObject);
      }
      ad.d("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchComplete, groupId = " + parame.afw());
      localObject = aMg(parame.afw());
      if (bt.hj((List)localObject))
      {
        ad.d("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchComplete, listeners.size = null");
        AppMethodBeat.o(152019);
        return;
      }
      ad.d("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchComplete, listeners.size = " + ((List)localObject).size());
      parame = parame.faC();
      this.EQB.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(152016);
          Iterator localIterator = this.EQE.iterator();
          while (localIterator.hasNext())
          {
            d locald = (d)localIterator.next();
            if (bt.nullAsNil(locald.afw()).equals(paramm.groupId)) {
              locald.aLX(parame);
            }
          }
          AppMethodBeat.o(152016);
        }
      });
      AppMethodBeat.o(152019);
      return;
      localObject = q.a.fbc().aMi(paramm.EPe);
      if (localObject != null)
      {
        ((s)localObject).field_status = 3;
        q.a.fbc().h((s)localObject);
      }
      localObject = aMg(parame.afw());
      if (!bt.hj((List)localObject))
      {
        parame = parame.faC();
        this.EQB.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(152015);
            Iterator localIterator = this.EQE.iterator();
            while (localIterator.hasNext())
            {
              d locald = (d)localIterator.next();
              if (bt.nullAsNil(locald.afw()).equals(paramm.groupId)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.a.c.i
 * JD-Core Version:    0.7.0.1
 */