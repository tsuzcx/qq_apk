package kotlin.l.b.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.p;
import kotlin.ak;
import kotlin.l.b.a.b.b.a.g.a;
import kotlin.l.b.a.b.b.ab;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.c.aj;
import kotlin.l.b.a.b.b.c.m;
import kotlin.l.b.a.b.b.c.x;
import kotlin.l.b.a.b.f.c;
import kotlin.l.b.a.b.l.e;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.al;
import kotlin.l.b.a.b.m.ax;
import kotlin.l.b.a.b.m.az;
import kotlin.l.b.a.b.m.bl;
import kotlin.l.b.a.b.m.d.a;
import kotlin.l.b.a.b.m.v;

public final class l
{
  private static final x aiEc;
  private static final x aiEd;
  
  static
  {
    AppMethodBeat.i(56696);
    Object localObject = v.kAF();
    kotlin.g.b.s.s(localObject, "getErrorModule()");
    localObject = new x((kotlin.l.b.a.b.b.l)new m((kotlin.l.b.a.b.b.ae)localObject, k.aiCj), kotlin.l.b.a.b.b.f.aiGu, k.aiCl.kxT(), av.aiHu, e.ajos);
    ((x)localObject).b(ab.aiHb);
    ((x)localObject).e(kotlin.l.b.a.b.b.s.aiGG);
    kotlin.l.b.a.b.b.l locall = (kotlin.l.b.a.b.b.l)localObject;
    g.a locala = kotlin.l.b.a.b.b.a.g.aiIh;
    ((x)localObject).oY(p.listOf(aj.a(locall, g.a.kpB(), bl.ajqN, kotlin.l.b.a.b.f.f.bJe("T"), 0, e.ajos)));
    ((x)localObject).kpZ();
    aiEc = (x)localObject;
    localObject = v.kAF();
    kotlin.g.b.s.s(localObject, "getErrorModule()");
    localObject = new x((kotlin.l.b.a.b.b.l)new m((kotlin.l.b.a.b.b.ae)localObject, k.aiCi), kotlin.l.b.a.b.b.f.aiGu, k.aiCm.kxT(), av.aiHu, e.ajos);
    ((x)localObject).b(ab.aiHb);
    ((x)localObject).e(kotlin.l.b.a.b.b.s.aiGG);
    locall = (kotlin.l.b.a.b.b.l)localObject;
    locala = kotlin.l.b.a.b.b.a.g.aiIh;
    ((x)localObject).oY(p.listOf(aj.a(locall, g.a.kpB(), bl.ajqN, kotlin.l.b.a.b.f.f.bJe("T"), 0, e.ajos)));
    ((x)localObject).kpZ();
    aiEd = (x)localObject;
    AppMethodBeat.o(56696);
  }
  
  public static final al a(ad paramad, boolean paramBoolean)
  {
    AppMethodBeat.i(191402);
    kotlin.g.b.s.u(paramad, "suspendFunType");
    boolean bool = g.e(paramad);
    if ((ak.aiuY) && (!bool))
    {
      paramad = (Throwable)new AssertionError(kotlin.g.b.s.X("This type should be suspend function type: ", paramad));
      AppMethodBeat.o(191402);
      throw paramad;
    }
    h localh = a.aE(paramad);
    kotlin.l.b.a.b.b.a.g localg1 = paramad.knl();
    ad localad = g.h(paramad);
    Object localObject2 = (Iterable)g.j(paramad);
    Object localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((az)((Iterator)localObject2).next()).koG());
    }
    localObject2 = (Collection)localObject1;
    localObject1 = kotlin.l.b.a.b.b.a.g.aiIh;
    kotlin.l.b.a.b.b.a.g localg2 = g.a.kpB();
    if (paramBoolean) {}
    for (localObject1 = aiEd.kmZ();; localObject1 = aiEc.kmZ())
    {
      kotlin.g.b.s.s(localObject1, "if (isReleaseCoroutines)…ERIMENTAL.typeConstructor");
      localObject1 = p.b((Collection)localObject2, kotlin.l.b.a.b.m.ae.c(localg2, (ax)localObject1, p.listOf(a.aF(g.i(paramad))), false));
      localObject2 = a.aE(paramad).kmP();
      kotlin.g.b.s.s(localObject2, "suspendFunType.builtIns.nullableAnyType");
      paramad = g.a(localh, localg1, localad, (List)localObject1, (ad)localObject2).Pq(paramad.ksB());
      AppMethodBeat.o(191402);
      return paramad;
    }
  }
  
  public static final boolean a(c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(56695);
    if (paramBoolean)
    {
      paramBoolean = kotlin.g.b.s.p(paramc, k.aiCm);
      AppMethodBeat.o(56695);
      return paramBoolean;
    }
    paramBoolean = kotlin.g.b.s.p(paramc, k.aiCl);
    AppMethodBeat.o(56695);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.a.l
 * JD-Core Version:    0.7.0.1
 */