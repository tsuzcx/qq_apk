package com.tencent.mm.pluginsdk.j.a.c;

import android.os.Looper;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Collection;
import java.util.Iterator;

public final class q
{
  public final t EQW;
  public final n EQX;
  public final i EQY;
  private volatile ap cPB;
  public final ap handler;
  public final boolean kld;
  
  private q()
  {
    AppMethodBeat.i(152059);
    this.cPB = null;
    r.init();
    this.EQW = t.fbe();
    if (this.EQW == null)
    {
      this.kld = false;
      this.EQX = null;
      this.handler = null;
      this.EQY = null;
      AppMethodBeat.o(152059);
      return;
    }
    this.kld = true;
    this.handler = new ap("ResDownloader-EventThread");
    this.EQY = new i(bZb());
    this.EQX = new n("ResDownloader-EventThread", this.EQY);
    AppMethodBeat.o(152059);
  }
  
  static n.a c(l paraml)
  {
    AppMethodBeat.i(152062);
    ad.d("MicroMsg.ResDownloaderCore", "getNetworkRequestHandler");
    int i = paraml.afw().hashCode();
    Iterator localIterator = r.fbd().iterator();
    while (localIterator.hasNext())
    {
      g localg = (g)localIterator.next();
      ad.i("MicroMsg.ResDownloaderCore", "plugin = %s, groupId = %s", new Object[] { localg.getClass().getSimpleName(), localg.afw() });
      if (localg.afw().hashCode() == i)
      {
        paraml = localg.c(paraml);
        AppMethodBeat.o(152062);
        return paraml;
      }
    }
    AppMethodBeat.o(152062);
    return null;
  }
  
  public final void Pd(String paramString)
  {
    AppMethodBeat.i(152067);
    if (this.kld) {
      this.EQX.aMh(paramString);
    }
    AppMethodBeat.o(152067);
  }
  
  public final s aMi(String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(152064);
    if (this.kld)
    {
      long l = bt.flT();
      s locals = this.EQW.aMi(paramString);
      if (locals != null) {
        bool = true;
      }
      ad.i("MicroMsg.ResDownloaderCore", "doQuery: urlKey = %s, ret = %b, cost = %d", new Object[] { paramString, Boolean.valueOf(bool), Long.valueOf(bt.Df(l)) });
      AppMethodBeat.o(152064);
      return locals;
    }
    AppMethodBeat.o(152064);
    return null;
  }
  
  public final boolean aMj(String paramString)
  {
    AppMethodBeat.i(152066);
    if (this.kld)
    {
      if ((this.EQX.aMe(paramString)) || (this.EQX.aMf(paramString)))
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
  
  public final void af(Runnable paramRunnable)
  {
    AppMethodBeat.i(152060);
    bZb().postToWorker(new b(paramRunnable, (byte)0));
    AppMethodBeat.o(152060);
  }
  
  final ap bZb()
  {
    AppMethodBeat.i(184269);
    if (this.cPB == null)
    {
      this.cPB = new ap("ResDownloader-WorkerThread");
      this.cPB.setLogging(false);
    }
    ap localap = this.cPB;
    AppMethodBeat.o(184269);
    return localap;
  }
  
  public final int d(l paraml)
  {
    AppMethodBeat.i(152065);
    if (this.kld)
    {
      if (bt.isNullOrNil(paraml.url))
      {
        ad.i("MicroMsg.ResDownloaderCore", "request#%s with null url, ignore", new Object[] { paraml.EPe });
        AppMethodBeat.o(152065);
        return 3;
      }
      ad.i("MicroMsg.ResDownloaderCore", "request#%s post to network worker", new Object[] { paraml.EPe });
      int i = this.EQX.b(paraml);
      AppMethodBeat.o(152065);
      return i;
    }
    AppMethodBeat.o(152065);
    return -1;
  }
  
  public final void h(s params)
  {
    AppMethodBeat.i(152063);
    long l;
    if (this.kld)
    {
      l = bt.flT();
      if (this.EQW.aMi(params.field_urlKey) == null) {
        break label84;
      }
      this.EQW.i(params);
    }
    for (boolean bool = false;; bool = true)
    {
      ad.i("MicroMsg.ResDownloaderCore", "doUpdate: urlKey = %s, opIsInsert(%b) cost = %d", new Object[] { params.field_urlKey, Boolean.valueOf(bool), Long.valueOf(bt.Df(l)) });
      AppMethodBeat.o(152063);
      return;
      label84:
      this.EQW.j(params);
    }
  }
  
  public static final class a
  {
    private static final q EQZ;
    
    static
    {
      AppMethodBeat.i(152057);
      EQZ = new q((byte)0);
      AppMethodBeat.o(152057);
    }
  }
  
  static final class b
    implements Runnable
  {
    private final Runnable cDO;
    
    private b(Runnable paramRunnable)
    {
      this.cDO = paramRunnable;
    }
    
    public final void run()
    {
      AppMethodBeat.i(152058);
      if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) {}
      for (int i = 1;; i = 0)
      {
        if ((i == 0) && (Process.getThreadPriority(Process.myTid()) != 10)) {
          Process.setThreadPriority(10);
        }
        if (this.cDO != null) {
          this.cDO.run();
        }
        AppMethodBeat.o(152058);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.a.c.q
 * JD-Core Version:    0.7.0.1
 */