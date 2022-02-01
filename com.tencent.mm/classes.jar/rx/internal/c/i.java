package rx.internal.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.a.f;
import rx.b.a;
import rx.d.c;
import rx.f.b;
import rx.j;

public final class i
  extends AtomicReference<Thread>
  implements Runnable, j
{
  final rx.internal.util.i MeA;
  final a MeB;
  
  public i(a parama)
  {
    AppMethodBeat.i(90341);
    this.MeB = parama;
    this.MeA = new rx.internal.util.i();
    AppMethodBeat.o(90341);
  }
  
  public i(a parama, b paramb)
  {
    AppMethodBeat.i(90342);
    this.MeB = parama;
    this.MeA = new rx.internal.util.i(new b(this, paramb));
    AppMethodBeat.o(90342);
  }
  
  public i(a parama, rx.internal.util.i parami)
  {
    AppMethodBeat.i(90343);
    this.MeB = parama;
    this.MeA = new rx.internal.util.i(new c(this, parami));
    AppMethodBeat.o(90343);
  }
  
  private static void N(Throwable paramThrowable)
  {
    AppMethodBeat.i(90345);
    c.onError(paramThrowable);
    Thread localThread = Thread.currentThread();
    localThread.getUncaughtExceptionHandler().uncaughtException(localThread, paramThrowable);
    AppMethodBeat.o(90345);
  }
  
  public final void b(Future<?> paramFuture)
  {
    AppMethodBeat.i(90347);
    this.MeA.b(new a(paramFuture));
    AppMethodBeat.o(90347);
  }
  
  public final void ggm()
  {
    AppMethodBeat.i(90346);
    if (!this.MeA.MfG) {
      this.MeA.ggm();
    }
    AppMethodBeat.o(90346);
  }
  
  public final boolean ggn()
  {
    return this.MeA.MfG;
  }
  
  public final void run()
  {
    AppMethodBeat.i(90344);
    try
    {
      lazySet(Thread.currentThread());
      this.MeB.call();
      return;
    }
    catch (f localf)
    {
      N(new IllegalStateException("Exception thrown on Scheduler.Worker thread. Add `onError` handling.", localf));
      return;
    }
    catch (Throwable localThrowable)
    {
      N(new IllegalStateException("Fatal Exception thrown on Scheduler.Worker thread.", localThrowable));
      return;
    }
    finally
    {
      ggm();
      AppMethodBeat.o(90344);
    }
  }
  
  final class a
    implements j
  {
    private final Future<?> MeC;
    
    a()
    {
      Object localObject;
      this.MeC = localObject;
    }
    
    public final void ggm()
    {
      AppMethodBeat.i(90337);
      if (i.this.get() != Thread.currentThread())
      {
        this.MeC.cancel(true);
        AppMethodBeat.o(90337);
        return;
      }
      this.MeC.cancel(false);
      AppMethodBeat.o(90337);
    }
    
    public final boolean ggn()
    {
      AppMethodBeat.i(90338);
      boolean bool = this.MeC.isCancelled();
      AppMethodBeat.o(90338);
      return bool;
    }
  }
  
  static final class b
    extends AtomicBoolean
    implements j
  {
    final i MeE;
    final b MeF;
    
    public b(i parami, b paramb)
    {
      this.MeE = parami;
      this.MeF = paramb;
    }
    
    public final void ggm()
    {
      AppMethodBeat.i(90339);
      if (compareAndSet(false, true)) {
        this.MeF.e(this.MeE);
      }
      AppMethodBeat.o(90339);
    }
    
    public final boolean ggn()
    {
      return this.MeE.MeA.MfG;
    }
  }
  
  static final class c
    extends AtomicBoolean
    implements j
  {
    final i MeE;
    final rx.internal.util.i MeG;
    
    public c(i parami, rx.internal.util.i parami1)
    {
      this.MeE = parami;
      this.MeG = parami1;
    }
    
    public final void ggm()
    {
      AppMethodBeat.i(90340);
      rx.internal.util.i locali;
      i locali1;
      if (compareAndSet(false, true))
      {
        locali = this.MeG;
        locali1 = this.MeE;
        if (locali.MfG) {}
      }
      try
      {
        List localList = locali.MfF;
        if ((locali.MfG) || (localList == null)) {
          return;
        }
        boolean bool = localList.remove(locali1);
        if (bool) {
          locali1.ggm();
        }
        AppMethodBeat.o(90340);
        return;
      }
      finally
      {
        AppMethodBeat.o(90340);
      }
    }
    
    public final boolean ggn()
    {
      return this.MeE.MeA.MfG;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     rx.internal.c.i
 * JD-Core Version:    0.7.0.1
 */