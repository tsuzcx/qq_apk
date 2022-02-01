package d.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l.b.a.b.b.a.g;
import d.l.b.a.b.i.c;

public final class x
  extends v
  implements bd
{
  private final v NZg;
  private final ab NZh;
  
  public x(v paramv, ab paramab)
  {
    super(paramv.NZc, paramv.NZd);
    AppMethodBeat.i(60746);
    this.NZg = paramv;
    this.NZh = paramab;
    AppMethodBeat.o(60746);
  }
  
  private x k(d.l.b.a.b.m.a.i parami)
  {
    AppMethodBeat.i(60743);
    p.h(parami, "kotlinTypeRefiner");
    ab localab = parami.aL((ab)this.NZg);
    if (localab == null)
    {
      parami = new d.v("null cannot be cast to non-null type org.jetbrains.kotlin.types.FlexibleType");
      AppMethodBeat.o(60743);
      throw parami;
    }
    parami = new x((v)localab, parami.aL(this.NZh));
    AppMethodBeat.o(60743);
    return parami;
  }
  
  public final bg Ao(boolean paramBoolean)
  {
    AppMethodBeat.i(60740);
    bg localbg = be.b(this.NZg.Ao(paramBoolean), (ab)this.NZh.gyC().Ao(paramBoolean));
    AppMethodBeat.o(60740);
    return localbg;
  }
  
  public final String a(c paramc, d.l.b.a.b.i.i parami)
  {
    AppMethodBeat.i(60741);
    p.h(paramc, "renderer");
    p.h(parami, "options");
    if (parami.gwU())
    {
      paramc = paramc.b(this.NZh);
      AppMethodBeat.o(60741);
      return paramc;
    }
    paramc = this.NZg.a(paramc, parami);
    AppMethodBeat.o(60741);
    return paramc;
  }
  
  public final bg b(g paramg)
  {
    AppMethodBeat.i(60739);
    p.h(paramg, "newAnnotations");
    paramg = be.b(this.NZg.b(paramg), this.NZh);
    AppMethodBeat.o(60739);
    return paramg;
  }
  
  public final aj gqu()
  {
    AppMethodBeat.i(60742);
    aj localaj = this.NZg.gqu();
    AppMethodBeat.o(60742);
    return localaj;
  }
  
  public final ab gyA()
  {
    return this.NZh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.m.x
 * JD-Core Version:    0.7.0.1
 */