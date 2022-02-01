package kotlinx.coroutines;

import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/coroutines/BlockingEventLoop;", "Lkotlinx/coroutines/EventLoopImplBase;", "thread", "Ljava/lang/Thread;", "(Ljava/lang/Thread;)V", "getThread", "()Ljava/lang/Thread;", "kotlinx-coroutines-core"})
public final class e
  extends be
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.e
 * JD-Core Version:    0.7.0.1
 */