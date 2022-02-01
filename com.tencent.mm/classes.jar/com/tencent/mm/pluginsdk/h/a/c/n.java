package com.tencent.mm.pluginsdk.h.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bs;
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
  private final com.tencent.e.b DlM;
  protected final c DlN;
  
  public n(String paramString, c paramc)
  {
    this(paramString, paramc, (byte)0);
  }
  
  private n(String paramString, c paramc, byte paramByte)
  {
    AppMethodBeat.i(184268);
    this.DlM = new f.a(this, paramString, 4, 4, new c());
    this.DlN = paramc;
    AppMethodBeat.o(184268);
  }
  
  protected f.d a(l paraml)
  {
    AppMethodBeat.i(152044);
    ac.i("MicroMsg.ResDownloader.NetworkWorker", "request.class = " + paraml.getClass().getSimpleName());
    q.a.eMf();
    a locala = q.c(paraml);
    Object localObject = locala;
    if (locala == null)
    {
      ac.i("MicroMsg.ResDownloader.NetworkWorker", "get null handler from plugin, use default handler");
      localObject = new b(paraml);
    }
    ((a)localObject).DlQ = this.DlN;
    AppMethodBeat.o(152044);
    return localObject;
  }
  
  final void aGH(String paramString)
  {
    AppMethodBeat.i(152043);
    super.LJ(paramString);
    AppMethodBeat.o(152043);
  }
  
  protected int b(l paraml)
  {
    int j = 0;
    AppMethodBeat.i(152042);
    if ((aGF(paraml.Dkb)) || (aGE(paraml.Dkb)))
    {
      ac.i("MicroMsg.ResDownloader.NetworkWorker", "urlKey = %s is already queueing, skip repeated task", new Object[] { paraml.Dkb });
      AppMethodBeat.o(152042);
      return 0;
    }
    int i = ab.Yu();
    ac.i("MicroMsg.ResDownloader.NetworkWorker", "currentNetType(%d), requestNetType(%d)", new Object[] { Integer.valueOf(i), Integer.valueOf(paraml.networkType) });
    if (i != 0) {
      if (2 == paraml.networkType) {
        i = 1;
      }
    }
    while (i == 0)
    {
      ac.i("MicroMsg.ResDownloader.NetworkWorker", "urlKey = %s, mismatch networkType , skip task", new Object[] { paraml.Dkb });
      AppMethodBeat.o(152042);
      return 1;
      if (i == 1) {
        i = 1;
      } else {
        i = 0;
      }
    }
    if ((!this.DlM.isShutdown()) && (!this.DlM.isTerminated()))
    {
      i = this.DlM.JZk.get();
      if ((com.tencent.e.b.aet(i)) || (!com.tencent.e.b.kB(i, 1610612736))) {
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
  
  protected final com.tencent.e.b eLR()
  {
    return this.DlM;
  }
  
  public void shutdown()
  {
    AppMethodBeat.i(152045);
    this.DlM.shutdownNow();
    Iterator localIterator = this.Dlw.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (Future)this.Dlw.get(localObject);
      if (localObject != null) {
        ((Future)localObject).cancel(true);
      }
    }
    this.pendingRequests.clear();
    this.Dlw.clear();
    AppMethodBeat.o(152045);
  }
  
  public static abstract class a<Req extends l>
    extends f.d<Req>
    implements e
  {
    private static final ThreadLocal<j> DlO = new ThreadLocal() {};
    private final int Dkk;
    private final AtomicInteger DlP;
    public volatile c DlQ;
    
    protected a(Req paramReq)
    {
      super();
      this.Dkk = paramReq.Dkk;
      this.DlP = new AtomicInteger(this.Dkk);
    }
    
    public boolean aXd()
    {
      return false;
    }
    
    public boolean aXe()
    {
      return true;
    }
    
    public boolean aXf()
    {
      return false;
    }
    
    protected boolean aXg()
    {
      return true;
    }
    
    public boolean aXh()
    {
      if (this.DlP.decrementAndGet() > 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.DlQ.A(eLF(), this.Dkk, this.DlP.get());
        return bool;
      }
    }
    
    protected m b(j paramj)
    {
      if (!aXg()) {
        return j.a(this);
      }
      paramj = q.a.eMf().aGI(eLF());
      if (paramj != null)
      {
        paramj.field_status = 1;
        q.a.eMf().h(paramj);
      }
      return j.a(this);
    }
    
    public final String eLF()
    {
      return ((l)aXi()).Dkb;
    }
    
    public final String eLZ()
    {
      return "GET";
    }
    
    public final Collection<b> eMa()
    {
      Map localMap = ((l)aXi()).getRequestHeaders();
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
        if (!bs.isNullOrNil(str2)) {
          localLinkedList.add(new b(str1, str2));
        }
      }
      return localLinkedList;
    }
    
    public final int eMb()
    {
      return ((l)aXi()).eMb();
    }
    
    public final String eMc()
    {
      return "application/x-www-form-urlencoded;charset=utf-8";
    }
    
    public final int getConnectTimeout()
    {
      return ((l)aXi()).getConnectTimeout();
    }
    
    public final String getFilePath()
    {
      return ((l)aXi()).getFilePath();
    }
    
    public final int getReadTimeout()
    {
      return ((l)aXi()).getReadTimeout();
    }
    
    public String getURL()
    {
      return ((l)aXi()).url;
    }
    
    public boolean qG(long paramLong)
    {
      this.DlQ.H(eLF(), paramLong);
      long l = bh.eVQ();
      ac.i("MicroMsg.ResDownloader.NetworkWorker", "%s: get available size = %d", new Object[] { eLF(), Long.valueOf(l) });
      return l >= paramLong;
    }
    
    public final void run()
    {
      m localm = b((j)DlO.get());
      if (localm != null)
      {
        this.DlQ.a(this, localm);
        return;
      }
      ac.e("MicroMsg.ResDownloader.NetworkWorker", "groupId = %s, performer get null response", new Object[] { azp() });
    }
  }
  
  static final class b
    extends n.a<l>
  {
    b(l paraml)
    {
      super();
    }
    
    public final String azp()
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
    
    private static String ax(Runnable paramRunnable)
    {
      AppMethodBeat.i(152038);
      if ((paramRunnable instanceof f.c))
      {
        if ((((f.c)paramRunnable).Dly instanceof l))
        {
          paramRunnable = String.format("priority = %d, urlKey = %s", new Object[] { Integer.valueOf(((l)((f.c)paramRunnable).Dly).priority), ((f.c)paramRunnable).Dly.eLF() });
          AppMethodBeat.o(152038);
          return paramRunnable;
        }
        paramRunnable = String.format("unknown request = %s", new Object[] { ((f.c)paramRunnable).Dly });
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
 * Qualified Name:     com.tencent.mm.pluginsdk.h.a.c.n
 * JD-Core Version:    0.7.0.1
 */