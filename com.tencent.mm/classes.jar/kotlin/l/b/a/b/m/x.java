package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.i.c;
import kotlin.t;

public final class x
  extends v
  implements bd
{
  private final v TNZ;
  private final ab TOa;
  
  public x(v paramv, ab paramab)
  {
    super(paramv.TNV, paramv.TNW);
    AppMethodBeat.i(60746);
    this.TNZ = paramv;
    this.TOa = paramab;
    AppMethodBeat.o(60746);
  }
  
  private x k(kotlin.l.b.a.b.m.a.i parami)
  {
    AppMethodBeat.i(60743);
    p.h(parami, "kotlinTypeRefiner");
    ab localab = parami.aK((ab)this.TNZ);
    if (localab == null)
    {
      parami = new t("null cannot be cast to non-null type org.jetbrains.kotlin.types.FlexibleType");
      AppMethodBeat.o(60743);
      throw parami;
    }
    parami = new x((v)localab, parami.aK(this.TOa));
    AppMethodBeat.o(60743);
    return parami;
  }
  
  public final bg EF(boolean paramBoolean)
  {
    AppMethodBeat.i(60740);
    bg localbg = be.b(this.TNZ.EF(paramBoolean), (ab)this.TOa.hLF().EF(paramBoolean));
    AppMethodBeat.o(60740);
    return localbg;
  }
  
  public final String a(c paramc, kotlin.l.b.a.b.i.i parami)
  {
    AppMethodBeat.i(60741);
    p.h(paramc, "renderer");
    p.h(parami, "options");
    if (parami.hJX())
    {
      paramc = paramc.b(this.TOa);
      AppMethodBeat.o(60741);
      return paramc;
    }
    paramc = this.TNZ.a(paramc, parami);
    AppMethodBeat.o(60741);
    return paramc;
  }
  
  public final bg b(g paramg)
  {
    AppMethodBeat.i(60739);
    p.h(paramg, "newAnnotations");
    paramg = be.b(this.TNZ.b(paramg), this.TOa);
    AppMethodBeat.o(60739);
    return paramg;
  }
  
  public final aj hDW()
  {
    AppMethodBeat.i(60742);
    aj localaj = this.TNZ.hDW();
    AppMethodBeat.o(60742);
    return localaj;
  }
  
  public final ab hLD()
  {
    return this.TOa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.m.x
 * JD-Core Version:    0.7.0.1
 */