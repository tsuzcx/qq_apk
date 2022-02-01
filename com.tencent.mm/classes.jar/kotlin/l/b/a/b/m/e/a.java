package kotlin.l.b.a.b.m.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.s;

public final class a<T>
{
  final T ajrO;
  public final T ajrP;
  
  public a(T paramT1, T paramT2)
  {
    this.ajrO = paramT1;
    this.ajrP = paramT2;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(61259);
    if (this == paramObject)
    {
      AppMethodBeat.o(61259);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(61259);
      return false;
    }
    paramObject = (a)paramObject;
    if (!s.p(this.ajrO, paramObject.ajrO))
    {
      AppMethodBeat.o(61259);
      return false;
    }
    if (!s.p(this.ajrP, paramObject.ajrP))
    {
      AppMethodBeat.o(61259);
      return false;
    }
    AppMethodBeat.o(61259);
    return true;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(61258);
    int i;
    if (this.ajrO == null)
    {
      i = 0;
      if (this.ajrP != null) {
        break label46;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(61258);
      return i * 31 + j;
      i = this.ajrO.hashCode();
      break;
      label46:
      j = this.ajrP.hashCode();
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(61257);
    String str = "ApproximationBounds(lower=" + this.ajrO + ", upper=" + this.ajrP + ')';
    AppMethodBeat.o(61257);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.l.b.a.b.m.e.a
 * JD-Core Version:    0.7.0.1
 */