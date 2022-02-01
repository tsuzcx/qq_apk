package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.b;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/CompletedWithCancellation;", "", "result", "onCancellation", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "toString", "", "kotlinx-coroutines-core"})
final class y
{
  public final b<Throwable, x> TTO;
  public final Object result;
  
  public final String toString()
  {
    AppMethodBeat.i(192385);
    String str = "CompletedWithCancellation[" + this.result + ']';
    AppMethodBeat.o(192385);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.coroutines.y
 * JD-Core Version:    0.7.0.1
 */