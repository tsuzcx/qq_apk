package d.l.b.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.aa;
import d.l.b.a.b.b.a.g.a;
import d.l.b.a.b.b.an;
import d.l.b.a.b.b.az;
import d.l.b.a.b.b.c.ai;
import d.l.b.a.b.b.c.m;
import d.l.b.a.b.b.c.x;
import d.l.b.a.b.b.l;
import d.l.b.a.b.b.w;
import d.l.b.a.b.b.y;
import d.l.b.a.b.j.c;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.ac;
import d.l.b.a.b.m.aj;
import d.l.b.a.b.m.at;
import d.l.b.a.b.m.av;
import d.l.b.a.b.m.bh;
import d.l.b.a.b.m.d.a;
import d.l.b.a.b.m.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class k
{
  private static final x JnZ;
  private static final x Joa;
  
  static
  {
    AppMethodBeat.i(56696);
    Object localObject1 = u.fJR();
    d.g.b.k.g(localObject1, "ErrorUtils.getErrorModule()");
    Object localObject2 = c.JRc;
    d.g.b.k.g(localObject2, "DescriptorUtils.COROUTIN…KAGE_FQ_NAME_EXPERIMENTAL");
    localObject1 = new x((l)new m((y)localObject1, (d.l.b.a.b.f.b)localObject2), d.l.b.a.b.b.f.Jqe, c.JRe.fHe(), an.JqJ, d.l.b.a.b.l.b.JWw);
    ((x)localObject1).b(w.Jqq);
    ((x)localObject1).d(az.JqT);
    localObject2 = (l)localObject1;
    g.a locala = d.l.b.a.b.b.a.g.JrB;
    ((x)localObject1).iK(j.listOf(ai.a((l)localObject2, g.a.fzI(), bh.JYD, d.l.b.a.b.f.f.aQC("T"), 0)));
    ((x)localObject1).fAg();
    JnZ = (x)localObject1;
    localObject1 = u.fJR();
    d.g.b.k.g(localObject1, "ErrorUtils.getErrorModule()");
    localObject2 = c.JRb;
    d.g.b.k.g(localObject2, "DescriptorUtils.COROUTINES_PACKAGE_FQ_NAME_RELEASE");
    localObject1 = new x((l)new m((y)localObject1, (d.l.b.a.b.f.b)localObject2), d.l.b.a.b.b.f.Jqe, c.JRf.fHe(), an.JqJ, d.l.b.a.b.l.b.JWw);
    ((x)localObject1).b(w.Jqq);
    ((x)localObject1).d(az.JqT);
    localObject2 = (l)localObject1;
    locala = d.l.b.a.b.b.a.g.JrB;
    ((x)localObject1).iK(j.listOf(ai.a((l)localObject2, g.a.fzI(), bh.JYD, d.l.b.a.b.f.f.aQC("T"), 0)));
    ((x)localObject1).fAg();
    Joa = (x)localObject1;
    AppMethodBeat.o(56696);
  }
  
  public static final aj E(ab paramab)
  {
    AppMethodBeat.i(56694);
    d.g.b.k.h(paramab, "suspendFunType");
    boolean bool = f.e(paramab);
    if ((aa.JfW) && (!bool))
    {
      paramab = (Throwable)new AssertionError("This type should be suspend function type: ".concat(String.valueOf(paramab)));
      AppMethodBeat.o(56694);
      throw paramab;
    }
    g localg = a.aN(paramab);
    d.l.b.a.b.b.a.g localg1 = paramab.fxF();
    ab localab = f.h(paramab);
    Object localObject2 = (Iterable)f.j(paramab);
    Object localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((av)((Iterator)localObject2).next()).fzr());
    }
    localObject1 = (Collection)localObject1;
    localObject2 = d.l.b.a.b.b.a.g.JrB;
    localObject2 = g.a.fzI();
    at localat = Joa.fxs();
    d.g.b.k.g(localat, "if (isReleaseCoroutines)…ERIMENTAL.typeConstructor");
    localObject1 = j.b((Collection)localObject1, ac.c((d.l.b.a.b.b.a.g)localObject2, localat, j.listOf(a.aO(f.i(paramab))), false));
    localObject2 = a.aN(paramab).fxc();
    d.g.b.k.g(localObject2, "suspendFunType.builtIns.nullableAnyType");
    paramab = f.a(localg, localg1, localab, (List)localObject1, (ab)localObject2).xW(paramab.fBT());
    AppMethodBeat.o(56694);
    return paramab;
  }
  
  public static final boolean a(d.l.b.a.b.f.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(56695);
    if (paramBoolean)
    {
      paramBoolean = d.g.b.k.g(paramb, c.JRf);
      AppMethodBeat.o(56695);
      return paramBoolean;
    }
    paramBoolean = d.g.b.k.g(paramb, c.JRe);
    AppMethodBeat.o(56695);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.a.k
 * JD-Core Version:    0.7.0.1
 */