package kotlinx.coroutines.c;

import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlinx/coroutines/scheduling/Task;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "()V", "submissionTime", "", "taskContext", "Lkotlinx/coroutines/scheduling/TaskContext;", "(JLkotlinx/coroutines/scheduling/TaskContext;)V", "mode", "", "getMode", "()I", "kotlinx-coroutines-core"})
public abstract class i
  implements Runnable
{
  public long Kgr;
  public j Kgs;
  
  public i()
  {
    this(0L, (j)h.Kgq);
  }
  
  public i(long paramLong, j paramj)
  {
    this.Kgr = paramLong;
    this.Kgs = paramj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.c.i
 * JD-Core Version:    0.7.0.1
 */