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
  public l LFn;
  public final av LFo;
  
  public c(av paramav)
  {
    AppMethodBeat.i(60031);
    this.LFo = paramav;
    if (this.LFo.gcC() != bh.LLV) {}
    for (int i = 1; (aa.KTq) && (i == 0); i = 0)
    {
      paramav = (Throwable)new AssertionError("Only nontrivial projections can be captured, not: " + this.LFo);
      AppMethodBeat.o(60031);
      throw paramav;
    }
    AppMethodBeat.o(60031);
  }
  
  public final boolean fQs()
  {
    return false;
  }
  
  public final g fRE()
  {
    AppMethodBeat.i(60030);
    g localg = this.LFo.fRV().gbz().fRE();
    k.g(localg, "projection.type.constructor.builtIns");
    AppMethodBeat.o(60030);
    return localg;
  }
  
  public final Collection<ab> fSt()
  {
    AppMethodBeat.i(60028);
    if (this.LFo.gcC() == bh.LLX) {}
    for (Object localObject = this.LFo.fRV();; localObject = (ab)fRE().fPG())
    {
      k.g(localObject, "if (projection.projectio… builtIns.nullableAnyType");
      localObject = (Collection)j.listOf(localObject);
      AppMethodBeat.o(60028);
      return localObject;
    }
  }
  
  public final av gbA()
  {
    return this.LFo;
  }
  
  public final List<as> getParameters()
  {
    return (List)v.KTF;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60029);
    String str = "CapturedTypeConstructor(" + this.LFo + ')';
    AppMethodBeat.o(60029);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.j.a.a.c
 * JD-Core Version:    0.7.0.1
 */