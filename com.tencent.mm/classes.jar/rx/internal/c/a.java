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
  private static final TimeUnit akbM;
  static final c akbN;
  static final a akbO;
  final ThreadFactory ahAf;
  final AtomicReference<a> akbP;
  
  static
  {
    AppMethodBeat.i(90324);
    akbM = TimeUnit.SECONDS;
    Object localObject = new c(rx.internal.util.g.akdE);
    akbN = (c)localObject;
    ((c)localObject).kKh();
    localObject = new a(null, 0L, null);
    akbO = (a)localObject;
    ((a)localObject).shutdown();
    AppMethodBeat.o(90324);
  }
  
  public a(ThreadFactory paramThreadFactory)
  {
    AppMethodBeat.i(90320);
    this.ahAf = paramThreadFactory;
    this.akbP = new AtomicReference(akbO);
    start();
    AppMethodBeat.o(90320);
  }
  
  public final g.a createWorker()
  {
    AppMethodBeat.i(90323);
    b localb = new b((a)this.akbP.get());
    AppMethodBeat.o(90323);
    return localb;
  }
  
  public final void shutdown()
  {
    AppMethodBeat.i(90322);
    a locala;
    do
    {
      locala = (a)this.akbP.get();
      if (locala == akbO)
      {
        AppMethodBeat.o(90322);
        return;
      }
    } while (!this.akbP.compareAndSet(locala, akbO));
    locala.shutdown();
    AppMethodBeat.o(90322);
  }
  
  public final void start()
  {
    AppMethodBeat.i(90321);
    a locala = new a(this.ahAf, 60L, akbM);
    if (!this.akbP.compareAndSet(akbO, locala)) {
      locala.shutdown();
    }
    AppMethodBeat.o(90321);
  }
  
  static final class a
  {
    private final ThreadFactory ahAf;
    final long ahAh;
    final ConcurrentLinkedQueue<a.c> akbQ;
    final b akbR;
    private final ScheduledExecutorService akbS;
    private final Future<?> akbT;
    
    a(ThreadFactory paramThreadFactory, long paramLong, TimeUnit paramTimeUnit)
    {
      AppMethodBeat.i(90312);
      this.ahAf = paramThreadFactory;
      if (paramTimeUnit != null)
      {
        paramLong = paramTimeUnit.toNanos(paramLong);
        this.ahAh = paramLong;
        this.akbQ = new ConcurrentLinkedQueue();
        this.akbR = new b();
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
            if (!locala.akbQ.isEmpty())
            {
              long l = System.nanoTime();
              Iterator localIterator = locala.akbQ.iterator();
              while (localIterator.hasNext())
              {
                a.c localc = (a.c)localIterator.next();
                if (localc.akcb > l) {
                  break;
                }
                if (locala.akbQ.remove(localc)) {
                  locala.akbR.e(localc);
                }
              }
            }
            AppMethodBeat.o(90311);
          }
        }, this.ahAh, this.ahAh, TimeUnit.NANOSECONDS);
      }
      for (;;)
      {
        this.akbS = paramThreadFactory;
        this.akbT = paramTimeUnit;
        AppMethodBeat.o(90312);
        return;
        paramLong = 0L;
        break;
        label126:
        paramTimeUnit = null;
        paramThreadFactory = null;
      }
    }
    
    final a.c kKr()
    {
      AppMethodBeat.i(90313);
      if (this.akbR.akdH)
      {
        localc = a.akbN;
        AppMethodBeat.o(90313);
        return localc;
      }
      while (!this.akbQ.isEmpty())
      {
        localc = (a.c)this.akbQ.poll();
        if (localc != null)
        {
          AppMethodBeat.o(90313);
          return localc;
        }
      }
      a.c localc = new a.c(this.ahAf);
      this.akbR.b(localc);
      AppMethodBeat.o(90313);
      return localc;
    }
    
    final void shutdown()
    {
      AppMethodBeat.i(90314);
      try
      {
        if (this.akbT != null) {
          this.akbT.cancel(true);
        }
        if (this.akbS != null) {
          this.akbS.shutdownNow();
        }
        return;
      }
      finally
      {
        this.akbR.kKh();
        AppMethodBeat.o(90314);
      }
    }
  }
  
  static final class b
    extends g.a
  {
    final b akbW;
    private final a.a akbX;
    private final a.c akbY;
    final AtomicBoolean akbZ;
    
    b(a.a parama)
    {
      AppMethodBeat.i(90316);
      this.akbW = new b();
      this.akbX = parama;
      this.akbZ = new AtomicBoolean();
      this.akbY = parama.kKr();
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
      if (this.akbW.akdH)
      {
        parama = d.kKY();
        AppMethodBeat.o(90319);
        return parama;
      }
      parama = this.akbY.b(new rx.b.a()
      {
        public final void call()
        {
          AppMethodBeat.i(90315);
          if (a.b.this.akbW.akdH)
          {
            AppMethodBeat.o(90315);
            return;
          }
          parama.call();
          AppMethodBeat.o(90315);
        }
      }, paramLong, paramTimeUnit);
      this.akbW.b(parama);
      paramTimeUnit = this.akbW;
      parama.akcJ.b(new i.b(parama, paramTimeUnit));
      AppMethodBeat.o(90319);
      return parama;
    }
    
    public final void kKh()
    {
      AppMethodBeat.i(90317);
      if (this.akbZ.compareAndSet(false, true))
      {
        a.a locala = this.akbX;
        a.c localc = this.akbY;
        localc.akcb = (System.nanoTime() + locala.ahAh);
        locala.akbQ.offer(localc);
      }
      this.akbW.kKh();
      AppMethodBeat.o(90317);
    }
    
    public final boolean kKi()
    {
      return this.akbW.akdH;
    }
  }
  
  static final class c
    extends h
  {
    long akcb = 0L;
    
    c(ThreadFactory paramThreadFactory)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     rx.internal.c.a
 * JD-Core Version:    0.7.0.1
 */