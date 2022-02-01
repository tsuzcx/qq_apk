package kotlinx.coroutines.d;

import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/scheduling/Task;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "()V", "submissionTime", "", "taskContext", "Lkotlinx/coroutines/scheduling/TaskContext;", "(JLkotlinx/coroutines/scheduling/TaskContext;)V", "mode", "", "getMode", "()I", "kotlinx-coroutines-core"})
public abstract class i
  implements Runnable
{
  public long abAq;
  public j abAr;
  
  public i()
  {
    this(0L, (j)h.abAp);
  }
  
  public i(long paramLong, j paramj)
  {
    this.abAq = paramLong;
    this.abAr = paramj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     kotlinx.coroutines.d.i
 * JD-Core Version:    0.7.0.1
 */