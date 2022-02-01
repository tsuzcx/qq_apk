package kotlin.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.l.b.a.b.a.h;
import kotlin.l.b.a.b.b.a.a;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.ao;
import kotlin.l.b.a.b.b.ap;
import kotlin.l.b.a.b.b.aq;
import kotlin.l.b.a.b.b.ar;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.b.a;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.bd;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.n;
import kotlin.l.b.a.b.b.s;
import kotlin.l.b.a.b.b.t;
import kotlin.l.b.a.b.b.v;
import kotlin.l.b.a.b.b.x;
import kotlin.l.b.a.b.m.bc;
import kotlin.l.b.a.b.m.be;
import kotlin.l.b.a.b.m.bl;
import kotlin.l.b.a.b.m.q;

public class ab
  extends am
  implements ap
{
  private final boolean aiJU;
  private final kotlin.l.b.a.b.b.ab aiJV;
  private final b.a aiKF;
  private List<ba> aiKl;
  private as aiKo;
  private as aiKp;
  public t aiKq;
  private final boolean aiKv;
  private final boolean aiKw;
  private Collection<? extends ap> aiLG;
  private final ap aiLH;
  private final boolean aiLI;
  private final boolean aiLJ;
  private final boolean aiLK;
  public ac aiLL;
  private ar aiLM;
  private boolean aiLN;
  private v aiLO;
  private v aiLP;
  
  protected ab(l paraml, ap paramap, g paramg, kotlin.l.b.a.b.b.ab paramab, t paramt, boolean paramBoolean1, kotlin.l.b.a.b.f.f paramf, b.a parama, av paramav, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7)
  {
    super(paraml, paramg, paramf, paramBoolean1, paramav);
    AppMethodBeat.i(191875);
    this.aiLG = null;
    this.aiJV = paramab;
    this.aiKq = paramt;
    paraml = paramap;
    if (paramap == null) {
      paraml = this;
    }
    this.aiLH = paraml;
    this.aiKF = parama;
    this.aiLI = paramBoolean2;
    this.aiLJ = paramBoolean3;
    this.aiKv = paramBoolean4;
    this.aiKw = paramBoolean5;
    this.aiJU = paramBoolean6;
    this.aiLK = paramBoolean7;
    AppMethodBeat.o(191875);
  }
  
  public static ab a(l paraml, g paramg, kotlin.l.b.a.b.b.ab paramab, t paramt, kotlin.l.b.a.b.f.f paramf, b.a parama, av paramav)
  {
    AppMethodBeat.i(191879);
    if (paraml == null) {
      aKu(7);
    }
    if (paramg == null) {
      aKu(8);
    }
    if (paramab == null) {
      aKu(9);
    }
    if (paramt == null) {
      aKu(10);
    }
    if (paramf == null) {
      aKu(11);
    }
    if (parama == null) {
      aKu(12);
    }
    if (paramav == null) {
      aKu(13);
    }
    paraml = new ab(paraml, null, paramg, paramab, paramt, true, paramf, parama, paramav, false, false, false, false, false, false);
    AppMethodBeat.o(191879);
    return paraml;
  }
  
  private static t a(t paramt, b.a parama)
  {
    AppMethodBeat.i(191885);
    if ((parama == b.a.aiGm) && (s.a(paramt.koD())))
    {
      paramt = s.aiGJ;
      AppMethodBeat.o(191885);
      return paramt;
    }
    AppMethodBeat.o(191885);
    return paramt;
  }
  
  private static x a(be parambe, ao paramao)
  {
    AppMethodBeat.i(57229);
    if (parambe == null) {
      aKu(25);
    }
    if (paramao == null) {
      aKu(26);
    }
    if (paramao.koI() != null)
    {
      parambe = paramao.koI().c(parambe);
      AppMethodBeat.o(57229);
      return parambe;
    }
    AppMethodBeat.o(57229);
    return null;
  }
  
  private a kqd()
  {
    AppMethodBeat.i(57226);
    a locala = new a();
    AppMethodBeat.o(57226);
    return locala;
  }
  
  public final void M(Collection<? extends kotlin.l.b.a.b.b.b> paramCollection)
  {
    AppMethodBeat.i(57234);
    if (paramCollection == null) {
      aKu(35);
    }
    this.aiLG = paramCollection;
    AppMethodBeat.o(57234);
  }
  
  public final void Po(boolean paramBoolean)
  {
    this.aiLN = paramBoolean;
  }
  
  public <V> V a(a.a<V> parama)
  {
    return null;
  }
  
  public final <R, D> R a(n<R, D> paramn, D paramD)
  {
    AppMethodBeat.i(57231);
    paramn = paramn.a(this, paramD);
    AppMethodBeat.o(57231);
    return paramn;
  }
  
  protected final ap a(a parama)
  {
    AppMethodBeat.i(57227);
    Object localObject2 = parama.aiLQ;
    Object localObject3 = parama.aiJV;
    Object localObject4 = parama.aiKq;
    Object localObject5 = parama.aiLH;
    Object localObject6 = parama.aiKF;
    Object localObject7 = parama.aiJy;
    boolean bool1 = parama.aiKU;
    Object localObject1 = parama.aiLH;
    if (bool1) {
      if (localObject1 != null)
      {
        localObject1 = ((ap)localObject1).knm();
        label70:
        if (localObject1 == null) {
          aKu(23);
        }
        localObject5 = a((l)localObject2, (kotlin.l.b.a.b.b.ab)localObject3, (t)localObject4, (ap)localObject5, (b.a)localObject6, (kotlin.l.b.a.b.f.f)localObject7, (av)localObject1);
        if (parama.aiKW != null) {
          break label187;
        }
      }
    }
    label187:
    for (localObject1 = koa();; localObject1 = parama.aiKW)
    {
      localObject3 = new ArrayList(((List)localObject1).size());
      localObject6 = q.a((List)localObject1, parama.aiKL, (l)localObject5, (List)localObject3);
      localObject4 = ((be)localObject6).c(parama.aiLR, bl.ajqO);
      if (localObject4 != null) {
        break label196;
      }
      AppMethodBeat.o(57227);
      return null;
      localObject1 = kpf();
      break;
      localObject1 = av.aiHu;
      break label70;
    }
    label196:
    localObject1 = parama.aiKp;
    if (localObject1 != null)
    {
      localObject2 = ((as)localObject1).e((be)localObject6);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        AppMethodBeat.o(57227);
        return null;
      }
    }
    else
    {
      localObject1 = null;
    }
    if (this.aiKo != null)
    {
      localObject2 = ((be)localObject6).c(this.aiKo.koG(), bl.ajqN);
      if (localObject2 == null)
      {
        AppMethodBeat.o(57227);
        return null;
      }
      localObject2 = new ae((l)localObject5, new kotlin.l.b.a.b.j.g.a.b((kotlin.l.b.a.b.b.a)localObject5, (kotlin.l.b.a.b.m.ad)localObject2, this.aiKo.kpi()), this.aiKo.knl());
      ((ab)localObject5).a((kotlin.l.b.a.b.m.ad)localObject4, (List)localObject3, (as)localObject1, (as)localObject2);
      if (this.aiLL != null) {
        break label516;
      }
      localObject1 = null;
      if (localObject1 != null)
      {
        localObject2 = this.aiLL.kob();
        ((aa)localObject1).aiKG = a((be)localObject6, this.aiLL);
        if (localObject2 == null) {
          break label633;
        }
      }
    }
    label516:
    label633:
    for (localObject2 = ((be)localObject6).c((kotlin.l.b.a.b.m.ad)localObject2, bl.ajqO);; localObject2 = null)
    {
      ((ac)localObject1).C((kotlin.l.b.a.b.m.ad)localObject2);
      if (this.aiLM != null) {
        break label639;
      }
      localObject2 = null;
      if (localObject2 == null) {
        break label796;
      }
      localObject4 = p.a((x)localObject2, this.aiLM.kod(), (be)localObject6, false, false, null);
      localObject3 = localObject4;
      if (localObject4 == null)
      {
        ((ab)localObject5).aiLN = true;
        localObject3 = Collections.singletonList(ad.a((ar)localObject2, kotlin.l.b.a.b.j.d.a.G(parama.aiLQ).kmN(), ((bd)this.aiLM.kod().get(0)).knl()));
      }
      if (((List)localObject3).size() == 1) {
        break label766;
      }
      parama = new IllegalStateException();
      AppMethodBeat.o(57227);
      throw parama;
      localObject2 = null;
      break;
      localObject2 = this.aiLL.knl();
      localObject3 = parama.aiJV;
      localObject4 = a(this.aiLL.knc(), parama.aiKF);
      bool1 = this.aiLL.oBZ;
      bool2 = this.aiLL.aiJU;
      bool3 = this.aiLL.aiKt;
      localObject7 = parama.aiKF;
      if (parama.aiLH == null) {}
      for (localObject1 = null;; localObject1 = parama.aiLH.kpc())
      {
        localObject1 = new ac((ap)localObject5, (g)localObject2, (kotlin.l.b.a.b.b.ab)localObject3, (t)localObject4, bool1, bool2, bool3, (b.a)localObject7, (aq)localObject1, av.aiHu);
        break;
      }
    }
    label639:
    localObject3 = this.aiLM.knl();
    localObject4 = parama.aiJV;
    localObject7 = a(this.aiLM.knc(), parama.aiKF);
    bool1 = this.aiLM.kpa();
    boolean bool2 = this.aiLM.knk();
    boolean bool3 = this.aiLM.kng();
    b.a locala = parama.aiKF;
    if (parama.aiLH == null) {}
    for (localObject2 = null;; localObject2 = parama.aiLH.kpd())
    {
      localObject2 = new ad((ap)localObject5, (g)localObject3, (kotlin.l.b.a.b.b.ab)localObject4, (t)localObject7, bool1, bool2, bool3, locala, (ar)localObject2, av.aiHu);
      break;
    }
    label766:
    ((aa)localObject2).aiKG = a((be)localObject6, this.aiLM);
    ((ad)localObject2).a((bd)((List)localObject3).get(0));
    label796:
    if (this.aiLO == null)
    {
      localObject3 = null;
      if (this.aiLP != null) {
        break label911;
      }
    }
    label911:
    for (localObject4 = null;; localObject4 = new o(this.aiLP.knl(), (ap)localObject5))
    {
      ((ab)localObject5).a((ac)localObject1, (ar)localObject2, (v)localObject3, (v)localObject4);
      if (!parama.aiKS) {
        break label940;
      }
      parama = kotlin.l.b.a.b.o.f.kBe();
      localObject1 = kof().iterator();
      while (((Iterator)localObject1).hasNext()) {
        parama.add(((ap)((Iterator)localObject1).next()).d((be)localObject6));
      }
      localObject3 = new o(this.aiLO.knl(), (ap)localObject5);
      break;
    }
    ((ab)localObject5).M(parama);
    label940:
    if ((kpw()) && (this.aiMp != null)) {
      ((ab)localObject5).a(this.aiMp);
    }
    AppMethodBeat.o(57227);
    return localObject5;
  }
  
  protected ab a(l paraml, kotlin.l.b.a.b.b.ab paramab, t paramt, ap paramap, b.a parama, kotlin.l.b.a.b.f.f paramf, av paramav)
  {
    AppMethodBeat.i(191922);
    if (paraml == null) {
      aKu(27);
    }
    if (paramab == null) {
      aKu(28);
    }
    if (paramt == null) {
      aKu(29);
    }
    if (parama == null) {
      aKu(30);
    }
    if (paramf == null) {
      aKu(31);
    }
    if (paramav == null) {
      aKu(32);
    }
    paraml = new ab(paraml, paramap, knl(), paramab, paramt, kpu(), paramf, parama, paramav, this.aiLI, kpw(), this.aiKv, this.aiKw, knk(), this.aiLK);
    AppMethodBeat.o(191922);
    return paraml;
  }
  
  public final void a(ac paramac, ar paramar)
  {
    AppMethodBeat.i(57219);
    a(paramac, paramar, null, null);
    AppMethodBeat.o(57219);
  }
  
  public final void a(ac paramac, ar paramar, v paramv1, v paramv2)
  {
    this.aiLL = paramac;
    this.aiLM = paramar;
    this.aiLO = paramv1;
    this.aiLP = paramv2;
  }
  
  public final void a(kotlin.l.b.a.b.m.ad paramad, List<? extends ba> paramList, as paramas1, as paramas2)
  {
    AppMethodBeat.i(57218);
    if (paramad == null) {
      aKu(14);
    }
    if (paramList == null) {
      aKu(15);
    }
    F(paramad);
    this.aiKl = new ArrayList(paramList);
    this.aiKo = paramas2;
    this.aiKp = paramas1;
    AppMethodBeat.o(57218);
  }
  
  public final ap d(be parambe)
  {
    AppMethodBeat.i(57225);
    if (parambe == null) {
      aKu(22);
    }
    if (parambe.aiKL.isEmpty())
    {
      AppMethodBeat.o(57225);
      return this;
    }
    a locala = kqd();
    parambe = parambe.kAR();
    if (parambe == null) {
      a.aKu(15);
    }
    locala.aiKL = parambe;
    if (locala == null) {
      a.aKu(16);
    }
    parambe = locala.g(kpf()).kqf();
    AppMethodBeat.o(57225);
    return parambe;
  }
  
  public final as knY()
  {
    return this.aiKo;
  }
  
  public final as knZ()
  {
    return this.aiKp;
  }
  
  public final kotlin.l.b.a.b.b.ab knb()
  {
    AppMethodBeat.i(57222);
    kotlin.l.b.a.b.b.ab localab = this.aiJV;
    if (localab == null) {
      aKu(19);
    }
    AppMethodBeat.o(57222);
    return localab;
  }
  
  public final t knc()
  {
    AppMethodBeat.i(191910);
    t localt = this.aiKq;
    if (localt == null) {
      aKu(20);
    }
    AppMethodBeat.o(191910);
    return localt;
  }
  
  public final boolean kni()
  {
    return this.aiKv;
  }
  
  public final boolean knj()
  {
    return this.aiKw;
  }
  
  public boolean knk()
  {
    return this.aiJU;
  }
  
  public final List<ba> koa()
  {
    AppMethodBeat.i(57220);
    Object localObject = this.aiKl;
    if (localObject == null)
    {
      localObject = new IllegalStateException("typeParameters == null for " + toString());
      AppMethodBeat.o(57220);
      throw ((Throwable)localObject);
    }
    if (localObject == null) {
      aKu(17);
    }
    AppMethodBeat.o(57220);
    return localObject;
  }
  
  public final kotlin.l.b.a.b.m.ad kob()
  {
    AppMethodBeat.i(57221);
    kotlin.l.b.a.b.m.ad localad = koG();
    if (localad == null) {
      aKu(18);
    }
    AppMethodBeat.o(57221);
    return localad;
  }
  
  public final Collection<? extends ap> kof()
  {
    AppMethodBeat.i(57235);
    if (this.aiLG != null) {}
    for (Object localObject = this.aiLG;; localObject = Collections.emptyList())
    {
      if (localObject == null) {
        aKu(36);
      }
      AppMethodBeat.o(57235);
      return localObject;
    }
  }
  
  public final b.a koh()
  {
    AppMethodBeat.i(57233);
    b.a locala = this.aiKF;
    if (locala == null) {
      aKu(34);
    }
    AppMethodBeat.o(57233);
    return locala;
  }
  
  public final ar kpd()
  {
    return this.aiLM;
  }
  
  public final List<ao> kpe()
  {
    AppMethodBeat.i(57224);
    ArrayList localArrayList = new ArrayList(2);
    if (this.aiLL != null) {
      localArrayList.add(this.aiLL);
    }
    if (this.aiLM != null) {
      localArrayList.add(this.aiLM);
    }
    AppMethodBeat.o(57224);
    return localArrayList;
  }
  
  public final ap kpf()
  {
    AppMethodBeat.i(57232);
    if (this.aiLH == this) {}
    for (Object localObject = this;; localObject = this.aiLH.kpf())
    {
      if (localObject == null) {
        aKu(33);
      }
      AppMethodBeat.o(57232);
      return localObject;
    }
  }
  
  public final v kpg()
  {
    return this.aiLO;
  }
  
  public final v kph()
  {
    return this.aiLP;
  }
  
  public boolean kpw()
  {
    return this.aiLJ;
  }
  
  public final boolean kpx()
  {
    return this.aiLI;
  }
  
  public final boolean kpy()
  {
    return this.aiLK;
  }
  
  public final boolean kqc()
  {
    return this.aiLN;
  }
  
  public final class a
  {
    kotlin.l.b.a.b.b.ab aiJV;
    kotlin.l.b.a.b.f.f aiJy;
    b.a aiKF;
    bc aiKL;
    boolean aiKS;
    boolean aiKU;
    List<ba> aiKW;
    as aiKp;
    t aiKq;
    ap aiLH;
    l aiLQ;
    kotlin.l.b.a.b.m.ad aiLR;
    
    public a()
    {
      AppMethodBeat.i(57212);
      this.aiLQ = ab.this.knp();
      this.aiJV = ab.this.knb();
      this.aiKq = ab.this.knc();
      this.aiLH = null;
      this.aiKU = false;
      this.aiKF = ab.this.koh();
      this.aiKL = bc.ajqx;
      this.aiKS = true;
      this.aiKp = ab.a(ab.this);
      this.aiKW = null;
      this.aiJy = ab.this.kok();
      this.aiLR = ab.this.koG();
      AppMethodBeat.o(57212);
    }
    
    public final a g(kotlin.l.b.a.b.b.b paramb)
    {
      AppMethodBeat.i(57213);
      this.aiLH = ((ap)paramb);
      if (this == null) {
        aKu(2);
      }
      AppMethodBeat.o(57213);
      return this;
    }
    
    public final ap kqf()
    {
      AppMethodBeat.i(57214);
      ap localap = ab.this.a(this);
      AppMethodBeat.o(57214);
      return localap;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.c.ab
 * JD-Core Version:    0.7.0.1
 */