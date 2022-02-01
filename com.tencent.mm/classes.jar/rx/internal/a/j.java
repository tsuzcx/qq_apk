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
  private final g abOf;
  private final boolean abOs;
  private final int bufferSize;
  
  public j(g paramg, int paramInt)
  {
    AppMethodBeat.i(90276);
    this.abOf = paramg;
    this.abOs = false;
    if (paramInt > 0) {}
    for (;;)
    {
      this.bufferSize = paramInt;
      AppMethodBeat.o(90276);
      return;
      paramInt = rx.internal.util.f.abQJ;
    }
  }
  
  static final class a<T>
    extends i<T>
    implements a
  {
    final boolean abOs;
    final i<? super T> abOt;
    final g.a abOu;
    final c<T> abOv;
    final AtomicLong abOw;
    final AtomicLong abOx;
    Throwable abOy;
    long abOz;
    final Queue<Object> fpW;
    volatile boolean jHM;
    final int limit;
    
    public a(g paramg, i<? super T> parami, boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(90269);
      this.abOw = new AtomicLong();
      this.abOx = new AtomicLong();
      this.abOt = parami;
      this.abOu = paramg.createWorker();
      this.abOs = paramBoolean;
      this.abOv = c.iVP();
      if (paramInt > 0)
      {
        this.limit = (paramInt - (paramInt >> 2));
        if (!UnsafeAccess.isUnsafeAvailable()) {
          break label112;
        }
      }
      label112:
      for (this.fpW = new SpscArrayQueue(paramInt);; this.fpW = new rx.internal.util.a.c(paramInt))
      {
        XM(paramInt);
        AppMethodBeat.o(90269);
        return;
        paramInt = rx.internal.util.f.abQJ;
        break;
      }
    }
    
    private boolean a(boolean paramBoolean1, boolean paramBoolean2, i<? super T> parami, Queue<Object> paramQueue)
    {
      AppMethodBeat.i(90275);
      if (parami.iVK())
      {
        paramQueue.clear();
        AppMethodBeat.o(90275);
        return true;
      }
      if (paramBoolean1)
      {
        if (!this.abOs) {
          break label94;
        }
        if (paramBoolean2)
        {
          paramQueue = this.abOy;
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
            parami.c(paramQueue);
            return false;
          }
          finally
          {
            this.abOu.iVJ();
            AppMethodBeat.o(90275);
          }
          parami.fUB();
        }
        Throwable localThrowable = this.abOy;
        if (localThrowable != null)
        {
          paramQueue.clear();
          try
          {
            parami.c(localThrowable);
            return true;
          }
          finally
          {
            this.abOu.iVJ();
            AppMethodBeat.o(90275);
          }
        }
      } while (!paramBoolean2);
      try
      {
        parami.fUB();
        return true;
      }
      finally
      {
        this.abOu.iVJ();
        AppMethodBeat.o(90275);
      }
    }
    
    public final void c(Throwable paramThrowable)
    {
      AppMethodBeat.i(90272);
      if ((iVK()) || (this.jHM))
      {
        rx.d.c.c(paramThrowable);
        AppMethodBeat.o(90272);
        return;
      }
      this.abOy = paramThrowable;
      this.jHM = true;
      schedule();
      AppMethodBeat.o(90272);
    }
    
    public final void call()
    {
      AppMethodBeat.i(90274);
      long l3 = 1L;
      long l2 = this.abOz;
      Object localObject1 = this.fpW;
      i locali = this.abOt;
      long l1 = this.abOw.get();
      label33:
      Object localObject2;
      long l4;
      if (l1 != l2)
      {
        boolean bool2 = this.jHM;
        localObject2 = ((Queue)localObject1).poll();
        if (localObject2 == null) {}
        for (boolean bool1 = true; a(bool2, bool1, locali, (Queue)localObject1); bool1 = false)
        {
          AppMethodBeat.o(90274);
          return;
        }
        if (!bool1)
        {
          locali.he(c.getValue(localObject2));
          l4 = l2 + 1L;
          if (l4 != this.limit) {
            break label280;
          }
          localObject2 = this.abOw;
          label126:
          l2 = ((AtomicLong)localObject2).get();
          if (l2 == 9223372036854775807L)
          {
            l1 = 9223372036854775807L;
            label144:
            XM(l4);
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
        if ((l1 == l2) && (a(this.jHM, ((Queue)localObject1).isEmpty(), locali, (Queue)localObject1)))
        {
          AppMethodBeat.o(90274);
          return;
        }
        this.abOz = l2;
        l1 = this.abOx.addAndGet(-l3);
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
    
    public final void fUB()
    {
      AppMethodBeat.i(90271);
      if ((iVK()) || (this.jHM))
      {
        AppMethodBeat.o(90271);
        return;
      }
      this.jHM = true;
      schedule();
      AppMethodBeat.o(90271);
    }
    
    public final void he(T paramT)
    {
      AppMethodBeat.i(90270);
      if ((iVK()) || (this.jHM))
      {
        AppMethodBeat.o(90270);
        return;
      }
      if (!this.fpW.offer(c.hh(paramT)))
      {
        c(new rx.a.c());
        AppMethodBeat.o(90270);
        return;
      }
      schedule();
      AppMethodBeat.o(90270);
    }
    
    protected final void schedule()
    {
      AppMethodBeat.i(90273);
      if (this.abOx.getAndIncrement() == 0L) {
        this.abOu.a(this);
      }
      AppMethodBeat.o(90273);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     rx.internal.a.j
 * JD-Core Version:    0.7.0.1
 */