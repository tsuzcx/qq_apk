package d.l.b.a.b.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.a.v;
import d.aa;
import d.g.b.k;
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
  public l JRU;
  public final av JRV;
  
  public c(av paramav)
  {
    AppMethodBeat.i(60031);
    this.JRV = paramav;
    if (this.JRV.fJZ() != bh.JYC) {}
    for (int i = 1; (aa.JfW) && (i == 0); i = 0)
    {
      paramav = (Throwable)new AssertionError("Only nontrivial projections can be captured, not: " + this.JRV);
      AppMethodBeat.o(60031);
      throw paramav;
    }
    AppMethodBeat.o(60031);
  }
  
  public final av fIX()
  {
    return this.JRV;
  }
  
  public final boolean fxO()
  {
    return false;
  }
  
  public final Collection<ab> fzP()
  {
    AppMethodBeat.i(60028);
    if (this.JRV.fJZ() == bh.JYE) {}
    for (Object localObject = this.JRV.fzr();; localObject = (ab)fza().fxc())
    {
      k.g(localObject, "if (projection.projectio… builtIns.nullableAnyType");
      localObject = (Collection)j.listOf(localObject);
      AppMethodBeat.o(60028);
      return localObject;
    }
  }
  
  public final g fza()
  {
    AppMethodBeat.i(60030);
    g localg = this.JRV.fzr().fIW().fza();
    k.g(localg, "projection.type.constructor.builtIns");
    AppMethodBeat.o(60030);
    return localg;
  }
  
  public final List<as> getParameters()
  {
    return (List)v.Jgl;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60029);
    String str = "CapturedTypeConstructor(" + this.JRV + ')';
    AppMethodBeat.o(60029);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.j.a.a.c
 * JD-Core Version:    0.7.0.1
 */