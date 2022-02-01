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
  static final int UlO;
  static final c UlP;
  static final b UlQ;
  final ThreadFactory RSH;
  public final AtomicReference<b> UlB;
  
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
    UlO = i;
    c localc = new c(rx.internal.util.g.Unq);
    UlP = localc;
    localc.hQA();
    UlQ = new b(null, 0);
    AppMethodBeat.o(90360);
  }
  
  public b(ThreadFactory paramThreadFactory)
  {
    AppMethodBeat.i(90356);
    this.RSH = paramThreadFactory;
    this.UlB = new AtomicReference(UlQ);
    start();
    AppMethodBeat.o(90356);
  }
  
  public final g.a createWorker()
  {
    AppMethodBeat.i(90357);
    a locala = new a(((b)this.UlB.get()).hQK());
    AppMethodBeat.o(90357);
    return locala;
  }
  
  public final void shutdown()
  {
    AppMethodBeat.i(90359);
    b localb;
    do
    {
      localb = (b)this.UlB.get();
      if (localb == UlQ)
      {
        AppMethodBeat.o(90359);
        return;
      }
    } while (!this.UlB.compareAndSet(localb, UlQ));
    localb.shutdown();
    AppMethodBeat.o(90359);
  }
  
  public final void start()
  {
    AppMethodBeat.i(90358);
    b localb = new b(this.RSH, UlO);
    if (!this.UlB.compareAndSet(UlQ, localb)) {
      localb.shutdown();
    }
    AppMethodBeat.o(90358);
  }
  
  static final class a
    extends g.a
  {
    private final rx.internal.util.i UlR;
    private final rx.f.b UlS;
    final rx.internal.util.i UlT;
    private final b.c UlU;
    
    a(b.c paramc)
    {
      AppMethodBeat.i(90352);
      this.UlR = new rx.internal.util.i();
      this.UlS = new rx.f.b();
      this.UlT = new rx.internal.util.i(new rx.j[] { this.UlR, this.UlS });
      this.UlU = paramc;
      AppMethodBeat.o(90352);
    }
    
    public final rx.j a(final a parama)
    {
      AppMethodBeat.i(90354);
      if (this.UlT.UnB)
      {
        parama = d.hRn();
        AppMethodBeat.o(90354);
        return parama;
      }
      b.c localc = this.UlU;
      Object localObject = new a()
      {
        public final void call()
        {
          AppMethodBeat.i(90350);
          if (b.a.this.UlT.UnB)
          {
            AppMethodBeat.o(90350);
            return;
          }
          parama.call();
          AppMethodBeat.o(90350);
        }
      };
      parama = this.UlR;
      localObject = new i(c.b((a)localObject), parama);
      parama.b((rx.j)localObject);
      if (0L <= 0L) {}
      for (parama = localc.Umn.submit((Runnable)localObject);; parama = localc.Umn.schedule((Runnable)localObject, 0L, null))
      {
        ((i)localObject).b(parama);
        AppMethodBeat.o(90354);
        return localObject;
      }
    }
    
    public final rx.j a(final a parama, long paramLong, TimeUnit paramTimeUnit)
    {
      AppMethodBeat.i(90355);
      if (this.UlT.UnB)
      {
        parama = d.hRn();
        AppMethodBeat.o(90355);
        return parama;
      }
      b.c localc = this.UlU;
      Object localObject = new a()
      {
        public final void call()
        {
          AppMethodBeat.i(90351);
          if (b.a.this.UlT.UnB)
          {
            AppMethodBeat.o(90351);
            return;
          }
          parama.call();
          AppMethodBeat.o(90351);
        }
      };
      parama = this.UlS;
      localObject = new i(c.b((a)localObject), parama);
      parama.b((rx.j)localObject);
      if (paramLong <= 0L) {}
      for (parama = localc.Umn.submit((Runnable)localObject);; parama = localc.Umn.schedule((Runnable)localObject, paramLong, paramTimeUnit))
      {
        ((i)localObject).b(parama);
        AppMethodBeat.o(90355);
        return localObject;
      }
    }
    
    public final void hQA()
    {
      AppMethodBeat.i(90353);
      this.UlT.hQA();
      AppMethodBeat.o(90353);
    }
    
    public final boolean hQB()
    {
      return this.UlT.UnB;
    }
  }
  
  public static final class b
  {
    final int UlW;
    final b.c[] UlX;
    long n;
    
    b(ThreadFactory paramThreadFactory, int paramInt)
    {
      AppMethodBeat.i(90348);
      this.UlW = paramInt;
      this.UlX = new b.c[paramInt];
      int i = 0;
      while (i < paramInt)
      {
        this.UlX[i] = new b.c(paramThreadFactory);
        i += 1;
      }
      AppMethodBeat.o(90348);
    }
    
    public final b.c hQK()
    {
      int i = this.UlW;
      if (i == 0) {
        return b.UlP;
      }
      b.c[] arrayOfc = this.UlX;
      long l = this.n;
      this.n = (1L + l);
      return arrayOfc[((int)(l % i))];
    }
    
    public final void shutdown()
    {
      AppMethodBeat.i(90349);
      b.c[] arrayOfc = this.UlX;
      int j = arrayOfc.length;
      int i = 0;
      while (i < j)
      {
        arrayOfc[i].hQA();
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