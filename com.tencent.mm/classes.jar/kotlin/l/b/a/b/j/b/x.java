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
    p.k(paramy, "module");
    a locala = g.aaFI.aaHf;
    p.j(locala, "KotlinBuiltIns.FQ_NAMES.uInt");
    paramy = s.b(paramy, locala);
    if (paramy != null)
    {
      paramy = paramy.iET();
      if (paramy != null)
      {
        paramy = (ab)paramy;
        AppMethodBeat.o(60120);
        return paramy;
      }
    }
    paramy = u.bHp("Unsigned type UInt not found");
    p.j(paramy, "ErrorUtils.createErrorTy…ned type UInt not found\")");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.j.b.x
 * JD-Core Version:    0.7.0.1
 */