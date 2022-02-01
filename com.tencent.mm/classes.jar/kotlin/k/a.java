package kotlin.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/ranges/ClosedDoubleRange;", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "start", "endInclusive", "(DD)V", "_endInclusive", "_start", "getEndInclusive", "()Ljava/lang/Double;", "getStart", "contains", "", "value", "equals", "other", "", "hashCode", "", "isEmpty", "lessThanOrEquals", "a", "b", "toString", "", "kotlin-stdlib"})
final class a
  implements b<Double>
{
  private final double SYS;
  private final double SYT;
  
  public a(double paramDouble)
  {
    this.SYS = paramDouble;
    this.SYT = 1.777777777777778D;
  }
  
  private boolean isEmpty()
  {
    return this.SYS > this.SYT;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(206221);
    if (((paramObject instanceof a)) && (((isEmpty()) && (((a)paramObject).isEmpty())) || ((this.SYS == ((a)paramObject).SYS) && (this.SYT == ((a)paramObject).SYT))))
    {
      AppMethodBeat.o(206221);
      return true;
    }
    AppMethodBeat.o(206221);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(206222);
    if (isEmpty())
    {
      AppMethodBeat.o(206222);
      return -1;
    }
    int i = Double.valueOf(this.SYS).hashCode();
    int j = Double.valueOf(this.SYT).hashCode();
    AppMethodBeat.o(206222);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(206223);
    String str = this.SYS + ".." + this.SYT;
    AppMethodBeat.o(206223);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.k.a
 * JD-Core Version:    0.7.0.1
 */