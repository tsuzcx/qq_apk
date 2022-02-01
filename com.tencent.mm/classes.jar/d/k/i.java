package d.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;

@d.l(gfA=1, gfx={1, 1, 16}, gfy={""}, gfz={"checkStepIsPositive", "", "isPositive", "", "step", "", "contains", "T", "", "R", "", "Lkotlin/ranges/ClosedRange;", "element", "(Ljava/lang/Iterable;Ljava/lang/Object;)Z", "rangeTo", "", "that", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Lkotlin/ranges/ClosedRange;", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "", "kotlin-stdlib"})
public class i
{
  public static final l<Double> O(double paramDouble)
  {
    AppMethodBeat.i(221196);
    l locall = (l)new k(paramDouble);
    AppMethodBeat.o(221196);
    return locall;
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
 * Qualified Name:     d.k.i
 * JD-Core Version:    0.7.0.1
 */