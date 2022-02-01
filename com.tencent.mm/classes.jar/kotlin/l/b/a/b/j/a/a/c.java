package kotlin.l.b.a.b.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.List;
import kotlin.a.j;
import kotlin.a.v;
import kotlin.aa;
import kotlin.g.b.p;
import kotlin.l.b.a.b.a.g;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.m.a.l;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.at;
import kotlin.l.b.a.b.m.av;
import kotlin.l.b.a.b.m.bh;

public final class c
  implements b
{
  public l TIn;
  public final av TIo;
  
  public c(av paramav)
  {
    AppMethodBeat.i(60031);
    this.TIo = paramav;
    if (this.TIo.hLI() != bh.TOQ) {}
    for (int i = 1; (aa.SXc) && (i == 0); i = 0)
    {
      paramav = (Throwable)new AssertionError("Only nontrivial projections can be captured, not: " + this.TIo);
      AppMethodBeat.o(60031);
      throw paramav;
    }
    AppMethodBeat.o(60031);
  }
  
  public final List<as> getParameters()
  {
    return (List)v.SXr;
  }
  
  public final Collection<ab> hBV()
  {
    AppMethodBeat.i(60028);
    if (this.TIo.hLI() == bh.TOS) {}
    for (Object localObject = this.TIo.hBy();; localObject = (ab)hBh().hzj())
    {
      p.g(localObject, "if (projection.projectio… builtIns.nullableAnyType");
      localObject = (Collection)j.listOf(localObject);
      AppMethodBeat.o(60028);
      return localObject;
    }
  }
  
  public final g hBh()
  {
    AppMethodBeat.i(60030);
    g localg = this.TIo.hBy().hKE().hBh();
    p.g(localg, "projection.type.constructor.builtIns");
    AppMethodBeat.o(60030);
    return localg;
  }
  
  public final av hKF()
  {
    return this.TIo;
  }
  
  public final boolean hzU()
  {
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60029);
    String str = "CapturedTypeConstructor(" + this.TIo + ')';
    AppMethodBeat.o(60029);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.j.a.a.c
 * JD-Core Version:    0.7.0.1
 */