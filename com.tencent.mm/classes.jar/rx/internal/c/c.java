package rx.internal.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import rx.b.a;
import rx.f.b;
import rx.g;
import rx.g.a;
import rx.j;

public final class c
  extends g
{
  final Executor executor;
  
  public c(Executor paramExecutor)
  {
    this.executor = paramExecutor;
  }
  
  public final g.a createWorker()
  {
    AppMethodBeat.i(90368);
    a locala = new a(this.executor);
    AppMethodBeat.o(90368);
    return locala;
  }
  
  static final class a
    extends g.a
    implements Runnable
  {
    final ConcurrentLinkedQueue<i> ABz;
    final b abPu;
    final AtomicInteger abPv;
    final ScheduledExecutorService abPw;
    final Executor executor;
    
    public a(Executor paramExecutor)
    {
      AppMethodBeat.i(90363);
      this.executor = paramExecutor;
      this.ABz = new ConcurrentLinkedQueue();
      this.abPv = new AtomicInteger();
      this.abPu = new b();
      this.abPw = d.iVU();
      AppMethodBeat.o(90363);
    }
    
    public final j a(a parama)
    {
      AppMethodBeat.i(90364);
      if (this.abPu.abQP)
      {
        parama = rx.f.d.iWx();
        AppMethodBeat.o(90364);
        return parama;
      }
      parama = new i(parama, this.abPu);
      this.abPu.b(parama);
      this.ABz.offer(parama);
      if (this.abPv.getAndIncrement() == 0) {}
      try
      {
        this.executor.execute(this);
        AppMethodBeat.o(90364);
        return parama;
      }
      catch (RejectedExecutionException localRejectedExecutionException)
      {
        this.abPu.e(parama);
        this.abPv.decrementAndGet();
        rx.d.c.c(localRejectedExecutionException);
        AppMethodBeat.o(90364);
        throw localRejectedExecutionException;
      }
    }
    
    public final j a(final a parama, long paramLong, TimeUnit paramTimeUnit)
    {
      AppMethodBeat.i(90366);
      if (paramLong <= 0L)
      {
        parama = a(parama);
        AppMethodBeat.o(90366);
        return parama;
      }
      if (this.abPu.abQP)
      {
        parama = rx.f.d.iWx();
        AppMethodBeat.o(90366);
        return parama;
      }
      rx.f.c localc1 = new rx.f.c();
      final rx.f.c localc2 = new rx.f.c();
      localc2.f(localc1);
      this.abPu.b(localc2);
      final j localj = rx.f.d.e(new a()
      {
        public final void call()
        {
          AppMethodBeat.i(90361);
          c.a.this.abPu.e(localc2);
          AppMethodBeat.o(90361);
        }
      });
      parama = new i(new a()
      {
        public final void call()
        {
          AppMethodBeat.i(90362);
          if (localc2.iVK())
          {
            AppMethodBeat.o(90362);
            return;
          }
          Object localObject = c.a.this.a(parama);
          localc2.f((j)localObject);
          if (localObject.getClass() == i.class)
          {
            localObject = (i)localObject;
            j localj = localj;
            ((i)localObject).abPR.b(localj);
          }
          AppMethodBeat.o(90362);
        }
      });
      localc1.f(parama);
      try
      {
        parama.b(this.abPw.schedule(parama, paramLong, paramTimeUnit));
        AppMethodBeat.o(90366);
        return localj;
      }
      catch (RejectedExecutionException parama)
      {
        rx.d.c.c(parama);
        AppMethodBeat.o(90366);
        throw parama;
      }
    }
    
    public final void iVJ()
    {
      AppMethodBeat.i(90367);
      this.abPu.iVJ();
      this.ABz.clear();
      AppMethodBeat.o(90367);
    }
    
    public final boolean iVK()
    {
      return this.abPu.abQP;
    }
    
    public final void run()
    {
      AppMethodBeat.i(90365);
      do
      {
        if (this.abPu.abQP)
        {
          this.ABz.clear();
          AppMethodBeat.o(90365);
          return;
        }
        i locali = (i)this.ABz.poll();
        if (locali == null)
        {
          AppMethodBeat.o(90365);
          return;
        }
        if (!locali.abPR.abQP)
        {
          if (this.abPu.abQP) {
            break;
          }
          locali.run();
        }
      } while (this.abPv.decrementAndGet() != 0);
      AppMethodBeat.o(90365);
      return;
      this.ABz.clear();
      AppMethodBeat.o(90365);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     rx.internal.c.c
 * JD-Core Version:    0.7.0.1
 */