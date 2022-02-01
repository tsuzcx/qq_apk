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
  private static final TimeUnit OvK;
  static final c OvL;
  static final a OvM;
  final ThreadFactory Mqk;
  final AtomicReference<a> OvN;
  
  static
  {
    AppMethodBeat.i(90324);
    OvK = TimeUnit.SECONDS;
    Object localObject = new c(rx.internal.util.g.OxC);
    OvL = (c)localObject;
    ((c)localObject).gDs();
    localObject = new a(null, 0L, null);
    OvM = (a)localObject;
    ((a)localObject).shutdown();
    AppMethodBeat.o(90324);
  }
  
  public a(ThreadFactory paramThreadFactory)
  {
    AppMethodBeat.i(90320);
    this.Mqk = paramThreadFactory;
    this.OvN = new AtomicReference(OvM);
    start();
    AppMethodBeat.o(90320);
  }
  
  public final g.a createWorker()
  {
    AppMethodBeat.i(90323);
    b localb = new b((a)this.OvN.get());
    AppMethodBeat.o(90323);
    return localb;
  }
  
  public final void shutdown()
  {
    AppMethodBeat.i(90322);
    a locala;
    do
    {
      locala = (a)this.OvN.get();
      if (locala == OvM)
      {
        AppMethodBeat.o(90322);
        return;
      }
    } while (!this.OvN.compareAndSet(locala, OvM));
    locala.shutdown();
    AppMethodBeat.o(90322);
  }
  
  public final void start()
  {
    AppMethodBeat.i(90321);
    a locala = new a(this.Mqk, 60L, OvK);
    if (!this.OvN.compareAndSet(OvM, locala)) {
      locala.shutdown();
    }
    AppMethodBeat.o(90321);
  }
  
  static final class a
  {
    private final ThreadFactory Mqk;
    final long Mqm;
    final ConcurrentLinkedQueue<a.c> OvO;
    final b OvP;
    private final ScheduledExecutorService OvQ;
    private final Future<?> OvR;
    
    a(ThreadFactory paramThreadFactory, long paramLong, TimeUnit paramTimeUnit)
    {
      AppMethodBeat.i(90312);
      this.Mqk = paramThreadFactory;
      if (paramTimeUnit != null)
      {
        paramLong = paramTimeUnit.toNanos(paramLong);
        this.Mqm = paramLong;
        this.OvO = new ConcurrentLinkedQueue();
        this.OvP = new b();
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
            if (!locala.OvO.isEmpty())
            {
              long l = System.nanoTime();
              Iterator localIterator = locala.OvO.iterator();
              while (localIterator.hasNext())
              {
                a.c localc = (a.c)localIterator.next();
                if (localc.OvZ > l) {
                  break;
                }
                if (locala.OvO.remove(localc)) {
                  locala.OvP.e(localc);
                }
              }
            }
            AppMethodBeat.o(90311);
          }
        }, this.Mqm, this.Mqm, TimeUnit.NANOSECONDS);
      }
      for (;;)
      {
        this.OvQ = paramThreadFactory;
        this.OvR = paramTimeUnit;
        AppMethodBeat.o(90312);
        return;
        paramLong = 0L;
        break;
        label126:
        paramTimeUnit = null;
        paramThreadFactory = null;
      }
    }
    
    final a.c gDB()
    {
      AppMethodBeat.i(90313);
      if (this.OvP.OxN)
      {
        localc = a.OvL;
        AppMethodBeat.o(90313);
        return localc;
      }
      while (!this.OvO.isEmpty())
      {
        localc = (a.c)this.OvO.poll();
        if (localc != null)
        {
          AppMethodBeat.o(90313);
          return localc;
        }
      }
      a.c localc = new a.c(this.Mqk);
      this.OvP.b(localc);
      AppMethodBeat.o(90313);
      return localc;
    }
    
    final void shutdown()
    {
      AppMethodBeat.i(90314);
      try
      {
        if (this.OvR != null) {
          this.OvR.cancel(true);
        }
        if (this.OvQ != null) {
          this.OvQ.shutdownNow();
        }
        return;
      }
      finally
      {
        this.OvP.gDs();
        AppMethodBeat.o(90314);
      }
    }
  }
  
  static final class b
    extends g.a
  {
    final b OvU;
    private final a.a OvV;
    private final a.c OvW;
    final AtomicBoolean OvX;
    
    b(a.a parama)
    {
      AppMethodBeat.i(90316);
      this.OvU = new b();
      this.OvV = parama;
      this.OvX = new AtomicBoolean();
      this.OvW = parama.gDB();
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
      if (this.OvU.OxN)
      {
        parama = d.gEf();
        AppMethodBeat.o(90319);
        return parama;
      }
      parama = this.OvW.b(new rx.b.a()
      {
        public final void call()
        {
          AppMethodBeat.i(90315);
          if (a.b.this.OvU.OxN)
          {
            AppMethodBeat.o(90315);
            return;
          }
          parama.call();
          AppMethodBeat.o(90315);
        }
      }, paramLong, paramTimeUnit);
      this.OvU.b(parama);
      paramTimeUnit = this.OvU;
      parama.OwH.b(new i.b(parama, paramTimeUnit));
      AppMethodBeat.o(90319);
      return parama;
    }
    
    public final void gDs()
    {
      AppMethodBeat.i(90317);
      if (this.OvX.compareAndSet(false, true))
      {
        a.a locala = this.OvV;
        a.c localc = this.OvW;
        localc.OvZ = (System.nanoTime() + locala.Mqm);
        locala.OvO.offer(localc);
      }
      this.OvU.gDs();
      AppMethodBeat.o(90317);
    }
    
    public final boolean gDt()
    {
      return this.OvU.OxN;
    }
  }
  
  static final class c
    extends h
  {
    long OvZ = 0L;
    
    c(ThreadFactory paramThreadFactory)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     rx.internal.c.a
 * JD-Core Version:    0.7.0.1
 */