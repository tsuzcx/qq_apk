package kotlinx.coroutines.c;

import a.aa;
import a.f.b.j;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "Ljava/lang/Thread;", "index", "", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;I)V", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;)V", "indexInArray", "getIndexInArray", "()I", "setIndexInArray", "(I)V", "isBlocking", "", "()Z", "isParking", "lastExhaustionTime", "", "lastStealIndex", "localQueue", "Lkotlinx/coroutines/scheduling/WorkQueue;", "getLocalQueue", "()Lkotlinx/coroutines/scheduling/WorkQueue;", "nextParkedWorker", "", "getNextParkedWorker", "()Ljava/lang/Object;", "setNextParkedWorker", "(Ljava/lang/Object;)V", "parkTimeNs", "rngState", "scheduler", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "getScheduler", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "spins", "state", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "getState", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "setState", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;)V", "terminationDeadline", "terminationState", "Lkotlinx/atomicfu/AtomicInt;", "afterTask", "", "taskMode", "Lkotlinx/coroutines/scheduling/TaskMode;", "beforeTask", "taskSubmissionTime", "blockingQuiescence", "blockingWorkerIdle", "cpuWorkerIdle", "doPark", "nanos", "findTask", "Lkotlinx/coroutines/scheduling/Task;", "findTask$kotlinx_coroutines_core", "findTaskWithCpuPermit", "idleReset", "mode", "idleResetBeforeUnpark", "nextInt", "upperBound", "nextInt$kotlinx_coroutines_core", "run", "tryAcquireCpuPermit", "tryForbidTermination", "tryReleaseCpu", "newState", "tryReleaseCpu$kotlinx_coroutines_core", "trySteal", "tryTerminateWorker", "kotlinx-coroutines-core"})
public final class a$b
  extends Thread
{
  private static final AtomicIntegerFieldUpdater CKa;
  volatile int CJW;
  final o CJX;
  volatile a.c CJY;
  private volatile int CJZ;
  private long CKb;
  volatile Object CKc;
  private long CKd;
  private volatile int CKe;
  private int CKf;
  private int CKg;
  private int CKh;
  
  static
  {
    AppMethodBeat.i(118352);
    CKa = AtomicIntegerFieldUpdater.newUpdater(b.class, "CJZ");
    AppMethodBeat.o(118352);
  }
  
  private a$b()
  {
    AppMethodBeat.i(118350);
    setDaemon(true);
    this.CJX = new o();
    this.CJY = a.c.CKm;
    this.CJZ = 0;
    this.CKc = a.eqx();
    this.CKf = a.eqw();
    this.CKg = a.j(locala).nextInt();
    AppMethodBeat.o(118350);
  }
  
  public a$b(int paramInt)
  {
    this(paramInt);
    AppMethodBeat.i(118351);
    int i;
    Wl(i);
    AppMethodBeat.o(118351);
  }
  
  private void Wl(int paramInt)
  {
    AppMethodBeat.i(118339);
    StringBuilder localStringBuilder = new StringBuilder().append(a.a(this.CKi)).append("-worker-");
    if (paramInt == 0) {}
    for (String str = "TERMINATED";; str = String.valueOf(paramInt))
    {
      setName(str);
      this.CJW = paramInt;
      AppMethodBeat.o(118339);
      return;
    }
  }
  
  private int Wm(int paramInt)
  {
    this.CKg ^= this.CKg << 13;
    this.CKg ^= this.CKg >> 17;
    this.CKg ^= this.CKg << 5;
    int i = paramInt - 1;
    if ((i & paramInt) == 0) {
      return i & this.CKg;
    }
    return (this.CKg & 0x7FFFFFFF) % paramInt;
  }
  
  private final boolean eqB()
  {
    AppMethodBeat.i(118345);
    i locali = a.i(this.CKi).eqG();
    if (locali != null)
    {
      this.CJX.a(locali, a.i(this.CKi));
      AppMethodBeat.o(118345);
      return false;
    }
    AppMethodBeat.o(118345);
    return true;
  }
  
  private final i eqE()
  {
    AppMethodBeat.i(118348);
    if (Wm(a.h(this.CKi) * 2) == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      locali = (i)a.i(this.CKi).eqc();
      if (locali == null) {
        break;
      }
      AppMethodBeat.o(118348);
      return locali;
    }
    i locali = this.CJX.eqL();
    if (locali != null)
    {
      AppMethodBeat.o(118348);
      return locali;
    }
    if (i == 0)
    {
      locali = (i)a.i(this.CKi).eqc();
      if (locali != null)
      {
        AppMethodBeat.o(118348);
        return locali;
      }
    }
    locali = eqF();
    AppMethodBeat.o(118348);
    return locali;
  }
  
  private final i eqF()
  {
    AppMethodBeat.i(118349);
    int k = a.g(this.CKi);
    if (k < 2)
    {
      AppMethodBeat.o(118349);
      return null;
    }
    int j = this.CKh;
    int i = j;
    if (j == 0) {
      i = Wm(k);
    }
    j = i + 1;
    i = j;
    if (j > k) {
      i = 1;
    }
    this.CKh = i;
    Object localObject = a.f(this.CKi)[i];
    if ((localObject != null) && (localObject != (b)this) && (this.CJX.a(((b)localObject).CJX, a.i(this.CKi))))
    {
      localObject = this.CJX.eqL();
      AppMethodBeat.o(118349);
      return localObject;
    }
    AppMethodBeat.o(118349);
    return null;
  }
  
  private final void pz(long paramLong)
  {
    AppMethodBeat.i(118344);
    a.a(this.CKi, this);
    LockSupport.parkNanos(paramLong);
    AppMethodBeat.o(118344);
  }
  
  public final boolean a(a.c paramc)
  {
    AppMethodBeat.i(118342);
    j.q(paramc, "newState");
    a.c localc = this.CJY;
    if (localc == a.c.CKj) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        a.b(this.CKi).release();
      }
      if (localc != paramc) {
        this.CJY = paramc;
      }
      AppMethodBeat.o(118342);
      return bool;
    }
  }
  
  public final boolean eqA()
  {
    AppMethodBeat.i(118341);
    if (this.CJY == a.c.CKj)
    {
      AppMethodBeat.o(118341);
      return true;
    }
    if (a.b(this.CKi).tryAcquire())
    {
      this.CJY = a.c.CKj;
      AppMethodBeat.o(118341);
      return true;
    }
    AppMethodBeat.o(118341);
    return false;
  }
  
  public final void eqC()
  {
    AppMethodBeat.i(118346);
    this.CKf = a.eqw();
    this.CKe = 0;
    AppMethodBeat.o(118346);
  }
  
  public final i eqD()
  {
    AppMethodBeat.i(118347);
    if (eqA())
    {
      localObject = eqE();
      AppMethodBeat.o(118347);
      return localObject;
    }
    i locali = this.CJX.eqL();
    Object localObject = locali;
    if (locali == null) {
      localObject = a.i(this.CKi).eqG();
    }
    AppMethodBeat.o(118347);
    return localObject;
  }
  
  public final boolean eqy()
  {
    return this.CJY == a.c.CKl;
  }
  
  public final boolean eqz()
  {
    AppMethodBeat.i(118340);
    int i = this.CJZ;
    switch (i)
    {
    default: 
      Throwable localThrowable = (Throwable)new IllegalStateException("Invalid terminationState = ".concat(String.valueOf(i)).toString());
      AppMethodBeat.o(118340);
      throw localThrowable;
    case 1: 
      AppMethodBeat.o(118340);
      return false;
    case -1: 
      AppMethodBeat.o(118340);
      return false;
    }
    boolean bool = CKa.compareAndSet(this, 0, -1);
    AppMethodBeat.o(118340);
    return bool;
  }
  
  public final void run()
  {
    AppMethodBeat.i(118343);
    int i = 0;
    while ((!a.c(this.CKi)) && (this.CJY != a.c.CKn))
    {
      ??? = eqD();
      if (??? == null)
      {
        if (this.CJY == a.c.CKj)
        {
          i = this.CKe;
          if (i <= 1500)
          {
            this.CKe = (i + 1);
            if (i >= 1000) {
              Thread.yield();
            }
          }
        }
        for (;;)
        {
          i = 1;
          break;
          if (this.CKf < a.eqv()) {
            this.CKf = a.i.e.iF(this.CKf * 3 >>> 1, a.eqv());
          }
          a(a.c.CKl);
          pz(this.CKf);
          continue;
          a(a.c.CKl);
          if (eqB())
          {
            this.CJZ = 0;
            if (this.CKb == 0L) {
              this.CKb = (System.nanoTime() + a.e(this.CKi));
            }
            pz(a.e(this.CKi));
            if (System.nanoTime() - this.CKb >= 0L)
            {
              this.CKb = 0L;
              synchronized (a.f(this.CKi))
              {
                boolean bool = a.c(this.CKi);
                if (!bool)
                {
                  i = a.g(this.CKi);
                  j = a.h(this.CKi);
                  if (i > j)
                  {
                    bool = eqB();
                    if (bool)
                    {
                      bool = CKa.compareAndSet(this, 0, 1);
                      if (bool)
                      {
                        i = this.CJW;
                        Wl(0);
                        a.a(this.CKi, this, i, 0);
                        Object localObject2 = this.CKi;
                        j = (int)(a.CJM.getAndDecrement(localObject2) & 0x1FFFFF);
                        if (j != i)
                        {
                          localObject2 = a.f(this.CKi)[j];
                          if (localObject2 == null) {
                            j.ebi();
                          }
                          a.f(this.CKi)[i] = localObject2;
                          ((b)localObject2).Wl(i);
                          a.a(this.CKi, (b)localObject2, j, i);
                        }
                        a.f(this.CKi)[j] = null;
                        localObject2 = y.BMg;
                        this.CJY = a.c.CKn;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      l locall = ((i)???).eqJ();
      int j = i;
      if (i != 0)
      {
        this.CKb = 0L;
        this.CKh = 0;
        if (this.CJY == a.c.CKl)
        {
          if (locall == l.CKD) {}
          for (i = 1; (aa.BMh) && (i == 0); i = 0)
          {
            ??? = (Throwable)new AssertionError("Assertion failed");
            AppMethodBeat.o(118343);
            throw ((Throwable)???);
          }
          this.CJY = a.c.CKk;
          this.CKf = a.eqw();
        }
        this.CKe = 0;
        j = 0;
      }
      long l1 = ((i)???).CKz;
      if (locall != l.CKC)
      {
        a locala = this.CKi;
        a.CJM.addAndGet(locala, 2097152L);
        if (a(a.c.CKk)) {
          a.d(this.CKi);
        }
        a.b((i)???);
        i = j;
        if (locall == l.CKC) {
          continue;
        }
        ??? = this.CKi;
        a.CJM.addAndGet(???, -2097152L);
        ??? = this.CJY;
        i = j;
        if (??? == a.c.CKn) {
          continue;
        }
        if (??? != a.c.CKk) {
          break label751;
        }
      }
      label751:
      for (i = 1;; i = 0)
      {
        if ((!aa.BMh) || (i != 0)) {
          break label756;
        }
        ??? = (Throwable)new AssertionError("Expected BLOCKING state, but has ".concat(String.valueOf(???)));
        AppMethodBeat.o(118343);
        throw ((Throwable)???);
        if (a.b(this.CKi).availablePermits() == 0) {
          break;
        }
        long l2 = m.CKK.nanoTime();
        if ((l2 - l1 < m.CKF) || (l2 - this.CKd < m.CKF * 5L)) {
          break;
        }
        this.CKd = l2;
        a.d(this.CKi);
        break;
      }
      label756:
      this.CJY = a.c.CKm;
      i = j;
    }
    a(a.c.CKn);
    AppMethodBeat.o(118343);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.c.a.b
 * JD-Core Version:    0.7.0.1
 */