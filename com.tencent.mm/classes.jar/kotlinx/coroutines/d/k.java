package kotlinx.coroutines.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/scheduling/TaskImpl;", "Lkotlinx/coroutines/scheduling/Task;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "submissionTime", "", "taskContext", "Lkotlinx/coroutines/scheduling/TaskContext;", "(Ljava/lang/Runnable;JLkotlinx/coroutines/scheduling/TaskContext;)V", "run", "", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  extends i
{
  public final Runnable ajwg;
  
  public k(Runnable paramRunnable, long paramLong, j paramj)
  {
    super(paramLong, paramj);
    AppMethodBeat.i(117992);
    this.ajwg = paramRunnable;
    AppMethodBeat.o(117992);
  }
  
  public final void run()
  {
    AppMethodBeat.i(117990);
    try
    {
      this.ajwg.run();
      return;
    }
    finally
    {
      this.ajBI.kED();
      AppMethodBeat.o(117990);
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(117991);
    String str = "Task[" + this.ajwg.getClass().getSimpleName() + '@' + Integer.toHexString(System.identityHashCode(this.ajwg)) + ", " + this.ajBH + ", " + this.ajBI + ']';
    AppMethodBeat.o(117991);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.d.k
 * JD-Core Version:    0.7.0.1
 */