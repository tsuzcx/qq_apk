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
  static final a UlA;
  private static final TimeUnit Uly;
  static final c Ulz;
  final ThreadFactory RSH;
  final AtomicReference<a> UlB;
  
  static
  {
    AppMethodBeat.i(90324);
    Uly = TimeUnit.SECONDS;
    Object localObject = new c(rx.internal.util.g.Unq);
    Ulz = (c)localObject;
    ((c)localObject).hQA();
    localObject = new a(null, 0L, null);
    UlA = (a)localObject;
    ((a)localObject).shutdown();
    AppMethodBeat.o(90324);
  }
  
  public a(ThreadFactory paramThreadFactory)
  {
    AppMethodBeat.i(90320);
    this.RSH = paramThreadFactory;
    this.UlB = new AtomicReference(UlA);
    start();
    AppMethodBeat.o(90320);
  }
  
  public final g.a createWorker()
  {
    AppMethodBeat.i(90323);
    b localb = new b((a)this.UlB.get());
    AppMethodBeat.o(90323);
    return localb;
  }
  
  public final void shutdown()
  {
    AppMethodBeat.i(90322);
    a locala;
    do
    {
      locala = (a)this.UlB.get();
      if (locala == UlA)
      {
        AppMethodBeat.o(90322);
        return;
      }
    } while (!this.UlB.compareAndSet(locala, UlA));
    locala.shutdown();
    AppMethodBeat.o(90322);
  }
  
  public final void start()
  {
    AppMethodBeat.i(90321);
    a locala = new a(this.RSH, 60L, Uly);
    if (!this.UlB.compareAndSet(UlA, locala)) {
      locala.shutdown();
    }
    AppMethodBeat.o(90321);
  }
  
  static final class a
  {
    private final ThreadFactory RSH;
    final long RSJ;
    final ConcurrentLinkedQueue<a.c> UlC;
    final b UlD;
    private final ScheduledExecutorService UlE;
    private final Future<?> UlF;
    
    a(ThreadFactory paramThreadFactory, long paramLong, TimeUnit paramTimeUnit)
    {
      AppMethodBeat.i(90312);
      this.RSH = paramThreadFactory;
      if (paramTimeUnit != null)
      {
        paramLong = paramTimeUnit.toNanos(paramLong);
        this.RSJ = paramLong;
        this.UlC = new ConcurrentLinkedQueue();
        this.UlD = new b();
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
            if (!locala.UlC.isEmpty())
            {
              long l = System.nanoTime();
              Iterator localIterator = locala.UlC.iterator();
              while (localIterator.hasNext())
              {
                a.c localc = (a.c)localIterator.next();
                if (localc.UlN > l) {
                  break;
                }
                if (locala.UlC.remove(localc)) {
                  locala.UlD.e(localc);
                }
              }
            }
            AppMethodBeat.o(90311);
          }
        }, this.RSJ, this.RSJ, TimeUnit.NANOSECONDS);
      }
      for (;;)
      {
        this.UlE = paramThreadFactory;
        this.UlF = paramTimeUnit;
        AppMethodBeat.o(90312);
        return;
        paramLong = 0L;
        break;
        label126:
        paramTimeUnit = null;
        paramThreadFactory = null;
      }
    }
    
    final a.c hQJ()
    {
      AppMethodBeat.i(90313);
      if (this.UlD.UnB)
      {
        localc = a.Ulz;
        AppMethodBeat.o(90313);
        return localc;
      }
      while (!this.UlC.isEmpty())
      {
        localc = (a.c)this.UlC.poll();
        if (localc != null)
        {
          AppMethodBeat.o(90313);
          return localc;
        }
      }
      a.c localc = new a.c(this.RSH);
      this.UlD.b(localc);
      AppMethodBeat.o(90313);
      return localc;
    }
    
    final void shutdown()
    {
      AppMethodBeat.i(90314);
      try
      {
        if (this.UlF != null) {
          this.UlF.cancel(true);
        }
        if (this.UlE != null) {
          this.UlE.shutdownNow();
        }
        return;
      }
      finally
      {
        this.UlD.hQA();
        AppMethodBeat.o(90314);
      }
    }
  }
  
  static final class b
    extends g.a
  {
    final b UlI;
    private final a.a UlJ;
    private final a.c UlK;
    final AtomicBoolean UlL;
    
    b(a.a parama)
    {
      AppMethodBeat.i(90316);
      this.UlI = new b();
      this.UlJ = parama;
      this.UlL = new AtomicBoolean();
      this.UlK = parama.hQJ();
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
      if (this.UlI.UnB)
      {
        parama = d.hRn();
        AppMethodBeat.o(90319);
        return parama;
      }
      parama = this.UlK.b(new rx.b.a()
      {
        public final void call()
        {
          AppMethodBeat.i(90315);
          if (a.b.this.UlI.UnB)
          {
            AppMethodBeat.o(90315);
            return;
          }
          parama.call();
          AppMethodBeat.o(90315);
        }
      }, paramLong, paramTimeUnit);
      this.UlI.b(parama);
      paramTimeUnit = this.UlI;
      parama.Umv.b(new i.b(parama, paramTimeUnit));
      AppMethodBeat.o(90319);
      return parama;
    }
    
    public final void hQA()
    {
      AppMethodBeat.i(90317);
      if (this.UlL.compareAndSet(false, true))
      {
        a.a locala = this.UlJ;
        a.c localc = this.UlK;
        localc.UlN = (System.nanoTime() + locala.RSJ);
        locala.UlC.offer(localc);
      }
      this.UlI.hQA();
      AppMethodBeat.o(90317);
    }
    
    public final boolean hQB()
    {
      return this.UlI.UnB;
    }
  }
  
  static final class c
    extends h
  {
    long UlN = 0L;
    
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