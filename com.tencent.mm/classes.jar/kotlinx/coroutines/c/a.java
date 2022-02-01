package kotlinx.coroutines.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.j.c;
import d.k.h;
import d.y;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.LockSupport;
import kotlinx.coroutines.ah;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "", "corePoolSize", "maxPoolSize", "", "idleWorkerKeepAliveNs", "", "schedulerName", "<init>", "(IIJLjava/lang/String;)V", "Lkotlinx/coroutines/scheduling/Task;", "task", "", "addToGlobalQueue", "(Lkotlinx/coroutines/scheduling/Task;)Z", "state", "availableCpuPermits", "(J)I", "blockingTasks", "", "close", "()V", "createNewWorker", "()I", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Lkotlinx/coroutines/scheduling/TaskContext;", "taskContext", "createTask$kotlinx_coroutines_core", "(Ljava/lang/Runnable;Lkotlinx/coroutines/scheduling/TaskContext;)Lkotlinx/coroutines/scheduling/Task;", "createTask", "createdWorkers", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "currentWorker", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "decrementBlockingTasks", "decrementCreatedWorkers", "tailDispatch", "dispatch", "(Ljava/lang/Runnable;Lkotlinx/coroutines/scheduling/TaskContext;Z)V", "command", "execute", "(Ljava/lang/Runnable;)V", "incrementBlockingTasks", "()J", "incrementCreatedWorkers", "worker", "parkedWorkersStackNextIndex", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;)I", "parkedWorkersStackPop", "parkedWorkersStackPush$kotlinx_coroutines_core", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;)Z", "parkedWorkersStackPush", "oldIndex", "newIndex", "parkedWorkersStackTopUpdate$kotlinx_coroutines_core", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;II)V", "parkedWorkersStackTopUpdate", "releaseCpuPermit", "runSafely", "(Lkotlinx/coroutines/scheduling/Task;)V", "timeout", "shutdown", "(J)V", "skipUnpark", "signalBlockingWork", "(Z)V", "signalCpuWork$kotlinx_coroutines_core", "signalCpuWork", "toString", "()Ljava/lang/String;", "tryAcquireCpuPermit", "()Z", "tryCreateWorker", "(J)Z", "tryUnpark", "submitToLocalQueue", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;Lkotlinx/coroutines/scheduling/Task;Z)Lkotlinx/coroutines/scheduling/Task;", "getAvailableCpuPermits", "I", "getCreatedWorkers", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalBlockingQueue", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalCpuQueue", "J", "isTerminated", "Ljava/lang/String;", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "workers", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "Companion", "Worker", "WorkerState", "kotlinx-coroutines-core", "Ljava/util/concurrent/Executor;", "Ljava/io/Closeable;"})
public final class a
  implements Closeable, Executor
{
  static final AtomicLongFieldUpdater KfO;
  static final AtomicLongFieldUpdater KfQ;
  private static final AtomicIntegerFieldUpdater KfR;
  public static final kotlinx.coroutines.a.m KfU;
  public static final a KfV;
  public final int Izu;
  public final e KfM;
  public final e KfN;
  public final AtomicReferenceArray<b> KfP;
  public final long KfS;
  public final String KfT;
  volatile int _isTerminated;
  public final int cUZ;
  volatile long controlState;
  volatile long parkedWorkersStack;
  
  static
  {
    AppMethodBeat.i(118011);
    KfV = new a((byte)0);
    KfU = new kotlinx.coroutines.a.m("NOT_IN_STACK");
    KfO = AtomicLongFieldUpdater.newUpdater(a.class, "parkedWorkersStack");
    KfQ = AtomicLongFieldUpdater.newUpdater(a.class, "controlState");
    KfR = AtomicIntegerFieldUpdater.newUpdater(a.class, "_isTerminated");
    AppMethodBeat.o(118011);
  }
  
  public a(int paramInt1, int paramInt2, long paramLong, String paramString)
  {
    AppMethodBeat.i(118005);
    this.cUZ = paramInt1;
    this.Izu = paramInt2;
    this.KfS = paramLong;
    this.KfT = paramString;
    if (this.cUZ > 0) {}
    for (paramInt1 = 1; paramInt1 == 0; paramInt1 = 0)
    {
      paramString = (Throwable)new IllegalArgumentException(("Core pool size " + this.cUZ + " should be at least 1").toString());
      AppMethodBeat.o(118005);
      throw paramString;
    }
    if (this.Izu >= this.cUZ) {}
    for (paramInt1 = 1; paramInt1 == 0; paramInt1 = 0)
    {
      paramString = (Throwable)new IllegalArgumentException(("Max pool size " + this.Izu + " should be greater than or equals to core pool size " + this.cUZ).toString());
      AppMethodBeat.o(118005);
      throw paramString;
    }
    if (this.Izu <= 2097150) {}
    for (paramInt1 = 1; paramInt1 == 0; paramInt1 = 0)
    {
      paramString = (Throwable)new IllegalArgumentException(("Max pool size " + this.Izu + " should not exceed maximal supported number of threads 2097150").toString());
      AppMethodBeat.o(118005);
      throw paramString;
    }
    if (this.KfS > 0L) {}
    for (paramInt1 = i; paramInt1 == 0; paramInt1 = 0)
    {
      paramString = (Throwable)new IllegalArgumentException(("Idle worker keep alive time " + this.KfS + " must be positive").toString());
      AppMethodBeat.o(118005);
      throw paramString;
    }
    this.KfM = new e();
    this.KfN = new e();
    this.parkedWorkersStack = 0L;
    this.KfP = new AtomicReferenceArray(this.Izu + 1);
    this.controlState = (this.cUZ << 42);
    this._isTerminated = 0;
    AppMethodBeat.o(118005);
  }
  
  private static int a(b paramb)
  {
    for (paramb = paramb.nextParkedWorker;; paramb = paramb.nextParkedWorker)
    {
      if (paramb == KfU) {
        return -1;
      }
      if (paramb == null) {
        return 0;
      }
      paramb = (b)paramb;
      int i = paramb.indexInArray;
      if (i != 0) {
        return i;
      }
    }
  }
  
  public static i a(Runnable paramRunnable, j paramj)
  {
    AppMethodBeat.i(117999);
    long l = l.Kgx.nanoTime();
    if ((paramRunnable instanceof i))
    {
      ((i)paramRunnable).Kgr = l;
      ((i)paramRunnable).Kgs = paramj;
      paramRunnable = (i)paramRunnable;
      AppMethodBeat.o(117999);
      return paramRunnable;
    }
    paramRunnable = (i)new k(paramRunnable, l, paramj);
    AppMethodBeat.o(117999);
    return paramRunnable;
  }
  
  public static void a(i parami)
  {
    AppMethodBeat.i(118004);
    try
    {
      parami.run();
      return;
    }
    catch (Throwable parami)
    {
      Thread localThread = Thread.currentThread();
      localThread.getUncaughtExceptionHandler().uncaughtException(localThread, parami);
      return;
    }
    finally
    {
      AppMethodBeat.o(118004);
    }
  }
  
  private final b fLX()
  {
    AppMethodBeat.i(117994);
    long l;
    int i;
    b localb;
    do
    {
      l = this.parkedWorkersStack;
      i = (int)(0x1FFFFF & l);
      localb = (b)this.KfP.get(i);
      if (localb == null)
      {
        AppMethodBeat.o(117994);
        return null;
      }
      i = a(localb);
    } while ((i < 0) || (!KfO.compareAndSet(this, l, 0xFFE00000 & 2097152L + l | i)));
    localb.nextParkedWorker = KfU;
    AppMethodBeat.o(117994);
    return localb;
  }
  
  private final boolean fLZ()
  {
    AppMethodBeat.i(118001);
    b localb;
    do
    {
      localb = fLX();
      if (localb == null)
      {
        AppMethodBeat.o(118001);
        return false;
      }
    } while (!b.KfY.compareAndSet(localb, -1, 0));
    LockSupport.unpark((Thread)localb);
    AppMethodBeat.o(118001);
    return true;
  }
  
  private final int fMa()
  {
    int j = 0;
    AppMethodBeat.i(118002);
    int k;
    int m;
    for (;;)
    {
      synchronized (this.KfP)
      {
        i = this._isTerminated;
        if (i != 0)
        {
          AppMethodBeat.o(118002);
          return -1;
        }
        long l = this.controlState;
        i = (int)(l & 0x1FFFFF);
        k = h.kK(i - (int)((l & 0xFFE00000) >> 21), 0);
        m = this.cUZ;
        if (k >= m)
        {
          AppMethodBeat.o(118002);
          return 0;
        }
        m = this.Izu;
        if (i >= m)
        {
          AppMethodBeat.o(118002);
          return 0;
        }
        m = (int)(this.controlState & 0x1FFFFF) + 1;
        if ((m > 0) && (this.KfP.get(m) == null))
        {
          i = 1;
          if (i != 0) {
            break;
          }
          Throwable localThrowable = (Throwable)new IllegalArgumentException("Failed requirement.".toString());
          AppMethodBeat.o(118002);
          throw localThrowable;
        }
      }
      i = 0;
    }
    Object localObject2 = new b(m);
    this.KfP.set(m, localObject2);
    int i = j;
    if (m == (int)(KfQ.incrementAndGet(this) & 0x1FFFFF)) {
      i = 1;
    }
    if (i == 0)
    {
      localObject2 = (Throwable)new IllegalArgumentException("Failed requirement.".toString());
      AppMethodBeat.o(118002);
      throw ((Throwable)localObject2);
    }
    ((b)localObject2).start();
    AppMethodBeat.o(118002);
    return k + 1;
  }
  
  private final b fMb()
  {
    AppMethodBeat.i(190020);
    Thread localThread = Thread.currentThread();
    Object localObject = localThread;
    if (!(localThread instanceof b)) {
      localObject = null;
    }
    localObject = (b)localObject;
    if (localObject != null)
    {
      if (d.g.b.k.g(((b)localObject).Kgd, (a)this))
      {
        AppMethodBeat.o(190020);
        return localObject;
      }
      AppMethodBeat.o(190020);
      return null;
    }
    AppMethodBeat.o(190020);
    return null;
  }
  
  private final boolean xP(long paramLong)
  {
    AppMethodBeat.i(190018);
    if (h.kK((int)(0x1FFFFF & paramLong) - (int)((0xFFE00000 & paramLong) >> 21), 0) < this.cUZ)
    {
      int i = fMa();
      if ((i == 1) && (this.cUZ > 1)) {
        fMa();
      }
      if (i > 0)
      {
        AppMethodBeat.o(190018);
        return true;
      }
    }
    AppMethodBeat.o(190018);
    return false;
  }
  
  public final void a(Runnable paramRunnable, j paramj, boolean paramBoolean)
  {
    int j = 1;
    AppMethodBeat.i(117997);
    paramj = a(paramRunnable, paramj);
    b localb = fMb();
    int i;
    if (localb == null)
    {
      paramRunnable = paramj;
      if (paramRunnable == null) {
        break label193;
      }
      if (paramRunnable.Kgs.fMh() != 1) {
        break label174;
      }
      i = 1;
      label48:
      if (i == 0) {
        break label180;
      }
    }
    label174:
    label180:
    for (boolean bool = this.KfN.fN(paramRunnable);; bool = this.KfM.fN(paramRunnable))
    {
      if (bool) {
        break label193;
      }
      paramRunnable = (Throwable)new RejectedExecutionException(this.KfT + " was terminated");
      AppMethodBeat.o(117997);
      throw paramRunnable;
      if (localb.KfX == c.Kgi)
      {
        paramRunnable = paramj;
        break;
      }
      if ((paramj.Kgs.fMh() == 0) && (localb.KfX == c.Kgf))
      {
        paramRunnable = paramj;
        break;
      }
      localb.Kgc = true;
      paramRunnable = localb.KfW.a(paramj, paramBoolean);
      break;
      i = 0;
      break label48;
    }
    label193:
    if ((paramBoolean) && (localb != null)) {
      i = j;
    }
    while (paramj.Kgs.fMh() == 0) {
      if (i != 0)
      {
        AppMethodBeat.o(117997);
        return;
        i = 0;
      }
      else
      {
        fLY();
        AppMethodBeat.o(117997);
        return;
      }
    }
    long l = KfQ.addAndGet(this, 2097152L);
    if ((i == 0) && (!fLZ()) && (!xP(l))) {
      fLZ();
    }
    AppMethodBeat.o(117997);
  }
  
  public final void a(b paramb, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(190016);
    for (;;)
    {
      long l = this.parkedWorkersStack;
      int i = (int)(0x1FFFFF & l);
      if (i == paramInt1) {
        if (paramInt2 == 0) {
          i = a(paramb);
        }
      }
      while ((i >= 0) && (KfO.compareAndSet(this, l, 2097152L + l & 0xFFE00000 | i)))
      {
        AppMethodBeat.o(190016);
        return;
        i = paramInt2;
      }
    }
  }
  
  public final void close()
  {
    int k = 1;
    AppMethodBeat.i(117996);
    if (KfR.compareAndSet(this, 0, 1))
    {
      b localb = fMb();
      for (;;)
      {
        int m;
        synchronized (this.KfP)
        {
          long l = this.controlState;
          m = (int)(l & 0x1FFFFF);
          if (m <= 0) {
            break;
          }
          i = 1;
          ??? = this.KfP.get(i);
          if (??? == null) {
            d.g.b.k.fvU();
          }
          ??? = (b)???;
          if (??? == localb) {
            break label198;
          }
          if (((b)???).isAlive())
          {
            LockSupport.unpark((Thread)???);
            ((b)???).join(10000L);
          }
        }
        if (localObject3 == c.Kgi) {}
        for (int j = 1; j == 0; j = 0)
        {
          ??? = (Throwable)new AssertionError();
          AppMethodBeat.o(117996);
          throw ((Throwable)???);
        }
        ((b)???).KfW.a(this.KfN);
        label198:
        if (i == m) {
          break;
        }
        i += 1;
      }
      this.KfN.close();
      this.KfM.close();
      if (localb != null)
      {
        localObject3 = localb.yp(true);
        ??? = localObject3;
        if (localObject3 != null) {}
      }
      else
      {
        ??? = (i)this.KfM.fLJ();
      }
      Object localObject3 = ???;
      if (??? == null) {
        localObject3 = (i)this.KfN.fLJ();
      }
      if (localObject3 == null)
      {
        if (localb != null) {
          localb.a(c.Kgi);
        }
        if (!ah.fKW()) {
          break label364;
        }
        if ((int)((this.controlState & 0x0) >> 42) != this.cUZ) {
          break label359;
        }
      }
      label359:
      for (int i = k;; i = 0)
      {
        if (i != 0) {
          break label364;
        }
        ??? = (Throwable)new AssertionError();
        AppMethodBeat.o(117996);
        throw ((Throwable)???);
        a((i)localObject3);
        break;
      }
      label364:
      this.parkedWorkersStack = 0L;
      this.controlState = 0L;
    }
    AppMethodBeat.o(117996);
  }
  
  public final void execute(Runnable paramRunnable)
  {
    AppMethodBeat.i(117995);
    a(this, paramRunnable);
    AppMethodBeat.o(117995);
  }
  
  public final void fLY()
  {
    AppMethodBeat.i(190017);
    if (fLZ())
    {
      AppMethodBeat.o(190017);
      return;
    }
    if (a(this))
    {
      AppMethodBeat.o(190017);
      return;
    }
    fLZ();
    AppMethodBeat.o(190017);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118003);
    Object localObject1 = new ArrayList();
    int i3 = this.KfP.length();
    int k = 1;
    int i = 0;
    int j = 0;
    int i1 = 0;
    int n = 0;
    int m = 0;
    if (k < i3)
    {
      Object localObject2 = (b)this.KfP.get(k);
      if (localObject2 == null) {}
      for (;;)
      {
        k += 1;
        break;
        int i4 = ((b)localObject2).KfW.fMj();
        localObject2 = ((b)localObject2).KfX;
        switch (b.ciE[localObject2.ordinal()])
        {
        default: 
        case 1: 
        case 2: 
        case 3: 
        case 4: 
          int i2;
          do
          {
            break;
            m += 1;
            break;
            n += 1;
            ((Collection)localObject1).add(String.valueOf(i4) + "b");
            break;
            i1 += 1;
            ((Collection)localObject1).add(String.valueOf(i4) + "c");
            break;
            i2 = j + 1;
            j = i2;
          } while (i4 <= 0);
          ((Collection)localObject1).add(String.valueOf(i4) + "d");
          j = i2;
          break;
        case 5: 
          i += 1;
        }
      }
    }
    long l = this.controlState;
    localObject1 = this.KfT + '@' + Integer.toHexString(System.identityHashCode(this)) + '[' + "Pool Size {core = " + this.cUZ + ", max = " + this.Izu + "}, Worker States {CPU = " + i1 + ", blocking = " + n + ", parked = " + m + ", dormant = " + j + ", terminated = " + i + "}, running workers queues = " + localObject1 + ", global CPU queue size = " + this.KfM.getSize() + ", global blocking queue size = " + this.KfN.getSize() + ", Control State {created workers= " + (int)(0x1FFFFF & l) + ", blocking tasks = " + (int)((0xFFE00000 & l) >> 21) + ", CPUs acquired = " + (this.cUZ - (int)((0x0 & l) >> 42)) + "}]";
    AppMethodBeat.o(118003);
    return localObject1;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlinx/coroutines/scheduling/CoroutineScheduler$Companion;", "", "()V", "BLOCKING_MASK", "", "BLOCKING_SHIFT", "", "CLAIMED", "CPU_PERMITS_MASK", "CPU_PERMITS_SHIFT", "CREATED_MASK", "MAX_SUPPORTED_POOL_SIZE", "MIN_SUPPORTED_POOL_SIZE", "NOT_IN_STACK", "Lkotlinx/coroutines/internal/Symbol;", "PARKED", "PARKED_INDEX_MASK", "PARKED_VERSION_INC", "PARKED_VERSION_MASK", "TERMINATED", "kotlinx-coroutines-core"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "", "index", "<init>", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;I)V", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;)V", "taskMode", "", "afterTask", "(I)V", "beforeTask", "Lkotlinx/coroutines/scheduling/Task;", "task", "executeTask", "(Lkotlinx/coroutines/scheduling/Task;)V", "", "scanLocalQueue", "findAnyTask", "(Z)Lkotlinx/coroutines/scheduling/Task;", "findTask", "mode", "idleReset", "inStack", "()Z", "upperBound", "nextInt$kotlinx_coroutines_core", "(I)I", "nextInt", "park", "()V", "pollGlobalQueues", "()Lkotlinx/coroutines/scheduling/Task;", "run", "runWorker", "tryAcquireCpuPermit", "tryPark", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "newState", "tryReleaseCpu$kotlinx_coroutines_core", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;)Z", "tryReleaseCpu", "blockingOnly", "trySteal", "tryTerminateWorker", "indexInArray", "I", "getIndexInArray", "()I", "setIndexInArray", "Lkotlinx/coroutines/scheduling/WorkQueue;", "localQueue", "Lkotlinx/coroutines/scheduling/WorkQueue;", "mayHaveLocalTasks", "Z", "", "minDelayUntilStealableTaskNs", "J", "", "nextParkedWorker", "Ljava/lang/Object;", "getNextParkedWorker", "()Ljava/lang/Object;", "setNextParkedWorker", "(Ljava/lang/Object;)V", "rngState", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "getScheduler", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "scheduler", "state", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "terminationDeadline", "kotlinx-coroutines-core", "Ljava/lang/Thread;"})
  public final class b
    extends Thread
  {
    static final AtomicIntegerFieldUpdater KfY;
    public final n KfW;
    public a.c KfX;
    private long KfZ;
    private long Kga;
    private int Kgb;
    public boolean Kgc;
    volatile int indexInArray;
    volatile Object nextParkedWorker;
    volatile int workerCtl;
    
    static
    {
      AppMethodBeat.i(118028);
      KfY = AtomicIntegerFieldUpdater.newUpdater(b.class, "workerCtl");
      AppMethodBeat.o(118028);
    }
    
    private b()
    {
      AppMethodBeat.i(118026);
      setDaemon(true);
      this.KfW = new n();
      this.KfX = a.c.Kgh;
      this.workerCtl = 0;
      this.nextParkedWorker = a.KfU;
      this$1 = c.JhE;
      this.Kgb = c.JhC.nextInt();
      AppMethodBeat.o(118026);
    }
    
    public b()
    {
      this();
      AppMethodBeat.i(118027);
      int i;
      agj(i);
      AppMethodBeat.o(118027);
    }
    
    private void agj(int paramInt)
    {
      AppMethodBeat.i(118015);
      StringBuilder localStringBuilder = new StringBuilder().append(this.Kgd.KfT).append("-worker-");
      if (paramInt == 0) {}
      for (String str = "TERMINATED";; str = String.valueOf(paramInt))
      {
        setName(str);
        this.indexInArray = paramInt;
        AppMethodBeat.o(118015);
        return;
      }
    }
    
    private int agk(int paramInt)
    {
      int i = this.Kgb;
      i ^= i << 13;
      i ^= i >> 17;
      i ^= i << 5;
      this.Kgb = i;
      int j = paramInt - 1;
      if ((j & paramInt) == 0) {
        return i & j;
      }
      return (i & 0x7FFFFFFF) % paramInt;
    }
    
    private final boolean fMc()
    {
      AppMethodBeat.i(118017);
      if (this.KfX == a.c.Kge)
      {
        AppMethodBeat.o(118017);
        return true;
      }
      a locala = this.Kgd;
      long l = locala.controlState;
      if ((int)((0x0 & l) >> 42) == 0) {}
      for (int i = 0;; i = 1)
      {
        if (i == 0) {
          break label88;
        }
        this.KfX = a.c.Kge;
        AppMethodBeat.o(118017);
        return true;
        if (!a.KfQ.compareAndSet(locala, l, l - 4398046511104L)) {
          break;
        }
      }
      label88:
      AppMethodBeat.o(118017);
      return false;
    }
    
    private final void fMd()
    {
      AppMethodBeat.i(190021);
      int j;
      int i;
      if (!fMe())
      {
        ??? = this.Kgd;
        if (this.nextParkedWorker == a.KfU)
        {
          long l;
          int k;
          do
          {
            l = ((a)???).parkedWorkersStack;
            j = (int)(0x1FFFFF & l);
            k = this.indexInArray;
            if (ah.fKW())
            {
              if (k != 0) {}
              for (i = 1; i == 0; i = 0)
              {
                ??? = (Throwable)new AssertionError();
                AppMethodBeat.o(190021);
                throw ((Throwable)???);
              }
            }
            this.nextParkedWorker = ((a)???).KfP.get(j);
          } while (!a.KfO.compareAndSet(???, l, k | 2097152L + l & 0xFFE00000));
        }
        AppMethodBeat.o(190021);
        return;
      }
      if (ah.fKW())
      {
        if (this.KfW.fMj() == 0) {}
        for (i = 1; i == 0; i = 0)
        {
          ??? = (Throwable)new AssertionError();
          AppMethodBeat.o(190021);
          throw ((Throwable)???);
        }
      }
      this.workerCtl = -1;
      while ((fMe()) && (this.Kgd._isTerminated == 0) && (this.KfX != a.c.Kgi))
      {
        a(a.c.Kgg);
        Thread.interrupted();
        if (this.KfZ == 0L) {
          this.KfZ = (System.nanoTime() + this.Kgd.KfS);
        }
        LockSupport.parkNanos(this.Kgd.KfS);
        if (System.nanoTime() - this.KfZ >= 0L)
        {
          this.KfZ = 0L;
          synchronized (this.Kgd.KfP)
          {
            i = this.Kgd._isTerminated;
            if (i == 0)
            {
              i = a.b(this.Kgd);
              j = this.Kgd.cUZ;
              if (i > j)
              {
                boolean bool = KfY.compareAndSet(this, -1, 1);
                if (bool)
                {
                  i = this.indexInArray;
                  agj(0);
                  this.Kgd.a(this, i, 0);
                  Object localObject2 = this.Kgd;
                  j = (int)(a.KfQ.getAndDecrement(localObject2) & 0x1FFFFF);
                  if (j != i)
                  {
                    localObject2 = this.Kgd.KfP.get(j);
                    if (localObject2 == null) {
                      d.g.b.k.fvU();
                    }
                    localObject2 = (b)localObject2;
                    this.Kgd.KfP.set(i, localObject2);
                    ((b)localObject2).agj(i);
                    this.Kgd.a((b)localObject2, j, i);
                  }
                  this.Kgd.KfP.set(j, null);
                  localObject2 = y.JfV;
                  this.KfX = a.c.Kgi;
                }
              }
            }
          }
        }
      }
      AppMethodBeat.o(190021);
    }
    
    private final boolean fMe()
    {
      return this.nextParkedWorker != a.KfU;
    }
    
    private final i fMf()
    {
      AppMethodBeat.i(190024);
      if (agk(2) == 0)
      {
        locali = (i)this.Kgd.KfM.fLJ();
        if (locali != null)
        {
          AppMethodBeat.o(190024);
          return locali;
        }
        locali = (i)this.Kgd.KfN.fLJ();
        AppMethodBeat.o(190024);
        return locali;
      }
      i locali = (i)this.Kgd.KfN.fLJ();
      if (locali != null)
      {
        AppMethodBeat.o(190024);
        return locali;
      }
      locali = (i)this.Kgd.KfM.fLJ();
      AppMethodBeat.o(190024);
      return locali;
    }
    
    private final i yq(boolean paramBoolean)
    {
      AppMethodBeat.i(190023);
      if (paramBoolean)
      {
        if (agk(this.Kgd.cUZ * 2) == 0) {}
        for (int i = 1; i != 0; i = 0)
        {
          locali = fMf();
          if (locali == null) {
            break;
          }
          AppMethodBeat.o(190023);
          return locali;
        }
        locali = this.KfW.fMk();
        if (locali != null)
        {
          AppMethodBeat.o(190023);
          return locali;
        }
        if (i == 0)
        {
          locali = fMf();
          if (locali != null)
          {
            AppMethodBeat.o(190023);
            return locali;
          }
        }
      }
      else
      {
        locali = fMf();
        if (locali != null)
        {
          AppMethodBeat.o(190023);
          return locali;
        }
      }
      i locali = yr(false);
      AppMethodBeat.o(190023);
      return locali;
    }
    
    private final i yr(boolean paramBoolean)
    {
      AppMethodBeat.i(190025);
      Object localObject;
      if (ah.fKW())
      {
        if (this.KfW.fMj() == 0) {}
        for (i = 1; i == 0; i = 0)
        {
          localObject = (Throwable)new AssertionError();
          AppMethodBeat.o(190025);
          throw ((Throwable)localObject);
        }
      }
      int m = a.b(this.Kgd);
      if (m < 2)
      {
        AppMethodBeat.o(190025);
        return null;
      }
      int i = agk(m);
      long l1 = 9223372036854775807L;
      int j = 0;
      if (j < m)
      {
        i += 1;
        if (i <= m) {
          break label307;
        }
        i = 1;
      }
      label307:
      for (;;)
      {
        localObject = (b)this.Kgd.KfP.get(i);
        if ((localObject != null) && (localObject != (b)this))
        {
          if (ah.fKW())
          {
            if (this.KfW.fMj() == 0) {}
            for (int k = 1; k == 0; k = 0)
            {
              localObject = (Throwable)new AssertionError();
              AppMethodBeat.o(190025);
              throw ((Throwable)localObject);
            }
          }
          if (paramBoolean) {}
          for (long l2 = this.KfW.b(((b)localObject).KfW); l2 == -1L; l2 = this.KfW.a(((b)localObject).KfW))
          {
            localObject = this.KfW.fMk();
            AppMethodBeat.o(190025);
            return localObject;
          }
          if (l2 > 0L) {
            l1 = Math.min(l1, l2);
          }
        }
        for (;;)
        {
          j += 1;
          break;
          if (l1 != 9223372036854775807L) {}
          for (;;)
          {
            this.Kga = l1;
            AppMethodBeat.o(190025);
            return null;
            l1 = 0L;
          }
        }
      }
    }
    
    public final boolean a(a.c paramc)
    {
      AppMethodBeat.i(118018);
      a.c localc = this.KfX;
      if (localc == a.c.Kge) {}
      for (boolean bool = true;; bool = false)
      {
        if (bool)
        {
          a locala = this.Kgd;
          a.KfQ.addAndGet(locala, 4398046511104L);
        }
        if (localc != paramc) {
          this.KfX = paramc;
        }
        AppMethodBeat.o(118018);
        return bool;
      }
    }
    
    public final void run()
    {
      AppMethodBeat.i(118019);
      int i = 0;
      while ((this.Kgd._isTerminated == 0) && (this.KfX != a.c.Kgi))
      {
        Object localObject = yp(this.Kgc);
        if (localObject != null)
        {
          this.Kga = 0L;
          int j = ((i)localObject).Kgs.fMh();
          this.KfZ = 0L;
          if (this.KfX == a.c.Kgg)
          {
            if (ah.fKW())
            {
              if (j == 1) {}
              for (i = 1; i == 0; i = 0)
              {
                localObject = (Throwable)new AssertionError();
                AppMethodBeat.o(118019);
                throw ((Throwable)localObject);
              }
            }
            this.KfX = a.c.Kgf;
          }
          if ((j != 0) && (a(a.c.Kgf))) {
            this.Kgd.fLY();
          }
          a.a((i)localObject);
          if (j != 0)
          {
            localObject = this.Kgd;
            a.KfQ.addAndGet(localObject, -2097152L);
            localObject = this.KfX;
            if (localObject != a.c.Kgi)
            {
              if (ah.fKW())
              {
                if (localObject == a.c.Kgf) {}
                for (i = 1; i == 0; i = 0)
                {
                  localObject = (Throwable)new AssertionError();
                  AppMethodBeat.o(118019);
                  throw ((Throwable)localObject);
                }
              }
              this.KfX = a.c.Kgh;
            }
          }
          i = 0;
        }
        else
        {
          this.Kgc = false;
          if (this.Kga != 0L)
          {
            if (i == 0)
            {
              i = 1;
            }
            else
            {
              a(a.c.Kgg);
              Thread.interrupted();
              LockSupport.parkNanos(this.Kga);
              this.Kga = 0L;
              i = 0;
            }
          }
          else {
            fMd();
          }
        }
      }
      a(a.c.Kgi);
      AppMethodBeat.o(118019);
    }
    
    public final i yp(boolean paramBoolean)
    {
      AppMethodBeat.i(190022);
      Object localObject1;
      if (fMc())
      {
        localObject1 = yq(paramBoolean);
        AppMethodBeat.o(190022);
        return localObject1;
      }
      if (paramBoolean)
      {
        localObject2 = this.KfW.fMk();
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = (i)this.Kgd.KfN.fLJ();
      }
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = yr(true);
      }
      AppMethodBeat.o(190022);
      return localObject2;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "", "(Ljava/lang/String;I)V", "CPU_ACQUIRED", "BLOCKING", "PARKING", "DORMANT", "TERMINATED", "kotlinx-coroutines-core"})
  public static enum c
  {
    static
    {
      AppMethodBeat.i(118012);
      c localc1 = new c("CPU_ACQUIRED", 0);
      Kge = localc1;
      c localc2 = new c("BLOCKING", 1);
      Kgf = localc2;
      c localc3 = new c("PARKING", 2);
      Kgg = localc3;
      c localc4 = new c("DORMANT", 3);
      Kgh = localc4;
      c localc5 = new c("TERMINATED", 4);
      Kgi = localc5;
      Kgj = new c[] { localc1, localc2, localc3, localc4, localc5 };
      AppMethodBeat.o(118012);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.c.a
 * JD-Core Version:    0.7.0.1
 */