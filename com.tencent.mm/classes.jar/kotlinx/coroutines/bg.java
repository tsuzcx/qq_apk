package kotlinx.coroutines;

import kotlin.l;
import kotlinx.coroutines.internal.a;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/EventLoop;", "Lkotlinx/coroutines/CoroutineDispatcher;", "()V", "isActive", "", "()Z", "isEmpty", "isUnconfinedLoopActive", "isUnconfinedQueueEmpty", "nextTime", "", "getNextTime", "()J", "shared", "unconfinedQueue", "Lkotlinx/coroutines/internal/ArrayQueue;", "Lkotlinx/coroutines/DispatchedTask;", "useCount", "decrementUseCount", "", "unconfined", "delta", "dispatchUnconfined", "task", "incrementUseCount", "processNextEvent", "processUnconfinedEvent", "shouldBeProcessedFromContext", "shutdown", "kotlinx-coroutines-core"})
public abstract class bg
  extends ad
{
  private long TUv;
  private boolean TUw;
  private a<ay<?>> TUx;
  
  private static long EW(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 4294967296L;
    }
    return 1L;
  }
  
  public final void EX(boolean paramBoolean)
  {
    this.TUv += EW(paramBoolean);
    if (!paramBoolean) {
      this.TUw = true;
    }
  }
  
  public final void b(ay<?> paramay)
  {
    a locala2 = this.TUx;
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new a();
      this.TUx = locala1;
    }
    locala1.addLast(paramay);
  }
  
  public long hMY()
  {
    if (!hNa()) {
      return 9223372036854775807L;
    }
    return hMZ();
  }
  
  protected long hMZ()
  {
    a locala = this.TUx;
    if (locala == null) {}
    while (locala.isEmpty()) {
      return 9223372036854775807L;
    }
    return 0L;
  }
  
  public final boolean hNa()
  {
    Object localObject = this.TUx;
    if (localObject == null) {
      return false;
    }
    localObject = (ay)((a)localObject).hNC();
    if (localObject == null) {
      return false;
    }
    ((ay)localObject).run();
    return true;
  }
  
  public final boolean hNb()
  {
    return this.TUv >= EW(true);
  }
  
  public final boolean hNc()
  {
    a locala = this.TUx;
    if (locala != null) {
      return locala.isEmpty();
    }
    return true;
  }
  
  public final void hNd()
  {
    int i = 1;
    this.TUv -= EW(true);
    if (this.TUv > 0L) {}
    do
    {
      return;
      if (an.hMK())
      {
        if (this.TUv == 0L) {}
        while (i == 0)
        {
          throw ((Throwable)new AssertionError());
          i = 0;
        }
      }
    } while (!this.TUw);
    shutdown();
  }
  
  protected boolean isEmpty()
  {
    return hNc();
  }
  
  protected void shutdown() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.bg
 * JD-Core Version:    0.7.0.1
 */