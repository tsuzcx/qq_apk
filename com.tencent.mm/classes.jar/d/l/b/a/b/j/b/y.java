package d.l.b.a.b.j.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l.b.a.b.a.g;
import d.l.b.a.b.a.g.a;
import d.l.b.a.b.b.e;
import d.l.b.a.b.b.s;
import d.l.b.a.b.f.a;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.u;

public final class y
  extends aa<Long>
{
  public y(long paramLong)
  {
    super(Long.valueOf(paramLong));
    AppMethodBeat.i(60125);
    AppMethodBeat.o(60125);
  }
  
  public final ab b(d.l.b.a.b.b.y paramy)
  {
    AppMethodBeat.i(60123);
    p.h(paramy, "module");
    a locala = g.Nng.NoE;
    p.g(locala, "KotlinBuiltIns.FQ_NAMES.uLong");
    paramy = s.b(paramy, locala);
    if (paramy != null)
    {
      paramy = paramy.gne();
      if (paramy != null)
      {
        paramy = (ab)paramy;
        AppMethodBeat.o(60123);
        return paramy;
      }
    }
    paramy = u.bey("Unsigned type ULong not found");
    p.g(paramy, "ErrorUtils.createErrorTy…ed type ULong not found\")");
    paramy = (ab)paramy;
    AppMethodBeat.o(60123);
    return paramy;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60124);
    String str = ((Number)getValue()).longValue() + ".toULong()";
    AppMethodBeat.o(60124);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.j.b.y
 * JD-Core Version:    0.7.0.1
 */