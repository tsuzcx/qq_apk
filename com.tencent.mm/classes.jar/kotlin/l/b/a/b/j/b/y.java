package kotlin.l.b.a.b.j.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.s;
import kotlin.l.b.a.b.a.k.a;
import kotlin.l.b.a.b.b.ae;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.w;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.v;

public final class y
  extends z<Short>
{
  public y(short paramShort)
  {
    super(Short.valueOf(paramShort));
    AppMethodBeat.i(60128);
    AppMethodBeat.o(60128);
  }
  
  public final ad c(ae paramae)
  {
    AppMethodBeat.i(60126);
    s.u(paramae, "module");
    paramae = w.b(paramae, k.a.aiDR);
    if (paramae == null) {}
    for (paramae = null; paramae == null; paramae = paramae.koj())
    {
      paramae = v.bJt("Unsigned type UShort not found");
      s.s(paramae, "createErrorType(\"Unsigned type UShort not found\")");
      paramae = (ad)paramae;
      AppMethodBeat.o(60126);
      return paramae;
    }
    paramae = (ad)paramae;
    AppMethodBeat.o(60126);
    return paramae;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60127);
    String str = ((Number)getValue()).intValue() + ".toUShort()";
    AppMethodBeat.o(60127);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.j.b.y
 * JD-Core Version:    0.7.0.1
 */