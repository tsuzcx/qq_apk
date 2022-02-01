package kotlin.l.b.a.b.b.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Set;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.e.b.j;
import kotlin.l.b.a.b.b.e.b.u;
import kotlin.l.b.a.b.d.a.e.g;
import kotlin.l.b.a.b.d.a.e.t;
import kotlin.l.b.a.b.d.a.l;
import kotlin.l.b.a.b.d.a.l.a;
import kotlin.l.b.a.b.f.b;
import kotlin.l.b.a.b.f.c;
import kotlin.n.n;

public final class d
  implements l
{
  private final ClassLoader aiMy;
  
  public d(ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(57362);
    this.aiMy = paramClassLoader;
    AppMethodBeat.o(57362);
  }
  
  public final g a(l.a parama)
  {
    AppMethodBeat.i(57359);
    s.u(parama, "request");
    parama = parama.aiEe;
    c localc = parama.kxL();
    s.s(localc, "classId.packageFqName");
    parama = parama.kxM().PF();
    s.s(parama, "classId.relativeClassName.asString()");
    parama = n.a(parama, '.', '$');
    if (localc.ajex.ajeC.isEmpty()) {}
    for (;;)
    {
      parama = e.e(this.aiMy, parama);
      if (parama == null) {
        break;
      }
      parama = (g)new j(parama);
      AppMethodBeat.o(57359);
      return parama;
      parama = localc.PF() + '.' + parama;
    }
    AppMethodBeat.o(57359);
    return null;
  }
  
  public final t j(c paramc)
  {
    AppMethodBeat.i(57360);
    s.u(paramc, "fqName");
    paramc = (t)new u(paramc);
    AppMethodBeat.o(57360);
    return paramc;
  }
  
  public final Set<String> k(c paramc)
  {
    AppMethodBeat.i(57361);
    s.u(paramc, "packageFqName");
    AppMethodBeat.o(57361);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.e.a.d
 * JD-Core Version:    0.7.0.1
 */