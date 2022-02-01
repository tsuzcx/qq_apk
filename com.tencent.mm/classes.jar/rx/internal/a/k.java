package rx.internal.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.a.d;
import rx.d.b;
import rx.i;
import rx.internal.util.b.a;

public final class k<T>
  implements d.b<T, T>
{
  private final Long abOB = null;
  private final rx.b.a abOC = null;
  private final a.d abOD = rx.a.abNa;
  
  private i<? super T> b(i<? super T> parami)
  {
    AppMethodBeat.i(90289);
    a locala = new a(parami, this.abOB, this.abOC, this.abOD);
    parami.b(locala);
    parami.a(locala.abOG);
    AppMethodBeat.o(90289);
    return locala;
  }
  
  public static <T> k<T> iVR()
  {
    return k.b.abOH;
  }
  
  static final class a<T>
    extends i<T>
    implements b.a
  {
    private final ConcurrentLinkedQueue<Object> ABz;
    private final rx.b.a abOC;
    private final a.d abOD;
    private final AtomicLong abOE;
    private final AtomicBoolean abOF;
    final rx.internal.util.b abOG;
    private final i<? super T> abOt;
    private final c<T> abOv;
    
    public a(i<? super T> parami, Long paramLong, rx.b.a parama, a.d paramd)
    {
      AppMethodBeat.i(90279);
      this.ABz = new ConcurrentLinkedQueue();
      this.abOF = new AtomicBoolean(false);
      this.abOv = c.iVP();
      this.abOt = parami;
      if (paramLong != null) {}
      for (parami = new AtomicLong(paramLong.longValue());; parami = null)
      {
        this.abOE = parami;
        this.abOC = parama;
        this.abOG = new rx.internal.util.b(this);
        this.abOD = paramd;
        AppMethodBeat.o(90279);
        return;
      }
    }
    
    private boolean iVS()
    {
      AppMethodBeat.i(90288);
      if (this.abOE == null)
      {
        AppMethodBeat.o(90288);
        return true;
      }
      long l;
      label145:
      do
      {
        l = this.abOE.get();
        if (l <= 0L) {
          for (;;)
          {
            try
            {
              if (!this.abOD.iVE()) {
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
              if (!this.abOF.compareAndSet(false, true)) {
                continue;
              }
              iVJ();
              this.abOt.c(localc);
              int i = 0;
              continue;
            }
            if (this.abOC != null) {}
            try
            {
              this.abOC.call();
              if (i != 0) {
                break label145;
              }
              AppMethodBeat.o(90288);
              return false;
            }
            catch (Throwable localThrowable)
            {
              rx.a.b.R(localThrowable);
              this.abOG.W(localThrowable);
              AppMethodBeat.o(90288);
              return false;
            }
            i = 0;
          }
        }
      } while (!this.abOE.compareAndSet(l, l - 1L));
      AppMethodBeat.o(90288);
      return true;
    }
    
    public final void U(Throwable paramThrowable)
    {
      AppMethodBeat.i(90285);
      if (paramThrowable != null)
      {
        this.abOt.c(paramThrowable);
        AppMethodBeat.o(90285);
        return;
      }
      this.abOt.fUB();
      AppMethodBeat.o(90285);
    }
    
    public final boolean V(Object paramObject)
    {
      AppMethodBeat.i(90284);
      boolean bool = c.a(this.abOt, paramObject);
      AppMethodBeat.o(90284);
      return bool;
    }
    
    public final void c(Throwable paramThrowable)
    {
      AppMethodBeat.i(90282);
      if (!this.abOF.get()) {
        this.abOG.W(paramThrowable);
      }
      AppMethodBeat.o(90282);
    }
    
    public final void fUB()
    {
      AppMethodBeat.i(90281);
      if (!this.abOF.get())
      {
        rx.internal.util.b localb = this.abOG;
        localb.terminated = true;
        localb.iVZ();
      }
      AppMethodBeat.o(90281);
    }
    
    public final void he(T paramT)
    {
      AppMethodBeat.i(90283);
      if (!iVS())
      {
        AppMethodBeat.o(90283);
        return;
      }
      this.ABz.offer(c.hh(paramT));
      this.abOG.iVZ();
      AppMethodBeat.o(90283);
    }
    
    public final void onStart()
    {
      AppMethodBeat.i(90280);
      XM(9223372036854775807L);
      AppMethodBeat.o(90280);
    }
    
    public final Object peek()
    {
      AppMethodBeat.i(90286);
      Object localObject = this.ABz.peek();
      AppMethodBeat.o(90286);
      return localObject;
    }
    
    public final Object poll()
    {
      AppMethodBeat.i(90287);
      Object localObject = this.ABz.poll();
      if ((this.abOE != null) && (localObject != null)) {
        this.abOE.incrementAndGet();
      }
      AppMethodBeat.o(90287);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     rx.internal.a.k
 * JD-Core Version:    0.7.0.1
 */