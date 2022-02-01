package kotlin.l.b.a.b.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.l.b.a.b.d.a.e.a;
import kotlin.l.b.a.b.d.a.e.g;
import kotlin.l.b.a.b.d.a.e.t;
import kotlin.l.b.a.b.f.f;

public final class u
  extends n
  implements t
{
  private final kotlin.l.b.a.b.f.b TiI;
  
  public u(kotlin.l.b.a.b.f.b paramb)
  {
    AppMethodBeat.i(57501);
    this.TiI = paramb;
    AppMethodBeat.o(57501);
  }
  
  public final Collection<g> S(kotlin.g.a.b<? super f, Boolean> paramb)
  {
    AppMethodBeat.i(57496);
    p.h(paramb, "nameFilter");
    paramb = (Collection)v.SXr;
    AppMethodBeat.o(57496);
    return paramb;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(57498);
    if (((paramObject instanceof u)) && (p.j(this.TiI, ((u)paramObject).TiI)))
    {
      AppMethodBeat.o(57498);
      return true;
    }
    AppMethodBeat.o(57498);
    return false;
  }
  
  public final kotlin.l.b.a.b.f.b hBk()
  {
    return this.TiI;
  }
  
  public final Collection<t> hDg()
  {
    return (Collection)v.SXr;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(57499);
    int i = this.TiI.hashCode();
    AppMethodBeat.o(57499);
    return i;
  }
  
  public final a l(kotlin.l.b.a.b.f.b paramb)
  {
    AppMethodBeat.i(57497);
    p.h(paramb, "fqName");
    AppMethodBeat.o(57497);
    return null;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(57500);
    String str = getClass().getName() + ": " + this.TiI;
    AppMethodBeat.o(57500);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.b.d.b.u
 * JD-Core Version:    0.7.0.1
 */