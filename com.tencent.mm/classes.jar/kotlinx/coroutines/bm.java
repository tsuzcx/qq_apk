package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.a;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/EventLoop;", "Lkotlinx/coroutines/CoroutineDispatcher;", "()V", "isActive", "", "()Z", "isEmpty", "isUnconfinedLoopActive", "isUnconfinedQueueEmpty", "nextTime", "", "getNextTime", "()J", "shared", "unconfinedQueue", "Lkotlinx/coroutines/internal/ArrayQueue;", "Lkotlinx/coroutines/DispatchedTask;", "useCount", "decrementUseCount", "", "unconfined", "delta", "dispatchUnconfined", "task", "incrementUseCount", "processNextEvent", "processUnconfinedEvent", "shouldBeProcessedFromContext", "shutdown", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class bm
  extends al
{
  private long ajvZ;
  private boolean ajwa;
  private a<bd<?>> ajwb;
  
  private static long PH(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 4294967296L;
    }
    return 1L;
  }
  
  public static boolean kCm()
  {
    return false;
  }
  
  public final void PI(boolean paramBoolean)
  {
    this.ajvZ += PH(paramBoolean);
    if (!paramBoolean) {
      this.ajwa = true;
    }
  }
  
  public final void PJ(boolean paramBoolean)
  {
    this.ajvZ -= PH(paramBoolean);
    if (this.ajvZ > 0L) {}
    do
    {
      return;
      if (au.ASSERTIONS_ENABLED)
      {
        if (this.ajvZ == 0L) {}
        for (int i = 1; i == 0; i = 0) {
          throw new AssertionError();
        }
      }
    } while (!this.ajwa);
    shutdown();
  }
  
  public final void b(bd<?> parambd)
  {
    a locala2 = this.ajwb;
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new a();
      this.ajwb = locala1;
    }
    locala1.hr(parambd);
  }
  
  protected long eHQ()
  {
    a locala = this.ajwb;
    if (locala == null) {}
    while (locala.isEmpty()) {
      return 9223372036854775807L;
    }
    return 0L;
  }
  
  protected boolean isEmpty()
  {
    return kCo();
  }
  
  public long kCk()
  {
    if (!kCl()) {
      return 9223372036854775807L;
    }
    return 0L;
  }
  
  public final boolean kCl()
  {
    Object localObject = this.ajwb;
    if (localObject == null) {
      return false;
    }
    localObject = (bd)((a)localObject).kkV();
    if (localObject == null) {
      return false;
    }
    ((bd)localObject).run();
    return true;
  }
  
  public final boolean kCn()
  {
    return this.ajvZ >= PH(true);
  }
  
  public final boolean kCo()
  {
    a locala = this.ajwb;
    if (locala == null) {
      return true;
    }
    return locala.isEmpty();
  }
  
  protected void shutdown() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.bm
 * JD-Core Version:    0.7.0.1
 */