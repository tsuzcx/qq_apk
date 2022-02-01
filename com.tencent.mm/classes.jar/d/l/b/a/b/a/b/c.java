package d.l.b.a.b.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.ac;
import d.g.b.p;
import d.l.b.a.b.a.a.b.c;
import d.l.b.a.b.a.g;
import d.l.b.a.b.a.g.a;
import d.l.b.a.b.b.e;
import d.l.b.a.b.b.l;
import d.l.b.a.b.f.b;
import d.l.b.a.b.f.f;
import d.l.b.a.b.f.h;
import d.n.n;
import d.v;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class c
{
  private static final String MTa;
  private static final String MTb;
  private static final String MTc;
  private static final String MTd;
  private static final d.l.b.a.b.f.a MTe;
  private static final b MTf;
  private static final d.l.b.a.b.f.a MTg;
  private static final HashMap<d.l.b.a.b.f.c, d.l.b.a.b.f.a> MTh;
  private static final HashMap<d.l.b.a.b.f.c, d.l.b.a.b.f.a> MTi;
  private static final HashMap<d.l.b.a.b.f.c, b> MTj;
  static final HashMap<d.l.b.a.b.f.c, b> MTk;
  private static final List<c.a> MTl;
  public static final c MTm;
  
  static
  {
    AppMethodBeat.i(56767);
    c localc = new c();
    MTm = localc;
    MTa = b.c.MSN.MSS.toString() + "." + b.c.MSN.MST;
    MTb = b.c.MSP.MSS.toString() + "." + b.c.MSP.MST;
    MTc = b.c.MSO.MSS.toString() + "." + b.c.MSO.MST;
    MTd = b.c.MSQ.MSS.toString() + "." + b.c.MSQ.MST;
    Object localObject1 = d.l.b.a.b.f.a.p(new b("kotlin.jvm.functions.FunctionN"));
    p.g(localObject1, "ClassId.topLevel(FqName(…vm.functions.FunctionN\"))");
    MTe = (d.l.b.a.b.f.a)localObject1;
    localObject1 = ((d.l.b.a.b.f.a)localObject1).gre();
    p.g(localObject1, "FUNCTION_N_CLASS_ID.asSingleFqName()");
    MTf = (b)localObject1;
    localObject1 = d.l.b.a.b.f.a.p(new b("kotlin.reflect.KFunction"));
    p.g(localObject1, "ClassId.topLevel(FqName(…tlin.reflect.KFunction\"))");
    MTg = (d.l.b.a.b.f.a)localObject1;
    MTh = new HashMap();
    MTi = new HashMap();
    MTj = new HashMap();
    MTk = new HashMap();
    localObject1 = d.l.b.a.b.f.a.p(g.MQb.MQR);
    p.g(localObject1, "ClassId.topLevel(FQ_NAMES.iterable)");
    Object localObject2 = g.MQb.MQZ;
    p.g(localObject2, "FQ_NAMES.mutableIterable");
    Object localObject3 = ((d.l.b.a.b.f.a)localObject1).gqZ();
    Object localObject4 = ((d.l.b.a.b.f.a)localObject1).gqZ();
    p.g(localObject4, "kotlinReadOnly.packageFqName");
    localObject2 = new d.l.b.a.b.f.a((b)localObject3, d.l.b.a.b.f.d.b((b)localObject2, (b)localObject4), false);
    localObject1 = new c.a(localc.bu(Iterable.class), (d.l.b.a.b.f.a)localObject1, (d.l.b.a.b.f.a)localObject2);
    localObject2 = d.l.b.a.b.f.a.p(g.MQb.MQQ);
    p.g(localObject2, "ClassId.topLevel(FQ_NAMES.iterator)");
    localObject3 = g.MQb.MQY;
    p.g(localObject3, "FQ_NAMES.mutableIterator");
    localObject4 = ((d.l.b.a.b.f.a)localObject2).gqZ();
    Object localObject5 = ((d.l.b.a.b.f.a)localObject2).gqZ();
    p.g(localObject5, "kotlinReadOnly.packageFqName");
    localObject3 = new d.l.b.a.b.f.a((b)localObject4, d.l.b.a.b.f.d.b((b)localObject3, (b)localObject5), false);
    localObject2 = new c.a(localc.bu(Iterator.class), (d.l.b.a.b.f.a)localObject2, (d.l.b.a.b.f.a)localObject3);
    localObject3 = d.l.b.a.b.f.a.p(g.MQb.MQS);
    p.g(localObject3, "ClassId.topLevel(FQ_NAMES.collection)");
    localObject4 = g.MQb.MRa;
    p.g(localObject4, "FQ_NAMES.mutableCollection");
    localObject5 = ((d.l.b.a.b.f.a)localObject3).gqZ();
    Object localObject6 = ((d.l.b.a.b.f.a)localObject3).gqZ();
    p.g(localObject6, "kotlinReadOnly.packageFqName");
    localObject4 = new d.l.b.a.b.f.a((b)localObject5, d.l.b.a.b.f.d.b((b)localObject4, (b)localObject6), false);
    localObject3 = new c.a(localc.bu(Collection.class), (d.l.b.a.b.f.a)localObject3, (d.l.b.a.b.f.a)localObject4);
    localObject4 = d.l.b.a.b.f.a.p(g.MQb.MQT);
    p.g(localObject4, "ClassId.topLevel(FQ_NAMES.list)");
    localObject5 = g.MQb.MRb;
    p.g(localObject5, "FQ_NAMES.mutableList");
    localObject6 = ((d.l.b.a.b.f.a)localObject4).gqZ();
    Object localObject7 = ((d.l.b.a.b.f.a)localObject4).gqZ();
    p.g(localObject7, "kotlinReadOnly.packageFqName");
    localObject5 = new d.l.b.a.b.f.a((b)localObject6, d.l.b.a.b.f.d.b((b)localObject5, (b)localObject7), false);
    localObject4 = new c.a(localc.bu(List.class), (d.l.b.a.b.f.a)localObject4, (d.l.b.a.b.f.a)localObject5);
    localObject5 = d.l.b.a.b.f.a.p(g.MQb.MQV);
    p.g(localObject5, "ClassId.topLevel(FQ_NAMES.set)");
    localObject6 = g.MQb.MRd;
    p.g(localObject6, "FQ_NAMES.mutableSet");
    localObject7 = ((d.l.b.a.b.f.a)localObject5).gqZ();
    Object localObject8 = ((d.l.b.a.b.f.a)localObject5).gqZ();
    p.g(localObject8, "kotlinReadOnly.packageFqName");
    localObject6 = new d.l.b.a.b.f.a((b)localObject7, d.l.b.a.b.f.d.b((b)localObject6, (b)localObject8), false);
    localObject5 = new c.a(localc.bu(Set.class), (d.l.b.a.b.f.a)localObject5, (d.l.b.a.b.f.a)localObject6);
    localObject6 = d.l.b.a.b.f.a.p(g.MQb.MQU);
    p.g(localObject6, "ClassId.topLevel(FQ_NAMES.listIterator)");
    localObject7 = g.MQb.MRc;
    p.g(localObject7, "FQ_NAMES.mutableListIterator");
    localObject8 = ((d.l.b.a.b.f.a)localObject6).gqZ();
    Object localObject9 = ((d.l.b.a.b.f.a)localObject6).gqZ();
    p.g(localObject9, "kotlinReadOnly.packageFqName");
    localObject7 = new d.l.b.a.b.f.a((b)localObject8, d.l.b.a.b.f.d.b((b)localObject7, (b)localObject9), false);
    localObject6 = new c.a(localc.bu(ListIterator.class), (d.l.b.a.b.f.a)localObject6, (d.l.b.a.b.f.a)localObject7);
    localObject7 = d.l.b.a.b.f.a.p(g.MQb.MQW);
    p.g(localObject7, "ClassId.topLevel(FQ_NAMES.map)");
    localObject8 = g.MQb.MRe;
    p.g(localObject8, "FQ_NAMES.mutableMap");
    localObject9 = ((d.l.b.a.b.f.a)localObject7).gqZ();
    b localb1 = ((d.l.b.a.b.f.a)localObject7).gqZ();
    p.g(localb1, "kotlinReadOnly.packageFqName");
    localObject8 = new d.l.b.a.b.f.a((b)localObject9, d.l.b.a.b.f.d.b((b)localObject8, localb1), false);
    localObject7 = new c.a(localc.bu(Map.class), (d.l.b.a.b.f.a)localObject7, (d.l.b.a.b.f.a)localObject8);
    localObject8 = d.l.b.a.b.f.a.p(g.MQb.MQW).o(g.MQb.MQX.grh());
    p.g(localObject8, "ClassId.topLevel(FQ_NAME…MES.mapEntry.shortName())");
    localObject9 = g.MQb.MRf;
    p.g(localObject9, "FQ_NAMES.mutableMapEntry");
    localb1 = ((d.l.b.a.b.f.a)localObject8).gqZ();
    b localb2 = ((d.l.b.a.b.f.a)localObject8).gqZ();
    p.g(localb2, "kotlinReadOnly.packageFqName");
    localObject9 = new d.l.b.a.b.f.a(localb1, d.l.b.a.b.f.d.b((b)localObject9, localb2), false);
    MTl = j.listOf(new c.a[] { localObject1, localObject2, localObject3, localObject4, localObject5, localObject6, localObject7, new c.a(localc.bu(Map.Entry.class), (d.l.b.a.b.f.a)localObject8, (d.l.b.a.b.f.a)localObject9) });
    localObject1 = g.MQb.MQf;
    p.g(localObject1, "FQ_NAMES.any");
    localc.a(Object.class, (d.l.b.a.b.f.c)localObject1);
    localObject1 = g.MQb.MQl;
    p.g(localObject1, "FQ_NAMES.string");
    localc.a(String.class, (d.l.b.a.b.f.c)localObject1);
    localObject1 = g.MQb.MQk;
    p.g(localObject1, "FQ_NAMES.charSequence");
    localc.a(CharSequence.class, (d.l.b.a.b.f.c)localObject1);
    localObject1 = g.MQb.MQy;
    p.g(localObject1, "FQ_NAMES.throwable");
    localc.a(Throwable.class, (b)localObject1);
    localObject1 = g.MQb.MQh;
    p.g(localObject1, "FQ_NAMES.cloneable");
    localc.a(Cloneable.class, (d.l.b.a.b.f.c)localObject1);
    localObject1 = g.MQb.MQv;
    p.g(localObject1, "FQ_NAMES.number");
    localc.a(Number.class, (d.l.b.a.b.f.c)localObject1);
    localObject1 = g.MQb.MQz;
    p.g(localObject1, "FQ_NAMES.comparable");
    localc.a(Comparable.class, (b)localObject1);
    localObject1 = g.MQb.MQw;
    p.g(localObject1, "FQ_NAMES._enum");
    localc.a(Enum.class, (d.l.b.a.b.f.c)localObject1);
    localObject1 = g.MQb.MQH;
    p.g(localObject1, "FQ_NAMES.annotation");
    localc.a(Annotation.class, (b)localObject1);
    localObject1 = MTl.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (c.a)((Iterator)localObject1).next();
      localObject3 = ((c.a)localObject2).MTn;
      localObject4 = ((c.a)localObject2).MTo;
      localObject2 = ((c.a)localObject2).MTp;
      a((d.l.b.a.b.f.a)localObject3, (d.l.b.a.b.f.a)localObject4);
      localObject5 = ((d.l.b.a.b.f.a)localObject2).gre();
      p.g(localObject5, "mutableClassId.asSingleFqName()");
      a((b)localObject5, (d.l.b.a.b.f.a)localObject3);
      localObject4 = ((d.l.b.a.b.f.a)localObject4).gre();
      p.g(localObject4, "readOnlyClassId.asSingleFqName()");
      localObject3 = ((d.l.b.a.b.f.a)localObject2).gre();
      p.g(localObject3, "mutableClassId.asSingleFqName()");
      localObject5 = (Map)MTj;
      localObject2 = ((d.l.b.a.b.f.a)localObject2).gre().grf();
      p.g(localObject2, "mutableClassId.asSingleFqName().toUnsafe()");
      ((Map)localObject5).put(localObject2, localObject4);
      localObject2 = (Map)MTk;
      localObject4 = ((b)localObject4).grf();
      p.g(localObject4, "readOnlyFqName.toUnsafe()");
      ((Map)localObject2).put(localObject4, localObject3);
    }
    localObject1 = d.l.b.a.b.j.e.d.values();
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      localObject3 = localObject1[i];
      localObject2 = d.l.b.a.b.f.a.p(((d.l.b.a.b.j.e.d)localObject3).gtg());
      p.g(localObject2, "ClassId.topLevel(jvmType.wrapperFqName)");
      localObject3 = d.l.b.a.b.f.a.p(g.c(((d.l.b.a.b.j.e.d)localObject3).gte()));
      p.g(localObject3, "ClassId.topLevel(KotlinB…e(jvmType.primitiveType))");
      a((d.l.b.a.b.f.a)localObject2, (d.l.b.a.b.f.a)localObject3);
      i += 1;
    }
    localObject1 = d.l.b.a.b.a.c.MPM;
    localObject1 = d.l.b.a.b.a.c.ggV().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (d.l.b.a.b.f.a)((Iterator)localObject1).next();
      localObject2 = d.l.b.a.b.f.a.p(new b("kotlin.jvm.internal." + ((d.l.b.a.b.f.a)localObject3).grb().sD() + "CompanionObject"));
      p.g(localObject2, "ClassId.topLevel(FqName(…g() + \"CompanionObject\"))");
      localObject3 = ((d.l.b.a.b.f.a)localObject3).o(h.Nqu);
      p.g(localObject3, "classId.createNestedClas…AME_FOR_COMPANION_OBJECT)");
      a((d.l.b.a.b.f.a)localObject2, (d.l.b.a.b.f.a)localObject3);
    }
    i = 0;
    while (i < 23)
    {
      localObject1 = d.l.b.a.b.f.a.p(new b("kotlin.jvm.functions.Function".concat(String.valueOf(i))));
      p.g(localObject1, "ClassId.topLevel(FqName(…m.functions.Function$i\"))");
      localObject2 = g.ajo(i);
      p.g(localObject2, "KotlinBuiltIns.getFunctionClassId(i)");
      a((d.l.b.a.b.f.a)localObject1, (d.l.b.a.b.f.a)localObject2);
      a(new b(MTb + i), MTg);
      i += 1;
    }
    i = 0;
    while (i < 22)
    {
      localObject1 = b.c.MSQ;
      localObject1 = ((b.c)localObject1).MSS.toString() + "." + ((b.c)localObject1).MST;
      a(new b((String)localObject1 + i), MTg);
      i += 1;
    }
    localObject1 = g.MQb.MQg.grk();
    p.g(localObject1, "FQ_NAMES.nothing.toSafe()");
    a((b)localObject1, localc.bu(Void.class));
    AppMethodBeat.o(56767);
  }
  
  private static e a(e parame, Map<d.l.b.a.b.f.c, b> paramMap, String paramString)
  {
    AppMethodBeat.i(56766);
    paramMap = (b)paramMap.get(d.l.b.a.b.j.c.n((l)parame));
    if (paramMap == null)
    {
      parame = (Throwable)new IllegalArgumentException("Given class " + parame + " is not a " + paramString + " collection");
      AppMethodBeat.o(56766);
      throw parame;
    }
    parame = d.l.b.a.b.j.d.a.G((l)parame).a(paramMap);
    p.g(parame, "descriptor.builtIns.getB…Name(oppositeClassFqName)");
    AppMethodBeat.o(56766);
    return parame;
  }
  
  private static void a(d.l.b.a.b.f.a parama1, d.l.b.a.b.f.a parama2)
  {
    AppMethodBeat.i(56757);
    Map localMap = (Map)MTh;
    d.l.b.a.b.f.c localc = parama1.gre().grf();
    p.g(localc, "javaClassId.asSingleFqName().toUnsafe()");
    localMap.put(localc, parama2);
    parama2 = parama2.gre();
    p.g(parama2, "kotlinClassId.asSingleFqName()");
    a(parama2, parama1);
    AppMethodBeat.o(56757);
  }
  
  private static void a(b paramb, d.l.b.a.b.f.a parama)
  {
    AppMethodBeat.i(56760);
    Map localMap = (Map)MTi;
    paramb = paramb.grf();
    p.g(paramb, "kotlinFqNameUnsafe.toUnsafe()");
    localMap.put(paramb, parama);
    AppMethodBeat.o(56760);
  }
  
  private final void a(Class<?> paramClass, b paramb)
  {
    AppMethodBeat.i(56759);
    paramClass = bu(paramClass);
    paramb = d.l.b.a.b.f.a.p(paramb);
    p.g(paramb, "ClassId.topLevel(kotlinFqName)");
    a(paramClass, paramb);
    AppMethodBeat.o(56759);
  }
  
  private final void a(Class<?> paramClass, d.l.b.a.b.f.c paramc)
  {
    AppMethodBeat.i(56758);
    paramc = paramc.grk();
    p.g(paramc, "kotlinFqName.toSafe()");
    a(paramClass, paramc);
    AppMethodBeat.o(56758);
  }
  
  private static boolean a(d.l.b.a.b.f.c paramc, String paramString)
  {
    AppMethodBeat.i(56756);
    paramc = paramc.sD();
    p.g(paramc, "kotlinFqName.asString()");
    paramc = n.br(paramc, paramString, "");
    int i;
    if (((CharSequence)paramc).length() > 0) {
      i = 1;
    }
    while ((i != 0) && (!n.aI((CharSequence)paramc)))
    {
      paramc = n.bdh(paramc);
      if ((paramc != null) && (paramc.intValue() >= 23))
      {
        AppMethodBeat.o(56756);
        return true;
        i = 0;
      }
      else
      {
        AppMethodBeat.o(56756);
        return false;
      }
    }
    AppMethodBeat.o(56756);
    return false;
  }
  
  private final d.l.b.a.b.f.a bu(Class<?> paramClass)
  {
    AppMethodBeat.i(56765);
    if ((!paramClass.isPrimitive()) && (!paramClass.isArray())) {}
    for (int i = 1; (ac.MKp) && (i == 0); i = 0)
    {
      paramClass = (Throwable)new AssertionError("Invalid class: ".concat(String.valueOf(paramClass)));
      AppMethodBeat.o(56765);
      throw paramClass;
    }
    Class localClass = paramClass.getDeclaringClass();
    if (localClass == null)
    {
      paramClass = d.l.b.a.b.f.a.p(new b(paramClass.getCanonicalName()));
      p.g(paramClass, "ClassId.topLevel(FqName(clazz.canonicalName))");
      AppMethodBeat.o(56765);
      return paramClass;
    }
    paramClass = bu(localClass).o(f.bcE(paramClass.getSimpleName()));
    p.g(paramClass, "classId(outer).createNes…tifier(clazz.simpleName))");
    AppMethodBeat.o(56765);
    return paramClass;
  }
  
  public static d.l.b.a.b.f.a c(b paramb)
  {
    AppMethodBeat.i(56753);
    p.h(paramb, "fqName");
    paramb = (d.l.b.a.b.f.a)MTh.get(paramb.grf());
    AppMethodBeat.o(56753);
    return paramb;
  }
  
  public static d.l.b.a.b.f.a c(d.l.b.a.b.f.c paramc)
  {
    AppMethodBeat.i(56755);
    p.h(paramc, "kotlinFqName");
    if (a(paramc, MTa))
    {
      paramc = MTe;
      AppMethodBeat.o(56755);
      return paramc;
    }
    if (a(paramc, MTc))
    {
      paramc = MTe;
      AppMethodBeat.o(56755);
      return paramc;
    }
    if (a(paramc, MTb))
    {
      paramc = MTg;
      AppMethodBeat.o(56755);
      return paramc;
    }
    if (a(paramc, MTd))
    {
      paramc = MTg;
      AppMethodBeat.o(56755);
      return paramc;
    }
    paramc = (d.l.b.a.b.f.a)MTi.get(paramc);
    AppMethodBeat.o(56755);
    return paramc;
  }
  
  public static b ghW()
  {
    return MTf;
  }
  
  public static List<c.a> ghX()
  {
    return MTl;
  }
  
  public static boolean h(e parame)
  {
    AppMethodBeat.i(56761);
    p.h(parame, "mutable");
    parame = d.l.b.a.b.j.c.n((l)parame);
    Map localMap = (Map)MTj;
    if (localMap == null)
    {
      parame = new v("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
      AppMethodBeat.o(56761);
      throw parame;
    }
    boolean bool = localMap.containsKey(parame);
    AppMethodBeat.o(56761);
    return bool;
  }
  
  public static boolean i(e parame)
  {
    AppMethodBeat.i(56762);
    p.h(parame, "readOnly");
    parame = d.l.b.a.b.j.c.n((l)parame);
    Map localMap = (Map)MTk;
    if (localMap == null)
    {
      parame = new v("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
      AppMethodBeat.o(56762);
      throw parame;
    }
    boolean bool = localMap.containsKey(parame);
    AppMethodBeat.o(56762);
    return bool;
  }
  
  public static e j(e parame)
  {
    AppMethodBeat.i(56763);
    p.h(parame, "mutable");
    parame = a(parame, (Map)MTj, "mutable");
    AppMethodBeat.o(56763);
    return parame;
  }
  
  public static e k(e parame)
  {
    AppMethodBeat.i(56764);
    p.h(parame, "readOnly");
    parame = a(parame, (Map)MTk, "read-only");
    AppMethodBeat.o(56764);
    return parame;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.a.b.c
 * JD-Core Version:    0.7.0.1
 */