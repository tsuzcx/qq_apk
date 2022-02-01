package d.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.b.a.a;
import d.l.b.a.b.b.ag;
import d.l.b.a.b.b.ah;
import d.l.b.a.b.b.ai;
import d.l.b.a.b.b.aj;
import d.l.b.a.b.b.ak;
import d.l.b.a.b.b.an;
import d.l.b.a.b.b.as;
import d.l.b.a.b.b.av;
import d.l.b.a.b.b.az;
import d.l.b.a.b.b.b.a;
import d.l.b.a.b.b.l;
import d.l.b.a.b.b.n;
import d.l.b.a.b.b.r;
import d.l.b.a.b.b.t;
import d.l.b.a.b.b.w;
import d.l.b.a.b.f.f;
import d.l.b.a.b.m.ay;
import d.l.b.a.b.m.bh;
import d.l.b.a.b.o.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class aa
  extends al
  implements ah
{
  private List<as> LdP;
  private final boolean LgF;
  private final w LgG;
  private ak LgZ;
  protected ak Lha;
  public d.l.b.a.b.b.ba Lhb;
  protected final boolean Lhg;
  private final boolean Lhh;
  private final b.a Lhq;
  private Collection<? extends ah> Lik;
  private final ah Lil;
  protected final boolean Lim;
  private final boolean Lin;
  protected final boolean Lio;
  public ab Lip;
  protected aj Liq;
  protected boolean Lir;
  protected r Lis;
  protected r Lit;
  
  protected aa(l paraml, ah paramah, d.l.b.a.b.b.a.g paramg, w paramw, d.l.b.a.b.b.ba paramba, boolean paramBoolean1, f paramf, b.a parama, an paraman, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7)
  {
    super(paraml, paramg, paramf, paramBoolean1, paraman);
    AppMethodBeat.i(57216);
    this.Lik = null;
    this.LgG = paramw;
    this.Lhb = paramba;
    paraml = paramah;
    if (paramah == null) {
      paraml = this;
    }
    this.Lil = paraml;
    this.Lhq = parama;
    this.Lim = paramBoolean2;
    this.Lin = paramBoolean3;
    this.Lhg = paramBoolean4;
    this.Lhh = paramBoolean5;
    this.LgF = paramBoolean6;
    this.Lio = paramBoolean7;
    AppMethodBeat.o(57216);
  }
  
  private static d.l.b.a.b.b.ba a(d.l.b.a.b.b.ba paramba, b.a parama)
  {
    AppMethodBeat.i(57228);
    if ((parama == b.a.Ldp) && (az.b(paramba.fSk())))
    {
      paramba = az.Lep;
      AppMethodBeat.o(57228);
      return paramba;
    }
    AppMethodBeat.o(57228);
    return paramba;
  }
  
  public static aa a(l paraml, d.l.b.a.b.b.a.g paramg, w paramw, d.l.b.a.b.b.ba paramba, f paramf, b.a parama, an paraman)
  {
    AppMethodBeat.i(57217);
    if (paraml == null) {
      agL(7);
    }
    if (paramg == null) {
      agL(8);
    }
    if (paramw == null) {
      agL(9);
    }
    if (paramba == null) {
      agL(10);
    }
    if (paramf == null) {
      agL(11);
    }
    if (parama == null) {
      agL(12);
    }
    if (paraman == null) {
      agL(13);
    }
    paraml = new aa(paraml, null, paramg, paramw, paramba, true, paramf, parama, paraman, false, false, false, false, false, false);
    AppMethodBeat.o(57217);
    return paraml;
  }
  
  private static t a(d.l.b.a.b.m.ba paramba, ag paramag)
  {
    AppMethodBeat.i(57229);
    if (paramba == null) {
      agL(25);
    }
    if (paramag == null) {
      agL(26);
    }
    if (paramag.fRr() != null)
    {
      paramba = paramag.fRr().c(paramba);
      AppMethodBeat.o(57229);
      return paramba;
    }
    AppMethodBeat.o(57229);
    return null;
  }
  
  private a fSM()
  {
    AppMethodBeat.i(57226);
    a locala = new a();
    AppMethodBeat.o(57226);
    return locala;
  }
  
  protected final ah a(a parama)
  {
    AppMethodBeat.i(57227);
    Object localObject2 = parama.Liu;
    Object localObject3 = parama.LgG;
    Object localObject4 = parama.Lhb;
    Object localObject5 = parama.Lil;
    Object localObject6 = parama.Lhq;
    Object localObject7 = parama.Lgj;
    boolean bool1 = parama.LhF;
    Object localObject1 = parama.Lil;
    if (bool1) {
      if (localObject1 != null)
      {
        localObject1 = ((ah)localObject1).fQk();
        label70:
        if (localObject1 == null) {
          agL(23);
        }
        localObject5 = a((l)localObject2, (w)localObject3, (d.l.b.a.b.b.ba)localObject4, (ah)localObject5, (b.a)localObject6, (f)localObject7, (an)localObject1);
        if (parama.LhH != null) {
          break label187;
        }
      }
    }
    label187:
    for (localObject1 = fQR();; localObject1 = parama.LhH)
    {
      localObject3 = new ArrayList(((List)localObject1).size());
      localObject6 = d.l.b.a.b.m.p.a((List)localObject1, parama.Lhw, (l)localObject5, (List)localObject3);
      localObject4 = ((d.l.b.a.b.m.ba)localObject6).c(fRV(), bh.LLX);
      if (localObject4 != null) {
        break label196;
      }
      AppMethodBeat.o(57227);
      return null;
      localObject1 = fRN();
      break;
      localObject1 = an.Lec;
      break label70;
    }
    label196:
    localObject1 = parama.Lha;
    if (localObject1 != null)
    {
      localObject2 = ((ak)localObject1).e((d.l.b.a.b.m.ba)localObject6);
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
    if (this.LgZ != null)
    {
      localObject2 = ((d.l.b.a.b.m.ba)localObject6).c(this.LgZ.fRV(), bh.LLW);
      if (localObject2 == null)
      {
        AppMethodBeat.o(57227);
        return null;
      }
      localObject2 = new ad((l)localObject5, new d.l.b.a.b.j.f.a.b((d.l.b.a.b.b.a)localObject5, (d.l.b.a.b.m.ab)localObject2, this.LgZ.fRQ()), this.LgZ.fQj());
      ((aa)localObject5).a((d.l.b.a.b.m.ab)localObject4, (List)localObject3, (ak)localObject1, (ak)localObject2);
      if (this.Lip != null) {
        break label516;
      }
      localObject1 = null;
      if (localObject1 != null)
      {
        localObject2 = this.Lip.fQS();
        ((z)localObject1).Lhr = a((d.l.b.a.b.m.ba)localObject6, this.Lip);
        if (localObject2 == null) {
          break label633;
        }
      }
    }
    label516:
    label633:
    for (localObject2 = ((d.l.b.a.b.m.ba)localObject6).c((d.l.b.a.b.m.ab)localObject2, bh.LLX);; localObject2 = null)
    {
      ((ab)localObject1).K((d.l.b.a.b.m.ab)localObject2);
      if (this.Liq != null) {
        break label639;
      }
      localObject2 = null;
      if (localObject2 == null) {
        break label796;
      }
      localObject4 = p.a((t)localObject2, this.Liq.fQU(), (d.l.b.a.b.m.ba)localObject6, false, false, null);
      localObject3 = localObject4;
      if (localObject4 == null)
      {
        ((aa)localObject5).Lir = true;
        localObject3 = Collections.singletonList(ac.a((aj)localObject2, d.l.b.a.b.j.d.a.G(parama.Liu).fPE(), ((av)this.Liq.fQU().get(0)).fQj()));
      }
      if (((List)localObject3).size() == 1) {
        break label766;
      }
      parama = new IllegalStateException();
      AppMethodBeat.o(57227);
      throw parama;
      localObject2 = null;
      break;
      localObject2 = this.Lip.fQj();
      localObject3 = parama.LgG;
      localObject4 = a(this.Lip.fQb(), parama.Lhq);
      bool1 = this.Lip.isDefault;
      bool2 = this.Lip.LgF;
      bool3 = this.Lip.Lhe;
      localObject7 = parama.Lhq;
      if (parama.Lil == null) {}
      for (localObject1 = null;; localObject1 = parama.Lil.fRK())
      {
        localObject1 = new ab((ah)localObject5, (d.l.b.a.b.b.a.g)localObject2, (w)localObject3, (d.l.b.a.b.b.ba)localObject4, bool1, bool2, bool3, (b.a)localObject7, (ai)localObject1, an.Lec);
        break;
      }
    }
    label639:
    localObject3 = this.Liq.fQj();
    localObject4 = parama.LgG;
    localObject7 = a(this.Liq.fQb(), parama.Lhq);
    bool1 = this.Liq.isDefault();
    boolean bool2 = this.Liq.fQi();
    boolean bool3 = this.Liq.fQf();
    b.a locala = parama.Lhq;
    if (parama.Lil == null) {}
    for (localObject2 = null;; localObject2 = parama.Lil.fRL())
    {
      localObject2 = new ac((ah)localObject5, (d.l.b.a.b.b.a.g)localObject3, (w)localObject4, (d.l.b.a.b.b.ba)localObject7, bool1, bool2, bool3, locala, (aj)localObject2, an.Lec);
      break;
    }
    label766:
    ((z)localObject2).Lhr = a((d.l.b.a.b.m.ba)localObject6, this.Liq);
    ((ac)localObject2).a((av)((List)localObject3).get(0));
    label796:
    if (this.Lis == null)
    {
      localObject3 = null;
      if (this.Lit != null) {
        break label911;
      }
    }
    label911:
    for (localObject4 = null;; localObject4 = new o(this.Lit.fQj(), (ah)localObject5))
    {
      ((aa)localObject5).a((ab)localObject1, (aj)localObject2, (r)localObject3, (r)localObject4);
      if (!parama.LhD) {
        break label940;
      }
      parama = i.gcT();
      localObject1 = fQW().iterator();
      while (((Iterator)localObject1).hasNext()) {
        parama.add(((ah)((Iterator)localObject1).next()).d((d.l.b.a.b.m.ba)localObject6));
      }
      localObject3 = new o(this.Lis.fQj(), (ah)localObject5);
      break;
    }
    ((aa)localObject5).t(parama);
    label940:
    if ((fSe()) && (this.LiT != null)) {
      ((aa)localObject5).a(this.LiT);
    }
    AppMethodBeat.o(57227);
    return localObject5;
  }
  
  protected aa a(l paraml, w paramw, d.l.b.a.b.b.ba paramba, ah paramah, b.a parama, f paramf, an paraman)
  {
    AppMethodBeat.i(57230);
    if (paraml == null) {
      agL(27);
    }
    if (paramw == null) {
      agL(28);
    }
    if (paramba == null) {
      agL(29);
    }
    if (parama == null) {
      agL(30);
    }
    if (paramf == null) {
      agL(31);
    }
    if (paraman == null) {
      agL(32);
    }
    paraml = new aa(paraml, paramah, fQj(), paramw, paramba, this.LiS, paramf, parama, paraman, this.Lim, fSe(), this.Lhg, this.Lhh, fQi(), this.Lio);
    AppMethodBeat.o(57230);
    return paraml;
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
  
  public final void a(ab paramab, aj paramaj)
  {
    AppMethodBeat.i(57219);
    a(paramab, paramaj, null, null);
    AppMethodBeat.o(57219);
  }
  
  public final void a(ab paramab, aj paramaj, r paramr1, r paramr2)
  {
    this.Lip = paramab;
    this.Liq = paramaj;
    this.Lis = paramr1;
    this.Lit = paramr2;
  }
  
  public final void a(d.l.b.a.b.m.ab paramab, List<? extends as> paramList, ak paramak1, ak paramak2)
  {
    AppMethodBeat.i(57218);
    if (paramab == null) {
      agL(14);
    }
    if (paramList == null) {
      agL(15);
    }
    N(paramab);
    this.LdP = new ArrayList(paramList);
    this.LgZ = paramak2;
    this.Lha = paramak1;
    AppMethodBeat.o(57218);
  }
  
  public final ah d(d.l.b.a.b.m.ba paramba)
  {
    AppMethodBeat.i(57225);
    if (paramba == null) {
      agL(22);
    }
    if (paramba.Lhw.isEmpty())
    {
      AppMethodBeat.o(57225);
      return this;
    }
    a locala = fSM();
    paramba = paramba.gcE();
    if (paramba == null) {
      a.agL(13);
    }
    locala.Lhw = paramba;
    paramba = locala.g(fRN()).fSO();
    AppMethodBeat.o(57225);
    return paramba;
  }
  
  public final w fPZ()
  {
    AppMethodBeat.i(57222);
    w localw = this.LgG;
    if (localw == null) {
      agL(19);
    }
    AppMethodBeat.o(57222);
    return localw;
  }
  
  public final ak fQP()
  {
    return this.LgZ;
  }
  
  public final ak fQQ()
  {
    return this.Lha;
  }
  
  public final List<as> fQR()
  {
    AppMethodBeat.i(57220);
    List localList = this.LdP;
    if (localList == null) {
      agL(17);
    }
    AppMethodBeat.o(57220);
    return localList;
  }
  
  public final d.l.b.a.b.m.ab fQS()
  {
    AppMethodBeat.i(57221);
    d.l.b.a.b.m.ab localab = fRV();
    if (localab == null) {
      agL(18);
    }
    AppMethodBeat.o(57221);
    return localab;
  }
  
  public final Collection<? extends ah> fQW()
  {
    AppMethodBeat.i(57235);
    if (this.Lik != null) {}
    for (Object localObject = this.Lik;; localObject = Collections.emptyList())
    {
      if (localObject == null) {
        agL(36);
      }
      AppMethodBeat.o(57235);
      return localObject;
    }
  }
  
  public final b.a fQY()
  {
    AppMethodBeat.i(57233);
    b.a locala = this.Lhq;
    if (locala == null) {
      agL(34);
    }
    AppMethodBeat.o(57233);
    return locala;
  }
  
  public final d.l.b.a.b.b.ba fQb()
  {
    AppMethodBeat.i(57223);
    d.l.b.a.b.b.ba localba = this.Lhb;
    if (localba == null) {
      agL(20);
    }
    AppMethodBeat.o(57223);
    return localba;
  }
  
  public final boolean fQg()
  {
    return this.Lhg;
  }
  
  public final boolean fQh()
  {
    return this.Lhh;
  }
  
  public boolean fQi()
  {
    return this.LgF;
  }
  
  public final aj fRL()
  {
    return this.Liq;
  }
  
  public final List<ag> fRM()
  {
    AppMethodBeat.i(57224);
    ArrayList localArrayList = new ArrayList(2);
    if (this.Lip != null) {
      localArrayList.add(this.Lip);
    }
    if (this.Liq != null) {
      localArrayList.add(this.Liq);
    }
    AppMethodBeat.o(57224);
    return localArrayList;
  }
  
  public final ah fRN()
  {
    AppMethodBeat.i(57232);
    if (this.Lil == this) {}
    for (Object localObject = this;; localObject = this.Lil.fRN())
    {
      if (localObject == null) {
        agL(33);
      }
      AppMethodBeat.o(57232);
      return localObject;
    }
  }
  
  public final r fRO()
  {
    return this.Lis;
  }
  
  public final r fRP()
  {
    return this.Lit;
  }
  
  public boolean fSe()
  {
    return this.Lin;
  }
  
  public final boolean fSf()
  {
    return this.Lim;
  }
  
  public final boolean fSg()
  {
    return this.Lio;
  }
  
  public final void t(Collection<? extends d.l.b.a.b.b.b> paramCollection)
  {
    AppMethodBeat.i(57234);
    if (paramCollection == null) {
      agL(35);
    }
    this.Lik = paramCollection;
    AppMethodBeat.o(57234);
  }
  
  public final class a
  {
    w LgG;
    f Lgj;
    boolean LhD;
    boolean LhF;
    List<as> LhH;
    ak Lha;
    d.l.b.a.b.b.ba Lhb;
    b.a Lhq;
    ay Lhw;
    ah Lil;
    l Liu;
    
    public a()
    {
      AppMethodBeat.i(57212);
      this.Liu = aa.this.fPU();
      this.LgG = aa.this.fPZ();
      this.Lhb = aa.this.fQb();
      this.Lil = null;
      this.LhF = false;
      this.Lhq = aa.this.fQY();
      this.Lhw = ay.LLI;
      this.LhD = true;
      this.Lha = aa.a(aa.this);
      this.LhH = null;
      this.Lgj = aa.this.fRf();
      AppMethodBeat.o(57212);
    }
    
    public final ah fSO()
    {
      AppMethodBeat.i(57214);
      ah localah = aa.this.a(this);
      AppMethodBeat.o(57214);
      return localah;
    }
    
    public final a g(d.l.b.a.b.b.b paramb)
    {
      AppMethodBeat.i(57213);
      this.Lil = ((ah)paramb);
      if (this == null) {
        agL(2);
      }
      AppMethodBeat.o(57213);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.b.c.aa
 * JD-Core Version:    0.7.0.1
 */