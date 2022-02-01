package kotlin.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.e.c;
import kotlin.g.b.a.a;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/ranges/LongProgression;", "", "", "start", "endInclusive", "step", "(JJJ)V", "first", "getFirst", "()J", "last", "getLast", "getStep", "equals", "", "other", "", "hashCode", "", "isEmpty", "iterator", "Lkotlin/collections/LongIterator;", "toString", "", "Companion", "kotlin-stdlib"})
public class g
  implements Iterable<Long>, a
{
  public static final a SZd;
  public final long BMh;
  public final long SZc;
  public final long first;
  
  static
  {
    AppMethodBeat.i(129320);
    SZd = new a((byte)0);
    AppMethodBeat.o(129320);
  }
  
  public g(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(129319);
    if (paramLong3 == 0L)
    {
      localThrowable = (Throwable)new IllegalArgumentException("Step must be non-zero.");
      AppMethodBeat.o(129319);
      throw localThrowable;
    }
    if (paramLong3 == -9223372036854775808L)
    {
      localThrowable = (Throwable)new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
      AppMethodBeat.o(129319);
      throw localThrowable;
    }
    this.first = paramLong1;
    long l;
    if (paramLong3 > 0L) {
      if (paramLong1 >= paramLong2) {
        l = paramLong2;
      }
    }
    for (;;)
    {
      this.SZc = l;
      this.BMh = paramLong3;
      AppMethodBeat.o(129319);
      return;
      l = paramLong2 - c.t(paramLong2, paramLong1, paramLong3);
      continue;
      if (paramLong3 >= 0L) {
        break;
      }
      l = paramLong2;
      if (paramLong1 > paramLong2) {
        l = paramLong2 + c.t(paramLong1, paramLong2, -paramLong3);
      }
    }
    Throwable localThrowable = (Throwable)new IllegalArgumentException("Step is zero.");
    AppMethodBeat.o(129319);
    throw localThrowable;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(129316);
    if (((paramObject instanceof g)) && (((isEmpty()) && (((g)paramObject).isEmpty())) || ((this.first == ((g)paramObject).first) && (this.SZc == ((g)paramObject).SZc) && (this.BMh == ((g)paramObject).BMh))))
    {
      AppMethodBeat.o(129316);
      return true;
    }
    AppMethodBeat.o(129316);
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(129317);
    if (isEmpty())
    {
      AppMethodBeat.o(129317);
      return -1;
    }
    int i = (int)(((this.first ^ this.first >>> 32) * 31L + (this.SZc ^ this.SZc >>> 32)) * 31L + (this.BMh ^ this.BMh >>> 32));
    AppMethodBeat.o(129317);
    return i;
  }
  
  public boolean isEmpty()
  {
    if (this.BMh > 0L) {
      if (this.first <= this.SZc) {}
    }
    while (this.first < this.SZc)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public String toString()
  {
    AppMethodBeat.i(129318);
    if (this.BMh > 0L)
    {
      str = this.first + ".." + this.SZc + " step " + this.BMh;
      AppMethodBeat.o(129318);
      return str;
    }
    String str = this.first + " downTo " + this.SZc + " step " + -this.BMh;
    AppMethodBeat.o(129318);
    return str;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/ranges/LongProgression$Companion;", "", "()V", "fromClosedRange", "Lkotlin/ranges/LongProgression;", "rangeStart", "", "rangeEnd", "step", "kotlin-stdlib"})
  public static final class a
  {
    public static g u(long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(129321);
      g localg = new g(paramLong1, paramLong2, paramLong3);
      AppMethodBeat.o(129321);
      return localg;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.k.g
 * JD-Core Version:    0.7.0.1
 */