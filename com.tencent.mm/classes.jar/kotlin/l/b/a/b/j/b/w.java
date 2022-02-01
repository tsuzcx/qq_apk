package kotlin.l.b.a.b.j.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.s;
import kotlin.l.b.a.b.a.k.a;
import kotlin.l.b.a.b.b.ae;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.v;

public final class w
  extends z<Integer>
{
  public w(int paramInt)
  {
    super(Integer.valueOf(paramInt));
    AppMethodBeat.i(60122);
    AppMethodBeat.o(60122);
  }
  
  public final ad c(ae paramae)
  {
    AppMethodBeat.i(60120);
    s.u(paramae, "module");
    paramae = kotlin.l.b.a.b.b.w.b(paramae, k.a.aiDS);
    if (paramae == null) {}
    for (paramae = null; paramae == null; paramae = paramae.koj())
    {
      paramae = v.bJt("Unsigned type UInt not found");
      s.s(paramae, "createErrorType(\"Unsigned type UInt not found\")");
      paramae = (ad)paramae;
      AppMethodBeat.o(60120);
      return paramae;
    }
    paramae = (ad)paramae;
    AppMethodBeat.o(60120);
    return paramae;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60121);
    String str = ((Number)getValue()).intValue() + ".toUInt()";
    AppMethodBeat.o(60121);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.j.b.w
 * JD-Core Version:    0.7.0.1
 */