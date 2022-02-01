package d.l.b.a.b.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.a.v;
import d.ac;
import d.g.b.p;
import d.l.b.a.b.a.g;
import d.l.b.a.b.b.as;
import d.l.b.a.b.m.a.l;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.at;
import d.l.b.a.b.m.av;
import d.l.b.a.b.m.bh;
import java.util.Collection;
import java.util.List;

public final class c
  implements b
{
  public l Nwl;
  public final av Nwm;
  
  public c(av paramav)
  {
    AppMethodBeat.i(60031);
    this.Nwm = paramav;
    if (this.Nwm.gud() != bh.NCP) {}
    for (int i = 1; (ac.MKp) && (i == 0); i = 0)
    {
      paramav = (Throwable)new AssertionError("Only nontrivial projections can be captured, not: " + this.Nwm);
      AppMethodBeat.o(60031);
      throw paramav;
    }
    AppMethodBeat.o(60031);
  }
  
  public final List<as> getParameters()
  {
    return (List)v.MKE;
  }
  
  public final boolean ghQ()
  {
    return false;
  }
  
  public final Collection<ab> gjR()
  {
    AppMethodBeat.i(60028);
    if (this.Nwm.gud() == bh.NCR) {}
    for (Object localObject = this.Nwm.gju();; localObject = (ab)gjd().ghe())
    {
      p.g(localObject, "if (projection.projectio… builtIns.nullableAnyType");
      localObject = (Collection)j.listOf(localObject);
      AppMethodBeat.o(60028);
      return localObject;
    }
  }
  
  public final g gjd()
  {
    AppMethodBeat.i(60030);
    g localg = this.Nwm.gju().gsZ().gjd();
    p.g(localg, "projection.type.constructor.builtIns");
    AppMethodBeat.o(60030);
    return localg;
  }
  
  public final av gta()
  {
    return this.Nwm;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60029);
    String str = "CapturedTypeConstructor(" + this.Nwm + ')';
    AppMethodBeat.o(60029);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.j.a.a.c
 * JD-Core Version:    0.7.0.1
 */