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
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.l.b.a.b.a.g.a;
import kotlin.l.b.a.b.b.am;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.az;
import kotlin.l.b.a.b.b.k;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.t.a;
import kotlin.l.b.a.b.b.w;
import kotlin.l.b.a.b.e.a.b;
import kotlin.l.b.a.b.e.a.h;
import kotlin.l.b.a.b.j.i.a.a;
import kotlin.l.b.a.b.m.ae;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.b.a.b.m.at;
import kotlin.l.b.a.b.m.au;
import kotlin.l.b.a.b.o.b.b;
import kotlin.l.b.a.b.o.b.c;

public class h
  implements kotlin.l.b.a.b.b.b.a, kotlin.l.b.a.b.b.b.c
{
  private static final Set<String> aaJA;
  private static final Set<String> aaJB;
  private static final Set<String> aaJC;
  public static final a aaJD;
  private static final Set<String> aaJx;
  private static final Set<String> aaJy;
  private static final Set<String> aaJz;
  private final kotlin.l.b.a.b.b.y aaIY;
  private final c aaJq;
  private final kotlin.f aaJr;
  private final kotlin.f aaJs;
  private final kotlin.l.b.a.b.m.ab aaJt;
  private final kotlin.l.b.a.b.l.f aaJu;
  private final kotlin.l.b.a.b.l.a<kotlin.l.b.a.b.f.b, kotlin.l.b.a.b.b.e> aaJv;
  private final kotlin.l.b.a.b.l.f aaJw;
  
  static
  {
    AppMethodBeat.i(56812);
    cMt = new kotlin.l.n[] { (kotlin.l.n)kotlin.g.b.ab.a(new z(kotlin.g.b.ab.bO(h.class), "cloneableType", "getCloneableType()Lorg/jetbrains/kotlin/types/SimpleType;")), (kotlin.l.n)kotlin.g.b.ab.a(new z(kotlin.g.b.ab.bO(h.class), "notConsideredDeprecation", "getNotConsideredDeprecation()Lorg/jetbrains/kotlin/descriptors/annotations/Annotations;")) };
    aaJD = new a((byte)0);
    Object localObject1 = kotlin.l.b.a.b.d.b.v.aaYI;
    aaJx = ak.c((Set)kotlin.l.b.a.b.d.b.v.r("Collection", new String[] { "toArray()[Ljava/lang/Object;", "toArray([Ljava/lang/Object;)[Ljava/lang/Object;" }), "java/lang/annotation/Annotation.annotationType()Ljava/lang/Class;");
    localObject1 = kotlin.l.b.a.b.d.b.v.aaYI;
    localObject1 = kotlin.l.b.a.b.d.b.v.aaYI;
    Object localObject2 = (Iterable)kotlin.a.j.listOf(new kotlin.l.b.a.b.j.e.d[] { kotlin.l.b.a.b.j.e.d.ably, kotlin.l.b.a.b.j.e.d.ablz });
    localObject1 = (Collection)new LinkedHashSet();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      kotlin.l.b.a.b.j.e.d locald = (kotlin.l.b.a.b.j.e.d)((Iterator)localObject2).next();
      String str = locald.iPb().iNA().qu();
      p.j(str, "it.wrapperFqName.shortName().asString()");
      kotlin.a.j.a((Collection)localObject1, (Iterable)kotlin.l.b.a.b.d.b.v.q(str, new String[] { locald.iPa() + "Value()" + locald.getDesc() }));
    }
    aaJy = ak.b(ak.b(ak.b(ak.b(ak.b((Set)localObject1, (Iterable)kotlin.l.b.a.b.d.b.v.r("List", new String[] { "sort(Ljava/util/Comparator;)V" })), (Iterable)kotlin.l.b.a.b.d.b.v.q("String", new String[] { "codePointAt(I)I", "codePointBefore(I)I", "codePointCount(II)I", "compareToIgnoreCase(Ljava/lang/String;)I", "concat(Ljava/lang/String;)Ljava/lang/String;", "contains(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/StringBuffer;)Z", "endsWith(Ljava/lang/String;)Z", "equalsIgnoreCase(Ljava/lang/String;)Z", "getBytes()[B", "getBytes(II[BI)V", "getBytes(Ljava/lang/String;)[B", "getBytes(Ljava/nio/charset/Charset;)[B", "getChars(II[CI)V", "indexOf(I)I", "indexOf(II)I", "indexOf(Ljava/lang/String;)I", "indexOf(Ljava/lang/String;I)I", "intern()Ljava/lang/String;", "isEmpty()Z", "lastIndexOf(I)I", "lastIndexOf(II)I", "lastIndexOf(Ljava/lang/String;)I", "lastIndexOf(Ljava/lang/String;I)I", "matches(Ljava/lang/String;)Z", "offsetByCodePoints(II)I", "regionMatches(ILjava/lang/String;II)Z", "regionMatches(ZILjava/lang/String;II)Z", "replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(CC)Ljava/lang/String;", "replaceFirst(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;", "split(Ljava/lang/String;I)[Ljava/lang/String;", "split(Ljava/lang/String;)[Ljava/lang/String;", "startsWith(Ljava/lang/String;I)Z", "startsWith(Ljava/lang/String;)Z", "substring(II)Ljava/lang/String;", "substring(I)Ljava/lang/String;", "toCharArray()[C", "toLowerCase()Ljava/lang/String;", "toLowerCase(Ljava/util/Locale;)Ljava/lang/String;", "toUpperCase()Ljava/lang/String;", "toUpperCase(Ljava/util/Locale;)Ljava/lang/String;", "trim()Ljava/lang/String;", "isBlank()Z", "lines()Ljava/util/stream/Stream;", "repeat(I)Ljava/lang/String;" })), (Iterable)kotlin.l.b.a.b.d.b.v.q("Double", new String[] { "isInfinite()Z", "isNaN()Z" })), (Iterable)kotlin.l.b.a.b.d.b.v.q("Float", new String[] { "isInfinite()Z", "isNaN()Z" })), (Iterable)kotlin.l.b.a.b.d.b.v.q("Enum", new String[] { "getDeclaringClass()Ljava/lang/Class;", "finalize()V" }));
    localObject1 = kotlin.l.b.a.b.d.b.v.aaYI;
    aaJz = ak.b(ak.b(ak.b(ak.b(ak.b(ak.b((Set)kotlin.l.b.a.b.d.b.v.q("CharSequence", new String[] { "codePoints()Ljava/util/stream/IntStream;", "chars()Ljava/util/stream/IntStream;" }), (Iterable)kotlin.l.b.a.b.d.b.v.r("Iterator", new String[] { "forEachRemaining(Ljava/util/function/Consumer;)V" })), (Iterable)kotlin.l.b.a.b.d.b.v.q("Iterable", new String[] { "forEach(Ljava/util/function/Consumer;)V", "spliterator()Ljava/util/Spliterator;" })), (Iterable)kotlin.l.b.a.b.d.b.v.q("Throwable", new String[] { "setStackTrace([Ljava/lang/StackTraceElement;)V", "fillInStackTrace()Ljava/lang/Throwable;", "getLocalizedMessage()Ljava/lang/String;", "printStackTrace()V", "printStackTrace(Ljava/io/PrintStream;)V", "printStackTrace(Ljava/io/PrintWriter;)V", "getStackTrace()[Ljava/lang/StackTraceElement;", "initCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "getSuppressed()[Ljava/lang/Throwable;", "addSuppressed(Ljava/lang/Throwable;)V" })), (Iterable)kotlin.l.b.a.b.d.b.v.r("Collection", new String[] { "spliterator()Ljava/util/Spliterator;", "parallelStream()Ljava/util/stream/Stream;", "stream()Ljava/util/stream/Stream;", "removeIf(Ljava/util/function/Predicate;)Z" })), (Iterable)kotlin.l.b.a.b.d.b.v.r("List", new String[] { "replaceAll(Ljava/util/function/UnaryOperator;)V" })), (Iterable)kotlin.l.b.a.b.d.b.v.r("Map", new String[] { "getOrDefault(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "forEach(Ljava/util/function/BiConsumer;)V", "replaceAll(Ljava/util/function/BiFunction;)V", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;" }));
    localObject1 = kotlin.l.b.a.b.d.b.v.aaYI;
    aaJA = ak.b(ak.b((Set)kotlin.l.b.a.b.d.b.v.r("Collection", new String[] { "removeIf(Ljava/util/function/Predicate;)Z" }), (Iterable)kotlin.l.b.a.b.d.b.v.r("List", new String[] { "replaceAll(Ljava/util/function/UnaryOperator;)V", "sort(Ljava/util/Comparator;)V" })), (Iterable)kotlin.l.b.a.b.d.b.v.r("Map", new String[] { "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove(Ljava/lang/Object;Ljava/lang/Object;)Z", "replaceAll(Ljava/util/function/BiFunction;)V", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z" }));
    localObject1 = kotlin.l.b.a.b.d.b.v.aaYI;
    localObject1 = a.iEB();
    localObject2 = kotlin.l.b.a.b.d.b.v.aj(new String[] { "D" });
    localObject1 = ak.b((Set)localObject1, (Iterable)kotlin.l.b.a.b.d.b.v.q("Float", (String[])Arrays.copyOf((Object[])localObject2, localObject2.length)));
    localObject2 = kotlin.l.b.a.b.d.b.v.aj(new String[] { "[C", "[CII", "[III", "[BIILjava/lang/String;", "[BIILjava/nio/charset/Charset;", "[BLjava/lang/String;", "[BLjava/nio/charset/Charset;", "[BII", "[B", "Ljava/lang/StringBuffer;", "Ljava/lang/StringBuilder;" });
    aaJB = ak.b((Set)localObject1, (Iterable)kotlin.l.b.a.b.d.b.v.q("String", (String[])Arrays.copyOf((Object[])localObject2, localObject2.length)));
    localObject1 = kotlin.l.b.a.b.d.b.v.aaYI;
    localObject1 = kotlin.l.b.a.b.d.b.v.aj(new String[] { "Ljava/lang/String;Ljava/lang/Throwable;ZZ" });
    aaJC = (Set)kotlin.l.b.a.b.d.b.v.q("Throwable", (String[])Arrays.copyOf((Object[])localObject1, localObject1.length));
    AppMethodBeat.o(56812);
  }
  
  public h(kotlin.l.b.a.b.b.y paramy, final kotlin.l.b.a.b.l.j paramj, kotlin.g.a.a<? extends kotlin.l.b.a.b.b.y> parama, kotlin.g.a.a<Boolean> parama1)
  {
    AppMethodBeat.i(56823);
    this.aaIY = paramy;
    this.aaJq = c.aaIT;
    this.aaJr = kotlin.g.ar(parama);
    this.aaJs = kotlin.g.ar(parama1);
    paramy = new d(this, this.aaIY, new kotlin.l.b.a.b.f.b("java.io"));
    parama = kotlin.a.j.listOf(new ae(paramj, (kotlin.g.a.a)new e(this)));
    paramy = new kotlin.l.b.a.b.b.c.h((l)paramy, kotlin.l.b.a.b.f.f.bHb("Serializable"), w.aaKl, kotlin.l.b.a.b.b.f.aaJZ, (Collection)parama, an.aaKE, paramj);
    paramy.a((kotlin.l.b.a.b.j.f.h)kotlin.l.b.a.b.j.f.h.b.abmC, (Set)kotlin.a.x.aaAf, null);
    paramy = paramy.iET();
    p.j(paramy, "mockSerializableClass.defaultType");
    this.aaJt = ((kotlin.l.b.a.b.m.ab)paramy);
    this.aaJu = paramj.av((kotlin.g.a.a)new c(this, paramj));
    this.aaJv = paramj.iPK();
    this.aaJw = paramj.av((kotlin.g.a.a)new m(this));
    AppMethodBeat.o(56823);
  }
  
  private final kotlin.l.b.a.b.b.y iEu()
  {
    AppMethodBeat.i(56813);
    kotlin.l.b.a.b.b.y localy = (kotlin.l.b.a.b.b.y)this.aaJr.getValue();
    AppMethodBeat.o(56813);
    return localy;
  }
  
  private final boolean iEv()
  {
    AppMethodBeat.i(56814);
    boolean bool = ((Boolean)this.aaJs.getValue()).booleanValue();
    AppMethodBeat.o(56814);
    return bool;
  }
  
  private final aj iEw()
  {
    AppMethodBeat.i(56815);
    aj localaj = (aj)kotlin.l.b.a.b.l.i.a(this.aaJu, cMt[0]);
    AppMethodBeat.o(56815);
    return localaj;
  }
  
  private final kotlin.l.b.a.b.b.a.g iEx()
  {
    AppMethodBeat.i(56816);
    kotlin.l.b.a.b.b.a.g localg = (kotlin.l.b.a.b.b.a.g)kotlin.l.b.a.b.l.i.a(this.aaJw, cMt[1]);
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
    if (!parame.iNC())
    {
      AppMethodBeat.o(56820);
      return null;
    }
    parame = c.c(parame);
    if (parame != null)
    {
      parame = parame.iNx();
      if (parame != null) {}
    }
    else
    {
      AppMethodBeat.o(56820);
      return null;
    }
    p.j(parame, "j2kClassMap.mapKotlinToJ…leFqName() ?: return null");
    kotlin.l.b.a.b.b.e locale = kotlin.l.b.a.b.b.q.a(iEu(), parame, (kotlin.l.b.a.b.c.a.a)kotlin.l.b.a.b.c.a.c.aaQz);
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
    p.k(paramf, "name");
    p.k(parame, "classDescriptor");
    Object localObject1 = a.aaIE;
    int i;
    if ((p.h(paramf, a.iEl())) && ((parame instanceof kotlin.l.b.a.b.k.a.b.e)) && (kotlin.l.b.a.b.a.g.c(parame)))
    {
      localObject1 = ((kotlin.l.b.a.b.k.a.b.e)parame).abnd.abas;
      p.j(localObject1, "classDescriptor.classProto.functionList");
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
          localObject3 = ((kotlin.l.b.a.b.k.a.b.e)parame).abnP.aaCB;
          p.j(localObject2, "functionProto");
          localObject2 = kotlin.l.b.a.b.k.a.x.b((kotlin.l.b.a.b.e.b.c)localObject3, ((a.h)localObject2).abbb);
          localObject3 = a.aaIE;
        } while (!p.h(localObject2, a.iEl()));
      }
      for (i = 1; i != 0; i = 0)
      {
        paramf = (Collection)kotlin.a.v.aaAd;
        AppMethodBeat.o(56818);
        return paramf;
      }
      parame = (kotlin.l.b.a.b.k.a.b.e)parame;
      paramf = ((am)kotlin.a.j.i((Iterable)iEw().iEC().b(paramf, (kotlin.l.b.a.b.c.a.a)kotlin.l.b.a.b.c.a.c.aaQz))).iFo();
      paramf.h((l)parame);
      paramf.a(az.aaKO);
      paramf.G((kotlin.l.b.a.b.m.ab)parame.iET());
      paramf.b(parame.iFb());
      paramf = paramf.iFu();
      if (paramf == null) {
        p.iCn();
      }
      paramf = (Collection)kotlin.a.j.listOf((am)paramf);
      AppMethodBeat.o(56818);
      return paramf;
    }
    if (!iEv())
    {
      paramf = (Collection)kotlin.a.v.aaAd;
      AppMethodBeat.o(56818);
      return paramf;
    }
    localObject1 = (kotlin.g.a.b)new h(paramf);
    Object localObject2 = n(parame);
    if (localObject2 == null) {
      paramf = (Collection)kotlin.a.v.aaAd;
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
      paramf = ((am)localObject3).iDJ();
      if (paramf != null) {
        break;
      }
      paramf = new kotlin.t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
      AppMethodBeat.o(56818);
      throw paramf;
      localObject3 = kotlin.l.b.a.b.j.d.a.o((l)localObject2);
      paramf = b.aaIG;
      paramf = b.iEm();
      p.k(localObject3, "fqName");
      p.k(paramf, "builtIns");
      localObject3 = c.a((kotlin.l.b.a.b.f.b)localObject3, paramf);
      if (localObject3 == null) {
        paramf = (Collection)kotlin.a.x.aaAf;
      }
      for (;;)
      {
        localObject3 = (kotlin.l.b.a.b.b.e)kotlin.a.j.h((Iterable)paramf);
        if (localObject3 != null) {
          break label628;
        }
        paramf = (Collection)kotlin.a.v.aaAd;
        break;
        localObject4 = (kotlin.l.b.a.b.f.b)c.aaIR.get(kotlin.l.b.a.b.j.d.a.q((l)localObject3));
        if (localObject4 == null)
        {
          paramf = (Collection)ak.setOf(localObject3);
        }
        else
        {
          p.j(localObject4, "readOnlyToMutable[kotlin…eturn setOf(kotlinAnalog)");
          paramf = paramf.a((kotlin.l.b.a.b.f.b)localObject4);
          p.j(paramf, "builtIns.getBuiltInClass…otlinMutableAnalogFqName)");
          paramf = (Collection)kotlin.a.j.listOf(new kotlin.l.b.a.b.b.e[] { localObject3, paramf });
        }
      }
      label628:
      localObject4 = kotlin.l.b.a.b.o.i.abuE;
      localObject4 = (Iterable)paramf;
      paramf = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject4, 10));
      localObject4 = ((Iterable)localObject4).iterator();
      while (((Iterator)localObject4).hasNext()) {
        paramf.add(kotlin.l.b.a.b.j.d.a.o((l)((Iterator)localObject4).next()));
      }
      localObject4 = (Collection)paramf;
      p.k(localObject4, "set");
      paramf = new kotlin.l.b.a.b.o.i((byte)0);
      paramf.addAll((Collection)localObject4);
      boolean bool2 = c.h(parame);
      localObject2 = ((kotlin.l.b.a.b.b.e)this.aaJv.b(kotlin.l.b.a.b.j.d.a.o((l)localObject2), (kotlin.g.a.a)new f((kotlin.l.b.a.b.d.a.c.a.f)localObject2, (kotlin.l.b.a.b.b.e)localObject3))).iEZ();
      p.j(localObject2, "fakeJavaClassDescriptor.unsubstitutedMemberScope");
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
        if ((((am)localObject4).iEN() == kotlin.l.b.a.b.b.b.a.aaJQ) && (((am)localObject4).iDQ().aaLa) && (!kotlin.l.b.a.b.a.g.g((l)localObject4)))
        {
          localObject5 = ((am)localObject4).iEL();
          p.j(localObject5, "analogueMember.overriddenDescriptors");
          localObject5 = (Iterable)localObject5;
          Object localObject6;
          if ((!(localObject5 instanceof Collection)) || (!((Collection)localObject5).isEmpty()))
          {
            localObject5 = ((Iterable)localObject5).iterator();
            while (((Iterator)localObject5).hasNext())
            {
              localObject6 = (kotlin.l.b.a.b.b.t)((Iterator)localObject5).next();
              p.j(localObject6, "it");
              localObject6 = ((kotlin.l.b.a.b.b.t)localObject6).iDJ();
              p.j(localObject6, "it.containingDeclaration");
              if (paramf.contains(kotlin.l.b.a.b.j.d.a.o((l)localObject6))) {
                i = 1;
              }
            }
          }
          for (;;)
          {
            if (i == 0)
            {
              localObject5 = ((am)localObject4).iDJ();
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
                Set localSet = aaJA;
                kotlin.l.b.a.b.d.b.v localv = kotlin.l.b.a.b.d.b.v.aaYI;
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
          localObject4 = kotlin.l.b.a.b.o.b.a((Collection)kotlin.a.j.listOf(localObject4), (b.b)k.aaJP, (kotlin.g.a.b)new l(this));
          p.j(localObject4, "DFS.ifAny<CallableMember…lassDescriptor)\n        }");
          bool1 = ((Boolean)localObject4).booleanValue();
          break label1098;
        }
      }
      paramf = (Collection)localObject1;
    }
    paramf = ((am)localObject3).c(j.a((kotlin.l.b.a.b.b.e)paramf, parame).iQb());
    if (paramf == null)
    {
      paramf = new kotlin.t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.SimpleFunctionDescriptor");
      AppMethodBeat.o(56818);
      throw paramf;
    }
    paramf = ((am)paramf).iFo();
    paramf.h((l)parame);
    paramf.b(parame.iFb());
    paramf.iFq();
    Object localObject4 = (kotlin.l.b.a.b.b.t)localObject3;
    Object localObject3 = ((kotlin.l.b.a.b.b.t)localObject4).iDJ();
    if (localObject3 == null)
    {
      paramf = new kotlin.t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
      AppMethodBeat.o(56818);
      throw paramf;
    }
    localObject3 = (kotlin.l.b.a.b.b.e)localObject3;
    localObject4 = kotlin.l.b.a.b.d.b.t.a((kotlin.l.b.a.b.b.t)localObject4, false, false, 3);
    Object localObject5 = new aa.f();
    ((aa.f)localObject5).aaBC = null;
    localObject3 = kotlin.l.b.a.b.o.b.a((Collection)kotlin.a.j.listOf(localObject3), (b.b)new i(this), (b.c)new j((String)localObject4, (aa.f)localObject5));
    p.j(localObject3, "DFS.dfs<ClassDescriptor,…CONSIDERED\n            })");
    localObject3 = (b)localObject3;
    switch (i.$EnumSwitchMapping$0[localObject3.ordinal()])
    {
    default: 
      label1432:
      paramf = paramf.iFu();
      if (paramf == null) {
        p.iCn();
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
        p.j(paramf.iFt(), "setHiddenForResolutionEverywhereBesideSupercalls()");
        break label1432;
        p.j(paramf.a(iEx()), "setAdditionalAnnotations(notConsideredDeprecation)");
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
    p.k(parame, "classDescriptor");
    p.k(paramam, "functionDescriptor");
    Object localObject = n(parame);
    if (localObject == null)
    {
      AppMethodBeat.o(56822);
      return true;
    }
    if (!paramam.iDY().h(kotlin.l.b.a.b.b.b.d.iGf()))
    {
      AppMethodBeat.o(56822);
      return true;
    }
    if (!iEv())
    {
      AppMethodBeat.o(56822);
      return false;
    }
    parame = kotlin.l.b.a.b.d.b.t.a((kotlin.l.b.a.b.b.t)paramam, false, false, 3);
    localObject = ((kotlin.l.b.a.b.d.a.c.a.f)localObject).iIh();
    paramam = paramam.iEU();
    p.j(paramam, "functionDescriptor.name");
    paramam = (Iterable)((kotlin.l.b.a.b.d.a.c.a.g)localObject).b(paramam, (kotlin.l.b.a.b.c.a.a)kotlin.l.b.a.b.c.a.c.aaQz);
    if ((!(paramam instanceof Collection)) || (!((Collection)paramam).isEmpty()))
    {
      paramam = paramam.iterator();
      while (paramam.hasNext()) {
        if (p.h(kotlin.l.b.a.b.d.b.t.a((kotlin.l.b.a.b.b.t)paramam.next(), false, false, 3), parame))
        {
          AppMethodBeat.o(56822);
          return true;
        }
      }
    }
    AppMethodBeat.o(56822);
    return false;
  }
  
  public final Collection<kotlin.l.b.a.b.m.ab> l(kotlin.l.b.a.b.b.e parame)
  {
    AppMethodBeat.i(56817);
    p.k(parame, "classDescriptor");
    parame = kotlin.l.b.a.b.j.d.a.q((l)parame);
    if (a.e(parame))
    {
      parame = iEw();
      p.j(parame, "cloneableType");
      parame = (Collection)kotlin.a.j.listOf(new kotlin.l.b.a.b.m.ab[] { (kotlin.l.b.a.b.m.ab)parame, this.aaJt });
      AppMethodBeat.o(56817);
      return parame;
    }
    if (a.d(parame))
    {
      parame = (Collection)kotlin.a.j.listOf(this.aaJt);
      AppMethodBeat.o(56817);
      return parame;
    }
    parame = (Collection)kotlin.a.v.aaAd;
    AppMethodBeat.o(56817);
    return parame;
  }
  
  public final Collection<kotlin.l.b.a.b.b.d> o(kotlin.l.b.a.b.b.e parame)
  {
    AppMethodBeat.i(56821);
    p.k(parame, "classDescriptor");
    if ((parame.iDN() != kotlin.l.b.a.b.b.f.aaJY) || (!iEv()))
    {
      parame = (Collection)kotlin.a.v.aaAd;
      AppMethodBeat.o(56821);
      return parame;
    }
    kotlin.l.b.a.b.d.a.c.a.f localf = n(parame);
    if (localf == null)
    {
      parame = (Collection)kotlin.a.v.aaAd;
      AppMethodBeat.o(56821);
      return parame;
    }
    Object localObject1 = kotlin.l.b.a.b.j.d.a.o((l)localf);
    Object localObject2 = b.aaIG;
    Object localObject3 = c.a((kotlin.l.b.a.b.f.b)localObject1, b.iEm());
    if (localObject3 == null)
    {
      parame = (Collection)kotlin.a.v.aaAd;
      AppMethodBeat.o(56821);
      return parame;
    }
    localObject2 = j.a((kotlin.l.b.a.b.b.e)localObject3, (kotlin.l.b.a.b.b.e)localf).iQb();
    Object localObject4 = new g((kotlin.l.b.a.b.m.ba)localObject2);
    localObject1 = (Iterable)localf.iIi();
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
      p.j(locald, "javaConstructor");
      if (locald.iDQ().aaLa)
      {
        localObject1 = ((kotlin.l.b.a.b.b.e)localObject3).iCg();
        p.j(localObject1, "defaultKotlinVersion.constructors");
        localObject1 = (Iterable)localObject1;
        if ((!(localObject1 instanceof Collection)) || (!((Collection)localObject1).isEmpty()))
        {
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject8 = (kotlin.l.b.a.b.b.d)((Iterator)localObject1).next();
            p.j(localObject8, "it");
            if (((g)localObject4).a((k)localObject8, (k)locald))
            {
              i = 0;
              if (i == 0) {
                break label505;
              }
              localObject1 = (k)locald;
              if (((k)localObject1).iEJ().size() != 1) {
                break label500;
              }
              localObject1 = ((k)localObject1).iEJ();
              p.j(localObject1, "valueParameters");
              localObject1 = kotlin.a.j.ls((List)localObject1);
              p.j(localObject1, "valueParameters.single()");
              localObject1 = ((av)localObject1).iFN().iOU().iEf();
              if (localObject1 == null) {
                break label495;
              }
              localObject1 = kotlin.l.b.a.b.j.d.a.q((l)localObject1);
              if (!p.h(localObject1, kotlin.l.b.a.b.j.d.a.q((l)parame))) {
                break label500;
              }
              i = 1;
              if ((i != 0) || (kotlin.l.b.a.b.a.g.g((l)locald))) {
                break label505;
              }
              localObject1 = aaJB;
              localObject8 = kotlin.l.b.a.b.d.b.v.aaYI;
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
      localObject5 = ((kotlin.l.b.a.b.b.d)localObject4).iFo();
      ((t.a)localObject5).h((l)parame);
      ((t.a)localObject5).G((kotlin.l.b.a.b.m.ab)parame.iET());
      ((t.a)localObject5).iFq();
      ((t.a)localObject5).b(((kotlin.l.b.a.b.m.ba)localObject2).iQc());
      localObject6 = aaJC;
      localObject7 = kotlin.l.b.a.b.d.b.v.aaYI;
      localObject7 = (kotlin.l.b.a.b.b.e)localf;
      p.j(localObject4, "javaConstructor");
      if (!((Set)localObject6).contains(kotlin.l.b.a.b.d.b.v.a((kotlin.l.b.a.b.b.e)localObject7, kotlin.l.b.a.b.d.b.t.a((kotlin.l.b.a.b.b.t)localObject4, false, false, 3)))) {
        ((t.a)localObject5).a(iEx());
      }
      localObject4 = ((t.a)localObject5).iFu();
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
      p.k(paramc, "fqName");
      if (e(paramc))
      {
        AppMethodBeat.o(56793);
        return true;
      }
      c localc = c.aaIT;
      paramc = c.c(paramc);
      if (paramc == null)
      {
        AppMethodBeat.o(56793);
        return false;
      }
      try
      {
        paramc = Class.forName(paramc.iNx().qu());
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
      if ((p.h(paramc, kotlin.l.b.a.b.a.g.aaFI.aaFT)) || (kotlin.l.b.a.b.a.g.b(paramc)))
      {
        AppMethodBeat.o(56794);
        return true;
      }
      AppMethodBeat.o(56794);
      return false;
    }
    
    static Set<String> iEB()
    {
      AppMethodBeat.i(56795);
      Object localObject1 = kotlin.l.b.a.b.d.b.v.aaYI;
      Object localObject2 = (Iterable)kotlin.a.j.listOf(new kotlin.l.b.a.b.j.e.d[] { kotlin.l.b.a.b.j.e.d.ably, kotlin.l.b.a.b.j.e.d.ablA, kotlin.l.b.a.b.j.e.d.ablF, kotlin.l.b.a.b.j.e.d.ablD, kotlin.l.b.a.b.j.e.d.ablA, kotlin.l.b.a.b.j.e.d.ablC, kotlin.l.b.a.b.j.e.d.ablE, kotlin.l.b.a.b.j.e.d.ablB });
      localObject1 = (Collection)new LinkedHashSet();
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = ((kotlin.l.b.a.b.j.e.d)((Iterator)localObject2).next()).iPb().iNA().qu();
        p.j(str, "it.wrapperFqName.shortName().asString()");
        String[] arrayOfString = kotlin.l.b.a.b.d.b.v.aj(new String[] { "Ljava/lang/String;" });
        kotlin.a.j.a((Collection)localObject1, (Iterable)kotlin.l.b.a.b.d.b.v.q(str, (String[])Arrays.copyOf(arrayOfString, arrayOfString.length)));
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
      aaJE = localb1;
      b localb2 = new b("WHITE_LIST", 1);
      aaJF = localb2;
      b localb3 = new b("NOT_CONSIDERED", 2);
      aaJG = localb3;
      b localb4 = new b("DROP", 3);
      aaJH = localb4;
      aaJI = new b[] { localb1, localb2, localb3, localb4 };
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
    implements m<k, k, Boolean>
  {
    g(kotlin.l.b.a.b.m.ba paramba)
    {
      super();
    }
    
    public final boolean a(k paramk1, k paramk2)
    {
      AppMethodBeat.i(56804);
      p.k(paramk1, "$this$isEffectivelyTheSameAs");
      p.k(paramk2, "javaConstructor");
      if (kotlin.l.b.a.b.j.i.f((kotlin.l.b.a.b.b.a)paramk1, (kotlin.l.b.a.b.b.a)paramk2.b(this.aaJM)) == i.a.a.abkI)
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
    j(String paramString, aa.f paramf) {}
  }
  
  static final class k<N>
    implements b.b<N>
  {
    public static final k aaJP;
    
    static
    {
      AppMethodBeat.i(56809);
      aaJP = new k();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.a.b.h
 * JD-Core Version:    0.7.0.1
 */