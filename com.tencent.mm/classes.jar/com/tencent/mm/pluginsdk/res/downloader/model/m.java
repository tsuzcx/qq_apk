package com.tencent.mm.pluginsdk.res.downloader.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ac;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.SdcardUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class m
  extends f<k>
{
  private final com.tencent.threadpool.b XWK;
  private final c XWL;
  
  public m(String paramString, c paramc)
  {
    this(paramString, paramc, (byte)0);
  }
  
  private m(String paramString, c paramc, byte paramByte)
  {
    AppMethodBeat.i(184268);
    this.XWK = new f.a(this, paramString, 4, 4, new c());
    this.XWL = paramc;
    AppMethodBeat.o(184268);
  }
  
  protected f.d a(k paramk)
  {
    AppMethodBeat.i(152044);
    Log.i("MicroMsg.ResDownloader.NetworkWorker", "request.class = " + paramk.getClass().getSimpleName());
    p.a.iJK();
    a locala = p.c(paramk);
    Object localObject = locala;
    if (locala == null)
    {
      Log.i("MicroMsg.ResDownloader.NetworkWorker", "get null handler from plugin, use default handler");
      localObject = new b(paramk);
    }
    ((a)localObject).XWO = this.XWL;
    AppMethodBeat.o(152044);
    return localObject;
  }
  
  protected int b(k paramk)
  {
    int j = 0;
    AppMethodBeat.i(152042);
    if ((bqn(paramk.XUX)) || (bqm(paramk.XUX)))
    {
      Log.i("MicroMsg.ResDownloader.NetworkWorker", "urlKey = %s is already queueing, skip repeated task", new Object[] { paramk.XUX });
      AppMethodBeat.o(152042);
      return 0;
    }
    int i = ac.aPK();
    Log.i("MicroMsg.ResDownloader.NetworkWorker", "currentNetType(%d), requestNetType(%d)", new Object[] { Integer.valueOf(i), Integer.valueOf(paramk.networkType) });
    if (i != 0) {
      if (2 == paramk.networkType) {
        i = 1;
      }
    }
    while (i == 0)
    {
      Log.i("MicroMsg.ResDownloader.NetworkWorker", "urlKey = %s, mismatch networkType , skip task", new Object[] { paramk.XUX });
      AppMethodBeat.o(152042);
      return 1;
      if (i == 1) {
        i = 1;
      } else {
        i = 0;
      }
    }
    if ((!this.XWK.isShutdown()) && (!this.XWK.isTerminated()))
    {
      i = this.XWK.ahzX.get();
      if ((com.tencent.threadpool.b.aHo(i)) || (!com.tencent.threadpool.b.pK(i, 1610612736))) {
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
    super.b(paramk);
    AppMethodBeat.o(152042);
    return 2;
  }
  
  final void bqp(String paramString)
  {
    AppMethodBeat.i(152043);
    super.ZJ(paramString);
    AppMethodBeat.o(152043);
  }
  
  protected final c iJI()
  {
    return this.XWL;
  }
  
  protected final com.tencent.threadpool.b iJs()
  {
    return this.XWK;
  }
  
  public void shutdown()
  {
    AppMethodBeat.i(152045);
    this.XWK.shutdownNow();
    cancelAll();
    AppMethodBeat.o(152045);
  }
  
  public static abstract class a<Req extends k>
    extends f.d<Req>
    implements e
  {
    private static final ThreadLocal<j> XWM = new m.a.1();
    private final int XVf;
    private final AtomicInteger XWN;
    public volatile c XWO;
    
    protected a(Req paramReq)
    {
      super();
      this.XVf = paramReq.XVf;
      this.XWN = new AtomicInteger(this.XVf);
    }
    
    protected l a(j paramj)
    {
      if (!cgV()) {
        return j.a(this);
      }
      paramj = p.a.iJK().bqq(iJd());
      if (paramj != null)
      {
        paramj.field_status = 1;
        p.a.iJK().h(paramj);
      }
      return j.a(this);
    }
    
    public String cgR()
    {
      return ((k)cgY()).url;
    }
    
    public boolean cgS()
    {
      return false;
    }
    
    public boolean cgT()
    {
      return true;
    }
    
    public boolean cgU()
    {
      return false;
    }
    
    protected boolean cgV()
    {
      return true;
    }
    
    public boolean cgW()
    {
      return true;
    }
    
    public boolean cgX()
    {
      if (this.XWN.decrementAndGet() > 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.XWO.G(iJd(), this.XVf, this.XWN.get());
        return bool;
      }
    }
    
    public final String getFilePath()
    {
      return ((k)cgY()).getFilePath();
    }
    
    public final String iJA()
    {
      return "GET";
    }
    
    public final Collection<b> iJB()
    {
      Map localMap = ((k)cgY()).getRequestHeaders();
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
    
    public final int iJC()
    {
      return ((k)cgY()).iJC();
    }
    
    public final int iJD()
    {
      return ((k)cgY()).iJD();
    }
    
    public final int iJE()
    {
      return ((k)cgY()).iJE();
    }
    
    public final byte[] iJF()
    {
      return null;
    }
    
    public final String iJG()
    {
      return "application/x-www-form-urlencoded;charset=utf-8";
    }
    
    public final String iJd()
    {
      return ((k)cgY()).XUX;
    }
    
    public boolean jz(long paramLong)
    {
      this.XWO.T(iJd(), paramLong);
      long l = SdcardUtil.getAvailableExternalMemorySize2();
      Log.i("MicroMsg.ResDownloader.NetworkWorker", "%s: get available size = %d", new Object[] { iJd(), Long.valueOf(l) });
      return l >= paramLong;
    }
    
    public final void run()
    {
      l locall = a((j)XWM.get());
      if (locall != null)
      {
        this.XWO.a(this, locall);
        return;
      }
      Log.e("MicroMsg.ResDownloader.NetworkWorker", "groupId = %s, performer get null response", new Object[] { aVp() });
    }
  }
  
  static final class b
    extends m.a<k>
  {
    b(k paramk)
    {
      super();
    }
    
    public final String aVp()
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
    
    private static String aU(Runnable paramRunnable)
    {
      AppMethodBeat.i(152038);
      if ((paramRunnable instanceof f.c))
      {
        if ((((f.c)paramRunnable).XWx instanceof k))
        {
          paramRunnable = String.format("priority = %d, urlKey = %s", new Object[] { Integer.valueOf(((k)((f.c)paramRunnable).XWx).priority), ((f.c)paramRunnable).XWx.iJd() });
          AppMethodBeat.o(152038);
          return paramRunnable;
        }
        paramRunnable = String.format("unknown request = %s", new Object[] { ((f.c)paramRunnable).XWx });
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
 * Qualified Name:     com.tencent.mm.pluginsdk.res.downloader.model.m
 * JD-Core Version:    0.7.0.1
 */