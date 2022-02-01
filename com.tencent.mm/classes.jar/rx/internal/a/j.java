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
  private final g UkJ;
  private final boolean UkW;
  private final int bufferSize;
  
  public j(g paramg, int paramInt)
  {
    AppMethodBeat.i(90276);
    this.UkJ = paramg;
    this.UkW = false;
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
    final boolean UkW;
    final rx.i<? super T> UkX;
    final g.a UkY;
    final c<T> UkZ;
    final AtomicLong Ula;
    final AtomicLong Ulb;
    Throwable Ulc;
    long Uld;
    volatile boolean chA;
    final Queue<Object> dxk;
    final int limit;
    
    public a(g paramg, rx.i<? super T> parami, boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(90269);
      this.Ula = new AtomicLong();
      this.Ulb = new AtomicLong();
      this.UkX = parami;
      this.UkY = paramg.createWorker();
      this.UkW = paramBoolean;
      this.UkZ = c.hQG();
      if (paramInt > 0)
      {
        this.limit = (paramInt - (paramInt >> 2));
        if (!UnsafeAccess.isUnsafeAvailable()) {
          break label112;
        }
      }
      label112:
      for (this.dxk = new SpscArrayQueue(paramInt);; this.dxk = new rx.internal.util.a.c(paramInt))
      {
        Pw(paramInt);
        AppMethodBeat.o(90269);
        return;
        paramInt = rx.internal.util.f.SIZE;
        break;
      }
    }
    
    private boolean a(boolean paramBoolean1, boolean paramBoolean2, rx.i<? super T> parami, Queue<Object> paramQueue)
    {
      AppMethodBeat.i(90275);
      if (parami.Ukg.UnB)
      {
        paramQueue.clear();
        AppMethodBeat.o(90275);
        return true;
      }
      if (paramBoolean1)
      {
        if (!this.UkW) {
          break label97;
        }
        if (paramBoolean2)
        {
          paramQueue = this.Ulc;
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
            this.UkY.hQA();
            AppMethodBeat.o(90275);
          }
          parami.hQw();
        }
        Throwable localThrowable = this.Ulc;
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
            this.UkY.hQA();
            AppMethodBeat.o(90275);
          }
        }
      } while (!paramBoolean2);
      try
      {
        parami.hQw();
        return true;
      }
      finally
      {
        this.UkY.hQA();
        AppMethodBeat.o(90275);
      }
    }
    
    public final void call()
    {
      AppMethodBeat.i(90274);
      long l3 = 1L;
      long l2 = this.Uld;
      Object localObject1 = this.dxk;
      rx.i locali = this.UkX;
      long l1 = this.Ula.get();
      label33:
      Object localObject2;
      long l4;
      if (l1 != l2)
      {
        boolean bool2 = this.chA;
        localObject2 = ((Queue)localObject1).poll();
        if (localObject2 == null) {}
        for (boolean bool1 = true; a(bool2, bool1, locali, (Queue)localObject1); bool1 = false)
        {
          AppMethodBeat.o(90274);
          return;
        }
        if (!bool1)
        {
          locali.gL(c.getValue(localObject2));
          l4 = l2 + 1L;
          if (l4 != this.limit) {
            break label280;
          }
          localObject2 = this.Ula;
          label126:
          l2 = ((AtomicLong)localObject2).get();
          if (l2 == 9223372036854775807L)
          {
            l1 = 9223372036854775807L;
            label144:
            Pw(l4);
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
        if ((l1 == l2) && (a(this.chA, ((Queue)localObject1).isEmpty(), locali, (Queue)localObject1)))
        {
          AppMethodBeat.o(90274);
          return;
        }
        this.Uld = l2;
        l1 = this.Ulb.addAndGet(-l3);
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
    
    public final void gL(T paramT)
    {
      AppMethodBeat.i(90270);
      if ((this.Ukg.UnB) || (this.chA))
      {
        AppMethodBeat.o(90270);
        return;
      }
      if (!this.dxk.offer(c.gN(paramT)))
      {
        onError(new rx.a.c());
        AppMethodBeat.o(90270);
        return;
      }
      schedule();
      AppMethodBeat.o(90270);
    }
    
    public final void hQw()
    {
      AppMethodBeat.i(90271);
      if ((this.Ukg.UnB) || (this.chA))
      {
        AppMethodBeat.o(90271);
        return;
      }
      this.chA = true;
      schedule();
      AppMethodBeat.o(90271);
    }
    
    public final void onError(Throwable paramThrowable)
    {
      AppMethodBeat.i(90272);
      if ((this.Ukg.UnB) || (this.chA))
      {
        rx.d.c.onError(paramThrowable);
        AppMethodBeat.o(90272);
        return;
      }
      this.Ulc = paramThrowable;
      this.chA = true;
      schedule();
      AppMethodBeat.o(90272);
    }
    
    protected final void schedule()
    {
      AppMethodBeat.i(90273);
      if (this.Ulb.getAndIncrement() == 0L) {
        this.UkY.a(this);
      }
      AppMethodBeat.o(90273);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     rx.internal.a.j
 * JD-Core Version:    0.7.0.1
 */