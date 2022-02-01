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
  private static final TimeUnit NYF;
  static final c NYG;
  static final a NYH;
  final ThreadFactory LTn;
  final AtomicReference<a> NYI;
  
  static
  {
    AppMethodBeat.i(90324);
    NYF = TimeUnit.SECONDS;
    Object localObject = new c(rx.internal.util.g.Oax);
    NYG = (c)localObject;
    ((c)localObject).gyQ();
    localObject = new a(null, 0L, null);
    NYH = (a)localObject;
    ((a)localObject).shutdown();
    AppMethodBeat.o(90324);
  }
  
  public a(ThreadFactory paramThreadFactory)
  {
    AppMethodBeat.i(90320);
    this.LTn = paramThreadFactory;
    this.NYI = new AtomicReference(NYH);
    start();
    AppMethodBeat.o(90320);
  }
  
  public final g.a createWorker()
  {
    AppMethodBeat.i(90323);
    b localb = new b((a)this.NYI.get());
    AppMethodBeat.o(90323);
    return localb;
  }
  
  public final void shutdown()
  {
    AppMethodBeat.i(90322);
    a locala;
    do
    {
      locala = (a)this.NYI.get();
      if (locala == NYH)
      {
        AppMethodBeat.o(90322);
        return;
      }
    } while (!this.NYI.compareAndSet(locala, NYH));
    locala.shutdown();
    AppMethodBeat.o(90322);
  }
  
  public final void start()
  {
    AppMethodBeat.i(90321);
    a locala = new a(this.LTn, 60L, NYF);
    if (!this.NYI.compareAndSet(NYH, locala)) {
      locala.shutdown();
    }
    AppMethodBeat.o(90321);
  }
  
  static final class a
  {
    private final ThreadFactory LTn;
    final long LTp;
    final ConcurrentLinkedQueue<a.c> NYJ;
    final b NYK;
    private final ScheduledExecutorService NYL;
    private final Future<?> NYM;
    
    a(ThreadFactory paramThreadFactory, long paramLong, TimeUnit paramTimeUnit)
    {
      AppMethodBeat.i(90312);
      this.LTn = paramThreadFactory;
      if (paramTimeUnit != null)
      {
        paramLong = paramTimeUnit.toNanos(paramLong);
        this.LTp = paramLong;
        this.NYJ = new ConcurrentLinkedQueue();
        this.NYK = new b();
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
            if (!locala.NYJ.isEmpty())
            {
              long l = System.nanoTime();
              Iterator localIterator = locala.NYJ.iterator();
              while (localIterator.hasNext())
              {
                a.c localc = (a.c)localIterator.next();
                if (localc.NYU > l) {
                  break;
                }
                if (locala.NYJ.remove(localc)) {
                  locala.NYK.e(localc);
                }
              }
            }
            AppMethodBeat.o(90311);
          }
        }, this.LTp, this.LTp, TimeUnit.NANOSECONDS);
      }
      for (;;)
      {
        this.NYL = paramThreadFactory;
        this.NYM = paramTimeUnit;
        AppMethodBeat.o(90312);
        return;
        paramLong = 0L;
        break;
        label126:
        paramTimeUnit = null;
        paramThreadFactory = null;
      }
    }
    
    final a.c gyZ()
    {
      AppMethodBeat.i(90313);
      if (this.NYK.OaI)
      {
        localc = a.NYG;
        AppMethodBeat.o(90313);
        return localc;
      }
      while (!this.NYJ.isEmpty())
      {
        localc = (a.c)this.NYJ.poll();
        if (localc != null)
        {
          AppMethodBeat.o(90313);
          return localc;
        }
      }
      a.c localc = new a.c(this.LTn);
      this.NYK.b(localc);
      AppMethodBeat.o(90313);
      return localc;
    }
    
    final void shutdown()
    {
      AppMethodBeat.i(90314);
      try
      {
        if (this.NYM != null) {
          this.NYM.cancel(true);
        }
        if (this.NYL != null) {
          this.NYL.shutdownNow();
        }
        return;
      }
      finally
      {
        this.NYK.gyQ();
        AppMethodBeat.o(90314);
      }
    }
  }
  
  static final class b
    extends g.a
  {
    final b NYP;
    private final a.a NYQ;
    private final a.c NYR;
    final AtomicBoolean NYS;
    
    b(a.a parama)
    {
      AppMethodBeat.i(90316);
      this.NYP = new b();
      this.NYQ = parama;
      this.NYS = new AtomicBoolean();
      this.NYR = parama.gyZ();
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
      if (this.NYP.OaI)
      {
        parama = d.gzD();
        AppMethodBeat.o(90319);
        return parama;
      }
      parama = this.NYR.b(new rx.b.a()
      {
        public final void call()
        {
          AppMethodBeat.i(90315);
          if (a.b.this.NYP.OaI)
          {
            AppMethodBeat.o(90315);
            return;
          }
          parama.call();
          AppMethodBeat.o(90315);
        }
      }, paramLong, paramTimeUnit);
      this.NYP.b(parama);
      paramTimeUnit = this.NYP;
      parama.NZC.b(new i.b(parama, paramTimeUnit));
      AppMethodBeat.o(90319);
      return parama;
    }
    
    public final void gyQ()
    {
      AppMethodBeat.i(90317);
      if (this.NYS.compareAndSet(false, true))
      {
        a.a locala = this.NYQ;
        a.c localc = this.NYR;
        localc.NYU = (System.nanoTime() + locala.LTp);
        locala.NYJ.offer(localc);
      }
      this.NYP.gyQ();
      AppMethodBeat.o(90317);
    }
    
    public final boolean gyR()
    {
      return this.NYP.OaI;
    }
  }
  
  static final class c
    extends h
  {
    long NYU = 0L;
    
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