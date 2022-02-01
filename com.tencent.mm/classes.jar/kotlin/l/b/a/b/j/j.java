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
import kotlin.ah;
import kotlin.l.b.a.b.b.ao;
import kotlin.l.b.a.b.b.ap;
import kotlin.l.b.a.b.b.ar;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.b.a;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.bd;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.t;
import kotlin.l.b.a.b.b.x;
import kotlin.l.b.a.b.m.a.f.a;
import kotlin.l.b.a.b.m.a.g;
import kotlin.l.b.a.b.m.a.g.a;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.af;
import kotlin.r;

public class j
{
  private static final List<e> ajiZ;
  public static final j ajja;
  private static final kotlin.l.b.a.b.m.a.e.a ajjb;
  private final g ajjc;
  private final kotlin.l.b.a.b.m.a.e.a ajjd;
  
  static
  {
    AppMethodBeat.i(60004);
    if (!j.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      ajiZ = kotlin.a.p.p(ServiceLoader.load(e.class, e.class.getClassLoader()));
      ajjb = new j.1();
      ajja = new j(ajjb, g.a.ajra);
      AppMethodBeat.o(60004);
      return;
    }
  }
  
  private j(kotlin.l.b.a.b.m.a.e.a parama, g paramg)
  {
    AppMethodBeat.i(59975);
    this.ajjd = parama;
    this.ajjc = paramg;
    AppMethodBeat.o(59975);
  }
  
  private static <D extends kotlin.l.b.a.b.b.a> Set<D> Q(Set<D> paramSet)
  {
    AppMethodBeat.i(59976);
    if ((!paramSet.isEmpty()) && (kotlin.l.b.a.b.j.d.a.f(kotlin.l.b.a.b.j.d.a.F((l)paramSet.iterator().next())))) {}
    j.2 local2;
    for (boolean bool = true;; bool = false)
    {
      local2 = new j.2();
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
        Object localObject2 = (r)local2.invoke(localObject1, localIterator2.next());
        kotlin.l.b.a.b.b.a locala = (kotlin.l.b.a.b.b.a)((r)localObject2).bsC;
        localObject2 = (kotlin.l.b.a.b.b.a)((r)localObject2).bsD;
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
  
  public static <H> H a(Collection<H> paramCollection, kotlin.g.a.b<H, kotlin.l.b.a.b.b.a> paramb)
  {
    AppMethodBeat.i(59996);
    if (paramCollection == null) {
      aKu(78);
    }
    if (paramb == null) {
      aKu(79);
    }
    if ((!$assertionsDisabled) && (paramCollection.isEmpty()))
    {
      paramCollection = new AssertionError("Should have at least one overridable descriptor");
      AppMethodBeat.o(59996);
      throw paramCollection;
    }
    if (paramCollection.size() == 1)
    {
      paramCollection = kotlin.a.p.e(paramCollection);
      if (paramCollection == null) {
        aKu(80);
      }
      AppMethodBeat.o(59996);
      return paramCollection;
    }
    ArrayList localArrayList = new ArrayList(2);
    List localList = kotlin.a.p.d(paramCollection, paramb);
    Object localObject = kotlin.a.p.e(paramCollection);
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
          aKu(81);
        }
        AppMethodBeat.o(59996);
        return paramCollection;
      }
      if (localArrayList.size() == 1)
      {
        paramCollection = kotlin.a.p.e(localArrayList);
        if (paramCollection == null) {
          aKu(82);
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
      } while (kotlin.l.b.a.b.m.aa.ac(((kotlin.l.b.a.b.b.a)paramb.invoke(paramCollection)).kob()));
      for (;;)
      {
        if (paramCollection != null)
        {
          if (paramCollection == null) {
            aKu(83);
          }
          AppMethodBeat.o(59996);
          return paramCollection;
        }
        paramCollection = kotlin.a.p.e(localArrayList);
        if (paramCollection == null) {
          aKu(84);
        }
        AppMethodBeat.o(59996);
        return paramCollection;
        paramCollection = null;
      }
    }
  }
  
