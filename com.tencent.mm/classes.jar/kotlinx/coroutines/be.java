package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.f;
import d.g.b.p;
import d.k.j;
import d.v;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.internal.y;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/coroutines/EventLoopImplBase;", "<init>", "()V", "", "closeQueue", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dequeue", "()Ljava/lang/Runnable;", "Lkotlin/coroutines/CoroutineContext;", "context", "block", "dispatch", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "task", "enqueue", "(Ljava/lang/Runnable;)V", "", "enqueueImpl", "(Ljava/lang/Runnable;)Z", "", "processNextEvent", "()J", "rescheduleAllDelayed", "resetAll", "now", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "delayedTask", "schedule", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTask;)V", "", "scheduleImpl", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTask;)I", "timeMillis", "Lkotlinx/coroutines/DisposableHandle;", "scheduleInvokeOnTimeout", "(JLjava/lang/Runnable;)Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/CancellableContinuation;", "continuation", "scheduleResumeAfterDelay", "(JLkotlinx/coroutines/CancellableContinuation;)V", "shouldUnpark", "(Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;)Z", "shutdown", "value", "isCompleted", "()Z", "setCompleted", "(Z)V", "isEmpty", "getNextTime", "nextTime", "DelayedResumeTask", "DelayedRunnableTask", "DelayedTask", "DelayedTaskQueue", "kotlinx-coroutines-core", "Lkotlinx/coroutines/EventLoopImplPlatform;", "Lkotlinx/coroutines/Delay;"})
public abstract class be
  extends bf
  implements as
{
  private static final AtomicReferenceFieldUpdater OfD = AtomicReferenceFieldUpdater.newUpdater(be.class, Object.class, "_queue");
  private static final AtomicReferenceFieldUpdater OfE = AtomicReferenceFieldUpdater.newUpdater(be.class, Object.class, "_delayed");
  volatile Object _delayed = null;
  private volatile int _isCompleted = 0;
  volatile Object _queue = null;
  
  private final boolean a(b paramb)
  {
    Object localObject = (c)this._delayed;
    if (localObject != null) {}
    for (localObject = (b)((c)localObject).gAL(); localObject == paramb; localObject = null) {
      return true;
    }
    return false;
  }
  
  private final boolean aU(Runnable paramRunnable)
  {
    Object localObject;
    kotlinx.coroutines.internal.l locall;
    do
    {
      for (;;)
      {
        localObject = this._queue;
        if (this._isCompleted != 0) {
          return false;
        }
        if (localObject == null)
        {
          if (OfD.compareAndSet(this, null, paramRunnable)) {
            return true;
          }
        }
        else
        {
          if (!(localObject instanceof kotlinx.coroutines.internal.l)) {
            break;
          }
          if (localObject == null) {
            throw new v("null cannot be cast to non-null type kotlinx.coroutines.Queue<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> /* = kotlinx.coroutines.internal.LockFreeTaskQueueCore<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> */");
          }
          switch (((kotlinx.coroutines.internal.l)localObject).gc(paramRunnable))
          {
          default: 
            break;
          case 0: 
            return true;
          case 2: 
            return false;
          }
          OfD.compareAndSet(this, localObject, ((kotlinx.coroutines.internal.l)localObject).gAF());
        }
      }
      if (localObject == bg.gAd()) {
        return false;
      }
      locall = new kotlinx.coroutines.internal.l(8, true);
      if (localObject == null) {
        throw new v("null cannot be cast to non-null type kotlinx.coroutines.Runnable /* = java.lang.Runnable */");
      }
      locall.gc((Runnable)localObject);
      locall.gc(paramRunnable);
    } while (!OfD.compareAndSet(this, localObject, locall));
    return true;
  }
  
  private final int b(long paramLong, b paramb)
  {
    if (this._isCompleted != 0) {
      return 1;
    }
    c localc = (c)this._delayed;
    Object localObject = localc;
    if (localc == null)
    {
      localObject = (be)this;
      OfE.compareAndSet(localObject, null, new c(paramLong));
      localObject = ((be)localObject)._delayed;
      if (localObject == null) {
        p.gkB();
      }
      localObject = (c)localObject;
    }
    return paramb.a(paramLong, (c)localObject, this);
  }
  
  private final void gzZ()
  {
    Object localObject = ck.Ogo;
    long l;
    if (localObject != null) {
      l = ((cj)localObject).nanoTime();
    }
    for (;;)
    {
      localObject = (c)this._delayed;
      if (localObject != null)
      {
        localObject = (b)((c)localObject).gAM();
        if (localObject != null) {}
      }
      else
      {
        return;
        l = System.nanoTime();
        continue;
      }
      c(l, (b)localObject);
    }
  }
  
  public final void a(long paramLong, b paramb)
  {
    switch (b(paramLong, paramb))
    {
    default: 
      throw ((Throwable)new IllegalStateException("unexpected result".toString()));
    case 0: 
      if (a(paramb)) {
        gAb();
      }
    case 2: 
      return;
    }
    c(paramLong, paramb);
  }
  
  public final void a(long paramLong, k<? super d.z> paramk)
  {
    long l = bg.Gf(paramLong);
    Object localObject;
    if (l < 4611686018427387903L)
    {
      localObject = ck.Ogo;
      if (localObject == null) {
        break label68;
      }
    }
    label68:
    for (paramLong = ((cj)localObject).nanoTime();; paramLong = System.nanoTime())
    {
      localObject = new a(l + paramLong, paramk);
      n.a(paramk, (ba)localObject);
      a(paramLong, (b)localObject);
      return;
    }
  }
  
  public final void a(f paramf, Runnable paramRunnable)
  {
    aT(paramRunnable);
  }
  
  public final void aT(Runnable paramRunnable)
  {
    for (Object localObject = this;; localObject = ao.Ofl) {
      if (((be)localObject).aU(paramRunnable))
      {
        ((be)localObject).gAb();
        return;
      }
    }
  }
  
  public final long gzT()
  {
    Object localObject4 = null;
    if (gzV()) {
      return gzU();
    }
    Object localObject5 = (c)this._delayed;
    Object localObject1;
    long l;
    if ((localObject5 != null) && (!((c)localObject5).isEmpty()))
    {
      localObject1 = ck.Ogo;
      if (localObject1 == null) {
        break label123;
      }
      l = ((cj)localObject1).nanoTime();
    }
    for (;;)
    {
      synchronized ((y)localObject5)
      {
        localObject1 = ???.gAN();
        if (localObject1 == null)
        {
          localObject1 = null;
          if ((b)localObject1 != null) {
            continue;
          }
          localObject5 = this._queue;
          if (localObject5 == null)
          {
            localObject1 = localObject4;
            if (localObject1 != null) {
              ((Runnable)localObject1).run();
            }
            return gzU();
            label123:
            l = System.nanoTime();
          }
        }
        else
        {
          localObject1 = (b)localObject1;
          int i;
          if (l - ((b)localObject1).nanoTime >= 0L)
          {
            i = 1;
            if (i != 0)
            {
              bool = aU((Runnable)localObject1);
              if (!bool) {
                continue;
              }
              localObject1 = ???.amn(0);
            }
          }
          else
          {
            i = 0;
            continue;
          }
          boolean bool = false;
          continue;
          localObject1 = null;
        }
      }
      Object localObject3;
      if ((localObject5 instanceof kotlinx.coroutines.internal.l))
      {
        if (localObject5 == null) {
          throw new v("null cannot be cast to non-null type kotlinx.coroutines.Queue<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> /* = kotlinx.coroutines.internal.LockFreeTaskQueueCore<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> */");
        }
        localObject3 = ((kotlinx.coroutines.internal.l)localObject5).gAv();
        if (localObject3 != kotlinx.coroutines.internal.l.OgZ) {
          localObject3 = (Runnable)localObject3;
        } else {
          OfD.compareAndSet(this, localObject5, ((kotlinx.coroutines.internal.l)localObject5).gAF());
        }
      }
      else
      {
        localObject3 = localObject4;
        if (localObject5 != bg.gAd()) {
          if (OfD.compareAndSet(this, localObject5, null))
          {
            if (localObject5 == null) {
              throw new v("null cannot be cast to non-null type kotlinx.coroutines.Runnable /* = java.lang.Runnable */");
            }
            localObject3 = (Runnable)localObject5;
          }
        }
      }
    }
  }
  
  protected final long gzU()
  {
    if (super.gzU() == 0L) {
      return 0L;
    }
    Object localObject = this._queue;
    if (localObject != null) {
      if ((localObject instanceof kotlinx.coroutines.internal.l))
      {
        if (!((kotlinx.coroutines.internal.l)localObject).isEmpty()) {
          return 0L;
        }
      }
      else
      {
        if (localObject == bg.gAd()) {
          return 9223372036854775807L;
        }
        return 0L;
      }
    }
    localObject = (c)this._delayed;
    if (localObject != null)
    {
      localObject = (b)((c)localObject).gAL();
      if (localObject != null) {}
    }
    else
    {
      return 9223372036854775807L;
    }
    long l2 = ((b)localObject).nanoTime;
    localObject = ck.Ogo;
    if (localObject != null) {}
    for (long l1 = ((cj)localObject).nanoTime();; l1 = System.nanoTime()) {
      return j.aG(l2 - l1, 0L);
    }
  }
  
  protected final boolean isEmpty()
  {
    if (!gzX()) {
      return false;
    }
    Object localObject = (c)this._delayed;
    if ((localObject != null) && (!((c)localObject).isEmpty())) {
      return false;
    }
    localObject = this._queue;
    if (localObject == null) {
      return true;
    }
    if ((localObject instanceof kotlinx.coroutines.internal.l)) {
      return ((kotlinx.coroutines.internal.l)localObject).isEmpty();
    }
    return localObject == bg.gAd();
  }
  
  protected final void shutdown()
  {
    Object localObject1 = ci.Ogn;
    ci.gAt();
    this._isCompleted = 1;
    if ((am.gzF()) && (this._isCompleted == 0)) {
      throw ((Throwable)new AssertionError());
    }
    label94:
    do
    {
      ((kotlinx.coroutines.internal.l)localObject2).gc((Runnable)localObject1);
      if (!OfD.compareAndSet(this, localObject1, localObject2)) {
        do
        {
          localObject1 = this._queue;
          if (localObject1 != null) {
            break label94;
          }
          break;
        } while (!OfD.compareAndSet(this, null, bg.gAd()));
      }
      do
      {
        for (;;)
        {
          if (gzT() > 0L)
          {
            gzZ();
            return;
            if (!(localObject1 instanceof kotlinx.coroutines.internal.l)) {
              break;
            }
            ((kotlinx.coroutines.internal.l)localObject1).close();
          }
        }
      } while (localObject1 == bg.gAd());
      Object localObject2 = new kotlinx.coroutines.internal.l(8, true);
    } while (localObject1 != null);
    throw new v("null cannot be cast to non-null type kotlinx.coroutines.Runnable /* = java.lang.Runnable */");
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/coroutines/EventLoopImplBase$DelayedResumeTask;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "nanoTime", "", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlinx/coroutines/EventLoopImplBase;JLkotlinx/coroutines/CancellableContinuation;)V", "run", "toString", "", "kotlinx-coroutines-core"})
  final class a
    extends be.b
  {
    private final k<d.z> OfF;
    
    public a(k<? super d.z> paramk)
    {
      super();
      Object localObject;
      this.OfF = localObject;
    }
    
    public final void run()
    {
      AppMethodBeat.i(209191);
      this.OfF.a(be.this, d.z.Nhr);
      AppMethodBeat.o(209191);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(209192);
      String str = super.toString() + this.OfF.toString();
      AppMethodBeat.o(209192);
      return str;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "nanoTime", "", "(J)V", "_heap", "", "value", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "heap", "getHeap", "()Lkotlinx/coroutines/internal/ThreadSafeHeap;", "setHeap", "(Lkotlinx/coroutines/internal/ThreadSafeHeap;)V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "compareTo", "other", "dispose", "", "scheduleTask", "now", "delayed", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "eventLoop", "Lkotlinx/coroutines/EventLoopImplBase;", "timeToExecute", "", "toString", "", "kotlinx-coroutines-core"})
  public static abstract class b
    implements Comparable<b>, Runnable, ba, kotlinx.coroutines.internal.z
  {
    private Object OfH;
    private int index;
    public long nanoTime;
    
    public b(long paramLong)
    {
      this.nanoTime = paramLong;
      this.index = -1;
    }
    
    public final int a(long paramLong, be.c paramc, be parambe)
    {
      Object localObject1;
      Object localObject2;
      int i;
      label84:
      label125:
      long l;
      for (;;)
      {
        try
        {
          localObject1 = this.OfH;
          localObject2 = bg.gAc();
          if (localObject1 == localObject2)
          {
            i = 2;
            return i;
          }
          localObject1 = (y)paramc;
          localObject2 = (kotlinx.coroutines.internal.z)this;
          b localb;
          try
          {
            localb = (b)((y)localObject1).gAN();
            boolean bool = be.a(parambe);
            if (bool)
            {
              i = 1;
              continue;
            }
            if (localb == null)
            {
              paramc.OfI = paramLong;
              if (this.nanoTime - paramc.OfI < 0L) {
                this.nanoTime = paramc.OfI;
              }
              if (!am.gzF()) {
                break;
              }
              if (((kotlinx.coroutines.internal.z)localObject2).gAa() != null) {
                break label328;
              }
              i = 1;
              if (i != 0) {
                break;
              }
              throw ((Throwable)new AssertionError());
            }
          }
          finally {}
          l = localb.nanoTime;
        }
        finally {}
        if (l - paramLong < 0L) {
          break label322;
        }
        label168:
        if (paramLong - paramc.OfI <= 0L) {
          break label326;
        }
        paramc.OfI = paramLong;
      }
      ((kotlinx.coroutines.internal.z)localObject2).a((y)localObject1);
      parambe = ((y)localObject1).Ohv;
      if (parambe == null)
      {
        paramc = new kotlinx.coroutines.internal.z[4];
        ((y)localObject1).Ohv = paramc;
      }
      for (;;)
      {
        i = ((y)localObject1)._size;
        ((y)localObject1)._size = (i + 1);
        paramc[i] = localObject2;
        ((kotlinx.coroutines.internal.z)localObject2).setIndex(i);
        ((y)localObject1).amo(i);
        i = 0;
        break;
        paramc = parambe;
        if (((y)localObject1)._size >= parambe.length)
        {
          paramc = Arrays.copyOf(parambe, ((y)localObject1)._size * 2);
          p.g(paramc, "java.util.Arrays.copyOf(this, newSize)");
          ((y)localObject1).Ohv = ((kotlinx.coroutines.internal.z[])paramc);
          paramc = (kotlinx.coroutines.internal.z[])paramc;
          continue;
          label322:
          paramLong = l;
          break label168;
          label326:
          break label84;
          label328:
          i = 0;
          break label125;
        }
      }
    }
    
    public final void a(y<?> paramy)
    {
      if (this.OfH != bg.gAc()) {}
      for (int i = 1; i == 0; i = 0) {
        throw ((Throwable)new IllegalArgumentException("Failed requirement.".toString()));
      }
      this.OfH = paramy;
    }
    
    /* Error */
    public final void dispose()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 73	kotlinx/coroutines/be$b:OfH	Ljava/lang/Object;
      //   6: astore_2
      //   7: invokestatic 79	kotlinx/coroutines/bg:gAc	()Lkotlinx/coroutines/internal/t;
      //   10: astore_1
      //   11: aload_2
      //   12: aload_1
      //   13: if_acmpne +6 -> 19
      //   16: aload_0
      //   17: monitorexit
      //   18: return
      //   19: aload_2
      //   20: astore_1
      //   21: aload_2
      //   22: instanceof 90
      //   25: ifne +5 -> 30
      //   28: aconst_null
      //   29: astore_1
      //   30: aload_1
      //   31: checkcast 90	kotlinx/coroutines/be$c
      //   34: astore_1
      //   35: aload_1
      //   36: ifnull +12 -> 48
      //   39: aload_1
      //   40: aload_0
      //   41: checkcast 13	kotlinx/coroutines/internal/z
      //   44: invokevirtual 154	kotlinx/coroutines/be$c:a	(Lkotlinx/coroutines/internal/z;)Z
      //   47: pop
      //   48: aload_0
      //   49: invokestatic 79	kotlinx/coroutines/bg:gAc	()Lkotlinx/coroutines/internal/t;
      //   52: putfield 73	kotlinx/coroutines/be$b:OfH	Ljava/lang/Object;
      //   55: goto -39 -> 16
      //   58: astore_1
      //   59: aload_0
      //   60: monitorexit
      //   61: aload_1
      //   62: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	63	0	this	b
      //   10	30	1	localObject1	Object
      //   58	4	1	localObject2	Object
      //   6	16	2	localObject3	Object
      // Exception table:
      //   from	to	target	type
      //   2	11	58	finally
      //   21	28	58	finally
      //   30	35	58	finally
      //   39	48	58	finally
      //   48	55	58	finally
    }
    
    public final y<?> gAa()
    {
      Object localObject2 = this.OfH;
      Object localObject1 = localObject2;
      if (!(localObject2 instanceof y)) {
        localObject1 = null;
      }
      return (y)localObject1;
    }
    
    public final int getIndex()
    {
      return this.index;
    }
    
    public final void setIndex(int paramInt)
    {
      this.index = paramInt;
    }
    
    public String toString()
    {
      return "Delayed[nanos=" + this.nanoTime + ']';
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "timeNow", "", "(J)V", "kotlinx-coroutines-core"})
  public static final class c
    extends y<be.b>
  {
    public long OfI;
    
    public c(long paramLong)
    {
      this.OfI = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.be
 * JD-Core Version:    0.7.0.1
 */