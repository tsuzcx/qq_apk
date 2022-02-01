package kotlin.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.d.a.c.b.g;
import kotlin.l.b.a.b.e.a.p;
import kotlin.l.b.a.b.e.c.a;
import kotlin.l.b.a.b.k.a.s;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.ac;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.b.a.b.m.u;

public final class h
  implements s
{
  public static final h TvB;
  
  static
  {
    AppMethodBeat.i(58196);
    TvB = new h();
    AppMethodBeat.o(58196);
  }
  
  public final ab a(a.p paramp, String paramString, aj paramaj1, aj paramaj2)
  {
    AppMethodBeat.i(58195);
    p.h(paramp, "proto");
    p.h(paramString, "flexibleId");
    p.h(paramaj1, "lowerBound");
    p.h(paramaj2, "upperBound");
    if ((p.j(paramString, "kotlin.jvm.PlatformType") ^ true))
    {
      paramp = u.bun("Error java flexible type with id: " + paramString + ". (" + paramaj1 + ".." + paramaj2 + ')');
      p.g(paramp, "ErrorUtils.createErrorTy…owerBound..$upperBound)\")");
      paramp = (ab)paramp;
      AppMethodBeat.o(58195);
      return paramp;
    }
    if (paramp.c(a.TBQ))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.d.b.h
 * JD-Core Version:    0.7.0.1
 */