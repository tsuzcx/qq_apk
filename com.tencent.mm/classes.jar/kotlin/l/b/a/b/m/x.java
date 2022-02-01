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
  private final ab abqA;
  private final v abqz;
  
  public x(v paramv, ab paramab)
  {
    super(paramv.abqv, paramv.abqw);
    AppMethodBeat.i(60746);
    this.abqz = paramv;
    this.abqA = paramab;
    AppMethodBeat.o(60746);
  }
  
  private x k(kotlin.l.b.a.b.m.a.i parami)
  {
    AppMethodBeat.i(60743);
    p.k(parami, "kotlinTypeRefiner");
    ab localab = parami.aK((ab)this.abqz);
    if (localab == null)
    {
      parami = new t("null cannot be cast to non-null type org.jetbrains.kotlin.types.FlexibleType");
      AppMethodBeat.o(60743);
      throw parami;
    }
    parami = new x((v)localab, parami.aK(this.abqA));
    AppMethodBeat.o(60743);
    return parami;
  }
  
  public final bg Jm(boolean paramBoolean)
  {
    AppMethodBeat.i(60740);
    bg localbg = be.b(this.abqz.Jm(paramBoolean), (ab)this.abqA.iPX().Jm(paramBoolean));
    AppMethodBeat.o(60740);
    return localbg;
  }
  
  public final String a(c paramc, kotlin.l.b.a.b.i.i parami)
  {
    AppMethodBeat.i(60741);
    p.k(paramc, "renderer");
    p.k(parami, "options");
    if (parami.iOn())
    {
      paramc = paramc.b(this.abqA);
      AppMethodBeat.o(60741);
      return paramc;
    }
    paramc = this.abqz.a(paramc, parami);
    AppMethodBeat.o(60741);
    return paramc;
  }
  
  public final bg b(g paramg)
  {
    AppMethodBeat.i(60739);
    p.k(paramg, "newAnnotations");
    paramg = be.b(this.abqz.b(paramg), this.abqA);
    AppMethodBeat.o(60739);
    return paramg;
  }
  
  public final aj iIq()
  {
    AppMethodBeat.i(60742);
    aj localaj = this.abqz.iIq();
    AppMethodBeat.o(60742);
    return localaj;
  }
  
  public final ab iPV()
  {
    return this.abqA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.m.x
 * JD-Core Version:    0.7.0.1
 */