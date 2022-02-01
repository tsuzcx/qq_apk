package rx.internal.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.a.b;
import rx.b.a;
import rx.d.c;
import rx.f.d;
import rx.g.a;
import rx.internal.util.e;
import rx.internal.util.g;
import rx.j;

public class h
  extends g.a
{
  private static final boolean akcD;
  public static final int akcE;
  private static final ConcurrentHashMap<ScheduledThreadPoolExecutor, ScheduledThreadPoolExecutor> akcF;
  private static final AtomicReference<ScheduledExecutorService> akcG;
  private static volatile Object akcH;
  private static final Object akcI;
  final ScheduledExecutorService akcB;
  volatile boolean akcC;
  
  static
  {
    AppMethodBeat.i(90336);
    akcI = new Object();
    akcF = new ConcurrentHashMap();
    akcG = new AtomicReference();
    akcE = Integer.getInteger("rx.scheduler.jdk6.purge-frequency-millis", 1000).intValue();
    boolean bool = Boolean.getBoolean("rx.scheduler.jdk6.purge-force");
    int i = e.kKy();
    if ((!bool) && ((i == 0) || (i >= 21))) {}
    for (bool = true;; bool = false)
    {
      akcD = bool;
      AppMethodBeat.o(90336);
      return;
    }
  }
  
  public h(ThreadFactory paramThreadFactory)
  {
    AppMethodBeat.i(90331);
    paramThreadFactory = Executors.newScheduledThreadPool(1, paramThreadFactory);
    if ((!b(paramThreadFactory)) && ((paramThreadFactory instanceof ScheduledThreadPoolExecutor))) {
      a((ScheduledThreadPoolExecutor)paramThreadFactory);
    }
    this.akcB = paramThreadFactory;
    AppMethodBeat.o(90331);
  }
  
  public static void a(ScheduledExecutorService paramScheduledExecutorService)
  {
    AppMethodBeat.i(90327);
    akcF.remove(paramScheduledExecutorService);
    AppMethodBeat.o(90327);
  }
  
  public static void a(ScheduledThreadPoolExecutor paramScheduledThreadPoolExecutor)
  {
    AppMethodBeat.i(90326);
    for (;;)
    {
      ScheduledExecutorService localScheduledExecutorService;
      if ((ScheduledExecutorService)akcG.get() == null)
      {
        localScheduledExecutorService = Executors.newScheduledThreadPool(1, new g("RxSchedulerPurge-"));
        if (akcG.compareAndSet(null, localScheduledExecutorService)) {
          localScheduledExecutorService.scheduleAtFixedRate(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(90325);
              h.kKt();
              AppMethodBeat.o(90325);
            }
          }, akcE, akcE, TimeUnit.MILLISECONDS);
        }
      }
      else
      {
        akcF.putIfAbsent(paramScheduledThreadPoolExecutor, paramScheduledThreadPoolExecutor);
        AppMethodBeat.o(90326);
        return;
      }
      localScheduledExecutorService.shutdownNow();
    }
  }
  
  public static boolean b(ScheduledExecutorService paramScheduledExecutorService)
  {
    AppMethodBeat.i(90329);
    if (akcD)
    {
      Object localObject1;
      Object localObject2;
      if ((paramScheduledExecutorService instanceof ScheduledThreadPoolExecutor))
      {
        localObject1 = akcH;
        if (localObject1 == akcI)
        {
          AppMethodBeat.o(90329);
          return false;
        }
        if (localObject1 == null)
        {
          localObject1 = c(paramScheduledExecutorService);
          if (localObject1 != null)
          {
            localObject2 = localObject1;
            akcH = localObject2;
          }
        }
      }
      for (;;)
      {
        if (localObject1 == null) {
          break label110;
        }
        try
        {
          ((Method)localObject1).invoke(paramScheduledExecutorService, new Object[] { Boolean.TRUE });
          AppMethodBeat.o(90329);
          return true;
        }
        catch (InvocationTargetException paramScheduledExecutorService)
        {
          c.l(paramScheduledExecutorService);
          AppMethodBeat.o(90329);
          return false;
        }
        catch (IllegalAccessException paramScheduledExecutorService)
        {
          for (;;)
          {
            c.l(paramScheduledExecutorService);
          }
        }
        catch (IllegalArgumentException paramScheduledExecutorService)
        {
          for (;;)
          {
            c.l(paramScheduledExecutorService);
          }
        }
        localObject2 = akcI;
        break;
        localObject1 = (Method)localObject1;
        continue;
        localObject1 = c(paramScheduledExecutorService);
      }
    }
  }
  
  private static Method c(ScheduledExecutorService paramScheduledExecutorService)
  {
    AppMethodBeat.i(90330);
    paramScheduledExecutorService = paramScheduledExecutorService.getClass().getMethods();
    int j = paramScheduledExecutorService.length;
    int i = 0;
    while (i < j)
    {
      Method localMethod = paramScheduledExecutorService[i];
      if (localMethod.getName().equals("setRemoveOnCancelPolicy"))
      {
        Class[] arrayOfClass = localMethod.getParameterTypes();
        if ((arrayOfClass.length == 1) && (arrayOfClass[0] == Boolean.TYPE))
        {
          AppMethodBeat.o(90330);
          return localMethod;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(90330);
    return null;
  }
  
  static void kKt()
  {
    AppMethodBeat.i(90328);
    for (;;)
    {
      try
      {
        Iterator localIterator = akcF.keySet().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        ScheduledThreadPoolExecutor localScheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor)localIterator.next();
        if (!localScheduledThreadPoolExecutor.isShutdown()) {
          localScheduledThreadPoolExecutor.purge();
        } else {
          localThrowable.remove();
        }
      }
      finally
      {
        b.ai(localThrowable);
        c.l(localThrowable);
        AppMethodBeat.o(90328);
        return;
      }
    }
    AppMethodBeat.o(90328);
  }
  
  public final j a(a parama)
  {
    AppMethodBeat.i(90332);
    parama = a(parama, 0L, null);
    AppMethodBeat.o(90332);
    return parama;
  }
  
  public final j a(a parama, long paramLong, TimeUnit paramTimeUnit)
  {
    AppMethodBeat.i(90333);
    if (this.akcC)
    {
      parama = d.kKY();
      AppMethodBeat.o(90333);
      return parama;
    }
    parama = b(parama, paramLong, paramTimeUnit);
    AppMethodBeat.o(90333);
    return parama;
  }
  
  public final i b(a parama, long paramLong, TimeUnit paramTimeUnit)
  {
    AppMethodBeat.i(90334);
    i locali = new i(c.b(parama));
    if (paramLong <= 0L) {}
    for (parama = this.akcB.submit(locali);; parama = this.akcB.schedule(locali, paramLong, paramTimeUnit))
    {
      locali.d(parama);
      AppMethodBeat.o(90334);
      return locali;
    }
  }
  
  public final void kKh()
  {
    AppMethodBeat.i(90335);
    this.akcC = true;
    this.akcB.shutdownNow();
    a(this.akcB);
    AppMethodBeat.o(90335);
  }
  
  public final boolean kKi()
  {
    return this.akcC;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     rx.internal.c.h
 * JD-Core Version:    0.7.0.1
 */