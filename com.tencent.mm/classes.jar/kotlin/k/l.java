package kotlin.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"checkStepIsPositive", "", "isPositive", "", "step", "", "contains", "T", "", "R", "", "Lkotlin/ranges/ClosedRange;", "element", "(Ljava/lang/Iterable;Ljava/lang/Object;)Z", "rangeTo", "", "that", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Lkotlin/ranges/ClosedRange;", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "", "kotlin-stdlib"}, k=5, mv={1, 5, 1}, xi=1, xs="kotlin/ranges/RangesKt")
public class l
{
  public static final void a(boolean paramBoolean, Number paramNumber)
  {
    AppMethodBeat.i(129312);
    s.u(paramNumber, "step");
    if (!paramBoolean)
    {
      paramNumber = (Throwable)new IllegalArgumentException("Step must be positive, was: " + paramNumber + '.');
      AppMethodBeat.o(129312);
      throw paramNumber;
    }
    AppMethodBeat.o(129312);
  }
  
  public static final c<Double> z(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(190849);
    c localc = (c)new a(paramDouble1, paramDouble2);
    AppMethodBeat.o(190849);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlin.k.l
 * JD-Core Version:    0.7.0.1
 */