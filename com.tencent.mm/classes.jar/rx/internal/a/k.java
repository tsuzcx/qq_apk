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
  private final Long KpB = null;
  private final rx.b.a KpC = null;
  private final a.d KpD = rx.a.Kob;
  
  private rx.i<? super T> b(rx.i<? super T> parami)
  {
    AppMethodBeat.i(90289);
    a locala = new a(parami, this.KpB, this.KpC, this.KpD);
    parami.b(locala);
    parami.a(locala.KpG);
    AppMethodBeat.o(90289);
    return locala;
  }
  
  static final class a<T>
    extends rx.i<T>
    implements b.a
  {
    private final rx.b.a KpC;
    private final a.d KpD;
    private final AtomicLong KpE;
    private final AtomicBoolean KpF;
    final rx.internal.util.b KpG;
    private final rx.i<? super T> Kpt;
    private final c<T> Kpv;
    private final ConcurrentLinkedQueue<Object> qRN;
    
    public a(rx.i<? super T> parami, Long paramLong, rx.b.a parama, a.d paramd)
    {
      AppMethodBeat.i(90279);
      this.qRN = new ConcurrentLinkedQueue();
      this.KpF = new AtomicBoolean(false);
      this.Kpv = c.fNC();
      this.Kpt = parami;
      if (paramLong != null) {}
      for (parami = new AtomicLong(paramLong.longValue());; parami = null)
      {
        this.KpE = parami;
        this.KpC = parama;
        this.KpG = new rx.internal.util.b(this);
        this.KpD = paramd;
        AppMethodBeat.o(90279);
        return;
      }
    }
    
    private boolean fNE()
    {
      AppMethodBeat.i(90288);
      if (this.KpE == null)
      {
        AppMethodBeat.o(90288);
        return true;
      }
      long l;
      label148:
      do
      {
        l = this.KpE.get();
        if (l <= 0L) {
          for (;;)
          {
            try
            {
              if (!this.KpD.fNq()) {
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
              if (!this.KpF.compareAndSet(false, true)) {
                continue;
              }
              this.KoC.fNw();
              this.Kpt.onError(localc);
              int i = 0;
              continue;
            }
            if (this.KpC != null) {}
            try
            {
              this.KpC.call();
              if (i != 0) {
                break label148;
              }
              AppMethodBeat.o(90288);
              return false;
            }
            catch (Throwable localThrowable)
            {
              rx.a.b.I(localThrowable);
              this.KpG.N(localThrowable);
              AppMethodBeat.o(90288);
              return false;
            }
            i = 0;
          }
        }
      } while (!this.KpE.compareAndSet(l, l - 1L));
      AppMethodBeat.o(90288);
      return true;
    }
    
    public final void L(Throwable paramThrowable)
    {
      AppMethodBeat.i(90285);
      if (paramThrowable != null)
      {
        this.Kpt.onError(paramThrowable);
        AppMethodBeat.o(90285);
        return;
      }
      this.Kpt.fNs();
      AppMethodBeat.o(90285);
    }
    
    public final boolean accept(Object paramObject)
    {
      AppMethodBeat.i(90284);
      boolean bool = c.a(this.Kpt, paramObject);
      AppMethodBeat.o(90284);
      return bool;
    }
    
    public final void fNs()
    {
      AppMethodBeat.i(90281);
      if (!this.KpF.get())
      {
        rx.internal.util.b localb = this.KpG;
        localb.terminated = true;
        localb.drain();
      }
      AppMethodBeat.o(90281);
    }
    
    public final void fV(T paramT)
    {
      AppMethodBeat.i(90283);
      if (!fNE())
      {
        AppMethodBeat.o(90283);
        return;
      }
      this.qRN.offer(c.fX(paramT));
      this.KpG.drain();
      AppMethodBeat.o(90283);
    }
    
    public final void onError(Throwable paramThrowable)
    {
      AppMethodBeat.i(90282);
      if (!this.KpF.get()) {
        this.KpG.N(paramThrowable);
      }
      AppMethodBeat.o(90282);
    }
    
    public final void onStart()
    {
      AppMethodBeat.i(90280);
      xU(9223372036854775807L);
      AppMethodBeat.o(90280);
    }
    
    public final Object peek()
    {
      AppMethodBeat.i(90286);
      Object localObject = this.qRN.peek();
      AppMethodBeat.o(90286);
      return localObject;
    }
    
    public final Object poll()
    {
      AppMethodBeat.i(90287);
      Object localObject = this.qRN.poll();
      if ((this.KpE != null) && (localObject != null)) {
        this.KpE.incrementAndGet();
      }
      AppMethodBeat.o(90287);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     rx.internal.a.k
 * JD-Core Version:    0.7.0.1
 */