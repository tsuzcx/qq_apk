package kotlinx.coroutines;

import d.l;
import java.util.concurrent.locks.LockSupport;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlinx/coroutines/EventLoopImplPlatform;", "Lkotlinx/coroutines/EventLoop;", "()V", "thread", "Ljava/lang/Thread;", "getThread", "()Ljava/lang/Thread;", "reschedule", "", "now", "", "delayedTask", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "unpark", "kotlinx-coroutines-core"})
public abstract class az
  extends ax
{
  protected final void c(long paramLong, ay.b paramb)
  {
    if (ah.fKW())
    {
      if ((az)this != aj.KdJ) {}
      for (int i = 1; i == 0; i = 0) {
        throw ((Throwable)new AssertionError());
      }
    }
    aj.KdJ.a(paramLong, paramb);
  }
  
  protected final void fLq()
  {
    Thread localThread = getThread();
    if ((Thread.currentThread() != localThread) && (cb.KeM == null)) {
      LockSupport.unpark(localThread);
    }
  }
  
  protected abstract Thread getThread();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.az
 * JD-Core Version:    0.7.0.1
 */