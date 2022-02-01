package kotlin.l.b.a.b.j.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.s;
import kotlin.l.b.a.b.a.k;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.j.f;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.ax;

public final class b
{
  private static boolean V(ad paramad)
  {
    AppMethodBeat.i(60160);
    s.u(paramad, "<this>");
    paramad = paramad.kzm().knA();
    if (paramad != null)
    {
      paramad = (l)paramad;
      s.u(paramad, "<this>");
      if ((f.D(paramad)) && (!s.p(kotlin.l.b.a.b.j.d.a.o((l)paramad), k.aiCn))) {}
      for (int i = 1; i == 1; i = 0)
      {
        AppMethodBeat.o(60160);
        return true;
      }
    }
    AppMethodBeat.o(60160);
    return false;
  }
  
  public static final boolean W(ad paramad)
  {
    AppMethodBeat.i(192192);
    if ((V(paramad)) || (X(paramad)))
    {
      AppMethodBeat.o(192192);
      return true;
    }
    AppMethodBeat.o(192192);
    return false;
  }
  
  private static final boolean X(ad paramad)
  {
    AppMethodBeat.i(60162);
    paramad = paramad.kzm().knA();
    if ((paramad instanceof ba)) {}
    for (paramad = (ba)paramad; paramad == null; paramad = null)
    {
      AppMethodBeat.o(60162);
      return false;
    }
    boolean bool = W(kotlin.l.b.a.b.m.d.a.d(paramad));
    AppMethodBeat.o(60162);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.j.e.b
 * JD-Core Version:    0.7.0.1
 */