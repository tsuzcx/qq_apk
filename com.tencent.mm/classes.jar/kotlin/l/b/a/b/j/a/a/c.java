package kotlin.l.b.a.b.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.List;
import kotlin.a.j;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.l.b.a.b.a.g;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.m.a.l;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.at;
import kotlin.l.b.a.b.m.av;
import kotlin.l.b.a.b.m.bh;
import kotlin.z;

public final class c
  implements b
{
  public l abkR;
  public final av abkS;
  
  public c(av paramav)
  {
    AppMethodBeat.i(60031);
    this.abkS = paramav;
    if (this.abkS.iQa() != bh.abrp) {}
    for (int i = 1; (z.aazO) && (i == 0); i = 0)
    {
      paramav = (Throwable)new AssertionError("Only nontrivial projections can be captured, not: " + this.abkS);
      AppMethodBeat.o(60031);
      throw paramav;
    }
    AppMethodBeat.o(60031);
  }
  
  public final List<as> iCb()
  {
    return (List)v.aaAd;
  }
  
  public final boolean iEh()
  {
    return false;
  }
  
  public final g iFv()
  {
    AppMethodBeat.i(60030);
    g localg = this.abkS.iFN().iOU().iFv();
    p.j(localg, "projection.type.constructor.builtIns");
    AppMethodBeat.o(60030);
    return localg;
  }
  
  public final Collection<ab> iGk()
  {
    AppMethodBeat.i(60028);
    if (this.abkS.iQa() == bh.abrr) {}
    for (Object localObject = this.abkS.iFN();; localObject = (ab)iFv().iDv())
    {
      p.j(localObject, "if (projection.projectio… builtIns.nullableAnyType");
      localObject = (Collection)j.listOf(localObject);
      AppMethodBeat.o(60028);
      return localObject;
    }
  }
  
  public final av iOV()
  {
    return this.abkS;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60029);
    String str = "CapturedTypeConstructor(" + this.abkS + ')';
    AppMethodBeat.o(60029);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.j.a.a.c
 * JD-Core Version:    0.7.0.1
 */