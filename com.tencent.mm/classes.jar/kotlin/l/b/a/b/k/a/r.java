package kotlin.l.b.a.b.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.s;
import kotlin.l.b.a.b.e.a.p;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.al;

public abstract interface r
{
  public abstract ad a(a.p paramp, String paramString, al paramal1, al paramal2);
  
  public static final class a
    implements r
  {
    public static final a ajmv;
    
    static
    {
      AppMethodBeat.i(60318);
      ajmv = new a();
      AppMethodBeat.o(60318);
    }
    
    public final ad a(a.p paramp, String paramString, al paramal1, al paramal2)
    {
      AppMethodBeat.i(60317);
      s.u(paramp, "proto");
      s.u(paramString, "flexibleId");
      s.u(paramal1, "lowerBound");
      s.u(paramal2, "upperBound");
      paramp = new IllegalArgumentException("This method should not be used.");
      AppMethodBeat.o(60317);
      throw paramp;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.k.a.r
 * JD-Core Version:    0.7.0.1
 */