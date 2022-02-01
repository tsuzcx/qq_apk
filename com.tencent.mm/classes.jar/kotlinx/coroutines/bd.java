package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.f;
import d.k.h;
import d.l;
import d.v;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.internal.x;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlinx/coroutines/EventLoopImplBase;", "<init>", "()V", "", "closeQueue", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dequeue", "()Ljava/lang/Runnable;", "Lkotlin/coroutines/CoroutineContext;", "context", "block", "dispatch", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "task", "enqueue", "(Ljava/lang/Runnable;)V", "", "enqueueImpl", "(Ljava/lang/Runnable;)Z", "", "processNextEvent", "()J", "rescheduleAllDelayed", "resetAll", "now", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "delayedTask", "schedule", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTask;)V", "", "scheduleImpl", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTask;)I", "timeMillis", "Lkotlinx/coroutines/DisposableHandle;", "scheduleInvokeOnTimeout", "(JLjava/lang/Runnable;)Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/CancellableContinuation;", "continuation", "scheduleResumeAfterDelay", "(JLkotlinx/coroutines/CancellableContinuation;)V", "shouldUnpark", "(Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;)Z", "shutdown", "value", "isCompleted", "()Z", "setCompleted", "(Z)V", "isEmpty", "getNextTime", "nextTime", "DelayedResumeTask", "DelayedRunnableTask", "DelayedTask", "DelayedTaskQueue", "kotlinx-coroutines-core", "Lkotlinx/coroutines/EventLoopImplPlatform;", "Lkotlinx/coroutines/Delay;"})
public abstract class bd
  extends be
  implements ar
{
  private static final AtomicReferenceFieldUpdater LRC = AtomicReferenceFieldUpdater.newUpdater(bd.class, Object.class, "_queue");
  private static final AtomicReferenceFieldUpdater LRD = AtomicReferenceFieldUpdater.newUpdater(bd.class, Object.class, "_delayed");
  volatile Object _delayed = null;
  private volatile int _isCompleted = 0;
  volatile Object _queue = null;
  
  private final boolean a(b paramb)
  {
    Object localObject = (c)this._delayed;
    if (localObject != null) {}
    for (localObject = (b)((c)localObject).geK(); localObject == paramb; localObject = null) {
      return true;
    }
    return false;
  }
  
  private final boolean aY(Runnable paramRunnable)
  {
    Object localObject;
    kotlinx.coroutines.internal.k localk;
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
          if (LRC.compareAndSet(this, null, paramRunnable)) {
            return true;
          }
        }
        else
        {
          if (!(localObject instanceof kotlinx.coroutines.internal.k)) {
            break;
          }
          if (localObject == null) {
            throw new v("null cannot be cast to non-null type kotlinx.coroutines.Queue<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> /* = kotlinx.coroutines.internal.LockFreeTaskQueueCore<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> */");
          }
          switch (((kotlinx.coroutines.internal.k)localObject).fW(paramRunnable))
          {
          default: 
            break;
          case 0: 
            return true;
          case 2: 
            return false;
          }
          LRC.compareAndSet(this, localObject, ((kotlinx.coroutines.internal.k)localObject).geE());
        }
      }
      if (localObject == bf.geb()) {
        return false;
      }
      localk = new kotlinx.coroutines.internal.k(8, true);
      if (localObject == null) {
        throw new v("null cannot be cast to non-null type kotlinx.coroutines.Runnable /* = java.lang.Runnable */");
      }
      localk.fW((Runnable)localObject);
      localk.fW(paramRunnable);
    } while (!LRC.compareAndSet(this, localObject, localk));
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
      localObject = (bd)this;
      LRD.compareAndSet(localObject, null, new c(paramLong));
      localObject = ((bd)localObject)._delayed;
      if (localObject == null) {
        d.g.b.k.fOy();
      }
      localObject = (c)localObject;
    }
    return paramb.a(paramLong, (c)localObject, this);
  }
  
  private final void gdX()
  {
    Object localObject = cg.LSm;
    long l;
    if (localObject != null) {
      l = ((cf)localObject).nanoTime();
    }
    for (;;)
    {
      localObject = (c)this._delayed;
      if (localObject != null)
      {
        localObject = (b)((c)localObject).geL();
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
        gdZ();
      }
    case 2: 
      return;
    }
    c(paramLong, paramb);
  }
  
  public final void a(long paramLong, j<? super d.y> paramj)
  {
    long l = bf.Cy(paramLong);
    Object localObject;
    if (l < 4611686018427387903L)
    {
      localObject = cg.LSm;
      if (localObject == null) {
        break label68;
      }
    }
    label68:
    for (paramLong = ((cf)localObject).nanoTime();; paramLong = System.nanoTime())
    {
      localObject = new a(l + paramLong, paramj);
      m.a(paramj, (az)localObject);
      a(paramLong, (b)localObject);
      return;
    }
  }
  
  public final void a(f paramf, Runnable paramRunnable)
  {
    aX(paramRunnable);
  }
  
  public final void aX(Runnable paramRunnable)
  {
    for (Object localObject = this;; localObject = an.LRk) {
      if (((bd)localObject).aY(paramRunnable))
      {
        ((bd)localObject).gdZ();
        return;
      }
    }
  }
  
  public final long gdR()
  {
    Object localObject4 = null;
    if (gdT()) {
      return gdS();
    }
    Object localObject5 = (c)this._delayed;
    Object localObject1;
    long l;
    if ((localObject5 != null) && (!((c)localObject5).isEmpty()))
    {
      localObject1 = cg.LSm;
      if (localObject1 == null) {
        break label123;
      }
      l = ((cf)localObject1).nanoTime();
    }
    for (;;)
    {
      synchronized ((x)localObject5)
      {
        localObject1 = ???.geM();
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
            return gdS();
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
              bool = aY((Runnable)localObject1);
              if (!bool) {
                continue;
              }
              localObject1 = ???.ajc(0);
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
      if ((localObject5 instanceof kotlinx.coroutines.internal.k))
      {
        if (localObject5 == null) {
          throw new v("null cannot be cast to non-null type kotlinx.coroutines.Queue<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> /* = kotlinx.coroutines.internal.LockFreeTaskQueueCore<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> */");
        }
        localObject3 = ((kotlinx.coroutines.internal.k)localObject5).geu();
        if (localObject3 != kotlinx.coroutines.internal.k.LSW) {
          localObject3 = (Runnable)localObject3;
        } else {
          LRC.compareAndSet(this, localObject5, ((kotlinx.coroutines.internal.k)localObject5).geE());
        }
      }
      else
      {
        localObject3 = localObject4;
        if (localObject5 != bf.geb()) {
          if (LRC.compareAndSet(this, localObject5, null))
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
  
  protected final long gdS()
  {
    if (super.gdS() == 0L) {
      return 0L;
    }
    Object localObject = this._queue;
    if (localObject != null) {
      if ((localObject instanceof kotlinx.coroutines.internal.k))
      {
        if (!((kotlinx.coroutines.internal.k)localObject).isEmpty()) {
          return 0L;
        }
      }
      else
      {
        if (localObject == bf.geb()) {
          return 9223372036854775807L;
        }
        return 0L;
      }
    }
    localObject = (c)this._delayed;
    if (localObject != null)
    {
      localObject = (b)((c)localObject).geK();
      if (localObject != null) {}
    }
    else
    {
      return 9223372036854775807L;
    }
    long l2 = ((b)localObject).nanoTime;
    localObject = cg.LSm;
    if (localObject != null) {}
    for (long l1 = ((cf)localObject).nanoTime();; l1 = System.nanoTime()) {
      return h.aC(l2 - l1, 0L);
    }
  }
  
  protected final boolean isEmpty()
  {
    if (!gdV()) {
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
    if ((localObject instanceof kotlinx.coroutines.internal.k)) {
      return ((kotlinx.coroutines.internal.k)localObject).isEmpty();
    }
    return localObject == bf.geb();
  }
  
  protected final void shutdown()
  {
    Object localObject1 = ce.LSl;
    ce.ger();
    this._isCompleted = 1;
    if ((al.gdD()) && (this._isCompleted == 0)) {
      throw ((Throwable)new AssertionError());
    }
    label94:
    do
    {
      ((kotlinx.coroutines.internal.k)localObject2).fW((Runnable)localObject1);
      if (!LRC.compareAndSet(this, localObject1, localObject2)) {
        do
        {
          localObject1 = this._queue;
          if (localObject1 != null) {
            break label94;
          }
          break;
        } while (!LRC.compareAndSet(this, null, bf.geb()));
      }
      do
      {
        for (;;)
        {
          if (gdR() > 0L)
          {
            gdX();
            return;
            if (!(localObject1 instanceof kotlinx.coroutines.internal.k)) {
              break;
            }
            ((kotlinx.coroutines.internal.k)localObject1).close();
          }
        }
      } while (localObject1 == bf.geb());
      Object localObject2 = new kotlinx.coroutines.internal.k(8, true);
    } while (localObject1 != null);
    throw new v("null cannot be cast to non-null type kotlinx.coroutines.Runnable /* = java.lang.Runnable */");
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlinx/coroutines/EventLoopImplBase$DelayedResumeTask;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "nanoTime", "", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlinx/coroutines/EventLoopImplBase;JLkotlinx/coroutines/CancellableContinuation;)V", "run", "toString", "", "kotlinx-coroutines-core"})
  final class a
    extends bd.b
  {
    private final j<d.y> LRE;
    
    public a(j<? super d.y> paramj)
    {
      super();
      Object localObject;
      this.LRE = localObject;
    }
    
    public final void run()
    {
      AppMethodBeat.i(191091);
      this.LRE.a(bd.this, d.y.KTp);
      AppMethodBeat.o(191091);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(191092);
      String str = super.toString() + this.LRE.toString();
      AppMethodBeat.o(191092);
      return str;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "nanoTime", "", "(J)V", "_heap", "", "value", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "heap", "getHeap", "()Lkotlinx/coroutines/internal/ThreadSafeHeap;", "setHeap", "(Lkotlinx/coroutines/internal/ThreadSafeHeap;)V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "compareTo", "other", "dispose", "", "scheduleTask", "now", "delayed", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "eventLoop", "Lkotlinx/coroutines/EventLoopImplBase;", "timeToExecute", "", "toString", "", "kotlinx-coroutines-core"})
  public static abstract class b
    implements Comparable<b>, Runnable, az, kotlinx.coroutines.internal.y
  {
    private Object LRG;
    private int index;
    public long nanoTime;
    
    public b(long paramLong)
    {
      this.nanoTime = paramLong;
      this.index = -1;
    }
    
    public final int a(long paramLong, bd.c paramc, bd parambd)
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
          localObject1 = this.LRG;
          localObject2 = bf.gea();
          if (localObject1 == localObject2)
          {
            i = 2;
            return i;
          }
          localObject1 = (x)paramc;
          localObject2 = (kotlinx.coroutines.internal.y)this;
          b localb;
          try
          {
            localb = (b)((x)localObject1).geM();
            boolean bool = bd.a(parambd);
            if (bool)
            {
              i = 1;
              continue;
            }
            if (localb == null)
            {
              paramc.LRH = paramLong;
              if (this.nanoTime - paramc.LRH < 0L) {
                this.nanoTime = paramc.LRH;
              }
              if (!al.gdD()) {
                break;
              }
              if (((kotlinx.coroutines.internal.y)localObject2).gdY() != null) {
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
        if (paramLong - paramc.LRH <= 0L) {
          break label326;
        }
        paramc.LRH = paramLong;
      }
      ((kotlinx.coroutines.internal.y)localObject2).a((x)localObject1);
      parambd = ((x)localObject1).LTs;
      if (parambd == null)
      {
        paramc = new kotlinx.coroutines.internal.y[4];
        ((x)localObject1).LTs = paramc;
      }
      for (;;)
      {
        i = ((x)localObject1)._size;
        ((x)localObject1)._size = (i + 1);
        paramc[i] = localObject2;
        ((kotlinx.coroutines.internal.y)localObject2).setIndex(i);
        ((x)localObject1).ajd(i);
        i = 0;
        break;
        paramc = parambd;
        if (((x)localObject1)._size >= parambd.length)
        {
          paramc = Arrays.copyOf(parambd, ((x)localObject1)._size * 2);
          d.g.b.k.g(paramc, "java.util.Arrays.copyOf(this, newSize)");
          ((x)localObject1).LTs = ((kotlinx.coroutines.internal.y[])paramc);
          paramc = (kotlinx.coroutines.internal.y[])paramc;
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
    
    public final void a(x<?> paramx)
    {
      if (this.LRG != bf.gea()) {}
      for (int i = 1; i == 0; i = 0) {
        throw ((Throwable)new IllegalArgumentException("Failed requirement.".toString()));
      }
      this.LRG = paramx;
    }
    
    /* Error */
    public final void dispose()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 73	kotlinx/coroutines/bd$b:LRG	Ljava/lang/Object;
      //   6: astore_2
      //   7: invokestatic 79	kotlinx/coroutines/bf:gea	()Lkotlinx/coroutines/internal/s;
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
      //   31: checkcast 90	kotlinx/coroutines/bd$c
      //   34: astore_1
      //   35: aload_1
      //   36: ifnull +12 -> 48
      //   39: aload_1
      //   40: aload_0
      //   41: checkcast 13	kotlinx/coroutines/internal/y
      //   44: invokevirtual 154	kotlinx/coroutines/bd$c:a	(Lkotlinx/coroutines/internal/y;)Z
      //   47: pop
      //   48: aload_0
      //   49: invokestatic 79	kotlinx/coroutines/bf:gea	()Lkotlinx/coroutines/internal/s;
      //   52: putfield 73	kotlinx/coroutines/bd$b:LRG	Ljava/lang/Object;
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
    
    public final x<?> gdY()
    {
      Object localObject2 = this.LRG;
      Object localObject1 = localObject2;
      if (!(localObject2 instanceof x)) {
        localObject1 = null;
      }
      return (x)localObject1;
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
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "timeNow", "", "(J)V", "kotlinx-coroutines-core"})
  public static final class c
    extends x<bd.b>
  {
    public long LRH;
    
    public c(long paramLong)
    {
      this.LRH = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.bd
 * JD-Core Version:    0.7.0.1
 */