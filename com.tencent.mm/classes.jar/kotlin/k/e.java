package kotlin.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.e.c;
import kotlin.g.b.a.a;

@Metadata(d1={""}, d2={"Lkotlin/ranges/IntProgression;", "", "", "start", "endInclusive", "step", "(III)V", "first", "getFirst", "()I", "last", "getLast", "getStep", "equals", "", "other", "", "hashCode", "isEmpty", "iterator", "Lkotlin/collections/IntIterator;", "toString", "", "Companion", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public class e
  implements Iterable<Integer>, a
{
  public static final a aixt;
  public final int aixs;
  public final int fIj;
  public final int rBp;
  
  static
  {
    AppMethodBeat.i(129297);
    aixt = new a((byte)0);
    AppMethodBeat.o(129297);
  }
  
  public e(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(129296);
    Throwable localThrowable;
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
    this.fIj = paramInt1;
    this.aixs = c.bO(paramInt1, paramInt2, paramInt3);
    this.rBp = paramInt3;
    AppMethodBeat.o(129296);
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(129293);
    if (((paramObject instanceof e)) && (((isEmpty()) && (((e)paramObject).isEmpty())) || ((this.fIj == ((e)paramObject).fIj) && (this.aixs == ((e)paramObject).aixs) && (this.rBp == ((e)paramObject).rBp))))
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
    int i = this.fIj;
    int j = this.aixs;
    int k = this.rBp;
    AppMethodBeat.o(129294);
    return (i * 31 + j) * 31 + k;
  }
  
  public boolean isEmpty()
  {
    if (this.rBp > 0) {
      if (this.fIj <= this.aixs) {}
    }
    while (this.fIj < this.aixs)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public String toString()
  {
    AppMethodBeat.i(129295);
    if (this.rBp > 0)
    {
      str = this.fIj + ".." + this.aixs + " step " + this.rBp;
      AppMethodBeat.o(129295);
      return str;
    }
    String str = this.fIj + " downTo " + this.aixs + " step " + -this.rBp;
    AppMethodBeat.o(129295);
    return str;
  }
  
  @Metadata(d1={""}, d2={"Lkotlin/ranges/IntProgression$Companion;", "", "()V", "fromClosedRange", "Lkotlin/ranges/IntProgression;", "rangeStart", "", "rangeEnd", "step", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
  public static final class a
  {
    public static e bP(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(129305);
      e locale = new e(paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(129305);
      return locale;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlin.k.e
 * JD-Core Version:    0.7.0.1
 */