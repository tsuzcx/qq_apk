package d.l.b.a.b.m.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;

public final class a<T>
{
  final T JZJ;
  public final T JZK;
  
  public a(T paramT1, T paramT2)
  {
    this.JZJ = paramT1;
    this.JZK = paramT2;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(61259);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((!k.g(this.JZJ, paramObject.JZJ)) || (!k.g(this.JZK, paramObject.JZK))) {}
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
    Object localObject = this.JZJ;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = this.JZK;
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
    String str = "ApproximationBounds(lower=" + this.JZJ + ", upper=" + this.JZK + ")";
    AppMethodBeat.o(61257);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.l.b.a.b.m.e.a
 * JD-Core Version:    0.7.0.1
 */