package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlinx/coroutines/CompletedIdempotentResult;", "", "idempotentResume", "result", "(Ljava/lang/Object;Ljava/lang/Object;)V", "toString", "", "kotlinx-coroutines-core"})
final class v
{
  public final Object result;
  
  public final String toString()
  {
    AppMethodBeat.i(118191);
    String str = "CompletedIdempotentResult[" + this.result + ']';
    AppMethodBeat.o(118191);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.coroutines.v
 * JD-Core Version:    0.7.0.1
 */