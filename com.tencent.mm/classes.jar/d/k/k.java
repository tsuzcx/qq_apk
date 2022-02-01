package d.k;

import com.tencent.matrix.trace.core.AppMethodBeat;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/ranges/ClosedDoubleRange;", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "start", "endInclusive", "(DD)V", "_endInclusive", "_start", "getEndInclusive", "()Ljava/lang/Double;", "getStart", "contains", "", "value", "equals", "other", "", "hashCode", "", "isEmpty", "lessThanOrEquals", "a", "b", "toString", "", "kotlin-stdlib"})
final class k
  implements l<Double>
{
  private final double OfN;
  private final double OfO;
  
  public k(double paramDouble)
  {
    this.OfN = paramDouble;
    this.OfO = 1.777777777777778D;
  }
  
  private boolean isEmpty()
  {
    return this.OfN > this.OfO;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(221198);
    if (((paramObject instanceof k)) && (((isEmpty()) && (((k)paramObject).isEmpty())) || ((this.OfN == ((k)paramObject).OfN) && (this.OfO == ((k)paramObject).OfO))))
    {
      AppMethodBeat.o(221198);
      return true;
    }
    AppMethodBeat.o(221198);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(221199);
    if (isEmpty())
    {
      AppMethodBeat.o(221199);
      return -1;
    }
    int i = Double.valueOf(this.OfN).hashCode();
    int j = Double.valueOf(this.OfO).hashCode();
    AppMethodBeat.o(221199);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(221200);
    String str = this.OfN + ".." + this.OfO;
    AppMethodBeat.o(221200);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.k.k
 * JD-Core Version:    0.7.0.1
 */