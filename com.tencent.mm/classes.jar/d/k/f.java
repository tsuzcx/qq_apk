package d.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlin/ranges/IntRange;", "Lkotlin/ranges/IntProgression;", "Lkotlin/ranges/ClosedRange;", "", "start", "endInclusive", "(II)V", "getEndInclusive", "()Ljava/lang/Integer;", "getStart", "contains", "", "value", "equals", "other", "", "hashCode", "isEmpty", "toString", "", "Companion", "kotlin-stdlib"})
public final class f
  extends d
  implements c<Integer>
{
  private static final f Njs;
  public static final a Njt;
  
  static
  {
    AppMethodBeat.i(129326);
    Njt = new a((byte)0);
    Njs = new f(1, 0);
    AppMethodBeat.o(129326);
  }
  
  public f(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2, 1);
  }
  
  public final boolean contains(int paramInt)
  {
    return (this.Njm <= paramInt) && (paramInt <= this.Njn);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(129323);
    if (((paramObject instanceof f)) && (((isEmpty()) && (((f)paramObject).isEmpty())) || ((this.Njm == ((f)paramObject).Njm) && (this.Njn == ((f)paramObject).Njn))))
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
    int i = this.Njm;
    int j = this.Njn;
    AppMethodBeat.o(129324);
    return i * 31 + j;
  }
  
  public final boolean isEmpty()
  {
    return this.Njm > this.Njn;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(129325);
    String str = this.Njm + ".." + this.Njn;
    AppMethodBeat.o(129325);
    return str;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlin/ranges/IntRange$Companion;", "", "()V", "EMPTY", "Lkotlin/ranges/IntRange;", "getEMPTY", "()Lkotlin/ranges/IntRange;", "kotlin-stdlib"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.k.f
 * JD-Core Version:    0.7.0.1
 */