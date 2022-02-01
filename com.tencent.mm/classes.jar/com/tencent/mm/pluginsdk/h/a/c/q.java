package com.tencent.mm.pluginsdk.h.a.c;

import android.os.Looper;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Collection;
import java.util.Iterator;

public final class q
{
  public final t DlU;
  public final n DlV;
  public final i DlW;
  private volatile ao cEw;
  public final ao handler;
  public final boolean jQO;
  
  private q()
  {
    AppMethodBeat.i(152059);
    this.cEw = null;
    r.init();
    this.DlU = t.eMh();
    if (this.DlU == null)
    {
      this.jQO = false;
      this.DlV = null;
      this.handler = null;
      this.DlW = null;
      AppMethodBeat.o(152059);
      return;
    }
    this.jQO = true;
    this.handler = new ao("ResDownloader-EventThread");
    this.DlW = new i(bUw());
    this.DlV = new n("ResDownloader-EventThread", this.DlW);
    AppMethodBeat.o(152059);
  }
  
  static n.a c(l paraml)
  {
    AppMethodBeat.i(152062);
    ac.d("MicroMsg.ResDownloaderCore", "getNetworkRequestHandler");
    int i = paraml.azp().hashCode();
    Iterator localIterator = r.eMg().iterator();
    while (localIterator.hasNext())
    {
      g localg = (g)localIterator.next();
      ac.i("MicroMsg.ResDownloaderCore", "plugin = %s, groupId = %s", new Object[] { localg.getClass().getSimpleName(), localg.azp() });
      if (localg.azp().hashCode() == i)
      {
        paraml = localg.c(paraml);
        AppMethodBeat.o(152062);
        return paraml;
      }
    }
    AppMethodBeat.o(152062);
    return null;
  }
  
  public final void LJ(String paramString)
  {
    AppMethodBeat.i(152067);
    if (this.jQO) {
      this.DlV.aGH(paramString);
    }
    AppMethodBeat.o(152067);
  }
  
  public final s aGI(String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(152064);
    if (this.jQO)
    {
      long l = bs.eWj();
      s locals = this.DlU.aGI(paramString);
      if (locals != null) {
        bool = true;
      }
      ac.i("MicroMsg.ResDownloaderCore", "doQuery: urlKey = %s, ret = %b, cost = %d", new Object[] { paramString, Boolean.valueOf(bool), Long.valueOf(bs.Ap(l)) });
      AppMethodBeat.o(152064);
      return locals;
    }
    AppMethodBeat.o(152064);
    return null;
  }
  
  public final boolean aGJ(String paramString)
  {
    AppMethodBeat.i(152066);
    if (this.jQO)
    {
      if ((this.DlV.aGE(paramString)) || (this.DlV.aGF(paramString)))
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
  
  public final void ag(Runnable paramRunnable)
  {
    AppMethodBeat.i(152060);
    bUw().postToWorker(new b(paramRunnable, (byte)0));
    AppMethodBeat.o(152060);
  }
  
  final ao bUw()
  {
    AppMethodBeat.i(184269);
    if (this.cEw == null)
    {
      this.cEw = new ao("ResDownloader-WorkerThread");
      this.cEw.setLogging(false);
    }
    ao localao = this.cEw;
    AppMethodBeat.o(184269);
    return localao;
  }
  
  public final int d(l paraml)
  {
    AppMethodBeat.i(152065);
    if (this.jQO)
    {
      if (bs.isNullOrNil(paraml.url))
      {
        ac.i("MicroMsg.ResDownloaderCore", "request#%s with null url, ignore", new Object[] { paraml.Dkb });
        AppMethodBeat.o(152065);
        return 3;
      }
      ac.i("MicroMsg.ResDownloaderCore", "request#%s post to network worker", new Object[] { paraml.Dkb });
      int i = this.DlV.b(paraml);
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
    if (this.jQO)
    {
      l = bs.eWj();
      if (this.DlU.aGI(params.field_urlKey) == null) {
        break label84;
      }
      this.DlU.i(params);
    }
    for (boolean bool = false;; bool = true)
    {
      ac.i("MicroMsg.ResDownloaderCore", "doUpdate: urlKey = %s, opIsInsert(%b) cost = %d", new Object[] { params.field_urlKey, Boolean.valueOf(bool), Long.valueOf(bs.Ap(l)) });
      AppMethodBeat.o(152063);
      return;
      label84:
      this.DlU.j(params);
    }
  }
  
  public static final class a
  {
    private static final q DlX;
    
    static
    {
      AppMethodBeat.i(152057);
      DlX = new q((byte)0);
      AppMethodBeat.o(152057);
    }
  }
  
  static final class b
    implements Runnable
  {
    private final Runnable csS;
    
    private b(Runnable paramRunnable)
    {
      this.csS = paramRunnable;
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
        if (this.csS != null) {
          this.csS.run();
        }
        AppMethodBeat.o(152058);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.h.a.c.q
 * JD-Core Version:    0.7.0.1
 */