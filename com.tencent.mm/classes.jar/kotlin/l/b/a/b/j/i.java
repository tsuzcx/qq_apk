package kotlin.l.b.a.b.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collection<Lkotlin.l.b.a.b.b.b;>;
import java.util.Collection<TH;>;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Queue;
import java.util.ServiceLoader;
import java.util.Set;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.l.b.a.b.b.ag;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.aj;
import kotlin.l.b.a.b.b.ak;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.az;
import kotlin.l.b.a.b.b.b.a;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.c.aa;
import kotlin.l.b.a.b.b.c.z;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.t;
import kotlin.l.b.a.b.b.v;
import kotlin.l.b.a.b.b.w;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.m.a.g;
import kotlin.l.b.a.b.m.a.g.a;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.at;
import kotlin.l.b.a.b.m.y;
import kotlin.o;
import kotlin.x;

public class i
{
  private static final List<d> THO;
  public static final i THP;
  private static final g.a THQ;
  private final kotlin.l.b.a.b.m.a.i THR;
  private final g.a THS;
  
  static
  {
    AppMethodBeat.i(60004);
    if (!i.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      THO = j.p(ServiceLoader.load(d.class, d.class.getClassLoader()));
      THQ = new g.a()
      {
        public final boolean a(at paramAnonymousat1, at paramAnonymousat2)
        {
          AppMethodBeat.i(59954);
          if (paramAnonymousat1 == null) {
            atM(0);
          }
          if (paramAnonymousat2 == null) {
            atM(1);
          }
          boolean bool = paramAnonymousat1.equals(paramAnonymousat2);
          AppMethodBeat.o(59954);
          return bool;
        }
      };
      THP = new i(THQ, kotlin.l.b.a.b.m.a.i.a.TPf);
      AppMethodBeat.o(60004);
      return;
    }
  }
  
  private i(g.a parama, kotlin.l.b.a.b.m.a.i parami)
  {
    AppMethodBeat.i(59975);
    this.THS = parama;
    this.THR = parami;
    AppMethodBeat.o(59975);
  }
  
  private static <D extends kotlin.l.b.a.b.b.a> Set<D> F(Set<D> paramSet)
  {
    AppMethodBeat.i(59976);
    if ((!paramSet.isEmpty()) && (kotlin.l.b.a.b.j.d.a.e(kotlin.l.b.a.b.j.d.a.F((l)paramSet.iterator().next())))) {}
    i.2 local2;
    for (boolean bool = true;; bool = false)
    {
      local2 = new i.2();
      if (paramSet.size() > 1) {
        break;
      }
      AppMethodBeat.o(59976);
      return paramSet;
    }
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    Iterator localIterator1 = paramSet.iterator();
    while (localIterator1.hasNext())
    {
      Object localObject1 = localIterator1.next();
      Iterator localIterator2 = localLinkedHashSet.iterator();
      for (;;)
      {
        if (!localIterator2.hasNext()) {
          break label197;
        }
        Object localObject2 = (o)local2.invoke(localObject1, localIterator2.next());
        kotlin.l.b.a.b.b.a locala = (kotlin.l.b.a.b.b.a)((o)localObject2).first;
        localObject2 = (kotlin.l.b.a.b.b.a)((o)localObject2).second;
        if (a(locala, (kotlin.l.b.a.b.b.a)localObject2, bool)) {
          localIterator2.remove();
        } else {
          if (a((kotlin.l.b.a.b.b.a)localObject2, locala, bool)) {
            break;
          }
        }
      }
      label197:
      localLinkedHashSet.add(localObject1);
    }
    if ((!$assertionsDisabled) && (localLinkedHashSet.isEmpty()))
    {
      paramSet = new AssertionError("All candidates filtered out from ".concat(String.valueOf(paramSet)));
      AppMethodBeat.o(59976);
      throw paramSet;
    }
    AppMethodBeat.o(59976);
    return localLinkedHashSet;
  }
  
