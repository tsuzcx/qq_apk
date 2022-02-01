package kotlin.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.e.c;
import kotlin.g.b.a.a;

@Metadata(d1={""}, d2={"Lkotlin/ranges/LongProgression;", "", "", "start", "endInclusive", "step", "(JJJ)V", "first", "getFirst", "()J", "last", "getLast", "getStep", "equals", "", "other", "", "hashCode", "", "isEmpty", "iterator", "Lkotlin/collections/LongIterator;", "toString", "", "Companion", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public class h
  implements Iterable<Long>, a
{
  public static final a aixz;
  public final long NFM;
  public final long aixy;
  public final long first;
  
  static
  {
    AppMethodBeat.i(129320);
    aixz = new a((byte)0);
    AppMethodBeat.o(129320);
  }
  
  public h(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(129319);
    Throwable localThrowable;
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
    this.aixy = c.A(paramLong1, paramLong2, paramLong3);
    this.NFM = paramLong3;
    AppMethodBeat.o(129319);
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(129316);
    if (((paramObject instanceof h)) && (((isEmpty()) && (((h)paramObject).isEmpty())) || ((this.first == ((h)paramObject).first) && (this.aixy == ((h)paramObject).aixy) && (this.NFM == ((h)paramObject).NFM))))
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
    int i = (int)(((this.first ^ this.first >>> 32) * 31L + (this.aixy ^ this.aixy >>> 32)) * 31L + (this.NFM ^ this.NFM >>> 32));
    AppMethodBeat.o(129317);
    return i;
  }
  
  public boolean isEmpty()
  {
    if (this.NFM > 0L) {
      if (this.first <= this.aixy) {}
    }
    while (this.first < this.aixy)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public String toString()
  {
    AppMethodBeat.i(129318);
    if (this.NFM > 0L)
    {
      str = this.first + ".." + this.aixy + " step " + this.NFM;
      AppMethodBeat.o(129318);
      return str;
    }
    String str = this.first + " downTo " + this.aixy + " step " + -this.NFM;
    AppMethodBeat.o(129318);
    return str;
  }
  
  @Metadata(d1={""}, d2={"Lkotlin/ranges/LongProgression$Companion;", "", "()V", "fromClosedRange", "Lkotlin/ranges/LongProgression;", "rangeStart", "", "rangeEnd", "step", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlin.k.h
 * JD-Core Version:    0.7.0.1
 */