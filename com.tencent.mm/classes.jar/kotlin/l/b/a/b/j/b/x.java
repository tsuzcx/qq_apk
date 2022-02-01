package kotlin.l.b.a.b.j.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.s;
import kotlin.l.b.a.b.a.k.a;
import kotlin.l.b.a.b.b.ae;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.w;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.v;

public final class x
  extends z<Long>
{
  public x(long paramLong)
  {
    super(Long.valueOf(paramLong));
    AppMethodBeat.i(60125);
    AppMethodBeat.o(60125);
  }
  
  public final ad c(ae paramae)
  {
    AppMethodBeat.i(60123);
    s.u(paramae, "module");
    paramae = w.b(paramae, k.a.aiDT);
    if (paramae == null) {}
    for (paramae = null; paramae == null; paramae = paramae.koj())
    {
      paramae = v.bJt("Unsigned type ULong not found");
      s.s(paramae, "createErrorType(\"Unsigned type ULong not found\")");
      paramae = (ad)paramae;
      AppMethodBeat.o(60123);
      return paramae;
    }
    paramae = (ad)paramae;
    AppMethodBeat.o(60123);
    return paramae;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60124);
    String str = ((Number)getValue()).longValue() + ".toULong()";
    AppMethodBeat.o(60124);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.j.b.x
 * JD-Core Version:    0.7.0.1
 */