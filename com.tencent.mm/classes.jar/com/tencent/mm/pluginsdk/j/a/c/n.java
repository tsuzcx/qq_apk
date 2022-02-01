package com.tencent.mm.pluginsdk.j.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ab;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.SdcardUtil;
import com.tencent.mm.sdk.platformtools.Util;
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
  private final com.tencent.f.b Kac;
  protected final c Kad;
  
  public n(String paramString, c paramc)
  {
    this(paramString, paramc, (byte)0);
  }
  
  private n(String paramString, c paramc, byte paramByte)
  {
    AppMethodBeat.i(184268);
    this.Kac = new f.a(this, paramString, 4, 4, new c());
    this.Kad = paramc;
    AppMethodBeat.o(184268);
  }
  
  protected f.d a(l paraml)
  {
    AppMethodBeat.i(152044);
    Log.i("MicroMsg.ResDownloader.NetworkWorker", "request.class = " + paraml.getClass().getSimpleName());
    q.a.goa();
    a locala = q.c(paraml);
    Object localObject = locala;
    if (locala == null)
    {
      Log.i("MicroMsg.ResDownloader.NetworkWorker", "get null handler from plugin, use default handler");
      localObject = new b(paraml);
    }
    ((a)localObject).Kag = this.Kad;
    AppMethodBeat.o(152044);
    return localObject;
  }
  
  protected int b(l paraml)
  {
    int j = 0;
    AppMethodBeat.i(152042);
    if ((bed(paraml.JYs)) || (bec(paraml.JYs)))
    {
      Log.i("MicroMsg.ResDownloader.NetworkWorker", "urlKey = %s is already queueing, skip repeated task", new Object[] { paraml.JYs });
      AppMethodBeat.o(152042);
      return 0;
    }
    int i = ab.ape();
    Log.i("MicroMsg.ResDownloader.NetworkWorker", "currentNetType(%d), requestNetType(%d)", new Object[] { Integer.valueOf(i), Integer.valueOf(paraml.networkType) });
    if (i != 0) {
      if (2 == paraml.networkType) {
        i = 1;
      }
    }
    while (i == 0)
    {
      Log.i("MicroMsg.ResDownloader.NetworkWorker", "urlKey = %s, mismatch networkType , skip task", new Object[] { paraml.JYs });
      AppMethodBeat.o(152042);
      return 1;
      if (i == 1) {
        i = 1;
      } else {
        i = 0;
      }
    }
    if ((!this.Kac.isShutdown()) && (!this.Kac.isTerminated()))
    {
      i = this.Kac.RSz.get();
      if ((com.tencent.f.b.aqP(i)) || (!com.tencent.f.b.mw(i, 1610612736))) {
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
  
  final void bef(String paramString)
  {
    AppMethodBeat.i(152043);
    super.Zb(paramString);
    AppMethodBeat.o(152043);
  }
  
  protected final com.tencent.f.b gnM()
  {
    return this.Kac;
  }
  
  public void shutdown()
  {
    AppMethodBeat.i(152045);
    this.Kac.shutdownNow();
    Iterator localIterator = this.JZN.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (Future)this.JZN.get(localObject);
      if (localObject != null) {
        ((Future)localObject).cancel(true);
      }
    }
    this.pendingRequests.clear();
    this.JZN.clear();
    AppMethodBeat.o(152045);
  }
  
  public static abstract class a<Req extends l>
    extends f.d<Req>
    implements e
  {
    private static final ThreadLocal<j> Kae = new ThreadLocal() {};
    private final int JYA;
    private final AtomicInteger Kaf;
    public volatile c Kag;
    
    protected a(Req paramReq)
    {
      super();
      this.JYA = paramReq.JYA;
      this.Kaf = new AtomicInteger(this.JYA);
    }
    
    public boolean AX(long paramLong)
    {
      this.Kag.O(gnA(), paramLong);
      long l = SdcardUtil.getAvailableExternalMemorySize2();
      Log.i("MicroMsg.ResDownloader.NetworkWorker", "%s: get available size = %d", new Object[] { gnA(), Long.valueOf(l) });
      return l >= paramLong;
    }
    
    protected m a(j paramj)
    {
      if (!bwr()) {
        return j.a(this);
      }
      paramj = q.a.goa().beg(gnA());
      if (paramj != null)
      {
        paramj.field_status = 1;
        q.a.goa().h(paramj);
      }
      return j.a(this);
    }
    
    public boolean bwo()
    {
      return false;
    }
    
    public boolean bwp()
    {
      return true;
    }
    
    public boolean bwq()
    {
      return false;
    }
    
    protected boolean bwr()
    {
      return true;
    }
    
    public boolean bws()
    {
      if (this.Kaf.decrementAndGet() > 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.Kag.C(gnA(), this.JYA, this.Kaf.get());
        return bool;
      }
    }
    
    public final int getConnectTimeout()
    {
      return ((l)bwt()).getConnectTimeout();
    }
    
    public final String getFilePath()
    {
      return ((l)bwt()).getFilePath();
    }
    
    public final int getReadTimeout()
    {
      return ((l)bwt()).getReadTimeout();
    }
    
    public String getURL()
    {
      return ((l)bwt()).url;
    }
    
    public final String gnA()
    {
      return ((l)bwt()).JYs;
    }
    
    public final String gnU()
    {
      return "GET";
    }
    
    public final Collection<b> gnV()
    {
      Map localMap = ((l)bwt()).getRequestHeaders();
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
        if (!Util.isNullOrNil(str2)) {
          localLinkedList.add(new b(str1, str2));
        }
      }
      return localLinkedList;
    }
    
    public final int gnW()
    {
      return ((l)bwt()).gnW();
    }
    
    public final String gnX()
    {
      return "application/x-www-form-urlencoded;charset=utf-8";
    }
    
    public final void run()
    {
      m localm = a((j)Kae.get());
      if (localm != null)
      {
        this.Kag.a(this, localm);
        return;
      }
      Log.e("MicroMsg.ResDownloader.NetworkWorker", "groupId = %s, performer get null response", new Object[] { avy() });
    }
  }
  
  static final class b
    extends n.a<l>
  {
    b(l paraml)
    {
      super();
    }
    
    public final String avy()
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
    
    private static String aF(Runnable paramRunnable)
    {
      AppMethodBeat.i(152038);
      if ((paramRunnable instanceof f.c))
      {
        if ((((f.c)paramRunnable).JZP instanceof l))
        {
          paramRunnable = String.format("priority = %d, urlKey = %s", new Object[] { Integer.valueOf(((l)((f.c)paramRunnable).JZP).priority), ((f.c)paramRunnable).JZP.gnA() });
          AppMethodBeat.o(152038);
          return paramRunnable;
        }
        paramRunnable = String.format("unknown request = %s", new Object[] { ((f.c)paramRunnable).JZP });
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
 * Qualified Name:     com.tencent.mm.pluginsdk.j.a.c.n
 * JD-Core Version:    0.7.0.1
 */