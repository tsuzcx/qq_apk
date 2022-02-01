package kotlin.l.b.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.a.ae;
import kotlin.g.b.p;
import kotlin.l.b.a.b.a.a.a.a;
import kotlin.l.b.a.b.a.a.b.c;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.f.b;
import kotlin.l.b.a.b.j.b.v;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.ac;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.b.a.b.m.at;
import kotlin.l.b.a.b.m.av;
import kotlin.z;

public final class f
{
  private static final b.c a(kotlin.l.b.a.b.f.c paramc)
  {
    AppMethodBeat.i(56661);
    if ((!paramc.iNC()) || (paramc.abfJ.isEmpty()))
    {
      AppMethodBeat.o(56661);
      return null;
    }
    Object localObject = kotlin.l.b.a.b.a.a.a.aaIk;
    localObject = paramc.iNA().qu();
    p.j(localObject, "shortName().asString()");
    paramc = paramc.iND().iNz();
    p.j(paramc, "toSafe().parent()");
    paramc = a.a.b((String)localObject, paramc);
    AppMethodBeat.o(56661);
    return paramc;
  }
  
  public static final aj a(g paramg, kotlin.l.b.a.b.b.a.g paramg1, ab paramab1, List<? extends ab> paramList, ab paramab2, boolean paramBoolean)
  {
    AppMethodBeat.i(56666);
    p.k(paramg, "builtIns");
    p.k(paramg1, "annotations");
    p.k(paramList, "parameterTypes");
    p.k(paramab2, "returnType");
    p.k(paramList, "parameterTypes");
    p.k(paramab2, "returnType");
    p.k(paramg, "builtIns");
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
    for (Object localObject1 = kotlin.l.b.a.b.m.d.a.aN(paramab1);; localObject1 = null)
    {
      kotlin.l.b.a.b.o.a.c((Collection)localObject2, localObject1);
      localObject1 = ((Iterable)paramList).iterator();
      i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        Collection localCollection = (Collection)localArrayList;
        if (i < 0) {
          kotlin.a.j.iBO();
        }
        localCollection.add(kotlin.l.b.a.b.m.d.a.aN((ab)localObject2));
        i += 1;
      }
      i = 0;
      break;
    }
    localArrayList.add(kotlin.l.b.a.b.m.d.a.aN(paramab2));
    localObject1 = (List)localArrayList;
    int i = paramList.size();
    if (paramab1 == null)
    {
      if (!paramBoolean) {
        break label295;
      }
      paramList = paramg.aDJ(i);
      label231:
      p.j(paramList, "if (suspendFunction) bui…tFunction(parameterCount)");
      paramab2 = paramg1;
      if (paramab1 != null)
      {
        paramab1 = g.aaFI.aaGm;
        p.j(paramab1, "KotlinBuiltIns.FQ_NAMES.extensionFunctionType");
        if (paramg1.g(paramab1) == null) {
          break label308;
        }
      }
    }
    for (paramab2 = paramg1;; paramab2 = kotlin.l.b.a.b.b.a.g.a.lw(kotlin.a.j.d(paramg1, new kotlin.l.b.a.b.b.a.j(paramg, paramab1, ae.iBR()))))
    {
      paramg = ac.a(paramab2, paramList, (List)localObject1);
      AppMethodBeat.o(56666);
      return paramg;
      i += 1;
      break;
      label295:
      paramList = paramg.bGC(g.aDH(i));
      break label231;
      label308:
      paramab1 = kotlin.l.b.a.b.b.a.g.aaLw;
      paramg1 = (Iterable)paramg1;
      paramab1 = g.aaFI.aaGm;
      p.j(paramab1, "KotlinBuiltIns.FQ_NAMES.extensionFunctionType");
    }
  }
  
  private static b.c b(l paraml)
  {
    AppMethodBeat.i(56660);
    p.k(paraml, "$this$getFunctionalClassKind");
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
    paraml = a(kotlin.l.b.a.b.j.d.a.q(paraml));
    AppMethodBeat.o(56660);
    return paraml;
  }
  
  public static final boolean d(ab paramab)
  {
    AppMethodBeat.i(56656);
    p.k(paramab, "$this$isFunctionType");
    paramab = paramab.iOU().iEf();
    if (paramab != null) {}
    for (paramab = b((l)paramab); paramab == b.c.aaIu; paramab = null)
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
    p.k(paramab, "$this$isSuspendFunctionType");
    paramab = paramab.iOU().iEf();
    if (paramab != null) {}
    for (paramab = b((l)paramab); paramab == b.c.aaIv; paramab = null)
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
    p.k(paramab, "$this$isBuiltinFunctionalType");
    paramab = paramab.iOU().iEf();
    if (paramab != null) {}
    for (paramab = b((l)paramab); (paramab == b.c.aaIu) || (paramab == b.c.aaIv); paramab = null)
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
    paramab = paramab.iDY();
    b localb = g.aaFI.aaGm;
    p.j(localb, "KotlinBuiltIns.FQ_NAMES.extensionFunctionType");
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
    p.k(paramab, "$this$getReceiverTypeFromFunctionType");
    boolean bool = f(paramab);
    if ((z.aazO) && (!bool))
    {
      paramab = (Throwable)new AssertionError("Not a function type: ".concat(String.valueOf(paramab)));
      AppMethodBeat.o(56662);
      throw paramab;
    }
    if (g(paramab))
    {
      paramab = ((av)kotlin.a.j.lo(paramab.iOR())).iFN();
      AppMethodBeat.o(56662);
      return paramab;
    }
    AppMethodBeat.o(56662);
    return null;
  }
  
  public static final ab i(ab paramab)
  {
    AppMethodBeat.i(56663);
    p.k(paramab, "$this$getReturnTypeFromFunctionType");
    boolean bool = f(paramab);
    if ((z.aazO) && (!bool))
    {
      paramab = (Throwable)new AssertionError("Not a function type: ".concat(String.valueOf(paramab)));
      AppMethodBeat.o(56663);
      throw paramab;
    }
    paramab = ((av)kotlin.a.j.lq(paramab.iOR())).iFN();
    p.j(paramab, "arguments.last().type");
    AppMethodBeat.o(56663);
    return paramab;
  }
  
  public static final List<av> j(ab paramab)
  {
    int j = 1;
    AppMethodBeat.i(56664);
    p.k(paramab, "$this$getValueParameterTypesFromFunctionType");
    boolean bool = f(paramab);
    if ((z.aazO) && (!bool))
    {
      paramab = (Throwable)new AssertionError("Not a function type: ".concat(String.valueOf(paramab)));
      AppMethodBeat.o(56664);
      throw paramab;
    }
    List localList = paramab.iOR();
    p.k(paramab, "$this$isBuiltinExtensionFunctionalType");
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
      if ((!z.aazO) || (j != 0)) {
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
  
  public static final kotlin.l.b.a.b.f.f k(ab paramab)
  {
    AppMethodBeat.i(56665);
    p.k(paramab, "$this$extractParameterNameFromFunctionTypeArgument");
    paramab = paramab.iDY();
    Object localObject = g.aaFI.aaGn;
    p.j(localObject, "KotlinBuiltIns.FQ_NAMES.parameterName");
    paramab = paramab.g((b)localObject);
    if (paramab == null)
    {
      AppMethodBeat.o(56665);
      return null;
    }
    localObject = kotlin.a.j.j((Iterable)paramab.iGd().values());
    paramab = (ab)localObject;
    if (!(localObject instanceof v)) {
      paramab = null;
    }
    paramab = (v)paramab;
    if (paramab != null)
    {
      paramab = (String)paramab.getValue();
      if (paramab != null) {
        if (!kotlin.l.b.a.b.f.f.bHc(paramab)) {
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
    paramab = kotlin.l.b.a.b.f.f.bHb(paramab);
    AppMethodBeat.o(56665);
    return paramab;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.a.f
 * JD-Core Version:    0.7.0.1
 */