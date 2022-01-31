package com.tencent.mm.sdk.f;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import junit.framework.Assert;

public class e
  implements f.a
{
  private static e ukn;
  static int[] uko = { 19, 16, 13, 10, 0, -2, -4, -5, -6, -8 };
  static long ukp = 0L;
  static long ukq = 0L;
  private static b ukr;
  private static a uks;
  private static b ukt;
  private boolean bFk = false;
  volatile boolean bNW = false;
  Object lock = new Object();
  private f ukf = new f(this.ukg + 2, TimeUnit.SECONDS, this.ukh, this);
  private int ukg = csv();
  private PriorityBlockingQueue<Runnable> ukh = new PriorityBlockingQueue(33);
  private LinkedList<g> uki = new LinkedList();
  private ArrayList<g> ukj = new ArrayList();
  private HashMap<g, Thread> ukk = new HashMap();
  private ArrayList<c> ukl = new ArrayList();
  private c ukm;
  
  private e()
  {
    HandlerThread localHandlerThread = aap("THREAD_POOL_HANDLER");
    localHandlerThread.start();
    this.ukm = new c(localHandlerThread.getLooper());
  }
  
  public static void Y(Runnable paramRunnable)
  {
    e locale = csu();
    synchronized (locale.lock)
    {
      Thread localThread = locale.Z(paramRunnable);
      if (localThread != null)
      {
        localThread.interrupt();
        return;
      }
      locale.af(paramRunnable);
    }
  }
  
  private Thread Z(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return null;
    }
    for (;;)
    {
      synchronized (this.lock)
      {
        Iterator localIterator = this.ukk.keySet().iterator();
        if (localIterator != null)
        {
          if (!localIterator.hasNext()) {
            break label99;
          }
          g localg = (g)localIterator.next();
          if ((localg == null) || (!localg.ugm.equals(paramRunnable))) {
            continue;
          }
          paramRunnable = localg;
          if (paramRunnable != null)
          {
            paramRunnable = (Thread)this.ukk.get(paramRunnable);
            return paramRunnable;
          }
        }
      }
      return null;
      label99:
      paramRunnable = null;
    }
  }
  
  public static void a(c paramc)
  {
    csu().b(paramc);
  }
  
  public static void a(Runnable paramRunnable, String paramString)
  {
    e locale = csu();
    synchronized (locale.lock)
    {
      paramRunnable = new g(paramRunnable, paramString, 2147483647, true, ukt);
      locale.ukj.add(paramRunnable);
      locale.ukf.execute(paramRunnable);
      if ((locale.ukf.getActiveCount() >= locale.ukg) && (locale.ukg < csv() * 2))
      {
        locale.ukg += 1;
        locale.ukf.setCorePoolSize(locale.ukg);
        locale.ukf.setMaximumPoolSize(locale.ukg);
        y.i("MicroMsg.ThreadPool", "|MMThreadPool postAtFront expand core pool size=" + locale.ukg);
        paramString = new ArrayList(locale.ukl).iterator();
      }
      while (paramString.hasNext())
      {
        paramString.next();
        Runnable localRunnable = paramRunnable.ugm;
        continue;
        locale.csw();
      }
    }
    locale.mz(false);
  }
  
  public static void a(Runnable paramRunnable, String paramString, int paramInt)
  {
    csu().b(paramRunnable, paramString, paramInt);
  }
  
  public static void aa(Runnable paramRunnable)
  {
    csu().ab(paramRunnable);
  }
  
  public static HandlerThread aap(String paramString)
  {
    csA();
    return a.dr(paramString, 0);
  }
  
  /* Error */
  private void ab(Runnable paramRunnable)
  {
    // Byte code:
    //   0: ldc_w 276
    //   3: aload_1
    //   4: invokestatic 282	junit/framework/Assert:assertNotNull	(Ljava/lang/String;Ljava/lang/Object;)V
    //   7: aconst_null
    //   8: astore_2
    //   9: aload_0
    //   10: getfield 93	com/tencent/mm/sdk/f/e:lock	Ljava/lang/Object;
    //   13: astore_3
    //   14: aload_3
    //   15: monitorenter
    //   16: aload_0
    //   17: aload_1
    //   18: invokespecial 285	com/tencent/mm/sdk/f/e:ae	(Ljava/lang/Runnable;)Z
    //   21: ifeq +18 -> 39
    //   24: new 8	com/tencent/mm/sdk/f/e$a
    //   27: dup
    //   28: aload_0
    //   29: aload_1
    //   30: invokespecial 288	com/tencent/mm/sdk/f/e$a:<init>	(Lcom/tencent/mm/sdk/f/e;Ljava/lang/Runnable;)V
    //   33: astore_2
    //   34: aload_0
    //   35: aload_2
    //   36: invokespecial 189	com/tencent/mm/sdk/f/e:b	(Lcom/tencent/mm/sdk/f/c;)V
    //   39: aload_3
    //   40: monitorexit
    //   41: aload_2
    //   42: ifnull +22 -> 64
    //   45: aload_1
    //   46: monitorenter
    //   47: aload_0
    //   48: getfield 91	com/tencent/mm/sdk/f/e:ukl	Ljava/util/ArrayList;
    //   51: aload_2
    //   52: invokevirtual 291	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   55: ifeq +15 -> 70
    //   58: aload_1
    //   59: invokevirtual 294	java/lang/Object:wait	()V
    //   62: aload_1
    //   63: monitorexit
    //   64: return
    //   65: astore_1
    //   66: aload_3
    //   67: monitorexit
    //   68: aload_1
    //   69: athrow
    //   70: ldc 232
    //   72: ldc_w 296
    //   75: invokestatic 299	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   78: goto -16 -> 62
    //   81: astore_2
    //   82: aload_1
    //   83: monitorexit
    //   84: aload_2
    //   85: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	this	e
    //   0	86	1	paramRunnable	Runnable
    //   8	44	2	locala	a
    //   81	4	2	localObject1	Object
    //   13	54	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   16	39	65	finally
    //   39	41	65	finally
    //   66	68	65	finally
    //   47	62	81	finally
    //   62	64	81	finally
    //   70	78	81	finally
    //   82	84	81	finally
  }
  
  public static void ac(Runnable paramRunnable)
  {
    int j = 1;
    e locale = csu();
    Assert.assertNotNull("join arg runnable is null!", paramRunnable);
    if (5000L < 0L) {
      throw new IllegalArgumentException();
    }
    int i;
    if (5000L >= 9223372036854L)
    {
      i = 1;
      if (5000L != 0L) {
        break label68;
      }
    }
    for (;;)
    {
      if ((j | i) == 0) {
        break label73;
      }
      locale.ab(paramRunnable);
      return;
      i = 0;
      break;
      label68:
      j = 0;
    }
    label73:
    a locala = null;
    for (;;)
    {
      synchronized (locale.lock)
      {
        if (locale.ae(paramRunnable))
        {
          locala = new a(locale, paramRunnable);
          csu().b(locala);
        }
        if (locala == null) {
          break;
        }
        try
        {
          if (locale.ukl.contains(locala))
          {
            paramRunnable.wait(5000L, 0);
            return;
          }
        }
        finally {}
      }
      y.d("MicroMsg.ThreadPool", "|MMThreadPool joinTask runnable is not in observerList, just removed!");
    }
  }
  
  public static boolean ad(Runnable paramRunnable)
  {
    return csu().ae(paramRunnable);
  }
  
  private boolean ae(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return false;
    }
    synchronized (this.lock)
    {
      Iterator localIterator = this.ukj.iterator();
      g localg;
      while ((localIterator != null) && (localIterator.hasNext()))
      {
        localg = (g)localIterator.next();
        if ((localg != null) && (localg.ugm.equals(paramRunnable))) {
          return true;
        }
      }
      localIterator = this.ukk.keySet().iterator();
      while ((localIterator != null) && (localIterator.hasNext()))
      {
        localg = (g)localIterator.next();
        if ((localg != null) && (localg.ugm.equals(paramRunnable))) {
          return true;
        }
      }
      return false;
    }
  }
  
  private boolean af(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return false;
    }
    for (;;)
    {
      synchronized (this.lock)
      {
        Iterator localIterator = this.ukj.iterator();
        if (localIterator != null)
        {
          if (!localIterator.hasNext()) {
            break label98;
          }
          g localg = (g)localIterator.next();
          if ((localg == null) || (!localg.ugm.equals(paramRunnable))) {
            continue;
          }
          localIterator.remove();
          paramRunnable = localg;
          if (paramRunnable != null)
          {
            this.ukf.remove(paramRunnable);
            return true;
          }
        }
      }
      return false;
      label98:
      paramRunnable = null;
    }
  }
  
  public static Thread b(Runnable paramRunnable, String paramString)
  {
    return csz().newThread(paramRunnable, paramString, 5);
  }
  
  private void b(c paramc)
  {
    synchronized (this.lock)
    {
      if (!this.ukl.contains(paramc)) {
        this.ukl.add(paramc);
      }
      return;
    }
  }
  
  private void b(Runnable paramRunnable, String paramString, int paramInt)
  {
    synchronized (this.lock)
    {
      paramRunnable = new g(paramRunnable, paramString, paramInt, true, ukt);
      this.uki.add(paramRunnable);
      this.ukj.add(paramRunnable);
      this.ukm.sendEmptyMessage(1);
      mz(false);
      return;
    }
  }
  
  public static Thread c(Runnable paramRunnable, String paramString, int paramInt)
  {
    return csz().newThread(paramRunnable, paramString, paramInt);
  }
  
  public static void c(c paramc)
  {
    e locale = csu();
    synchronized (locale.lock)
    {
      locale.ukl.remove(paramc);
      return;
    }
  }
  
  private static a csA()
  {
    if (uks == null) {
      uks = new a(ukt);
    }
    return uks;
  }
  
  public static e csu()
  {
    if (ukn == null) {}
    try
    {
      if (ukn == null) {
        ukn = new e();
      }
      return ukn;
    }
    finally {}
  }
  
  private static int csv()
  {
    int i = Runtime.getRuntime().availableProcessors() * 4 + 2;
    if (i > 32) {
      return 32;
    }
    return i;
  }
  
  private void csw()
  {
    if (this.ukf.getCorePoolSize() < this.ukg)
    {
      this.ukf.setCorePoolSize(this.ukg);
      this.ukf.setMaximumPoolSize(this.ukg);
    }
  }
  
  public static void csy()
  {
    csu().mz(true);
  }
  
  private static b csz()
  {
    if (ukr == null) {
      ukr = new b(ukt);
    }
    return ukr;
  }
  
  public static HandlerThread ds(String paramString, int paramInt)
  {
    csA();
    return a.dr(paramString, paramInt);
  }
  
  private void mz(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    g localg;
    synchronized (this.lock)
    {
      y.i("MicroMsg.ThreadPool", "------------------------------------------");
      Iterator localIterator1 = this.uki.iterator();
      if ((localIterator1 != null) && (localIterator1.hasNext()))
      {
        localg = (g)localIterator1.next();
        y.i("MicroMsg.ThreadPool", "|MMThreadPool adding task{" + localg + "}");
      }
    }
    y.i("MicroMsg.ThreadPool", "-----------");
    Iterator localIterator2 = this.ukj.iterator();
    if (localIterator2 != null) {
      while (localIterator2.hasNext())
      {
        localg = (g)localIterator2.next();
        y.i("MicroMsg.ThreadPool", "|MMThreadPool waiting task{" + localg + "}");
      }
    }
    y.i("MicroMsg.ThreadPool", "-----------");
    localIterator2 = this.ukk.keySet().iterator();
    if (localIterator2 != null) {
      while (localIterator2.hasNext())
      {
        localg = (g)localIterator2.next();
        y.i("MicroMsg.ThreadPool", "|MMThreadPool running task{" + localg + "}");
      }
    }
    y.i("MicroMsg.ThreadPool", "-----------");
    y.i("MicroMsg.ThreadPool", "|MMThreadPool poolSize=" + this.ukf.getPoolSize() + "|activeCount=" + this.ukf.getActiveCount() + "|corePoolSize=" + this.ukf.getPoolSize() + "|largestPoolSize=" + this.ukf.getLargestPoolSize() + "|maximuPoolSize=" + this.ukf.getMaximumPoolSize());
    y.i("MicroMsg.ThreadPool", "------------------------------------------");
  }
  
  public static void post(Runnable paramRunnable, String paramString)
  {
    csu().b(paramRunnable, paramString, 5);
  }
  
  public static boolean remove(Runnable paramRunnable)
  {
    return csu().af(paramRunnable);
  }
  
  public final void X(Runnable paramRunnable)
  {
    for (;;)
    {
      synchronized (this.lock)
      {
        paramRunnable = (g)paramRunnable;
        Iterator localIterator = this.ukk.keySet().iterator();
        if (localIterator != null)
        {
          if (!localIterator.hasNext()) {
            break label251;
          }
          g localg = (g)localIterator.next();
          if ((localg == null) || (!localg.equals(paramRunnable))) {
            continue;
          }
          localIterator.remove();
          i = 1;
          if (i != 0)
          {
            localIterator = new ArrayList(this.ukl).iterator();
            if (localIterator.hasNext()) {
              ((c)localIterator.next()).A(paramRunnable.ugm);
            }
          }
        }
      }
      int i = this.ukf.getActiveCount();
      int j = this.ukf.getQueue().size();
      int k = this.ukf.getCorePoolSize();
      if ((i == 1) && (j == 0))
      {
        if (k > 0)
        {
          this.ukg = csv();
          this.ukf.setCorePoolSize(0);
          this.ukf.setMaximumPoolSize(this.ukg + 2);
        }
        paramRunnable = new ArrayList(this.ukl).iterator();
        while (paramRunnable.hasNext()) {
          paramRunnable.next();
        }
        this.bFk = false;
      }
      return;
      label251:
      i = 0;
    }
  }
  
  public final void beforeExecute(Thread paramThread, Runnable paramRunnable)
  {
    int i = 10;
    for (;;)
    {
      int j;
      synchronized (this.lock)
      {
        Iterator localIterator = this.ukj.iterator();
        if (localIterator == null) {
          break label221;
        }
        paramRunnable = (g)paramRunnable;
        j = paramRunnable.priority;
        if (j <= 0)
        {
          i = 1;
          paramThread.setPriority(i);
          paramThread.setName(paramRunnable.ugn);
          if (!localIterator.hasNext()) {
            break label225;
          }
          g localg = (g)localIterator.next();
          if ((localg == null) || (!localg.equals(paramRunnable))) {
            continue;
          }
          localIterator.remove();
          i = 1;
          if (i == 0) {
            break label221;
          }
          this.ukk.put(paramRunnable, paramThread);
          paramThread = new ArrayList(this.ukl);
          if (this.bFk) {
            break label181;
          }
          localIterator = paramThread.iterator();
          if (!localIterator.hasNext()) {
            break label181;
          }
          localIterator.next();
        }
      }
      if (j <= 10)
      {
        i = j;
        continue;
        label181:
        this.bFk = true;
        paramThread = paramThread.iterator();
        while (paramThread.hasNext()) {
          ((c)paramThread.next()).z(paramRunnable.ugm);
        }
        label221:
        return;
        label225:
        i = 0;
      }
    }
  }
  
  public final String csx()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    synchronized (this.lock)
    {
      localStringBuilder.append("waitingTaskQueue size:" + this.ukj.size()).append("|");
      Iterator localIterator = this.ukk.keySet().iterator();
      if (localIterator.hasNext()) {
        localStringBuilder.append(((g)localIterator.next()).ugn).append("|");
      }
    }
    return localObject2.toString();
  }
  
  final class a
    implements c
  {
    private final Runnable r;
    
    public a(Runnable paramRunnable)
    {
      this.r = paramRunnable;
    }
    
    public final void A(Runnable arg1)
    {
      if (???.equals(this.r)) {
        synchronized (this.r)
        {
          this.r.notifyAll();
          e.c(this);
          return;
        }
      }
    }
    
    public final void z(Runnable paramRunnable) {}
  }
  
  public static abstract interface b {}
  
  final class c
    extends ah
  {
    public c(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message arg1)
    {
      switch (???.what)
      {
      default: 
        return;
      }
      removeMessages(???.what);
      if (e.this.bNW)
      {
        long l = System.currentTimeMillis();
        e locale;
        if ((e.rg() > 0L) && (Math.abs(e.ukq - l) > e.rg()))
        {
          y.i("MicroMsg.ThreadPool", "|MMThreadPool thread pool is auto wakeup");
          locale = e.this;
        }
        synchronized (locale.lock)
        {
          locale.bNW = false;
          e.ukq = 0L;
          e.ukp = 0L;
          sendEmptyMessageDelayed(1, 1000L);
          return;
        }
      }
      e.a(e.this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.f.e
 * JD-Core Version:    0.7.0.1
 */