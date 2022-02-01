package d.l.b.a.b.j.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l.b.a.b.a.g;
import d.l.b.a.b.a.g.a;
import d.l.b.a.b.b.e;
import d.l.b.a.b.b.s;
import d.l.b.a.b.b.y;
import d.l.b.a.b.f.a;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.u;

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
    k.h(paramy, "module");
    a locala = g.KZg.LaB;
    k.g(locala, "KotlinBuiltIns.FQ_NAMES.uByte");
    paramy = s.b(paramy, locala);
    if (paramy != null)
    {
      paramy = paramy.fRe();
      if (paramy != null)
      {
        paramy = (ab)paramy;
        AppMethodBeat.o(60117);
        return paramy;
      }
    }
    paramy = u.aWR("Unsigned type UByte not found");
    k.g(paramy, "ErrorUtils.createErrorTy…ed type UByte not found\")");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.j.b.w
 * JD-Core Version:    0.7.0.1
 */