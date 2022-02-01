package kotlin.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.ak;
import kotlin.g.b.s;
import kotlin.l.b.a.b.f.b;
import kotlin.l.b.a.b.k.a.g;

public final class f
  implements g
{
  private final m aiRL;
  private final e aiRM;
  
  public f(m paramm, e parame)
  {
    AppMethodBeat.i(58194);
    this.aiRL = paramm;
    this.aiRM = parame;
    AppMethodBeat.o(58194);
  }
  
  public final kotlin.l.b.a.b.k.a.f f(b paramb)
  {
    AppMethodBeat.i(58193);
    s.u(paramb, "classId");
    o localo = n.a(this.aiRL, paramb);
    if (localo == null)
    {
      AppMethodBeat.o(58193);
      return null;
    }
    boolean bool = s.p(localo.kmb(), paramb);
    if ((ak.aiuY) && (!bool))
    {
      paramb = (Throwable)new AssertionError("Class with incorrect id found: expected " + paramb + ", actual " + localo.kmb());
      AppMethodBeat.o(58193);
      throw paramb;
    }
    paramb = this.aiRM.a(localo);
    AppMethodBeat.o(58193);
    return paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.d.b.f
 * JD-Core Version:    0.7.0.1
 */