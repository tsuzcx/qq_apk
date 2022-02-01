package kotlin.l.b.a.b.m.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.a.v;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.j.f.h;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.b.a.b.m.av;
import kotlin.l.b.a.b.m.bg;
import kotlin.l.b.a.b.m.c.b;
import kotlin.l.b.a.b.m.c.d;
import kotlin.l.b.a.b.m.u;

public final class k
  extends aj
  implements d
{
  private final g aaLb;
  private final boolean abkQ;
  private final b abrG;
  final l abrH;
  final bg abrI;
  
  public k(b paramb, l paraml, bg parambg, g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(61069);
    this.abrG = paramb;
    this.abrH = paraml;
    this.abrI = parambg;
    this.aaLb = paramg;
    this.abkQ = paramBoolean;
    AppMethodBeat.o(61069);
  }
  
  public k(b paramb, bg parambg, av paramav, as paramas)
  {
    this(paramb, new l(paramav, null, null, paramas, 6), parambg);
    AppMethodBeat.i(270302);
    AppMethodBeat.o(270302);
  }
  
  private k JC(boolean paramBoolean)
  {
    AppMethodBeat.i(61063);
    k localk = new k(this.abrG, this.abrH, this.abrI, this.aaLb, paramBoolean);
    AppMethodBeat.o(61063);
    return localk;
  }
  
  private k k(g paramg)
  {
    AppMethodBeat.i(61060);
    p.k(paramg, "newAnnotations");
    paramg = new k(this.abrG, this.abrH, this.abrI, paramg, this.abkQ);
    AppMethodBeat.o(61060);
    return paramg;
  }
  
  private k o(i parami)
  {
    Object localObject3 = null;
    AppMethodBeat.i(61066);
    p.k(parami, "kotlinTypeRefiner");
    b localb = this.abrG;
    l locall1 = this.abrH;
    p.k(parami, "kotlinTypeRefiner");
    av localav = locall1.abkS.m(parami);
    p.j(localav, "projection.refine(kotlinTypeRefiner)");
    Object localObject1;
    Object localObject2;
    if (locall1.abrK != null)
    {
      localObject1 = (a)new l.c(locall1, parami);
      l locall2 = locall1.abrL;
      localObject2 = locall2;
      if (locall2 == null) {
        localObject2 = locall1;
      }
      localObject1 = new l(localav, (a)localObject1, (l)localObject2, locall1.abqV);
      localObject2 = this.abrI;
      if (localObject2 == null) {
        break label162;
      }
    }
    label162:
    for (parami = parami.aK((ab)localObject2).iPX();; parami = localObject3)
    {
      parami = new k(localb, (l)localObject1, parami, this.aaLb, this.abkQ);
      AppMethodBeat.o(61066);
      return parami;
      localObject1 = null;
      break;
    }
  }
  
  public final g iDY()
  {
    return this.aaLb;
  }
  
  public final h iEC()
  {
    AppMethodBeat.i(61059);
    h localh = u.eh("No member resolution should be done on captured type!", true);
    p.j(localh, "ErrorUtils.createErrorSc…on captured type!\", true)");
    AppMethodBeat.o(61059);
    return localh;
  }
  
  public final boolean iIu()
  {
    return this.abkQ;
  }
  
  public final List<av> iOR()
  {
    return (List)v.aaAd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.m.a.k
 * JD-Core Version:    0.7.0.1
 */