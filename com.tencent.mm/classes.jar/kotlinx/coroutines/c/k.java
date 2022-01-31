package kotlinx.coroutines.c;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlinx.coroutines.af;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlinx/coroutines/scheduling/TaskImpl;", "Lkotlinx/coroutines/scheduling/Task;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "submissionTime", "", "taskContext", "Lkotlinx/coroutines/scheduling/TaskContext;", "(Ljava/lang/Runnable;JLkotlinx/coroutines/scheduling/TaskContext;)V", "run", "", "toString", "", "kotlinx-coroutines-core"})
public final class k
  extends i
{
  public final Runnable CKB;
  
  public k(Runnable paramRunnable, long paramLong, j paramj)
  {
    super(paramLong, paramj);
    AppMethodBeat.i(118316);
    this.CKB = paramRunnable;
    AppMethodBeat.o(118316);
  }
  
  public final void run()
  {
    AppMethodBeat.i(118314);
    try
    {
      this.CKB.run();
      return;
    }
    finally
    {
      this.CKA.eqH();
      AppMethodBeat.o(118314);
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118315);
    String str = "Task[" + af.ea(this.CKB) + '@' + af.dZ(this.CKB) + ", " + this.CKz + ", " + this.CKA + ']';
    AppMethodBeat.o(118315);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     kotlinx.coroutines.c.k
 * JD-Core Version:    0.7.0.1
 */