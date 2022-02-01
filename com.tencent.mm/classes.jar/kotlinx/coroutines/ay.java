package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.f;
import d.g.b.k;
import d.l;
import d.v;
import d.y;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.a.i;
import kotlinx.coroutines.a.r;
import kotlinx.coroutines.a.s;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlinx/coroutines/EventLoopImplBase;", "<init>", "()V", "", "closeQueue", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dequeue", "()Ljava/lang/Runnable;", "Lkotlin/coroutines/CoroutineContext;", "context", "block", "dispatch", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "task", "enqueue", "(Ljava/lang/Runnable;)V", "", "enqueueImpl", "(Ljava/lang/Runnable;)Z", "", "processNextEvent", "()J", "rescheduleAllDelayed", "resetAll", "now", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "delayedTask", "schedule", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTask;)V", "", "scheduleImpl", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTask;)I", "timeMillis", "Lkotlinx/coroutines/DisposableHandle;", "scheduleInvokeOnTimeout", "(JLjava/lang/Runnable;)Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/CancellableContinuation;", "continuation", "scheduleResumeAfterDelay", "(JLkotlinx/coroutines/CancellableContinuation;)V", "shouldUnpark", "(Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;)Z", "shutdown", "value", "isCompleted", "()Z", "setCompleted", "(Z)V", "isEmpty", "getNextTime", "nextTime", "DelayedResumeTask", "DelayedRunnableTask", "DelayedTask", "DelayedTaskQueue", "kotlinx-coroutines-core", "Lkotlinx/coroutines/EventLoopImplPlatform;", "Lkotlinx/coroutines/Delay;"})
public abstract class ay
  extends az
  implements an
{
  private static final AtomicReferenceFieldUpdater Kec = AtomicReferenceFieldUpdater.newUpdater(ay.class, Object.class, "_queue");
  private static final AtomicReferenceFieldUpdater Ked = AtomicReferenceFieldUpdater.newUpdater(ay.class, Object.class, "_delayed");
  volatile Object _delayed = null;
  private volatile int _isCompleted = 0;
  volatile Object _queue = null;
  
  private final boolean a(b paramb)
  {
    Object localObject = (c)this._delayed;
    if (localObject != null) {}
    for (localObject = (b)((c)localObject).fLU(); localObject == paramb; localObject = null) {
      return true;
    }
    return false;
  }
  
  private final boolean aV(Runnable paramRunnable)
  {
    Object localObject;
    i locali;
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
          if (Kec.compareAndSet(this, null, paramRunnable)) {
            return true;
          }
        }
        else
        {
          if (!(localObject instanceof i)) {
            break;
          }
          if (localObject == null) {
            throw new v("null cannot be cast to non-null type kotlinx.coroutines.Queue<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> /* = kotlinx.coroutines.internal.LockFreeTaskQueueCore<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> */");
          }
          switch (((i)localObject).fO(paramRunnable))
          {
          default: 
            break;
          case 0: 
            return true;
          case 2: 
            return false;
          }
          Kec.compareAndSet(this, localObject, ((i)localObject).fLR());
        }
      }
      if (localObject == ba.fLs()) {
        return false;
      }
      locali = new i(8, true);
      if (localObject == null) {
        throw new v("null cannot be cast to non-null type kotlinx.coroutines.Runnable /* = java.lang.Runnable */");
      }
      locali.fO((Runnable)localObject);
      locali.fO(paramRunnable);
    } while (!Kec.compareAndSet(this, localObject, locali));
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
      localObject = (ay)this;
      Ked.compareAndSet(localObject, null, new c(paramLong));
      localObject = ((ay)localObject)._delayed;
      if (localObject == null) {
        k.fvU();
      }
      localObject = (c)localObject;
    }
    return paramb.a(paramLong, (c)localObject, this);
  }
  
  private final void fLo()
  {
    Object localObject = cb.KeM;
    long l;
    if (localObject != null) {
      l = ((ca)localObject).nanoTime();
    }
    for (;;)
    {
      localObject = (c)this._delayed;
      if (localObject != null)
      {
        localObject = (b)((c)localObject).fLV();
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
        fLq();
      }
    case 2: 
      return;
    }
    c(paramLong, paramb);
  }
  
  public final void a(long paramLong, h<? super y> paramh)
  {
    long l = ba.xL(paramLong);
    Object localObject;
    if (l < 4611686018427387903L)
    {
      localObject = cb.KeM;
      if (localObject == null) {
        break label68;
      }
    }
    label68:
    for (paramLong = ((ca)localObject).nanoTime();; paramLong = System.nanoTime())
    {
      localObject = new a(l + paramLong, paramh);
      j.a(paramh, (au)localObject);
      a(paramLong, (b)localObject);
      return;
    }
  }
  
  public final void a(f paramf, Runnable paramRunnable)
  {
    aU(paramRunnable);
  }
  
  public final void aU(Runnable paramRunnable)
  {
    for (Object localObject = this;; localObject = aj.KdJ) {
      if (((ay)localObject).aV(paramRunnable))
      {
        ((ay)localObject).fLq();
        return;
      }
    }
  }
  
  public final long fLi()
  {
    Object localObject4 = null;
    if (fLk()) {
      return fLj();
    }
    Object localObject5 = (c)this._delayed;
    Object localObject1;
    long l;
    if ((localObject5 != null) && (!((c)localObject5).isEmpty()))
    {
      localObject1 = cb.KeM;
      if (localObject1 == null) {
        break label123;
      }
      l = ((ca)localObject1).nanoTime();
    }
    for (;;)
    {
      synchronized ((r)localObject5)
      {
        localObject1 = ???.fLW();
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
            return fLj();
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
              bool = aV((Runnable)localObject1);
              if (!bool) {
                continue;
              }
              localObject1 = ???.agg(0);
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
      if ((localObject5 instanceof i))
      {
        if (localObject5 == null) {
          throw new v("null cannot be cast to non-null type kotlinx.coroutines.Queue<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> /* = kotlinx.coroutines.internal.LockFreeTaskQueueCore<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> */");
        }
        localObject3 = ((i)localObject5).fLJ();
        if (localObject3 != i.Kfu) {
          localObject3 = (Runnable)localObject3;
        } else {
          Kec.compareAndSet(this, localObject5, ((i)localObject5).fLR());
        }
      }
      else
      {
        localObject3 = localObject4;
        if (localObject5 != ba.fLs()) {
          if (Kec.compareAndSet(this, localObject5, null))
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
  
  protected final long fLj()
  {
    if (super.fLj() == 0L) {
      return 0L;
    }
    Object localObject = this._queue;
    if (localObject != null) {
      if ((localObject instanceof i))
      {
        if (!((i)localObject).isEmpty()) {
          return 0L;
        }
      }
      else
      {
        if (localObject == ba.fLs()) {
          return 9223372036854775807L;
        }
        return 0L;
      }
    }
    localObject = (c)this._delayed;
    if (localObject != null)
    {
      localObject = (b)((c)localObject).fLU();
      if (localObject != null) {}
    }
    else
    {
      return 9223372036854775807L;
    }
    long l2 = ((b)localObject).nanoTime;
    localObject = cb.KeM;
    if (localObject != null) {}
    for (long l1 = ((ca)localObject).nanoTime();; l1 = System.nanoTime()) {
      return d.k.h.aH(l2 - l1, 0L);
    }
  }
  
  protected final boolean isEmpty()
  {
    if (!fLm()) {
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
    if ((localObject instanceof i)) {
      return ((i)localObject).isEmpty();
    }
    return localObject == ba.fLs();
  }
  
  protected final void shutdown()
  {
    Object localObject1 = bz.KeL;
    bz.fLH();
    this._isCompleted = 1;
    if ((ah.fKW()) && (this._isCompleted == 0)) {
      throw ((Throwable)new AssertionError());
    }
    label94:
    do
    {
      ((i)localObject2).fO((Runnable)localObject1);
      if (!Kec.compareAndSet(this, localObject1, localObject2)) {
        do
        {
          localObject1 = this._queue;
          if (localObject1 != null) {
            break label94;
          }
          break;
        } while (!Kec.compareAndSet(this, null, ba.fLs()));
      }
      do
      {
        for (;;)
        {
          if (fLi() > 0L)
          {
            fLo();
            return;
            if (!(localObject1 instanceof i)) {
              break;
            }
            ((i)localObject1).vE();
          }
        }
      } while (localObject1 == ba.fLs());
      Object localObject2 = new i(8, true);
    } while (localObject1 != null);
    throw new v("null cannot be cast to non-null type kotlinx.coroutines.Runnable /* = java.lang.Runnable */");
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlinx/coroutines/EventLoopImplBase$DelayedResumeTask;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "nanoTime", "", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlinx/coroutines/EventLoopImplBase;JLkotlinx/coroutines/CancellableContinuation;)V", "run", "toString", "", "kotlinx-coroutines-core"})
  final class a
    extends ay.b
  {
    private final h<y> Kee;
    
    public a(h<? super y> paramh)
    {
      super();
      Object localObject;
      this.Kee = localObject;
    }
    
    public final void run()
    {
      AppMethodBeat.i(189983);
      this.Kee.a(ay.this, y.JfV);
      AppMethodBeat.o(189983);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(189984);
      String str = super.toString() + this.Kee.toString();
      AppMethodBeat.o(189984);
      return str;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "nanoTime", "", "(J)V", "_heap", "", "value", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "heap", "getHeap", "()Lkotlinx/coroutines/internal/ThreadSafeHeap;", "setHeap", "(Lkotlinx/coroutines/internal/ThreadSafeHeap;)V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "compareTo", "other", "dispose", "", "scheduleTask", "now", "delayed", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "eventLoop", "Lkotlinx/coroutines/EventLoopImplBase;", "timeToExecute", "", "toString", "", "kotlinx-coroutines-core"})
  public static abstract class b
    implements Comparable<b>, Runnable, s, au
  {
    private Object Keg;
    private int index;
    public long nanoTime;
    
    public b(long paramLong)
    {
      this.nanoTime = paramLong;
      this.index = -1;
    }
    
    public final int a(long paramLong, ay.c paramc, ay paramay)
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
          localObject1 = this.Keg;
          localObject2 = ba.fLr();
          if (localObject1 == localObject2)
          {
            i = 2;
            return i;
          }
          localObject1 = (r)paramc;
          localObject2 = (s)this;
          b localb;
          try
          {
            localb = (b)((r)localObject1).fLW();
            boolean bool = ay.a(paramay);
            if (bool)
            {
              i = 1;
              continue;
            }
            if (localb == null)
            {
              paramc.Keh = paramLong;
              if (this.nanoTime - paramc.Keh < 0L) {
                this.nanoTime = paramc.Keh;
              }
              if (!ah.fKW()) {
                break;
              }
              if (((s)localObject2).fLp() != null) {
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
        if (paramLong - paramc.Keh <= 0L) {
          break label326;
        }
        paramc.Keh = paramLong;
      }
      ((s)localObject2).a((r)localObject1);
      paramay = ((r)localObject1).KfK;
      if (paramay == null)
      {
        paramc = new s[4];
        ((r)localObject1).KfK = paramc;
      }
      for (;;)
      {
        i = ((r)localObject1)._size;
        ((r)localObject1)._size = (i + 1);
        paramc[i] = localObject2;
        ((s)localObject2).setIndex(i);
        ((r)localObject1).agh(i);
        i = 0;
        break;
        paramc = paramay;
        if (((r)localObject1)._size >= paramay.length)
        {
          paramc = Arrays.copyOf(paramay, ((r)localObject1)._size * 2);
          k.g(paramc, "java.util.Arrays.copyOf(this, newSize)");
          ((r)localObject1).KfK = ((s[])paramc);
          paramc = (s[])paramc;
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
    
    public final void a(r<?> paramr)
    {
      if (this.Keg != ba.fLr()) {}
      for (int i = 1; i == 0; i = 0) {
        throw ((Throwable)new IllegalArgumentException("Failed requirement.".toString()));
      }
      this.Keg = paramr;
    }
    
    /* Error */
    public final void dispose()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 73	kotlinx/coroutines/ay$b:Keg	Ljava/lang/Object;
      //   6: astore_2
      //   7: invokestatic 79	kotlinx/coroutines/ba:fLr	()Lkotlinx/coroutines/a/m;
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
      //   31: checkcast 90	kotlinx/coroutines/ay$c
      //   34: astore_1
      //   35: aload_1
      //   36: ifnull +12 -> 48
      //   39: aload_1
      //   40: aload_0
      //   41: checkcast 11	kotlinx/coroutines/a/s
      //   44: invokevirtual 154	kotlinx/coroutines/ay$c:a	(Lkotlinx/coroutines/a/s;)Z
      //   47: pop
      //   48: aload_0
      //   49: invokestatic 79	kotlinx/coroutines/ba:fLr	()Lkotlinx/coroutines/a/m;
      //   52: putfield 73	kotlinx/coroutines/ay$b:Keg	Ljava/lang/Object;
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
    
    public final r<?> fLp()
    {
      Object localObject2 = this.Keg;
      Object localObject1 = localObject2;
      if (!(localObject2 instanceof r)) {
        localObject1 = null;
      }
      return (r)localObject1;
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
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "timeNow", "", "(J)V", "kotlinx-coroutines-core"})
  public static final class c
    extends r<ay.b>
  {
    public long Keh;
    
    public c(long paramLong)
    {
      this.Keh = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.ay
 * JD-Core Version:    0.7.0.1
 */