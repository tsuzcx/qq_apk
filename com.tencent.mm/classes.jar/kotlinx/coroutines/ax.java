package kotlinx.coroutines;

import d.l;
import kotlinx.coroutines.a.a;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlinx/coroutines/EventLoop;", "Lkotlinx/coroutines/CoroutineDispatcher;", "()V", "isActive", "", "()Z", "isEmpty", "isUnconfinedLoopActive", "isUnconfinedQueueEmpty", "nextTime", "", "getNextTime", "()J", "shared", "unconfinedQueue", "Lkotlinx/coroutines/internal/ArrayQueue;", "Lkotlinx/coroutines/DispatchedTask;", "useCount", "decrementUseCount", "", "unconfined", "delta", "dispatchUnconfined", "task", "incrementUseCount", "processNextEvent", "processUnconfinedEvent", "shouldBeProcessedFromContext", "shutdown", "kotlinx-coroutines-core"})
public abstract class ax
  extends y
{
  private long KdZ;
  private boolean Kea;
  private a<ar<?>> Keb;
  
  private static long yn(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 4294967296L;
    }
    return 1L;
  }
  
  public final void b(ar<?> paramar)
  {
    a locala2 = this.Keb;
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new a();
      this.Keb = locala1;
    }
    locala1.addLast(paramar);
  }
  
  public long fLi()
  {
    if (!fLk()) {
      return 9223372036854775807L;
    }
    return fLj();
  }
  
  protected long fLj()
  {
    a locala = this.Keb;
    if (locala == null) {}
    while (locala.isEmpty()) {
      return 9223372036854775807L;
    }
    return 0L;
  }
  
  public final boolean fLk()
  {
    Object localObject = this.Keb;
    if (localObject == null) {
      return false;
    }
    localObject = (ar)((a)localObject).fLJ();
    if (localObject == null) {
      return false;
    }
    ((ar)localObject).run();
    return true;
  }
  
  public final boolean fLl()
  {
    return this.KdZ >= yn(true);
  }
  
  public final boolean fLm()
  {
    a locala = this.Keb;
    if (locala != null) {
      return locala.isEmpty();
    }
    return true;
  }
  
  public final void fLn()
  {
    int i = 1;
    this.KdZ -= yn(true);
    if (this.KdZ > 0L) {}
    do
    {
      return;
      if (ah.fKW())
      {
        if (this.KdZ == 0L) {}
        while (i == 0)
        {
          throw ((Throwable)new AssertionError());
          i = 0;
        }
      }
    } while (!this.Kea);
    shutdown();
  }
  
  protected boolean isEmpty()
  {
    return fLm();
  }
  
  protected void shutdown() {}
  
  public final void yo(boolean paramBoolean)
  {
    this.KdZ += yn(paramBoolean);
    if (!paramBoolean) {
      this.Kea = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.ax
 * JD-Core Version:    0.7.0.1
 */