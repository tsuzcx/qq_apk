package kotlinx.coroutines.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.j.c;
import kotlinx.coroutines.au;
import kotlinx.coroutines.internal.ac;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "", "corePoolSize", "maxPoolSize", "", "idleWorkerKeepAliveNs", "", "schedulerName", "<init>", "(IIJLjava/lang/String;)V", "Lkotlinx/coroutines/scheduling/Task;", "task", "", "addToGlobalQueue", "(Lkotlinx/coroutines/scheduling/Task;)Z", "state", "availableCpuPermits", "(J)I", "blockingTasks", "", "close", "()V", "createNewWorker", "()I", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Lkotlinx/coroutines/scheduling/TaskContext;", "taskContext", "createTask", "(Ljava/lang/Runnable;Lkotlinx/coroutines/scheduling/TaskContext;)Lkotlinx/coroutines/scheduling/Task;", "createdWorkers", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "currentWorker", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "decrementBlockingTasks", "decrementCreatedWorkers", "tailDispatch", "dispatch", "(Ljava/lang/Runnable;Lkotlinx/coroutines/scheduling/TaskContext;Z)V", "command", "execute", "(Ljava/lang/Runnable;)V", "incrementBlockingTasks", "()J", "incrementCreatedWorkers", "worker", "parkedWorkersStackNextIndex", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;)I", "parkedWorkersStackPop", "parkedWorkersStackPush", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;)Z", "oldIndex", "newIndex", "parkedWorkersStackTopUpdate", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;II)V", "releaseCpuPermit", "runSafely", "(Lkotlinx/coroutines/scheduling/Task;)V", "timeout", "shutdown", "(J)V", "skipUnpark", "signalBlockingWork", "(Z)V", "signalCpuWork", "toString", "()Ljava/lang/String;", "tryAcquireCpuPermit", "()Z", "tryCreateWorker", "(J)Z", "tryUnpark", "submitToLocalQueue", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;Lkotlinx/coroutines/scheduling/Task;Z)Lkotlinx/coroutines/scheduling/Task;", "getAvailableCpuPermits", "I", "getCreatedWorkers", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalBlockingQueue", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalCpuQueue", "J", "isTerminated", "Ljava/lang/String;", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "workers", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "Companion", "Worker", "WorkerState", "kotlinx-coroutines-core", "Ljava/util/concurrent/Executor;", "Ljava/io/Closeable;"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements Closeable, Executor
{
  public static final a.a ajBc;
  public static final ac ajBl;
  public final int ahBX;
  public final long ajBd;
  public final String ajBe;
  public final d ajBf;
  public final d ajBg;
  public final AtomicReferenceArray<c> ajBi;
  public final int hsI;
  
  static
  {
    AppMethodBeat.i(118011);
    ajBc = new a.a((byte)0);
    ajBl = new ac("NOT_IN_STACK");
    ajBh = AtomicLongFieldUpdater.newUpdater(a.class, "parkedWorkersStack");
    ajBj = AtomicLongFieldUpdater.newUpdater(a.class, "controlState");
    ajBk = AtomicIntegerFieldUpdater.newUpdater(a.class, "_isTerminated");
    AppMethodBeat.o(118011);
  }
  
  public a(int paramInt1, int paramInt2, long paramLong, String paramString)
  {
    AppMethodBeat.i(118005);
    this.hsI = paramInt1;
    this.ahBX = paramInt2;
    this.ajBd = paramLong;
    this.ajBe = paramString;
    if (this.hsI > 0) {}
    for (paramInt1 = 1; paramInt1 == 0; paramInt1 = 0)
    {
      paramString = (Throwable)new IllegalArgumentException(("Core pool size " + this.hsI + " should be at least 1").toString());
      AppMethodBeat.o(118005);
      throw paramString;
    }
    if (this.ahBX >= this.hsI) {}
    for (paramInt1 = 1; paramInt1 == 0; paramInt1 = 0)
    {
      paramString = (Throwable)new IllegalArgumentException(("Max pool size " + this.ahBX + " should be greater than or equals to core pool size " + this.hsI).toString());
      AppMethodBeat.o(118005);
      throw paramString;
    }
    if (this.ahBX <= 2097150) {}
    for (paramInt1 = 1; paramInt1 == 0; paramInt1 = 0)
    {
      paramString = (Throwable)new IllegalArgumentException(("Max pool size " + this.ahBX + " should not exceed maximal supported number of threads 2097150").toString());
      AppMethodBeat.o(118005);
      throw paramString;
    }
    if (this.ajBd > 0L) {}
    for (paramInt1 = i; paramInt1 == 0; paramInt1 = 0)
    {
      paramString = (Throwable)new IllegalArgumentException(("Idle worker keep alive time " + this.ajBd + " must be positive").toString());
      AppMethodBeat.o(118005);
      throw paramString;
    }
    this.ajBf = new d();
    this.ajBg = new d();
    this.parkedWorkersStack = 0L;
    this.ajBi = new AtomicReferenceArray(this.ahBX + 1);
    this.controlState = (this.hsI << 42);
    this._isTerminated = 0;
    AppMethodBeat.o(118005);
  }
  
  private final boolean BR(long paramLong)
  {
    AppMethodBeat.i(189495);
    if (kotlin.k.k.qu((int)(0x1FFFFF & paramLong) - (int)((0xFFE00000 & paramLong) >> 21), 0) < this.hsI)
    {
      int i = kEw();
      if ((i == 1) && (this.hsI > 1)) {
        kEw();
      }
      if (i > 0)
      {
        AppMethodBeat.o(189495);
        return true;
      }
    }
    AppMethodBeat.o(189495);
    return false;
  }
  
  private static int a(c paramc)
  {
    for (paramc = paramc.nextParkedWorker;; paramc = paramc.nextParkedWorker)
    {
      if (paramc == ajBl) {
        return -1;
      }
      if (paramc == null) {
        return 0;
      }
      paramc = (c)paramc;
      int i = paramc.indexInArray;
      if (i != 0) {
        return i;
      }
    }
  }
  
  public static i a(Runnable paramRunnable, j paramj)
  {
    AppMethodBeat.i(189486);
    long l = l.ajBM.nanoTime();
    if ((paramRunnable instanceof i))
    {
      ((i)paramRunnable).ajBH = l;
      ((i)paramRunnable).ajBI = paramj;
      paramRunnable = (i)paramRunnable;
      AppMethodBeat.o(189486);
      return paramRunnable;
    }
    paramRunnable = (i)new k(paramRunnable, l, paramj);
    AppMethodBeat.o(189486);
    return paramRunnable;
  }
  
  public static void a(i parami)
  {
    AppMethodBeat.i(118004);
    try
    {
      parami.run();
      AppMethodBeat.o(118004);
      return;
    }
    finally
    {
      try
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
  }
  
  private final c kEt()
  {
    AppMethodBeat.i(117994);
    long l;
    int i;
    c localc;
    do
    {
      l = this.parkedWorkersStack;
      i = (int)(0x1FFFFF & l);
      localc = (c)this.ajBi.get(i);
      if (localc == null)
      {
        AppMethodBeat.o(117994);
        return null;
      }
      i = a(localc);
    } while ((i < 0) || (!ajBh.compareAndSet(this, l, 0xFFE00000 & 2097152L + l | i)));
    localc.nextParkedWorker = ajBl;
    AppMethodBeat.o(117994);
    return localc;
  }
  
  private final boolean kEv()
  {
    AppMethodBeat.i(118001);
    c localc;
    do
    {
      localc = kEt();
      if (localc == null)
      {
        AppMethodBeat.o(118001);
        return false;
      }
    } while (!c.ajBo.compareAndSet(localc, -1, 0));
    LockSupport.unpark((Thread)localc);
    AppMethodBeat.o(118001);
    return true;
  }
  
  private final int kEw()
  {
    int j = 0;
    AppMethodBeat.i(118002);
    int k;
    int m;
    for (;;)
    {
      synchronized (this.ajBi)
      {
        i = this._isTerminated;
        if (i != 0)
        {
          AppMethodBeat.o(118002);
          return -1;
        }
        long l = this.controlState;
        i = (int)(l & 0x1FFFFF);
        k = kotlin.k.k.qu(i - (int)((l & 0xFFE00000) >> 21), 0);
        m = this.hsI;
        if (k >= m)
        {
          AppMethodBeat.o(118002);
          return 0;
        }
        m = this.ahBX;
        if (i >= m)
        {
          AppMethodBeat.o(118002);
          return 0;
        }
        m = (int)(this.controlState & 0x1FFFFF) + 1;
        if ((m > 0) && (this.ajBi.get(m) == null))
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
    Object localObject2 = new c(m);
    this.ajBi.set(m, localObject2);
    int i = j;
    if (m == (int)(ajBj.incrementAndGet(this) & 0x1FFFFF)) {
      i = 1;
    }
    if (i == 0)
    {
      localObject2 = (Throwable)new IllegalArgumentException("Failed requirement.".toString());
      AppMethodBeat.o(118002);
      throw ((Throwable)localObject2);
    }
    ((c)localObject2).start();
    AppMethodBeat.o(118002);
    return k + 1;
  }
  
  private final c kEx()
  {
    AppMethodBeat.i(189535);
    Object localObject = Thread.currentThread();
    if ((localObject instanceof c)) {}
    for (localObject = (c)localObject; (localObject != null) && (s.p(((c)localObject).ajBt, this)); localObject = null)
    {
      AppMethodBeat.o(189535);
      return localObject;
    }
    AppMethodBeat.o(189535);
    return null;
  }
  
  public final void a(Runnable paramRunnable, j paramj, boolean paramBoolean)
  {
    int j = 1;
    AppMethodBeat.i(117997);
    paramj = a(paramRunnable, paramj);
    c localc = kEx();
    int i;
    if (localc == null)
    {
      paramRunnable = paramj;
      if (paramRunnable == null) {
        break label177;
      }
      if (paramRunnable.ajBI.kEC() != 1) {
        break label158;
      }
      i = 1;
      label48:
      if (i == 0) {
        break label164;
      }
    }
    label158:
    label164:
    for (boolean bool = this.ajBg.jl(paramRunnable);; bool = this.ajBf.jl(paramRunnable))
    {
      if (bool) {
        break label177;
      }
      paramRunnable = new RejectedExecutionException(s.X(this.ajBe, " was terminated"));
      AppMethodBeat.o(117997);
      throw paramRunnable;
      if (localc.ajBn == d.ajBy)
      {
        paramRunnable = paramj;
        break;
      }
      if ((paramj.ajBI.kEC() == 0) && (localc.ajBn == d.ajBv))
      {
        paramRunnable = paramj;
        break;
      }
      localc.ajBs = true;
      paramRunnable = localc.ajBm.a(paramj, paramBoolean);
      break;
      i = 0;
      break label48;
    }
    label177:
    if ((paramBoolean) && (localc != null)) {
      i = j;
    }
    while (paramj.ajBI.kEC() == 0) {
      if (i != 0)
      {
        AppMethodBeat.o(117997);
        return;
        i = 0;
      }
      else
      {
        kEu();
        AppMethodBeat.o(117997);
        return;
      }
    }
    long l = ajBj.addAndGet(this, 2097152L);
    if ((i == 0) && (!kEv()) && (!BR(l))) {
      kEv();
    }
    AppMethodBeat.o(117997);
  }
  
  public final void a(c paramc, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(189563);
    for (;;)
    {
      long l = this.parkedWorkersStack;
      int i = (int)(0x1FFFFF & l);
      if (i == paramInt1) {
        if (paramInt2 == 0) {
          i = a(paramc);
        }
      }
      while ((i >= 0) && (ajBh.compareAndSet(this, l, 2097152L + l & 0xFFE00000 | i)))
      {
        AppMethodBeat.o(189563);
        return;
        i = paramInt2;
      }
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(117996);
    c localc;
    if (ajBk.compareAndSet(this, 0, 1)) {
      localc = kEx();
    }
    for (;;)
    {
      int k;
      int i;
      Object localObject3;
      synchronized (this.ajBi)
      {
        long l = this.controlState;
        k = (int)(l & 0x1FFFFF);
        if (k <= 0) {
          break label193;
        }
        i = 1;
        ??? = this.ajBi.get(i);
        s.checkNotNull(???);
        ??? = (c)???;
        if (??? == localc) {
          break label188;
        }
        if (((c)???).isAlive())
        {
          LockSupport.unpark((Thread)???);
          ((c)???).join(10000L);
        }
      }
      if (localObject3 == d.ajBy) {}
      for (int j = 1; j == 0; j = 0)
      {
        ??? = new AssertionError();
        AppMethodBeat.o(117996);
        throw ((Throwable)???);
      }
      ((c)???).ajBm.a(this.ajBg);
      label188:
      if (i == k)
      {
        label193:
        this.ajBg.close();
        this.ajBf.close();
        if (localc == null) {}
        for (localObject3 = null;; localObject3 = localc.PL(true))
        {
          ??? = localObject3;
          if (localObject3 == null)
          {
            localObject3 = (i)this.ajBf.kkV();
            ??? = localObject3;
            if (localObject3 == null)
            {
              ??? = (i)this.ajBg.kkV();
              if (??? == null) {
                break label281;
              }
            }
          }
          a((i)???);
          break;
        }
        if (localc != null) {
          localc.a(d.ajBy);
        }
        if (au.ASSERTIONS_ENABLED)
        {
          if ((int)((this.controlState & 0x0) >> 42) == this.hsI) {}
          for (i = 1; i == 0; i = 0)
          {
            ??? = new AssertionError();
            AppMethodBeat.o(117996);
            throw ((Throwable)???);
          }
        }
        this.parkedWorkersStack = 0L;
        this.controlState = 0L;
        AppMethodBeat.o(117996);
        return;
      }
      label281:
      i += 1;
    }
  }
  
  public final void execute(Runnable paramRunnable)
  {
    AppMethodBeat.i(117995);
    a(this, paramRunnable, null, false, 6);
    AppMethodBeat.o(117995);
  }
  
  public final void kEu()
  {
    AppMethodBeat.i(189589);
    if (kEv())
    {
      AppMethodBeat.o(189589);
      return;
    }
    if (a(this))
    {
      AppMethodBeat.o(189589);
      return;
    }
    kEv();
    AppMethodBeat.o(189589);
  }
  
  public final String toString()
  {
    int i6 = 1;
    AppMethodBeat.i(118003);
    Object localObject1 = new ArrayList();
    int i8 = this.ajBi.length();
    int i5;
    int i4;
    int i3;
    int i2;
    int i1;
    int i7;
    Object localObject2;
    int i;
    int j;
    int k;
    int m;
    int n;
    if (1 < i8)
    {
      i5 = 0;
      i4 = 0;
      i3 = 0;
      i2 = 0;
      i1 = 0;
      i7 = i6 + 1;
      localObject2 = (c)this.ajBi.get(i6);
      i = i5;
      j = i4;
      k = i3;
      m = i2;
      n = i1;
      if (localObject2 != null)
      {
        i6 = ((c)localObject2).ajBm.kEF();
        localObject2 = ((c)localObject2).ajBn;
      }
      switch (b.$EnumSwitchMapping$0[localObject2.ordinal()])
      {
      default: 
        n = i1;
        m = i2;
        k = i3;
        j = i4;
        i = i5;
        label169:
        if (i7 < i8) {
          break;
        }
      }
    }
    for (;;)
    {
      long l = this.controlState;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.ajBe).append('@').append(Integer.toHexString(System.identityHashCode(this))).append("[Pool Size {core = ").append(this.hsI).append(", max = ").append(this.ahBX).append("}, Worker States {CPU = ").append(k).append(", blocking = ").append(m).append(", parked = ").append(n).append(", dormant = ").append(j).append(", terminated = ").append(i).append("}, running workers queues = ").append(localObject1).append(", global CPU queue size = ").append(this.ajBf.getSize()).append(", global blocking queue size = ").append(this.ajBg.getSize());
      ((StringBuilder)localObject2).append(", Control State {created workers= ").append((int)(0x1FFFFF & l)).append(", blocking tasks = ").append((int)((0xFFE00000 & l) >> 21)).append(", CPUs acquired = ").append(this.hsI - (int)((0x0 & l) >> 42)).append("}]");
      localObject1 = ((StringBuilder)localObject2).toString();
      AppMethodBeat.o(118003);
      return localObject1;
      n = i1 + 1;
      i = i5;
      j = i4;
      k = i3;
      m = i2;
      break label169;
      m = i2 + 1;
      ((Collection)localObject1).add(i6 + 'b');
      i = i5;
      j = i4;
      k = i3;
      n = i1;
      break label169;
      k = i3 + 1;
      ((Collection)localObject1).add(i6 + 'c');
      i = i5;
      j = i4;
      m = i2;
      n = i1;
      break label169;
      i4 += 1;
      i = i5;
      j = i4;
      k = i3;
      m = i2;
      n = i1;
      if (i6 <= 0) {
        break label169;
      }
      ((Collection)localObject1).add(i6 + 'd');
      i = i5;
      j = i4;
      k = i3;
      m = i2;
      n = i1;
      break label169;
      i = i5 + 1;
      j = i4;
      k = i3;
      m = i2;
      n = i1;
      break label169;
      i6 = i7;
      i5 = i;
      i4 = j;
      i3 = k;
      i2 = m;
      i1 = n;
      break;
      i = 0;
      j = 0;
      k = 0;
      m = 0;
      n = 0;
    }
  }
  
  @Metadata(d1={""}, d2={"Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "", "index", "<init>", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;I)V", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;)V", "taskMode", "", "afterTask", "(I)V", "beforeTask", "Lkotlinx/coroutines/scheduling/Task;", "task", "executeTask", "(Lkotlinx/coroutines/scheduling/Task;)V", "", "scanLocalQueue", "findAnyTask", "(Z)Lkotlinx/coroutines/scheduling/Task;", "findTask", "mode", "idleReset", "inStack", "()Z", "upperBound", "nextInt", "(I)I", "park", "()V", "pollGlobalQueues", "()Lkotlinx/coroutines/scheduling/Task;", "run", "runWorker", "tryAcquireCpuPermit", "tryPark", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "newState", "tryReleaseCpu", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;)Z", "blockingOnly", "trySteal", "tryTerminateWorker", "indexInArray", "I", "getIndexInArray", "()I", "setIndexInArray", "Lkotlinx/coroutines/scheduling/WorkQueue;", "localQueue", "Lkotlinx/coroutines/scheduling/WorkQueue;", "mayHaveLocalTasks", "Z", "", "minDelayUntilStealableTaskNs", "J", "", "nextParkedWorker", "Ljava/lang/Object;", "getNextParkedWorker", "()Ljava/lang/Object;", "setNextParkedWorker", "(Ljava/lang/Object;)V", "rngState", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "getScheduler", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "scheduler", "state", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "terminationDeadline", "kotlinx-coroutines-core", "Ljava/lang/Thread;"}, k=1, mv={1, 5, 1}, xi=48)
  public final class c
    extends Thread
  {
    public final m ajBm;
    public a.d ajBn;
    private long ajBp;
    private long ajBq;
    private int ajBr;
    public boolean ajBs;
    volatile int indexInArray;
    volatile Object nextParkedWorker;
    
    static
    {
      AppMethodBeat.i(118028);
      ajBo = AtomicIntegerFieldUpdater.newUpdater(c.class, "workerCtl");
      AppMethodBeat.o(118028);
    }
    
    private c()
    {
      AppMethodBeat.i(118026);
      setDaemon(true);
      this.ajBm = new m();
      this.ajBn = a.d.ajBx;
      this.workerCtl = 0;
      this.nextParkedWorker = a.ajBl;
      this$1 = c.aixl;
      this.ajBr = c.klI().Zo();
      AppMethodBeat.o(118026);
    }
    
    public c()
    {
      this();
      AppMethodBeat.i(118027);
      int i;
      aMH(i);
      AppMethodBeat.o(118027);
    }
    
    private final i PM(boolean paramBoolean)
    {
      AppMethodBeat.i(189483);
      if (paramBoolean)
      {
        if (Pa(a.this.hsI * 2) == 0) {}
        for (int i = 1; i != 0; i = 0)
        {
          locali = kEB();
          if (locali == null) {
            break;
          }
          AppMethodBeat.o(189483);
          return locali;
        }
        locali = this.ajBm.kEG();
        if (locali != null)
        {
          AppMethodBeat.o(189483);
          return locali;
        }
        if (i == 0)
        {
          locali = kEB();
          if (locali != null)
          {
            AppMethodBeat.o(189483);
            return locali;
          }
        }
      }
      else
      {
        locali = kEB();
        if (locali != null)
        {
          AppMethodBeat.o(189483);
          return locali;
        }
      }
      i locali = PN(false);
      AppMethodBeat.o(189483);
      return locali;
    }
    
    private final i PN(boolean paramBoolean)
    {
      AppMethodBeat.i(189502);
      if (au.ASSERTIONS_ENABLED)
      {
        if (this.ajBm.kEF() == 0) {}
        for (i = 1; i == 0; i = 0)
        {
          localObject = new AssertionError();
          AppMethodBeat.o(189502);
          throw ((Throwable)localObject);
        }
      }
      int m = (int)(a.this.controlState & 0x1FFFFF);
      if (m < 2)
      {
        AppMethodBeat.o(189502);
        return null;
      }
      int i = Pa(m);
      long l1 = 9223372036854775807L;
      Object localObject = a.this;
      int j = 0;
      if (j < m)
      {
        i += 1;
        if (i <= m) {
          break label314;
        }
        i = 1;
      }
      label314:
      for (;;)
      {
        c localc = (c)((a)localObject).ajBi.get(i);
        long l3 = l1;
        if (localc != null)
        {
          l3 = l1;
          if (localc != this)
          {
            if (au.ASSERTIONS_ENABLED)
            {
              if (this.ajBm.kEF() == 0) {}
              for (int k = 1; k == 0; k = 0)
              {
                localObject = new AssertionError();
                AppMethodBeat.o(189502);
                throw ((Throwable)localObject);
              }
            }
            if (paramBoolean) {}
            for (long l2 = this.ajBm.b(localc.ajBm); l2 == -1L; l2 = this.ajBm.a(localc.ajBm))
            {
              localObject = this.ajBm.kEG();
              AppMethodBeat.o(189502);
              return localObject;
            }
            l3 = l1;
            if (l2 > 0L) {
              l3 = Math.min(l1, l2);
            }
          }
        }
        j += 1;
        l1 = l3;
        break;
        if (l1 != 9223372036854775807L) {}
        for (;;)
        {
          this.ajBq = l1;
          AppMethodBeat.o(189502);
          return null;
          l1 = 0L;
        }
      }
    }
    
    private int Pa(int paramInt)
    {
      int i = this.ajBr;
      i ^= i << 13;
      i ^= i >> 17;
      i ^= i << 5;
      this.ajBr = i;
      int j = paramInt - 1;
      if ((j & paramInt) == 0) {
        return i & j;
      }
      return (i & 0x7FFFFFFF) % paramInt;
    }
    
    private void aMH(int paramInt)
    {
      AppMethodBeat.i(118015);
      StringBuilder localStringBuilder = new StringBuilder().append(a.this.ajBe).append("-worker-");
      if (paramInt == 0) {}
      for (String str = "TERMINATED";; str = String.valueOf(paramInt))
      {
        setName(str);
        this.indexInArray = paramInt;
        AppMethodBeat.o(118015);
        return;
      }
    }
    
    private final boolean kEA()
    {
      return this.nextParkedWorker != a.ajBl;
    }
    
    private final i kEB()
    {
      AppMethodBeat.i(189491);
      if (Pa(2) == 0)
      {
        locali = (i)a.this.ajBf.kkV();
        if (locali != null)
        {
          AppMethodBeat.o(189491);
          return locali;
        }
        locali = (i)a.this.ajBg.kkV();
        AppMethodBeat.o(189491);
        return locali;
      }
      i locali = (i)a.this.ajBg.kkV();
      if (locali != null)
      {
        AppMethodBeat.o(189491);
        return locali;
      }
      locali = (i)a.this.ajBf.kkV();
      AppMethodBeat.o(189491);
      return locali;
    }
    
    private final boolean kEy()
    {
      AppMethodBeat.i(118017);
      if (this.ajBn == a.d.ajBu)
      {
        AppMethodBeat.o(118017);
        return true;
      }
      a locala = a.this;
      long l = locala.controlState;
      if ((int)((0x0 & l) >> 42) == 0) {}
      for (int i = 0;; i = 1)
      {
        if (i == 0) {
          break label91;
        }
        this.ajBn = a.d.ajBu;
        AppMethodBeat.o(118017);
        return true;
        if (!a.ajBj.compareAndSet(locala, l, l - 4398046511104L)) {
          break;
        }
      }
      label91:
      AppMethodBeat.o(118017);
      return false;
    }
    
    private final void kEz()
    {
      AppMethodBeat.i(189466);
      Object localObject1;
      int j;
      int i;
      if (!kEA())
      {
        localObject1 = a.this;
        if (this.nextParkedWorker == a.ajBl)
        {
          long l;
          int k;
          do
          {
            l = ((a)localObject1).parkedWorkersStack;
            j = (int)(0x1FFFFF & l);
            k = this.indexInArray;
            if (au.ASSERTIONS_ENABLED)
            {
              if (k != 0) {}
              for (i = 1; i == 0; i = 0)
              {
                localObject1 = new AssertionError();
                AppMethodBeat.o(189466);
                throw ((Throwable)localObject1);
              }
            }
            this.nextParkedWorker = ((a)localObject1).ajBi.get(j);
          } while (!a.ajBh.compareAndSet(localObject1, l, k | 2097152L + l & 0xFFE00000));
        }
        AppMethodBeat.o(189466);
        return;
      }
      if (au.ASSERTIONS_ENABLED)
      {
        if (this.ajBm.kEF() == 0) {}
        for (i = 1; i == 0; i = 0)
        {
          localObject1 = new AssertionError();
          AppMethodBeat.o(189466);
          throw ((Throwable)localObject1);
        }
      }
      this.workerCtl = -1;
      while ((kEA()) && (this.workerCtl == -1) && (a.this._isTerminated == 0) && (this.ajBn != a.d.ajBy))
      {
        a(a.d.ajBw);
        Thread.interrupted();
        if (this.ajBp == 0L) {
          this.ajBp = (System.nanoTime() + a.this.ajBd);
        }
        LockSupport.parkNanos(a.this.ajBd);
        if (System.nanoTime() - this.ajBp >= 0L)
        {
          this.ajBp = 0L;
          localObject1 = a.this.ajBi;
          Object localObject2 = a.this;
          try
          {
            i = ((a)localObject2)._isTerminated;
            if (i != 0) {}
            i = (int)(((a)localObject2).controlState & 0x1FFFFF);
            j = ((a)localObject2).hsI;
            if (i <= j) {}
            boolean bool = ajBo.compareAndSet(this, -1, 1);
            if (!bool) {}
            i = this.indexInArray;
            aMH(0);
            ((a)localObject2).a(this, i, 0);
            j = (int)(a.ajBj.getAndDecrement(localObject2) & 0x1FFFFF);
            if (j != i)
            {
              Object localObject4 = ((a)localObject2).ajBi.get(j);
              s.checkNotNull(localObject4);
              localObject4 = (c)localObject4;
              ((a)localObject2).ajBi.set(i, localObject4);
              ((c)localObject4).aMH(i);
              ((a)localObject2).a((c)localObject4, j, i);
            }
            ((a)localObject2).ajBi.set(j, null);
            localObject2 = ah.aiuX;
            this.ajBn = a.d.ajBy;
          }
          finally
          {
            AppMethodBeat.o(189466);
          }
        }
      }
      AppMethodBeat.o(189466);
    }
    
    public final i PL(boolean paramBoolean)
    {
      AppMethodBeat.i(189533);
      i locali;
      if (kEy())
      {
        locali = PM(paramBoolean);
        AppMethodBeat.o(189533);
        return locali;
      }
      if (paramBoolean)
      {
        locali = this.ajBm.kEG();
        if (locali == null) {}
      }
      while (locali == null)
      {
        locali = PN(true);
        AppMethodBeat.o(189533);
        return locali;
        locali = (i)a.this.ajBg.kkV();
      }
      AppMethodBeat.o(189533);
      return locali;
    }
    
    public final boolean a(a.d paramd)
    {
      AppMethodBeat.i(189516);
      a.d locald = this.ajBn;
      if (locald == a.d.ajBu) {}
      for (boolean bool = true;; bool = false)
      {
        if (bool)
        {
          a locala = a.this;
          a.ajBj.addAndGet(locala, 4398046511104L);
        }
        if (locald != paramd) {
          this.ajBn = paramd;
        }
        AppMethodBeat.o(189516);
        return bool;
      }
    }
    
    public final void run()
    {
      AppMethodBeat.i(118019);
      int i = 0;
      while ((a.this._isTerminated == 0) && (this.ajBn != a.d.ajBy))
      {
        Object localObject = PL(this.ajBs);
        if (localObject != null)
        {
          this.ajBq = 0L;
          int j = ((i)localObject).ajBI.kEC();
          this.ajBp = 0L;
          if (this.ajBn == a.d.ajBw)
          {
            if (au.ASSERTIONS_ENABLED)
            {
              if (j == 1) {}
              for (i = 1; i == 0; i = 0)
              {
                localObject = new AssertionError();
                AppMethodBeat.o(118019);
                throw ((Throwable)localObject);
              }
            }
            this.ajBn = a.d.ajBv;
          }
          if ((j != 0) && (a(a.d.ajBv))) {
            a.this.kEu();
          }
          a.a((i)localObject);
          if (j != 0)
          {
            localObject = a.this;
            a.ajBj.addAndGet(localObject, -2097152L);
            localObject = this.ajBn;
            if (localObject != a.d.ajBy)
            {
              if (au.ASSERTIONS_ENABLED)
              {
                if (localObject == a.d.ajBv) {}
                for (i = 1; i == 0; i = 0)
                {
                  localObject = new AssertionError();
                  AppMethodBeat.o(118019);
                  throw ((Throwable)localObject);
                }
              }
              this.ajBn = a.d.ajBx;
            }
          }
          i = 0;
        }
        else
        {
          this.ajBs = false;
          if (this.ajBq != 0L)
          {
            if (i == 0)
            {
              i = 1;
            }
            else
            {
              a(a.d.ajBw);
              Thread.interrupted();
              LockSupport.parkNanos(this.ajBq);
              this.ajBq = 0L;
              i = 0;
            }
          }
          else {
            kEz();
          }
        }
      }
      a(a.d.ajBy);
      AppMethodBeat.o(118019);
    }
  }
  
  @Metadata(d1={""}, d2={"Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "", "(Ljava/lang/String;I)V", "CPU_ACQUIRED", "BLOCKING", "PARKING", "DORMANT", "TERMINATED", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum d
  {
    static
    {
      AppMethodBeat.i(118012);
      ajBu = new d("CPU_ACQUIRED", 0);
      ajBv = new d("BLOCKING", 1);
      ajBw = new d("PARKING", 2);
      ajBx = new d("DORMANT", 3);
      ajBy = new d("TERMINATED", 4);
      ajBz = new d[] { ajBu, ajBv, ajBw, ajBx, ajBy };
      AppMethodBeat.o(118012);
    }
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.d.a
 * JD-Core Version:    0.7.0.1
 */