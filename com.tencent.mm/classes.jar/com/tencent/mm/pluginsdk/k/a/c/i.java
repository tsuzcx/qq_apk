package com.tencent.mm.pluginsdk.k.a.c;

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
  private final MMHandler Rat;
  public final SparseArray<List<d>> Rau;
  public final Object Rav;
  
  i(MMHandler paramMMHandler)
  {
    AppMethodBeat.i(152018);
    this.Rat = paramMMHandler;
    this.Rau = new SparseArray();
    this.Rav = new Object();
    AppMethodBeat.o(152018);
  }
  
  private List<d> bqA(String arg1)
  {
    AppMethodBeat.i(152022);
    int i = ???.hashCode();
    synchronized (this.Rav)
    {
      List localList = (List)this.Rau.get(i);
      AppMethodBeat.o(152022);
      return localList;
    }
  }
  
  public final void C(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(152020);
    Log.i("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchRetry, urlKey = %s, max = %d, count = %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    paramString = p.a.hiK().bqC(paramString);
    if (paramString != null)
    {
      paramString.field_maxRetryTimes = paramInt1;
      paramString.field_retryTimes = paramInt2;
      p.a.hiK().h(paramString);
    }
    AppMethodBeat.o(152020);
  }
  
  public final void O(String paramString, long paramLong)
  {
    AppMethodBeat.i(152021);
    paramString = p.a.hiK().bqC(paramString);
    if (paramString != null)
    {
      paramString.field_contentLength = paramLong;
      p.a.hiK().h(paramString);
    }
    AppMethodBeat.o(152021);
  }
  
  public final void a(final e parame, final l paraml)
  {
    AppMethodBeat.i(152019);
    Log.i("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchResponse, response = ".concat(String.valueOf(paraml)));
    switch (paraml.status)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(152019);
      return;
      Object localObject = p.a.hiK().bqC(paraml.QYU);
      if (localObject != null)
      {
        ((r)localObject).field_status = 4;
        p.a.hiK().h((r)localObject);
      }
      localObject = bqA(parame.aCt());
      if (!Util.isNullOrNil((List)localObject))
      {
        parame = parame.hig();
        this.Rat.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(152017);
            Iterator localIterator = this.Raw.iterator();
            while (localIterator.hasNext())
            {
              d locald = (d)localIterator.next();
              if (Util.nullAsNil(locald.aCt()).equals(paraml.groupId)) {
                locald.bqs(parame);
              }
            }
            AppMethodBeat.o(152017);
          }
        });
      }
      AppMethodBeat.o(152019);
      return;
      localObject = p.a.hiK().bqC(paraml.QYU);
      if (localObject != null)
      {
        ((r)localObject).field_status = 2;
        p.a.hiK().h((r)localObject);
      }
      Log.d("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchComplete, groupId = " + parame.aCt());
      localObject = bqA(parame.aCt());
      if (Util.isNullOrNil((List)localObject))
      {
        Log.d("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchComplete, listeners.size = null");
        AppMethodBeat.o(152019);
        return;
      }
      Log.d("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchComplete, listeners.size = " + ((List)localObject).size());
      parame = parame.hig();
      this.Rat.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(152016);
          Iterator localIterator = this.Raw.iterator();
          while (localIterator.hasNext())
          {
            d locald = (d)localIterator.next();
            if (Util.nullAsNil(locald.aCt()).equals(paraml.groupId)) {
              locald.bqr(parame);
            }
          }
          AppMethodBeat.o(152016);
        }
      });
      AppMethodBeat.o(152019);
      return;
      localObject = p.a.hiK().bqC(paraml.QYU);
      if (localObject != null)
      {
        ((r)localObject).field_status = 3;
        p.a.hiK().h((r)localObject);
      }
      localObject = bqA(parame.aCt());
      if (!Util.isNullOrNil((List)localObject))
      {
        parame = parame.hig();
        this.Rat.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(152015);
            Iterator localIterator = this.Raw.iterator();
            while (localIterator.hasNext())
            {
              d locald = (d)localIterator.next();
              if (Util.nullAsNil(locald.aCt()).equals(paraml.groupId)) {
                locald.a(parame, paraml);
              }
            }
            AppMethodBeat.o(152015);
          }
        });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.k.a.c.i
 * JD-Core Version:    0.7.0.1
 */