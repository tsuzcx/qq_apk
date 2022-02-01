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
  static final int akcc;
  static final c akcd;
  static final b akce;
  final ThreadFactory ahAf;
  public final AtomicReference<b> akbP;
  
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
    akcc = i;
    c localc = new c(rx.internal.util.g.akdE);
    akcd = localc;
    localc.kKh();
    akce = new b(null, 0);
    AppMethodBeat.o(90360);
  }
  
  public b(ThreadFactory paramThreadFactory)
  {
    AppMethodBeat.i(90356);
    this.ahAf = paramThreadFactory;
    this.akbP = new AtomicReference(akce);
    start();
    AppMethodBeat.o(90356);
  }
  
  public final g.a createWorker()
  {
    AppMethodBeat.i(90357);
    Object localObject = (b)this.akbP.get();
    int i = ((b)localObject).akck;
    if (i == 0) {}
    c[] arrayOfc;
    long l;
    for (localObject = akcd;; localObject = arrayOfc[((int)(l % i))])
    {
      localObject = new a((c)localObject);
      AppMethodBeat.o(90357);
      return localObject;
      arrayOfc = ((b)localObject).akcl;
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
      localb = (b)this.akbP.get();
      if (localb == akce)
      {
        AppMethodBeat.o(90359);
        return;
      }
    } while (!this.akbP.compareAndSet(localb, akce));
    localb.shutdown();
    AppMethodBeat.o(90359);
  }
  
  public final void start()
  {
    AppMethodBeat.i(90358);
    b localb = new b(this.ahAf, akcc);
    if (!this.akbP.compareAndSet(akce, localb)) {
      localb.shutdown();
    }
    AppMethodBeat.o(90358);
  }
  
  static final class a
    extends g.a
  {
    private final rx.internal.util.i akcf;
    private final rx.f.b akcg;
    final rx.internal.util.i akch;
    private final b.c akci;
    
    a(b.c paramc)
    {
      AppMethodBeat.i(90352);
      this.akcf = new rx.internal.util.i();
      this.akcg = new rx.f.b();
      this.akch = new rx.internal.util.i(new rx.j[] { this.akcf, this.akcg });
      this.akci = paramc;
      AppMethodBeat.o(90352);
    }
    
    public final rx.j a(final a parama)
    {
      AppMethodBeat.i(90354);
      if (this.akch.akdH)
      {
        parama = d.kKY();
        AppMethodBeat.o(90354);
        return parama;
      }
      b.c localc = this.akci;
      Object localObject = new a()
      {
        public final void call()
        {
          AppMethodBeat.i(90350);
          if (b.a.this.akch.akdH)
          {
            AppMethodBeat.o(90350);
            return;
          }
          parama.call();
          AppMethodBeat.o(90350);
        }
      };
      parama = this.akcf;
      localObject = new i(c.b((a)localObject), parama);
      parama.b((rx.j)localObject);
      if (0L <= 0L) {}
      for (parama = localc.akcB.submit((Runnable)localObject);; parama = localc.akcB.schedule((Runnable)localObject, 0L, null))
      {
        ((i)localObject).d(parama);
        AppMethodBeat.o(90354);
        return localObject;
      }
    }
    
    public final rx.j a(final a parama, long paramLong, TimeUnit paramTimeUnit)
    {
      AppMethodBeat.i(90355);
      if (this.akch.akdH)
      {
        parama = d.kKY();
        AppMethodBeat.o(90355);
        return parama;
      }
      b.c localc = this.akci;
      Object localObject = new a()
      {
        public final void call()
        {
          AppMethodBeat.i(90351);
          if (b.a.this.akch.akdH)
          {
            AppMethodBeat.o(90351);
            return;
          }
          parama.call();
          AppMethodBeat.o(90351);
        }
      };
      parama = this.akcg;
      localObject = new i(c.b((a)localObject), parama);
      parama.b((rx.j)localObject);
      if (paramLong <= 0L) {}
      for (parama = localc.akcB.submit((Runnable)localObject);; parama = localc.akcB.schedule((Runnable)localObject, paramLong, paramTimeUnit))
      {
        ((i)localObject).d(parama);
        AppMethodBeat.o(90355);
        return localObject;
      }
    }
    
    public final void kKh()
    {
      AppMethodBeat.i(90353);
      this.akch.kKh();
      AppMethodBeat.o(90353);
    }
    
    public final boolean kKi()
    {
      return this.akch.akdH;
    }
  }
  
  public static final class b
  {
    final int akck;
    final b.c[] akcl;
    long n;
    
    b(ThreadFactory paramThreadFactory, int paramInt)
    {
      AppMethodBeat.i(90348);
      this.akck = paramInt;
      this.akcl = new b.c[paramInt];
      int i = 0;
      while (i < paramInt)
      {
        this.akcl[i] = new b.c(paramThreadFactory);
        i += 1;
      }
      AppMethodBeat.o(90348);
    }
    
    public final void shutdown()
    {
      AppMethodBeat.i(90349);
      b.c[] arrayOfc = this.akcl;
      int j = arrayOfc.length;
      int i = 0;
      while (i < j)
      {
        arrayOfc[i].kKh();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     rx.internal.c.b
 * JD-Core Version:    0.7.0.1
 */