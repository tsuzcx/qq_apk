package rx.internal.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.a.d;
import rx.d.b;
import rx.internal.util.b.a;

public final class k<T>
  implements d.b<T, T>
{
  private final Long Ulf = null;
  private final rx.b.a Ulg = null;
  private final a.d Ulh = rx.a.UjF;
  
  private rx.i<? super T> b(rx.i<? super T> parami)
  {
    AppMethodBeat.i(90289);
    a locala = new a(parami, this.Ulf, this.Ulg, this.Ulh);
    parami.b(locala);
    parami.a(locala.Ulk);
    AppMethodBeat.o(90289);
    return locala;
  }
  
  static final class a<T>
    extends rx.i<T>
    implements b.a
  {
    private final rx.i<? super T> UkX;
    private final c<T> UkZ;
    private final rx.b.a Ulg;
    private final a.d Ulh;
    private final AtomicLong Uli;
    private final AtomicBoolean Ulj;
    final rx.internal.util.b Ulk;
    private final ConcurrentLinkedQueue<Object> vTW;
    
    public a(rx.i<? super T> parami, Long paramLong, rx.b.a parama, a.d paramd)
    {
      AppMethodBeat.i(90279);
      this.vTW = new ConcurrentLinkedQueue();
      this.Ulj = new AtomicBoolean(false);
      this.UkZ = c.hQG();
      this.UkX = parami;
      if (paramLong != null) {}
      for (parami = new AtomicLong(paramLong.longValue());; parami = null)
      {
        this.Uli = parami;
        this.Ulg = parama;
        this.Ulk = new rx.internal.util.b(this);
        this.Ulh = paramd;
        AppMethodBeat.o(90279);
        return;
      }
    }
    
    private boolean hQI()
    {
      AppMethodBeat.i(90288);
      if (this.Uli == null)
      {
        AppMethodBeat.o(90288);
        return true;
      }
      long l;
      label148:
      do
      {
        l = this.Uli.get();
        if (l <= 0L) {
          for (;;)
          {
            try
            {
              if (!this.Ulh.hQu()) {
                continue;
              }
              Object localObject = poll();
              if (localObject == null) {
                continue;
              }
              i = 1;
            }
            catch (rx.a.c localc)
            {
              if (!this.Ulj.compareAndSet(false, true)) {
                continue;
              }
              this.Ukg.hQA();
              this.UkX.onError(localc);
              int i = 0;
              continue;
            }
            if (this.Ulg != null) {}
            try
            {
              this.Ulg.call();
              if (i != 0) {
                break label148;
              }
              AppMethodBeat.o(90288);
              return false;
            }
            catch (Throwable localThrowable)
            {
              rx.a.b.N(localThrowable);
              this.Ulk.S(localThrowable);
              AppMethodBeat.o(90288);
              return false;
            }
            i = 0;
          }
        }
      } while (!this.Uli.compareAndSet(l, l - 1L));
      AppMethodBeat.o(90288);
      return true;
    }
    
    public final void Q(Throwable paramThrowable)
    {
      AppMethodBeat.i(90285);
      if (paramThrowable != null)
      {
        this.UkX.onError(paramThrowable);
        AppMethodBeat.o(90285);
        return;
      }
      this.UkX.hQw();
      AppMethodBeat.o(90285);
    }
    
    public final boolean accept(Object paramObject)
    {
      AppMethodBeat.i(90284);
      boolean bool = c.a(this.UkX, paramObject);
      AppMethodBeat.o(90284);
      return bool;
    }
    
    public final void gL(T paramT)
    {
      AppMethodBeat.i(90283);
      if (!hQI())
      {
        AppMethodBeat.o(90283);
        return;
      }
      this.vTW.offer(c.gN(paramT));
      this.Ulk.drain();
      AppMethodBeat.o(90283);
    }
    
    public final void hQw()
    {
      AppMethodBeat.i(90281);
      if (!this.Ulj.get())
      {
        rx.internal.util.b localb = this.Ulk;
        localb.terminated = true;
        localb.drain();
      }
      AppMethodBeat.o(90281);
    }
    
    public final void onError(Throwable paramThrowable)
    {
      AppMethodBeat.i(90282);
      if (!this.Ulj.get()) {
        this.Ulk.S(paramThrowable);
      }
      AppMethodBeat.o(90282);
    }
    
    public final void onStart()
    {
      AppMethodBeat.i(90280);
      Pw(9223372036854775807L);
      AppMethodBeat.o(90280);
    }
    
    public final Object peek()
    {
      AppMethodBeat.i(90286);
      Object localObject = this.vTW.peek();
      AppMethodBeat.o(90286);
      return localObject;
    }
    
    public final Object poll()
    {
      AppMethodBeat.i(90287);
      Object localObject = this.vTW.poll();
      if ((this.Uli != null) && (localObject != null)) {
        this.Uli.incrementAndGet();
      }
      AppMethodBeat.o(90287);
      return localObject;
    }
  }
  
  public static final class b
  {
    public static final k<?> Ull;
    
    static
    {
      AppMethodBeat.i(90278);
      Ull = new k();
      AppMethodBeat.o(90278);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     rx.internal.a.k
 * JD-Core Version:    0.7.0.1
 */