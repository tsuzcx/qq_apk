package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/EventLoopImplPlatform;", "Lkotlinx/coroutines/EventLoop;", "()V", "thread", "Ljava/lang/Thread;", "getThread", "()Ljava/lang/Thread;", "reschedule", "", "now", "", "delayedTask", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "unpark", "kotlinx-coroutines-core"})
public abstract class bk
  extends bi
{
  protected final void c(long paramLong, bj.c paramc)
  {
    if (ap.iRg())
    {
      if ((bk)this != ar.abwJ) {}
      for (int i = 1; i == 0; i = 0) {
        throw ((Throwable)new AssertionError());
      }
    }
    ar.abwJ.a(paramLong, paramc);
  }
  
  protected abstract Thread getThread();
  
  protected final void iRB()
  {
    Thread localThread = getThread();
    if ((Thread.currentThread() != localThread) && (cx.abxP == null)) {
      LockSupport.unpark(localThread);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.bk
 * JD-Core Version:    0.7.0.1
 */