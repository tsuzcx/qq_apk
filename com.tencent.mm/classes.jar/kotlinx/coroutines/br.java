package kotlinx.coroutines;

import a.l;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlinx/coroutines/TimeSource;", "", "currentTimeMillis", "", "nanoTime", "parkNanos", "", "blocker", "nanos", "registerTimeLoopThread", "trackTask", "unTrackTask", "unpark", "thread", "Ljava/lang/Thread;", "unregisterTimeLoopThread", "wrapTask", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "kotlinx-coroutines-core"})
public abstract interface br
{
  public abstract Runnable aB(Runnable paramRunnable);
  
  public abstract long nanoTime();
  
  public abstract void parkNanos(Object paramObject, long paramLong);
  
  public abstract void unpark(Thread paramThread);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     kotlinx.coroutines.br
 * JD-Core Version:    0.7.0.1
 */