package d.l.b.a.b.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.g.a.m;
import d.l.b.a.b.b.ag;
import d.l.b.a.b.b.ah;
import d.l.b.a.b.b.aj;
import d.l.b.a.b.b.ak;
import d.l.b.a.b.b.as;
import d.l.b.a.b.b.av;
import d.l.b.a.b.b.az;
import d.l.b.a.b.b.b.a;
import d.l.b.a.b.b.ba;
import d.l.b.a.b.b.c.aa;
import d.l.b.a.b.b.c.z;
import d.l.b.a.b.b.e;
import d.l.b.a.b.b.l;
import d.l.b.a.b.b.t;
import d.l.b.a.b.b.v;
import d.l.b.a.b.b.w;
import d.l.b.a.b.f.f;
import d.l.b.a.b.m.a.g;
import d.l.b.a.b.m.a.g.a;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.ad;
import d.l.b.a.b.m.at;
import d.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collection<Ld.l.b.a.b.b.b;>;
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

public class i
{
  private static final List<d> JRu;
  public static final i JRv;
  private static final g.a JRw;
  private final d.l.b.a.b.m.a.i JRx;
  private final g.a JRy;
  
  static
  {
    AppMethodBeat.i(60004);
    if (!i.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      JRu = j.m(ServiceLoader.load(d.class, d.class.getClassLoader()));
      JRw = new i.1();
      JRv = new i(JRw, d.l.b.a.b.m.a.i.a.JYQ);
      AppMethodBeat.o(60004);
      return;
    }
  }
  
  private i(g.a parama, d.l.b.a.b.m.a.i parami)
  {
    AppMethodBeat.i(59975);
    this.JRy = parama;
    this.JRx = parami;
    AppMethodBeat.o(59975);
  }
  
