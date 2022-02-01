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
import kotlin.a.p;
import kotlin.ak;
import kotlin.g.b.s;
import kotlin.l.b.a.b.a.i;
import kotlin.l.b.a.b.a.k;
import kotlin.l.b.a.b.a.k.a;
import kotlin.l.b.a.b.f.b;
import kotlin.l.b.a.b.f.d;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.f.h;
import kotlin.n.n;

public final class c
{
  public static final c aiEX;
  private static final String aiEY;
  private static final String aiEZ;
  private static final String aiFa;
  private static final String aiFb;
  private static final b aiFc;
  private static final kotlin.l.b.a.b.f.c aiFd;
  private static final b aiFe;
  private static final b aiFf;
  private static final b aiFg;
  private static final HashMap<d, b> aiFh;
  private static final HashMap<d, b> aiFi;
  private static final HashMap<d, kotlin.l.b.a.b.f.c> aiFj;
  private static final HashMap<d, kotlin.l.b.a.b.f.c> aiFk;
  private static final List<c.a> aiFl;
  
  static
  {
    int j = 0;
    AppMethodBeat.i(56767);
    aiEX = new c();
    aiEY = kotlin.l.b.a.b.a.a.c.aiEM.aiEI.toString() + '.' + kotlin.l.b.a.b.a.a.c.aiEM.aiEJ;
    aiEZ = kotlin.l.b.a.b.a.a.c.aiEO.aiEI.toString() + '.' + kotlin.l.b.a.b.a.a.c.aiEO.aiEJ;
    aiFa = kotlin.l.b.a.b.a.a.c.aiEN.aiEI.toString() + '.' + kotlin.l.b.a.b.a.a.c.aiEN.aiEJ;
    aiFb = kotlin.l.b.a.b.a.a.c.aiEP.aiEI.toString() + '.' + kotlin.l.b.a.b.a.a.c.aiEP.aiEJ;
    Object localObject1 = b.s(new kotlin.l.b.a.b.f.c("kotlin.jvm.functions.FunctionN"));
    s.s(localObject1, "topLevel(FqName(\"kotlin.jvm.functions.FunctionN\"))");
    aiFc = (b)localObject1;
    localObject1 = ((b)localObject1).kxQ();
    s.s(localObject1, "FUNCTION_N_CLASS_ID.asSingleFqName()");
    aiFd = (kotlin.l.b.a.b.f.c)localObject1;
    localObject1 = b.s(new kotlin.l.b.a.b.f.c("kotlin.reflect.KFunction"));
    s.s(localObject1, "topLevel(FqName(\"kotlin.reflect.KFunction\"))");
    aiFe = (b)localObject1;
    localObject1 = b.s(new kotlin.l.b.a.b.f.c("kotlin.reflect.KClass"));
    s.s(localObject1, "topLevel(FqName(\"kotlin.reflect.KClass\"))");
    aiFf = (b)localObject1;
    aiFg = aiEX.cF(Class.class);
    aiFh = new HashMap();
    aiFi = new HashMap();
    aiFj = new HashMap();
    aiFk = new HashMap();
    localObject1 = aiEX;
    Object localObject2 = b.s(k.a.aiDl);
    s.s(localObject2, "topLevel(FqNames.iterable)");
    Object localObject3 = k.a.aiDt;
    Object localObject4 = ((b)localObject2).kxL();
    Object localObject5 = ((b)localObject2).kxL();
    s.s(localObject5, "kotlinReadOnly.packageFqName");
    localObject3 = new b((kotlin.l.b.a.b.f.c)localObject4, kotlin.l.b.a.b.f.e.b((kotlin.l.b.a.b.f.c)localObject3, (kotlin.l.b.a.b.f.c)localObject5), false);
    localObject1 = new c.a(((c)localObject1).cF(Iterable.class), (b)localObject2, (b)localObject3);
    localObject2 = aiEX;
    localObject3 = b.s(k.a.aiDk);
    s.s(localObject3, "topLevel(FqNames.iterator)");
    localObject4 = k.a.aiDs;
    localObject5 = ((b)localObject3).kxL();
    Object localObject6 = ((b)localObject3).kxL();
    s.s(localObject6, "kotlinReadOnly.packageFqName");
    localObject4 = new b((kotlin.l.b.a.b.f.c)localObject5, kotlin.l.b.a.b.f.e.b((kotlin.l.b.a.b.f.c)localObject4, (kotlin.l.b.a.b.f.c)localObject6), false);
    localObject2 = new c.a(((c)localObject2).cF(Iterator.class), (b)localObject3, (b)localObject4);
    localObject3 = aiEX;
    localObject4 = b.s(k.a.aiDm);
    s.s(localObject4, "topLevel(FqNames.collection)");
    localObject5 = k.a.aiDu;
    localObject6 = ((b)localObject4).kxL();
    Object localObject7 = ((b)localObject4).kxL();
    s.s(localObject7, "kotlinReadOnly.packageFqName");
    localObject5 = new b((kotlin.l.b.a.b.f.c)localObject6, kotlin.l.b.a.b.f.e.b((kotlin.l.b.a.b.f.c)localObject5, (kotlin.l.b.a.b.f.c)localObject7), false);
    localObject3 = new c.a(((c)localObject3).cF(Collection.class), (b)localObject4, (b)localObject5);
    localObject4 = aiEX;
    localObject5 = b.s(k.a.aiDn);
    s.s(localObject5, "topLevel(FqNames.list)");
    localObject6 = k.a.aiDv;
    localObject7 = ((b)localObject5).kxL();
    Object localObject8 = ((b)localObject5).kxL();
    s.s(localObject8, "kotlinReadOnly.packageFqName");
    localObject6 = new b((kotlin.l.b.a.b.f.c)localObject7, kotlin.l.b.a.b.f.e.b((kotlin.l.b.a.b.f.c)localObject6, (kotlin.l.b.a.b.f.c)localObject8), false);
    localObject4 = new c.a(((c)localObject4).cF(List.class), (b)localObject5, (b)localObject6);
    localObject5 = aiEX;
    localObject6 = b.s(k.a.aiDp);
    s.s(localObject6, "topLevel(FqNames.set)");
    localObject7 = k.a.aiDx;
    localObject8 = ((b)localObject6).kxL();
    Object localObject9 = ((b)localObject6).kxL();
    s.s(localObject9, "kotlinReadOnly.packageFqName");
    localObject7 = new b((kotlin.l.b.a.b.f.c)localObject8, kotlin.l.b.a.b.f.e.b((kotlin.l.b.a.b.f.c)localObject7, (kotlin.l.b.a.b.f.c)localObject9), false);
    localObject5 = new c.a(((c)localObject5).cF(Set.class), (b)localObject6, (b)localObject7);
    localObject6 = aiEX;
    localObject7 = b.s(k.a.aiDo);
    s.s(localObject7, "topLevel(FqNames.listIterator)");
    localObject8 = k.a.aiDw;
    localObject9 = ((b)localObject7).kxL();
    Object localObject10 = ((b)localObject7).kxL();
    s.s(localObject10, "kotlinReadOnly.packageFqName");
    localObject8 = new b((kotlin.l.b.a.b.f.c)localObject9, kotlin.l.b.a.b.f.e.b((kotlin.l.b.a.b.f.c)localObject8, (kotlin.l.b.a.b.f.c)localObject10), false);
    localObject6 = new c.a(((c)localObject6).cF(ListIterator.class), (b)localObject7, (b)localObject8);
    localObject7 = aiEX;
    localObject8 = b.s(k.a.aiDq);
    s.s(localObject8, "topLevel(FqNames.map)");
    localObject9 = k.a.aiDy;
    localObject10 = ((b)localObject8).kxL();
    kotlin.l.b.a.b.f.c localc1 = ((b)localObject8).kxL();
    s.s(localc1, "kotlinReadOnly.packageFqName");
    localObject9 = new b((kotlin.l.b.a.b.f.c)localObject10, kotlin.l.b.a.b.f.e.b((kotlin.l.b.a.b.f.c)localObject9, localc1), false);
    localObject7 = new c.a(((c)localObject7).cF(Map.class), (b)localObject8, (b)localObject9);
    localObject8 = aiEX;
    localObject9 = b.s(k.a.aiDq).p(k.a.aiDr.kxT());
    s.s(localObject9, "topLevel(FqNames.map).cr…mes.mapEntry.shortName())");
    localObject10 = k.a.aiDz;
    localc1 = ((b)localObject9).kxL();
    kotlin.l.b.a.b.f.c localc2 = ((b)localObject9).kxL();
    s.s(localc2, "kotlinReadOnly.packageFqName");
    localObject10 = new b(localc1, kotlin.l.b.a.b.f.e.b((kotlin.l.b.a.b.f.c)localObject10, localc2), false);
    aiFl = p.listOf(new c.a[] { localObject1, localObject2, localObject3, localObject4, localObject5, localObject6, localObject7, new c.a(((c)localObject8).cF(Map.Entry.class), (b)localObject9, (b)localObject10) });
    aiEX.a(Object.class, k.a.aiCy);
    aiEX.a(String.class, k.a.aiCE);
    aiEX.a(CharSequence.class, k.a.aiCD);
    aiEX.a(Throwable.class, k.a.aiCR);
    aiEX.a(Cloneable.class, k.a.aiCA);
    aiEX.a(Number.class, k.a.aiCO);
    aiEX.a(Comparable.class, k.a.aiCS);
    aiEX.a(Enum.class, k.a.aiCP);
    aiEX.a(Annotation.class, k.a.aiDb);
    localObject1 = aiFl.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (c.a)((Iterator)localObject1).next();
      localObject3 = ((c.a)localObject2).aiFm;
      localObject4 = ((c.a)localObject2).aiFn;
      localObject2 = ((c.a)localObject2).aiFo;
      a((b)localObject3, (b)localObject4);
      localObject5 = ((b)localObject2).kxQ();
      s.s(localObject5, "mutableClassId.asSingleFqName()");
      a((kotlin.l.b.a.b.f.c)localObject5, (b)localObject3);
      localObject4 = ((b)localObject4).kxQ();
      s.s(localObject4, "readOnlyClassId.asSingleFqName()");
      localObject3 = ((b)localObject2).kxQ();
      s.s(localObject3, "mutableClassId.asSingleFqName()");
      localObject5 = (Map)aiFj;
      localObject2 = ((b)localObject2).kxQ().kxR();
      s.s(localObject2, "mutableClassId.asSingleFqName().toUnsafe()");
      ((Map)localObject5).put(localObject2, localObject4);
      localObject2 = (Map)aiFk;
      localObject4 = ((kotlin.l.b.a.b.f.c)localObject4).kxR();
      s.s(localObject4, "readOnlyFqName.toUnsafe()");
      ((Map)localObject2).put(localObject4, localObject3);
    }
    localObject1 = kotlin.l.b.a.b.j.e.e.values();
    int k = localObject1.length;
    int i = 0;
    while (i < k)
    {
      localObject3 = localObject1[i];
      i += 1;
      localObject2 = b.s(((kotlin.l.b.a.b.j.e.e)localObject3).kzu());
      s.s(localObject2, "topLevel(jvmType.wrapperFqName)");
      localObject3 = ((kotlin.l.b.a.b.j.e.e)localObject3).kzs();
      s.s(localObject3, "jvmType.primitiveType");
      localObject3 = b.s(k.c((i)localObject3));
      s.s(localObject3, "topLevel(StandardNames.g…e(jvmType.primitiveType))");
      a((b)localObject2, (b)localObject3);
    }
    localObject1 = kotlin.l.b.a.b.a.c.aiBl;
    localObject1 = kotlin.l.b.a.b.a.c.kmG().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (b)((Iterator)localObject1).next();
      localObject2 = b.s(new kotlin.l.b.a.b.f.c("kotlin.jvm.internal." + ((b)localObject3).kxN().PF() + "CompanionObject"));
      s.s(localObject2, "topLevel(FqName(\"kotlin.…g() + \"CompanionObject\"))");
      localObject3 = ((b)localObject3).p(h.ajeL);
      s.s(localObject3, "classId.createNestedClas…AME_FOR_COMPANION_OBJECT)");
      a((b)localObject2, (b)localObject3);
    }
    for (i = 0;; i = k)
    {
      k = i + 1;
      localObject1 = b.s(new kotlin.l.b.a.b.f.c(s.X("kotlin.jvm.functions.Function", Integer.valueOf(i))));
      s.s(localObject1, "topLevel(FqName(\"kotlin.…m.functions.Function$i\"))");
      a((b)localObject1, k.aKx(i));
      a(new kotlin.l.b.a.b.f.c(s.X(aiEZ, Integer.valueOf(i))), aiFe);
      if (k >= 23) {
        for (i = j;; i = j)
        {
          j = i + 1;
          localObject1 = kotlin.l.b.a.b.a.a.c.aiEP;
          a(new kotlin.l.b.a.b.f.c(s.X(((kotlin.l.b.a.b.a.a.c)localObject1).aiEI.toString() + '.' + ((kotlin.l.b.a.b.a.a.c)localObject1).aiEJ, Integer.valueOf(i))), aiFe);
          if (j >= 22)
          {
            localObject1 = k.a.aiCz.kxX();
            s.s(localObject1, "nothing.toSafe()");
            a((kotlin.l.b.a.b.f.c)localObject1, aiEX.cF(Void.class));
            AppMethodBeat.o(56767);
            return;
          }
        }
      }
    }
  }
  
  private final void a(Class<?> paramClass, kotlin.l.b.a.b.f.c paramc)
  {
    AppMethodBeat.i(56759);
    paramClass = cF(paramClass);
    paramc = b.s(paramc);
    s.s(paramc, "topLevel(kotlinFqName)");
    a(paramClass, paramc);
    AppMethodBeat.o(56759);
  }
  
  private final void a(Class<?> paramClass, d paramd)
  {
    AppMethodBeat.i(56758);
    paramd = paramd.kxX();
    s.s(paramd, "kotlinFqName.toSafe()");
    a(paramClass, paramd);
    AppMethodBeat.o(56758);
  }
  
  private static void a(b paramb1, b paramb2)
  {
    AppMethodBeat.i(56757);
    Map localMap = (Map)aiFh;
    d locald = paramb1.kxQ().kxR();
    s.s(locald, "javaClassId.asSingleFqName().toUnsafe()");
    localMap.put(locald, paramb2);
    paramb2 = paramb2.kxQ();
    s.s(paramb2, "kotlinClassId.asSingleFqName()");
    a(paramb2, paramb1);
    AppMethodBeat.o(56757);
  }
  
  private static void a(kotlin.l.b.a.b.f.c paramc, b paramb)
  {
    AppMethodBeat.i(56760);
    Map localMap = (Map)aiFi;
    paramc = paramc.kxR();
    s.s(paramc, "kotlinFqNameUnsafe.toUnsafe()");
    localMap.put(paramc, paramb);
    AppMethodBeat.o(56760);
  }
  
  private static boolean a(d paramd, String paramString)
  {
    AppMethodBeat.i(56756);
    paramd = paramd.PF();
    s.s(paramd, "kotlinFqName.asString()");
    paramd = n.bY(paramd, paramString, "");
    int i;
    if (((CharSequence)paramd).length() > 0) {
      i = 1;
    }
    while ((i != 0) && (!n.bu((CharSequence)paramd)))
    {
      paramd = n.bJF(paramd);
      if ((paramd != null) && (paramd.intValue() >= 23))
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
  
  public static b c(kotlin.l.b.a.b.f.c paramc)
  {
    AppMethodBeat.i(56753);
    s.u(paramc, "fqName");
    paramc = (b)aiFh.get(paramc.kxR());
    AppMethodBeat.o(56753);
    return paramc;
  }
  
  public static b c(d paramd)
  {
    AppMethodBeat.i(56755);
    s.u(paramd, "kotlinFqName");
    if (a(paramd, aiEY))
    {
      paramd = aiFc;
      AppMethodBeat.o(56755);
      return paramd;
    }
    if (a(paramd, aiFa))
    {
      paramd = aiFc;
      AppMethodBeat.o(56755);
      return paramd;
    }
    if (a(paramd, aiEZ))
    {
      paramd = aiFe;
      AppMethodBeat.o(56755);
      return paramd;
    }
    if (a(paramd, aiFb))
    {
      paramd = aiFe;
      AppMethodBeat.o(56755);
      return paramd;
    }
    paramd = (b)aiFi.get(paramd);
    AppMethodBeat.o(56755);
    return paramd;
  }
  
  private final b cF(Class<?> paramClass)
  {
    AppMethodBeat.i(56765);
    if ((!paramClass.isPrimitive()) && (!paramClass.isArray())) {}
    for (int i = 1; (ak.aiuY) && (i == 0); i = 0)
    {
      paramClass = (Throwable)new AssertionError(s.X("Invalid class: ", paramClass));
      AppMethodBeat.o(56765);
      throw paramClass;
    }
    Class localClass = paramClass.getDeclaringClass();
    if (localClass == null)
    {
      paramClass = b.s(new kotlin.l.b.a.b.f.c(paramClass.getCanonicalName()));
      s.s(paramClass, "topLevel(FqName(clazz.canonicalName))");
      AppMethodBeat.o(56765);
      return paramClass;
    }
    paramClass = cF(localClass).p(f.bJe(paramClass.getSimpleName()));
    s.s(paramClass, "classId(outer).createNes…tifier(clazz.simpleName))");
    AppMethodBeat.o(56765);
    return paramClass;
  }
  
  public static kotlin.l.b.a.b.f.c d(d paramd)
  {
    AppMethodBeat.i(191499);
    paramd = (kotlin.l.b.a.b.f.c)((Map)aiFj).get(paramd);
    AppMethodBeat.o(191499);
    return paramd;
  }
  
  public static kotlin.l.b.a.b.f.c e(d paramd)
  {
    AppMethodBeat.i(191503);
    paramd = (kotlin.l.b.a.b.f.c)((Map)aiFk).get(paramd);
    AppMethodBeat.o(191503);
    return paramd;
  }
  
  public static boolean f(d paramd)
  {
    AppMethodBeat.i(191505);
    Map localMap = (Map)aiFj;
    if (localMap == null)
    {
      paramd = new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
      AppMethodBeat.o(191505);
      throw paramd;
    }
    boolean bool = localMap.containsKey(paramd);
    AppMethodBeat.o(191505);
    return bool;
  }
  
  public static boolean g(d paramd)
  {
    AppMethodBeat.i(191509);
    Map localMap = (Map)aiFk;
    if (localMap == null)
    {
      paramd = new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
      AppMethodBeat.o(191509);
      throw paramd;
    }
    boolean bool = localMap.containsKey(paramd);
    AppMethodBeat.o(191509);
    return bool;
  }
  
  public static kotlin.l.b.a.b.f.c knF()
  {
    return aiFd;
  }
  
  public static List<c.a> knG()
  {
    return aiFl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.a.b.c
 * JD-Core Version:    0.7.0.1
 */