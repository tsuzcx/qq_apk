package rx.schedulers;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.c.j;
import rx.internal.c.m;

public final class Schedulers
{
  private static final AtomicReference<Schedulers> KsL;
  private final rx.g KsI;
  private final rx.g KsJ;
  private final rx.g KsK;
  
  static
  {
    AppMethodBeat.i(90101);
    KsL = new AtomicReference();
    AppMethodBeat.o(90101);
  }
  
  private Schedulers()
  {
    AppMethodBeat.i(90090);
    rx.d.f.fNS().fNX();
    this.KsI = rx.d.g.fNY();
    this.KsJ = rx.d.g.fNZ();
    this.KsK = rx.d.g.fOa();
    AppMethodBeat.o(90090);
  }
  
  public static rx.g computation()
  {
    AppMethodBeat.i(90092);
    rx.g localg = rx.d.c.c(fOd().KsI);
    AppMethodBeat.o(90092);
    return localg;
  }
  
  private static Schedulers fOd()
  {
    AppMethodBeat.i(90089);
    for (;;)
    {
      Schedulers localSchedulers = (Schedulers)KsL.get();
      if (localSchedulers != null)
      {
        AppMethodBeat.o(90089);
        return localSchedulers;
      }
      localSchedulers = new Schedulers();
      if (KsL.compareAndSet(null, localSchedulers))
      {
        AppMethodBeat.o(90089);
        return localSchedulers;
      }
      localSchedulers.fOf();
    }
  }
  
  private void fOe()
  {
    try
    {
      AppMethodBeat.i(90099);
      if ((this.KsI instanceof j)) {
        ((j)this.KsI).start();
      }
      if ((this.KsJ instanceof j)) {
        ((j)this.KsJ).start();
      }
      if ((this.KsK instanceof j)) {
        ((j)this.KsK).start();
      }
      AppMethodBeat.o(90099);
      return;
    }
    finally {}
  }
  
  private void fOf()
  {
    try
    {
      AppMethodBeat.i(90100);
      if ((this.KsI instanceof j)) {
        ((j)this.KsI).shutdown();
      }
      if ((this.KsJ instanceof j)) {
        ((j)this.KsJ).shutdown();
      }
      if ((this.KsK instanceof j)) {
        ((j)this.KsK).shutdown();
      }
      AppMethodBeat.o(90100);
      return;
    }
    finally {}
  }
  
  public static rx.g from(Executor paramExecutor)
  {
    AppMethodBeat.i(90095);
    paramExecutor = new rx.internal.c.c(paramExecutor);
    AppMethodBeat.o(90095);
    return paramExecutor;
  }
  
  public static rx.g immediate()
  {
    return rx.internal.c.f.KqG;
  }
  
  public static rx.g io()
  {
    AppMethodBeat.i(90093);
    rx.g localg = rx.d.c.d(fOd().KsJ);
    AppMethodBeat.o(90093);
    return localg;
  }
  
  public static rx.g newThread()
  {
    AppMethodBeat.i(90091);
    rx.g localg = rx.d.c.e(fOd().KsK);
    AppMethodBeat.o(90091);
    return localg;
  }
  
  public static void reset()
  {
    AppMethodBeat.i(90096);
    Schedulers localSchedulers = (Schedulers)KsL.getAndSet(null);
    if (localSchedulers != null) {
      localSchedulers.fOf();
    }
    AppMethodBeat.o(90096);
  }
  
  public static void shutdown()
  {
    AppMethodBeat.i(90098);
    Schedulers localSchedulers = fOd();
    localSchedulers.fOf();
    try
    {
      rx.internal.c.d.KqB.shutdown();
      rx.internal.util.f.KrK.shutdown();
      rx.internal.util.f.KrL.shutdown();
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
    Schedulers localSchedulers = fOd();
    localSchedulers.fOe();
    try
    {
      rx.internal.c.d.KqB.start();
      rx.internal.util.f.KrK.start();
      rx.internal.util.f.KrL.start();
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
    return m.Krl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     rx.schedulers.Schedulers
 * JD-Core Version:    0.7.0.1
 */