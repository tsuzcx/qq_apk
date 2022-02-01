package com.tencent.threadpool;

import android.os.SystemClock;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.threadpool.i.k;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public final class h
  implements c, i
{
  public static i ahAA;
  public static c ahAB;
  private a ahAC;
  final com.tencent.threadpool.h.e ahAD;
  private AtomicBoolean cly;
  
  private h(a parama)
  {
    AppMethodBeat.i(183164);
    this.cly = new AtomicBoolean(false);
    this.ahAC = parama;
    this.ahAD = new com.tencent.threadpool.h.e(parama);
    AppMethodBeat.o(183164);
  }
  
  private com.tencent.threadpool.i.d<?> a(Runnable paramRunnable, final long paramLong1, long paramLong2, final boolean paramBoolean)
  {
    AppMethodBeat.i(226919);
    paramRunnable = (com.tencent.threadpool.i.d)com.tencent.threadpool.e.e.hh(paramRunnable).a(new com.tencent.threadpool.e.a() {}).a(new com.tencent.threadpool.e.a() {}).jZk();
    AppMethodBeat.o(226919);
    return paramRunnable;
  }
  
  private com.tencent.threadpool.i.d<?> a(Runnable paramRunnable, final long paramLong, String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(183188);
    paramRunnable = (com.tencent.threadpool.i.d)com.tencent.threadpool.e.e.hh(paramRunnable).a(new com.tencent.threadpool.e.a() {}).a(new com.tencent.threadpool.e.a() {}).jZk();
    AppMethodBeat.o(183188);
    return paramRunnable;
  }
  
  static void a(a parama)
  {
    try
    {
      AppMethodBeat.i(183163);
      parama = new h(parama);
      ahAA = parama;
      ahAB = parama;
      AppMethodBeat.o(183163);
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  private com.tencent.threadpool.i.d<?> c(Runnable paramRunnable, final long paramLong, String paramString)
  {
    AppMethodBeat.i(226914);
    paramRunnable = (com.tencent.threadpool.i.d)com.tencent.threadpool.e.e.hh(paramRunnable).a(new com.tencent.threadpool.e.a() {}).a(new com.tencent.threadpool.e.a() {}).jZk();
    AppMethodBeat.o(226914);
    return paramRunnable;
  }
  
  private com.tencent.threadpool.i.d<?> c(Runnable paramRunnable, final long paramLong, final boolean paramBoolean)
  {
    AppMethodBeat.i(183186);
    paramRunnable = (com.tencent.threadpool.i.d)com.tencent.threadpool.e.e.hh(paramRunnable).a(new com.tencent.threadpool.e.a() {}).a(new com.tencent.threadpool.e.a() {}).jZk();
    AppMethodBeat.o(183186);
    return paramRunnable;
  }
  
  private com.tencent.threadpool.i.d<?> d(Runnable paramRunnable, final long paramLong, String paramString)
  {
    AppMethodBeat.i(226916);
    paramRunnable = (com.tencent.threadpool.i.d)com.tencent.threadpool.e.e.hh(paramRunnable).a(new com.tencent.threadpool.e.a() {}).a(new com.tencent.threadpool.e.a() {}).jZk();
    AppMethodBeat.o(226916);
    return paramRunnable;
  }
  
  private com.tencent.threadpool.i.d<?> s(Runnable paramRunnable, final long paramLong)
  {
    AppMethodBeat.i(183187);
    paramRunnable = (com.tencent.threadpool.i.d)com.tencent.threadpool.e.e.hh(paramRunnable).a(new com.tencent.threadpool.e.a() {}).a(new com.tencent.threadpool.e.a() {}).jZk();
    AppMethodBeat.o(183187);
    return paramRunnable;
  }
  
  public final b a(String paramString, int paramInt1, int paramInt2, BlockingQueue<Runnable> paramBlockingQueue)
  {
    AppMethodBeat.i(183185);
    paramString = new b(paramString, paramInt1, paramInt2, paramBlockingQueue, new b.a());
    AppMethodBeat.o(183185);
    return paramString;
  }
  
  public final com.tencent.threadpool.i.d<?> a(Runnable paramRunnable, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(226973);
    Objects.requireNonNull(paramRunnable);
    paramRunnable = a(paramRunnable, paramLong1, paramLong2, true);
    AppMethodBeat.o(226973);
    return paramRunnable;
  }
  
  public final com.tencent.threadpool.i.d<?> a(Runnable paramRunnable, long paramLong, String paramString)
  {
    AppMethodBeat.i(183174);
    Objects.requireNonNull(paramRunnable);
    paramRunnable = a(paramRunnable, paramLong, paramString, false);
    AppMethodBeat.o(183174);
    return paramRunnable;
  }
  
  public final <T> com.tencent.threadpool.i.d<T> a(Callable<T> paramCallable, final String paramString)
  {
    AppMethodBeat.i(183172);
    Objects.requireNonNull(paramCallable);
    Objects.requireNonNull(paramCallable);
    paramCallable = (com.tencent.threadpool.i.d)com.tencent.threadpool.e.e.hh(paramCallable).a(new com.tencent.threadpool.e.a() {}).a(new com.tencent.threadpool.e.a() {}).jZk();
    AppMethodBeat.o(183172);
    return paramCallable;
  }
  
  public final com.tencent.threadpool.i.d<?> b(Runnable paramRunnable, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(226976);
    Objects.requireNonNull(paramRunnable);
    paramRunnable = a(paramRunnable, paramLong1, paramLong2, false);
    AppMethodBeat.o(226976);
    return paramRunnable;
  }
  
  public final com.tencent.threadpool.i.d<?> b(Runnable paramRunnable, long paramLong, String paramString)
  {
    AppMethodBeat.i(226967);
    Objects.requireNonNull(paramRunnable);
    paramRunnable = d(paramRunnable, paramLong, paramString);
    AppMethodBeat.o(226967);
    return paramRunnable;
  }
  
  public final boolean bFQ(String paramString)
  {
    AppMethodBeat.i(183179);
    Objects.requireNonNull(paramString);
    paramString = com.tencent.threadpool.j.a.bFW(paramString);
    if (paramString != null)
    {
      paramString.ahCy.clear();
      AppMethodBeat.o(183179);
      return true;
    }
    AppMethodBeat.o(183179);
    return false;
  }
  
  public final b bFR(String paramString)
  {
    AppMethodBeat.i(183184);
    paramString = new b(paramString, 1, 1, new LinkedBlockingQueue(), new b.a());
    AppMethodBeat.o(183184);
    return paramString;
  }
  
  public final com.tencent.threadpool.i.d<?> bk(Runnable paramRunnable)
  {
    AppMethodBeat.i(183165);
    Objects.requireNonNull(paramRunnable);
    paramRunnable = c(paramRunnable, 0L, false);
    AppMethodBeat.o(183165);
    return paramRunnable;
  }
  
  public final com.tencent.threadpool.i.d<?> bl(Runnable paramRunnable)
  {
    AppMethodBeat.i(183167);
    Objects.requireNonNull(paramRunnable);
    paramRunnable = c(paramRunnable, 0L, true);
    AppMethodBeat.o(183167);
    return paramRunnable;
  }
  
  public final com.tencent.threadpool.i.d<?> bm(Runnable paramRunnable)
  {
    AppMethodBeat.i(183168);
    Objects.requireNonNull(paramRunnable);
    paramRunnable = p(paramRunnable, 0L);
    AppMethodBeat.o(183168);
    return paramRunnable;
  }
  
  public final com.tencent.threadpool.i.d<?> bn(Runnable paramRunnable)
  {
    AppMethodBeat.i(183175);
    Objects.requireNonNull(paramRunnable);
    paramRunnable = q(paramRunnable, 0L);
    AppMethodBeat.o(183175);
    return paramRunnable;
  }
  
  public final com.tencent.threadpool.i.d<?> bo(Runnable paramRunnable)
  {
    AppMethodBeat.i(183176);
    Objects.requireNonNull(paramRunnable);
    paramRunnable = r(paramRunnable, 0L);
    AppMethodBeat.o(183176);
    return paramRunnable;
  }
  
  public final com.tencent.threadpool.i.d<?> bp(Runnable paramRunnable)
  {
    AppMethodBeat.i(183178);
    paramRunnable = bn(paramRunnable);
    AppMethodBeat.o(183178);
    return paramRunnable;
  }
  
  public final <T> com.tencent.threadpool.i.d<T> e(Callable<T> paramCallable)
  {
    AppMethodBeat.i(226921);
    Objects.requireNonNull(paramCallable);
    paramCallable = (com.tencent.threadpool.i.d)com.tencent.threadpool.e.e.hh(paramCallable).a(new com.tencent.threadpool.e.a() {}).a(new com.tencent.threadpool.e.a() {}).jZk();
    AppMethodBeat.o(226921);
    return paramCallable;
  }
  
  public final <T> com.tencent.threadpool.i.d<T> f(Callable<T> paramCallable)
  {
    AppMethodBeat.i(183169);
    Objects.requireNonNull(paramCallable);
    Objects.requireNonNull(paramCallable);
    paramCallable = (com.tencent.threadpool.i.d)com.tencent.threadpool.e.e.hh(paramCallable).a(new com.tencent.threadpool.e.a() {}).a(new com.tencent.threadpool.e.a() {}).jZk();
    AppMethodBeat.o(183169);
    return paramCallable;
  }
  
  public final com.tencent.threadpool.i.d<?> g(Runnable paramRunnable, String paramString)
  {
    AppMethodBeat.i(183171);
    Objects.requireNonNull(paramRunnable);
    paramRunnable = a(paramRunnable, 0L, paramString);
    AppMethodBeat.o(183171);
    return paramRunnable;
  }
  
  public final <T> com.tencent.threadpool.i.d<T> g(Callable<T> paramCallable)
  {
    AppMethodBeat.i(226936);
    Objects.requireNonNull(paramCallable);
    Objects.requireNonNull(paramCallable);
    paramCallable = (com.tencent.threadpool.i.d)com.tencent.threadpool.e.e.hh(paramCallable).a(new com.tencent.threadpool.e.a() {}).a(new com.tencent.threadpool.e.a() {}).jZk();
    AppMethodBeat.o(226936);
    return paramCallable;
  }
  
  public final com.tencent.threadpool.i.d<?> h(Runnable paramRunnable, String paramString)
  {
    AppMethodBeat.i(183173);
    Objects.requireNonNull(paramRunnable);
    paramRunnable = a(paramRunnable, 0L, paramString, true);
    AppMethodBeat.o(183173);
    return paramRunnable;
  }
  
  public final <T> com.tencent.threadpool.i.d<T> h(Callable<T> paramCallable)
  {
    AppMethodBeat.i(226954);
    Objects.requireNonNull(paramCallable);
    Objects.requireNonNull(paramCallable);
    paramCallable = (com.tencent.threadpool.i.d)com.tencent.threadpool.e.e.hh(paramCallable).a(new com.tencent.threadpool.e.a() {}).a(new com.tencent.threadpool.e.a() {}).jZk();
    AppMethodBeat.o(226954);
    return paramCallable;
  }
  
  public final com.tencent.threadpool.i.d<?> i(Runnable paramRunnable, String paramString)
  {
    AppMethodBeat.i(226945);
    Objects.requireNonNull(paramRunnable);
    Objects.requireNonNull(paramRunnable);
    paramRunnable = c(paramRunnable, 0L, paramString);
    AppMethodBeat.o(226945);
    return paramRunnable;
  }
  
  public final boolean isShutdown()
  {
    AppMethodBeat.i(183180);
    boolean bool = this.cly.get();
    AppMethodBeat.o(183180);
    return bool;
  }
  
  public final com.tencent.threadpool.i.d<?> j(Runnable paramRunnable, String paramString)
  {
    AppMethodBeat.i(226963);
    Objects.requireNonNull(paramRunnable);
    paramRunnable = b(paramRunnable, 0L, paramString);
    AppMethodBeat.o(226963);
    return paramRunnable;
  }
  
  public final Map<String, Integer> jYS()
  {
    AppMethodBeat.i(183182);
    Map localMap = com.tencent.threadpool.g.h.ahBK.jZq();
    AppMethodBeat.o(183182);
    return localMap;
  }
  
  public final Map<String, List<Pair<String, Integer>>> jYT()
  {
    AppMethodBeat.i(183183);
    long l1 = SystemClock.uptimeMillis();
    HashMap localHashMap = new HashMap();
    Iterator localIterator1 = this.ahAD.jYT().entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator1.next();
      Object localObject = new HashMap();
      Iterator localIterator2 = ((List)localEntry.getValue()).iterator();
      if (localIterator2.hasNext())
      {
        String str = (String)localIterator2.next();
        Pair localPair = (Pair)((HashMap)localObject).get(str);
        if (localPair == null) {}
        for (int i = 1;; i = ((Integer)localPair.second).intValue() + 1)
        {
          ((HashMap)localObject).put(str, new Pair(str, Integer.valueOf(i))
          {
            public final String toString()
            {
              AppMethodBeat.i(183145);
              String str = "(" + (String)this.first + " -> " + this.second + ")";
              AppMethodBeat.o(183145);
              return str;
            }
          });
          break;
        }
      }
      localObject = new LinkedList(((HashMap)localObject).values());
      Collections.sort((List)localObject, new Comparator() {});
      localHashMap.put(localEntry.getKey(), localObject);
    }
    long l2 = SystemClock.uptimeMillis();
    d.ahAq.i("ThreadPool", "[dumpWaitingTask] cost=" + (l2 - l1) + "ms", new Object[0]);
    AppMethodBeat.o(183183);
    return localHashMap;
  }
  
  /* Error */
  public final boolean jYV()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc_w 425
    //   7: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_0
    //   11: getfield 85	com/tencent/threadpool/h:cly	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   14: iconst_0
    //   15: iconst_1
    //   16: invokevirtual 429	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   19: ifeq +74 -> 93
    //   22: invokestatic 432	com/tencent/threadpool/j/a:release	()V
    //   25: aload_0
    //   26: getfield 93	com/tencent/threadpool/h:ahAD	Lcom/tencent/threadpool/h/e;
    //   29: astore_2
    //   30: aload_2
    //   31: getfield 436	com/tencent/threadpool/h/e:ahCf	Lcom/tencent/threadpool/h/b;
    //   34: invokevirtual 441	com/tencent/threadpool/h/b:shutdown	()V
    //   37: aload_2
    //   38: getfield 445	com/tencent/threadpool/h/e:ahCg	Lcom/tencent/threadpool/h/c;
    //   41: invokevirtual 448	com/tencent/threadpool/h/c:shutdown	()V
    //   44: aload_2
    //   45: getfield 452	com/tencent/threadpool/h/e:ahCh	Lcom/tencent/threadpool/h/f;
    //   48: invokevirtual 455	com/tencent/threadpool/h/f:shutdown	()V
    //   51: getstatic 395	com/tencent/threadpool/d:ahAq	Lcom/tencent/threadpool/d$a;
    //   54: ldc_w 457
    //   57: ldc_w 459
    //   60: iconst_0
    //   61: anewarray 4	java/lang/Object
    //   64: invokeinterface 422 4 0
    //   69: invokestatic 462	com/tencent/threadpool/e/h:release	()V
    //   72: invokestatic 465	com/tencent/threadpool/e/d:release	()V
    //   75: getstatic 469	com/tencent/threadpool/d:ahAo	Lcom/tencent/threadpool/d$e;
    //   78: invokeinterface 472 1 0
    //   83: ldc_w 425
    //   86: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   89: aload_0
    //   90: monitorexit
    //   91: iload_1
    //   92: ireturn
    //   93: ldc_w 425
    //   96: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: iconst_0
    //   100: istore_1
    //   101: goto -12 -> 89
    //   104: astore_2
    //   105: aload_0
    //   106: monitorexit
    //   107: aload_2
    //   108: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	this	h
    //   1	100	1	bool	boolean
    //   29	16	2	locale	com.tencent.threadpool.h.e
    //   104	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	89	104	finally
    //   93	99	104	finally
  }
  
  public final a jYW()
  {
    return this.ahAC;
  }
  
  public final com.tencent.threadpool.i.d<?> o(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(183166);
    Objects.requireNonNull(paramRunnable);
    paramRunnable = c(paramRunnable, paramLong, false);
    AppMethodBeat.o(183166);
    return paramRunnable;
  }
  
  public final com.tencent.threadpool.i.d<?> p(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(183170);
    Objects.requireNonNull(paramRunnable);
    paramRunnable = s(paramRunnable, paramLong);
    AppMethodBeat.o(183170);
    return paramRunnable;
  }
  
  public final com.tencent.threadpool.i.d<?> q(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(226942);
    Objects.requireNonNull(paramRunnable);
    paramRunnable = c(paramRunnable, paramLong, null);
    AppMethodBeat.o(226942);
    return paramRunnable;
  }
  
  public final com.tencent.threadpool.i.d<?> r(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(226958);
    Objects.requireNonNull(paramRunnable);
    paramRunnable = d(paramRunnable, paramLong, null);
    AppMethodBeat.o(226958);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.threadpool.h
 * JD-Core Version:    0.7.0.1
 */