package com.tencent.mm.pluginsdk.j.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.bu;
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
  private final com.tencent.e.b Fjj;
  protected final c Fjk;
  
  public n(String paramString, c paramc)
  {
    this(paramString, paramc, (byte)0);
  }
  
  private n(String paramString, c paramc, byte paramByte)
  {
    AppMethodBeat.i(184268);
    this.Fjj = new f.a(this, paramString, 4, 4, new c());
    this.Fjk = paramc;
    AppMethodBeat.o(184268);
  }
  
  protected f.d a(l paraml)
  {
    AppMethodBeat.i(152044);
    ae.i("MicroMsg.ResDownloader.NetworkWorker", "request.class = " + paraml.getClass().getSimpleName());
    q.a.feQ();
    a locala = q.c(paraml);
    Object localObject = locala;
    if (locala == null)
    {
      ae.i("MicroMsg.ResDownloader.NetworkWorker", "get null handler from plugin, use default handler");
      localObject = new b(paraml);
    }
    ((a)localObject).Fjn = this.Fjk;
    AppMethodBeat.o(152044);
    return localObject;
  }
  
  final void aND(String paramString)
  {
    AppMethodBeat.i(152043);
    super.PL(paramString);
    AppMethodBeat.o(152043);
  }
  
  protected int b(l paraml)
  {
    int j = 0;
    AppMethodBeat.i(152042);
    if ((aNB(paraml.Fhz)) || (aNA(paraml.Fhz)))
    {
      ae.i("MicroMsg.ResDownloader.NetworkWorker", "urlKey = %s is already queueing, skip repeated task", new Object[] { paraml.Fhz });
      AppMethodBeat.o(152042);
      return 0;
    }
    int i = ab.abf();
    ae.i("MicroMsg.ResDownloader.NetworkWorker", "currentNetType(%d), requestNetType(%d)", new Object[] { Integer.valueOf(i), Integer.valueOf(paraml.networkType) });
    if (i != 0) {
      if (2 == paraml.networkType) {
        i = 1;
      }
    }
    while (i == 0)
    {
      ae.i("MicroMsg.ResDownloader.NetworkWorker", "urlKey = %s, mismatch networkType , skip task", new Object[] { paraml.Fhz });
      AppMethodBeat.o(152042);
      return 1;
      if (i == 1) {
        i = 1;
      } else {
        i = 0;
      }
    }
    if ((!this.Fjj.isShutdown()) && (!this.Fjj.isTerminated()))
    {
      i = this.Fjj.Mqc.get();
      if ((com.tencent.e.b.ahC(i)) || (!com.tencent.e.b.kX(i, 1610612736))) {
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
  
  protected final com.tencent.e.b feC()
  {
    return this.Fjj;
  }
  
  public void shutdown()
  {
    AppMethodBeat.i(152045);
    this.Fjj.shutdownNow();
    Iterator localIterator = this.FiT.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (Future)this.FiT.get(localObject);
      if (localObject != null) {
        ((Future)localObject).cancel(true);
      }
    }
    this.pendingRequests.clear();
    this.FiT.clear();
    AppMethodBeat.o(152045);
  }
  
  public static abstract class a<Req extends l>
    extends f.d<Req>
    implements e
  {
    private static final ThreadLocal<j> Fjl = new ThreadLocal() {};
    private final int FhH;
    private final AtomicInteger Fjm;
    public volatile c Fjn;
    
    protected a(Req paramReq)
    {
      super();
      this.FhH = paramReq.FhH;
      this.Fjm = new AtomicInteger(this.FhH);
    }
    
    protected m b(j paramj)
    {
      if (!bbd()) {
        return j.a(this);
      }
      paramj = q.a.feQ().aNE(feq());
      if (paramj != null)
      {
        paramj.field_status = 1;
        q.a.feQ().h(paramj);
      }
      return j.a(this);
    }
    
    public boolean bba()
    {
      return false;
    }
    
    public boolean bbb()
    {
      return true;
    }
    
    public boolean bbc()
    {
      return false;
    }
    
    protected boolean bbd()
    {
      return true;
    }
    
    public boolean bbe()
    {
      if (this.Fjm.decrementAndGet() > 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.Fjn.C(feq(), this.FhH, this.Fjm.get());
        return bool;
      }
    }
    
    public final String feK()
    {
      return "GET";
    }
    
    public final Collection<b> feL()
    {
      Map localMap = ((l)bbf()).getRequestHeaders();
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
        if (!bu.isNullOrNil(str2)) {
          localLinkedList.add(new b(str1, str2));
        }
      }
      return localLinkedList;
    }
    
    public final int feM()
    {
      return ((l)bbf()).feM();
    }
    
    public final String feN()
    {
      return "application/x-www-form-urlencoded;charset=utf-8";
    }
    
    public final String feq()
    {
      return ((l)bbf()).Fhz;
    }
    
    public final int getConnectTimeout()
    {
      return ((l)bbf()).getConnectTimeout();
    }
    
    public final String getFilePath()
    {
      return ((l)bbf()).getFilePath();
    }
    
    public final int getReadTimeout()
    {
      return ((l)bbf()).getReadTimeout();
    }
    
    public String getURL()
    {
      return ((l)bbf()).url;
    }
    
    public final void run()
    {
      m localm = b((j)Fjl.get());
      if (localm != null)
      {
        this.Fjn.a(this, localm);
        return;
      }
      ae.e("MicroMsg.ResDownloader.NetworkWorker", "groupId = %s, performer get null response", new Object[] { afK() });
    }
    
    public boolean sR(long paramLong)
    {
      this.Fjn.O(feq(), paramLong);
      long l = bj.fpv();
      ae.i("MicroMsg.ResDownloader.NetworkWorker", "%s: get available size = %d", new Object[] { feq(), Long.valueOf(l) });
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
    
    public final String afK()
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
    
    private static String au(Runnable paramRunnable)
    {
      AppMethodBeat.i(152038);
      if ((paramRunnable instanceof f.c))
      {
        if ((((f.c)paramRunnable).FiV instanceof l))
        {
          paramRunnable = String.format("priority = %d, urlKey = %s", new Object[] { Integer.valueOf(((l)((f.c)paramRunnable).FiV).priority), ((f.c)paramRunnable).FiV.feq() });
          AppMethodBeat.o(152038);
          return paramRunnable;
        }
        paramRunnable = String.format("unknown request = %s", new Object[] { ((f.c)paramRunnable).FiV });
        AppMethodBeat.o(152038);
        return paramRunnable;
      }
      paramRunnable = String.format("unknown runnable = %s", new Object[] { paramRunnable });
      AppMethodBeat.o(152038);
      return paramRunnable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.a.c.n
 * JD-Core Version:    0.7.0.1
 */