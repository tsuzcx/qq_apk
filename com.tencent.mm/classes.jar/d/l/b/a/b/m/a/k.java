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
  private final boolean LFm;
  private final b LMl;
  final l LMm;
  final bg LMn;
  private final g Lez;
  
  public k(b paramb, l paraml, bg parambg, g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(61069);
    this.LMl = paramb;
    this.LMm = paraml;
    this.LMn = parambg;
    this.Lez = paramg;
    this.LFm = paramBoolean;
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
    paramg = new k(this.LMl, this.LMm, this.LMn, paramg, this.LFm);
    AppMethodBeat.o(61060);
    return paramg;
  }
  
  private k o(i parami)
  {
    Object localObject3 = null;
    AppMethodBeat.i(61066);
    d.g.b.k.h(parami, "kotlinTypeRefiner");
    b localb = this.LMl;
    Object localObject2 = this.LMm;
    d.g.b.k.h(parami, "kotlinTypeRefiner");
    av localav = ((l)localObject2).LFo.m(parami);
    d.g.b.k.g(localav, "projection.refine(kotlinTypeRefiner)");
    Object localObject1;
    l locall;
    if (((l)localObject2).LMp != null)
    {
      localObject1 = (a)new l.c((l)localObject2, parami);
      locall = ((l)localObject2).LMq;
      if (locall != null) {
        break label152;
      }
    }
    for (;;)
    {
      localObject1 = new l(localav, (a)localObject1, (l)localObject2);
      localObject2 = this.LMn;
      if (localObject2 != null) {}
      for (parami = parami.aL((ab)localObject2).gcz();; parami = localObject3)
      {
        parami = new k(localb, (l)localObject1, parami, this.Lez, this.LFm);
        AppMethodBeat.o(61066);
        return parami;
        localObject1 = null;
        break;
      }
      label152:
      localObject2 = locall;
    }
  }
  
  private k zE(boolean paramBoolean)
  {
    AppMethodBeat.i(61063);
    k localk = new k(this.LMl, this.LMm, this.LMn, this.Lez, paramBoolean);
    AppMethodBeat.o(61063);
    return localk;
  }
  
  public final h fQN()
  {
    AppMethodBeat.i(61059);
    h localh = u.dq("No member resolution should be done on captured type!", true);
    d.g.b.k.g(localh, "ErrorUtils.createErrorSc…on captured type!\", true)");
    AppMethodBeat.o(61059);
    return localh;
  }
  
  public final g fQj()
  {
    return this.Lez;
  }
  
  public final boolean fUx()
  {
    return this.LFm;
  }
  
  public final List<av> gbw()
  {
    return (List)v.KTF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.m.a.k
 * JD-Core Version:    0.7.0.1
 */