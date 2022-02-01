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
  final rx.internal.util.i KqR;
  final a KqS;
  
  public i(a parama)
  {
    AppMethodBeat.i(90341);
    this.KqS = parama;
    this.KqR = new rx.internal.util.i();
    AppMethodBeat.o(90341);
  }
  
  public i(a parama, b paramb)
  {
    AppMethodBeat.i(90342);
    this.KqS = parama;
    this.KqR = new rx.internal.util.i(new b(this, paramb));
    AppMethodBeat.o(90342);
  }
  
  public i(a parama, rx.internal.util.i parami)
  {
    AppMethodBeat.i(90343);
    this.KqS = parama;
    this.KqR = new rx.internal.util.i(new c(this, parami));
    AppMethodBeat.o(90343);
  }
  
  private static void M(Throwable paramThrowable)
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
    this.KqR.b(new a(paramFuture));
    AppMethodBeat.o(90347);
  }
  
  public final void fNw()
  {
    AppMethodBeat.i(90346);
    if (!this.KqR.KrX) {
      this.KqR.fNw();
    }
    AppMethodBeat.o(90346);
  }
  
  public final boolean fNx()
  {
    return this.KqR.KrX;
  }
  
  public final void run()
  {
    AppMethodBeat.i(90344);
    try
    {
      lazySet(Thread.currentThread());
      this.KqS.call();
      return;
    }
    catch (f localf)
    {
      M(new IllegalStateException("Exception thrown on Scheduler.Worker thread. Add `onError` handling.", localf));
      return;
    }
    catch (Throwable localThrowable)
    {
      M(new IllegalStateException("Fatal Exception thrown on Scheduler.Worker thread.", localThrowable));
      return;
    }
    finally
    {
      fNw();
      AppMethodBeat.o(90344);
    }
  }
  
  final class a
    implements j
  {
    private final Future<?> KqT;
    
    a()
    {
      Object localObject;
      this.KqT = localObject;
    }
    
    public final void fNw()
    {
      AppMethodBeat.i(90337);
      if (i.this.get() != Thread.currentThread())
      {
        this.KqT.cancel(true);
        AppMethodBeat.o(90337);
        return;
      }
      this.KqT.cancel(false);
      AppMethodBeat.o(90337);
    }
    
    public final boolean fNx()
    {
      AppMethodBeat.i(90338);
      boolean bool = this.KqT.isCancelled();
      AppMethodBeat.o(90338);
      return bool;
    }
  }
  
  static final class b
    extends AtomicBoolean
    implements j
  {
    final i KqV;
    final b KqW;
    
    public b(i parami, b paramb)
    {
      this.KqV = parami;
      this.KqW = paramb;
    }
    
    public final void fNw()
    {
      AppMethodBeat.i(90339);
      if (compareAndSet(false, true)) {
        this.KqW.e(this.KqV);
      }
      AppMethodBeat.o(90339);
    }
    
    public final boolean fNx()
    {
      return this.KqV.KqR.KrX;
    }
  }
  
  static final class c
    extends AtomicBoolean
    implements j
  {
    final i KqV;
    final rx.internal.util.i KqX;
    
    public c(i parami, rx.internal.util.i parami1)
    {
      this.KqV = parami;
      this.KqX = parami1;
    }
    
    public final void fNw()
    {
      AppMethodBeat.i(90340);
      rx.internal.util.i locali;
      i locali1;
      if (compareAndSet(false, true))
      {
        locali = this.KqX;
        locali1 = this.KqV;
        if (locali.KrX) {}
      }
      try
      {
        List localList = locali.KrW;
        if ((locali.KrX) || (localList == null)) {
          return;
        }
        boolean bool = localList.remove(locali1);
        if (bool) {
          locali1.fNw();
        }
        AppMethodBeat.o(90340);
        return;
      }
      finally
      {
        AppMethodBeat.o(90340);
      }
    }
    
    public final boolean fNx()
    {
      return this.KqV.KqR.KrX;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     rx.internal.c.i
 * JD-Core Version:    0.7.0.1
 */