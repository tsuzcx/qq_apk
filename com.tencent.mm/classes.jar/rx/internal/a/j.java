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
  private final g OuV;
  private final boolean Ovi;
  private final int bufferSize;
  
  public j(g paramg, int paramInt)
  {
    AppMethodBeat.i(90276);
    this.OuV = paramg;
    this.Ovi = false;
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
    final boolean Ovi;
    final rx.i<? super T> Ovj;
    final g.a Ovk;
    final c<T> Ovl;
    final AtomicLong Ovm;
    final AtomicLong Ovn;
    Throwable Ovo;
    long Ovp;
    volatile boolean bWS;
    final Queue<Object> dga;
    final int limit;
    
    public a(g paramg, rx.i<? super T> parami, boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(90269);
      this.Ovm = new AtomicLong();
      this.Ovn = new AtomicLong();
      this.Ovj = parami;
      this.Ovk = paramg.createWorker();
      this.Ovi = paramBoolean;
      this.Ovl = c.gDy();
      if (paramInt > 0)
      {
        this.limit = (paramInt - (paramInt >> 2));
        if (!UnsafeAccess.isUnsafeAvailable()) {
          break label112;
        }
      }
      label112:
      for (this.dga = new SpscArrayQueue(paramInt);; this.dga = new rx.internal.util.a.c(paramInt))
      {
        Gq(paramInt);
        AppMethodBeat.o(90269);
        return;
        paramInt = rx.internal.util.f.SIZE;
        break;
      }
    }
    
    private boolean a(boolean paramBoolean1, boolean paramBoolean2, rx.i<? super T> parami, Queue<Object> paramQueue)
    {
      AppMethodBeat.i(90275);
      if (parami.Ous.OxN)
      {
        paramQueue.clear();
        AppMethodBeat.o(90275);
        return true;
      }
      if (paramBoolean1)
      {
        if (!this.Ovi) {
          break label97;
        }
        if (paramBoolean2)
        {
          paramQueue = this.Ovo;
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
            this.Ovk.gDs();
            AppMethodBeat.o(90275);
          }
          parami.gDo();
        }
        Throwable localThrowable = this.Ovo;
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
            this.Ovk.gDs();
            AppMethodBeat.o(90275);
          }
        }
      } while (!paramBoolean2);
      try
      {
        parami.gDo();
        return true;
      }
      finally
      {
        this.Ovk.gDs();
        AppMethodBeat.o(90275);
      }
    }
    
    public final void call()
    {
      AppMethodBeat.i(90274);
      long l3 = 1L;
      long l2 = this.Ovp;
      Object localObject1 = this.dga;
      rx.i locali = this.Ovj;
      long l1 = this.Ovm.get();
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
          locali.gC(c.getValue(localObject2));
          l4 = l2 + 1L;
          if (l4 != this.limit) {
            break label280;
          }
          localObject2 = this.Ovm;
          label126:
          l2 = ((AtomicLong)localObject2).get();
          if (l2 == 9223372036854775807L)
          {
            l1 = 9223372036854775807L;
            label144:
            Gq(l4);
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
        this.Ovp = l2;
        l1 = this.Ovn.addAndGet(-l3);
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
    
    public final void gC(T paramT)
    {
      AppMethodBeat.i(90270);
      if ((this.Ous.OxN) || (this.bWS))
      {
        AppMethodBeat.o(90270);
        return;
      }
      if (!this.dga.offer(c.gE(paramT)))
      {
        onError(new rx.a.c());
        AppMethodBeat.o(90270);
        return;
      }
      schedule();
      AppMethodBeat.o(90270);
    }
    
    public final void gDo()
    {
      AppMethodBeat.i(90271);
      if ((this.Ous.OxN) || (this.bWS))
      {
        AppMethodBeat.o(90271);
        return;
      }
      this.bWS = true;
      schedule();
      AppMethodBeat.o(90271);
    }
    
    public final void onError(Throwable paramThrowable)
    {
      AppMethodBeat.i(90272);
      if ((this.Ous.OxN) || (this.bWS))
      {
        rx.d.c.onError(paramThrowable);
        AppMethodBeat.o(90272);
        return;
      }
      this.Ovo = paramThrowable;
      this.bWS = true;
      schedule();
      AppMethodBeat.o(90272);
    }
    
    protected final void schedule()
    {
      AppMethodBeat.i(90273);
      if (this.Ovn.getAndIncrement() == 0L) {
        this.Ovk.a(this);
      }
      AppMethodBeat.o(90273);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     rx.internal.a.j
 * JD-Core Version:    0.7.0.1
 */