package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/coroutines/CompletedWithCancellation;", "", "result", "onCancellation", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "toString", "", "kotlinx-coroutines-core"})
final class x
{
  public final b<Throwable, z> OeU;
  public final Object result;
  
  public final String toString()
  {
    AppMethodBeat.i(209250);
    String str = "CompletedWithCancellation[" + this.result + ']';
    AppMethodBeat.o(209250);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.coroutines.x
 * JD-Core Version:    0.7.0.1
 */