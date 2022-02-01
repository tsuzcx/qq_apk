package d.l.b.a.b.m.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;

public final class a<T>
{
  final T NDX;
  public final T NDY;
  
  public a(T paramT1, T paramT2)
  {
    this.NDX = paramT1;
    this.NDY = paramT2;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(61259);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((!p.i(this.NDX, paramObject.NDX)) || (!p.i(this.NDY, paramObject.NDY))) {}
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
    Object localObject = this.NDX;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = this.NDY;
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
    String str = "ApproximationBounds(lower=" + this.NDX + ", upper=" + this.NDY + ")";
    AppMethodBeat.o(61257);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.l.b.a.b.m.e.a
 * JD-Core Version:    0.7.0.1
 */