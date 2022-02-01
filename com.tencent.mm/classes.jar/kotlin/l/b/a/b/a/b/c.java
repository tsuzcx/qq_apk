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
import kotlin.aa;
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

public final class c
{
  private static final String TfN;
  private static final String TfO;
  private static final String TfP;
  private static final String TfQ;
  private static final kotlin.l.b.a.b.f.a TfR;
  private static final b TfS;
  private static final kotlin.l.b.a.b.f.a TfT;
  private static final HashMap<kotlin.l.b.a.b.f.c, kotlin.l.b.a.b.f.a> TfU;
  private static final HashMap<kotlin.l.b.a.b.f.c, kotlin.l.b.a.b.f.a> TfV;
  private static final HashMap<kotlin.l.b.a.b.f.c, b> TfW;
  static final HashMap<kotlin.l.b.a.b.f.c, b> TfX;
  private static final List<c.a> TfY;
  public static final c TfZ;
  
  static
  {
    AppMethodBeat.i(56767);
    c localc = new c();
    TfZ = localc;
    TfN = b.c.TfA.TfF.toString() + "." + b.c.TfA.TfG;
    TfO = b.c.TfC.TfF.toString() + "." + b.c.TfC.TfG;
    TfP = b.c.TfB.TfF.toString() + "." + b.c.TfB.TfG;
    TfQ = b.c.TfD.TfF.toString() + "." + b.c.TfD.TfG;
    Object localObject1 = kotlin.l.b.a.b.f.a.p(new b("kotlin.jvm.functions.FunctionN"));
    p.g(localObject1, "ClassId.topLevel(FqName(…vm.functions.FunctionN\"))");
    TfR = (kotlin.l.b.a.b.f.a)localObject1;
    localObject1 = ((kotlin.l.b.a.b.f.a)localObject1).hJd();
    p.g(localObject1, "FUNCTION_N_CLASS_ID.asSingleFqName()");
    TfS = (b)localObject1;
    localObject1 = kotlin.l.b.a.b.f.a.p(new b("kotlin.reflect.KFunction"));
    p.g(localObject1, "ClassId.topLevel(FqName(…tlin.reflect.KFunction\"))");
    TfT = (kotlin.l.b.a.b.f.a)localObject1;
    TfU = new HashMap();
    TfV = new HashMap();
    TfW = new HashMap();
    TfX = new HashMap();
    localObject1 = kotlin.l.b.a.b.f.a.p(g.TcO.TdE);
    p.g(localObject1, "ClassId.topLevel(FQ_NAMES.iterable)");
    Object localObject2 = g.TcO.TdM;
    p.g(localObject2, "FQ_NAMES.mutableIterable");
    Object localObject3 = ((kotlin.l.b.a.b.f.a)localObject1).hIY();
    Object localObject4 = ((kotlin.l.b.a.b.f.a)localObject1).hIY();
    p.g(localObject4, "kotlinReadOnly.packageFqName");
    localObject2 = new kotlin.l.b.a.b.f.a((b)localObject3, kotlin.l.b.a.b.f.d.b((b)localObject2, (b)localObject4), false);
    localObject1 = new c.a(localc.bu(Iterable.class), (kotlin.l.b.a.b.f.a)localObject1, (kotlin.l.b.a.b.f.a)localObject2);
    localObject2 = kotlin.l.b.a.b.f.a.p(g.TcO.TdD);
    p.g(localObject2, "ClassId.topLevel(FQ_NAMES.iterator)");
    localObject3 = g.TcO.TdL;
    p.g(localObject3, "FQ_NAMES.mutableIterator");
    localObject4 = ((kotlin.l.b.a.b.f.a)localObject2).hIY();
    Object localObject5 = ((kotlin.l.b.a.b.f.a)localObject2).hIY();
    p.g(localObject5, "kotlinReadOnly.packageFqName");
    localObject3 = new kotlin.l.b.a.b.f.a((b)localObject4, kotlin.l.b.a.b.f.d.b((b)localObject3, (b)localObject5), false);
    localObject2 = new c.a(localc.bu(Iterator.class), (kotlin.l.b.a.b.f.a)localObject2, (kotlin.l.b.a.b.f.a)localObject3);
    localObject3 = kotlin.l.b.a.b.f.a.p(g.TcO.TdF);
    p.g(localObject3, "ClassId.topLevel(FQ_NAMES.collection)");
    localObject4 = g.TcO.TdN;
    p.g(localObject4, "FQ_NAMES.mutableCollection");
    localObject5 = ((kotlin.l.b.a.b.f.a)localObject3).hIY();
    Object localObject6 = ((kotlin.l.b.a.b.f.a)localObject3).hIY();
    p.g(localObject6, "kotlinReadOnly.packageFqName");
    localObject4 = new kotlin.l.b.a.b.f.a((b)localObject5, kotlin.l.b.a.b.f.d.b((b)localObject4, (b)localObject6), false);
    localObject3 = new c.a(localc.bu(Collection.class), (kotlin.l.b.a.b.f.a)localObject3, (kotlin.l.b.a.b.f.a)localObject4);
    localObject4 = kotlin.l.b.a.b.f.a.p(g.TcO.TdG);
    p.g(localObject4, "ClassId.topLevel(FQ_NAMES.list)");
    localObject5 = g.TcO.TdO;
    p.g(localObject5, "FQ_NAMES.mutableList");
    localObject6 = ((kotlin.l.b.a.b.f.a)localObject4).hIY();
    Object localObject7 = ((kotlin.l.b.a.b.f.a)localObject4).hIY();
    p.g(localObject7, "kotlinReadOnly.packageFqName");
    localObject5 = new kotlin.l.b.a.b.f.a((b)localObject6, kotlin.l.b.a.b.f.d.b((b)localObject5, (b)localObject7), false);
    localObject4 = new c.a(localc.bu(List.class), (kotlin.l.b.a.b.f.a)localObject4, (kotlin.l.b.a.b.f.a)localObject5);
    localObject5 = kotlin.l.b.a.b.f.a.p(g.TcO.TdI);
    p.g(localObject5, "ClassId.topLevel(FQ_NAMES.set)");
    localObject6 = g.TcO.TdQ;
    p.g(localObject6, "FQ_NAMES.mutableSet");
    localObject7 = ((kotlin.l.b.a.b.f.a)localObject5).hIY();
    Object localObject8 = ((kotlin.l.b.a.b.f.a)localObject5).hIY();
    p.g(localObject8, "kotlinReadOnly.packageFqName");
    localObject6 = new kotlin.l.b.a.b.f.a((b)localObject7, kotlin.l.b.a.b.f.d.b((b)localObject6, (b)localObject8), false);
    localObject5 = new c.a(localc.bu(Set.class), (kotlin.l.b.a.b.f.a)localObject5, (kotlin.l.b.a.b.f.a)localObject6);
    localObject6 = kotlin.l.b.a.b.f.a.p(g.TcO.TdH);
    p.g(localObject6, "ClassId.topLevel(FQ_NAMES.listIterator)");
    localObject7 = g.TcO.TdP;
    p.g(localObject7, "FQ_NAMES.mutableListIterator");
    localObject8 = ((kotlin.l.b.a.b.f.a)localObject6).hIY();
    Object localObject9 = ((kotlin.l.b.a.b.f.a)localObject6).hIY();
    p.g(localObject9, "kotlinReadOnly.packageFqName");
    localObject7 = new kotlin.l.b.a.b.f.a((b)localObject8, kotlin.l.b.a.b.f.d.b((b)localObject7, (b)localObject9), false);
    localObject6 = new c.a(localc.bu(ListIterator.class), (kotlin.l.b.a.b.f.a)localObject6, (kotlin.l.b.a.b.f.a)localObject7);
    localObject7 = kotlin.l.b.a.b.f.a.p(g.TcO.TdJ);
    p.g(localObject7, "ClassId.topLevel(FQ_NAMES.map)");
    localObject8 = g.TcO.TdR;
    p.g(localObject8, "FQ_NAMES.mutableMap");
    localObject9 = ((kotlin.l.b.a.b.f.a)localObject7).hIY();
    b localb1 = ((kotlin.l.b.a.b.f.a)localObject7).hIY();
    p.g(localb1, "kotlinReadOnly.packageFqName");
    localObject8 = new kotlin.l.b.a.b.f.a((b)localObject9, kotlin.l.b.a.b.f.d.b((b)localObject8, localb1), false);
    localObject7 = new c.a(localc.bu(Map.class), (kotlin.l.b.a.b.f.a)localObject7, (kotlin.l.b.a.b.f.a)localObject8);
    localObject8 = kotlin.l.b.a.b.f.a.p(g.TcO.TdJ).o(g.TcO.TdK.hJg());
    p.g(localObject8, "ClassId.topLevel(FQ_NAME…MES.mapEntry.shortName())");
    localObject9 = g.TcO.TdS;
    p.g(localObject9, "FQ_NAMES.mutableMapEntry");
    localb1 = ((kotlin.l.b.a.b.f.a)localObject8).hIY();
    b localb2 = ((kotlin.l.b.a.b.f.a)localObject8).hIY();
    p.g(localb2, "kotlinReadOnly.packageFqName");
    localObject9 = new kotlin.l.b.a.b.f.a(localb1, kotlin.l.b.a.b.f.d.b((b)localObject9, localb2), false);
    TfY = j.listOf(new c.a[] { localObject1, localObject2, localObject3, localObject4, localObject5, localObject6, localObject7, new c.a(localc.bu(Map.Entry.class), (kotlin.l.b.a.b.f.a)localObject8, (kotlin.l.b.a.b.f.a)localObject9) });
    localObject1 = g.TcO.TcS;
    p.g(localObject1, "FQ_NAMES.any");
    localc.a(Object.class, (kotlin.l.b.a.b.f.c)localObject1);
    localObject1 = g.TcO.TcY;
    p.g(localObject1, "FQ_NAMES.string");
    localc.a(String.class, (kotlin.l.b.a.b.f.c)localObject1);
    localObject1 = g.TcO.TcX;
    p.g(localObject1, "FQ_NAMES.charSequence");
    localc.a(CharSequence.class, (kotlin.l.b.a.b.f.c)localObject1);
    localObject1 = g.TcO.Tdl;
    p.g(localObject1, "FQ_NAMES.throwable");
    localc.a(Throwable.class, (b)localObject1);
    localObject1 = g.TcO.TcU;
    p.g(localObject1, "FQ_NAMES.cloneable");
    localc.a(Cloneable.class, (kotlin.l.b.a.b.f.c)localObject1);
    localObject1 = g.TcO.Tdi;
    p.g(localObject1, "FQ_NAMES.number");
    localc.a(Number.class, (kotlin.l.b.a.b.f.c)localObject1);
    localObject1 = g.TcO.Tdm;
    p.g(localObject1, "FQ_NAMES.comparable");
    localc.a(Comparable.class, (b)localObject1);
    localObject1 = g.TcO.Tdj;
    p.g(localObject1, "FQ_NAMES._enum");
    localc.a(Enum.class, (kotlin.l.b.a.b.f.c)localObject1);
    localObject1 = g.TcO.Tdu;
    p.g(localObject1, "FQ_NAMES.annotation");
    localc.a(Annotation.class, (b)localObject1);
    localObject1 = TfY.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (c.a)((Iterator)localObject1).next();
      localObject3 = ((c.a)localObject2).Tga;
      localObject4 = ((c.a)localObject2).Tgb;
      localObject2 = ((c.a)localObject2).Tgc;
      a((kotlin.l.b.a.b.f.a)localObject3, (kotlin.l.b.a.b.f.a)localObject4);
      localObject5 = ((kotlin.l.b.a.b.f.a)localObject2).hJd();
      p.g(localObject5, "mutableClassId.asSingleFqName()");
      a((b)localObject5, (kotlin.l.b.a.b.f.a)localObject3);
      localObject4 = ((kotlin.l.b.a.b.f.a)localObject4).hJd();
      p.g(localObject4, "readOnlyClassId.asSingleFqName()");
      localObject3 = ((kotlin.l.b.a.b.f.a)localObject2).hJd();
      p.g(localObject3, "mutableClassId.asSingleFqName()");
      localObject5 = (Map)TfW;
      localObject2 = ((kotlin.l.b.a.b.f.a)localObject2).hJd().hJe();
      p.g(localObject2, "mutableClassId.asSingleFqName().toUnsafe()");
      ((Map)localObject5).put(localObject2, localObject4);
      localObject2 = (Map)TfX;
      localObject4 = ((b)localObject4).hJe();
      p.g(localObject4, "readOnlyFqName.toUnsafe()");
      ((Map)localObject2).put(localObject4, localObject3);
    }
    localObject1 = kotlin.l.b.a.b.j.e.d.values();
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      localObject3 = localObject1[i];
      localObject2 = kotlin.l.b.a.b.f.a.p(((kotlin.l.b.a.b.j.e.d)localObject3).hKL());
      p.g(localObject2, "ClassId.topLevel(jvmType.wrapperFqName)");
      localObject3 = kotlin.l.b.a.b.f.a.p(g.c(((kotlin.l.b.a.b.j.e.d)localObject3).hKJ()));
      p.g(localObject3, "ClassId.topLevel(KotlinB…e(jvmType.primitiveType))");
      a((kotlin.l.b.a.b.f.a)localObject2, (kotlin.l.b.a.b.f.a)localObject3);
      i += 1;
    }
    localObject1 = kotlin.l.b.a.b.a.c.Tcz;
    localObject1 = kotlin.l.b.a.b.a.c.hza().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (kotlin.l.b.a.b.f.a)((Iterator)localObject1).next();
      localObject2 = kotlin.l.b.a.b.f.a.p(new b("kotlin.jvm.internal." + ((kotlin.l.b.a.b.f.a)localObject3).hJa().sG() + "CompanionObject"));
      p.g(localObject2, "ClassId.topLevel(FqName(…g() + \"CompanionObject\"))");
      localObject3 = ((kotlin.l.b.a.b.f.a)localObject3).o(h.TDf);
      p.g(localObject3, "classId.createNestedClas…AME_FOR_COMPANION_OBJECT)");
      a((kotlin.l.b.a.b.f.a)localObject2, (kotlin.l.b.a.b.f.a)localObject3);
    }
    i = 0;
    while (i < 23)
    {
      localObject1 = kotlin.l.b.a.b.f.a.p(new b("kotlin.jvm.functions.Function".concat(String.valueOf(i))));
      p.g(localObject1, "ClassId.topLevel(FqName(…m.functions.Function$i\"))");
      localObject2 = g.atO(i);
      p.g(localObject2, "KotlinBuiltIns.getFunctionClassId(i)");
      a((kotlin.l.b.a.b.f.a)localObject1, (kotlin.l.b.a.b.f.a)localObject2);
      a(new b(TfO + i), TfT);
      i += 1;
    }
    i = 0;
    while (i < 22)
    {
      localObject1 = b.c.TfD;
      localObject1 = ((b.c)localObject1).TfF.toString() + "." + ((b.c)localObject1).TfG;
      a(new b((String)localObject1 + i), TfT);
      i += 1;
    }
    localObject1 = g.TcO.TcT.hJj();
    p.g(localObject1, "FQ_NAMES.nothing.toSafe()");
    a((b)localObject1, localc.bu(Void.class));
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
    p.g(parame, "descriptor.builtIns.getB…Name(oppositeClassFqName)");
    AppMethodBeat.o(56766);
    return parame;
  }
  
  private final void a(Class<?> paramClass, b paramb)
  {
    AppMethodBeat.i(56759);
    paramClass = bu(paramClass);
    paramb = kotlin.l.b.a.b.f.a.p(paramb);
    p.g(paramb, "ClassId.topLevel(kotlinFqName)");
    a(paramClass, paramb);
    AppMethodBeat.o(56759);
  }
  
  private final void a(Class<?> paramClass, kotlin.l.b.a.b.f.c paramc)
  {
    AppMethodBeat.i(56758);
    paramc = paramc.hJj();
    p.g(paramc, "kotlinFqName.toSafe()");
    a(paramClass, paramc);
    AppMethodBeat.o(56758);
  }
  
  private static void a(kotlin.l.b.a.b.f.a parama1, kotlin.l.b.a.b.f.a parama2)
  {
    AppMethodBeat.i(56757);
    Map localMap = (Map)TfU;
    kotlin.l.b.a.b.f.c localc = parama1.hJd().hJe();
    p.g(localc, "javaClassId.asSingleFqName().toUnsafe()");
    localMap.put(localc, parama2);
    parama2 = parama2.hJd();
    p.g(parama2, "kotlinClassId.asSingleFqName()");
    a(parama2, parama1);
    AppMethodBeat.o(56757);
  }
  
  private static void a(b paramb, kotlin.l.b.a.b.f.a parama)
  {
    AppMethodBeat.i(56760);
    Map localMap = (Map)TfV;
    paramb = paramb.hJe();
    p.g(paramb, "kotlinFqNameUnsafe.toUnsafe()");
    localMap.put(paramb, parama);
    AppMethodBeat.o(56760);
  }
  
  private static boolean a(kotlin.l.b.a.b.f.c paramc, String paramString)
  {
    AppMethodBeat.i(56756);
    paramc = paramc.sG();
    p.g(paramc, "kotlinFqName.asString()");
    paramc = n.bA(paramc, paramString, "");
    int i;
    if (((CharSequence)paramc).length() > 0) {
      i = 1;
    }
    while ((i != 0) && (!n.aP((CharSequence)paramc)))
    {
      paramc = n.buA(paramc);
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
  
  private final kotlin.l.b.a.b.f.a bu(Class<?> paramClass)
  {
    AppMethodBeat.i(56765);
    if ((!paramClass.isPrimitive()) && (!paramClass.isArray())) {}
    for (int i = 1; (aa.SXc) && (i == 0); i = 0)
    {
      paramClass = (Throwable)new AssertionError("Invalid class: ".concat(String.valueOf(paramClass)));
      AppMethodBeat.o(56765);
      throw paramClass;
    }
    Class localClass = paramClass.getDeclaringClass();
    if (localClass == null)
    {
      paramClass = kotlin.l.b.a.b.f.a.p(new b(paramClass.getCanonicalName()));
      p.g(paramClass, "ClassId.topLevel(FqName(clazz.canonicalName))");
      AppMethodBeat.o(56765);
      return paramClass;
    }
    paramClass = bu(localClass).o(f.btY(paramClass.getSimpleName()));
    p.g(paramClass, "classId(outer).createNes…tifier(clazz.simpleName))");
    AppMethodBeat.o(56765);
    return paramClass;
  }
  
  public static kotlin.l.b.a.b.f.a c(b paramb)
  {
    AppMethodBeat.i(56753);
    p.h(paramb, "fqName");
    paramb = (kotlin.l.b.a.b.f.a)TfU.get(paramb.hJe());
    AppMethodBeat.o(56753);
    return paramb;
  }
  
  public static kotlin.l.b.a.b.f.a c(kotlin.l.b.a.b.f.c paramc)
  {
    AppMethodBeat.i(56755);
    p.h(paramc, "kotlinFqName");
    if (a(paramc, TfN))
    {
      paramc = TfR;
      AppMethodBeat.o(56755);
      return paramc;
    }
    if (a(paramc, TfP))
    {
      paramc = TfR;
      AppMethodBeat.o(56755);
      return paramc;
    }
    if (a(paramc, TfO))
    {
      paramc = TfT;
      AppMethodBeat.o(56755);
      return paramc;
    }
    if (a(paramc, TfQ))
    {
      paramc = TfT;
      AppMethodBeat.o(56755);
      return paramc;
    }
    paramc = (kotlin.l.b.a.b.f.a)TfV.get(paramc);
    AppMethodBeat.o(56755);
    return paramc;
  }
  
  public static boolean h(e parame)
  {
    AppMethodBeat.i(56761);
    p.h(parame, "mutable");
    parame = kotlin.l.b.a.b.j.c.n((l)parame);
    Map localMap = (Map)TfW;
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
  
  public static b hAa()
  {
    return TfS;
  }
  
  public static List<c.a> hAb()
  {
    return TfY;
  }
  
  public static boolean i(e parame)
  {
    AppMethodBeat.i(56762);
    p.h(parame, "readOnly");
    parame = kotlin.l.b.a.b.j.c.n((l)parame);
    Map localMap = (Map)TfX;
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
  
  public static e j(e parame)
  {
    AppMethodBeat.i(56763);
    p.h(parame, "mutable");
    parame = a(parame, (Map)TfW, "mutable");
    AppMethodBeat.o(56763);
    return parame;
  }
  
  public static e k(e parame)
  {
    AppMethodBeat.i(56764);
    p.h(parame, "readOnly");
    parame = a(parame, (Map)TfX, "read-only");
    AppMethodBeat.o(56764);
    return parame;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.a.b.c
 * JD-Core Version:    0.7.0.1
 */