package rx.internal.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import rx.b.a;
import rx.d.b;
import rx.g;
import rx.g.a;
import rx.i;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;

public final class j<T>
  implements d.b<T, T>
{
  private final g akaY;
  private final boolean akbl;
  private final int bufferSize;
  
  public j(g paramg, int paramInt)
  {
    AppMethodBeat.i(90276);
    this.akaY = paramg;
    this.akbl = false;
    if (paramInt > 0) {}
    for (;;)
    {
      this.bufferSize = paramInt;
      AppMethodBeat.o(90276);
      return;
      paramInt = rx.internal.util.f.akdB;
    }
  }
  
  static final class a<T>
    extends i<T>
    implements a
  {
    final boolean akbl;
    final i<? super T> akbm;
    final g.a akbn;
    final c<T> akbo;
    final AtomicLong akbp;
    final AtomicLong akbq;
    long akbr;
    Throwable bSn;
    final Queue<Object> huf;
    final int limit;
    volatile boolean mhq;
    
    public a(g paramg, i<? super T> parami, boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(90269);
      this.akbp = new AtomicLong();
      this.akbq = new AtomicLong();
      this.akbm = parami;
      this.akbn = paramg.createWorker();
      this.akbl = paramBoolean;
      this.akbo = c.kKn();
      if (paramInt > 0)
      {
        this.limit = (paramInt - (paramInt >> 2));
        if (!UnsafeAccess.isUnsafeAvailable()) {
          break label112;
        }
      }
      label112:
      for (this.huf = new SpscArrayQueue(paramInt);; this.huf = new rx.internal.util.a.c(paramInt))
      {
        Cp(paramInt);
        AppMethodBeat.o(90269);
        return;
        paramInt = rx.internal.util.f.akdB;
        break;
      }
    }
    
    private boolean a(boolean paramBoolean1, boolean paramBoolean2, i<? super T> parami, Queue<Object> paramQueue)
    {
      AppMethodBeat.i(90275);
      if (parami.kKi())
      {
        paramQueue.clear();
        AppMethodBeat.o(90275);
        return true;
      }
      if (paramBoolean1)
      {
        if (!this.akbl) {
          break label94;
        }
        if (paramBoolean2)
        {
          paramQueue = this.bSn;
          if (paramQueue == null) {
            break label72;
          }
        }
      }
      label72:
      label94:
      do
      {
        for (;;)
        {
          try
          {
            parami.l(paramQueue);
            return false;
          }
          finally
          {
            this.akbn.kKh();
            AppMethodBeat.o(90275);
          }
          parami.fvq();
        }
        Throwable localThrowable = this.bSn;
        if (localThrowable != null)
        {
          paramQueue.clear();
          try
          {
            parami.l(localThrowable);
            return true;
          }
          finally
          {
            this.akbn.kKh();
            AppMethodBeat.o(90275);
          }
        }
      } while (!paramBoolean2);
      try
      {
        parami.fvq();
        return true;
      }
      finally
      {
        this.akbn.kKh();
        AppMethodBeat.o(90275);
      }
    }
    
    public final void call()
    {
      AppMethodBeat.i(90274);
      long l3 = 1L;
      long l2 = this.akbr;
      Object localObject1 = this.huf;
      i locali = this.akbm;
      long l1 = this.akbp.get();
      label33:
      Object localObject2;
      long l4;
      if (l1 != l2)
      {
        boolean bool2 = this.mhq;
        localObject2 = ((Queue)localObject1).poll();
        if (localObject2 == null) {}
        for (boolean bool1 = true; a(bool2, bool1, locali, (Queue)localObject1); bool1 = false)
        {
          AppMethodBeat.o(90274);
          return;
        }
        if (!bool1)
        {
          locali.jV(c.getValue(localObject2));
          l4 = l2 + 1L;
          if (l4 != this.limit) {
            break label280;
          }
          localObject2 = this.akbp;
          label126:
          l2 = ((AtomicLong)localObject2).get();
          if (l2 == 9223372036854775807L)
          {
            l1 = 9223372036854775807L;
            label144:
            Cp(l4);
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
        if ((l1 == l2) && (a(this.mhq, ((Queue)localObject1).isEmpty(), locali, (Queue)localObject1)))
        {
          AppMethodBeat.o(90274);
          return;
        }
        this.akbr = l2;
        l1 = this.akbq.addAndGet(-l3);
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
    
    public final void fvq()
    {
      AppMethodBeat.i(90271);
      if ((kKi()) || (this.mhq))
      {
        AppMethodBeat.o(90271);
        return;
      }
      this.mhq = true;
      schedule();
      AppMethodBeat.o(90271);
    }
    
    public final void jV(T paramT)
    {
      AppMethodBeat.i(90270);
      if ((kKi()) || (this.mhq))
      {
        AppMethodBeat.o(90270);
        return;
      }
      if (!this.huf.offer(c.jY(paramT)))
      {
        l(new rx.a.c());
        AppMethodBeat.o(90270);
        return;
      }
      schedule();
      AppMethodBeat.o(90270);
    }
    
    public final void l(Throwable paramThrowable)
    {
      AppMethodBeat.i(90272);
      if ((kKi()) || (this.mhq))
      {
        rx.d.c.l(paramThrowable);
        AppMethodBeat.o(90272);
        return;
      }
      this.bSn = paramThrowable;
      this.mhq = true;
      schedule();
      AppMethodBeat.o(90272);
    }
    
    protected final void schedule()
    {
      AppMethodBeat.i(90273);
      if (this.akbq.getAndIncrement() == 0L) {
        this.akbn.a(this);
      }
      AppMethodBeat.o(90273);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     rx.internal.a.j
 * JD-Core Version:    0.7.0.1
 */