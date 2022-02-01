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
  private static final List<d> abks;
  public static final i abkt;
  private static final g.a abku;
  private final kotlin.l.b.a.b.m.a.i abkv;
  private final g.a abkw;
  
  static
  {
    AppMethodBeat.i(60004);
    if (!i.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      abks = j.p(ServiceLoader.load(d.class, d.class.getClassLoader()));
      abku = new g.a()
      {
        public final boolean a(at paramAnonymousat1, at paramAnonymousat2)
        {
          AppMethodBeat.i(59954);
          if (paramAnonymousat1 == null) {
            aDG(0);
          }
          if (paramAnonymousat2 == null) {
            aDG(1);
          }
          boolean bool = paramAnonymousat1.equals(paramAnonymousat2);
          AppMethodBeat.o(59954);
          return bool;
        }
      };
      abkt = new i(abku, kotlin.l.b.a.b.m.a.i.a.abrE);
      AppMethodBeat.o(60004);
      return;
    }
  }
  
  private i(g.a parama, kotlin.l.b.a.b.m.a.i parami)
  {
    AppMethodBeat.i(59975);
    this.abkw = parama;
    this.abkv = parami;
    AppMethodBeat.o(59975);
  }
  
  private static <D extends kotlin.l.b.a.b.b.a> Set<D> E(Set<D> paramSet)
  {
    AppMethodBeat.i(59976);
    if ((!paramSet.isEmpty()) && (kotlin.l.b.a.b.j.d.a.e(kotlin.l.b.a.b.j.d.a.F((l)paramSet.iterator().next())))) {}
    m local2;
    for (boolean bool = true;; bool = false)
    {
      local2 = new m() {};
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
        kotlin.l.b.a.b.b.a locala = (kotlin.l.b.a.b.b.a)((o)localObject2).Mx;
        localObject2 = (kotlin.l.b.a.b.b.a)((o)localObject2).My;
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
  
  private g O(List<as> paramList1, List<as> paramList2)
  {
    AppMethodBeat.i(59984);
    if (paramList1 == null) {
      aDG(38);
    }
    if (paramList2 == null) {
      aDG(39);
    }
    if ((!$assertionsDisabled) && (paramList1.size() != paramList2.size()))
    {
      paramList1 = new AssertionError("Should be the same number of type parameters: " + paramList1 + " vs " + paramList2);
      AppMethodBeat.o(59984);
      throw paramList1;
    }
    if (paramList1.isEmpty())
    {
      paramList1 = kotlin.l.b.a.b.m.a.h.b(this.abkw);
      AppMethodBeat.o(59984);
      return paramList1;
    }
    final HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < paramList1.size())
    {
      localHashMap.put(((as)paramList1.get(i)).iDL(), ((as)paramList2.get(i)).iDL());
      i += 1;
    }
    paramList1 = kotlin.l.b.a.b.m.a.h.b(new g.a()
    {
      public final boolean a(at paramAnonymousat1, at paramAnonymousat2)
      {
        AppMethodBeat.i(59957);
        if (paramAnonymousat1 == null) {
          aDG(0);
        }
        if (paramAnonymousat2 == null) {
          aDG(1);
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
      aDG(73);
    }
    if (paramb == null) {
      aDG(74);
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
        aDG(75);
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
          aDG(76);
        }
        AppMethodBeat.o(59996);
        return paramCollection;
      }
      if (localArrayList.size() == 1)
      {
        paramCollection = j.e(localArrayList);
        if (paramCollection == null) {
          aDG(77);
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
      } while (y.al(((kotlin.l.b.a.b.b.a)paramb.invoke(paramCollection)).iEH()));
      for (;;)
      {
        if (paramCollection != null)
        {
          if (paramCollection == null) {
            aDG(78);
          }
          AppMethodBeat.o(59996);
          return paramCollection;
        }
        paramCollection = j.e(localArrayList);
        if (paramCollection == null) {
          aDG(79);
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
      aDG(94);
    }
    if (paramb == null) {
      aDG(96);
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
        if (localObject2 == i.a.a.abkI)
        {
          localArrayList.add(localObject1);
          paramCollection.remove();
        }
        else if (localObject2 == i.a.a.abkK)
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
      aDG(55);
    }
    if (paramCollection == null) {
      aDG(56);
    }
    if (parame == null) {
      aDG(57);
    }
    if (paramh == null) {
      aDG(58);
    }
    ArrayList localArrayList = new ArrayList(paramCollection.size());
    kotlin.l.b.a.b.o.i locali = kotlin.l.b.a.b.o.i.iQq();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      kotlin.l.b.a.b.b.b localb = (kotlin.l.b.a.b.b.b)paramCollection.next();
      i.a.a locala = b(localb, paramb, parame).iOQ();
      if (paramb == null) {
        aDG(53);
      }
      if (localb == null) {
        aDG(54);
      }
      if ((!az.b(localb.iDQ())) && (az.a(localb, paramb))) {}
      for (int i = 1;; i = 0) {
        switch (9.abkE[locala.ordinal()])
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
      aDG(91);
    }
    if (paramCollection == null) {
      aDG(92);
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
      aDG(83);
    }
    if (parame == null) {
      aDG(84);
    }
    Object localObject = paramCollection.iterator();
    int i = 0;
    int j = 0;
    if (((Iterator)localObject).hasNext())
    {
      kotlin.l.b.a.b.b.b localb = (kotlin.l.b.a.b.b.b)((Iterator)localObject).next();
      switch (9.abkF[localb.iDO().ordinal()])
      {
      }
      for (;;)
      {
        break;
        paramCollection = w.aaKi;
        if (paramCollection == null) {
          aDG(85);
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
    if ((parame.iDV()) && (parame.iDO() != w.aaKl) && (parame.iDO() != w.aaKj)) {}
    while ((j != 0) && (i == 0))
    {
      paramCollection = w.aaKk;
      if (paramCollection == null) {
        aDG(86);
      }
      AppMethodBeat.o(59998);
      return paramCollection;
      bool = false;
    }
    if ((j == 0) && (i != 0))
    {
      if (bool) {}
      for (paramCollection = parame.iDO();; paramCollection = w.aaKl)
      {
        if (paramCollection == null) {
          aDG(87);
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
    paramCollection = a(E((Set)localObject), bool, parame.iDO());
    AppMethodBeat.o(59998);
    return paramCollection;
  }
  
  private static w a(Collection<kotlin.l.b.a.b.b.b> paramCollection, boolean paramBoolean, w paramw)
  {
    AppMethodBeat.i(59999);
    if (paramCollection == null) {
      aDG(88);
    }
    if (paramw == null) {
      aDG(89);
    }
    Object localObject = w.aaKl;
    Iterator localIterator = paramCollection.iterator();
    paramCollection = (Collection<kotlin.l.b.a.b.b.b>)localObject;
    if (localIterator.hasNext())
    {
      localObject = (kotlin.l.b.a.b.b.b)localIterator.next();
      if ((paramBoolean) && (((kotlin.l.b.a.b.b.b)localObject).iDO() == w.aaKl))
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
      localObject = ((kotlin.l.b.a.b.b.b)localObject).iDO();
      break label77;
      if (paramCollection == null) {
        aDG(90);
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
    parama = new i(parama, kotlin.l.b.a.b.m.a.i.a.abrE);
    AppMethodBeat.o(59973);
    return parama;
  }
  
  private static void a(Collection<kotlin.l.b.a.b.b.b> paramCollection, e parame, h paramh)
  {
    AppMethodBeat.i(59997);
    if (paramCollection == null) {
      aDG(80);
    }
    if (parame == null) {
      aDG(81);
    }
    if (paramh == null) {
      aDG(82);
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
    for (localObject = az.aaKR;; localObject = az.aaKQ)
    {
      parame = ((kotlin.l.b.a.b.b.b)a(paramCollection, new kotlin.g.a.b() {})).a(parame, localw, (ba)localObject, b.a.aaJR);
      paramh.a(parame, paramCollection);
      if (($assertionsDisabled) || (!parame.iEL().isEmpty())) {
        break label171;
      }
      paramCollection = new AssertionError("Overridden descriptors should be set for " + b.a.aaJR);
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
      aDG(13);
    }
    if (paramSet == null) {
      aDG(14);
    }
    if (paramb.iEN().iEO())
    {
      paramSet.add(paramb);
      AppMethodBeat.o(59979);
      return;
    }
    if (paramb.iEL().isEmpty())
    {
      paramb = new IllegalStateException("No overridden descriptors found for (fake override) ".concat(String.valueOf(paramb)));
      AppMethodBeat.o(59979);
      throw paramb;
    }
    paramb = paramb.iEL().iterator();
    while (paramb.hasNext()) {
      a((kotlin.l.b.a.b.b.b)paramb.next(), paramSet);
    }
    AppMethodBeat.o(59979);
  }
  
  public static void a(kotlin.l.b.a.b.b.b paramb, kotlin.g.a.b<kotlin.l.b.a.b.b.b, x> paramb1)
  {
    AppMethodBeat.i(60003);
    if (paramb == null) {
      aDG(102);
    }
    Object localObject1 = paramb.iEL().iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (kotlin.l.b.a.b.b.b)((Iterator)localObject1).next();
      if (((kotlin.l.b.a.b.b.b)localObject2).iDQ() == az.aaKQ) {
        a((kotlin.l.b.a.b.b.b)localObject2, paramb1);
      }
    }
    if (paramb.iDQ() != az.aaKQ)
    {
      AppMethodBeat.o(60003);
      return;
    }
    if (paramb == null) {
      aDG(103);
    }
    Object localObject3 = paramb.iEL();
    if (localObject3 == null) {
      aDG(104);
    }
    label132:
    label152:
    label221:
    Object localObject4;
    if (((Collection)localObject3).isEmpty())
    {
      localObject2 = az.aaKV;
      if (localObject2 == null)
      {
        localObject1 = null;
        if (localObject1 != null) {
          break label501;
        }
        if (paramb1 != null) {
          paramb1.invoke(paramb);
        }
        localObject2 = az.aaKO;
        if (!(paramb instanceof aa)) {
          break label518;
        }
        localObject3 = (aa)paramb;
        if (localObject2 == null) {
          aa.aDG(16);
        }
        ((aa)localObject3).aaNF = ((ba)localObject2);
        localObject2 = ((ah)paramb).iFE().iterator();
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
        localObject2 = ((kotlin.l.b.a.b.b.b)localObject5).iDQ();
        if ((!$assertionsDisabled) && (localObject2 == az.aaKQ))
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
          localObject4 = az.b((ba)localObject1, ((kotlin.l.b.a.b.b.b)((Iterator)localObject2).next()).iDQ());
          if ((localObject4 == null) || (((Integer)localObject4).intValue() < 0))
          {
            localObject2 = null;
            break;
          }
        }
      }
      localObject2 = localObject1;
      break;
      if (paramb.iEN() == b.a.aaJR)
      {
        localObject3 = ((Collection)localObject3).iterator();
        do
        {
          localObject1 = localObject2;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject1 = (kotlin.l.b.a.b.b.b)((Iterator)localObject3).next();
        } while ((((kotlin.l.b.a.b.b.b)localObject1).iDO() == w.aaKl) || (((kotlin.l.b.a.b.b.b)localObject1).iDQ().equals(localObject2)));
        localObject1 = null;
        break label132;
      }
      localObject1 = ((ba)localObject2).iGc();
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
          kotlin.l.b.a.b.b.c.p.aDG(9);
        }
        paramb.aaNF = ((ba)localObject2);
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
      paramb.aaNF = ((ba)localObject2);
      if (localObject2 != paramb.iFB().iDQ()) {
        paramb.lJx = false;
      }
      AppMethodBeat.o(60003);
      return;
    }
  }
  
  private static void a(e parame, Collection<kotlin.l.b.a.b.b.b> paramCollection, h paramh)
  {
    AppMethodBeat.i(59991);
    if (parame == null) {
      aDG(60);
    }
    if (paramh == null) {
      aDG(62);
    }
    Object localObject;
    int i;
    if (paramCollection.size() >= 2)
    {
      localObject = new kotlin.g.a.b() {};
      kotlin.g.b.p.k(paramCollection, "$this$all");
      kotlin.g.b.p.k(localObject, "predicate");
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
      localObject = k.x(paramCollection);
      if (localObject == null) {
        aDG(99);
      }
      if (paramh == null) {
        aDG(101);
      }
      a(a(localObject, paramCollection, new kotlin.g.a.b()new kotlin.g.a.b {}, new kotlin.g.a.b() {}), parame, paramh);
    }
    AppMethodBeat.o(59991);
  }
  
  private static boolean a(kotlin.l.b.a.b.b.a parama, Collection<kotlin.l.b.a.b.b.a> paramCollection)
  {
    AppMethodBeat.i(59994);
    if (parama == null) {
      aDG(67);
    }
    if (paramCollection == null) {
      aDG(68);
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
      aDG(9);
    }
    if (paramD2 == null) {
      aDG(10);
    }
    if ((!paramD1.equals(paramD2)) && (a.abjQ.a(paramD1.iEI(), paramD2.iEI(), paramBoolean)))
    {
      AppMethodBeat.o(59977);
      return true;
    }
    paramD2 = paramD2.iEI();
    paramD1 = c.e(paramD1).iterator();
    while (paramD1.hasNext())
    {
      kotlin.l.b.a.b.b.a locala = (kotlin.l.b.a.b.b.a)paramD1.next();
      if (a.abjQ.a(paramD2, locala, paramBoolean))
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
      aDG(69);
    }
    if (paramab1 == null) {
      aDG(70);
    }
    if (parama2 == null) {
      aDG(71);
    }
    if (paramab2 == null) {
      aDG(72);
    }
    boolean bool = abkt.O(parama1.iEG(), parama2.iEG()).c(paramab1, paramab2);
    AppMethodBeat.o(59995);
    return bool;
  }
  
  private boolean a(as paramas1, as paramas2, g paramg)
  {
    AppMethodBeat.i(59987);
    if (paramas1 == null) {
      aDG(45);
    }
    if (paramas2 == null) {
      aDG(46);
    }
    if (paramg == null) {
      aDG(47);
    }
    Object localObject = paramas1.iCz();
    paramas1 = new ArrayList(paramas2.iCz());
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
      aDG(65);
    }
    if (paramp2 == null) {
      aDG(66);
    }
    paramp1 = az.b(paramp1.iDQ(), paramp2.iDQ());
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
      aDG(42);
    }
    if (paramab2 == null) {
      aDG(43);
    }
    if (paramg == null) {
      aDG(44);
    }
    if ((ad.ap(paramab1)) && (ad.ap(paramab2))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(59986);
      return true;
    }
    boolean bool = paramg.d(this.abkv.aK(paramab1), this.abkv.aK(paramab2));
    AppMethodBeat.o(59986);
    return bool;
  }
  
  private a b(kotlin.l.b.a.b.b.a parama1, kotlin.l.b.a.b.b.a parama2, e parame)
  {
    AppMethodBeat.i(59980);
    if (parama1 == null) {
      aDG(15);
    }
    if (parama2 == null) {
      aDG(16);
    }
    parama1 = a(parama1, parama2, parame, false);
    if (parama1 == null) {
      aDG(17);
    }
    AppMethodBeat.o(59980);
    return parama1;
  }
  
  private static a c(kotlin.l.b.a.b.b.a parama1, kotlin.l.b.a.b.b.a parama2)
  {
    AppMethodBeat.i(59983);
    if (parama1 == null) {
      aDG(36);
    }
    if (parama2 == null) {
      aDG(37);
    }
    if ((((parama1 instanceof t)) && (!(parama2 instanceof t))) || (((parama1 instanceof ah)) && (!(parama2 instanceof ah))))
    {
      parama1 = a.bHi("Member kind mismatch");
      AppMethodBeat.o(59983);
      return parama1;
    }
    if ((!(parama1 instanceof t)) && (!(parama1 instanceof ah)))
    {
      parama1 = new IllegalArgumentException("This type of CallableDescriptor cannot be checked for overridability: ".concat(String.valueOf(parama1)));
      AppMethodBeat.o(59983);
      throw parama1;
    }
    if (!parama1.iEU().equals(parama2.iEU()))
    {
      parama1 = a.bHi("Name mismatch");
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
    if (parama1.iEE() == null)
    {
      i = 1;
      if (parama2.iEE() != null) {
        break label53;
      }
    }
    for (;;)
    {
      if (i == j) {
        break label58;
      }
      parama1 = a.bHi("Receiver presence mismatch");
      AppMethodBeat.o(59985);
      return parama1;
      i = 0;
      break;
      label53:
      j = 0;
    }
    label58:
    if (parama1.iEJ().size() != parama2.iEJ().size())
    {
      parama1 = a.bHi("Value parameter number mismatch");
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
      aDG(63);
    }
    if (parama2 == null) {
      aDG(64);
    }
    ab localab1 = parama1.iEH();
    ab localab2 = parama2.iEH();
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
      aj localaj1 = localah1.iFD();
      aj localaj2 = localah2.iFD();
      if ((localaj1 == null) || (localaj2 == null)) {}
      for (bool = true; !bool; bool = a(localaj1, localaj2))
      {
        AppMethodBeat.o(59992);
        return false;
      }
      if ((localah1.iFU()) && (localah2.iFU()))
      {
        bool = abkt.O(parama1.iEG(), parama2.iEG()).d(localab1, localab2);
        AppMethodBeat.o(59992);
        return bool;
      }
      if (((localah1.iFU()) || (!localah2.iFU())) && (a(parama1, localab1, parama2, localab2)))
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
    i.a.a locala = abkt.b(parama2, parama1, null).iOQ();
    parama1 = abkt.b(parama1, parama2, null).iOQ();
    if ((locala == i.a.a.abkI) && (parama1 == i.a.a.abkI))
    {
      parama1 = i.a.a.abkI;
      AppMethodBeat.o(60002);
      return parama1;
    }
    if ((locala == i.a.a.abkK) || (parama1 == i.a.a.abkK))
    {
      parama1 = i.a.a.abkK;
      AppMethodBeat.o(60002);
      return parama1;
    }
    parama1 = i.a.a.abkJ;
    AppMethodBeat.o(60002);
    return parama1;
  }
  
  public static i f(kotlin.l.b.a.b.m.a.i parami)
  {
    AppMethodBeat.i(59974);
    if (parami == null) {
      aDG(1);
    }
    parami = new i(abku, parami);
    AppMethodBeat.o(59974);
    return parami;
  }
  
  private static List<ab> g(kotlin.l.b.a.b.b.a parama)
  {
    AppMethodBeat.i(59988);
    ak localak = parama.iEE();
    ArrayList localArrayList = new ArrayList();
    if (localak != null) {
      localArrayList.add(localak.iFN());
    }
    parama = parama.iEJ().iterator();
    while (parama.hasNext()) {
      localArrayList.add(((av)parama.next()).iFN());
    }
    AppMethodBeat.o(59988);
    return localArrayList;
  }
  
  private static Set<kotlin.l.b.a.b.b.b> u(kotlin.l.b.a.b.b.b paramb)
  {
    AppMethodBeat.i(59978);
    if (paramb == null) {
      aDG(11);
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
      aDG(18);
    }
    if (parama2 == null) {
      aDG(19);
    }
    Object localObject1 = b(parama1, parama2, paramBoolean);
    if (((a)localObject1).iOQ() == i.a.a.abkI) {}
    Object localObject2;
    Object localObject3;
    for (int i = 1;; i = 0)
    {
      localObject2 = abks.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (d)((Iterator)localObject2).next();
        if ((((d)localObject3).iHN() != d.a.abkg) && ((i == 0) || (((d)localObject3).iHN() != d.a.abkh)))
        {
          localObject3 = ((d)localObject3).a(parama1, parama2, parame);
          switch (9.abkD[localObject3.ordinal()])
          {
          default: 
            break;
          case 1: 
            i = 1;
          }
        }
      }
    }
    parama1 = a.bHj("External condition failed");
    AppMethodBeat.o(59981);
    return parama1;
    parama1 = a.bHi("External condition");
    AppMethodBeat.o(59981);
    return parama1;
    if (i == 0)
    {
      if (localObject1 == null) {
        aDG(22);
      }
      AppMethodBeat.o(59981);
      return localObject1;
    }
    localObject1 = abks.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (d)((Iterator)localObject1).next();
      if (((d)localObject2).iHN() == d.a.abkg)
      {
        localObject3 = ((d)localObject2).a(parama1, parama2, parame);
        switch (9.abkD[localObject3.ordinal()])
        {
        default: 
          break;
        case 1: 
          parama1 = new IllegalStateException("Contract violation in " + localObject2.getClass().getName() + " condition. It's not supposed to end with success");
          AppMethodBeat.o(59981);
          throw parama1;
        case 2: 
          parama1 = a.bHj("External condition failed");
          AppMethodBeat.o(59981);
          return parama1;
        case 3: 
          parama1 = a.bHi("External condition");
          AppMethodBeat.o(59981);
          return parama1;
        }
      }
    }
    parama1 = a.iOP();
    if (parama1 == null) {
      aDG(25);
    }
    AppMethodBeat.o(59981);
    return parama1;
  }
  
  public final void a(f paramf, Collection<? extends kotlin.l.b.a.b.b.b> paramCollection1, Collection<? extends kotlin.l.b.a.b.b.b> paramCollection2, e parame, h paramh)
  {
    AppMethodBeat.i(59989);
    if (paramf == null) {
      aDG(48);
    }
    if (paramCollection1 == null) {
      aDG(49);
    }
    if (paramCollection2 == null) {
      aDG(50);
    }
    if (parame == null) {
      aDG(51);
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
      aDG(26);
    }
    if (parama2 == null) {
      aDG(27);
    }
    Object localObject = c(parama1, parama2);
    if (localObject != null)
    {
      if (localObject == null) {
        aDG(28);
      }
      AppMethodBeat.o(59982);
      return localObject;
    }
    List localList1 = g(parama1);
    List localList2 = g(parama2);
    List localList3 = parama1.iEG();
    List localList4 = parama2.iEG();
    if (localList3.size() != localList4.size())
    {
      while (i < localList1.size())
      {
        if (!g.abrB.d((ab)localList1.get(i), (ab)localList2.get(i)))
        {
          parama1 = a.bHi("Type parameter number mismatch");
          AppMethodBeat.o(59982);
          return parama1;
        }
        i += 1;
      }
      parama1 = a.bHj("Type parameter number mismatch");
      AppMethodBeat.o(59982);
      return parama1;
    }
    localObject = O(localList3, localList4);
    i = 0;
    while (i < localList3.size())
    {
      if (!a((as)localList3.get(i), (as)localList4.get(i), (g)localObject))
      {
        parama1 = a.bHi("Type parameter bounds mismatch");
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
        parama1 = a.bHi("Value parameter type mismatch");
        AppMethodBeat.o(59982);
        return parama1;
      }
      i += 1;
    }
    if (((parama1 instanceof t)) && ((parama2 instanceof t)) && (((t)parama1).iFn() != ((t)parama2).iFn()))
    {
      parama1 = a.bHj("Incompatible suspendability");
      AppMethodBeat.o(59982);
      return parama1;
    }
    if (paramBoolean)
    {
      parama1 = parama1.iEH();
      parama2 = parama2.iEH();
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
        if ((i == 0) && (!((g)localObject).c(this.abkv.aK(parama2), this.abkv.aK(parama1))))
        {
          parama1 = a.bHj("Return type mismatch");
          AppMethodBeat.o(59982);
          return parama1;
        }
      }
    }
    parama1 = a.iOP();
    if (parama1 == null) {
      aDG(35);
    }
    AppMethodBeat.o(59982);
    return parama1;
  }
  
  public static final class a
  {
    private static final a abkG;
    private final a abkH;
    private final String debugMessage;
    
    static
    {
      AppMethodBeat.i(59971);
      abkG = new a(a.abkI, "SUCCESS");
      AppMethodBeat.o(59971);
    }
    
    private a(a parama, String paramString)
    {
      AppMethodBeat.i(59969);
      this.abkH = parama;
      this.debugMessage = paramString;
      AppMethodBeat.o(59969);
    }
    
    public static a bHi(String paramString)
    {
      AppMethodBeat.i(59967);
      paramString = new a(a.abkJ, paramString);
      AppMethodBeat.o(59967);
      return paramString;
    }
    
    public static a bHj(String paramString)
    {
      AppMethodBeat.i(59968);
      paramString = new a(a.abkK, paramString);
      AppMethodBeat.o(59968);
      return paramString;
    }
    
    public static a iOP()
    {
      AppMethodBeat.i(59966);
      a locala = abkG;
      if (locala == null) {
        aDG(0);
      }
      AppMethodBeat.o(59966);
      return locala;
    }
    
    public final a iOQ()
    {
      AppMethodBeat.i(59970);
      a locala = this.abkH;
      if (locala == null) {
        aDG(5);
      }
      AppMethodBeat.o(59970);
      return locala;
    }
    
    public static enum a
    {
      static
      {
        AppMethodBeat.i(59965);
        abkI = new a("OVERRIDABLE", 0);
        abkJ = new a("INCOMPATIBLE", 1);
        abkK = new a("CONFLICT", 2);
        abkL = new a[] { abkI, abkJ, abkK };
        AppMethodBeat.o(59965);
      }
      
      private a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.j.i
 * JD-Core Version:    0.7.0.1
 */