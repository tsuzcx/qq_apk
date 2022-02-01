package kotlinx.coroutines;

import d.l;
import kotlinx.coroutines.internal.a;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlinx/coroutines/EventLoop;", "Lkotlinx/coroutines/CoroutineDispatcher;", "()V", "isActive", "", "()Z", "isEmpty", "isUnconfinedLoopActive", "isUnconfinedQueueEmpty", "nextTime", "", "getNextTime", "()J", "shared", "unconfinedQueue", "Lkotlinx/coroutines/internal/ArrayQueue;", "Lkotlinx/coroutines/DispatchedTask;", "useCount", "decrementUseCount", "", "unconfined", "delta", "dispatchUnconfined", "task", "incrementUseCount", "processNextEvent", "processUnconfinedEvent", "shouldBeProcessedFromContext", "shutdown", "kotlinx-coroutines-core"})
public abstract class bc
  extends ab
{
  private boolean LRA;
  private a<aw<?>> LRB;
  private long LRz;
  
  private static long zF(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 4294967296L;
    }
    return 1L;
  }
  
  public final void b(aw<?> paramaw)
  {
    a locala2 = this.LRB;
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new a();
      this.LRB = locala1;
    }
    locala1.addLast(paramaw);
  }
  
  public long gdR()
  {
    if (!gdT()) {
      return 9223372036854775807L;
    }
    return gdS();
  }
  
  protected long gdS()
  {
    a locala = this.LRB;
    if (locala == null) {}
    while (locala.isEmpty()) {
      return 9223372036854775807L;
    }
    return 0L;
  }
  
  public final boolean gdT()
  {
    Object localObject = this.LRB;
    if (localObject == null) {
      return false;
    }
    localObject = (aw)((a)localObject).geu();
    if (localObject == null) {
      return false;
    }
    ((aw)localObject).run();
    return true;
  }
  
  public final boolean gdU()
  {
    return this.LRz >= zF(true);
  }
  
  public final boolean gdV()
  {
    a locala = this.LRB;
    if (locala != null) {
      return locala.isEmpty();
    }
    return true;
  }
  
  public final void gdW()
  {
    int i = 1;
    this.LRz -= zF(true);
    if (this.LRz > 0L) {}
    do
    {
      return;
      if (al.gdD())
      {
        if (this.LRz == 0L) {}
        while (i == 0)
        {
          throw ((Throwable)new AssertionError());
          i = 0;
        }
      }
    } while (!this.LRA);
    shutdown();
  }
  
  protected boolean isEmpty()
  {
    return gdV();
  }
  
  protected void shutdown() {}
  
  public final void zG(boolean paramBoolean)
  {
    this.LRz += zF(paramBoolean);
    if (!paramBoolean) {
      this.LRA = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.bc
 * JD-Core Version:    0.7.0.1
 */