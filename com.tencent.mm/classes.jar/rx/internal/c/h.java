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
  implements j
{
  private static final boolean Ump;
  public static final int Umq;
  private static final ConcurrentHashMap<ScheduledThreadPoolExecutor, ScheduledThreadPoolExecutor> Umr;
  private static final AtomicReference<ScheduledExecutorService> Ums;
  private static volatile Object Umt;
  private static final Object Umu;
  final ScheduledExecutorService Umn;
  volatile boolean Umo;
  
  static
  {
    AppMethodBeat.i(90336);
    Umu = new Object();
    Umr = new ConcurrentHashMap();
    Ums = new AtomicReference();
    Umq = Integer.getInteger("rx.scheduler.jdk6.purge-frequency-millis", 1000).intValue();
    boolean bool = Boolean.getBoolean("rx.scheduler.jdk6.purge-force");
    int i = e.hQR();
    if ((!bool) && ((i == 0) || (i >= 21))) {}
    for (bool = true;; bool = false)
    {
      Ump = bool;
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
    this.Umn = paramThreadFactory;
    AppMethodBeat.o(90331);
  }
  
  public static void a(ScheduledExecutorService paramScheduledExecutorService)
  {
    AppMethodBeat.i(90327);
    Umr.remove(paramScheduledExecutorService);
    AppMethodBeat.o(90327);
  }
  
  public static void a(ScheduledThreadPoolExecutor paramScheduledThreadPoolExecutor)
  {
    AppMethodBeat.i(90326);
    for (;;)
    {
      ScheduledExecutorService localScheduledExecutorService;
      if ((ScheduledExecutorService)Ums.get() == null)
      {
        localScheduledExecutorService = Executors.newScheduledThreadPool(1, new g("RxSchedulerPurge-"));
        if (Ums.compareAndSet(null, localScheduledExecutorService)) {
          localScheduledExecutorService.scheduleAtFixedRate(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(90325);
              h.hQN();
              AppMethodBeat.o(90325);
            }
          }, Umq, Umq, TimeUnit.MILLISECONDS);
        }
      }
      else
      {
        Umr.putIfAbsent(paramScheduledThreadPoolExecutor, paramScheduledThreadPoolExecutor);
        AppMethodBeat.o(90326);
        return;
      }
      localScheduledExecutorService.shutdownNow();
    }
  }
  
  public static boolean b(ScheduledExecutorService paramScheduledExecutorService)
  {
    AppMethodBeat.i(90329);
    if (Ump)
    {
      Object localObject1;
      Object localObject2;
      if ((paramScheduledExecutorService instanceof ScheduledThreadPoolExecutor))
      {
        localObject1 = Umt;
        if (localObject1 == Umu)
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
            Umt = localObject2;
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
          c.onError(paramScheduledExecutorService);
          AppMethodBeat.o(90329);
          return false;
        }
        catch (IllegalAccessException paramScheduledExecutorService)
        {
          for (;;)
          {
            c.onError(paramScheduledExecutorService);
          }
        }
        catch (IllegalArgumentException paramScheduledExecutorService)
        {
          for (;;)
          {
            c.onError(paramScheduledExecutorService);
          }
        }
        localObject2 = Umu;
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
  
  static void hQN()
  {
    AppMethodBeat.i(90328);
    for (;;)
    {
      try
      {
        Iterator localIterator = Umr.keySet().iterator();
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
      catch (Throwable localThrowable)
      {
        b.N(localThrowable);
        c.onError(localThrowable);
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
    if (this.Umo)
    {
      parama = d.hRn();
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
    for (parama = this.Umn.submit(locali);; parama = this.Umn.schedule(locali, paramLong, paramTimeUnit))
    {
      locali.b(parama);
      AppMethodBeat.o(90334);
      return locali;
    }
  }
  
  public final void hQA()
  {
    AppMethodBeat.i(90335);
    this.Umo = true;
    this.Umn.shutdownNow();
    a(this.Umn);
    AppMethodBeat.o(90335);
  }
  
  public final boolean hQB()
  {
    return this.Umo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     rx.internal.c.h
 * JD-Core Version:    0.7.0.1
 */