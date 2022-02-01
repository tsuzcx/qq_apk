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
  private static final TimeUnit MdD;
  static final c MdE;
  static final a MdF;
  final ThreadFactory JZs;
  final AtomicReference<a> MdG;
  
  static
  {
    AppMethodBeat.i(90324);
    MdD = TimeUnit.SECONDS;
    Object localObject = new c(rx.internal.util.g.Mfv);
    MdE = (c)localObject;
    ((c)localObject).ggm();
    localObject = new a(null, 0L, null);
    MdF = (a)localObject;
    ((a)localObject).shutdown();
    AppMethodBeat.o(90324);
  }
  
  public a(ThreadFactory paramThreadFactory)
  {
    AppMethodBeat.i(90320);
    this.JZs = paramThreadFactory;
    this.MdG = new AtomicReference(MdF);
    start();
    AppMethodBeat.o(90320);
  }
  
  public final g.a createWorker()
  {
    AppMethodBeat.i(90323);
    b localb = new b((a)this.MdG.get());
    AppMethodBeat.o(90323);
    return localb;
  }
  
  public final void shutdown()
  {
    AppMethodBeat.i(90322);
    a locala;
    do
    {
      locala = (a)this.MdG.get();
      if (locala == MdF)
      {
        AppMethodBeat.o(90322);
        return;
      }
    } while (!this.MdG.compareAndSet(locala, MdF));
    locala.shutdown();
    AppMethodBeat.o(90322);
  }
  
  public final void start()
  {
    AppMethodBeat.i(90321);
    a locala = new a(this.JZs, 60L, MdD);
    if (!this.MdG.compareAndSet(MdF, locala)) {
      locala.shutdown();
    }
    AppMethodBeat.o(90321);
  }
  
  static final class a
  {
    private final ThreadFactory JZs;
    final long JZu;
    final ConcurrentLinkedQueue<a.c> MdH;
    final b MdI;
    private final ScheduledExecutorService MdJ;
    private final Future<?> MdK;
    
    a(ThreadFactory paramThreadFactory, long paramLong, TimeUnit paramTimeUnit)
    {
      AppMethodBeat.i(90312);
      this.JZs = paramThreadFactory;
      if (paramTimeUnit != null)
      {
        paramLong = paramTimeUnit.toNanos(paramLong);
        this.JZu = paramLong;
        this.MdH = new ConcurrentLinkedQueue();
        this.MdI = new b();
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
            if (!locala.MdH.isEmpty())
            {
              long l = System.nanoTime();
              Iterator localIterator = locala.MdH.iterator();
              while (localIterator.hasNext())
              {
                a.c localc = (a.c)localIterator.next();
                if (localc.MdS > l) {
                  break;
                }
                if (locala.MdH.remove(localc)) {
                  locala.MdI.e(localc);
                }
              }
            }
            AppMethodBeat.o(90311);
          }
        }, this.JZu, this.JZu, TimeUnit.NANOSECONDS);
      }
      for (;;)
      {
        this.MdJ = paramThreadFactory;
        this.MdK = paramTimeUnit;
        AppMethodBeat.o(90312);
        return;
        paramLong = 0L;
        break;
        label126:
        paramTimeUnit = null;
        paramThreadFactory = null;
      }
    }
    
    final a.c ggv()
    {
      AppMethodBeat.i(90313);
      if (this.MdI.MfG)
      {
        localc = a.MdE;
        AppMethodBeat.o(90313);
        return localc;
      }
      while (!this.MdH.isEmpty())
      {
        localc = (a.c)this.MdH.poll();
        if (localc != null)
        {
          AppMethodBeat.o(90313);
          return localc;
        }
      }
      a.c localc = new a.c(this.JZs);
      this.MdI.b(localc);
      AppMethodBeat.o(90313);
      return localc;
    }
    
    final void shutdown()
    {
      AppMethodBeat.i(90314);
      try
      {
        if (this.MdK != null) {
          this.MdK.cancel(true);
        }
        if (this.MdJ != null) {
          this.MdJ.shutdownNow();
        }
        return;
      }
      finally
      {
        this.MdI.ggm();
        AppMethodBeat.o(90314);
      }
    }
  }
  
  static final class b
    extends g.a
  {
    final b MdN;
    private final a.a MdO;
    private final a.c MdP;
    final AtomicBoolean MdQ;
    
    b(a.a parama)
    {
      AppMethodBeat.i(90316);
      this.MdN = new b();
      this.MdO = parama;
      this.MdQ = new AtomicBoolean();
      this.MdP = parama.ggv();
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
      if (this.MdN.MfG)
      {
        parama = d.ggZ();
        AppMethodBeat.o(90319);
        return parama;
      }
      parama = this.MdP.b(new rx.b.a()
      {
        public final void call()
        {
          AppMethodBeat.i(90315);
          if (a.b.this.MdN.MfG)
          {
            AppMethodBeat.o(90315);
            return;
          }
          parama.call();
          AppMethodBeat.o(90315);
        }
      }, paramLong, paramTimeUnit);
      this.MdN.b(parama);
      paramTimeUnit = this.MdN;
      parama.MeA.b(new i.b(parama, paramTimeUnit));
      AppMethodBeat.o(90319);
      return parama;
    }
    
    public final void ggm()
    {
      AppMethodBeat.i(90317);
      if (this.MdQ.compareAndSet(false, true))
      {
        a.a locala = this.MdO;
        a.c localc = this.MdP;
        localc.MdS = (System.nanoTime() + locala.JZu);
        locala.MdH.offer(localc);
      }
      this.MdN.ggm();
      AppMethodBeat.o(90317);
    }
    
    public final boolean ggn()
    {
      return this.MdN.MfG;
    }
  }
  
  static final class c
    extends h
  {
    long MdS = 0L;
    
    c(ThreadFactory paramThreadFactory)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     rx.internal.c.a
 * JD-Core Version:    0.7.0.1
 */