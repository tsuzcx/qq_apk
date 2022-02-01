package kotlin.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlin/ranges/ClosedDoubleRange;", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "start", "endInclusive", "(DD)V", "_endInclusive", "_start", "getEndInclusive", "()Ljava/lang/Double;", "getStart", "contains", "", "value", "equals", "other", "", "hashCode", "", "isEmpty", "lessThanOrEquals", "a", "b", "toString", "", "kotlin-stdlib"})
final class a
  implements b<Double>
{
  private final double aaBO;
  private final double aaBP;
  
  public a(double paramDouble)
  {
    this.aaBO = paramDouble;
    this.aaBP = 1.777777777777778D;
  }
  
  private boolean isEmpty()
  {
    return this.aaBO > this.aaBP;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(217166);
    if (((paramObject instanceof a)) && (((isEmpty()) && (((a)paramObject).isEmpty())) || ((this.aaBO == ((a)paramObject).aaBO) && (this.aaBP == ((a)paramObject).aaBP))))
    {
      AppMethodBeat.o(217166);
      return true;
    }
    AppMethodBeat.o(217166);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(217167);
    if (isEmpty())
    {
      AppMethodBeat.o(217167);
      return -1;
    }
    int i = Double.valueOf(this.aaBO).hashCode();
    int j = Double.valueOf(this.aaBP).hashCode();
    AppMethodBeat.o(217167);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(217168);
    String str = this.aaBO + ".." + this.aaBP;
    AppMethodBeat.o(217168);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.k.a
 * JD-Core Version:    0.7.0.1
 */