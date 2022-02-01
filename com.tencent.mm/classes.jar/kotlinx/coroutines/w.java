package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.l;
import d.y;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlinx/coroutines/CompletedWithCancellation;", "", "result", "onCancellation", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "toString", "", "kotlinx-coroutines-core"})
final class w
{
  public final b<Throwable, y> LQT;
  public final Object result;
  
  public final String toString()
  {
    AppMethodBeat.i(191149);
    String str = "CompletedWithCancellation[" + this.result + ']';
    AppMethodBeat.o(191149);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.coroutines.w
 * JD-Core Version:    0.7.0.1
 */