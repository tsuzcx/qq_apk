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
  private List<as> Thx;
  private ak TkJ;
  protected ak TkK;
  public kotlin.l.b.a.b.b.ba TkL;
  protected final boolean TkQ;
  private final boolean TkR;
  private final boolean Tkp;
  private final w Tkq;
  private Collection<? extends ah> TlU;
  private final ah TlV;
  protected final boolean TlW;
  private final boolean TlX;
  protected final boolean TlY;
  public ab TlZ;
  private final b.a Tla;
  protected aj Tma;
  protected boolean Tmb;
  protected r Tmc;
  protected r Tmd;
  
  protected aa(l paraml, ah paramah, kotlin.l.b.a.b.b.a.g paramg, w paramw, kotlin.l.b.a.b.b.ba paramba, boolean paramBoolean1, f paramf, b.a parama, an paraman, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7)
  {
    super(paraml, paramg, paramf, paramBoolean1, paraman);
    AppMethodBeat.i(57216);
    this.TlU = null;
    this.Tkq = paramw;
    this.TkL = paramba;
    paraml = paramah;
    if (paramah == null) {
      paraml = this;
    }
    this.TlV = paraml;
    this.Tla = parama;
    this.TlW = paramBoolean2;
    this.TlX = paramBoolean3;
    this.TkQ = paramBoolean4;
    this.TkR = paramBoolean5;
    this.Tkp = paramBoolean6;
    this.TlY = paramBoolean7;
    AppMethodBeat.o(57216);
  }
  
  private static kotlin.l.b.a.b.b.ba a(kotlin.l.b.a.b.b.ba paramba, b.a parama)
  {
    AppMethodBeat.i(57228);
    if ((parama == b.a.TgX) && (az.b(paramba.hBN())))
    {
      paramba = az.ThX;
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
      atM(7);
    }
    if (paramg == null) {
      atM(8);
    }
    if (paramw == null) {
      atM(9);
    }
    if (paramba == null) {
      atM(10);
    }
    if (paramf == null) {
      atM(11);
    }
    if (parama == null) {
      atM(12);
    }
    if (paraman == null) {
      atM(13);
    }
    paraml = new aa(paraml, null, paramg, paramw, paramba, true, paramf, parama, paraman, false, false, false, false, false, false);
    AppMethodBeat.o(57217);
    return paraml;
  }
  
  private static t a(kotlin.l.b.a.b.m.ba paramba, ag paramag)
  {
    AppMethodBeat.i(57229);
    if (paramba == null) {
      atM(25);
    }
    if (paramag == null) {
      atM(26);
    }
    if (paramag.hAU() != null)
    {
      paramba = paramag.hAU().c(paramba);
      AppMethodBeat.o(57229);
      return paramba;
    }
    AppMethodBeat.o(57229);
    return null;
  }
  
  private a hCp()
  {
    AppMethodBeat.i(57226);
    a locala = new a();
    AppMethodBeat.o(57226);
    return locala;
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
    Object localObject2 = parama.Tme;
    Object localObject3 = parama.Tkq;
    Object localObject4 = parama.TkL;
    Object localObject5 = parama.TlV;
    Object localObject6 = parama.Tla;
    Object localObject7 = parama.TjT;
    boolean bool1 = parama.Tlp;
    Object localObject1 = parama.TlV;
    if (bool1) {
      if (localObject1 != null)
      {
        localObject1 = ((ah)localObject1).hzM();
        label70:
        if (localObject1 == null) {
          atM(23);
        }
        localObject5 = a((l)localObject2, (w)localObject3, (kotlin.l.b.a.b.b.ba)localObject4, (ah)localObject5, (b.a)localObject6, (f)localObject7, (an)localObject1);
        if (parama.Tlr != null) {
          break label187;
        }
      }
    }
    label187:
    for (localObject1 = hAt();; localObject1 = parama.Tlr)
    {
      localObject3 = new ArrayList(((List)localObject1).size());
      localObject6 = kotlin.l.b.a.b.m.p.a((List)localObject1, parama.Tlg, (l)localObject5, (List)localObject3);
      localObject4 = ((kotlin.l.b.a.b.m.ba)localObject6).c(hBy(), bh.TOS);
      if (localObject4 != null) {
        break label196;
      }
      AppMethodBeat.o(57227);
      return null;
      localObject1 = hBq();
      break;
      localObject1 = an.ThK;
      break label70;
    }
    label196:
    localObject1 = parama.TkK;
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
    if (this.TkJ != null)
    {
      localObject2 = ((kotlin.l.b.a.b.m.ba)localObject6).c(this.TkJ.hBy(), bh.TOR);
      if (localObject2 == null)
      {
        AppMethodBeat.o(57227);
        return null;
      }
      localObject2 = new ad((l)localObject5, new kotlin.l.b.a.b.j.f.a.b((kotlin.l.b.a.b.b.a)localObject5, (kotlin.l.b.a.b.m.ab)localObject2, this.TkJ.hBt()), this.TkJ.hzL());
      ((aa)localObject5).a((kotlin.l.b.a.b.m.ab)localObject4, (List)localObject3, (ak)localObject1, (ak)localObject2);
      if (this.TlZ != null) {
        break label516;
      }
      localObject1 = null;
      if (localObject1 != null)
      {
        localObject2 = this.TlZ.hAu();
        ((z)localObject1).Tlb = a((kotlin.l.b.a.b.m.ba)localObject6, this.TlZ);
        if (localObject2 == null) {
          break label633;
        }
      }
    }
    label516:
    label633:
    for (localObject2 = ((kotlin.l.b.a.b.m.ba)localObject6).c((kotlin.l.b.a.b.m.ab)localObject2, bh.TOS);; localObject2 = null)
    {
      ((ab)localObject1).J((kotlin.l.b.a.b.m.ab)localObject2);
      if (this.Tma != null) {
        break label639;
      }
      localObject2 = null;
      if (localObject2 == null) {
        break label796;
      }
      localObject4 = p.a((t)localObject2, this.Tma.hAw(), (kotlin.l.b.a.b.m.ba)localObject6, false, false, null);
      localObject3 = localObject4;
      if (localObject4 == null)
      {
        ((aa)localObject5).Tmb = true;
        localObject3 = Collections.singletonList(ac.a((aj)localObject2, kotlin.l.b.a.b.j.d.a.G(parama.Tme).hzh(), ((av)this.Tma.hAw().get(0)).hzL()));
      }
      if (((List)localObject3).size() == 1) {
        break label766;
      }
      parama = new IllegalStateException();
      AppMethodBeat.o(57227);
      throw parama;
      localObject2 = null;
      break;
      localObject2 = this.TlZ.hzL();
      localObject3 = parama.Tkq;
      localObject4 = a(this.TlZ.hzE(), parama.Tla);
      bool1 = this.TlZ.isDefault;
      bool2 = this.TlZ.Tkp;
      bool3 = this.TlZ.TkO;
      localObject7 = parama.Tla;
      if (parama.TlV == null) {}
      for (localObject1 = null;; localObject1 = parama.TlV.hBn())
      {
        localObject1 = new ab((ah)localObject5, (kotlin.l.b.a.b.b.a.g)localObject2, (w)localObject3, (kotlin.l.b.a.b.b.ba)localObject4, bool1, bool2, bool3, (b.a)localObject7, (ai)localObject1, an.ThK);
        break;
      }
    }
    label639:
    localObject3 = this.Tma.hzL();
    localObject4 = parama.Tkq;
    localObject7 = a(this.Tma.hzE(), parama.Tla);
    bool1 = this.Tma.isDefault();
    boolean bool2 = this.Tma.isExternal();
    boolean bool3 = this.Tma.hzI();
    b.a locala = parama.Tla;
    if (parama.TlV == null) {}
    for (localObject2 = null;; localObject2 = parama.TlV.hBo())
    {
      localObject2 = new ac((ah)localObject5, (kotlin.l.b.a.b.b.a.g)localObject3, (w)localObject4, (kotlin.l.b.a.b.b.ba)localObject7, bool1, bool2, bool3, locala, (aj)localObject2, an.ThK);
      break;
    }
    label766:
    ((z)localObject2).Tlb = a((kotlin.l.b.a.b.m.ba)localObject6, this.Tma);
    ((ac)localObject2).a((av)((List)localObject3).get(0));
    label796:
    if (this.Tmc == null)
    {
      localObject3 = null;
      if (this.Tmd != null) {
        break label911;
      }
    }
    label911:
    for (localObject4 = null;; localObject4 = new o(this.Tmd.hzL(), (ah)localObject5))
    {
      ((aa)localObject5).a((ab)localObject1, (aj)localObject2, (r)localObject3, (r)localObject4);
      if (!parama.Tln) {
        break label940;
      }
      parama = i.hLZ();
      localObject1 = hAy().iterator();
      while (((Iterator)localObject1).hasNext()) {
        parama.add(((ah)((Iterator)localObject1).next()).d((kotlin.l.b.a.b.m.ba)localObject6));
      }
      localObject3 = new o(this.Tmc.hzL(), (ah)localObject5);
      break;
    }
    ((aa)localObject5).x(parama);
    label940:
    if ((hBH()) && (this.TmD != null)) {
      ((aa)localObject5).a(this.TmD);
    }
    AppMethodBeat.o(57227);
    return localObject5;
  }
  
  protected aa a(l paraml, w paramw, kotlin.l.b.a.b.b.ba paramba, ah paramah, b.a parama, f paramf, an paraman)
  {
    AppMethodBeat.i(57230);
    if (paraml == null) {
      atM(27);
    }
    if (paramw == null) {
      atM(28);
    }
    if (paramba == null) {
      atM(29);
    }
    if (parama == null) {
      atM(30);
    }
    if (paramf == null) {
      atM(31);
    }
    if (paraman == null) {
      atM(32);
    }
    paraml = new aa(paraml, paramah, hzL(), paramw, paramba, this.TmC, paramf, parama, paraman, this.TlW, hBH(), this.TkQ, this.TkR, isExternal(), this.TlY);
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
    this.TlZ = paramab;
    this.Tma = paramaj;
    this.Tmc = paramr1;
    this.Tmd = paramr2;
  }
  
  public final void a(kotlin.l.b.a.b.m.ab paramab, List<? extends as> paramList, ak paramak1, ak paramak2)
  {
    AppMethodBeat.i(57218);
    if (paramab == null) {
      atM(14);
    }
    if (paramList == null) {
      atM(15);
    }
    M(paramab);
    this.Thx = new ArrayList(paramList);
    this.TkJ = paramak2;
    this.TkK = paramak1;
    AppMethodBeat.o(57218);
  }
  
  public final ah d(kotlin.l.b.a.b.m.ba paramba)
  {
    AppMethodBeat.i(57225);
    if (paramba == null) {
      atM(22);
    }
    if (paramba.Tlg.isEmpty())
    {
      AppMethodBeat.o(57225);
      return this;
    }
    a locala = hCp();
    paramba = paramba.hLK();
    if (paramba == null) {
      a.atM(13);
    }
    locala.Tlg = paramba;
    paramba = locala.g(hBq()).hCr();
    AppMethodBeat.o(57225);
    return paramba;
  }
  
  public final b.a hAA()
  {
    AppMethodBeat.i(57233);
    b.a locala = this.Tla;
    if (locala == null) {
      atM(34);
    }
    AppMethodBeat.o(57233);
    return locala;
  }
  
  public final ak hAr()
  {
    return this.TkJ;
  }
  
  public final ak hAs()
  {
    return this.TkK;
  }
  
  public final List<as> hAt()
  {
    AppMethodBeat.i(57220);
    List localList = this.Thx;
    if (localList == null) {
      atM(17);
    }
    AppMethodBeat.o(57220);
    return localList;
  }
  
  public final kotlin.l.b.a.b.m.ab hAu()
  {
    AppMethodBeat.i(57221);
    kotlin.l.b.a.b.m.ab localab = hBy();
    if (localab == null) {
      atM(18);
    }
    AppMethodBeat.o(57221);
    return localab;
  }
  
  public final Collection<? extends ah> hAy()
  {
    AppMethodBeat.i(57235);
    if (this.TlU != null) {}
    for (Object localObject = this.TlU;; localObject = Collections.emptyList())
    {
      if (localObject == null) {
        atM(36);
      }
      AppMethodBeat.o(57235);
      return localObject;
    }
  }
  
  public boolean hBH()
  {
    return this.TlX;
  }
  
  public final boolean hBI()
  {
    return this.TlW;
  }
  
  public final boolean hBJ()
  {
    return this.TlY;
  }
  
  public final aj hBo()
  {
    return this.Tma;
  }
  
  public final List<ag> hBp()
  {
    AppMethodBeat.i(57224);
    ArrayList localArrayList = new ArrayList(2);
    if (this.TlZ != null) {
      localArrayList.add(this.TlZ);
    }
    if (this.Tma != null) {
      localArrayList.add(this.Tma);
    }
    AppMethodBeat.o(57224);
    return localArrayList;
  }
  
  public final ah hBq()
  {
    AppMethodBeat.i(57232);
    if (this.TlV == this) {}
    for (Object localObject = this;; localObject = this.TlV.hBq())
    {
      if (localObject == null) {
        atM(33);
      }
      AppMethodBeat.o(57232);
      return localObject;
    }
  }
  
  public final r hBr()
  {
    return this.Tmc;
  }
  
  public final r hBs()
  {
    return this.Tmd;
  }
  
  public final w hzC()
  {
    AppMethodBeat.i(57222);
    w localw = this.Tkq;
    if (localw == null) {
      atM(19);
    }
    AppMethodBeat.o(57222);
    return localw;
  }
  
  public final kotlin.l.b.a.b.b.ba hzE()
  {
    AppMethodBeat.i(57223);
    kotlin.l.b.a.b.b.ba localba = this.TkL;
    if (localba == null) {
      atM(20);
    }
    AppMethodBeat.o(57223);
    return localba;
  }
  
  public final boolean hzJ()
  {
    return this.TkQ;
  }
  
  public final boolean hzK()
  {
    return this.TkR;
  }
  
  public boolean isExternal()
  {
    return this.Tkp;
  }
  
  public final void x(Collection<? extends kotlin.l.b.a.b.b.b> paramCollection)
  {
    AppMethodBeat.i(57234);
    if (paramCollection == null) {
      atM(35);
    }
    this.TlU = paramCollection;
    AppMethodBeat.o(57234);
  }
  
  public final class a
  {
    f TjT;
    ak TkK;
    kotlin.l.b.a.b.b.ba TkL;
    w Tkq;
    ah TlV;
    b.a Tla;
    ay Tlg;
    boolean Tln;
    boolean Tlp;
    List<as> Tlr;
    l Tme;
    
    public a()
    {
      AppMethodBeat.i(57212);
      this.Tme = aa.this.hzx();
      this.Tkq = aa.this.hzC();
      this.TkL = aa.this.hzE();
      this.TlV = null;
      this.Tlp = false;
      this.Tla = aa.this.hAA();
      this.Tlg = ay.TOD;
      this.Tln = true;
      this.TkK = aa.a(aa.this);
      this.Tlr = null;
      this.TjT = aa.this.hAH();
      AppMethodBeat.o(57212);
    }
    
    public final a g(kotlin.l.b.a.b.b.b paramb)
    {
      AppMethodBeat.i(57213);
      this.TlV = ((ah)paramb);
      if (this == null) {
        atM(2);
      }
      AppMethodBeat.o(57213);
      return this;
    }
    
    public final ah hCr()
    {
      AppMethodBeat.i(57214);
      ah localah = aa.this.a(this);
      AppMethodBeat.o(57214);
      return localah;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.b.c.aa
 * JD-Core Version:    0.7.0.1
 */