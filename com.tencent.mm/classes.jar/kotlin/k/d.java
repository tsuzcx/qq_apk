package kotlin.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.e.c;
import kotlin.g.b.a.a;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/ranges/IntProgression;", "", "", "start", "endInclusive", "step", "(III)V", "first", "getFirst", "()I", "last", "getLast", "getStep", "equals", "", "other", "", "hashCode", "isEmpty", "iterator", "Lkotlin/collections/IntIterator;", "toString", "", "Companion", "kotlin-stdlib"})
public class d
  implements Iterable<Integer>, a
{
  public static final a SYW;
  public final int SYU;
  public final int SYV;
  public final int lCq;
  
  static
  {
    AppMethodBeat.i(129297);
    SYW = new a((byte)0);
    AppMethodBeat.o(129297);
  }
  
  public d(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(129296);
    if (paramInt3 == 0)
    {
      localThrowable = (Throwable)new IllegalArgumentException("Step must be non-zero.");
      AppMethodBeat.o(129296);
      throw localThrowable;
    }
    if (paramInt3 == -2147483648)
    {
      localThrowable = (Throwable)new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
      AppMethodBeat.o(129296);
      throw localThrowable;
    }
    this.SYU = paramInt1;
    int i;
    if (paramInt3 > 0) {
      if (paramInt1 >= paramInt2) {
        i = paramInt2;
      }
    }
    for (;;)
    {
      this.SYV = i;
      this.lCq = paramInt3;
      AppMethodBeat.o(129296);
      return;
      i = paramInt2 - c.bf(paramInt2, paramInt1, paramInt3);
      continue;
      if (paramInt3 >= 0) {
        break;
      }
      i = paramInt2;
      if (paramInt1 > paramInt2) {
        i = paramInt2 + c.bf(paramInt1, paramInt2, -paramInt3);
      }
    }
    Throwable localThrowable = (Throwable)new IllegalArgumentException("Step is zero.");
    AppMethodBeat.o(129296);
    throw localThrowable;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(129293);
    if (((paramObject instanceof d)) && (((isEmpty()) && (((d)paramObject).isEmpty())) || ((this.SYU == ((d)paramObject).SYU) && (this.SYV == ((d)paramObject).SYV) && (this.lCq == ((d)paramObject).lCq))))
    {
      AppMethodBeat.o(129293);
      return true;
    }
    AppMethodBeat.o(129293);
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(129294);
    if (isEmpty())
    {
      AppMethodBeat.o(129294);
      return -1;
    }
    int i = this.SYU;
    int j = this.SYV;
    int k = this.lCq;
    AppMethodBeat.o(129294);
    return (i * 31 + j) * 31 + k;
  }
  
  public boolean isEmpty()
  {
    if (this.lCq > 0) {
      if (this.SYU <= this.SYV) {}
    }
    while (this.SYU < this.SYV)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public String toString()
  {
    AppMethodBeat.i(129295);
    if (this.lCq > 0)
    {
      str = this.SYU + ".." + this.SYV + " step " + this.lCq;
      AppMethodBeat.o(129295);
      return str;
    }
    String str = this.SYU + " downTo " + this.SYV + " step " + -this.lCq;
    AppMethodBeat.o(129295);
    return str;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/ranges/IntProgression$Companion;", "", "()V", "fromClosedRange", "Lkotlin/ranges/IntProgression;", "rangeStart", "", "rangeEnd", "step", "kotlin-stdlib"})
  public static final class a
  {
    public static d bg(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(129305);
      d locald = new d(paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(129305);
      return locald;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.k.d
 * JD-Core Version:    0.7.0.1
 */