package kotlin.l.b.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
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
import kotlin.z;

public final class k
{
  private static final x aaHV;
  private static final x aaHW;
  
  static
  {
    AppMethodBeat.i(56696);
    Object localObject1 = u.iPT();
    p.j(localObject1, "ErrorUtils.getErrorModule()");
    Object localObject2 = c.abka;
    p.j(localObject2, "DescriptorUtils.COROUTIN…KAGE_FQ_NAME_EXPERIMENTAL");
    localObject1 = new x((l)new m((y)localObject1, (kotlin.l.b.a.b.f.b)localObject2), kotlin.l.b.a.b.b.f.aaJZ, c.abkc.iNA(), an.aaKE, kotlin.l.b.a.b.l.b.abpp);
    ((x)localObject1).b(w.aaKl);
    ((x)localObject1).d(az.aaKO);
    localObject2 = (l)localObject1;
    g.a locala = kotlin.l.b.a.b.b.a.g.aaLw;
    ((x)localObject1).lA(j.listOf(ai.a((l)localObject2, g.a.iGe(), bh.abrq, kotlin.l.b.a.b.f.f.bHb("T"), 0, kotlin.l.b.a.b.l.b.abpp)));
    ((x)localObject1).iGC();
    aaHV = (x)localObject1;
    localObject1 = u.iPT();
    p.j(localObject1, "ErrorUtils.getErrorModule()");
    localObject2 = c.abjZ;
    p.j(localObject2, "DescriptorUtils.COROUTINES_PACKAGE_FQ_NAME_RELEASE");
    localObject1 = new x((l)new m((y)localObject1, (kotlin.l.b.a.b.f.b)localObject2), kotlin.l.b.a.b.b.f.aaJZ, c.abkd.iNA(), an.aaKE, kotlin.l.b.a.b.l.b.abpp);
    ((x)localObject1).b(w.aaKl);
    ((x)localObject1).d(az.aaKO);
    localObject2 = (l)localObject1;
    locala = kotlin.l.b.a.b.b.a.g.aaLw;
    ((x)localObject1).lA(j.listOf(ai.a((l)localObject2, g.a.iGe(), bh.abrq, kotlin.l.b.a.b.f.f.bHb("T"), 0, kotlin.l.b.a.b.l.b.abpp)));
    ((x)localObject1).iGC();
    aaHW = (x)localObject1;
    AppMethodBeat.o(56696);
  }
  
  public static final aj a(ab paramab, boolean paramBoolean)
  {
    AppMethodBeat.i(249913);
    p.k(paramab, "suspendFunType");
    paramBoolean = f.e(paramab);
    if ((z.aazO) && (!paramBoolean))
    {
      paramab = (Throwable)new AssertionError("This type should be suspend function type: ".concat(String.valueOf(paramab)));
      AppMethodBeat.o(249913);
      throw paramab;
    }
    g localg = a.aM(paramab);
    kotlin.l.b.a.b.b.a.g localg1 = paramab.iDY();
    ab localab = f.h(paramab);
    Object localObject2 = (Iterable)f.j(paramab);
    Object localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((av)((Iterator)localObject2).next()).iFN());
    }
    localObject1 = (Collection)localObject1;
    localObject2 = kotlin.l.b.a.b.b.a.g.aaLw;
    localObject2 = g.a.iGe();
    at localat = aaHW.iDL();
    p.j(localat, "if (isReleaseCoroutines)…ERIMENTAL.typeConstructor");
    localObject1 = j.b((Collection)localObject1, ac.c((kotlin.l.b.a.b.b.a.g)localObject2, localat, j.listOf(a.aN(f.i(paramab))), false));
    localObject2 = a.aM(paramab).iDv();
    p.j(localObject2, "suspendFunType.builtIns.nullableAnyType");
    paramab = f.a(localg, localg1, localab, (List)localObject1, (ab)localObject2).Jn(paramab.iIu());
    AppMethodBeat.o(249913);
    return paramab;
  }
  
  public static final boolean a(kotlin.l.b.a.b.f.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(56695);
    if (paramBoolean)
    {
      paramBoolean = p.h(paramb, c.abkd);
      AppMethodBeat.o(56695);
      return paramBoolean;
    }
    paramBoolean = p.h(paramb, c.abkc);
    AppMethodBeat.o(56695);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.a.k
 * JD-Core Version:    0.7.0.1
 */