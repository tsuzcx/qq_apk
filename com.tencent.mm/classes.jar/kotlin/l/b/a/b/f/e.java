package kotlin.l.b.a.b.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.s;
import kotlin.n.n;

public final class e
{
  private static boolean a(c paramc1, c paramc2)
  {
    AppMethodBeat.i(59318);
    s.u(paramc1, "<this>");
    s.u(paramc2, "packageName");
    if (s.p(paramc1, paramc2))
    {
      AppMethodBeat.o(59318);
      return true;
    }
    if (paramc2.isRoot())
    {
      AppMethodBeat.o(59318);
      return true;
    }
    paramc1 = paramc1.PF();
    s.s(paramc1, "this.asString()");
    paramc2 = paramc2.PF();
    s.s(paramc2, "packageName.asString()");
    if ((n.U(paramc1, paramc2, false)) && (paramc1.charAt(paramc2.length()) == '.'))
    {
      AppMethodBeat.o(59318);
      return true;
    }
    AppMethodBeat.o(59318);
    return false;
  }
  
  public static final c b(c paramc1, c paramc2)
  {
    AppMethodBeat.i(59319);
    s.u(paramc1, "<this>");
    s.u(paramc2, "prefix");
    if ((!a(paramc1, paramc2)) || (paramc2.isRoot()))
    {
      AppMethodBeat.o(59319);
      return paramc1;
    }
    if (s.p(paramc1, paramc2))
    {
      paramc1 = c.ajew;
      s.s(paramc1, "ROOT");
      AppMethodBeat.o(59319);
      return paramc1;
    }
    paramc1 = paramc1.PF();
    s.s(paramc1, "asString()");
    paramc1 = paramc1.substring(paramc2.PF().length() + 1);
    s.s(paramc1, "(this as java.lang.String).substring(startIndex)");
    paramc1 = new c(paramc1);
    AppMethodBeat.o(59319);
    return paramc1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.f.e
 * JD-Core Version:    0.7.0.1
 */