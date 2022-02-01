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

public final class z
  extends aa<Short>
{
  public z(short paramShort)
  {
    super(Short.valueOf(paramShort));
    AppMethodBeat.i(60128);
    AppMethodBeat.o(60128);
  }
  
  public final ab b(y paramy)
  {
    AppMethodBeat.i(60126);
    p.h(paramy, "module");
    a locala = g.MQb.MRx;
    p.g(locala, "KotlinBuiltIns.FQ_NAMES.uShort");
    paramy = s.b(paramy, locala);
    if (paramy != null)
    {
      paramy = paramy.giC();
      if (paramy != null)
      {
        paramy = (ab)paramy;
        AppMethodBeat.o(60126);
        return paramy;
      }
    }
    paramy = u.bcU("Unsigned type UShort not found");
    p.g(paramy, "ErrorUtils.createErrorTy…d type UShort not found\")");
    paramy = (ab)paramy;
    AppMethodBeat.o(60126);
    return paramy;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60127);
    String str = ((Number)getValue()).shortValue() + ".toUShort()";
    AppMethodBeat.o(60127);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.j.b.z
 * JD-Core Version:    0.7.0.1
 */