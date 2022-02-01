package kotlin.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlin/ranges/IntRange;", "Lkotlin/ranges/IntProgression;", "Lkotlin/ranges/ClosedRange;", "", "start", "endInclusive", "(II)V", "getEndInclusive", "()Ljava/lang/Integer;", "getStart", "contains", "", "value", "equals", "other", "", "hashCode", "isEmpty", "toString", "", "Companion", "kotlin-stdlib"})
public final class e
  extends c
{
  private static final e aaBU;
  public static final a aaBV;
  
  static
  {
    AppMethodBeat.i(129326);
    aaBV = new a((byte)0);
    aaBU = new e(1, 0);
    AppMethodBeat.o(129326);
  }
  
  public e(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2, 1);
  }
  
  public final boolean contains(int paramInt)
  {
    return (this.dHa <= paramInt) && (paramInt <= this.aaBQ);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(129323);
    if (((paramObject instanceof e)) && (((isEmpty()) && (((e)paramObject).isEmpty())) || ((this.dHa == ((e)paramObject).dHa) && (this.aaBQ == ((e)paramObject).aaBQ))))
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
    int i = this.dHa;
    int j = this.aaBQ;
    AppMethodBeat.o(129324);
    return i * 31 + j;
  }
  
  public final boolean isEmpty()
  {
    return this.dHa > this.aaBQ;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(129325);
    String str = this.dHa + ".." + this.aaBQ;
    AppMethodBeat.o(129325);
    return str;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlin/ranges/IntRange$Companion;", "", "()V", "EMPTY", "Lkotlin/ranges/IntRange;", "getEMPTY", "()Lkotlin/ranges/IntRange;", "kotlin-stdlib"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.k.e
 * JD-Core Version:    0.7.0.1
 */