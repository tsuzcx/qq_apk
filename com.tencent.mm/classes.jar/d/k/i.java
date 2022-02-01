package d.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"checkStepIsPositive", "", "isPositive", "", "step", "", "contains", "T", "", "R", "", "Lkotlin/ranges/ClosedRange;", "element", "(Ljava/lang/Iterable;Ljava/lang/Object;)Z", "rangeTo", "", "that", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Lkotlin/ranges/ClosedRange;", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "", "kotlin-stdlib"}, fOb=1)
class i
{
  public static final void a(boolean paramBoolean, Number paramNumber)
  {
    AppMethodBeat.i(129312);
    k.h(paramNumber, "step");
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
 * Qualified Name:     d.k.i
 * JD-Core Version:    0.7.0.1
 */