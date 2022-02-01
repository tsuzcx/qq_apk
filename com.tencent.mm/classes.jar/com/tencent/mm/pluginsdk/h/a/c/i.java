package com.tencent.mm.pluginsdk.h.a.c;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.List;

public final class i
  implements c
{
  public final SparseArray<List<d>> DlA;
  public final Object DlB;
  private final ao Dlz;
  
  i(ao paramao)
  {
    AppMethodBeat.i(152018);
    this.Dlz = paramao;
    this.DlA = new SparseArray();
    this.DlB = new Object();
    AppMethodBeat.o(152018);
  }
  
  private List<d> aGG(String arg1)
  {
    AppMethodBeat.i(152022);
    int i = ???.hashCode();
    synchronized (this.DlB)
    {
      List localList = (List)this.DlA.get(i);
      AppMethodBeat.o(152022);
      return localList;
    }
  }
  
  public final void A(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(152020);
    ac.i("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchRetry, urlKey = %s, max = %d, count = %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    paramString = q.a.eMf().aGI(paramString);
    if (paramString != null)
    {
      paramString.field_maxRetryTimes = paramInt1;
      paramString.field_retryTimes = paramInt2;
      q.a.eMf().h(paramString);
    }
    AppMethodBeat.o(152020);
  }
  
  public final void H(String paramString, long paramLong)
  {
    AppMethodBeat.i(152021);
    paramString = q.a.eMf().aGI(paramString);
    if (paramString != null)
    {
      paramString.field_contentLength = paramLong;
      q.a.eMf().h(paramString);
    }
    AppMethodBeat.o(152021);
  }
  
  public final void a(final e parame, final m paramm)
  {
    AppMethodBeat.i(152019);
    ac.i("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchResponse, response = ".concat(String.valueOf(paramm)));
    switch (paramm.status)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(152019);
      return;
      Object localObject = q.a.eMf().aGI(paramm.Dkb);
      if (localObject != null)
      {
        ((s)localObject).field_status = 4;
        q.a.eMf().h((s)localObject);
      }
      localObject = aGG(parame.azp());
      if (!bs.gY((List)localObject))
      {
        parame = parame.eLF();
        this.Dlz.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(152017);
            Iterator localIterator = this.DlC.iterator();
            while (localIterator.hasNext())
            {
              d locald = (d)localIterator.next();
              if (bs.nullAsNil(locald.azp()).equals(paramm.groupId)) {
                locald.aGy(parame);
              }
            }
            AppMethodBeat.o(152017);
          }
        });
      }
      AppMethodBeat.o(152019);
      return;
      localObject = q.a.eMf().aGI(paramm.Dkb);
      if (localObject != null)
      {
        ((s)localObject).field_status = 2;
        q.a.eMf().h((s)localObject);
      }
      ac.d("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchComplete, groupId = " + parame.azp());
      localObject = aGG(parame.azp());
      if (bs.gY((List)localObject))
      {
        ac.d("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchComplete, listeners.size = null");
        AppMethodBeat.o(152019);
        return;
      }
      ac.d("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchComplete, listeners.size = " + ((List)localObject).size());
      parame = parame.eLF();
      this.Dlz.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(152016);
          Iterator localIterator = this.DlC.iterator();
          while (localIterator.hasNext())
          {
            d locald = (d)localIterator.next();
            if (bs.nullAsNil(locald.azp()).equals(paramm.groupId)) {
              locald.aGx(parame);
            }
          }
          AppMethodBeat.o(152016);
        }
      });
      AppMethodBeat.o(152019);
      return;
      localObject = q.a.eMf().aGI(paramm.Dkb);
      if (localObject != null)
      {
        ((s)localObject).field_status = 3;
        q.a.eMf().h((s)localObject);
      }
      localObject = aGG(parame.azp());
      if (!bs.gY((List)localObject))
      {
        parame = parame.eLF();
        this.Dlz.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(152015);
            Iterator localIterator = this.DlC.iterator();
            while (localIterator.hasNext())
            {
              d locald = (d)localIterator.next();
              if (bs.nullAsNil(locald.azp()).equals(paramm.groupId)) {
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
 * Qualified Name:     com.tencent.mm.pluginsdk.h.a.c.i
 * JD-Core Version:    0.7.0.1
 */