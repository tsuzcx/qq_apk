package com.tencent.mm.pluginsdk.res.downloader.model;

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
  public final Object XWA;
  private final MMHandler XWy;
  public final SparseArray<List<d>> XWz;
  
  i(MMHandler paramMMHandler)
  {
    AppMethodBeat.i(152018);
    this.XWy = paramMMHandler;
    this.XWz = new SparseArray();
    this.XWA = new Object();
    AppMethodBeat.o(152018);
  }
  
  private List<d> bqo(String arg1)
  {
    AppMethodBeat.i(152022);
    int i = ???.hashCode();
    synchronized (this.XWA)
    {
      List localList = (List)this.XWz.get(i);
      AppMethodBeat.o(152022);
      return localList;
    }
  }
  
  public final void G(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(152020);
    Log.i("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchRetry, urlKey = %s, max = %d, count = %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    paramString = p.a.iJK().bqq(paramString);
    if (paramString != null)
    {
      paramString.field_maxRetryTimes = paramInt1;
      paramString.field_retryTimes = paramInt2;
      p.a.iJK().h(paramString);
    }
    AppMethodBeat.o(152020);
  }
  
  public final void T(String paramString, long paramLong)
  {
    AppMethodBeat.i(152021);
    paramString = p.a.iJK().bqq(paramString);
    if (paramString != null)
    {
      paramString.field_contentLength = paramLong;
      p.a.iJK().h(paramString);
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
      Object localObject = p.a.iJK().bqq(paraml.XUX);
      if (localObject != null)
      {
        ((r)localObject).field_status = 4;
        p.a.iJK().h((r)localObject);
      }
      localObject = bqo(parame.aVp());
      if (!Util.isNullOrNil((List)localObject))
      {
        parame = parame.iJd();
        this.XWy.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(152017);
            Iterator localIterator = this.XWB.iterator();
            while (localIterator.hasNext())
            {
              d locald = (d)localIterator.next();
              if (Util.nullAsNil(locald.aVp()).equals(paraml.groupId)) {
                locald.bqg(parame);
              }
            }
            AppMethodBeat.o(152017);
          }
        });
      }
      AppMethodBeat.o(152019);
      return;
      localObject = p.a.iJK().bqq(paraml.XUX);
      if (localObject != null)
      {
        ((r)localObject).field_status = 2;
        p.a.iJK().h((r)localObject);
      }
      Log.d("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchComplete, groupId = " + parame.aVp());
      localObject = bqo(parame.aVp());
      if (Util.isNullOrNil((List)localObject))
      {
        Log.d("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchComplete, listeners.size = null");
        AppMethodBeat.o(152019);
        return;
      }
      Log.d("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchComplete, listeners.size = " + ((List)localObject).size());
      parame = parame.iJd();
      this.XWy.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(152016);
          Iterator localIterator = this.XWB.iterator();
          while (localIterator.hasNext())
          {
            d locald = (d)localIterator.next();
            if (Util.nullAsNil(locald.aVp()).equals(paraml.groupId)) {
              locald.bqf(parame);
            }
          }
          AppMethodBeat.o(152016);
        }
      });
      AppMethodBeat.o(152019);
      return;
      localObject = p.a.iJK().bqq(paraml.XUX);
      if (localObject != null)
      {
        ((r)localObject).field_status = 3;
        p.a.iJK().h((r)localObject);
      }
      localObject = bqo(parame.aVp());
      if (!Util.isNullOrNil((List)localObject))
      {
        parame = parame.iJd();
        this.XWy.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(152015);
            Iterator localIterator = this.XWB.iterator();
            while (localIterator.hasNext())
            {
              d locald = (d)localIterator.next();
              if (Util.nullAsNil(locald.aVp()).equals(paraml.groupId)) {
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
 * Qualified Name:     com.tencent.mm.pluginsdk.res.downloader.model.i
 * JD-Core Version:    0.7.0.1
 */