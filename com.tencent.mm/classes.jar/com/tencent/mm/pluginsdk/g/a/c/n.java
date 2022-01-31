package com.tencent.mm.pluginsdk.g.a.c;

import com.tencent.mm.compatible.e.w;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class n
  extends f<l>
{
  private final f<l>.a rXF;
  public final c rXG;
  
  public n(u paramu, c paramc)
  {
    this(paramu, paramc, (byte)0);
  }
  
  private n(u paramu, c paramc, byte paramByte)
  {
    this.rXF = new f.a(this, 4, 4, 3000L, TimeUnit.MILLISECONDS, new n.c(), paramu);
    this.rXF.setKeepAliveTime(30000L, TimeUnit.MILLISECONDS);
    this.rXF.allowCoreThreadTimeOut(true);
    this.rXG = paramc;
  }
  
  public f.d a(l paraml)
  {
    y.i("MicroMsg.ResDownloader.NetworkWorker", "request.class = " + paraml.getClass().getSimpleName());
    q.a.clL();
    n.a locala = q.c(paraml);
    Object localObject = locala;
    if (locala == null)
    {
      y.i("MicroMsg.ResDownloader.NetworkWorker", "get null handler from plugin, use default handler");
      localObject = new n.b(paraml);
    }
    ((n.a)localObject).rXJ = this.rXG;
    return localObject;
  }
  
  public int b(l paraml)
  {
    int j = 0;
    if ((Wj(paraml.rVT)) || (isDownloading(paraml.rVT)))
    {
      y.i("MicroMsg.ResDownloader.NetworkWorker", "urlKey = %s is already queueing, skip repeated task", new Object[] { paraml.rVT });
      return 0;
    }
    int i = w.zx();
    y.i("MicroMsg.ResDownloader.NetworkWorker", "currentNetType(%d), requestNetType(%d)", new Object[] { Integer.valueOf(i), Integer.valueOf(paraml.networkType) });
    if (i != 0) {
      if (2 == paraml.networkType) {
        i = 1;
      }
    }
    while (i == 0)
    {
      y.i("MicroMsg.ResDownloader.NetworkWorker", "urlKey = %s, mismatch networkType , skip task", new Object[] { paraml.rVT });
      return 1;
      if (i == 1) {
        i = 1;
      } else {
        i = 0;
      }
    }
    if ((!this.rXF.isShutdown()) && (!this.rXF.isTerminated()))
    {
      i = j;
      if (!this.rXF.isTerminating()) {}
    }
    else
    {
      i = 1;
    }
    if (i != 0) {
      return 4;
    }
    super.b(paraml);
    return 2;
  }
  
  protected final f<l>.a clz()
  {
    return this.rXF;
  }
  
  public final boolean isDownloading(String paramString)
  {
    return this.rXp.containsKey(paramString);
  }
  
  public void shutdown()
  {
    this.rXF.shutdownNow();
    Iterator localIterator = this.rXp.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (Future)this.rXp.get(localObject);
      if (localObject != null) {
        ((Future)localObject).cancel(true);
      }
    }
    this.rXo.clear();
    this.rXp.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.c.n
 * JD-Core Version:    0.7.0.1
 */