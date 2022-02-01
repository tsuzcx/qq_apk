package rx.schedulers;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.c.j;
import rx.internal.c.m;

public final class Schedulers
{
  private static final AtomicReference<Schedulers> Uop;
  private final rx.g Uom;
  private final rx.g Uon;
  private final rx.g Uoo;
  
  static
  {
    AppMethodBeat.i(90101);
    Uop = new AtomicReference();
    AppMethodBeat.o(90101);
  }
  
  private Schedulers()
  {
    AppMethodBeat.i(90090);
    rx.d.f.hQW().hRb();
    this.Uom = rx.d.g.hRc();
    this.Uon = rx.d.g.hRd();
    this.Uoo = rx.d.g.hRe();
    AppMethodBeat.o(90090);
  }
  
  public static rx.g computation()
  {
    AppMethodBeat.i(90092);
    rx.g localg = rx.d.c.c(hRh().Uom);
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
  
  private static Schedulers hRh()
  {
    AppMethodBeat.i(90089);
    for (;;)
    {
      Schedulers localSchedulers = (Schedulers)Uop.get();
      if (localSchedulers != null)
      {
        AppMethodBeat.o(90089);
        return localSchedulers;
      }
      localSchedulers = new Schedulers();
      if (Uop.compareAndSet(null, localSchedulers))
      {
        AppMethodBeat.o(90089);
        return localSchedulers;
      }
      localSchedulers.hRj();
    }
  }
  
  private void hRi()
  {
    try
    {
      AppMethodBeat.i(90099);
      if ((this.Uom instanceof j)) {
        ((j)this.Uom).start();
      }
      if ((this.Uon instanceof j)) {
        ((j)this.Uon).start();
      }
      if ((this.Uoo instanceof j)) {
        ((j)this.Uoo).start();
      }
      AppMethodBeat.o(90099);
      return;
    }
    finally {}
  }
  
  private void hRj()
  {
    try
    {
      AppMethodBeat.i(90100);
      if ((this.Uom instanceof j)) {
        ((j)this.Uom).shutdown();
      }
      if ((this.Uon instanceof j)) {
        ((j)this.Uon).shutdown();
      }
      if ((this.Uoo instanceof j)) {
        ((j)this.Uoo).shutdown();
      }
      AppMethodBeat.o(90100);
      return;
    }
    finally {}
  }
  
  public static rx.g immediate()
  {
    return rx.internal.c.f.Umk;
  }
  
  public static rx.g io()
  {
    AppMethodBeat.i(90093);
    rx.g localg = rx.d.c.d(hRh().Uon);
    AppMethodBeat.o(90093);
    return localg;
  }
  
  public static rx.g newThread()
  {
    AppMethodBeat.i(90091);
    rx.g localg = rx.d.c.e(hRh().Uoo);
    AppMethodBeat.o(90091);
    return localg;
  }
  
  public static void reset()
  {
    AppMethodBeat.i(90096);
    Schedulers localSchedulers = (Schedulers)Uop.getAndSet(null);
    if (localSchedulers != null) {
      localSchedulers.hRj();
    }
    AppMethodBeat.o(90096);
  }
  
  public static void shutdown()
  {
    AppMethodBeat.i(90098);
    Schedulers localSchedulers = hRh();
    localSchedulers.hRj();
    try
    {
      rx.internal.c.d.Umf.shutdown();
      rx.internal.util.f.Uno.shutdown();
      rx.internal.util.f.Unp.shutdown();
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
    Schedulers localSchedulers = hRh();
    localSchedulers.hRi();
    try
    {
      rx.internal.c.d.Umf.start();
      rx.internal.util.f.Uno.start();
      rx.internal.util.f.Unp.start();
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
    return m.UmP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     rx.schedulers.Schedulers
 * JD-Core Version:    0.7.0.1
 */