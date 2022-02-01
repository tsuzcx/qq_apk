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
  static final int Owa;
  static final c Owb;
  static final b Owc;
  final ThreadFactory Mqk;
  public final AtomicReference<b> OvN;
  
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
    Owa = i;
    c localc = new c(rx.internal.util.g.OxC);
    Owb = localc;
    localc.gDs();
    Owc = new b(null, 0);
    AppMethodBeat.o(90360);
  }
  
  public b(ThreadFactory paramThreadFactory)
  {
    AppMethodBeat.i(90356);
    this.Mqk = paramThreadFactory;
    this.OvN = new AtomicReference(Owc);
    start();
    AppMethodBeat.o(90356);
  }
  
  public final g.a createWorker()
  {
    AppMethodBeat.i(90357);
    a locala = new a(((b)this.OvN.get()).gDC());
    AppMethodBeat.o(90357);
    return locala;
  }
  
  public final void shutdown()
  {
    AppMethodBeat.i(90359);
    b localb;
    do
    {
      localb = (b)this.OvN.get();
      if (localb == Owc)
      {
        AppMethodBeat.o(90359);
        return;
      }
    } while (!this.OvN.compareAndSet(localb, Owc));
    localb.shutdown();
    AppMethodBeat.o(90359);
  }
  
  public final void start()
  {
    AppMethodBeat.i(90358);
    b localb = new b(this.Mqk, Owa);
    if (!this.OvN.compareAndSet(Owc, localb)) {
      localb.shutdown();
    }
    AppMethodBeat.o(90358);
  }
  
  static final class a
    extends g.a
  {
    private final rx.internal.util.i Owd;
    private final rx.f.b Owe;
    final rx.internal.util.i Owf;
    private final b.c Owg;
    
    a(b.c paramc)
    {
      AppMethodBeat.i(90352);
      this.Owd = new rx.internal.util.i();
      this.Owe = new rx.f.b();
      this.Owf = new rx.internal.util.i(new rx.j[] { this.Owd, this.Owe });
      this.Owg = paramc;
      AppMethodBeat.o(90352);
    }
    
    public final rx.j a(final a parama)
    {
      AppMethodBeat.i(90354);
      if (this.Owf.OxN)
      {
        parama = d.gEf();
        AppMethodBeat.o(90354);
        return parama;
      }
      b.c localc = this.Owg;
      Object localObject = new a()
      {
        public final void call()
        {
          AppMethodBeat.i(90350);
          if (b.a.this.Owf.OxN)
          {
            AppMethodBeat.o(90350);
            return;
          }
          parama.call();
          AppMethodBeat.o(90350);
        }
      };
      parama = this.Owd;
      localObject = new i(c.b((a)localObject), parama);
      parama.b((rx.j)localObject);
      if (0L <= 0L) {}
      for (parama = localc.Owz.submit((Runnable)localObject);; parama = localc.Owz.schedule((Runnable)localObject, 0L, null))
      {
        ((i)localObject).b(parama);
        AppMethodBeat.o(90354);
        return localObject;
      }
    }
    
    public final rx.j a(final a parama, long paramLong, TimeUnit paramTimeUnit)
    {
      AppMethodBeat.i(90355);
      if (this.Owf.OxN)
      {
        parama = d.gEf();
        AppMethodBeat.o(90355);
        return parama;
      }
      b.c localc = this.Owg;
      Object localObject = new a()
      {
        public final void call()
        {
          AppMethodBeat.i(90351);
          if (b.a.this.Owf.OxN)
          {
            AppMethodBeat.o(90351);
            return;
          }
          parama.call();
          AppMethodBeat.o(90351);
        }
      };
      parama = this.Owe;
      localObject = new i(c.b((a)localObject), parama);
      parama.b((rx.j)localObject);
      if (paramLong <= 0L) {}
      for (parama = localc.Owz.submit((Runnable)localObject);; parama = localc.Owz.schedule((Runnable)localObject, paramLong, paramTimeUnit))
      {
        ((i)localObject).b(parama);
        AppMethodBeat.o(90355);
        return localObject;
      }
    }
    
    public final void gDs()
    {
      AppMethodBeat.i(90353);
      this.Owf.gDs();
      AppMethodBeat.o(90353);
    }
    
    public final boolean gDt()
    {
      return this.Owf.OxN;
    }
  }
  
  public static final class b
  {
    final int Owi;
    final b.c[] Owj;
    long n;
    
    b(ThreadFactory paramThreadFactory, int paramInt)
    {
      AppMethodBeat.i(90348);
      this.Owi = paramInt;
      this.Owj = new b.c[paramInt];
      int i = 0;
      while (i < paramInt)
      {
        this.Owj[i] = new b.c(paramThreadFactory);
        i += 1;
      }
      AppMethodBeat.o(90348);
    }
    
    public final b.c gDC()
    {
      int i = this.Owi;
      if (i == 0) {
        return b.Owb;
      }
      b.c[] arrayOfc = this.Owj;
      long l = this.n;
      this.n = (1L + l);
      return arrayOfc[((int)(l % i))];
    }
    
    public final void shutdown()
    {
      AppMethodBeat.i(90349);
      b.c[] arrayOfc = this.Owj;
      int j = arrayOfc.length;
      int i = 0;
      while (i < j)
      {
        arrayOfc[i].gDs();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     rx.internal.c.b
 * JD-Core Version:    0.7.0.1
 */