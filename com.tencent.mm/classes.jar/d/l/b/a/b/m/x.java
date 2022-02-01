package d.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l.b.a.b.b.a.g;
import d.l.b.a.b.i.c;

public final class x
  extends v
  implements bd
{
  private final v JXL;
  private final ab JXM;
  
  public x(v paramv, ab paramab)
  {
    super(paramv.JXH, paramv.JXI);
    AppMethodBeat.i(60746);
    this.JXL = paramv;
    this.JXM = paramab;
    AppMethodBeat.o(60746);
  }
  
  private x k(d.l.b.a.b.m.a.i parami)
  {
    AppMethodBeat.i(60743);
    k.h(parami, "kotlinTypeRefiner");
    ab localab = parami.aL((ab)this.JXL);
    if (localab == null)
    {
      parami = new d.v("null cannot be cast to non-null type org.jetbrains.kotlin.types.FlexibleType");
      AppMethodBeat.o(60743);
      throw parami;
    }
    parami = new x((v)localab, parami.aL(this.JXM));
    AppMethodBeat.o(60743);
    return parami;
  }
  
  public final String a(c paramc, d.l.b.a.b.i.i parami)
  {
    AppMethodBeat.i(60741);
    k.h(paramc, "renderer");
    k.h(parami, "options");
    if (parami.fIq())
    {
      paramc = paramc.b(this.JXM);
      AppMethodBeat.o(60741);
      return paramc;
    }
    paramc = this.JXL.a(paramc, parami);
    AppMethodBeat.o(60741);
    return paramc;
  }
  
  public final bg b(g paramg)
  {
    AppMethodBeat.i(60739);
    k.h(paramg, "newAnnotations");
    paramg = be.b(this.JXL.b(paramg), this.JXM);
    AppMethodBeat.o(60739);
    return paramg;
  }
  
  public final aj fBP()
  {
    AppMethodBeat.i(60742);
    aj localaj = this.JXL.fBP();
    AppMethodBeat.o(60742);
    return localaj;
  }
  
  public final ab fJU()
  {
    return this.JXM;
  }
  
  public final bg xV(boolean paramBoolean)
  {
    AppMethodBeat.i(60740);
    bg localbg = be.b(this.JXL.xV(paramBoolean), (ab)this.JXM.fJW().xV(paramBoolean));
    AppMethodBeat.o(60740);
    return localbg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.m.x
 * JD-Core Version:    0.7.0.1
 */