package kotlin.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/ranges/LongRange;", "Lkotlin/ranges/LongProgression;", "Lkotlin/ranges/ClosedRange;", "", "start", "endInclusive", "(JJ)V", "getEndInclusive", "()Ljava/lang/Long;", "getStart", "contains", "", "value", "equals", "other", "", "hashCode", "", "isEmpty", "toString", "", "Companion", "kotlin-stdlib"})
public final class i
  extends g
  implements c<Long>
{
  private static final i SZg;
  public static final i.a SZh;
  
  static
  {
    AppMethodBeat.i(129302);
    SZh = new i.a((byte)0);
    SZg = new i(1L, 0L);
    AppMethodBeat.o(129302);
  }
  
  public i(long paramLong1, long paramLong2)
  {
    super(paramLong1, paramLong2, 1L);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(129299);
    if (((paramObject instanceof i)) && (((isEmpty()) && (((i)paramObject).isEmpty())) || ((this.first == ((i)paramObject).first) && (this.SZc == ((i)paramObject).SZc))))
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
    int i = (int)(31L * (this.first ^ this.first >>> 32) + (this.SZc ^ this.SZc >>> 32));
    AppMethodBeat.o(129300);
    return i;
  }
  
  public final boolean isEmpty()
  {
    return this.first > this.SZc;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(129301);
    String str = this.first + ".." + this.SZc;
    AppMethodBeat.o(129301);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     kotlin.k.i
 * JD-Core Version:    0.7.0.1
 */