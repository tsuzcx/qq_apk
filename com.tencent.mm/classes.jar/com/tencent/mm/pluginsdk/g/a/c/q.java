package com.tencent.mm.pluginsdk.g.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Collection;
import java.util.Iterator;

public final class q
{
  private volatile al ftB;
  public final ak handler;
  public final boolean hsO;
  public final t vOE;
  public final n vOF;
  public final i vOG;
  
  private q()
  {
    AppMethodBeat.i(79615);
    this.ftB = null;
    r.init();
    this.vOE = t.dmB();
    if (this.vOE == null)
    {
      this.hsO = false;
      this.vOF = null;
      this.handler = null;
      this.vOG = null;
      AppMethodBeat.o(79615);
      return;
    }
    this.hsO = true;
    u localu = new u();
    this.handler = new al("ResDownloader-EventThread").caB();
    this.vOG = new i(aNS().caB());
    this.vOF = new n(localu, this.vOG);
    AppMethodBeat.o(79615);
  }
  
  static n.a c(l paraml)
  {
    AppMethodBeat.i(79619);
    ab.d("MicroMsg.ResDownloaderCore", "getNetworkRequestHandler");
    int i = paraml.avS().hashCode();
    Iterator localIterator = r.dmA().iterator();
    while (localIterator.hasNext())
    {
      g localg = (g)localIterator.next();
      ab.i("MicroMsg.ResDownloaderCore", "plugin = %s, groupId = %s", new Object[] { localg.getClass().getSimpleName(), localg.avS() });
      if (localg.avS().hashCode() == i)
      {
        paraml = localg.c(paraml);
        AppMethodBeat.o(79619);
        return paraml;
      }
    }
    AppMethodBeat.o(79619);
    return null;
  }
  
  public final void BI(String paramString)
  {
    AppMethodBeat.i(79624);
    if (this.hsO) {
      this.vOF.alP(paramString);
    }
    AppMethodBeat.o(79624);
  }
  
  public final void O(Runnable paramRunnable)
  {
    AppMethodBeat.i(79616);
    aNS().ac(new q.b(paramRunnable, (byte)0));
    AppMethodBeat.o(79616);
  }
  
  final al aNS()
  {
    AppMethodBeat.i(79617);
    if (this.ftB == null) {
      this.ftB = new al("ResDownloader-WorkerThread");
    }
    al localal = this.ftB;
    AppMethodBeat.o(79617);
    return localal;
  }
  
  public final s alQ(String paramString)
  {
    AppMethodBeat.i(79621);
    if (this.hsO)
    {
      long l = bo.aoy();
      s locals = this.vOE.alQ(paramString);
      if (locals == null) {}
      for (paramString = "null";; paramString = locals.field_urlKey)
      {
        ab.i("MicroMsg.ResDownloaderCore", "doQuery: urlKey = %s, cost = %d", new Object[] { paramString, Long.valueOf(bo.hl(l)) });
        AppMethodBeat.o(79621);
        return locals;
      }
    }
    AppMethodBeat.o(79621);
    return null;
  }
  
  public final boolean alR(String paramString)
  {
    AppMethodBeat.i(79623);
    if (this.hsO)
    {
      if ((this.vOF.alM(paramString)) || (this.vOF.alN(paramString)))
      {
        AppMethodBeat.o(79623);
        return true;
      }
      AppMethodBeat.o(79623);
      return false;
    }
    AppMethodBeat.o(79623);
    return false;
  }
  
  public final int d(l paraml)
  {
    AppMethodBeat.i(79622);
    if (this.hsO)
    {
      if (bo.isNullOrNil(paraml.url))
      {
        ab.i("MicroMsg.ResDownloaderCore", "request#%s with null url, ignore", new Object[] { paraml.vMK });
        AppMethodBeat.o(79622);
        return 3;
      }
      ab.i("MicroMsg.ResDownloaderCore", "request#%s post to network worker", new Object[] { paraml.vMK });
      int i = this.vOF.b(paraml);
      AppMethodBeat.o(79622);
      return i;
    }
    AppMethodBeat.o(79622);
    return -1;
  }
  
  public final void h(s params)
  {
    AppMethodBeat.i(79620);
    long l;
    if (this.hsO)
    {
      l = bo.aoy();
      if (this.vOE.alQ(params.field_urlKey) == null) {
        break label84;
      }
      this.vOE.i(params);
    }
    for (boolean bool = false;; bool = true)
    {
      ab.i("MicroMsg.ResDownloaderCore", "doUpdate: urlKey = %s, opIsInsert(%b) cost = %d", new Object[] { params.field_urlKey, Boolean.valueOf(bool), Long.valueOf(bo.hl(l)) });
      AppMethodBeat.o(79620);
      return;
      label84:
      this.vOE.j(params);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.c.q
 * JD-Core Version:    0.7.0.1
 */