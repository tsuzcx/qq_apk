package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.d.f;
import kotlin.k.k;
import kotlinx.coroutines.internal.ac;
import kotlinx.coroutines.internal.ai;
import kotlinx.coroutines.internal.r;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/EventLoopImplBase;", "<init>", "()V", "", "closeQueue", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dequeue", "()Ljava/lang/Runnable;", "Lkotlin/coroutines/CoroutineContext;", "context", "block", "dispatch", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "task", "enqueue", "(Ljava/lang/Runnable;)V", "", "enqueueImpl", "(Ljava/lang/Runnable;)Z", "", "processNextEvent", "()J", "rescheduleAllDelayed", "resetAll", "now", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "delayedTask", "schedule", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTask;)V", "", "scheduleImpl", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTask;)I", "timeMillis", "Lkotlinx/coroutines/DisposableHandle;", "scheduleInvokeOnTimeout", "(JLjava/lang/Runnable;)Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/CancellableContinuation;", "continuation", "scheduleResumeAfterDelay", "(JLkotlinx/coroutines/CancellableContinuation;)V", "shouldUnpark", "(Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;)Z", "shutdown", "value", "isCompleted", "()Z", "setCompleted", "(Z)V", "isEmpty", "getNextTime", "nextTime", "DelayedResumeTask", "DelayedRunnableTask", "DelayedTask", "DelayedTaskQueue", "kotlinx-coroutines-core", "Lkotlinx/coroutines/EventLoopImplPlatform;", "Lkotlinx/coroutines/Delay;"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class bn
  extends bo
  implements ba
{
  private final boolean a(c paramc)
  {
    Object localObject = (d)this._delayed;
    if (localObject == null) {}
    for (localObject = null; localObject == paramc; localObject = (c)((d)localObject).kEq()) {
      return true;
    }
    return false;
  }
  
  private final int b(long paramLong, c paramc)
  {
    if (this._isCompleted != 0) {
      return 1;
    }
    d locald = (d)this._delayed;
    Object localObject = locald;
    if (locald == null)
    {
      localObject = (bn)this;
      ajwd.compareAndSet(localObject, null, new d(paramLong));
      localObject = ((bn)localObject)._delayed;
      kotlin.g.b.s.checkNotNull(localObject);
      localObject = (d)localObject;
    }
    return paramc.a(paramLong, (d)localObject, this);
  }
  
  private final boolean bt(Runnable paramRunnable)
  {
    Object localObject;
    r localr;
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
          if (ajwc.compareAndSet(this, null, paramRunnable)) {
            return true;
          }
        }
        else
        {
          if (!(localObject instanceof r)) {
            break;
          }
          if (localObject == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
          }
          switch (((r)localObject).jm(paramRunnable))
          {
          default: 
            break;
          case 0: 
            return true;
          case 2: 
            return false;
          }
          ajwc.compareAndSet(this, localObject, ((r)localObject).kEh());
        }
      }
      if (localObject == bp.kCs()) {
        return false;
      }
      localr = new r(8, true);
      if (localObject == null) {
        throw new NullPointerException("null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
      }
      localr.jm((Runnable)localObject);
      localr.jm(paramRunnable);
    } while (!ajwc.compareAndSet(this, localObject, localr));
    return true;
  }
  
  private final void kCq()
  {
    long l;
    if (c.ajvf == null)
    {
      l = System.nanoTime();
      localObject = (d)this._delayed;
      if (localObject != null) {
        break label39;
      }
    }
    label39:
    for (Object localObject = null;; localObject = (c)((d)localObject).kEr())
    {
      if (localObject == null) {
        return;
      }
      c(l, (c)localObject);
      break;
      throw null;
    }
  }
  
  public bi a(long paramLong, Runnable paramRunnable, f paramf)
  {
    return ba.a.b(paramLong, paramRunnable, paramf);
  }
  
  public final void a(long paramLong, c paramc)
  {
    switch (b(paramLong, paramc))
    {
    default: 
      throw ((Throwable)new IllegalStateException("unexpected result".toString()));
    case 0: 
      if (a(paramc)) {
        Co();
      }
    case 2: 
      return;
    }
    c(paramLong, paramc);
  }
  
  public final void a(long paramLong, p<? super kotlin.ah> paramp)
  {
    paramLong = bp.BL(paramLong);
    if (paramLong < 4611686018427387903L)
    {
      if (c.ajvf == null)
      {
        long l = System.nanoTime();
        a locala = new a(paramLong + l, paramp);
        s.a(paramp, (bi)locala);
        a(l, (c)locala);
      }
    }
    else {
      return;
    }
    throw null;
  }
  
  public final void a(f paramf, Runnable paramRunnable)
  {
    bs(paramRunnable);
  }
  
  public final void bs(Runnable paramRunnable)
  {
    for (Object localObject = this;; localObject = aw.ajvR) {
      if (((bn)localObject).bt(paramRunnable))
      {
        ((bn)localObject).Co();
        return;
      }
    }
  }
  
  protected final long eHQ()
  {
    if (super.eHQ() == 0L) {
      return 0L;
    }
    Object localObject = this._queue;
    if (localObject != null) {
      if ((localObject instanceof r))
      {
        if (!((r)localObject).isEmpty()) {
          return 0L;
        }
      }
      else
      {
        if (localObject == bp.kCs()) {
          return 9223372036854775807L;
        }
        return 0L;
      }
    }
    localObject = (d)this._delayed;
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = (c)((d)localObject).kEq()) {
      return 9223372036854775807L;
    }
    long l = ((c)localObject).ajwh;
    if (c.ajvf == null) {
      return k.bR(l - System.nanoTime(), 0L);
    }
    throw null;
  }
  
  protected final boolean isEmpty()
  {
    if (!kCo()) {
      return false;
    }
    Object localObject = (d)this._delayed;
    if ((localObject != null) && (!((d)localObject).isEmpty())) {
      return false;
    }
    localObject = this._queue;
    if (localObject == null) {
      return true;
    }
    if ((localObject instanceof r)) {
      return ((r)localObject).isEmpty();
    }
    return localObject == bp.kCs();
  }
  
  public final long kCk()
  {
    Object localObject4 = null;
    if (kCl()) {
      return 0L;
    }
    Object localObject5 = (d)this._delayed;
    long l;
    if ((localObject5 != null) && (!((d)localObject5).isEmpty()))
    {
      if (c.ajvf != null) {
        break label109;
      }
      l = System.nanoTime();
    }
    for (;;)
    {
      synchronized ((kotlinx.coroutines.internal.ah)localObject5)
      {
        Object localObject1 = ???.kEs();
        if (localObject1 == null)
        {
          localObject1 = null;
          if ((c)localObject1 != null) {
            continue;
          }
          localObject5 = this._queue;
          if (localObject5 == null)
          {
            localObject1 = localObject4;
            if (localObject1 == null) {
              break;
            }
            ((Runnable)localObject1).run();
            return 0L;
            label109:
            throw null;
          }
        }
        else
        {
          localObject1 = (c)localObject1;
          int i;
          if (l - ((c)localObject1).ajwh >= 0L)
          {
            i = 1;
            if (i != 0)
            {
              bool = bt((Runnable)localObject1);
              if (!bool) {
                continue;
              }
              localObject1 = ???.aME(0);
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
      if ((localObject5 instanceof r))
      {
        if (localObject5 == null) {
          throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
        }
        localObject3 = ((r)localObject5).kkV();
        if (localObject3 != r.ajAG) {
          localObject3 = (Runnable)localObject3;
        } else {
          ajwc.compareAndSet(this, localObject5, ((r)localObject5).kEh());
        }
      }
      else
      {
        localObject3 = localObject4;
        if (localObject5 != bp.kCs()) {
          if (ajwc.compareAndSet(this, localObject5, null))
          {
            if (localObject5 == null) {
              throw new NullPointerException("null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
            }
            localObject3 = (Runnable)localObject5;
          }
        }
      }
    }
    return eHQ();
  }
  
  protected final void kCp()
  {
    this._queue = null;
    this._delayed = null;
  }
  
  protected final void shutdown()
  {
    Object localObject1 = cz.ajwN;
    cz.kCO();
    this._isCompleted = 1;
    if ((au.ASSERTIONS_ENABLED) && (this._isCompleted == 0)) {
      throw new AssertionError();
    }
    label91:
    do
    {
      ((r)localObject2).jm((Runnable)localObject1);
      if (!ajwc.compareAndSet(this, localObject1, localObject2)) {
        do
        {
          localObject1 = this._queue;
          if (localObject1 != null) {
            break label91;
          }
          break;
        } while (!ajwc.compareAndSet(this, null, bp.kCs()));
      }
      do
      {
        for (;;)
        {
          if (kCk() > 0L)
          {
            kCq();
            return;
            if (!(localObject1 instanceof r)) {
              break;
            }
            ((r)localObject1).close();
          }
        }
      } while (localObject1 == bp.kCs());
      Object localObject2 = new r(8, true);
    } while (localObject1 != null);
    throw new NullPointerException("null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
  }
  
  @Metadata(d1={""}, d2={"Lkotlinx/coroutines/EventLoopImplBase$DelayedResumeTask;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "nanoTime", "", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlinx/coroutines/EventLoopImplBase;JLkotlinx/coroutines/CancellableContinuation;)V", "run", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
  final class a
    extends bn.c
  {
    private final p<kotlin.ah> ajwe;
    
    public a(p<? super kotlin.ah> paramp)
    {
      super();
      Object localObject;
      this.ajwe = localObject;
    }
    
    public final void run()
    {
      AppMethodBeat.i(188827);
      this.ajwe.a((al)bn.this, kotlin.ah.aiuX);
      AppMethodBeat.o(188827);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(188833);
      String str = kotlin.g.b.s.X(super.toString(), this.ajwe);
      AppMethodBeat.o(188833);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Lkotlinx/coroutines/EventLoopImplBase$DelayedRunnableTask;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "nanoTime", "", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "(JLjava/lang/Runnable;)V", "run", "", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
  static final class b
    extends bn.c
  {
    private final Runnable ajwg;
    
    public b(long paramLong, Runnable paramRunnable)
    {
      super();
      this.ajwg = paramRunnable;
    }
    
    public final void run()
    {
      AppMethodBeat.i(188834);
      this.ajwg.run();
      AppMethodBeat.o(188834);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(188842);
      String str = kotlin.g.b.s.X(super.toString(), this.ajwg);
      AppMethodBeat.o(188842);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "nanoTime", "", "(J)V", "_heap", "", "value", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "heap", "getHeap", "()Lkotlinx/coroutines/internal/ThreadSafeHeap;", "setHeap", "(Lkotlinx/coroutines/internal/ThreadSafeHeap;)V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "compareTo", "other", "dispose", "", "scheduleTask", "now", "delayed", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "eventLoop", "Lkotlinx/coroutines/EventLoopImplBase;", "timeToExecute", "", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract class c
    implements Comparable<c>, Runnable, bi, ai
  {
    public long ajwh;
    private Object ajwi;
    private int index;
    
    public c(long paramLong)
    {
      this.ajwh = paramLong;
      this.index = -1;
    }
    
    public final int a(long paramLong, bn.d paramd, bn parambn)
    {
      Object localObject2;
      int i;
      label78:
      label125:
      long l;
      for (;;)
      {
        try
        {
          ??? = this.ajwi;
          localObject2 = bp.kCt();
          if (??? == localObject2)
          {
            i = 2;
            return i;
          }
          synchronized ((kotlinx.coroutines.internal.ah)paramd)
          {
            localObject2 = (c)((kotlinx.coroutines.internal.ah)???).kEs();
            boolean bool = bn.a(parambn);
            if (bool)
            {
              i = 1;
              continue;
            }
            if (localObject2 == null)
            {
              paramd.ajwj = paramLong;
              if (this.ajwh - paramd.ajwj < 0L) {
                this.ajwh = paramd.ajwj;
              }
              localObject2 = (ai)this;
              if (!au.ASSERTIONS_ENABLED) {
                break;
              }
              if (((ai)localObject2).kCr() != null) {
                break label322;
              }
              i = 1;
              if (i != 0) {
                break;
              }
              throw new AssertionError();
            }
          }
          l = ((c)localObject2).ajwh;
        }
        finally {}
        if (l - paramLong < 0L) {
          break label316;
        }
        label165:
        if (paramLong - paramd.ajwj <= 0L) {
          break label320;
        }
        paramd.ajwj = paramLong;
      }
      ((ai)localObject2).a((kotlinx.coroutines.internal.ah)???);
      parambn = ((kotlinx.coroutines.internal.ah)???).ajBa;
      if (parambn == null)
      {
        paramd = new ai[4];
        ((kotlinx.coroutines.internal.ah)???).ajBa = paramd;
      }
      for (;;)
      {
        i = ((kotlinx.coroutines.internal.ah)???)._size;
        ((kotlinx.coroutines.internal.ah)???)._size = (i + 1);
        paramd[i] = localObject2;
        ((ai)localObject2).setIndex(i);
        ((kotlinx.coroutines.internal.ah)???).aMF(i);
        i = 0;
        break;
        paramd = parambn;
        if (((kotlinx.coroutines.internal.ah)???)._size >= parambn.length)
        {
          paramd = Arrays.copyOf(parambn, ((kotlinx.coroutines.internal.ah)???)._size * 2);
          kotlin.g.b.s.s(paramd, "java.util.Arrays.copyOf(this, newSize)");
          ((kotlinx.coroutines.internal.ah)???).ajBa = ((ai[])paramd);
          paramd = (ai[])paramd;
          continue;
          label316:
          paramLong = l;
          break label165;
          label320:
          break label78;
          label322:
          i = 0;
          break label125;
        }
      }
    }
    
    public final void a(kotlinx.coroutines.internal.ah<?> paramah)
    {
      if (this.ajwi != bp.kCt()) {}
      for (int i = 1; i == 0; i = 0) {
        throw ((Throwable)new IllegalArgumentException("Failed requirement.".toString()));
      }
      this.ajwi = paramah;
    }
    
    public final void dispose()
    {
      for (;;)
      {
        try
        {
          Object localObject1 = this.ajwi;
          ac localac = bp.kCt();
          if (localObject1 == localac) {
            return;
          }
          if ((localObject1 instanceof bn.d))
          {
            localObject1 = (bn.d)localObject1;
            if (localObject1 != null) {
              ((bn.d)localObject1).a((ai)this);
            }
            this.ajwi = bp.kCt();
          }
          else
          {
            Object localObject3 = null;
          }
        }
        finally {}
      }
    }
    
    public final int getIndex()
    {
      return this.index;
    }
    
    public final kotlinx.coroutines.internal.ah<?> kCr()
    {
      Object localObject = this.ajwi;
      if ((localObject instanceof kotlinx.coroutines.internal.ah)) {
        return (kotlinx.coroutines.internal.ah)localObject;
      }
      return null;
    }
    
    public final void setIndex(int paramInt)
    {
      this.index = paramInt;
    }
    
    public String toString()
    {
      return "Delayed[nanos=" + this.ajwh + ']';
    }
  }
  
  @Metadata(d1={""}, d2={"Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "timeNow", "", "(J)V", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends kotlinx.coroutines.internal.ah<bn.c>
  {
    public long ajwj;
    
    public d(long paramLong)
    {
      this.ajwj = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.bn
 * JD-Core Version:    0.7.0.1
 */