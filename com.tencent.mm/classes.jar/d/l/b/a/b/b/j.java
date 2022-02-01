package d.l.b.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l.b.a.b.a.g;
import d.l.b.a.b.a.m;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.bc;

public final class j
{
  public static final j NrD;
  
  static
  {
    AppMethodBeat.i(56849);
    NrD = new j();
    AppMethodBeat.o(56849);
  }
  
  public static final boolean G(ab paramab)
  {
    AppMethodBeat.i(56848);
    p.h(paramab, "type");
    p.h(paramab, "$this$canBeUsedForConstVal");
    if (!g.o(paramab))
    {
      m localm = m.NpG;
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