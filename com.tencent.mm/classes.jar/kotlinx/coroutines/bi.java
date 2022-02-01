package kotlinx.coroutines;

import kotlin.l;
import kotlinx.coroutines.internal.a;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/EventLoop;", "Lkotlinx/coroutines/CoroutineDispatcher;", "()V", "isActive", "", "()Z", "isEmpty", "isUnconfinedLoopActive", "isUnconfinedQueueEmpty", "nextTime", "", "getNextTime", "()J", "shared", "unconfinedQueue", "Lkotlinx/coroutines/internal/ArrayQueue;", "Lkotlinx/coroutines/DispatchedTask;", "useCount", "decrementUseCount", "", "unconfined", "delta", "dispatchUnconfined", "task", "incrementUseCount", "processNextEvent", "processUnconfinedEvent", "shouldBeProcessedFromContext", "shutdown", "kotlinx-coroutines-core"})
public abstract class bi
  extends af
{
  private long abwY;
  private boolean abwZ;
  private a<ba<?>> abxa;
  
  private static long JD(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 4294967296L;
    }
    return 1L;
  }
  
  public final void JE(boolean paramBoolean)
  {
    this.abwY += JD(paramBoolean);
    if (!paramBoolean) {
      this.abwZ = true;
    }
  }
  
  public final void JF(boolean paramBoolean)
  {
    this.abwY -= JD(paramBoolean);
    if (this.abwY > 0L) {}
    do
    {
      return;
      if (ap.iRg())
      {
        if (this.abwY == 0L) {}
        for (int i = 1; i == 0; i = 0) {
          throw ((Throwable)new AssertionError());
        }
      }
    } while (!this.abwZ);
    shutdown();
  }
  
  public final void b(ba<?> paramba)
  {
    a locala2 = this.abxa;
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new a();
      this.abxa = locala1;
    }
    locala1.gv(paramba);
  }
  
  protected long dMN()
  {
    a locala = this.abxa;
    if (locala == null) {}
    while (locala.isEmpty()) {
      return 9223372036854775807L;
    }
    return 0L;
  }
  
  public long iRu()
  {
    if (!iRv()) {
      return 9223372036854775807L;
    }
    return 0L;
  }
  
  public final boolean iRv()
  {
    Object localObject = this.abxa;
    if (localObject == null) {
      return false;
    }
    localObject = (ba)((a)localObject).iSD();
    if (localObject == null) {
      return false;
    }
    ((ba)localObject).run();
    return true;
  }
  
  public final boolean iRw()
  {
    return this.abwY >= JD(true);
  }
  
  public final boolean iRx()
  {
    a locala = this.abxa;
    if (locala != null) {
      return locala.isEmpty();
    }
    return true;
  }
  
  protected boolean isEmpty()
  {
    return iRx();
  }
  
  protected void shutdown() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.bi
 * JD-Core Version:    0.7.0.1
 */