  private g L(List<as> paramList1, List<as> paramList2)
  {
    AppMethodBeat.i(59984);
    if (paramList1 == null) {
      adP(38);
    }
    if (paramList2 == null) {
      adP(39);
    }
    if ((!$assertionsDisabled) && (paramList1.size() != paramList2.size()))
    {
      paramList1 = new AssertionError("Should be the same number of type parameters: " + paramList1 + " vs " + paramList2);
      AppMethodBeat.o(59984);
      throw paramList1;
    }
    if (paramList1.isEmpty())
    {
      paramList1 = d.l.b.a.b.m.a.h.b(this.JRy);
      AppMethodBeat.o(59984);
      return paramList1;
    }
    final HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < paramList1.size())
    {
      localHashMap.put(((as)paramList1.get(i)).fxs(), ((as)paramList2.get(i)).fxs());
      i += 1;
    }
    paramList1 = d.l.b.a.b.m.a.h.b(new g.a()
    {
      public final boolean a(at paramAnonymousat1, at paramAnonymousat2)
      {
        AppMethodBeat.i(59957);
        if (paramAnonymousat1 == null) {
          adP(0);
        }
        if (paramAnonymousat2 == null) {
          adP(1);
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
  
  private static w a(Collection<d.l.b.a.b.b.b> paramCollection, e parame)
  {
    boolean bool = true;
    AppMethodBeat.i(59998);
    if (paramCollection == null) {
      adP(83);
    }
    if (parame == null) {
      adP(84);
    }
    Object localObject = paramCollection.iterator();
    int i = 0;
    int j = 0;
    if (((Iterator)localObject).hasNext())
    {
      d.l.b.a.b.b.b localb = (d.l.b.a.b.b.b)((Iterator)localObject).next();
      switch (9.JRH[localb.fxv().ordinal()])
      {
      }
      for (;;)
      {
        break;
        paramCollection = w.Jqn;
        if (paramCollection == null) {
          adP(85);
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
    if ((parame.fxC()) && (parame.fxv() != w.Jqq) && (parame.fxv() != w.Jqo)) {}
    while ((j != 0) && (i == 0))
    {
      paramCollection = w.Jqp;
      if (paramCollection == null) {
        adP(86);
      }
      AppMethodBeat.o(59998);
      return paramCollection;
      bool = false;
    }
    if ((j == 0) && (i != 0))
    {
      if (bool) {}
      for (paramCollection = parame.fxv();; paramCollection = w.Jqq)
      {
        if (paramCollection == null) {
          adP(87);
        }
        AppMethodBeat.o(59998);
        return paramCollection;
      }
    }
    localObject = new HashSet();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      ((Set)localObject).addAll(u((d.l.b.a.b.b.b)paramCollection.next()));
    }
    paramCollection = a(o((Set)localObject), bool, parame.fxv());
    AppMethodBeat.o(59998);
    return paramCollection;
  }
  
  private static w a(Collection<d.l.b.a.b.b.b> paramCollection, boolean paramBoolean, w paramw)
  {
    AppMethodBeat.i(59999);
    if (paramCollection == null) {
      adP(88);
    }
    if (paramw == null) {
      adP(89);
    }
    Object localObject = w.Jqq;
    Iterator localIterator = paramCollection.iterator();
    paramCollection = (Collection<d.l.b.a.b.b.b>)localObject;
    if (localIterator.hasNext())
    {
      localObject = (d.l.b.a.b.b.b)localIterator.next();
      if ((paramBoolean) && (((d.l.b.a.b.b.b)localObject).fxv() == w.Jqq))
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
      paramCollection = (Collection<d.l.b.a.b.b.b>)localObject;
      break;
      localObject = ((d.l.b.a.b.b.b)localObject).fxv();
      break label77;
      if (paramCollection == null) {
        adP(90);
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
    parama = new i(parama, d.l.b.a.b.m.a.i.a.JYQ);
    AppMethodBeat.o(59973);
    return parama;
  }
  
  public static <H> H a(Collection<H> paramCollection, d.g.a.b<H, d.l.b.a.b.b.a> paramb)
  {
    AppMethodBeat.i(59996);
    if (paramCollection == null) {
      adP(73);
    }
    if (paramb == null) {
      adP(74);
    }
    if ((!$assertionsDisabled) && (paramCollection.isEmpty()))
    {
      paramCollection = new AssertionError("Should have at least one overridable descriptor");
      AppMethodBeat.o(59996);
      throw paramCollection;
    }
    if (paramCollection.size() == 1)
    {
      paramCollection = j.c(paramCollection);
      if (paramCollection == null) {
        adP(75);
      }
      AppMethodBeat.o(59996);
      return paramCollection;
    }
    ArrayList localArrayList = new ArrayList(2);
    List localList = j.d(paramCollection, paramb);
    Object localObject = j.c(paramCollection);
    d.l.b.a.b.b.a locala1 = (d.l.b.a.b.b.a)paramb.aA(localObject);
    Iterator localIterator = paramCollection.iterator();
    paramCollection = (Collection<H>)localObject;
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      d.l.b.a.b.b.a locala2 = (d.l.b.a.b.b.a)paramb.aA(localObject);
      if (a(locala2, localList)) {
        localArrayList.add(localObject);
      }
      if ((!e(locala2, locala1)) || (e(locala1, locala2))) {
        break label356;
      }
      paramCollection = (Collection<H>)localObject;
    }
    label356:
    for (;;)
    {
      break;
      if (localArrayList.isEmpty())
      {
        if (paramCollection == null) {
          adP(76);
        }
        AppMethodBeat.o(59996);
        return paramCollection;
      }
      if (localArrayList.size() == 1)
      {
        paramCollection = j.c(localArrayList);
        if (paramCollection == null) {
          adP(77);
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
      } while (d.l.b.a.b.m.y.am(((d.l.b.a.b.b.a)paramb.aA(paramCollection)).fyo()));
      for (;;)
      {
        if (paramCollection != null)
        {
          if (paramCollection == null) {
            adP(78);
          }
          AppMethodBeat.o(59996);
          return paramCollection;
        }
        paramCollection = j.c(localArrayList);
        if (paramCollection == null) {
          adP(79);
        }
        AppMethodBeat.o(59996);
        return paramCollection;
        paramCollection = null;
      }
    }
  }
  
  private Collection<d.l.b.a.b.b.b> a(d.l.b.a.b.b.b paramb, Collection<? extends d.l.b.a.b.b.b> paramCollection, e parame, h paramh)
  {
    AppMethodBeat.i(59990);
    if (paramb == null) {
      adP(55);
    }
    if (paramCollection == null) {
      adP(56);
    }
    if (parame == null) {
      adP(57);
    }
    if (paramh == null) {
      adP(58);
    }
    ArrayList localArrayList = new ArrayList(paramCollection.size());
    d.l.b.a.b.o.i locali = d.l.b.a.b.o.i.fKq();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      d.l.b.a.b.b.b localb = (d.l.b.a.b.b.b)paramCollection.next();
      i.a.a locala = b(localb, paramb, parame).fIS();
      if (paramb == null) {
        adP(53);
      }
      if (localb == null) {
        adP(54);
      }
      if ((!az.b(localb.fxx())) && (az.a(localb, paramb))) {}
      for (int i = 1;; i = 0) {
        switch (9.JRG[locala.ordinal()])
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
  
  private static Collection<d.l.b.a.b.b.b> a(e parame, Collection<d.l.b.a.b.b.b> paramCollection)
  {
    AppMethodBeat.i(60000);
    if (parame == null) {
      adP(91);
    }
    if (paramCollection == null) {
      adP(92);
    }
    parame = j.c(paramCollection, new d.g.a.b() {});
    AppMethodBeat.o(60000);
    return parame;
  }
  
  public static <H> Collection<H> a(H paramH, Collection<H> paramCollection, d.g.a.b<H, d.l.b.a.b.b.a> paramb, d.g.a.b<H, d.y> paramb1)
  {
    AppMethodBeat.i(60001);
    if (paramH == null) {
      adP(94);
    }
    if (paramb == null) {
      adP(96);
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramH);
    d.l.b.a.b.b.a locala = (d.l.b.a.b.b.a)paramb.aA(paramH);
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      Object localObject1 = paramCollection.next();
      Object localObject2 = (d.l.b.a.b.b.a)paramb.aA(localObject1);
      if (paramH == localObject1)
      {
        paramCollection.remove();
      }
      else
      {
        localObject2 = f(locala, (d.l.b.a.b.b.a)localObject2);
        if (localObject2 == i.a.a.JRL)
        {
          localArrayList.add(localObject1);
          paramCollection.remove();
        }
        else if (localObject2 == i.a.a.JRN)
        {
          paramb1.aA(localObject1);
          paramCollection.remove();
        }
      }
    }
    AppMethodBeat.o(60001);
    return localArrayList;
  }
  
  public static void a(d.l.b.a.b.b.b paramb, d.g.a.b<d.l.b.a.b.b.b, d.y> paramb1)
  {
    AppMethodBeat.i(60003);
    if (paramb == null) {
      adP(102);
    }
    Object localObject1 = paramb.fys().iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (d.l.b.a.b.b.b)((Iterator)localObject1).next();
      if (((d.l.b.a.b.b.b)localObject2).fxx() == az.JqV) {
        a((d.l.b.a.b.b.b)localObject2, paramb1);
      }
    }
    if (paramb.fxx() != az.JqV)
    {
      AppMethodBeat.o(60003);
      return;
    }
    if (paramb == null) {
      adP(103);
    }
    Object localObject3 = paramb.fys();
    if (localObject3 == null) {
      adP(104);
    }
    label132:
    label152:
    label221:
    Object localObject4;
    if (((Collection)localObject3).isEmpty())
    {
      localObject2 = az.Jra;
      if (localObject2 == null)
      {
        localObject1 = null;
        if (localObject1 != null) {
          break label501;
        }
        if (paramb1 != null) {
          paramb1.aA(paramb);
        }
        localObject2 = az.JqT;
        if (!(paramb instanceof aa)) {
          break label518;
        }
        localObject3 = (aa)paramb;
        if (localObject2 == null) {
          aa.adP(16);
        }
        ((aa)localObject3).JtI = ((ba)localObject2);
        localObject2 = ((ah)paramb).fzi().iterator();
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
          a((d.l.b.a.b.b.b)localObject3, paramb);
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
        Object localObject5 = (d.l.b.a.b.b.b)((Iterator)localObject4).next();
        localObject2 = ((d.l.b.a.b.b.b)localObject5).fxx();
        if ((!$assertionsDisabled) && (localObject2 == az.JqV))
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
          localObject4 = az.b((ba)localObject1, ((d.l.b.a.b.b.b)((Iterator)localObject2).next()).fxx());
          if ((localObject4 == null) || (((Integer)localObject4).intValue() < 0))
          {
            localObject2 = null;
            break;
          }
        }
      }
      localObject2 = localObject1;
      break;
      if (paramb.fyu() == b.a.JpW)
      {
        localObject3 = ((Collection)localObject3).iterator();
        do
        {
          localObject1 = localObject2;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject1 = (d.l.b.a.b.b.b)((Iterator)localObject3).next();
        } while ((((d.l.b.a.b.b.b)localObject1).fxv() == w.Jqq) || (((d.l.b.a.b.b.b)localObject1).fxx().equals(localObject2)));
        localObject1 = null;
        break label132;
      }
      localObject1 = ((ba)localObject2).fzG();
      break label132;
      label501:
      localObject2 = localObject1;
      break label152;
      paramb = paramb1;
      break label221;
      label511:
      AppMethodBeat.o(60003);
      return;
      if ((paramb instanceof d.l.b.a.b.b.c.p))
      {
        paramb = (d.l.b.a.b.b.c.p)paramb;
        if (localObject2 == null) {
          d.l.b.a.b.b.c.p.adP(9);
        }
        paramb.JtI = ((ba)localObject2);
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
      paramb.JtI = ((ba)localObject2);
      if (localObject2 != paramb.fzf().fxx()) {
        paramb.isDefault = false;
      }
      AppMethodBeat.o(60003);
      return;
    }
  }
  
  private static void a(d.l.b.a.b.b.b paramb, Set<d.l.b.a.b.b.b> paramSet)
  {
    AppMethodBeat.i(59979);
    if (paramb == null) {
      adP(13);
    }
    if (paramSet == null) {
      adP(14);
    }
    if (paramb.fyu().fyv())
    {
      paramSet.add(paramb);
      AppMethodBeat.o(59979);
      return;
    }
    if (paramb.fys().isEmpty())
    {
      paramb = new IllegalStateException("No overridden descriptors found for (fake override) ".concat(String.valueOf(paramb)));
      AppMethodBeat.o(59979);
      throw paramb;
    }
    paramb = paramb.fys().iterator();
    while (paramb.hasNext()) {
      a((d.l.b.a.b.b.b)paramb.next(), paramSet);
    }
    AppMethodBeat.o(59979);
  }
  
  private static void a(e parame, Collection<d.l.b.a.b.b.b> paramCollection, h paramh)
  {
    AppMethodBeat.i(59991);
    if (parame == null) {
      adP(60);
    }
    if (paramh == null) {
      adP(62);
    }
    Object localObject;
    int i;
    if (paramCollection.size() >= 2)
    {
      localObject = new d.g.a.b() {};
      d.g.b.k.h(paramCollection, "$this$all");
      d.g.b.k.h(localObject, "predicate");
      if (!((Collection)paramCollection).isEmpty())
      {
        Iterator localIterator = paramCollection.iterator();
        while (localIterator.hasNext()) {
          if (!((Boolean)((d.g.a.b)localObject).aA(localIterator.next())).booleanValue()) {
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
          a(Collections.singleton((d.l.b.a.b.b.b)paramCollection.next()), parame, paramh);
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
      localObject = k.u(paramCollection);
      if (localObject == null) {
        adP(99);
      }
      if (paramh == null) {
        adP(101);
      }
      a(a(localObject, paramCollection, new d.g.a.b()new d.g.a.b {}, new d.g.a.b() {}), parame, paramh);
    }
    AppMethodBeat.o(59991);
  }
  
  private static void a(Collection<d.l.b.a.b.b.b> paramCollection, e parame, h paramh)
  {
    AppMethodBeat.i(59997);
    if (paramCollection == null) {
      adP(80);
    }
    if (parame == null) {
      adP(81);
    }
    if (paramh == null) {
      adP(82);
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
    for (localObject = az.JqW;; localObject = az.JqV)
    {
      parame = ((d.l.b.a.b.b.b)a(paramCollection, new d.g.a.b() {})).a(parame, localw, (ba)localObject, b.a.JpW);
      paramh.a(parame, paramCollection);
      if (($assertionsDisabled) || (!parame.fys().isEmpty())) {
        break label171;
      }
      paramCollection = new AssertionError("Overridden descriptors should be set for " + b.a.JpW);
      AppMethodBeat.o(59997);
      throw paramCollection;
      paramCollection = (Collection<d.l.b.a.b.b.b>)localObject;
      break;
    }
    label171:
    paramh.e(parame);
    AppMethodBeat.o(59997);
  }
  
  private static <D extends d.l.b.a.b.b.a> boolean a(D paramD1, D paramD2, boolean paramBoolean)
  {
    AppMethodBeat.i(59977);
    if (paramD1 == null) {
      adP(9);
    }
    if (paramD2 == null) {
      adP(10);
    }
    if ((!paramD1.equals(paramD2)) && (a.JQS.a(paramD1.fyp(), paramD2.fyp(), paramBoolean)))
    {
      AppMethodBeat.o(59977);
      return true;
    }
    paramD2 = paramD2.fyp();
    paramD1 = c.e(paramD1).iterator();
    while (paramD1.hasNext())
    {
      d.l.b.a.b.b.a locala = (d.l.b.a.b.b.a)paramD1.next();
      if (a.JQS.a(paramD2, locala, paramBoolean))
      {
        AppMethodBeat.o(59977);
        return true;
      }
    }
    AppMethodBeat.o(59977);
    return false;
  }
  
  private static boolean a(d.l.b.a.b.b.a parama1, ab paramab1, d.l.b.a.b.b.a parama2, ab paramab2)
  {
    AppMethodBeat.i(59995);
    if (parama1 == null) {
      adP(69);
    }
    if (paramab1 == null) {
      adP(70);
    }
    if (parama2 == null) {
      adP(71);
    }
    if (paramab2 == null) {
      adP(72);
    }
    boolean bool = JRv.L(parama1.fyn(), parama2.fyn()).c(paramab1, paramab2);
    AppMethodBeat.o(59995);
    return bool;
  }
  
  private static boolean a(d.l.b.a.b.b.a parama, Collection<d.l.b.a.b.b.a> paramCollection)
  {
    AppMethodBeat.i(59994);
    if (parama == null) {
      adP(67);
    }
    if (paramCollection == null) {
      adP(68);
    }
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      if (!e(parama, (d.l.b.a.b.b.a)paramCollection.next()))
      {
        AppMethodBeat.o(59994);
        return false;
      }
    }
    AppMethodBeat.o(59994);
    return true;
  }
  
  private boolean a(as paramas1, as paramas2, g paramg)
  {
    AppMethodBeat.i(59987);
    if (paramas1 == null) {
      adP(45);
    }
    if (paramas2 == null) {
      adP(46);
    }
    if (paramg == null) {
      adP(47);
    }
    Object localObject = paramas1.fwf();
    paramas1 = new ArrayList(paramas2.fwf());
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
  
  private static boolean a(d.l.b.a.b.b.p paramp1, d.l.b.a.b.b.p paramp2)
  {
    AppMethodBeat.i(59993);
    if (paramp1 == null) {
      adP(65);
    }
    if (paramp2 == null) {
      adP(66);
    }
    paramp1 = az.b(paramp1.fxx(), paramp2.fxx());
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
      adP(42);
    }
    if (paramab2 == null) {
      adP(43);
    }
    if (paramg == null) {
      adP(44);
    }
    if ((ad.aq(paramab1)) && (ad.aq(paramab2))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(59986);
      return true;
    }
    boolean bool = paramg.d(this.JRx.aL(paramab1), this.JRx.aL(paramab2));
    AppMethodBeat.o(59986);
    return bool;
  }
  
  private a b(d.l.b.a.b.b.a parama1, d.l.b.a.b.b.a parama2, e parame)
  {
    AppMethodBeat.i(59980);
    if (parama1 == null) {
      adP(15);
    }
    if (parama2 == null) {
      adP(16);
    }
    parama1 = a(parama1, parama2, parame, false);
    if (parama1 == null) {
      adP(17);
    }
    AppMethodBeat.o(59980);
    return parama1;
  }
  
  private static a c(d.l.b.a.b.b.a parama1, d.l.b.a.b.b.a parama2)
  {
    AppMethodBeat.i(59983);
    if (parama1 == null) {
      adP(36);
    }
    if (parama2 == null) {
      adP(37);
    }
    if ((((parama1 instanceof t)) && (!(parama2 instanceof t))) || (((parama1 instanceof ah)) && (!(parama2 instanceof ah))))
    {
      parama1 = a.aQL("Member kind mismatch");
      AppMethodBeat.o(59983);
      return parama1;
    }
    if ((!(parama1 instanceof t)) && (!(parama1 instanceof ah)))
    {
      parama1 = new IllegalArgumentException("This type of CallableDescriptor cannot be checked for overridability: ".concat(String.valueOf(parama1)));
      AppMethodBeat.o(59983);
      throw parama1;
    }
    if (!parama1.fyB().equals(parama2.fyB()))
    {
      parama1 = a.aQL("Name mismatch");
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
  
  private static a d(d.l.b.a.b.b.a parama1, d.l.b.a.b.b.a parama2)
  {
    int j = 1;
    AppMethodBeat.i(59985);
    int i;
    if (parama1.fyl() == null)
    {
      i = 1;
      if (parama2.fyl() != null) {
        break label53;
      }
    }
    for (;;)
    {
      if (i == j) {
        break label58;
      }
      parama1 = a.aQL("Receiver presence mismatch");
      AppMethodBeat.o(59985);
      return parama1;
      i = 0;
      break;
      label53:
      j = 0;
    }
    label58:
    if (parama1.fyq().size() != parama2.fyq().size())
    {
      parama1 = a.aQL("Value parameter number mismatch");
      AppMethodBeat.o(59985);
      return parama1;
    }
    AppMethodBeat.o(59985);
    return null;
  }
  
  public static boolean e(d.l.b.a.b.b.a parama1, d.l.b.a.b.b.a parama2)
  {
    AppMethodBeat.i(59992);
    if (parama1 == null) {
      adP(63);
    }
    if (parama2 == null) {
      adP(64);
    }
    ab localab1 = parama1.fyo();
    ab localab2 = parama2.fyo();
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
      aj localaj1 = localah1.fzh();
      aj localaj2 = localah2.fzh();
      if ((localaj1 == null) || (localaj2 == null)) {}
      for (bool = true; !bool; bool = a(localaj1, localaj2))
      {
        AppMethodBeat.o(59992);
        return false;
      }
      if ((localah1.fzy()) && (localah2.fzy()))
      {
        bool = JRv.L(parama1.fyn(), parama2.fyn()).d(localab1, localab2);
        AppMethodBeat.o(59992);
        return bool;
      }
      if (((localah1.fzy()) || (!localah2.fzy())) && (a(parama1, localab1, parama2, localab2)))
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
  
  public static i.a.a f(d.l.b.a.b.b.a parama1, d.l.b.a.b.b.a parama2)
  {
    AppMethodBeat.i(60002);
    i.a.a locala = JRv.b(parama2, parama1, null).fIS();
    parama1 = JRv.b(parama1, parama2, null).fIS();
    if ((locala == i.a.a.JRL) && (parama1 == i.a.a.JRL))
    {
      parama1 = i.a.a.JRL;
      AppMethodBeat.o(60002);
      return parama1;
    }
    if ((locala == i.a.a.JRN) || (parama1 == i.a.a.JRN))
    {
      parama1 = i.a.a.JRN;
      AppMethodBeat.o(60002);
      return parama1;
    }
    parama1 = i.a.a.JRM;
    AppMethodBeat.o(60002);
    return parama1;
  }
  
  public static i f(d.l.b.a.b.m.a.i parami)
  {
    AppMethodBeat.i(59974);
    if (parami == null) {
      adP(1);
    }
    parami = new i(JRw, parami);
    AppMethodBeat.o(59974);
    return parami;
  }
  
  private static List<ab> g(d.l.b.a.b.b.a parama)
  {
    AppMethodBeat.i(59988);
    ak localak = parama.fyl();
    ArrayList localArrayList = new ArrayList();
    if (localak != null) {
      localArrayList.add(localak.fzr());
    }
    parama = parama.fyq().iterator();
    while (parama.hasNext()) {
      localArrayList.add(((av)parama.next()).fzr());
    }
    AppMethodBeat.o(59988);
    return localArrayList;
  }
  
  private static <D extends d.l.b.a.b.b.a> Set<D> o(Set<D> paramSet)
  {
    AppMethodBeat.i(59976);
    if ((!paramSet.isEmpty()) && (d.l.b.a.b.j.d.a.e(d.l.b.a.b.j.d.a.F((l)paramSet.iterator().next())))) {}
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
          break label199;
        }
        Object localObject2 = (o)local2.n(localObject1, localIterator2.next());
        d.l.b.a.b.b.a locala = (d.l.b.a.b.b.a)((o)localObject2).first;
        localObject2 = (d.l.b.a.b.b.a)((o)localObject2).second;
        if (a(locala, (d.l.b.a.b.b.a)localObject2, bool)) {
          localIterator2.remove();
        } else {
          if (a((d.l.b.a.b.b.a)localObject2, locala, bool)) {
            break;
          }
        }
      }
      label199:
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
  
  private static Set<d.l.b.a.b.b.b> u(d.l.b.a.b.b.b paramb)
  {
    AppMethodBeat.i(59978);
    if (paramb == null) {
      adP(11);
    }
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    a(paramb, localLinkedHashSet);
    AppMethodBeat.o(59978);
    return localLinkedHashSet;
  }
  
  public final a a(d.l.b.a.b.b.a parama1, d.l.b.a.b.b.a parama2, e parame, boolean paramBoolean)
  {
    AppMethodBeat.i(59981);
    if (parama1 == null) {
      adP(18);
    }
    if (parama2 == null) {
      adP(19);
    }
    Object localObject1 = b(parama1, parama2, paramBoolean);
    if (((a)localObject1).fIS() == i.a.a.JRL) {}
    Object localObject2;
    Object localObject3;
    for (int i = 1;; i = 0)
    {
      localObject2 = JRu.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (d)((Iterator)localObject2).next();
        if ((((d)localObject3).fBn() != d.a.JRi) && ((i == 0) || (((d)localObject3).fBn() != d.a.JRj)))
        {
          localObject3 = ((d)localObject3).a(parama1, parama2, parame);
          switch (9.JRF[localObject3.ordinal()])
          {
          default: 
            break;
          case 1: 
            i = 1;
          }
        }
      }
    }
    parama1 = a.aQM("External condition failed");
    AppMethodBeat.o(59981);
    return parama1;
    parama1 = a.aQL("External condition");
    AppMethodBeat.o(59981);
    return parama1;
    if (i == 0)
    {
      if (localObject1 == null) {
        adP(22);
      }
      AppMethodBeat.o(59981);
      return localObject1;
    }
    localObject1 = JRu.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (d)((Iterator)localObject1).next();
      if (((d)localObject2).fBn() == d.a.JRi)
      {
        localObject3 = ((d)localObject2).a(parama1, parama2, parame);
        switch (9.JRF[localObject3.ordinal()])
        {
        default: 
          break;
        case 1: 
          parama1 = new IllegalStateException("Contract violation in " + localObject2.getClass().getName() + " condition. It's not supposed to end with success");
          AppMethodBeat.o(59981);
          throw parama1;
        case 2: 
          parama1 = a.aQM("External condition failed");
          AppMethodBeat.o(59981);
          return parama1;
        case 3: 
          parama1 = a.aQL("External condition");
          AppMethodBeat.o(59981);
          return parama1;
        }
      }
    }
    parama1 = a.fIR();
    if (parama1 == null) {
      adP(25);
    }
    AppMethodBeat.o(59981);
    return parama1;
  }
  
  public final void a(f paramf, Collection<? extends d.l.b.a.b.b.b> paramCollection1, Collection<? extends d.l.b.a.b.b.b> paramCollection2, e parame, h paramh)
  {
    AppMethodBeat.i(59989);
    if (paramf == null) {
      adP(48);
    }
    if (paramCollection1 == null) {
      adP(49);
    }
    if (paramCollection2 == null) {
      adP(50);
    }
    if (parame == null) {
      adP(51);
    }
    paramf = new LinkedHashSet(paramCollection1);
    paramCollection2 = paramCollection2.iterator();
    while (paramCollection2.hasNext()) {
      paramf.removeAll(a((d.l.b.a.b.b.b)paramCollection2.next(), paramCollection1, parame, paramh));
    }
    a(parame, paramf, paramh);
    AppMethodBeat.o(59989);
  }
  
  public final a b(d.l.b.a.b.b.a parama1, d.l.b.a.b.b.a parama2, boolean paramBoolean)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(59982);
    if (parama1 == null) {
      adP(26);
    }
    if (parama2 == null) {
      adP(27);
    }
    Object localObject = c(parama1, parama2);
    if (localObject != null)
    {
      if (localObject == null) {
        adP(28);
      }
      AppMethodBeat.o(59982);
      return localObject;
    }
    List localList1 = g(parama1);
    List localList2 = g(parama2);
    List localList3 = parama1.fyn();
    List localList4 = parama2.fyn();
    if (localList3.size() != localList4.size())
    {
      while (i < localList1.size())
      {
        if (!g.JYN.d((ab)localList1.get(i), (ab)localList2.get(i)))
        {
          parama1 = a.aQL("Type parameter number mismatch");
          AppMethodBeat.o(59982);
          return parama1;
        }
        i += 1;
      }
      parama1 = a.aQM("Type parameter number mismatch");
      AppMethodBeat.o(59982);
      return parama1;
    }
    localObject = L(localList3, localList4);
    i = 0;
    while (i < localList3.size())
    {
      if (!a((as)localList3.get(i), (as)localList4.get(i), (g)localObject))
      {
        parama1 = a.aQL("Type parameter bounds mismatch");
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
        parama1 = a.aQL("Value parameter type mismatch");
        AppMethodBeat.o(59982);
        return parama1;
      }
      i += 1;
    }
    if (((parama1 instanceof t)) && ((parama2 instanceof t)) && (((t)parama1).fyS() != ((t)parama2).fyS()))
    {
      parama1 = a.aQM("Incompatible suspendability");
      AppMethodBeat.o(59982);
      return parama1;
    }
    if (paramBoolean)
    {
      parama1 = parama1.fyo();
      parama2 = parama2.fyo();
      if ((parama1 != null) && (parama2 != null))
      {
        i = j;
        if (ad.aq(parama2))
        {
          i = j;
          if (ad.aq(parama1)) {
            i = 1;
          }
        }
        if ((i == 0) && (!((g)localObject).c(this.JRx.aL(parama2), this.JRx.aL(parama1))))
        {
          parama1 = a.aQM("Return type mismatch");
          AppMethodBeat.o(59982);
          return parama1;
        }
      }
    }
    parama1 = a.fIR();
    if (parama1 == null) {
      adP(35);
    }
    AppMethodBeat.o(59982);
    return parama1;
  }
  
  public static final class a
  {
    private static final a JRI;
    private final a JRJ;
    private final String JRK;
    
    static
    {
      AppMethodBeat.i(59971);
      JRI = new a(a.JRL, "SUCCESS");
      AppMethodBeat.o(59971);
    }
    
    private a(a parama, String paramString)
    {
      AppMethodBeat.i(59969);
      this.JRJ = parama;
      this.JRK = paramString;
      AppMethodBeat.o(59969);
    }
    
    public static a aQL(String paramString)
    {
      AppMethodBeat.i(59967);
      paramString = new a(a.JRM, paramString);
      AppMethodBeat.o(59967);
      return paramString;
    }
    
    public static a aQM(String paramString)
    {
      AppMethodBeat.i(59968);
      paramString = new a(a.JRN, paramString);
      AppMethodBeat.o(59968);
      return paramString;
    }
    
    public static a fIR()
    {
      AppMethodBeat.i(59966);
      a locala = JRI;
      if (locala == null) {
        adP(0);
      }
      AppMethodBeat.o(59966);
      return locala;
    }
    
    public final a fIS()
    {
      AppMethodBeat.i(59970);
      a locala = this.JRJ;
      if (locala == null) {
        adP(5);
      }
      AppMethodBeat.o(59970);
      return locala;
    }
    
    public static enum a
    {
      static
      {
        AppMethodBeat.i(59965);
        JRL = new a("OVERRIDABLE", 0);
        JRM = new a("INCOMPATIBLE", 1);
        JRN = new a("CONFLICT", 2);
        JRO = new a[] { JRL, JRM, JRN };
        AppMethodBeat.o(59965);
      }
      
      private a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.j.i
 * JD-Core Version:    0.7.0.1
 */