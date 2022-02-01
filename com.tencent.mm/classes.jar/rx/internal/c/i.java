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
  final rx.internal.util.i NZC;
  final a NZD;
  
  public i(a parama)
  {
    AppMethodBeat.i(90341);
    this.NZD = parama;
    this.NZC = new rx.internal.util.i();
    AppMethodBeat.o(90341);
  }
  
  public i(a parama, b paramb)
  {
    AppMethodBeat.i(90342);
    this.NZD = parama;
    this.NZC = new rx.internal.util.i(new b(this, paramb));
    AppMethodBeat.o(90342);
  }
  
  public i(a parama, rx.internal.util.i parami)
  {
    AppMethodBeat.i(90343);
    this.NZD = parama;
    this.NZC = new rx.internal.util.i(new c(this, parami));
    AppMethodBeat.o(90343);
  }
  
  private static void O(Throwable paramThrowable)
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
    this.NZC.b(new i.a(this, paramFuture));
    AppMethodBeat.o(90347);
  }
  
  public final void gyQ()
  {
    AppMethodBeat.i(90346);
    if (!this.NZC.OaI) {
      this.NZC.gyQ();
    }
    AppMethodBeat.o(90346);
  }
  
  public final boolean gyR()
  {
    return this.NZC.OaI;
  }
  
  public final void run()
  {
    AppMethodBeat.i(90344);
    try
    {
      lazySet(Thread.currentThread());
      this.NZD.call();
      return;
    }
    catch (f localf)
    {
      O(new IllegalStateException("Exception thrown on Scheduler.Worker thread. Add `onError` handling.", localf));
      return;
    }
    catch (Throwable localThrowable)
    {
      O(new IllegalStateException("Fatal Exception thrown on Scheduler.Worker thread.", localThrowable));
      return;
    }
    finally
    {
      gyQ();
      AppMethodBeat.o(90344);
    }
  }
  
  static final class b
    extends AtomicBoolean
    implements j
  {
    final i NZG;
    final b NZH;
    
    public b(i parami, b paramb)
    {
      this.NZG = parami;
      this.NZH = paramb;
    }
    
    public final void gyQ()
    {
      AppMethodBeat.i(90339);
      if (compareAndSet(false, true)) {
        this.NZH.e(this.NZG);
      }
      AppMethodBeat.o(90339);
    }
    
    public final boolean gyR()
    {
      return this.NZG.NZC.OaI;
    }
  }
  
  static final class c
    extends AtomicBoolean
    implements j
  {
    final i NZG;
    final rx.internal.util.i NZI;
    
    public c(i parami, rx.internal.util.i parami1)
    {
      this.NZG = parami;
      this.NZI = parami1;
    }
    
    public final void gyQ()
    {
      AppMethodBeat.i(90340);
      rx.internal.util.i locali;
      i locali1;
      if (compareAndSet(false, true))
      {
        locali = this.NZI;
        locali1 = this.NZG;
        if (locali.OaI) {}
      }
      try
      {
        List localList = locali.OaH;
        if ((locali.OaI) || (localList == null)) {
          return;
        }
        boolean bool = localList.remove(locali1);
        if (bool) {
          locali1.gyQ();
        }
        AppMethodBeat.o(90340);
        return;
      }
      finally
      {
        AppMethodBeat.o(90340);
      }
    }
    
    public final boolean gyR()
    {
      return this.NZG.NZC.OaI;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     rx.internal.c.i
 * JD-Core Version:    0.7.0.1
 */