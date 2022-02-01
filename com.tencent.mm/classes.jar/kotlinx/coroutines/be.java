package kotlinx.coroutines;

import d.l;
import java.util.concurrent.locks.LockSupport;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlinx/coroutines/EventLoopImplPlatform;", "Lkotlinx/coroutines/EventLoop;", "()V", "thread", "Ljava/lang/Thread;", "getThread", "()Ljava/lang/Thread;", "reschedule", "", "now", "", "delayedTask", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "unpark", "kotlinx-coroutines-core"})
public abstract class be
  extends bc
{
  protected final void c(long paramLong, bd.b paramb)
  {
    if (al.gdD())
    {
      if ((be)this != an.LRk) {}
      for (int i = 1; i == 0; i = 0) {
        throw ((Throwable)new AssertionError());
      }
    }
    an.LRk.a(paramLong, paramb);
  }
  
  protected final void gdZ()
  {
    Thread localThread = getThread();
    if ((Thread.currentThread() != localThread) && (cg.LSm == null)) {
      LockSupport.unpark(localThread);
    }
  }
  
  protected abstract Thread getThread();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.be
 * JD-Core Version:    0.7.0.1
 */