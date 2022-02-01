package com.tencent.mm.pluginsdk.k.a.c;

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
  private final com.tencent.e.b RaF;
  private final c RaG;
  
  public m(String paramString, c paramc)
  {
    this(paramString, paramc, (byte)0);
  }
  
  private m(String paramString, c paramc, byte paramByte)
  {
    AppMethodBeat.i(184268);
    this.RaF = new f.a(this, paramString, 4, 4, new c());
    this.RaG = paramc;
    AppMethodBeat.o(184268);
  }
  
  protected f.d a(k paramk)
  {
    AppMethodBeat.i(152044);
    Log.i("MicroMsg.ResDownloader.NetworkWorker", "request.class = " + paramk.getClass().getSimpleName());
    p.a.hiK();
    a locala = p.c(paramk);
    Object localObject = locala;
    if (locala == null)
    {
      Log.i("MicroMsg.ResDownloader.NetworkWorker", "get null handler from plugin, use default handler");
      localObject = new b(paramk);
    }
    ((a)localObject).RaJ = this.RaG;
    AppMethodBeat.o(152044);
    return localObject;
  }
  
  protected int b(k paramk)
  {
    int j = 0;
    AppMethodBeat.i(152042);
    if ((bqz(paramk.QYU)) || (bqy(paramk.QYU)))
    {
      Log.i("MicroMsg.ResDownloader.NetworkWorker", "urlKey = %s is already queueing, skip repeated task", new Object[] { paramk.QYU });
      AppMethodBeat.o(152042);
      return 0;
    }
    int i = ac.avq();
    Log.i("MicroMsg.ResDownloader.NetworkWorker", "currentNetType(%d), requestNetType(%d)", new Object[] { Integer.valueOf(i), Integer.valueOf(paramk.networkType) });
    if (i != 0) {
      if (2 == paramk.networkType) {
        i = 1;
      }
    }
    while (i == 0)
    {
      Log.i("MicroMsg.ResDownloader.NetworkWorker", "urlKey = %s, mismatch networkType , skip task", new Object[] { paramk.QYU });
      AppMethodBeat.o(152042);
      return 1;
      if (i == 1) {
        i = 1;
      } else {
        i = 0;
      }
    }
    if ((!this.RaF.isShutdown()) && (!this.RaF.isTerminated()))
    {
      i = this.RaF.Zvd.get();
      if ((com.tencent.e.b.aAC(i)) || (!com.tencent.e.b.nN(i, 1610612736))) {
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
  
  final void bqB(String paramString)
  {
    AppMethodBeat.i(152043);
    super.agN(paramString);
    AppMethodBeat.o(152043);
  }
  
  protected final c hiI()
  {
    return this.RaG;
  }
  
  protected final com.tencent.e.b hit()
  {
    return this.RaF;
  }
  
  public void shutdown()
  {
    AppMethodBeat.i(152045);
    this.RaF.shutdownNow();
    cancelAll();
    AppMethodBeat.o(152045);
  }
  
  public static abstract class a<Req extends k>
    extends f.d<Req>
    implements e
  {
    private static final ThreadLocal<j> RaH = new ThreadLocal() {};
    private final int QZc;
    private final AtomicInteger RaI;
    public volatile c RaJ;
    
    protected a(Req paramReq)
    {
      super();
      this.QZc = paramReq.QZc;
      this.RaI = new AtomicInteger(this.QZc);
    }
    
    public boolean Hj(long paramLong)
    {
      this.RaJ.O(hig(), paramLong);
      long l = SdcardUtil.getAvailableExternalMemorySize2();
      Log.i("MicroMsg.ResDownloader.NetworkWorker", "%s: get available size = %d", new Object[] { hig(), Long.valueOf(l) });
      return l >= paramLong;
    }
    
    protected l a(j paramj)
    {
      if (!bHy()) {
        return j.a(this);
      }
      paramj = p.a.hiK().bqC(hig());
      if (paramj != null)
      {
        paramj.field_status = 1;
        p.a.hiK().h(paramj);
      }
      return j.a(this);
    }
    
    public boolean bHv()
    {
      return false;
    }
    
    public boolean bHw()
    {
      return true;
    }
    
    public boolean bHx()
    {
      return false;
    }
    
    protected boolean bHy()
    {
      return true;
    }
    
    public boolean bHz()
    {
      if (this.RaI.decrementAndGet() > 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.RaJ.C(hig(), this.QZc, this.RaI.get());
        return bool;
      }
    }
    
    public String btD()
    {
      return ((k)bHA()).url;
    }
    
    public final String getFilePath()
    {
      return ((k)bHA()).getFilePath();
    }
    
    public final String hiB()
    {
      return "GET";
    }
    
    public final Collection<b> hiC()
    {
      Map localMap = ((k)bHA()).getRequestHeaders();
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
    
    public final int hiD()
    {
      return ((k)bHA()).hiD();
    }
    
    public final int hiE()
    {
      return ((k)bHA()).hiE();
    }
    
    public final int hiF()
    {
      return ((k)bHA()).hiF();
    }
    
    public final String hiG()
    {
      return "application/x-www-form-urlencoded;charset=utf-8";
    }
    
    public final String hig()
    {
      return ((k)bHA()).QYU;
    }
    
    public final void run()
    {
      l locall = a((j)RaH.get());
      if (locall != null)
      {
        this.RaJ.a(this, locall);
        return;
      }
      Log.e("MicroMsg.ResDownloader.NetworkWorker", "groupId = %s, performer get null response", new Object[] { aCt() });
    }
  }
  
  static final class b
    extends m.a<k>
  {
    b(k paramk)
    {
      super();
    }
    
    public final String aCt()
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
    
    private static String aL(Runnable paramRunnable)
    {
      AppMethodBeat.i(152038);
      if ((paramRunnable instanceof f.c))
      {
        if ((((f.c)paramRunnable).Ras instanceof k))
        {
          paramRunnable = String.format("priority = %d, urlKey = %s", new Object[] { Integer.valueOf(((k)((f.c)paramRunnable).Ras).priority), ((f.c)paramRunnable).Ras.hig() });
          AppMethodBeat.o(152038);
          return paramRunnable;
        }
        paramRunnable = String.format("unknown request = %s", new Object[] { ((f.c)paramRunnable).Ras });
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
 * Qualified Name:     com.tencent.mm.pluginsdk.k.a.c.m
 * JD-Core Version:    0.7.0.1
 */