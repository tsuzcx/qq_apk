package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.l;
import d.y;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlinx/coroutines/CompletedWithCancellation;", "", "result", "onCancellation", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "toString", "", "kotlinx-coroutines-core"})
final class t
{
  public final b<Throwable, y> Kdr;
  public final Object result;
  
  public final String toString()
  {
    AppMethodBeat.i(190034);
    String str = "CompletedWithCancellation[" + this.result + ']';
    AppMethodBeat.o(190034);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.coroutines.t
 * JD-Core Version:    0.7.0.1
 */