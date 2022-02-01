package d.l.b.a.b.m.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.v;
import d.g.a.a;
import d.g.b.p;
import d.l.b.a.b.b.a.g;
import d.l.b.a.b.b.as;
import d.l.b.a.b.j.f.h;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.aj;
import d.l.b.a.b.m.av;
import d.l.b.a.b.m.bg;
import d.l.b.a.b.m.c.b;
import d.l.b.a.b.m.c.d;
import d.l.b.a.b.m.u;
import java.util.List;

public final class k
  extends aj
  implements d
{
  private final g MVu;
  private final b NDg;
  final l NDh;
  final bg NDi;
  private final boolean Nwk;
  
  public k(b paramb, l paraml, bg parambg, g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(61069);
    this.NDg = paramb;
    this.NDh = paraml;
    this.NDi = parambg;
    this.MVu = paramg;
    this.Nwk = paramBoolean;
    AppMethodBeat.o(61069);
  }
  
  public k(b paramb, bg parambg, av paramav, as paramas)
  {
    this(paramb, new l(paramav, null, paramas, 6), parambg);
    AppMethodBeat.i(187796);
    AppMethodBeat.o(187796);
  }
  
  private k As(boolean paramBoolean)
  {
    AppMethodBeat.i(61063);
    k localk = new k(this.NDg, this.NDh, this.NDi, this.MVu, paramBoolean);
    AppMethodBeat.o(61063);
    return localk;
  }
  
  private k k(g paramg)
  {
    AppMethodBeat.i(61060);
    p.h(paramg, "newAnnotations");
    paramg = new k(this.NDg, this.NDh, this.NDi, paramg, this.Nwk);
    AppMethodBeat.o(61060);
    return paramg;
  }
  
  private k o(i parami)
  {
    Object localObject3 = null;
    AppMethodBeat.i(61066);
    p.h(parami, "kotlinTypeRefiner");
    b localb = this.NDg;
    l locall1 = this.NDh;
    p.h(parami, "kotlinTypeRefiner");
    av localav = locall1.Nwm.m(parami);
    p.g(localav, "projection.refine(kotlinTypeRefiner)");
    Object localObject1;
    Object localObject2;
    if (locall1.NDk != null)
    {
      localObject1 = (a)new l.c(locall1, parami);
      l locall2 = locall1.NDl;
      localObject2 = locall2;
      if (locall2 == null) {
        localObject2 = locall1;
      }
      localObject1 = new l(localav, (a)localObject1, (l)localObject2, locall1.NCv);
      localObject2 = this.NDi;
      if (localObject2 == null) {
        break label162;
      }
    }
    label162:
    for (parami = parami.aL((ab)localObject2).gua();; parami = localObject3)
    {
      parami = new k(localb, (l)localObject1, parami, this.MVu, this.Nwk);
      AppMethodBeat.o(61066);
      return parami;
      localObject1 = null;
      break;
    }
  }
  
  public final g ghH()
  {
    return this.MVu;
  }
  
  public final h gil()
  {
    AppMethodBeat.i(61059);
    h localh = u.dv("No member resolution should be done on captured type!", true);
    p.g(localh, "ErrorUtils.createErrorSc…on captured type!\", true)");
    AppMethodBeat.o(61059);
    return localh;
  }
  
  public final boolean glW()
  {
    return this.Nwk;
  }
  
  public final List<av> gsW()
  {
    return (List)v.MKE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.m.a.k
 * JD-Core Version:    0.7.0.1
 */