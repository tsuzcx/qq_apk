package kotlin.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lkotlin/ranges/ClosedDoubleRange;", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "start", "endInclusive", "(DD)V", "_endInclusive", "_start", "getEndInclusive", "()Ljava/lang/Double;", "getStart", "contains", "", "value", "equals", "other", "", "hashCode", "", "isEmpty", "lessThanOrEquals", "a", "b", "toString", "", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
final class a
  implements c<Double>
{
  private final double aixo;
  private final double aixp;
  
  public a(double paramDouble1, double paramDouble2)
  {
    this.aixo = paramDouble1;
    this.aixp = paramDouble2;
  }
  
  private boolean isEmpty()
  {
    return this.aixo > this.aixp;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(190873);
    if (((paramObject instanceof a)) && (((isEmpty()) && (((a)paramObject).isEmpty())) || ((this.aixo == ((a)paramObject).aixo) && (this.aixp == ((a)paramObject).aixp))))
    {
      AppMethodBeat.o(190873);
      return true;
    }
    AppMethodBeat.o(190873);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(190881);
    if (isEmpty())
    {
      AppMethodBeat.o(190881);
      return -1;
    }
    int i = Double.valueOf(this.aixo).hashCode();
    int j = Double.valueOf(this.aixp).hashCode();
    AppMethodBeat.o(190881);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(190885);
    String str = this.aixo + ".." + this.aixp;
    AppMethodBeat.o(190885);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlin.k.a
 * JD-Core Version:    0.7.0.1
 */