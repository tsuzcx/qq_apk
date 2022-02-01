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
  private final Long NYm = null;
  private final rx.b.a NYn = null;
  private final a.d NYo = rx.a.NWM;
  
  private rx.i<? super T> b(rx.i<? super T> parami)
  {
    AppMethodBeat.i(90289);
    a locala = new a(parami, this.NYm, this.NYn, this.NYo);
    parami.b(locala);
    parami.a(locala.NYr);
    AppMethodBeat.o(90289);
    return locala;
  }
  
  static final class a<T>
    extends rx.i<T>
    implements b.a
  {
    private final rx.i<? super T> NYe;
    private final c<T> NYg;
    private final rx.b.a NYn;
    private final a.d NYo;
    private final AtomicLong NYp;
    private final AtomicBoolean NYq;
    final rx.internal.util.b NYr;
    private final ConcurrentLinkedQueue<Object> sJP;
    
    public a(rx.i<? super T> parami, Long paramLong, rx.b.a parama, a.d paramd)
    {
      AppMethodBeat.i(90279);
      this.sJP = new ConcurrentLinkedQueue();
      this.NYq = new AtomicBoolean(false);
      this.NYg = c.gyW();
      this.NYe = parami;
      if (paramLong != null) {}
      for (parami = new AtomicLong(paramLong.longValue());; parami = null)
      {
        this.NYp = parami;
        this.NYn = parama;
        this.NYr = new rx.internal.util.b(this);
        this.NYo = paramd;
        AppMethodBeat.o(90279);
        return;
      }
    }
    
    private boolean gyY()
    {
      AppMethodBeat.i(90288);
      if (this.NYp == null)
      {
        AppMethodBeat.o(90288);
        return true;
      }
      long l;
      label148:
      do
      {
        l = this.NYp.get();
        if (l <= 0L) {
          for (;;)
          {
            try
            {
              if (!this.NYo.gyK()) {
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
              if (!this.NYq.compareAndSet(false, true)) {
                continue;
              }
              this.NXn.gyQ();
              this.NYe.onError(localc);
              int i = 0;
              continue;
            }
            if (this.NYn != null) {}
            try
            {
              this.NYn.call();
              if (i != 0) {
                break label148;
              }
              AppMethodBeat.o(90288);
              return false;
            }
            catch (Throwable localThrowable)
            {
              rx.a.b.K(localThrowable);
              this.NYr.P(localThrowable);
              AppMethodBeat.o(90288);
              return false;
            }
            i = 0;
          }
        }
      } while (!this.NYp.compareAndSet(l, l - 1L));
      AppMethodBeat.o(90288);
      return true;
    }
    
    public final void N(Throwable paramThrowable)
    {
      AppMethodBeat.i(90285);
      if (paramThrowable != null)
      {
        this.NYe.onError(paramThrowable);
        AppMethodBeat.o(90285);
        return;
      }
      this.NYe.gyM();
      AppMethodBeat.o(90285);
    }
    
    public final boolean accept(Object paramObject)
    {
      AppMethodBeat.i(90284);
      boolean bool = c.a(this.NYe, paramObject);
      AppMethodBeat.o(90284);
      return bool;
    }
    
    public final void gyM()
    {
      AppMethodBeat.i(90281);
      if (!this.NYq.get())
      {
        rx.internal.util.b localb = this.NYr;
        localb.terminated = true;
        localb.drain();
      }
      AppMethodBeat.o(90281);
    }
    
    public final void gz(T paramT)
    {
      AppMethodBeat.i(90283);
      if (!gyY())
      {
        AppMethodBeat.o(90283);
        return;
      }
      this.sJP.offer(c.gB(paramT));
      this.NYr.drain();
      AppMethodBeat.o(90283);
    }
    
    public final void onError(Throwable paramThrowable)
    {
      AppMethodBeat.i(90282);
      if (!this.NYq.get()) {
        this.NYr.P(paramThrowable);
      }
      AppMethodBeat.o(90282);
    }
    
    public final void onStart()
    {
      AppMethodBeat.i(90280);
      FO(9223372036854775807L);
      AppMethodBeat.o(90280);
    }
    
    public final Object peek()
    {
      AppMethodBeat.i(90286);
      Object localObject = this.sJP.peek();
      AppMethodBeat.o(90286);
      return localObject;
    }
    
    public final Object poll()
    {
      AppMethodBeat.i(90287);
      Object localObject = this.sJP.poll();
      if ((this.NYp != null) && (localObject != null)) {
        this.NYp.incrementAndGet();
      }
      AppMethodBeat.o(90287);
      return localObject;
    }
  }
  
  public static final class b
  {
    public static final k<?> NYs;
    
    static
    {
      AppMethodBeat.i(90278);
      NYs = new k();
      AppMethodBeat.o(90278);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     rx.internal.a.k
 * JD-Core Version:    0.7.0.1
 */