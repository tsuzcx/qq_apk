package kotlin.l.b.a.b.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l.b.a.b.a.a.b.c;
import kotlin.l.b.a.b.a.g;
import kotlin.l.b.a.b.a.g.a;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.f.b;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.f.h;
import kotlin.n.n;
import kotlin.t;
import kotlin.z;

public final class c
{
  private static final String aaIH;
  private static final String aaII;
  private static final String aaIJ;
  private static final String aaIK;
  private static final kotlin.l.b.a.b.f.a aaIL;
  private static final b aaIM;
  private static final kotlin.l.b.a.b.f.a aaIN;
  private static final HashMap<kotlin.l.b.a.b.f.c, kotlin.l.b.a.b.f.a> aaIO;
  private static final HashMap<kotlin.l.b.a.b.f.c, kotlin.l.b.a.b.f.a> aaIP;
  private static final HashMap<kotlin.l.b.a.b.f.c, b> aaIQ;
  static final HashMap<kotlin.l.b.a.b.f.c, b> aaIR;
  private static final List<c.a> aaIS;
  public static final c aaIT;
  
  static
  {
    AppMethodBeat.i(56767);
    c localc = new c();
    aaIT = localc;
    aaIH = b.c.aaIu.aaIz.toString() + "." + b.c.aaIu.aaIA;
    aaII = b.c.aaIw.aaIz.toString() + "." + b.c.aaIw.aaIA;
    aaIJ = b.c.aaIv.aaIz.toString() + "." + b.c.aaIv.aaIA;
    aaIK = b.c.aaIx.aaIz.toString() + "." + b.c.aaIx.aaIA;
    Object localObject1 = kotlin.l.b.a.b.f.a.p(new b("kotlin.jvm.functions.FunctionN"));
    p.j(localObject1, "ClassId.topLevel(FqName(…vm.functions.FunctionN\"))");
    aaIL = (kotlin.l.b.a.b.f.a)localObject1;
    localObject1 = ((kotlin.l.b.a.b.f.a)localObject1).iNx();
    p.j(localObject1, "FUNCTION_N_CLASS_ID.asSingleFqName()");
    aaIM = (b)localObject1;
    localObject1 = kotlin.l.b.a.b.f.a.p(new b("kotlin.reflect.KFunction"));
    p.j(localObject1, "ClassId.topLevel(FqName(…tlin.reflect.KFunction\"))");
    aaIN = (kotlin.l.b.a.b.f.a)localObject1;
    aaIO = new HashMap();
    aaIP = new HashMap();
    aaIQ = new HashMap();
    aaIR = new HashMap();
    localObject1 = kotlin.l.b.a.b.f.a.p(g.aaFI.aaGy);
    p.j(localObject1, "ClassId.topLevel(FQ_NAMES.iterable)");
    Object localObject2 = g.aaFI.aaGG;
    p.j(localObject2, "FQ_NAMES.mutableIterable");
    Object localObject3 = ((kotlin.l.b.a.b.f.a)localObject1).iNs();
    Object localObject4 = ((kotlin.l.b.a.b.f.a)localObject1).iNs();
    p.j(localObject4, "kotlinReadOnly.packageFqName");
    localObject2 = new kotlin.l.b.a.b.f.a((b)localObject3, kotlin.l.b.a.b.f.d.b((b)localObject2, (b)localObject4), false);
    localObject1 = new c.a(localc.bT(Iterable.class), (kotlin.l.b.a.b.f.a)localObject1, (kotlin.l.b.a.b.f.a)localObject2);
    localObject2 = kotlin.l.b.a.b.f.a.p(g.aaFI.aaGx);
    p.j(localObject2, "ClassId.topLevel(FQ_NAMES.iterator)");
    localObject3 = g.aaFI.aaGF;
    p.j(localObject3, "FQ_NAMES.mutableIterator");
    localObject4 = ((kotlin.l.b.a.b.f.a)localObject2).iNs();
    Object localObject5 = ((kotlin.l.b.a.b.f.a)localObject2).iNs();
    p.j(localObject5, "kotlinReadOnly.packageFqName");
    localObject3 = new kotlin.l.b.a.b.f.a((b)localObject4, kotlin.l.b.a.b.f.d.b((b)localObject3, (b)localObject5), false);
    localObject2 = new c.a(localc.bT(Iterator.class), (kotlin.l.b.a.b.f.a)localObject2, (kotlin.l.b.a.b.f.a)localObject3);
    localObject3 = kotlin.l.b.a.b.f.a.p(g.aaFI.aaGz);
    p.j(localObject3, "ClassId.topLevel(FQ_NAMES.collection)");
    localObject4 = g.aaFI.aaGH;
    p.j(localObject4, "FQ_NAMES.mutableCollection");
    localObject5 = ((kotlin.l.b.a.b.f.a)localObject3).iNs();
    Object localObject6 = ((kotlin.l.b.a.b.f.a)localObject3).iNs();
    p.j(localObject6, "kotlinReadOnly.packageFqName");
    localObject4 = new kotlin.l.b.a.b.f.a((b)localObject5, kotlin.l.b.a.b.f.d.b((b)localObject4, (b)localObject6), false);
    localObject3 = new c.a(localc.bT(Collection.class), (kotlin.l.b.a.b.f.a)localObject3, (kotlin.l.b.a.b.f.a)localObject4);
    localObject4 = kotlin.l.b.a.b.f.a.p(g.aaFI.aaGA);
    p.j(localObject4, "ClassId.topLevel(FQ_NAMES.list)");
    localObject5 = g.aaFI.aaGI;
    p.j(localObject5, "FQ_NAMES.mutableList");
    localObject6 = ((kotlin.l.b.a.b.f.a)localObject4).iNs();
    Object localObject7 = ((kotlin.l.b.a.b.f.a)localObject4).iNs();
    p.j(localObject7, "kotlinReadOnly.packageFqName");
    localObject5 = new kotlin.l.b.a.b.f.a((b)localObject6, kotlin.l.b.a.b.f.d.b((b)localObject5, (b)localObject7), false);
    localObject4 = new c.a(localc.bT(List.class), (kotlin.l.b.a.b.f.a)localObject4, (kotlin.l.b.a.b.f.a)localObject5);
    localObject5 = kotlin.l.b.a.b.f.a.p(g.aaFI.aaGC);
    p.j(localObject5, "ClassId.topLevel(FQ_NAMES.set)");
    localObject6 = g.aaFI.aaGK;
    p.j(localObject6, "FQ_NAMES.mutableSet");
    localObject7 = ((kotlin.l.b.a.b.f.a)localObject5).iNs();
    Object localObject8 = ((kotlin.l.b.a.b.f.a)localObject5).iNs();
    p.j(localObject8, "kotlinReadOnly.packageFqName");
    localObject6 = new kotlin.l.b.a.b.f.a((b)localObject7, kotlin.l.b.a.b.f.d.b((b)localObject6, (b)localObject8), false);
    localObject5 = new c.a(localc.bT(Set.class), (kotlin.l.b.a.b.f.a)localObject5, (kotlin.l.b.a.b.f.a)localObject6);
    localObject6 = kotlin.l.b.a.b.f.a.p(g.aaFI.aaGB);
    p.j(localObject6, "ClassId.topLevel(FQ_NAMES.listIterator)");
    localObject7 = g.aaFI.aaGJ;
    p.j(localObject7, "FQ_NAMES.mutableListIterator");
    localObject8 = ((kotlin.l.b.a.b.f.a)localObject6).iNs();
    Object localObject9 = ((kotlin.l.b.a.b.f.a)localObject6).iNs();
    p.j(localObject9, "kotlinReadOnly.packageFqName");
    localObject7 = new kotlin.l.b.a.b.f.a((b)localObject8, kotlin.l.b.a.b.f.d.b((b)localObject7, (b)localObject9), false);
    localObject6 = new c.a(localc.bT(ListIterator.class), (kotlin.l.b.a.b.f.a)localObject6, (kotlin.l.b.a.b.f.a)localObject7);
    localObject7 = kotlin.l.b.a.b.f.a.p(g.aaFI.aaGD);
    p.j(localObject7, "ClassId.topLevel(FQ_NAMES.map)");
    localObject8 = g.aaFI.aaGL;
    p.j(localObject8, "FQ_NAMES.mutableMap");
    localObject9 = ((kotlin.l.b.a.b.f.a)localObject7).iNs();
    b localb1 = ((kotlin.l.b.a.b.f.a)localObject7).iNs();
    p.j(localb1, "kotlinReadOnly.packageFqName");
    localObject8 = new kotlin.l.b.a.b.f.a((b)localObject9, kotlin.l.b.a.b.f.d.b((b)localObject8, localb1), false);
    localObject7 = new c.a(localc.bT(Map.class), (kotlin.l.b.a.b.f.a)localObject7, (kotlin.l.b.a.b.f.a)localObject8);
    localObject8 = kotlin.l.b.a.b.f.a.p(g.aaFI.aaGD).o(g.aaFI.aaGE.iNA());
    p.j(localObject8, "ClassId.topLevel(FQ_NAME…MES.mapEntry.shortName())");
    localObject9 = g.aaFI.aaGM;
    p.j(localObject9, "FQ_NAMES.mutableMapEntry");
    localb1 = ((kotlin.l.b.a.b.f.a)localObject8).iNs();
    b localb2 = ((kotlin.l.b.a.b.f.a)localObject8).iNs();
    p.j(localb2, "kotlinReadOnly.packageFqName");
    localObject9 = new kotlin.l.b.a.b.f.a(localb1, kotlin.l.b.a.b.f.d.b((b)localObject9, localb2), false);
    aaIS = j.listOf(new c.a[] { localObject1, localObject2, localObject3, localObject4, localObject5, localObject6, localObject7, new c.a(localc.bT(Map.Entry.class), (kotlin.l.b.a.b.f.a)localObject8, (kotlin.l.b.a.b.f.a)localObject9) });
    localObject1 = g.aaFI.aaFM;
    p.j(localObject1, "FQ_NAMES.any");
    localc.a(Object.class, (kotlin.l.b.a.b.f.c)localObject1);
    localObject1 = g.aaFI.aaFS;
    p.j(localObject1, "FQ_NAMES.string");
    localc.a(String.class, (kotlin.l.b.a.b.f.c)localObject1);
    localObject1 = g.aaFI.aaFR;
    p.j(localObject1, "FQ_NAMES.charSequence");
    localc.a(CharSequence.class, (kotlin.l.b.a.b.f.c)localObject1);
    localObject1 = g.aaFI.aaGf;
    p.j(localObject1, "FQ_NAMES.throwable");
    localc.a(Throwable.class, (b)localObject1);
    localObject1 = g.aaFI.aaFO;
    p.j(localObject1, "FQ_NAMES.cloneable");
    localc.a(Cloneable.class, (kotlin.l.b.a.b.f.c)localObject1);
    localObject1 = g.aaFI.aaGc;
    p.j(localObject1, "FQ_NAMES.number");
    localc.a(Number.class, (kotlin.l.b.a.b.f.c)localObject1);
    localObject1 = g.aaFI.aaGg;
    p.j(localObject1, "FQ_NAMES.comparable");
    localc.a(Comparable.class, (b)localObject1);
    localObject1 = g.aaFI.aaGd;
    p.j(localObject1, "FQ_NAMES._enum");
    localc.a(Enum.class, (kotlin.l.b.a.b.f.c)localObject1);
    localObject1 = g.aaFI.aaGo;
    p.j(localObject1, "FQ_NAMES.annotation");
    localc.a(Annotation.class, (b)localObject1);
    localObject1 = aaIS.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (c.a)((Iterator)localObject1).next();
      localObject3 = ((c.a)localObject2).aaIU;
      localObject4 = ((c.a)localObject2).aaIV;
      localObject2 = ((c.a)localObject2).aaIW;
      a((kotlin.l.b.a.b.f.a)localObject3, (kotlin.l.b.a.b.f.a)localObject4);
      localObject5 = ((kotlin.l.b.a.b.f.a)localObject2).iNx();
      p.j(localObject5, "mutableClassId.asSingleFqName()");
      a((b)localObject5, (kotlin.l.b.a.b.f.a)localObject3);
      localObject4 = ((kotlin.l.b.a.b.f.a)localObject4).iNx();
      p.j(localObject4, "readOnlyClassId.asSingleFqName()");
      localObject3 = ((kotlin.l.b.a.b.f.a)localObject2).iNx();
      p.j(localObject3, "mutableClassId.asSingleFqName()");
      localObject5 = (Map)aaIQ;
      localObject2 = ((kotlin.l.b.a.b.f.a)localObject2).iNx().iNy();
      p.j(localObject2, "mutableClassId.asSingleFqName().toUnsafe()");
      ((Map)localObject5).put(localObject2, localObject4);
      localObject2 = (Map)aaIR;
      localObject4 = ((b)localObject4).iNy();
      p.j(localObject4, "readOnlyFqName.toUnsafe()");
      ((Map)localObject2).put(localObject4, localObject3);
    }
    localObject1 = kotlin.l.b.a.b.j.e.d.values();
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      localObject3 = localObject1[i];
      localObject2 = kotlin.l.b.a.b.f.a.p(((kotlin.l.b.a.b.j.e.d)localObject3).iPb());
      p.j(localObject2, "ClassId.topLevel(jvmType.wrapperFqName)");
      localObject3 = kotlin.l.b.a.b.f.a.p(g.c(((kotlin.l.b.a.b.j.e.d)localObject3).iOZ()));
      p.j(localObject3, "ClassId.topLevel(KotlinB…e(jvmType.primitiveType))");
      a((kotlin.l.b.a.b.f.a)localObject2, (kotlin.l.b.a.b.f.a)localObject3);
      i += 1;
    }
    localObject1 = kotlin.l.b.a.b.a.c.aaFt;
    localObject1 = kotlin.l.b.a.b.a.c.iDm().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (kotlin.l.b.a.b.f.a)((Iterator)localObject1).next();
      localObject2 = kotlin.l.b.a.b.f.a.p(new b("kotlin.jvm.internal." + ((kotlin.l.b.a.b.f.a)localObject3).iNu().qu() + "CompanionObject"));
      p.j(localObject2, "ClassId.topLevel(FqName(…g() + \"CompanionObject\"))");
      localObject3 = ((kotlin.l.b.a.b.f.a)localObject3).o(h.abfS);
      p.j(localObject3, "classId.createNestedClas…AME_FOR_COMPANION_OBJECT)");
      a((kotlin.l.b.a.b.f.a)localObject2, (kotlin.l.b.a.b.f.a)localObject3);
    }
    i = 0;
    while (i < 23)
    {
      localObject1 = kotlin.l.b.a.b.f.a.p(new b("kotlin.jvm.functions.Function".concat(String.valueOf(i))));
      p.j(localObject1, "ClassId.topLevel(FqName(…m.functions.Function$i\"))");
      localObject2 = g.aDI(i);
      p.j(localObject2, "KotlinBuiltIns.getFunctionClassId(i)");
      a((kotlin.l.b.a.b.f.a)localObject1, (kotlin.l.b.a.b.f.a)localObject2);
      a(new b(aaII + i), aaIN);
      i += 1;
    }
    i = 0;
    while (i < 22)
    {
      localObject1 = b.c.aaIx;
      localObject1 = ((b.c)localObject1).aaIz.toString() + "." + ((b.c)localObject1).aaIA;
      a(new b((String)localObject1 + i), aaIN);
      i += 1;
    }
    localObject1 = g.aaFI.aaFN.iND();
    p.j(localObject1, "FQ_NAMES.nothing.toSafe()");
    a((b)localObject1, localc.bT(Void.class));
    AppMethodBeat.o(56767);
  }
  
  private static e a(e parame, Map<kotlin.l.b.a.b.f.c, b> paramMap, String paramString)
  {
    AppMethodBeat.i(56766);
    paramMap = (b)paramMap.get(kotlin.l.b.a.b.j.c.n((l)parame));
    if (paramMap == null)
    {
      parame = (Throwable)new IllegalArgumentException("Given class " + parame + " is not a " + paramString + " collection");
      AppMethodBeat.o(56766);
      throw parame;
    }
    parame = kotlin.l.b.a.b.j.d.a.G((l)parame).a(paramMap);
    p.j(parame, "descriptor.builtIns.getB…Name(oppositeClassFqName)");
    AppMethodBeat.o(56766);
    return parame;
  }
  
  private final void a(Class<?> paramClass, b paramb)
  {
    AppMethodBeat.i(56759);
    paramClass = bT(paramClass);
    paramb = kotlin.l.b.a.b.f.a.p(paramb);
    p.j(paramb, "ClassId.topLevel(kotlinFqName)");
    a(paramClass, paramb);
    AppMethodBeat.o(56759);
  }
  
  private final void a(Class<?> paramClass, kotlin.l.b.a.b.f.c paramc)
  {
    AppMethodBeat.i(56758);
    paramc = paramc.iND();
    p.j(paramc, "kotlinFqName.toSafe()");
    a(paramClass, paramc);
    AppMethodBeat.o(56758);
  }
  
  private static void a(kotlin.l.b.a.b.f.a parama1, kotlin.l.b.a.b.f.a parama2)
  {
    AppMethodBeat.i(56757);
    Map localMap = (Map)aaIO;
    kotlin.l.b.a.b.f.c localc = parama1.iNx().iNy();
    p.j(localc, "javaClassId.asSingleFqName().toUnsafe()");
    localMap.put(localc, parama2);
    parama2 = parama2.iNx();
    p.j(parama2, "kotlinClassId.asSingleFqName()");
    a(parama2, parama1);
    AppMethodBeat.o(56757);
  }
  
  private static void a(b paramb, kotlin.l.b.a.b.f.a parama)
  {
    AppMethodBeat.i(56760);
    Map localMap = (Map)aaIP;
    paramb = paramb.iNy();
    p.j(paramb, "kotlinFqNameUnsafe.toUnsafe()");
    localMap.put(paramb, parama);
    AppMethodBeat.o(56760);
  }
  
  private static boolean a(kotlin.l.b.a.b.f.c paramc, String paramString)
  {
    AppMethodBeat.i(56756);
    paramc = paramc.qu();
    p.j(paramc, "kotlinFqName.asString()");
    paramc = n.bz(paramc, paramString, "");
    int i;
    if (((CharSequence)paramc).length() > 0) {
      i = 1;
    }
    while ((i != 0) && (!n.bf((CharSequence)paramc)))
    {
      paramc = n.bHC(paramc);
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
  
  private final kotlin.l.b.a.b.f.a bT(Class<?> paramClass)
  {
    AppMethodBeat.i(56765);
    if ((!paramClass.isPrimitive()) && (!paramClass.isArray())) {}
    for (int i = 1; (z.aazO) && (i == 0); i = 0)
    {
      paramClass = (Throwable)new AssertionError("Invalid class: ".concat(String.valueOf(paramClass)));
      AppMethodBeat.o(56765);
      throw paramClass;
    }
    Class localClass = paramClass.getDeclaringClass();
    if (localClass == null)
    {
      paramClass = kotlin.l.b.a.b.f.a.p(new b(paramClass.getCanonicalName()));
      p.j(paramClass, "ClassId.topLevel(FqName(clazz.canonicalName))");
      AppMethodBeat.o(56765);
      return paramClass;
    }
    paramClass = bT(localClass).o(f.bHb(paramClass.getSimpleName()));
    p.j(paramClass, "classId(outer).createNes…tifier(clazz.simpleName))");
    AppMethodBeat.o(56765);
    return paramClass;
  }
  
  public static kotlin.l.b.a.b.f.a c(b paramb)
  {
    AppMethodBeat.i(56753);
    p.k(paramb, "fqName");
    paramb = (kotlin.l.b.a.b.f.a)aaIO.get(paramb.iNy());
    AppMethodBeat.o(56753);
    return paramb;
  }
  
  public static kotlin.l.b.a.b.f.a c(kotlin.l.b.a.b.f.c paramc)
  {
    AppMethodBeat.i(56755);
    p.k(paramc, "kotlinFqName");
    if (a(paramc, aaIH))
    {
      paramc = aaIL;
      AppMethodBeat.o(56755);
      return paramc;
    }
    if (a(paramc, aaIJ))
    {
      paramc = aaIL;
      AppMethodBeat.o(56755);
      return paramc;
    }
    if (a(paramc, aaII))
    {
      paramc = aaIN;
      AppMethodBeat.o(56755);
      return paramc;
    }
    if (a(paramc, aaIK))
    {
      paramc = aaIN;
      AppMethodBeat.o(56755);
      return paramc;
    }
    paramc = (kotlin.l.b.a.b.f.a)aaIP.get(paramc);
    AppMethodBeat.o(56755);
    return paramc;
  }
  
  public static boolean h(e parame)
  {
    AppMethodBeat.i(56761);
    p.k(parame, "mutable");
    parame = kotlin.l.b.a.b.j.c.n((l)parame);
    Map localMap = (Map)aaIQ;
    if (localMap == null)
    {
      parame = new t("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
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
    p.k(parame, "readOnly");
    parame = kotlin.l.b.a.b.j.c.n((l)parame);
    Map localMap = (Map)aaIR;
    if (localMap == null)
    {
      parame = new t("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
      AppMethodBeat.o(56762);
      throw parame;
    }
    boolean bool = localMap.containsKey(parame);
    AppMethodBeat.o(56762);
    return bool;
  }
  
  public static b iEn()
  {
    return aaIM;
  }
  
  public static List<c.a> iEo()
  {
    return aaIS;
  }
  
  public static e j(e parame)
  {
    AppMethodBeat.i(56763);
    p.k(parame, "mutable");
    parame = a(parame, (Map)aaIQ, "mutable");
    AppMethodBeat.o(56763);
    return parame;
  }
  
  public static e k(e parame)
  {
    AppMethodBeat.i(56764);
    p.k(parame, "readOnly");
    parame = a(parame, (Map)aaIR, "read-only");
    AppMethodBeat.o(56764);
    return parame;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.a.b.c
 * JD-Core Version:    0.7.0.1
 */