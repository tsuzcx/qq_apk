package kotlin.l.b.a.b.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.d.b.u;
import kotlin.l.b.a.b.d.a.e.g;
import kotlin.l.b.a.b.d.a.e.t;
import kotlin.l.b.a.b.d.a.j.a;
import kotlin.l.b.a.b.f.a;
import kotlin.l.b.a.b.f.b;
import kotlin.l.b.a.b.f.c;
import kotlin.n.n;

public final class d
  implements kotlin.l.b.a.b.d.a.j
{
  private final ClassLoader TmI;
  
  public d(ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(57362);
    this.TmI = paramClassLoader;
    AppMethodBeat.o(57362);
  }
  
  public final g a(j.a parama)
  {
    AppMethodBeat.i(57359);
    p.h(parama, "request");
    parama = parama.Tfj;
    b localb = parama.hIY();
    p.g(localb, "classId.packageFqName");
    parama = parama.hIZ().sG();
    p.g(parama, "classId.relativeClassName.asString()");
    parama = n.a(parama, '.', '$');
    if (localb.TCR.TCW.isEmpty()) {}
    for (;;)
    {
      parama = e.a(this.TmI, parama);
      if (parama == null) {
        break;
      }
      parama = (g)new kotlin.l.b.a.b.b.d.b.j(parama);
      AppMethodBeat.o(57359);
      return parama;
      parama = localb.sG() + "." + parama;
    }
    AppMethodBeat.o(57359);
    return null;
  }
  
  public final t i(b paramb)
  {
    AppMethodBeat.i(57360);
    p.h(paramb, "fqName");
    paramb = (t)new u(paramb);
    AppMethodBeat.o(57360);
    return paramb;
  }
  
  public final Set<String> j(b paramb)
  {
    AppMethodBeat.i(57361);
    p.h(paramb, "packageFqName");
    AppMethodBeat.o(57361);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.b.d.a.d
 * JD-Core Version:    0.7.0.1
 */