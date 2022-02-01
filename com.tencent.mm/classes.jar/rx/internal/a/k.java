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
  private final Long Mdk = null;
  private final rx.b.a Mdl = null;
  private final a.d Mdm = rx.a.MbK;
  
  private rx.i<? super T> b(rx.i<? super T> parami)
  {
    AppMethodBeat.i(90289);
    a locala = new a(parami, this.Mdk, this.Mdl, this.Mdm);
    parami.b(locala);
    parami.a(locala.Mdp);
    AppMethodBeat.o(90289);
    return locala;
  }
  
  static final class a<T>
    extends rx.i<T>
    implements b.a
  {
    private final rx.i<? super T> Mdc;
    private final c<T> Mde;
    private final rx.b.a Mdl;
    private final a.d Mdm;
    private final AtomicLong Mdn;
    private final AtomicBoolean Mdo;
    final rx.internal.util.b Mdp;
    private final ConcurrentLinkedQueue<Object> rNK;
    
    public a(rx.i<? super T> parami, Long paramLong, rx.b.a parama, a.d paramd)
    {
      AppMethodBeat.i(90279);
      this.rNK = new ConcurrentLinkedQueue();
      this.Mdo = new AtomicBoolean(false);
      this.Mde = c.ggs();
      this.Mdc = parami;
      if (paramLong != null) {}
      for (parami = new AtomicLong(paramLong.longValue());; parami = null)
      {
        this.Mdn = parami;
        this.Mdl = parama;
        this.Mdp = new rx.internal.util.b(this);
        this.Mdm = paramd;
        AppMethodBeat.o(90279);
        return;
      }
    }
    
    private boolean ggu()
    {
      AppMethodBeat.i(90288);
      if (this.Mdn == null)
      {
        AppMethodBeat.o(90288);
        return true;
      }
      long l;
      label148:
      do
      {
        l = this.Mdn.get();
        if (l <= 0L) {
          for (;;)
          {
            try
            {
              if (!this.Mdm.ggg()) {
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
              if (!this.Mdo.compareAndSet(false, true)) {
                continue;
              }
              this.Mcl.ggm();
              this.Mdc.onError(localc);
              int i = 0;
              continue;
            }
            if (this.Mdl != null) {}
            try
            {
              this.Mdl.call();
              if (i != 0) {
                break label148;
              }
              AppMethodBeat.o(90288);
              return false;
            }
            catch (Throwable localThrowable)
            {
              rx.a.b.J(localThrowable);
              this.Mdp.O(localThrowable);
              AppMethodBeat.o(90288);
              return false;
            }
            i = 0;
          }
        }
      } while (!this.Mdn.compareAndSet(l, l - 1L));
      AppMethodBeat.o(90288);
      return true;
    }
    
    public final void M(Throwable paramThrowable)
    {
      AppMethodBeat.i(90285);
      if (paramThrowable != null)
      {
        this.Mdc.onError(paramThrowable);
        AppMethodBeat.o(90285);
        return;
      }
      this.Mdc.ggi();
      AppMethodBeat.o(90285);
    }
    
    public final boolean accept(Object paramObject)
    {
      AppMethodBeat.i(90284);
      boolean bool = c.a(this.Mdc, paramObject);
      AppMethodBeat.o(90284);
      return bool;
    }
    
    public final void gd(T paramT)
    {
      AppMethodBeat.i(90283);
      if (!ggu())
      {
        AppMethodBeat.o(90283);
        return;
      }
      this.rNK.offer(c.gf(paramT));
      this.Mdp.drain();
      AppMethodBeat.o(90283);
    }
    
    public final void ggi()
    {
      AppMethodBeat.i(90281);
      if (!this.Mdo.get())
      {
        rx.internal.util.b localb = this.Mdp;
        localb.terminated = true;
        localb.drain();
      }
      AppMethodBeat.o(90281);
    }
    
    public final void onError(Throwable paramThrowable)
    {
      AppMethodBeat.i(90282);
      if (!this.Mdo.get()) {
        this.Mdp.O(paramThrowable);
      }
      AppMethodBeat.o(90282);
    }
    
    public final void onStart()
    {
      AppMethodBeat.i(90280);
      CI(9223372036854775807L);
      AppMethodBeat.o(90280);
    }
    
    public final Object peek()
    {
      AppMethodBeat.i(90286);
      Object localObject = this.rNK.peek();
      AppMethodBeat.o(90286);
      return localObject;
    }
    
    public final Object poll()
    {
      AppMethodBeat.i(90287);
      Object localObject = this.rNK.poll();
      if ((this.Mdn != null) && (localObject != null)) {
        this.Mdn.incrementAndGet();
      }
      AppMethodBeat.o(90287);
      return localObject;
    }
  }
  
  public static final class b
  {
    public static final k<?> Mdq;
    
    static
    {
      AppMethodBeat.i(90278);
      Mdq = new k();
      AppMethodBeat.o(90278);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     rx.internal.a.k
 * JD-Core Version:    0.7.0.1
 */