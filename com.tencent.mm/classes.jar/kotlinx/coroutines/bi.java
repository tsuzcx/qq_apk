package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/EventLoopImplPlatform;", "Lkotlinx/coroutines/EventLoop;", "()V", "thread", "Ljava/lang/Thread;", "getThread", "()Ljava/lang/Thread;", "reschedule", "", "now", "", "delayedTask", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "unpark", "kotlinx-coroutines-core"})
public abstract class bi
  extends bg
{
  protected final void c(long paramLong, bh.c paramc)
  {
    if (an.hMK())
    {
      if ((bi)this != ap.TUg) {}
      for (int i = 1; i == 0; i = 0) {
        throw ((Throwable)new AssertionError());
      }
    }
    ap.TUg.a(paramLong, paramc);
  }
  
  protected abstract Thread getThread();
  
  protected final void hNg()
  {
    Thread localThread = getThread();
    if ((Thread.currentThread() != localThread) && (cr.TVl == null)) {
      LockSupport.unpark(localThread);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.bi
 * JD-Core Version:    0.7.0.1
 */