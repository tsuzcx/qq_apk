package com.tencent.mm.pluginsdk.j.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Collection;
import java.util.Iterator;

public final class q
{
  public final t Fjr;
  public final n Fjs;
  public final i Fjt;
  private volatile aq cQl;
  public final aq handler;
  public final boolean kot;
  
  private q()
  {
    AppMethodBeat.i(152059);
    this.cQl = null;
    r.init();
    this.Fjr = t.feS();
    if (this.Fjr == null)
    {
      this.kot = false;
      this.Fjs = null;
      this.handler = null;
      this.Fjt = null;
      AppMethodBeat.o(152059);
      return;
    }
    this.kot = true;
    this.handler = new aq("ResDownloader-EventThread");
    this.Fjt = new i(caq());
    this.Fjs = new n("ResDownloader-EventThread", this.Fjt);
    AppMethodBeat.o(152059);
  }
  
  static n.a c(l paraml)
  {
    AppMethodBeat.i(152062);
    ae.d("MicroMsg.ResDownloaderCore", "getNetworkRequestHandler");
    int i = paraml.afK().hashCode();
    Iterator localIterator = r.feR().iterator();
    while (localIterator.hasNext())
    {
      g localg = (g)localIterator.next();
      ae.i("MicroMsg.ResDownloaderCore", "plugin = %s, groupId = %s", new Object[] { localg.getClass().getSimpleName(), localg.afK() });
      if (localg.afK().hashCode() == i)
      {
        paraml = localg.c(paraml);
        AppMethodBeat.o(152062);
        return paraml;
      }
    }
    AppMethodBeat.o(152062);
    return null;
  }
  
  public final void PL(String paramString)
  {
    AppMethodBeat.i(152067);
    if (this.kot) {
      this.Fjs.aND(paramString);
    }
    AppMethodBeat.o(152067);
  }
  
  public final s aNE(String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(152064);
    if (this.kot)
    {
      long l = bu.fpO();
      s locals = this.Fjr.aNE(paramString);
      if (locals != null) {
        bool = true;
      }
      ae.i("MicroMsg.ResDownloaderCore", "doQuery: urlKey = %s, ret = %b, cost = %d", new Object[] { paramString, Boolean.valueOf(bool), Long.valueOf(bu.DD(l)) });
      AppMethodBeat.o(152064);
      return locals;
    }
    AppMethodBeat.o(152064);
    return null;
  }
  
  public final boolean aNF(String paramString)
  {
    AppMethodBeat.i(152066);
    if (this.kot)
    {
      if ((this.Fjs.aNA(paramString)) || (this.Fjs.aNB(paramString)))
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
  
  public final void ad(Runnable paramRunnable)
  {
    AppMethodBeat.i(152060);
    caq().postToWorker(new q.b(paramRunnable, (byte)0));
    AppMethodBeat.o(152060);
  }
  
  final aq caq()
  {
    AppMethodBeat.i(184269);
    if (this.cQl == null)
    {
      this.cQl = new aq("ResDownloader-WorkerThread");
      this.cQl.setLogging(false);
    }
    aq localaq = this.cQl;
    AppMethodBeat.o(184269);
    return localaq;
  }
  
  public final int d(l paraml)
  {
    AppMethodBeat.i(152065);
    if (this.kot)
    {
      if (bu.isNullOrNil(paraml.url))
      {
        ae.i("MicroMsg.ResDownloaderCore", "request#%s with null url, ignore", new Object[] { paraml.Fhz });
        AppMethodBeat.o(152065);
        return 3;
      }
      ae.i("MicroMsg.ResDownloaderCore", "request#%s post to network worker", new Object[] { paraml.Fhz });
      int i = this.Fjs.b(paraml);
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
    if (this.kot)
    {
      l = bu.fpO();
      if (this.Fjr.aNE(params.field_urlKey) == null) {
        break label84;
      }
      this.Fjr.i(params);
    }
    for (boolean bool = false;; bool = true)
    {
      ae.i("MicroMsg.ResDownloaderCore", "doUpdate: urlKey = %s, opIsInsert(%b) cost = %d", new Object[] { params.field_urlKey, Boolean.valueOf(bool), Long.valueOf(bu.DD(l)) });
      AppMethodBeat.o(152063);
      return;
      label84:
      this.Fjr.j(params);
    }
  }
  
  public static final class a
  {
    private static final q Fju;
    
    static
    {
      AppMethodBeat.i(152057);
      Fju = new q((byte)0);
      AppMethodBeat.o(152057);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.a.c.q
 * JD-Core Version:    0.7.0.1
 */