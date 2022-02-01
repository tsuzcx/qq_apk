package rx.schedulers;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.c.j;
import rx.internal.c.m;

public final class Schedulers
{
  private static final AtomicReference<Schedulers> akev;
  private final rx.g akes;
  private final rx.g aket;
  private final rx.g akeu;
  
  static
  {
    AppMethodBeat.i(90101);
    akev = new AtomicReference();
    AppMethodBeat.o(90101);
  }
  
  private Schedulers()
  {
    AppMethodBeat.i(90090);
    rx.d.f.kKE().kKJ();
    rx.g localg = rx.d.g.kKN();
    if (localg != null)
    {
      this.akes = localg;
      localg = rx.d.g.kKO();
      if (localg == null) {
        break label71;
      }
    }
    label71:
    for (this.aket = localg;; this.aket = rx.d.g.kKL())
    {
      localg = rx.d.g.kKP();
      if (localg == null) {
        break label81;
      }
      this.akeu = localg;
      AppMethodBeat.o(90090);
      return;
      this.akes = rx.d.g.kKK();
      break;
    }
    label81:
    this.akeu = rx.d.g.kKM();
    AppMethodBeat.o(90090);
  }
  
  public static rx.g computation()
  {
    AppMethodBeat.i(90092);
    rx.g localg = rx.d.c.b(kKS().akes);
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
  
  public static rx.g immediate()
  {
    return rx.internal.c.f.akcy;
  }
  
  public static rx.g io()
  {
    AppMethodBeat.i(90093);
    rx.g localg = rx.d.c.c(kKS().aket);
    AppMethodBeat.o(90093);
    return localg;
  }
  
  private static Schedulers kKS()
  {
    AppMethodBeat.i(90089);
    for (;;)
    {
      Schedulers localSchedulers = (Schedulers)akev.get();
      if (localSchedulers != null)
      {
        AppMethodBeat.o(90089);
        return localSchedulers;
      }
      localSchedulers = new Schedulers();
      if (akev.compareAndSet(null, localSchedulers))
      {
        AppMethodBeat.o(90089);
        return localSchedulers;
      }
      localSchedulers.kKU();
    }
  }
  
  private void kKT()
  {
    try
    {
      AppMethodBeat.i(90099);
      if ((this.akes instanceof j)) {
        ((j)this.akes).start();
      }
      if ((this.aket instanceof j)) {
        ((j)this.aket).start();
      }
      if ((this.akeu instanceof j)) {
        ((j)this.akeu).start();
      }
      AppMethodBeat.o(90099);
      return;
    }
    finally {}
  }
  
  private void kKU()
  {
    try
    {
      AppMethodBeat.i(90100);
      if ((this.akes instanceof j)) {
        ((j)this.akes).shutdown();
      }
      if ((this.aket instanceof j)) {
        ((j)this.aket).shutdown();
      }
      if ((this.akeu instanceof j)) {
        ((j)this.akeu).shutdown();
      }
      AppMethodBeat.o(90100);
      return;
    }
    finally {}
  }
  
  public static rx.g newThread()
  {
    AppMethodBeat.i(90091);
    rx.g localg = rx.d.c.d(kKS().akeu);
    AppMethodBeat.o(90091);
    return localg;
  }
  
  public static void reset()
  {
    AppMethodBeat.i(90096);
    Schedulers localSchedulers = (Schedulers)akev.getAndSet(null);
    if (localSchedulers != null) {
      localSchedulers.kKU();
    }
    AppMethodBeat.o(90096);
  }
  
  public static void shutdown()
  {
    AppMethodBeat.i(90098);
    Schedulers localSchedulers = kKS();
    localSchedulers.kKU();
    try
    {
      rx.internal.c.d.akct.shutdown();
      rx.internal.util.f.akdC.shutdown();
      rx.internal.util.f.akdD.shutdown();
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
    Schedulers localSchedulers = kKS();
    localSchedulers.kKT();
    try
    {
      rx.internal.c.d.akct.start();
      rx.internal.util.f.akdC.start();
      rx.internal.util.f.akdD.start();
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
    return m.akdd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     rx.schedulers.Schedulers
 * JD-Core Version:    0.7.0.1
 */