  private g I(List<as> paramList1, List<as> paramList2)
  {
    AppMethodBeat.i(59984);
    if (paramList1 == null) {
      atM(38);
    }
    if (paramList2 == null) {
      atM(39);
    }
    if ((!$assertionsDisabled) && (paramList1.size() != paramList2.size()))
    {
      paramList1 = new AssertionError("Should be the same number of type parameters: " + paramList1 + " vs " + paramList2);
      AppMethodBeat.o(59984);
      throw paramList1;
    }
    if (paramList1.isEmpty())
    {
      paramList1 = kotlin.l.b.a.b.m.a.h.b(this.THS);
      AppMethodBeat.o(59984);
      return paramList1;
    }
    final HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < paramList1.size())
    {
      localHashMap.put(((as)paramList1.get(i)).hzz(), ((as)paramList2.get(i)).hzz());
      i += 1;
    }
    paramList1 = kotlin.l.b.a.b.m.a.h.b(new g.a()
    {
      public final boolean a(at paramAnonymousat1, at paramAnonymousat2)
      {
        AppMethodBeat.i(59957);
        if (paramAnonymousat1 == null) {
          atM(0);
        }
        if (paramAnonymousat2 == null) {
          atM(1);
        }
        if (i.a(i.this).a(paramAnonymousat1, paramAnonymousat2))
        {
          AppMethodBeat.o(59957);
          return true;
        }
        at localat1 = (at)localHashMap.get(paramAnonymousat1);
        at localat2 = (at)localHashMap.get(paramAnonymousat2);
        if (((localat1 != null) && (localat1.equals(paramAnonymousat2))) || ((localat2 != null) && (localat2.equals(paramAnonymousat1))))
        {
          AppMethodBeat.o(59957);
          return true;
        }
        AppMethodBeat.o(59957);
        return false;
      }
    });
    AppMethodBeat.o(59984);
    return paramList1;
  }
  
  public static <H> H a(Collection<H> paramCollection, kotlin.g.a.b<H, kotlin.l.b.a.b.b.a> paramb)
  {
    AppMethodBeat.i(59996);
    if (paramCollection == null) {
      atM(73);
    }
    if (paramb == null) {
      atM(74);
    }
    if ((!$assertionsDisabled) && (paramCollection.isEmpty()))
    {
      paramCollection = new AssertionError("Should have at least one overridable descriptor");
      AppMethodBeat.o(59996);
      throw paramCollection;
    }
    if (paramCollection.size() == 1)
    {
      paramCollection = j.e(paramCollection);
      if (paramCollection == null) {
        atM(75);
      }
      AppMethodBeat.o(59996);
      return paramCollection;
    }
    ArrayList localArrayList = new ArrayList(2);
    List localList = j.d(paramCollection, paramb);
    Object localObject = j.e(paramCollection);
    kotlin.l.b.a.b.b.a locala1 = (kotlin.l.b.a.b.b.a)paramb.invoke(localObject);
    Iterator localIterator = paramCollection.iterator();
    paramCollection = (Collection<H>)localObject;
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      kotlin.l.b.a.b.b.a locala2 = (kotlin.l.b.a.b.b.a)paramb.invoke(localObject);
      if (a(locala2, localList)) {
        localArrayList.add(localObject);
      }
      if ((!e(locala2, locala1)) || (e(locala1, locala2))) {
        break label348;
      }
      paramCollection = (Collection<H>)localObject;
    }
    label348:
    for (;;)
    {
      break;
      if (localArrayList.isEmpty())
      {
        if (paramCollection == null) {
          atM(76);
        }
        AppMethodBeat.o(59996);
        return paramCollection;
      }
      if (localArrayList.size() == 1)
      {
        paramCollection = j.e(localArrayList);
        if (paramCollection == null) {
          atM(77);
        }
        AppMethodBeat.o(59996);
        return paramCollection;
      }
      localObject = localArrayList.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        paramCollection = ((Iterator)localObject).next();
      } while (y.al(((kotlin.l.b.a.b.b.a)paramb.invoke(paramCollection)).hAu()));
      for (;;)
      {
        if (paramCollection != null)
        {
          if (paramCollection == null) {
            atM(78);
          }
          AppMethodBeat.o(59996);
          return paramCollection;
        }
        paramCollection = j.e(localArrayList);
        if (paramCollection == null) {
          atM(79);
        }
        AppMethodBeat.o(59996);
        return paramCollection;
        paramCollection = null;
      }
    }
  }
  
  public static <H> Collection<H> a(H paramH, Collection<H> paramCollection, kotlin.g.a.b<H, kotlin.l.b.a.b.b.a> paramb, kotlin.g.a.b<H, x> paramb1)
  {
    AppMethodBeat.i(60001);
    if (paramH == null) {
      atM(94);
    }
    if (paramb == null) {
      atM(96);
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramH);
    kotlin.l.b.a.b.b.a locala = (kotlin.l.b.a.b.b.a)paramb.invoke(paramH);
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      Object localObject1 = paramCollection.next();
      Object localObject2 = (kotlin.l.b.a.b.b.a)paramb.invoke(localObject1);
      if (paramH == localObject1)
      {
        paramCollection.remove();
      }
      else
      {
        localObject2 = f(locala, (kotlin.l.b.a.b.b.a)localObject2);
        if (localObject2 == i.a.a.TIe)
        {
          localArrayList.add(localObject1);
          paramCollection.remove();
        }
        else if (localObject2 == i.a.a.TIg)
        {
          paramb1.invoke(localObject1);
          paramCollection.remove();
        }
      }
    }
    AppMethodBeat.o(60001);
    return localArrayList;
  }
  
  private Collection<kotlin.l.b.a.b.b.b> a(kotlin.l.b.a.b.b.b paramb, Collection<? extends kotlin.l.b.a.b.b.b> paramCollection, e parame, h paramh)
  {
    AppMethodBeat.i(59990);
    if (paramb == null) {
      atM(55);
    }
    if (paramCollection == null) {
      atM(56);
    }
    if (parame == null) {
      atM(57);
    }
    if (paramh == null) {
      atM(58);
    }
    ArrayList localArrayList = new ArrayList(paramCollection.size());
    kotlin.l.b.a.b.o.i locali = kotlin.l.b.a.b.o.i.hLZ();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      kotlin.l.b.a.b.b.b localb = (kotlin.l.b.a.b.b.b)paramCollection.next();
      i.a.a locala = b(localb, paramb, parame).hKA();
      if (paramb == null) {
        atM(53);
      }
      if (localb == null) {
        atM(54);
      }
      if ((!az.b(localb.hzE())) && (az.a(localb, paramb))) {}
      for (int i = 1;; i = 0) {
        switch (9.TIa[locala.ordinal()])
        {
        default: 
          break;
        case 1: 
          if (i != 0) {
            locali.add(localb);
          }
          localArrayList.add(localb);
          break;
        }
      }
      if (i != 0) {
        paramh.b(localb, paramb);
      }
      localArrayList.add(localb);
    }
    paramh.a(paramb, locali);
    AppMethodBeat.o(59990);
    return localArrayList;
  }
  
  private static Collection<kotlin.l.b.a.b.b.b> a(e parame, Collection<kotlin.l.b.a.b.b.b> paramCollection)
  {
    AppMethodBeat.i(60000);
    if (parame == null) {
      atM(91);
    }
    if (paramCollection == null) {
      atM(92);
    }
    parame = j.c(paramCollection, new kotlin.g.a.b() {});
    AppMethodBeat.o(60000);
    return parame;
  }
  
  private static w a(Collection<kotlin.l.b.a.b.b.b> paramCollection, e parame)
  {
    boolean bool = true;
    AppMethodBeat.i(59998);
    if (paramCollection == null) {
      atM(83);
    }
    if (parame == null) {
      atM(84);
    }
    Object localObject = paramCollection.iterator();
    int i = 0;
    int j = 0;
    if (((Iterator)localObject).hasNext())
    {
      kotlin.l.b.a.b.b.b localb = (kotlin.l.b.a.b.b.b)((Iterator)localObject).next();
      switch (9.TIb[localb.hzC().ordinal()])
      {
      }
      for (;;)
      {
        break;
        paramCollection = w.Tho;
        if (paramCollection == null) {
          atM(85);
        }
        AppMethodBeat.o(59998);
        return paramCollection;
        paramCollection = new IllegalStateException("Member cannot have SEALED modality: ".concat(String.valueOf(localb)));
        AppMethodBeat.o(59998);
        throw paramCollection;
        j = 1;
        break;
        i = 1;
      }
    }
    if ((parame.hzJ()) && (parame.hzC() != w.Thr) && (parame.hzC() != w.Thp)) {}
    while ((j != 0) && (i == 0))
    {
      paramCollection = w.Thq;
      if (paramCollection == null) {
        atM(86);
      }
      AppMethodBeat.o(59998);
      return paramCollection;
      bool = false;
    }
    if ((j == 0) && (i != 0))
    {
      if (bool) {}
      for (paramCollection = parame.hzC();; paramCollection = w.Thr)
      {
        if (paramCollection == null) {
          atM(87);
        }
        AppMethodBeat.o(59998);
        return paramCollection;
      }
    }
    localObject = new HashSet();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      ((Set)localObject).addAll(u((kotlin.l.b.a.b.b.b)paramCollection.next()));
    }
    paramCollection = a(F((Set)localObject), bool, parame.hzC());
    AppMethodBeat.o(59998);
    return paramCollection;
  }
  
  private static w a(Collection<kotlin.l.b.a.b.b.b> paramCollection, boolean paramBoolean, w paramw)
  {
    AppMethodBeat.i(59999);
    if (paramCollection == null) {
      atM(88);
    }
    if (paramw == null) {
      atM(89);
    }
    Object localObject = w.Thr;
    Iterator localIterator = paramCollection.iterator();
    paramCollection = (Collection<kotlin.l.b.a.b.b.b>)localObject;
    if (localIterator.hasNext())
    {
      localObject = (kotlin.l.b.a.b.b.b)localIterator.next();
      if ((paramBoolean) && (((kotlin.l.b.a.b.b.b)localObject).hzC() == w.Thr))
      {
        localObject = paramw;
        label77:
        if (((w)localObject).compareTo(paramCollection) >= 0) {
          break label117;
        }
      }
    }
    for (;;)
    {
      paramCollection = (Collection<kotlin.l.b.a.b.b.b>)localObject;
      break;
      localObject = ((kotlin.l.b.a.b.b.b)localObject).hzC();
      break label77;
      if (paramCollection == null) {
        atM(90);
      }
      AppMethodBeat.o(59999);
      return paramCollection;
      label117:
      localObject = paramCollection;
    }
  }
  
  public static i a(g.a parama)
  {
    AppMethodBeat.i(59973);
    parama = new i(parama, kotlin.l.b.a.b.m.a.i.a.TPf);
    AppMethodBeat.o(59973);
    return parama;
  }
  
  private static void a(Collection<kotlin.l.b.a.b.b.b> paramCollection, e parame, h paramh)
  {
    AppMethodBeat.i(59997);
    if (paramCollection == null) {
      atM(80);
    }
    if (parame == null) {
      atM(81);
    }
    if (paramh == null) {
      atM(82);
    }
    Object localObject = a(parame, paramCollection);
    boolean bool = ((Collection)localObject).isEmpty();
    w localw;
    if (bool)
    {
      localw = a(paramCollection, parame);
      if (!bool) {
        break label163;
      }
    }
    label163:
    for (localObject = az.ThX;; localObject = az.ThW)
    {
      parame = ((kotlin.l.b.a.b.b.b)a(paramCollection, new kotlin.g.a.b() {})).a(parame, localw, (ba)localObject, b.a.TgX);
      paramh.a(parame, paramCollection);
      if (($assertionsDisabled) || (!parame.hAy().isEmpty())) {
        break label171;
      }
      paramCollection = new AssertionError("Overridden descriptors should be set for " + b.a.TgX);
      AppMethodBeat.o(59997);
      throw paramCollection;
      paramCollection = (Collection<kotlin.l.b.a.b.b.b>)localObject;
      break;
    }
    label171:
    paramh.e(parame);
    AppMethodBeat.o(59997);
  }
  
  private static void a(kotlin.l.b.a.b.b.b paramb, Set<kotlin.l.b.a.b.b.b> paramSet)
  {
    AppMethodBeat.i(59979);
    if (paramb == null) {
      atM(13);
    }
    if (paramSet == null) {
      atM(14);
    }
    if (paramb.hAA().hAB())
    {
      paramSet.add(paramb);
      AppMethodBeat.o(59979);
      return;
    }
    if (paramb.hAy().isEmpty())
    {
      paramb = new IllegalStateException("No overridden descriptors found for (fake override) ".concat(String.valueOf(paramb)));
      AppMethodBeat.o(59979);
      throw paramb;
    }
    paramb = paramb.hAy().iterator();
    while (paramb.hasNext()) {
      a((kotlin.l.b.a.b.b.b)paramb.next(), paramSet);
    }
    AppMethodBeat.o(59979);
  }
  
  public static void a(kotlin.l.b.a.b.b.b paramb, kotlin.g.a.b<kotlin.l.b.a.b.b.b, x> paramb1)
  {
    AppMethodBeat.i(60003);
    if (paramb == null) {
      atM(102);
    }
    Object localObject1 = paramb.hAy().iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (kotlin.l.b.a.b.b.b)((Iterator)localObject1).next();
      if (((kotlin.l.b.a.b.b.b)localObject2).hzE() == az.ThW) {
        a((kotlin.l.b.a.b.b.b)localObject2, paramb1);
      }
    }
    if (paramb.hzE() != az.ThW)
    {
      AppMethodBeat.o(60003);
      return;
    }
    if (paramb == null) {
      atM(103);
    }
    Object localObject3 = paramb.hAy();
    if (localObject3 == null) {
      atM(104);
    }
    label132:
    label152:
    label221:
    Object localObject4;
    if (((Collection)localObject3).isEmpty())
    {
      localObject2 = az.Tib;
      if (localObject2 == null)
      {
        localObject1 = null;
        if (localObject1 != null) {
          break label501;
        }
        if (paramb1 != null) {
          paramb1.invoke(paramb);
        }
        localObject2 = az.ThU;
        if (!(paramb instanceof aa)) {
          break label518;
        }
        localObject3 = (aa)paramb;
        if (localObject2 == null) {
          aa.atM(16);
        }
        ((aa)localObject3).TkL = ((ba)localObject2);
        localObject2 = ((ah)paramb).hBp().iterator();
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label511;
          }
          localObject3 = (ag)((Iterator)localObject2).next();
          if (localObject1 != null) {
            break;
          }
          paramb = null;
          a((kotlin.l.b.a.b.b.b)localObject3, paramb);
        }
      }
    }
    else
    {
      localObject4 = ((Collection)localObject3).iterator();
      localObject1 = null;
      label241:
      while (((Iterator)localObject4).hasNext())
      {
        Object localObject5 = (kotlin.l.b.a.b.b.b)((Iterator)localObject4).next();
        localObject2 = ((kotlin.l.b.a.b.b.b)localObject5).hzE();
        if ((!$assertionsDisabled) && (localObject2 == az.ThW))
        {
          paramb = new AssertionError("Visibility should have been computed for ".concat(String.valueOf(localObject5)));
          AppMethodBeat.o(60003);
          throw paramb;
        }
        if (localObject1 == null)
        {
          localObject1 = localObject2;
        }
        else
        {
          localObject5 = az.b((ba)localObject2, (ba)localObject1);
          if (localObject5 == null)
          {
            localObject1 = null;
          }
          else
          {
            if (((Integer)localObject5).intValue() <= 0) {
              break label615;
            }
            localObject1 = localObject2;
          }
        }
      }
    }
    label518:
    label615:
    for (;;)
    {
      break label241;
      if (localObject1 == null)
      {
        localObject2 = null;
        break;
      }
      localObject2 = ((Collection)localObject3).iterator();
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          localObject4 = az.b((ba)localObject1, ((kotlin.l.b.a.b.b.b)((Iterator)localObject2).next()).hzE());
          if ((localObject4 == null) || (((Integer)localObject4).intValue() < 0))
          {
            localObject2 = null;
            break;
          }
        }
      }
      localObject2 = localObject1;
      break;
      if (paramb.hAA() == b.a.TgX)
      {
        localObject3 = ((Collection)localObject3).iterator();
        do
        {
          localObject1 = localObject2;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject1 = (kotlin.l.b.a.b.b.b)((Iterator)localObject3).next();
        } while ((((kotlin.l.b.a.b.b.b)localObject1).hzC() == w.Thr) || (((kotlin.l.b.a.b.b.b)localObject1).hzE().equals(localObject2)));
        localObject1 = null;
        break label132;
      }
      localObject1 = ((ba)localObject2).hBN();
      break label132;
      label501:
      localObject2 = localObject1;
      break label152;
      paramb = paramb1;
      break label221;
      label511:
      AppMethodBeat.o(60003);
      return;
      if ((paramb instanceof kotlin.l.b.a.b.b.c.p))
      {
        paramb = (kotlin.l.b.a.b.b.c.p)paramb;
        if (localObject2 == null) {
          kotlin.l.b.a.b.b.c.p.atM(9);
        }
        paramb.TkL = ((ba)localObject2);
        AppMethodBeat.o(60003);
        return;
      }
      if ((!$assertionsDisabled) && (!(paramb instanceof z)))
      {
        paramb = new AssertionError();
        AppMethodBeat.o(60003);
        throw paramb;
      }
      paramb = (z)paramb;
      paramb.TkL = ((ba)localObject2);
      if (localObject2 != paramb.hBm().hzE()) {
        paramb.isDefault = false;
      }
      AppMethodBeat.o(60003);
      return;
    }
  }
  
  private static void a(e parame, Collection<kotlin.l.b.a.b.b.b> paramCollection, h paramh)
  {
    AppMethodBeat.i(59991);
    if (parame == null) {
      atM(60);
    }
    if (paramh == null) {
      atM(62);
    }
    Object localObject;
    int i;
    if (paramCollection.size() >= 2)
    {
      localObject = new kotlin.g.a.b() {};
      kotlin.g.b.p.h(paramCollection, "$this$all");
      kotlin.g.b.p.h(localObject, "predicate");
      if (!((Collection)paramCollection).isEmpty())
      {
        Iterator localIterator = paramCollection.iterator();
        while (localIterator.hasNext()) {
          if (!((Boolean)((kotlin.g.a.b)localObject).invoke(localIterator.next())).booleanValue()) {
            i = 0;
          }
        }
      }
    }
    while (i != 0)
    {
      paramCollection = paramCollection.iterator();
      for (;;)
      {
        if (paramCollection.hasNext())
        {
          a(Collections.singleton((kotlin.l.b.a.b.b.b)paramCollection.next()), parame, paramh);
          continue;
          i = 1;
          break;
        }
      }
      AppMethodBeat.o(59991);
      return;
    }
    paramCollection = new LinkedList(paramCollection);
    while (!paramCollection.isEmpty())
    {
      localObject = k.z(paramCollection);
      if (localObject == null) {
        atM(99);
      }
      if (paramh == null) {
        atM(101);
      }
      a(a(localObject, paramCollection, new kotlin.g.a.b()new kotlin.g.a.b {}, new kotlin.g.a.b() {}), parame, paramh);
    }
    AppMethodBeat.o(59991);
  }
  
  private static boolean a(kotlin.l.b.a.b.b.a parama, Collection<kotlin.l.b.a.b.b.a> paramCollection)
  {
    AppMethodBeat.i(59994);
    if (parama == null) {
      atM(67);
    }
    if (paramCollection == null) {
      atM(68);
    }
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      if (!e(parama, (kotlin.l.b.a.b.b.a)paramCollection.next()))
      {
        AppMethodBeat.o(59994);
        return false;
      }
    }
    AppMethodBeat.o(59994);
    return true;
  }
  
  private static <D extends kotlin.l.b.a.b.b.a> boolean a(D paramD1, D paramD2, boolean paramBoolean)
  {
    AppMethodBeat.i(59977);
    if (paramD1 == null) {
      atM(9);
    }
    if (paramD2 == null) {
      atM(10);
    }
    if ((!paramD1.equals(paramD2)) && (a.THm.a(paramD1.hAv(), paramD2.hAv(), paramBoolean)))
    {
      AppMethodBeat.o(59977);
      return true;
    }
    paramD2 = paramD2.hAv();
    paramD1 = c.e(paramD1).iterator();
    while (paramD1.hasNext())
    {
      kotlin.l.b.a.b.b.a locala = (kotlin.l.b.a.b.b.a)paramD1.next();
      if (a.THm.a(paramD2, locala, paramBoolean))
      {
        AppMethodBeat.o(59977);
        return true;
      }
    }
    AppMethodBeat.o(59977);
    return false;
  }
  
  private static boolean a(kotlin.l.b.a.b.b.a parama1, ab paramab1, kotlin.l.b.a.b.b.a parama2, ab paramab2)
  {
    AppMethodBeat.i(59995);
    if (parama1 == null) {
      atM(69);
    }
    if (paramab1 == null) {
      atM(70);
    }
    if (parama2 == null) {
      atM(71);
    }
    if (paramab2 == null) {
      atM(72);
    }
    boolean bool = THP.I(parama1.hAt(), parama2.hAt()).c(paramab1, paramab2);
    AppMethodBeat.o(59995);
    return bool;
  }
  
  private boolean a(as paramas1, as paramas2, g paramg)
  {
    AppMethodBeat.i(59987);
    if (paramas1 == null) {
      atM(45);
    }
    if (paramas2 == null) {
      atM(46);
    }
    if (paramg == null) {
      atM(47);
    }
    Object localObject = paramas1.hyo();
    paramas1 = new ArrayList(paramas2.hyo());
    if (((List)localObject).size() != paramas1.size())
    {
      AppMethodBeat.o(59987);
      return false;
    }
    paramas2 = ((List)localObject).iterator();
    while (paramas2.hasNext())
    {
      localObject = (ab)paramas2.next();
      ListIterator localListIterator = paramas1.listIterator();
      for (;;)
      {
        if (localListIterator.hasNext()) {
          if (a((ab)localObject, (ab)localListIterator.next(), paramg))
          {
            localListIterator.remove();
            break;
          }
        }
      }
      AppMethodBeat.o(59987);
      return false;
    }
    AppMethodBeat.o(59987);
    return true;
  }
  
  private static boolean a(kotlin.l.b.a.b.b.p paramp1, kotlin.l.b.a.b.b.p paramp2)
  {
    AppMethodBeat.i(59993);
    if (paramp1 == null) {
      atM(65);
    }
    if (paramp2 == null) {
      atM(66);
    }
    paramp1 = az.b(paramp1.hzE(), paramp2.hzE());
    if ((paramp1 == null) || (paramp1.intValue() >= 0))
    {
      AppMethodBeat.o(59993);
      return true;
    }
    AppMethodBeat.o(59993);
    return false;
  }
  
  private boolean a(ab paramab1, ab paramab2, g paramg)
  {
    AppMethodBeat.i(59986);
    if (paramab1 == null) {
      atM(42);
    }
    if (paramab2 == null) {
      atM(43);
    }
    if (paramg == null) {
      atM(44);
    }
    if ((ad.ap(paramab1)) && (ad.ap(paramab2))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(59986);
      return true;
    }
    boolean bool = paramg.d(this.THR.aK(paramab1), this.THR.aK(paramab2));
    AppMethodBeat.o(59986);
    return bool;
  }
  
  private a b(kotlin.l.b.a.b.b.a parama1, kotlin.l.b.a.b.b.a parama2, e parame)
  {
    AppMethodBeat.i(59980);
    if (parama1 == null) {
      atM(15);
    }
    if (parama2 == null) {
      atM(16);
    }
    parama1 = a(parama1, parama2, parame, false);
    if (parama1 == null) {
      atM(17);
    }
    AppMethodBeat.o(59980);
    return parama1;
  }
  
  private static a c(kotlin.l.b.a.b.b.a parama1, kotlin.l.b.a.b.b.a parama2)
  {
    AppMethodBeat.i(59983);
    if (parama1 == null) {
      atM(36);
    }
    if (parama2 == null) {
      atM(37);
    }
    if ((((parama1 instanceof t)) && (!(parama2 instanceof t))) || (((parama1 instanceof ah)) && (!(parama2 instanceof ah))))
    {
      parama1 = a.bug("Member kind mismatch");
      AppMethodBeat.o(59983);
      return parama1;
    }
    if ((!(parama1 instanceof t)) && (!(parama1 instanceof ah)))
    {
      parama1 = new IllegalArgumentException("This type of CallableDescriptor cannot be checked for overridability: ".concat(String.valueOf(parama1)));
      AppMethodBeat.o(59983);
      throw parama1;
    }
    if (!parama1.hAH().equals(parama2.hAH()))
    {
      parama1 = a.bug("Name mismatch");
      AppMethodBeat.o(59983);
      return parama1;
    }
    parama1 = d(parama1, parama2);
    if (parama1 != null)
    {
      AppMethodBeat.o(59983);
      return parama1;
    }
    AppMethodBeat.o(59983);
    return null;
  }
  
  private static a d(kotlin.l.b.a.b.b.a parama1, kotlin.l.b.a.b.b.a parama2)
  {
    int j = 1;
    AppMethodBeat.i(59985);
    int i;
    if (parama1.hAr() == null)
    {
      i = 1;
      if (parama2.hAr() != null) {
        break label53;
      }
    }
    for (;;)
    {
      if (i == j) {
        break label58;
      }
      parama1 = a.bug("Receiver presence mismatch");
      AppMethodBeat.o(59985);
      return parama1;
      i = 0;
      break;
      label53:
      j = 0;
    }
    label58:
    if (parama1.hAw().size() != parama2.hAw().size())
    {
      parama1 = a.bug("Value parameter number mismatch");
      AppMethodBeat.o(59985);
      return parama1;
    }
    AppMethodBeat.o(59985);
    return null;
  }
  
  public static boolean e(kotlin.l.b.a.b.b.a parama1, kotlin.l.b.a.b.b.a parama2)
  {
    AppMethodBeat.i(59992);
    if (parama1 == null) {
      atM(63);
    }
    if (parama2 == null) {
      atM(64);
    }
    ab localab1 = parama1.hAu();
    ab localab2 = parama2.hAu();
    if ((!$assertionsDisabled) && (localab1 == null))
    {
      parama1 = new AssertionError("Return type of " + parama1 + " is null");
      AppMethodBeat.o(59992);
      throw parama1;
    }
    if ((!$assertionsDisabled) && (localab2 == null))
    {
      parama1 = new AssertionError("Return type of " + parama2 + " is null");
      AppMethodBeat.o(59992);
      throw parama1;
    }
    if (!a(parama1, parama2))
    {
      AppMethodBeat.o(59992);
      return false;
    }
    boolean bool;
    if ((parama1 instanceof t))
    {
      if ((!$assertionsDisabled) && (!(parama2 instanceof t)))
      {
        parama1 = new AssertionError("b is " + parama2.getClass());
        AppMethodBeat.o(59992);
        throw parama1;
      }
      bool = a(parama1, localab1, parama2, localab2);
      AppMethodBeat.o(59992);
      return bool;
    }
    if ((parama1 instanceof ah))
    {
      if ((!$assertionsDisabled) && (!(parama2 instanceof ah)))
      {
        parama1 = new AssertionError("b is " + parama2.getClass());
        AppMethodBeat.o(59992);
        throw parama1;
      }
      ah localah1 = (ah)parama1;
      ah localah2 = (ah)parama2;
      aj localaj1 = localah1.hBo();
      aj localaj2 = localah2.hBo();
      if ((localaj1 == null) || (localaj2 == null)) {}
      for (bool = true; !bool; bool = a(localaj1, localaj2))
      {
        AppMethodBeat.o(59992);
        return false;
      }
      if ((localah1.hBF()) && (localah2.hBF()))
      {
        bool = THP.I(parama1.hAt(), parama2.hAt()).d(localab1, localab2);
        AppMethodBeat.o(59992);
        return bool;
      }
      if (((localah1.hBF()) || (!localah2.hBF())) && (a(parama1, localab1, parama2, localab2)))
      {
        AppMethodBeat.o(59992);
        return true;
      }
      AppMethodBeat.o(59992);
      return false;
    }
    parama1 = new IllegalArgumentException("Unexpected callable: " + parama1.getClass());
    AppMethodBeat.o(59992);
    throw parama1;
  }
  
  public static i.a.a f(kotlin.l.b.a.b.b.a parama1, kotlin.l.b.a.b.b.a parama2)
  {
    AppMethodBeat.i(60002);
    i.a.a locala = THP.b(parama2, parama1, null).hKA();
    parama1 = THP.b(parama1, parama2, null).hKA();
    if ((locala == i.a.a.TIe) && (parama1 == i.a.a.TIe))
    {
      parama1 = i.a.a.TIe;
      AppMethodBeat.o(60002);
      return parama1;
    }
    if ((locala == i.a.a.TIg) || (parama1 == i.a.a.TIg))
    {
      parama1 = i.a.a.TIg;
      AppMethodBeat.o(60002);
      return parama1;
    }
    parama1 = i.a.a.TIf;
    AppMethodBeat.o(60002);
    return parama1;
  }
  
  public static i f(kotlin.l.b.a.b.m.a.i parami)
  {
    AppMethodBeat.i(59974);
    if (parami == null) {
      atM(1);
    }
    parami = new i(THQ, parami);
    AppMethodBeat.o(59974);
    return parami;
  }
  
  private static List<ab> g(kotlin.l.b.a.b.b.a parama)
  {
    AppMethodBeat.i(59988);
    ak localak = parama.hAr();
    ArrayList localArrayList = new ArrayList();
    if (localak != null) {
      localArrayList.add(localak.hBy());
    }
    parama = parama.hAw().iterator();
    while (parama.hasNext()) {
      localArrayList.add(((av)parama.next()).hBy());
    }
    AppMethodBeat.o(59988);
    return localArrayList;
  }
  
  private static Set<kotlin.l.b.a.b.b.b> u(kotlin.l.b.a.b.b.b paramb)
  {
    AppMethodBeat.i(59978);
    if (paramb == null) {
      atM(11);
    }
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    a(paramb, localLinkedHashSet);
    AppMethodBeat.o(59978);
    return localLinkedHashSet;
  }
  
  public final a a(kotlin.l.b.a.b.b.a parama1, kotlin.l.b.a.b.b.a parama2, e parame, boolean paramBoolean)
  {
    AppMethodBeat.i(59981);
    if (parama1 == null) {
      atM(18);
    }
    if (parama2 == null) {
      atM(19);
    }
    Object localObject1 = b(parama1, parama2, paramBoolean);
    if (((a)localObject1).hKA() == i.a.a.TIe) {}
    Object localObject2;
    Object localObject3;
    for (int i = 1;; i = 0)
    {
      localObject2 = THO.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (d)((Iterator)localObject2).next();
        if ((((d)localObject3).hDu() != d.a.THC) && ((i == 0) || (((d)localObject3).hDu() != d.a.THD)))
        {
          localObject3 = ((d)localObject3).a(parama1, parama2, parame);
          switch (9.THZ[localObject3.ordinal()])
          {
          default: 
            break;
          case 1: 
            i = 1;
          }
        }
      }
    }
    parama1 = a.buh("External condition failed");
    AppMethodBeat.o(59981);
    return parama1;
    parama1 = a.bug("External condition");
    AppMethodBeat.o(59981);
    return parama1;
    if (i == 0)
    {
      if (localObject1 == null) {
        atM(22);
      }
      AppMethodBeat.o(59981);
      return localObject1;
    }
    localObject1 = THO.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (d)((Iterator)localObject1).next();
      if (((d)localObject2).hDu() == d.a.THC)
      {
        localObject3 = ((d)localObject2).a(parama1, parama2, parame);
        switch (9.THZ[localObject3.ordinal()])
        {
        default: 
          break;
        case 1: 
          parama1 = new IllegalStateException("Contract violation in " + localObject2.getClass().getName() + " condition. It's not supposed to end with success");
          AppMethodBeat.o(59981);
          throw parama1;
        case 2: 
          parama1 = a.buh("External condition failed");
          AppMethodBeat.o(59981);
          return parama1;
        case 3: 
          parama1 = a.bug("External condition");
          AppMethodBeat.o(59981);
          return parama1;
        }
      }
    }
    parama1 = a.hKz();
    if (parama1 == null) {
      atM(25);
    }
    AppMethodBeat.o(59981);
    return parama1;
  }
  
  public final void a(f paramf, Collection<? extends kotlin.l.b.a.b.b.b> paramCollection1, Collection<? extends kotlin.l.b.a.b.b.b> paramCollection2, e parame, h paramh)
  {
    AppMethodBeat.i(59989);
    if (paramf == null) {
      atM(48);
    }
    if (paramCollection1 == null) {
      atM(49);
    }
    if (paramCollection2 == null) {
      atM(50);
    }
    if (parame == null) {
      atM(51);
    }
    paramf = new LinkedHashSet(paramCollection1);
    paramCollection2 = paramCollection2.iterator();
    while (paramCollection2.hasNext()) {
      paramf.removeAll(a((kotlin.l.b.a.b.b.b)paramCollection2.next(), paramCollection1, parame, paramh));
    }
    a(parame, paramf, paramh);
    AppMethodBeat.o(59989);
  }
  
  public final a b(kotlin.l.b.a.b.b.a parama1, kotlin.l.b.a.b.b.a parama2, boolean paramBoolean)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(59982);
    if (parama1 == null) {
      atM(26);
    }
    if (parama2 == null) {
      atM(27);
    }
    Object localObject = c(parama1, parama2);
    if (localObject != null)
    {
      if (localObject == null) {
        atM(28);
      }
      AppMethodBeat.o(59982);
      return localObject;
    }
    List localList1 = g(parama1);
    List localList2 = g(parama2);
    List localList3 = parama1.hAt();
    List localList4 = parama2.hAt();
    if (localList3.size() != localList4.size())
    {
      while (i < localList1.size())
      {
        if (!g.TPc.d((ab)localList1.get(i), (ab)localList2.get(i)))
        {
          parama1 = a.bug("Type parameter number mismatch");
          AppMethodBeat.o(59982);
          return parama1;
        }
        i += 1;
      }
      parama1 = a.buh("Type parameter number mismatch");
      AppMethodBeat.o(59982);
      return parama1;
    }
    localObject = I(localList3, localList4);
    i = 0;
    while (i < localList3.size())
    {
      if (!a((as)localList3.get(i), (as)localList4.get(i), (g)localObject))
      {
        parama1 = a.bug("Type parameter bounds mismatch");
        AppMethodBeat.o(59982);
        return parama1;
      }
      i += 1;
    }
    i = 0;
    while (i < localList1.size())
    {
      if (!a((ab)localList1.get(i), (ab)localList2.get(i), (g)localObject))
      {
        parama1 = a.bug("Value parameter type mismatch");
        AppMethodBeat.o(59982);
        return parama1;
      }
      i += 1;
    }
    if (((parama1 instanceof t)) && ((parama2 instanceof t)) && (((t)parama1).hAZ() != ((t)parama2).hAZ()))
    {
      parama1 = a.buh("Incompatible suspendability");
      AppMethodBeat.o(59982);
      return parama1;
    }
    if (paramBoolean)
    {
      parama1 = parama1.hAu();
      parama2 = parama2.hAu();
      if ((parama1 != null) && (parama2 != null))
      {
        i = j;
        if (ad.ap(parama2))
        {
          i = j;
          if (ad.ap(parama1)) {
            i = 1;
          }
        }
        if ((i == 0) && (!((g)localObject).c(this.THR.aK(parama2), this.THR.aK(parama1))))
        {
          parama1 = a.buh("Return type mismatch");
          AppMethodBeat.o(59982);
          return parama1;
        }
      }
    }
    parama1 = a.hKz();
    if (parama1 == null) {
      atM(35);
    }
    AppMethodBeat.o(59982);
    return parama1;
  }
  
  public static final class a
  {
    private static final a TIc;
    private final a TId;
    private final String debugMessage;
    
    static
    {
      AppMethodBeat.i(59971);
      TIc = new a(a.TIe, "SUCCESS");
      AppMethodBeat.o(59971);
    }
    
    private a(a parama, String paramString)
    {
      AppMethodBeat.i(59969);
      this.TId = parama;
      this.debugMessage = paramString;
      AppMethodBeat.o(59969);
    }
    
    public static a bug(String paramString)
    {
      AppMethodBeat.i(59967);
      paramString = new a(a.TIf, paramString);
      AppMethodBeat.o(59967);
      return paramString;
    }
    
    public static a buh(String paramString)
    {
      AppMethodBeat.i(59968);
      paramString = new a(a.TIg, paramString);
      AppMethodBeat.o(59968);
      return paramString;
    }
    
    public static a hKz()
    {
      AppMethodBeat.i(59966);
      a locala = TIc;
      if (locala == null) {
        atM(0);
      }
      AppMethodBeat.o(59966);
      return locala;
    }
    
    public final a hKA()
    {
      AppMethodBeat.i(59970);
      a locala = this.TId;
      if (locala == null) {
        atM(5);
      }
      AppMethodBeat.o(59970);
      return locala;
    }
    
    public static enum a
    {
      static
      {
        AppMethodBeat.i(59965);
        TIe = new a("OVERRIDABLE", 0);
        TIf = new a("INCOMPATIBLE", 1);
        TIg = new a("CONFLICT", 2);
        TIh = new a[] { TIe, TIf, TIg };
        AppMethodBeat.o(59965);
      }
      
      private a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.j.i
 * JD-Core Version:    0.7.0.1
 */