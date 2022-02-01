package kotlin.l.b.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.l.b.a.b.a.a.c.a;
import kotlin.l.b.a.b.b.a.g.a;
import kotlin.l.b.a.b.b.a.j;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.f.d;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.j.b.u;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.ae;
import kotlin.l.b.a.b.m.al;
import kotlin.l.b.a.b.m.ax;
import kotlin.l.b.a.b.m.az;

public final class g
{
  private static final kotlin.l.b.a.b.a.a.c a(d paramd)
  {
    AppMethodBeat.i(191424);
    if ((!paramd.kxW()) || (paramd.ajeC.isEmpty()))
    {
      AppMethodBeat.o(191424);
      return null;
    }
    Object localObject = kotlin.l.b.a.b.a.a.c.aiEH;
    localObject = paramd.kxT().PF();
    s.s(localObject, "shortName().asString()");
    paramd = paramd.kxX().kxS();
    s.s(paramd, "toSafe().parent()");
    paramd = c.a.b((String)localObject, paramd);
    AppMethodBeat.o(191424);
    return paramd;
  }
  
  public static final al a(h paramh, kotlin.l.b.a.b.b.a.g paramg, ad paramad1, List<? extends ad> paramList, ad paramad2, boolean paramBoolean)
  {
    AppMethodBeat.i(56666);
    s.u(paramh, "builtIns");
    s.u(paramg, "annotations");
    s.u(paramList, "parameterTypes");
    s.u(paramad2, "returnType");
    s.u(paramList, "parameterTypes");
    s.u(paramad2, "returnType");
    s.u(paramh, "builtIns");
    int j = paramList.size();
    int i;
    ArrayList localArrayList;
    Object localObject2;
    if (paramad1 != null)
    {
      i = 1;
      localArrayList = new ArrayList(i + j + 1);
      localObject2 = (Collection)localArrayList;
      if (paramad1 != null) {
        break label180;
      }
    }
    label180:
    for (Object localObject1 = null;; localObject1 = kotlin.l.b.a.b.m.d.a.aF(paramad1))
    {
      kotlin.l.b.a.b.o.a.c((Collection)localObject2, localObject1);
      localObject1 = ((Iterable)paramList).iterator();
      i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        Collection localCollection = (Collection)localArrayList;
        if (i < 0) {
          p.kkW();
        }
        localCollection.add(kotlin.l.b.a.b.m.d.a.aF((ad)localObject2));
        i += 1;
      }
      i = 0;
      break;
    }
    localArrayList.add(kotlin.l.b.a.b.m.d.a.aF(paramad2));
    localObject1 = (List)localArrayList;
    if (paramad1 == null)
    {
      i = paramList.size();
      s.u(paramh, "builtIns");
      if (!paramBoolean) {
        break label306;
      }
      paramList = paramh.aKv(i);
      label237:
      s.s(paramList, "if (isSuspendFunction) b…tFunction(parameterCount)");
      paramad2 = paramg;
      if (paramad1 != null)
      {
        s.u(paramg, "<this>");
        s.u(paramh, "builtIns");
        if (!paramg.i(k.a.aiCZ)) {
          break label319;
        }
      }
    }
    for (paramad2 = paramg;; paramad2 = g.a.oS(p.d((Iterable)paramg, new j(paramh, k.a.aiCZ, kotlin.a.ak.kkZ()))))
    {
      paramh = ae.a(paramad2, paramList, (List)localObject1);
      AppMethodBeat.o(56666);
      return paramh;
      i = paramList.size() + 1;
      break;
      label306:
      paramList = paramh.bIC(k.aKw(i));
      break label237;
      label319:
      paramad1 = kotlin.l.b.a.b.b.a.g.aiIh;
    }
  }
  
  private static kotlin.l.b.a.b.a.a.c b(l paraml)
  {
    AppMethodBeat.i(191419);
    s.u(paraml, "<this>");
    if (!(paraml instanceof e))
    {
      AppMethodBeat.o(191419);
      return null;
    }
    if (!h.d(paraml))
    {
      AppMethodBeat.o(191419);
      return null;
    }
    paraml = a(kotlin.l.b.a.b.j.d.a.q(paraml));
    AppMethodBeat.o(191419);
    return paraml;
  }
  
  public static final boolean d(ad paramad)
  {
    AppMethodBeat.i(56656);
    s.u(paramad, "<this>");
    paramad = paramad.kzm().knA();
    if (paramad == null) {}
    for (paramad = null; paramad == kotlin.l.b.a.b.a.a.c.aiEM; paramad = b((l)paramad))
    {
      AppMethodBeat.o(56656);
      return true;
    }
    AppMethodBeat.o(56656);
    return false;
  }
  
  public static final boolean e(ad paramad)
  {
    AppMethodBeat.i(56657);
    s.u(paramad, "<this>");
    paramad = paramad.kzm().knA();
    if (paramad == null) {}
    for (paramad = null; paramad == kotlin.l.b.a.b.a.a.c.aiEN; paramad = b((l)paramad))
    {
      AppMethodBeat.o(56657);
      return true;
    }
    AppMethodBeat.o(56657);
    return false;
  }
  
  public static final boolean f(ad paramad)
  {
    AppMethodBeat.i(56658);
    s.u(paramad, "<this>");
    paramad = paramad.kzm().knA();
    if (paramad != null)
    {
      paramad = (l)paramad;
      s.u(paramad, "<this>");
      paramad = b(paramad);
      if ((paramad == kotlin.l.b.a.b.a.a.c.aiEM) || (paramad == kotlin.l.b.a.b.a.a.c.aiEN)) {}
      for (int i = 1; i == 1; i = 0)
      {
        AppMethodBeat.o(56658);
        return true;
      }
    }
    AppMethodBeat.o(56658);
    return false;
  }
  
  private static final boolean g(ad paramad)
  {
    AppMethodBeat.i(56659);
    if (paramad.knl().h(k.a.aiCZ) != null)
    {
      AppMethodBeat.o(56659);
      return true;
    }
    AppMethodBeat.o(56659);
    return false;
  }
  
  public static final ad h(ad paramad)
  {
    AppMethodBeat.i(56662);
    s.u(paramad, "<this>");
    boolean bool = f(paramad);
    if ((kotlin.ak.aiuY) && (!bool))
    {
      paramad = (Throwable)new AssertionError(s.X("Not a function type: ", paramad));
      AppMethodBeat.o(56662);
      throw paramad;
    }
    if (g(paramad))
    {
      paramad = ((az)p.oK(paramad.klR())).koG();
      AppMethodBeat.o(56662);
      return paramad;
    }
    AppMethodBeat.o(56662);
    return null;
  }
  
  public static final ad i(ad paramad)
  {
    AppMethodBeat.i(56663);
    s.u(paramad, "<this>");
    boolean bool = f(paramad);
    if ((kotlin.ak.aiuY) && (!bool))
    {
      paramad = (Throwable)new AssertionError(s.X("Not a function type: ", paramad));
      AppMethodBeat.o(56663);
      throw paramad;
    }
    paramad = ((az)p.oM(paramad.klR())).koG();
    s.s(paramad, "arguments.last().type");
    AppMethodBeat.o(56663);
    return paramad;
  }
  
  public static final List<az> j(ad paramad)
  {
    int j = 1;
    AppMethodBeat.i(56664);
    s.u(paramad, "<this>");
    boolean bool = f(paramad);
    if ((kotlin.ak.aiuY) && (!bool))
    {
      paramad = (Throwable)new AssertionError(s.X("Not a function type: ", paramad));
      AppMethodBeat.o(56664);
      throw paramad;
    }
    List localList = paramad.klR();
    s.u(paramad, "<this>");
    int i;
    label91:
    int k;
    if ((f(paramad)) && (g(paramad)))
    {
      i = 1;
      if (i == 0) {
        break label147;
      }
      i = 1;
      k = localList.size() - 1;
      if (i > k) {
        break label152;
      }
    }
    for (;;)
    {
      if ((!kotlin.ak.aiuY) || (j != 0)) {
        break label157;
      }
      paramad = (Throwable)new AssertionError(s.X("Not an exact function type: ", paramad));
      AppMethodBeat.o(56664);
      throw paramad;
      i = 0;
      break;
      label147:
      i = 0;
      break label91;
      label152:
      j = 0;
    }
    label157:
    paramad = localList.subList(i, k);
    AppMethodBeat.o(56664);
    return paramad;
  }
  
  public static final f k(ad paramad)
  {
    AppMethodBeat.i(56665);
    s.u(paramad, "<this>");
    paramad = paramad.knl().h(k.a.aiDa);
    if (paramad == null)
    {
      AppMethodBeat.o(56665);
      return null;
    }
    paramad = p.j((Iterable)paramad.kpA().values());
    if ((paramad instanceof u))
    {
      paramad = (u)paramad;
      if (paramad == null) {
        break label107;
      }
      paramad = (String)paramad.getValue();
      if ((paramad == null) || (!f.bJf(paramad))) {
        break label107;
      }
    }
    for (;;)
    {
      if (paramad != null) {
        break label112;
      }
      AppMethodBeat.o(56665);
      return null;
      paramad = null;
      break;
      label107:
      paramad = null;
    }
    label112:
    paramad = f.bJe(paramad);
    AppMethodBeat.o(56665);
    return paramad;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.a.g
 * JD-Core Version:    0.7.0.1
 */