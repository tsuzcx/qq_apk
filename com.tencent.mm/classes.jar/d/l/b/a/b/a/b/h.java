package d.l.b.a.b.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.ak;
import d.g.a.m;
import d.g.b.u;
import d.g.b.v.f;
import d.l.b.a.b.a.g.a;
import d.l.b.a.b.b.am;
import d.l.b.a.b.b.an;
import d.l.b.a.b.b.av;
import d.l.b.a.b.b.az;
import d.l.b.a.b.b.q;
import d.l.b.a.b.b.t.a;
import d.l.b.a.b.e.a.b;
import d.l.b.a.b.e.a.h;
import d.l.b.a.b.j.i.a.a;
import d.l.b.a.b.k.a.n;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.ae;
import d.l.b.a.b.m.aj;
import d.l.b.a.b.m.at;
import d.l.b.a.b.m.au;
import d.l.b.a.b.o.b.b;
import d.l.b.a.b.o.b.c;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class h
  implements d.l.b.a.b.b.b.a, d.l.b.a.b.b.b.c
{
  private static final Set<String> LcV;
  private static final Set<String> LcW;
  private static final Set<String> LcX;
  private static final Set<String> LcY;
  private static final Set<String> LcZ;
  private static final Set<String> Lda;
  public static final a Ldb;
  private final c LcO;
  private final d.f LcP;
  private final d.f LcQ;
  private final ab LcR;
  private final d.l.b.a.b.l.f LcS;
  private final d.l.b.a.b.l.a<d.l.b.a.b.f.b, d.l.b.a.b.b.e> LcT;
  private final d.l.b.a.b.l.f LcU;
  private final d.l.b.a.b.b.y Lcw;
  
  static
  {
    AppMethodBeat.i(56812);
    $$delegatedProperties = new d.l.k[] { (d.l.k)d.g.b.w.a(new u(d.g.b.w.bn(h.class), "ownerModuleDescriptor", "getOwnerModuleDescriptor()Lorg/jetbrains/kotlin/descriptors/ModuleDescriptor;")), (d.l.k)d.g.b.w.a(new u(d.g.b.w.bn(h.class), "isAdditionalBuiltInsFeatureSupported", "isAdditionalBuiltInsFeatureSupported()Z")), (d.l.k)d.g.b.w.a(new u(d.g.b.w.bn(h.class), "cloneableType", "getCloneableType()Lorg/jetbrains/kotlin/types/SimpleType;")), (d.l.k)d.g.b.w.a(new u(d.g.b.w.bn(h.class), "notConsideredDeprecation", "getNotConsideredDeprecation()Lorg/jetbrains/kotlin/descriptors/annotations/Annotations;")) };
    Ldb = new a((byte)0);
    Object localObject1 = d.l.b.a.b.d.b.v.Lsj;
    LcV = ak.c((Set)d.l.b.a.b.d.b.v.s("Collection", new String[] { "toArray()[Ljava/lang/Object;", "toArray([Ljava/lang/Object;)[Ljava/lang/Object;" }), "java/lang/annotation/Annotation.annotationType()Ljava/lang/Class;");
    localObject1 = d.l.b.a.b.d.b.v.Lsj;
    localObject1 = d.l.b.a.b.d.b.v.Lsj;
    Object localObject2 = (Iterable)d.a.j.listOf(new d.l.b.a.b.j.e.d[] { d.l.b.a.b.j.e.d.LFV, d.l.b.a.b.j.e.d.LFW });
    localObject1 = (Collection)new LinkedHashSet();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      d.l.b.a.b.j.e.d locald = (d.l.b.a.b.j.e.d)((Iterator)localObject2).next();
      String str = locald.gbH().fZI().rf();
      d.g.b.k.g(str, "it.wrapperFqName.shortName().asString()");
      d.a.j.a((Collection)localObject1, (Iterable)d.l.b.a.b.d.b.v.r(str, new String[] { locald.gbG() + "Value()" + locald.getDesc() }));
    }
    LcW = ak.a(ak.a(ak.a(ak.a(ak.a((Set)localObject1, (Iterable)d.l.b.a.b.d.b.v.s("List", new String[] { "sort(Ljava/util/Comparator;)V" })), (Iterable)d.l.b.a.b.d.b.v.r("String", new String[] { "codePointAt(I)I", "codePointBefore(I)I", "codePointCount(II)I", "compareToIgnoreCase(Ljava/lang/String;)I", "concat(Ljava/lang/String;)Ljava/lang/String;", "contains(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/StringBuffer;)Z", "endsWith(Ljava/lang/String;)Z", "equalsIgnoreCase(Ljava/lang/String;)Z", "getBytes()[B", "getBytes(II[BI)V", "getBytes(Ljava/lang/String;)[B", "getBytes(Ljava/nio/charset/Charset;)[B", "getChars(II[CI)V", "indexOf(I)I", "indexOf(II)I", "indexOf(Ljava/lang/String;)I", "indexOf(Ljava/lang/String;I)I", "intern()Ljava/lang/String;", "isEmpty()Z", "lastIndexOf(I)I", "lastIndexOf(II)I", "lastIndexOf(Ljava/lang/String;)I", "lastIndexOf(Ljava/lang/String;I)I", "matches(Ljava/lang/String;)Z", "offsetByCodePoints(II)I", "regionMatches(ILjava/lang/String;II)Z", "regionMatches(ZILjava/lang/String;II)Z", "replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(CC)Ljava/lang/String;", "replaceFirst(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;", "split(Ljava/lang/String;I)[Ljava/lang/String;", "split(Ljava/lang/String;)[Ljava/lang/String;", "startsWith(Ljava/lang/String;I)Z", "startsWith(Ljava/lang/String;)Z", "substring(II)Ljava/lang/String;", "substring(I)Ljava/lang/String;", "toCharArray()[C", "toLowerCase()Ljava/lang/String;", "toLowerCase(Ljava/util/Locale;)Ljava/lang/String;", "toUpperCase()Ljava/lang/String;", "toUpperCase(Ljava/util/Locale;)Ljava/lang/String;", "trim()Ljava/lang/String;", "isBlank()Z", "lines()Ljava/util/stream/Stream;", "repeat(I)Ljava/lang/String;" })), (Iterable)d.l.b.a.b.d.b.v.r("Double", new String[] { "isInfinite()Z", "isNaN()Z" })), (Iterable)d.l.b.a.b.d.b.v.r("Float", new String[] { "isInfinite()Z", "isNaN()Z" })), (Iterable)d.l.b.a.b.d.b.v.r("Enum", new String[] { "getDeclaringClass()Ljava/lang/Class;", "finalize()V" }));
    localObject1 = d.l.b.a.b.d.b.v.Lsj;
    LcX = ak.a(ak.a(ak.a(ak.a(ak.a(ak.a((Set)d.l.b.a.b.d.b.v.r("CharSequence", new String[] { "codePoints()Ljava/util/stream/IntStream;", "chars()Ljava/util/stream/IntStream;" }), (Iterable)d.l.b.a.b.d.b.v.s("Iterator", new String[] { "forEachRemaining(Ljava/util/function/Consumer;)V" })), (Iterable)d.l.b.a.b.d.b.v.r("Iterable", new String[] { "forEach(Ljava/util/function/Consumer;)V", "spliterator()Ljava/util/Spliterator;" })), (Iterable)d.l.b.a.b.d.b.v.r("Throwable", new String[] { "setStackTrace([Ljava/lang/StackTraceElement;)V", "fillInStackTrace()Ljava/lang/Throwable;", "getLocalizedMessage()Ljava/lang/String;", "printStackTrace()V", "printStackTrace(Ljava/io/PrintStream;)V", "printStackTrace(Ljava/io/PrintWriter;)V", "getStackTrace()[Ljava/lang/StackTraceElement;", "initCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "getSuppressed()[Ljava/lang/Throwable;", "addSuppressed(Ljava/lang/Throwable;)V" })), (Iterable)d.l.b.a.b.d.b.v.s("Collection", new String[] { "spliterator()Ljava/util/Spliterator;", "parallelStream()Ljava/util/stream/Stream;", "stream()Ljava/util/stream/Stream;", "removeIf(Ljava/util/function/Predicate;)Z" })), (Iterable)d.l.b.a.b.d.b.v.s("List", new String[] { "replaceAll(Ljava/util/function/UnaryOperator;)V" })), (Iterable)d.l.b.a.b.d.b.v.s("Map", new String[] { "getOrDefault(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "forEach(Ljava/util/function/BiConsumer;)V", "replaceAll(Ljava/util/function/BiFunction;)V", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;" }));
    localObject1 = d.l.b.a.b.d.b.v.Lsj;
    LcY = ak.a(ak.a((Set)d.l.b.a.b.d.b.v.s("Collection", new String[] { "removeIf(Ljava/util/function/Predicate;)Z" }), (Iterable)d.l.b.a.b.d.b.v.s("List", new String[] { "replaceAll(Ljava/util/function/UnaryOperator;)V", "sort(Ljava/util/Comparator;)V" })), (Iterable)d.l.b.a.b.d.b.v.s("Map", new String[] { "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove(Ljava/lang/Object;Ljava/lang/Object;)Z", "replaceAll(Ljava/util/function/BiFunction;)V", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z" }));
    localObject1 = d.l.b.a.b.d.b.v.Lsj;
    localObject1 = a.fQM();
    localObject2 = d.l.b.a.b.d.b.v.ag(new String[] { "D" });
    localObject1 = ak.a((Set)localObject1, (Iterable)d.l.b.a.b.d.b.v.r("Float", (String[])Arrays.copyOf((Object[])localObject2, localObject2.length)));
    localObject2 = d.l.b.a.b.d.b.v.ag(new String[] { "[C", "[CII", "[III", "[BIILjava/lang/String;", "[BIILjava/nio/charset/Charset;", "[BLjava/lang/String;", "[BLjava/nio/charset/Charset;", "[BII", "[B", "Ljava/lang/StringBuffer;", "Ljava/lang/StringBuilder;" });
    LcZ = ak.a((Set)localObject1, (Iterable)d.l.b.a.b.d.b.v.r("String", (String[])Arrays.copyOf((Object[])localObject2, localObject2.length)));
    localObject1 = d.l.b.a.b.d.b.v.Lsj;
    localObject1 = d.l.b.a.b.d.b.v.ag(new String[] { "Ljava/lang/String;Ljava/lang/Throwable;ZZ" });
    Lda = (Set)d.l.b.a.b.d.b.v.r("Throwable", (String[])Arrays.copyOf((Object[])localObject1, localObject1.length));
    AppMethodBeat.o(56812);
  }
  
  public h(d.l.b.a.b.b.y paramy, final d.l.b.a.b.l.i parami, d.g.a.a<? extends d.l.b.a.b.b.y> parama, d.g.a.a<Boolean> parama1)
  {
    AppMethodBeat.i(56823);
    this.Lcw = paramy;
    this.LcO = c.Lcr;
    this.LcP = d.g.K(parama);
    this.LcQ = d.g.K(parama1);
    paramy = new d(this, this.Lcw, new d.l.b.a.b.f.b("java.io"));
    parama = d.a.j.listOf(new ae(parami, (d.g.a.a)new e(this)));
    paramy = new d.l.b.a.b.b.c.h((d.l.b.a.b.b.l)paramy, d.l.b.a.b.f.f.aWB("Serializable"), d.l.b.a.b.b.w.LdJ, d.l.b.a.b.b.f.Ldx, (Collection)parama, an.Lec, parami);
    paramy.a((d.l.b.a.b.j.f.h)d.l.b.a.b.j.f.h.b.LGZ, (Set)d.a.x.KTH, null);
    paramy = paramy.fRe();
    d.g.b.k.g(paramy, "mockSerializableClass.defaultType");
    this.LcR = ((ab)paramy);
    this.LcS = parami.O((d.g.a.a)new c(this, parami));
    this.LcT = parami.gco();
    this.LcU = parami.O((d.g.a.a)new m(this));
    AppMethodBeat.o(56823);
  }
  
  private final d.l.b.a.b.b.y fQF()
  {
    AppMethodBeat.i(56813);
    d.l.b.a.b.b.y localy = (d.l.b.a.b.b.y)this.LcP.getValue();
    AppMethodBeat.o(56813);
    return localy;
  }
  
  private final boolean fQG()
  {
    AppMethodBeat.i(56814);
    boolean bool = ((Boolean)this.LcQ.getValue()).booleanValue();
    AppMethodBeat.o(56814);
    return bool;
  }
  
  private final aj fQH()
  {
    AppMethodBeat.i(56815);
    aj localaj = (aj)d.l.b.a.b.l.h.a(this.LcS, $$delegatedProperties[2]);
    AppMethodBeat.o(56815);
    return localaj;
  }
  
  private final d.l.b.a.b.b.a.g fQI()
  {
    AppMethodBeat.i(56816);
    d.l.b.a.b.b.a.g localg = (d.l.b.a.b.b.a.g)d.l.b.a.b.l.h.a(this.LcU, $$delegatedProperties[3]);
    AppMethodBeat.o(56816);
    return localg;
  }
  
  private final d.l.b.a.b.d.a.c.a.f n(d.l.b.a.b.b.e parame)
  {
    AppMethodBeat.i(56820);
    if (d.l.b.a.b.a.g.f(parame))
    {
      AppMethodBeat.o(56820);
      return null;
    }
    if (!d.l.b.a.b.a.g.d((d.l.b.a.b.b.l)parame))
    {
      AppMethodBeat.o(56820);
      return null;
    }
    parame = d.l.b.a.b.j.d.a.q((d.l.b.a.b.b.l)parame);
    if (!parame.fZK())
    {
      AppMethodBeat.o(56820);
      return null;
    }
    parame = c.c(parame);
    if (parame != null)
    {
      parame = parame.fZF();
      if (parame != null) {}
    }
    else
    {
      AppMethodBeat.o(56820);
      return null;
    }
    d.g.b.k.g(parame, "j2kClassMap.mapKotlinToJ…leFqName() ?: return null");
    d.l.b.a.b.b.e locale = q.a(fQF(), parame, (d.l.b.a.b.c.a.a)d.l.b.a.b.c.a.c.LjV);
    parame = locale;
    if (!(locale instanceof d.l.b.a.b.d.a.c.a.f)) {
      parame = null;
    }
    parame = (d.l.b.a.b.d.a.c.a.f)parame;
    AppMethodBeat.o(56820);
    return parame;
  }
  
  public final Collection<am> a(d.l.b.a.b.f.f paramf, d.l.b.a.b.b.e parame)
  {
    AppMethodBeat.i(56818);
    d.g.b.k.h(paramf, "name");
    d.g.b.k.h(parame, "classDescriptor");
    Object localObject1 = a.Lcc;
    int i;
    if ((d.g.b.k.g(paramf, a.fQw())) && ((parame instanceof d.l.b.a.b.k.a.b.e)) && (d.l.b.a.b.a.g.c(parame)))
    {
      localObject1 = ((d.l.b.a.b.k.a.b.e)parame).LHz.LtW;
      d.g.b.k.g(localObject1, "classDescriptor.classProto.functionList");
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
          localObject3 = ((d.l.b.a.b.k.a.b.e)parame).LIl.KVO;
          d.g.b.k.g(localObject2, "functionProto");
          localObject2 = d.l.b.a.b.k.a.x.b((d.l.b.a.b.e.b.c)localObject3, ((a.h)localObject2).LuF);
          localObject3 = a.Lcc;
        } while (!d.g.b.k.g(localObject2, a.fQw()));
      }
      for (i = 1; i != 0; i = 0)
      {
        paramf = (Collection)d.a.v.KTF;
        AppMethodBeat.o(56818);
        return paramf;
      }
      parame = (d.l.b.a.b.k.a.b.e)parame;
      paramf = ((am)d.a.j.f((Iterable)fQH().fQN().b(paramf, (d.l.b.a.b.c.a.a)d.l.b.a.b.c.a.c.LjV))).fRx();
      paramf.h((d.l.b.a.b.b.l)parame);
      paramf.a(az.Lem);
      paramf.H((ab)parame.fRe());
      paramf.b(parame.fRl());
      paramf = paramf.fRD();
      if (paramf == null) {
        d.g.b.k.fOy();
      }
      paramf = (Collection)d.a.j.listOf((am)paramf);
      AppMethodBeat.o(56818);
      return paramf;
    }
    if (!fQG())
    {
      paramf = (Collection)d.a.v.KTF;
      AppMethodBeat.o(56818);
      return paramf;
    }
    Object localObject2 = (d.g.a.b)new h(paramf);
    Object localObject3 = n(parame);
    if (localObject3 == null) {
      paramf = (Collection)d.a.v.KTF;
    }
    for (;;)
    {
      paramf = (Iterable)paramf;
      localObject1 = (Collection)new ArrayList();
      localObject2 = paramf.iterator();
      if (!((Iterator)localObject2).hasNext()) {
        break label1614;
      }
      localObject3 = (am)((Iterator)localObject2).next();
      paramf = ((am)localObject3).fPU();
      if (paramf != null) {
        break;
      }
      paramf = new d.v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
      AppMethodBeat.o(56818);
      throw paramf;
      localObject1 = d.l.b.a.b.j.d.a.o((d.l.b.a.b.b.l)localObject3);
      paramf = b.Lce;
      paramf = b.fQx();
      d.g.b.k.h(localObject1, "fqName");
      d.g.b.k.h(paramf, "builtIns");
      localObject1 = c.a((d.l.b.a.b.f.b)localObject1, paramf);
      if (localObject1 == null)
      {
        localObject1 = (Collection)d.a.x.KTH;
        label518:
        paramf = (Iterable)localObject1;
        d.g.b.k.h(paramf, "$this$lastOrNull");
        if (!(paramf instanceof List)) {
          break label683;
        }
        if (!((List)paramf).isEmpty()) {
          break label659;
        }
        paramf = null;
      }
      for (;;)
      {
        localObject4 = (d.l.b.a.b.b.e)paramf;
        if (localObject4 != null) {
          break label727;
        }
        paramf = (Collection)d.a.v.KTF;
        break;
        localObject4 = (d.l.b.a.b.f.b)c.Lcp.get(d.l.b.a.b.j.d.a.q((d.l.b.a.b.b.l)localObject1));
        if (localObject4 == null)
        {
          localObject1 = (Collection)ak.setOf(localObject1);
          break label518;
        }
        d.g.b.k.g(localObject4, "readOnlyToMutable[kotlin…eturn setOf(kotlinAnalog)");
        paramf = paramf.a((d.l.b.a.b.f.b)localObject4);
        d.g.b.k.g(paramf, "builtIns.getBuiltInClass…otlinMutableAnalogFqName)");
        localObject1 = (Collection)d.a.j.listOf(new d.l.b.a.b.b.e[] { localObject1, paramf });
        break label518;
        label659:
        paramf = ((List)paramf).get(((List)paramf).size() - 1);
        continue;
        label683:
        localObject4 = paramf.iterator();
        if (!((Iterator)localObject4).hasNext()) {
          paramf = null;
        } else {
          do
          {
            paramf = ((Iterator)localObject4).next();
          } while (((Iterator)localObject4).hasNext());
        }
      }
      label727:
      paramf = d.l.b.a.b.o.i.LPk;
      localObject1 = (Iterable)localObject1;
      paramf = (Collection)new ArrayList(d.a.j.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        paramf.add(d.l.b.a.b.j.d.a.o((d.l.b.a.b.b.l)((Iterator)localObject1).next()));
      }
      localObject1 = (Collection)paramf;
      d.g.b.k.h(localObject1, "set");
      paramf = new d.l.b.a.b.o.i((byte)0);
      paramf.addAll((Collection)localObject1);
      boolean bool2 = c.h(parame);
      localObject1 = ((d.l.b.a.b.b.e)this.LcT.b(d.l.b.a.b.j.d.a.o((d.l.b.a.b.b.l)localObject3), (d.g.a.a)new f((d.l.b.a.b.d.a.c.a.f)localObject3, (d.l.b.a.b.b.e)localObject4))).fRj();
      d.g.b.k.g(localObject1, "fakeJavaClassDescriptor.unsubstitutedMemberScope");
      localObject2 = (Iterable)((d.g.a.b)localObject2).ay(localObject1);
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      label1197:
      label1269:
      label1272:
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        localObject4 = (am)localObject3;
        boolean bool1;
        if ((((am)localObject4).fQY() == d.l.b.a.b.b.b.a.Ldo) && (((am)localObject4).fQb().Ley) && (!d.l.b.a.b.a.g.g((d.l.b.a.b.b.l)localObject4)))
        {
          localObject5 = ((am)localObject4).fQW();
          d.g.b.k.g(localObject5, "analogueMember.overriddenDescriptors");
          localObject5 = (Iterable)localObject5;
          Object localObject6;
          if ((!(localObject5 instanceof Collection)) || (!((Collection)localObject5).isEmpty()))
          {
            localObject5 = ((Iterable)localObject5).iterator();
            while (((Iterator)localObject5).hasNext())
            {
              localObject6 = (d.l.b.a.b.b.t)((Iterator)localObject5).next();
              d.g.b.k.g(localObject6, "it");
              localObject6 = ((d.l.b.a.b.b.t)localObject6).fPU();
              d.g.b.k.g(localObject6, "it.containingDeclaration");
              if (paramf.contains(d.l.b.a.b.j.d.a.o((d.l.b.a.b.b.l)localObject6))) {
                i = 1;
              }
            }
          }
          for (;;)
          {
            if (i == 0)
            {
              localObject5 = ((am)localObject4).fPU();
              if (localObject5 == null)
              {
                paramf = new d.v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                AppMethodBeat.o(56818);
                throw paramf;
                i = 0;
              }
              else
              {
                localObject5 = (d.l.b.a.b.b.e)localObject5;
                localObject6 = d.l.b.a.b.d.b.t.a((d.l.b.a.b.b.t)localObject4, false, false, 3);
                Set localSet = LcY;
                d.l.b.a.b.d.b.v localv = d.l.b.a.b.d.b.v.Lsj;
                if ((localSet.contains(d.l.b.a.b.d.b.v.a((d.l.b.a.b.b.e)localObject5, (String)localObject6)) ^ bool2))
                {
                  bool1 = true;
                  if (bool1) {
                    break label1269;
                  }
                }
              }
            }
          }
        }
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label1272;
          }
          ((Collection)localObject1).add(localObject3);
          break;
          localObject4 = d.l.b.a.b.o.b.a((Collection)d.a.j.listOf(localObject4), (b.b)k.Ldn, (d.g.a.b)new l(this));
          d.g.b.k.g(localObject4, "DFS.ifAny<CallableMember…lassDescriptor)\n        }");
          bool1 = ((Boolean)localObject4).booleanValue();
          break label1197;
        }
      }
      paramf = (Collection)localObject1;
    }
    paramf = ((am)localObject3).c(j.a((d.l.b.a.b.b.e)paramf, parame).gcD());
    if (paramf == null)
    {
      paramf = new d.v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.SimpleFunctionDescriptor");
      AppMethodBeat.o(56818);
      throw paramf;
    }
    paramf = ((am)paramf).fRx();
    paramf.h((d.l.b.a.b.b.l)parame);
    paramf.b(parame.fRl());
    paramf.fRz();
    Object localObject4 = (d.l.b.a.b.b.t)localObject3;
    localObject3 = ((d.l.b.a.b.b.t)localObject4).fPU();
    if (localObject3 == null)
    {
      paramf = new d.v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
      AppMethodBeat.o(56818);
      throw paramf;
    }
    localObject3 = (d.l.b.a.b.b.e)localObject3;
    localObject4 = d.l.b.a.b.d.b.t.a((d.l.b.a.b.b.t)localObject4, false, false, 3);
    Object localObject5 = new v.f();
    ((v.f)localObject5).KUQ = null;
    localObject3 = d.l.b.a.b.o.b.a((Collection)d.a.j.listOf(localObject3), (b.b)new i(this), (b.c)new j((String)localObject4, (v.f)localObject5));
    d.g.b.k.g(localObject3, "DFS.dfs<ClassDescriptor,…CONSIDERED\n            })");
    localObject3 = (b)localObject3;
    switch (i.cfA[localObject3.ordinal()])
    {
    default: 
      label1528:
      paramf = paramf.fRD();
      if (paramf == null) {
        d.g.b.k.fOy();
      }
      paramf = (am)paramf;
    }
    while (paramf != null)
    {
      ((Collection)localObject1).add(paramf);
      break;
      if (d.l.b.a.b.b.x.p(parame))
      {
        paramf = null;
      }
      else
      {
        d.g.b.k.g(paramf.fRC(), "setHiddenForResolutionEverywhereBesideSupercalls()");
        break label1528;
        d.g.b.k.g(paramf.a(fQI()), "setAdditionalAnnotations(notConsideredDeprecation)");
        break label1528;
        paramf = null;
      }
    }
    label1614:
    paramf = (Collection)localObject1;
    AppMethodBeat.o(56818);
    return paramf;
  }
  
  public final boolean a(d.l.b.a.b.b.e parame, am paramam)
  {
    AppMethodBeat.i(56822);
    d.g.b.k.h(parame, "classDescriptor");
    d.g.b.k.h(paramam, "functionDescriptor");
    Object localObject = n(parame);
    if (localObject == null)
    {
      AppMethodBeat.o(56822);
      return true;
    }
    if (!paramam.fQj().h(d.l.b.a.b.b.b.d.fSn()))
    {
      AppMethodBeat.o(56822);
      return true;
    }
    if (!fQG())
    {
      AppMethodBeat.o(56822);
      return false;
    }
    parame = d.l.b.a.b.d.b.t.a((d.l.b.a.b.b.t)paramam, false, false, 3);
    localObject = ((d.l.b.a.b.d.a.c.a.f)localObject).fUl();
    paramam = paramam.fRf();
    d.g.b.k.g(paramam, "functionDescriptor.name");
    paramam = (Iterable)((d.l.b.a.b.d.a.c.a.g)localObject).b(paramam, (d.l.b.a.b.c.a.a)d.l.b.a.b.c.a.c.LjV);
    if ((!(paramam instanceof Collection)) || (!((Collection)paramam).isEmpty()))
    {
      paramam = paramam.iterator();
      while (paramam.hasNext()) {
        if (d.g.b.k.g(d.l.b.a.b.d.b.t.a((d.l.b.a.b.b.t)paramam.next(), false, false, 3), parame))
        {
          AppMethodBeat.o(56822);
          return true;
        }
      }
    }
    AppMethodBeat.o(56822);
    return false;
  }
  
  public final Collection<ab> l(d.l.b.a.b.b.e parame)
  {
    AppMethodBeat.i(56817);
    d.g.b.k.h(parame, "classDescriptor");
    parame = d.l.b.a.b.j.d.a.q((d.l.b.a.b.b.l)parame);
    if (a.e(parame))
    {
      parame = fQH();
      d.g.b.k.g(parame, "cloneableType");
      parame = (Collection)d.a.j.listOf(new ab[] { (ab)parame, this.LcR });
      AppMethodBeat.o(56817);
      return parame;
    }
    if (a.d(parame))
    {
      parame = (Collection)d.a.j.listOf(this.LcR);
      AppMethodBeat.o(56817);
      return parame;
    }
    parame = (Collection)d.a.v.KTF;
    AppMethodBeat.o(56817);
    return parame;
  }
  
  public final Collection<d.l.b.a.b.b.d> o(d.l.b.a.b.b.e parame)
  {
    AppMethodBeat.i(56821);
    d.g.b.k.h(parame, "classDescriptor");
    if ((parame.fPY() != d.l.b.a.b.b.f.Ldw) || (!fQG()))
    {
      parame = (Collection)d.a.v.KTF;
      AppMethodBeat.o(56821);
      return parame;
    }
    d.l.b.a.b.d.a.c.a.f localf = n(parame);
    if (localf == null)
    {
      parame = (Collection)d.a.v.KTF;
      AppMethodBeat.o(56821);
      return parame;
    }
    Object localObject1 = d.l.b.a.b.j.d.a.o((d.l.b.a.b.b.l)localf);
    Object localObject2 = b.Lce;
    Object localObject3 = c.a((d.l.b.a.b.f.b)localObject1, b.fQx());
    if (localObject3 == null)
    {
      parame = (Collection)d.a.v.KTF;
      AppMethodBeat.o(56821);
      return parame;
    }
    localObject2 = j.a((d.l.b.a.b.b.e)localObject3, (d.l.b.a.b.b.e)localf).gcD();
    Object localObject4 = new g((d.l.b.a.b.m.ba)localObject2);
    localObject1 = (Iterable)localf.fUm();
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
      d.l.b.a.b.b.d locald = (d.l.b.a.b.b.d)localObject7;
      d.g.b.k.g(locald, "javaConstructor");
      if (locald.fQb().Ley)
      {
        localObject1 = ((d.l.b.a.b.b.e)localObject3).fOv();
        d.g.b.k.g(localObject1, "defaultKotlinVersion.constructors");
        localObject1 = (Iterable)localObject1;
        if ((!(localObject1 instanceof Collection)) || (!((Collection)localObject1).isEmpty()))
        {
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject8 = (d.l.b.a.b.b.d)((Iterator)localObject1).next();
            d.g.b.k.g(localObject8, "it");
            if (((g)localObject4).a((d.l.b.a.b.b.k)localObject8, (d.l.b.a.b.b.k)locald))
            {
              i = 0;
              if (i == 0) {
                break label505;
              }
              localObject1 = (d.l.b.a.b.b.k)locald;
              if (((d.l.b.a.b.b.k)localObject1).fQU().size() != 1) {
                break label500;
              }
              localObject1 = ((d.l.b.a.b.b.k)localObject1).fQU();
              d.g.b.k.g(localObject1, "valueParameters");
              localObject1 = d.a.j.iS((List)localObject1);
              d.g.b.k.g(localObject1, "valueParameters.single()");
              localObject1 = ((av)localObject1).fRV().gbz().fQq();
              if (localObject1 == null) {
                break label495;
              }
              localObject1 = d.l.b.a.b.j.d.a.q((d.l.b.a.b.b.l)localObject1);
              if (!d.g.b.k.g(localObject1, d.l.b.a.b.j.d.a.q((d.l.b.a.b.b.l)parame))) {
                break label500;
              }
              i = 1;
              if ((i != 0) || (d.l.b.a.b.a.g.g((d.l.b.a.b.b.l)locald))) {
                break label505;
              }
              localObject1 = LcZ;
              localObject8 = d.l.b.a.b.d.b.v.Lsj;
              if (((Set)localObject1).contains(d.l.b.a.b.d.b.v.a((d.l.b.a.b.b.e)localf, d.l.b.a.b.d.b.t.a((d.l.b.a.b.b.t)locald, false, false, 3)))) {
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
    localObject1 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (d.l.b.a.b.b.d)((Iterator)localObject3).next();
      localObject5 = ((d.l.b.a.b.b.d)localObject4).fRx();
      ((t.a)localObject5).h((d.l.b.a.b.b.l)parame);
      ((t.a)localObject5).H((ab)parame.fRe());
      ((t.a)localObject5).fRz();
      ((t.a)localObject5).b(((d.l.b.a.b.m.ba)localObject2).gcE());
      localObject6 = Lda;
      localObject7 = d.l.b.a.b.d.b.v.Lsj;
      localObject7 = (d.l.b.a.b.b.e)localf;
      d.g.b.k.g(localObject4, "javaConstructor");
      if (!((Set)localObject6).contains(d.l.b.a.b.d.b.v.a((d.l.b.a.b.b.e)localObject7, d.l.b.a.b.d.b.t.a((d.l.b.a.b.b.t)localObject4, false, false, 3)))) {
        ((t.a)localObject5).a(fQI());
      }
      localObject4 = ((t.a)localObject5).fRD();
      if (localObject4 == null)
      {
        parame = new d.v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassConstructorDescriptor");
        AppMethodBeat.o(56821);
        throw parame;
      }
      ((Collection)localObject1).add((d.l.b.a.b.b.d)localObject4);
    }
    parame = (Collection)localObject1;
    AppMethodBeat.o(56821);
    return parame;
  }
  
  public static final class a
  {
    public static boolean d(d.l.b.a.b.f.c paramc)
    {
      AppMethodBeat.i(56793);
      d.g.b.k.h(paramc, "fqName");
      if (e(paramc))
      {
        AppMethodBeat.o(56793);
        return true;
      }
      c localc = c.Lcr;
      paramc = c.c(paramc);
      if (paramc == null)
      {
        AppMethodBeat.o(56793);
        return false;
      }
      try
      {
        paramc = Class.forName(paramc.fZF().rf());
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
    
    static boolean e(d.l.b.a.b.f.c paramc)
    {
      AppMethodBeat.i(56794);
      if ((d.g.b.k.g(paramc, d.l.b.a.b.a.g.KZg.KZr)) || (d.l.b.a.b.a.g.b(paramc)))
      {
        AppMethodBeat.o(56794);
        return true;
      }
      AppMethodBeat.o(56794);
      return false;
    }
    
    static Set<String> fQM()
    {
      AppMethodBeat.i(56795);
      Object localObject1 = d.l.b.a.b.d.b.v.Lsj;
      Object localObject2 = (Iterable)d.a.j.listOf(new d.l.b.a.b.j.e.d[] { d.l.b.a.b.j.e.d.LFV, d.l.b.a.b.j.e.d.LFX, d.l.b.a.b.j.e.d.LGc, d.l.b.a.b.j.e.d.LGa, d.l.b.a.b.j.e.d.LFX, d.l.b.a.b.j.e.d.LFZ, d.l.b.a.b.j.e.d.LGb, d.l.b.a.b.j.e.d.LFY });
      localObject1 = (Collection)new LinkedHashSet();
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = ((d.l.b.a.b.j.e.d)((Iterator)localObject2).next()).gbH().fZI().rf();
        d.g.b.k.g(str, "it.wrapperFqName.shortName().asString()");
        String[] arrayOfString = d.l.b.a.b.d.b.v.ag(new String[] { "Ljava/lang/String;" });
        d.a.j.a((Collection)localObject1, (Iterable)d.l.b.a.b.d.b.v.r(str, (String[])Arrays.copyOf(arrayOfString, arrayOfString.length)));
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
      Ldc = localb1;
      b localb2 = new b("WHITE_LIST", 1);
      Ldd = localb2;
      b localb3 = new b("NOT_CONSIDERED", 2);
      Lde = localb3;
      b localb4 = new b("DROP", 3);
      Ldf = localb4;
      Ldg = new b[] { localb1, localb2, localb3, localb4 };
      AppMethodBeat.o(56796);
    }
    
    private b() {}
  }
  
  static final class c
    extends d.g.b.l
    implements d.g.a.a<aj>
  {
    c(h paramh, d.l.b.a.b.l.i parami)
    {
      super();
    }
  }
  
  public static final class d
    extends d.l.b.a.b.b.c.y
  {
    d(d.l.b.a.b.b.y paramy, d.l.b.a.b.f.b paramb)
    {
      super(localb);
    }
  }
  
  static final class e
    extends d.g.b.l
    implements d.g.a.a<aj>
  {
    e(h paramh)
    {
      super();
    }
  }
  
  static final class f
    extends d.g.b.l
    implements d.g.a.a<d.l.b.a.b.d.a.c.a.f>
  {
    f(d.l.b.a.b.d.a.c.a.f paramf, d.l.b.a.b.b.e parame)
    {
      super();
    }
  }
  
  static final class g
    extends d.g.b.l
    implements m<d.l.b.a.b.b.k, d.l.b.a.b.b.k, Boolean>
  {
    g(d.l.b.a.b.m.ba paramba)
    {
      super();
    }
    
    public final boolean a(d.l.b.a.b.b.k paramk1, d.l.b.a.b.b.k paramk2)
    {
      AppMethodBeat.i(56804);
      d.g.b.k.h(paramk1, "$this$isEffectivelyTheSameAs");
      d.g.b.k.h(paramk2, "javaConstructor");
      if (d.l.b.a.b.j.i.f((d.l.b.a.b.b.a)paramk1, (d.l.b.a.b.b.a)paramk2.b(this.Ldk)) == i.a.a.LFe)
      {
        AppMethodBeat.o(56804);
        return true;
      }
      AppMethodBeat.o(56804);
      return false;
    }
  }
  
  static final class h
    extends d.g.b.l
    implements d.g.a.b<d.l.b.a.b.j.f.h, Collection<? extends am>>
  {
    h(d.l.b.a.b.f.f paramf)
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
    extends d.l.b.a.b.o.b.a<d.l.b.a.b.b.e, h.b>
  {
    j(String paramString, v.f paramf) {}
  }
  
  static final class k<N>
    implements b.b<N>
  {
    public static final k Ldn;
    
    static
    {
      AppMethodBeat.i(56809);
      Ldn = new k();
      AppMethodBeat.o(56809);
    }
  }
  
  static final class l
    extends d.g.b.l
    implements d.g.a.b<d.l.b.a.b.b.b, Boolean>
  {
    l(h paramh)
    {
      super();
    }
  }
  
  static final class m
    extends d.g.b.l
    implements d.g.a.a<d.l.b.a.b.b.a.g>
  {
    m(h paramh)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.a.b.h
 * JD-Core Version:    0.7.0.1
 */