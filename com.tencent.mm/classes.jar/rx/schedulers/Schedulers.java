package rx.schedulers;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.c.j;
import rx.internal.c.m;

public final class Schedulers
{
  private static final AtomicReference<Schedulers> Mgu;
  private final rx.g Mgr;
  private final rx.g Mgs;
  private final rx.g Mgt;
  
  static
  {
    AppMethodBeat.i(90101);
    Mgu = new AtomicReference();
    AppMethodBeat.o(90101);
  }
  
  private Schedulers()
  {
    AppMethodBeat.i(90090);
    rx.d.f.ggI().ggN();
    this.Mgr = rx.d.g.ggO();
    this.Mgs = rx.d.g.ggP();
    this.Mgt = rx.d.g.ggQ();
    AppMethodBeat.o(90090);
  }
  
  public static rx.g computation()
  {
    AppMethodBeat.i(90092);
    rx.g localg = rx.d.c.c(ggT().Mgr);
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
  
  private static Schedulers ggT()
  {
    AppMethodBeat.i(90089);
    for (;;)
    {
      Schedulers localSchedulers = (Schedulers)Mgu.get();
      if (localSchedulers != null)
      {
        AppMethodBeat.o(90089);
        return localSchedulers;
      }
      localSchedulers = new Schedulers();
      if (Mgu.compareAndSet(null, localSchedulers))
      {
        AppMethodBeat.o(90089);
        return localSchedulers;
      }
      localSchedulers.ggV();
    }
  }
  
  private void ggU()
  {
    try
    {
      AppMethodBeat.i(90099);
      if ((this.Mgr instanceof j)) {
        ((j)this.Mgr).start();
      }
      if ((this.Mgs instanceof j)) {
        ((j)this.Mgs).start();
      }
      if ((this.Mgt instanceof j)) {
        ((j)this.Mgt).start();
      }
      AppMethodBeat.o(90099);
      return;
    }
    finally {}
  }
  
  private void ggV()
  {
    try
    {
      AppMethodBeat.i(90100);
      if ((this.Mgr instanceof j)) {
        ((j)this.Mgr).shutdown();
      }
      if ((this.Mgs instanceof j)) {
        ((j)this.Mgs).shutdown();
      }
      if ((this.Mgt instanceof j)) {
        ((j)this.Mgt).shutdown();
      }
      AppMethodBeat.o(90100);
      return;
    }
    finally {}
  }
  
  public static rx.g immediate()
  {
    return rx.internal.c.f.Mep;
  }
  
  public static rx.g io()
  {
    AppMethodBeat.i(90093);
    rx.g localg = rx.d.c.d(ggT().Mgs);
    AppMethodBeat.o(90093);
    return localg;
  }
  
  public static rx.g newThread()
  {
    AppMethodBeat.i(90091);
    rx.g localg = rx.d.c.e(ggT().Mgt);
    AppMethodBeat.o(90091);
    return localg;
  }
  
  public static void reset()
  {
    AppMethodBeat.i(90096);
    Schedulers localSchedulers = (Schedulers)Mgu.getAndSet(null);
    if (localSchedulers != null) {
      localSchedulers.ggV();
    }
    AppMethodBeat.o(90096);
  }
  
  public static void shutdown()
  {
    AppMethodBeat.i(90098);
    Schedulers localSchedulers = ggT();
    localSchedulers.ggV();
    try
    {
      rx.internal.c.d.Mek.shutdown();
      rx.internal.util.f.Mft.shutdown();
      rx.internal.util.f.Mfu.shutdown();
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
    Schedulers localSchedulers = ggT();
    localSchedulers.ggU();
    try
    {
      rx.internal.c.d.Mek.start();
      rx.internal.util.f.Mft.start();
      rx.internal.util.f.Mfu.start();
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
    return m.MeU;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     rx.schedulers.Schedulers
 * JD-Core Version:    0.7.0.1
 */