package kotlinx.coroutines;

import d.l;
import java.util.concurrent.locks.LockSupport;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/coroutines/EventLoopImplPlatform;", "Lkotlinx/coroutines/EventLoop;", "()V", "thread", "Ljava/lang/Thread;", "getThread", "()Ljava/lang/Thread;", "reschedule", "", "now", "", "delayedTask", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "unpark", "kotlinx-coroutines-core"})
public abstract class bf
  extends bd
{
  protected final void c(long paramLong, be.b paramb)
  {
    if (am.gzF())
    {
      if ((bf)this != ao.Ofl) {}
      for (int i = 1; i == 0; i = 0) {
        throw ((Throwable)new AssertionError());
      }
    }
    ao.Ofl.a(paramLong, paramb);
  }
  
  protected final void gAb()
  {
    Thread localThread = getThread();
    if ((Thread.currentThread() != localThread) && (ck.Ogo == null)) {
      LockSupport.unpark(localThread);
    }
  }
  
  protected abstract Thread getThread();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.bf
 * JD-Core Version:    0.7.0.1
 */