package kotlin.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.s;
import kotlin.l.b.a.b.d.a.c.b.f;
import kotlin.l.b.a.b.e.a.p;
import kotlin.l.b.a.b.e.c.a;
import kotlin.l.b.a.b.k.a.r;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.ae;
import kotlin.l.b.a.b.m.al;
import kotlin.l.b.a.b.m.v;

public final class g
  implements r
{
  public static final g aiWF;
  
  static
  {
    AppMethodBeat.i(58196);
    aiWF = new g();
    AppMethodBeat.o(58196);
  }
  
  public final ad a(a.p paramp, String paramString, al paramal1, al paramal2)
  {
    AppMethodBeat.i(58195);
    s.u(paramp, "proto");
    s.u(paramString, "flexibleId");
    s.u(paramal1, "lowerBound");
    s.u(paramal2, "upperBound");
    if (!s.p(paramString, "kotlin.jvm.PlatformType"))
    {
      paramp = v.bJt("Error java flexible type with id: " + paramString + ". (" + paramal1 + ".." + paramal2 + ')');
      s.s(paramp, "createErrorType(\"Error j…owerBound..$upperBound)\")");
      paramp = (ad)paramp;
      AppMethodBeat.o(58195);
      return paramp;
    }
    if (paramp.c(a.ajdq))
    {
      paramp = (ad)new f(paramal1, paramal2);
      AppMethodBeat.o(58195);
      return paramp;
    }
    paramp = (ad)ae.a(paramal1, paramal2);
    AppMethodBeat.o(58195);
    return paramp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.d.b.g
 * JD-Core Version:    0.7.0.1
 */