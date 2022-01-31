package com.tencent.mm.pluginsdk.g.a.c;

import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

public final class q
{
  private volatile ai edy = null;
  public final boolean gaO;
  public final ah handler;
  public final t rXN;
  public final n rXO;
  public final i rXP;
  
  private q()
  {
    r.init();
    this.rXN = t.clN();
    if (this.rXN == null)
    {
      this.gaO = false;
      this.rXO = null;
      this.handler = null;
      this.rXP = null;
      return;
    }
    this.gaO = true;
    u localu = new u();
    this.handler = new ai("ResDownloader-EventThread").crf();
    this.rXP = new i(DS().crf());
    this.rXO = new n(localu, this.rXP);
  }
  
  static n.a c(l paraml)
  {
    y.d("MicroMsg.ResDownloaderCore", "getNetworkRequestHandler");
    int i = paraml.acb().hashCode();
    Iterator localIterator = r.clM().iterator();
    while (localIterator.hasNext())
    {
      g localg = (g)localIterator.next();
      y.i("MicroMsg.ResDownloaderCore", "plugin = %s, groupId = %s", new Object[] { localg.getClass().getSimpleName(), localg.acb() });
      if (localg.acb().hashCode() == i) {
        return localg.c(paraml);
      }
    }
    return null;
  }
  
  final ai DS()
  {
    if (this.edy == null) {
      this.edy = new ai("ResDownloader-WorkerThread");
    }
    return this.edy;
  }
  
  public final void H(Runnable paramRunnable)
  {
    DS().O(new q.b(paramRunnable, (byte)0));
  }
  
  public final s Wl(String paramString)
  {
    if (this.gaO)
    {
      long l = bk.UY();
      s locals = this.rXN.Wl(paramString);
      if (locals == null) {}
      for (paramString = "null";; paramString = locals.field_urlKey)
      {
        y.i("MicroMsg.ResDownloaderCore", "doQuery: urlKey = %s, cost = %d", new Object[] { paramString, Long.valueOf(bk.co(l)) });
        return locals;
      }
    }
    return null;
  }
  
  public final boolean Wm(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.gaO) {
      if (!this.rXO.isDownloading(paramString))
      {
        bool1 = bool2;
        if (!this.rXO.Wj(paramString)) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final void Wn(String paramString)
  {
    if (this.gaO)
    {
      n localn = this.rXO;
      Future localFuture = (Future)localn.rXp.remove(paramString);
      if (localFuture != null) {
        localFuture.cancel(true);
      }
      localn.rXo.remove(paramString);
    }
  }
  
  public final void a(String paramString, d paramd)
  {
    y.d("MicroMsg.ResDownloaderCore", "addNetworkEventLister, groupId = %s, listener = %s", new Object[] { paramString, paramd });
    i locali;
    if (this.gaO)
    {
      locali = this.rXP;
      y.d("MicroMsg.ResDownloader.NetworkEventDispatcher", "addNetworkEventListener, listener = " + paramd);
      if (paramd != null) {}
    }
    else
    {
      return;
    }
    int i = paramString.hashCode();
    synchronized (locali.rXu)
    {
      List localList = (List)locali.rXt.get(i);
      paramString = localList;
      if (localList == null) {
        paramString = new LinkedList();
      }
      paramString.add(paramd);
      locali.rXt.put(i, paramString);
      return;
    }
  }
  
  public final int d(l paraml)
  {
    if (this.gaO)
    {
      if (bk.bl(paraml.url))
      {
        y.i("MicroMsg.ResDownloaderCore", "request#%s with null url, ignore", new Object[] { paraml.rVT });
        return 3;
      }
      y.i("MicroMsg.ResDownloaderCore", "request#%s post to network worker", new Object[] { paraml.rVT });
      return this.rXO.b(paraml);
    }
    return -1;
  }
  
  public final void g(s params)
  {
    long l;
    if (this.gaO)
    {
      l = bk.UY();
      if (this.rXN.Wl(params.field_urlKey) == null) {
        break label75;
      }
      this.rXN.h(params);
    }
    for (boolean bool = false;; bool = true)
    {
      y.i("MicroMsg.ResDownloaderCore", "doUpdate: urlKey = %s, opIsInsert(%b) cost = %d", new Object[] { params.field_urlKey, Boolean.valueOf(bool), Long.valueOf(bk.co(l)) });
      return;
      label75:
      this.rXN.i(params);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.c.q
 * JD-Core Version:    0.7.0.1
 */