  public static <H> Collection<H> a(H paramH, Collection<H> paramCollection, kotlin.g.a.b<H, kotlin.l.b.a.b.b.a> paramb, kotlin.g.a.b<H, ah> paramb1)
  {
    AppMethodBeat.i(60001);
    if (paramH == null) {
      aKu(99);
    }
    if (paramb == null) {
      aKu(101);
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
        if (localObject2 == j.a.a.ajjn)
        {
          localArrayList.add(localObject1);
          paramCollection.remove();
        }
        else if (localObject2 == j.a.a.ajjp)
        {
          paramb1.invoke(localObject1);
          paramCollection.remove();
        }
      }
    }
    AppMethodBeat.o(60001);
    return localArrayList;
  }
  
  private Collection<kotlin.l.b.a.b.b.b> a(kotlin.l.b.a.b.b.b paramb, Collection<? extends kotlin.l.b.a.b.b.b> paramCollection, kotlin.l.b.a.b.b.e parame, i parami)
  {
    AppMethodBeat.i(59990);
    if (paramb == null) {
      aKu(59);
    }
    if (paramCollection == null) {
      aKu(60);
    }
    if (parame == null) {
      aKu(61);
    }
    if (parami == null) {
      aKu(62);
    }
    ArrayList localArrayList = new ArrayList(paramCollection.size());
    kotlin.l.b.a.b.o.f localf = kotlin.l.b.a.b.o.f.kBe();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      kotlin.l.b.a.b.b.b localb = (kotlin.l.b.a.b.b.b)paramCollection.next();
      j.a.a locala = b(localb, paramb, parame).kzj();
      if (paramb == null) {
        aKu(57);
      }
      if (localb == null) {
        aKu(58);
      }
      if ((!kotlin.l.b.a.b.b.s.a(localb.knc())) && (kotlin.l.b.a.b.b.s.a(localb, paramb))) {}
      for (int i = 1;; i = 0) {
        switch (8.ajjj[locala.ordinal()])
        {
        default: 
          break;
        case 1: 
          if (i != 0) {
            localf.add(localb);
          }
          localArrayList.add(localb);
          break;
        }
      }
      if (i != 0) {
        parami.b(localb, paramb);
      }
      localArrayList.add(localb);
    }
    parami.a(paramb, localf);
    AppMethodBeat.o(59990);
    return localArrayList;
  }
  
  private static Collection<kotlin.l.b.a.b.b.b> a(kotlin.l.b.a.b.b.e parame, Collection<kotlin.l.b.a.b.b.b> paramCollection)
  {
    AppMethodBeat.i(60000);
    if (parame == null) {
      aKu(96);
    }
    if (paramCollection == null) {
      aKu(97);
    }
    parame = kotlin.a.p.c(paramCollection, new kotlin.g.a.b() {});
    if (parame == null) {
      aKu(98);
    }
    AppMethodBeat.o(60000);
    return parame;
  }
  
  private static kotlin.l.b.a.b.b.ab a(Collection<kotlin.l.b.a.b.b.b> paramCollection, kotlin.l.b.a.b.b.e parame)
  {
    boolean bool = true;
    AppMethodBeat.i(59998);
    if (paramCollection == null) {
      aKu(88);
    }
    if (parame == null) {
      aKu(89);
    }
    Object localObject = paramCollection.iterator();
    int i = 0;
    int j = 0;
    if (((Iterator)localObject).hasNext())
    {
      kotlin.l.b.a.b.b.b localb = (kotlin.l.b.a.b.b.b)((Iterator)localObject).next();
      switch (8.ajjk[localb.knb().ordinal()])
      {
      }
      for (;;)
      {
        break;
        paramCollection = kotlin.l.b.a.b.b.ab.aiGY;
        if (paramCollection == null) {
          aKu(90);
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
    if ((parame.kni()) && (parame.knb() != kotlin.l.b.a.b.b.ab.aiHb) && (parame.knb() != kotlin.l.b.a.b.b.ab.aiGZ)) {}
    while ((j != 0) && (i == 0))
    {
      paramCollection = kotlin.l.b.a.b.b.ab.aiHa;
      if (paramCollection == null) {
        aKu(91);
      }
      AppMethodBeat.o(59998);
      return paramCollection;
      bool = false;
    }
    if ((j == 0) && (i != 0))
    {
      if (bool) {}
      for (paramCollection = parame.knb();; paramCollection = kotlin.l.b.a.b.b.ab.aiHb)
      {
        if (paramCollection == null) {
          aKu(92);
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
    paramCollection = a(Q((Set)localObject), bool, parame.knb());
    AppMethodBeat.o(59998);
    return paramCollection;
  }
  
  private static kotlin.l.b.a.b.b.ab a(Collection<kotlin.l.b.a.b.b.b> paramCollection, boolean paramBoolean, kotlin.l.b.a.b.b.ab paramab)
  {
    AppMethodBeat.i(59999);
    if (paramCollection == null) {
      aKu(93);
    }
    if (paramab == null) {
      aKu(94);
    }
    Object localObject = kotlin.l.b.a.b.b.ab.aiHb;
    Iterator localIterator = paramCollection.iterator();
    paramCollection = (Collection<kotlin.l.b.a.b.b.b>)localObject;
    if (localIterator.hasNext())
    {
      localObject = (kotlin.l.b.a.b.b.b)localIterator.next();
      if ((paramBoolean) && (((kotlin.l.b.a.b.b.b)localObject).knb() == kotlin.l.b.a.b.b.ab.aiHb))
      {
        localObject = paramab;
        label77:
        if (((kotlin.l.b.a.b.b.ab)localObject).compareTo(paramCollection) >= 0) {
          break label117;
        }
      }
    }
    for (;;)
    {
      paramCollection = (Collection<kotlin.l.b.a.b.b.b>)localObject;
      break;
      localObject = ((kotlin.l.b.a.b.b.b)localObject).knb();
      break label77;
      if (paramCollection == null) {
        aKu(95);
      }
      AppMethodBeat.o(59999);
      return paramCollection;
      label117:
      localObject = paramCollection;
    }
  }
  
  public static j a(g paramg, kotlin.l.b.a.b.m.a.e.a parama)
  {
    AppMethodBeat.i(192188);
    if (paramg == null) {
      aKu(2);
    }
    paramg = new j(parama, paramg);
    AppMethodBeat.o(192188);
    return paramg;
  }
  
  private static void a(Collection<kotlin.l.b.a.b.b.b> paramCollection, kotlin.l.b.a.b.b.e parame, i parami)
  {
    AppMethodBeat.i(59997);
    if (paramCollection == null) {
      aKu(85);
    }
    if (parame == null) {
      aKu(86);
    }
    if (parami == null) {
      aKu(87);
    }
    Object localObject = a(parame, paramCollection);
    boolean bool = ((Collection)localObject).isEmpty();
    kotlin.l.b.a.b.b.ab localab;
    if (bool)
    {
      localab = a(paramCollection, parame);
      if (!bool) {
        break label163;
      }
    }
    label163:
    for (localObject = kotlin.l.b.a.b.b.s.aiGJ;; localObject = kotlin.l.b.a.b.b.s.aiGI)
    {
      parame = ((kotlin.l.b.a.b.b.b)a(paramCollection, new j.4())).a(parame, localab, (t)localObject, b.a.aiGm);
      parami.a(parame, paramCollection);
      if (($assertionsDisabled) || (!parame.kof().isEmpty())) {
        break label171;
      }
      paramCollection = new AssertionError("Overridden descriptors should be set for " + b.a.aiGm);
      AppMethodBeat.o(59997);
      throw paramCollection;
      paramCollection = (Collection<kotlin.l.b.a.b.b.b>)localObject;
      break;
    }
    label171:
    parami.e(parame);
    AppMethodBeat.o(59997);
  }
  
  private static void a(kotlin.l.b.a.b.b.b paramb, Set<kotlin.l.b.a.b.b.b> paramSet)
  {
    AppMethodBeat.i(59979);
    if (paramb == null) {
      aKu(15);
    }
    if (paramSet == null) {
      aKu(16);
    }
    if (paramb.koh().koi())
    {
      paramSet.add(paramb);
      AppMethodBeat.o(59979);
      return;
    }
    if (paramb.kof().isEmpty())
    {
      paramb = new IllegalStateException("No overridden descriptors found for (fake override) ".concat(String.valueOf(paramb)));
      AppMethodBeat.o(59979);
      throw paramb;
    }
    paramb = paramb.kof().iterator();
    while (paramb.hasNext()) {
      a((kotlin.l.b.a.b.b.b)paramb.next(), paramSet);
    }
    AppMethodBeat.o(59979);
  }
  
  public static void a(kotlin.l.b.a.b.b.b paramb, kotlin.g.a.b<kotlin.l.b.a.b.b.b, ah> paramb1)
  {
    AppMethodBeat.i(60003);
    if (paramb == null) {
      aKu(107);
    }
    Object localObject1 = paramb.kof().iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (kotlin.l.b.a.b.b.b)((Iterator)localObject1).next();
      if (((kotlin.l.b.a.b.b.b)localObject2).knc() == kotlin.l.b.a.b.b.s.aiGI) {
        a((kotlin.l.b.a.b.b.b)localObject2, paramb1);
      }
    }
    if (paramb.knc() != kotlin.l.b.a.b.b.s.aiGI)
    {
      AppMethodBeat.o(60003);
      return;
    }
    if (paramb == null) {
      aKu(108);
    }
    Object localObject3 = paramb.kof();
    if (localObject3 == null) {
      aKu(109);
    }
    label132:
    label152:
    label221:
    Object localObject4;
    if (((Collection)localObject3).isEmpty())
    {
      localObject2 = kotlin.l.b.a.b.b.s.aiGN;
      if (localObject2 == null)
      {
        localObject1 = null;
        if (localObject1 != null) {
          break label501;
        }
        if (paramb1 != null) {
          paramb1.invoke(paramb);
        }
        localObject2 = kotlin.l.b.a.b.b.s.aiGG;
        if (!(paramb instanceof kotlin.l.b.a.b.b.c.ab)) {
          break label518;
        }
        localObject3 = (kotlin.l.b.a.b.b.c.ab)paramb;
        if (localObject2 == null) {
          kotlin.l.b.a.b.b.c.ab.aKu(16);
        }
        ((kotlin.l.b.a.b.b.c.ab)localObject3).aiKq = ((t)localObject2);
        localObject2 = ((ap)paramb).kpe().iterator();
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label511;
          }
          localObject3 = (ao)((Iterator)localObject2).next();
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
        localObject2 = ((kotlin.l.b.a.b.b.b)localObject5).knc();
        if ((!$assertionsDisabled) && (localObject2 == kotlin.l.b.a.b.b.s.aiGI))
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
          localObject5 = kotlin.l.b.a.b.b.s.a((t)localObject2, (t)localObject1);
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
          localObject4 = kotlin.l.b.a.b.b.s.a((t)localObject1, ((kotlin.l.b.a.b.b.b)((Iterator)localObject2).next()).knc());
          if ((localObject4 == null) || (((Integer)localObject4).intValue() < 0))
          {
            localObject2 = null;
            break;
          }
        }
      }
      localObject2 = localObject1;
      break;
      if (paramb.koh() == b.a.aiGm)
      {
        localObject3 = ((Collection)localObject3).iterator();
        do
        {
          localObject1 = localObject2;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject1 = (kotlin.l.b.a.b.b.b)((Iterator)localObject3).next();
        } while ((((kotlin.l.b.a.b.b.b)localObject1).knb() == kotlin.l.b.a.b.b.ab.aiHb) || (((kotlin.l.b.a.b.b.b)localObject1).knc().equals(localObject2)));
        localObject1 = null;
        break label132;
      }
      localObject1 = ((t)localObject2).koD();
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
          kotlin.l.b.a.b.b.c.p.aKu(9);
        }
        paramb.aiKq = ((t)localObject2);
        AppMethodBeat.o(60003);
        return;
      }
      if ((!$assertionsDisabled) && (!(paramb instanceof kotlin.l.b.a.b.b.c.aa)))
      {
        paramb = new AssertionError();
        AppMethodBeat.o(60003);
        throw paramb;
      }
      paramb = (kotlin.l.b.a.b.b.c.aa)paramb;
      paramb.aiKq = ((t)localObject2);
      if (localObject2 != paramb.kpb().knc()) {
        paramb.oBZ = false;
      }
      AppMethodBeat.o(60003);
      return;
    }
  }
  
  private static void a(kotlin.l.b.a.b.b.e parame, Collection<kotlin.l.b.a.b.b.b> paramCollection, i parami)
  {
    AppMethodBeat.i(59991);
    if (parame == null) {
      aKu(64);
    }
    if (parami == null) {
      aKu(66);
    }
    Object localObject;
    int i;
    if (paramCollection.size() >= 2)
    {
      localObject = new kotlin.g.a.b() {};
      kotlin.g.b.s.u(paramCollection, "$this$all");
      kotlin.g.b.s.u(localObject, "predicate");
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
          a(Collections.singleton((kotlin.l.b.a.b.b.b)paramCollection.next()), parame, parami);
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
      localObject = p.O(paramCollection);
      if (localObject == null) {
        aKu(104);
      }
      if (parami == null) {
        aKu(106);
      }
      a(a(localObject, paramCollection, new j.6(), new kotlin.g.a.b() {}), parame, parami);
    }
    AppMethodBeat.o(59991);
  }
  
  private static boolean a(kotlin.l.b.a.b.b.a parama, Collection<kotlin.l.b.a.b.b.a> paramCollection)
  {
    AppMethodBeat.i(59994);
    if (parama == null) {
      aKu(71);
    }
    if (paramCollection == null) {
      aKu(72);
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
    AppMethodBeat.i(192199);
    if (paramD1 == null) {
      aKu(11);
    }
    if (paramD2 == null) {
      aKu(12);
    }
    if ((!paramD1.equals(paramD2)) && (b.ajiF.a(paramD1.koc(), paramD2.koc(), paramBoolean)))
    {
      AppMethodBeat.o(192199);
      return true;
    }
    paramD2 = paramD2.koc();
    paramD1 = d.e(paramD1).iterator();
    while (paramD1.hasNext())
    {
      kotlin.l.b.a.b.b.a locala = (kotlin.l.b.a.b.b.a)paramD1.next();
      if (b.ajiF.a(paramD2, locala, paramBoolean))
      {
        AppMethodBeat.o(192199);
        return true;
      }
    }
    AppMethodBeat.o(192199);
    return false;
  }
  
  private static boolean a(kotlin.l.b.a.b.b.a parama1, ad paramad1, kotlin.l.b.a.b.b.a parama2, ad paramad2, r<kotlin.l.b.a.b.m.a.m, kotlin.l.b.a.b.m.a.a> paramr)
  {
    AppMethodBeat.i(192239);
    if (parama1 == null) {
      aKu(73);
    }
    if (paramad1 == null) {
      aKu(74);
    }
    if (parama2 == null) {
      aKu(75);
    }
    if (paramad2 == null) {
      aKu(76);
    }
    if (paramr == null) {
      aKu(77);
    }
    boolean bool = kotlin.l.b.a.b.m.a.m.b((kotlin.l.b.a.b.m.a.a)paramr.bsD, paramad1.kAK(), paramad2.kAK());
    AppMethodBeat.o(192239);
    return bool;
  }
  
  private static boolean a(ba paramba1, ba paramba2, r<kotlin.l.b.a.b.m.a.m, kotlin.l.b.a.b.m.a.a> paramr)
  {
    AppMethodBeat.i(192225);
    if (paramba1 == null) {
      aKu(49);
    }
    if (paramba2 == null) {
      aKu(50);
    }
    if (paramr == null) {
      aKu(51);
    }
    Object localObject = paramba1.klF();
    paramba1 = new ArrayList(paramba2.klF());
    if (((List)localObject).size() != paramba1.size())
    {
      AppMethodBeat.o(192225);
      return false;
    }
    paramba2 = ((List)localObject).iterator();
    while (paramba2.hasNext())
    {
      localObject = (ad)paramba2.next();
      ListIterator localListIterator = paramba1.listIterator();
      for (;;)
      {
        if (localListIterator.hasNext()) {
          if (a((ad)localObject, (ad)localListIterator.next(), paramr))
          {
            localListIterator.remove();
            break;
          }
        }
      }
      AppMethodBeat.o(192225);
      return false;
    }
    AppMethodBeat.o(192225);
    return true;
  }
  
  private static boolean a(kotlin.l.b.a.b.b.p paramp1, kotlin.l.b.a.b.b.p paramp2)
  {
    AppMethodBeat.i(59993);
    if (paramp1 == null) {
      aKu(69);
    }
    if (paramp2 == null) {
      aKu(70);
    }
    paramp1 = kotlin.l.b.a.b.b.s.a(paramp1.knc(), paramp2.knc());
    if ((paramp1 == null) || (paramp1.intValue() >= 0))
    {
      AppMethodBeat.o(59993);
      return true;
    }
    AppMethodBeat.o(59993);
    return false;
  }
  
  private static boolean a(ad paramad1, ad paramad2, r<kotlin.l.b.a.b.m.a.m, kotlin.l.b.a.b.m.a.a> paramr)
  {
    AppMethodBeat.i(192222);
    if (paramad1 == null) {
      aKu(46);
    }
    if (paramad2 == null) {
      aKu(47);
    }
    if (paramr == null) {
      aKu(48);
    }
    if ((af.ai(paramad1)) && (af.ai(paramad2))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(192222);
      return true;
    }
    boolean bool = kotlin.l.b.a.b.m.a.m.a((kotlin.l.b.a.b.m.a.a)paramr.bsD, paramad1.kAK(), paramad2.kAK());
    AppMethodBeat.o(192222);
    return bool;
  }
  
  private r<kotlin.l.b.a.b.m.a.m, kotlin.l.b.a.b.m.a.a> ab(List<ba> paramList1, List<ba> paramList2)
  {
    AppMethodBeat.i(192215);
    if (paramList1 == null) {
      aKu(40);
    }
    if (paramList2 == null) {
      aKu(41);
    }
    if ((!$assertionsDisabled) && (paramList1.size() != paramList2.size()))
    {
      paramList1 = new AssertionError("Should be the same number of type parameters: " + paramList1 + " vs " + paramList2);
      AppMethodBeat.o(192215);
      throw paramList1;
    }
    paramList1 = new r(new kotlin.l.b.a.b.m.a.m(this.ajjc, f.a.ajqZ), ac(paramList1, paramList2));
    AppMethodBeat.o(192215);
    return paramList1;
  }
  
  private kotlin.l.b.a.b.m.a.a ac(List<ba> paramList1, List<ba> paramList2)
  {
    AppMethodBeat.i(192218);
    if (paramList1 == null) {
      aKu(42);
    }
    if (paramList2 == null) {
      aKu(43);
    }
    if (paramList1.isEmpty())
    {
      paramList1 = (kotlin.l.b.a.b.m.a.a)new k(null, this.ajjd, this.ajjc).kzk();
      if (paramList1 == null) {
        aKu(44);
      }
      AppMethodBeat.o(192218);
      return paramList1;
    }
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < paramList1.size())
    {
      localHashMap.put(((ba)paramList1.get(i)).kmZ(), ((ba)paramList2.get(i)).kmZ());
      i += 1;
    }
    paramList1 = (kotlin.l.b.a.b.m.a.a)new k(localHashMap, this.ajjd, this.ajjc).kzk();
    if (paramList1 == null) {
      aKu(45);
    }
    AppMethodBeat.o(192218);
    return paramList1;
  }
  
  private a b(kotlin.l.b.a.b.b.a parama1, kotlin.l.b.a.b.b.a parama2, kotlin.l.b.a.b.b.e parame)
  {
    AppMethodBeat.i(59980);
    if (parama1 == null) {
      aKu(17);
    }
    if (parama2 == null) {
      aKu(18);
    }
    parama1 = a(parama1, parama2, parame, false);
    if (parama1 == null) {
      aKu(19);
    }
    AppMethodBeat.o(59980);
    return parama1;
  }
  
  private static a c(kotlin.l.b.a.b.b.a parama1, kotlin.l.b.a.b.b.a parama2)
  {
    AppMethodBeat.i(59983);
    if (parama1 == null) {
      aKu(38);
    }
    if (parama2 == null) {
      aKu(39);
    }
    if ((((parama1 instanceof x)) && (!(parama2 instanceof x))) || (((parama1 instanceof ap)) && (!(parama2 instanceof ap))))
    {
      parama1 = a.bJm("Member kind mismatch");
      AppMethodBeat.o(59983);
      return parama1;
    }
    if ((!(parama1 instanceof x)) && (!(parama1 instanceof ap)))
    {
      parama1 = new IllegalArgumentException("This type of CallableDescriptor cannot be checked for overridability: ".concat(String.valueOf(parama1)));
      AppMethodBeat.o(59983);
      throw parama1;
    }
    if (!parama1.kok().equals(parama2.kok()))
    {
      parama1 = a.bJm("Name mismatch");
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
    if (parama1.knY() == null)
    {
      i = 1;
      if (parama2.knY() != null) {
        break label53;
      }
    }
    for (;;)
    {
      if (i == j) {
        break label58;
      }
      parama1 = a.bJm("Receiver presence mismatch");
      AppMethodBeat.o(59985);
      return parama1;
      i = 0;
      break;
      label53:
      j = 0;
    }
    label58:
    if (parama1.kod().size() != parama2.kod().size())
    {
      parama1 = a.bJm("Value parameter number mismatch");
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
      aKu(67);
    }
    if (parama2 == null) {
      aKu(68);
    }
    ad localad1 = parama1.kob();
    ad localad2 = parama2.kob();
    if ((!$assertionsDisabled) && (localad1 == null))
    {
      parama1 = new AssertionError("Return type of " + parama1 + " is null");
      AppMethodBeat.o(59992);
      throw parama1;
    }
    if ((!$assertionsDisabled) && (localad2 == null))
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
    r localr = ajja.ab(parama1.koa(), parama2.koa());
    boolean bool;
    if ((parama1 instanceof x))
    {
      if ((!$assertionsDisabled) && (!(parama2 instanceof x)))
      {
        parama1 = new AssertionError("b is " + parama2.getClass());
        AppMethodBeat.o(59992);
        throw parama1;
      }
      bool = a(parama1, localad1, parama2, localad2, localr);
      AppMethodBeat.o(59992);
      return bool;
    }
    if ((parama1 instanceof ap))
    {
      if ((!$assertionsDisabled) && (!(parama2 instanceof ap)))
      {
        parama1 = new AssertionError("b is " + parama2.getClass());
        AppMethodBeat.o(59992);
        throw parama1;
      }
      ap localap1 = (ap)parama1;
      ap localap2 = (ap)parama2;
      ar localar1 = localap1.kpd();
      ar localar2 = localap2.kpd();
      if ((localar1 == null) || (localar2 == null)) {}
      for (bool = true; !bool; bool = a(localar1, localar2))
      {
        AppMethodBeat.o(59992);
        return false;
      }
      if ((localap1.kpu()) && (localap2.kpu()))
      {
        bool = kotlin.l.b.a.b.m.a.m.a((kotlin.l.b.a.b.m.a.a)localr.bsD, localad1.kAK(), localad2.kAK());
        AppMethodBeat.o(59992);
        return bool;
      }
      if (((localap1.kpu()) || (!localap2.kpu())) && (a(parama1, localad1, parama2, localad2, localr)))
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
  
  public static j.a.a f(kotlin.l.b.a.b.b.a parama1, kotlin.l.b.a.b.b.a parama2)
  {
    AppMethodBeat.i(60002);
    j.a.a locala = ajja.b(parama2, parama1, null).kzj();
    parama1 = ajja.b(parama1, parama2, null).kzj();
    if ((locala == j.a.a.ajjn) && (parama1 == j.a.a.ajjn))
    {
      parama1 = j.a.a.ajjn;
      AppMethodBeat.o(60002);
      return parama1;
    }
    if ((locala == j.a.a.ajjp) || (parama1 == j.a.a.ajjp))
    {
      parama1 = j.a.a.ajjp;
      AppMethodBeat.o(60002);
      return parama1;
    }
    parama1 = j.a.a.ajjo;
    AppMethodBeat.o(60002);
    return parama1;
  }
  
  private static List<ad> g(kotlin.l.b.a.b.b.a parama)
  {
    AppMethodBeat.i(59988);
    as localas = parama.knY();
    ArrayList localArrayList = new ArrayList();
    if (localas != null) {
      localArrayList.add(localas.koG());
    }
    parama = parama.kod().iterator();
    while (parama.hasNext()) {
      localArrayList.add(((bd)parama.next()).koG());
    }
    AppMethodBeat.o(59988);
    return localArrayList;
  }
  
  public static j g(g paramg)
  {
    AppMethodBeat.i(59974);
    if (paramg == null) {
      aKu(1);
    }
    paramg = new j(ajjb, paramg);
    AppMethodBeat.o(59974);
    return paramg;
  }
  
  private static Set<kotlin.l.b.a.b.b.b> u(kotlin.l.b.a.b.b.b paramb)
  {
    AppMethodBeat.i(59978);
    if (paramb == null) {
      aKu(13);
    }
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    a(paramb, localLinkedHashSet);
    AppMethodBeat.o(59978);
    return localLinkedHashSet;
  }
  
  public final a a(kotlin.l.b.a.b.b.a parama1, kotlin.l.b.a.b.b.a parama2, kotlin.l.b.a.b.b.e parame, boolean paramBoolean)
  {
    AppMethodBeat.i(59981);
    if (parama1 == null) {
      aKu(20);
    }
    if (parama2 == null) {
      aKu(21);
    }
    Object localObject1 = b(parama1, parama2, paramBoolean);
    if (((a)localObject1).kzj() == j.a.a.ajjn) {}
    Object localObject2;
    Object localObject3;
    for (int i = 1;; i = 0)
    {
      localObject2 = ajiZ.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (e)((Iterator)localObject2).next();
        if ((((e)localObject3).krB() != e.a.ajiM) && ((i == 0) || (((e)localObject3).krB() != e.a.ajiN)))
        {
          localObject3 = ((e)localObject3).a(parama1, parama2, parame);
          switch (8.ajji[localObject3.ordinal()])
          {
          default: 
            break;
          case 1: 
            i = 1;
          }
        }
      }
    }
    parama1 = a.bJn("External condition failed");
    if (parama1 == null) {
      aKu(22);
    }
    AppMethodBeat.o(59981);
    return parama1;
    parama1 = a.bJm("External condition");
    if (parama1 == null) {
      aKu(23);
    }
    AppMethodBeat.o(59981);
    return parama1;
    if (i == 0)
    {
      if (localObject1 == null) {
        aKu(24);
      }
      AppMethodBeat.o(59981);
      return localObject1;
    }
    localObject1 = ajiZ.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (e)((Iterator)localObject1).next();
      if (((e)localObject2).krB() == e.a.ajiM)
      {
        localObject3 = ((e)localObject2).a(parama1, parama2, parame);
        switch (8.ajji[localObject3.ordinal()])
        {
        default: 
          break;
        case 1: 
          parama1 = new IllegalStateException("Contract violation in " + localObject2.getClass().getName() + " condition. It's not supposed to end with success");
          AppMethodBeat.o(59981);
          throw parama1;
        case 2: 
          parama1 = a.bJn("External condition failed");
          if (parama1 == null) {
            aKu(25);
          }
          AppMethodBeat.o(59981);
          return parama1;
        case 3: 
          parama1 = a.bJm("External condition");
          if (parama1 == null) {
            aKu(26);
          }
          AppMethodBeat.o(59981);
          return parama1;
        }
      }
    }
    parama1 = a.kzi();
    if (parama1 == null) {
      aKu(27);
    }
    AppMethodBeat.o(59981);
    return parama1;
  }
  
  public final void a(kotlin.l.b.a.b.f.f paramf, Collection<? extends kotlin.l.b.a.b.b.b> paramCollection1, Collection<? extends kotlin.l.b.a.b.b.b> paramCollection2, kotlin.l.b.a.b.b.e parame, i parami)
  {
    AppMethodBeat.i(59989);
    if (paramf == null) {
      aKu(52);
    }
    if (paramCollection1 == null) {
      aKu(53);
    }
    if (paramCollection2 == null) {
      aKu(54);
    }
    if (parame == null) {
      aKu(55);
    }
    paramf = new LinkedHashSet(paramCollection1);
    paramCollection2 = paramCollection2.iterator();
    while (paramCollection2.hasNext()) {
      paramf.removeAll(a((kotlin.l.b.a.b.b.b)paramCollection2.next(), paramCollection1, parame, parami));
    }
    a(parame, paramf, parami);
    AppMethodBeat.o(59989);
  }
  
  public final a b(kotlin.l.b.a.b.b.a parama1, kotlin.l.b.a.b.b.a parama2, boolean paramBoolean)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(59982);
    if (parama1 == null) {
      aKu(28);
    }
    if (parama2 == null) {
      aKu(29);
    }
    Object localObject = c(parama1, parama2);
    if (localObject != null)
    {
      if (localObject == null) {
        aKu(30);
      }
      AppMethodBeat.o(59982);
      return localObject;
    }
    List localList1 = g(parama1);
    List localList2 = g(parama2);
    List localList3 = parama1.koa();
    List localList4 = parama2.koa();
    if (localList3.size() != localList4.size())
    {
      while (i < localList1.size())
      {
        if (!kotlin.l.b.a.b.m.a.e.ajqY.e((ad)localList1.get(i), (ad)localList2.get(i)))
        {
          parama1 = a.bJm("Type parameter number mismatch");
          if (parama1 == null) {
            aKu(31);
          }
          AppMethodBeat.o(59982);
          return parama1;
        }
        i += 1;
      }
      parama1 = a.bJn("Type parameter number mismatch");
      if (parama1 == null) {
        aKu(32);
      }
      AppMethodBeat.o(59982);
      return parama1;
    }
    localObject = ab(localList3, localList4);
    i = 0;
    while (i < localList3.size())
    {
      if (!a((ba)localList3.get(i), (ba)localList4.get(i), (r)localObject))
      {
        parama1 = a.bJm("Type parameter bounds mismatch");
        if (parama1 == null) {
          aKu(33);
        }
        AppMethodBeat.o(59982);
        return parama1;
      }
      i += 1;
    }
    i = 0;
    while (i < localList1.size())
    {
      if (!a((ad)localList1.get(i), (ad)localList2.get(i), (r)localObject))
      {
        parama1 = a.bJm("Value parameter type mismatch");
        if (parama1 == null) {
          aKu(34);
        }
        AppMethodBeat.o(59982);
        return parama1;
      }
      i += 1;
    }
    if (((parama1 instanceof x)) && ((parama2 instanceof x)) && (((x)parama1).koN() != ((x)parama2).koN()))
    {
      parama1 = a.bJn("Incompatible suspendability");
      if (parama1 == null) {
        aKu(35);
      }
      AppMethodBeat.o(59982);
      return parama1;
    }
    if (paramBoolean)
    {
      parama1 = parama1.kob();
      parama2 = parama2.kob();
      if ((parama1 != null) && (parama2 != null))
      {
        i = j;
        if (af.ai(parama2))
        {
          i = j;
          if (af.ai(parama1)) {
            i = 1;
          }
        }
        if ((i == 0) && (!kotlin.l.b.a.b.m.a.m.b((kotlin.l.b.a.b.m.a.a)((r)localObject).bsD, parama2.kAK(), parama1.kAK())))
        {
          parama1 = a.bJn("Return type mismatch");
          if (parama1 == null) {
            aKu(36);
          }
          AppMethodBeat.o(59982);
          return parama1;
        }
      }
    }
    parama1 = a.kzi();
    if (parama1 == null) {
      aKu(37);
    }
    AppMethodBeat.o(59982);
    return parama1;
  }
  
  public static final class a
  {
    private static final a ajjl;
    private final a ajjm;
    private final String debugMessage;
    
    static
    {
      AppMethodBeat.i(59971);
      ajjl = new a(a.ajjn, "SUCCESS");
      AppMethodBeat.o(59971);
    }
    
    private a(a parama, String paramString)
    {
      AppMethodBeat.i(59969);
      this.ajjm = parama;
      this.debugMessage = paramString;
      AppMethodBeat.o(59969);
    }
    
    public static a bJm(String paramString)
    {
      AppMethodBeat.i(59967);
      paramString = new a(a.ajjo, paramString);
      AppMethodBeat.o(59967);
      return paramString;
    }
    
    public static a bJn(String paramString)
    {
      AppMethodBeat.i(59968);
      paramString = new a(a.ajjp, paramString);
      AppMethodBeat.o(59968);
      return paramString;
    }
    
    public static a kzi()
    {
      AppMethodBeat.i(59966);
      a locala = ajjl;
      if (locala == null) {
        aKu(0);
      }
      AppMethodBeat.o(59966);
      return locala;
    }
    
    public final a kzj()
    {
      AppMethodBeat.i(59970);
      a locala = this.ajjm;
      if (locala == null) {
        aKu(5);
      }
      AppMethodBeat.o(59970);
      return locala;
    }
    
    public static enum a
    {
      static
      {
        AppMethodBeat.i(59965);
        ajjn = new a("OVERRIDABLE", 0);
        ajjo = new a("INCOMPATIBLE", 1);
        ajjp = new a("CONFLICT", 2);
        ajjq = new a[] { ajjn, ajjo, ajjp };
        AppMethodBeat.o(59965);
      }
      
      private a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.j.j
 * JD-Core Version:    0.7.0.1
 */