package kotlinx.coroutines.b;

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
import kotlinx.coroutines.al;
import kotlinx.coroutines.internal.s;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "", "corePoolSize", "maxPoolSize", "", "idleWorkerKeepAliveNs", "", "schedulerName", "<init>", "(IIJLjava/lang/String;)V", "Lkotlinx/coroutines/scheduling/Task;", "task", "", "addToGlobalQueue", "(Lkotlinx/coroutines/scheduling/Task;)Z", "state", "availableCpuPermits", "(J)I", "blockingTasks", "", "close", "()V", "createNewWorker", "()I", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Lkotlinx/coroutines/scheduling/TaskContext;", "taskContext", "createTask$kotlinx_coroutines_core", "(Ljava/lang/Runnable;Lkotlinx/coroutines/scheduling/TaskContext;)Lkotlinx/coroutines/scheduling/Task;", "createTask", "createdWorkers", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "currentWorker", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "decrementBlockingTasks", "decrementCreatedWorkers", "tailDispatch", "dispatch", "(Ljava/lang/Runnable;Lkotlinx/coroutines/scheduling/TaskContext;Z)V", "command", "execute", "(Ljava/lang/Runnable;)V", "incrementBlockingTasks", "()J", "incrementCreatedWorkers", "worker", "parkedWorkersStackNextIndex", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;)I", "parkedWorkersStackPop", "parkedWorkersStackPush$kotlinx_coroutines_core", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;)Z", "parkedWorkersStackPush", "oldIndex", "newIndex", "parkedWorkersStackTopUpdate$kotlinx_coroutines_core", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;II)V", "parkedWorkersStackTopUpdate", "releaseCpuPermit", "runSafely", "(Lkotlinx/coroutines/scheduling/Task;)V", "timeout", "shutdown", "(J)V", "skipUnpark", "signalBlockingWork", "(Z)V", "signalCpuWork$kotlinx_coroutines_core", "signalCpuWork", "toString", "()Ljava/lang/String;", "tryAcquireCpuPermit", "()Z", "tryCreateWorker", "(J)Z", "tryUnpark", "submitToLocalQueue", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;Lkotlinx/coroutines/scheduling/Task;Z)Lkotlinx/coroutines/scheduling/Task;", "getAvailableCpuPermits", "I", "getCreatedWorkers", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalBlockingQueue", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalCpuQueue", "J", "isTerminated", "Ljava/lang/String;", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "workers", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "Companion", "Worker", "WorkerState", "kotlinx-coroutines-core", "Ljava/util/concurrent/Executor;", "Ljava/io/Closeable;"})
public final class a
  implements Closeable, Executor
{
  public static final s LTC;
  public static final a LTD;
  static final AtomicLongFieldUpdater LTw;
  static final AtomicLongFieldUpdater LTy;
  private static final AtomicIntegerFieldUpdater LTz;
  public final int Kbd;
  public final long LTA;
  public final String LTB;
  public final e LTu;
  public final e LTv;
  public final AtomicReferenceArray<b> LTx;
  volatile int _isTerminated;
  public final int cSv;
  volatile long controlState;
  volatile long parkedWorkersStack;
  
  static
  {
    AppMethodBeat.i(118011);
    LTD = new a((byte)0);
    LTC = new s("NOT_IN_STACK");
    LTw = AtomicLongFieldUpdater.newUpdater(a.class, "parkedWorkersStack");
    LTy = AtomicLongFieldUpdater.newUpdater(a.class, "controlState");
    LTz = AtomicIntegerFieldUpdater.newUpdater(a.class, "_isTerminated");
    AppMethodBeat.o(118011);
  }
  
  public a(int paramInt1, int paramInt2, long paramLong, String paramString)
  {
    AppMethodBeat.i(118005);
    this.cSv = paramInt1;
    this.Kbd = paramInt2;
    this.LTA = paramLong;
    this.LTB = paramString;
    if (this.cSv > 0) {}
    for (paramInt1 = 1; paramInt1 == 0; paramInt1 = 0)
    {
      paramString = (Throwable)new IllegalArgumentException(("Core pool size " + this.cSv + " should be at least 1").toString());
      AppMethodBeat.o(118005);
      throw paramString;
    }
    if (this.Kbd >= this.cSv) {}
    for (paramInt1 = 1; paramInt1 == 0; paramInt1 = 0)
    {
      paramString = (Throwable)new IllegalArgumentException(("Max pool size " + this.Kbd + " should be greater than or equals to core pool size " + this.cSv).toString());
      AppMethodBeat.o(118005);
      throw paramString;
    }
    if (this.Kbd <= 2097150) {}
    for (paramInt1 = 1; paramInt1 == 0; paramInt1 = 0)
    {
      paramString = (Throwable)new IllegalArgumentException(("Max pool size " + this.Kbd + " should not exceed maximal supported number of threads 2097150").toString());
      AppMethodBeat.o(118005);
      throw paramString;
    }
    if (this.LTA > 0L) {}
    for (paramInt1 = i; paramInt1 == 0; paramInt1 = 0)
    {
      paramString = (Throwable)new IllegalArgumentException(("Idle worker keep alive time " + this.LTA + " must be positive").toString());
      AppMethodBeat.o(118005);
      throw paramString;
    }
    this.LTu = new e();
    this.LTv = new e();
    this.parkedWorkersStack = 0L;
    this.LTx = new AtomicReferenceArray(this.Kbd + 1);
    this.controlState = (this.cSv << 42);
    this._isTerminated = 0;
    AppMethodBeat.o(118005);
  }
  
  private final boolean CC(long paramLong)
  {
    AppMethodBeat.i(191130);
    if (h.la((int)(0x1FFFFF & paramLong) - (int)((0xFFE00000 & paramLong) >> 21), 0) < this.cSv)
    {
      int i = geQ();
      if ((i == 1) && (this.cSv > 1)) {
        geQ();
      }
      if (i > 0)
      {
        AppMethodBeat.o(191130);
        return true;
      }
    }
    AppMethodBeat.o(191130);
    return false;
  }
  
  private static int a(b paramb)
  {
    for (paramb = paramb.nextParkedWorker;; paramb = paramb.nextParkedWorker)
    {
      if (paramb == LTC) {
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
    long l = l.LUh.nanoTime();
    if ((paramRunnable instanceof i))
    {
      ((i)paramRunnable).LUb = l;
      ((i)paramRunnable).LUc = paramj;
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
  
  private final b geN()
  {
    AppMethodBeat.i(117994);
    long l;
    int i;
    b localb;
    do
    {
      l = this.parkedWorkersStack;
      i = (int)(0x1FFFFF & l);
      localb = (b)this.LTx.get(i);
      if (localb == null)
      {
        AppMethodBeat.o(117994);
        return null;
      }
      i = a(localb);
    } while ((i < 0) || (!LTw.compareAndSet(this, l, 0xFFE00000 & 2097152L + l | i)));
    localb.nextParkedWorker = LTC;
    AppMethodBeat.o(117994);
    return localb;
  }
  
  private final boolean geP()
  {
    AppMethodBeat.i(118001);
    b localb;
    do
    {
      localb = geN();
      if (localb == null)
      {
        AppMethodBeat.o(118001);
        return false;
      }
    } while (!b.LTH.compareAndSet(localb, -1, 0));
    LockSupport.unpark((Thread)localb);
    AppMethodBeat.o(118001);
    return true;
  }
  
  private final int geQ()
  {
    int j = 0;
    AppMethodBeat.i(118002);
    int k;
    int m;
    for (;;)
    {
      synchronized (this.LTx)
      {
        i = this._isTerminated;
        if (i != 0)
        {
          AppMethodBeat.o(118002);
          return -1;
        }
        long l = this.controlState;
        i = (int)(l & 0x1FFFFF);
        k = h.la(i - (int)((l & 0xFFE00000) >> 21), 0);
        m = this.cSv;
        if (k >= m)
        {
          AppMethodBeat.o(118002);
          return 0;
        }
        m = this.Kbd;
        if (i >= m)
        {
          AppMethodBeat.o(118002);
          return 0;
        }
        m = (int)(this.controlState & 0x1FFFFF) + 1;
        if ((m > 0) && (this.LTx.get(m) == null))
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
    this.LTx.set(m, localObject2);
    int i = j;
    if (m == (int)(LTy.incrementAndGet(this) & 0x1FFFFF)) {
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
  
  private final b geR()
  {
    AppMethodBeat.i(191132);
    Thread localThread = Thread.currentThread();
    Object localObject = localThread;
    if (!(localThread instanceof b)) {
      localObject = null;
    }
    localObject = (b)localObject;
    if (localObject != null)
    {
      if (d.g.b.k.g(((b)localObject).LTM, (a)this))
      {
        AppMethodBeat.o(191132);
        return localObject;
      }
      AppMethodBeat.o(191132);
      return null;
    }
    AppMethodBeat.o(191132);
    return null;
  }
  
  public final void a(Runnable paramRunnable, j paramj, boolean paramBoolean)
  {
    int j = 1;
    AppMethodBeat.i(117997);
    paramj = a(paramRunnable, paramj);
    b localb = geR();
    int i;
    if (localb == null)
    {
      paramRunnable = paramj;
      if (paramRunnable == null) {
        break label193;
      }
      if (paramRunnable.LUc.geX() != 1) {
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
    for (boolean bool = this.LTv.fV(paramRunnable);; bool = this.LTu.fV(paramRunnable))
    {
      if (bool) {
        break label193;
      }
      paramRunnable = (Throwable)new RejectedExecutionException(this.LTB + " was terminated");
      AppMethodBeat.o(117997);
      throw paramRunnable;
      if (localb.LTG == c.LTS)
      {
        paramRunnable = paramj;
        break;
      }
      if ((paramj.LUc.geX() == 0) && (localb.LTG == c.LTO))
      {
        paramRunnable = paramj;
        break;
      }
      localb.LTL = true;
      paramRunnable = localb.LTF.a(paramj, paramBoolean);
      break;
      i = 0;
      break label48;
    }
    label193:
    if ((paramBoolean) && (localb != null)) {
      i = j;
    }
    while (paramj.LUc.geX() == 0) {
      if (i != 0)
      {
        AppMethodBeat.o(117997);
        return;
        i = 0;
      }
      else
      {
        geO();
        AppMethodBeat.o(117997);
        return;
      }
    }
    long l = LTy.addAndGet(this, 2097152L);
    if ((i == 0) && (!geP()) && (!CC(l))) {
      geP();
    }
    AppMethodBeat.o(117997);
  }
  
  public final void a(b paramb, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(191128);
    for (;;)
    {
      long l = this.parkedWorkersStack;
      int i = (int)(0x1FFFFF & l);
      if (i == paramInt1) {
        if (paramInt2 == 0) {
          i = a(paramb);
        }
      }
      while ((i >= 0) && (LTw.compareAndSet(this, l, 2097152L + l & 0xFFE00000 | i)))
      {
        AppMethodBeat.o(191128);
        return;
        i = paramInt2;
      }
    }
  }
  
  public final void close()
  {
    int k = 1;
    AppMethodBeat.i(117996);
    if (LTz.compareAndSet(this, 0, 1))
    {
      b localb = geR();
      for (;;)
      {
        int m;
        synchronized (this.LTx)
        {
          long l = this.controlState;
          m = (int)(l & 0x1FFFFF);
          if (m <= 0) {
            break;
          }
          i = 1;
          ??? = this.LTx.get(i);
          if (??? == null) {
            d.g.b.k.fOy();
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
        if (localObject3 == c.LTS) {}
        for (int j = 1; j == 0; j = 0)
        {
          ??? = (Throwable)new AssertionError();
          AppMethodBeat.o(117996);
          throw ((Throwable)???);
        }
        ((b)???).LTF.a(this.LTv);
        label198:
        if (i == m) {
          break;
        }
        i += 1;
      }
      this.LTv.close();
      this.LTu.close();
      if (localb != null)
      {
        localObject3 = localb.zH(true);
        ??? = localObject3;
        if (localObject3 != null) {}
      }
      else
      {
        ??? = (i)this.LTu.geu();
      }
      Object localObject3 = ???;
      if (??? == null) {
        localObject3 = (i)this.LTv.geu();
      }
      if (localObject3 == null)
      {
        if (localb != null) {
          localb.a(c.LTS);
        }
        if (!al.gdD()) {
          break label364;
        }
        if ((int)((this.controlState & 0x0) >> 42) != this.cSv) {
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
  
  public final void geO()
  {
    AppMethodBeat.i(191129);
    if (geP())
    {
      AppMethodBeat.o(191129);
      return;
    }
    if (a(this))
    {
      AppMethodBeat.o(191129);
      return;
    }
    geP();
    AppMethodBeat.o(191129);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118003);
    Object localObject1 = new ArrayList();
    int i3 = this.LTx.length();
    int k = 1;
    int i = 0;
    int j = 0;
    int i1 = 0;
    int n = 0;
    int m = 0;
    if (k < i3)
    {
      Object localObject2 = (b)this.LTx.get(k);
      if (localObject2 == null) {}
      for (;;)
      {
        k += 1;
        break;
        int i4 = ((b)localObject2).LTF.geZ();
        localObject2 = ((b)localObject2).LTG;
        switch (b.cfA[localObject2.ordinal()])
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
    localObject1 = this.LTB + '@' + Integer.toHexString(System.identityHashCode(this)) + '[' + "Pool Size {core = " + this.cSv + ", max = " + this.Kbd + "}, Worker States {CPU = " + i1 + ", blocking = " + n + ", parked = " + m + ", dormant = " + j + ", terminated = " + i + "}, running workers queues = " + localObject1 + ", global CPU queue size = " + this.LTu.getSize() + ", global blocking queue size = " + this.LTv.getSize() + ", Control State {created workers= " + (int)(0x1FFFFF & l) + ", blocking tasks = " + (int)((0xFFE00000 & l) >> 21) + ", CPUs acquired = " + (this.cSv - (int)((0x0 & l) >> 42)) + "}]";
    AppMethodBeat.o(118003);
    return localObject1;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlinx/coroutines/scheduling/CoroutineScheduler$Companion;", "", "()V", "BLOCKING_MASK", "", "BLOCKING_SHIFT", "", "CLAIMED", "CPU_PERMITS_MASK", "CPU_PERMITS_SHIFT", "CREATED_MASK", "MAX_SUPPORTED_POOL_SIZE", "MIN_SUPPORTED_POOL_SIZE", "NOT_IN_STACK", "Lkotlinx/coroutines/internal/Symbol;", "PARKED", "PARKED_INDEX_MASK", "PARKED_VERSION_INC", "PARKED_VERSION_MASK", "TERMINATED", "kotlinx-coroutines-core"})
  public static final class a {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "", "index", "<init>", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;I)V", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;)V", "taskMode", "", "afterTask", "(I)V", "beforeTask", "Lkotlinx/coroutines/scheduling/Task;", "task", "executeTask", "(Lkotlinx/coroutines/scheduling/Task;)V", "", "scanLocalQueue", "findAnyTask", "(Z)Lkotlinx/coroutines/scheduling/Task;", "findTask", "mode", "idleReset", "inStack", "()Z", "upperBound", "nextInt$kotlinx_coroutines_core", "(I)I", "nextInt", "park", "()V", "pollGlobalQueues", "()Lkotlinx/coroutines/scheduling/Task;", "run", "runWorker", "tryAcquireCpuPermit", "tryPark", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "newState", "tryReleaseCpu$kotlinx_coroutines_core", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;)Z", "tryReleaseCpu", "blockingOnly", "trySteal", "tryTerminateWorker", "indexInArray", "I", "getIndexInArray", "()I", "setIndexInArray", "Lkotlinx/coroutines/scheduling/WorkQueue;", "localQueue", "Lkotlinx/coroutines/scheduling/WorkQueue;", "mayHaveLocalTasks", "Z", "", "minDelayUntilStealableTaskNs", "J", "", "nextParkedWorker", "Ljava/lang/Object;", "getNextParkedWorker", "()Ljava/lang/Object;", "setNextParkedWorker", "(Ljava/lang/Object;)V", "rngState", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "getScheduler", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "scheduler", "state", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "terminationDeadline", "kotlinx-coroutines-core", "Ljava/lang/Thread;"})
  public final class b
    extends Thread
  {
    static final AtomicIntegerFieldUpdater LTH;
    public final n LTF;
    public a.c LTG;
    private long LTI;
    private long LTJ;
    private int LTK;
    public boolean LTL;
    volatile int indexInArray;
    volatile Object nextParkedWorker;
    volatile int workerCtl;
    
    static
    {
      AppMethodBeat.i(118028);
      LTH = AtomicIntegerFieldUpdater.newUpdater(b.class, "workerCtl");
      AppMethodBeat.o(118028);
    }
    
    private b()
    {
      AppMethodBeat.i(118026);
      setDaemon(true);
      this.LTF = new n();
      this.LTG = a.c.LTQ;
      this.workerCtl = 0;
      this.nextParkedWorker = a.LTC;
      this$1 = c.KUY;
      this.LTK = c.KUW.nextInt();
      AppMethodBeat.o(118026);
    }
    
    public b()
    {
      this();
      AppMethodBeat.i(118027);
      int i;
      ajf(i);
      AppMethodBeat.o(118027);
    }
    
    private void ajf(int paramInt)
    {
      AppMethodBeat.i(118015);
      StringBuilder localStringBuilder = new StringBuilder().append(this.LTM.LTB).append("-worker-");
      if (paramInt == 0) {}
      for (String str = "TERMINATED";; str = String.valueOf(paramInt))
      {
        setName(str);
        this.indexInArray = paramInt;
        AppMethodBeat.o(118015);
        return;
      }
    }
    
    private int ajg(int paramInt)
    {
      int i = this.LTK;
      i ^= i << 13;
      i ^= i >> 17;
      i ^= i << 5;
      this.LTK = i;
      int j = paramInt - 1;
      if ((j & paramInt) == 0) {
        return i & j;
      }
      return (i & 0x7FFFFFFF) % paramInt;
    }
    
    private final boolean geS()
    {
      AppMethodBeat.i(118017);
      if (this.LTG == a.c.LTN)
      {
        AppMethodBeat.o(118017);
        return true;
      }
      a locala = this.LTM;
      long l = locala.controlState;
      if ((int)((0x0 & l) >> 42) == 0) {}
      for (int i = 0;; i = 1)
      {
        if (i == 0) {
          break label88;
        }
        this.LTG = a.c.LTN;
        AppMethodBeat.o(118017);
        return true;
        if (!a.LTy.compareAndSet(locala, l, l - 4398046511104L)) {
          break;
        }
      }
      label88:
      AppMethodBeat.o(118017);
      return false;
    }
    
    private final void geT()
    {
      AppMethodBeat.i(191133);
      int j;
      int i;
      if (!geU())
      {
        ??? = this.LTM;
        if (this.nextParkedWorker == a.LTC)
        {
          long l;
          int k;
          do
          {
            l = ((a)???).parkedWorkersStack;
            j = (int)(0x1FFFFF & l);
            k = this.indexInArray;
            if (al.gdD())
            {
              if (k != 0) {}
              for (i = 1; i == 0; i = 0)
              {
                ??? = (Throwable)new AssertionError();
                AppMethodBeat.o(191133);
                throw ((Throwable)???);
              }
            }
            this.nextParkedWorker = ((a)???).LTx.get(j);
          } while (!a.LTw.compareAndSet(???, l, k | 2097152L + l & 0xFFE00000));
        }
        AppMethodBeat.o(191133);
        return;
      }
      if (al.gdD())
      {
        if (this.LTF.geZ() == 0) {}
        for (i = 1; i == 0; i = 0)
        {
          ??? = (Throwable)new AssertionError();
          AppMethodBeat.o(191133);
          throw ((Throwable)???);
        }
      }
      this.workerCtl = -1;
      while ((geU()) && (this.LTM._isTerminated == 0) && (this.LTG != a.c.LTS))
      {
        a(a.c.LTP);
        Thread.interrupted();
        if (this.LTI == 0L) {
          this.LTI = (System.nanoTime() + this.LTM.LTA);
        }
        LockSupport.parkNanos(this.LTM.LTA);
        if (System.nanoTime() - this.LTI >= 0L)
        {
          this.LTI = 0L;
          synchronized (this.LTM.LTx)
          {
            i = this.LTM._isTerminated;
            if (i == 0)
            {
              i = a.b(this.LTM);
              j = this.LTM.cSv;
              if (i > j)
              {
                boolean bool = LTH.compareAndSet(this, -1, 1);
                if (bool)
                {
                  i = this.indexInArray;
                  ajf(0);
                  this.LTM.a(this, i, 0);
                  Object localObject2 = this.LTM;
                  j = (int)(a.LTy.getAndDecrement(localObject2) & 0x1FFFFF);
                  if (j != i)
                  {
                    localObject2 = this.LTM.LTx.get(j);
                    if (localObject2 == null) {
                      d.g.b.k.fOy();
                    }
                    localObject2 = (b)localObject2;
                    this.LTM.LTx.set(i, localObject2);
                    ((b)localObject2).ajf(i);
                    this.LTM.a((b)localObject2, j, i);
                  }
                  this.LTM.LTx.set(j, null);
                  localObject2 = y.KTp;
                  this.LTG = a.c.LTS;
                }
              }
            }
          }
        }
      }
      AppMethodBeat.o(191133);
    }
    
    private final boolean geU()
    {
      return this.nextParkedWorker != a.LTC;
    }
    
    private final i geV()
    {
      AppMethodBeat.i(191136);
      if (ajg(2) == 0)
      {
        locali = (i)this.LTM.LTu.geu();
        if (locali != null)
        {
          AppMethodBeat.o(191136);
          return locali;
        }
        locali = (i)this.LTM.LTv.geu();
        AppMethodBeat.o(191136);
        return locali;
      }
      i locali = (i)this.LTM.LTv.geu();
      if (locali != null)
      {
        AppMethodBeat.o(191136);
        return locali;
      }
      locali = (i)this.LTM.LTu.geu();
      AppMethodBeat.o(191136);
      return locali;
    }
    
    private final i zI(boolean paramBoolean)
    {
      AppMethodBeat.i(191135);
      if (paramBoolean)
      {
        if (ajg(this.LTM.cSv * 2) == 0) {}
        for (int i = 1; i != 0; i = 0)
        {
          locali = geV();
          if (locali == null) {
            break;
          }
          AppMethodBeat.o(191135);
          return locali;
        }
        locali = this.LTF.gfa();
        if (locali != null)
        {
          AppMethodBeat.o(191135);
          return locali;
        }
        if (i == 0)
        {
          locali = geV();
          if (locali != null)
          {
            AppMethodBeat.o(191135);
            return locali;
          }
        }
      }
      else
      {
        locali = geV();
        if (locali != null)
        {
          AppMethodBeat.o(191135);
          return locali;
        }
      }
      i locali = zJ(false);
      AppMethodBeat.o(191135);
      return locali;
    }
    
    private final i zJ(boolean paramBoolean)
    {
      AppMethodBeat.i(191137);
      Object localObject;
      if (al.gdD())
      {
        if (this.LTF.geZ() == 0) {}
        for (i = 1; i == 0; i = 0)
        {
          localObject = (Throwable)new AssertionError();
          AppMethodBeat.o(191137);
          throw ((Throwable)localObject);
        }
      }
      int m = a.b(this.LTM);
      if (m < 2)
      {
        AppMethodBeat.o(191137);
        return null;
      }
      int i = ajg(m);
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
        localObject = (b)this.LTM.LTx.get(i);
        if ((localObject != null) && (localObject != (b)this))
        {
          if (al.gdD())
          {
            if (this.LTF.geZ() == 0) {}
            for (int k = 1; k == 0; k = 0)
            {
              localObject = (Throwable)new AssertionError();
              AppMethodBeat.o(191137);
              throw ((Throwable)localObject);
            }
          }
          if (paramBoolean) {}
          for (long l2 = this.LTF.b(((b)localObject).LTF); l2 == -1L; l2 = this.LTF.a(((b)localObject).LTF))
          {
            localObject = this.LTF.gfa();
            AppMethodBeat.o(191137);
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
            this.LTJ = l1;
            AppMethodBeat.o(191137);
            return null;
            l1 = 0L;
          }
        }
      }
    }
    
    public final boolean a(a.c paramc)
    {
      AppMethodBeat.i(118018);
      a.c localc = this.LTG;
      if (localc == a.c.LTN) {}
      for (boolean bool = true;; bool = false)
      {
        if (bool)
        {
          a locala = this.LTM;
          a.LTy.addAndGet(locala, 4398046511104L);
        }
        if (localc != paramc) {
          this.LTG = paramc;
        }
        AppMethodBeat.o(118018);
        return bool;
      }
    }
    
    public final void run()
    {
      AppMethodBeat.i(118019);
      int i = 0;
      while ((this.LTM._isTerminated == 0) && (this.LTG != a.c.LTS))
      {
        Object localObject = zH(this.LTL);
        if (localObject != null)
        {
          this.LTJ = 0L;
          int j = ((i)localObject).LUc.geX();
          this.LTI = 0L;
          if (this.LTG == a.c.LTP)
          {
            if (al.gdD())
            {
              if (j == 1) {}
              for (i = 1; i == 0; i = 0)
              {
                localObject = (Throwable)new AssertionError();
                AppMethodBeat.o(118019);
                throw ((Throwable)localObject);
              }
            }
            this.LTG = a.c.LTO;
          }
          if ((j != 0) && (a(a.c.LTO))) {
            this.LTM.geO();
          }
          a.a((i)localObject);
          if (j != 0)
          {
            localObject = this.LTM;
            a.LTy.addAndGet(localObject, -2097152L);
            localObject = this.LTG;
            if (localObject != a.c.LTS)
            {
              if (al.gdD())
              {
                if (localObject == a.c.LTO) {}
                for (i = 1; i == 0; i = 0)
                {
                  localObject = (Throwable)new AssertionError();
                  AppMethodBeat.o(118019);
                  throw ((Throwable)localObject);
                }
              }
              this.LTG = a.c.LTQ;
            }
          }
          i = 0;
        }
        else
        {
          this.LTL = false;
          if (this.LTJ != 0L)
          {
            if (i == 0)
            {
              i = 1;
            }
            else
            {
              a(a.c.LTP);
              Thread.interrupted();
              LockSupport.parkNanos(this.LTJ);
              this.LTJ = 0L;
              i = 0;
            }
          }
          else {
            geT();
          }
        }
      }
      a(a.c.LTS);
      AppMethodBeat.o(118019);
    }
    
    public final i zH(boolean paramBoolean)
    {
      AppMethodBeat.i(191134);
      Object localObject1;
      if (geS())
      {
        localObject1 = zI(paramBoolean);
        AppMethodBeat.o(191134);
        return localObject1;
      }
      if (paramBoolean)
      {
        localObject2 = this.LTF.gfa();
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = (i)this.LTM.LTv.geu();
      }
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = zJ(true);
      }
      AppMethodBeat.o(191134);
      return localObject2;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "", "(Ljava/lang/String;I)V", "CPU_ACQUIRED", "BLOCKING", "PARKING", "DORMANT", "TERMINATED", "kotlinx-coroutines-core"})
  public static enum c
  {
    static
    {
      AppMethodBeat.i(118012);
      c localc1 = new c("CPU_ACQUIRED", 0);
      LTN = localc1;
      c localc2 = new c("BLOCKING", 1);
      LTO = localc2;
      c localc3 = new c("PARKING", 2);
      LTP = localc3;
      c localc4 = new c("DORMANT", 3);
      LTQ = localc4;
      c localc5 = new c("TERMINATED", 4);
      LTS = localc5;
      LTT = new c[] { localc1, localc2, localc3, localc4, localc5 };
      AppMethodBeat.o(118012);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.b.a
 * JD-Core Version:    0.7.0.1
 */