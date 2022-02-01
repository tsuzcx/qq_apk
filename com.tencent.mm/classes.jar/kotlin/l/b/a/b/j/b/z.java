package kotlin.l.b.a.b.j.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.a.g;
import kotlin.l.b.a.b.a.g.a;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.s;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.f.a;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.u;

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
    a locala = g.TcO.Tek;
    p.g(locala, "KotlinBuiltIns.FQ_NAMES.uShort");
    paramy = s.b(paramy, locala);
    if (paramy != null)
    {
      paramy = paramy.hAG();
      if (paramy != null)
      {
        paramy = (ab)paramy;
        AppMethodBeat.o(60126);
        return paramy;
      }
    }
    paramy = u.bun("Unsigned type UShort not found");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.j.b.z
 * JD-Core Version:    0.7.0.1
 */