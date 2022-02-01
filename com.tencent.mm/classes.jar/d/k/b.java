package d.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.e.c;
import d.g.b.a.a;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlin/ranges/IntProgression;", "", "", "start", "endInclusive", "step", "(III)V", "first", "getFirst", "()I", "last", "getLast", "getStep", "equals", "", "other", "", "hashCode", "isEmpty", "iterator", "Lkotlin/collections/IntIterator;", "toString", "", "Companion", "kotlin-stdlib"})
public class b
  implements a, Iterable<Integer>
{
  public static final a JhJ;
  public final int JhH;
  public final int JhI;
  public final int jzV;
  
  static
  {
    AppMethodBeat.i(129297);
    JhJ = new a((byte)0);
    AppMethodBeat.o(129297);
  }
  
  public b(int paramInt1, int paramInt2, int paramInt3)
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
    this.JhH = paramInt1;
    int i;
    if (paramInt3 > 0) {
      if (paramInt1 >= paramInt2) {
        i = paramInt2;
      }
    }
    for (;;)
    {
      this.JhI = i;
      this.jzV = paramInt3;
      AppMethodBeat.o(129296);
      return;
      i = paramInt2 - c.aV(paramInt2, paramInt1, paramInt3);
      continue;
      if (paramInt3 >= 0) {
        break;
      }
      i = paramInt2;
      if (paramInt1 > paramInt2) {
        i = paramInt2 + c.aV(paramInt1, paramInt2, -paramInt3);
      }
    }
    Throwable localThrowable = (Throwable)new IllegalArgumentException("Step is zero.");
    AppMethodBeat.o(129296);
    throw localThrowable;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(129293);
    if (((paramObject instanceof b)) && (((isEmpty()) && (((b)paramObject).isEmpty())) || ((this.JhH == ((b)paramObject).JhH) && (this.JhI == ((b)paramObject).JhI) && (this.jzV == ((b)paramObject).jzV))))
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
    int i = this.JhH;
    int j = this.JhI;
    int k = this.jzV;
    AppMethodBeat.o(129294);
    return (i * 31 + j) * 31 + k;
  }
  
  public boolean isEmpty()
  {
    if (this.jzV > 0) {
      if (this.JhH <= this.JhI) {}
    }
    while (this.JhH < this.JhI)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public String toString()
  {
    AppMethodBeat.i(129295);
    if (this.jzV > 0)
    {
      str = this.JhH + ".." + this.JhI + " step " + this.jzV;
      AppMethodBeat.o(129295);
      return str;
    }
    String str = this.JhH + " downTo " + this.JhI + " step " + -this.jzV;
    AppMethodBeat.o(129295);
    return str;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlin/ranges/IntProgression$Companion;", "", "()V", "fromClosedRange", "Lkotlin/ranges/IntProgression;", "rangeStart", "", "rangeEnd", "step", "kotlin-stdlib"})
  public static final class a
  {
    public static b aW(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(129305);
      b localb = new b(paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(129305);
      return localb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.k.b
 * JD-Core Version:    0.7.0.1
 */