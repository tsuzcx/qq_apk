package kotlin.l.b.a.b.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.a.m;
import kotlin.g.b.aa;
import kotlin.g.b.p;
import kotlin.g.b.z.f;
import kotlin.l.b.a.b.a.g.a;
import kotlin.l.b.a.b.b.am;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.az;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.t.a;
import kotlin.l.b.a.b.b.w;
import kotlin.l.b.a.b.e.a.b;
import kotlin.l.b.a.b.e.a.h;
import kotlin.l.b.a.b.j.i.a.a;
import kotlin.l.b.a.b.k.a.n;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.ae;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.b.a.b.m.at;
import kotlin.l.b.a.b.m.au;
import kotlin.l.b.a.b.o.b.b;
import kotlin.l.b.a.b.o.b.c;

public class h
  implements kotlin.l.b.a.b.b.b.a, kotlin.l.b.a.b.b.b.c
{
  private static final Set<String> TgD;
  private static final Set<String> TgE;
  private static final Set<String> TgF;
  private static final Set<String> TgG;
  private static final Set<String> TgH;
  private static final Set<String> TgI;
  public static final a TgJ;
  private final kotlin.l.b.a.b.l.f TgA;
  private final kotlin.l.b.a.b.l.a<kotlin.l.b.a.b.f.b, kotlin.l.b.a.b.b.e> TgB;
  private final kotlin.l.b.a.b.l.f TgC;
  private final kotlin.l.b.a.b.b.y Tge;
  private final c Tgw;
  private final kotlin.f Tgx;
  private final kotlin.f Tgy;
  private final ab Tgz;
  
  static
  {
    AppMethodBeat.i(56812);
    cLI = new kotlin.l.k[] { (kotlin.l.k)aa.a(new kotlin.g.b.y(aa.bp(h.class), "cloneableType", "getCloneableType()Lorg/jetbrains/kotlin/types/SimpleType;")), (kotlin.l.k)aa.a(new kotlin.g.b.y(aa.bp(h.class), "notConsideredDeprecation", "getNotConsideredDeprecation()Lorg/jetbrains/kotlin/descriptors/annotations/Annotations;")) };
    TgJ = new a((byte)0);
    Object localObject1 = kotlin.l.b.a.b.d.b.v.TvS;
    TgD = ak.c((Set)kotlin.l.b.a.b.d.b.v.s("Collection", new String[] { "toArray()[Ljava/lang/Object;", "toArray([Ljava/lang/Object;)[Ljava/lang/Object;" }), "java/lang/annotation/Annotation.annotationType()Ljava/lang/Class;");
    localObject1 = kotlin.l.b.a.b.d.b.v.TvS;
    localObject1 = kotlin.l.b.a.b.d.b.v.TvS;
    Object localObject2 = (Iterable)kotlin.a.j.listOf(new kotlin.l.b.a.b.j.e.d[] { kotlin.l.b.a.b.j.e.d.TIW, kotlin.l.b.a.b.j.e.d.TIX });
    localObject1 = (Collection)new LinkedHashSet();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      kotlin.l.b.a.b.j.e.d locald = (kotlin.l.b.a.b.j.e.d)((Iterator)localObject2).next();
      String str = locald.hKL().hJg().sG();
      p.g(str, "it.wrapperFqName.shortName().asString()");
      kotlin.a.j.a((Collection)localObject1, (Iterable)kotlin.l.b.a.b.d.b.v.r(str, new String[] { locald.hKK() + "Value()" + locald.getDesc() }));
    }
    TgE = ak.b(ak.b(ak.b(ak.b(ak.b((Set)localObject1, (Iterable)kotlin.l.b.a.b.d.b.v.s("List", new String[] { "sort(Ljava/util/Comparator;)V" })), (Iterable)kotlin.l.b.a.b.d.b.v.r("String", new String[] { "codePointAt(I)I", "codePointBefore(I)I", "codePointCount(II)I", "compareToIgnoreCase(Ljava/lang/String;)I", "concat(Ljava/lang/String;)Ljava/lang/String;", "contains(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/StringBuffer;)Z", "endsWith(Ljava/lang/String;)Z", "equalsIgnoreCase(Ljava/lang/String;)Z", "getBytes()[B", "getBytes(II[BI)V", "getBytes(Ljava/lang/String;)[B", "getBytes(Ljava/nio/charset/Charset;)[B", "getChars(II[CI)V", "indexOf(I)I", "indexOf(II)I", "indexOf(Ljava/lang/String;)I", "indexOf(Ljava/lang/String;I)I", "intern()Ljava/lang/String;", "isEmpty()Z", "lastIndexOf(I)I", "lastIndexOf(II)I", "lastIndexOf(Ljava/lang/String;)I", "lastIndexOf(Ljava/lang/String;I)I", "matches(Ljava/lang/String;)Z", "offsetByCodePoints(II)I", "regionMatches(ILjava/lang/String;II)Z", "regionMatches(ZILjava/lang/String;II)Z", "replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(CC)Ljava/lang/String;", "replaceFirst(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;", "split(Ljava/lang/String;I)[Ljava/lang/String;", "split(Ljava/lang/String;)[Ljava/lang/String;", "startsWith(Ljava/lang/String;I)Z", "startsWith(Ljava/lang/String;)Z", "substring(II)Ljava/lang/String;", "substring(I)Ljava/lang/String;", "toCharArray()[C", "toLowerCase()Ljava/lang/String;", "toLowerCase(Ljava/util/Locale;)Ljava/lang/String;", "toUpperCase()Ljava/lang/String;", "toUpperCase(Ljava/util/Locale;)Ljava/lang/String;", "trim()Ljava/lang/String;", "isBlank()Z", "lines()Ljava/util/stream/Stream;", "repeat(I)Ljava/lang/String;" })), (Iterable)kotlin.l.b.a.b.d.b.v.r("Double", new String[] { "isInfinite()Z", "isNaN()Z" })), (Iterable)kotlin.l.b.a.b.d.b.v.r("Float", new String[] { "isInfinite()Z", "isNaN()Z" })), (Iterable)kotlin.l.b.a.b.d.b.v.r("Enum", new String[] { "getDeclaringClass()Ljava/lang/Class;", "finalize()V" }));
    localObject1 = kotlin.l.b.a.b.d.b.v.TvS;
    TgF = ak.b(ak.b(ak.b(ak.b(ak.b(ak.b((Set)kotlin.l.b.a.b.d.b.v.r("CharSequence", new String[] { "codePoints()Ljava/util/stream/IntStream;", "chars()Ljava/util/stream/IntStream;" }), (Iterable)kotlin.l.b.a.b.d.b.v.s("Iterator", new String[] { "forEachRemaining(Ljava/util/function/Consumer;)V" })), (Iterable)kotlin.l.b.a.b.d.b.v.r("Iterable", new String[] { "forEach(Ljava/util/function/Consumer;)V", "spliterator()Ljava/util/Spliterator;" })), (Iterable)kotlin.l.b.a.b.d.b.v.r("Throwable", new String[] { "setStackTrace([Ljava/lang/StackTraceElement;)V", "fillInStackTrace()Ljava/lang/Throwable;", "getLocalizedMessage()Ljava/lang/String;", "printStackTrace()V", "printStackTrace(Ljava/io/PrintStream;)V", "printStackTrace(Ljava/io/PrintWriter;)V", "getStackTrace()[Ljava/lang/StackTraceElement;", "initCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "getSuppressed()[Ljava/lang/Throwable;", "addSuppressed(Ljava/lang/Throwable;)V" })), (Iterable)kotlin.l.b.a.b.d.b.v.s("Collection", new String[] { "spliterator()Ljava/util/Spliterator;", "parallelStream()Ljava/util/stream/Stream;", "stream()Ljava/util/stream/Stream;", "removeIf(Ljava/util/function/Predicate;)Z" })), (Iterable)kotlin.l.b.a.b.d.b.v.s("List", new String[] { "replaceAll(Ljava/util/function/UnaryOperator;)V" })), (Iterable)kotlin.l.b.a.b.d.b.v.s("Map", new String[] { "getOrDefault(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "forEach(Ljava/util/function/BiConsumer;)V", "replaceAll(Ljava/util/function/BiFunction;)V", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;" }));
    localObject1 = kotlin.l.b.a.b.d.b.v.TvS;
    TgG = ak.b(ak.b((Set)kotlin.l.b.a.b.d.b.v.s("Collection", new String[] { "removeIf(Ljava/util/function/Predicate;)Z" }), (Iterable)kotlin.l.b.a.b.d.b.v.s("List", new String[] { "replaceAll(Ljava/util/function/UnaryOperator;)V", "sort(Ljava/util/Comparator;)V" })), (Iterable)kotlin.l.b.a.b.d.b.v.s("Map", new String[] { "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove(Ljava/lang/Object;Ljava/lang/Object;)Z", "replaceAll(Ljava/util/function/BiFunction;)V", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z" }));
    localObject1 = kotlin.l.b.a.b.d.b.v.TvS;
    localObject1 = a.hAo();
    localObject2 = kotlin.l.b.a.b.d.b.v.aj(new String[] { "D" });
    localObject1 = ak.b((Set)localObject1, (Iterable)kotlin.l.b.a.b.d.b.v.r("Float", (String[])Arrays.copyOf((Object[])localObject2, localObject2.length)));
    localObject2 = kotlin.l.b.a.b.d.b.v.aj(new String[] { "[C", "[CII", "[III", "[BIILjava/lang/String;", "[BIILjava/nio/charset/Charset;", "[BLjava/lang/String;", "[BLjava/nio/charset/Charset;", "[BII", "[B", "Ljava/lang/StringBuffer;", "Ljava/lang/StringBuilder;" });
    TgH = ak.b((Set)localObject1, (Iterable)kotlin.l.b.a.b.d.b.v.r("String", (String[])Arrays.copyOf((Object[])localObject2, localObject2.length)));
    localObject1 = kotlin.l.b.a.b.d.b.v.TvS;
    localObject1 = kotlin.l.b.a.b.d.b.v.aj(new String[] { "Ljava/lang/String;Ljava/lang/Throwable;ZZ" });
    TgI = (Set)kotlin.l.b.a.b.d.b.v.r("Throwable", (String[])Arrays.copyOf((Object[])localObject1, localObject1.length));
    AppMethodBeat.o(56812);
  }
  
  public h(kotlin.l.b.a.b.b.y paramy, final kotlin.l.b.a.b.l.j paramj, kotlin.g.a.a<? extends kotlin.l.b.a.b.b.y> parama, kotlin.g.a.a<Boolean> parama1)
  {
    AppMethodBeat.i(56823);
    this.Tge = paramy;
    this.Tgw = c.TfZ;
    this.Tgx = kotlin.g.ah(parama);
    this.Tgy = kotlin.g.ah(parama1);
    paramy = new d(this, this.Tge, new kotlin.l.b.a.b.f.b("java.io"));
    parama = kotlin.a.j.listOf(new ae(paramj, (kotlin.g.a.a)new e(this)));
    paramy = new kotlin.l.b.a.b.b.c.h((l)paramy, kotlin.l.b.a.b.f.f.btY("Serializable"), w.Thr, kotlin.l.b.a.b.b.f.Thf, (Collection)parama, an.ThK, paramj);
    paramy.a((kotlin.l.b.a.b.j.f.h)kotlin.l.b.a.b.j.f.h.b.TKa, (Set)kotlin.a.x.SXt, null);
    paramy = paramy.hAG();
    p.g(paramy, "mockSerializableClass.defaultType");
    this.Tgz = ((ab)paramy);
    this.TgA = paramj.al((kotlin.g.a.a)new c(this, paramj));
    this.TgB = paramj.hLs();
    this.TgC = paramj.al((kotlin.g.a.a)new m(this));
    AppMethodBeat.o(56823);
  }
  
  private final kotlin.l.b.a.b.b.y hAh()
  {
    AppMethodBeat.i(56813);
    kotlin.l.b.a.b.b.y localy = (kotlin.l.b.a.b.b.y)this.Tgx.getValue();
    AppMethodBeat.o(56813);
    return localy;
  }
  
  private final boolean hAi()
  {
    AppMethodBeat.i(56814);
    boolean bool = ((Boolean)this.Tgy.getValue()).booleanValue();
    AppMethodBeat.o(56814);
    return bool;
  }
  
  private final aj hAj()
  {
    AppMethodBeat.i(56815);
    aj localaj = (aj)kotlin.l.b.a.b.l.i.a(this.TgA, cLI[0]);
    AppMethodBeat.o(56815);
    return localaj;
  }
  
  private final kotlin.l.b.a.b.b.a.g hAk()
  {
    AppMethodBeat.i(56816);
    kotlin.l.b.a.b.b.a.g localg = (kotlin.l.b.a.b.b.a.g)kotlin.l.b.a.b.l.i.a(this.TgC, cLI[1]);
    AppMethodBeat.o(56816);
    return localg;
  }
  
  private final kotlin.l.b.a.b.d.a.c.a.f n(kotlin.l.b.a.b.b.e parame)
  {
    AppMethodBeat.i(56820);
    if (kotlin.l.b.a.b.a.g.f(parame))
    {
      AppMethodBeat.o(56820);
      return null;
    }
    if (!kotlin.l.b.a.b.a.g.d((l)parame))
    {
      AppMethodBeat.o(56820);
      return null;
    }
    parame = kotlin.l.b.a.b.j.d.a.q((l)parame);
    if (!parame.hJi())
    {
      AppMethodBeat.o(56820);
      return null;
    }
    parame = c.c(parame);
    if (parame != null)
    {
      parame = parame.hJd();
      if (parame != null) {}
    }
    else
    {
      AppMethodBeat.o(56820);
      return null;
    }
    p.g(parame, "j2kClassMap.mapKotlinToJ…leFqName() ?: return null");
    kotlin.l.b.a.b.b.e locale = kotlin.l.b.a.b.b.q.a(hAh(), parame, (kotlin.l.b.a.b.c.a.a)kotlin.l.b.a.b.c.a.c.TnF);
    parame = locale;
    if (!(locale instanceof kotlin.l.b.a.b.d.a.c.a.f)) {
      parame = null;
    }
    parame = (kotlin.l.b.a.b.d.a.c.a.f)parame;
    AppMethodBeat.o(56820);
    return parame;
  }
  
  public final Collection<am> a(kotlin.l.b.a.b.f.f paramf, kotlin.l.b.a.b.b.e parame)
  {
    AppMethodBeat.i(56818);
    p.h(paramf, "name");
    p.h(parame, "classDescriptor");
    Object localObject1 = a.TfK;
    int i;
    if ((p.j(paramf, a.hzY())) && ((parame instanceof kotlin.l.b.a.b.k.a.b.e)) && (kotlin.l.b.a.b.a.g.c(parame)))
    {
      localObject1 = ((kotlin.l.b.a.b.k.a.b.e)parame).TKA.TxB;
      p.g(localObject1, "classDescriptor.classProto.functionList");
      localObject1 = (Iterable)localObject1;
      if ((!(localObject1 instanceof Collection)) || (!((Collection)localObject1).isEmpty()))
      {
        localObject1 = ((Iterable)localObject1).iterator();
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (a.h)((Iterator)localObject1).next();
          localObject3 = ((kotlin.l.b.a.b.k.a.b.e)parame).TLm.SZH;
          p.g(localObject2, "functionProto");
          localObject2 = kotlin.l.b.a.b.k.a.x.b((kotlin.l.b.a.b.e.b.c)localObject3, ((a.h)localObject2).Tyk);
          localObject3 = a.TfK;
        } while (!p.j(localObject2, a.hzY()));
      }
      for (i = 1; i != 0; i = 0)
      {
        paramf = (Collection)kotlin.a.v.SXr;
        AppMethodBeat.o(56818);
        return paramf;
      }
      parame = (kotlin.l.b.a.b.k.a.b.e)parame;
      paramf = ((am)kotlin.a.j.i((Iterable)hAj().hAp().b(paramf, (kotlin.l.b.a.b.c.a.a)kotlin.l.b.a.b.c.a.c.TnF))).hBa();
      paramf.h((l)parame);
      paramf.a(az.ThU);
      paramf.G((ab)parame.hAG());
      paramf.b(parame.hAO());
      paramf = paramf.hBg();
      if (paramf == null) {
        p.hyc();
      }
      paramf = (Collection)kotlin.a.j.listOf((am)paramf);
      AppMethodBeat.o(56818);
      return paramf;
    }
    if (!hAi())
    {
      paramf = (Collection)kotlin.a.v.SXr;
      AppMethodBeat.o(56818);
      return paramf;
    }
    localObject1 = (kotlin.g.a.b)new h(paramf);
    Object localObject2 = n(parame);
    if (localObject2 == null) {
      paramf = (Collection)kotlin.a.v.SXr;
    }
    for (;;)
    {
      paramf = (Iterable)paramf;
      localObject1 = (Collection)new ArrayList();
      localObject2 = paramf.iterator();
      if (!((Iterator)localObject2).hasNext()) {
        break label1518;
      }
      localObject3 = (am)((Iterator)localObject2).next();
      paramf = ((am)localObject3).hzx();
      if (paramf != null) {
        break;
      }
      paramf = new kotlin.t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
      AppMethodBeat.o(56818);
      throw paramf;
      localObject3 = kotlin.l.b.a.b.j.d.a.o((l)localObject2);
      paramf = b.TfM;
      paramf = b.hzZ();
      p.h(localObject3, "fqName");
      p.h(paramf, "builtIns");
      localObject3 = c.a((kotlin.l.b.a.b.f.b)localObject3, paramf);
      if (localObject3 == null) {
        paramf = (Collection)kotlin.a.x.SXt;
      }
      for (;;)
      {
        localObject3 = (kotlin.l.b.a.b.b.e)kotlin.a.j.h((Iterable)paramf);
        if (localObject3 != null) {
          break label628;
        }
        paramf = (Collection)kotlin.a.v.SXr;
        break;
        localObject4 = (kotlin.l.b.a.b.f.b)c.TfX.get(kotlin.l.b.a.b.j.d.a.q((l)localObject3));
        if (localObject4 == null)
        {
          paramf = (Collection)ak.setOf(localObject3);
        }
        else
        {
          p.g(localObject4, "readOnlyToMutable[kotlin…eturn setOf(kotlinAnalog)");
          paramf = paramf.a((kotlin.l.b.a.b.f.b)localObject4);
          p.g(paramf, "builtIns.getBuiltInClass…otlinMutableAnalogFqName)");
          paramf = (Collection)kotlin.a.j.listOf(new kotlin.l.b.a.b.b.e[] { localObject3, paramf });
        }
      }
      label628:
      localObject4 = kotlin.l.b.a.b.o.i.TSf;
      localObject4 = (Iterable)paramf;
      paramf = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject4, 10));
      localObject4 = ((Iterable)localObject4).iterator();
      while (((Iterator)localObject4).hasNext()) {
        paramf.add(kotlin.l.b.a.b.j.d.a.o((l)((Iterator)localObject4).next()));
      }
      localObject4 = (Collection)paramf;
      p.h(localObject4, "set");
      paramf = new kotlin.l.b.a.b.o.i((byte)0);
      paramf.addAll((Collection)localObject4);
      boolean bool2 = c.h(parame);
      localObject2 = ((kotlin.l.b.a.b.b.e)this.TgB.b(kotlin.l.b.a.b.j.d.a.o((l)localObject2), (kotlin.g.a.a)new f((kotlin.l.b.a.b.d.a.c.a.f)localObject2, (kotlin.l.b.a.b.b.e)localObject3))).hAM();
      p.g(localObject2, "fakeJavaClassDescriptor.unsubstitutedMemberScope");
      localObject2 = (Iterable)((kotlin.g.a.b)localObject1).invoke(localObject2);
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      label1170:
      label1173:
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        localObject4 = (am)localObject3;
        boolean bool1;
        if ((((am)localObject4).hAA() == kotlin.l.b.a.b.b.b.a.TgW) && (((am)localObject4).hzE().Tig) && (!kotlin.l.b.a.b.a.g.g((l)localObject4)))
        {
          localObject5 = ((am)localObject4).hAy();
          p.g(localObject5, "analogueMember.overriddenDescriptors");
          localObject5 = (Iterable)localObject5;
          Object localObject6;
          if ((!(localObject5 instanceof Collection)) || (!((Collection)localObject5).isEmpty()))
          {
            localObject5 = ((Iterable)localObject5).iterator();
            while (((Iterator)localObject5).hasNext())
            {
              localObject6 = (kotlin.l.b.a.b.b.t)((Iterator)localObject5).next();
              p.g(localObject6, "it");
              localObject6 = ((kotlin.l.b.a.b.b.t)localObject6).hzx();
              p.g(localObject6, "it.containingDeclaration");
              if (paramf.contains(kotlin.l.b.a.b.j.d.a.o((l)localObject6))) {
                i = 1;
              }
            }
          }
          for (;;)
          {
            if (i == 0)
            {
              localObject5 = ((am)localObject4).hzx();
              if (localObject5 == null)
              {
                paramf = new kotlin.t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                AppMethodBeat.o(56818);
                throw paramf;
                i = 0;
              }
              else
              {
                localObject5 = (kotlin.l.b.a.b.b.e)localObject5;
                localObject6 = kotlin.l.b.a.b.d.b.t.a((kotlin.l.b.a.b.b.t)localObject4, false, false, 3);
                Set localSet = TgG;
                kotlin.l.b.a.b.d.b.v localv = kotlin.l.b.a.b.d.b.v.TvS;
                if ((localSet.contains(kotlin.l.b.a.b.d.b.v.a((kotlin.l.b.a.b.b.e)localObject5, (String)localObject6)) ^ bool2))
                {
                  bool1 = true;
                  label1098:
                  if (bool1) {
                    break label1170;
                  }
                }
              }
            }
          }
        }
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label1173;
          }
          ((Collection)localObject1).add(localObject3);
          break;
          localObject4 = kotlin.l.b.a.b.o.b.a((Collection)kotlin.a.j.listOf(localObject4), (b.b)k.TgV, (kotlin.g.a.b)new l(this));
          p.g(localObject4, "DFS.ifAny<CallableMember…lassDescriptor)\n        }");
          bool1 = ((Boolean)localObject4).booleanValue();
          break label1098;
        }
      }
      paramf = (Collection)localObject1;
    }
    paramf = ((am)localObject3).c(j.a((kotlin.l.b.a.b.b.e)paramf, parame).hLJ());
    if (paramf == null)
    {
      paramf = new kotlin.t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.SimpleFunctionDescriptor");
      AppMethodBeat.o(56818);
      throw paramf;
    }
    paramf = ((am)paramf).hBa();
    paramf.h((l)parame);
    paramf.b(parame.hAO());
    paramf.hBc();
    Object localObject4 = (kotlin.l.b.a.b.b.t)localObject3;
    Object localObject3 = ((kotlin.l.b.a.b.b.t)localObject4).hzx();
    if (localObject3 == null)
    {
      paramf = new kotlin.t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
      AppMethodBeat.o(56818);
      throw paramf;
    }
    localObject3 = (kotlin.l.b.a.b.b.e)localObject3;
    localObject4 = kotlin.l.b.a.b.d.b.t.a((kotlin.l.b.a.b.b.t)localObject4, false, false, 3);
    Object localObject5 = new z.f();
    ((z.f)localObject5).SYG = null;
    localObject3 = kotlin.l.b.a.b.o.b.a((Collection)kotlin.a.j.listOf(localObject3), (b.b)new i(this), (b.c)new j((String)localObject4, (z.f)localObject5));
    p.g(localObject3, "DFS.dfs<ClassDescriptor,…CONSIDERED\n            })");
    localObject3 = (b)localObject3;
    switch (i.$EnumSwitchMapping$0[localObject3.ordinal()])
    {
    default: 
      label1432:
      paramf = paramf.hBg();
      if (paramf == null) {
        p.hyc();
      }
      paramf = (am)paramf;
    }
    while (paramf != null)
    {
      ((Collection)localObject1).add(paramf);
      break;
      if (kotlin.l.b.a.b.b.x.p(parame))
      {
        paramf = null;
      }
      else
      {
        p.g(paramf.hBf(), "setHiddenForResolutionEverywhereBesideSupercalls()");
        break label1432;
        p.g(paramf.a(hAk()), "setAdditionalAnnotations(notConsideredDeprecation)");
        break label1432;
        paramf = null;
      }
    }
    label1518:
    paramf = (Collection)localObject1;
    AppMethodBeat.o(56818);
    return paramf;
  }
  
  public final boolean a(kotlin.l.b.a.b.b.e parame, am paramam)
  {
    AppMethodBeat.i(56822);
    p.h(parame, "classDescriptor");
    p.h(paramam, "functionDescriptor");
    Object localObject = n(parame);
    if (localObject == null)
    {
      AppMethodBeat.o(56822);
      return true;
    }
    if (!paramam.hzL().h(kotlin.l.b.a.b.b.b.d.hBQ()))
    {
      AppMethodBeat.o(56822);
      return true;
    }
    if (!hAi())
    {
      AppMethodBeat.o(56822);
      return false;
    }
    parame = kotlin.l.b.a.b.d.b.t.a((kotlin.l.b.a.b.b.t)paramam, false, false, 3);
    localObject = ((kotlin.l.b.a.b.d.a.c.a.f)localObject).hDO();
    paramam = paramam.hAH();
    p.g(paramam, "functionDescriptor.name");
    paramam = (Iterable)((kotlin.l.b.a.b.d.a.c.a.g)localObject).b(paramam, (kotlin.l.b.a.b.c.a.a)kotlin.l.b.a.b.c.a.c.TnF);
    if ((!(paramam instanceof Collection)) || (!((Collection)paramam).isEmpty()))
    {
      paramam = paramam.iterator();
      while (paramam.hasNext()) {
        if (p.j(kotlin.l.b.a.b.d.b.t.a((kotlin.l.b.a.b.b.t)paramam.next(), false, false, 3), parame))
        {
          AppMethodBeat.o(56822);
          return true;
        }
      }
    }
    AppMethodBeat.o(56822);
    return false;
  }
  
  public final Collection<ab> l(kotlin.l.b.a.b.b.e parame)
  {
    AppMethodBeat.i(56817);
    p.h(parame, "classDescriptor");
    parame = kotlin.l.b.a.b.j.d.a.q((l)parame);
    if (a.e(parame))
    {
      parame = hAj();
      p.g(parame, "cloneableType");
      parame = (Collection)kotlin.a.j.listOf(new ab[] { (ab)parame, this.Tgz });
      AppMethodBeat.o(56817);
      return parame;
    }
    if (a.d(parame))
    {
      parame = (Collection)kotlin.a.j.listOf(this.Tgz);
      AppMethodBeat.o(56817);
      return parame;
    }
    parame = (Collection)kotlin.a.v.SXr;
    AppMethodBeat.o(56817);
    return parame;
  }
  
  public final Collection<kotlin.l.b.a.b.b.d> o(kotlin.l.b.a.b.b.e parame)
  {
    AppMethodBeat.i(56821);
    p.h(parame, "classDescriptor");
    if ((parame.hzB() != kotlin.l.b.a.b.b.f.The) || (!hAi()))
    {
      parame = (Collection)kotlin.a.v.SXr;
      AppMethodBeat.o(56821);
      return parame;
    }
    kotlin.l.b.a.b.d.a.c.a.f localf = n(parame);
    if (localf == null)
    {
      parame = (Collection)kotlin.a.v.SXr;
      AppMethodBeat.o(56821);
      return parame;
    }
    Object localObject1 = kotlin.l.b.a.b.j.d.a.o((l)localf);
    Object localObject2 = b.TfM;
    Object localObject3 = c.a((kotlin.l.b.a.b.f.b)localObject1, b.hzZ());
    if (localObject3 == null)
    {
      parame = (Collection)kotlin.a.v.SXr;
      AppMethodBeat.o(56821);
      return parame;
    }
    localObject2 = j.a((kotlin.l.b.a.b.b.e)localObject3, (kotlin.l.b.a.b.b.e)localf).hLJ();
    Object localObject4 = new g((kotlin.l.b.a.b.m.ba)localObject2);
    localObject1 = (Iterable)localf.hDP();
    Object localObject5 = (Collection)new ArrayList();
    Object localObject6 = ((Iterable)localObject1).iterator();
    Object localObject7;
    label322:
    label495:
    label500:
    label505:
    label508:
    while (((Iterator)localObject6).hasNext())
    {
      localObject7 = ((Iterator)localObject6).next();
      kotlin.l.b.a.b.b.d locald = (kotlin.l.b.a.b.b.d)localObject7;
      p.g(locald, "javaConstructor");
      if (locald.hzE().Tig)
      {
        localObject1 = ((kotlin.l.b.a.b.b.e)localObject3).hxW();
        p.g(localObject1, "defaultKotlinVersion.constructors");
        localObject1 = (Iterable)localObject1;
        if ((!(localObject1 instanceof Collection)) || (!((Collection)localObject1).isEmpty()))
        {
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject8 = (kotlin.l.b.a.b.b.d)((Iterator)localObject1).next();
            p.g(localObject8, "it");
            if (((g)localObject4).a((kotlin.l.b.a.b.b.k)localObject8, (kotlin.l.b.a.b.b.k)locald))
            {
              i = 0;
              if (i == 0) {
                break label505;
              }
              localObject1 = (kotlin.l.b.a.b.b.k)locald;
              if (((kotlin.l.b.a.b.b.k)localObject1).hAw().size() != 1) {
                break label500;
              }
              localObject1 = ((kotlin.l.b.a.b.b.k)localObject1).hAw();
              p.g(localObject1, "valueParameters");
              localObject1 = kotlin.a.j.kw((List)localObject1);
              p.g(localObject1, "valueParameters.single()");
              localObject1 = ((av)localObject1).hBy().hKE().hzS();
              if (localObject1 == null) {
                break label495;
              }
              localObject1 = kotlin.l.b.a.b.j.d.a.q((l)localObject1);
              if (!p.j(localObject1, kotlin.l.b.a.b.j.d.a.q((l)parame))) {
                break label500;
              }
              i = 1;
              if ((i != 0) || (kotlin.l.b.a.b.a.g.g((l)locald))) {
                break label505;
              }
              localObject1 = TgH;
              localObject8 = kotlin.l.b.a.b.d.b.v.TvS;
              if (((Set)localObject1).contains(kotlin.l.b.a.b.d.b.v.a((kotlin.l.b.a.b.b.e)localf, kotlin.l.b.a.b.d.b.t.a((kotlin.l.b.a.b.b.t)locald, false, false, 3)))) {
                break label505;
              }
            }
          }
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label508;
        }
        ((Collection)localObject5).add(localObject7);
        break;
        i = 1;
        break label322;
        localObject1 = null;
        break label403;
        i = 0;
        break label419;
      }
    }
    label403:
    label419:
    localObject3 = (Iterable)localObject5;
    localObject1 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (kotlin.l.b.a.b.b.d)((Iterator)localObject3).next();
      localObject5 = ((kotlin.l.b.a.b.b.d)localObject4).hBa();
      ((t.a)localObject5).h((l)parame);
      ((t.a)localObject5).G((ab)parame.hAG());
      ((t.a)localObject5).hBc();
      ((t.a)localObject5).b(((kotlin.l.b.a.b.m.ba)localObject2).hLK());
      localObject6 = TgI;
      localObject7 = kotlin.l.b.a.b.d.b.v.TvS;
      localObject7 = (kotlin.l.b.a.b.b.e)localf;
      p.g(localObject4, "javaConstructor");
      if (!((Set)localObject6).contains(kotlin.l.b.a.b.d.b.v.a((kotlin.l.b.a.b.b.e)localObject7, kotlin.l.b.a.b.d.b.t.a((kotlin.l.b.a.b.b.t)localObject4, false, false, 3)))) {
        ((t.a)localObject5).a(hAk());
      }
      localObject4 = ((t.a)localObject5).hBg();
      if (localObject4 == null)
      {
        parame = new kotlin.t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassConstructorDescriptor");
        AppMethodBeat.o(56821);
        throw parame;
      }
      ((Collection)localObject1).add((kotlin.l.b.a.b.b.d)localObject4);
    }
    parame = (Collection)localObject1;
    AppMethodBeat.o(56821);
    return parame;
  }
  
  public static final class a
  {
    public static boolean d(kotlin.l.b.a.b.f.c paramc)
    {
      AppMethodBeat.i(56793);
      p.h(paramc, "fqName");
      if (e(paramc))
      {
        AppMethodBeat.o(56793);
        return true;
      }
      c localc = c.TfZ;
      paramc = c.c(paramc);
      if (paramc == null)
      {
        AppMethodBeat.o(56793);
        return false;
      }
      try
      {
        paramc = Class.forName(paramc.hJd().sG());
        boolean bool = Serializable.class.isAssignableFrom(paramc);
        AppMethodBeat.o(56793);
        return bool;
      }
      catch (ClassNotFoundException paramc)
      {
        AppMethodBeat.o(56793);
      }
      return false;
    }
    
    static boolean e(kotlin.l.b.a.b.f.c paramc)
    {
      AppMethodBeat.i(56794);
      if ((p.j(paramc, kotlin.l.b.a.b.a.g.TcO.TcZ)) || (kotlin.l.b.a.b.a.g.b(paramc)))
      {
        AppMethodBeat.o(56794);
        return true;
      }
      AppMethodBeat.o(56794);
      return false;
    }
    
    static Set<String> hAo()
    {
      AppMethodBeat.i(56795);
      Object localObject1 = kotlin.l.b.a.b.d.b.v.TvS;
      Object localObject2 = (Iterable)kotlin.a.j.listOf(new kotlin.l.b.a.b.j.e.d[] { kotlin.l.b.a.b.j.e.d.TIW, kotlin.l.b.a.b.j.e.d.TIY, kotlin.l.b.a.b.j.e.d.TJd, kotlin.l.b.a.b.j.e.d.TJb, kotlin.l.b.a.b.j.e.d.TIY, kotlin.l.b.a.b.j.e.d.TJa, kotlin.l.b.a.b.j.e.d.TJc, kotlin.l.b.a.b.j.e.d.TIZ });
      localObject1 = (Collection)new LinkedHashSet();
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = ((kotlin.l.b.a.b.j.e.d)((Iterator)localObject2).next()).hKL().hJg().sG();
        p.g(str, "it.wrapperFqName.shortName().asString()");
        String[] arrayOfString = kotlin.l.b.a.b.d.b.v.aj(new String[] { "Ljava/lang/String;" });
        kotlin.a.j.a((Collection)localObject1, (Iterable)kotlin.l.b.a.b.d.b.v.r(str, (String[])Arrays.copyOf(arrayOfString, arrayOfString.length)));
      }
      localObject1 = (Set)localObject1;
      AppMethodBeat.o(56795);
      return localObject1;
    }
  }
  
  static enum b
  {
    static
    {
      AppMethodBeat.i(56796);
      b localb1 = new b("BLACK_LIST", 0);
      TgK = localb1;
      b localb2 = new b("WHITE_LIST", 1);
      TgL = localb2;
      b localb3 = new b("NOT_CONSIDERED", 2);
      TgM = localb3;
      b localb4 = new b("DROP", 3);
      TgN = localb4;
      TgO = new b[] { localb1, localb2, localb3, localb4 };
      AppMethodBeat.o(56796);
    }
    
    private b() {}
  }
  
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<aj>
  {
    c(h paramh, kotlin.l.b.a.b.l.j paramj)
    {
      super();
    }
  }
  
  public static final class d
    extends kotlin.l.b.a.b.b.c.y
  {
    d(kotlin.l.b.a.b.b.y paramy, kotlin.l.b.a.b.f.b paramb)
    {
      super(localb);
    }
  }
  
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.a<aj>
  {
    e(h paramh)
    {
      super();
    }
  }
  
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.a<kotlin.l.b.a.b.d.a.c.a.f>
  {
    f(kotlin.l.b.a.b.d.a.c.a.f paramf, kotlin.l.b.a.b.b.e parame)
    {
      super();
    }
  }
  
  static final class g
    extends kotlin.g.b.q
    implements m<kotlin.l.b.a.b.b.k, kotlin.l.b.a.b.b.k, Boolean>
  {
    g(kotlin.l.b.a.b.m.ba paramba)
    {
      super();
    }
    
    public final boolean a(kotlin.l.b.a.b.b.k paramk1, kotlin.l.b.a.b.b.k paramk2)
    {
      AppMethodBeat.i(56804);
      p.h(paramk1, "$this$isEffectivelyTheSameAs");
      p.h(paramk2, "javaConstructor");
      if (kotlin.l.b.a.b.j.i.f((kotlin.l.b.a.b.b.a)paramk1, (kotlin.l.b.a.b.b.a)paramk2.b(this.TgS)) == i.a.a.TIe)
      {
        AppMethodBeat.o(56804);
        return true;
      }
      AppMethodBeat.o(56804);
      return false;
    }
  }
  
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.b<kotlin.l.b.a.b.j.f.h, Collection<? extends am>>
  {
    h(kotlin.l.b.a.b.f.f paramf)
    {
      super();
    }
  }
  
  static final class i<N>
    implements b.b<N>
  {
    i(h paramh) {}
  }
  
  public static final class j
    extends kotlin.l.b.a.b.o.b.a<kotlin.l.b.a.b.b.e, h.b>
  {
    j(String paramString, z.f paramf) {}
  }
  
  static final class k<N>
    implements b.b<N>
  {
    public static final k TgV;
    
    static
    {
      AppMethodBeat.i(56809);
      TgV = new k();
      AppMethodBeat.o(56809);
    }
  }
  
  static final class l
    extends kotlin.g.b.q
    implements kotlin.g.a.b<kotlin.l.b.a.b.b.b, Boolean>
  {
    l(h paramh)
    {
      super();
    }
  }
  
  static final class m
    extends kotlin.g.b.q
    implements kotlin.g.a.a<kotlin.l.b.a.b.b.a.g>
  {
    m(h paramh)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.a.b.h
 * JD-Core Version:    0.7.0.1
 */