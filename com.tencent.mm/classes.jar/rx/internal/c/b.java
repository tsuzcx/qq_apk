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
  static final int Kqk;
  static final c Kql;
  static final b Kqm;
  final ThreadFactory IxJ;
  public final AtomicReference<b> KpX;
  
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
    Kqk = i;
    c localc = new c(rx.internal.util.g.KrM);
    Kql = localc;
    localc.fNw();
    Kqm = new b(null, 0);
    AppMethodBeat.o(90360);
  }
  
  public b(ThreadFactory paramThreadFactory)
  {
    AppMethodBeat.i(90356);
    this.IxJ = paramThreadFactory;
    this.KpX = new AtomicReference(Kqm);
    start();
    AppMethodBeat.o(90356);
  }
  
  public final g.a createWorker()
  {
    AppMethodBeat.i(90357);
    a locala = new a(((b)this.KpX.get()).fNG());
    AppMethodBeat.o(90357);
    return locala;
  }
  
  public final void shutdown()
  {
    AppMethodBeat.i(90359);
    b localb;
    do
    {
      localb = (b)this.KpX.get();
      if (localb == Kqm)
      {
        AppMethodBeat.o(90359);
        return;
      }
    } while (!this.KpX.compareAndSet(localb, Kqm));
    localb.shutdown();
    AppMethodBeat.o(90359);
  }
  
  public final void start()
  {
    AppMethodBeat.i(90358);
    b localb = new b(this.IxJ, Kqk);
    if (!this.KpX.compareAndSet(Kqm, localb)) {
      localb.shutdown();
    }
    AppMethodBeat.o(90358);
  }
  
  static final class a
    extends g.a
  {
    private final rx.internal.util.i Kqn;
    private final rx.f.b Kqo;
    final rx.internal.util.i Kqp;
    private final b.c Kqq;
    
    a(b.c paramc)
    {
      AppMethodBeat.i(90352);
      this.Kqn = new rx.internal.util.i();
      this.Kqo = new rx.f.b();
      this.Kqp = new rx.internal.util.i(new rx.j[] { this.Kqn, this.Kqo });
      this.Kqq = paramc;
      AppMethodBeat.o(90352);
    }
    
    public final rx.j a(final a parama)
    {
      AppMethodBeat.i(90354);
      if (this.Kqp.KrX)
      {
        parama = d.fOj();
        AppMethodBeat.o(90354);
        return parama;
      }
      b.c localc = this.Kqq;
      Object localObject = new a()
      {
        public final void call()
        {
          AppMethodBeat.i(90350);
          if (b.a.this.Kqp.KrX)
          {
            AppMethodBeat.o(90350);
            return;
          }
          parama.call();
          AppMethodBeat.o(90350);
        }
      };
      parama = this.Kqn;
      localObject = new i(c.b((a)localObject), parama);
      parama.b((rx.j)localObject);
      if (0L <= 0L) {}
      for (parama = localc.KqJ.submit((Runnable)localObject);; parama = localc.KqJ.schedule((Runnable)localObject, 0L, null))
      {
        ((i)localObject).b(parama);
        AppMethodBeat.o(90354);
        return localObject;
      }
    }
    
    public final rx.j a(final a parama, long paramLong, TimeUnit paramTimeUnit)
    {
      AppMethodBeat.i(90355);
      if (this.Kqp.KrX)
      {
        parama = d.fOj();
        AppMethodBeat.o(90355);
        return parama;
      }
      b.c localc = this.Kqq;
      Object localObject = new a()
      {
        public final void call()
        {
          AppMethodBeat.i(90351);
          if (b.a.this.Kqp.KrX)
          {
            AppMethodBeat.o(90351);
            return;
          }
          parama.call();
          AppMethodBeat.o(90351);
        }
      };
      parama = this.Kqo;
      localObject = new i(c.b((a)localObject), parama);
      parama.b((rx.j)localObject);
      if (paramLong <= 0L) {}
      for (parama = localc.KqJ.submit((Runnable)localObject);; parama = localc.KqJ.schedule((Runnable)localObject, paramLong, paramTimeUnit))
      {
        ((i)localObject).b(parama);
        AppMethodBeat.o(90355);
        return localObject;
      }
    }
    
    public final void fNw()
    {
      AppMethodBeat.i(90353);
      this.Kqp.fNw();
      AppMethodBeat.o(90353);
    }
    
    public final boolean fNx()
    {
      return this.Kqp.KrX;
    }
  }
  
  public static final class b
  {
    final int Kqs;
    final b.c[] Kqt;
    long n;
    
    b(ThreadFactory paramThreadFactory, int paramInt)
    {
      AppMethodBeat.i(90348);
      this.Kqs = paramInt;
      this.Kqt = new b.c[paramInt];
      int i = 0;
      while (i < paramInt)
      {
        this.Kqt[i] = new b.c(paramThreadFactory);
        i += 1;
      }
      AppMethodBeat.o(90348);
    }
    
    public final b.c fNG()
    {
      int i = this.Kqs;
      if (i == 0) {
        return b.Kql;
      }
      b.c[] arrayOfc = this.Kqt;
      long l = this.n;
      this.n = (1L + l);
      return arrayOfc[((int)(l % i))];
    }
    
    public final void shutdown()
    {
      AppMethodBeat.i(90349);
      b.c[] arrayOfc = this.Kqt;
      int j = arrayOfc.length;
      int i = 0;
      while (i < j)
      {
        arrayOfc[i].fNw();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     rx.internal.c.b
 * JD-Core Version:    0.7.0.1
 */