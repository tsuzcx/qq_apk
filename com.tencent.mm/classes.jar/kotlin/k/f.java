package kotlin.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.e.c;
import kotlin.g.b.a.a;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlin/ranges/LongProgression;", "", "", "start", "endInclusive", "step", "(JJJ)V", "first", "getFirst", "()J", "last", "getLast", "getStep", "equals", "", "other", "", "hashCode", "", "isEmpty", "iterator", "Lkotlin/collections/LongIterator;", "toString", "", "Companion", "kotlin-stdlib"})
public class f
  implements Iterable<Long>, a
{
  public static final a aaBX;
  public final long HIt;
  public final long aaBW;
  public final long first;
  
  static
  {
    AppMethodBeat.i(129320);
    aaBX = new a((byte)0);
    AppMethodBeat.o(129320);
  }
  
  public f(long paramLong1, long paramLong2, long paramLong3)
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
      this.aaBW = l;
      this.HIt = paramLong3;
      AppMethodBeat.o(129319);
      return;
      l = paramLong2 - c.v(paramLong2, paramLong1, paramLong3);
      continue;
      if (paramLong3 >= 0L) {
        break;
      }
      l = paramLong2;
      if (paramLong1 > paramLong2) {
        l = paramLong2 + c.v(paramLong1, paramLong2, -paramLong3);
      }
    }
    Throwable localThrowable = (Throwable)new IllegalArgumentException("Step is zero.");
    AppMethodBeat.o(129319);
    throw localThrowable;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(129316);
    if (((paramObject instanceof f)) && (((isEmpty()) && (((f)paramObject).isEmpty())) || ((this.first == ((f)paramObject).first) && (this.aaBW == ((f)paramObject).aaBW) && (this.HIt == ((f)paramObject).HIt))))
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
    int i = (int)(((this.first ^ this.first >>> 32) * 31L + (this.aaBW ^ this.aaBW >>> 32)) * 31L + (this.HIt ^ this.HIt >>> 32));
    AppMethodBeat.o(129317);
    return i;
  }
  
  public boolean isEmpty()
  {
    if (this.HIt > 0L) {
      if (this.first <= this.aaBW) {}
    }
    while (this.first < this.aaBW)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public String toString()
  {
    AppMethodBeat.i(129318);
    if (this.HIt > 0L)
    {
      str = this.first + ".." + this.aaBW + " step " + this.HIt;
      AppMethodBeat.o(129318);
      return str;
    }
    String str = this.first + " downTo " + this.aaBW + " step " + -this.HIt;
    AppMethodBeat.o(129318);
    return str;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlin/ranges/LongProgression$Companion;", "", "()V", "fromClosedRange", "Lkotlin/ranges/LongProgression;", "rangeStart", "", "rangeEnd", "step", "kotlin-stdlib"})
  public static final class a
  {
    public static f w(long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(129321);
      f localf = new f(paramLong1, paramLong2, paramLong3);
      AppMethodBeat.o(129321);
      return localf;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.k.f
 * JD-Core Version:    0.7.0.1
 */