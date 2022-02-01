package d.l.b.a.b.m.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;

public final class a<T>
{
  final T Obe;
  public final T Obf;
  
  public a(T paramT1, T paramT2)
  {
    this.Obe = paramT1;
    this.Obf = paramT2;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(61259);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((!p.i(this.Obe, paramObject.Obe)) || (!p.i(this.Obf, paramObject.Obf))) {}
      }
    }
    else
    {
      AppMethodBeat.o(61259);
      return true;
    }
    AppMethodBeat.o(61259);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(61258);
    Object localObject = this.Obe;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = this.Obf;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      AppMethodBeat.o(61258);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(61257);
    String str = "ApproximationBounds(lower=" + this.Obe + ", upper=" + this.Obf + ")";
    AppMethodBeat.o(61257);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.l.b.a.b.m.e.a
 * JD-Core Version:    0.7.0.1
 */