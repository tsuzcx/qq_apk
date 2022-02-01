package d.l.b.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.ae;
import d.aa;
import d.g.b.k;
import d.l.b.a.b.a.a.a.a;
import d.l.b.a.b.a.a.b.c;
import d.l.b.a.b.b.e;
import d.l.b.a.b.b.l;
import d.l.b.a.b.f.b;
import d.l.b.a.b.j.b.v;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.ac;
import d.l.b.a.b.m.aj;
import d.l.b.a.b.m.at;
import d.l.b.a.b.m.av;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class f
{
  private static final b.c a(d.l.b.a.b.f.c paramc)
  {
    AppMethodBeat.i(56661);
    if ((!paramc.fZK()) || (paramc.Lzo.isEmpty()))
    {
      AppMethodBeat.o(56661);
      return null;
    }
    Object localObject = d.l.b.a.b.a.a.a.LbI;
    localObject = paramc.fZI().rf();
    k.g(localObject, "shortName().asString()");
    paramc = paramc.fZL().fZH();
    k.g(paramc, "toSafe().parent()");
    paramc = a.a.b((String)localObject, paramc);
    AppMethodBeat.o(56661);
    return paramc;
  }
  
  public static final aj a(g paramg, d.l.b.a.b.b.a.g paramg1, ab paramab1, List<? extends ab> paramList, ab paramab2, boolean paramBoolean)
  {
    AppMethodBeat.i(56666);
    k.h(paramg, "builtIns");
    k.h(paramg1, "annotations");
    k.h(paramList, "parameterTypes");
    k.h(paramab2, "returnType");
    k.h(paramList, "parameterTypes");
    k.h(paramab2, "returnType");
    k.h(paramg, "builtIns");
    int j = paramList.size();
    ArrayList localArrayList;
    Object localObject2;
    if (paramab1 != null)
    {
      i = 1;
      localArrayList = new ArrayList(i + j + 1);
      localObject2 = (Collection)localArrayList;
      if (paramab1 == null) {
        break label183;
      }
    }
    label183:
    for (Object localObject1 = d.l.b.a.b.m.d.a.aO(paramab1);; localObject1 = null)
    {
      d.l.b.a.b.o.a.c((Collection)localObject2, localObject1);
      localObject1 = ((Iterable)paramList).iterator();
      i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        Collection localCollection = (Collection)localArrayList;
        if (i < 0) {
          d.a.j.fOc();
        }
        localCollection.add(d.l.b.a.b.m.d.a.aO((ab)localObject2));
        i += 1;
      }
      i = 0;
      break;
    }
    localArrayList.add(d.l.b.a.b.m.d.a.aO(paramab2));
    localObject1 = (List)localArrayList;
    int i = paramList.size();
    if (paramab1 == null)
    {
      if (!paramBoolean) {
        break label295;
      }
      paramList = paramg.agO(i);
      label231:
      k.g(paramList, "if (suspendFunction) bui…tFunction(parameterCount)");
      paramab2 = paramg1;
      if (paramab1 != null)
      {
        paramab1 = g.KZg.KZK;
        k.g(paramab1, "KotlinBuiltIns.FQ_NAMES.extensionFunctionType");
        if (paramg1.g(paramab1) == null) {
          break label308;
        }
      }
    }
    for (paramab2 = paramg1;; paramab2 = d.l.b.a.b.b.a.g.a.iX(d.a.j.d(paramg1, new d.l.b.a.b.b.a.j(paramg, paramab1, ae.emptyMap()))))
    {
      paramg = ac.a(paramab2, paramList, (List)localObject1);
      AppMethodBeat.o(56666);
      return paramg;
      i += 1;
      break;
      label295:
      paramList = paramg.aWc(g.agM(i));
      break label231;
      label308:
      paramab1 = d.l.b.a.b.b.a.g.LeU;
      paramg1 = (Iterable)paramg1;
      paramab1 = g.KZg.KZK;
      k.g(paramab1, "KotlinBuiltIns.FQ_NAMES.extensionFunctionType");
    }
  }
  
  private static b.c b(l paraml)
  {
    AppMethodBeat.i(56660);
    k.h(paraml, "$this$getFunctionalClassKind");
    if (!(paraml instanceof e))
    {
      AppMethodBeat.o(56660);
      return null;
    }
    if (!g.d(paraml))
    {
      AppMethodBeat.o(56660);
      return null;
    }
    paraml = a(d.l.b.a.b.j.d.a.q(paraml));
    AppMethodBeat.o(56660);
    return paraml;
  }
  
  public static final boolean d(ab paramab)
  {
    AppMethodBeat.i(56656);
    k.h(paramab, "$this$isFunctionType");
    paramab = paramab.gbz().fQq();
    if (paramab != null) {}
    for (paramab = b((l)paramab); paramab == b.c.LbS; paramab = null)
    {
      AppMethodBeat.o(56656);
      return true;
    }
    AppMethodBeat.o(56656);
    return false;
  }
  
  public static final boolean e(ab paramab)
  {
    AppMethodBeat.i(56657);
    k.h(paramab, "$this$isSuspendFunctionType");
    paramab = paramab.gbz().fQq();
    if (paramab != null) {}
    for (paramab = b((l)paramab); paramab == b.c.LbT; paramab = null)
    {
      AppMethodBeat.o(56657);
      return true;
    }
    AppMethodBeat.o(56657);
    return false;
  }
  
  public static final boolean f(ab paramab)
  {
    AppMethodBeat.i(56658);
    k.h(paramab, "$this$isBuiltinFunctionalType");
    paramab = paramab.gbz().fQq();
    if (paramab != null) {}
    for (paramab = b((l)paramab); (paramab == b.c.LbS) || (paramab == b.c.LbT); paramab = null)
    {
      AppMethodBeat.o(56658);
      return true;
    }
    AppMethodBeat.o(56658);
    return false;
  }
  
  private static final boolean g(ab paramab)
  {
    AppMethodBeat.i(56659);
    paramab = paramab.fQj();
    b localb = g.KZg.KZK;
    k.g(localb, "KotlinBuiltIns.FQ_NAMES.extensionFunctionType");
    if (paramab.g(localb) != null)
    {
      AppMethodBeat.o(56659);
      return true;
    }
    AppMethodBeat.o(56659);
    return false;
  }
  
  public static final ab h(ab paramab)
  {
    AppMethodBeat.i(56662);
    k.h(paramab, "$this$getReceiverTypeFromFunctionType");
    boolean bool = f(paramab);
    if ((aa.KTq) && (!bool))
    {
      paramab = (Throwable)new AssertionError("Not a function type: ".concat(String.valueOf(paramab)));
      AppMethodBeat.o(56662);
      throw paramab;
    }
    if (g(paramab))
    {
      paramab = ((av)d.a.j.iO(paramab.gbw())).fRV();
      AppMethodBeat.o(56662);
      return paramab;
    }
    AppMethodBeat.o(56662);
    return null;
  }
  
  public static final ab i(ab paramab)
  {
    AppMethodBeat.i(56663);
    k.h(paramab, "$this$getReturnTypeFromFunctionType");
    boolean bool = f(paramab);
    if ((aa.KTq) && (!bool))
    {
      paramab = (Throwable)new AssertionError("Not a function type: ".concat(String.valueOf(paramab)));
      AppMethodBeat.o(56663);
      throw paramab;
    }
    paramab = ((av)d.a.j.iQ(paramab.gbw())).fRV();
    k.g(paramab, "arguments.last().type");
    AppMethodBeat.o(56663);
    return paramab;
  }
  
  public static final List<av> j(ab paramab)
  {
    int j = 1;
    AppMethodBeat.i(56664);
    k.h(paramab, "$this$getValueParameterTypesFromFunctionType");
    boolean bool = f(paramab);
    if ((aa.KTq) && (!bool))
    {
      paramab = (Throwable)new AssertionError("Not a function type: ".concat(String.valueOf(paramab)));
      AppMethodBeat.o(56664);
      throw paramab;
    }
    List localList = paramab.gbw();
    k.h(paramab, "$this$isBuiltinExtensionFunctionalType");
    int i;
    label96:
    int k;
    if ((f(paramab)) && (g(paramab)))
    {
      i = 1;
      if (i == 0) {
        break label155;
      }
      i = 1;
      k = localList.size() - 1;
      if (i > k) {
        break label160;
      }
    }
    for (;;)
    {
      if ((!aa.KTq) || (j != 0)) {
        break label165;
      }
      paramab = (Throwable)new AssertionError("Not an exact function type: ".concat(String.valueOf(paramab)));
      AppMethodBeat.o(56664);
      throw paramab;
      i = 0;
      break;
      label155:
      i = 0;
      break label96;
      label160:
      j = 0;
    }
    label165:
    paramab = localList.subList(i, k);
    AppMethodBeat.o(56664);
    return paramab;
  }
  
  public static final d.l.b.a.b.f.f k(ab paramab)
  {
    AppMethodBeat.i(56665);
    k.h(paramab, "$this$extractParameterNameFromFunctionTypeArgument");
    paramab = paramab.fQj();
    Object localObject = g.KZg.KZL;
    k.g(localObject, "KotlinBuiltIns.FQ_NAMES.parameterName");
    paramab = paramab.g((b)localObject);
    if (paramab == null)
    {
      AppMethodBeat.o(56665);
      return null;
    }
    localObject = d.a.j.g((Iterable)paramab.fSl().values());
    paramab = (ab)localObject;
    if (!(localObject instanceof v)) {
      paramab = null;
    }
    paramab = (v)paramab;
    if (paramab != null)
    {
      paramab = (String)paramab.getValue();
      if (paramab != null) {
        if (!d.l.b.a.b.f.f.aWC(paramab)) {
          break label121;
        }
      }
    }
    while (paramab == null)
    {
      AppMethodBeat.o(56665);
      return null;
      label121:
      paramab = null;
    }
    paramab = d.l.b.a.b.f.f.aWB(paramab);
    AppMethodBeat.o(56665);
    return paramab;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.a.f
 * JD-Core Version:    0.7.0.1
 */