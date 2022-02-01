package kotlin.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/ranges/IntRange;", "Lkotlin/ranges/IntProgression;", "Lkotlin/ranges/ClosedRange;", "", "start", "endInclusive", "(II)V", "getEndInclusive", "()Ljava/lang/Integer;", "getStart", "contains", "", "value", "equals", "other", "", "hashCode", "isEmpty", "toString", "", "Companion", "kotlin-stdlib"})
public final class f
  extends d
  implements c<Integer>
{
  private static final f SZa;
  public static final a SZb;
  
  static
  {
    AppMethodBeat.i(129326);
    SZb = new a((byte)0);
    SZa = new f(1, 0);
    AppMethodBeat.o(129326);
  }
  
  public f(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2, 1);
  }
  
  public final boolean contains(int paramInt)
  {
    return (this.SYU <= paramInt) && (paramInt <= this.SYV);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(129323);
    if (((paramObject instanceof f)) && (((isEmpty()) && (((f)paramObject).isEmpty())) || ((this.SYU == ((f)paramObject).SYU) && (this.SYV == ((f)paramObject).SYV))))
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
    int i = this.SYU;
    int j = this.SYV;
    AppMethodBeat.o(129324);
    return i * 31 + j;
  }
  
  public final boolean isEmpty()
  {
    return this.SYU > this.SYV;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(129325);
    String str = this.SYU + ".." + this.SYV;
    AppMethodBeat.o(129325);
    return str;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/ranges/IntRange$Companion;", "", "()V", "EMPTY", "Lkotlin/ranges/IntRange;", "getEMPTY", "()Lkotlin/ranges/IntRange;", "kotlin-stdlib"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.k.f
 * JD-Core Version:    0.7.0.1
 */