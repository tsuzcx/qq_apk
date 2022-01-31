package kotlinx.coroutines.c;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlinx/coroutines/scheduling/Task;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "()V", "submissionTime", "", "taskContext", "Lkotlinx/coroutines/scheduling/TaskContext;", "(JLkotlinx/coroutines/scheduling/TaskContext;)V", "mode", "Lkotlinx/coroutines/scheduling/TaskMode;", "getMode", "()Lkotlinx/coroutines/scheduling/TaskMode;", "kotlinx-coroutines-core"})
public abstract class i
  implements Runnable
{
  public j CKA;
  public long CKz;
  
  public i()
  {
    this(0L, (j)h.CKy);
  }
  
  public i(long paramLong, j paramj)
  {
    this.CKz = paramLong;
    this.CKA = paramj;
  }
  
  public final l eqJ()
  {
    return this.CKA.eqI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     kotlinx.coroutines.c.i
 * JD-Core Version:    0.7.0.1
 */