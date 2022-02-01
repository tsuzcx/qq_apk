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
  private static final List<d> LEN;
  public static final i LEO;
  private static final g.a LEP;
  private final d.l.b.a.b.m.a.i LEQ;
  private final g.a LER;
  
  static
  {
    AppMethodBeat.i(60004);
    if (!i.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      LEN = j.l(ServiceLoader.load(d.class, d.class.getClassLoader()));
      LEP = new g.a()
      {
        public final boolean a(at paramAnonymousat1, at paramAnonymousat2)
        {
          AppMethodBeat.i(59954);
          if (paramAnonymousat1 == null) {
            agL(0);
          }
          if (paramAnonymousat2 == null) {
            agL(1);
          }
          boolean bool = paramAnonymousat1.equals(paramAnonymousat2);
          AppMethodBeat.o(59954);
          return bool;
        }
      };
      LEO = new i(LEP, d.l.b.a.b.m.a.i.a.LMj);
      AppMethodBeat.o(60004);
      return;
    }
  }
  
  private i(g.a parama, d.l.b.a.b.m.a.i parami)
  {
    AppMethodBeat.i(59975);
    this.LER = parama;
    this.LEQ = parami;
    AppMethodBeat.o(59975);
  }
  
  private g L(List<as> paramList1, List<as> paramList2)
  {
    AppMethodBeat.i(59984);
    if (paramList1 == null) {
      agL(38);
    }
    if (paramList2 == null) {
      agL(39);
    }
    if ((!$assertionsDisabled) && (paramList1.size() != paramList2.size()))
    {
      paramList1 = new AssertionError("Should be the same number of type parameters: " + paramList1 + " vs " + paramList2);
      AppMethodBeat.o(59984);
      throw paramList1;
    }
    if (paramList1.isEmpty())
    {
      paramList1 = d.l.b.a.b.m.a.h.b(this.LER);
      AppMethodBeat.o(59984);
      return paramList1;
    }
    final HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < paramList1.size())
    {
      localHashMap.put(((as)paramList1.get(i)).fPW(), ((as)paramList2.get(i)).fPW());
      i += 1;
    }
    paramList1 = d.l.b.a.b.m.a.h.b(new g.a()
    {
      public final boolean a(at paramAnonymousat1, at paramAnonymousat2)
      {
        AppMethodBeat.i(59957);
        if (paramAnonymousat1 == null) {
          agL(0);
        }
        if (paramAnonymousat2 == null) {
          agL(1);
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
      agL(83);
    }
    if (parame == null) {
      agL(84);
    }
    Object localObject = paramCollection.iterator();
    int i = 0;
    int j = 0;
    if (((Iterator)localObject).hasNext())
    {
      d.l.b.a.b.b.b localb = (d.l.b.a.b.b.b)((Iterator)localObject).next();
      switch (9.LFa[localb.fPZ().ordinal()])
      {
      }
      for (;;)
      {
        break;
        paramCollection = w.LdG;
        if (paramCollection == null) {
          agL(85);
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
    if ((parame.fQg()) && (parame.fPZ() != w.LdJ) && (parame.fPZ() != w.LdH)) {}
    while ((j != 0) && (i == 0))
    {
      paramCollection = w.LdI;
      if (paramCollection == null) {
        agL(86);
      }
      AppMethodBeat.o(59998);
      return paramCollection;
      bool = false;
    }
    if ((j == 0) && (i != 0))
    {
      if (bool) {}
      for (paramCollection = parame.fPZ();; paramCollection = w.LdJ)
      {
        if (paramCollection == null) {
          agL(87);
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
    paramCollection = a(p((Set)localObject), bool, parame.fPZ());
    AppMethodBeat.o(59998);
    return paramCollection;
  }
  
  private static w a(Collection<d.l.b.a.b.b.b> paramCollection, boolean paramBoolean, w paramw)
  {
    AppMethodBeat.i(59999);
    if (paramCollection == null) {
      agL(88);
    }
    if (paramw == null) {
      agL(89);
    }
    Object localObject = w.LdJ;
    Iterator localIterator = paramCollection.iterator();
    paramCollection = (Collection<d.l.b.a.b.b.b>)localObject;
    if (localIterator.hasNext())
    {
      localObject = (d.l.b.a.b.b.b)localIterator.next();
      if ((paramBoolean) && (((d.l.b.a.b.b.b)localObject).fPZ() == w.LdJ))
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
      localObject = ((d.l.b.a.b.b.b)localObject).fPZ();
      break label77;
      if (paramCollection == null) {
        agL(90);
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
    parama = new i(parama, d.l.b.a.b.m.a.i.a.LMj);
    AppMethodBeat.o(59973);
    return parama;
  }
  
  public static <H> H a(Collection<H> paramCollection, d.g.a.b<H, d.l.b.a.b.b.a> paramb)
  {
    AppMethodBeat.i(59996);
    if (paramCollection == null) {
      agL(73);
    }
    if (paramb == null) {
      agL(74);
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
        agL(75);
      }
      AppMethodBeat.o(59996);
      return paramCollection;
    }
    ArrayList localArrayList = new ArrayList(2);
    List localList = j.d(paramCollection, paramb);
    Object localObject = j.c(paramCollection);
    d.l.b.a.b.b.a locala1 = (d.l.b.a.b.b.a)paramb.ay(localObject);
    Iterator localIterator = paramCollection.iterator();
    paramCollection = (Collection<H>)localObject;
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      d.l.b.a.b.b.a locala2 = (d.l.b.a.b.b.a)paramb.ay(localObject);
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
          agL(76);
        }
        AppMethodBeat.o(59996);
        return paramCollection;
      }
      if (localArrayList.size() == 1)
      {
        paramCollection = j.c(localArrayList);
        if (paramCollection == null) {
          agL(77);
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
      } while (d.l.b.a.b.m.y.am(((d.l.b.a.b.b.a)paramb.ay(paramCollection)).fQS()));
      for (;;)
      {
        if (paramCollection != null)
        {
          if (paramCollection == null) {
            agL(78);
          }
          AppMethodBeat.o(59996);
          return paramCollection;
        }
        paramCollection = j.c(localArrayList);
        if (paramCollection == null) {
          agL(79);
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
      agL(55);
    }
    if (paramCollection == null) {
      agL(56);
    }
    if (parame == null) {
      agL(57);
    }
    if (paramh == null) {
      agL(58);
    }
    ArrayList localArrayList = new ArrayList(paramCollection.size());
    d.l.b.a.b.o.i locali = d.l.b.a.b.o.i.gcT();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      d.l.b.a.b.b.b localb = (d.l.b.a.b.b.b)paramCollection.next();
      i.a.a locala = b(localb, paramb, parame).gbv();
      if (paramb == null) {
        agL(53);
      }
      if (localb == null) {
        agL(54);
      }
      if ((!az.b(localb.fQb())) && (az.a(localb, paramb))) {}
      for (int i = 1;; i = 0) {
        switch (9.LEZ[locala.ordinal()])
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
      agL(91);
    }
    if (paramCollection == null) {
      agL(92);
    }
    parame = j.c(paramCollection, new d.g.a.b() {});
    AppMethodBeat.o(60000);
    return parame;
  }
  
  public static <H> Collection<H> a(H paramH, Collection<H> paramCollection, d.g.a.b<H, d.l.b.a.b.b.a> paramb, d.g.a.b<H, d.y> paramb1)
  {
    AppMethodBeat.i(60001);
    if (paramH == null) {
      agL(94);
    }
    if (paramb == null) {
      agL(96);
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramH);
    d.l.b.a.b.b.a locala = (d.l.b.a.b.b.a)paramb.ay(paramH);
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      Object localObject1 = paramCollection.next();
      Object localObject2 = (d.l.b.a.b.b.a)paramb.ay(localObject1);
      if (paramH == localObject1)
      {
        paramCollection.remove();
      }
      else
      {
        localObject2 = f(locala, (d.l.b.a.b.b.a)localObject2);
        if (localObject2 == i.a.a.LFe)
        {
          localArrayList.add(localObject1);
          paramCollection.remove();
        }
        else if (localObject2 == i.a.a.LFg)
        {
          paramb1.ay(localObject1);
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
      agL(102);
    }
    Object localObject1 = paramb.fQW().iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (d.l.b.a.b.b.b)((Iterator)localObject1).next();
      if (((d.l.b.a.b.b.b)localObject2).fQb() == az.Leo) {
        a((d.l.b.a.b.b.b)localObject2, paramb1);
      }
    }
    if (paramb.fQb() != az.Leo)
    {
      AppMethodBeat.o(60003);
      return;
    }
    if (paramb == null) {
      agL(103);
    }
    Object localObject3 = paramb.fQW();
    if (localObject3 == null) {
      agL(104);
    }
    label132:
    label152:
    label221:
    Object localObject4;
    if (((Collection)localObject3).isEmpty())
    {
      localObject2 = az.Let;
      if (localObject2 == null)
      {
        localObject1 = null;
        if (localObject1 != null) {
          break label501;
        }
        if (paramb1 != null) {
          paramb1.ay(paramb);
        }
        localObject2 = az.Lem;
        if (!(paramb instanceof aa)) {
          break label518;
        }
        localObject3 = (aa)paramb;
        if (localObject2 == null) {
          aa.agL(16);
        }
        ((aa)localObject3).Lhb = ((ba)localObject2);
        localObject2 = ((ah)paramb).fRM().iterator();
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
        localObject2 = ((d.l.b.a.b.b.b)localObject5).fQb();
        if ((!$assertionsDisabled) && (localObject2 == az.Leo))
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
          localObject4 = az.b((ba)localObject1, ((d.l.b.a.b.b.b)((Iterator)localObject2).next()).fQb());
          if ((localObject4 == null) || (((Integer)localObject4).intValue() < 0))
          {
            localObject2 = null;
            break;
          }
        }
      }
      localObject2 = localObject1;
      break;
      if (paramb.fQY() == b.a.Ldp)
      {
        localObject3 = ((Collection)localObject3).iterator();
        do
        {
          localObject1 = localObject2;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject1 = (d.l.b.a.b.b.b)((Iterator)localObject3).next();
        } while ((((d.l.b.a.b.b.b)localObject1).fPZ() == w.LdJ) || (((d.l.b.a.b.b.b)localObject1).fQb().equals(localObject2)));
        localObject1 = null;
        break label132;
      }
      localObject1 = ((ba)localObject2).fSk();
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
          d.l.b.a.b.b.c.p.agL(9);
        }
        paramb.Lhb = ((ba)localObject2);
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
      paramb.Lhb = ((ba)localObject2);
      if (localObject2 != paramb.fRJ().fQb()) {
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
      agL(13);
    }
    if (paramSet == null) {
      agL(14);
    }
    if (paramb.fQY().fQZ())
    {
      paramSet.add(paramb);
      AppMethodBeat.o(59979);
      return;
    }
    if (paramb.fQW().isEmpty())
    {
      paramb = new IllegalStateException("No overridden descriptors found for (fake override) ".concat(String.valueOf(paramb)));
      AppMethodBeat.o(59979);
      throw paramb;
    }
    paramb = paramb.fQW().iterator();
    while (paramb.hasNext()) {
      a((d.l.b.a.b.b.b)paramb.next(), paramSet);
    }
    AppMethodBeat.o(59979);
  }
  
  private static void a(e parame, Collection<d.l.b.a.b.b.b> paramCollection, h paramh)
  {
    AppMethodBeat.i(59991);
    if (parame == null) {
      agL(60);
    }
    if (paramh == null) {
      agL(62);
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
          if (!((Boolean)((d.g.a.b)localObject).ay(localIterator.next())).booleanValue()) {
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
      localObject = k.v(paramCollection);
      if (localObject == null) {
        agL(99);
      }
      if (paramh == null) {
        agL(101);
      }
      a(a(localObject, paramCollection, new d.g.a.b()new d.g.a.b {}, new d.g.a.b() {}), parame, paramh);
    }
    AppMethodBeat.o(59991);
  }
  
  private static void a(Collection<d.l.b.a.b.b.b> paramCollection, e parame, h paramh)
  {
    AppMethodBeat.i(59997);
    if (paramCollection == null) {
      agL(80);
    }
    if (parame == null) {
      agL(81);
    }
    if (paramh == null) {
      agL(82);
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
    for (localObject = az.Lep;; localObject = az.Leo)
    {
      parame = ((d.l.b.a.b.b.b)a(paramCollection, new d.g.a.b() {})).a(parame, localw, (ba)localObject, b.a.Ldp);
      paramh.a(parame, paramCollection);
      if (($assertionsDisabled) || (!parame.fQW().isEmpty())) {
        break label171;
      }
      paramCollection = new AssertionError("Overridden descriptors should be set for " + b.a.Ldp);
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
      agL(9);
    }
    if (paramD2 == null) {
      agL(10);
    }
    if ((!paramD1.equals(paramD2)) && (a.LEl.a(paramD1.fQT(), paramD2.fQT(), paramBoolean)))
    {
      AppMethodBeat.o(59977);
      return true;
    }
    paramD2 = paramD2.fQT();
    paramD1 = c.e(paramD1).iterator();
    while (paramD1.hasNext())
    {
      d.l.b.a.b.b.a locala = (d.l.b.a.b.b.a)paramD1.next();
      if (a.LEl.a(paramD2, locala, paramBoolean))
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
      agL(69);
    }
    if (paramab1 == null) {
      agL(70);
    }
    if (parama2 == null) {
      agL(71);
    }
    if (paramab2 == null) {
      agL(72);
    }
    boolean bool = LEO.L(parama1.fQR(), parama2.fQR()).c(paramab1, paramab2);
    AppMethodBeat.o(59995);
    return bool;
  }
  
  private static boolean a(d.l.b.a.b.b.a parama, Collection<d.l.b.a.b.b.a> paramCollection)
  {
    AppMethodBeat.i(59994);
    if (parama == null) {
      agL(67);
    }
    if (paramCollection == null) {
      agL(68);
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
      agL(45);
    }
    if (paramas2 == null) {
      agL(46);
    }
    if (paramg == null) {
      agL(47);
    }
    Object localObject = paramas1.fOJ();
    paramas1 = new ArrayList(paramas2.fOJ());
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
      agL(65);
    }
    if (paramp2 == null) {
      agL(66);
    }
    paramp1 = az.b(paramp1.fQb(), paramp2.fQb());
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
      agL(42);
    }
    if (paramab2 == null) {
      agL(43);
    }
    if (paramg == null) {
      agL(44);
    }
    if ((ad.aq(paramab1)) && (ad.aq(paramab2))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(59986);
      return true;
    }
    boolean bool = paramg.d(this.LEQ.aL(paramab1), this.LEQ.aL(paramab2));
    AppMethodBeat.o(59986);
    return bool;
  }
  
  private a b(d.l.b.a.b.b.a parama1, d.l.b.a.b.b.a parama2, e parame)
  {
    AppMethodBeat.i(59980);
    if (parama1 == null) {
      agL(15);
    }
    if (parama2 == null) {
      agL(16);
    }
    parama1 = a(parama1, parama2, parame, false);
    if (parama1 == null) {
      agL(17);
    }
    AppMethodBeat.o(59980);
    return parama1;
  }
  
  private static a c(d.l.b.a.b.b.a parama1, d.l.b.a.b.b.a parama2)
  {
    AppMethodBeat.i(59983);
    if (parama1 == null) {
      agL(36);
    }
    if (parama2 == null) {
      agL(37);
    }
    if ((((parama1 instanceof t)) && (!(parama2 instanceof t))) || (((parama1 instanceof ah)) && (!(parama2 instanceof ah))))
    {
      parama1 = a.aWK("Member kind mismatch");
      AppMethodBeat.o(59983);
      return parama1;
    }
    if ((!(parama1 instanceof t)) && (!(parama1 instanceof ah)))
    {
      parama1 = new IllegalArgumentException("This type of CallableDescriptor cannot be checked for overridability: ".concat(String.valueOf(parama1)));
      AppMethodBeat.o(59983);
      throw parama1;
    }
    if (!parama1.fRf().equals(parama2.fRf()))
    {
      parama1 = a.aWK("Name mismatch");
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
    if (parama1.fQP() == null)
    {
      i = 1;
      if (parama2.fQP() != null) {
        break label53;
      }
    }
    for (;;)
    {
      if (i == j) {
        break label58;
      }
      parama1 = a.aWK("Receiver presence mismatch");
      AppMethodBeat.o(59985);
      return parama1;
      i = 0;
      break;
      label53:
      j = 0;
    }
    label58:
    if (parama1.fQU().size() != parama2.fQU().size())
    {
      parama1 = a.aWK("Value parameter number mismatch");
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
      agL(63);
    }
    if (parama2 == null) {
      agL(64);
    }
    ab localab1 = parama1.fQS();
    ab localab2 = parama2.fQS();
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
      aj localaj1 = localah1.fRL();
      aj localaj2 = localah2.fRL();
      if ((localaj1 == null) || (localaj2 == null)) {}
      for (bool = true; !bool; bool = a(localaj1, localaj2))
      {
        AppMethodBeat.o(59992);
        return false;
      }
      if ((localah1.fSc()) && (localah2.fSc()))
      {
        bool = LEO.L(parama1.fQR(), parama2.fQR()).d(localab1, localab2);
        AppMethodBeat.o(59992);
        return bool;
      }
      if (((localah1.fSc()) || (!localah2.fSc())) && (a(parama1, localab1, parama2, localab2)))
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
    i.a.a locala = LEO.b(parama2, parama1, null).gbv();
    parama1 = LEO.b(parama1, parama2, null).gbv();
    if ((locala == i.a.a.LFe) && (parama1 == i.a.a.LFe))
    {
      parama1 = i.a.a.LFe;
      AppMethodBeat.o(60002);
      return parama1;
    }
    if ((locala == i.a.a.LFg) || (parama1 == i.a.a.LFg))
    {
      parama1 = i.a.a.LFg;
      AppMethodBeat.o(60002);
      return parama1;
    }
    parama1 = i.a.a.LFf;
    AppMethodBeat.o(60002);
    return parama1;
  }
  
  public static i f(d.l.b.a.b.m.a.i parami)
  {
    AppMethodBeat.i(59974);
    if (parami == null) {
      agL(1);
    }
    parami = new i(LEP, parami);
    AppMethodBeat.o(59974);
    return parami;
  }
  
  private static List<ab> g(d.l.b.a.b.b.a parama)
  {
    AppMethodBeat.i(59988);
    ak localak = parama.fQP();
    ArrayList localArrayList = new ArrayList();
    if (localak != null) {
      localArrayList.add(localak.fRV());
    }
    parama = parama.fQU().iterator();
    while (parama.hasNext()) {
      localArrayList.add(((av)parama.next()).fRV());
    }
    AppMethodBeat.o(59988);
    return localArrayList;
  }
  
  private static <D extends d.l.b.a.b.b.a> Set<D> p(Set<D> paramSet)
  {
    AppMethodBeat.i(59976);
    if ((!paramSet.isEmpty()) && (d.l.b.a.b.j.d.a.e(d.l.b.a.b.j.d.a.F((l)paramSet.iterator().next())))) {}
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
      agL(11);
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
      agL(18);
    }
    if (parama2 == null) {
      agL(19);
    }
    Object localObject1 = b(parama1, parama2, paramBoolean);
    if (((a)localObject1).gbv() == i.a.a.LFe) {}
    Object localObject2;
    Object localObject3;
    for (int i = 1;; i = 0)
    {
      localObject2 = LEN.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (d)((Iterator)localObject2).next();
        if ((((d)localObject3).fTR() != d.a.LEB) && ((i == 0) || (((d)localObject3).fTR() != d.a.LEC)))
        {
          localObject3 = ((d)localObject3).a(parama1, parama2, parame);
          switch (9.LEY[localObject3.ordinal()])
          {
          default: 
            break;
          case 1: 
            i = 1;
          }
        }
      }
    }
    parama1 = a.aWL("External condition failed");
    AppMethodBeat.o(59981);
    return parama1;
    parama1 = a.aWK("External condition");
    AppMethodBeat.o(59981);
    return parama1;
    if (i == 0)
    {
      if (localObject1 == null) {
        agL(22);
      }
      AppMethodBeat.o(59981);
      return localObject1;
    }
    localObject1 = LEN.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (d)((Iterator)localObject1).next();
      if (((d)localObject2).fTR() == d.a.LEB)
      {
        localObject3 = ((d)localObject2).a(parama1, parama2, parame);
        switch (9.LEY[localObject3.ordinal()])
        {
        default: 
          break;
        case 1: 
          parama1 = new IllegalStateException("Contract violation in " + localObject2.getClass().getName() + " condition. It's not supposed to end with success");
          AppMethodBeat.o(59981);
          throw parama1;
        case 2: 
          parama1 = a.aWL("External condition failed");
          AppMethodBeat.o(59981);
          return parama1;
        case 3: 
          parama1 = a.aWK("External condition");
          AppMethodBeat.o(59981);
          return parama1;
        }
      }
    }
    parama1 = a.gbu();
    if (parama1 == null) {
      agL(25);
    }
    AppMethodBeat.o(59981);
    return parama1;
  }
  
  public final void a(f paramf, Collection<? extends d.l.b.a.b.b.b> paramCollection1, Collection<? extends d.l.b.a.b.b.b> paramCollection2, e parame, h paramh)
  {
    AppMethodBeat.i(59989);
    if (paramf == null) {
      agL(48);
    }
    if (paramCollection1 == null) {
      agL(49);
    }
    if (paramCollection2 == null) {
      agL(50);
    }
    if (parame == null) {
      agL(51);
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
      agL(26);
    }
    if (parama2 == null) {
      agL(27);
    }
    Object localObject = c(parama1, parama2);
    if (localObject != null)
    {
      if (localObject == null) {
        agL(28);
      }
      AppMethodBeat.o(59982);
      return localObject;
    }
    List localList1 = g(parama1);
    List localList2 = g(parama2);
    List localList3 = parama1.fQR();
    List localList4 = parama2.fQR();
    if (localList3.size() != localList4.size())
    {
      while (i < localList1.size())
      {
        if (!g.LMg.d((ab)localList1.get(i), (ab)localList2.get(i)))
        {
          parama1 = a.aWK("Type parameter number mismatch");
          AppMethodBeat.o(59982);
          return parama1;
        }
        i += 1;
      }
      parama1 = a.aWL("Type parameter number mismatch");
      AppMethodBeat.o(59982);
      return parama1;
    }
    localObject = L(localList3, localList4);
    i = 0;
    while (i < localList3.size())
    {
      if (!a((as)localList3.get(i), (as)localList4.get(i), (g)localObject))
      {
        parama1 = a.aWK("Type parameter bounds mismatch");
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
        parama1 = a.aWK("Value parameter type mismatch");
        AppMethodBeat.o(59982);
        return parama1;
      }
      i += 1;
    }
    if (((parama1 instanceof t)) && ((parama2 instanceof t)) && (((t)parama1).fRw() != ((t)parama2).fRw()))
    {
      parama1 = a.aWL("Incompatible suspendability");
      AppMethodBeat.o(59982);
      return parama1;
    }
    if (paramBoolean)
    {
      parama1 = parama1.fQS();
      parama2 = parama2.fQS();
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
        if ((i == 0) && (!((g)localObject).c(this.LEQ.aL(parama2), this.LEQ.aL(parama1))))
        {
          parama1 = a.aWL("Return type mismatch");
          AppMethodBeat.o(59982);
          return parama1;
        }
      }
    }
    parama1 = a.gbu();
    if (parama1 == null) {
      agL(35);
    }
    AppMethodBeat.o(59982);
    return parama1;
  }
  
  public static final class a
  {
    private static final a LFb;
    private final a LFc;
    private final String LFd;
    
    static
    {
      AppMethodBeat.i(59971);
      LFb = new a(a.LFe, "SUCCESS");
      AppMethodBeat.o(59971);
    }
    
    private a(a parama, String paramString)
    {
      AppMethodBeat.i(59969);
      this.LFc = parama;
      this.LFd = paramString;
      AppMethodBeat.o(59969);
    }
    
    public static a aWK(String paramString)
    {
      AppMethodBeat.i(59967);
      paramString = new a(a.LFf, paramString);
      AppMethodBeat.o(59967);
      return paramString;
    }
    
    public static a aWL(String paramString)
    {
      AppMethodBeat.i(59968);
      paramString = new a(a.LFg, paramString);
      AppMethodBeat.o(59968);
      return paramString;
    }
    
    public static a gbu()
    {
      AppMethodBeat.i(59966);
      a locala = LFb;
      if (locala == null) {
        agL(0);
      }
      AppMethodBeat.o(59966);
      return locala;
    }
    
    public final a gbv()
    {
      AppMethodBeat.i(59970);
      a locala = this.LFc;
      if (locala == null) {
        agL(5);
      }
      AppMethodBeat.o(59970);
      return locala;
    }
    
    public static enum a
    {
      static
      {
        AppMethodBeat.i(59965);
        LFe = new a("OVERRIDABLE", 0);
        LFf = new a("INCOMPATIBLE", 1);
        LFg = new a("CONFLICT", 2);
        LFh = new a[] { LFe, LFf, LFg };
        AppMethodBeat.o(59965);
      }
      
      private a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.j.i
 * JD-Core Version:    0.7.0.1
 */