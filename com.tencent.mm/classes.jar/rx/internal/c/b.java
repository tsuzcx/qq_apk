package rx.internal.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.b.a;
import rx.d.c;
import rx.f.d;
import rx.g.a;

public final class b
  extends rx.g
  implements j
{
  static final int abPk;
  static final c abPl;
  static final b abPm;
  final ThreadFactory Zvl;
  public final AtomicReference<b> abOX;
  
  static
  {
    AppMethodBeat.i(90360);
    int j = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
    int k = Runtime.getRuntime().availableProcessors();
    int i;
    if (j > 0)
    {
      i = j;
      if (j <= k) {}
    }
    else
    {
      i = k;
    }
    abPk = i;
    c localc = new c(rx.internal.util.g.abQM);
    abPl = localc;
    localc.iVJ();
    abPm = new b(null, 0);
    AppMethodBeat.o(90360);
  }
  
  public b(ThreadFactory paramThreadFactory)
  {
    AppMethodBeat.i(90356);
    this.Zvl = paramThreadFactory;
    this.abOX = new AtomicReference(abPm);
    start();
    AppMethodBeat.o(90356);
  }
  
  public final g.a createWorker()
  {
    AppMethodBeat.i(90357);
    Object localObject = (b)this.abOX.get();
    int i = ((b)localObject).abPs;
    if (i == 0) {}
    c[] arrayOfc;
    long l;
    for (localObject = abPl;; localObject = arrayOfc[((int)(l % i))])
    {
      localObject = new a((c)localObject);
      AppMethodBeat.o(90357);
      return localObject;
      arrayOfc = ((b)localObject).abPt;
      l = ((b)localObject).n;
      ((b)localObject).n = (1L + l);
    }
  }
  
  public final void shutdown()
  {
    AppMethodBeat.i(90359);
    b localb;
    do
    {
      localb = (b)this.abOX.get();
      if (localb == abPm)
      {
        AppMethodBeat.o(90359);
        return;
      }
    } while (!this.abOX.compareAndSet(localb, abPm));
    localb.shutdown();
    AppMethodBeat.o(90359);
  }
  
  public final void start()
  {
    AppMethodBeat.i(90358);
    b localb = new b(this.Zvl, abPk);
    if (!this.abOX.compareAndSet(abPm, localb)) {
      localb.shutdown();
    }
    AppMethodBeat.o(90358);
  }
  
  static final class a
    extends g.a
  {
    private final rx.internal.util.i abPn;
    private final rx.f.b abPo;
    final rx.internal.util.i abPp;
    private final b.c abPq;
    
    a(b.c paramc)
    {
      AppMethodBeat.i(90352);
      this.abPn = new rx.internal.util.i();
      this.abPo = new rx.f.b();
      this.abPp = new rx.internal.util.i(new rx.j[] { this.abPn, this.abPo });
      this.abPq = paramc;
      AppMethodBeat.o(90352);
    }
    
    public final rx.j a(final a parama)
    {
      AppMethodBeat.i(90354);
      if (this.abPp.abQP)
      {
        parama = d.iWx();
        AppMethodBeat.o(90354);
        return parama;
      }
      b.c localc = this.abPq;
      Object localObject = new a()
      {
        public final void call()
        {
          AppMethodBeat.i(90350);
          if (b.a.this.abPp.abQP)
          {
            AppMethodBeat.o(90350);
            return;
          }
          parama.call();
          AppMethodBeat.o(90350);
        }
      };
      parama = this.abPn;
      localObject = new i(c.b((a)localObject), parama);
      parama.b((rx.j)localObject);
      if (0L <= 0L) {}
      for (parama = localc.abPJ.submit((Runnable)localObject);; parama = localc.abPJ.schedule((Runnable)localObject, 0L, null))
      {
        ((i)localObject).b(parama);
        AppMethodBeat.o(90354);
        return localObject;
      }
    }
    
    public final rx.j a(final a parama, long paramLong, TimeUnit paramTimeUnit)
    {
      AppMethodBeat.i(90355);
      if (this.abPp.abQP)
      {
        parama = d.iWx();
        AppMethodBeat.o(90355);
        return parama;
      }
      b.c localc = this.abPq;
      Object localObject = new a()
      {
        public final void call()
        {
          AppMethodBeat.i(90351);
          if (b.a.this.abPp.abQP)
          {
            AppMethodBeat.o(90351);
            return;
          }
          parama.call();
          AppMethodBeat.o(90351);
        }
      };
      parama = this.abPo;
      localObject = new i(c.b((a)localObject), parama);
      parama.b((rx.j)localObject);
      if (paramLong <= 0L) {}
      for (parama = localc.abPJ.submit((Runnable)localObject);; parama = localc.abPJ.schedule((Runnable)localObject, paramLong, paramTimeUnit))
      {
        ((i)localObject).b(parama);
        AppMethodBeat.o(90355);
        return localObject;
      }
    }
    
    public final void iVJ()
    {
      AppMethodBeat.i(90353);
      this.abPp.iVJ();
      AppMethodBeat.o(90353);
    }
    
    public final boolean iVK()
    {
      return this.abPp.abQP;
    }
  }
  
  public static final class b
  {
    final int abPs;
    final b.c[] abPt;
    long n;
    
    b(ThreadFactory paramThreadFactory, int paramInt)
    {
      AppMethodBeat.i(90348);
      this.abPs = paramInt;
      this.abPt = new b.c[paramInt];
      int i = 0;
      while (i < paramInt)
      {
        this.abPt[i] = new b.c(paramThreadFactory);
        i += 1;
      }
      AppMethodBeat.o(90348);
    }
    
    public final void shutdown()
    {
      AppMethodBeat.i(90349);
      b.c[] arrayOfc = this.abPt;
      int j = arrayOfc.length;
      int i = 0;
      while (i < j)
      {
        arrayOfc[i].iVJ();
        i += 1;
      }
      AppMethodBeat.o(90349);
    }
  }
  
  public static final class c
    extends h
  {
    c(ThreadFactory paramThreadFactory)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     rx.internal.c.b
 * JD-Core Version:    0.7.0.1
 */