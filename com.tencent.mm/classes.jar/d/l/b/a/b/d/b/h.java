package d.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l.b.a.b.d.a.c.b.g;
import d.l.b.a.b.e.a.p;
import d.l.b.a.b.e.c.a;
import d.l.b.a.b.k.a.s;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.ac;
import d.l.b.a.b.m.aj;
import d.l.b.a.b.m.u;

public final class h
  implements s
{
  public static final h NFV;
  
  static
  {
    AppMethodBeat.i(58196);
    NFV = new h();
    AppMethodBeat.o(58196);
  }
  
  public final ab a(a.p paramp, String paramString, aj paramaj1, aj paramaj2)
  {
    AppMethodBeat.i(58195);
    p.h(paramp, "proto");
    p.h(paramString, "flexibleId");
    p.h(paramaj1, "lowerBound");
    p.h(paramaj2, "upperBound");
    if ((p.i(paramString, "kotlin.jvm.PlatformType") ^ true))
    {
      paramp = u.bey("Error java flexible type with id: " + paramString + ". (" + paramaj1 + ".." + paramaj2 + ')');
      p.g(paramp, "ErrorUtils.createErrorTy…owerBound..$upperBound)\")");
      paramp = (ab)paramp;
      AppMethodBeat.o(58195);
      return paramp;
    }
    if (paramp.c(a.NMm))
    {
      paramp = (ab)new g(paramaj1, paramaj2);
      AppMethodBeat.o(58195);
      return paramp;
    }
    paramp = (ab)ac.a(paramaj1, paramaj2);
    AppMethodBeat.o(58195);
    return paramp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.d.b.h
 * JD-Core Version:    0.7.0.1
 */