package kotlin.l.b.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.aa;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.a.g.a;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.az;
import kotlin.l.b.a.b.b.c.ai;
import kotlin.l.b.a.b.b.c.m;
import kotlin.l.b.a.b.b.c.x;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.w;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.j.c;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.ac;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.b.a.b.m.at;
import kotlin.l.b.a.b.m.av;
import kotlin.l.b.a.b.m.bh;
import kotlin.l.b.a.b.m.d.a;
import kotlin.l.b.a.b.m.u;

public final class k
{
  private static final x Tfb;
  private static final x Tfc;
  
  static
  {
    AppMethodBeat.i(56696);
    Object localObject1 = u.hLA();
    p.g(localObject1, "ErrorUtils.getErrorModule()");
    Object localObject2 = c.THw;
    p.g(localObject2, "DescriptorUtils.COROUTIN…KAGE_FQ_NAME_EXPERIMENTAL");
    localObject1 = new x((l)new m((y)localObject1, (kotlin.l.b.a.b.f.b)localObject2), kotlin.l.b.a.b.b.f.Thf, c.THy.hJg(), an.ThK, kotlin.l.b.a.b.l.b.TMN);
    ((x)localObject1).b(w.Thr);
    ((x)localObject1).d(az.ThU);
    localObject2 = (l)localObject1;
    g.a locala = kotlin.l.b.a.b.b.a.g.TiC;
    ((x)localObject1).kD(j.listOf(ai.a((l)localObject2, g.a.hBP(), bh.TOR, kotlin.l.b.a.b.f.f.btY("T"), 0, kotlin.l.b.a.b.l.b.TMN)));
    ((x)localObject1).hCn();
    Tfb = (x)localObject1;
    localObject1 = u.hLA();
    p.g(localObject1, "ErrorUtils.getErrorModule()");
    localObject2 = c.THv;
    p.g(localObject2, "DescriptorUtils.COROUTINES_PACKAGE_FQ_NAME_RELEASE");
    localObject1 = new x((l)new m((y)localObject1, (kotlin.l.b.a.b.f.b)localObject2), kotlin.l.b.a.b.b.f.Thf, c.THz.hJg(), an.ThK, kotlin.l.b.a.b.l.b.TMN);
    ((x)localObject1).b(w.Thr);
    ((x)localObject1).d(az.ThU);
    localObject2 = (l)localObject1;
    locala = kotlin.l.b.a.b.b.a.g.TiC;
    ((x)localObject1).kD(j.listOf(ai.a((l)localObject2, g.a.hBP(), bh.TOR, kotlin.l.b.a.b.f.f.btY("T"), 0, kotlin.l.b.a.b.l.b.TMN)));
    ((x)localObject1).hCn();
    Tfc = (x)localObject1;
    AppMethodBeat.o(56696);
  }
  
  public static final aj a(ab paramab, boolean paramBoolean)
  {
    AppMethodBeat.i(186239);
    p.h(paramab, "suspendFunType");
    paramBoolean = f.e(paramab);
    if ((aa.SXc) && (!paramBoolean))
    {
      paramab = (Throwable)new AssertionError("This type should be suspend function type: ".concat(String.valueOf(paramab)));
      AppMethodBeat.o(186239);
      throw paramab;
    }
    g localg = a.aM(paramab);
    kotlin.l.b.a.b.b.a.g localg1 = paramab.hzL();
    ab localab = f.h(paramab);
    Object localObject2 = (Iterable)f.j(paramab);
    Object localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((av)((Iterator)localObject2).next()).hBy());
    }
    localObject1 = (Collection)localObject1;
    localObject2 = kotlin.l.b.a.b.b.a.g.TiC;
    localObject2 = g.a.hBP();
    at localat = Tfc.hzz();
    p.g(localat, "if (isReleaseCoroutines)…ERIMENTAL.typeConstructor");
    localObject1 = j.b((Collection)localObject1, ac.c((kotlin.l.b.a.b.b.a.g)localObject2, localat, j.listOf(a.aN(f.i(paramab))), false));
    localObject2 = a.aM(paramab).hzj();
    p.g(localObject2, "suspendFunType.builtIns.nullableAnyType");
    paramab = f.a(localg, localg1, localab, (List)localObject1, (ab)localObject2).EG(paramab.hEa());
    AppMethodBeat.o(186239);
    return paramab;
  }
  
  public static final boolean a(kotlin.l.b.a.b.f.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(56695);
    if (paramBoolean)
    {
      paramBoolean = p.j(paramb, c.THz);
      AppMethodBeat.o(56695);
      return paramBoolean;
    }
    paramBoolean = p.j(paramb, c.THy);
    AppMethodBeat.o(56695);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.a.k
 * JD-Core Version:    0.7.0.1
 */