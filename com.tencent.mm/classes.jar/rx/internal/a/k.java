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
  private final Long Ovr = null;
  private final rx.b.a Ovs = null;
  private final a.d Ovt = rx.a.OtR;
  
  private rx.i<? super T> b(rx.i<? super T> parami)
  {
    AppMethodBeat.i(90289);
    a locala = new a(parami, this.Ovr, this.Ovs, this.Ovt);
    parami.b(locala);
    parami.a(locala.Ovw);
    AppMethodBeat.o(90289);
    return locala;
  }
  
  static final class a<T>
    extends rx.i<T>
    implements b.a
  {
    private final rx.i<? super T> Ovj;
    private final c<T> Ovl;
    private final rx.b.a Ovs;
    private final a.d Ovt;
    private final AtomicLong Ovu;
    private final AtomicBoolean Ovv;
    final rx.internal.util.b Ovw;
    private final ConcurrentLinkedQueue<Object> sVc;
    
    public a(rx.i<? super T> parami, Long paramLong, rx.b.a parama, a.d paramd)
    {
      AppMethodBeat.i(90279);
      this.sVc = new ConcurrentLinkedQueue();
      this.Ovv = new AtomicBoolean(false);
      this.Ovl = c.gDy();
      this.Ovj = parami;
      if (paramLong != null) {}
      for (parami = new AtomicLong(paramLong.longValue());; parami = null)
      {
        this.Ovu = parami;
        this.Ovs = parama;
        this.Ovw = new rx.internal.util.b(this);
        this.Ovt = paramd;
        AppMethodBeat.o(90279);
        return;
      }
    }
    
    private boolean gDA()
    {
      AppMethodBeat.i(90288);
      if (this.Ovu == null)
      {
        AppMethodBeat.o(90288);
        return true;
      }
      long l;
      label148:
      do
      {
        l = this.Ovu.get();
        if (l <= 0L) {
          for (;;)
          {
            try
            {
              if (!this.Ovt.gDm()) {
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
              if (!this.Ovv.compareAndSet(false, true)) {
                continue;
              }
              this.Ous.gDs();
              this.Ovj.onError(localc);
              int i = 0;
              continue;
            }
            if (this.Ovs != null) {}
            try
            {
              this.Ovs.call();
              if (i != 0) {
                break label148;
              }
              AppMethodBeat.o(90288);
              return false;
            }
            catch (Throwable localThrowable)
            {
              rx.a.b.L(localThrowable);
              this.Ovw.Q(localThrowable);
              AppMethodBeat.o(90288);
              return false;
            }
            i = 0;
          }
        }
      } while (!this.Ovu.compareAndSet(l, l - 1L));
      AppMethodBeat.o(90288);
      return true;
    }
    
    public final void O(Throwable paramThrowable)
    {
      AppMethodBeat.i(90285);
      if (paramThrowable != null)
      {
        this.Ovj.onError(paramThrowable);
        AppMethodBeat.o(90285);
        return;
      }
      this.Ovj.gDo();
      AppMethodBeat.o(90285);
    }
    
    public final boolean accept(Object paramObject)
    {
      AppMethodBeat.i(90284);
      boolean bool = c.a(this.Ovj, paramObject);
      AppMethodBeat.o(90284);
      return bool;
    }
    
    public final void gC(T paramT)
    {
      AppMethodBeat.i(90283);
      if (!gDA())
      {
        AppMethodBeat.o(90283);
        return;
      }
      this.sVc.offer(c.gE(paramT));
      this.Ovw.drain();
      AppMethodBeat.o(90283);
    }
    
    public final void gDo()
    {
      AppMethodBeat.i(90281);
      if (!this.Ovv.get())
      {
        rx.internal.util.b localb = this.Ovw;
        localb.terminated = true;
        localb.drain();
      }
      AppMethodBeat.o(90281);
    }
    
    public final void onError(Throwable paramThrowable)
    {
      AppMethodBeat.i(90282);
      if (!this.Ovv.get()) {
        this.Ovw.Q(paramThrowable);
      }
      AppMethodBeat.o(90282);
    }
    
    public final void onStart()
    {
      AppMethodBeat.i(90280);
      Gq(9223372036854775807L);
      AppMethodBeat.o(90280);
    }
    
    public final Object peek()
    {
      AppMethodBeat.i(90286);
      Object localObject = this.sVc.peek();
      AppMethodBeat.o(90286);
      return localObject;
    }
    
    public final Object poll()
    {
      AppMethodBeat.i(90287);
      Object localObject = this.sVc.poll();
      if ((this.Ovu != null) && (localObject != null)) {
        this.Ovu.incrementAndGet();
      }
      AppMethodBeat.o(90287);
      return localObject;
    }
  }
  
  public static final class b
  {
    public static final k<?> Ovx;
    
    static
    {
      AppMethodBeat.i(90278);
      Ovx = new k();
      AppMethodBeat.o(90278);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     rx.internal.a.k
 * JD-Core Version:    0.7.0.1
 */