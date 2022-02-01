package kotlin.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.j.g.h;
import kotlin.l.b.a.b.m.a.g;
import kotlin.l.b.a.b.m.bc;

public abstract class t
  implements e
{
  public static final a aiLm = new a((byte)0);
  
  protected abstract h a(g paramg);
  
  protected abstract h a(bc parambc, g paramg);
  
  public static final class a
  {
    public static h a(e parame, g paramg)
    {
      AppMethodBeat.i(57168);
      s.u(parame, "<this>");
      s.u(paramg, "kotlinTypeRefiner");
      if ((parame instanceof t)) {}
      for (t localt = (t)parame; localt == null; localt = null)
      {
        parame = parame.kot();
        s.s(parame, "this.unsubstitutedMemberScope");
        AppMethodBeat.o(57168);
        return parame;
      }
      parame = localt.a(paramg);
      AppMethodBeat.o(57168);
      return parame;
    }
    
    public static h a(e parame, bc parambc, g paramg)
    {
      AppMethodBeat.i(57169);
      s.u(parame, "<this>");
      s.u(parambc, "typeSubstitution");
      s.u(paramg, "kotlinTypeRefiner");
      if ((parame instanceof t)) {}
      for (t localt = (t)parame; localt == null; localt = null)
      {
        parame = parame.a(parambc);
        s.s(parame, "this.getMemberScope(\n   …ubstitution\n            )");
        AppMethodBeat.o(57169);
        return parame;
      }
      parame = localt.a(parambc, paramg);
      AppMethodBeat.o(57169);
      return parame;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.c.t
 * JD-Core Version:    0.7.0.1
 */