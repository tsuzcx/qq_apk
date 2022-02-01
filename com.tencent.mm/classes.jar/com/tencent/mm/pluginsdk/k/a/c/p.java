package com.tencent.mm.pluginsdk.k.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.Iterator;

public final class p
{
  public final s RaN;
  public final m RaO;
  public final i RaP;
  private volatile MMHandler eYn;
  public final MMHandler handler;
  public final boolean omY;
  
  private p()
  {
    AppMethodBeat.i(152059);
    this.eYn = null;
    q.init();
    this.RaN = s.hiM();
    if (this.RaN == null)
    {
      this.omY = false;
      this.RaO = null;
      this.handler = null;
      this.RaP = null;
      AppMethodBeat.o(152059);
      return;
    }
    this.omY = true;
    this.handler = new MMHandler("ResDownloader-EventThread");
    this.RaP = new i(cMC());
    this.RaO = new m("ResDownloader-EventThread", this.RaP);
    AppMethodBeat.o(152059);
  }
  
  static m.a c(k paramk)
  {
    AppMethodBeat.i(152062);
    Log.d("MicroMsg.ResDownloaderCore", "getNetworkRequestHandler");
    int i = paramk.aCt().hashCode();
    Iterator localIterator = q.hiL().iterator();
    while (localIterator.hasNext())
    {
      g localg = (g)localIterator.next();
      Log.i("MicroMsg.ResDownloaderCore", "plugin = %s, groupId = %s", new Object[] { localg.getClass().getSimpleName(), localg.aCt() });
      if (localg.aCt().hashCode() == i)
      {
        paramk = localg.c(paramk);
        AppMethodBeat.o(152062);
        return paramk;
      }
    }
    AppMethodBeat.o(152062);
    return null;
  }
  
  public final void agN(String paramString)
  {
    AppMethodBeat.i(152067);
    if (this.omY) {
      this.RaO.bqB(paramString);
    }
    AppMethodBeat.o(152067);
  }
  
  public final void am(Runnable paramRunnable)
  {
    AppMethodBeat.i(152060);
    cMC().postToWorker(new p.b(paramRunnable, (byte)0));
    AppMethodBeat.o(152060);
  }
  
  public final r bqC(String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(152064);
    if (this.omY)
    {
      long l = Util.nowMilliSecond();
      r localr = this.RaN.bqC(paramString);
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
  
  public final boolean bqD(String paramString)
  {
    AppMethodBeat.i(152066);
    if (this.omY)
    {
      if ((this.RaO.bqy(paramString)) || (this.RaO.bqz(paramString)))
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
  
  final MMHandler cMC()
  {
    AppMethodBeat.i(184269);
    if (this.eYn == null)
    {
      this.eYn = new MMHandler("ResDownloader-WorkerThread");
      this.eYn.setLogging(false);
    }
    MMHandler localMMHandler = this.eYn;
    AppMethodBeat.o(184269);
    return localMMHandler;
  }
  
  public final int d(k paramk)
  {
    AppMethodBeat.i(152065);
    if (this.omY)
    {
      if (Util.isNullOrNil(paramk.url))
      {
        Log.i("MicroMsg.ResDownloaderCore", "request#%s with null url, ignore", new Object[] { paramk.QYU });
        AppMethodBeat.o(152065);
        return 3;
      }
      Log.i("MicroMsg.ResDownloaderCore", "request#%s post to network worker", new Object[] { paramk.QYU });
      int i = this.RaO.b(paramk);
      AppMethodBeat.o(152065);
      return i;
    }
    AppMethodBeat.o(152065);
    return -1;
  }
  
  public final void h(r paramr)
  {
    AppMethodBeat.i(152063);
    long l;
    if (this.omY)
    {
      l = Util.nowMilliSecond();
      if (this.RaN.bqC(paramr.field_urlKey) == null) {
        break label84;
      }
      this.RaN.i(paramr);
    }
    for (boolean bool = false;; bool = true)
    {
      Log.i("MicroMsg.ResDownloaderCore", "doUpdate: urlKey = %s, opIsInsert(%b) cost = %d", new Object[] { paramr.field_urlKey, Boolean.valueOf(bool), Long.valueOf(Util.milliSecondsToNow(l)) });
      AppMethodBeat.o(152063);
      return;
      label84:
      this.RaN.j(paramr);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.k.a.c.p
 * JD-Core Version:    0.7.0.1
 */