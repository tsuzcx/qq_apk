package d.l.b.a.b.j.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l.b.a.b.a.g;
import d.l.b.a.b.a.g.a;
import d.l.b.a.b.b.e;
import d.l.b.a.b.b.s;
import d.l.b.a.b.b.y;
import d.l.b.a.b.f.a;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.u;

public final class x
  extends aa<Integer>
{
  public x(int paramInt)
  {
    super(Integer.valueOf(paramInt));
    AppMethodBeat.i(60122);
    AppMethodBeat.o(60122);
  }
  
  public final ab b(y paramy)
  {
    AppMethodBeat.i(60120);
    p.h(paramy, "module");
    a locala = g.Nng.NoD;
    p.g(locala, "KotlinBuiltIns.FQ_NAMES.uInt");
    paramy = s.b(paramy, locala);
    if (paramy != null)
    {
      paramy = paramy.gne();
      if (paramy != null)
      {
        paramy = (ab)paramy;
        AppMethodBeat.o(60120);
        return paramy;
      }
    }
    paramy = u.bey("Unsigned type UInt not found");
    p.g(paramy, "ErrorUtils.createErrorTy…ned type UInt not found\")");
    paramy = (ab)paramy;
    AppMethodBeat.o(60120);
    return paramy;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60121);
    String str = ((Number)getValue()).intValue() + ".toUInt()";
    AppMethodBeat.o(60121);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.j.b.x
 * JD-Core Version:    0.7.0.1
 */