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
  private final boolean NTq;
  private final g Nsz;
  private final b Oan;
  final l Oao;
  final bg Oap;
  
  public k(b paramb, l paraml, bg parambg, g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(61069);
    this.Oan = paramb;
    this.Oao = paraml;
    this.Oap = parambg;
    this.Nsz = paramg;
    this.NTq = paramBoolean;
    AppMethodBeat.o(61069);
  }
  
  public k(b paramb, bg parambg, av paramav, as paramas)
  {
    this(paramb, new l(paramav, null, paramas, 6), parambg);
    AppMethodBeat.i(193320);
    AppMethodBeat.o(193320);
  }
  
  private k AF(boolean paramBoolean)
  {
    AppMethodBeat.i(61063);
    k localk = new k(this.Oan, this.Oao, this.Oap, this.Nsz, paramBoolean);
    AppMethodBeat.o(61063);
    return localk;
  }
  
  private k k(g paramg)
  {
    AppMethodBeat.i(61060);
    p.h(paramg, "newAnnotations");
    paramg = new k(this.Oan, this.Oao, this.Oap, paramg, this.NTq);
    AppMethodBeat.o(61060);
    return paramg;
  }
  
  private k o(i parami)
  {
    Object localObject3 = null;
    AppMethodBeat.i(61066);
    p.h(parami, "kotlinTypeRefiner");
    b localb = this.Oan;
    l locall1 = this.Oao;
    p.h(parami, "kotlinTypeRefiner");
    av localav = locall1.NTs.m(parami);
    p.g(localav, "projection.refine(kotlinTypeRefiner)");
    Object localObject1;
    Object localObject2;
    if (locall1.Oar != null)
    {
      localObject1 = (a)new l.c(locall1, parami);
      l locall2 = locall1.Oas;
      localObject2 = locall2;
      if (locall2 == null) {
        localObject2 = locall1;
      }
      localObject1 = new l(localav, (a)localObject1, (l)localObject2, locall1.NZC);
      localObject2 = this.Oap;
      if (localObject2 == null) {
        break label162;
      }
    }
    label162:
    for (parami = parami.aL((ab)localObject2).gyC();; parami = localObject3)
    {
      parami = new k(localb, (l)localObject1, parami, this.Nsz, this.NTq);
      AppMethodBeat.o(61066);
      return parami;
      localObject1 = null;
      break;
    }
  }
  
  public final h gmN()
  {
    AppMethodBeat.i(61059);
    h localh = u.dy("No member resolution should be done on captured type!", true);
    p.g(localh, "ErrorUtils.createErrorSc…on captured type!\", true)");
    AppMethodBeat.o(61059);
    return localh;
  }
  
  public final g gmj()
  {
    return this.Nsz;
  }
  
  public final boolean gqy()
  {
    return this.NTq;
  }
  
  public final List<av> gxy()
  {
    return (List)v.NhH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.m.a.k
 * JD-Core Version:    0.7.0.1
 */