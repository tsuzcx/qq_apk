package kotlin.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lkotlin/ranges/ClosedFloatRange;", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "start", "endInclusive", "(FF)V", "_endInclusive", "_start", "getEndInclusive", "()Ljava/lang/Float;", "getStart", "contains", "", "value", "equals", "other", "", "hashCode", "", "isEmpty", "lessThanOrEquals", "a", "b", "toString", "", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class b
  implements c<Float>
{
  private final float aixq = 0.0F;
  private final float aixr = 0.0F;
  
  private boolean isEmpty()
  {
    return this.aixq > this.aixr;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(190878);
    if (((paramObject instanceof b)) && (((isEmpty()) && (((b)paramObject).isEmpty())) || ((this.aixq == ((b)paramObject).aixq) && (this.aixr == ((b)paramObject).aixr))))
    {
      AppMethodBeat.o(190878);
      return true;
    }
    AppMethodBeat.o(190878);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(190884);
    if (isEmpty())
    {
      AppMethodBeat.o(190884);
      return -1;
    }
    int i = Float.valueOf(this.aixq).hashCode();
    int j = Float.valueOf(this.aixr).hashCode();
    AppMethodBeat.o(190884);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(190887);
    String str = this.aixq + ".." + this.aixr;
    AppMethodBeat.o(190887);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlin.k.b
 * JD-Core Version:    0.7.0.1
 */