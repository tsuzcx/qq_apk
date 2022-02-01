package d.l.b.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l.b.a.b.a.g;
import d.l.b.a.b.a.m;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.bc;

public final class j
{
  public static final j LdD;
  
  static
  {
    AppMethodBeat.i(56849);
    LdD = new j();
    AppMethodBeat.o(56849);
  }
  
  public static final boolean G(ab paramab)
  {
    AppMethodBeat.i(56848);
    k.h(paramab, "type");
    k.h(paramab, "$this$canBeUsedForConstVal");
    if (!g.o(paramab))
    {
      m localm = m.LbG;
      if (!m.F(paramab)) {
        break label42;
      }
    }
    label42:
    if ((!bc.aF(paramab)) || (g.D(paramab)))
    {
      AppMethodBeat.o(56848);
      return true;
    }
    AppMethodBeat.o(56848);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.b.j
 * JD-Core Version:    0.7.0.1
 */