package kotlinx.coroutines;

import d.l;
import kotlinx.coroutines.internal.a;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/coroutines/EventLoop;", "Lkotlinx/coroutines/CoroutineDispatcher;", "()V", "isActive", "", "()Z", "isEmpty", "isUnconfinedLoopActive", "isUnconfinedQueueEmpty", "nextTime", "", "getNextTime", "()J", "shared", "unconfinedQueue", "Lkotlinx/coroutines/internal/ArrayQueue;", "Lkotlinx/coroutines/DispatchedTask;", "useCount", "decrementUseCount", "", "unconfined", "delta", "dispatchUnconfined", "task", "incrementUseCount", "processNextEvent", "processUnconfinedEvent", "shouldBeProcessedFromContext", "shutdown", "kotlinx-coroutines-core"})
public abstract class bd
  extends ac
{
  private long NIu;
  private boolean NIv;
  private a<ax<?>> NIw;
  
  private static long At(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 4294967296L;
    }
    return 1L;
  }
  
  public final void Au(boolean paramBoolean)
  {
    this.NIu += At(paramBoolean);
    if (!paramBoolean) {
      this.NIv = true;
    }
  }
  
  public final void b(ax<?> paramax)
  {
    a locala2 = this.NIw;
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new a();
      this.NIw = locala1;
    }
    locala1.addLast(paramax);
  }
  
  public long gvr()
  {
    if (!gvt()) {
      return 9223372036854775807L;
    }
    return gvs();
  }
  
  protected long gvs()
  {
    a locala = this.NIw;
    if (locala == null) {}
    while (locala.isEmpty()) {
      return 9223372036854775807L;
    }
    return 0L;
  }
  
  public final boolean gvt()
  {
    Object localObject = this.NIw;
    if (localObject == null) {
      return false;
    }
    localObject = (ax)((a)localObject).gvT();
    if (localObject == null) {
      return false;
    }
    ((ax)localObject).run();
    return true;
  }
  
  public final boolean gvu()
  {
    return this.NIu >= At(true);
  }
  
  public final boolean gvv()
  {
    a locala = this.NIw;
    if (locala != null) {
      return locala.isEmpty();
    }
    return true;
  }
  
  public final void gvw()
  {
    int i = 1;
    this.NIu -= At(true);
    if (this.NIu > 0L) {}
    do
    {
      return;
      if (am.gvd())
      {
        if (this.NIu == 0L) {}
        while (i == 0)
        {
          throw ((Throwable)new AssertionError());
          i = 0;
        }
      }
    } while (!this.NIv);
    shutdown();
  }
  
  protected boolean isEmpty()
  {
    return gvv();
  }
  
  protected void shutdown() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.bd
 * JD-Core Version:    0.7.0.1
 */