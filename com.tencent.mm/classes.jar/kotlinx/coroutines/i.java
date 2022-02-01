package kotlinx.coroutines;

import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/BlockingEventLoop;", "Lkotlinx/coroutines/EventLoopImplBase;", "thread", "Ljava/lang/Thread;", "(Ljava/lang/Thread;)V", "getThread", "()Ljava/lang/Thread;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends bn
{
  private final Thread thread;
  
  public i(Thread paramThread)
  {
    this.thread = paramThread;
  }
  
  protected final Thread getThread()
  {
    return this.thread;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.i
 * JD-Core Version:    0.7.0.1
 */