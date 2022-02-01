package kotlin.l.b.a.b.j.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.a.g;
import kotlin.l.b.a.b.a.g.a;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.s;
import kotlin.l.b.a.b.f.a;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.u;

public final class y
  extends aa<Long>
{
  public y(long paramLong)
  {
    super(Long.valueOf(paramLong));
    AppMethodBeat.i(60125);
    AppMethodBeat.o(60125);
  }
  
  public final ab b(kotlin.l.b.a.b.b.y paramy)
  {
    AppMethodBeat.i(60123);
    p.k(paramy, "module");
    a locala = g.aaFI.aaHg;
    p.j(locala, "KotlinBuiltIns.FQ_NAMES.uLong");
    paramy = s.b(paramy, locala);
    if (paramy != null)
    {
      paramy = paramy.iET();
      if (paramy != null)
      {
        paramy = (ab)paramy;
        AppMethodBeat.o(60123);
        return paramy;
      }
    }
    paramy = u.bHp("Unsigned type ULong not found");
    p.j(paramy, "ErrorUtils.createErrorTy…ed type ULong not found\")");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.j.b.y
 * JD-Core Version:    0.7.0.1
 */