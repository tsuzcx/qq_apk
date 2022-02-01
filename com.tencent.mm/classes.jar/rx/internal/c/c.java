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
    final b UlY;
    final AtomicInteger UlZ;
    final ScheduledExecutorService Uma;
    final Executor executor;
    final ConcurrentLinkedQueue<i> vTW;
    
    public a(Executor paramExecutor)
    {
      AppMethodBeat.i(90363);
      this.executor = paramExecutor;
      this.vTW = new ConcurrentLinkedQueue();
      this.UlZ = new AtomicInteger();
      this.UlY = new b();
      this.Uma = d.hQL();
      AppMethodBeat.o(90363);
    }
    
    public final j a(a parama)
    {
      AppMethodBeat.i(90364);
      if (this.UlY.UnB)
      {
        parama = rx.f.d.hRn();
        AppMethodBeat.o(90364);
        return parama;
      }
      parama = new i(parama, this.UlY);
      this.UlY.b(parama);
      this.vTW.offer(parama);
      if (this.UlZ.getAndIncrement() == 0) {}
      try
      {
        this.executor.execute(this);
        AppMethodBeat.o(90364);
        return parama;
      }
      catch (RejectedExecutionException localRejectedExecutionException)
      {
        this.UlY.e(parama);
        this.UlZ.decrementAndGet();
        rx.d.c.onError(localRejectedExecutionException);
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
      if (this.UlY.UnB)
      {
        parama = rx.f.d.hRn();
        AppMethodBeat.o(90366);
        return parama;
      }
      rx.f.c localc1 = new rx.f.c();
      final rx.f.c localc2 = new rx.f.c();
      localc2.f(localc1);
      this.UlY.b(localc2);
      final j localj = rx.f.d.e(new a()
      {
        public final void call()
        {
          AppMethodBeat.i(90361);
          c.a.this.UlY.e(localc2);
          AppMethodBeat.o(90361);
        }
      });
      parama = new i(new a()
      {
        public final void call()
        {
          AppMethodBeat.i(90362);
          if (localc2.hQB())
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
            ((i)localObject).Umv.b(localj);
          }
          AppMethodBeat.o(90362);
        }
      });
      localc1.f(parama);
      try
      {
        parama.b(this.Uma.schedule(parama, paramLong, paramTimeUnit));
        AppMethodBeat.o(90366);
        return localj;
      }
      catch (RejectedExecutionException parama)
      {
        rx.d.c.onError(parama);
        AppMethodBeat.o(90366);
        throw parama;
      }
    }
    
    public final void hQA()
    {
      AppMethodBeat.i(90367);
      this.UlY.hQA();
      this.vTW.clear();
      AppMethodBeat.o(90367);
    }
    
    public final boolean hQB()
    {
      return this.UlY.UnB;
    }
    
    public final void run()
    {
      AppMethodBeat.i(90365);
      do
      {
        if (this.UlY.UnB)
        {
          this.vTW.clear();
          AppMethodBeat.o(90365);
          return;
        }
        i locali = (i)this.vTW.poll();
        if (locali == null)
        {
          AppMethodBeat.o(90365);
          return;
        }
        if (!locali.Umv.UnB)
        {
          if (this.UlY.UnB) {
            break;
          }
          locali.run();
        }
      } while (this.UlZ.decrementAndGet() != 0);
      AppMethodBeat.o(90365);
      return;
      this.vTW.clear();
      AppMethodBeat.o(90365);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     rx.internal.c.c
 * JD-Core Version:    0.7.0.1
 */