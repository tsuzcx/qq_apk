package d.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlin/ranges/LongRange;", "Lkotlin/ranges/LongProgression;", "Lkotlin/ranges/ClosedRange;", "", "start", "endInclusive", "(JJ)V", "getEndInclusive", "()Ljava/lang/Long;", "getStart", "contains", "", "value", "equals", "other", "", "hashCode", "", "isEmpty", "toString", "", "Companion", "kotlin-stdlib"})
public final class i
  extends g
  implements c<Long>
{
  private static final i Njy;
  public static final a Njz;
  
  static
  {
    AppMethodBeat.i(129302);
    Njz = new a((byte)0);
    Njy = new i(1L, 0L);
    AppMethodBeat.o(129302);
  }
  
  public i(long paramLong1, long paramLong2)
  {
    super(paramLong1, paramLong2, 1L);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(129299);
    if (((paramObject instanceof i)) && (((isEmpty()) && (((i)paramObject).isEmpty())) || ((this.first == ((i)paramObject).first) && (this.Nju == ((i)paramObject).Nju))))
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
    int i = (int)(31L * (this.first ^ this.first >>> 32) + (this.Nju ^ this.Nju >>> 32));
    AppMethodBeat.o(129300);
    return i;
  }
  
  public final boolean isEmpty()
  {
    return this.first > this.Nju;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(129301);
    String str = this.first + ".." + this.Nju;
    AppMethodBeat.o(129301);
    return str;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlin/ranges/LongRange$Companion;", "", "()V", "EMPTY", "Lkotlin/ranges/LongRange;", "getEMPTY", "()Lkotlin/ranges/LongRange;", "kotlin-stdlib"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.k.i
 * JD-Core Version:    0.7.0.1
 */