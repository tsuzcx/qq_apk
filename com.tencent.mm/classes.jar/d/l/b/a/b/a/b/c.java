package d.l.b.a.b.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.aa;
import d.g.b.k;
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
  private static final String JoM;
  private static final String JoN;
  private static final String JoO;
  private static final String JoP;
  private static final d.l.b.a.b.f.a JoQ;
  private static final b JoR;
  private static final d.l.b.a.b.f.a JoS;
  private static final HashMap<d.l.b.a.b.f.c, d.l.b.a.b.f.a> JoT;
  private static final HashMap<d.l.b.a.b.f.c, d.l.b.a.b.f.a> JoU;
  private static final HashMap<d.l.b.a.b.f.c, b> JoV;
  static final HashMap<d.l.b.a.b.f.c, b> JoW;
  private static final List<c.a> JoX;
  public static final c JoY;
  
  static
  {
    AppMethodBeat.i(56767);
    c localc = new c();
    JoY = localc;
    JoM = b.c.Joz.JoE.toString() + "." + b.c.Joz.JoF;
    JoN = b.c.JoB.JoE.toString() + "." + b.c.JoB.JoF;
    JoO = b.c.JoA.JoE.toString() + "." + b.c.JoA.JoF;
    JoP = b.c.JoC.JoE.toString() + "." + b.c.JoC.JoF;
    Object localObject1 = d.l.b.a.b.f.a.p(new b("kotlin.jvm.functions.FunctionN"));
    k.g(localObject1, "ClassId.topLevel(FqName(…vm.functions.FunctionN\"))");
    JoQ = (d.l.b.a.b.f.a)localObject1;
    localObject1 = ((d.l.b.a.b.f.a)localObject1).fHb();
    k.g(localObject1, "FUNCTION_N_CLASS_ID.asSingleFqName()");
    JoR = (b)localObject1;
    localObject1 = d.l.b.a.b.f.a.p(new b("kotlin.reflect.KFunction"));
    k.g(localObject1, "ClassId.topLevel(FqName(…tlin.reflect.KFunction\"))");
    JoS = (d.l.b.a.b.f.a)localObject1;
    JoT = new HashMap();
    JoU = new HashMap();
    JoV = new HashMap();
    JoW = new HashMap();
    localObject1 = d.l.b.a.b.f.a.p(g.JlM.JmC);
    k.g(localObject1, "ClassId.topLevel(FQ_NAMES.iterable)");
    Object localObject2 = g.JlM.JmK;
    k.g(localObject2, "FQ_NAMES.mutableIterable");
    Object localObject3 = ((d.l.b.a.b.f.a)localObject1).fGW();
    Object localObject4 = ((d.l.b.a.b.f.a)localObject1).fGW();
    k.g(localObject4, "kotlinReadOnly.packageFqName");
    localObject2 = new d.l.b.a.b.f.a((b)localObject3, d.l.b.a.b.f.d.b((b)localObject2, (b)localObject4), false);
    localObject1 = new c.a(localc.bp(Iterable.class), (d.l.b.a.b.f.a)localObject1, (d.l.b.a.b.f.a)localObject2);
    localObject2 = d.l.b.a.b.f.a.p(g.JlM.JmB);
    k.g(localObject2, "ClassId.topLevel(FQ_NAMES.iterator)");
    localObject3 = g.JlM.JmJ;
    k.g(localObject3, "FQ_NAMES.mutableIterator");
    localObject4 = ((d.l.b.a.b.f.a)localObject2).fGW();
    Object localObject5 = ((d.l.b.a.b.f.a)localObject2).fGW();
    k.g(localObject5, "kotlinReadOnly.packageFqName");
    localObject3 = new d.l.b.a.b.f.a((b)localObject4, d.l.b.a.b.f.d.b((b)localObject3, (b)localObject5), false);
    localObject2 = new c.a(localc.bp(Iterator.class), (d.l.b.a.b.f.a)localObject2, (d.l.b.a.b.f.a)localObject3);
    localObject3 = d.l.b.a.b.f.a.p(g.JlM.JmD);
    k.g(localObject3, "ClassId.topLevel(FQ_NAMES.collection)");
    localObject4 = g.JlM.JmL;
    k.g(localObject4, "FQ_NAMES.mutableCollection");
    localObject5 = ((d.l.b.a.b.f.a)localObject3).fGW();
    Object localObject6 = ((d.l.b.a.b.f.a)localObject3).fGW();
    k.g(localObject6, "kotlinReadOnly.packageFqName");
    localObject4 = new d.l.b.a.b.f.a((b)localObject5, d.l.b.a.b.f.d.b((b)localObject4, (b)localObject6), false);
    localObject3 = new c.a(localc.bp(Collection.class), (d.l.b.a.b.f.a)localObject3, (d.l.b.a.b.f.a)localObject4);
    localObject4 = d.l.b.a.b.f.a.p(g.JlM.JmE);
    k.g(localObject4, "ClassId.topLevel(FQ_NAMES.list)");
    localObject5 = g.JlM.JmM;
    k.g(localObject5, "FQ_NAMES.mutableList");
    localObject6 = ((d.l.b.a.b.f.a)localObject4).fGW();
    Object localObject7 = ((d.l.b.a.b.f.a)localObject4).fGW();
    k.g(localObject7, "kotlinReadOnly.packageFqName");
    localObject5 = new d.l.b.a.b.f.a((b)localObject6, d.l.b.a.b.f.d.b((b)localObject5, (b)localObject7), false);
    localObject4 = new c.a(localc.bp(List.class), (d.l.b.a.b.f.a)localObject4, (d.l.b.a.b.f.a)localObject5);
    localObject5 = d.l.b.a.b.f.a.p(g.JlM.JmG);
    k.g(localObject5, "ClassId.topLevel(FQ_NAMES.set)");
    localObject6 = g.JlM.JmO;
    k.g(localObject6, "FQ_NAMES.mutableSet");
    localObject7 = ((d.l.b.a.b.f.a)localObject5).fGW();
    Object localObject8 = ((d.l.b.a.b.f.a)localObject5).fGW();
    k.g(localObject8, "kotlinReadOnly.packageFqName");
    localObject6 = new d.l.b.a.b.f.a((b)localObject7, d.l.b.a.b.f.d.b((b)localObject6, (b)localObject8), false);
    localObject5 = new c.a(localc.bp(Set.class), (d.l.b.a.b.f.a)localObject5, (d.l.b.a.b.f.a)localObject6);
    localObject6 = d.l.b.a.b.f.a.p(g.JlM.JmF);
    k.g(localObject6, "ClassId.topLevel(FQ_NAMES.listIterator)");
    localObject7 = g.JlM.JmN;
    k.g(localObject7, "FQ_NAMES.mutableListIterator");
    localObject8 = ((d.l.b.a.b.f.a)localObject6).fGW();
    Object localObject9 = ((d.l.b.a.b.f.a)localObject6).fGW();
    k.g(localObject9, "kotlinReadOnly.packageFqName");
    localObject7 = new d.l.b.a.b.f.a((b)localObject8, d.l.b.a.b.f.d.b((b)localObject7, (b)localObject9), false);
    localObject6 = new c.a(localc.bp(ListIterator.class), (d.l.b.a.b.f.a)localObject6, (d.l.b.a.b.f.a)localObject7);
    localObject7 = d.l.b.a.b.f.a.p(g.JlM.JmH);
    k.g(localObject7, "ClassId.topLevel(FQ_NAMES.map)");
    localObject8 = g.JlM.JmP;
    k.g(localObject8, "FQ_NAMES.mutableMap");
    localObject9 = ((d.l.b.a.b.f.a)localObject7).fGW();
    b localb1 = ((d.l.b.a.b.f.a)localObject7).fGW();
    k.g(localb1, "kotlinReadOnly.packageFqName");
    localObject8 = new d.l.b.a.b.f.a((b)localObject9, d.l.b.a.b.f.d.b((b)localObject8, localb1), false);
    localObject7 = new c.a(localc.bp(Map.class), (d.l.b.a.b.f.a)localObject7, (d.l.b.a.b.f.a)localObject8);
    localObject8 = d.l.b.a.b.f.a.p(g.JlM.JmH).o(g.JlM.JmI.fHe());
    k.g(localObject8, "ClassId.topLevel(FQ_NAME…MES.mapEntry.shortName())");
    localObject9 = g.JlM.JmQ;
    k.g(localObject9, "FQ_NAMES.mutableMapEntry");
    localb1 = ((d.l.b.a.b.f.a)localObject8).fGW();
    b localb2 = ((d.l.b.a.b.f.a)localObject8).fGW();
    k.g(localb2, "kotlinReadOnly.packageFqName");
    localObject9 = new d.l.b.a.b.f.a(localb1, d.l.b.a.b.f.d.b((b)localObject9, localb2), false);
    JoX = j.listOf(new c.a[] { localObject1, localObject2, localObject3, localObject4, localObject5, localObject6, localObject7, new c.a(localc.bp(Map.Entry.class), (d.l.b.a.b.f.a)localObject8, (d.l.b.a.b.f.a)localObject9) });
    localObject1 = g.JlM.JlQ;
    k.g(localObject1, "FQ_NAMES.any");
    localc.a(Object.class, (d.l.b.a.b.f.c)localObject1);
    localObject1 = g.JlM.JlW;
    k.g(localObject1, "FQ_NAMES.string");
    localc.a(String.class, (d.l.b.a.b.f.c)localObject1);
    localObject1 = g.JlM.JlV;
    k.g(localObject1, "FQ_NAMES.charSequence");
    localc.a(CharSequence.class, (d.l.b.a.b.f.c)localObject1);
    localObject1 = g.JlM.Jmj;
    k.g(localObject1, "FQ_NAMES.throwable");
    localc.a(Throwable.class, (b)localObject1);
    localObject1 = g.JlM.JlS;
    k.g(localObject1, "FQ_NAMES.cloneable");
    localc.a(Cloneable.class, (d.l.b.a.b.f.c)localObject1);
    localObject1 = g.JlM.Jmg;
    k.g(localObject1, "FQ_NAMES.number");
    localc.a(Number.class, (d.l.b.a.b.f.c)localObject1);
    localObject1 = g.JlM.Jmk;
    k.g(localObject1, "FQ_NAMES.comparable");
    localc.a(Comparable.class, (b)localObject1);
    localObject1 = g.JlM.Jmh;
    k.g(localObject1, "FQ_NAMES._enum");
    localc.a(Enum.class, (d.l.b.a.b.f.c)localObject1);
    localObject1 = g.JlM.Jms;
    k.g(localObject1, "FQ_NAMES.annotation");
    localc.a(Annotation.class, (b)localObject1);
    localObject1 = JoX.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (c.a)((Iterator)localObject1).next();
      localObject3 = ((c.a)localObject2).JoZ;
      localObject4 = ((c.a)localObject2).Jpa;
      localObject2 = ((c.a)localObject2).Jpb;
      a((d.l.b.a.b.f.a)localObject3, (d.l.b.a.b.f.a)localObject4);
      localObject5 = ((d.l.b.a.b.f.a)localObject2).fHb();
      k.g(localObject5, "mutableClassId.asSingleFqName()");
      a((b)localObject5, (d.l.b.a.b.f.a)localObject3);
      localObject4 = ((d.l.b.a.b.f.a)localObject4).fHb();
      k.g(localObject4, "readOnlyClassId.asSingleFqName()");
      localObject3 = ((d.l.b.a.b.f.a)localObject2).fHb();
      k.g(localObject3, "mutableClassId.asSingleFqName()");
      localObject5 = (Map)JoV;
      localObject2 = ((d.l.b.a.b.f.a)localObject2).fHb().fHc();
      k.g(localObject2, "mutableClassId.asSingleFqName().toUnsafe()");
      ((Map)localObject5).put(localObject2, localObject4);
      localObject2 = (Map)JoW;
      localObject4 = ((b)localObject4).fHc();
      k.g(localObject4, "readOnlyFqName.toUnsafe()");
      ((Map)localObject2).put(localObject4, localObject3);
    }
    localObject1 = d.l.b.a.b.j.e.d.values();
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      localObject3 = localObject1[i];
      localObject2 = d.l.b.a.b.f.a.p(((d.l.b.a.b.j.e.d)localObject3).fJe());
      k.g(localObject2, "ClassId.topLevel(jvmType.wrapperFqName)");
      localObject3 = d.l.b.a.b.f.a.p(g.c(((d.l.b.a.b.j.e.d)localObject3).fJc()));
      k.g(localObject3, "ClassId.topLevel(KotlinB…e(jvmType.primitiveType))");
      a((d.l.b.a.b.f.a)localObject2, (d.l.b.a.b.f.a)localObject3);
      i += 1;
    }
    localObject1 = d.l.b.a.b.a.c.Jlx;
    localObject1 = d.l.b.a.b.a.c.fwT().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (d.l.b.a.b.f.a)((Iterator)localObject1).next();
      localObject2 = d.l.b.a.b.f.a.p(new b("kotlin.jvm.internal." + ((d.l.b.a.b.f.a)localObject3).fGY().qV() + "CompanionObject"));
      k.g(localObject2, "ClassId.topLevel(FqName(…g() + \"CompanionObject\"))");
      localObject3 = ((d.l.b.a.b.f.a)localObject3).o(h.JMe);
      k.g(localObject3, "classId.createNestedClas…AME_FOR_COMPANION_OBJECT)");
      a((d.l.b.a.b.f.a)localObject2, (d.l.b.a.b.f.a)localObject3);
    }
    i = 0;
    while (i < 23)
    {
      localObject1 = d.l.b.a.b.f.a.p(new b("kotlin.jvm.functions.Function".concat(String.valueOf(i))));
      k.g(localObject1, "ClassId.topLevel(FqName(…m.functions.Function$i\"))");
      localObject2 = g.adR(i);
      k.g(localObject2, "KotlinBuiltIns.getFunctionClassId(i)");
      a((d.l.b.a.b.f.a)localObject1, (d.l.b.a.b.f.a)localObject2);
      a(new b(JoN + i), JoS);
      i += 1;
    }
    i = 0;
    while (i < 22)
    {
      localObject1 = b.c.JoC;
      localObject1 = ((b.c)localObject1).JoE.toString() + "." + ((b.c)localObject1).JoF;
      a(new b((String)localObject1 + i), JoS);
      i += 1;
    }
    localObject1 = g.JlM.JlR.fHh();
    k.g(localObject1, "FQ_NAMES.nothing.toSafe()");
    a((b)localObject1, localc.bp(Void.class));
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
    k.g(parame, "descriptor.builtIns.getB…Name(oppositeClassFqName)");
    AppMethodBeat.o(56766);
    return parame;
  }
  
  private static void a(d.l.b.a.b.f.a parama1, d.l.b.a.b.f.a parama2)
  {
    AppMethodBeat.i(56757);
    Map localMap = (Map)JoT;
    d.l.b.a.b.f.c localc = parama1.fHb().fHc();
    k.g(localc, "javaClassId.asSingleFqName().toUnsafe()");
    localMap.put(localc, parama2);
    parama2 = parama2.fHb();
    k.g(parama2, "kotlinClassId.asSingleFqName()");
    a(parama2, parama1);
    AppMethodBeat.o(56757);
  }
  
  private static void a(b paramb, d.l.b.a.b.f.a parama)
  {
    AppMethodBeat.i(56760);
    Map localMap = (Map)JoU;
    paramb = paramb.fHc();
    k.g(paramb, "kotlinFqNameUnsafe.toUnsafe()");
    localMap.put(paramb, parama);
    AppMethodBeat.o(56760);
  }
  
  private final void a(Class<?> paramClass, b paramb)
  {
    AppMethodBeat.i(56759);
    paramClass = bp(paramClass);
    paramb = d.l.b.a.b.f.a.p(paramb);
    k.g(paramb, "ClassId.topLevel(kotlinFqName)");
    a(paramClass, paramb);
    AppMethodBeat.o(56759);
  }
  
  private final void a(Class<?> paramClass, d.l.b.a.b.f.c paramc)
  {
    AppMethodBeat.i(56758);
    paramc = paramc.fHh();
    k.g(paramc, "kotlinFqName.toSafe()");
    a(paramClass, paramc);
    AppMethodBeat.o(56758);
  }
  
  private static boolean a(d.l.b.a.b.f.c paramc, String paramString)
  {
    AppMethodBeat.i(56756);
    paramc = paramc.qV();
    k.g(paramc, "kotlinFqName.asString()");
    paramc = n.bd(paramc, paramString, "");
    int i;
    if (((CharSequence)paramc).length() > 0) {
      i = 1;
    }
    while ((i != 0) && (!n.aG((CharSequence)paramc)))
    {
      paramc = n.aRf(paramc);
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
  
  private final d.l.b.a.b.f.a bp(Class<?> paramClass)
  {
    AppMethodBeat.i(56765);
    if ((!paramClass.isPrimitive()) && (!paramClass.isArray())) {}
    for (int i = 1; (aa.JfW) && (i == 0); i = 0)
    {
      paramClass = (Throwable)new AssertionError("Invalid class: ".concat(String.valueOf(paramClass)));
      AppMethodBeat.o(56765);
      throw paramClass;
    }
    Class localClass = paramClass.getDeclaringClass();
    if (localClass == null)
    {
      paramClass = d.l.b.a.b.f.a.p(new b(paramClass.getCanonicalName()));
      k.g(paramClass, "ClassId.topLevel(FqName(clazz.canonicalName))");
      AppMethodBeat.o(56765);
      return paramClass;
    }
    paramClass = bp(localClass).o(f.aQC(paramClass.getSimpleName()));
    k.g(paramClass, "classId(outer).createNes…tifier(clazz.simpleName))");
    AppMethodBeat.o(56765);
    return paramClass;
  }
  
  public static d.l.b.a.b.f.a c(b paramb)
  {
    AppMethodBeat.i(56753);
    k.h(paramb, "fqName");
    paramb = (d.l.b.a.b.f.a)JoT.get(paramb.fHc());
    AppMethodBeat.o(56753);
    return paramb;
  }
  
  public static d.l.b.a.b.f.a c(d.l.b.a.b.f.c paramc)
  {
    AppMethodBeat.i(56755);
    k.h(paramc, "kotlinFqName");
    if (a(paramc, JoM))
    {
      paramc = JoQ;
      AppMethodBeat.o(56755);
      return paramc;
    }
    if (a(paramc, JoO))
    {
      paramc = JoQ;
      AppMethodBeat.o(56755);
      return paramc;
    }
    if (a(paramc, JoN))
    {
      paramc = JoS;
      AppMethodBeat.o(56755);
      return paramc;
    }
    if (a(paramc, JoP))
    {
      paramc = JoS;
      AppMethodBeat.o(56755);
      return paramc;
    }
    paramc = (d.l.b.a.b.f.a)JoU.get(paramc);
    AppMethodBeat.o(56755);
    return paramc;
  }
  
  public static b fxU()
  {
    return JoR;
  }
  
  public static List<c.a> fxV()
  {
    return JoX;
  }
  
  public static boolean h(e parame)
  {
    AppMethodBeat.i(56761);
    k.h(parame, "mutable");
    parame = d.l.b.a.b.j.c.n((l)parame);
    Map localMap = (Map)JoV;
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
    k.h(parame, "readOnly");
    parame = d.l.b.a.b.j.c.n((l)parame);
    Map localMap = (Map)JoW;
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
    k.h(parame, "mutable");
    parame = a(parame, (Map)JoV, "mutable");
    AppMethodBeat.o(56763);
    return parame;
  }
  
  public static e k(e parame)
  {
    AppMethodBeat.i(56764);
    k.h(parame, "readOnly");
    parame = a(parame, (Map)JoW, "read-only");
    AppMethodBeat.o(56764);
    return parame;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.a.b.c
 * JD-Core Version:    0.7.0.1
 */