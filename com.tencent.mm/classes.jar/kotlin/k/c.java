package kotlin.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.a.a;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlin/ranges/IntProgression;", "", "", "start", "endInclusive", "step", "(III)V", "first", "getFirst", "()I", "last", "getLast", "getStep", "equals", "", "other", "", "hashCode", "isEmpty", "iterator", "Lkotlin/collections/IntIterator;", "toString", "", "Companion", "kotlin-stdlib"})
public class c
  implements Iterable<Integer>, a
{
  public static final a aaBR;
  public final int aaBQ;
  public final int dHa;
  public final int oxQ;
  
  static
  {
    AppMethodBeat.i(129297);
    aaBR = new a((byte)0);
    AppMethodBeat.o(129297);
  }
  
  public c(int paramInt1, int paramInt2, int paramInt3)
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
    this.dHa = paramInt1;
    int i;
    if (paramInt3 > 0) {
      if (paramInt1 >= paramInt2) {
        i = paramInt2;
      }
    }
    for (;;)
    {
      this.aaBQ = i;
      this.oxQ = paramInt3;
      AppMethodBeat.o(129296);
      return;
      i = paramInt2 - kotlin.e.c.bk(paramInt2, paramInt1, paramInt3);
      continue;
      if (paramInt3 >= 0) {
        break;
      }
      i = paramInt2;
      if (paramInt1 > paramInt2) {
        i = paramInt2 + kotlin.e.c.bk(paramInt1, paramInt2, -paramInt3);
      }
    }
    Throwable localThrowable = (Throwable)new IllegalArgumentException("Step is zero.");
    AppMethodBeat.o(129296);
    throw localThrowable;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(129293);
    if (((paramObject instanceof c)) && (((isEmpty()) && (((c)paramObject).isEmpty())) || ((this.dHa == ((c)paramObject).dHa) && (this.aaBQ == ((c)paramObject).aaBQ) && (this.oxQ == ((c)paramObject).oxQ))))
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
    int i = this.dHa;
    int j = this.aaBQ;
    int k = this.oxQ;
    AppMethodBeat.o(129294);
    return (i * 31 + j) * 31 + k;
  }
  
  public boolean isEmpty()
  {
    if (this.oxQ > 0) {
      if (this.dHa <= this.aaBQ) {}
    }
    while (this.dHa < this.aaBQ)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public String toString()
  {
    AppMethodBeat.i(129295);
    if (this.oxQ > 0)
    {
      str = this.dHa + ".." + this.aaBQ + " step " + this.oxQ;
      AppMethodBeat.o(129295);
      return str;
    }
    String str = this.dHa + " downTo " + this.aaBQ + " step " + -this.oxQ;
    AppMethodBeat.o(129295);
    return str;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlin/ranges/IntProgression$Companion;", "", "()V", "fromClosedRange", "Lkotlin/ranges/IntProgression;", "rangeStart", "", "rangeEnd", "step", "kotlin-stdlib"})
  public static final class a
  {
    public static c bl(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(129305);
      c localc = new c(paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(129305);
      return localc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.k.c
 * JD-Core Version:    0.7.0.1
 */