package kotlin.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.l.b.a.b.b.a.a;
import kotlin.l.b.a.b.b.ag;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.ai;
import kotlin.l.b.a.b.b.aj;
import kotlin.l.b.a.b.b.ak;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.az;
import kotlin.l.b.a.b.b.b.a;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.n;
import kotlin.l.b.a.b.b.r;
import kotlin.l.b.a.b.b.t;
import kotlin.l.b.a.b.b.w;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.m.ay;
import kotlin.l.b.a.b.m.bh;
import kotlin.l.b.a.b.o.i;

public class aa
  extends al
  implements ah
{
  private List<as> aaKr;
  private ak aaND;
  private ak aaNE;
  public kotlin.l.b.a.b.b.ba aaNF;
  private final boolean aaNK;
  private final boolean aaNL;
  private final b.a aaNU;
  private final boolean aaNj;
  private final w aaNk;
  private Collection<? extends ah> aaOO;
  private final ah aaOP;
  private final boolean aaOQ;
  private final boolean aaOR;
  private final boolean aaOS;
  public ab aaOT;
  private aj aaOU;
  private boolean aaOV;
  private r aaOW;
  private r aaOX;
  
  protected aa(l paraml, ah paramah, kotlin.l.b.a.b.b.a.g paramg, w paramw, kotlin.l.b.a.b.b.ba paramba, boolean paramBoolean1, f paramf, b.a parama, an paraman, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7)
  {
    super(paraml, paramg, paramf, paramBoolean1, paraman);
    AppMethodBeat.i(57216);
    this.aaOO = null;
    this.aaNk = paramw;
    this.aaNF = paramba;
    paraml = paramah;
    if (paramah == null) {
      paraml = this;
    }
    this.aaOP = paraml;
    this.aaNU = parama;
    this.aaOQ = paramBoolean2;
    this.aaOR = paramBoolean3;
    this.aaNK = paramBoolean4;
    this.aaNL = paramBoolean5;
    this.aaNj = paramBoolean6;
    this.aaOS = paramBoolean7;
    AppMethodBeat.o(57216);
  }
  
  private static kotlin.l.b.a.b.b.ba a(kotlin.l.b.a.b.b.ba paramba, b.a parama)
  {
    AppMethodBeat.i(57228);
    if ((parama == b.a.aaJR) && (az.b(paramba.iGc())))
    {
      paramba = az.aaKR;
      AppMethodBeat.o(57228);
      return paramba;
    }
    AppMethodBeat.o(57228);
    return paramba;
  }
  
  public static aa a(l paraml, kotlin.l.b.a.b.b.a.g paramg, w paramw, kotlin.l.b.a.b.b.ba paramba, f paramf, b.a parama, an paraman)
  {
    AppMethodBeat.i(57217);
    if (paraml == null) {
      aDG(7);
    }
    if (paramg == null) {
      aDG(8);
    }
    if (paramw == null) {
      aDG(9);
    }
    if (paramba == null) {
      aDG(10);
    }
    if (paramf == null) {
      aDG(11);
    }
    if (parama == null) {
      aDG(12);
    }
    if (paraman == null) {
      aDG(13);
    }
    paraml = new aa(paraml, null, paramg, paramw, paramba, true, paramf, parama, paraman, false, false, false, false, false, false);
    AppMethodBeat.o(57217);
    return paraml;
  }
  
  private static t a(kotlin.l.b.a.b.m.ba paramba, ag paramag)
  {
    AppMethodBeat.i(57229);
    if (paramba == null) {
      aDG(25);
    }
    if (paramag == null) {
      aDG(26);
    }
    if (paramag.iFi() != null)
    {
      paramba = paramag.iFi().c(paramba);
      AppMethodBeat.o(57229);
      return paramba;
    }
    AppMethodBeat.o(57229);
    return null;
  }
  
  private a iGF()
  {
    AppMethodBeat.i(57226);
    a locala = new a();
    AppMethodBeat.o(57226);
    return locala;
  }
  
  public final void Jl(boolean paramBoolean)
  {
    this.aaOV = paramBoolean;
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
  
  protected final ah a(a parama)
  {
    AppMethodBeat.i(57227);
    Object localObject2 = parama.aaOY;
    Object localObject3 = parama.aaNk;
    Object localObject4 = parama.aaNF;
    Object localObject5 = parama.aaOP;
    Object localObject6 = parama.aaNU;
    Object localObject7 = parama.aaMN;
    boolean bool1 = parama.aaOj;
    Object localObject1 = parama.aaOP;
    if (bool1) {
      if (localObject1 != null)
      {
        localObject1 = ((ah)localObject1).iDZ();
        label70:
        if (localObject1 == null) {
          aDG(23);
        }
        localObject5 = a((l)localObject2, (w)localObject3, (kotlin.l.b.a.b.b.ba)localObject4, (ah)localObject5, (b.a)localObject6, (f)localObject7, (an)localObject1);
        if (parama.aaOl != null) {
          break label187;
        }
      }
    }
    label187:
    for (localObject1 = iEG();; localObject1 = parama.aaOl)
    {
      localObject3 = new ArrayList(((List)localObject1).size());
      localObject6 = kotlin.l.b.a.b.m.p.a((List)localObject1, parama.aaOa, (l)localObject5, (List)localObject3);
      localObject4 = ((kotlin.l.b.a.b.m.ba)localObject6).c(iFN(), bh.abrr);
      if (localObject4 != null) {
        break label196;
      }
      AppMethodBeat.o(57227);
      return null;
      localObject1 = iFF();
      break;
      localObject1 = an.aaKE;
      break label70;
    }
    label196:
    localObject1 = parama.aaNE;
    if (localObject1 != null)
    {
      localObject2 = ((ak)localObject1).e((kotlin.l.b.a.b.m.ba)localObject6);
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
    if (this.aaND != null)
    {
      localObject2 = ((kotlin.l.b.a.b.m.ba)localObject6).c(this.aaND.iFN(), bh.abrq);
      if (localObject2 == null)
      {
        AppMethodBeat.o(57227);
        return null;
      }
      localObject2 = new ad((l)localObject5, new kotlin.l.b.a.b.j.f.a.b((kotlin.l.b.a.b.b.a)localObject5, (kotlin.l.b.a.b.m.ab)localObject2, this.aaND.iFI()), this.aaND.iDY());
      ((aa)localObject5).a((kotlin.l.b.a.b.m.ab)localObject4, (List)localObject3, (ak)localObject1, (ak)localObject2);
      if (this.aaOT != null) {
        break label516;
      }
      localObject1 = null;
      if (localObject1 != null)
      {
        localObject2 = this.aaOT.iEH();
        ((z)localObject1).aaNV = a((kotlin.l.b.a.b.m.ba)localObject6, this.aaOT);
        if (localObject2 == null) {
          break label633;
        }
      }
    }
    label516:
    label633:
    for (localObject2 = ((kotlin.l.b.a.b.m.ba)localObject6).c((kotlin.l.b.a.b.m.ab)localObject2, bh.abrr);; localObject2 = null)
    {
      ((ab)localObject1).J((kotlin.l.b.a.b.m.ab)localObject2);
      if (this.aaOU != null) {
        break label639;
      }
      localObject2 = null;
      if (localObject2 == null) {
        break label796;
      }
      localObject4 = p.a((t)localObject2, this.aaOU.iEJ(), (kotlin.l.b.a.b.m.ba)localObject6, false, false, null);
      localObject3 = localObject4;
      if (localObject4 == null)
      {
        ((aa)localObject5).aaOV = true;
        localObject3 = Collections.singletonList(ac.a((aj)localObject2, kotlin.l.b.a.b.j.d.a.G(parama.aaOY).iDt(), ((av)this.aaOU.iEJ().get(0)).iDY()));
      }
      if (((List)localObject3).size() == 1) {
        break label766;
      }
      parama = new IllegalStateException();
      AppMethodBeat.o(57227);
      throw parama;
      localObject2 = null;
      break;
      localObject2 = this.aaOT.iDY();
      localObject3 = parama.aaNk;
      localObject4 = a(this.aaOT.iDQ(), parama.aaNU);
      bool1 = this.aaOT.lJx;
      bool2 = this.aaOT.aaNj;
      bool3 = this.aaOT.aaNI;
      localObject7 = parama.aaNU;
      if (parama.aaOP == null) {}
      for (localObject1 = null;; localObject1 = parama.aaOP.iFC())
      {
        localObject1 = new ab((ah)localObject5, (kotlin.l.b.a.b.b.a.g)localObject2, (w)localObject3, (kotlin.l.b.a.b.b.ba)localObject4, bool1, bool2, bool3, (b.a)localObject7, (ai)localObject1, an.aaKE);
        break;
      }
    }
    label639:
    localObject3 = this.aaOU.iDY();
    localObject4 = parama.aaNk;
    localObject7 = a(this.aaOU.iDQ(), parama.aaNU);
    bool1 = this.aaOU.iFA();
    boolean bool2 = this.aaOU.iDX();
    boolean bool3 = this.aaOU.iDU();
    b.a locala = parama.aaNU;
    if (parama.aaOP == null) {}
    for (localObject2 = null;; localObject2 = parama.aaOP.iFD())
    {
      localObject2 = new ac((ah)localObject5, (kotlin.l.b.a.b.b.a.g)localObject3, (w)localObject4, (kotlin.l.b.a.b.b.ba)localObject7, bool1, bool2, bool3, locala, (aj)localObject2, an.aaKE);
      break;
    }
    label766:
    ((z)localObject2).aaNV = a((kotlin.l.b.a.b.m.ba)localObject6, this.aaOU);
    ((ac)localObject2).a((av)((List)localObject3).get(0));
    label796:
    if (this.aaOW == null)
    {
      localObject3 = null;
      if (this.aaOX != null) {
        break label911;
      }
    }
    label911:
    for (localObject4 = null;; localObject4 = new o(this.aaOX.iDY(), (ah)localObject5))
    {
      ((aa)localObject5).a((ab)localObject1, (aj)localObject2, (r)localObject3, (r)localObject4);
      if (!parama.aaOh) {
        break label940;
      }
      parama = i.iQq();
      localObject1 = iEL().iterator();
      while (((Iterator)localObject1).hasNext()) {
        parama.add(((ah)((Iterator)localObject1).next()).d((kotlin.l.b.a.b.m.ba)localObject6));
      }
      localObject3 = new o(this.aaOW.iDY(), (ah)localObject5);
      break;
    }
    ((aa)localObject5).v(parama);
    label940:
    if ((iFW()) && (this.aaPx != null)) {
      ((aa)localObject5).a(this.aaPx);
    }
    AppMethodBeat.o(57227);
    return localObject5;
  }
  
  protected aa a(l paraml, w paramw, kotlin.l.b.a.b.b.ba paramba, ah paramah, b.a parama, f paramf, an paraman)
  {
    AppMethodBeat.i(57230);
    if (paraml == null) {
      aDG(27);
    }
    if (paramw == null) {
      aDG(28);
    }
    if (paramba == null) {
      aDG(29);
    }
    if (parama == null) {
      aDG(30);
    }
    if (paramf == null) {
      aDG(31);
    }
    if (paraman == null) {
      aDG(32);
    }
    paraml = new aa(paraml, paramah, iDY(), paramw, paramba, iFU(), paramf, parama, paraman, this.aaOQ, iFW(), this.aaNK, this.aaNL, iDX(), this.aaOS);
    AppMethodBeat.o(57230);
    return paraml;
  }
  
  public final void a(ab paramab, aj paramaj)
  {
    AppMethodBeat.i(57219);
    a(paramab, paramaj, null, null);
    AppMethodBeat.o(57219);
  }
  
  public final void a(ab paramab, aj paramaj, r paramr1, r paramr2)
  {
    this.aaOT = paramab;
    this.aaOU = paramaj;
    this.aaOW = paramr1;
    this.aaOX = paramr2;
  }
  
  public final void a(kotlin.l.b.a.b.m.ab paramab, List<? extends as> paramList, ak paramak1, ak paramak2)
  {
    AppMethodBeat.i(57218);
    if (paramab == null) {
      aDG(14);
    }
    if (paramList == null) {
      aDG(15);
    }
    M(paramab);
    this.aaKr = new ArrayList(paramList);
    this.aaND = paramak2;
    this.aaNE = paramak1;
    AppMethodBeat.o(57218);
  }
  
  public final ah d(kotlin.l.b.a.b.m.ba paramba)
  {
    AppMethodBeat.i(57225);
    if (paramba == null) {
      aDG(22);
    }
    if (paramba.aaOa.isEmpty())
    {
      AppMethodBeat.o(57225);
      return this;
    }
    a locala = iGF();
    paramba = paramba.iQc();
    if (paramba == null) {
      a.aDG(13);
    }
    locala.aaOa = paramba;
    paramba = locala.g(iFF()).iGH();
    AppMethodBeat.o(57225);
    return paramba;
  }
  
  public final w iDO()
  {
    AppMethodBeat.i(57222);
    w localw = this.aaNk;
    if (localw == null) {
      aDG(19);
    }
    AppMethodBeat.o(57222);
    return localw;
  }
  
  public final kotlin.l.b.a.b.b.ba iDQ()
  {
    AppMethodBeat.i(57223);
    kotlin.l.b.a.b.b.ba localba = this.aaNF;
    if (localba == null) {
      aDG(20);
    }
    AppMethodBeat.o(57223);
    return localba;
  }
  
  public final boolean iDV()
  {
    return this.aaNK;
  }
  
  public final boolean iDW()
  {
    return this.aaNL;
  }
  
  public boolean iDX()
  {
    return this.aaNj;
  }
  
  public final ak iEE()
  {
    return this.aaND;
  }
  
  public final ak iEF()
  {
    return this.aaNE;
  }
  
  public final List<as> iEG()
  {
    AppMethodBeat.i(57220);
    List localList = this.aaKr;
    if (localList == null) {
      aDG(17);
    }
    AppMethodBeat.o(57220);
    return localList;
  }
  
  public final kotlin.l.b.a.b.m.ab iEH()
  {
    AppMethodBeat.i(57221);
    kotlin.l.b.a.b.m.ab localab = iFN();
    if (localab == null) {
      aDG(18);
    }
    AppMethodBeat.o(57221);
    return localab;
  }
  
  public final Collection<? extends ah> iEL()
  {
    AppMethodBeat.i(57235);
    if (this.aaOO != null) {}
    for (Object localObject = this.aaOO;; localObject = Collections.emptyList())
    {
      if (localObject == null) {
        aDG(36);
      }
      AppMethodBeat.o(57235);
      return localObject;
    }
  }
  
  public final b.a iEN()
  {
    AppMethodBeat.i(57233);
    b.a locala = this.aaNU;
    if (locala == null) {
      aDG(34);
    }
    AppMethodBeat.o(57233);
    return locala;
  }
  
  public final aj iFD()
  {
    return this.aaOU;
  }
  
  public final List<ag> iFE()
  {
    AppMethodBeat.i(57224);
    ArrayList localArrayList = new ArrayList(2);
    if (this.aaOT != null) {
      localArrayList.add(this.aaOT);
    }
    if (this.aaOU != null) {
      localArrayList.add(this.aaOU);
    }
    AppMethodBeat.o(57224);
    return localArrayList;
  }
  
  public final ah iFF()
  {
    AppMethodBeat.i(57232);
    if (this.aaOP == this) {}
    for (Object localObject = this;; localObject = this.aaOP.iFF())
    {
      if (localObject == null) {
        aDG(33);
      }
      AppMethodBeat.o(57232);
      return localObject;
    }
  }
  
  public final r iFG()
  {
    return this.aaOW;
  }
  
  public final r iFH()
  {
    return this.aaOX;
  }
  
  public boolean iFW()
  {
    return this.aaOR;
  }
  
  public final boolean iFX()
  {
    return this.aaOQ;
  }
  
  public final boolean iFY()
  {
    return this.aaOS;
  }
  
  public final boolean iGE()
  {
    return this.aaOV;
  }
  
  public final void v(Collection<? extends kotlin.l.b.a.b.b.b> paramCollection)
  {
    AppMethodBeat.i(57234);
    if (paramCollection == null) {
      aDG(35);
    }
    this.aaOO = paramCollection;
    AppMethodBeat.o(57234);
  }
  
  public final class a
  {
    f aaMN;
    ak aaNE;
    kotlin.l.b.a.b.b.ba aaNF;
    b.a aaNU;
    w aaNk;
    ah aaOP;
    l aaOY;
    ay aaOa;
    boolean aaOh;
    boolean aaOj;
    List<as> aaOl;
    
    public a()
    {
      AppMethodBeat.i(57212);
      this.aaOY = aa.this.iDJ();
      this.aaNk = aa.this.iDO();
      this.aaNF = aa.this.iDQ();
      this.aaOP = null;
      this.aaOj = false;
      this.aaNU = aa.this.iEN();
      this.aaOa = ay.abrd;
      this.aaOh = true;
      this.aaNE = aa.a(aa.this);
      this.aaOl = null;
      this.aaMN = aa.this.iEU();
      AppMethodBeat.o(57212);
    }
    
    public final a g(kotlin.l.b.a.b.b.b paramb)
    {
      AppMethodBeat.i(57213);
      this.aaOP = ((ah)paramb);
      if (this == null) {
        aDG(2);
      }
      AppMethodBeat.o(57213);
      return this;
    }
    
    public final ah iGH()
    {
      AppMethodBeat.i(57214);
      ah localah = aa.this.a(this);
      AppMethodBeat.o(57214);
      return localah;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.b.c.aa
 * JD-Core Version:    0.7.0.1
 */