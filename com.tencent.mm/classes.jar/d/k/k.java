package d.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"checkStepIsPositive", "", "isPositive", "", "step", "", "contains", "T", "", "R", "", "Lkotlin/ranges/ClosedRange;", "element", "(Ljava/lang/Iterable;Ljava/lang/Object;)Z", "rangeTo", "", "that", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Lkotlin/ranges/ClosedRange;", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "", "kotlin-stdlib"}, gkc=1)
public class k
{
  public static final b<Double> L(double paramDouble)
  {
    AppMethodBeat.i(188736);
    b localb = (b)new a(paramDouble);
    AppMethodBeat.o(188736);
    return localb;
  }
  
  public static final void a(boolean paramBoolean, Number paramNumber)
  {
    AppMethodBeat.i(129312);
    p.h(paramNumber, "step");
    if (!paramBoolean)
    {
      paramNumber = (Throwable)new IllegalArgumentException("Step must be positive, was: " + paramNumber + '.');
      AppMethodBeat.o(129312);
      throw paramNumber;
    }
    AppMethodBeat.o(129312);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.k.k
 * JD-Core Version:    0.7.0.1
 */