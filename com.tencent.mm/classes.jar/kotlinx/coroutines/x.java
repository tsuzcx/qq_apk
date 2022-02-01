package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/coroutines/CompletedWithCancellation;", "", "result", "onCancellation", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "toString", "", "kotlinx-coroutines-core"})
final class x
{
  public final b<Throwable, z> NHO;
  public final Object result;
  
  public final String toString()
  {
    AppMethodBeat.i(190759);
    String str = "CompletedWithCancellation[" + this.result + ']';
    AppMethodBeat.o(190759);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.coroutines.x
 * JD-Core Version:    0.7.0.1
 */