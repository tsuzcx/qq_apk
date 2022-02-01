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
    final b Med;
    final AtomicInteger Mee;
    final ScheduledExecutorService Mef;
    final Executor executor;
    final ConcurrentLinkedQueue<i> rNK;
    
    public a(Executor paramExecutor)
    {
      AppMethodBeat.i(90363);
      this.executor = paramExecutor;
      this.rNK = new ConcurrentLinkedQueue();
      this.Mee = new AtomicInteger();
      this.Med = new b();
      this.Mef = d.ggx();
      AppMethodBeat.o(90363);
    }
    
    public final j a(a parama)
    {
      AppMethodBeat.i(90364);
      if (this.Med.MfG)
      {
        parama = rx.f.d.ggZ();
        AppMethodBeat.o(90364);
        return parama;
      }
      parama = new i(parama, this.Med);
      this.Med.b(parama);
      this.rNK.offer(parama);
      if (this.Mee.getAndIncrement() == 0) {}
      try
      {
        this.executor.execute(this);
        AppMethodBeat.o(90364);
        return parama;
      }
      catch (RejectedExecutionException localRejectedExecutionException)
      {
        this.Med.e(parama);
        this.Mee.decrementAndGet();
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
      if (this.Med.MfG)
      {
        parama = rx.f.d.ggZ();
        AppMethodBeat.o(90366);
        return parama;
      }
      rx.f.c localc1 = new rx.f.c();
      final rx.f.c localc2 = new rx.f.c();
      localc2.f(localc1);
      this.Med.b(localc2);
      final j localj = rx.f.d.e(new a()
      {
        public final void call()
        {
          AppMethodBeat.i(90361);
          c.a.this.Med.e(localc2);
          AppMethodBeat.o(90361);
        }
      });
      parama = new i(new a()
      {
        public final void call()
        {
          AppMethodBeat.i(90362);
          if (localc2.ggn())
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
            ((i)localObject).MeA.b(localj);
          }
          AppMethodBeat.o(90362);
        }
      });
      localc1.f(parama);
      try
      {
        parama.b(this.Mef.schedule(parama, paramLong, paramTimeUnit));
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
    
    public final void ggm()
    {
      AppMethodBeat.i(90367);
      this.Med.ggm();
      this.rNK.clear();
      AppMethodBeat.o(90367);
    }
    
    public final boolean ggn()
    {
      return this.Med.MfG;
    }
    
    public final void run()
    {
      AppMethodBeat.i(90365);
      do
      {
        if (this.Med.MfG)
        {
          this.rNK.clear();
          AppMethodBeat.o(90365);
          return;
        }
        i locali = (i)this.rNK.poll();
        if (locali == null)
        {
          AppMethodBeat.o(90365);
          return;
        }
        if (!locali.MeA.MfG)
        {
          if (this.Med.MfG) {
            break;
          }
          locali.run();
        }
      } while (this.Mee.decrementAndGet() != 0);
      AppMethodBeat.o(90365);
      return;
      this.rNK.clear();
      AppMethodBeat.o(90365);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     rx.internal.c.c
 * JD-Core Version:    0.7.0.1
 */