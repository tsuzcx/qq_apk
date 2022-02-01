package d.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/ranges/LongRange;", "Lkotlin/ranges/LongProgression;", "Lkotlin/ranges/ClosedRange;", "", "start", "endInclusive", "(JJ)V", "getEndInclusive", "()Ljava/lang/Long;", "getStart", "contains", "", "value", "equals", "other", "", "hashCode", "", "isEmpty", "toString", "", "Companion", "kotlin-stdlib"})
public final class g
  extends e
  implements a<Long>
{
  private static final g MMt;
  public static final a MMu;
  
  static
  {
    AppMethodBeat.i(129302);
    MMu = new a((byte)0);
    MMt = new g(1L, 0L);
    AppMethodBeat.o(129302);
  }
  
  public g(long paramLong1, long paramLong2)
  {
    super(paramLong1, paramLong2, 1L);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(129299);
    if (((paramObject instanceof g)) && (((isEmpty()) && (((g)paramObject).isEmpty())) || ((this.first == ((g)paramObject).first) && (this.MMp == ((g)paramObject).MMp))))
    {
      AppMethodBeat.o(129299);
      return true;
    }
    AppMethodBeat.o(129299);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(129300);
    if (isEmpty())
    {
      AppMethodBeat.o(129300);
      return -1;
    }
    int i = (int)(31L * (this.first ^ this.first >>> 32) + (this.MMp ^ this.MMp >>> 32));
    AppMethodBeat.o(129300);
    return i;
  }
  
  public final boolean isEmpty()
  {
    return this.first > this.MMp;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(129301);
    String str = this.first + ".." + this.MMp;
    AppMethodBeat.o(129301);
    return str;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/ranges/LongRange$Companion;", "", "()V", "EMPTY", "Lkotlin/ranges/LongRange;", "getEMPTY", "()Lkotlin/ranges/LongRange;", "kotlin-stdlib"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.k.g
 * JD-Core Version:    0.7.0.1
 */