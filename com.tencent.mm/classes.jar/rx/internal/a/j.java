package rx.internal.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import rx.b.a;
import rx.d.b;
import rx.g;
import rx.g.a;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;

public final class j<T>
  implements d.b<T, T>
{
  private final g Kpf;
  private final boolean Kps;
  private final int bufferSize;
  
  public j(g paramg, int paramInt)
  {
    AppMethodBeat.i(90276);
    this.Kpf = paramg;
    this.Kps = false;
    if (paramInt > 0) {}
    for (;;)
    {
      this.bufferSize = paramInt;
      AppMethodBeat.o(90276);
      return;
      paramInt = rx.internal.util.f.SIZE;
    }
  }
  
  static final class a<T>
    extends rx.i<T>
    implements a
  {
    final boolean Kps;
    final rx.i<? super T> Kpt;
    final g.a Kpu;
    final c<T> Kpv;
    final AtomicLong Kpw;
    final AtomicLong Kpx;
    Throwable Kpy;
    long Kpz;
    volatile boolean bOX;
    final Queue<Object> cWm;
    final int limit;
    
    public a(g paramg, rx.i<? super T> parami, boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(90269);
      this.Kpw = new AtomicLong();
      this.Kpx = new AtomicLong();
      this.Kpt = parami;
      this.Kpu = paramg.createWorker();
      this.Kps = paramBoolean;
      this.Kpv = c.fNC();
      if (paramInt > 0)
      {
        this.limit = (paramInt - (paramInt >> 2));
        if (!UnsafeAccess.isUnsafeAvailable()) {
          break label112;
        }
      }
      label112:
      for (this.cWm = new SpscArrayQueue(paramInt);; this.cWm = new rx.internal.util.a.c(paramInt))
      {
        xU(paramInt);
        AppMethodBeat.o(90269);
        return;
        paramInt = rx.internal.util.f.SIZE;
        break;
      }
    }
    
    private boolean a(boolean paramBoolean1, boolean paramBoolean2, rx.i<? super T> parami, Queue<Object> paramQueue)
    {
      AppMethodBeat.i(90275);
      if (parami.KoC.KrX)
      {
        paramQueue.clear();
        AppMethodBeat.o(90275);
        return true;
      }
      if (paramBoolean1)
      {
        if (!this.Kps) {
          break label97;
        }
        if (paramBoolean2)
        {
          paramQueue = this.Kpy;
          if (paramQueue == null) {
            break label75;
          }
        }
      }
      label75:
      label97:
      do
      {
        for (;;)
        {
          try
          {
            parami.onError(paramQueue);
            return false;
          }
          finally
          {
            this.Kpu.fNw();
            AppMethodBeat.o(90275);
          }
          parami.fNs();
        }
        Throwable localThrowable = this.Kpy;
        if (localThrowable != null)
        {
          paramQueue.clear();
          try
          {
            parami.onError(localThrowable);
            return true;
          }
          finally
          {
            this.Kpu.fNw();
            AppMethodBeat.o(90275);
          }
        }
      } while (!paramBoolean2);
      try
      {
        parami.fNs();
        return true;
      }
      finally
      {
        this.Kpu.fNw();
        AppMethodBeat.o(90275);
      }
    }
    
    public final void call()
    {
      AppMethodBeat.i(90274);
      long l3 = 1L;
      long l2 = this.Kpz;
      Object localObject1 = this.cWm;
      rx.i locali = this.Kpt;
      long l1 = this.Kpw.get();
      label33:
      Object localObject2;
      long l4;
      if (l1 != l2)
      {
        boolean bool2 = this.bOX;
        localObject2 = ((Queue)localObject1).poll();
        if (localObject2 == null) {}
        for (boolean bool1 = true; a(bool2, bool1, locali, (Queue)localObject1); bool1 = false)
        {
          AppMethodBeat.o(90274);
          return;
        }
        if (!bool1)
        {
          locali.fV(c.getValue(localObject2));
          l4 = l2 + 1L;
          if (l4 != this.limit) {
            break label280;
          }
          localObject2 = this.Kpw;
          label126:
          l2 = ((AtomicLong)localObject2).get();
          if (l2 == 9223372036854775807L)
          {
            l1 = 9223372036854775807L;
            label144:
            xU(l4);
            l2 = l1;
          }
        }
      }
      for (l1 = 0L;; l1 = l4)
      {
        l4 = l2;
        l2 = l1;
        l1 = l4;
        break label33;
        l1 = l2 - l4;
        if (l1 < 0L)
        {
          localObject1 = new IllegalStateException("More produced than requested: ".concat(String.valueOf(l1)));
          AppMethodBeat.o(90274);
          throw ((Throwable)localObject1);
        }
        if (!((AtomicLong)localObject2).compareAndSet(l2, l1)) {
          break label126;
        }
        break label144;
        if ((l1 == l2) && (a(this.bOX, ((Queue)localObject1).isEmpty(), locali, (Queue)localObject1)))
        {
          AppMethodBeat.o(90274);
          return;
        }
        this.Kpz = l2;
        l1 = this.Kpx.addAndGet(-l3);
        l3 = l1;
        if (l1 != 0L) {
          break;
        }
        AppMethodBeat.o(90274);
        return;
        label280:
        l2 = l1;
      }
    }
    
    public final void fNs()
    {
      AppMethodBeat.i(90271);
      if ((this.KoC.KrX) || (this.bOX))
      {
        AppMethodBeat.o(90271);
        return;
      }
      this.bOX = true;
      schedule();
      AppMethodBeat.o(90271);
    }
    
    public final void fV(T paramT)
    {
      AppMethodBeat.i(90270);
      if ((this.KoC.KrX) || (this.bOX))
      {
        AppMethodBeat.o(90270);
        return;
      }
      if (!this.cWm.offer(c.fX(paramT)))
      {
        onError(new rx.a.c());
        AppMethodBeat.o(90270);
        return;
      }
      schedule();
      AppMethodBeat.o(90270);
    }
    
    public final void onError(Throwable paramThrowable)
    {
      AppMethodBeat.i(90272);
      if ((this.KoC.KrX) || (this.bOX))
      {
        rx.d.c.onError(paramThrowable);
        AppMethodBeat.o(90272);
        return;
      }
      this.Kpy = paramThrowable;
      this.bOX = true;
      schedule();
      AppMethodBeat.o(90272);
    }
    
    protected final void schedule()
    {
      AppMethodBeat.i(90273);
      if (this.Kpx.getAndIncrement() == 0L) {
        this.Kpu.a(this);
      }
      AppMethodBeat.o(90273);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     rx.internal.a.j
 * JD-Core Version:    0.7.0.1
 */