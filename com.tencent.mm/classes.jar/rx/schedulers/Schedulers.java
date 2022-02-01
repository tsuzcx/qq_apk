package rx.schedulers;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.c.j;
import rx.internal.c.m;

public final class Schedulers
{
  private static final AtomicReference<Schedulers> abRD;
  private final rx.g abRA;
  private final rx.g abRB;
  private final rx.g abRC;
  
  static
  {
    AppMethodBeat.i(90101);
    abRD = new AtomicReference();
    AppMethodBeat.o(90101);
  }
  
  private Schedulers()
  {
    AppMethodBeat.i(90090);
    rx.d.f.iWg().iWl();
    this.abRA = rx.d.g.iWm();
    this.abRB = rx.d.g.iWn();
    this.abRC = rx.d.g.iWo();
    AppMethodBeat.o(90090);
  }
  
  public static rx.g computation()
  {
    AppMethodBeat.i(90092);
    rx.g localg = rx.d.c.b(iWr().abRA);
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
  
  private static Schedulers iWr()
  {
    AppMethodBeat.i(90089);
    for (;;)
    {
      Schedulers localSchedulers = (Schedulers)abRD.get();
      if (localSchedulers != null)
      {
        AppMethodBeat.o(90089);
        return localSchedulers;
      }
      localSchedulers = new Schedulers();
      if (abRD.compareAndSet(null, localSchedulers))
      {
        AppMethodBeat.o(90089);
        return localSchedulers;
      }
      localSchedulers.iWt();
    }
  }
  
  private void iWs()
  {
    try
    {
      AppMethodBeat.i(90099);
      if ((this.abRA instanceof j)) {
        ((j)this.abRA).start();
      }
      if ((this.abRB instanceof j)) {
        ((j)this.abRB).start();
      }
      if ((this.abRC instanceof j)) {
        ((j)this.abRC).start();
      }
      AppMethodBeat.o(90099);
      return;
    }
    finally {}
  }
  
  private void iWt()
  {
    try
    {
      AppMethodBeat.i(90100);
      if ((this.abRA instanceof j)) {
        ((j)this.abRA).shutdown();
      }
      if ((this.abRB instanceof j)) {
        ((j)this.abRB).shutdown();
      }
      if ((this.abRC instanceof j)) {
        ((j)this.abRC).shutdown();
      }
      AppMethodBeat.o(90100);
      return;
    }
    finally {}
  }
  
  public static rx.g immediate()
  {
    return rx.internal.c.f.abPG;
  }
  
  public static rx.g io()
  {
    AppMethodBeat.i(90093);
    rx.g localg = rx.d.c.c(iWr().abRB);
    AppMethodBeat.o(90093);
    return localg;
  }
  
  public static rx.g newThread()
  {
    AppMethodBeat.i(90091);
    rx.g localg = rx.d.c.d(iWr().abRC);
    AppMethodBeat.o(90091);
    return localg;
  }
  
  public static void reset()
  {
    AppMethodBeat.i(90096);
    Schedulers localSchedulers = (Schedulers)abRD.getAndSet(null);
    if (localSchedulers != null) {
      localSchedulers.iWt();
    }
    AppMethodBeat.o(90096);
  }
  
  public static void shutdown()
  {
    AppMethodBeat.i(90098);
    Schedulers localSchedulers = iWr();
    localSchedulers.iWt();
    try
    {
      rx.internal.c.d.abPB.shutdown();
      rx.internal.util.f.abQK.shutdown();
      rx.internal.util.f.abQL.shutdown();
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
    Schedulers localSchedulers = iWr();
    localSchedulers.iWs();
    try
    {
      rx.internal.c.d.abPB.start();
      rx.internal.util.f.abQK.start();
      rx.internal.util.f.abQL.start();
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
    return m.abQl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     rx.schedulers.Schedulers
 * JD-Core Version:    0.7.0.1
 */