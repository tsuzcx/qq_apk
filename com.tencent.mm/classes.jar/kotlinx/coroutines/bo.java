package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/EventLoopImplPlatform;", "Lkotlinx/coroutines/EventLoop;", "()V", "thread", "Ljava/lang/Thread;", "getThread", "()Ljava/lang/Thread;", "reschedule", "", "now", "", "delayedTask", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "unpark", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class bo
  extends bm
{
  protected final void Co()
  {
    Thread localThread = getThread();
    if ((Thread.currentThread() != localThread) && (c.ajvf == null)) {
      LockSupport.unpark(localThread);
    }
  }
  
  protected final void c(long paramLong, bn.c paramc)
  {
    if (au.ASSERTIONS_ENABLED)
    {
      if (this != aw.ajvR) {}
      for (int i = 1; i == 0; i = 0) {
        throw new AssertionError();
      }
    }
    aw.ajvR.a(paramLong, paramc);
  }
  
  protected abstract Thread getThread();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.bo
 * JD-Core Version:    0.7.0.1
 */