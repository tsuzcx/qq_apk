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

public final class w
  extends aa<Byte>
{
  public w(byte paramByte)
  {
    super(Byte.valueOf(paramByte));
    AppMethodBeat.i(60119);
    AppMethodBeat.o(60119);
  }
  
  public final ab b(y paramy)
  {
    AppMethodBeat.i(60117);
    p.k(paramy, "module");
    a locala = g.aaFI.aaHd;
    p.j(locala, "KotlinBuiltIns.FQ_NAMES.uByte");
    paramy = s.b(paramy, locala);
    if (paramy != null)
    {
      paramy = paramy.iET();
      if (paramy != null)
      {
        paramy = (ab)paramy;
        AppMethodBeat.o(60117);
        return paramy;
      }
    }
    paramy = u.bHp("Unsigned type UByte not found");
    p.j(paramy, "ErrorUtils.createErrorTy…ed type UByte not found\")");
    paramy = (ab)paramy;
    AppMethodBeat.o(60117);
    return paramy;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60118);
    String str = ((Number)getValue()).byteValue() + ".toUByte()";
    AppMethodBeat.o(60118);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.j.b.w
 * JD-Core Version:    0.7.0.1
 */