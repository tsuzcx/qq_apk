package kotlin.l.b.a.b.d.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collection<+Lkotlin.l.b.a.b.m.ad;>;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.g.b.u;
import kotlin.l.b.a.b.b.a.g.a;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.ap;
import kotlin.l.b.a.b.b.b.a;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.bd;
import kotlin.l.b.a.b.d.a.c.a;
import kotlin.l.b.a.b.d.a.c.a.m;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.af;
import kotlin.l.b.a.b.m.al;
import kotlin.l.b.a.b.m.ax;
import kotlin.l.b.a.b.m.az;
import kotlin.l.b.a.b.m.bg;
import kotlin.l.b.a.b.m.bi;
import kotlin.l.b.a.b.m.bk;
import kotlin.l.b.a.b.m.bl;
import kotlin.l.b.a.b.m.z;

public final class l
{
  private final kotlin.l.b.a.b.d.a.s aiOo;
  final kotlin.l.b.a.b.d.a.c aiRX;
  final d aiVs;
  
  public l(kotlin.l.b.a.b.d.a.c paramc, kotlin.l.b.a.b.d.a.s params, d paramd)
  {
    AppMethodBeat.i(192072);
    this.aiRX = paramc;
    this.aiOo = params;
    this.aiVs = paramd;
    AppMethodBeat.o(192072);
  }
  
