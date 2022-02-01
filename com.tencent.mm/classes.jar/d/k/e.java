package d.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.e.c;
import d.g.b.a.a;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlin/ranges/LongProgression;", "", "", "start", "endInclusive", "step", "(JJJ)V", "first", "getFirst", "()J", "last", "getLast", "getStep", "equals", "", "other", "", "hashCode", "", "isEmpty", "iterator", "Lkotlin/collections/LongIterator;", "toString", "", "Companion", "kotlin-stdlib"})
public class e
  implements a, Iterable<Long>
{
  public static final a JhQ;
  public final long JhP;
  public final long first;
  public final long vfC;
  
  static
  {
    AppMethodBeat.i(129320);
    JhQ = new a((byte)0);
    AppMethodBeat.o(129320);
  }
  
  public e(long paramLong1, long paramLong2, long paramLong3)
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
      this.JhP = l;
      this.vfC = paramLong3;
      AppMethodBeat.o(129319);
      return;
      l = paramLong2 - c.s(paramLong2, paramLong1, paramLong3);
      continue;
      if (paramLong3 >= 0L) {
        break;
      }
      l = paramLong2;
      if (paramLong1 > paramLong2) {
        l = paramLong2 + c.s(paramLong1, paramLong2, -paramLong3);
      }
    }
    Throwable localThrowable = (Throwable)new IllegalArgumentException("Step is zero.");
    AppMethodBeat.o(129319);
    throw localThrowable;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(129316);
    if (((paramObject instanceof e)) && (((isEmpty()) && (((e)paramObject).isEmpty())) || ((this.first == ((e)paramObject).first) && (this.JhP == ((e)paramObject).JhP) && (this.vfC == ((e)paramObject).vfC))))
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
    int i = (int)(((this.first ^ this.first >>> 32) * 31L + (this.JhP ^ this.JhP >>> 32)) * 31L + (this.vfC ^ this.vfC >>> 32));
    AppMethodBeat.o(129317);
    return i;
  }
  
  public boolean isEmpty()
  {
    if (this.vfC > 0L) {
      if (this.first <= this.JhP) {}
    }
    while (this.first < this.JhP)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public String toString()
  {
    AppMethodBeat.i(129318);
    if (this.vfC > 0L)
    {
      str = this.first + ".." + this.JhP + " step " + this.vfC;
      AppMethodBeat.o(129318);
      return str;
    }
    String str = this.first + " downTo " + this.JhP + " step " + -this.vfC;
    AppMethodBeat.o(129318);
    return str;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlin/ranges/LongProgression$Companion;", "", "()V", "fromClosedRange", "Lkotlin/ranges/LongProgression;", "rangeStart", "", "rangeEnd", "step", "kotlin-stdlib"})
  public static final class a
  {
    public static e t(long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(129321);
      e locale = new e(paramLong1, paramLong2, paramLong3);
      AppMethodBeat.o(129321);
      return locale;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.k.e
 * JD-Core Version:    0.7.0.1
 */