package com.tencent.mm.pluginsdk.g.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.z;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class n
  extends f<l>
{
  private final f<l>.a vOw;
  protected final c vOx;
  
  public n(u paramu, c paramc)
  {
    this(paramu, paramc, (byte)0);
  }
  
  private n(u paramu, c paramc, byte paramByte)
  {
    AppMethodBeat.i(79597);
    this.vOw = new f.a(this, 4, 4, 3000L, TimeUnit.MILLISECONDS, new n.c(), paramu);
    this.vOw.setKeepAliveTime(30000L, TimeUnit.MILLISECONDS);
    this.vOw.allowCoreThreadTimeOut(true);
    this.vOx = paramc;
    AppMethodBeat.o(79597);
  }
  
  protected f.d a(l paraml)
  {
    AppMethodBeat.i(79600);
    ab.i("MicroMsg.ResDownloader.NetworkWorker", "request.class = " + paraml.getClass().getSimpleName());
    q.a.dmz();
    n.a locala = q.c(paraml);
    Object localObject = locala;
    if (locala == null)
    {
      ab.i("MicroMsg.ResDownloader.NetworkWorker", "get null handler from plugin, use default handler");
      localObject = new n.b(paraml);
    }
    ((n.a)localObject).vOA = this.vOx;
    AppMethodBeat.o(79600);
    return localObject;
  }
  
  final void alP(String paramString)
  {
    AppMethodBeat.i(79599);
    Future localFuture = (Future)this.vOg.remove(paramString);
    if (localFuture != null) {
      localFuture.cancel(true);
    }
    this.pendingRequests.remove(paramString);
    AppMethodBeat.o(79599);
  }
  
  protected int b(l paraml)
  {
    int j = 0;
    AppMethodBeat.i(79598);
    if ((alN(paraml.vMK)) || (alM(paraml.vMK)))
    {
      ab.i("MicroMsg.ResDownloader.NetworkWorker", "urlKey = %s is already queueing, skip repeated task", new Object[] { paraml.vMK });
      AppMethodBeat.o(79598);
      return 0;
    }
    int i = z.LZ();
    ab.i("MicroMsg.ResDownloader.NetworkWorker", "currentNetType(%d), requestNetType(%d)", new Object[] { Integer.valueOf(i), Integer.valueOf(paraml.networkType) });
    if (i != 0) {
      if (2 == paraml.networkType) {
        i = 1;
      }
    }
    while (i == 0)
    {
      ab.i("MicroMsg.ResDownloader.NetworkWorker", "urlKey = %s, mismatch networkType , skip task", new Object[] { paraml.vMK });
      AppMethodBeat.o(79598);
      return 1;
      if (i == 1) {
        i = 1;
      } else {
        i = 0;
      }
    }
    if ((!this.vOw.isShutdown()) && (!this.vOw.isTerminated()))
    {
      i = j;
      if (!this.vOw.isTerminating()) {}
    }
    else
    {
      i = 1;
    }
    if (i != 0)
    {
      AppMethodBeat.o(79598);
      return 4;
    }
    super.b(paraml);
    AppMethodBeat.o(79598);
    return 2;
  }
  
  protected final f<l>.a dml()
  {
    return this.vOw;
  }
  
  public void shutdown()
  {
    AppMethodBeat.i(79601);
    this.vOw.shutdownNow();
    Iterator localIterator = this.vOg.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (Future)this.vOg.get(localObject);
      if (localObject != null) {
        ((Future)localObject).cancel(true);
      }
    }
    this.pendingRequests.clear();
    this.vOg.clear();
    AppMethodBeat.o(79601);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.c.n
 * JD-Core Version:    0.7.0.1
 */