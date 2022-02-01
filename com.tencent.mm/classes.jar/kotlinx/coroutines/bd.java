package kotlinx.coroutines;

import d.l;
import kotlinx.coroutines.internal.a;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/coroutines/EventLoop;", "Lkotlinx/coroutines/CoroutineDispatcher;", "()V", "isActive", "", "()Z", "isEmpty", "isUnconfinedLoopActive", "isUnconfinedQueueEmpty", "nextTime", "", "getNextTime", "()J", "shared", "unconfinedQueue", "Lkotlinx/coroutines/internal/ArrayQueue;", "Lkotlinx/coroutines/DispatchedTask;", "useCount", "decrementUseCount", "", "unconfined", "delta", "dispatchUnconfined", "task", "incrementUseCount", "processNextEvent", "processUnconfinedEvent", "shouldBeProcessedFromContext", "shutdown", "kotlinx-coroutines-core"})
public abstract class bd
  extends ac
{
  private long OfA;
  private boolean OfB;
  private a<ax<?>> OfC;
  
  private static long AG(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 4294967296L;
    }
    return 1L;
  }
  
  public final void AH(boolean paramBoolean)
  {
    this.OfA += AG(paramBoolean);
    if (!paramBoolean) {
      this.OfB = true;
    }
  }
  
  public final void b(ax<?> paramax)
  {
    a locala2 = this.OfC;
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new a();
      this.OfC = locala1;
    }
    locala1.addLast(paramax);
  }
  
  public long gzT()
  {
    if (!gzV()) {
      return 9223372036854775807L;
    }
    return gzU();
  }
  
  protected long gzU()
  {
    a locala = this.OfC;
    if (locala == null) {}
    while (locala.isEmpty()) {
      return 9223372036854775807L;
    }
    return 0L;
  }
  
  public final boolean gzV()
  {
    Object localObject = this.OfC;
    if (localObject == null) {
      return false;
    }
    localObject = (ax)((a)localObject).gAv();
    if (localObject == null) {
      return false;
    }
    ((ax)localObject).run();
    return true;
  }
  
  public final boolean gzW()
  {
    return this.OfA >= AG(true);
  }
  
  public final boolean gzX()
  {
    a locala = this.OfC;
    if (locala != null) {
      return locala.isEmpty();
    }
    return true;
  }
  
  public final void gzY()
  {
    int i = 1;
    this.OfA -= AG(true);
    if (this.OfA > 0L) {}
    do
    {
      return;
      if (am.gzF())
      {
        if (this.OfA == 0L) {}
        while (i == 0)
        {
          throw ((Throwable)new AssertionError());
          i = 0;
        }
      }
    } while (!this.OfB);
    shutdown();
  }
  
  protected boolean isEmpty()
  {
    return gzX();
  }
  
  protected void shutdown() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.bd
 * JD-Core Version:    0.7.0.1
 */