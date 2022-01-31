package com.tencent.mm.pluginsdk.g.a.c;

import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

public final class i
  implements c
{
  private final ah rXs;
  public final SparseArray<List<d>> rXt;
  public final Object rXu;
  
  i(ah paramah)
  {
    this.rXs = paramah;
    this.rXt = new SparseArray();
    this.rXu = new Object();
  }
  
  private List<d> Wk(String arg1)
  {
    int i = ???.hashCode();
    synchronized (this.rXu)
    {
      List localList = (List)this.rXt.get(i);
      return localList;
    }
  }
  
  public final void a(e parame, m paramm)
  {
    y.i("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchResponse, response = " + paramm);
    switch (paramm.status)
    {
    }
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = q.a.clL().Wl(paramm.rVT);
        if (localObject != null)
        {
          ((s)localObject).field_status = 4;
          q.a.clL().g((s)localObject);
        }
        localObject = Wk(parame.acb());
      } while (bk.dk((List)localObject));
      parame = parame.cls();
      this.rXs.post(new i.3(this, (List)localObject, paramm, parame));
      return;
      localObject = q.a.clL().Wl(paramm.rVT);
      if (localObject != null)
      {
        ((s)localObject).field_status = 2;
        q.a.clL().g((s)localObject);
      }
      y.d("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchComplete, groupId = " + parame.acb());
      localObject = Wk(parame.acb());
      if (bk.dk((List)localObject))
      {
        y.d("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchComplete, listeners.size = null");
        return;
      }
      y.d("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchComplete, listeners.size = " + ((List)localObject).size());
      parame = parame.cls();
      this.rXs.post(new i.2(this, (List)localObject, paramm, parame));
      return;
      localObject = q.a.clL().Wl(paramm.rVT);
      if (localObject != null)
      {
        ((s)localObject).field_status = 3;
        q.a.clL().g((s)localObject);
      }
      localObject = Wk(parame.acb());
    } while (bk.dk((List)localObject));
    parame = parame.cls();
    this.rXs.post(new i.1(this, (List)localObject, paramm, parame));
  }
  
  public final void a(String paramString, k paramk) {}
  
  public final void s(String paramString, int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchRetry, urlKey = %s, max = %d, count = %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    paramString = q.a.clL().Wl(paramString);
    if (paramString != null)
    {
      paramString.field_maxRetryTimes = paramInt1;
      paramString.field_retryTimes = paramInt2;
      q.a.clL().g(paramString);
    }
  }
  
  public final void u(String paramString, long paramLong)
  {
    paramString = q.a.clL().Wl(paramString);
    if (paramString != null)
    {
      paramString.field_contentLength = paramLong;
      q.a.clL().g(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.c.i
 * JD-Core Version:    0.7.0.1
 */