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
import d.l.b.a.b.m.y;
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
  private static final List<d> NvM;
  public static final i NvN;
  private static final g.a NvO;
  private final d.l.b.a.b.m.a.i NvP;
  private final g.a NvQ;
  
  static
  {
    AppMethodBeat.i(60004);
    if (!i.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      NvM = j.l(ServiceLoader.load(d.class, d.class.getClassLoader()));
      NvO = new i.1();
      NvN = new i(NvO, d.l.b.a.b.m.a.i.a.NDe);
      AppMethodBeat.o(60004);
      return;
    }
  }
  
  private i(g.a parama, d.l.b.a.b.m.a.i parami)
  {
    AppMethodBeat.i(59975);
    this.NvQ = parama;
    this.NvP = parami;
    AppMethodBeat.o(59975);
  }
  
  private g N(List<as> paramList1, List<as> paramList2)
  {
    AppMethodBeat.i(59984);
    if (paramList1 == null) {
      ajm(38);
    }
    if (paramList2 == null) {
      ajm(39);
    }
    if ((!$assertionsDisabled) && (paramList1.size() != paramList2.size()))
    {
      paramList1 = new AssertionError("Should be the same number of type parameters: " + paramList1 + " vs " + paramList2);
      AppMethodBeat.o(59984);
      throw paramList1;
    }
    if (paramList1.isEmpty())
    {
      paramList1 = d.l.b.a.b.m.a.h.b(this.NvQ);
      AppMethodBeat.o(59984);
      return paramList1;
    }
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < paramList1.size())
    {
      localHashMap.put(((as)paramList1.get(i)).ghu(), ((as)paramList2.get(i)).ghu());
      i += 1;
    }
    paramList1 = d.l.b.a.b.m.a.h.b(new i.3(this, localHashMap));
    AppMethodBeat.o(59984);
    return paramList1;
  }
  
  private static w a(Collection<d.l.b.a.b.b.b> paramCollection, e parame)
  {
    boolean bool = true;
    AppMethodBeat.i(59998);
    if (paramCollection == null) {
      ajm(83);
    }
    if (parame == null) {
      ajm(84);
    }
    Object localObject = paramCollection.iterator();
    int i = 0;
    int j = 0;
    if (((Iterator)localObject).hasNext())
    {
      d.l.b.a.b.b.b localb = (d.l.b.a.b.b.b)((Iterator)localObject).next();
      switch (9.NvZ[localb.ghx().ordinal()])
      {
      }
      for (;;)
      {
        break;
        paramCollection = w.MUB;
        if (paramCollection == null) {
          ajm(85);
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
    if ((parame.ghE()) && (parame.ghx() != w.MUE) && (parame.ghx() != w.MUC)) {}
    while ((j != 0) && (i == 0))
    {
      paramCollection = w.MUD;
      if (paramCollection == null) {
        ajm(86);
      }
      AppMethodBeat.o(59998);
      return paramCollection;
      bool = false;
    }
    if ((j == 0) && (i != 0))
    {
      if (bool) {}
      for (paramCollection = parame.ghx();; paramCollection = w.MUE)
      {
        if (paramCollection == null) {
          ajm(87);
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
    paramCollection = a(w((Set)localObject), bool, parame.ghx());
    AppMethodBeat.o(59998);
    return paramCollection;
  }
  
  private static w a(Collection<d.l.b.a.b.b.b> paramCollection, boolean paramBoolean, w paramw)
  {
    AppMethodBeat.i(59999);
    if (paramCollection == null) {
      ajm(88);
    }
    if (paramw == null) {
      ajm(89);
    }
    Object localObject = w.MUE;
    Iterator localIterator = paramCollection.iterator();
    paramCollection = (Collection<d.l.b.a.b.b.b>)localObject;
    if (localIterator.hasNext())
    {
      localObject = (d.l.b.a.b.b.b)localIterator.next();
      if ((paramBoolean) && (((d.l.b.a.b.b.b)localObject).ghx() == w.MUE))
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
      localObject = ((d.l.b.a.b.b.b)localObject).ghx();
      break label77;
      if (paramCollection == null) {
        ajm(90);
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
    parama = new i(parama, d.l.b.a.b.m.a.i.a.NDe);
    AppMethodBeat.o(59973);
    return parama;
  }
  
  public static <H> H a(Collection<H> paramCollection, d.g.a.b<H, d.l.b.a.b.b.a> paramb)
  {
    AppMethodBeat.i(59996);
    if (paramCollection == null) {
      ajm(73);
    }
    if (paramb == null) {
      ajm(74);
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
        ajm(75);
      }
      AppMethodBeat.o(59996);
      return paramCollection;
    }
    ArrayList localArrayList = new ArrayList(2);
    List localList = j.d(paramCollection, paramb);
    Object localObject = j.c(paramCollection);
    d.l.b.a.b.b.a locala1 = (d.l.b.a.b.b.a)paramb.invoke(localObject);
    Iterator localIterator = paramCollection.iterator();
    paramCollection = (Collection<H>)localObject;
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      d.l.b.a.b.b.a locala2 = (d.l.b.a.b.b.a)paramb.invoke(localObject);
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
          ajm(76);
        }
        AppMethodBeat.o(59996);
        return paramCollection;
      }
      if (localArrayList.size() == 1)
      {
        paramCollection = j.c(localArrayList);
        if (paramCollection == null) {
          ajm(77);
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
      } while (y.am(((d.l.b.a.b.b.a)paramb.invoke(paramCollection)).giq()));
      for (;;)
      {
        if (paramCollection != null)
        {
          if (paramCollection == null) {
            ajm(78);
          }
          AppMethodBeat.o(59996);
          return paramCollection;
        }
        paramCollection = j.c(localArrayList);
        if (paramCollection == null) {
          ajm(79);
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
      ajm(55);
    }
    if (paramCollection == null) {
      ajm(56);
    }
    if (parame == null) {
      ajm(57);
    }
    if (paramh == null) {
      ajm(58);
    }
    ArrayList localArrayList = new ArrayList(paramCollection.size());
    d.l.b.a.b.o.i locali = d.l.b.a.b.o.i.guu();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      d.l.b.a.b.b.b localb = (d.l.b.a.b.b.b)paramCollection.next();
      i.a.a locala = b(localb, paramb, parame).gsV();
      if (paramb == null) {
        ajm(53);
      }
      if (localb == null) {
        ajm(54);
      }
      if ((!az.b(localb.ghz())) && (az.a(localb, paramb))) {}
      for (int i = 1;; i = 0) {
        switch (9.NvY[locala.ordinal()])
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
      ajm(91);
    }
    if (paramCollection == null) {
      ajm(92);
    }
    parame = j.c(paramCollection, new d.g.a.b() {});
    AppMethodBeat.o(60000);
    return parame;
  }
  
  public static <H> Collection<H> a(H paramH, Collection<H> paramCollection, d.g.a.b<H, d.l.b.a.b.b.a> paramb, d.g.a.b<H, d.z> paramb1)
  {
    AppMethodBeat.i(60001);
    if (paramH == null) {
      ajm(94);
    }
    if (paramb == null) {
      ajm(96);
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramH);
    d.l.b.a.b.b.a locala = (d.l.b.a.b.b.a)paramb.invoke(paramH);
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      Object localObject1 = paramCollection.next();
      Object localObject2 = (d.l.b.a.b.b.a)paramb.invoke(localObject1);
      if (paramH == localObject1)
      {
        paramCollection.remove();
      }
      else
      {
        localObject2 = f(locala, (d.l.b.a.b.b.a)localObject2);
        if (localObject2 == i.a.a.Nwc)
        {
          localArrayList.add(localObject1);
          paramCollection.remove();
        }
        else if (localObject2 == i.a.a.Nwe)
        {
          paramb1.invoke(localObject1);
          paramCollection.remove();
        }
      }
    }
    AppMethodBeat.o(60001);
    return localArrayList;
  }
  
  public static void a(d.l.b.a.b.b.b paramb, d.g.a.b<d.l.b.a.b.b.b, d.z> paramb1)
  {
    AppMethodBeat.i(60003);
    if (paramb == null) {
      ajm(102);
    }
    Object localObject1 = paramb.giu().iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (d.l.b.a.b.b.b)((Iterator)localObject1).next();
      if (((d.l.b.a.b.b.b)localObject2).ghz() == az.MVj) {
        a((d.l.b.a.b.b.b)localObject2, paramb1);
      }
    }
    if (paramb.ghz() != az.MVj)
    {
      AppMethodBeat.o(60003);
      return;
    }
    if (paramb == null) {
      ajm(103);
    }
    Object localObject3 = paramb.giu();
    if (localObject3 == null) {
      ajm(104);
    }
    label132:
    label152:
    label221:
    Object localObject4;
    if (((Collection)localObject3).isEmpty())
    {
      localObject2 = az.MVo;
      if (localObject2 == null)
      {
        localObject1 = null;
        if (localObject1 != null) {
          break label501;
        }
        if (paramb1 != null) {
          paramb1.invoke(paramb);
        }
        localObject2 = az.MVh;
        if (!(paramb instanceof aa)) {
          break label518;
        }
        localObject3 = (aa)paramb;
        if (localObject2 == null) {
          aa.ajm(16);
        }
        ((aa)localObject3).MXX = ((ba)localObject2);
        localObject2 = ((ah)paramb).gjl().iterator();
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
        localObject2 = ((d.l.b.a.b.b.b)localObject5).ghz();
        if ((!$assertionsDisabled) && (localObject2 == az.MVj))
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
          localObject4 = az.b((ba)localObject1, ((d.l.b.a.b.b.b)((Iterator)localObject2).next()).ghz());
          if ((localObject4 == null) || (((Integer)localObject4).intValue() < 0))
          {
            localObject2 = null;
            break;
          }
        }
      }
      localObject2 = localObject1;
      break;
      if (paramb.giw() == b.a.MUk)
      {
        localObject3 = ((Collection)localObject3).iterator();
        do
        {
          localObject1 = localObject2;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject1 = (d.l.b.a.b.b.b)((Iterator)localObject3).next();
        } while ((((d.l.b.a.b.b.b)localObject1).ghx() == w.MUE) || (((d.l.b.a.b.b.b)localObject1).ghz().equals(localObject2)));
        localObject1 = null;
        break label132;
      }
      localObject1 = ((ba)localObject2).gjJ();
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
          d.l.b.a.b.b.c.p.ajm(9);
        }
        paramb.MXX = ((ba)localObject2);
        AppMethodBeat.o(60003);
        return;
      }
      if ((!$assertionsDisabled) && (!(paramb instanceof d.l.b.a.b.b.c.z)))
      {
        paramb = new AssertionError();
        AppMethodBeat.o(60003);
        throw paramb;
      }
      paramb = (d.l.b.a.b.b.c.z)paramb;
      paramb.MXX = ((ba)localObject2);
      if (localObject2 != paramb.gji().ghz()) {
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
      ajm(13);
    }
    if (paramSet == null) {
      ajm(14);
    }
    if (paramb.giw().gix())
    {
      paramSet.add(paramb);
      AppMethodBeat.o(59979);
      return;
    }
    if (paramb.giu().isEmpty())
    {
      paramb = new IllegalStateException("No overridden descriptors found for (fake override) ".concat(String.valueOf(paramb)));
      AppMethodBeat.o(59979);
      throw paramb;
    }
    paramb = paramb.giu().iterator();
    while (paramb.hasNext()) {
      a((d.l.b.a.b.b.b)paramb.next(), paramSet);
    }
    AppMethodBeat.o(59979);
  }
  
  private static void a(e parame, Collection<d.l.b.a.b.b.b> paramCollection, h paramh)
  {
    AppMethodBeat.i(59991);
    if (parame == null) {
      ajm(60);
    }
    if (paramh == null) {
      ajm(62);
    }
    Object localObject;
    int i;
    if (paramCollection.size() >= 2)
    {
      localObject = new d.g.a.b() {};
      d.g.b.p.h(paramCollection, "$this$all");
      d.g.b.p.h(localObject, "predicate");
      if (!((Collection)paramCollection).isEmpty())
      {
        Iterator localIterator = paramCollection.iterator();
        while (localIterator.hasNext()) {
          if (!((Boolean)((d.g.a.b)localObject).invoke(localIterator.next())).booleanValue()) {
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
      localObject = k.w(paramCollection);
      if (localObject == null) {
        ajm(99);
      }
      if (paramh == null) {
        ajm(101);
      }
      a(a(localObject, paramCollection, new d.g.a.b()new d.g.a.b {}, new d.g.a.b() {}), parame, paramh);
    }
    AppMethodBeat.o(59991);
  }
  
  private static void a(Collection<d.l.b.a.b.b.b> paramCollection, e parame, h paramh)
  {
    AppMethodBeat.i(59997);
    if (paramCollection == null) {
      ajm(80);
    }
    if (parame == null) {
      ajm(81);
    }
    if (paramh == null) {
      ajm(82);
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
    for (localObject = az.MVk;; localObject = az.MVj)
    {
      parame = ((d.l.b.a.b.b.b)a(paramCollection, new d.g.a.b() {})).a(parame, localw, (ba)localObject, b.a.MUk);
      paramh.a(parame, paramCollection);
      if (($assertionsDisabled) || (!parame.giu().isEmpty())) {
        break label171;
      }
      paramCollection = new AssertionError("Overridden descriptors should be set for " + b.a.MUk);
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
      ajm(9);
    }
    if (paramD2 == null) {
      ajm(10);
    }
    if ((!paramD1.equals(paramD2)) && (a.Nvk.a(paramD1.gir(), paramD2.gir(), paramBoolean)))
    {
      AppMethodBeat.o(59977);
      return true;
    }
    paramD2 = paramD2.gir();
    paramD1 = c.e(paramD1).iterator();
    while (paramD1.hasNext())
    {
      d.l.b.a.b.b.a locala = (d.l.b.a.b.b.a)paramD1.next();
      if (a.Nvk.a(paramD2, locala, paramBoolean))
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
      ajm(69);
    }
    if (paramab1 == null) {
      ajm(70);
    }
    if (parama2 == null) {
      ajm(71);
    }
    if (paramab2 == null) {
      ajm(72);
    }
    boolean bool = NvN.N(parama1.gip(), parama2.gip()).c(paramab1, paramab2);
    AppMethodBeat.o(59995);
    return bool;
  }
  
  private static boolean a(d.l.b.a.b.b.a parama, Collection<d.l.b.a.b.b.a> paramCollection)
  {
    AppMethodBeat.i(59994);
    if (parama == null) {
      ajm(67);
    }
    if (paramCollection == null) {
      ajm(68);
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
      ajm(45);
    }
    if (paramas2 == null) {
      ajm(46);
    }
    if (paramg == null) {
      ajm(47);
    }
    Object localObject = paramas1.ggj();
    paramas1 = new ArrayList(paramas2.ggj());
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
      ajm(65);
    }
    if (paramp2 == null) {
      ajm(66);
    }
    paramp1 = az.b(paramp1.ghz(), paramp2.ghz());
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
      ajm(42);
    }
    if (paramab2 == null) {
      ajm(43);
    }
    if (paramg == null) {
      ajm(44);
    }
    if ((ad.aq(paramab1)) && (ad.aq(paramab2))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(59986);
      return true;
    }
    boolean bool = paramg.d(this.NvP.aL(paramab1), this.NvP.aL(paramab2));
    AppMethodBeat.o(59986);
    return bool;
  }
  
  private a b(d.l.b.a.b.b.a parama1, d.l.b.a.b.b.a parama2, e parame)
  {
    AppMethodBeat.i(59980);
    if (parama1 == null) {
      ajm(15);
    }
    if (parama2 == null) {
      ajm(16);
    }
    parama1 = a(parama1, parama2, parame, false);
    if (parama1 == null) {
      ajm(17);
    }
    AppMethodBeat.o(59980);
    return parama1;
  }
  
  private static a c(d.l.b.a.b.b.a parama1, d.l.b.a.b.b.a parama2)
  {
    AppMethodBeat.i(59983);
    if (parama1 == null) {
      ajm(36);
    }
    if (parama2 == null) {
      ajm(37);
    }
    if ((((parama1 instanceof t)) && (!(parama2 instanceof t))) || (((parama1 instanceof ah)) && (!(parama2 instanceof ah))))
    {
      parama1 = a.bcN("Member kind mismatch");
      AppMethodBeat.o(59983);
      return parama1;
    }
    if ((!(parama1 instanceof t)) && (!(parama1 instanceof ah)))
    {
      parama1 = new IllegalArgumentException("This type of CallableDescriptor cannot be checked for overridability: ".concat(String.valueOf(parama1)));
      AppMethodBeat.o(59983);
      throw parama1;
    }
    if (!parama1.giD().equals(parama2.giD()))
    {
      parama1 = a.bcN("Name mismatch");
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
    if (parama1.gin() == null)
    {
      i = 1;
      if (parama2.gin() != null) {
        break label53;
      }
    }
    for (;;)
    {
      if (i == j) {
        break label58;
      }
      parama1 = a.bcN("Receiver presence mismatch");
      AppMethodBeat.o(59985);
      return parama1;
      i = 0;
      break;
      label53:
      j = 0;
    }
    label58:
    if (parama1.gis().size() != parama2.gis().size())
    {
      parama1 = a.bcN("Value parameter number mismatch");
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
      ajm(63);
    }
    if (parama2 == null) {
      ajm(64);
    }
    ab localab1 = parama1.giq();
    ab localab2 = parama2.giq();
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
      aj localaj1 = localah1.gjk();
      aj localaj2 = localah2.gjk();
      if ((localaj1 == null) || (localaj2 == null)) {}
      for (bool = true; !bool; bool = a(localaj1, localaj2))
      {
        AppMethodBeat.o(59992);
        return false;
      }
      if ((localah1.gjB()) && (localah2.gjB()))
      {
        bool = NvN.N(parama1.gip(), parama2.gip()).d(localab1, localab2);
        AppMethodBeat.o(59992);
        return bool;
      }
      if (((localah1.gjB()) || (!localah2.gjB())) && (a(parama1, localab1, parama2, localab2)))
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
    i.a.a locala = NvN.b(parama2, parama1, null).gsV();
    parama1 = NvN.b(parama1, parama2, null).gsV();
    if ((locala == i.a.a.Nwc) && (parama1 == i.a.a.Nwc))
    {
      parama1 = i.a.a.Nwc;
      AppMethodBeat.o(60002);
      return parama1;
    }
    if ((locala == i.a.a.Nwe) || (parama1 == i.a.a.Nwe))
    {
      parama1 = i.a.a.Nwe;
      AppMethodBeat.o(60002);
      return parama1;
    }
    parama1 = i.a.a.Nwd;
    AppMethodBeat.o(60002);
    return parama1;
  }
  
  public static i f(d.l.b.a.b.m.a.i parami)
  {
    AppMethodBeat.i(59974);
    if (parami == null) {
      ajm(1);
    }
    parami = new i(NvO, parami);
    AppMethodBeat.o(59974);
    return parami;
  }
  
  private static List<ab> g(d.l.b.a.b.b.a parama)
  {
    AppMethodBeat.i(59988);
    ak localak = parama.gin();
    ArrayList localArrayList = new ArrayList();
    if (localak != null) {
      localArrayList.add(localak.gju());
    }
    parama = parama.gis().iterator();
    while (parama.hasNext()) {
      localArrayList.add(((av)parama.next()).gju());
    }
    AppMethodBeat.o(59988);
    return localArrayList;
  }
  
  private static Set<d.l.b.a.b.b.b> u(d.l.b.a.b.b.b paramb)
  {
    AppMethodBeat.i(59978);
    if (paramb == null) {
      ajm(11);
    }
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    a(paramb, localLinkedHashSet);
    AppMethodBeat.o(59978);
    return localLinkedHashSet;
  }
  
  private static <D extends d.l.b.a.b.b.a> Set<D> w(Set<D> paramSet)
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
        Object localObject2 = (o)local2.p(localObject1, localIterator2.next());
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
  
  public final a a(d.l.b.a.b.b.a parama1, d.l.b.a.b.b.a parama2, e parame, boolean paramBoolean)
  {
    AppMethodBeat.i(59981);
    if (parama1 == null) {
      ajm(18);
    }
    if (parama2 == null) {
      ajm(19);
    }
    Object localObject1 = b(parama1, parama2, paramBoolean);
    if (((a)localObject1).gsV() == i.a.a.Nwc) {}
    Object localObject2;
    Object localObject3;
    for (int i = 1;; i = 0)
    {
      localObject2 = NvM.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (d)((Iterator)localObject2).next();
        if ((((d)localObject3).glq() != d.a.NvA) && ((i == 0) || (((d)localObject3).glq() != d.a.NvB)))
        {
          localObject3 = ((d)localObject3).a(parama1, parama2, parame);
          switch (9.NvX[localObject3.ordinal()])
          {
          default: 
            break;
          case 1: 
            i = 1;
          }
        }
      }
    }
    parama1 = a.bcO("External condition failed");
    AppMethodBeat.o(59981);
    return parama1;
    parama1 = a.bcN("External condition");
    AppMethodBeat.o(59981);
    return parama1;
    if (i == 0)
    {
      if (localObject1 == null) {
        ajm(22);
      }
      AppMethodBeat.o(59981);
      return localObject1;
    }
    localObject1 = NvM.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (d)((Iterator)localObject1).next();
      if (((d)localObject2).glq() == d.a.NvA)
      {
        localObject3 = ((d)localObject2).a(parama1, parama2, parame);
        switch (9.NvX[localObject3.ordinal()])
        {
        default: 
          break;
        case 1: 
          parama1 = new IllegalStateException("Contract violation in " + localObject2.getClass().getName() + " condition. It's not supposed to end with success");
          AppMethodBeat.o(59981);
          throw parama1;
        case 2: 
          parama1 = a.bcO("External condition failed");
          AppMethodBeat.o(59981);
          return parama1;
        case 3: 
          parama1 = a.bcN("External condition");
          AppMethodBeat.o(59981);
          return parama1;
        }
      }
    }
    parama1 = a.gsU();
    if (parama1 == null) {
      ajm(25);
    }
    AppMethodBeat.o(59981);
    return parama1;
  }
  
  public final void a(f paramf, Collection<? extends d.l.b.a.b.b.b> paramCollection1, Collection<? extends d.l.b.a.b.b.b> paramCollection2, e parame, h paramh)
  {
    AppMethodBeat.i(59989);
    if (paramf == null) {
      ajm(48);
    }
    if (paramCollection1 == null) {
      ajm(49);
    }
    if (paramCollection2 == null) {
      ajm(50);
    }
    if (parame == null) {
      ajm(51);
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
      ajm(26);
    }
    if (parama2 == null) {
      ajm(27);
    }
    Object localObject = c(parama1, parama2);
    if (localObject != null)
    {
      if (localObject == null) {
        ajm(28);
      }
      AppMethodBeat.o(59982);
      return localObject;
    }
    List localList1 = g(parama1);
    List localList2 = g(parama2);
    List localList3 = parama1.gip();
    List localList4 = parama2.gip();
    if (localList3.size() != localList4.size())
    {
      while (i < localList1.size())
      {
        if (!g.NDb.d((ab)localList1.get(i), (ab)localList2.get(i)))
        {
          parama1 = a.bcN("Type parameter number mismatch");
          AppMethodBeat.o(59982);
          return parama1;
        }
        i += 1;
      }
      parama1 = a.bcO("Type parameter number mismatch");
      AppMethodBeat.o(59982);
      return parama1;
    }
    localObject = N(localList3, localList4);
    i = 0;
    while (i < localList3.size())
    {
      if (!a((as)localList3.get(i), (as)localList4.get(i), (g)localObject))
      {
        parama1 = a.bcN("Type parameter bounds mismatch");
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
        parama1 = a.bcN("Value parameter type mismatch");
        AppMethodBeat.o(59982);
        return parama1;
      }
      i += 1;
    }
    if (((parama1 instanceof t)) && ((parama2 instanceof t)) && (((t)parama1).giV() != ((t)parama2).giV()))
    {
      parama1 = a.bcO("Incompatible suspendability");
      AppMethodBeat.o(59982);
      return parama1;
    }
    if (paramBoolean)
    {
      parama1 = parama1.giq();
      parama2 = parama2.giq();
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
        if ((i == 0) && (!((g)localObject).c(this.NvP.aL(parama2), this.NvP.aL(parama1))))
        {
          parama1 = a.bcO("Return type mismatch");
          AppMethodBeat.o(59982);
          return parama1;
        }
      }
    }
    parama1 = a.gsU();
    if (parama1 == null) {
      ajm(35);
    }
    AppMethodBeat.o(59982);
    return parama1;
  }
  
  public static final class a
  {
    private static final a Nwa;
    private final a Nwb;
    private final String debugMessage;
    
    static
    {
      AppMethodBeat.i(59971);
      Nwa = new a(a.Nwc, "SUCCESS");
      AppMethodBeat.o(59971);
    }
    
    private a(a parama, String paramString)
    {
      AppMethodBeat.i(59969);
      this.Nwb = parama;
      this.debugMessage = paramString;
      AppMethodBeat.o(59969);
    }
    
    public static a bcN(String paramString)
    {
      AppMethodBeat.i(59967);
      paramString = new a(a.Nwd, paramString);
      AppMethodBeat.o(59967);
      return paramString;
    }
    
    public static a bcO(String paramString)
    {
      AppMethodBeat.i(59968);
      paramString = new a(a.Nwe, paramString);
      AppMethodBeat.o(59968);
      return paramString;
    }
    
    public static a gsU()
    {
      AppMethodBeat.i(59966);
      a locala = Nwa;
      if (locala == null) {
        ajm(0);
      }
      AppMethodBeat.o(59966);
      return locala;
    }
    
    public final a gsV()
    {
      AppMethodBeat.i(59970);
      a locala = this.Nwb;
      if (locala == null) {
        ajm(5);
      }
      AppMethodBeat.o(59970);
      return locala;
    }
    
    public static enum a
    {
      static
      {
        AppMethodBeat.i(59965);
        Nwc = new a("OVERRIDABLE", 0);
        Nwd = new a("INCOMPATIBLE", 1);
        Nwe = new a("CONFLICT", 2);
        Nwf = new a[] { Nwc, Nwd, Nwe };
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