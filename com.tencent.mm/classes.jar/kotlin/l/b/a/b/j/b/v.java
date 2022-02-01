package kotlin.l.b.a.b.j.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.s;
import kotlin.l.b.a.b.a.k.a;
import kotlin.l.b.a.b.b.ae;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.w;
import kotlin.l.b.a.b.m.ad;

public final class v
  extends z<Byte>
{
  public v(byte paramByte)
  {
    super(Byte.valueOf(paramByte));
    AppMethodBeat.i(60119);
    AppMethodBeat.o(60119);
  }
  
  public final ad c(ae paramae)
  {
    AppMethodBeat.i(60117);
    s.u(paramae, "module");
    paramae = w.b(paramae, k.a.aiDQ);
    if (paramae == null) {}
    for (paramae = null; paramae == null; paramae = paramae.koj())
    {
      paramae = kotlin.l.b.a.b.m.v.bJt("Unsigned type UByte not found");
      s.s(paramae, "createErrorType(\"Unsigned type UByte not found\")");
      paramae = (ad)paramae;
      AppMethodBeat.o(60117);
      return paramae;
    }
    paramae = (ad)paramae;
    AppMethodBeat.o(60117);
    return paramae;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60118);
    String str = ((Number)getValue()).intValue() + ".toUByte()";
    AppMethodBeat.o(60118);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.j.b.v
 * JD-Core Version:    0.7.0.1
 */