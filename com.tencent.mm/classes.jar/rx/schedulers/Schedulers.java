package rx.schedulers;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.c.j;
import rx.internal.c.m;

public final class Schedulers
{
  private static final AtomicReference<Schedulers> Obw;
  private final rx.g Obt;
  private final rx.g Obu;
  private final rx.g Obv;
  
  static
  {
    AppMethodBeat.i(90101);
    Obw = new AtomicReference();
    AppMethodBeat.o(90101);
  }
  
  private Schedulers()
  {
    AppMethodBeat.i(90090);
    rx.d.f.gzm().gzr();
    this.Obt = rx.d.g.gzs();
    this.Obu = rx.d.g.gzt();
    this.Obv = rx.d.g.gzu();
    AppMethodBeat.o(90090);
  }
  
  public static rx.g computation()
  {
    AppMethodBeat.i(90092);
    rx.g localg = rx.d.c.c(gzx().Obt);
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
  
  private static Schedulers gzx()
  {
    AppMethodBeat.i(90089);
    for (;;)
    {
      Schedulers localSchedulers = (Schedulers)Obw.get();
      if (localSchedulers != null)
      {
        AppMethodBeat.o(90089);
        return localSchedulers;
      }
      localSchedulers = new Schedulers();
      if (Obw.compareAndSet(null, localSchedulers))
      {
        AppMethodBeat.o(90089);
        return localSchedulers;
      }
      localSchedulers.gzz();
    }
  }
  
  private void gzy()
  {
    try
    {
      AppMethodBeat.i(90099);
      if ((this.Obt instanceof j)) {
        ((j)this.Obt).start();
      }
      if ((this.Obu instanceof j)) {
        ((j)this.Obu).start();
      }
      if ((this.Obv instanceof j)) {
        ((j)this.Obv).start();
      }
      AppMethodBeat.o(90099);
      return;
    }
    finally {}
  }
  
  private void gzz()
  {
    try
    {
      AppMethodBeat.i(90100);
      if ((this.Obt instanceof j)) {
        ((j)this.Obt).shutdown();
      }
      if ((this.Obu instanceof j)) {
        ((j)this.Obu).shutdown();
      }
      if ((this.Obv instanceof j)) {
        ((j)this.Obv).shutdown();
      }
      AppMethodBeat.o(90100);
      return;
    }
    finally {}
  }
  
  public static rx.g immediate()
  {
    return rx.internal.c.f.NZr;
  }
  
  public static rx.g io()
  {
    AppMethodBeat.i(90093);
    rx.g localg = rx.d.c.d(gzx().Obu);
    AppMethodBeat.o(90093);
    return localg;
  }
  
  public static rx.g newThread()
  {
    AppMethodBeat.i(90091);
    rx.g localg = rx.d.c.e(gzx().Obv);
    AppMethodBeat.o(90091);
    return localg;
  }
  
  public static void reset()
  {
    AppMethodBeat.i(90096);
    Schedulers localSchedulers = (Schedulers)Obw.getAndSet(null);
    if (localSchedulers != null) {
      localSchedulers.gzz();
    }
    AppMethodBeat.o(90096);
  }
  
  public static void shutdown()
  {
    AppMethodBeat.i(90098);
    Schedulers localSchedulers = gzx();
    localSchedulers.gzz();
    try
    {
      rx.internal.c.d.NZm.shutdown();
      rx.internal.util.f.Oav.shutdown();
      rx.internal.util.f.Oaw.shutdown();
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
    Schedulers localSchedulers = gzx();
    localSchedulers.gzy();
    try
    {
      rx.internal.c.d.NZm.start();
      rx.internal.util.f.Oav.start();
      rx.internal.util.f.Oaw.start();
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
    return m.NZW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     rx.schedulers.Schedulers
 * JD-Core Version:    0.7.0.1
 */