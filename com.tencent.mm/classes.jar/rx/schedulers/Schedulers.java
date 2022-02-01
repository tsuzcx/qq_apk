package rx.schedulers;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.c.j;
import rx.internal.c.m;

public final class Schedulers
{
  private static final AtomicReference<Schedulers> OyB;
  private final rx.g OyA;
  private final rx.g Oyy;
  private final rx.g Oyz;
  
  static
  {
    AppMethodBeat.i(90101);
    OyB = new AtomicReference();
    AppMethodBeat.o(90101);
  }
  
  private Schedulers()
  {
    AppMethodBeat.i(90090);
    rx.d.f.gDO().gDT();
    this.Oyy = rx.d.g.gDU();
    this.Oyz = rx.d.g.gDV();
    this.OyA = rx.d.g.gDW();
    AppMethodBeat.o(90090);
  }
  
  public static rx.g computation()
  {
    AppMethodBeat.i(90092);
    rx.g localg = rx.d.c.c(gDZ().Oyy);
    AppMethodBeat.o(90092);
    return localg;
  }
  
  public static rx.g from(Executor paramExecutor)
  {
    AppMethodBeat.i(90095);
    paramExecutor = new rx.internal.c.c(paramExecutor);
    AppMethodBeat.o(90095);
    return paramExecutor;
  }
  
  private static Schedulers gDZ()
  {
    AppMethodBeat.i(90089);
    for (;;)
    {
      Schedulers localSchedulers = (Schedulers)OyB.get();
      if (localSchedulers != null)
      {
        AppMethodBeat.o(90089);
        return localSchedulers;
      }
      localSchedulers = new Schedulers();
      if (OyB.compareAndSet(null, localSchedulers))
      {
        AppMethodBeat.o(90089);
        return localSchedulers;
      }
      localSchedulers.gEb();
    }
  }
  
  private void gEa()
  {
    try
    {
      AppMethodBeat.i(90099);
      if ((this.Oyy instanceof j)) {
        ((j)this.Oyy).start();
      }
      if ((this.Oyz instanceof j)) {
        ((j)this.Oyz).start();
      }
      if ((this.OyA instanceof j)) {
        ((j)this.OyA).start();
      }
      AppMethodBeat.o(90099);
      return;
    }
    finally {}
  }
  
  private void gEb()
  {
    try
    {
      AppMethodBeat.i(90100);
      if ((this.Oyy instanceof j)) {
        ((j)this.Oyy).shutdown();
      }
      if ((this.Oyz instanceof j)) {
        ((j)this.Oyz).shutdown();
      }
      if ((this.OyA instanceof j)) {
        ((j)this.OyA).shutdown();
      }
      AppMethodBeat.o(90100);
      return;
    }
    finally {}
  }
  
  public static rx.g immediate()
  {
    return rx.internal.c.f.Oww;
  }
  
  public static rx.g io()
  {
    AppMethodBeat.i(90093);
    rx.g localg = rx.d.c.d(gDZ().Oyz);
    AppMethodBeat.o(90093);
    return localg;
  }
  
  public static rx.g newThread()
  {
    AppMethodBeat.i(90091);
    rx.g localg = rx.d.c.e(gDZ().OyA);
    AppMethodBeat.o(90091);
    return localg;
  }
  
  public static void reset()
  {
    AppMethodBeat.i(90096);
    Schedulers localSchedulers = (Schedulers)OyB.getAndSet(null);
    if (localSchedulers != null) {
      localSchedulers.gEb();
    }
    AppMethodBeat.o(90096);
  }
  
  public static void shutdown()
  {
    AppMethodBeat.i(90098);
    Schedulers localSchedulers = gDZ();
    localSchedulers.gEb();
    try
    {
      rx.internal.c.d.Owr.shutdown();
      rx.internal.util.f.OxA.shutdown();
      rx.internal.util.f.OxB.shutdown();
      return;
    }
    finally
    {
      AppMethodBeat.o(90098);
    }
  }
  
  public static void start()
  {
    AppMethodBeat.i(90097);
    Schedulers localSchedulers = gDZ();
    localSchedulers.gEa();
    try
    {
      rx.internal.c.d.Owr.start();
      rx.internal.util.f.OxA.start();
      rx.internal.util.f.OxB.start();
      return;
    }
    finally
    {
      AppMethodBeat.o(90097);
    }
  }
  
  public static TestScheduler test()
  {
    AppMethodBeat.i(90094);
    TestScheduler localTestScheduler = new TestScheduler();
    AppMethodBeat.o(90094);
    return localTestScheduler;
  }
  
  public static rx.g trampoline()
  {
    return m.Oxb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     rx.schedulers.Schedulers
 * JD-Core Version:    0.7.0.1
 */