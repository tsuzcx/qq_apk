package com.tencent.mm.pluginsdk.res.downloader.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class p
{
  public final s XWT;
  public final m XWU;
  public final i XWV;
  public final MMHandler handler;
  private volatile MMHandler hbN;
  public final boolean rqI;
  
  private p()
  {
    AppMethodBeat.i(152059);
    this.hbN = null;
    q.init();
    this.XWT = s.iJM();
    if (this.XWT == null)
    {
      this.rqI = false;
      this.XWU = null;
      this.handler = null;
      this.XWV = null;
      AppMethodBeat.o(152059);
      return;
    }
    this.rqI = true;
    this.handler = new MMHandler("ResDownloader-EventThread");
    this.XWV = new i(dqg());
    this.XWU = new m("ResDownloader-EventThread", this.XWV);
    AppMethodBeat.o(152059);
  }
  
  static m.a c(k paramk)
  {
    AppMethodBeat.i(152062);
    Log.d("MicroMsg.ResDownloaderCore", "getNetworkRequestHandler");
    int i = paramk.aVp().hashCode();
    Iterator localIterator = q.iJL().iterator();
    while (localIterator.hasNext())
    {
      g localg = (g)localIterator.next();
      Log.i("MicroMsg.ResDownloaderCore", "plugin = %s, groupId = %s", new Object[] { localg.getClass().getSimpleName(), localg.aVp() });
      if (localg.aVp().hashCode() == i)
      {
        paramk = localg.c(paramk);
        AppMethodBeat.o(152062);
        return paramk;
      }
    }
    AppMethodBeat.o(152062);
    return null;
  }
  
  public final void ZJ(String paramString)
  {
    AppMethodBeat.i(152067);
    if (this.rqI) {
      this.XWU.bqp(paramString);
    }
    AppMethodBeat.o(152067);
  }
  
  public final void au(Runnable paramRunnable)
  {
    AppMethodBeat.i(152060);
    dqg().postToWorker(new p.b(paramRunnable, (byte)0));
    AppMethodBeat.o(152060);
  }
  
  public final r bqq(String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(152064);
    if (this.rqI)
    {
      long l = Util.nowMilliSecond();
      r localr = this.XWT.bqq(paramString);
      if (localr != null) {
        bool = true;
      }
      Log.i("MicroMsg.ResDownloaderCore", "doQuery: urlKey = %s, ret = %b, cost = %d", new Object[] { paramString, Boolean.valueOf(bool), Long.valueOf(Util.milliSecondsToNow(l)) });
      AppMethodBeat.o(152064);
      return localr;
    }
    AppMethodBeat.o(152064);
    return null;
  }
  
  public final List<r> bqr(String paramString)
  {
    AppMethodBeat.i(245003);
    if (this.rqI)
    {
      long l = Util.nowMilliSecond();
      try
      {
        List localList = this.XWT.bqr(paramString);
        return localList;
      }
      finally
      {
        Log.i("MicroMsg.ResDownloaderCore", "queryForKeyLike %s, cost:%d", new Object[] { paramString, Long.valueOf(Util.nowMilliSecond() - l) });
        AppMethodBeat.o(245003);
      }
    }
    AppMethodBeat.o(245003);
    return null;
  }
  
  public final boolean bqs(String paramString)
  {
    AppMethodBeat.i(152066);
    if (this.rqI)
    {
      if ((this.XWU.bqm(paramString)) || (this.XWU.bqn(paramString)))
      {
        AppMethodBeat.o(152066);
        return true;
      }
      AppMethodBeat.o(152066);
      return false;
    }
    AppMethodBeat.o(152066);
    return false;
  }
  
  public final int d(k paramk)
  {
    AppMethodBeat.i(152065);
    if (this.rqI)
    {
      if (Util.isNullOrNil(paramk.url))
      {
        Log.i("MicroMsg.ResDownloaderCore", "request#%s with null url, ignore", new Object[] { paramk.XUX });
        AppMethodBeat.o(152065);
        return 3;
      }
      Log.i("MicroMsg.ResDownloaderCore", "request#%s post to network worker", new Object[] { paramk.XUX });
      int i = this.XWU.b(paramk);
      AppMethodBeat.o(152065);
      return i;
    }
    AppMethodBeat.o(152065);
    return -1;
  }
  
  final MMHandler dqg()
  {
    AppMethodBeat.i(184269);
    if (this.hbN == null)
    {
      this.hbN = new MMHandler("ResDownloader-WorkerThread");
      this.hbN.setLogging(false);
    }
    MMHandler localMMHandler = this.hbN;
    AppMethodBeat.o(184269);
    return localMMHandler;
  }
  
  public final void h(r paramr)
  {
    AppMethodBeat.i(152063);
    long l;
    if (this.rqI)
    {
      l = Util.nowMilliSecond();
      if (this.XWT.bqq(paramr.field_urlKey) == null) {
        break label84;
      }
      this.XWT.i(paramr);
    }
    for (boolean bool = false;; bool = true)
    {
      Log.i("MicroMsg.ResDownloaderCore", "doUpdate: urlKey = %s, opIsInsert(%b) cost = %d", new Object[] { paramr.field_urlKey, Boolean.valueOf(bool), Long.valueOf(Util.milliSecondsToNow(l)) });
      AppMethodBeat.o(152063);
      return;
      label84:
      this.XWT.j(paramr);
    }
  }
  
  public static final class a
  {
    private static final p XWW;
    
    static
    {
      AppMethodBeat.i(152057);
      XWW = new p((byte)0);
      AppMethodBeat.o(152057);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.res.downloader.model.p
 * JD-Core Version:    0.7.0.1
 */