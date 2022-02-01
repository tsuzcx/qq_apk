package com.tencent.mm.sdk.b;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.j;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class d
  implements com.tencent.mm.sdk.b.a.b, com.tencent.mm.sdk.b.a.f, com.tencent.mm.sdk.b.b.d
{
  public static int aaB;
  private static com.tencent.mm.sdk.b.c.a aaC;
  public static boolean aap;
  public static boolean aaq;
  private static b<Runnable> aat;
  public static final com.tencent.mm.sdk.b.a.f aau;
  public static final com.tencent.mm.sdk.b.a.c aav;
  private static com.tencent.mm.sdk.b.a.g aax;
  final ReentrantLock aaA = new ReentrantLock();
  private j aar = new j(Looper.getMainLooper());
  private Map<Object, List<com.tencent.mm.sdk.b.d.a>> aas = new HashMap();
  public com.tencent.mm.sdk.b.b.a aaw = new com.tencent.mm.sdk.b.b.g(this, this);
  private long aay;
  final AtomicBoolean aaz = new AtomicBoolean(false);
  
  static
  {
    if (!d.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      aam = bool;
      aap = false;
      aaq = false;
      aat = new b();
      aau = new d();
      aav = new c(aau);
      aaB = 7;
      return;
    }
  }
  
  private d()
  {
    Runnable local2 = new Runnable()
    {
      public final void run()
      {
        a.E("MAIN_LOOP_TAG");
      }
    };
    this.aar.post(local2);
  }
  
  @Deprecated
  public static HandlerThread F(String paramString)
  {
    lH();
    return com.tencent.mm.sdk.b.c.a.G(paramString);
  }
  
  private com.tencent.mm.sdk.b.d.a a(Object paramObject, int paramInt)
  {
    for (;;)
    {
      synchronized (this.aas)
      {
        List localList = (List)this.aas.get(paramObject);
        if ((localList == null) || (localList.isEmpty()))
        {
          this.aas.remove(paramObject);
          return null;
        }
        ListIterator localListIterator = localList.listIterator();
        if (localListIterator.hasNext())
        {
          locala = (com.tencent.mm.sdk.b.d.a)localListIterator.next();
          if (locala.token != paramInt) {
            continue;
          }
          localListIterator.remove();
          if (localList.isEmpty()) {
            this.aas.remove(paramObject);
          }
          return locala;
        }
      }
      com.tencent.mm.sdk.b.d.a locala = null;
    }
  }
  
  private void a(Object paramObject, com.tencent.mm.sdk.b.d.a parama)
  {
    synchronized (this.aas)
    {
      Object localObject2 = (List)this.aas.get(paramObject);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = this.aas;
        localObject1 = new LinkedList();
        ((Map)localObject2).put(paramObject, localObject1);
      }
      ((List)localObject1).add(parama);
      if (aax != null) {
        parama.lX();
      }
      return;
    }
  }
  
  private void a(Runnable paramRunnable, String paramString, com.tencent.mm.sdk.b.d.a parama)
  {
    if (b(paramRunnable, paramString)) {
      this.aaw.execute(parama);
    }
  }
  
  private void a(List<g> paramList1, List<g> paramList2)
  {
    for (;;)
    {
      g localg;
      synchronized (this.aas)
      {
        Iterator localIterator1 = this.aas.values().iterator();
        if (!localIterator1.hasNext()) {
          break;
        }
        Iterator localIterator2 = ((List)localIterator1.next()).iterator();
        if (!localIterator2.hasNext()) {
          continue;
        }
        com.tencent.mm.sdk.b.d.a locala = (com.tencent.mm.sdk.b.d.a)localIterator2.next();
        localg = new g(locala.getKey());
        localg.aaM = locala.ZI;
        if (locala.isRunning())
        {
          localg.aaL = h.aaP;
          paramList2.add(localg);
        }
      }
      localg.aaL = h.aaO;
      paramList1.add(localg);
    }
  }
  
  private com.tencent.mm.sdk.b.d.a b(Object paramObject, int paramInt)
  {
    if (paramObject == null) {
      return null;
    }
    for (;;)
    {
      synchronized (this.aas)
      {
        paramObject = (List)this.aas.get(paramObject);
        if ((paramObject == null) || (paramObject.isEmpty())) {
          return null;
        }
        if (paramInt < 0)
        {
          paramObject = (com.tencent.mm.sdk.b.d.a)paramObject.get(0);
          return paramObject;
        }
      }
      Iterator localIterator = paramObject.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          paramObject = (com.tencent.mm.sdk.b.d.a)localIterator.next();
          int i = paramObject.token;
          if (paramInt != i) {
            break;
          }
        }
      }
      paramObject = null;
    }
  }
  
  private static boolean b(Runnable paramRunnable, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return true;
    }
    return aat.b(paramRunnable, paramString);
  }
  
  private static String f(Runnable paramRunnable)
  {
    String str = null;
    if ((paramRunnable instanceof com.tencent.mm.sdk.b.d.b)) {
      str = ((com.tencent.mm.sdk.b.d.b)paramRunnable).getKey();
    }
    while (!TextUtils.isEmpty(null)) {
      return str;
    }
    return paramRunnable.getClass().getName();
  }
  
  private static com.tencent.mm.sdk.b.c.a lH()
  {
    if (aaC == null) {}
    try
    {
      if (aaC == null) {
        aaC = new com.tencent.mm.sdk.b.c.a();
      }
      return aaC;
    }
    finally {}
  }
  
  public final void a(Runnable paramRunnable, String paramString)
  {
    if ((!aam) && (paramRunnable == null)) {
      throw new AssertionError();
    }
    com.tencent.mm.sdk.b.d.a locala = new com.tencent.mm.sdk.b.d.a(paramRunnable, f(paramRunnable), paramString, 0L, new e(this, paramString, null), aax, f.lJ());
    a(paramRunnable, locala);
    a(paramRunnable, paramString, locala);
  }
  
  public final void b(final Runnable paramRunnable, final String paramString, long paramLong)
  {
    if ((!aam) && (paramRunnable == null)) {
      throw new AssertionError();
    }
    final com.tencent.mm.sdk.b.d.a locala = new com.tencent.mm.sdk.b.d.a(paramRunnable, f(paramRunnable), paramString, paramLong, new e(this, paramString, null), aax, f.lJ());
    a(paramRunnable, locala);
    f.lJ().postAtTime(new Runnable()
    {
      public final void run()
      {
        if (!locala.isAlive())
        {
          com.tencent.mm.sdk.platformtools.f.b("MicroMsg.ThreadPool", "may be was removed before! future:%s", new Object[] { locala });
          return;
        }
        d.a(d.this, paramRunnable, paramString, locala);
      }
    }, locala, SystemClock.uptimeMillis() + Math.max(0L, paramLong));
  }
  
  public final void g(Runnable paramRunnable)
  {
    if ((paramRunnable instanceof com.tencent.mm.sdk.b.d.a))
    {
      paramRunnable = (com.tencent.mm.sdk.b.d.a)paramRunnable;
      a.E(paramRunnable.aaI);
      if (aax != null) {
        paramRunnable.lX();
      }
    }
  }
  
  public final void h(Runnable paramRunnable)
  {
    if ((paramRunnable instanceof com.tencent.mm.sdk.b.d.a))
    {
      paramRunnable = (com.tencent.mm.sdk.b.d.a)paramRunnable;
      a(paramRunnable.lW(), paramRunnable.token);
      a.E("");
      if (aax != null) {
        paramRunnable.lX();
      }
    }
  }
  
  public final void lF()
  {
    this.aaA.lock();
    try
    {
      if (this.aaz.compareAndSet(false, true))
      {
        this.aay = System.currentTimeMillis();
        if (aax != null) {
          a(new LinkedList(), new LinkedList());
        }
      }
      return;
    }
    finally
    {
      this.aaA.unlock();
    }
  }
  
  public final void lG()
  {
    this.aaA.lock();
    try
    {
      if ((this.aaz.compareAndSet(true, false)) && (aax != null)) {
        System.currentTimeMillis();
      }
      return;
    }
    finally
    {
      this.aaA.unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.b.d
 * JD-Core Version:    0.7.0.1
 */