package d.l.b.a.b.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l.b.a.b.e.a.p;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.aj;

public abstract interface s
{
  public abstract ab a(a.p paramp, String paramString, aj paramaj1, aj paramaj2);
  
  public static final class a
    implements s
  {
    public static final a JUO;
    
    static
    {
      AppMethodBeat.i(60318);
      JUO = new a();
      AppMethodBeat.o(60318);
    }
    
    public final ab a(a.p paramp, String paramString, aj paramaj1, aj paramaj2)
    {
      AppMethodBeat.i(60317);
      k.h(paramp, "proto");
      k.h(paramString, "flexibleId");
      k.h(paramaj1, "lowerBound");
      k.h(paramaj2, "upperBound");
      paramp = (Throwable)new IllegalArgumentException("This method should not be used.");
      AppMethodBeat.o(60317);
      throw paramp;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.k.a.s
 * JD-Core Version:    0.7.0.1
 */