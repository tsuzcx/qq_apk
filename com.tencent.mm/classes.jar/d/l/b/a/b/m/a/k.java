package d.l.b.a.b.m.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.v;
import d.g.a.a;
import d.l.b.a.b.b.a.g;
import d.l.b.a.b.j.f.h;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.aj;
import d.l.b.a.b.m.av;
import d.l.b.a.b.m.bg;
import d.l.b.a.b.m.c.b;
import d.l.b.a.b.m.c.c;
import d.l.b.a.b.m.u;
import java.util.List;

public final class k
  extends aj
  implements c
{
  private final boolean JRT;
  private final b JYS;
  final l JYT;
  final bg JYU;
  private final g Jrg;
  
  public k(b paramb, l paraml, bg parambg, g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(61069);
    this.JYS = paramb;
    this.JYT = paraml;
    this.JYU = parambg;
    this.Jrg = paramg;
    this.JRT = paramBoolean;
    AppMethodBeat.o(61069);
  }
  
  public k(b paramb, bg parambg, av paramav)
  {
    this(paramb, new l(paramav), parambg);
    AppMethodBeat.i(61071);
    AppMethodBeat.o(61071);
  }
  
  private k k(g paramg)
  {
    AppMethodBeat.i(61060);
    d.g.b.k.h(paramg, "newAnnotations");
    paramg = new k(this.JYS, this.JYT, this.JYU, paramg, this.JRT);
    AppMethodBeat.o(61060);
    return paramg;
  }
  
  private k o(i parami)
  {
    Object localObject3 = null;
    AppMethodBeat.i(61066);
    d.g.b.k.h(parami, "kotlinTypeRefiner");
    b localb = this.JYS;
    Object localObject2 = this.JYT;
    d.g.b.k.h(parami, "kotlinTypeRefiner");
    av localav = ((l)localObject2).JRV.m(parami);
    d.g.b.k.g(localav, "projection.refine(kotlinTypeRefiner)");
    Object localObject1;
    l locall;
    if (((l)localObject2).JYW != null)
    {
      localObject1 = (a)new l.c((l)localObject2, parami);
      locall = ((l)localObject2).JYX;
      if (locall != null) {
        break label152;
      }
    }
    for (;;)
    {
      localObject1 = new l(localav, (a)localObject1, (l)localObject2);
      localObject2 = this.JYU;
      if (localObject2 != null) {}
      for (parami = parami.aL((ab)localObject2).fJW();; parami = localObject3)
      {
        parami = new k(localb, (l)localObject1, parami, this.Jrg, this.JRT);
        AppMethodBeat.o(61066);
        return parami;
        localObject1 = null;
        break;
      }
      label152:
      localObject2 = locall;
    }
  }
  
  private k ym(boolean paramBoolean)
  {
    AppMethodBeat.i(61063);
    k localk = new k(this.JYS, this.JYT, this.JYU, this.Jrg, paramBoolean);
    AppMethodBeat.o(61063);
    return localk;
  }
  
  public final boolean fBT()
  {
    return this.JRT;
  }
  
  public final List<av> fIT()
  {
    return (List)v.Jgl;
  }
  
  public final g fxF()
  {
    return this.Jrg;
  }
  
  public final h fyj()
  {
    AppMethodBeat.i(61059);
    h localh = u.dl("No member resolution should be done on captured type!", true);
    d.g.b.k.g(localh, "ErrorUtils.createErrorSc…on captured type!\", true)");
    AppMethodBeat.o(61059);
    return localh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.m.a.k
 * JD-Core Version:    0.7.0.1
 */