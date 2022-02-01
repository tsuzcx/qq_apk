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
  private List<as> MUK;
  private final boolean MXB;
  private final w MXC;
  private ak MXV;
  protected ak MXW;
  public d.l.b.a.b.b.ba MXX;
  protected final boolean MYc;
  private final boolean MYd;
  private final b.a MYm;
  private Collection<? extends ah> MZg;
  private final ah MZh;
  protected final boolean MZi;
  private final boolean MZj;
  protected final boolean MZk;
  public ab MZl;
  protected aj MZm;
  protected boolean MZn;
  protected r MZo;
  protected r MZp;
  
  protected aa(l paraml, ah paramah, d.l.b.a.b.b.a.g paramg, w paramw, d.l.b.a.b.b.ba paramba, boolean paramBoolean1, f paramf, b.a parama, an paraman, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7)
  {
    super(paraml, paramg, paramf, paramBoolean1, paraman);
    AppMethodBeat.i(57216);
    this.MZg = null;
    this.MXC = paramw;
    this.MXX = paramba;
    paraml = paramah;
    if (paramah == null) {
      paraml = this;
    }
    this.MZh = paraml;
    this.MYm = parama;
    this.MZi = paramBoolean2;
    this.MZj = paramBoolean3;
    this.MYc = paramBoolean4;
    this.MYd = paramBoolean5;
    this.MXB = paramBoolean6;
    this.MZk = paramBoolean7;
    AppMethodBeat.o(57216);
  }
  
  private static d.l.b.a.b.b.ba a(d.l.b.a.b.b.ba paramba, b.a parama)
  {
    AppMethodBeat.i(57228);
    if ((parama == b.a.MUk) && (az.b(paramba.gjJ())))
    {
      paramba = az.MVk;
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
      ajm(7);
    }
    if (paramg == null) {
      ajm(8);
    }
    if (paramw == null) {
      ajm(9);
    }
    if (paramba == null) {
      ajm(10);
    }
    if (paramf == null) {
      ajm(11);
    }
    if (parama == null) {
      ajm(12);
    }
    if (paraman == null) {
      ajm(13);
    }
    paraml = new aa(paraml, null, paramg, paramw, paramba, true, paramf, parama, paraman, false, false, false, false, false, false);
    AppMethodBeat.o(57217);
    return paraml;
  }
  
  private static t a(d.l.b.a.b.m.ba paramba, ag paramag)
  {
    AppMethodBeat.i(57229);
    if (paramba == null) {
      ajm(25);
    }
    if (paramag == null) {
      ajm(26);
    }
    if (paramag.giQ() != null)
    {
      paramba = paramag.giQ().c(paramba);
      AppMethodBeat.o(57229);
      return paramba;
    }
    AppMethodBeat.o(57229);
    return null;
  }
  
  private a gkl()
  {
    AppMethodBeat.i(57226);
    a locala = new a();
    AppMethodBeat.o(57226);
    return locala;
  }
  
  protected final ah a(a parama)
  {
    AppMethodBeat.i(57227);
    Object localObject2 = parama.MZq;
    Object localObject3 = parama.MXC;
    Object localObject4 = parama.MXX;
    Object localObject5 = parama.MZh;
    Object localObject6 = parama.MYm;
    Object localObject7 = parama.MXf;
    boolean bool1 = parama.MYB;
    Object localObject1 = parama.MZh;
    if (bool1) {
      if (localObject1 != null)
      {
        localObject1 = ((ah)localObject1).ghI();
        label70:
        if (localObject1 == null) {
          ajm(23);
        }
        localObject5 = a((l)localObject2, (w)localObject3, (d.l.b.a.b.b.ba)localObject4, (ah)localObject5, (b.a)localObject6, (f)localObject7, (an)localObject1);
        if (parama.MYD != null) {
          break label187;
        }
      }
    }
    label187:
    for (localObject1 = gip();; localObject1 = parama.MYD)
    {
      localObject3 = new ArrayList(((List)localObject1).size());
      localObject6 = d.l.b.a.b.m.p.a((List)localObject1, parama.MYs, (l)localObject5, (List)localObject3);
      localObject4 = ((d.l.b.a.b.m.ba)localObject6).c(gju(), bh.NCR);
      if (localObject4 != null) {
        break label196;
      }
      AppMethodBeat.o(57227);
      return null;
      localObject1 = gjm();
      break;
      localObject1 = an.MUX;
      break label70;
    }
    label196:
    localObject1 = parama.MXW;
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
    if (this.MXV != null)
    {
      localObject2 = ((d.l.b.a.b.m.ba)localObject6).c(this.MXV.gju(), bh.NCQ);
      if (localObject2 == null)
      {
        AppMethodBeat.o(57227);
        return null;
      }
      localObject2 = new ad((l)localObject5, new d.l.b.a.b.j.f.a.b((d.l.b.a.b.b.a)localObject5, (d.l.b.a.b.m.ab)localObject2, this.MXV.gjp()), this.MXV.ghH());
      ((aa)localObject5).a((d.l.b.a.b.m.ab)localObject4, (List)localObject3, (ak)localObject1, (ak)localObject2);
      if (this.MZl != null) {
        break label516;
      }
      localObject1 = null;
      if (localObject1 != null)
      {
        localObject2 = this.MZl.giq();
        ((z)localObject1).MYn = a((d.l.b.a.b.m.ba)localObject6, this.MZl);
        if (localObject2 == null) {
          break label633;
        }
      }
    }
    label516:
    label633:
    for (localObject2 = ((d.l.b.a.b.m.ba)localObject6).c((d.l.b.a.b.m.ab)localObject2, bh.NCR);; localObject2 = null)
    {
      ((ab)localObject1).K((d.l.b.a.b.m.ab)localObject2);
      if (this.MZm != null) {
        break label639;
      }
      localObject2 = null;
      if (localObject2 == null) {
        break label796;
      }
      localObject4 = p.a((t)localObject2, this.MZm.gis(), (d.l.b.a.b.m.ba)localObject6, false, false, null);
      localObject3 = localObject4;
      if (localObject4 == null)
      {
        ((aa)localObject5).MZn = true;
        localObject3 = Collections.singletonList(ac.a((aj)localObject2, d.l.b.a.b.j.d.a.G(parama.MZq).ghc(), ((av)this.MZm.gis().get(0)).ghH()));
      }
      if (((List)localObject3).size() == 1) {
        break label766;
      }
      parama = new IllegalStateException();
      AppMethodBeat.o(57227);
      throw parama;
      localObject2 = null;
      break;
      localObject2 = this.MZl.ghH();
      localObject3 = parama.MXC;
      localObject4 = a(this.MZl.ghz(), parama.MYm);
      bool1 = this.MZl.isDefault;
      bool2 = this.MZl.MXB;
      bool3 = this.MZl.MYa;
      localObject7 = parama.MYm;
      if (parama.MZh == null) {}
      for (localObject1 = null;; localObject1 = parama.MZh.gjj())
      {
        localObject1 = new ab((ah)localObject5, (d.l.b.a.b.b.a.g)localObject2, (w)localObject3, (d.l.b.a.b.b.ba)localObject4, bool1, bool2, bool3, (b.a)localObject7, (ai)localObject1, an.MUX);
        break;
      }
    }
    label639:
    localObject3 = this.MZm.ghH();
    localObject4 = parama.MXC;
    localObject7 = a(this.MZm.ghz(), parama.MYm);
    bool1 = this.MZm.isDefault();
    boolean bool2 = this.MZm.ghG();
    boolean bool3 = this.MZm.ghD();
    b.a locala = parama.MYm;
    if (parama.MZh == null) {}
    for (localObject2 = null;; localObject2 = parama.MZh.gjk())
    {
      localObject2 = new ac((ah)localObject5, (d.l.b.a.b.b.a.g)localObject3, (w)localObject4, (d.l.b.a.b.b.ba)localObject7, bool1, bool2, bool3, locala, (aj)localObject2, an.MUX);
      break;
    }
    label766:
    ((z)localObject2).MYn = a((d.l.b.a.b.m.ba)localObject6, this.MZm);
    ((ac)localObject2).a((av)((List)localObject3).get(0));
    label796:
    if (this.MZo == null)
    {
      localObject3 = null;
      if (this.MZp != null) {
        break label911;
      }
    }
    label911:
    for (localObject4 = null;; localObject4 = new o(this.MZp.ghH(), (ah)localObject5))
    {
      ((aa)localObject5).a((ab)localObject1, (aj)localObject2, (r)localObject3, (r)localObject4);
      if (!parama.MYz) {
        break label940;
      }
      parama = i.guu();
      localObject1 = giu().iterator();
      while (((Iterator)localObject1).hasNext()) {
        parama.add(((ah)((Iterator)localObject1).next()).d((d.l.b.a.b.m.ba)localObject6));
      }
      localObject3 = new o(this.MZo.ghH(), (ah)localObject5);
      break;
    }
    ((aa)localObject5).u(parama);
    label940:
    if ((gjD()) && (this.MZP != null)) {
      ((aa)localObject5).a(this.MZP);
    }
    AppMethodBeat.o(57227);
    return localObject5;
  }
  
  protected aa a(l paraml, w paramw, d.l.b.a.b.b.ba paramba, ah paramah, b.a parama, f paramf, an paraman)
  {
    AppMethodBeat.i(57230);
    if (paraml == null) {
      ajm(27);
    }
    if (paramw == null) {
      ajm(28);
    }
    if (paramba == null) {
      ajm(29);
    }
    if (parama == null) {
      ajm(30);
    }
    if (paramf == null) {
      ajm(31);
    }
    if (paraman == null) {
      ajm(32);
    }
    paraml = new aa(paraml, paramah, ghH(), paramw, paramba, this.MZO, paramf, parama, paraman, this.MZi, gjD(), this.MYc, this.MYd, ghG(), this.MZk);
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
    this.MZl = paramab;
    this.MZm = paramaj;
    this.MZo = paramr1;
    this.MZp = paramr2;
  }
  
  public final void a(d.l.b.a.b.m.ab paramab, List<? extends as> paramList, ak paramak1, ak paramak2)
  {
    AppMethodBeat.i(57218);
    if (paramab == null) {
      ajm(14);
    }
    if (paramList == null) {
      ajm(15);
    }
    N(paramab);
    this.MUK = new ArrayList(paramList);
    this.MXV = paramak2;
    this.MXW = paramak1;
    AppMethodBeat.o(57218);
  }
  
  public final ah d(d.l.b.a.b.m.ba paramba)
  {
    AppMethodBeat.i(57225);
    if (paramba == null) {
      ajm(22);
    }
    if (paramba.MYs.isEmpty())
    {
      AppMethodBeat.o(57225);
      return this;
    }
    a locala = gkl();
    paramba = paramba.guf();
    if (paramba == null) {
      a.ajm(13);
    }
    locala.MYs = paramba;
    paramba = locala.g(gjm()).gkn();
    AppMethodBeat.o(57225);
    return paramba;
  }
  
  public final boolean ghE()
  {
    return this.MYc;
  }
  
  public final boolean ghF()
  {
    return this.MYd;
  }
  
  public boolean ghG()
  {
    return this.MXB;
  }
  
  public final w ghx()
  {
    AppMethodBeat.i(57222);
    w localw = this.MXC;
    if (localw == null) {
      ajm(19);
    }
    AppMethodBeat.o(57222);
    return localw;
  }
  
  public final d.l.b.a.b.b.ba ghz()
  {
    AppMethodBeat.i(57223);
    d.l.b.a.b.b.ba localba = this.MXX;
    if (localba == null) {
      ajm(20);
    }
    AppMethodBeat.o(57223);
    return localba;
  }
  
  public final ak gin()
  {
    return this.MXV;
  }
  
  public final ak gio()
  {
    return this.MXW;
  }
  
  public final List<as> gip()
  {
    AppMethodBeat.i(57220);
    List localList = this.MUK;
    if (localList == null) {
      ajm(17);
    }
    AppMethodBeat.o(57220);
    return localList;
  }
  
  public final d.l.b.a.b.m.ab giq()
  {
    AppMethodBeat.i(57221);
    d.l.b.a.b.m.ab localab = gju();
    if (localab == null) {
      ajm(18);
    }
    AppMethodBeat.o(57221);
    return localab;
  }
  
  public final Collection<? extends ah> giu()
  {
    AppMethodBeat.i(57235);
    if (this.MZg != null) {}
    for (Object localObject = this.MZg;; localObject = Collections.emptyList())
    {
      if (localObject == null) {
        ajm(36);
      }
      AppMethodBeat.o(57235);
      return localObject;
    }
  }
  
  public final b.a giw()
  {
    AppMethodBeat.i(57233);
    b.a locala = this.MYm;
    if (locala == null) {
      ajm(34);
    }
    AppMethodBeat.o(57233);
    return locala;
  }
  
  public boolean gjD()
  {
    return this.MZj;
  }
  
  public final boolean gjE()
  {
    return this.MZi;
  }
  
  public final boolean gjF()
  {
    return this.MZk;
  }
  
  public final aj gjk()
  {
    return this.MZm;
  }
  
  public final List<ag> gjl()
  {
    AppMethodBeat.i(57224);
    ArrayList localArrayList = new ArrayList(2);
    if (this.MZl != null) {
      localArrayList.add(this.MZl);
    }
    if (this.MZm != null) {
      localArrayList.add(this.MZm);
    }
    AppMethodBeat.o(57224);
    return localArrayList;
  }
  
  public final ah gjm()
  {
    AppMethodBeat.i(57232);
    if (this.MZh == this) {}
    for (Object localObject = this;; localObject = this.MZh.gjm())
    {
      if (localObject == null) {
        ajm(33);
      }
      AppMethodBeat.o(57232);
      return localObject;
    }
  }
  
  public final r gjn()
  {
    return this.MZo;
  }
  
  public final r gjo()
  {
    return this.MZp;
  }
  
  public final void u(Collection<? extends d.l.b.a.b.b.b> paramCollection)
  {
    AppMethodBeat.i(57234);
    if (paramCollection == null) {
      ajm(35);
    }
    this.MZg = paramCollection;
    AppMethodBeat.o(57234);
  }
  
  public final class a
  {
    w MXC;
    ak MXW;
    d.l.b.a.b.b.ba MXX;
    f MXf;
    boolean MYB;
    List<as> MYD;
    b.a MYm;
    ay MYs;
    boolean MYz;
    ah MZh;
    l MZq;
    
    public a()
    {
      AppMethodBeat.i(57212);
      this.MZq = aa.this.ghs();
      this.MXC = aa.this.ghx();
      this.MXX = aa.this.ghz();
      this.MZh = null;
      this.MYB = false;
      this.MYm = aa.this.giw();
      this.MYs = ay.NCD;
      this.MYz = true;
      this.MXW = aa.a(aa.this);
      this.MYD = null;
      this.MXf = aa.this.giD();
      AppMethodBeat.o(57212);
    }
    
    public final a g(d.l.b.a.b.b.b paramb)
    {
      AppMethodBeat.i(57213);
      this.MZh = ((ah)paramb);
      if (this == null) {
        ajm(2);
      }
      AppMethodBeat.o(57213);
      return this;
    }
    
    public final ah gkn()
    {
      AppMethodBeat.i(57214);
      ah localah = aa.this.a(this);
      AppMethodBeat.o(57214);
      return localah;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.b.c.aa
 * JD-Core Version:    0.7.0.1
 */