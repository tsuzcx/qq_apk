package com.tencent.mm.pluginsdk.j.a.c;

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
  private final com.tencent.e.b EQO;
  protected final c EQP;
  
  public n(String paramString, c paramc)
  {
    this(paramString, paramc, (byte)0);
  }
  
  private n(String paramString, c paramc, byte paramByte)
  {
    AppMethodBeat.i(184268);
    this.EQO = new f.a(this, paramString, 4, 4, new c());
    this.EQP = paramc;
    AppMethodBeat.o(184268);
  }
  
  protected f.d a(l paraml)
  {
    AppMethodBeat.i(152044);
    ad.i("MicroMsg.ResDownloader.NetworkWorker", "request.class = " + paraml.getClass().getSimpleName());
    q.a.fbc();
    a locala = q.c(paraml);
    Object localObject = locala;
    if (locala == null)
    {
      ad.i("MicroMsg.ResDownloader.NetworkWorker", "get null handler from plugin, use default handler");
      localObject = new b(paraml);
    }
    ((a)localObject).EQS = this.EQP;
    AppMethodBeat.o(152044);
    return localObject;
  }
  
  final void aMh(String paramString)
  {
    AppMethodBeat.i(152043);
    super.Pd(paramString);
    AppMethodBeat.o(152043);
  }
  
  protected int b(l paraml)
  {
    int j = 0;
    AppMethodBeat.i(152042);
    if ((aMf(paraml.EPe)) || (aMe(paraml.EPe)))
    {
      ad.i("MicroMsg.ResDownloader.NetworkWorker", "urlKey = %s is already queueing, skip repeated task", new Object[] { paraml.EPe });
      AppMethodBeat.o(152042);
      return 0;
    }
    int i = ab.aaW();
    ad.i("MicroMsg.ResDownloader.NetworkWorker", "currentNetType(%d), requestNetType(%d)", new Object[] { Integer.valueOf(i), Integer.valueOf(paraml.networkType) });
    if (i != 0) {
      if (2 == paraml.networkType) {
        i = 1;
      }
    }
    while (i == 0)
    {
      ad.i("MicroMsg.ResDownloader.NetworkWorker", "urlKey = %s, mismatch networkType , skip task", new Object[] { paraml.EPe });
      AppMethodBeat.o(152042);
      return 1;
      if (i == 1) {
        i = 1;
      } else {
        i = 0;
      }
    }
    if ((!this.EQO.isShutdown()) && (!this.EQO.isTerminated()))
    {
      i = this.EQO.LTf.get();
      if ((com.tencent.e.b.agT(i)) || (!com.tencent.e.b.kQ(i, 1610612736))) {
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
  
  protected final com.tencent.e.b faO()
  {
    return this.EQO;
  }
  
  public void shutdown()
  {
    AppMethodBeat.i(152045);
    this.EQO.shutdownNow();
    Iterator localIterator = this.EQy.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (Future)this.EQy.get(localObject);
      if (localObject != null) {
        ((Future)localObject).cancel(true);
      }
    }
    this.pendingRequests.clear();
    this.EQy.clear();
    AppMethodBeat.o(152045);
  }
  
  public static abstract class a<Req extends l>
    extends f.d<Req>
    implements e
  {
    private static final ThreadLocal<j> EQQ = new ThreadLocal() {};
    private final int EPm;
    private final AtomicInteger EQR;
    public volatile c EQS;
    
    protected a(Req paramReq)
    {
      super();
      this.EPm = paramReq.EPm;
      this.EQR = new AtomicInteger(this.EPm);
    }
    
    protected m b(j paramj)
    {
      if (!baE()) {
        return j.a(this);
      }
      paramj = q.a.fbc().aMi(faC());
      if (paramj != null)
      {
        paramj.field_status = 1;
        q.a.fbc().h(paramj);
      }
      return j.a(this);
    }
    
    public boolean baB()
    {
      return false;
    }
    
    public boolean baC()
    {
      return true;
    }
    
    public boolean baD()
    {
      return false;
    }
    
    protected boolean baE()
    {
      return true;
    }
    
    public boolean baF()
    {
      if (this.EQR.decrementAndGet() > 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.EQS.C(faC(), this.EPm, this.EQR.get());
        return bool;
      }
    }
    
    public final String faC()
    {
      return ((l)baG()).EPe;
    }
    
    public final String faW()
    {
      return "GET";
    }
    
    public final Collection<b> faX()
    {
      Map localMap = ((l)baG()).getRequestHeaders();
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
    
    public final int faY()
    {
      return ((l)baG()).faY();
    }
    
    public final String faZ()
    {
      return "application/x-www-form-urlencoded;charset=utf-8";
    }
    
    public final int getConnectTimeout()
    {
      return ((l)baG()).getConnectTimeout();
    }
    
    public final String getFilePath()
    {
      return ((l)baG()).getFilePath();
    }
    
    public final int getReadTimeout()
    {
      return ((l)baG()).getReadTimeout();
    }
    
    public String getURL()
    {
      return ((l)baG()).url;
    }
    
    public final void run()
    {
      m localm = b((j)EQQ.get());
      if (localm != null)
      {
        this.EQS.a(this, localm);
        return;
      }
      ad.e("MicroMsg.ResDownloader.NetworkWorker", "groupId = %s, performer get null response", new Object[] { afw() });
    }
    
    public boolean sE(long paramLong)
    {
      this.EQS.O(faC(), paramLong);
      long l = bi.flA();
      ad.i("MicroMsg.ResDownloader.NetworkWorker", "%s: get available size = %d", new Object[] { faC(), Long.valueOf(l) });
      return l >= paramLong;
    }
  }
  
  static final class b
    extends n.a<l>
  {
    b(l paraml)
    {
      super();
    }
    
    public final String afw()
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
    
    private static String aw(Runnable paramRunnable)
    {
      AppMethodBeat.i(152038);
      if ((paramRunnable instanceof f.c))
      {
        if ((((f.c)paramRunnable).EQA instanceof l))
        {
          paramRunnable = String.format("priority = %d, urlKey = %s", new Object[] { Integer.valueOf(((l)((f.c)paramRunnable).EQA).priority), ((f.c)paramRunnable).EQA.faC() });
          AppMethodBeat.o(152038);
          return paramRunnable;
        }
        paramRunnable = String.format("unknown request = %s", new Object[] { ((f.c)paramRunnable).EQA });
        AppMethodBeat.o(152038);
        return paramRunnable;
      }
      paramRunnable = String.format("unknown runnable = %s", new Object[] { paramRunnable });
      AppMethodBeat.o(152038);
      return paramRunnable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.a.c.n
 * JD-Core Version:    0.7.0.1
 */