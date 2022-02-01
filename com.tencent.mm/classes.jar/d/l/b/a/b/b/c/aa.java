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
  private List<as> NrP;
  private final boolean NuH;
  private final w NuI;
  private ak Nvb;
  protected ak Nvc;
  public d.l.b.a.b.b.ba Nvd;
  protected final boolean Nvi;
  private final boolean Nvj;
  private final b.a Nvs;
  private Collection<? extends ah> Nwm;
  private final ah Nwn;
  protected final boolean Nwo;
  private final boolean Nwp;
  protected final boolean Nwq;
  public ab Nwr;
  protected aj Nws;
  protected boolean Nwt;
  protected r Nwu;
  protected r Nwv;
  
  protected aa(l paraml, ah paramah, d.l.b.a.b.b.a.g paramg, w paramw, d.l.b.a.b.b.ba paramba, boolean paramBoolean1, f paramf, b.a parama, an paraman, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7)
  {
    super(paraml, paramg, paramf, paramBoolean1, paraman);
    AppMethodBeat.i(57216);
    this.Nwm = null;
    this.NuI = paramw;
    this.Nvd = paramba;
    paraml = paramah;
    if (paramah == null) {
      paraml = this;
    }
    this.Nwn = paraml;
    this.Nvs = parama;
    this.Nwo = paramBoolean2;
    this.Nwp = paramBoolean3;
    this.Nvi = paramBoolean4;
    this.Nvj = paramBoolean5;
    this.NuH = paramBoolean6;
    this.Nwq = paramBoolean7;
    AppMethodBeat.o(57216);
  }
  
  private static d.l.b.a.b.b.ba a(d.l.b.a.b.b.ba paramba, b.a parama)
  {
    AppMethodBeat.i(57228);
    if ((parama == b.a.Nrp) && (az.b(paramba.gol())))
    {
      paramba = az.Nsp;
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
      ajW(7);
    }
    if (paramg == null) {
      ajW(8);
    }
    if (paramw == null) {
      ajW(9);
    }
    if (paramba == null) {
      ajW(10);
    }
    if (paramf == null) {
      ajW(11);
    }
    if (parama == null) {
      ajW(12);
    }
    if (paraman == null) {
      ajW(13);
    }
    paraml = new aa(paraml, null, paramg, paramw, paramba, true, paramf, parama, paraman, false, false, false, false, false, false);
    AppMethodBeat.o(57217);
    return paraml;
  }
  
  private static t a(d.l.b.a.b.m.ba paramba, ag paramag)
  {
    AppMethodBeat.i(57229);
    if (paramba == null) {
      ajW(25);
    }
    if (paramag == null) {
      ajW(26);
    }
    if (paramag.gns() != null)
    {
      paramba = paramag.gns().c(paramba);
      AppMethodBeat.o(57229);
      return paramba;
    }
    AppMethodBeat.o(57229);
    return null;
  }
  
  private a goN()
  {
    AppMethodBeat.i(57226);
    a locala = new a();
    AppMethodBeat.o(57226);
    return locala;
  }
  
  protected final ah a(a parama)
  {
    AppMethodBeat.i(57227);
    Object localObject2 = parama.Nww;
    Object localObject3 = parama.NuI;
    Object localObject4 = parama.Nvd;
    Object localObject5 = parama.Nwn;
    Object localObject6 = parama.Nvs;
    Object localObject7 = parama.Nul;
    boolean bool1 = parama.NvH;
    Object localObject1 = parama.Nwn;
    if (bool1) {
      if (localObject1 != null)
      {
        localObject1 = ((ah)localObject1).gmk();
        label70:
        if (localObject1 == null) {
          ajW(23);
        }
        localObject5 = a((l)localObject2, (w)localObject3, (d.l.b.a.b.b.ba)localObject4, (ah)localObject5, (b.a)localObject6, (f)localObject7, (an)localObject1);
        if (parama.NvJ != null) {
          break label187;
        }
      }
    }
    label187:
    for (localObject1 = gmR();; localObject1 = parama.NvJ)
    {
      localObject3 = new ArrayList(((List)localObject1).size());
      localObject6 = d.l.b.a.b.m.p.a((List)localObject1, parama.Nvy, (l)localObject5, (List)localObject3);
      localObject4 = ((d.l.b.a.b.m.ba)localObject6).c(gnW(), bh.NZY);
      if (localObject4 != null) {
        break label196;
      }
      AppMethodBeat.o(57227);
      return null;
      localObject1 = gnO();
      break;
      localObject1 = an.Nsc;
      break label70;
    }
    label196:
    localObject1 = parama.Nvc;
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
    if (this.Nvb != null)
    {
      localObject2 = ((d.l.b.a.b.m.ba)localObject6).c(this.Nvb.gnW(), bh.NZX);
      if (localObject2 == null)
      {
        AppMethodBeat.o(57227);
        return null;
      }
      localObject2 = new ad((l)localObject5, new d.l.b.a.b.j.f.a.b((d.l.b.a.b.b.a)localObject5, (d.l.b.a.b.m.ab)localObject2, this.Nvb.gnR()), this.Nvb.gmj());
      ((aa)localObject5).a((d.l.b.a.b.m.ab)localObject4, (List)localObject3, (ak)localObject1, (ak)localObject2);
      if (this.Nwr != null) {
        break label516;
      }
      localObject1 = null;
      if (localObject1 != null)
      {
        localObject2 = this.Nwr.gmS();
        ((z)localObject1).Nvt = a((d.l.b.a.b.m.ba)localObject6, this.Nwr);
        if (localObject2 == null) {
          break label633;
        }
      }
    }
    label516:
    label633:
    for (localObject2 = ((d.l.b.a.b.m.ba)localObject6).c((d.l.b.a.b.m.ab)localObject2, bh.NZY);; localObject2 = null)
    {
      ((ab)localObject1).K((d.l.b.a.b.m.ab)localObject2);
      if (this.Nws != null) {
        break label639;
      }
      localObject2 = null;
      if (localObject2 == null) {
        break label796;
      }
      localObject4 = p.a((t)localObject2, this.Nws.gmU(), (d.l.b.a.b.m.ba)localObject6, false, false, null);
      localObject3 = localObject4;
      if (localObject4 == null)
      {
        ((aa)localObject5).Nwt = true;
        localObject3 = Collections.singletonList(ac.a((aj)localObject2, d.l.b.a.b.j.d.a.G(parama.Nww).glE(), ((av)this.Nws.gmU().get(0)).gmj()));
      }
      if (((List)localObject3).size() == 1) {
        break label766;
      }
      parama = new IllegalStateException();
      AppMethodBeat.o(57227);
      throw parama;
      localObject2 = null;
      break;
      localObject2 = this.Nwr.gmj();
      localObject3 = parama.NuI;
      localObject4 = a(this.Nwr.gmb(), parama.Nvs);
      bool1 = this.Nwr.isDefault;
      bool2 = this.Nwr.NuH;
      bool3 = this.Nwr.Nvg;
      localObject7 = parama.Nvs;
      if (parama.Nwn == null) {}
      for (localObject1 = null;; localObject1 = parama.Nwn.gnL())
      {
        localObject1 = new ab((ah)localObject5, (d.l.b.a.b.b.a.g)localObject2, (w)localObject3, (d.l.b.a.b.b.ba)localObject4, bool1, bool2, bool3, (b.a)localObject7, (ai)localObject1, an.Nsc);
        break;
      }
    }
    label639:
    localObject3 = this.Nws.gmj();
    localObject4 = parama.NuI;
    localObject7 = a(this.Nws.gmb(), parama.Nvs);
    bool1 = this.Nws.isDefault();
    boolean bool2 = this.Nws.gmi();
    boolean bool3 = this.Nws.gmf();
    b.a locala = parama.Nvs;
    if (parama.Nwn == null) {}
    for (localObject2 = null;; localObject2 = parama.Nwn.gnM())
    {
      localObject2 = new ac((ah)localObject5, (d.l.b.a.b.b.a.g)localObject3, (w)localObject4, (d.l.b.a.b.b.ba)localObject7, bool1, bool2, bool3, locala, (aj)localObject2, an.Nsc);
      break;
    }
    label766:
    ((z)localObject2).Nvt = a((d.l.b.a.b.m.ba)localObject6, this.Nws);
    ((ac)localObject2).a((av)((List)localObject3).get(0));
    label796:
    if (this.Nwu == null)
    {
      localObject3 = null;
      if (this.Nwv != null) {
        break label911;
      }
    }
    label911:
    for (localObject4 = null;; localObject4 = new o(this.Nwv.gmj(), (ah)localObject5))
    {
      ((aa)localObject5).a((ab)localObject1, (aj)localObject2, (r)localObject3, (r)localObject4);
      if (!parama.NvF) {
        break label940;
      }
      parama = i.gyW();
      localObject1 = gmW().iterator();
      while (((Iterator)localObject1).hasNext()) {
        parama.add(((ah)((Iterator)localObject1).next()).d((d.l.b.a.b.m.ba)localObject6));
      }
      localObject3 = new o(this.Nwu.gmj(), (ah)localObject5);
      break;
    }
    ((aa)localObject5).u(parama);
    label940:
    if ((gof()) && (this.NwV != null)) {
      ((aa)localObject5).a(this.NwV);
    }
    AppMethodBeat.o(57227);
    return localObject5;
  }
  
  protected aa a(l paraml, w paramw, d.l.b.a.b.b.ba paramba, ah paramah, b.a parama, f paramf, an paraman)
  {
    AppMethodBeat.i(57230);
    if (paraml == null) {
      ajW(27);
    }
    if (paramw == null) {
      ajW(28);
    }
    if (paramba == null) {
      ajW(29);
    }
    if (parama == null) {
      ajW(30);
    }
    if (paramf == null) {
      ajW(31);
    }
    if (paraman == null) {
      ajW(32);
    }
    paraml = new aa(paraml, paramah, gmj(), paramw, paramba, this.NwU, paramf, parama, paraman, this.Nwo, gof(), this.Nvi, this.Nvj, gmi(), this.Nwq);
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
    this.Nwr = paramab;
    this.Nws = paramaj;
    this.Nwu = paramr1;
    this.Nwv = paramr2;
  }
  
  public final void a(d.l.b.a.b.m.ab paramab, List<? extends as> paramList, ak paramak1, ak paramak2)
  {
    AppMethodBeat.i(57218);
    if (paramab == null) {
      ajW(14);
    }
    if (paramList == null) {
      ajW(15);
    }
    N(paramab);
    this.NrP = new ArrayList(paramList);
    this.Nvb = paramak2;
    this.Nvc = paramak1;
    AppMethodBeat.o(57218);
  }
  
  public final ah d(d.l.b.a.b.m.ba paramba)
  {
    AppMethodBeat.i(57225);
    if (paramba == null) {
      ajW(22);
    }
    if (paramba.Nvy.isEmpty())
    {
      AppMethodBeat.o(57225);
      return this;
    }
    a locala = goN();
    paramba = paramba.gyH();
    if (paramba == null) {
      a.ajW(13);
    }
    locala.Nvy = paramba;
    paramba = locala.g(gnO()).goP();
    AppMethodBeat.o(57225);
    return paramba;
  }
  
  public final w glZ()
  {
    AppMethodBeat.i(57222);
    w localw = this.NuI;
    if (localw == null) {
      ajW(19);
    }
    AppMethodBeat.o(57222);
    return localw;
  }
  
  public final ak gmP()
  {
    return this.Nvb;
  }
  
  public final ak gmQ()
  {
    return this.Nvc;
  }
  
  public final List<as> gmR()
  {
    AppMethodBeat.i(57220);
    List localList = this.NrP;
    if (localList == null) {
      ajW(17);
    }
    AppMethodBeat.o(57220);
    return localList;
  }
  
  public final d.l.b.a.b.m.ab gmS()
  {
    AppMethodBeat.i(57221);
    d.l.b.a.b.m.ab localab = gnW();
    if (localab == null) {
      ajW(18);
    }
    AppMethodBeat.o(57221);
    return localab;
  }
  
  public final Collection<? extends ah> gmW()
  {
    AppMethodBeat.i(57235);
    if (this.Nwm != null) {}
    for (Object localObject = this.Nwm;; localObject = Collections.emptyList())
    {
      if (localObject == null) {
        ajW(36);
      }
      AppMethodBeat.o(57235);
      return localObject;
    }
  }
  
  public final b.a gmY()
  {
    AppMethodBeat.i(57233);
    b.a locala = this.Nvs;
    if (locala == null) {
      ajW(34);
    }
    AppMethodBeat.o(57233);
    return locala;
  }
  
  public final d.l.b.a.b.b.ba gmb()
  {
    AppMethodBeat.i(57223);
    d.l.b.a.b.b.ba localba = this.Nvd;
    if (localba == null) {
      ajW(20);
    }
    AppMethodBeat.o(57223);
    return localba;
  }
  
  public final boolean gmg()
  {
    return this.Nvi;
  }
  
  public final boolean gmh()
  {
    return this.Nvj;
  }
  
  public boolean gmi()
  {
    return this.NuH;
  }
  
  public final aj gnM()
  {
    return this.Nws;
  }
  
  public final List<ag> gnN()
  {
    AppMethodBeat.i(57224);
    ArrayList localArrayList = new ArrayList(2);
    if (this.Nwr != null) {
      localArrayList.add(this.Nwr);
    }
    if (this.Nws != null) {
      localArrayList.add(this.Nws);
    }
    AppMethodBeat.o(57224);
    return localArrayList;
  }
  
  public final ah gnO()
  {
    AppMethodBeat.i(57232);
    if (this.Nwn == this) {}
    for (Object localObject = this;; localObject = this.Nwn.gnO())
    {
      if (localObject == null) {
        ajW(33);
      }
      AppMethodBeat.o(57232);
      return localObject;
    }
  }
  
  public final r gnP()
  {
    return this.Nwu;
  }
  
  public final r gnQ()
  {
    return this.Nwv;
  }
  
  public boolean gof()
  {
    return this.Nwp;
  }
  
  public final boolean gog()
  {
    return this.Nwo;
  }
  
  public final boolean goh()
  {
    return this.Nwq;
  }
  
  public final void u(Collection<? extends d.l.b.a.b.b.b> paramCollection)
  {
    AppMethodBeat.i(57234);
    if (paramCollection == null) {
      ajW(35);
    }
    this.Nwm = paramCollection;
    AppMethodBeat.o(57234);
  }
  
  public final class a
  {
    w NuI;
    f Nul;
    boolean NvF;
    boolean NvH;
    List<as> NvJ;
    ak Nvc;
    d.l.b.a.b.b.ba Nvd;
    b.a Nvs;
    ay Nvy;
    ah Nwn;
    l Nww;
    
    public a()
    {
      AppMethodBeat.i(57212);
      this.Nww = aa.this.glU();
      this.NuI = aa.this.glZ();
      this.Nvd = aa.this.gmb();
      this.Nwn = null;
      this.NvH = false;
      this.Nvs = aa.this.gmY();
      this.Nvy = ay.NZK;
      this.NvF = true;
      this.Nvc = aa.a(aa.this);
      this.NvJ = null;
      this.Nul = aa.this.gnf();
      AppMethodBeat.o(57212);
    }
    
    public final a g(d.l.b.a.b.b.b paramb)
    {
      AppMethodBeat.i(57213);
      this.Nwn = ((ah)paramb);
      if (this == null) {
        ajW(2);
      }
      AppMethodBeat.o(57213);
      return this;
    }
    
    public final ah goP()
    {
      AppMethodBeat.i(57214);
      ah localah = aa.this.a(this);
      AppMethodBeat.o(57214);
      return localah;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.b.c.aa
 * JD-Core Version:    0.7.0.1
 */