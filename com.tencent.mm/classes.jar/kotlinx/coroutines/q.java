package kotlinx.coroutines;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlinx/coroutines/CompletedExceptionally;", "", "cause", "", "(Ljava/lang/Throwable;)V", "toString", "", "kotlinx-coroutines-core"})
public class q
{
  public final Throwable cause;
  
  public q(Throwable paramThrowable)
  {
    AppMethodBeat.i(118475);
    this.cause = paramThrowable;
    AppMethodBeat.o(118475);
  }
  
  public String toString()
  {
    AppMethodBeat.i(118474);
    String str = af.ea(this) + '[' + this.cause + ']';
    AppMethodBeat.o(118474);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.q
 * JD-Core Version:    0.7.0.1
 */