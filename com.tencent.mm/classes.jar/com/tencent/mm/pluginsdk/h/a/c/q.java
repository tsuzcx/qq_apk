package com.tencent.mm.pluginsdk.h.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Collection;
import java.util.Iterator;

public final class q
{
  public final t BTE;
  public final n BTF;
  public final i BTG;
  private volatile ap cHo;
  public final ap handler;
  public final boolean jqw;
  
  private q()
  {
    AppMethodBeat.i(152059);
    this.cHo = null;
    r.init();
    this.BTE = t.ewN();
    if (this.BTE == null)
    {
      this.jqw = false;
      this.BTF = null;
      this.handler = null;
      this.BTG = null;
      AppMethodBeat.o(152059);
      return;
    }
    this.jqw = true;
    this.handler = new ap("ResDownloader-EventThread");
    this.BTG = new i(bNl());
    this.BTF = new n("ResDownloader-EventThread", this.BTG);
    AppMethodBeat.o(152059);
  }
  
  static n.a c(l paraml)
  {
    AppMethodBeat.i(152062);
    ad.d("MicroMsg.ResDownloaderCore", "getNetworkRequestHandler");
    int i = paraml.asy().hashCode();
    Iterator localIterator = r.ewM().iterator();
    while (localIterator.hasNext())
    {
      g localg = (g)localIterator.next();
      ad.i("MicroMsg.ResDownloaderCore", "plugin = %s, groupId = %s", new Object[] { localg.getClass().getSimpleName(), localg.asy() });
      if (localg.asy().hashCode() == i)
      {
        paraml = localg.c(paraml);
        AppMethodBeat.o(152062);
        return paraml;
      }
    }
    AppMethodBeat.o(152062);
    return null;
  }
  
  public final void HF(String paramString)
  {
    AppMethodBeat.i(152067);
    if (this.jqw) {
      this.BTF.aBp(paramString);
    }
    AppMethodBeat.o(152067);
  }
  
  public final s aBq(String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(152064);
    if (this.jqw)
    {
      long l = bt.eGO();
      s locals = this.BTE.aBq(paramString);
      if (locals != null) {
        bool = true;
      }
      ad.i("MicroMsg.ResDownloaderCore", "doQuery: urlKey = %s, ret = %b, cost = %d", new Object[] { paramString, Boolean.valueOf(bool), Long.valueOf(bt.vM(l)) });
      AppMethodBeat.o(152064);
      return locals;
    }
    AppMethodBeat.o(152064);
    return null;
  }
  
  public final boolean aBr(String paramString)
  {
    AppMethodBeat.i(152066);
    if (this.jqw)
    {
      if ((this.BTF.aBm(paramString)) || (this.BTF.aBn(paramString)))
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
  
  public final void ae(Runnable paramRunnable)
  {
    AppMethodBeat.i(152060);
    bNl().postToWorker(new q.b(paramRunnable, (byte)0));
    AppMethodBeat.o(152060);
  }
  
  final ap bNl()
  {
    AppMethodBeat.i(184269);
    if (this.cHo == null)
    {
      this.cHo = new ap("ResDownloader-WorkerThread");
      this.cHo.setLogging(false);
    }
    ap localap = this.cHo;
    AppMethodBeat.o(184269);
    return localap;
  }
  
  public final int d(l paraml)
  {
    AppMethodBeat.i(152065);
    if (this.jqw)
    {
      if (bt.isNullOrNil(paraml.url))
      {
        ad.i("MicroMsg.ResDownloaderCore", "request#%s with null url, ignore", new Object[] { paraml.BRL });
        AppMethodBeat.o(152065);
        return 3;
      }
      ad.i("MicroMsg.ResDownloaderCore", "request#%s post to network worker", new Object[] { paraml.BRL });
      int i = this.BTF.b(paraml);
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
    if (this.jqw)
    {
      l = bt.eGO();
      if (this.BTE.aBq(params.field_urlKey) == null) {
        break label84;
      }
      this.BTE.i(params);
    }
    for (boolean bool = false;; bool = true)
    {
      ad.i("MicroMsg.ResDownloaderCore", "doUpdate: urlKey = %s, opIsInsert(%b) cost = %d", new Object[] { params.field_urlKey, Boolean.valueOf(bool), Long.valueOf(bt.vM(l)) });
      AppMethodBeat.o(152063);
      return;
      label84:
      this.BTE.j(params);
    }
  }
  
  public static final class a
  {
    private static final q BTH;
    
    static
    {
      AppMethodBeat.i(152057);
      BTH = new q((byte)0);
      AppMethodBeat.o(152057);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.h.a.c.q
 * JD-Core Version:    0.7.0.1
 */