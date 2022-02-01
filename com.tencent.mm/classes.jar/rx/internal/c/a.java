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
  private static final TimeUnit abOU;
  static final c abOV;
  static final a abOW;
  final ThreadFactory Zvl;
  final AtomicReference<a> abOX;
  
  static
  {
    AppMethodBeat.i(90324);
    abOU = TimeUnit.SECONDS;
    Object localObject = new c(rx.internal.util.g.abQM);
    abOV = (c)localObject;
    ((c)localObject).iVJ();
    localObject = new a(null, 0L, null);
    abOW = (a)localObject;
    ((a)localObject).shutdown();
    AppMethodBeat.o(90324);
  }
  
  public a(ThreadFactory paramThreadFactory)
  {
    AppMethodBeat.i(90320);
    this.Zvl = paramThreadFactory;
    this.abOX = new AtomicReference(abOW);
    start();
    AppMethodBeat.o(90320);
  }
  
  public final g.a createWorker()
  {
    AppMethodBeat.i(90323);
    b localb = new b((a)this.abOX.get());
    AppMethodBeat.o(90323);
    return localb;
  }
  
  public final void shutdown()
  {
    AppMethodBeat.i(90322);
    a locala;
    do
    {
      locala = (a)this.abOX.get();
      if (locala == abOW)
      {
        AppMethodBeat.o(90322);
        return;
      }
    } while (!this.abOX.compareAndSet(locala, abOW));
    locala.shutdown();
    AppMethodBeat.o(90322);
  }
  
  public final void start()
  {
    AppMethodBeat.i(90321);
    a locala = new a(this.Zvl, 60L, abOU);
    if (!this.abOX.compareAndSet(abOW, locala)) {
      locala.shutdown();
    }
    AppMethodBeat.o(90321);
  }
  
  static final class a
  {
    private final ThreadFactory Zvl;
    final long Zvn;
    final ConcurrentLinkedQueue<a.c> abOY;
    final b abOZ;
    private final ScheduledExecutorService abPa;
    private final Future<?> abPb;
    
    a(ThreadFactory paramThreadFactory, long paramLong, TimeUnit paramTimeUnit)
    {
      AppMethodBeat.i(90312);
      this.Zvl = paramThreadFactory;
      if (paramTimeUnit != null)
      {
        paramLong = paramTimeUnit.toNanos(paramLong);
        this.Zvn = paramLong;
        this.abOY = new ConcurrentLinkedQueue();
        this.abOZ = new b();
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
            if (!locala.abOY.isEmpty())
            {
              long l = System.nanoTime();
              Iterator localIterator = locala.abOY.iterator();
              while (localIterator.hasNext())
              {
                a.c localc = (a.c)localIterator.next();
                if (localc.abPj > l) {
                  break;
                }
                if (locala.abOY.remove(localc)) {
                  locala.abOZ.e(localc);
                }
              }
            }
            AppMethodBeat.o(90311);
          }
        }, this.Zvn, this.Zvn, TimeUnit.NANOSECONDS);
      }
      for (;;)
      {
        this.abPa = paramThreadFactory;
        this.abPb = paramTimeUnit;
        AppMethodBeat.o(90312);
        return;
        paramLong = 0L;
        break;
        label126:
        paramTimeUnit = null;
        paramThreadFactory = null;
      }
    }
    
    final a.c iVT()
    {
      AppMethodBeat.i(90313);
      if (this.abOZ.abQP)
      {
        localc = a.abOV;
        AppMethodBeat.o(90313);
        return localc;
      }
      while (!this.abOY.isEmpty())
      {
        localc = (a.c)this.abOY.poll();
        if (localc != null)
        {
          AppMethodBeat.o(90313);
          return localc;
        }
      }
      a.c localc = new a.c(this.Zvl);
      this.abOZ.b(localc);
      AppMethodBeat.o(90313);
      return localc;
    }
    
    final void shutdown()
    {
      AppMethodBeat.i(90314);
      try
      {
        if (this.abPb != null) {
          this.abPb.cancel(true);
        }
        if (this.abPa != null) {
          this.abPa.shutdownNow();
        }
        return;
      }
      finally
      {
        this.abOZ.iVJ();
        AppMethodBeat.o(90314);
      }
    }
  }
  
  static final class b
    extends g.a
  {
    final b abPe;
    private final a.a abPf;
    private final a.c abPg;
    final AtomicBoolean abPh;
    
    b(a.a parama)
    {
      AppMethodBeat.i(90316);
      this.abPe = new b();
      this.abPf = parama;
      this.abPh = new AtomicBoolean();
      this.abPg = parama.iVT();
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
      if (this.abPe.abQP)
      {
        parama = d.iWx();
        AppMethodBeat.o(90319);
        return parama;
      }
      parama = this.abPg.b(new rx.b.a()
      {
        public final void call()
        {
          AppMethodBeat.i(90315);
          if (a.b.this.abPe.abQP)
          {
            AppMethodBeat.o(90315);
            return;
          }
          parama.call();
          AppMethodBeat.o(90315);
        }
      }, paramLong, paramTimeUnit);
      this.abPe.b(parama);
      paramTimeUnit = this.abPe;
      parama.abPR.b(new i.b(parama, paramTimeUnit));
      AppMethodBeat.o(90319);
      return parama;
    }
    
    public final void iVJ()
    {
      AppMethodBeat.i(90317);
      if (this.abPh.compareAndSet(false, true))
      {
        a.a locala = this.abPf;
        a.c localc = this.abPg;
        localc.abPj = (System.nanoTime() + locala.Zvn);
        locala.abOY.offer(localc);
      }
      this.abPe.iVJ();
      AppMethodBeat.o(90317);
    }
    
    public final boolean iVK()
    {
      return this.abPe.abQP;
    }
  }
  
  static final class c
    extends h
  {
    long abPj = 0L;
    
    c(ThreadFactory paramThreadFactory)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     rx.internal.c.a
 * JD-Core Version:    0.7.0.1
 */