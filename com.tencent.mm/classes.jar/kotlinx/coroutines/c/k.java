package kotlinx.coroutines.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlinx/coroutines/scheduling/TaskImpl;", "Lkotlinx/coroutines/scheduling/Task;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "submissionTime", "", "taskContext", "Lkotlinx/coroutines/scheduling/TaskContext;", "(Ljava/lang/Runnable;JLkotlinx/coroutines/scheduling/TaskContext;)V", "run", "", "toString", "", "kotlinx-coroutines-core"})
public final class k
  extends i
{
  public final Runnable Kgt;
  
  public k(Runnable paramRunnable, long paramLong, j paramj)
  {
    super(paramLong, paramj);
    AppMethodBeat.i(117992);
    this.Kgt = paramRunnable;
    AppMethodBeat.o(117992);
  }
  
  public final void run()
  {
    AppMethodBeat.i(117990);
    try
    {
      this.Kgt.run();
      return;
    }
    finally
    {
      this.Kgs.fMg();
      AppMethodBeat.o(117990);
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(117991);
    String str = "Task[" + this.Kgt.getClass().getSimpleName() + '@' + Integer.toHexString(System.identityHashCode(this.Kgt)) + ", " + this.Kgr + ", " + this.Kgs + ']';
    AppMethodBeat.o(117991);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.c.k
 * JD-Core Version:    0.7.0.1
 */