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
  private final boolean TIm;
  private final b TPh;
  final l TPi;
  final bg TPj;
  private final g Tih;
  
  public k(b paramb, l paraml, bg parambg, g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(61069);
    this.TPh = paramb;
    this.TPi = paraml;
    this.TPj = parambg;
    this.Tih = paramg;
    this.TIm = paramBoolean;
    AppMethodBeat.o(61069);
  }
  
  public k(b paramb, bg parambg, av paramav, as paramas)
  {
    this(paramb, new l(paramav, null, null, paramas, 6), parambg);
    AppMethodBeat.i(186275);
    AppMethodBeat.o(186275);
  }
  
  private k EV(boolean paramBoolean)
  {
    AppMethodBeat.i(61063);
    k localk = new k(this.TPh, this.TPi, this.TPj, this.Tih, paramBoolean);
    AppMethodBeat.o(61063);
    return localk;
  }
  
  private k k(g paramg)
  {
    AppMethodBeat.i(61060);
    p.h(paramg, "newAnnotations");
    paramg = new k(this.TPh, this.TPi, this.TPj, paramg, this.TIm);
    AppMethodBeat.o(61060);
    return paramg;
  }
  
  private k o(i parami)
  {
    Object localObject3 = null;
    AppMethodBeat.i(61066);
    p.h(parami, "kotlinTypeRefiner");
    b localb = this.TPh;
    l locall1 = this.TPi;
    p.h(parami, "kotlinTypeRefiner");
    av localav = locall1.TIo.m(parami);
    p.g(localav, "projection.refine(kotlinTypeRefiner)");
    Object localObject1;
    Object localObject2;
    if (locall1.TPl != null)
    {
      localObject1 = (a)new l.c(locall1, parami);
      l locall2 = locall1.TPm;
      localObject2 = locall2;
      if (locall2 == null) {
        localObject2 = locall1;
      }
      localObject1 = new l(localav, (a)localObject1, (l)localObject2, locall1.TOv);
      localObject2 = this.TPj;
      if (localObject2 == null) {
        break label162;
      }
    }
    label162:
    for (parami = parami.aK((ab)localObject2).hLF();; parami = localObject3)
    {
      parami = new k(localb, (l)localObject1, parami, this.Tih, this.TIm);
      AppMethodBeat.o(61066);
      return parami;
      localObject1 = null;
      break;
    }
  }
  
  public final h hAp()
  {
    AppMethodBeat.i(61059);
    h localh = u.dU("No member resolution should be done on captured type!", true);
    p.g(localh, "ErrorUtils.createErrorSc…on captured type!\", true)");
    AppMethodBeat.o(61059);
    return localh;
  }
  
  public final boolean hEa()
  {
    return this.TIm;
  }
  
  public final List<av> hKB()
  {
    return (List)v.SXr;
  }
  
  public final g hzL()
  {
    return this.Tih;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.m.a.k
 * JD-Core Version:    0.7.0.1
 */