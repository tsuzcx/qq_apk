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
  static final int NYV;
  static final c NYW;
  static final b NYX;
  final ThreadFactory LTn;
  public final AtomicReference<b> NYI;
  
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
    NYV = i;
    c localc = new c(rx.internal.util.g.Oax);
    NYW = localc;
    localc.gyQ();
    NYX = new b(null, 0);
    AppMethodBeat.o(90360);
  }
  
  public b(ThreadFactory paramThreadFactory)
  {
    AppMethodBeat.i(90356);
    this.LTn = paramThreadFactory;
    this.NYI = new AtomicReference(NYX);
    start();
    AppMethodBeat.o(90356);
  }
  
  public final g.a createWorker()
  {
    AppMethodBeat.i(90357);
    a locala = new a(((b)this.NYI.get()).gza());
    AppMethodBeat.o(90357);
    return locala;
  }
  
  public final void shutdown()
  {
    AppMethodBeat.i(90359);
    b localb;
    do
    {
      localb = (b)this.NYI.get();
      if (localb == NYX)
      {
        AppMethodBeat.o(90359);
        return;
      }
    } while (!this.NYI.compareAndSet(localb, NYX));
    localb.shutdown();
    AppMethodBeat.o(90359);
  }
  
  public final void start()
  {
    AppMethodBeat.i(90358);
    b localb = new b(this.LTn, NYV);
    if (!this.NYI.compareAndSet(NYX, localb)) {
      localb.shutdown();
    }
    AppMethodBeat.o(90358);
  }
  
  static final class a
    extends g.a
  {
    private final rx.internal.util.i NYY;
    private final rx.f.b NYZ;
    final rx.internal.util.i NZa;
    private final b.c NZb;
    
    a(b.c paramc)
    {
      AppMethodBeat.i(90352);
      this.NYY = new rx.internal.util.i();
      this.NYZ = new rx.f.b();
      this.NZa = new rx.internal.util.i(new rx.j[] { this.NYY, this.NYZ });
      this.NZb = paramc;
      AppMethodBeat.o(90352);
    }
    
    public final rx.j a(final a parama)
    {
      AppMethodBeat.i(90354);
      if (this.NZa.OaI)
      {
        parama = d.gzD();
        AppMethodBeat.o(90354);
        return parama;
      }
      b.c localc = this.NZb;
      Object localObject = new a()
      {
        public final void call()
        {
          AppMethodBeat.i(90350);
          if (b.a.this.NZa.OaI)
          {
            AppMethodBeat.o(90350);
            return;
          }
          parama.call();
          AppMethodBeat.o(90350);
        }
      };
      parama = this.NYY;
      localObject = new i(c.b((a)localObject), parama);
      parama.b((rx.j)localObject);
      if (0L <= 0L) {}
      for (parama = localc.NZu.submit((Runnable)localObject);; parama = localc.NZu.schedule((Runnable)localObject, 0L, null))
      {
        ((i)localObject).b(parama);
        AppMethodBeat.o(90354);
        return localObject;
      }
    }
    
    public final rx.j a(final a parama, long paramLong, TimeUnit paramTimeUnit)
    {
      AppMethodBeat.i(90355);
      if (this.NZa.OaI)
      {
        parama = d.gzD();
        AppMethodBeat.o(90355);
        return parama;
      }
      b.c localc = this.NZb;
      Object localObject = new a()
      {
        public final void call()
        {
          AppMethodBeat.i(90351);
          if (b.a.this.NZa.OaI)
          {
            AppMethodBeat.o(90351);
            return;
          }
          parama.call();
          AppMethodBeat.o(90351);
        }
      };
      parama = this.NYZ;
      localObject = new i(c.b((a)localObject), parama);
      parama.b((rx.j)localObject);
      if (paramLong <= 0L) {}
      for (parama = localc.NZu.submit((Runnable)localObject);; parama = localc.NZu.schedule((Runnable)localObject, paramLong, paramTimeUnit))
      {
        ((i)localObject).b(parama);
        AppMethodBeat.o(90355);
        return localObject;
      }
    }
    
    public final void gyQ()
    {
      AppMethodBeat.i(90353);
      this.NZa.gyQ();
      AppMethodBeat.o(90353);
    }
    
    public final boolean gyR()
    {
      return this.NZa.OaI;
    }
  }
  
  public static final class b
  {
    final int NZd;
    final b.c[] NZe;
    long n;
    
    b(ThreadFactory paramThreadFactory, int paramInt)
    {
      AppMethodBeat.i(90348);
      this.NZd = paramInt;
      this.NZe = new b.c[paramInt];
      int i = 0;
      while (i < paramInt)
      {
        this.NZe[i] = new b.c(paramThreadFactory);
        i += 1;
      }
      AppMethodBeat.o(90348);
    }
    
    public final b.c gza()
    {
      int i = this.NZd;
      if (i == 0) {
        return b.NYW;
      }
      b.c[] arrayOfc = this.NZe;
      long l = this.n;
      this.n = (1L + l);
      return arrayOfc[((int)(l % i))];
    }
    
    public final void shutdown()
    {
      AppMethodBeat.i(90349);
      b.c[] arrayOfc = this.NZe;
      int j = arrayOfc.length;
      int i = 0;
      while (i < j)
      {
        arrayOfc[i].gyQ();
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