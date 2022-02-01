package kotlin.l.b.a.b.d.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.a.ah;
import kotlin.a.ar;
import kotlin.a.p;
import kotlin.ak;
import kotlin.l.b.a.b.b.a.g.a;
import kotlin.l.b.a.b.b.ab.a;
import kotlin.l.b.a.b.b.ag.b;
import kotlin.l.b.a.b.b.at;
import kotlin.l.b.a.b.b.at.a;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.bi;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.t;
import kotlin.l.b.a.b.d.a.f.l.a;
import kotlin.l.b.a.b.d.a.f.l.b;
import kotlin.l.b.a.b.d.a.o;
import kotlin.l.b.a.b.f.i;
import kotlin.l.b.a.b.k.a.q;
import kotlin.l.b.a.b.l.m;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.al;
import kotlin.l.b.a.b.m.ax;
import kotlin.l.b.a.b.m.bb;
import kotlin.l.b.a.b.m.be;
import kotlin.l.b.a.b.m.bl;

public final class f
  extends kotlin.l.b.a.b.b.c.g
  implements kotlin.l.b.a.b.d.a.b.c
{
  public static final f.a aiSQ;
  private static final Set<String> aiTb;
  private final kotlin.l.b.a.b.b.a.g aiHM;
  private final boolean aiHg;
  private final kotlin.l.b.a.b.b.ab aiJV;
  private final kotlin.l.b.a.b.b.f aiJW;
  public final kotlin.l.b.a.b.d.a.e.g aiSA;
  final kotlin.l.b.a.b.d.a.c.h aiSR;
  private final e aiSS;
  public final kotlin.j aiST;
  private final bi aiSU;
  final b aiSV;
  private final g aiSW;
  private final at<g> aiSX;
  private final kotlin.l.b.a.b.j.g.f aiSY;
  private final k aiSZ;
  public final kotlin.l.b.a.b.d.a.c.h aiSh;
  private final kotlin.l.b.a.b.l.h<List<ba>> aiTa;
  
  static
  {
    AppMethodBeat.i(57824);
    aiSQ = new f.a((byte)0);
    aiTb = ar.setOf(new String[] { "equals", "hashCode", "getClass", "wait", "notify", "notifyAll", "toString" });
    AppMethodBeat.o(57824);
  }
  
  public f(kotlin.l.b.a.b.d.a.c.h paramh, kotlin.l.b.a.b.b.l paraml, kotlin.l.b.a.b.d.a.e.g paramg, e parame)
  {
    super(paramh.aiSp.aiBu, paraml, paramg.kok(), (av)paramh.aiSp.aiRS.a((kotlin.l.b.a.b.d.a.e.l)paramg));
    AppMethodBeat.i(57823);
    this.aiSR = paramh;
    this.aiSA = paramg;
    this.aiSS = parame;
    this.aiSh = kotlin.l.b.a.b.d.a.c.a.a(this.aiSR, (kotlin.l.b.a.b.b.g)this, (kotlin.l.b.a.b.d.a.e.y)this.aiSA, 4);
    this.aiSh.aiSp.aiRP.b(this.aiSA);
    if (this.aiSA.kqF() == null) {}
    for (int i = 1; (ak.aiuY) && (i == 0); i = 0)
    {
      paramh = (Throwable)new AssertionError(kotlin.g.b.s.X("Creating LazyJavaClassDescriptor for light class ", this.aiSA));
      AppMethodBeat.o(57823);
      throw paramh;
    }
    this.aiST = kotlin.k.cm((kotlin.g.a.a)new d(this));
    if (this.aiSA.kqH())
    {
      paramh = kotlin.l.b.a.b.b.f.aiGx;
      this.aiJW = paramh;
      if ((!this.aiSA.kqH()) && (!this.aiSA.kqI())) {
        break label540;
      }
      paramh = kotlin.l.b.a.b.b.ab.aiGY;
      this.aiJV = paramh;
      this.aiSU = this.aiSA.kqO();
      if ((this.aiSA.kqQ() == null) || (this.aiSA.jNm())) {
        break label621;
      }
      bool1 = true;
      label292:
      this.aiHg = bool1;
      this.aiSV = new b();
      paramh = this.aiSh;
      paraml = (e)this;
      paramg = this.aiSA;
      if (this.aiSS == null) {
        break label627;
      }
    }
    label540:
    label583:
    label615:
    label621:
    label627:
    for (boolean bool1 = bool3;; bool1 = false)
    {
      this.aiSW = new g(paramh, paraml, paramg, bool1);
      paramh = at.aiHn;
      this.aiSX = at.a.a((e)this, this.aiSh.aiSp.aiBu, this.aiSh.aiSp.aiSb.kAT(), (kotlin.g.a.b)new e(this));
      this.aiSY = new kotlin.l.b.a.b.j.g.f((kotlin.l.b.a.b.j.g.h)this.aiSW);
      this.aiSZ = new k(this.aiSh, this.aiSA, this);
      this.aiHM = kotlin.l.b.a.b.d.a.c.f.a(this.aiSh, (kotlin.l.b.a.b.d.a.e.d)this.aiSA);
      this.aiTa = this.aiSh.aiSp.aiBu.cq((kotlin.g.a.a)new c(this));
      AppMethodBeat.o(57823);
      return;
      if (this.aiSA.kqG())
      {
        paramh = kotlin.l.b.a.b.b.f.aiGu;
        break;
      }
      if (this.aiSA.kqI())
      {
        paramh = kotlin.l.b.a.b.b.f.aiGv;
        break;
      }
      paramh = kotlin.l.b.a.b.b.f.aiGt;
      break;
      paramh = kotlin.l.b.a.b.b.ab.aiGX;
      if ((this.aiSA.kqK()) || (this.aiSA.kqM()) || (this.aiSA.kqG()))
      {
        bool1 = true;
        if (this.aiSA.kqN()) {
          break label615;
        }
      }
      for (boolean bool2 = true;; bool2 = false)
      {
        paramh = ab.a.bY(bool1, bool2);
        break;
        bool1 = false;
        break label583;
      }
      bool1 = false;
      break label292;
    }
  }
  
  public final boolean isValue()
  {
    return false;
  }
  
  public final ax kmZ()
  {
    return (ax)this.aiSV;
  }
  
  public final kotlin.l.b.a.b.b.f kna()
  {
    return this.aiJW;
  }
  
  public final kotlin.l.b.a.b.b.ab knb()
  {
    return this.aiJV;
  }
  
  public final t knc()
  {
    AppMethodBeat.i(192163);
    if ((kotlin.g.b.s.p(this.aiSU, kotlin.l.b.a.b.b.s.aiGC)) && (this.aiSA.kqQ() == null))
    {
      localt = o.aiOQ;
      kotlin.g.b.s.s(localt, "{\n            JavaDescri…KAGE_VISIBILITY\n        }");
      AppMethodBeat.o(192163);
      return localt;
    }
    t localt = kotlin.l.b.a.b.d.a.ae.a(this.aiSU);
    AppMethodBeat.o(192163);
    return localt;
  }
  
  public final boolean knd()
  {
    return false;
  }
  
  public final boolean kne()
  {
    return this.aiHg;
  }
  
  public final boolean knf()
  {
    return false;
  }
  
  public final boolean kng()
  {
    return false;
  }
  
  public final boolean knh()
  {
    return false;
  }
  
  public final boolean kni()
  {
    return false;
  }
  
  public final boolean knj()
  {
    return false;
  }
  
  public final kotlin.l.b.a.b.b.a.g knl()
  {
    return this.aiHM;
  }
  
  public final kotlin.l.b.a.b.b.y<al> knn()
  {
    return null;
  }
  
  public final List<ba> kno()
  {
    AppMethodBeat.i(57821);
    List localList = (List)this.aiTa.invoke();
    AppMethodBeat.o(57821);
    return localList;
  }
  
  public final kotlin.l.b.a.b.j.g.h knq()
  {
    return (kotlin.l.b.a.b.j.g.h)this.aiSZ;
  }
  
  public final e knr()
  {
    return null;
  }
  
  public final kotlin.l.b.a.b.b.d kns()
  {
    return null;
  }
  
  public final Collection<e> knt()
  {
    AppMethodBeat.i(192182);
    if (this.aiJV == kotlin.l.b.a.b.b.ab.aiGZ)
    {
      kotlin.l.b.a.b.d.a.c.b.a locala = kotlin.l.b.a.b.d.a.c.b.d.a(kotlin.l.b.a.b.d.a.a.k.aiRp, false, null, 3);
      localObject = (Iterable)this.aiSA.kqL();
      Collection localCollection = (Collection)new ArrayList();
      Iterator localIterator = ((Iterable)localObject).iterator();
      label133:
      while (localIterator.hasNext())
      {
        localObject = (kotlin.l.b.a.b.d.a.e.j)localIterator.next();
        localObject = this.aiSh.aiSt.a((kotlin.l.b.a.b.d.a.e.w)localObject, locala).kzm().knA();
        if ((localObject instanceof e)) {}
        for (localObject = (e)localObject;; localObject = null)
        {
          if (localObject == null) {
            break label133;
          }
          localCollection.add(localObject);
          break;
        }
      }
      localObject = (Collection)localCollection;
      AppMethodBeat.o(192182);
      return localObject;
    }
    Object localObject = (Collection)kotlin.a.ab.aivy;
    AppMethodBeat.o(192182);
    return localObject;
  }
  
  public final kotlin.l.b.a.b.j.g.h kou()
  {
    return (kotlin.l.b.a.b.j.g.h)this.aiSY;
  }
  
  public final g ksp()
  {
    AppMethodBeat.i(57817);
    g localg = (g)super.kot();
    AppMethodBeat.o(57817);
    return localg;
  }
  
  public final List<kotlin.l.b.a.b.b.d> ksq()
  {
    AppMethodBeat.i(57819);
    List localList = (List)this.aiSW.aiTg.invoke();
    AppMethodBeat.o(57819);
    return localList;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(57822);
    String str = kotlin.g.b.s.X("Lazy Java class ", kotlin.l.b.a.b.j.d.a.q((kotlin.l.b.a.b.b.l)this));
    AppMethodBeat.o(57822);
    return str;
  }
  
  final class b
    extends kotlin.l.b.a.b.m.b
  {
    private final kotlin.l.b.a.b.l.h<List<ba>> aiTc;
    
    public b()
    {
      super();
      AppMethodBeat.i(57812);
      this.aiTc = f.a(this.aiTd).aiSp.aiBu.cq((kotlin.g.a.a)new a(this.aiTd));
      AppMethodBeat.o(57812);
    }
    
    private final ad ksr()
    {
      int j = 0;
      AppMethodBeat.i(57809);
      Object localObject1 = this.aiTd.knl();
      Object localObject2 = kotlin.l.b.a.b.d.a.w.aiPH;
      kotlin.g.b.s.s(localObject2, "PURELY_IMPLEMENTS_ANNOTATION");
      localObject1 = ((kotlin.l.b.a.b.b.a.g)localObject1).h((kotlin.l.b.a.b.f.c)localObject2);
      if (localObject1 == null)
      {
        localObject1 = null;
        if (localObject1 == null) {
          break label342;
        }
        i = j;
        if (!((kotlin.l.b.a.b.f.c)localObject1).ajex.ajeC.isEmpty())
        {
          i = j;
          if (((kotlin.l.b.a.b.f.c)localObject1).r(kotlin.l.b.a.b.a.k.aiCq)) {
            i = 1;
          }
        }
        if (i == 0) {
          break label342;
        }
      }
      for (;;)
      {
        if (localObject1 != null) {
          break label386;
        }
        localObject2 = kotlin.l.b.a.b.d.a.k.aiOH;
        localObject2 = kotlin.l.b.a.b.d.a.k.n(kotlin.l.b.a.b.j.d.a.o((kotlin.l.b.a.b.b.l)this.aiTd));
        if (localObject2 != null) {
          break label348;
        }
        AppMethodBeat.o(57809);
        return null;
        localObject1 = p.j((Iterable)((kotlin.l.b.a.b.b.a.c)localObject1).kpA().values());
        if ((localObject1 instanceof kotlin.l.b.a.b.j.b.u))
        {
          localObject1 = (kotlin.l.b.a.b.j.b.u)localObject1;
          label159:
          if (localObject1 != null) {
            break label184;
          }
        }
        label184:
        for (localObject2 = null;; localObject2 = (String)((kotlin.l.b.a.b.j.b.u)localObject1).getValue())
        {
          if (localObject2 != null) {
            break label197;
          }
          localObject1 = null;
          break;
          localObject1 = null;
          break label159;
        }
        label197:
        if (localObject2 != null)
        {
          localObject1 = i.ajeO;
          i = 0;
          char c;
          do
          {
            for (;;)
            {
              if (i >= ((String)localObject2).length()) {
                break label315;
              }
              c = ((String)localObject2).charAt(i);
              i += 1;
              switch (kotlin.l.b.a.b.f.e.a.$EnumSwitchMapping$0[localObject1.ordinal()])
              {
              default: 
                break;
              case 1: 
              case 2: 
                if (!Character.isJavaIdentifierPart(c)) {
                  break label303;
                }
                localObject1 = i.ajeP;
                break;
              case 3: 
                if (c != '.') {
                  break label296;
                }
                localObject1 = i.ajeQ;
              }
            }
          } while (Character.isJavaIdentifierPart(c));
        }
        label296:
        label303:
        for (i = 0;; i = 1)
        {
          if (i != 0) {
            break label328;
          }
          localObject1 = null;
          break;
          label315:
          if (localObject1 == i.ajeQ) {
            break label303;
          }
        }
        label328:
        localObject1 = new kotlin.l.b.a.b.f.c((String)localObject2);
        break;
        label342:
        localObject1 = null;
      }
      for (;;)
      {
        label348:
        localObject2 = kotlin.l.b.a.b.j.d.a.b(f.a(this.aiTd).aiSp.aiEx, (kotlin.l.b.a.b.f.c)localObject2, (kotlin.l.b.a.b.c.a.b)kotlin.l.b.a.b.c.a.d.aiNN);
        if (localObject2 != null) {
          break;
        }
        AppMethodBeat.o(57809);
        return null;
        label386:
        localObject2 = localObject1;
      }
      int i = ((e)localObject2).kmZ().klq().size();
      Object localObject3 = ((ax)this.aiTd.aiSV).klq();
      kotlin.g.b.s.s(localObject3, "getTypeConstructor().parameters");
      j = ((List)localObject3).size();
      Object localObject4;
      if (j == i)
      {
        localObject3 = (Iterable)localObject3;
        localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject3, 10));
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (ba)((Iterator)localObject3).next();
          ((Collection)localObject1).add(new bb(bl.ajqM, (ad)((ba)localObject4).koj()));
        }
      }
      for (localObject1 = (List)localObject1;; localObject1 = (List)localObject3)
      {
        localObject3 = kotlin.l.b.a.b.b.a.g.aiIh;
        localObject1 = (ad)kotlin.l.b.a.b.m.ae.a(g.a.kpB(), (e)localObject2, (List)localObject1);
        AppMethodBeat.o(57809);
        return localObject1;
        if ((j != 1) || (i <= 1) || (localObject1 != null)) {
          break;
        }
        localObject1 = new bb(bl.ajqM, (ad)((ba)p.oO((List)localObject3)).koj());
        localObject4 = (Iterable)new kotlin.k.g(1, i);
        localObject3 = (Collection)new ArrayList(p.a((Iterable)localObject4, 10));
        localObject4 = ((Iterable)localObject4).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          ((ah)localObject4).Zo();
          ((Collection)localObject3).add(localObject1);
        }
      }
      AppMethodBeat.o(57809);
      return null;
    }
    
    public final List<ba> klq()
    {
      AppMethodBeat.i(57807);
      List localList = (List)this.aiTc.invoke();
      AppMethodBeat.o(57807);
      return localList;
    }
    
    public final Collection<ad> knw()
    {
      AppMethodBeat.i(57808);
      Object localObject1 = this.aiTd.aiSA.kpG();
      ArrayList localArrayList = new ArrayList(((Collection)localObject1).size());
      Object localObject2 = new ArrayList(0);
      Object localObject3 = ksr();
      Object localObject4 = ((Collection)localObject1).iterator();
      label256:
      while (((Iterator)localObject4).hasNext())
      {
        localObject1 = (kotlin.l.b.a.b.d.a.e.j)((Iterator)localObject4).next();
        ad localad = f.a(this.aiTd).aiSt.a((kotlin.l.b.a.b.d.a.e.w)localObject1, kotlin.l.b.a.b.d.a.c.b.d.a(kotlin.l.b.a.b.d.a.a.k.aiRo, false, null, 3));
        Object localObject5 = f.a(this.aiTd).aiSp.aiRY;
        kotlin.l.b.a.b.d.a.c.h localh = f.a(this.aiTd);
        kotlin.g.b.s.u(localad, "type");
        kotlin.g.b.s.u(localh, "context");
        localad = l.b.a(new l.b((kotlin.l.b.a.b.d.a.f.l)localObject5, null, localad, (Collection)kotlin.a.ab.aivy, false, localh, kotlin.l.b.a.b.d.a.a.aiOc, false, true, 64)).aiAd;
        if ((localad.kzm().knA() instanceof ag.b)) {
          ((ArrayList)localObject2).add(localObject1);
        }
        localObject5 = localad.kzm();
        if (localObject3 == null) {}
        for (localObject1 = null;; localObject1 = ((ad)localObject3).kzm())
        {
          if ((kotlin.g.b.s.p(localObject5, localObject1)) || (kotlin.l.b.a.b.a.h.s(localad))) {
            break label256;
          }
          localArrayList.add(localad);
          break;
        }
      }
      localObject4 = (Collection)localArrayList;
      localObject1 = f.b(this.aiTd);
      if (localObject1 == null)
      {
        localObject1 = null;
        kotlin.l.b.a.b.o.a.c((Collection)localObject4, localObject1);
        kotlin.l.b.a.b.o.a.c((Collection)localArrayList, localObject3);
        if (((Collection)localObject2).isEmpty()) {
          break label442;
        }
        i = 1;
      }
      for (;;)
      {
        label308:
        if (i != 0)
        {
          localObject1 = f.a(this.aiTd).aiSp.aiRO;
          localObject3 = (e)this.aiTd;
          localObject4 = (Iterable)localObject2;
          localObject2 = (Collection)new ArrayList(p.a((Iterable)localObject4, 10));
          localObject4 = ((Iterable)localObject4).iterator();
          for (;;)
          {
            if (((Iterator)localObject4).hasNext())
            {
              ((Collection)localObject2).add(((kotlin.l.b.a.b.d.a.e.j)((Iterator)localObject4).next()).kqW());
              continue;
              localObject1 = kotlin.l.b.a.b.a.b.j.a((e)localObject1, (e)this.aiTd).kAO().c((ad)((e)localObject1).koj(), bl.ajqM);
              break;
              label442:
              i = 0;
              break label308;
            }
          }
          ((q)localObject1).a((e)localObject3, (List)localObject2);
        }
      }
      if (!((Collection)localArrayList).isEmpty()) {}
      for (int i = 1; i != 0; i = 0)
      {
        localObject1 = (Collection)p.p((Iterable)localArrayList);
        AppMethodBeat.o(57808);
        return localObject1;
      }
      localObject1 = (Collection)p.listOf(f.a(this.aiTd).aiSp.aiEx.koV().kmO());
      AppMethodBeat.o(57808);
      return localObject1;
    }
    
    public final boolean knx()
    {
      return true;
    }
    
    public final kotlin.l.b.a.b.b.ay kny()
    {
      AppMethodBeat.i(57810);
      kotlin.l.b.a.b.b.ay localay = f.a(this.aiTd).aiSp.aiJR;
      AppMethodBeat.o(57810);
      return localay;
    }
    
    public final e knz()
    {
      return (e)this.aiTd;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(57811);
      String str = this.aiTd.kok().PF();
      kotlin.g.b.s.s(str, "name.asString()");
      AppMethodBeat.o(57811);
      return str;
    }
    
    static final class a
      extends kotlin.g.b.u
      implements kotlin.g.a.a<List<? extends ba>>
    {
      a(f paramf)
      {
        super();
      }
    }
  }
  
  static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.a<List<? extends ba>>
  {
    c(f paramf)
    {
      super();
    }
  }
  
  static final class d
    extends kotlin.g.b.u
    implements kotlin.g.a.a<List<? extends kotlin.l.b.a.b.d.a.e.a>>
  {
    d(f paramf)
    {
      super();
    }
  }
  
  static final class e
    extends kotlin.g.b.u
    implements kotlin.g.a.b<kotlin.l.b.a.b.m.a.g, g>
  {
    e(f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.c.a.f
 * JD-Core Version:    0.7.0.1
 */