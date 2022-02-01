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
  final rx.internal.util.i abPR;
  final a abPS;
  
  public i(a parama)
  {
    AppMethodBeat.i(90341);
    this.abPS = parama;
    this.abPR = new rx.internal.util.i();
    AppMethodBeat.o(90341);
  }
  
  public i(a parama, b paramb)
  {
    AppMethodBeat.i(90342);
    this.abPS = parama;
    this.abPR = new rx.internal.util.i(new b(this, paramb));
    AppMethodBeat.o(90342);
  }
  
  public i(a parama, rx.internal.util.i parami)
  {
    AppMethodBeat.i(90343);
    this.abPS = parama;
    this.abPR = new rx.internal.util.i(new c(this, parami));
    AppMethodBeat.o(90343);
  }
  
  private static void V(Throwable paramThrowable)
  {
    AppMethodBeat.i(90345);
    c.c(paramThrowable);
    Thread localThread = Thread.currentThread();
    localThread.getUncaughtExceptionHandler().uncaughtException(localThread, paramThrowable);
    AppMethodBeat.o(90345);
  }
  
  public final void b(Future<?> paramFuture)
  {
    AppMethodBeat.i(90347);
    this.abPR.b(new a(paramFuture));
    AppMethodBeat.o(90347);
  }
  
  public final void iVJ()
  {
    AppMethodBeat.i(90346);
    if (!this.abPR.abQP) {
      this.abPR.iVJ();
    }
    AppMethodBeat.o(90346);
  }
  
  public final boolean iVK()
  {
    return this.abPR.abQP;
  }
  
  public final void run()
  {
    AppMethodBeat.i(90344);
    try
    {
      lazySet(Thread.currentThread());
      this.abPS.call();
      return;
    }
    catch (f localf)
    {
      V(new IllegalStateException("Exception thrown on Scheduler.Worker thread. Add `onError` handling.", localf));
      return;
    }
    catch (Throwable localThrowable)
    {
      V(new IllegalStateException("Fatal Exception thrown on Scheduler.Worker thread.", localThrowable));
      return;
    }
    finally
    {
      iVJ();
      AppMethodBeat.o(90344);
    }
  }
  
  final class a
    implements j
  {
    private final Future<?> abPT;
    
    a()
    {
      Object localObject;
      this.abPT = localObject;
    }
    
    public final void iVJ()
    {
      AppMethodBeat.i(90337);
      if (i.this.get() != Thread.currentThread())
      {
        this.abPT.cancel(true);
        AppMethodBeat.o(90337);
        return;
      }
      this.abPT.cancel(false);
      AppMethodBeat.o(90337);
    }
    
    public final boolean iVK()
    {
      AppMethodBeat.i(90338);
      boolean bool = this.abPT.isCancelled();
      AppMethodBeat.o(90338);
      return bool;
    }
  }
  
  static final class b
    extends AtomicBoolean
    implements j
  {
    final i abPV;
    final b abPW;
    
    public b(i parami, b paramb)
    {
      this.abPV = parami;
      this.abPW = paramb;
    }
    
    public final void iVJ()
    {
      AppMethodBeat.i(90339);
      if (compareAndSet(false, true)) {
        this.abPW.e(this.abPV);
      }
      AppMethodBeat.o(90339);
    }
    
    public final boolean iVK()
    {
      return this.abPV.abPR.abQP;
    }
  }
  
  static final class c
    extends AtomicBoolean
    implements j
  {
    final i abPV;
    final rx.internal.util.i abPX;
    
    public c(i parami, rx.internal.util.i parami1)
    {
      this.abPV = parami;
      this.abPX = parami1;
    }
    
    public final void iVJ()
    {
      AppMethodBeat.i(90340);
      rx.internal.util.i locali;
      i locali1;
      if (compareAndSet(false, true))
      {
        locali = this.abPX;
        locali1 = this.abPV;
        if (locali.abQP) {}
      }
      try
      {
        List localList = locali.abQO;
        if ((locali.abQP) || (localList == null)) {
          return;
        }
        boolean bool = localList.remove(locali1);
        if (bool) {
          locali1.iVJ();
        }
        AppMethodBeat.o(90340);
        return;
      }
      finally
      {
        AppMethodBeat.o(90340);
      }
    }
    
    public final boolean iVK()
    {
      return this.abPV.abPR.abQP;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     rx.internal.c.i
 * JD-Core Version:    0.7.0.1
 */