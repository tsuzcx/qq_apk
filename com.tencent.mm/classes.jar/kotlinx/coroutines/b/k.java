package kotlinx.coroutines.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/scheduling/TaskImpl;", "Lkotlinx/coroutines/scheduling/Task;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "submissionTime", "", "taskContext", "Lkotlinx/coroutines/scheduling/TaskContext;", "(Ljava/lang/Runnable;JLkotlinx/coroutines/scheduling/TaskContext;)V", "run", "", "toString", "", "kotlinx-coroutines-core"})
public final class k
  extends i
{
  public final Runnable TUC;
  
  public k(Runnable paramRunnable, long paramLong, j paramj)
  {
    super(paramLong, paramj);
    AppMethodBeat.i(117992);
    this.TUC = paramRunnable;
    AppMethodBeat.o(117992);
  }
  
  public final void run()
  {
    AppMethodBeat.i(117990);
    try
    {
      this.TUC.run();
      return;
    }
    finally
    {
      this.TXa.hOe();
      AppMethodBeat.o(117990);
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(117991);
    String str = "Task[" + this.TUC.getClass().getSimpleName() + '@' + Integer.toHexString(System.identityHashCode(this.TUC)) + ", " + this.TWZ + ", " + this.TXa + ']';
    AppMethodBeat.o(117991);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.b.k
 * JD-Core Version:    0.7.0.1
 */