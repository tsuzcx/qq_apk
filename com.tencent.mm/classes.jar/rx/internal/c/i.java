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
  final rx.internal.util.i OwH;
  final a OwI;
  
  public i(a parama)
  {
    AppMethodBeat.i(90341);
    this.OwI = parama;
    this.OwH = new rx.internal.util.i();
    AppMethodBeat.o(90341);
  }
  
  public i(a parama, b paramb)
  {
    AppMethodBeat.i(90342);
    this.OwI = parama;
    this.OwH = new rx.internal.util.i(new b(this, paramb));
    AppMethodBeat.o(90342);
  }
  
  public i(a parama, rx.internal.util.i parami)
  {
    AppMethodBeat.i(90343);
    this.OwI = parama;
    this.OwH = new rx.internal.util.i(new c(this, parami));
    AppMethodBeat.o(90343);
  }
  
  private static void P(Throwable paramThrowable)
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
    this.OwH.b(new a(paramFuture));
    AppMethodBeat.o(90347);
  }
  
  public final void gDs()
  {
    AppMethodBeat.i(90346);
    if (!this.OwH.OxN) {
      this.OwH.gDs();
    }
    AppMethodBeat.o(90346);
  }
  
  public final boolean gDt()
  {
    return this.OwH.OxN;
  }
  
  public final void run()
  {
    AppMethodBeat.i(90344);
    try
    {
      lazySet(Thread.currentThread());
      this.OwI.call();
      return;
    }
    catch (f localf)
    {
      P(new IllegalStateException("Exception thrown on Scheduler.Worker thread. Add `onError` handling.", localf));
      return;
    }
    catch (Throwable localThrowable)
    {
      P(new IllegalStateException("Fatal Exception thrown on Scheduler.Worker thread.", localThrowable));
      return;
    }
    finally
    {
      gDs();
      AppMethodBeat.o(90344);
    }
  }
  
  final class a
    implements j
  {
    private final Future<?> OwJ;
    
    a()
    {
      Object localObject;
      this.OwJ = localObject;
    }
    
    public final void gDs()
    {
      AppMethodBeat.i(90337);
      if (i.this.get() != Thread.currentThread())
      {
        this.OwJ.cancel(true);
        AppMethodBeat.o(90337);
        return;
      }
      this.OwJ.cancel(false);
      AppMethodBeat.o(90337);
    }
    
    public final boolean gDt()
    {
      AppMethodBeat.i(90338);
      boolean bool = this.OwJ.isCancelled();
      AppMethodBeat.o(90338);
      return bool;
    }
  }
  
  static final class b
    extends AtomicBoolean
    implements j
  {
    final i OwL;
    final b OwM;
    
    public b(i parami, b paramb)
    {
      this.OwL = parami;
      this.OwM = paramb;
    }
    
    public final void gDs()
    {
      AppMethodBeat.i(90339);
      if (compareAndSet(false, true)) {
        this.OwM.e(this.OwL);
      }
      AppMethodBeat.o(90339);
    }
    
    public final boolean gDt()
    {
      return this.OwL.OwH.OxN;
    }
  }
  
  static final class c
    extends AtomicBoolean
    implements j
  {
    final i OwL;
    final rx.internal.util.i OwN;
    
    public c(i parami, rx.internal.util.i parami1)
    {
      this.OwL = parami;
      this.OwN = parami1;
    }
    
    public final void gDs()
    {
      AppMethodBeat.i(90340);
      rx.internal.util.i locali;
      i locali1;
      if (compareAndSet(false, true))
      {
        locali = this.OwN;
        locali1 = this.OwL;
        if (locali.OxN) {}
      }
      try
      {
        List localList = locali.OxM;
        if ((locali.OxN) || (localList == null)) {
          return;
        }
        boolean bool = localList.remove(locali1);
        if (bool) {
          locali1.gDs();
        }
        AppMethodBeat.o(90340);
        return;
      }
      finally
      {
        AppMethodBeat.o(90340);
      }
    }
    
    public final boolean gDt()
    {
      return this.OwL.OwH.OxN;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     rx.internal.c.i
 * JD-Core Version:    0.7.0.1
 */