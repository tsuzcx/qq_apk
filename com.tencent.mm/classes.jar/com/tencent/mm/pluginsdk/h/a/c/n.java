package com.tencent.mm.pluginsdk.h.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ab;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class n
  extends f<l>
{
  private final com.tencent.e.b BTw;
  protected final c BTx;
  
  public n(String paramString, c paramc)
  {
    this(paramString, paramc, (byte)0);
  }
  
  private n(String paramString, c paramc, byte paramByte)
  {
    AppMethodBeat.i(184268);
    this.BTw = new f.a(this, paramString, 4, 4, new c());
    this.BTx = paramc;
    AppMethodBeat.o(184268);
  }
  
  protected f.d a(l paraml)
  {
    AppMethodBeat.i(152044);
    ad.i("MicroMsg.ResDownloader.NetworkWorker", "request.class = " + paraml.getClass().getSimpleName());
    q.a.ewL();
    a locala = q.c(paraml);
    Object localObject = locala;
    if (locala == null)
    {
      ad.i("MicroMsg.ResDownloader.NetworkWorker", "get null handler from plugin, use default handler");
      localObject = new b(paraml);
    }
    ((a)localObject).BTA = this.BTx;
    AppMethodBeat.o(152044);
    return localObject;
  }
  
  final void aBp(String paramString)
  {
    AppMethodBeat.i(152043);
    super.HF(paramString);
    AppMethodBeat.o(152043);
  }
  
  protected int b(l paraml)
  {
    int j = 0;
    AppMethodBeat.i(152042);
    if ((aBn(paraml.BRL)) || (aBm(paraml.BRL)))
    {
      ad.i("MicroMsg.ResDownloader.NetworkWorker", "urlKey = %s is already queueing, skip repeated task", new Object[] { paraml.BRL });
      AppMethodBeat.o(152042);
      return 0;
    }
    int i = ab.Xx();
    ad.i("MicroMsg.ResDownloader.NetworkWorker", "currentNetType(%d), requestNetType(%d)", new Object[] { Integer.valueOf(i), Integer.valueOf(paraml.networkType) });
    if (i != 0) {
      if (2 == paraml.networkType) {
        i = 1;
      }
    }
    while (i == 0)
    {
      ad.i("MicroMsg.ResDownloader.NetworkWorker", "urlKey = %s, mismatch networkType , skip task", new Object[] { paraml.BRL });
      AppMethodBeat.o(152042);
      return 1;
      if (i == 1) {
        i = 1;
      } else {
        i = 0;
      }
    }
    if ((!this.BTw.isShutdown()) && (!this.BTw.isTerminated()))
    {
      i = this.BTw.IxB.get();
      if ((com.tencent.e.b.aca(i)) || (!com.tencent.e.b.ko(i, 1610612736))) {
        break label210;
      }
    }
    label210:
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        j = 1;
      }
      if (j == 0) {
        break;
      }
      AppMethodBeat.o(152042);
      return 4;
    }
    super.b(paraml);
    AppMethodBeat.o(152042);
    return 2;
  }
  
  protected final com.tencent.e.b ewx()
  {
    return this.BTw;
  }
  
  public void shutdown()
  {
    AppMethodBeat.i(152045);
    this.BTw.shutdownNow();
    Iterator localIterator = this.BTg.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (Future)this.BTg.get(localObject);
      if (localObject != null) {
        ((Future)localObject).cancel(true);
      }
    }
    this.pendingRequests.clear();
    this.BTg.clear();
    AppMethodBeat.o(152045);
  }
  
  public static abstract class a<Req extends l>
    extends f.d<Req>
    implements e
  {
    private static final ThreadLocal<j> BTy = new ThreadLocal() {};
    private final int BRU;
    public volatile c BTA;
    private final AtomicInteger BTz;
    
    protected a(Req paramReq)
    {
      super();
      this.BRU = paramReq.BRU;
      this.BTz = new AtomicInteger(this.BRU);
    }
    
    public boolean aQl()
    {
      return false;
    }
    
    public boolean aQm()
    {
      return true;
    }
    
    public boolean aQn()
    {
      return false;
    }
    
    protected boolean aQo()
    {
      return true;
    }
    
    public boolean aQp()
    {
      if (this.BTz.decrementAndGet() > 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.BTA.B(ewl(), this.BRU, this.BTz.get());
        return bool;
      }
    }
    
    protected m b(j paramj)
    {
      if (!aQo()) {
        return j.a(this);
      }
      paramj = q.a.ewL().aBq(ewl());
      if (paramj != null)
      {
        paramj.field_status = 1;
        q.a.ewL().h(paramj);
      }
      return j.a(this);
    }
    
    public final String ewF()
    {
      return "GET";
    }
    
    public final Collection<b> ewG()
    {
      Map localMap = ((l)aQq()).getRequestHeaders();
      if ((localMap == null) || (localMap.size() == 0)) {
        return null;
      }
      Object localObject = localMap.keySet();
      if ((localObject == null) || (((Set)localObject).size() == 0)) {
        return null;
      }
      LinkedList localLinkedList = new LinkedList();
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str1 = (String)((Iterator)localObject).next();
        String str2 = (String)localMap.get(str1);
        if (!bt.isNullOrNil(str2)) {
          localLinkedList.add(new b(str1, str2));
        }
      }
      return localLinkedList;
    }
    
    public final int ewH()
    {
      return ((l)aQq()).ewH();
    }
    
    public final String ewI()
    {
      return "application/x-www-form-urlencoded;charset=utf-8";
    }
    
    public final String ewl()
    {
      return ((l)aQq()).BRL;
    }
    
    public final int getConnectTimeout()
    {
      return ((l)aQq()).getConnectTimeout();
    }
    
    public final String getFilePath()
    {
      return ((l)aQq()).getFilePath();
    }
    
    public final int getReadTimeout()
    {
      return ((l)aQq()).getReadTimeout();
    }
    
    public String getURL()
    {
      return ((l)aQq()).url;
    }
    
    public boolean mR(long paramLong)
    {
      this.BTA.G(ewl(), paramLong);
      long l = bi.eGv();
      ad.i("MicroMsg.ResDownloader.NetworkWorker", "%s: get available size = %d", new Object[] { ewl(), Long.valueOf(l) });
      return l >= paramLong;
    }
    
    public final void run()
    {
      m localm = b((j)BTy.get());
      if (localm != null)
      {
        this.BTA.a(this, localm);
        return;
      }
      ad.e("MicroMsg.ResDownloader.NetworkWorker", "groupId = %s, performer get null response", new Object[] { asy() });
    }
  }
  
  static final class b
    extends n.a<l>
  {
    b(l paraml)
    {
      super();
    }
    
    public final String asy()
    {
      return "ResDownload";
    }
  }
  
  static final class c
    extends PriorityBlockingQueue<Runnable>
  {
    public c()
    {
      super(new Comparator() {});
      AppMethodBeat.i(152037);
      AppMethodBeat.o(152037);
    }
    
    private static String av(Runnable paramRunnable)
    {
      AppMethodBeat.i(152038);
      if ((paramRunnable instanceof f.c))
      {
        if ((((f.c)paramRunnable).BTi instanceof l))
        {
          paramRunnable = String.format("priority = %d, urlKey = %s", new Object[] { Integer.valueOf(((l)((f.c)paramRunnable).BTi).priority), ((f.c)paramRunnable).BTi.ewl() });
          AppMethodBeat.o(152038);
          return paramRunnable;
        }
        paramRunnable = String.format("unknown request = %s", new Object[] { ((f.c)paramRunnable).BTi });
        AppMethodBeat.o(152038);
        return paramRunnable;
      }
      paramRunnable = String.format("unknown runnable = %s", new Object[] { paramRunnable });
      AppMethodBeat.o(152038);
      return paramRunnable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.h.a.c.n
 * JD-Core Version:    0.7.0.1
 */