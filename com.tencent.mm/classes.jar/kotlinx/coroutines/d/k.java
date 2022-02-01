package kotlinx.coroutines.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/scheduling/TaskImpl;", "Lkotlinx/coroutines/scheduling/Task;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "submissionTime", "", "taskContext", "Lkotlinx/coroutines/scheduling/TaskContext;", "(Ljava/lang/Runnable;JLkotlinx/coroutines/scheduling/TaskContext;)V", "run", "", "toString", "", "kotlinx-coroutines-core"})
public final class k
  extends i
{
  public final Runnable abxf;
  
  public k(Runnable paramRunnable, long paramLong, j paramj)
  {
    super(paramLong, paramj);
    AppMethodBeat.i(117992);
    this.abxf = paramRunnable;
    AppMethodBeat.o(117992);
  }
  
  public final void run()
  {
    AppMethodBeat.i(117990);
    try
    {
      this.abxf.run();
      return;
    }
    finally
    {
      this.abAr.iTk();
      AppMethodBeat.o(117990);
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(117991);
    String str = "Task[" + this.abxf.getClass().getSimpleName() + '@' + Integer.toHexString(System.identityHashCode(this.abxf)) + ", " + this.abAq + ", " + this.abAr + ']';
    AppMethodBeat.o(117991);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     kotlinx.coroutines.d.k
 * JD-Core Version:    0.7.0.1
 */