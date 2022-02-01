package d.l.b.a.b.m.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;

public final class a<T>
{
  final T LNc;
  public final T LNd;
  
  public a(T paramT1, T paramT2)
  {
    this.LNc = paramT1;
    this.LNd = paramT2;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(61259);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((!k.g(this.LNc, paramObject.LNc)) || (!k.g(this.LNd, paramObject.LNd))) {}
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
    Object localObject = this.LNc;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = this.LNd;
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
    String str = "ApproximationBounds(lower=" + this.LNc + ", upper=" + this.LNd + ")";
    AppMethodBeat.o(61257);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.l.b.a.b.m.e.a
 * JD-Core Version:    0.7.0.1
 */