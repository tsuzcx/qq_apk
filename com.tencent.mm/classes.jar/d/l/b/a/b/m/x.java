package d.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l.b.a.b.b.a.g;
import d.l.b.a.b.i.c;

public final class x
  extends v
  implements bd
{
  private final v NBZ;
  private final ab NCa;
  
  public x(v paramv, ab paramab)
  {
    super(paramv.NBV, paramv.NBW);
    AppMethodBeat.i(60746);
    this.NBZ = paramv;
    this.NCa = paramab;
    AppMethodBeat.o(60746);
  }
  
  private x k(d.l.b.a.b.m.a.i parami)
  {
    AppMethodBeat.i(60743);
    p.h(parami, "kotlinTypeRefiner");
    ab localab = parami.aL((ab)this.NBZ);
    if (localab == null)
    {
      parami = new d.v("null cannot be cast to non-null type org.jetbrains.kotlin.types.FlexibleType");
      AppMethodBeat.o(60743);
      throw parami;
    }
    parami = new x((v)localab, parami.aL(this.NCa));
    AppMethodBeat.o(60743);
    return parami;
  }
  
  public final bg Ab(boolean paramBoolean)
  {
    AppMethodBeat.i(60740);
    bg localbg = be.b(this.NBZ.Ab(paramBoolean), (ab)this.NCa.gua().Ab(paramBoolean));
    AppMethodBeat.o(60740);
    return localbg;
  }
  
  public final String a(c paramc, d.l.b.a.b.i.i parami)
  {
    AppMethodBeat.i(60741);
    p.h(paramc, "renderer");
    p.h(parami, "options");
    if (parami.gss())
    {
      paramc = paramc.b(this.NCa);
      AppMethodBeat.o(60741);
      return paramc;
    }
    paramc = this.NBZ.a(paramc, parami);
    AppMethodBeat.o(60741);
    return paramc;
  }
  
  public final bg b(g paramg)
  {
    AppMethodBeat.i(60739);
    p.h(paramg, "newAnnotations");
    paramg = be.b(this.NBZ.b(paramg), this.NCa);
    AppMethodBeat.o(60739);
    return paramg;
  }
  
  public final aj glS()
  {
    AppMethodBeat.i(60742);
    aj localaj = this.NBZ.glS();
    AppMethodBeat.o(60742);
    return localaj;
  }
  
  public final ab gtY()
  {
    return this.NCa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.m.x
 * JD-Core Version:    0.7.0.1
 */