  private final <D extends kotlin.l.b.a.b.b.b> D a(D paramD, kotlin.l.b.a.b.d.a.c.h paramh)
  {
    AppMethodBeat.i(58106);
    if (!(paramD instanceof kotlin.l.b.a.b.d.a.b.a))
    {
      AppMethodBeat.o(58106);
      return paramD;
    }
    if ((((kotlin.l.b.a.b.d.a.b.a)paramD).koh() == b.a.aiGm) && (((kotlin.l.b.a.b.d.a.b.a)paramD).kog().kof().size() == 1))
    {
      AppMethodBeat.o(58106);
      return paramD;
    }
    Object localObject1 = (kotlin.l.b.a.b.b.l)paramD;
    kotlin.g.b.s.u(localObject1, "<this>");
    Object localObject2 = ((kotlin.l.b.a.b.b.l)localObject1).knp();
    label102:
    label115:
    Object localObject4;
    int i;
    if ((localObject2 == null) || ((localObject1 instanceof ah)))
    {
      localObject1 = null;
      if (localObject1 != null) {
        break label430;
      }
      localObject1 = paramD.knl();
      localObject4 = kotlin.l.b.a.b.d.a.c.a.b(paramh, (kotlin.l.b.a.b.b.a.g)localObject1);
      if (!(paramD instanceof kotlin.l.b.a.b.d.a.b.f)) {
        break label638;
      }
      paramh = ((kotlin.l.b.a.b.d.a.b.f)paramD).aiLL;
      if ((paramh == null) || (paramh.oBZ)) {
        break label633;
      }
      i = 1;
      label151:
      if (i == 0) {
        break label638;
      }
      paramh = ((kotlin.l.b.a.b.d.a.b.f)paramD).aiLL;
      kotlin.g.b.s.checkNotNull(paramh);
      kotlin.g.b.s.s(paramh, "getter!!");
      paramh = (kotlin.l.b.a.b.b.b)paramh;
      label178:
      if (((kotlin.l.b.a.b.d.a.b.a)paramD).knY() == null) {
        break label661;
      }
      if ((paramh instanceof kotlin.l.b.a.b.b.x)) {
        break label1432;
      }
    }
    label256:
    label516:
    label521:
    label661:
    label1432:
    for (localObject1 = null;; localObject1 = paramh)
    {
      localObject1 = (kotlin.l.b.a.b.b.x)localObject1;
      label215:
      Object localObject3;
      if (localObject1 == null)
      {
        localObject1 = null;
        localObject3 = b.a(a(paramD, (bd)localObject1, (kotlin.l.b.a.b.d.a.c.h)localObject4, (kotlin.g.a.b)c.aiVJ));
        label235:
        if (!(paramD instanceof kotlin.l.b.a.b.d.a.b.e)) {
          break label667;
        }
        localObject1 = (kotlin.l.b.a.b.d.a.b.e)paramD;
        label248:
        if (localObject1 != null) {
          break label673;
        }
        localObject1 = null;
        if (localObject1 == null) {
          break label734;
        }
        if (((k)localObject1).aiVr.size() != ((kotlin.l.b.a.b.d.a.b.a)paramD).kod().size()) {
          break label729;
        }
      }
      label430:
      label445:
      label453:
      label729:
      for (i = 1;; i = 0)
      {
        if ((!kotlin.ak.aiuY) || (i != 0)) {
          break label734;
        }
        paramD = (Throwable)new AssertionError("Predefined enhancement info for " + paramD + " has " + ((k)localObject1).aiVr.size() + ", but " + ((kotlin.l.b.a.b.d.a.b.a)paramD).kod().size() + " expected");
        AppMethodBeat.o(58106);
        throw paramD;
        kotlin.g.b.s.u(localObject2, "<this>");
        if (!(((kotlin.l.b.a.b.b.l)localObject2).knp() instanceof ah))
        {
          localObject1 = localObject2;
          break;
        }
        if ((localObject2 instanceof kotlin.l.b.a.b.b.h))
        {
          localObject1 = (kotlin.l.b.a.b.b.h)localObject2;
          break label102;
        }
        localObject1 = null;
        break label102;
        if ((localObject1 instanceof kotlin.l.b.a.b.d.a.c.a.f))
        {
          localObject1 = (kotlin.l.b.a.b.d.a.c.a.f)localObject1;
          if (localObject1 != null) {
            break label498;
          }
          localObject1 = null;
          localObject2 = (Collection)localObject1;
          if ((localObject2 != null) && (!((Collection)localObject2).isEmpty())) {
            break label516;
          }
        }
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label521;
          }
          localObject1 = paramD.knl();
          break;
          localObject1 = null;
          break label445;
          label498:
          localObject1 = (List)((kotlin.l.b.a.b.d.a.c.a.f)localObject1).aiST.getValue();
          break label453;
        }
        localObject2 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((Collection)localObject1).add(new kotlin.l.b.a.b.d.a.c.a.e(paramh, (kotlin.l.b.a.b.d.a.e.a)((Iterator)localObject2).next(), true));
        }
        localObject1 = (List)localObject1;
        localObject2 = kotlin.l.b.a.b.b.a.g.aiIh;
        localObject1 = g.a.oS(kotlin.a.p.c((Iterable)paramD.knl(), (Iterable)localObject1));
        break label115;
        label633:
        i = 0;
        break label151;
        label638:
        paramh = paramD;
        break label178;
        localObject1 = (bd)((kotlin.l.b.a.b.b.x)localObject1).a(kotlin.l.b.a.b.d.a.b.e.aiRt);
        break label215;
        localObject3 = null;
        break label235;
        localObject1 = null;
        break label248;
        localObject1 = kotlin.l.b.a.b.d.b.s.a(kotlin.l.b.a.b.d.b.v.aiXe, (kotlin.l.b.a.b.b.e)((kotlin.l.b.a.b.d.a.b.e)localObject1).knp(), kotlin.l.b.a.b.d.b.t.a((kotlin.l.b.a.b.b.x)localObject1, false, false, 3));
        if (localObject1 == null)
        {
          localObject1 = null;
          break label256;
        }
        localObject1 = (k)j.ksC().get(localObject1);
        break label256;
      }
      label667:
      label673:
      label734:
      localObject2 = paramh.kod();
      kotlin.g.b.s.s(localObject2, "annotationOwnerForMember.valueParameters");
      localObject2 = (Iterable)localObject2;
      Object localObject5 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject2, 10));
      Object localObject6 = ((Iterable)localObject2).iterator();
      if (((Iterator)localObject6).hasNext())
      {
        localObject2 = (bd)((Iterator)localObject6).next();
        b localb = a(paramD, (bd)localObject2, (kotlin.l.b.a.b.d.a.c.h)localObject4, (kotlin.g.a.b)new e((bd)localObject2));
        if (localObject1 == null) {
          localObject2 = null;
        }
        for (;;)
        {
          ((Collection)localObject5).add(localb.a((r)localObject2));
          break;
          List localList = ((k)localObject1).aiVr;
          if (localList == null) {
            localObject2 = null;
          } else {
            localObject2 = (r)kotlin.a.p.ae(localList, ((bd)localObject2).getIndex());
          }
        }
      }
      localObject5 = (List)localObject5;
      localObject6 = (kotlin.l.b.a.b.b.a.a)paramh;
      if (!(paramD instanceof ap)) {}
      for (localObject2 = null;; localObject2 = paramD)
      {
        localObject2 = (ap)localObject2;
        label949:
        label977:
        label1002:
        int j;
        if ((localObject2 != null) && (kotlin.l.b.a.b.d.a.c.a.c.d((ap)localObject2) == true))
        {
          i = 1;
          if (i == 0) {
            break label1328;
          }
          localObject2 = kotlin.l.b.a.b.d.a.a.aiOb;
          localObject2 = a(paramD, (kotlin.l.b.a.b.b.a.a)localObject6, true, (kotlin.l.b.a.b.d.a.c.h)localObject4, (kotlin.l.b.a.b.d.a.a)localObject2, (kotlin.g.a.b)l.d.aiVK);
          if (localObject1 != null) {
            break label1336;
          }
          localObject1 = null;
          localObject2 = ((b)localObject2).a((r)localObject1);
          if ((localObject3 == null) || (((a)localObject3).aiVt != true)) {
            break label1346;
          }
          i = 1;
          if ((i == 0) && (!((a)localObject2).aiVt))
          {
            localObject1 = (Iterable)localObject5;
            if (((Collection)localObject1).isEmpty()) {
              break label1351;
            }
            localObject1 = ((Iterable)localObject1).iterator();
          }
          while (((Iterator)localObject1).hasNext()) {
            if (((a)((Iterator)localObject1).next()).aiVt)
            {
              i = 1;
              label1071:
              if (i == 0) {
                break label1356;
              }
              i = 1;
              label1077:
              if ((localObject3 == null) || (((a)localObject3).aiUK != true)) {
                break label1361;
              }
              j = 1;
              label1094:
              if ((j == 0) && (!((a)localObject2).aiUK))
              {
                localObject1 = (Iterable)localObject5;
                if (((Collection)localObject1).isEmpty()) {
                  break label1367;
                }
                localObject1 = ((Iterable)localObject1).iterator();
              }
              while (((Iterator)localObject1).hasNext()) {
                if (((a)((Iterator)localObject1).next()).aiUK)
                {
                  j = 1;
                  if ((j == 0) && (i == 0)) {
                    break label1419;
                  }
                  if (i == 0) {
                    break label1373;
                  }
                  localObject1 = kotlin.v.Y(kotlin.l.b.a.b.j.c.a.kzp(), new kotlin.l.b.a.b.d.a.i((kotlin.l.b.a.b.b.l)paramD));
                  label1197:
                  localObject4 = (kotlin.l.b.a.b.d.a.b.a)paramD;
                  if (localObject3 != null) {
                    break label1379;
                  }
                }
              }
            }
          }
        }
        label1328:
        label1336:
        label1346:
        label1351:
        label1356:
        label1361:
        label1367:
        label1373:
        label1379:
        for (paramD = null;; paramD = ((a)localObject3).aiAd)
        {
          localObject5 = (Iterable)localObject5;
          localObject3 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject5, 10));
          localObject5 = ((Iterable)localObject5).iterator();
          i = 0;
          while (((Iterator)localObject5).hasNext())
          {
            localObject6 = ((Iterator)localObject5).next();
            if (i < 0) {
              kotlin.a.p.kkW();
            }
            ((Collection)localObject3).add(new kotlin.l.b.a.b.d.a.b.i(((a)localObject6).aiAd, ((bd)paramh.kod().get(i)).kpp()));
            i += 1;
          }
          i = 0;
          break;
          localObject2 = kotlin.l.b.a.b.d.a.a.aiNZ;
          break label949;
          localObject1 = ((k)localObject1).aiVq;
          break label977;
          i = 0;
          break label1002;
          i = 0;
          break label1071;
          i = 0;
          break label1077;
          j = 0;
          break label1094;
          j = 0;
          break label1165;
          localObject1 = null;
          break label1197;
        }
        paramD = (kotlin.l.b.a.b.b.b)((kotlin.l.b.a.b.d.a.b.a)localObject4).a(paramD, (List)localObject3, ((a)localObject2).aiAd, (kotlin.r)localObject1);
        AppMethodBeat.o(58106);
        return paramD;
        AppMethodBeat.o(58106);
        return paramD;
      }
    }
  }
  
  private static i a(kotlin.l.b.a.b.b.a.c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(192080);
    paramc = kotlin.l.b.a.b.j.d.a.k(paramc);
    if ((paramc instanceof kotlin.l.b.a.b.j.b.j)) {}
    for (paramc = (kotlin.l.b.a.b.j.b.j)paramc; paramc == null; paramc = null)
    {
      paramc = new i(h.aiUX, paramBoolean);
      AppMethodBeat.o(192080);
      return paramc;
    }
    paramc = paramc.ajjI.PF();
    switch (paramc.hashCode())
    {
    }
    do
    {
      do
      {
        do
        {
          AppMethodBeat.o(192080);
          return null;
        } while (!paramc.equals("MAYBE"));
        do
        {
          paramc = new i(h.aiUW, paramBoolean);
          AppMethodBeat.o(192080);
          return paramc;
        } while (paramc.equals("NEVER"));
      } while ((goto 108) || (!paramc.equals("UNKNOWN")));
      paramc = new i(h.aiUY, paramBoolean);
      AppMethodBeat.o(192080);
      return paramc;
    } while (!paramc.equals("ALWAYS"));
    paramc = new i(h.aiUX, paramBoolean);
    AppMethodBeat.o(192080);
    return paramc;
  }
  
  private final i a(kotlin.l.b.a.b.f.c paramc, kotlin.l.b.a.b.b.a.c paramc1, boolean paramBoolean)
  {
    AppMethodBeat.i(192086);
    kotlin.l.b.a.b.d.a.ab localab = (kotlin.l.b.a.b.d.a.ab)this.aiOo.aiPf.invoke(paramc);
    if (localab.eDZ())
    {
      AppMethodBeat.o(192086);
      return null;
    }
    if ((localab.krU()) || (paramBoolean)) {}
    for (paramBoolean = true; kotlin.l.b.a.b.d.a.x.krJ().contains(paramc); paramBoolean = false)
    {
      paramc = new i(h.aiUW, paramBoolean);
      AppMethodBeat.o(192086);
      return paramc;
    }
    if (kotlin.l.b.a.b.d.a.x.krM().contains(paramc))
    {
      paramc = new i(h.aiUX, paramBoolean);
      AppMethodBeat.o(192086);
      return paramc;
    }
    if (kotlin.g.b.s.p(paramc, kotlin.l.b.a.b.d.a.x.krG()))
    {
      paramc = new i(h.aiUW, paramBoolean);
      AppMethodBeat.o(192086);
      return paramc;
    }
    if (kotlin.g.b.s.p(paramc, kotlin.l.b.a.b.d.a.x.krH()))
    {
      paramc = new i(h.aiUY, paramBoolean);
      AppMethodBeat.o(192086);
      return paramc;
    }
    if (kotlin.g.b.s.p(paramc, kotlin.l.b.a.b.d.a.x.krK()))
    {
      paramc = a(paramc1, paramBoolean);
      AppMethodBeat.o(192086);
      return paramc;
    }
    if (kotlin.g.b.s.p(paramc, kotlin.l.b.a.b.d.a.x.krN()))
    {
      paramc = new i(h.aiUW, paramBoolean);
      AppMethodBeat.o(192086);
      return paramc;
    }
    if (kotlin.g.b.s.p(paramc, kotlin.l.b.a.b.d.a.x.krO()))
    {
      paramc = new i(h.aiUX, paramBoolean);
      AppMethodBeat.o(192086);
      return paramc;
    }
    if (kotlin.g.b.s.p(paramc, kotlin.l.b.a.b.d.a.x.krQ()))
    {
      paramc = new i(h.aiUX, paramBoolean);
      AppMethodBeat.o(192086);
      return paramc;
    }
    if (kotlin.g.b.s.p(paramc, kotlin.l.b.a.b.d.a.x.krP()))
    {
      paramc = new i(h.aiUW, paramBoolean);
      AppMethodBeat.o(192086);
      return paramc;
    }
    AppMethodBeat.o(192086);
    return null;
  }
  
  private final b a(kotlin.l.b.a.b.b.b paramb, kotlin.l.b.a.b.b.a.a parama, boolean paramBoolean, kotlin.l.b.a.b.d.a.c.h paramh, kotlin.l.b.a.b.d.a.a parama1, kotlin.g.a.b<? super kotlin.l.b.a.b.b.b, ? extends ad> paramb1)
  {
    AppMethodBeat.i(192097);
    ad localad = (ad)paramb1.invoke(paramb);
    Collection localCollection = paramb.kof();
    kotlin.g.b.s.s(localCollection, "this.overriddenDescriptors");
    Object localObject = (Iterable)localCollection;
    localCollection = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      kotlin.l.b.a.b.b.b localb = (kotlin.l.b.a.b.b.b)((Iterator)localObject).next();
      kotlin.g.b.s.s(localb, "it");
      localCollection.add((ad)paramb1.invoke(localb));
    }
    paramb = new b(parama, localad, (Collection)localCollection, paramBoolean, kotlin.l.b.a.b.d.a.c.a.b(paramh, ((ad)paramb1.invoke(paramb)).knl()), parama1, false, false, 192);
    AppMethodBeat.o(192097);
    return paramb;
  }
  
  private final b a(kotlin.l.b.a.b.b.b paramb, bd parambd, kotlin.l.b.a.b.d.a.c.h paramh, kotlin.g.a.b<? super kotlin.l.b.a.b.b.b, ? extends ad> paramb1)
  {
    AppMethodBeat.i(58107);
    kotlin.l.b.a.b.b.a.a locala = (kotlin.l.b.a.b.b.a.a)parambd;
    if (parambd == null) {
      parambd = paramh;
    }
    for (;;)
    {
      paramb = a(paramb, locala, false, parambd, kotlin.l.b.a.b.d.a.a.aiOa, paramb1);
      AppMethodBeat.o(58107);
      return paramb;
      parambd = kotlin.l.b.a.b.d.a.c.a.b(paramh, parambd.knl());
      if (parambd == null) {
        parambd = paramh;
      }
    }
  }
  
  private final i b(kotlin.l.b.a.b.b.a.c paramc, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(192083);
    Object localObject = paramc.koY();
    if (localObject == null)
    {
      AppMethodBeat.o(192083);
      return null;
    }
    if (((paramc instanceof kotlin.l.b.a.b.d.a.c.a.e)) && ((((kotlin.l.b.a.b.d.a.c.a.e)paramc).aiSO) || (paramBoolean2)) && (!paramBoolean1)) {}
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      localObject = a((kotlin.l.b.a.b.f.c)localObject, paramc, paramBoolean1);
      if (localObject != null) {
        break;
      }
      AppMethodBeat.o(192083);
      return null;
    }
    if ((!((i)localObject).aiVb) && ((paramc instanceof kotlin.l.b.a.b.d.a.b.g)) && (((kotlin.l.b.a.b.d.a.b.g)paramc).kqt()))
    {
      paramc = i.a((i)localObject, true);
      AppMethodBeat.o(192083);
      return paramc;
    }
    AppMethodBeat.o(192083);
    return localObject;
  }
  
  public final <D extends kotlin.l.b.a.b.b.b> Collection<D> a(kotlin.l.b.a.b.d.a.c.h paramh, Collection<? extends D> paramCollection)
  {
    AppMethodBeat.i(58105);
    kotlin.g.b.s.u(paramh, "c");
    kotlin.g.b.s.u(paramCollection, "platformSignatures");
    Object localObject = (Iterable)paramCollection;
    paramCollection = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramCollection.add(a((kotlin.l.b.a.b.b.b)((Iterator)localObject).next(), paramh));
    }
    paramh = (Collection)paramCollection;
    AppMethodBeat.o(58105);
    return paramh;
  }
  
  public final i a(kotlin.l.b.a.b.b.a.c paramc, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(192103);
    kotlin.g.b.s.u(paramc, "annotationDescriptor");
    Object localObject = b(paramc, paramBoolean1, paramBoolean2);
    if (localObject != null)
    {
      AppMethodBeat.o(192103);
      return localObject;
    }
    localObject = this.aiRX.d(paramc);
    if (localObject == null)
    {
      AppMethodBeat.o(192103);
      return null;
    }
    paramc = this.aiRX.g(paramc);
    if (paramc.eDZ())
    {
      AppMethodBeat.o(192103);
      return null;
    }
    localObject = b((kotlin.l.b.a.b.b.a.c)localObject, paramBoolean1, paramBoolean2);
    if (localObject == null)
    {
      AppMethodBeat.o(192103);
      return null;
    }
    paramc = i.a((i)localObject, paramc.krU());
    AppMethodBeat.o(192103);
    return paramc;
  }
  
  public static final class a
  {
    public final ad aiAd;
    final boolean aiUK;
    final boolean aiVt;
    
    public a(ad paramad, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(58078);
      this.aiAd = paramad;
      this.aiUK = paramBoolean1;
      this.aiVt = paramBoolean2;
      AppMethodBeat.o(58078);
    }
  }
  
  public final class b
  {
    private final boolean aiVA;
    private final boolean aiVB;
    private final kotlin.l.b.a.b.b.a.a aiVu;
    private final ad aiVv;
    private final Collection<ad> aiVw;
    private final boolean aiVx;
    private final kotlin.l.b.a.b.d.a.c.h aiVy;
    private final kotlin.l.b.a.b.d.a.a aiVz;
    
    private b(ad paramad, Collection<? extends ad> paramCollection, boolean paramBoolean1, kotlin.l.b.a.b.d.a.c.h paramh, kotlin.l.b.a.b.d.a.a parama, boolean paramBoolean2, boolean paramBoolean3)
    {
      AppMethodBeat.i(192055);
      this.aiVu = paramad;
      this.aiVv = paramCollection;
      this.aiVw = paramBoolean1;
      this.aiVx = paramh;
      this.aiVy = parama;
      this.aiVz = paramBoolean2;
      this.aiVA = paramBoolean3;
      boolean bool;
      this.aiVB = bool;
      AppMethodBeat.o(192055);
    }
    
    private static e I(ad paramad)
    {
      f localf = null;
      AppMethodBeat.i(58090);
      Object localObject1;
      Object localObject2;
      ad localad;
      label69:
      int i;
      if (kotlin.l.b.a.b.m.aa.ac(paramad))
      {
        localObject1 = kotlin.l.b.a.b.m.aa.ad(paramad);
        localObject1 = new kotlin.r(((kotlin.l.b.a.b.m.x)localObject1).ajpE, ((kotlin.l.b.a.b.m.x)localObject1).ajpF);
        localObject2 = (ad)((kotlin.r)localObject1).bsC;
        localad = (ad)((kotlin.r)localObject1).bsD;
        localObject1 = kotlin.l.b.a.b.a.b.d.aiFp;
        if (!((ad)localObject2).ksB()) {
          break label143;
        }
        localObject1 = h.aiUW;
        kotlin.g.b.s.u(localObject2, "type");
        localObject2 = bg.az((ad)localObject2);
        if ((localObject2 == null) || (!kotlin.l.b.a.b.a.b.d.i((kotlin.l.b.a.b.b.e)localObject2))) {
          break label163;
        }
        i = 1;
        label98:
        if (i == 0) {
          break label168;
        }
        localf = f.aiUS;
      }
      label143:
      label163:
      label168:
      label211:
      for (;;)
      {
        paramad = new e((h)localObject1, localf, paramad.kAK() instanceof g);
        AppMethodBeat.o(58090);
        return paramad;
        localObject1 = new kotlin.r(paramad, paramad);
        break;
        if (!localad.ksB())
        {
          localObject1 = h.aiUX;
          break label69;
        }
        localObject1 = null;
        break label69;
        i = 0;
        break label98;
        kotlin.g.b.s.u(localad, "type");
        localObject2 = bg.az(localad);
        if ((localObject2 != null) && (kotlin.l.b.a.b.a.b.d.h((kotlin.l.b.a.b.b.e)localObject2))) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label211;
          }
          localf = f.aiUT;
          break;
        }
      }
    }
    
    private final List<n> J(ad paramad)
    {
      AppMethodBeat.i(58093);
      ArrayList localArrayList = new ArrayList(1);
      a(this, localArrayList, paramad, this.aiVy, null);
      paramad = (List)localArrayList;
      AppMethodBeat.o(58093);
      return paramad;
    }
    
    private static final <T> T a(List<kotlin.l.b.a.b.f.c> paramList, kotlin.l.b.a.b.b.a.g paramg, T paramT)
    {
      AppMethodBeat.i(192109);
      paramList = (Iterable)paramList;
      if ((!(paramList instanceof Collection)) || (!((Collection)paramList).isEmpty()))
      {
        paramList = paramList.iterator();
        if (paramList.hasNext()) {
          if (paramg.h((kotlin.l.b.a.b.f.c)paramList.next()) != null)
          {
            i = 1;
            label65:
            if (i == 0) {
              break label85;
            }
          }
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label92;
        }
        AppMethodBeat.o(192109);
        return paramT;
        i = 0;
        break label65;
        label85:
        break;
      }
      label92:
      AppMethodBeat.o(192109);
      return null;
    }
    
    private final e a(ad paramad, Collection<? extends ad> paramCollection, kotlin.l.b.a.b.d.a.n paramn, boolean paramBoolean1, ba paramba, boolean paramBoolean2)
    {
      AppMethodBeat.i(192105);
      Object localObject2 = (Iterable)paramCollection;
      Object localObject1 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((Collection)localObject1).add(I((ad)((Iterator)localObject2).next()));
      }
      localObject2 = (List)localObject1;
      Object localObject3 = (Iterable)localObject2;
      localObject1 = (Collection)new ArrayList();
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = ((e)((Iterator)localObject3).next()).aiUO;
        if (localObject4 != null) {
          ((Collection)localObject1).add(localObject4);
        }
      }
      localObject3 = kotlin.a.p.r((Iterable)localObject1);
      Object localObject4 = (Iterable)localObject2;
      localObject1 = (Collection)new ArrayList();
      localObject4 = ((Iterable)localObject4).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = ((e)((Iterator)localObject4).next()).aiUN;
        if (localObject5 != null) {
          ((Collection)localObject1).add(localObject5);
        }
      }
      localObject4 = kotlin.a.p.r((Iterable)localObject1);
      paramCollection = (Iterable)paramCollection;
      Object localObject5 = (Collection)new ArrayList();
      Object localObject6 = paramCollection.iterator();
      if (((Iterator)localObject6).hasNext())
      {
        paramCollection = (ad)((Iterator)localObject6).next();
        kotlin.g.b.s.u(paramCollection, "<this>");
        localObject1 = bi.aC(paramCollection);
        if (localObject1 == null) {}
        for (;;)
        {
          paramCollection = I(paramCollection).aiUN;
          if (paramCollection == null) {
            break;
          }
          ((Collection)localObject5).add(paramCollection);
          break;
          paramCollection = (Collection<? extends ad>)localObject1;
        }
      }
      localObject5 = kotlin.a.p.r((Iterable)localObject5);
      paramn = a(paramad, paramBoolean1, paramn, paramba, paramBoolean2);
      int i;
      label384:
      label390:
      label411:
      label456:
      label463:
      label484:
      label492:
      int j;
      if (!paramn.aiUQ)
      {
        i = 1;
        if (i == 0) {
          break label640;
        }
        paramad = paramn;
        if (paramad != null) {
          break label645;
        }
        paramad = null;
        localObject6 = paramn.aiUN;
        if ((!this.aiVx) || (!paramBoolean1)) {
          break label653;
        }
        paramBoolean2 = true;
        paramba = q.a((Set)localObject4, paramad, paramBoolean2);
        if (paramba == null) {
          break label681;
        }
        localObject1 = this.aiVu;
        paramCollection = (Collection<? extends ad>)localObject1;
        if (!(localObject1 instanceof bd)) {
          paramCollection = null;
        }
        paramCollection = (bd)paramCollection;
        if (paramCollection != null) {
          break label659;
        }
        paramCollection = null;
        if (paramCollection == null) {
          break label669;
        }
        i = 1;
        if ((i == 0) || (!paramBoolean1) || (paramba != h.aiUW)) {
          break label675;
        }
        i = 1;
        if (i != 0) {
          break label681;
        }
        paramCollection = paramba;
        paramba = (f)q.a((Set)localObject3, f.aiUT, f.aiUS, paramn.aiUO, paramBoolean2);
        if ((localObject6 == paramad) && (kotlin.g.b.s.p(localObject5, localObject4))) {
          break label686;
        }
        i = 1;
        label533:
        if (!paramn.aiUP)
        {
          paramad = (Iterable)localObject2;
          if (((Collection)paramad).isEmpty()) {
            break label692;
          }
          paramad = paramad.iterator();
          while (paramad.hasNext()) {
            if (((e)paramad.next()).aiUP)
            {
              j = 1;
              label592:
              if (j == 0) {
                break label698;
              }
            }
          }
        }
      }
      label640:
      label645:
      label653:
      label659:
      label669:
      label675:
      label681:
      label686:
      label692:
      label698:
      for (paramBoolean1 = true;; paramBoolean1 = false)
      {
        if ((paramCollection != null) || (i == 0)) {
          break label704;
        }
        paramad = q.a(q.a((Set)localObject5, (h)localObject6, paramBoolean2), paramba, true, paramBoolean1);
        AppMethodBeat.o(192105);
        return paramad;
        i = 0;
        break;
        paramad = null;
        break label384;
        paramad = paramad.aiUN;
        break label390;
        paramBoolean2 = false;
        break label411;
        paramCollection = paramCollection.kpq();
        break label456;
        i = 0;
        break label463;
        i = 0;
        break label484;
        paramCollection = null;
        break label492;
        i = 0;
        break label533;
        j = 0;
        break label592;
      }
      label704:
      if (paramCollection == null) {}
      for (paramBoolean2 = true;; paramBoolean2 = false)
      {
        paramad = q.a(paramCollection, paramba, paramBoolean2, paramBoolean1);
        AppMethodBeat.o(192105);
        return paramad;
      }
    }
    
    private final e a(ad paramad, boolean paramBoolean1, kotlin.l.b.a.b.d.a.n paramn, ba paramba, boolean paramBoolean2)
    {
      AppMethodBeat.i(192082);
      Object localObject1;
      if (paramBoolean2)
      {
        if (paramba == null) {}
        for (localObject1 = null; localObject1 == bl.ajqN; localObject1 = paramba.kom())
        {
          paramad = e.aiUM;
          paramad = e.ksz();
          AppMethodBeat.o(192082);
          return paramad;
        }
      }
      boolean bool = this.aiVy.aiSp.aiSa.ksi();
      Object localObject3;
      Object localObject2;
      Object localObject4;
      int i;
      if ((paramBoolean1) && (this.aiVu != null) && (!(this.aiVu instanceof ba)) && (bool))
      {
        localObject3 = (Iterable)this.aiVu.knl();
        localObject1 = l.this;
        localObject2 = (Collection)new ArrayList();
        localObject3 = ((Iterable)localObject3).iterator();
        label229:
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = ((Iterator)localObject3).next();
          Object localObject5 = (kotlin.l.b.a.b.b.a.c)localObject4;
          localObject5 = ((l)localObject1).aiRX.f((kotlin.l.b.a.b.b.a.c)localObject5);
          if (localObject5 == null) {
            i = 1;
          }
          for (;;)
          {
            if (i == 0) {
              break label229;
            }
            ((Collection)localObject2).add(localObject4);
            break;
            if (!((c.a)localObject5).component2().contains(kotlin.l.b.a.b.d.a.a.aiOc)) {
              i = 1;
            } else {
              i = 0;
            }
          }
        }
        localObject1 = (List)localObject2;
        localObject2 = kotlin.l.b.a.b.b.a.g.aiIh;
        localObject1 = kotlin.l.b.a.b.b.a.i.a(g.a.oS((List)localObject1), paramad.knl());
        if (!paramBoolean1) {
          break label627;
        }
        paramn = this.aiVy.ksj();
        if (paramn != null) {
          break label615;
        }
        paramn = null;
        label275:
        if (paramn == null) {
          break label636;
        }
        if (((!paramn.aiOO) && (kotlin.l.b.a.b.m.d.a.aA(paramad))) || ((!paramn.aiOP) && (paramBoolean2))) {
          break label630;
        }
        i = 1;
        label308:
        if (i == 0) {
          break label636;
        }
        localObject3 = paramn;
        label316:
        paramn = paramad.kzm().knA();
        if (!(paramn instanceof ba)) {
          break label642;
        }
        paramn = (ba)paramn;
        label338:
        if (paramn != null) {
          break label647;
        }
        paramn = null;
        label344:
        if (paramn != null) {
          break label655;
        }
        paramn = new kotlin.r(null, Boolean.FALSE);
        localObject4 = (i)paramn.bsC;
        paramBoolean1 = ((Boolean)paramn.bsD).booleanValue();
        localObject2 = a((kotlin.l.b.a.b.b.a.g)localObject1, bool, this.aiVA);
        if ((localObject2 == null) || (paramBoolean2)) {
          break label705;
        }
        label404:
        if (localObject2 != null) {
          break label1081;
        }
        if (localObject4 != null) {
          break label745;
        }
        if (localObject3 != null) {
          break label711;
        }
        paramn = null;
        label421:
        if (paramba != null) {
          break label751;
        }
        paramba = null;
        label429:
        if (paramba != null) {
          break label761;
        }
      }
      for (;;)
      {
        if (localObject2 == null) {
          break label980;
        }
        if (((i)localObject2).aiVa != h.aiUX) {
          break label974;
        }
        i = 1;
        label453:
        if (paramn != null) {
          break label1052;
        }
        localObject2 = null;
        label460:
        paramba = a(kotlin.l.b.a.b.d.a.x.krR(), (kotlin.l.b.a.b.b.a.g)localObject1, f.aiUS);
        localObject1 = a(kotlin.l.b.a.b.d.a.x.krS(), (kotlin.l.b.a.b.b.a.g)localObject1, f.aiUT);
        if ((paramba != null) && (localObject1 != null) && (!kotlin.g.b.s.p(paramba, localObject1))) {
          break label1064;
        }
        if (paramba != null) {
          break label1061;
        }
        paramba = (ba)localObject1;
        label515:
        paramba = (f)paramba;
        if ((i == 0) || (!kotlin.l.b.a.b.m.d.a.aA(paramad))) {
          break label1070;
        }
        paramBoolean1 = true;
        label536:
        if ((paramn == null) || (paramn.aiVb != true)) {
          break label1075;
        }
        paramBoolean2 = true;
        label551:
        paramad = new e((h)localObject2, paramba, paramBoolean1, paramBoolean2);
        AppMethodBeat.o(192082);
        return paramad;
        if ((paramBoolean1) && (this.aiVu != null))
        {
          localObject1 = kotlin.l.b.a.b.b.a.i.a(this.aiVu.knl(), paramad.knl());
          break;
        }
        localObject1 = paramad.knl();
        break;
        label615:
        paramn = paramn.b(this.aiVz);
        break label275;
        label627:
        break label275;
        label630:
        i = 0;
        break label308;
        label636:
        localObject3 = null;
        break label316;
        label642:
        paramn = null;
        break label338;
        label647:
        paramn = a(paramn);
        break label344;
        label655:
        localObject2 = new i(h.aiUX, paramn.aiVb);
        if (paramn.aiVa == h.aiUX) {}
        for (paramBoolean1 = true;; paramBoolean1 = false)
        {
          paramn = new kotlin.r(localObject2, Boolean.valueOf(paramBoolean1));
          break;
        }
        label705:
        localObject2 = null;
        break label404;
        label711:
        paramn = ((kotlin.l.b.a.b.d.a.n)localObject3).aiOM;
        if (paramn == null)
        {
          paramn = null;
          break label421;
        }
        paramn = new i(paramn.aiVa, paramn.aiVb);
        break label421;
        label745:
        paramn = (kotlin.l.b.a.b.d.a.n)localObject4;
        break label421;
        label751:
        paramba = a(paramba);
        break label429;
        label761:
        if ((localObject3 == null) && (paramn == null) && (paramba.aiVa == h.aiUW))
        {
          paramn = new i(h.aiUY, paramba.aiVb);
        }
        else if (paramn == null)
        {
          paramn = paramba;
        }
        else if (paramba.aiVa != h.aiUY)
        {
          if (paramn.aiVa == h.aiUY) {
            break label968;
          }
          if (paramba.aiVa != h.aiUW)
          {
            if (paramn.aiVa == h.aiUW) {
              break label968;
            }
            if ((paramba.aiVa == paramn.aiVa) && (paramba.aiVa == h.aiUX)) {}
            for (i = 1; (kotlin.ak.aiuY) && (i == 0); i = 0)
            {
              paramad = (Throwable)new AssertionError("Expected everything is NOT_NULL, but " + paramba + " and " + paramn + " are found");
              AppMethodBeat.o(192082);
              throw paramad;
            }
            paramn = new i(h.aiUX);
          }
        }
      }
      label968:
      for (paramn = paramba;; paramn = (kotlin.l.b.a.b.d.a.n)localObject2)
      {
        break;
        label974:
        i = 0;
        break label453;
        label980:
        if (!paramBoolean1)
        {
          if (localObject3 == null) {
            break label1040;
          }
          if ((((kotlin.l.b.a.b.d.a.n)localObject3).aiOM.aiVa != h.aiUX) || (!((kotlin.l.b.a.b.d.a.n)localObject3).aiOO)) {
            break label1034;
          }
          i = 1;
          label1014:
          if (i != 1) {
            break label1040;
          }
        }
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label1046;
          }
          i = 1;
          break;
          i = 0;
          break label1014;
        }
        i = 0;
        break label453;
        localObject2 = paramn.aiVa;
        break label460;
        break label515;
        paramba = null;
        break label515;
        paramBoolean1 = false;
        break label536;
        paramBoolean2 = false;
        break label551;
      }
    }
    
    private final i a(kotlin.l.b.a.b.b.a.g paramg, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(192090);
      Object localObject = (Iterable)paramg;
      paramg = l.this;
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        i locali = paramg.a((kotlin.l.b.a.b.b.a.c)((Iterator)localObject).next(), paramBoolean1, paramBoolean2);
        if (locali != null)
        {
          AppMethodBeat.o(192090);
          return locali;
        }
      }
      AppMethodBeat.o(192090);
      return null;
    }
    
    private static i a(ba paramba)
    {
      int j = 0;
      AppMethodBeat.i(192087);
      if ((paramba instanceof m))
      {
        localObject1 = ((m)paramba).klF();
        kotlin.g.b.s.s(localObject1, "upperBounds");
        localObject1 = (Iterable)localObject1;
        if (((localObject1 instanceof Collection)) && (((Collection)localObject1).isEmpty())) {
          break label99;
        }
        localObject1 = ((Iterable)localObject1).iterator();
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
        } while (af.ai((ad)((Iterator)localObject1).next()));
      }
      label99:
      for (int i = 0; i != 0; i = 1)
      {
        AppMethodBeat.o(192087);
        return null;
      }
      Object localObject1 = ((m)paramba).klF();
      kotlin.g.b.s.s(localObject1, "upperBounds");
      localObject1 = (Iterable)localObject1;
      if ((!(localObject1 instanceof Collection)) || (!((Collection)localObject1).isEmpty()))
      {
        Object localObject2 = ((Iterable)localObject1).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localObject1 = ((ad)((Iterator)localObject2).next()).kAK();
          if ((localObject1 instanceof kotlin.l.b.a.b.m.x))
          {
            localObject1 = (kotlin.l.b.a.b.m.x)localObject1;
            label187:
            if ((localObject1 == null) || (((kotlin.l.b.a.b.m.x)localObject1).ajpE.ksB() == ((kotlin.l.b.a.b.m.x)localObject1).ajpF.ksB())) {
              break label345;
            }
            i = 1;
            label210:
            if (i != 0) {
              break label348;
            }
            i = 0;
            label216:
            if (i == 0) {
              break label499;
            }
            localObject1 = ((m)paramba).klF();
            kotlin.g.b.s.s(localObject1, "upperBounds");
            localObject1 = (Iterable)localObject1;
            if (((localObject1 instanceof Collection)) && (((Collection)localObject1).isEmpty())) {
              break label360;
            }
            localObject1 = ((Iterable)localObject1).iterator();
            label266:
            if (!((Iterator)localObject1).hasNext()) {
              break label360;
            }
            localObject2 = (ad)((Iterator)localObject1).next();
            if ((!(localObject2 instanceof z)) || (af.ah(((z)localObject2).ajpJ))) {
              break label355;
            }
            i = 1;
            label310:
            if (i == 0) {
              break label358;
            }
          }
        }
      }
      label345:
      label348:
      label355:
      label358:
      label360:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label365;
        }
        paramba = new i(h.aiUX, true);
        AppMethodBeat.o(192087);
        return paramba;
        localObject1 = null;
        break label187;
        i = 0;
        break label210;
        break;
        i = 1;
        break label216;
        i = 0;
        break label310;
        break label266;
      }
      label365:
      paramba = ((m)paramba).klF();
      kotlin.g.b.s.s(paramba, "upperBounds");
      paramba = (Iterable)paramba;
      if ((paramba instanceof Collection))
      {
        i = j;
        if (((Collection)paramba).isEmpty()) {}
      }
      else
      {
        paramba = paramba.iterator();
      }
      for (;;)
      {
        i = j;
        if (paramba.hasNext())
        {
          localObject1 = (ad)paramba.next();
          if ((!(localObject1 instanceof z)) || (!af.ah(((z)localObject1).ajpJ))) {
            break label486;
          }
        }
        label486:
        for (i = 1; i != 0; i = 0)
        {
          i = 1;
          if (i == 0) {
            break label491;
          }
          paramba = new i(h.aiUW, true);
          AppMethodBeat.o(192087);
          return paramba;
        }
      }
      label491:
      AppMethodBeat.o(192087);
      return null;
      label499:
      paramba = ((m)paramba).klF();
      kotlin.g.b.s.s(paramba, "upperBounds");
      paramba = (Iterable)paramba;
      if ((!(paramba instanceof Collection)) || (!((Collection)paramba).isEmpty()))
      {
        paramba = paramba.iterator();
        if (paramba.hasNext())
        {
          localObject1 = (ad)paramba.next();
          kotlin.g.b.s.s(localObject1, "it");
          if (!af.ah((ad)localObject1))
          {
            i = 1;
            label580:
            if (i == 0) {
              break label614;
            }
            i = 1;
            label586:
            if (i == 0) {
              break label621;
            }
          }
        }
      }
      label614:
      label621:
      for (paramba = h.aiUX;; paramba = h.aiUW)
      {
        paramba = new i(paramba);
        AppMethodBeat.o(192087);
        return paramba;
        i = 0;
        break label580;
        break;
        i = 0;
        break label586;
      }
    }
    
    private static final void a(b paramb, ArrayList<n> paramArrayList, ad paramad, kotlin.l.b.a.b.d.a.c.h paramh, ba paramba)
    {
      AppMethodBeat.i(192114);
      kotlin.l.b.a.b.d.a.c.h localh = kotlin.l.b.a.b.d.a.c.a.b(paramh, paramad.knl());
      Object localObject = localh.ksj();
      if (localObject == null)
      {
        paramh = null;
        paramArrayList.add(new n(paramad, paramh, paramba, false));
        if ((paramb.aiVB) && ((paramad instanceof kotlin.l.b.a.b.m.ak))) {
          AppMethodBeat.o(192114);
        }
      }
      else
      {
        if (paramb.aiVA) {}
        for (paramh = kotlin.l.b.a.b.d.a.a.aiOd;; paramh = kotlin.l.b.a.b.d.a.a.aiOc)
        {
          paramh = ((kotlin.l.b.a.b.d.a.t)localObject).b(paramh);
          break;
        }
      }
      paramba = (Iterable)paramad.klR();
      paramad = paramad.kzm().klq();
      kotlin.g.b.s.s(paramad, "type.constructor.parameters");
      paramad = kotlin.a.p.d(paramba, (Iterable)paramad).iterator();
      while (paramad.hasNext())
      {
        paramba = (kotlin.r)paramad.next();
        localObject = (az)paramba.bsC;
        paramba = (ba)paramba.bsD;
        if (((az)localObject).kAM())
        {
          localObject = ((az)localObject).koG();
          kotlin.g.b.s.s(localObject, "arg.type");
          paramArrayList.add(new n((ad)localObject, paramh, paramba, true));
        }
        else
        {
          localObject = ((az)localObject).koG();
          kotlin.g.b.s.s(localObject, "arg.type");
          a(paramb, paramArrayList, (ad)localObject, localh, paramba);
        }
      }
      AppMethodBeat.o(192114);
    }
    
    private final kotlin.g.a.b<Integer, e> ksG()
    {
      AppMethodBeat.i(58092);
      Object localObject2 = (Iterable)this.aiVw;
      Object localObject1 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((Collection)localObject1).add(J((ad)((Iterator)localObject2).next()));
      }
      localObject2 = (List)localObject1;
      List localList = J(this.aiVv);
      Object localObject3;
      int i;
      label182:
      label188:
      label194:
      int j;
      label200:
      int k;
      if (this.aiVx)
      {
        localObject1 = (Iterable)this.aiVw;
        if ((!(localObject1 instanceof Collection)) || (!((Collection)localObject1).isEmpty()))
        {
          localObject1 = ((Iterable)localObject1).iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localObject3 = (ad)((Iterator)localObject1).next();
            if (!kotlin.l.b.a.b.m.a.e.ajqY.e((ad)localObject3, this.aiVv))
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
              localObject3 = new e[j];
              k = 0;
            }
          }
        }
      }
      for (;;)
      {
        if (k >= j) {
          break label472;
        }
        boolean bool1;
        if (k == 0)
        {
          bool1 = true;
          label220:
          if ((!bool1) && (i != 0)) {
            break label299;
          }
        }
        label270:
        label277:
        label282:
        label299:
        for (int m = 1;; m = 0)
        {
          if ((!kotlin.ak.aiuY) || (m != 0)) {
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
          bool1 = false;
          break label220;
        }
        label305:
        localObject1 = (n)localList.get(k);
        ad localad = ((n)localObject1).aiAd;
        kotlin.l.b.a.b.d.a.n localn = ((n)localObject1).aiVR;
        ba localba = ((n)localObject1).aiVS;
        boolean bool2 = ((n)localObject1).aiVT;
        localObject1 = (Iterable)localObject2;
        Collection localCollection = (Collection)new ArrayList();
        Iterator localIterator = ((Iterable)localObject1).iterator();
        label437:
        while (localIterator.hasNext())
        {
          localObject1 = (n)kotlin.a.p.ae((List)localIterator.next(), k);
          if (localObject1 == null) {}
          for (localObject1 = null;; localObject1 = ((n)localObject1).aiAd)
          {
            if (localObject1 == null) {
              break label437;
            }
            localCollection.add(localObject1);
            break;
          }
        }
        localObject3[k] = a(localad, (Collection)(List)localCollection, localn, bool1, localba, bool2);
        k += 1;
      }
      label472:
      localObject1 = (kotlin.g.a.b)new a((e[])localObject3);
      AppMethodBeat.o(58092);
      return localObject1;
    }
    
    public final l.a a(r paramr)
    {
      AppMethodBeat.i(58089);
      kotlin.g.a.b localb = ksG();
      boolean bool;
      if (paramr == null)
      {
        paramr = null;
        if (!this.aiVB) {
          break label131;
        }
        bool = bg.a(this.aiVv, (kotlin.g.a.b)b.aiVE, (kotlin.g.a.b)l.b.c.aiVF);
        label45:
        d locald = l.this.aiVs;
        ad localad = this.aiVv;
        Object localObject = paramr;
        if (paramr == null) {
          localObject = localb;
        }
        paramr = locald.a(localad, (kotlin.g.a.b)localObject, this.aiVB);
        if (paramr != null) {
          break label148;
        }
      }
      label131:
      label148:
      for (paramr = null;; paramr = new l.a(paramr, true, bool))
      {
        if (paramr != null) {
          break label162;
        }
        paramr = new l.a(this.aiVv, false, bool);
        AppMethodBeat.o(58089);
        return paramr;
        paramr = (kotlin.g.a.b)new l.b.e(paramr, localb);
        break;
        bool = bg.a(this.aiVv, (kotlin.g.a.b)d.aiVG);
        break label45;
      }
      label162:
      AppMethodBeat.o(58089);
      return paramr;
    }
    
    static final class a
      extends u
      implements kotlin.g.a.b<Integer, e>
    {
      a(e[] paramArrayOfe)
      {
        super();
      }
    }
  }
  
  static final class c
    extends u
    implements kotlin.g.a.b<kotlin.l.b.a.b.b.b, ad>
  {
    public static final c aiVJ;
    
    static
    {
      AppMethodBeat.i(58098);
      aiVJ = new c();
      AppMethodBeat.o(58098);
    }
    
    c()
    {
      super();
    }
  }
  
  static final class e
    extends u
    implements kotlin.g.a.b<kotlin.l.b.a.b.b.b, ad>
  {
    e(bd parambd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.f.l
 * JD-Core Version:    0.7.0.1
 */