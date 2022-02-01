package d.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlin/ranges/IntRange;", "Lkotlin/ranges/IntProgression;", "Lkotlin/ranges/ClosedRange;", "", "start", "endInclusive", "(II)V", "getEndInclusive", "()Ljava/lang/Integer;", "getStart", "contains", "", "value", "equals", "other", "", "hashCode", "isEmpty", "toString", "", "Companion", "kotlin-stdlib"})
public final class d
  extends b
  implements a<Integer>
{
  private static final d JhN;
  public static final a JhO;
  
  static
  {
    AppMethodBeat.i(129326);
    JhO = new a((byte)0);
    JhN = new d(1, 0);
    AppMethodBeat.o(129326);
  }
  
  public d(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2, 1);
  }
  
  public final boolean contains(int paramInt)
  {
    return (this.JhH <= paramInt) && (paramInt <= this.JhI);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(129323);
    if (((paramObject instanceof d)) && (((isEmpty()) && (((d)paramObject).isEmpty())) || ((this.JhH == ((d)paramObject).JhH) && (this.JhI == ((d)paramObject).JhI))))
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
    int i = this.JhH;
    int j = this.JhI;
    AppMethodBeat.o(129324);
    return i * 31 + j;
  }
  
  public final boolean isEmpty()
  {
    return this.JhH > this.JhI;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(129325);
    String str = this.JhH + ".." + this.JhI;
    AppMethodBeat.o(129325);
    return str;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlin/ranges/IntRange$Companion;", "", "()V", "EMPTY", "Lkotlin/ranges/IntRange;", "getEMPTY", "()Lkotlin/ranges/IntRange;", "kotlin-stdlib"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.k.d
 * JD-Core Version:    0.7.0.1
 */