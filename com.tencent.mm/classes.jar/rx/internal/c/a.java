package rx.internal.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.f.b;
import rx.f.d;
import rx.g.a;

public final class a
  extends rx.g
  implements j
{
  private static final TimeUnit KpU;
  static final c KpV;
  static final a KpW;
  final ThreadFactory IxJ;
  final AtomicReference<a> KpX;
  
  static
  {
    AppMethodBeat.i(90324);
    KpU = TimeUnit.SECONDS;
    Object localObject = new c(rx.internal.util.g.KrM);
    KpV = (c)localObject;
    ((c)localObject).fNw();
    localObject = new a(null, 0L, null);
    KpW = (a)localObject;
    ((a)localObject).shutdown();
    AppMethodBeat.o(90324);
  }
  
  public a(ThreadFactory paramThreadFactory)
  {
    AppMethodBeat.i(90320);
    this.IxJ = paramThreadFactory;
    this.KpX = new AtomicReference(KpW);
    start();
    AppMethodBeat.o(90320);
  }
  
  public final g.a createWorker()
  {
    AppMethodBeat.i(90323);
    b localb = new b((a)this.KpX.get());
    AppMethodBeat.o(90323);
    return localb;
  }
  
  public final void shutdown()
  {
    AppMethodBeat.i(90322);
    a locala;
    do
    {
      locala = (a)this.KpX.get();
      if (locala == KpW)
      {
        AppMethodBeat.o(90322);
        return;
      }
    } while (!this.KpX.compareAndSet(locala, KpW));
    locala.shutdown();
    AppMethodBeat.o(90322);
  }
  
  public final void start()
  {
    AppMethodBeat.i(90321);
    a locala = new a(this.IxJ, 60L, KpU);
    if (!this.KpX.compareAndSet(KpW, locala)) {
      locala.shutdown();
    }
    AppMethodBeat.o(90321);
  }
  
  static final class a
  {
    private final ThreadFactory IxJ;
    final long IxL;
    final ConcurrentLinkedQueue<a.c> KpY;
    final b KpZ;
    private final ScheduledExecutorService Kqa;
    private final Future<?> Kqb;
    
    a(ThreadFactory paramThreadFactory, long paramLong, TimeUnit paramTimeUnit)
    {
      AppMethodBeat.i(90312);
      this.IxJ = paramThreadFactory;
      if (paramTimeUnit != null)
      {
        paramLong = paramTimeUnit.toNanos(paramLong);
        this.IxL = paramLong;
        this.KpY = new ConcurrentLinkedQueue();
        this.KpZ = new b();
        if (paramTimeUnit == null) {
          break label126;
        }
        paramThreadFactory = Executors.newScheduledThreadPool(1, new a.a.1(this, paramThreadFactory));
        h.b(paramThreadFactory);
        paramTimeUnit = paramThreadFactory.scheduleWithFixedDelay(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(90311);
            a.a locala = a.a.this;
            if (!locala.KpY.isEmpty())
            {
              long l = System.nanoTime();
              Iterator localIterator = locala.KpY.iterator();
              while (localIterator.hasNext())
              {
                a.c localc = (a.c)localIterator.next();
                if (localc.Kqj > l) {
                  break;
                }
                if (locala.KpY.remove(localc)) {
                  locala.KpZ.e(localc);
                }
              }
            }
            AppMethodBeat.o(90311);
          }
        }, this.IxL, this.IxL, TimeUnit.NANOSECONDS);
      }
      for (;;)
      {
        this.Kqa = paramThreadFactory;
        this.Kqb = paramTimeUnit;
        AppMethodBeat.o(90312);
        return;
        paramLong = 0L;
        break;
        label126:
        paramTimeUnit = null;
        paramThreadFactory = null;
      }
    }
    
    final a.c fNF()
    {
      AppMethodBeat.i(90313);
      if (this.KpZ.KrX)
      {
        localc = a.KpV;
        AppMethodBeat.o(90313);
        return localc;
      }
      while (!this.KpY.isEmpty())
      {
        localc = (a.c)this.KpY.poll();
        if (localc != null)
        {
          AppMethodBeat.o(90313);
          return localc;
        }
      }
      a.c localc = new a.c(this.IxJ);
      this.KpZ.b(localc);
      AppMethodBeat.o(90313);
      return localc;
    }
    
    final void shutdown()
    {
      AppMethodBeat.i(90314);
      try
      {
        if (this.Kqb != null) {
          this.Kqb.cancel(true);
        }
        if (this.Kqa != null) {
          this.Kqa.shutdownNow();
        }
        return;
      }
      finally
      {
        this.KpZ.fNw();
        AppMethodBeat.o(90314);
      }
    }
  }
  
  static final class b
    extends g.a
  {
    final b Kqe;
    private final a.a Kqf;
    private final a.c Kqg;
    final AtomicBoolean Kqh;
    
    b(a.a parama)
    {
      AppMethodBeat.i(90316);
      this.Kqe = new b();
      this.Kqf = parama;
      this.Kqh = new AtomicBoolean();
      this.Kqg = parama.fNF();
      AppMethodBeat.o(90316);
    }
    
    public final rx.j a(rx.b.a parama)
    {
      AppMethodBeat.i(90318);
      parama = a(parama, 0L, null);
      AppMethodBeat.o(90318);
      return parama;
    }
    
    public final rx.j a(final rx.b.a parama, long paramLong, TimeUnit paramTimeUnit)
    {
      AppMethodBeat.i(90319);
      if (this.Kqe.KrX)
      {
        parama = d.fOj();
        AppMethodBeat.o(90319);
        return parama;
      }
      parama = this.Kqg.b(new rx.b.a()
      {
        public final void call()
        {
          AppMethodBeat.i(90315);
          if (a.b.this.Kqe.KrX)
          {
            AppMethodBeat.o(90315);
            return;
          }
          parama.call();
          AppMethodBeat.o(90315);
        }
      }, paramLong, paramTimeUnit);
      this.Kqe.b(parama);
      paramTimeUnit = this.Kqe;
      parama.KqR.b(new i.b(parama, paramTimeUnit));
      AppMethodBeat.o(90319);
      return parama;
    }
    
    public final void fNw()
    {
      AppMethodBeat.i(90317);
      if (this.Kqh.compareAndSet(false, true))
      {
        a.a locala = this.Kqf;
        a.c localc = this.Kqg;
        localc.Kqj = (System.nanoTime() + locala.IxL);
        locala.KpY.offer(localc);
      }
      this.Kqe.fNw();
      AppMethodBeat.o(90317);
    }
    
    public final boolean fNx()
    {
      return this.Kqe.KrX;
    }
  }
  
  static final class c
    extends h
  {
    long Kqj = 0L;
    
    c(ThreadFactory paramThreadFactory)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     rx.internal.c.a
 * JD-Core Version:    0.7.0.1
 */