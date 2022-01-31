package com.tencent.mm.sdk.g;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.a.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class d
  implements com.tencent.mm.sdk.g.a.b, com.tencent.mm.sdk.g.a.e, com.tencent.mm.sdk.g.b.d.a
{
  public static boolean ysh;
  public static boolean ysi;
  private static b<Runnable> ysl;
  public static final com.tencent.mm.sdk.g.a.e ysm;
  public static final com.tencent.mm.sdk.g.a.c ysn;
  private static f ysp;
  public static int yst;
  private static com.tencent.mm.sdk.g.c.b ysu;
  private static com.tencent.mm.sdk.g.c.a ysv;
  private ak ysj;
  private Map<Object, List<com.tencent.mm.sdk.g.d.a>> ysk;
  public com.tencent.mm.sdk.g.b.a yso;
  private long ysq;
  final AtomicBoolean ysr;
  final ReentrantLock yss;
  
  static
  {
    AppMethodBeat.i(52586);
    if (!d.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      ysh = false;
      ysi = false;
      ysl = new b();
      ysm = new d();
      ysn = new c(ysm);
      yst = 7;
      AppMethodBeat.o(52586);
      return;
    }
  }
  
  private d()
  {
    AppMethodBeat.i(52566);
    this.ysj = new ak(Looper.getMainLooper());
    this.ysk = new HashMap();
    this.ysr = new AtomicBoolean(false);
    this.yss = new ReentrantLock();
    this.yso = new com.tencent.mm.sdk.g.b.e(this, this);
    d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(52536);
        a.setTag("MAIN_LOOP_TAG");
        AppMethodBeat.o(52536);
      }
    });
    AppMethodBeat.o(52566);
  }
  
  public static Thread a(Runnable paramRunnable, String paramString, int paramInt)
  {
    AppMethodBeat.i(52579);
    paramRunnable = duu().newThread(paramRunnable, paramString, paramInt);
    AppMethodBeat.o(52579);
    return paramRunnable;
  }
  
  private static Map<String, Integer> a(Map<String, Integer> paramMap, List<e> paramList)
  {
    AppMethodBeat.i(52565);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      e locale = (e)paramList.next();
      if (paramMap.containsKey(locale.name))
      {
        int i = ((Integer)paramMap.get(locale.name)).intValue();
        paramMap.put(locale.name, Integer.valueOf(i + 1));
      }
      else
      {
        paramMap.put(locale.name, Integer.valueOf(1));
      }
    }
    AppMethodBeat.o(52565);
    return paramMap;
  }
  
  public static void a(f paramf)
  {
    ysp = paramf;
  }
  
  private void a(Object paramObject, com.tencent.mm.sdk.g.d.a parama)
  {
    AppMethodBeat.i(52570);
    synchronized (this.ysk)
    {
      Object localObject2 = (List)this.ysk.get(paramObject);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = this.ysk;
        localObject1 = new LinkedList();
        ((Map)localObject2).put(paramObject, localObject1);
      }
      ((List)localObject1).add(parama);
      if (ysp != null) {
        ysp.a(parama.duL());
      }
      AppMethodBeat.o(52570);
      return;
    }
  }
  
  private void a(Runnable paramRunnable, String paramString, com.tencent.mm.sdk.g.d.a parama)
  {
    AppMethodBeat.i(52545);
    if (c(paramRunnable, paramString)) {
      this.yso.execute(parama);
    }
    AppMethodBeat.o(52545);
  }
  
  private void a(final Runnable paramRunnable, final String paramString1, final String paramString2, long paramLong)
  {
    AppMethodBeat.i(52548);
    paramString1 = new com.tencent.mm.sdk.g.d.a(paramRunnable, paramString1, paramString2, paramLong, new a(paramString2, null), ysp, b.ysC);
    a(paramRunnable, paramString1);
    b.ysC.postAtTime(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(52535);
        if (!paramString1.bRn)
        {
          ab.w("MicroMsg.ThreadPool", "may be was removed before! future:%s", new Object[] { paramString1 });
          AppMethodBeat.o(52535);
          return;
        }
        d.a(d.this, paramRunnable, paramString2, paramString1);
        AppMethodBeat.o(52535);
      }
    }, paramString1, SystemClock.uptimeMillis() + Math.max(0L, paramLong));
    AppMethodBeat.o(52548);
  }
  
  private void a(Runnable paramRunnable, String paramString1, String paramString2, com.tencent.mm.sdk.g.a.d paramd)
  {
    AppMethodBeat.i(52544);
    paramString1 = new com.tencent.mm.sdk.g.d.a(paramRunnable, paramString1, paramString2, 0L, new a(paramString2, paramd), ysp, b.ysC);
    a(paramRunnable, paramString1);
    a(paramRunnable, paramString2, paramString1);
    AppMethodBeat.o(52544);
  }
  
  private List<com.tencent.mm.sdk.g.d.a> aqt(String paramString)
  {
    AppMethodBeat.i(52569);
    LinkedList localLinkedList = new LinkedList();
    for (;;)
    {
      Iterator localIterator1;
      synchronized (this.ysk)
      {
        localIterator1 = this.ysk.values().iterator();
        if (!localIterator1.hasNext()) {
          break;
        }
        Iterator localIterator2 = ((List)localIterator1.next()).iterator();
        i = 1;
        if (!localIterator2.hasNext()) {
          break label142;
        }
        com.tencent.mm.sdk.g.d.a locala = (com.tencent.mm.sdk.g.d.a)localIterator2.next();
        if ((locala.ysA == paramString) && (locala.duK()))
        {
          localLinkedList.add(locala);
          localIterator2.remove();
        }
      }
      int i = 0;
      continue;
      label142:
      if (i != 0) {
        localIterator1.remove();
      }
    }
    AppMethodBeat.o(52569);
    return localLinkedList;
  }
  
  @Deprecated
  public static HandlerThread aqu(String paramString)
  {
    AppMethodBeat.i(52581);
    duv();
    paramString = com.tencent.mm.sdk.g.c.a.eA(paramString, 0);
    AppMethodBeat.o(52581);
    return paramString;
  }
  
  private static boolean c(Runnable paramRunnable, String paramString)
  {
    AppMethodBeat.i(52549);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(52549);
      return true;
    }
    boolean bool = ysl.i(paramRunnable, paramString);
    AppMethodBeat.o(52549);
    return bool;
  }
  
  private boolean cA(Object paramObject)
  {
    AppMethodBeat.i(52572);
    synchronized (this.ysk)
    {
      boolean bool = this.ysk.containsKey(paramObject);
      AppMethodBeat.o(52572);
      return bool;
    }
  }
  
  private List<com.tencent.mm.sdk.g.d.a> cz(Object paramObject)
  {
    AppMethodBeat.i(52568);
    LinkedList localLinkedList = new LinkedList();
    synchronized (this.ysk)
    {
      paramObject = (List)this.ysk.remove(paramObject);
      if (paramObject != null)
      {
        paramObject = paramObject.iterator();
        while (paramObject.hasNext())
        {
          com.tencent.mm.sdk.g.d.a locala = (com.tencent.mm.sdk.g.d.a)paramObject.next();
          if (locala.duK()) {
            localLinkedList.add(locala);
          }
        }
      }
    }
    AppMethodBeat.o(52568);
    return localLinkedList;
  }
  
  private static String d(Runnable paramRunnable, String paramString)
  {
    AppMethodBeat.i(52550);
    String str;
    if ((paramRunnable instanceof com.tencent.mm.sdk.g.d.b)) {
      str = ((com.tencent.mm.sdk.g.d.b)paramRunnable).getKey();
    }
    for (;;)
    {
      AppMethodBeat.o(52550);
      return str;
      str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = paramRunnable.getClass().getName();
      }
    }
  }
  
  private static com.tencent.mm.sdk.g.c.b duu()
  {
    AppMethodBeat.i(52577);
    if (ysu == null) {}
    try
    {
      if (ysu == null) {
        ysu = new com.tencent.mm.sdk.g.c.b();
      }
      com.tencent.mm.sdk.g.c.b localb = ysu;
      AppMethodBeat.o(52577);
      return localb;
    }
    finally
    {
      AppMethodBeat.o(52577);
    }
  }
  
  private static com.tencent.mm.sdk.g.c.a duv()
  {
    AppMethodBeat.i(52580);
    if (ysv == null) {}
    try
    {
      if (ysv == null) {
        ysv = new com.tencent.mm.sdk.g.c.a();
      }
      com.tencent.mm.sdk.g.c.a locala = ysv;
      AppMethodBeat.o(52580);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(52580);
    }
  }
  
  @Deprecated
  public static HandlerThread ey(String paramString, int paramInt)
  {
    AppMethodBeat.i(52582);
    duv();
    paramString = com.tencent.mm.sdk.g.c.a.eA(paramString, paramInt);
    AppMethodBeat.o(52582);
    return paramString;
  }
  
  @Deprecated
  public static void f(Runnable paramRunnable, String paramString)
  {
    AppMethodBeat.i(52575);
    ysm.e(paramRunnable, paramString);
    AppMethodBeat.o(52575);
  }
  
  private com.tencent.mm.sdk.g.d.a g(Object paramObject, int paramInt)
  {
    AppMethodBeat.i(52567);
    for (;;)
    {
      synchronized (this.ysk)
      {
        List localList = (List)this.ysk.get(paramObject);
        if ((localList == null) || (localList.isEmpty()))
        {
          this.ysk.remove(paramObject);
          AppMethodBeat.o(52567);
          return null;
        }
        ListIterator localListIterator = localList.listIterator();
        if (localListIterator.hasNext())
        {
          locala = (com.tencent.mm.sdk.g.d.a)localListIterator.next();
          if (locala.token != paramInt) {
            continue;
          }
          localListIterator.remove();
          if (localList.isEmpty()) {
            this.ysk.remove(paramObject);
          }
          AppMethodBeat.o(52567);
          return locala;
        }
      }
      com.tencent.mm.sdk.g.d.a locala = null;
    }
  }
  
  @Deprecated
  public static void g(Runnable paramRunnable, String paramString)
  {
    AppMethodBeat.i(52576);
    ysm.e(paramRunnable, paramString);
    AppMethodBeat.o(52576);
  }
  
  private com.tencent.mm.sdk.g.d.a h(Object paramObject, int paramInt)
  {
    AppMethodBeat.i(52571);
    if (paramObject == null)
    {
      AppMethodBeat.o(52571);
      return null;
    }
    for (;;)
    {
      synchronized (this.ysk)
      {
        paramObject = (List)this.ysk.get(paramObject);
        if ((paramObject == null) || (paramObject.isEmpty()))
        {
          AppMethodBeat.o(52571);
          return null;
        }
        if (paramInt < 0)
        {
          paramObject = (com.tencent.mm.sdk.g.d.a)paramObject.get(0);
          AppMethodBeat.o(52571);
          return paramObject;
        }
        Iterator localIterator = paramObject.iterator();
        if (localIterator.hasNext())
        {
          paramObject = (com.tencent.mm.sdk.g.d.a)localIterator.next();
          if (paramInt == paramObject.token) {
            continue;
          }
        }
      }
      paramObject = null;
    }
  }
  
  public static Thread h(Runnable paramRunnable, String paramString)
  {
    AppMethodBeat.i(52578);
    paramRunnable = duu().newThread(paramRunnable, paramString, 5);
    AppMethodBeat.o(52578);
    return paramRunnable;
  }
  
  @Deprecated
  public static void post(Runnable paramRunnable, String paramString)
  {
    AppMethodBeat.i(52574);
    ysm.e(paramRunnable, paramString);
    AppMethodBeat.o(52574);
  }
  
  private void s(List<e> paramList1, List<e> paramList2)
  {
    AppMethodBeat.i(52564);
    for (;;)
    {
      e locale;
      synchronized (this.ysk)
      {
        Iterator localIterator1 = this.ysk.values().iterator();
        if (!localIterator1.hasNext()) {
          break;
        }
        Iterator localIterator2 = ((List)localIterator1.next()).iterator();
        if (!localIterator2.hasNext()) {
          continue;
        }
        com.tencent.mm.sdk.g.d.a locala = (com.tencent.mm.sdk.g.d.a)localIterator2.next();
        locale = new e(locala.eMp);
        locale.ysE = locala.cgd;
        if (locala.isRunning())
        {
          locale.ysD = e.a.ysG;
          paramList2.add(locale);
        }
      }
      locale.ysD = e.a.ysF;
      paramList1.add(locale);
    }
    AppMethodBeat.o(52564);
  }
  
  public final void Nj(int paramInt)
  {
    AppMethodBeat.i(52560);
    this.yss.lock();
    try
    {
      if (this.ysr.compareAndSet(false, true))
      {
        this.ysq = System.currentTimeMillis();
        if (ysp != null)
        {
          LinkedList localLinkedList1 = new LinkedList();
          LinkedList localLinkedList2 = new LinkedList();
          s(localLinkedList1, localLinkedList2);
          ysp.a(paramInt, localLinkedList1, localLinkedList2);
        }
      }
      return;
    }
    finally
    {
      this.yss.unlock();
      AppMethodBeat.o(52560);
    }
  }
  
  public final void a(Runnable paramRunnable, String paramString, com.tencent.mm.sdk.g.a.d paramd)
  {
    AppMethodBeat.i(52543);
    if ((!$assertionsDisabled) && (paramRunnable == null))
    {
      paramRunnable = new AssertionError();
      AppMethodBeat.o(52543);
      throw paramRunnable;
    }
    a(paramRunnable, d(paramRunnable, null), paramString, paramd);
    AppMethodBeat.o(52543);
  }
  
  public final void afterExecute(Runnable paramRunnable, Throwable paramThrowable)
  {
    AppMethodBeat.i(52559);
    Object localObject;
    if ((paramRunnable instanceof com.tencent.mm.sdk.g.d.a))
    {
      com.tencent.mm.sdk.g.d.a locala = (com.tencent.mm.sdk.g.d.a)paramRunnable;
      g(locala.yol, locala.token);
      a.setTag("");
      localObject = locala.ytv;
      paramThrowable = (Throwable)localObject;
      if (ysp != null)
      {
        ysp.c(locala.duL());
        paramThrowable = (Throwable)localObject;
      }
    }
    if (paramThrowable != null)
    {
      localObject = paramRunnable;
      if ((paramRunnable instanceof com.tencent.mm.sdk.g.d.a)) {
        localObject = ((com.tencent.mm.sdk.g.d.a)paramRunnable).yol;
      }
      if (ysp != null) {
        ysp.a(localObject, paramThrowable);
      }
    }
    AppMethodBeat.o(52559);
  }
  
  public final void al(Runnable paramRunnable)
  {
    AppMethodBeat.i(52551);
    com.tencent.mm.sdk.g.d.a locala = h(paramRunnable, -1);
    for (;;)
    {
      if (locala != null) {}
      try
      {
        locala.get(5000L, TimeUnit.MILLISECONDS);
        label28:
        locala = h(paramRunnable, locala.token);
        continue;
        AppMethodBeat.o(52551);
        return;
      }
      catch (CancellationException localCancellationException)
      {
        break label28;
      }
    }
  }
  
  public final void am(Runnable paramRunnable)
  {
    AppMethodBeat.i(52552);
    com.tencent.mm.sdk.g.d.a locala = h(paramRunnable, -1);
    for (;;)
    {
      if (locala != null) {}
      try
      {
        locala.get();
        label22:
        locala = h(paramRunnable, locala.token);
        continue;
        AppMethodBeat.o(52552);
        return;
      }
      catch (CancellationException localCancellationException)
      {
        break label22;
      }
    }
  }
  
  public final boolean an(Runnable paramRunnable)
  {
    AppMethodBeat.i(52555);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(52555);
      return false;
    }
    boolean bool = cA(paramRunnable);
    AppMethodBeat.o(52555);
    return bool;
  }
  
  public final void ao(Runnable paramRunnable)
  {
    AppMethodBeat.i(52558);
    if ((paramRunnable instanceof com.tencent.mm.sdk.g.d.a))
    {
      paramRunnable = (com.tencent.mm.sdk.g.d.a)paramRunnable;
      a.setTag(paramRunnable.ysA);
      if (ysp != null) {
        ysp.b(paramRunnable.duL());
      }
    }
    AppMethodBeat.o(52558);
  }
  
  public final void b(Runnable paramRunnable, String paramString)
  {
    AppMethodBeat.i(52542);
    if ((!$assertionsDisabled) && (paramRunnable == null))
    {
      paramRunnable = new AssertionError();
      AppMethodBeat.o(52542);
      throw paramRunnable;
    }
    a(paramRunnable, d(paramRunnable, null), paramString, null);
    AppMethodBeat.o(52542);
  }
  
  public final void b(Runnable paramRunnable, String paramString, long paramLong)
  {
    AppMethodBeat.i(52547);
    if ((!$assertionsDisabled) && (paramRunnable == null))
    {
      paramRunnable = new AssertionError();
      AppMethodBeat.o(52547);
      throw paramRunnable;
    }
    a(paramRunnable, d(paramRunnable, null), paramString, paramLong);
    AppMethodBeat.o(52547);
  }
  
  public final com.tencent.mm.sdk.g.b.a cjN()
  {
    return this.yso;
  }
  
  public final void d(Runnable paramRunnable)
  {
    AppMethodBeat.i(52556);
    this.ysj.post(paramRunnable);
    AppMethodBeat.o(52556);
  }
  
  public final void d(Map<String, Integer> paramMap1, Map<String, Integer> paramMap2)
  {
    AppMethodBeat.i(52563);
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    s(localLinkedList1, localLinkedList2);
    a(paramMap1, localLinkedList2);
    a(paramMap2, localLinkedList1);
    AppMethodBeat.o(52563);
  }
  
  public final void dus()
  {
    AppMethodBeat.i(52561);
    this.yss.lock();
    try
    {
      if ((this.ysr.compareAndSet(true, false)) && (ysp != null)) {
        ysp.kP(System.currentTimeMillis() - this.ysq);
      }
      return;
    }
    finally
    {
      this.yss.unlock();
      AppMethodBeat.o(52561);
    }
  }
  
  public final String dut()
  {
    AppMethodBeat.i(52562);
    StringBuilder localStringBuilder = new StringBuilder(String.format("dumpInfo[%s]:", new Object[] { null }));
    HashMap localHashMap = new HashMap();
    for (;;)
    {
      com.tencent.mm.sdk.g.d.a locala;
      synchronized (this.ysk)
      {
        Iterator localIterator1 = this.ysk.values().iterator();
        continue;
        if (!localIterator1.hasNext()) {
          break;
        }
        Iterator localIterator2 = ((List)localIterator1.next()).iterator();
        if (!localIterator2.hasNext()) {
          continue;
        }
        locala = (com.tencent.mm.sdk.g.d.a)localIterator2.next();
        if (!locala.isRunning()) {
          continue;
        }
        if (localHashMap.containsKey(locala.eMp))
        {
          int i = ((Integer)localHashMap.get(locala.eMp)).intValue();
          localHashMap.put(locala.eMp, Integer.valueOf(i + 1));
        }
      }
      localHashMap.put(locala.eMp, Integer.valueOf(1));
    }
    localObject2.append(localHashMap.toString());
    ??? = localObject2.toString();
    AppMethodBeat.o(52562);
    return ???;
  }
  
  @Deprecated
  public final void e(Runnable paramRunnable, String paramString)
  {
    AppMethodBeat.i(52573);
    if ((!$assertionsDisabled) && (paramRunnable == null))
    {
      paramRunnable = new AssertionError();
      AppMethodBeat.o(52573);
      throw paramRunnable;
    }
    a(paramRunnable, d(paramRunnable, paramString), null, null);
    AppMethodBeat.o(52573);
  }
  
  public final void execute(Runnable paramRunnable)
  {
    AppMethodBeat.i(52541);
    if ((!$assertionsDisabled) && (paramRunnable == null))
    {
      paramRunnable = new AssertionError();
      AppMethodBeat.o(52541);
      throw paramRunnable;
    }
    a(paramRunnable, d(paramRunnable, null), null, null);
    AppMethodBeat.o(52541);
  }
  
  public final void r(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(52546);
    if ((!$assertionsDisabled) && (paramRunnable == null))
    {
      paramRunnable = new AssertionError();
      AppMethodBeat.o(52546);
      throw paramRunnable;
    }
    a(paramRunnable, d(paramRunnable, null), null, paramLong);
    AppMethodBeat.o(52546);
  }
  
  public final void remove(String paramString)
  {
    AppMethodBeat.i(52554);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(52554);
      return;
    }
    List localList = aqt(paramString);
    ysl.aqs(paramString);
    int i = 0;
    while (i < localList.size())
    {
      paramString = (com.tencent.mm.sdk.g.d.a)localList.get(i);
      b.ysC.removeCallbacksAndMessages(paramString);
      this.yso.remove(paramString);
      if (ysp != null) {
        ysp.d(paramString.duL());
      }
      i += 1;
    }
    AppMethodBeat.o(52554);
  }
  
  public final boolean remove(Runnable paramRunnable)
  {
    int i = 0;
    AppMethodBeat.i(52553);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(52553);
      return false;
    }
    List localList = cz(paramRunnable);
    ysl.remove(paramRunnable);
    boolean bool;
    if (!localList.isEmpty()) {
      bool = true;
    }
    while (i < localList.size())
    {
      paramRunnable = (com.tencent.mm.sdk.g.d.a)localList.get(i);
      b.ysC.removeCallbacksAndMessages(paramRunnable);
      this.yso.remove(paramRunnable);
      if (ysp != null) {
        ysp.d(paramRunnable.duL());
      }
      i += 1;
      continue;
      bool = false;
    }
    AppMethodBeat.o(52553);
    return bool;
  }
  
  public final void s(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(52557);
    this.ysj.postDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(52557);
  }
  
  final class a
    implements com.tencent.mm.sdk.g.a.d
  {
    String ysA;
    com.tencent.mm.sdk.g.a.d ysz;
    
    a(String paramString, com.tencent.mm.sdk.g.a.d paramd)
    {
      this.ysA = paramString;
      this.ysz = paramd;
    }
    
    public final void a(Runnable paramRunnable, int paramInt)
    {
      AppMethodBeat.i(52537);
      if (this.ysz != null) {
        this.ysz.a(paramRunnable, paramInt);
      }
      AppMethodBeat.o(52537);
    }
    
    public final void b(Runnable paramRunnable, int paramInt)
    {
      AppMethodBeat.i(52538);
      try
      {
        boolean bool = TextUtils.isEmpty(this.ysA);
        if (bool) {
          return;
        }
        Object localObject1 = d.i(paramRunnable, this.ysA);
        localObject1 = d.a(d.this, localObject1, paramInt);
        if (localObject1 != null) {
          d.this.yso.execute((Runnable)localObject1);
        }
        return;
      }
      finally
      {
        if (this.ysz != null) {
          this.ysz.b(paramRunnable, paramInt);
        }
        AppMethodBeat.o(52538);
      }
      AppMethodBeat.o(52538);
    }
  }
  
  static final class b
  {
    private static HandlerThread ysB;
    private static Handler ysC;
    
    static
    {
      AppMethodBeat.i(52540);
      ysB = com.tencent.mm.sdk.g.c.c.aqv("OrderWorker");
      if (!ysB.isAlive()) {
        ysB.start();
      }
      ysC = new Handler(ysB.getLooper())
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(52539);
          super.handleMessage(paramAnonymousMessage);
          if ((paramAnonymousMessage.what == d.yst) && (d.duw() != null)) {
            d.duw().e((e)paramAnonymousMessage.obj);
          }
          AppMethodBeat.o(52539);
        }
      };
      AppMethodBeat.o(52540);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.g.d
 * JD-Core Version:    0.7.0.1
 */