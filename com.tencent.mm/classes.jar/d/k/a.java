package d.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlin/ranges/ClosedDoubleRange;", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "start", "endInclusive", "(DD)V", "_endInclusive", "_start", "getEndInclusive", "()Ljava/lang/Double;", "getStart", "contains", "", "value", "equals", "other", "", "hashCode", "", "isEmpty", "lessThanOrEquals", "a", "b", "toString", "", "kotlin-stdlib"})
final class a
  implements b<Double>
{
  private final double Njk;
  private final double Njl;
  
  public a(double paramDouble)
  {
    this.Njk = paramDouble;
    this.Njl = 1.777777777777778D;
  }
  
  private boolean isEmpty()
  {
    return this.Njk > this.Njl;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(188738);
    if (((paramObject instanceof a)) && (((isEmpty()) && (((a)paramObject).isEmpty())) || ((this.Njk == ((a)paramObject).Njk) && (this.Njl == ((a)paramObject).Njl))))
    {
      AppMethodBeat.o(188738);
      return true;
    }
    AppMethodBeat.o(188738);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(188739);
    if (isEmpty())
    {
      AppMethodBeat.o(188739);
      return -1;
    }
    int i = Double.valueOf(this.Njk).hashCode();
    int j = Double.valueOf(this.Njl).hashCode();
    AppMethodBeat.o(188739);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(188740);
    String str = this.Njk + ".." + this.Njl;
    AppMethodBeat.o(188740);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.k.a
 * JD-Core Version:    0.7.0.1
 */