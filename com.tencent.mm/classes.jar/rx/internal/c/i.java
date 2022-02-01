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
  final rx.internal.util.i Umv;
  final a Umw;
  
  public i(a parama)
  {
    AppMethodBeat.i(90341);
    this.Umw = parama;
    this.Umv = new rx.internal.util.i();
    AppMethodBeat.o(90341);
  }
  
  public i(a parama, b paramb)
  {
    AppMethodBeat.i(90342);
    this.Umw = parama;
    this.Umv = new rx.internal.util.i(new b(this, paramb));
    AppMethodBeat.o(90342);
  }
  
  public i(a parama, rx.internal.util.i parami)
  {
    AppMethodBeat.i(90343);
    this.Umw = parama;
    this.Umv = new rx.internal.util.i(new c(this, parami));
    AppMethodBeat.o(90343);
  }
  
  private static void R(Throwable paramThrowable)
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
    this.Umv.b(new i.a(this, paramFuture));
    AppMethodBeat.o(90347);
  }
  
  public final void hQA()
  {
    AppMethodBeat.i(90346);
    if (!this.Umv.UnB) {
      this.Umv.hQA();
    }
    AppMethodBeat.o(90346);
  }
  
  public final boolean hQB()
  {
    return this.Umv.UnB;
  }
  
  public final void run()
  {
    AppMethodBeat.i(90344);
    try
    {
      lazySet(Thread.currentThread());
      this.Umw.call();
      return;
    }
    catch (f localf)
    {
      R(new IllegalStateException("Exception thrown on Scheduler.Worker thread. Add `onError` handling.", localf));
      return;
    }
    catch (Throwable localThrowable)
    {
      R(new IllegalStateException("Fatal Exception thrown on Scheduler.Worker thread.", localThrowable));
      return;
    }
    finally
    {
      hQA();
      AppMethodBeat.o(90344);
    }
  }
  
  static final class b
    extends AtomicBoolean
    implements j
  {
    final b UmA;
    final i Umz;
    
    public b(i parami, b paramb)
    {
      this.Umz = parami;
      this.UmA = paramb;
    }
    
    public final void hQA()
    {
      AppMethodBeat.i(90339);
      if (compareAndSet(false, true)) {
        this.UmA.e(this.Umz);
      }
      AppMethodBeat.o(90339);
    }
    
    public final boolean hQB()
    {
      return this.Umz.Umv.UnB;
    }
  }
  
  static final class c
    extends AtomicBoolean
    implements j
  {
    final rx.internal.util.i UmB;
    final i Umz;
    
    public c(i parami, rx.internal.util.i parami1)
    {
      this.Umz = parami;
      this.UmB = parami1;
    }
    
    public final void hQA()
    {
      AppMethodBeat.i(90340);
      rx.internal.util.i locali;
      i locali1;
      if (compareAndSet(false, true))
      {
        locali = this.UmB;
        locali1 = this.Umz;
        if (locali.UnB) {}
      }
      try
      {
        List localList = locali.UnA;
        if ((locali.UnB) || (localList == null)) {
          return;
        }
        boolean bool = localList.remove(locali1);
        if (bool) {
          locali1.hQA();
        }
        AppMethodBeat.o(90340);
        return;
      }
      finally
      {
        AppMethodBeat.o(90340);
      }
    }
    
    public final boolean hQB()
    {
      return this.Umz.Umv.UnB;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     rx.internal.c.i
 * JD-Core Version:    0.7.0.1
 */