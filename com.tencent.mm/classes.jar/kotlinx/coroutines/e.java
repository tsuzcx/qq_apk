package kotlinx.coroutines;

import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/BlockingEventLoop;", "Lkotlinx/coroutines/EventLoopImplBase;", "thread", "Ljava/lang/Thread;", "(Ljava/lang/Thread;)V", "getThread", "()Ljava/lang/Thread;", "kotlinx-coroutines-core"})
public final class e
  extends bh
{
  private final Thread thread;
  
  public e(Thread paramThread)
  {
    this.thread = paramThread;
  }
  
  protected final Thread getThread()
  {
    return this.thread;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.e
 * JD-Core Version:    0.7.0.1
 */