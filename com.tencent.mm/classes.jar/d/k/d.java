package d.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.e.c;
import d.g.b.a.a;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlin/ranges/IntProgression;", "", "", "start", "endInclusive", "step", "(III)V", "first", "getFirst", "()I", "last", "getLast", "getStep", "equals", "", "other", "", "hashCode", "isEmpty", "iterator", "Lkotlin/collections/IntIterator;", "toString", "", "Companion", "kotlin-stdlib"})
public class d
  implements a, Iterable<Integer>
{
  public static final a Njo;
  public final int Njm;
  public final int Njn;
  public final int kyd;
  
  static
  {
    AppMethodBeat.i(129297);
    Njo = new a((byte)0);
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
    this.Njm = paramInt1;
    int i;
    if (paramInt3 > 0) {
      if (paramInt1 >= paramInt2) {
        i = paramInt2;
      }
    }
    for (;;)
    {
      this.Njn = i;
      this.kyd = paramInt3;
      AppMethodBeat.o(129296);
      return;
      i = paramInt2 - c.aZ(paramInt2, paramInt1, paramInt3);
      continue;
      if (paramInt3 >= 0) {
        break;
      }
      i = paramInt2;
      if (paramInt1 > paramInt2) {
        i = paramInt2 + c.aZ(paramInt1, paramInt2, -paramInt3);
      }
    }
    Throwable localThrowable = (Throwable)new IllegalArgumentException("Step is zero.");
    AppMethodBeat.o(129296);
    throw localThrowable;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(129293);
    if (((paramObject instanceof d)) && (((isEmpty()) && (((d)paramObject).isEmpty())) || ((this.Njm == ((d)paramObject).Njm) && (this.Njn == ((d)paramObject).Njn) && (this.kyd == ((d)paramObject).kyd))))
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
    int i = this.Njm;
    int j = this.Njn;
    int k = this.kyd;
    AppMethodBeat.o(129294);
    return (i * 31 + j) * 31 + k;
  }
  
  public boolean isEmpty()
  {
    if (this.kyd > 0) {
      if (this.Njm <= this.Njn) {}
    }
    while (this.Njm < this.Njn)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public String toString()
  {
    AppMethodBeat.i(129295);
    if (this.kyd > 0)
    {
      str = this.Njm + ".." + this.Njn + " step " + this.kyd;
      AppMethodBeat.o(129295);
      return str;
    }
    String str = this.Njm + " downTo " + this.Njn + " step " + -this.kyd;
    AppMethodBeat.o(129295);
    return str;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlin/ranges/IntProgression$Companion;", "", "()V", "fromClosedRange", "Lkotlin/ranges/IntProgression;", "rangeStart", "", "rangeEnd", "step", "kotlin-stdlib"})
  public static final class a
  {
    public static d ba(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(129305);
      d locald = new d(paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(129305);
      return locald;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.k.d
 * JD-Core Version:    0.7.0.1
 */