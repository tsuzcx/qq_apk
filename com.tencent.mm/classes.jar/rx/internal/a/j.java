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
  private final g NXQ;
  private final boolean NYd;
  private final int bufferSize;
  
  public j(g paramg, int paramInt)
  {
    AppMethodBeat.i(90276);
    this.NXQ = paramg;
    this.NYd = false;
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
    final boolean NYd;
    final rx.i<? super T> NYe;
    final g.a NYf;
    final c<T> NYg;
    final AtomicLong NYh;
    final AtomicLong NYi;
    Throwable NYj;
    long NYk;
    volatile boolean bWS;
    final Queue<Object> deY;
    final int limit;
    
    public a(g paramg, rx.i<? super T> parami, boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(90269);
      this.NYh = new AtomicLong();
      this.NYi = new AtomicLong();
      this.NYe = parami;
      this.NYf = paramg.createWorker();
      this.NYd = paramBoolean;
      this.NYg = c.gyW();
      if (paramInt > 0)
      {
        this.limit = (paramInt - (paramInt >> 2));
        if (!UnsafeAccess.isUnsafeAvailable()) {
          break label112;
        }
      }
      label112:
      for (this.deY = new SpscArrayQueue(paramInt);; this.deY = new rx.internal.util.a.c(paramInt))
      {
        FO(paramInt);
        AppMethodBeat.o(90269);
        return;
        paramInt = rx.internal.util.f.SIZE;
        break;
      }
    }
    
    private boolean a(boolean paramBoolean1, boolean paramBoolean2, rx.i<? super T> parami, Queue<Object> paramQueue)
    {
      AppMethodBeat.i(90275);
      if (parami.NXn.OaI)
      {
        paramQueue.clear();
        AppMethodBeat.o(90275);
        return true;
      }
      if (paramBoolean1)
      {
        if (!this.NYd) {
          break label97;
        }
        if (paramBoolean2)
        {
          paramQueue = this.NYj;
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
            this.NYf.gyQ();
            AppMethodBeat.o(90275);
          }
          parami.gyM();
        }
        Throwable localThrowable = this.NYj;
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
            this.NYf.gyQ();
            AppMethodBeat.o(90275);
          }
        }
      } while (!paramBoolean2);
      try
      {
        parami.gyM();
        return true;
      }
      finally
      {
        this.NYf.gyQ();
        AppMethodBeat.o(90275);
      }
    }
    
    public final void call()
    {
      AppMethodBeat.i(90274);
      long l3 = 1L;
      long l2 = this.NYk;
      Object localObject1 = this.deY;
      rx.i locali = this.NYe;
      long l1 = this.NYh.get();
      label33:
      Object localObject2;
      long l4;
      if (l1 != l2)
      {
        boolean bool2 = this.bWS;
        localObject2 = ((Queue)localObject1).poll();
        if (localObject2 == null) {}
        for (boolean bool1 = true; a(bool2, bool1, locali, (Queue)localObject1); bool1 = false)
        {
          AppMethodBeat.o(90274);
          return;
        }
        if (!bool1)
        {
          locali.gz(c.getValue(localObject2));
          l4 = l2 + 1L;
          if (l4 != this.limit) {
            break label280;
          }
          localObject2 = this.NYh;
          label126:
          l2 = ((AtomicLong)localObject2).get();
          if (l2 == 9223372036854775807L)
          {
            l1 = 9223372036854775807L;
            label144:
            FO(l4);
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
        if ((l1 == l2) && (a(this.bWS, ((Queue)localObject1).isEmpty(), locali, (Queue)localObject1)))
        {
          AppMethodBeat.o(90274);
          return;
        }
        this.NYk = l2;
        l1 = this.NYi.addAndGet(-l3);
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
    
    public final void gyM()
    {
      AppMethodBeat.i(90271);
      if ((this.NXn.OaI) || (this.bWS))
      {
        AppMethodBeat.o(90271);
        return;
      }
      this.bWS = true;
      schedule();
      AppMethodBeat.o(90271);
    }
    
    public final void gz(T paramT)
    {
      AppMethodBeat.i(90270);
      if ((this.NXn.OaI) || (this.bWS))
      {
        AppMethodBeat.o(90270);
        return;
      }
      if (!this.deY.offer(c.gB(paramT)))
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
      if ((this.NXn.OaI) || (this.bWS))
      {
        rx.d.c.onError(paramThrowable);
        AppMethodBeat.o(90272);
        return;
      }
      this.NYj = paramThrowable;
      this.bWS = true;
      schedule();
      AppMethodBeat.o(90272);
    }
    
    protected final void schedule()
    {
      AppMethodBeat.i(90273);
      if (this.NYi.getAndIncrement() == 0L) {
        this.NYf.a(this);
      }
      AppMethodBeat.o(90273);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     rx.internal.a.j
 * JD-Core Version:    0.7.0.1
 */