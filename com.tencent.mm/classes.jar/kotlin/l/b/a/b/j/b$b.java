package kotlin.l.b.a.b.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.l.b.a.b.b.a;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.m.a.e.a;
import kotlin.l.b.a.b.m.ax;

final class b$b
  implements e.a
{
  b$b(boolean paramBoolean, a parama1, a parama2) {}
  
  public final boolean a(ax paramax1, ax paramax2)
  {
    AppMethodBeat.i(59875);
    s.u(paramax1, "c1");
    s.u(paramax2, "c2");
    if (s.p(paramax1, paramax2))
    {
      AppMethodBeat.o(59875);
      return true;
    }
    paramax1 = paramax1.knA();
    paramax2 = paramax2.knA();
    if ((!(paramax1 instanceof ba)) || (!(paramax2 instanceof ba)))
    {
      AppMethodBeat.o(59875);
      return false;
    }
    boolean bool = b.ajiF.a((ba)paramax1, (ba)paramax2, this.ajiH, (m)new u(this.ajiI) {});
    AppMethodBeat.o(59875);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlin.l.b.a.b.j.b.b
 * JD-Core Version:    0.7.0.1
 */