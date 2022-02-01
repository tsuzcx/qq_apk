package kotlin.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lkotlin/ranges/IntRange;", "Lkotlin/ranges/IntProgression;", "Lkotlin/ranges/ClosedRange;", "", "start", "endInclusive", "(II)V", "getEndInclusive", "()Ljava/lang/Integer;", "getStart", "contains", "", "value", "equals", "other", "", "hashCode", "isEmpty", "toString", "", "Companion", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class g
  extends e
  implements d<Integer>
{
  private static final g aixw;
  public static final a aixx;
  
  static
  {
    AppMethodBeat.i(129326);
    aixx = new a((byte)0);
    aixw = new g(1, 0);
    AppMethodBeat.o(129326);
  }
  
  public g(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2, 1);
  }
  
  public final boolean aKs(int paramInt)
  {
    return (this.fIj <= paramInt) && (paramInt <= this.aixs);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(129323);
    if (((paramObject instanceof g)) && (((isEmpty()) && (((g)paramObject).isEmpty())) || ((this.fIj == ((g)paramObject).fIj) && (this.aixs == ((g)paramObject).aixs))))
    {
      AppMethodBeat.o(129323);
      return true;
    }
    AppMethodBeat.o(129323);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(129324);
    if (isEmpty())
    {
      AppMethodBeat.o(129324);
      return -1;
    }
    int i = this.fIj;
    int j = this.aixs;
    AppMethodBeat.o(129324);
    return i * 31 + j;
  }
  
  public final boolean isEmpty()
  {
    return this.fIj > this.aixs;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(129325);
    String str = this.fIj + ".." + this.aixs;
    AppMethodBeat.o(129325);
    return str;
  }
  
  @Metadata(d1={""}, d2={"Lkotlin/ranges/IntRange$Companion;", "", "()V", "EMPTY", "Lkotlin/ranges/IntRange;", "getEMPTY", "()Lkotlin/ranges/IntRange;", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlin.k.g
 * JD-Core Version:    0.7.0.1
 */