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
  private List<as> Jqw;
  private ak JtG;
  protected ak JtH;
  public d.l.b.a.b.b.ba JtI;
  protected final boolean JtN;
  private final boolean JtO;
  private final b.a JtX;
  private final boolean Jtm;
  private final w Jtn;
  private Collection<? extends ah> JuR;
  private final ah JuS;
  protected final boolean JuT;
  private final boolean JuU;
  protected final boolean JuV;
  public ab JuW;
  protected aj JuX;
  protected boolean JuY;
  protected r JuZ;
  protected r Jva;
  
  protected aa(l paraml, ah paramah, d.l.b.a.b.b.a.g paramg, w paramw, d.l.b.a.b.b.ba paramba, boolean paramBoolean1, f paramf, b.a parama, an paraman, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7)
  {
    super(paraml, paramg, paramf, paramBoolean1, paraman);
    AppMethodBeat.i(57216);
    this.JuR = null;
    this.Jtn = paramw;
    this.JtI = paramba;
    paraml = paramah;
    if (paramah == null) {
      paraml = this;
    }
    this.JuS = paraml;
    this.JtX = parama;
    this.JuT = paramBoolean2;
    this.JuU = paramBoolean3;
    this.JtN = paramBoolean4;
    this.JtO = paramBoolean5;
    this.Jtm = paramBoolean6;
    this.JuV = paramBoolean7;
    AppMethodBeat.o(57216);
  }
  
  private static d.l.b.a.b.b.ba a(d.l.b.a.b.b.ba paramba, b.a parama)
  {
    AppMethodBeat.i(57228);
    if ((parama == b.a.JpW) && (az.b(paramba.fzG())))
    {
      paramba = az.JqW;
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
      adP(7);
    }
    if (paramg == null) {
      adP(8);
    }
    if (paramw == null) {
      adP(9);
    }
    if (paramba == null) {
      adP(10);
    }
    if (paramf == null) {
      adP(11);
    }
    if (parama == null) {
      adP(12);
    }
    if (paraman == null) {
      adP(13);
    }
    paraml = new aa(paraml, null, paramg, paramw, paramba, true, paramf, parama, paraman, false, false, false, false, false, false);
    AppMethodBeat.o(57217);
    return paraml;
  }
  
  private static t a(d.l.b.a.b.m.ba paramba, ag paramag)
  {
    AppMethodBeat.i(57229);
    if (paramba == null) {
      adP(25);
    }
    if (paramag == null) {
      adP(26);
    }
    if (paramag.fyN() != null)
    {
      paramba = paramag.fyN().c(paramba);
      AppMethodBeat.o(57229);
      return paramba;
    }
    AppMethodBeat.o(57229);
    return null;
  }
  
  private a fAi()
  {
    AppMethodBeat.i(57226);
    a locala = new a();
    AppMethodBeat.o(57226);
    return locala;
  }
  
  protected final ah a(a parama)
  {
    AppMethodBeat.i(57227);
    Object localObject2 = parama.Jvb;
    Object localObject3 = parama.Jtn;
    Object localObject4 = parama.JtI;
    Object localObject5 = parama.JuS;
    Object localObject6 = parama.JtX;
    Object localObject7 = parama.JsQ;
    boolean bool1 = parama.Jum;
    Object localObject1 = parama.JuS;
    if (bool1) {
      if (localObject1 != null)
      {
        localObject1 = ((ah)localObject1).fxG();
        label70:
        if (localObject1 == null) {
          adP(23);
        }
        localObject5 = a((l)localObject2, (w)localObject3, (d.l.b.a.b.b.ba)localObject4, (ah)localObject5, (b.a)localObject6, (f)localObject7, (an)localObject1);
        if (parama.Juo != null) {
          break label187;
        }
      }
    }
    label187:
    for (localObject1 = fyn();; localObject1 = parama.Juo)
    {
      localObject3 = new ArrayList(((List)localObject1).size());
      localObject6 = d.l.b.a.b.m.p.a((List)localObject1, parama.Jud, (l)localObject5, (List)localObject3);
      localObject4 = ((d.l.b.a.b.m.ba)localObject6).c(fzr(), bh.JYE);
      if (localObject4 != null) {
        break label196;
      }
      AppMethodBeat.o(57227);
      return null;
      localObject1 = fzj();
      break;
      localObject1 = an.JqJ;
      break label70;
    }
    label196:
    localObject1 = parama.JtH;
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
    if (this.JtG != null)
    {
      localObject2 = ((d.l.b.a.b.m.ba)localObject6).c(this.JtG.fzr(), bh.JYD);
      if (localObject2 == null)
      {
        AppMethodBeat.o(57227);
        return null;
      }
      localObject2 = new ad((l)localObject5, new d.l.b.a.b.j.f.a.b((d.l.b.a.b.b.a)localObject5, (d.l.b.a.b.m.ab)localObject2, this.JtG.fzm()), this.JtG.fxF());
      ((aa)localObject5).a((d.l.b.a.b.m.ab)localObject4, (List)localObject3, (ak)localObject1, (ak)localObject2);
      if (this.JuW != null) {
        break label516;
      }
      localObject1 = null;
      if (localObject1 != null)
      {
        localObject2 = this.JuW.fyo();
        ((z)localObject1).JtY = a((d.l.b.a.b.m.ba)localObject6, this.JuW);
        if (localObject2 == null) {
          break label633;
        }
      }
    }
    label516:
    label633:
    for (localObject2 = ((d.l.b.a.b.m.ba)localObject6).c((d.l.b.a.b.m.ab)localObject2, bh.JYE);; localObject2 = null)
    {
      ((ab)localObject1).K((d.l.b.a.b.m.ab)localObject2);
      if (this.JuX != null) {
        break label639;
      }
      localObject2 = null;
      if (localObject2 == null) {
        break label796;
      }
      localObject4 = p.a((t)localObject2, this.JuX.fyq(), (d.l.b.a.b.m.ba)localObject6, false, false, null);
      localObject3 = localObject4;
      if (localObject4 == null)
      {
        ((aa)localObject5).JuY = true;
        localObject3 = Collections.singletonList(ac.a((aj)localObject2, d.l.b.a.b.j.d.a.G(parama.Jvb).fxa(), ((av)this.JuX.fyq().get(0)).fxF()));
      }
      if (((List)localObject3).size() == 1) {
        break label766;
      }
      parama = new IllegalStateException();
      AppMethodBeat.o(57227);
      throw parama;
      localObject2 = null;
      break;
      localObject2 = this.JuW.fxF();
      localObject3 = parama.Jtn;
      localObject4 = a(this.JuW.fxx(), parama.JtX);
      bool1 = this.JuW.isDefault;
      bool2 = this.JuW.Jtm;
      bool3 = this.JuW.JtL;
      localObject7 = parama.JtX;
      if (parama.JuS == null) {}
      for (localObject1 = null;; localObject1 = parama.JuS.fzg())
      {
        localObject1 = new ab((ah)localObject5, (d.l.b.a.b.b.a.g)localObject2, (w)localObject3, (d.l.b.a.b.b.ba)localObject4, bool1, bool2, bool3, (b.a)localObject7, (ai)localObject1, an.JqJ);
        break;
      }
    }
    label639:
    localObject3 = this.JuX.fxF();
    localObject4 = parama.Jtn;
    localObject7 = a(this.JuX.fxx(), parama.JtX);
    bool1 = this.JuX.isDefault();
    boolean bool2 = this.JuX.fxE();
    boolean bool3 = this.JuX.fxB();
    b.a locala = parama.JtX;
    if (parama.JuS == null) {}
    for (localObject2 = null;; localObject2 = parama.JuS.fzh())
    {
      localObject2 = new ac((ah)localObject5, (d.l.b.a.b.b.a.g)localObject3, (w)localObject4, (d.l.b.a.b.b.ba)localObject7, bool1, bool2, bool3, locala, (aj)localObject2, an.JqJ);
      break;
    }
    label766:
    ((z)localObject2).JtY = a((d.l.b.a.b.m.ba)localObject6, this.JuX);
    ((ac)localObject2).a((av)((List)localObject3).get(0));
    label796:
    if (this.JuZ == null)
    {
      localObject3 = null;
      if (this.Jva != null) {
        break label911;
      }
    }
    label911:
    for (localObject4 = null;; localObject4 = new o(this.Jva.fxF(), (ah)localObject5))
    {
      ((aa)localObject5).a((ab)localObject1, (aj)localObject2, (r)localObject3, (r)localObject4);
      if (!parama.Juk) {
        break label940;
      }
      parama = i.fKq();
      localObject1 = fys().iterator();
      while (((Iterator)localObject1).hasNext()) {
        parama.add(((ah)((Iterator)localObject1).next()).d((d.l.b.a.b.m.ba)localObject6));
      }
      localObject3 = new o(this.JuZ.fxF(), (ah)localObject5);
      break;
    }
    ((aa)localObject5).s(parama);
    label940:
    if ((fzA()) && (this.JvA != null)) {
      ((aa)localObject5).a(this.JvA);
    }
    AppMethodBeat.o(57227);
    return localObject5;
  }
  
  protected aa a(l paraml, w paramw, d.l.b.a.b.b.ba paramba, ah paramah, b.a parama, f paramf, an paraman)
  {
    AppMethodBeat.i(57230);
    if (paraml == null) {
      adP(27);
    }
    if (paramw == null) {
      adP(28);
    }
    if (paramba == null) {
      adP(29);
    }
    if (parama == null) {
      adP(30);
    }
    if (paramf == null) {
      adP(31);
    }
    if (paraman == null) {
      adP(32);
    }
    paraml = new aa(paraml, paramah, fxF(), paramw, paramba, this.Jvz, paramf, parama, paraman, this.JuT, fzA(), this.JtN, this.JtO, fxE(), this.JuV);
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
    this.JuW = paramab;
    this.JuX = paramaj;
    this.JuZ = paramr1;
    this.Jva = paramr2;
  }
  
  public final void a(d.l.b.a.b.m.ab paramab, List<? extends as> paramList, ak paramak1, ak paramak2)
  {
    AppMethodBeat.i(57218);
    if (paramab == null) {
      adP(14);
    }
    if (paramList == null) {
      adP(15);
    }
    N(paramab);
    this.Jqw = new ArrayList(paramList);
    this.JtG = paramak2;
    this.JtH = paramak1;
    AppMethodBeat.o(57218);
  }
  
  public final ah d(d.l.b.a.b.m.ba paramba)
  {
    AppMethodBeat.i(57225);
    if (paramba == null) {
      adP(22);
    }
    if (paramba.Jud.isEmpty())
    {
      AppMethodBeat.o(57225);
      return this;
    }
    a locala = fAi();
    paramba = paramba.fKb();
    if (paramba == null) {
      a.adP(13);
    }
    locala.Jud = paramba;
    paramba = locala.g(fzj()).fAk();
    AppMethodBeat.o(57225);
    return paramba;
  }
  
  public final boolean fxC()
  {
    return this.JtN;
  }
  
  public final boolean fxD()
  {
    return this.JtO;
  }
  
  public boolean fxE()
  {
    return this.Jtm;
  }
  
  public final w fxv()
  {
    AppMethodBeat.i(57222);
    w localw = this.Jtn;
    if (localw == null) {
      adP(19);
    }
    AppMethodBeat.o(57222);
    return localw;
  }
  
  public final d.l.b.a.b.b.ba fxx()
  {
    AppMethodBeat.i(57223);
    d.l.b.a.b.b.ba localba = this.JtI;
    if (localba == null) {
      adP(20);
    }
    AppMethodBeat.o(57223);
    return localba;
  }
  
  public final ak fyl()
  {
    return this.JtG;
  }
  
  public final ak fym()
  {
    return this.JtH;
  }
  
  public final List<as> fyn()
  {
    AppMethodBeat.i(57220);
    List localList = this.Jqw;
    if (localList == null) {
      adP(17);
    }
    AppMethodBeat.o(57220);
    return localList;
  }
  
  public final d.l.b.a.b.m.ab fyo()
  {
    AppMethodBeat.i(57221);
    d.l.b.a.b.m.ab localab = fzr();
    if (localab == null) {
      adP(18);
    }
    AppMethodBeat.o(57221);
    return localab;
  }
  
  public final Collection<? extends ah> fys()
  {
    AppMethodBeat.i(57235);
    if (this.JuR != null) {}
    for (Object localObject = this.JuR;; localObject = Collections.emptyList())
    {
      if (localObject == null) {
        adP(36);
      }
      AppMethodBeat.o(57235);
      return localObject;
    }
  }
  
  public final b.a fyu()
  {
    AppMethodBeat.i(57233);
    b.a locala = this.JtX;
    if (locala == null) {
      adP(34);
    }
    AppMethodBeat.o(57233);
    return locala;
  }
  
  public boolean fzA()
  {
    return this.JuU;
  }
  
  public final boolean fzB()
  {
    return this.JuT;
  }
  
  public final boolean fzC()
  {
    return this.JuV;
  }
  
  public final aj fzh()
  {
    return this.JuX;
  }
  
  public final List<ag> fzi()
  {
    AppMethodBeat.i(57224);
    ArrayList localArrayList = new ArrayList(2);
    if (this.JuW != null) {
      localArrayList.add(this.JuW);
    }
    if (this.JuX != null) {
      localArrayList.add(this.JuX);
    }
    AppMethodBeat.o(57224);
    return localArrayList;
  }
  
  public final ah fzj()
  {
    AppMethodBeat.i(57232);
    if (this.JuS == this) {}
    for (Object localObject = this;; localObject = this.JuS.fzj())
    {
      if (localObject == null) {
        adP(33);
      }
      AppMethodBeat.o(57232);
      return localObject;
    }
  }
  
  public final r fzk()
  {
    return this.JuZ;
  }
  
  public final r fzl()
  {
    return this.Jva;
  }
  
  public final void s(Collection<? extends d.l.b.a.b.b.b> paramCollection)
  {
    AppMethodBeat.i(57234);
    if (paramCollection == null) {
      adP(35);
    }
    this.JuR = paramCollection;
    AppMethodBeat.o(57234);
  }
  
  public final class a
  {
    f JsQ;
    ak JtH;
    d.l.b.a.b.b.ba JtI;
    b.a JtX;
    w Jtn;
    ah JuS;
    ay Jud;
    boolean Juk;
    boolean Jum;
    List<as> Juo;
    l Jvb;
    
    public a()
    {
      AppMethodBeat.i(57212);
      this.Jvb = aa.this.fxq();
      this.Jtn = aa.this.fxv();
      this.JtI = aa.this.fxx();
      this.JuS = null;
      this.Jum = false;
      this.JtX = aa.this.fyu();
      this.Jud = ay.JYp;
      this.Juk = true;
      this.JtH = aa.a(aa.this);
      this.Juo = null;
      this.JsQ = aa.this.fyB();
      AppMethodBeat.o(57212);
    }
    
    public final ah fAk()
    {
      AppMethodBeat.i(57214);
      ah localah = aa.this.a(this);
      AppMethodBeat.o(57214);
      return localah;
    }
    
    public final a g(d.l.b.a.b.b.b paramb)
    {
      AppMethodBeat.i(57213);
      this.JuS = ((ah)paramb);
      if (this == null) {
        adP(2);
      }
      AppMethodBeat.o(57213);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.b.c.aa
 * JD-Core Version:    0.7.0.1
 */