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
  public l NTr;
  public final av NTs;
  
  public c(av paramav)
  {
    AppMethodBeat.i(60031);
    this.NTs = paramav;
    if (this.NTs.gyF() != bh.NZW) {}
    for (int i = 1; (ac.Nhs) && (i == 0); i = 0)
    {
      paramav = (Throwable)new AssertionError("Only nontrivial projections can be captured, not: " + this.NTs);
      AppMethodBeat.o(60031);
      throw paramav;
    }
    AppMethodBeat.o(60031);
  }
  
  public final List<as> getParameters()
  {
    return (List)v.NhH;
  }
  
  public final boolean gms()
  {
    return false;
  }
  
  public final g gnF()
  {
    AppMethodBeat.i(60030);
    g localg = this.NTs.gnW().gxB().gnF();
    p.g(localg, "projection.type.constructor.builtIns");
    AppMethodBeat.o(60030);
    return localg;
  }
  
  public final Collection<ab> got()
  {
    AppMethodBeat.i(60028);
    if (this.NTs.gyF() == bh.NZY) {}
    for (Object localObject = this.NTs.gnW();; localObject = (ab)gnF().glG())
    {
      p.g(localObject, "if (projection.projectio… builtIns.nullableAnyType");
      localObject = (Collection)j.listOf(localObject);
      AppMethodBeat.o(60028);
      return localObject;
    }
  }
  
  public final av gxC()
  {
    return this.NTs;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60029);
    String str = "CapturedTypeConstructor(" + this.NTs + ')';
    AppMethodBeat.o(60029);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.j.a.a.c
 * JD-Core Version:    0.7.0.1
 */