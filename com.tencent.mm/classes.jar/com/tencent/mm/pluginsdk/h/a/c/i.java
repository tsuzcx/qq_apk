package com.tencent.mm.pluginsdk.h.a.c;

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
  private final ap BTj;
  public final SparseArray<List<d>> BTk;
  public final Object BTl;
  
  i(ap paramap)
  {
    AppMethodBeat.i(152018);
    this.BTj = paramap;
    this.BTk = new SparseArray();
    this.BTl = new Object();
    AppMethodBeat.o(152018);
  }
  
  private List<d> aBo(String arg1)
  {
    AppMethodBeat.i(152022);
    int i = ???.hashCode();
    synchronized (this.BTl)
    {
      List localList = (List)this.BTk.get(i);
      AppMethodBeat.o(152022);
      return localList;
    }
  }
  
  public final void B(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(152020);
    ad.i("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchRetry, urlKey = %s, max = %d, count = %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    paramString = q.a.ewL().aBq(paramString);
    if (paramString != null)
    {
      paramString.field_maxRetryTimes = paramInt1;
      paramString.field_retryTimes = paramInt2;
      q.a.ewL().h(paramString);
    }
    AppMethodBeat.o(152020);
  }
  
  public final void G(String paramString, long paramLong)
  {
    AppMethodBeat.i(152021);
    paramString = q.a.ewL().aBq(paramString);
    if (paramString != null)
    {
      paramString.field_contentLength = paramLong;
      q.a.ewL().h(paramString);
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
      Object localObject = q.a.ewL().aBq(paramm.BRL);
      if (localObject != null)
      {
        ((s)localObject).field_status = 4;
        q.a.ewL().h((s)localObject);
      }
      localObject = aBo(parame.asy());
      if (!bt.gL((List)localObject))
      {
        parame = parame.ewl();
        this.BTj.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(152017);
            Iterator localIterator = this.BTm.iterator();
            while (localIterator.hasNext())
            {
              d locald = (d)localIterator.next();
              if (bt.nullAsNil(locald.asy()).equals(paramm.groupId)) {
                locald.aBg(parame);
              }
            }
            AppMethodBeat.o(152017);
          }
        });
      }
      AppMethodBeat.o(152019);
      return;
      localObject = q.a.ewL().aBq(paramm.BRL);
      if (localObject != null)
      {
        ((s)localObject).field_status = 2;
        q.a.ewL().h((s)localObject);
      }
      ad.d("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchComplete, groupId = " + parame.asy());
      localObject = aBo(parame.asy());
      if (bt.gL((List)localObject))
      {
        ad.d("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchComplete, listeners.size = null");
        AppMethodBeat.o(152019);
        return;
      }
      ad.d("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchComplete, listeners.size = " + ((List)localObject).size());
      parame = parame.ewl();
      this.BTj.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(152016);
          Iterator localIterator = this.BTm.iterator();
          while (localIterator.hasNext())
          {
            d locald = (d)localIterator.next();
            if (bt.nullAsNil(locald.asy()).equals(paramm.groupId)) {
              locald.aBf(parame);
            }
          }
          AppMethodBeat.o(152016);
        }
      });
      AppMethodBeat.o(152019);
      return;
      localObject = q.a.ewL().aBq(paramm.BRL);
      if (localObject != null)
      {
        ((s)localObject).field_status = 3;
        q.a.ewL().h((s)localObject);
      }
      localObject = aBo(parame.asy());
      if (!bt.gL((List)localObject))
      {
        parame = parame.ewl();
        this.BTj.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(152015);
            Iterator localIterator = this.BTm.iterator();
            while (localIterator.hasNext())
            {
              d locald = (d)localIterator.next();
              if (bt.nullAsNil(locald.asy()).equals(paramm.groupId)) {
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
 * Qualified Name:     com.tencent.mm.pluginsdk.h.a.c.i
 * JD-Core Version:    0.7.0.1
 */