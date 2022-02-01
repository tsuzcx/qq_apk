package d.l.b.a.b.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l.b.a.b.b.d.b.u;
import d.l.b.a.b.d.a.e.g;
import d.l.b.a.b.d.a.e.t;
import d.l.b.a.b.d.a.j.a;
import d.l.b.a.b.f.a;
import d.l.b.a.b.f.b;
import d.l.b.a.b.f.c;
import d.n.n;
import java.util.Set;

public final class d
  implements d.l.b.a.b.d.a.j
{
  private final ClassLoader MZU;
  
  public d(ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(57362);
    this.MZU = paramClassLoader;
    AppMethodBeat.o(57362);
  }
  
  public final g a(j.a parama)
  {
    AppMethodBeat.i(57359);
    p.h(parama, "request");
    parama = parama.MSw;
    b localb = parama.gqZ();
    p.g(localb, "classId.packageFqName");
    parama = parama.gra().sD();
    p.g(parama, "classId.relativeClassName.asString()");
    parama = n.a(parama, '.', '$');
    if (localb.Nqg.Nql.isEmpty()) {}
    for (;;)
    {
      parama = e.a(this.MZU, parama);
      if (parama == null) {
        break;
      }
      parama = (g)new d.l.b.a.b.b.d.b.j(parama);
      AppMethodBeat.o(57359);
      return parama;
      parama = localb.sD() + "." + parama;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.b.d.a.d
 * JD-Core Version:    0.7.0.1
 */