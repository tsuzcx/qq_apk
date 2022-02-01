package d.l.b.a.b.d.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l.b.a.b.b.ah;
import d.l.b.a.b.b.b.a;
import d.l.b.a.b.b.c.z;
import d.l.b.a.b.d.a.a.a;
import d.l.b.a.b.d.a.q;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.bc;
import d.l.b.a.b.m.be;
import d.l.b.a.b.m.bg;
import d.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collection<+Ld.l.b.a.b.m.ab;>;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class l
{
  private final d.l.b.a.b.d.a.a JAa;
  private final d.l.b.a.b.o.e JwY;
  
  public l(d.l.b.a.b.d.a.a parama, d.l.b.a.b.o.e parame)
  {
    AppMethodBeat.i(58109);
    this.JAa = parama;
    this.JwY = parame;
    AppMethodBeat.o(58109);
  }
  
  private final <D extends d.l.b.a.b.b.b> D a(D paramD, d.l.b.a.b.d.a.c.h paramh)
  {
    AppMethodBeat.i(58106);
    if (!(paramD instanceof d.l.b.a.b.d.a.b.b))
    {
      AppMethodBeat.o(58106);
      return paramD;
    }
    if (((d.l.b.a.b.d.a.b.b)paramD).fyu() == b.a.JpW)
    {
      localObject1 = ((d.l.b.a.b.d.a.b.b)paramD).fyt();
      k.g(localObject1, "original");
      if (((d.l.b.a.b.b.b)localObject1).fys().size() == 1)
      {
        AppMethodBeat.o(58106);
        return paramD;
      }
    }
    d.l.b.a.b.d.a.c.h localh = d.l.b.a.b.d.a.c.a.b(paramh, paramD.fxF());
    if ((paramD instanceof d.l.b.a.b.d.a.b.g))
    {
      paramh = ((d.l.b.a.b.d.a.b.g)paramD).JuW;
      if ((paramh != null) && (!paramh.isDefault))
      {
        paramh = ((d.l.b.a.b.d.a.b.g)paramD).JuW;
        if (paramh == null) {
          k.fvU();
        }
        k.g(paramh, "getter!!");
        paramh = (d.l.b.a.b.b.b)paramh;
        if (((d.l.b.a.b.d.a.b.b)paramD).fyl() == null) {
          break label276;
        }
        if ((paramh instanceof d.l.b.a.b.b.t)) {
          break label1470;
        }
      }
    }
    label188:
    label1470:
    for (Object localObject1 = null;; localObject1 = paramh)
    {
      localObject1 = (d.l.b.a.b.b.t)localObject1;
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = (d.l.b.a.b.b.av)((d.l.b.a.b.b.t)localObject1).a(d.l.b.a.b.d.a.b.f.Jzw);
        localObject2 = a(paramD, (d.l.b.a.b.b.av)localObject1, localh, (d.g.a.b)d.JDE).a(null);
        label209:
        if ((paramD instanceof d.l.b.a.b.d.a.b.f)) {
          break label1464;
        }
      }
      for (localObject1 = null;; localObject1 = paramD)
      {
        localObject1 = (d.l.b.a.b.d.a.b.f)localObject1;
        Object localObject3;
        if (localObject1 != null)
        {
          localObject3 = d.l.b.a.b.d.b.v.JEQ;
          localObject3 = ((d.l.b.a.b.d.a.b.f)localObject1).fxq();
          if (localObject3 == null)
          {
            paramD = new d.v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            AppMethodBeat.o(58106);
            throw paramD;
            paramh = paramD;
            break;
            localObject1 = null;
            break label188;
            localObject2 = null;
            break label209;
          }
          localObject1 = d.l.b.a.b.d.b.v.a((d.l.b.a.b.b.e)localObject3, d.l.b.a.b.d.b.t.a((d.l.b.a.b.b.t)localObject1, false, false, 3));
          if (localObject1 != null)
          {
            localObject3 = (j)i.fBU().get(localObject1);
            if (localObject3 == null) {
              break label457;
            }
            if (((j)localObject3).JDm.size() != ((d.l.b.a.b.d.a.b.b)paramD).fyq().size()) {
              break label452;
            }
          }
        }
        label452:
        for (int i = 1;; i = 0)
        {
          if ((!d.aa.JfW) || (i != 0)) {
            break label457;
          }
          paramD = (Throwable)new AssertionError("Predefined enhancement info for " + paramD + " has " + ((j)localObject3).JDm.size() + ", but " + ((d.l.b.a.b.d.a.b.b)paramD).fyq().size() + " expected");
          AppMethodBeat.o(58106);
          throw paramD;
          localObject3 = null;
          break;
        }
        label457:
        localObject1 = paramh.fyq();
        k.g(localObject1, "annotationOwnerForMember.valueParameters");
        localObject1 = (Iterable)localObject1;
        Collection localCollection = (Collection)new ArrayList(d.a.j.a((Iterable)localObject1, 10));
        Iterator localIterator = ((Iterable)localObject1).iterator();
        label586:
        label610:
        Object localObject5;
        if (localIterator.hasNext())
        {
          d.l.b.a.b.b.av localav = (d.l.b.a.b.b.av)localIterator.next();
          localObject4 = a(paramD, localav, localh, (d.g.a.b)new f(localav));
          a locala;
          label732:
          boolean bool1;
          if (localObject3 != null)
          {
            localObject1 = ((j)localObject3).JDm;
            if (localObject1 != null)
            {
              localObject1 = (r)d.a.j.C((List)localObject1, localav.getIndex());
              locala = ((b)localObject4).a((r)localObject1);
              if (!locala.JDo) {
                break label843;
              }
              localObject4 = locala.Jko;
              k.g(localav, "p");
              k.h(localav, "$this$getDefaultValueFromAnnotation");
              localObject1 = localav.fxF();
              localObject5 = d.l.b.a.b.d.a.p.Jyt;
              k.g(localObject5, "JvmAnnotationNames.DEFAULT_VALUE_FQ_NAME");
              localObject1 = ((d.l.b.a.b.b.a.g)localObject1).g((d.l.b.a.b.f.b)localObject5);
              if (localObject1 == null) {
                break label871;
              }
              localObject5 = d.l.b.a.b.j.d.a.m((d.l.b.a.b.b.a.c)localObject1);
              if (localObject5 == null) {
                break label871;
              }
              localObject1 = localObject5;
              if (!(localObject5 instanceof d.l.b.a.b.j.b.v)) {
                localObject1 = null;
              }
              localObject1 = (d.l.b.a.b.j.b.v)localObject1;
              if (localObject1 == null) {
                break label871;
              }
              localObject1 = (String)((d.l.b.a.b.j.b.v)localObject1).getValue();
              if (localObject1 == null) {
                break label871;
              }
              localObject1 = (d.l.b.a.b.d.a.b.a)new d.l.b.a.b.d.a.b.j((String)localObject1);
              if (!(localObject1 instanceof d.l.b.a.b.d.a.b.j)) {
                break label928;
              }
              if (d.l.b.a.b.d.a.u.a((ab)localObject4, ((d.l.b.a.b.d.a.b.j)localObject1).value) == null) {
                break label922;
              }
              bool1 = true;
              label759:
              if ((!bool1) || (!localav.fys().isEmpty())) {
                break label981;
              }
              bool1 = true;
              if ((!locala.JDo) && (bool1 == localav.fzt())) {
                break label987;
              }
            }
          }
          label843:
          label981:
          label987:
          for (boolean bool2 = true;; bool2 = false)
          {
            localCollection.add(new c(locala.Jko, bool1, bool2, locala.JDp));
            break;
            localObject1 = null;
            break label586;
            k.g(localav, "p");
            localObject4 = localav.fzr();
            k.g(localObject4, "p.type");
            break label610;
            label871:
            localObject1 = localav.fxF();
            localObject5 = d.l.b.a.b.d.a.p.Jyu;
            k.g(localObject5, "JvmAnnotationNames.DEFAULT_NULL_FQ_NAME");
            if (((d.l.b.a.b.b.a.g)localObject1).h((d.l.b.a.b.f.b)localObject5))
            {
              localObject1 = (d.l.b.a.b.d.a.b.a)d.l.b.a.b.d.a.b.h.JzH;
              break label732;
            }
            localObject1 = null;
            break label732;
            bool1 = false;
            break label759;
            if (k.g(localObject1, d.l.b.a.b.d.a.b.h.JzH))
            {
              bool1 = bc.aG((ab)localObject4);
              break label759;
            }
            if (localObject1 == null)
            {
              bool1 = localav.fzt();
              break label759;
            }
            paramD = new d.m();
            AppMethodBeat.o(58106);
            throw paramD;
            bool1 = false;
            break label782;
          }
        }
        localObject1 = (List)localCollection;
        Object localObject4 = (d.l.b.a.b.b.a.a)paramh;
        if (!(paramD instanceof ah)) {}
        for (paramh = null;; paramh = paramD)
        {
          paramh = (ah)paramh;
          label1147:
          int j;
          if ((paramh != null) && (d.l.b.a.b.d.a.c.a.c.e(paramh) == true))
          {
            paramh = a.a.Jxb;
            localObject4 = a(paramD, (d.l.b.a.b.b.a.a)localObject4, true, localh, paramh, (d.g.a.b)e.JDF);
            if (localObject3 == null) {
              break label1367;
            }
            paramh = ((j)localObject3).JDl;
            localObject3 = ((b)localObject4).a(paramh);
            if (((localObject2 == null) || (((a)localObject2).JDp != true)) && (!((a)localObject3).JDp))
            {
              paramh = (Iterable)localObject1;
              if (((Collection)paramh).isEmpty()) {
                break label1372;
              }
              paramh = paramh.iterator();
            }
            while (paramh.hasNext()) {
              if (((c)paramh.next()).JDp)
              {
                i = 1;
                if (i == 0) {
                  break label1377;
                }
                i = 1;
                if (((localObject2 == null) || (((a)localObject2).JDo != true)) && (!((a)localObject3).JDo))
                {
                  paramh = (Iterable)localObject1;
                  if (((Collection)paramh).isEmpty()) {
                    break label1382;
                  }
                  paramh = paramh.iterator();
                }
                while (paramh.hasNext()) {
                  if (((c)paramh.next()).JDo)
                  {
                    j = 1;
                    label1227:
                    if ((j == 0) && (i == 0)) {
                      break label1452;
                    }
                    if (i == 0) {
                      break label1388;
                    }
                    paramh = d.u.P(d.l.b.a.b.j.c.a.fIZ(), new d.l.b.a.b.d.a.g((d.l.b.a.b.b.l)paramD));
                    label1258:
                    localObject4 = (d.l.b.a.b.d.a.b.b)paramD;
                    if (localObject2 == null) {
                      break label1393;
                    }
                  }
                }
              }
            }
          }
          label1367:
          label1372:
          label1377:
          label1382:
          label1388:
          label1393:
          for (paramD = ((a)localObject2).Jko;; paramD = null)
          {
            localObject2 = (Iterable)localObject1;
            localObject1 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject2, 10));
            localObject2 = ((Iterable)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject5 = (c)((Iterator)localObject2).next();
              ((Collection)localObject1).add(new d.l.b.a.b.d.a.b.l(((a)localObject5).Jko, ((c)localObject5).JzI));
            }
            paramh = a.a.JwZ;
            break;
            paramh = null;
            break label1066;
            i = 0;
            break label1147;
            i = 0;
            break label1153;
            j = 0;
            break label1227;
            paramh = null;
            break label1258;
          }
          paramD = ((d.l.b.a.b.d.a.b.b)localObject4).a(paramD, (List)localObject1, ((a)localObject3).Jko, paramh);
          if (paramD == null)
          {
            paramD = new d.v("null cannot be cast to non-null type D");
            AppMethodBeat.o(58106);
            throw paramD;
          }
          paramD = (d.l.b.a.b.b.b)paramD;
          AppMethodBeat.o(58106);
          return paramD;
          AppMethodBeat.o(58106);
          return paramD;
        }
      }
    }
  }
  
  private final b a(d.l.b.a.b.b.b paramb, d.l.b.a.b.b.a.a parama, boolean paramBoolean, d.l.b.a.b.d.a.c.h paramh, a.a parama1, d.g.a.b<? super d.l.b.a.b.b.b, ? extends ab> paramb1)
  {
    AppMethodBeat.i(58108);
    ab localab = (ab)paramb1.aA(paramb);
    Collection localCollection = paramb.fys();
    k.g(localCollection, "this.overriddenDescriptors");
    Object localObject = (Iterable)localCollection;
    localCollection = (Collection)new ArrayList(d.a.j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      d.l.b.a.b.b.b localb = (d.l.b.a.b.b.b)((Iterator)localObject).next();
      k.g(localb, "it");
      localCollection.add((ab)paramb1.aA(localb));
    }
    paramb = new b(parama, localab, (Collection)localCollection, paramBoolean, d.l.b.a.b.d.a.c.a.b(paramh, ((ab)paramb1.aA(paramb)).fxF()), parama1);
    AppMethodBeat.o(58108);
    return paramb;
  }
  
  private final b a(d.l.b.a.b.b.b paramb, d.l.b.a.b.b.av paramav, d.l.b.a.b.d.a.c.h paramh, d.g.a.b<? super d.l.b.a.b.b.b, ? extends ab> paramb1)
  {
    AppMethodBeat.i(58107);
    d.l.b.a.b.b.a.a locala = (d.l.b.a.b.b.a.a)paramav;
    if (paramav != null)
    {
      paramav = d.l.b.a.b.d.a.c.a.b(paramh, paramav.fxF());
      if (paramav != null) {
        break label54;
      }
    }
    for (;;)
    {
      paramb = a(paramb, locala, false, paramh, a.a.Jxa, paramb1);
      AppMethodBeat.o(58107);
      return paramb;
      label54:
      paramh = paramav;
    }
  }
  
  private static h h(d.l.b.a.b.b.a.c paramc)
  {
    AppMethodBeat.i(58102);
    d.l.b.a.b.j.b.g localg = d.l.b.a.b.j.d.a.m(paramc);
    paramc = localg;
    if (!(localg instanceof d.l.b.a.b.j.b.j)) {
      paramc = null;
    }
    paramc = (d.l.b.a.b.j.b.j)paramc;
    if (paramc == null)
    {
      paramc = new h(g.JCS);
      AppMethodBeat.o(58102);
      return paramc;
    }
    paramc = paramc.JSf.qV();
    switch (paramc.hashCode())
    {
    }
    do
    {
      do
      {
        do
        {
          AppMethodBeat.o(58102);
          return null;
        } while (!paramc.equals("MAYBE"));
        for (;;)
        {
          paramc = new h(g.JCR);
          AppMethodBeat.o(58102);
          return paramc;
          if (!paramc.equals("NEVER")) {
            break;
          }
        }
      } while (!paramc.equals("UNKNOWN"));
      paramc = new h(g.JCT);
      AppMethodBeat.o(58102);
      return paramc;
    } while (!paramc.equals("ALWAYS"));
    paramc = new h(g.JCS);
    AppMethodBeat.o(58102);
    return paramc;
  }
  
  private final h j(d.l.b.a.b.b.a.c paramc)
  {
    AppMethodBeat.i(58104);
    Object localObject = paramc.fzd();
    if (localObject == null)
    {
      AppMethodBeat.o(58104);
      return null;
    }
    if (q.fBo().contains(localObject)) {
      localObject = new h(g.JCR);
    }
    while (localObject != null) {
      if ((!((h)localObject).JCW) && ((paramc instanceof d.l.b.a.b.d.a.b.i)) && (((d.l.b.a.b.d.a.b.i)paramc).fBy()))
      {
        paramc = h.a((h)localObject, true);
        AppMethodBeat.o(58104);
        return paramc;
        if (q.fBr().contains(localObject)) {
          localObject = new h(g.JCS);
        } else if (k.g(localObject, q.fBp())) {
          localObject = h(paramc);
        } else if ((k.g(localObject, q.fBs())) && (this.JwY.Kbx)) {
          localObject = new h(g.JCR);
        } else if ((k.g(localObject, q.fBt())) && (this.JwY.Kbx)) {
          localObject = new h(g.JCS);
        } else if (k.g(localObject, q.fBv())) {
          localObject = new h(g.JCS, true);
        } else if (k.g(localObject, q.fBu())) {
          localObject = new h(g.JCR, true);
        } else {
          localObject = null;
        }
      }
      else
      {
        AppMethodBeat.o(58104);
        return localObject;
      }
    }
    AppMethodBeat.o(58104);
    return null;
  }
  
  public final <D extends d.l.b.a.b.b.b> Collection<D> a(d.l.b.a.b.d.a.c.h paramh, Collection<? extends D> paramCollection)
  {
    AppMethodBeat.i(58105);
    k.h(paramh, "c");
    k.h(paramCollection, "platformSignatures");
    Object localObject = (Iterable)paramCollection;
    paramCollection = (Collection)new ArrayList(d.a.j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramCollection.add(a((d.l.b.a.b.b.b)((Iterator)localObject).next(), paramh));
    }
    paramh = (Collection)paramCollection;
    AppMethodBeat.o(58105);
    return paramh;
  }
  
  public final h i(d.l.b.a.b.b.a.c paramc)
  {
    AppMethodBeat.i(58103);
    k.h(paramc, "annotationDescriptor");
    Object localObject = j(paramc);
    if (localObject != null)
    {
      AppMethodBeat.o(58103);
      return localObject;
    }
    localObject = this.JAa.d(paramc);
    if (localObject == null)
    {
      AppMethodBeat.o(58103);
      return null;
    }
    paramc = this.JAa.f(paramc);
    if (paramc.fKm())
    {
      AppMethodBeat.o(58103);
      return null;
    }
    localObject = j((d.l.b.a.b.b.a.c)localObject);
    if (localObject != null)
    {
      paramc = h.a((h)localObject, paramc.fKl());
      AppMethodBeat.o(58103);
      return paramc;
    }
    AppMethodBeat.o(58103);
    return null;
  }
  
  static class a
  {
    final boolean JDo;
    final boolean JDp;
    final ab Jko;
    
    public a(ab paramab, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(58078);
      this.Jko = paramab;
      this.JDo = paramBoolean1;
      this.JDp = paramBoolean2;
      AppMethodBeat.o(58078);
    }
  }
  
  final class b
  {
    private final d.l.b.a.b.b.a.a JDq;
    private final ab JDr;
    private final Collection<ab> JDs;
    private final boolean JDt;
    private final d.l.b.a.b.d.a.c.h JDu;
    private final a.a JDv;
    
    public b(ab paramab, Collection<? extends ab> paramCollection, boolean paramBoolean, d.l.b.a.b.d.a.c.h paramh, a.a parama)
    {
      AppMethodBeat.i(58095);
      this.JDq = paramab;
      this.JDr = paramCollection;
      this.JDs = paramBoolean;
      this.JDt = paramh;
      this.JDu = parama;
      this.JDv = localObject;
      AppMethodBeat.o(58095);
    }
    
    private static d S(ab paramab)
    {
      e locale = null;
      AppMethodBeat.i(58090);
      Object localObject1;
      Object localObject2;
      ab localab;
      label69:
      int i;
      if (d.l.b.a.b.m.y.am(paramab))
      {
        localObject1 = d.l.b.a.b.m.y.an(paramab);
        localObject1 = new o(((d.l.b.a.b.m.v)localObject1).JXH, ((d.l.b.a.b.m.v)localObject1).JXI);
        localObject2 = (ab)((o)localObject1).first;
        localab = (ab)((o)localObject1).second;
        localObject1 = d.l.b.a.b.a.b.c.JoY;
        if (!((ab)localObject2).fBT()) {
          break label143;
        }
        localObject1 = g.JCR;
        k.h(localObject2, "type");
        localObject2 = bc.aH((ab)localObject2);
        if ((localObject2 == null) || (!d.l.b.a.b.a.b.c.i((d.l.b.a.b.b.e)localObject2))) {
          break label163;
        }
        i = 1;
        label98:
        if (i == 0) {
          break label168;
        }
        locale = e.JCN;
      }
      label143:
      label163:
      label168:
      label211:
      for (;;)
      {
        paramab = new d((g)localObject1, locale, paramab.fJW() instanceof f);
        AppMethodBeat.o(58090);
        return paramab;
        localObject1 = new o(paramab, paramab);
        break;
        if (!localab.fBT())
        {
          localObject1 = g.JCS;
          break label69;
        }
        localObject1 = null;
        break label69;
        i = 0;
        break label98;
        k.h(localab, "type");
        localObject2 = bc.aH(localab);
        if ((localObject2 != null) && (d.l.b.a.b.a.b.c.h((d.l.b.a.b.b.e)localObject2))) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label211;
          }
          locale = e.JCO;
          break;
        }
      }
    }
    
    private final List<p> T(ab paramab)
    {
      AppMethodBeat.i(58093);
      ArrayList localArrayList = new ArrayList(1);
      new f(localArrayList).a(paramab, this.JDu);
      paramab = (List)localArrayList;
      AppMethodBeat.o(58093);
      return paramab;
    }
    
    private final d a(ab paramab, Collection<? extends ab> paramCollection, d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(58094);
      Object localObject2 = (Iterable)paramCollection;
      Object localObject1 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((Collection)localObject1).add(S((ab)((Iterator)localObject2).next()));
      }
      List localList = (List)localObject1;
      localObject2 = (Iterable)localList;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((d)((Iterator)localObject2).next()).JCI;
        if (localObject3 != null) {
          ((Collection)localObject1).add(localObject3);
        }
      }
      Object localObject3 = d.a.j.o((Iterable)localObject1);
      localObject2 = (Iterable)localList;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = ((d)((Iterator)localObject2).next()).JCH;
        if (localObject4 != null) {
          ((Collection)localObject1).add(localObject4);
        }
      }
      Object localObject4 = d.a.j.o((Iterable)localObject1);
      paramCollection = (Iterable)paramCollection;
      localObject2 = (Collection)new ArrayList();
      Object localObject5 = paramCollection.iterator();
      if (((Iterator)localObject5).hasNext())
      {
        paramCollection = (ab)((Iterator)localObject5).next();
        k.h(paramCollection, "$this$unwrapEnhancement");
        localObject1 = be.aK(paramCollection);
        if (localObject1 != null) {
          break label732;
        }
      }
      for (;;)
      {
        paramCollection = S(paramCollection).JCH;
        if (paramCollection == null) {
          break;
        }
        ((Collection)localObject2).add(paramCollection);
        break;
        localObject5 = d.a.j.o((Iterable)localObject2);
        paramd = a(paramab, paramBoolean, paramd);
        int i;
        label374:
        label383:
        g localg;
        label404:
        label454:
        label461:
        label482:
        label490:
        int j;
        if (!paramd.JCK)
        {
          i = 1;
          if (i == 0) {
            break label640;
          }
          paramab = paramd;
          if (paramab == null) {
            break label645;
          }
          paramCollection = paramab.JCH;
          localg = paramd.JCH;
          if ((!this.JDt) || (!paramBoolean)) {
            break label650;
          }
          bool = true;
          localObject1 = n.a((Set)localObject4, paramCollection, bool);
          if (localObject1 == null) {
            break label678;
          }
          localObject2 = this.JDq;
          paramab = (ab)localObject2;
          if (!(localObject2 instanceof d.l.b.a.b.b.av)) {
            paramab = null;
          }
          paramab = (d.l.b.a.b.b.av)paramab;
          if (paramab == null) {
            break label656;
          }
          paramab = paramab.fzu();
          if (paramab == null) {
            break label661;
          }
          i = 1;
          if ((i == 0) || (!paramBoolean) || (localObject1 != g.JCR)) {
            break label667;
          }
          i = 1;
          if (i != 0) {
            break label673;
          }
          paramab = (ab)localObject1;
          localObject1 = (e)n.a((Set)localObject3, e.JCO, e.JCN, paramd.JCI, bool);
          if ((localg == paramCollection) && (!(k.g(localObject5, localObject4) ^ true))) {
            break label683;
          }
          i = 1;
          label533:
          if (!paramd.JCJ)
          {
            paramCollection = (Iterable)localList;
            if (((Collection)paramCollection).isEmpty()) {
              break label689;
            }
            paramCollection = paramCollection.iterator();
            while (paramCollection.hasNext()) {
              if (((d)paramCollection.next()).JCJ)
              {
                j = 1;
                label592:
                if (j == 0) {
                  break label695;
                }
              }
            }
          }
        }
        label640:
        label645:
        label650:
        label656:
        label661:
        label667:
        label673:
        label678:
        label683:
        label689:
        label695:
        for (paramBoolean = true;; paramBoolean = false)
        {
          if ((paramab != null) || (i == 0)) {
            break label701;
          }
          paramab = n.a(n.a((Set)localObject5, localg, bool), (e)localObject1, true, paramBoolean);
          AppMethodBeat.o(58094);
          return paramab;
          i = 0;
          break;
          paramab = null;
          break label374;
          paramCollection = null;
          break label383;
          bool = false;
          break label404;
          paramab = null;
          break label454;
          i = 0;
          break label461;
          i = 0;
          break label482;
          paramab = null;
          break label490;
          paramab = null;
          break label490;
          i = 0;
          break label533;
          j = 0;
          break label592;
        }
        label701:
        if (paramab == null) {}
        for (boolean bool = true;; bool = false)
        {
          paramab = n.a(paramab, (e)localObject1, bool, paramBoolean);
          AppMethodBeat.o(58094);
          return paramab;
        }
        label732:
        paramCollection = (Collection<? extends ab>)localObject1;
      }
    }
    
    private final d a(ab paramab, boolean paramBoolean, d paramd)
    {
      g localg = null;
      AppMethodBeat.i(58091);
      Object localObject1;
      Object localObject2;
      l.b.e locale;
      if ((paramBoolean) && (this.JDq != null))
      {
        localObject1 = d.l.b.a.b.b.a.i.a(this.JDq.fxF(), paramab.fxF());
        localObject2 = new l.b.d((d.l.b.a.b.b.a.g)localObject1);
        locale = l.b.e.JDC;
        if (paramBoolean)
        {
          paramd = this.JDu.fBC();
          if (paramd == null) {
            break label281;
          }
          paramd = paramd.b(this.JDv);
        }
        label79:
        localObject1 = (Iterable)localObject1;
        l locall = l.this;
        Iterator localIterator = ((Iterable)localObject1).iterator();
        while (localIterator.hasNext())
        {
          localObject1 = locall.i((d.l.b.a.b.b.a.c)localIterator.next());
          if (localObject1 != null)
          {
            label133:
            if (localObject1 != null) {
              break label314;
            }
            if ((paramd == null) || (paramd.JCH == null)) {
              break label292;
            }
            paramd = new h(paramd.JCH, paramd.JCK);
          }
        }
      }
      for (;;)
      {
        label165:
        if (paramd != null)
        {
          localObject1 = paramd.JCV;
          label175:
          localObject2 = (e)locale.n(((l.b.d)localObject2).a(q.fBw(), e.JCN), ((l.b.d)localObject2).a(q.fBx(), e.JCO));
          if (paramd != null) {
            localg = paramd.JCV;
          }
          if ((localg != g.JCS) || (!d.l.b.a.b.m.d.a.aI(paramab))) {
            break label303;
          }
          paramBoolean = true;
          label234:
          if ((paramd == null) || (paramd.JCW != true)) {
            break label308;
          }
        }
        label281:
        label292:
        label303:
        label308:
        for (boolean bool = true;; bool = false)
        {
          paramab = new d((g)localObject1, (e)localObject2, paramBoolean, bool);
          AppMethodBeat.o(58091);
          return paramab;
          localObject1 = paramab.fxF();
          break;
          paramd = null;
          break label79;
          localObject1 = null;
          break label133;
          paramd = null;
          break label165;
          localObject1 = null;
          break label175;
          paramBoolean = false;
          break label234;
        }
        label314:
        paramd = (d)localObject1;
      }
    }
    
    private final d.g.a.b<Integer, d> fBY()
    {
      AppMethodBeat.i(58092);
      Object localObject2 = (Iterable)this.JDs;
      Object localObject1 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((Collection)localObject1).add(T((ab)((Iterator)localObject2).next()));
      }
      localObject2 = (List)localObject1;
      List localList = T(this.JDr);
      Object localObject3;
      int i;
      label182:
      label188:
      label194:
      int j;
      label200:
      int k;
      if (this.JDt)
      {
        localObject1 = (Iterable)this.JDs;
        if ((!(localObject1 instanceof Collection)) || (!((Collection)localObject1).isEmpty()))
        {
          localObject1 = ((Iterable)localObject1).iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localObject3 = (ab)((Iterator)localObject1).next();
            if (!d.l.b.a.b.m.a.g.JYN.d((ab)localObject3, this.JDr))
            {
              i = 1;
              if (i == 0) {
                break label270;
              }
              i = 1;
              if (i == 0) {
                break label277;
              }
              i = 1;
              if (i == 0) {
                break label282;
              }
              j = 1;
              localObject3 = new d[j];
              k = 0;
            }
          }
        }
      }
      for (;;)
      {
        if (k >= j) {
          break label454;
        }
        boolean bool;
        if (k == 0)
        {
          bool = true;
          label220:
          if ((!bool) && (i != 0)) {
            break label299;
          }
        }
        label270:
        label277:
        label282:
        label299:
        for (int m = 1;; m = 0)
        {
          if ((!d.aa.JfW) || (m != 0)) {
            break label305;
          }
          localObject1 = (Throwable)new AssertionError("Only head type constructors should be computed");
          AppMethodBeat.o(58092);
          throw ((Throwable)localObject1);
          i = 0;
          break label182;
          break;
          i = 0;
          break label188;
          i = 0;
          break label194;
          j = localList.size();
          break label200;
          bool = false;
          break label220;
        }
        label305:
        localObject1 = (p)localList.get(k);
        ab localab = ((p)localObject1).Jko;
        d locald = ((p)localObject1).JDM;
        localObject1 = (Iterable)localObject2;
        Collection localCollection = (Collection)new ArrayList();
        Iterator localIterator = ((Iterable)localObject1).iterator();
        label423:
        while (localIterator.hasNext())
        {
          localObject1 = (p)d.a.j.C((List)localIterator.next(), k);
          if (localObject1 != null) {}
          for (localObject1 = ((p)localObject1).Jko;; localObject1 = null)
          {
            if (localObject1 == null) {
              break label423;
            }
            localCollection.add(localObject1);
            break;
          }
        }
        localObject3[k] = a(localab, (Collection)(List)localCollection, locald, bool);
        k += 1;
      }
      label454:
      localObject1 = (d.g.a.b)new a((d[])localObject3);
      AppMethodBeat.o(58092);
      return localObject1;
    }
    
    public final l.a a(r paramr)
    {
      AppMethodBeat.i(58089);
      d.g.a.b localb = fBY();
      if (paramr != null) {}
      boolean bool;
      for (paramr = (d.g.a.b)new l.b.b(paramr, localb);; paramr = null)
      {
        bool = bc.b(this.JDr, (d.g.a.b)c.JDA);
        ab localab = this.JDr;
        Object localObject = paramr;
        if (paramr == null) {
          localObject = localb;
        }
        paramr = s.a(localab, (d.g.a.b)localObject);
        if (paramr == null) {
          break;
        }
        paramr = new l.a(paramr, true, bool);
        AppMethodBeat.o(58089);
        return paramr;
      }
      paramr = new l.a(this.JDr, false, bool);
      AppMethodBeat.o(58089);
      return paramr;
    }
    
    static final class a
      extends d.g.b.l
      implements d.g.a.b<Integer, d>
    {
      a(d[] paramArrayOfd)
      {
        super();
      }
    }
    
    static final class c
      extends d.g.b.l
      implements d.g.a.b<bg, Boolean>
    {
      public static final c JDA;
      
      static
      {
        AppMethodBeat.i(58082);
        JDA = new c();
        AppMethodBeat.o(58082);
      }
      
      c()
      {
        super();
      }
    }
    
    static final class f
      extends d.g.b.l
      implements d.g.a.m<ab, d.l.b.a.b.d.a.c.h, d.y>
    {
      f(ArrayList paramArrayList)
      {
        super();
      }
      
      public final void a(ab paramab, d.l.b.a.b.d.a.c.h paramh)
      {
        AppMethodBeat.i(58088);
        k.h(paramab, "type");
        k.h(paramh, "ownerContext");
        d.l.b.a.b.d.a.c.h localh = d.l.b.a.b.d.a.c.a.b(paramh, paramab.fxF());
        Object localObject = this.JDD;
        paramh = localh.fBC();
        if (paramh != null)
        {
          paramh = paramh.b(a.a.Jxc);
          ((ArrayList)localObject).add(new p(paramab, paramh));
          paramab = paramab.fIT().iterator();
        }
        for (;;)
        {
          if (!paramab.hasNext()) {
            break label173;
          }
          paramh = (d.l.b.a.b.m.av)paramab.next();
          if (paramh.fJY())
          {
            localObject = this.JDD;
            paramh = paramh.fzr();
            k.g(paramh, "arg.type");
            ((ArrayList)localObject).add(new p(paramh, null));
            continue;
            paramh = null;
            break;
          }
          localObject = (f)this;
          paramh = paramh.fzr();
          k.g(paramh, "arg.type");
          ((f)localObject).a(paramh, localh);
        }
        label173:
        AppMethodBeat.o(58088);
      }
    }
  }
  
  static final class c
    extends l.a
  {
    final boolean JzI;
    
    public c(ab paramab, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      super(paramBoolean2, paramBoolean3);
      AppMethodBeat.i(58096);
      this.JzI = paramBoolean1;
      AppMethodBeat.o(58096);
    }
  }
  
  static final class d
    extends d.g.b.l
    implements d.g.a.b<d.l.b.a.b.b.b, ab>
  {
    public static final d JDE;
    
    static
    {
      AppMethodBeat.i(58098);
      JDE = new d();
      AppMethodBeat.o(58098);
    }
    
    d()
    {
      super();
    }
  }
  
  static final class e
    extends d.g.b.l
    implements d.g.a.b<d.l.b.a.b.b.b, ab>
  {
    public static final e JDF;
    
    static
    {
      AppMethodBeat.i(58100);
      JDF = new e();
      AppMethodBeat.o(58100);
    }
    
    e()
    {
      super();
    }
  }
  
  static final class f
    extends d.g.b.l
    implements d.g.a.b<d.l.b.a.b.b.b, ab>
  {
    f(d.l.b.a.b.b.av paramav)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.d.a.f.l
 * JD-Core Version:    0.7.0.1
 */