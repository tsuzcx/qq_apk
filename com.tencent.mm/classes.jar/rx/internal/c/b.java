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
  static final int MdT;
  static final c MdU;
  static final b MdV;
  final ThreadFactory JZs;
  public final AtomicReference<b> MdG;
  
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
    MdT = i;
    c localc = new c(rx.internal.util.g.Mfv);
    MdU = localc;
    localc.ggm();
    MdV = new b(null, 0);
    AppMethodBeat.o(90360);
  }
  
  public b(ThreadFactory paramThreadFactory)
  {
    AppMethodBeat.i(90356);
    this.JZs = paramThreadFactory;
    this.MdG = new AtomicReference(MdV);
    start();
    AppMethodBeat.o(90356);
  }
  
  public final g.a createWorker()
  {
    AppMethodBeat.i(90357);
    a locala = new a(((b)this.MdG.get()).ggw());
    AppMethodBeat.o(90357);
    return locala;
  }
  
  public final void shutdown()
  {
    AppMethodBeat.i(90359);
    b localb;
    do
    {
      localb = (b)this.MdG.get();
      if (localb == MdV)
      {
        AppMethodBeat.o(90359);
        return;
      }
    } while (!this.MdG.compareAndSet(localb, MdV));
    localb.shutdown();
    AppMethodBeat.o(90359);
  }
  
  public final void start()
  {
    AppMethodBeat.i(90358);
    b localb = new b(this.JZs, MdT);
    if (!this.MdG.compareAndSet(MdV, localb)) {
      localb.shutdown();
    }
    AppMethodBeat.o(90358);
  }
  
  static final class a
    extends g.a
  {
    private final rx.internal.util.i MdW;
    private final rx.f.b MdX;
    final rx.internal.util.i MdY;
    private final b.c MdZ;
    
    a(b.c paramc)
    {
      AppMethodBeat.i(90352);
      this.MdW = new rx.internal.util.i();
      this.MdX = new rx.f.b();
      this.MdY = new rx.internal.util.i(new rx.j[] { this.MdW, this.MdX });
      this.MdZ = paramc;
      AppMethodBeat.o(90352);
    }
    
    public final rx.j a(final a parama)
    {
      AppMethodBeat.i(90354);
      if (this.MdY.MfG)
      {
        parama = d.ggZ();
        AppMethodBeat.o(90354);
        return parama;
      }
      b.c localc = this.MdZ;
      Object localObject = new a()
      {
        public final void call()
        {
          AppMethodBeat.i(90350);
          if (b.a.this.MdY.MfG)
          {
            AppMethodBeat.o(90350);
            return;
          }
          parama.call();
          AppMethodBeat.o(90350);
        }
      };
      parama = this.MdW;
      localObject = new i(c.b((a)localObject), parama);
      parama.b((rx.j)localObject);
      if (0L <= 0L) {}
      for (parama = localc.Mes.submit((Runnable)localObject);; parama = localc.Mes.schedule((Runnable)localObject, 0L, null))
      {
        ((i)localObject).b(parama);
        AppMethodBeat.o(90354);
        return localObject;
      }
    }
    
    public final rx.j a(final a parama, long paramLong, TimeUnit paramTimeUnit)
    {
      AppMethodBeat.i(90355);
      if (this.MdY.MfG)
      {
        parama = d.ggZ();
        AppMethodBeat.o(90355);
        return parama;
      }
      b.c localc = this.MdZ;
      Object localObject = new a()
      {
        public final void call()
        {
          AppMethodBeat.i(90351);
          if (b.a.this.MdY.MfG)
          {
            AppMethodBeat.o(90351);
            return;
          }
          parama.call();
          AppMethodBeat.o(90351);
        }
      };
      parama = this.MdX;
      localObject = new i(c.b((a)localObject), parama);
      parama.b((rx.j)localObject);
      if (paramLong <= 0L) {}
      for (parama = localc.Mes.submit((Runnable)localObject);; parama = localc.Mes.schedule((Runnable)localObject, paramLong, paramTimeUnit))
      {
        ((i)localObject).b(parama);
        AppMethodBeat.o(90355);
        return localObject;
      }
    }
    
    public final void ggm()
    {
      AppMethodBeat.i(90353);
      this.MdY.ggm();
      AppMethodBeat.o(90353);
    }
    
    public final boolean ggn()
    {
      return this.MdY.MfG;
    }
  }
  
  public static final class b
  {
    final int Meb;
    final b.c[] Mec;
    long n;
    
    b(ThreadFactory paramThreadFactory, int paramInt)
    {
      AppMethodBeat.i(90348);
      this.Meb = paramInt;
      this.Mec = new b.c[paramInt];
      int i = 0;
      while (i < paramInt)
      {
        this.Mec[i] = new b.c(paramThreadFactory);
        i += 1;
      }
      AppMethodBeat.o(90348);
    }
    
    public final b.c ggw()
    {
      int i = this.Meb;
      if (i == 0) {
        return b.MdU;
      }
      b.c[] arrayOfc = this.Mec;
      long l = this.n;
      this.n = (1L + l);
      return arrayOfc[((int)(l % i))];
    }
    
    public final void shutdown()
    {
      AppMethodBeat.i(90349);
      b.c[] arrayOfc = this.Mec;
      int j = arrayOfc.length;
      int i = 0;
      while (i < j)
      {
        arrayOfc[i].ggm();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     rx.internal.c.b
 * JD-Core Version:    0.7.0.1
 */