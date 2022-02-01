package kotlinx.coroutines.d;

import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/scheduling/Task;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "()V", "submissionTime", "", "taskContext", "Lkotlinx/coroutines/scheduling/TaskContext;", "(JLkotlinx/coroutines/scheduling/TaskContext;)V", "mode", "", "getMode", "()I", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class i
  implements Runnable
{
  public long ajBH;
  public j ajBI;
  
  public i()
  {
    this(0L, (j)g.ajBG);
  }
  
  public i(long paramLong, j paramj)
  {
    this.ajBH = paramLong;
    this.ajBI = paramj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.d.i
 * JD-Core Version:    0.7.0.1
 */