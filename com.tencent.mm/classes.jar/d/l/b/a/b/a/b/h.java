package d.l.b.a.b.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.ak;
import d.g.a.m;
import d.g.b.p;
import d.g.b.y.f;
import d.g.b.z;
import d.l.b.a.b.a.g.a;
import d.l.b.a.b.b.am;
import d.l.b.a.b.b.an;
import d.l.b.a.b.b.av;
import d.l.b.a.b.b.az;
import d.l.b.a.b.b.l;
import d.l.b.a.b.b.t.a;
import d.l.b.a.b.b.w;
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
  private static final Set<String> MTQ;
  private static final Set<String> MTR;
  private static final Set<String> MTS;
  private static final Set<String> MTT;
  private static final Set<String> MTU;
  private static final Set<String> MTV;
  public static final a MTW;
  private final c MTJ;
  private final d.f MTK;
  private final d.f MTL;
  private final ab MTM;
  private final d.l.b.a.b.l.f MTN;
  private final d.l.b.a.b.l.a<d.l.b.a.b.f.b, d.l.b.a.b.b.e> MTO;
  private final d.l.b.a.b.l.f MTP;
  private final d.l.b.a.b.b.y MTr;
  
  static
  {
    AppMethodBeat.i(56812);
    cwV = new d.l.k[] { (d.l.k)z.a(new d.g.b.x(z.bp(h.class), "cloneableType", "getCloneableType()Lorg/jetbrains/kotlin/types/SimpleType;")), (d.l.k)z.a(new d.g.b.x(z.bp(h.class), "notConsideredDeprecation", "getNotConsideredDeprecation()Lorg/jetbrains/kotlin/descriptors/annotations/Annotations;")) };
    MTW = new a((byte)0);
    Object localObject1 = d.l.b.a.b.d.b.v.Njg;
    MTQ = ak.c((Set)d.l.b.a.b.d.b.v.s("Collection", new String[] { "toArray()[Ljava/lang/Object;", "toArray([Ljava/lang/Object;)[Ljava/lang/Object;" }), "java/lang/annotation/Annotation.annotationType()Ljava/lang/Class;");
    localObject1 = d.l.b.a.b.d.b.v.Njg;
    localObject1 = d.l.b.a.b.d.b.v.Njg;
    Object localObject2 = (Iterable)d.a.j.listOf(new d.l.b.a.b.j.e.d[] { d.l.b.a.b.j.e.d.NwT, d.l.b.a.b.j.e.d.NwU });
    localObject1 = (Collection)new LinkedHashSet();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      d.l.b.a.b.j.e.d locald = (d.l.b.a.b.j.e.d)((Iterator)localObject2).next();
      String str = locald.gtg().grh().sD();
      p.g(str, "it.wrapperFqName.shortName().asString()");
      d.a.j.a((Collection)localObject1, (Iterable)d.l.b.a.b.d.b.v.r(str, new String[] { locald.gtf() + "Value()" + locald.getDesc() }));
    }
    MTR = ak.b(ak.b(ak.b(ak.b(ak.b((Set)localObject1, (Iterable)d.l.b.a.b.d.b.v.s("List", new String[] { "sort(Ljava/util/Comparator;)V" })), (Iterable)d.l.b.a.b.d.b.v.r("String", new String[] { "codePointAt(I)I", "codePointBefore(I)I", "codePointCount(II)I", "compareToIgnoreCase(Ljava/lang/String;)I", "concat(Ljava/lang/String;)Ljava/lang/String;", "contains(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/StringBuffer;)Z", "endsWith(Ljava/lang/String;)Z", "equalsIgnoreCase(Ljava/lang/String;)Z", "getBytes()[B", "getBytes(II[BI)V", "getBytes(Ljava/lang/String;)[B", "getBytes(Ljava/nio/charset/Charset;)[B", "getChars(II[CI)V", "indexOf(I)I", "indexOf(II)I", "indexOf(Ljava/lang/String;)I", "indexOf(Ljava/lang/String;I)I", "intern()Ljava/lang/String;", "isEmpty()Z", "lastIndexOf(I)I", "lastIndexOf(II)I", "lastIndexOf(Ljava/lang/String;)I", "lastIndexOf(Ljava/lang/String;I)I", "matches(Ljava/lang/String;)Z", "offsetByCodePoints(II)I", "regionMatches(ILjava/lang/String;II)Z", "regionMatches(ZILjava/lang/String;II)Z", "replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(CC)Ljava/lang/String;", "replaceFirst(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;", "split(Ljava/lang/String;I)[Ljava/lang/String;", "split(Ljava/lang/String;)[Ljava/lang/String;", "startsWith(Ljava/lang/String;I)Z", "startsWith(Ljava/lang/String;)Z", "substring(II)Ljava/lang/String;", "substring(I)Ljava/lang/String;", "toCharArray()[C", "toLowerCase()Ljava/lang/String;", "toLowerCase(Ljava/util/Locale;)Ljava/lang/String;", "toUpperCase()Ljava/lang/String;", "toUpperCase(Ljava/util/Locale;)Ljava/lang/String;", "trim()Ljava/lang/String;", "isBlank()Z", "lines()Ljava/util/stream/Stream;", "repeat(I)Ljava/lang/String;" })), (Iterable)d.l.b.a.b.d.b.v.r("Double", new String[] { "isInfinite()Z", "isNaN()Z" })), (Iterable)d.l.b.a.b.d.b.v.r("Float", new String[] { "isInfinite()Z", "isNaN()Z" })), (Iterable)d.l.b.a.b.d.b.v.r("Enum", new String[] { "getDeclaringClass()Ljava/lang/Class;", "finalize()V" }));
    localObject1 = d.l.b.a.b.d.b.v.Njg;
    MTS = ak.b(ak.b(ak.b(ak.b(ak.b(ak.b((Set)d.l.b.a.b.d.b.v.r("CharSequence", new String[] { "codePoints()Ljava/util/stream/IntStream;", "chars()Ljava/util/stream/IntStream;" }), (Iterable)d.l.b.a.b.d.b.v.s("Iterator", new String[] { "forEachRemaining(Ljava/util/function/Consumer;)V" })), (Iterable)d.l.b.a.b.d.b.v.r("Iterable", new String[] { "forEach(Ljava/util/function/Consumer;)V", "spliterator()Ljava/util/Spliterator;" })), (Iterable)d.l.b.a.b.d.b.v.r("Throwable", new String[] { "setStackTrace([Ljava/lang/StackTraceElement;)V", "fillInStackTrace()Ljava/lang/Throwable;", "getLocalizedMessage()Ljava/lang/String;", "printStackTrace()V", "printStackTrace(Ljava/io/PrintStream;)V", "printStackTrace(Ljava/io/PrintWriter;)V", "getStackTrace()[Ljava/lang/StackTraceElement;", "initCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "getSuppressed()[Ljava/lang/Throwable;", "addSuppressed(Ljava/lang/Throwable;)V" })), (Iterable)d.l.b.a.b.d.b.v.s("Collection", new String[] { "spliterator()Ljava/util/Spliterator;", "parallelStream()Ljava/util/stream/Stream;", "stream()Ljava/util/stream/Stream;", "removeIf(Ljava/util/function/Predicate;)Z" })), (Iterable)d.l.b.a.b.d.b.v.s("List", new String[] { "replaceAll(Ljava/util/function/UnaryOperator;)V" })), (Iterable)d.l.b.a.b.d.b.v.s("Map", new String[] { "getOrDefault(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "forEach(Ljava/util/function/BiConsumer;)V", "replaceAll(Ljava/util/function/BiFunction;)V", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;" }));
    localObject1 = d.l.b.a.b.d.b.v.Njg;
    MTT = ak.b(ak.b((Set)d.l.b.a.b.d.b.v.s("Collection", new String[] { "removeIf(Ljava/util/function/Predicate;)Z" }), (Iterable)d.l.b.a.b.d.b.v.s("List", new String[] { "replaceAll(Ljava/util/function/UnaryOperator;)V", "sort(Ljava/util/Comparator;)V" })), (Iterable)d.l.b.a.b.d.b.v.s("Map", new String[] { "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove(Ljava/lang/Object;Ljava/lang/Object;)Z", "replaceAll(Ljava/util/function/BiFunction;)V", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z" }));
    localObject1 = d.l.b.a.b.d.b.v.Njg;
    localObject1 = a.gik();
    localObject2 = d.l.b.a.b.d.b.v.an(new String[] { "D" });
    localObject1 = ak.b((Set)localObject1, (Iterable)d.l.b.a.b.d.b.v.r("Float", (String[])Arrays.copyOf((Object[])localObject2, localObject2.length)));
    localObject2 = d.l.b.a.b.d.b.v.an(new String[] { "[C", "[CII", "[III", "[BIILjava/lang/String;", "[BIILjava/nio/charset/Charset;", "[BLjava/lang/String;", "[BLjava/nio/charset/Charset;", "[BII", "[B", "Ljava/lang/StringBuffer;", "Ljava/lang/StringBuilder;" });
    MTU = ak.b((Set)localObject1, (Iterable)d.l.b.a.b.d.b.v.r("String", (String[])Arrays.copyOf((Object[])localObject2, localObject2.length)));
    localObject1 = d.l.b.a.b.d.b.v.Njg;
    localObject1 = d.l.b.a.b.d.b.v.an(new String[] { "Ljava/lang/String;Ljava/lang/Throwable;ZZ" });
    MTV = (Set)d.l.b.a.b.d.b.v.r("Throwable", (String[])Arrays.copyOf((Object[])localObject1, localObject1.length));
    AppMethodBeat.o(56812);
  }
  
  public h(d.l.b.a.b.b.y paramy, final d.l.b.a.b.l.j paramj, d.g.a.a<? extends d.l.b.a.b.b.y> parama, d.g.a.a<Boolean> parama1)
  {
    AppMethodBeat.i(56823);
    this.MTr = paramy;
    this.MTJ = c.MTm;
    this.MTK = d.g.O(parama);
    this.MTL = d.g.O(parama1);
    paramy = new d(this, this.MTr, new d.l.b.a.b.f.b("java.io"));
    parama = d.a.j.listOf(new ae(paramj, (d.g.a.a)new e(this)));
    paramy = new d.l.b.a.b.b.c.h((l)paramy, d.l.b.a.b.f.f.bcE("Serializable"), w.MUE, d.l.b.a.b.b.f.MUs, (Collection)parama, an.MUX, paramj);
    paramy.a((d.l.b.a.b.j.f.h)d.l.b.a.b.j.f.h.b.NxX, (Set)d.a.x.MKG, null);
    paramy = paramy.giC();
    p.g(paramy, "mockSerializableClass.defaultType");
    this.MTM = ((ab)paramy);
    this.MTN = paramj.S((d.g.a.a)new c(this, paramj));
    this.MTO = paramj.gtN();
    this.MTP = paramj.S((d.g.a.a)new m(this));
    AppMethodBeat.o(56823);
  }
  
  private final d.l.b.a.b.b.y gid()
  {
    AppMethodBeat.i(56813);
    d.l.b.a.b.b.y localy = (d.l.b.a.b.b.y)this.MTK.getValue();
    AppMethodBeat.o(56813);
    return localy;
  }
  
  private final boolean gie()
  {
    AppMethodBeat.i(56814);
    boolean bool = ((Boolean)this.MTL.getValue()).booleanValue();
    AppMethodBeat.o(56814);
    return bool;
  }
  
  private final aj gif()
  {
    AppMethodBeat.i(56815);
    aj localaj = (aj)d.l.b.a.b.l.i.a(this.MTN, cwV[0]);
    AppMethodBeat.o(56815);
    return localaj;
  }
  
  private final d.l.b.a.b.b.a.g gig()
  {
    AppMethodBeat.i(56816);
    d.l.b.a.b.b.a.g localg = (d.l.b.a.b.b.a.g)d.l.b.a.b.l.i.a(this.MTP, cwV[1]);
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
    if (!d.l.b.a.b.a.g.d((l)parame))
    {
      AppMethodBeat.o(56820);
      return null;
    }
    parame = d.l.b.a.b.j.d.a.q((l)parame);
    if (!parame.grj())
    {
      AppMethodBeat.o(56820);
      return null;
    }
    parame = c.c(parame);
    if (parame != null)
    {
      parame = parame.gre();
      if (parame != null) {}
    }
    else
    {
      AppMethodBeat.o(56820);
      return null;
    }
    p.g(parame, "j2kClassMap.mapKotlinToJ…leFqName() ?: return null");
    d.l.b.a.b.b.e locale = d.l.b.a.b.b.q.a(gid(), parame, (d.l.b.a.b.c.a.a)d.l.b.a.b.c.a.c.NaS);
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
    p.h(paramf, "name");
    p.h(parame, "classDescriptor");
    Object localObject1 = a.MSX;
    int i;
    if ((p.i(paramf, a.ghU())) && ((parame instanceof d.l.b.a.b.k.a.b.e)) && (d.l.b.a.b.a.g.c(parame)))
    {
      localObject1 = ((d.l.b.a.b.k.a.b.e)parame).Nyx.NkT;
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
          localObject3 = ((d.l.b.a.b.k.a.b.e)parame).Nzj.MMU;
          p.g(localObject2, "functionProto");
          localObject2 = d.l.b.a.b.k.a.x.b((d.l.b.a.b.e.b.c)localObject3, ((a.h)localObject2).NlC);
          localObject3 = a.MSX;
        } while (!p.i(localObject2, a.ghU()));
      }
      for (i = 1; i != 0; i = 0)
      {
        paramf = (Collection)d.a.v.MKE;
        AppMethodBeat.o(56818);
        return paramf;
      }
      parame = (d.l.b.a.b.k.a.b.e)parame;
      paramf = ((am)d.a.j.f((Iterable)gif().gil().b(paramf, (d.l.b.a.b.c.a.a)d.l.b.a.b.c.a.c.NaS))).giW();
      paramf.h((l)parame);
      paramf.a(az.MVh);
      paramf.H((ab)parame.giC());
      paramf.b(parame.giK());
      paramf = paramf.gjc();
      if (paramf == null) {
        p.gfZ();
      }
      paramf = (Collection)d.a.j.listOf((am)paramf);
      AppMethodBeat.o(56818);
      return paramf;
    }
    if (!gie())
    {
      paramf = (Collection)d.a.v.MKE;
      AppMethodBeat.o(56818);
      return paramf;
    }
    Object localObject2 = (d.g.a.b)new h(paramf);
    Object localObject3 = n(parame);
    if (localObject3 == null) {
      paramf = (Collection)d.a.v.MKE;
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
      paramf = ((am)localObject3).ghs();
      if (paramf != null) {
        break;
      }
      paramf = new d.v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
      AppMethodBeat.o(56818);
      throw paramf;
      localObject1 = d.l.b.a.b.j.d.a.o((l)localObject3);
      paramf = b.MSZ;
      paramf = b.ghV();
      p.h(localObject1, "fqName");
      p.h(paramf, "builtIns");
      localObject1 = c.a((d.l.b.a.b.f.b)localObject1, paramf);
      if (localObject1 == null)
      {
        localObject1 = (Collection)d.a.x.MKG;
        label518:
        paramf = (Iterable)localObject1;
        p.h(paramf, "$this$lastOrNull");
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
        paramf = (Collection)d.a.v.MKE;
        break;
        localObject4 = (d.l.b.a.b.f.b)c.MTk.get(d.l.b.a.b.j.d.a.q((l)localObject1));
        if (localObject4 == null)
        {
          localObject1 = (Collection)ak.setOf(localObject1);
          break label518;
        }
        p.g(localObject4, "readOnlyToMutable[kotlin…eturn setOf(kotlinAnalog)");
        paramf = paramf.a((d.l.b.a.b.f.b)localObject4);
        p.g(paramf, "builtIns.getBuiltInClass…otlinMutableAnalogFqName)");
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
      paramf = d.l.b.a.b.o.i.NGf;
      localObject1 = (Iterable)localObject1;
      paramf = (Collection)new ArrayList(d.a.j.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        paramf.add(d.l.b.a.b.j.d.a.o((l)((Iterator)localObject1).next()));
      }
      localObject1 = (Collection)paramf;
      p.h(localObject1, "set");
      paramf = new d.l.b.a.b.o.i((byte)0);
      paramf.addAll((Collection)localObject1);
      boolean bool2 = c.h(parame);
      localObject1 = ((d.l.b.a.b.b.e)this.MTO.b(d.l.b.a.b.j.d.a.o((l)localObject3), (d.g.a.a)new f((d.l.b.a.b.d.a.c.a.f)localObject3, (d.l.b.a.b.b.e)localObject4))).giI();
      p.g(localObject1, "fakeJavaClassDescriptor.unsubstitutedMemberScope");
      localObject2 = (Iterable)((d.g.a.b)localObject2).invoke(localObject1);
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
        if ((((am)localObject4).giw() == d.l.b.a.b.b.b.a.MUj) && (((am)localObject4).ghz().MVt) && (!d.l.b.a.b.a.g.g((l)localObject4)))
        {
          localObject5 = ((am)localObject4).giu();
          p.g(localObject5, "analogueMember.overriddenDescriptors");
          localObject5 = (Iterable)localObject5;
          Object localObject6;
          if ((!(localObject5 instanceof Collection)) || (!((Collection)localObject5).isEmpty()))
          {
            localObject5 = ((Iterable)localObject5).iterator();
            while (((Iterator)localObject5).hasNext())
            {
              localObject6 = (d.l.b.a.b.b.t)((Iterator)localObject5).next();
              p.g(localObject6, "it");
              localObject6 = ((d.l.b.a.b.b.t)localObject6).ghs();
              p.g(localObject6, "it.containingDeclaration");
              if (paramf.contains(d.l.b.a.b.j.d.a.o((l)localObject6))) {
                i = 1;
              }
            }
          }
          for (;;)
          {
            if (i == 0)
            {
              localObject5 = ((am)localObject4).ghs();
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
                Set localSet = MTT;
                d.l.b.a.b.d.b.v localv = d.l.b.a.b.d.b.v.Njg;
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
          localObject4 = d.l.b.a.b.o.b.a((Collection)d.a.j.listOf(localObject4), (b.b)k.MUi, (d.g.a.b)new l(this));
          p.g(localObject4, "DFS.ifAny<CallableMember…lassDescriptor)\n        }");
          bool1 = ((Boolean)localObject4).booleanValue();
          break label1197;
        }
      }
      paramf = (Collection)localObject1;
    }
    paramf = ((am)localObject3).c(j.a((d.l.b.a.b.b.e)paramf, parame).gue());
    if (paramf == null)
    {
      paramf = new d.v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.SimpleFunctionDescriptor");
      AppMethodBeat.o(56818);
      throw paramf;
    }
    paramf = ((am)paramf).giW();
    paramf.h((l)parame);
    paramf.b(parame.giK());
    paramf.giY();
    Object localObject4 = (d.l.b.a.b.b.t)localObject3;
    localObject3 = ((d.l.b.a.b.b.t)localObject4).ghs();
    if (localObject3 == null)
    {
      paramf = new d.v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
      AppMethodBeat.o(56818);
      throw paramf;
    }
    localObject3 = (d.l.b.a.b.b.e)localObject3;
    localObject4 = d.l.b.a.b.d.b.t.a((d.l.b.a.b.b.t)localObject4, false, false, 3);
    Object localObject5 = new y.f();
    ((y.f)localObject5).MLV = null;
    localObject3 = d.l.b.a.b.o.b.a((Collection)d.a.j.listOf(localObject3), (b.b)new i(this), (b.c)new j((String)localObject4, (y.f)localObject5));
    p.g(localObject3, "DFS.dfs<ClassDescriptor,…CONSIDERED\n            })");
    localObject3 = (b)localObject3;
    switch (i.cpQ[localObject3.ordinal()])
    {
    default: 
      label1528:
      paramf = paramf.gjc();
      if (paramf == null) {
        p.gfZ();
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
        p.g(paramf.gjb(), "setHiddenForResolutionEverywhereBesideSupercalls()");
        break label1528;
        p.g(paramf.a(gig()), "setAdditionalAnnotations(notConsideredDeprecation)");
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
    p.h(parame, "classDescriptor");
    p.h(paramam, "functionDescriptor");
    Object localObject = n(parame);
    if (localObject == null)
    {
      AppMethodBeat.o(56822);
      return true;
    }
    if (!paramam.ghH().h(d.l.b.a.b.b.b.d.gjM()))
    {
      AppMethodBeat.o(56822);
      return true;
    }
    if (!gie())
    {
      AppMethodBeat.o(56822);
      return false;
    }
    parame = d.l.b.a.b.d.b.t.a((d.l.b.a.b.b.t)paramam, false, false, 3);
    localObject = ((d.l.b.a.b.d.a.c.a.f)localObject).glK();
    paramam = paramam.giD();
    p.g(paramam, "functionDescriptor.name");
    paramam = (Iterable)((d.l.b.a.b.d.a.c.a.g)localObject).b(paramam, (d.l.b.a.b.c.a.a)d.l.b.a.b.c.a.c.NaS);
    if ((!(paramam instanceof Collection)) || (!((Collection)paramam).isEmpty()))
    {
      paramam = paramam.iterator();
      while (paramam.hasNext()) {
        if (p.i(d.l.b.a.b.d.b.t.a((d.l.b.a.b.b.t)paramam.next(), false, false, 3), parame))
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
    p.h(parame, "classDescriptor");
    parame = d.l.b.a.b.j.d.a.q((l)parame);
    if (a.e(parame))
    {
      parame = gif();
      p.g(parame, "cloneableType");
      parame = (Collection)d.a.j.listOf(new ab[] { (ab)parame, this.MTM });
      AppMethodBeat.o(56817);
      return parame;
    }
    if (a.d(parame))
    {
      parame = (Collection)d.a.j.listOf(this.MTM);
      AppMethodBeat.o(56817);
      return parame;
    }
    parame = (Collection)d.a.v.MKE;
    AppMethodBeat.o(56817);
    return parame;
  }
  
  public final Collection<d.l.b.a.b.b.d> o(d.l.b.a.b.b.e parame)
  {
    AppMethodBeat.i(56821);
    p.h(parame, "classDescriptor");
    if ((parame.ghw() != d.l.b.a.b.b.f.MUr) || (!gie()))
    {
      parame = (Collection)d.a.v.MKE;
      AppMethodBeat.o(56821);
      return parame;
    }
    d.l.b.a.b.d.a.c.a.f localf = n(parame);
    if (localf == null)
    {
      parame = (Collection)d.a.v.MKE;
      AppMethodBeat.o(56821);
      return parame;
    }
    Object localObject1 = d.l.b.a.b.j.d.a.o((l)localf);
    Object localObject2 = b.MSZ;
    Object localObject3 = c.a((d.l.b.a.b.f.b)localObject1, b.ghV());
    if (localObject3 == null)
    {
      parame = (Collection)d.a.v.MKE;
      AppMethodBeat.o(56821);
      return parame;
    }
    localObject2 = j.a((d.l.b.a.b.b.e)localObject3, (d.l.b.a.b.b.e)localf).gue();
    Object localObject4 = new g((d.l.b.a.b.m.ba)localObject2);
    localObject1 = (Iterable)localf.glL();
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
      p.g(locald, "javaConstructor");
      if (locald.ghz().MVt)
      {
        localObject1 = ((d.l.b.a.b.b.e)localObject3).gfV();
        p.g(localObject1, "defaultKotlinVersion.constructors");
        localObject1 = (Iterable)localObject1;
        if ((!(localObject1 instanceof Collection)) || (!((Collection)localObject1).isEmpty()))
        {
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject8 = (d.l.b.a.b.b.d)((Iterator)localObject1).next();
            p.g(localObject8, "it");
            if (((g)localObject4).a((d.l.b.a.b.b.k)localObject8, (d.l.b.a.b.b.k)locald))
            {
              i = 0;
              if (i == 0) {
                break label505;
              }
              localObject1 = (d.l.b.a.b.b.k)locald;
              if (((d.l.b.a.b.b.k)localObject1).gis().size() != 1) {
                break label500;
              }
              localObject1 = ((d.l.b.a.b.b.k)localObject1).gis();
              p.g(localObject1, "valueParameters");
              localObject1 = d.a.j.jg((List)localObject1);
              p.g(localObject1, "valueParameters.single()");
              localObject1 = ((av)localObject1).gju().gsZ().ghO();
              if (localObject1 == null) {
                break label495;
              }
              localObject1 = d.l.b.a.b.j.d.a.q((l)localObject1);
              if (!p.i(localObject1, d.l.b.a.b.j.d.a.q((l)parame))) {
                break label500;
              }
              i = 1;
              if ((i != 0) || (d.l.b.a.b.a.g.g((l)locald))) {
                break label505;
              }
              localObject1 = MTU;
              localObject8 = d.l.b.a.b.d.b.v.Njg;
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
      localObject5 = ((d.l.b.a.b.b.d)localObject4).giW();
      ((t.a)localObject5).h((l)parame);
      ((t.a)localObject5).H((ab)parame.giC());
      ((t.a)localObject5).giY();
      ((t.a)localObject5).b(((d.l.b.a.b.m.ba)localObject2).guf());
      localObject6 = MTV;
      localObject7 = d.l.b.a.b.d.b.v.Njg;
      localObject7 = (d.l.b.a.b.b.e)localf;
      p.g(localObject4, "javaConstructor");
      if (!((Set)localObject6).contains(d.l.b.a.b.d.b.v.a((d.l.b.a.b.b.e)localObject7, d.l.b.a.b.d.b.t.a((d.l.b.a.b.b.t)localObject4, false, false, 3)))) {
        ((t.a)localObject5).a(gig());
      }
      localObject4 = ((t.a)localObject5).gjc();
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
      p.h(paramc, "fqName");
      if (e(paramc))
      {
        AppMethodBeat.o(56793);
        return true;
      }
      c localc = c.MTm;
      paramc = c.c(paramc);
      if (paramc == null)
      {
        AppMethodBeat.o(56793);
        return false;
      }
      try
      {
        paramc = Class.forName(paramc.gre().sD());
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
      if ((p.i(paramc, d.l.b.a.b.a.g.MQb.MQm)) || (d.l.b.a.b.a.g.b(paramc)))
      {
        AppMethodBeat.o(56794);
        return true;
      }
      AppMethodBeat.o(56794);
      return false;
    }
    
    static Set<String> gik()
    {
      AppMethodBeat.i(56795);
      Object localObject1 = d.l.b.a.b.d.b.v.Njg;
      Object localObject2 = (Iterable)d.a.j.listOf(new d.l.b.a.b.j.e.d[] { d.l.b.a.b.j.e.d.NwT, d.l.b.a.b.j.e.d.NwV, d.l.b.a.b.j.e.d.Nxa, d.l.b.a.b.j.e.d.NwY, d.l.b.a.b.j.e.d.NwV, d.l.b.a.b.j.e.d.NwX, d.l.b.a.b.j.e.d.NwZ, d.l.b.a.b.j.e.d.NwW });
      localObject1 = (Collection)new LinkedHashSet();
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = ((d.l.b.a.b.j.e.d)((Iterator)localObject2).next()).gtg().grh().sD();
        p.g(str, "it.wrapperFqName.shortName().asString()");
        String[] arrayOfString = d.l.b.a.b.d.b.v.an(new String[] { "Ljava/lang/String;" });
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
      MTX = localb1;
      b localb2 = new b("WHITE_LIST", 1);
      MTY = localb2;
      b localb3 = new b("NOT_CONSIDERED", 2);
      MTZ = localb3;
      b localb4 = new b("DROP", 3);
      MUa = localb4;
      MUb = new b[] { localb1, localb2, localb3, localb4 };
      AppMethodBeat.o(56796);
    }
    
    private b() {}
  }
  
  static final class c
    extends d.g.b.q
    implements d.g.a.a<aj>
  {
    c(h paramh, d.l.b.a.b.l.j paramj)
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
    extends d.g.b.q
    implements d.g.a.a<aj>
  {
    e(h paramh)
    {
      super();
    }
  }
  
  static final class f
    extends d.g.b.q
    implements d.g.a.a<d.l.b.a.b.d.a.c.a.f>
  {
    f(d.l.b.a.b.d.a.c.a.f paramf, d.l.b.a.b.b.e parame)
    {
      super();
    }
  }
  
  static final class g
    extends d.g.b.q
    implements m<d.l.b.a.b.b.k, d.l.b.a.b.b.k, Boolean>
  {
    g(d.l.b.a.b.m.ba paramba)
    {
      super();
    }
    
    public final boolean a(d.l.b.a.b.b.k paramk1, d.l.b.a.b.b.k paramk2)
    {
      AppMethodBeat.i(56804);
      p.h(paramk1, "$this$isEffectivelyTheSameAs");
      p.h(paramk2, "javaConstructor");
      if (d.l.b.a.b.j.i.f((d.l.b.a.b.b.a)paramk1, (d.l.b.a.b.b.a)paramk2.b(this.MUf)) == i.a.a.Nwc)
      {
        AppMethodBeat.o(56804);
        return true;
      }
      AppMethodBeat.o(56804);
      return false;
    }
  }
  
  static final class h
    extends d.g.b.q
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
    j(String paramString, y.f paramf) {}
  }
  
  static final class k<N>
    implements b.b<N>
  {
    public static final k MUi;
    
    static
    {
      AppMethodBeat.i(56809);
      MUi = new k();
      AppMethodBeat.o(56809);
    }
  }
  
  static final class l
    extends d.g.b.q
    implements d.g.a.b<d.l.b.a.b.b.b, Boolean>
  {
    l(h paramh)
    {
      super();
    }
  }
  
  static final class m
    extends d.g.b.q
    implements d.g.a.a<d.l.b.a.b.b.a.g>
  {
    m(h paramh)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.a.b.h
 * JD-Core Version:    0.7.0.1
 */