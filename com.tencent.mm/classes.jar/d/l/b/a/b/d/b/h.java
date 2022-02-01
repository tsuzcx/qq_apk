package d.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
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
  public static final h LrS;
  
  static
  {
    AppMethodBeat.i(58196);
    LrS = new h();
    AppMethodBeat.o(58196);
  }
  
  public final ab a(a.p paramp, String paramString, aj paramaj1, aj paramaj2)
  {
    AppMethodBeat.i(58195);
    k.h(paramp, "proto");
    k.h(paramString, "flexibleId");
    k.h(paramaj1, "lowerBound");
    k.h(paramaj2, "upperBound");
    if ((k.g(paramString, "kotlin.jvm.PlatformType") ^ true))
    {
      paramp = u.aWR("Error java flexible type with id: " + paramString + ". (" + paramaj1 + ".." + paramaj2 + ')');
      k.g(paramp, "ErrorUtils.createErrorTy…owerBound..$upperBound)\")");
      paramp = (ab)paramp;
      AppMethodBeat.o(58195);
      return paramp;
    }
    if (paramp.c(a.Lyj))
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