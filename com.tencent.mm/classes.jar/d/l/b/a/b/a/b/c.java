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
  private static final String Lcf;
  private static final String Lcg;
  private static final String Lch;
  private static final String Lci;
  private static final d.l.b.a.b.f.a Lcj;
  private static final b Lck;
  private static final d.l.b.a.b.f.a Lcl;
  private static final HashMap<d.l.b.a.b.f.c, d.l.b.a.b.f.a> Lcm;
  private static final HashMap<d.l.b.a.b.f.c, d.l.b.a.b.f.a> Lcn;
  private static final HashMap<d.l.b.a.b.f.c, b> Lco;
  static final HashMap<d.l.b.a.b.f.c, b> Lcp;
  private static final List<a> Lcq;
  public static final c Lcr;
  
  static
  {
    AppMethodBeat.i(56767);
    c localc = new c();
    Lcr = localc;
    Lcf = b.c.LbS.LbX.toString() + "." + b.c.LbS.LbY;
    Lcg = b.c.LbU.LbX.toString() + "." + b.c.LbU.LbY;
    Lch = b.c.LbT.LbX.toString() + "." + b.c.LbT.LbY;
    Lci = b.c.LbV.LbX.toString() + "." + b.c.LbV.LbY;
    Object localObject1 = d.l.b.a.b.f.a.p(new b("kotlin.jvm.functions.FunctionN"));
    k.g(localObject1, "ClassId.topLevel(FqName(…vm.functions.FunctionN\"))");
    Lcj = (d.l.b.a.b.f.a)localObject1;
    localObject1 = ((d.l.b.a.b.f.a)localObject1).fZF();
    k.g(localObject1, "FUNCTION_N_CLASS_ID.asSingleFqName()");
    Lck = (b)localObject1;
    localObject1 = d.l.b.a.b.f.a.p(new b("kotlin.reflect.KFunction"));
    k.g(localObject1, "ClassId.topLevel(FqName(…tlin.reflect.KFunction\"))");
    Lcl = (d.l.b.a.b.f.a)localObject1;
    Lcm = new HashMap();
    Lcn = new HashMap();
    Lco = new HashMap();
    Lcp = new HashMap();
    localObject1 = d.l.b.a.b.f.a.p(g.KZg.KZW);
    k.g(localObject1, "ClassId.topLevel(FQ_NAMES.iterable)");
    Object localObject2 = g.KZg.Lae;
    k.g(localObject2, "FQ_NAMES.mutableIterable");
    Object localObject3 = ((d.l.b.a.b.f.a)localObject1).fZA();
    Object localObject4 = ((d.l.b.a.b.f.a)localObject1).fZA();
    k.g(localObject4, "kotlinReadOnly.packageFqName");
    localObject2 = new d.l.b.a.b.f.a((b)localObject3, d.l.b.a.b.f.d.b((b)localObject2, (b)localObject4), false);
    localObject1 = new a(localc.bs(Iterable.class), (d.l.b.a.b.f.a)localObject1, (d.l.b.a.b.f.a)localObject2);
    localObject2 = d.l.b.a.b.f.a.p(g.KZg.KZV);
    k.g(localObject2, "ClassId.topLevel(FQ_NAMES.iterator)");
    localObject3 = g.KZg.Lad;
    k.g(localObject3, "FQ_NAMES.mutableIterator");
    localObject4 = ((d.l.b.a.b.f.a)localObject2).fZA();
    Object localObject5 = ((d.l.b.a.b.f.a)localObject2).fZA();
    k.g(localObject5, "kotlinReadOnly.packageFqName");
    localObject3 = new d.l.b.a.b.f.a((b)localObject4, d.l.b.a.b.f.d.b((b)localObject3, (b)localObject5), false);
    localObject2 = new a(localc.bs(Iterator.class), (d.l.b.a.b.f.a)localObject2, (d.l.b.a.b.f.a)localObject3);
    localObject3 = d.l.b.a.b.f.a.p(g.KZg.KZX);
    k.g(localObject3, "ClassId.topLevel(FQ_NAMES.collection)");
    localObject4 = g.KZg.Laf;
    k.g(localObject4, "FQ_NAMES.mutableCollection");
    localObject5 = ((d.l.b.a.b.f.a)localObject3).fZA();
    Object localObject6 = ((d.l.b.a.b.f.a)localObject3).fZA();
    k.g(localObject6, "kotlinReadOnly.packageFqName");
    localObject4 = new d.l.b.a.b.f.a((b)localObject5, d.l.b.a.b.f.d.b((b)localObject4, (b)localObject6), false);
    localObject3 = new a(localc.bs(Collection.class), (d.l.b.a.b.f.a)localObject3, (d.l.b.a.b.f.a)localObject4);
    localObject4 = d.l.b.a.b.f.a.p(g.KZg.KZY);
    k.g(localObject4, "ClassId.topLevel(FQ_NAMES.list)");
    localObject5 = g.KZg.Lag;
    k.g(localObject5, "FQ_NAMES.mutableList");
    localObject6 = ((d.l.b.a.b.f.a)localObject4).fZA();
    Object localObject7 = ((d.l.b.a.b.f.a)localObject4).fZA();
    k.g(localObject7, "kotlinReadOnly.packageFqName");
    localObject5 = new d.l.b.a.b.f.a((b)localObject6, d.l.b.a.b.f.d.b((b)localObject5, (b)localObject7), false);
    localObject4 = new a(localc.bs(List.class), (d.l.b.a.b.f.a)localObject4, (d.l.b.a.b.f.a)localObject5);
    localObject5 = d.l.b.a.b.f.a.p(g.KZg.Laa);
    k.g(localObject5, "ClassId.topLevel(FQ_NAMES.set)");
    localObject6 = g.KZg.Lai;
    k.g(localObject6, "FQ_NAMES.mutableSet");
    localObject7 = ((d.l.b.a.b.f.a)localObject5).fZA();
    Object localObject8 = ((d.l.b.a.b.f.a)localObject5).fZA();
    k.g(localObject8, "kotlinReadOnly.packageFqName");
    localObject6 = new d.l.b.a.b.f.a((b)localObject7, d.l.b.a.b.f.d.b((b)localObject6, (b)localObject8), false);
    localObject5 = new a(localc.bs(Set.class), (d.l.b.a.b.f.a)localObject5, (d.l.b.a.b.f.a)localObject6);
    localObject6 = d.l.b.a.b.f.a.p(g.KZg.KZZ);
    k.g(localObject6, "ClassId.topLevel(FQ_NAMES.listIterator)");
    localObject7 = g.KZg.Lah;
    k.g(localObject7, "FQ_NAMES.mutableListIterator");
    localObject8 = ((d.l.b.a.b.f.a)localObject6).fZA();
    Object localObject9 = ((d.l.b.a.b.f.a)localObject6).fZA();
    k.g(localObject9, "kotlinReadOnly.packageFqName");
    localObject7 = new d.l.b.a.b.f.a((b)localObject8, d.l.b.a.b.f.d.b((b)localObject7, (b)localObject9), false);
    localObject6 = new a(localc.bs(ListIterator.class), (d.l.b.a.b.f.a)localObject6, (d.l.b.a.b.f.a)localObject7);
    localObject7 = d.l.b.a.b.f.a.p(g.KZg.Lab);
    k.g(localObject7, "ClassId.topLevel(FQ_NAMES.map)");
    localObject8 = g.KZg.Laj;
    k.g(localObject8, "FQ_NAMES.mutableMap");
    localObject9 = ((d.l.b.a.b.f.a)localObject7).fZA();
    b localb1 = ((d.l.b.a.b.f.a)localObject7).fZA();
    k.g(localb1, "kotlinReadOnly.packageFqName");
    localObject8 = new d.l.b.a.b.f.a((b)localObject9, d.l.b.a.b.f.d.b((b)localObject8, localb1), false);
    localObject7 = new a(localc.bs(Map.class), (d.l.b.a.b.f.a)localObject7, (d.l.b.a.b.f.a)localObject8);
    localObject8 = d.l.b.a.b.f.a.p(g.KZg.Lab).o(g.KZg.Lac.fZI());
    k.g(localObject8, "ClassId.topLevel(FQ_NAME…MES.mapEntry.shortName())");
    localObject9 = g.KZg.Lak;
    k.g(localObject9, "FQ_NAMES.mutableMapEntry");
    localb1 = ((d.l.b.a.b.f.a)localObject8).fZA();
    b localb2 = ((d.l.b.a.b.f.a)localObject8).fZA();
    k.g(localb2, "kotlinReadOnly.packageFqName");
    localObject9 = new d.l.b.a.b.f.a(localb1, d.l.b.a.b.f.d.b((b)localObject9, localb2), false);
    Lcq = j.listOf(new a[] { localObject1, localObject2, localObject3, localObject4, localObject5, localObject6, localObject7, new a(localc.bs(Map.Entry.class), (d.l.b.a.b.f.a)localObject8, (d.l.b.a.b.f.a)localObject9) });
    localObject1 = g.KZg.KZk;
    k.g(localObject1, "FQ_NAMES.any");
    localc.a(Object.class, (d.l.b.a.b.f.c)localObject1);
    localObject1 = g.KZg.KZq;
    k.g(localObject1, "FQ_NAMES.string");
    localc.a(String.class, (d.l.b.a.b.f.c)localObject1);
    localObject1 = g.KZg.KZp;
    k.g(localObject1, "FQ_NAMES.charSequence");
    localc.a(CharSequence.class, (d.l.b.a.b.f.c)localObject1);
    localObject1 = g.KZg.KZD;
    k.g(localObject1, "FQ_NAMES.throwable");
    localc.a(Throwable.class, (b)localObject1);
    localObject1 = g.KZg.KZm;
    k.g(localObject1, "FQ_NAMES.cloneable");
    localc.a(Cloneable.class, (d.l.b.a.b.f.c)localObject1);
    localObject1 = g.KZg.KZA;
    k.g(localObject1, "FQ_NAMES.number");
    localc.a(Number.class, (d.l.b.a.b.f.c)localObject1);
    localObject1 = g.KZg.KZE;
    k.g(localObject1, "FQ_NAMES.comparable");
    localc.a(Comparable.class, (b)localObject1);
    localObject1 = g.KZg.KZB;
    k.g(localObject1, "FQ_NAMES._enum");
    localc.a(Enum.class, (d.l.b.a.b.f.c)localObject1);
    localObject1 = g.KZg.KZM;
    k.g(localObject1, "FQ_NAMES.annotation");
    localc.a(Annotation.class, (b)localObject1);
    localObject1 = Lcq.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (a)((Iterator)localObject1).next();
      localObject3 = ((a)localObject2).Lcs;
      localObject4 = ((a)localObject2).Lct;
      localObject2 = ((a)localObject2).Lcu;
      a((d.l.b.a.b.f.a)localObject3, (d.l.b.a.b.f.a)localObject4);
      localObject5 = ((d.l.b.a.b.f.a)localObject2).fZF();
      k.g(localObject5, "mutableClassId.asSingleFqName()");
      a((b)localObject5, (d.l.b.a.b.f.a)localObject3);
      localObject4 = ((d.l.b.a.b.f.a)localObject4).fZF();
      k.g(localObject4, "readOnlyClassId.asSingleFqName()");
      localObject3 = ((d.l.b.a.b.f.a)localObject2).fZF();
      k.g(localObject3, "mutableClassId.asSingleFqName()");
      localObject5 = (Map)Lco;
      localObject2 = ((d.l.b.a.b.f.a)localObject2).fZF().fZG();
      k.g(localObject2, "mutableClassId.asSingleFqName().toUnsafe()");
      ((Map)localObject5).put(localObject2, localObject4);
      localObject2 = (Map)Lcp;
      localObject4 = ((b)localObject4).fZG();
      k.g(localObject4, "readOnlyFqName.toUnsafe()");
      ((Map)localObject2).put(localObject4, localObject3);
    }
    localObject1 = d.l.b.a.b.j.e.d.values();
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      localObject3 = localObject1[i];
      localObject2 = d.l.b.a.b.f.a.p(((d.l.b.a.b.j.e.d)localObject3).gbH());
      k.g(localObject2, "ClassId.topLevel(jvmType.wrapperFqName)");
      localObject3 = d.l.b.a.b.f.a.p(g.c(((d.l.b.a.b.j.e.d)localObject3).gbF()));
      k.g(localObject3, "ClassId.topLevel(KotlinB…e(jvmType.primitiveType))");
      a((d.l.b.a.b.f.a)localObject2, (d.l.b.a.b.f.a)localObject3);
      i += 1;
    }
    localObject1 = d.l.b.a.b.a.c.KYR;
    localObject1 = d.l.b.a.b.a.c.fPx().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (d.l.b.a.b.f.a)((Iterator)localObject1).next();
      localObject2 = d.l.b.a.b.f.a.p(new b("kotlin.jvm.internal." + ((d.l.b.a.b.f.a)localObject3).fZC().rf() + "CompanionObject"));
      k.g(localObject2, "ClassId.topLevel(FqName(…g() + \"CompanionObject\"))");
      localObject3 = ((d.l.b.a.b.f.a)localObject3).o(h.Lzx);
      k.g(localObject3, "classId.createNestedClas…AME_FOR_COMPANION_OBJECT)");
      a((d.l.b.a.b.f.a)localObject2, (d.l.b.a.b.f.a)localObject3);
    }
    i = 0;
    while (i < 23)
    {
      localObject1 = d.l.b.a.b.f.a.p(new b("kotlin.jvm.functions.Function".concat(String.valueOf(i))));
      k.g(localObject1, "ClassId.topLevel(FqName(…m.functions.Function$i\"))");
      localObject2 = g.agN(i);
      k.g(localObject2, "KotlinBuiltIns.getFunctionClassId(i)");
      a((d.l.b.a.b.f.a)localObject1, (d.l.b.a.b.f.a)localObject2);
      a(new b(Lcg + i), Lcl);
      i += 1;
    }
    i = 0;
    while (i < 22)
    {
      localObject1 = b.c.LbV;
      localObject1 = ((b.c)localObject1).LbX.toString() + "." + ((b.c)localObject1).LbY;
      a(new b((String)localObject1 + i), Lcl);
      i += 1;
    }
    localObject1 = g.KZg.KZl.fZL();
    k.g(localObject1, "FQ_NAMES.nothing.toSafe()");
    a((b)localObject1, localc.bs(Void.class));
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
    Map localMap = (Map)Lcm;
    d.l.b.a.b.f.c localc = parama1.fZF().fZG();
    k.g(localc, "javaClassId.asSingleFqName().toUnsafe()");
    localMap.put(localc, parama2);
    parama2 = parama2.fZF();
    k.g(parama2, "kotlinClassId.asSingleFqName()");
    a(parama2, parama1);
    AppMethodBeat.o(56757);
  }
  
  private static void a(b paramb, d.l.b.a.b.f.a parama)
  {
    AppMethodBeat.i(56760);
    Map localMap = (Map)Lcn;
    paramb = paramb.fZG();
    k.g(paramb, "kotlinFqNameUnsafe.toUnsafe()");
    localMap.put(paramb, parama);
    AppMethodBeat.o(56760);
  }
  
  private final void a(Class<?> paramClass, b paramb)
  {
    AppMethodBeat.i(56759);
    paramClass = bs(paramClass);
    paramb = d.l.b.a.b.f.a.p(paramb);
    k.g(paramb, "ClassId.topLevel(kotlinFqName)");
    a(paramClass, paramb);
    AppMethodBeat.o(56759);
  }
  
  private final void a(Class<?> paramClass, d.l.b.a.b.f.c paramc)
  {
    AppMethodBeat.i(56758);
    paramc = paramc.fZL();
    k.g(paramc, "kotlinFqName.toSafe()");
    a(paramClass, paramc);
    AppMethodBeat.o(56758);
  }
  
  private static boolean a(d.l.b.a.b.f.c paramc, String paramString)
  {
    AppMethodBeat.i(56756);
    paramc = paramc.rf();
    k.g(paramc, "kotlinFqName.asString()");
    paramc = n.bi(paramc, paramString, "");
    int i;
    if (((CharSequence)paramc).length() > 0) {
      i = 1;
    }
    while ((i != 0) && (!n.aH((CharSequence)paramc)))
    {
      paramc = n.aXe(paramc);
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
  
  private final d.l.b.a.b.f.a bs(Class<?> paramClass)
  {
    AppMethodBeat.i(56765);
    if ((!paramClass.isPrimitive()) && (!paramClass.isArray())) {}
    for (int i = 1; (aa.KTq) && (i == 0); i = 0)
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
    paramClass = bs(localClass).o(f.aWB(paramClass.getSimpleName()));
    k.g(paramClass, "classId(outer).createNes…tifier(clazz.simpleName))");
    AppMethodBeat.o(56765);
    return paramClass;
  }
  
  public static d.l.b.a.b.f.a c(b paramb)
  {
    AppMethodBeat.i(56753);
    k.h(paramb, "fqName");
    paramb = (d.l.b.a.b.f.a)Lcm.get(paramb.fZG());
    AppMethodBeat.o(56753);
    return paramb;
  }
  
  public static d.l.b.a.b.f.a c(d.l.b.a.b.f.c paramc)
  {
    AppMethodBeat.i(56755);
    k.h(paramc, "kotlinFqName");
    if (a(paramc, Lcf))
    {
      paramc = Lcj;
      AppMethodBeat.o(56755);
      return paramc;
    }
    if (a(paramc, Lch))
    {
      paramc = Lcj;
      AppMethodBeat.o(56755);
      return paramc;
    }
    if (a(paramc, Lcg))
    {
      paramc = Lcl;
      AppMethodBeat.o(56755);
      return paramc;
    }
    if (a(paramc, Lci))
    {
      paramc = Lcl;
      AppMethodBeat.o(56755);
      return paramc;
    }
    paramc = (d.l.b.a.b.f.a)Lcn.get(paramc);
    AppMethodBeat.o(56755);
    return paramc;
  }
  
  public static b fQy()
  {
    return Lck;
  }
  
  public static List<a> fQz()
  {
    return Lcq;
  }
  
  public static boolean h(e parame)
  {
    AppMethodBeat.i(56761);
    k.h(parame, "mutable");
    parame = d.l.b.a.b.j.c.n((l)parame);
    Map localMap = (Map)Lco;
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
    Map localMap = (Map)Lcp;
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
    parame = a(parame, (Map)Lco, "mutable");
    AppMethodBeat.o(56763);
    return parame;
  }
  
  public static e k(e parame)
  {
    AppMethodBeat.i(56764);
    k.h(parame, "readOnly");
    parame = a(parame, (Map)Lcp, "read-only");
    AppMethodBeat.o(56764);
    return parame;
  }
  
  public static final class a
  {
    public final d.l.b.a.b.f.a Lcs;
    final d.l.b.a.b.f.a Lct;
    final d.l.b.a.b.f.a Lcu;
    
    public a(d.l.b.a.b.f.a parama1, d.l.b.a.b.f.a parama2, d.l.b.a.b.f.a parama3)
    {
      AppMethodBeat.i(56749);
      this.Lcs = parama1;
      this.Lct = parama2;
      this.Lcu = parama3;
      AppMethodBeat.o(56749);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(56752);
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((!k.g(this.Lcs, paramObject.Lcs)) || (!k.g(this.Lct, paramObject.Lct)) || (!k.g(this.Lcu, paramObject.Lcu))) {}
        }
      }
      else
      {
        AppMethodBeat.o(56752);
        return true;
      }
      AppMethodBeat.o(56752);
      return false;
    }
    
    public final int hashCode()
    {
      int k = 0;
      AppMethodBeat.i(56751);
      d.l.b.a.b.f.a locala = this.Lcs;
      int i;
      if (locala != null)
      {
        i = locala.hashCode();
        locala = this.Lct;
        if (locala == null) {
          break label80;
        }
      }
      label80:
      for (int j = locala.hashCode();; j = 0)
      {
        locala = this.Lcu;
        if (locala != null) {
          k = locala.hashCode();
        }
        AppMethodBeat.o(56751);
        return (j + i * 31) * 31 + k;
        i = 0;
        break;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(56750);
      String str = "PlatformMutabilityMapping(javaClass=" + this.Lcs + ", kotlinReadOnly=" + this.Lct + ", kotlinMutable=" + this.Lcu + ")";
      AppMethodBeat.o(56750);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.a.b.c
 * JD-Core Version:    0.7.0.1
 */