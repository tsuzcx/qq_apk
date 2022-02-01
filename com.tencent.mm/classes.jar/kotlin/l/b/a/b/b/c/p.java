package kotlin.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.a.j;
import kotlin.l.b.a.b.b.a.a;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.a.i;
import kotlin.l.b.a.b.b.ak;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.ax;
import kotlin.l.b.a.b.b.az;
import kotlin.l.b.a.b.b.b.a;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.n;
import kotlin.l.b.a.b.b.t;
import kotlin.l.b.a.b.b.t.a;
import kotlin.l.b.a.b.b.w;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.ay;
import kotlin.l.b.a.b.m.bh;

public abstract class p
  extends k
  implements t
{
  private List<as> aaKr;
  private List<av> aaNB;
  private ab aaNC;
  private ak aaND;
  private ak aaNE;
  public kotlin.l.b.a.b.b.ba aaNF = az.aaKS;
  public boolean aaNG = false;
  public boolean aaNH = false;
  public boolean aaNI = false;
  public boolean aaNJ = false;
  public boolean aaNK = false;
  private boolean aaNL = false;
  boolean aaNM = false;
  boolean aaNN = false;
  public boolean aaNO = false;
  private boolean aaNP = true;
  private boolean aaNQ = false;
  private Collection<? extends t> aaNR = null;
  private volatile kotlin.g.a.a<Collection<t>> aaNS = null;
  private final t aaNT;
  private final b.a aaNU;
  private t aaNV = null;
  protected Map<a.a<?>, Object> aaNW = null;
  public boolean aaNj = false;
  private w aaNk;
  
  protected p(l paraml, t paramt, g paramg, f paramf, b.a parama, an paraman)
  {
    super(paraml, paramg, paramf, paraman);
    paraml = paramt;
    if (paramt == null) {
      paraml = this;
    }
    this.aaNT = paraml;
    this.aaNU = parama;
  }
  
  public static List<av> a(t paramt, List<av> paramList, kotlin.l.b.a.b.m.ba paramba, boolean paramBoolean1, boolean paramBoolean2, boolean[] paramArrayOfBoolean)
  {
    if (paramList == null) {
      aDG(28);
    }
    if (paramba == null) {
      aDG(29);
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      Object localObject3 = (av)localIterator.next();
      ab localab = paramba.c(((av)localObject3).iFN(), bh.abrq);
      Object localObject1 = ((av)localObject3).iFQ();
      if (localObject1 == null) {}
      for (paramList = null; localab == null; paramList = paramba.c((ab)localObject1, bh.abrq)) {
        return null;
      }
      if (((localab != ((av)localObject3).iFN()) || (localObject1 != paramList)) && (paramArrayOfBoolean != null)) {
        paramArrayOfBoolean[0] = true;
      }
      localObject1 = null;
      if ((localObject3 instanceof aj.b)) {
        localObject1 = new kotlin.g.a.a() {};
      }
      Object localObject2;
      label178:
      int i;
      g localg;
      f localf;
      boolean bool1;
      boolean bool2;
      boolean bool3;
      if (paramBoolean1)
      {
        localObject2 = null;
        i = ((av)localObject3).getIndex();
        localg = ((av)localObject3).iDY();
        localf = ((av)localObject3).iEU();
        bool1 = ((av)localObject3).iFP();
        bool2 = ((av)localObject3).iFS();
        bool3 = ((av)localObject3).iFT();
        if (!paramBoolean2) {
          break label289;
        }
      }
      label289:
      for (localObject3 = ((av)localObject3).iDZ();; localObject3 = an.aaKE)
      {
        localArrayList.add(aj.a(paramt, (av)localObject2, i, localg, localf, localab, bool1, bool2, bool3, paramList, (an)localObject3, (kotlin.g.a.a)localObject1));
        break;
        localObject2 = localObject3;
        break label178;
      }
    }
    return localArrayList;
  }
  
  public final void I(ab paramab)
  {
    if (paramab == null) {
      aDG(10);
    }
    this.aaNC = paramab;
  }
  
  public final void Jh(boolean paramBoolean)
  {
    this.aaNL = paramBoolean;
  }
  
  public void Ji(boolean paramBoolean)
  {
    this.aaNP = paramBoolean;
  }
  
  public void Jj(boolean paramBoolean)
  {
    this.aaNQ = paramBoolean;
  }
  
  public <V> V a(a.a<V> parama)
  {
    if (this.aaNW == null) {
      return null;
    }
    return this.aaNW.get(parama);
  }
  
  public <R, D> R a(n<R, D> paramn, D paramD)
  {
    return paramn.a(this, paramD);
  }
  
  public p a(ak paramak1, ak paramak2, List<? extends as> paramList, List<av> paramList1, ab paramab, w paramw, kotlin.l.b.a.b.b.ba paramba)
  {
    int k = 0;
    if (paramList == null) {
      aDG(5);
    }
    if (paramList1 == null) {
      aDG(6);
    }
    if (paramba == null) {
      aDG(7);
    }
    this.aaKr = j.p(paramList);
    this.aaNB = j.p(paramList1);
    this.aaNC = paramab;
    this.aaNk = paramw;
    this.aaNF = paramba;
    this.aaND = paramak1;
    this.aaNE = paramak2;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= paramList.size()) {
        break;
      }
      paramak1 = (as)paramList.get(i);
      if (paramak1.getIndex() != i) {
        throw new IllegalStateException(paramak1 + " index is " + paramak1.getIndex() + " but position is " + i);
      }
      i += 1;
    }
    do
    {
      j += 1;
      if (j >= paramList1.size()) {
        break;
      }
      paramak1 = (av)paramList1.get(j);
    } while (paramak1.getIndex() == j + 0);
    throw new IllegalStateException(paramak1 + "index is " + paramak1.getIndex() + " but position is " + j);
    if (this == null) {
      aDG(8);
    }
    return this;
  }
  
  protected abstract p a(l paraml, t paramt, b.a parama, f paramf, g paramg, an paraman);
  
  protected t a(a parama)
  {
    if (parama == null) {
      aDG(23);
    }
    Object localObject3 = new boolean[1];
    Object localObject1;
    Object localObject4;
    Object localObject5;
    Object localObject6;
    Object localObject7;
    Object localObject2;
    label78:
    label87:
    int j;
    if (parama.aaOm != null)
    {
      localObject1 = i.a(iDY(), parama.aaOm);
      localObject4 = parama.aaOb;
      localObject5 = parama.aaNT;
      localObject6 = parama.aaNU;
      localObject7 = parama.aaMN;
      boolean bool1 = parama.aaOj;
      localObject2 = parama.aaNT;
      if (!bool1) {
        break label214;
      }
      if (localObject2 == null) {
        break label205;
      }
      localObject2 = ((t)localObject2).iDZ();
      if (localObject2 == null) {
        aDG(25);
      }
      localObject4 = a((l)localObject4, (t)localObject5, (b.a)localObject6, (f)localObject7, (g)localObject1, (an)localObject2);
      if (parama.aaOl != null) {
        break label222;
      }
      localObject1 = iEG();
      label128:
      j = localObject3[0];
      if (((List)localObject1).isEmpty()) {
        break label231;
      }
    }
    label205:
    label214:
    label222:
    label231:
    for (int i = 1;; i = 0)
    {
      localObject3[0] = (i | j);
      localObject6 = new ArrayList(((List)localObject1).size());
      localObject5 = kotlin.l.b.a.b.m.p.a((List)localObject1, parama.aaOa, (l)localObject4, (List)localObject6, (boolean[])localObject3);
      if (localObject5 != null) {
        break label236;
      }
      localObject3 = null;
      return localObject3;
      localObject1 = iDY();
      break;
      localObject2 = iFh();
      break label78;
      localObject2 = an.aaKE;
      break label87;
      localObject1 = parama.aaOl;
      break label128;
    }
    label236:
    if (parama.aaOf != null)
    {
      localObject2 = ((kotlin.l.b.a.b.m.ba)localObject5).c(parama.aaOf.iFN(), bh.abrq);
      if (localObject2 == null) {
        return null;
      }
      localObject1 = new ad((l)localObject4, new kotlin.l.b.a.b.j.f.a.b((kotlin.l.b.a.b.b.a)localObject4, (ab)localObject2, parama.aaOf.iFI()), parama.aaOf.iDY());
      j = localObject3[0];
      if (localObject2 != parama.aaOf.iFN())
      {
        i = 1;
        localObject3[0] = (i | j);
      }
    }
    for (;;)
    {
      label330:
      if (parama.aaNE != null)
      {
        localObject2 = parama.aaNE.e((kotlin.l.b.a.b.m.ba)localObject5);
        if (localObject2 == null)
        {
          return null;
          i = 0;
          break label330;
        }
        j = localObject3[0];
        if (localObject2 != parama.aaNE)
        {
          i = 1;
          localObject3[0] = (i | j);
        }
      }
      for (;;)
      {
        label385:
        localObject7 = a((t)localObject4, parama.aaOe, (kotlin.l.b.a.b.m.ba)localObject5, parama.aaOk, parama.aaOj, (boolean[])localObject3);
        if (localObject7 == null)
        {
          return null;
          i = 0;
          break label385;
        }
        ab localab = ((kotlin.l.b.a.b.m.ba)localObject5).c(parama.aaOg, bh.abrr);
        if (localab == null) {
          return null;
        }
        j = localObject3[0];
        if (localab != parama.aaOg)
        {
          i = 1;
          localObject3[0] = (i | j);
          if (localObject3[0] == 0)
          {
            localObject3 = this;
            if (parama.aaOo) {
              break;
            }
          }
          ((p)localObject4).a((ak)localObject1, (ak)localObject2, (List)localObject6, (List)localObject7, localab, parama.aaOc, parama.aaOd);
          ((p)localObject4).aaNG = this.aaNG;
          ((p)localObject4).aaNH = this.aaNH;
          ((p)localObject4).aaNj = this.aaNj;
          ((p)localObject4).aaNI = this.aaNI;
          ((p)localObject4).aaNJ = this.aaNJ;
          ((p)localObject4).aaNO = this.aaNO;
          ((p)localObject4).aaNK = this.aaNK;
          ((p)localObject4).aaNL = this.aaNL;
          ((p)localObject4).Ji(this.aaNP);
          ((p)localObject4).aaNM = parama.aaNM;
          ((p)localObject4).aaNN = parama.aaNN;
          if (parama.aaOn == null) {
            break label749;
          }
        }
        label749:
        for (boolean bool2 = parama.aaOn.booleanValue();; bool2 = this.aaNQ)
        {
          ((p)localObject4).Jj(bool2);
          if ((parama.aaNW.isEmpty()) && (this.aaNW == null)) {
            break label810;
          }
          localObject1 = parama.aaNW;
          if (this.aaNW == null) {
            break label757;
          }
          localObject2 = this.aaNW.entrySet().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (Map.Entry)((Iterator)localObject2).next();
            if (!((Map)localObject1).containsKey(((Map.Entry)localObject3).getKey())) {
              ((Map)localObject1).put(((Map.Entry)localObject3).getKey(), ((Map.Entry)localObject3).getValue());
            }
          }
          i = 0;
          break;
        }
        label757:
        if (((Map)localObject1).size() == 1)
        {
          ((p)localObject4).aaNW = Collections.singletonMap(((Map)localObject1).keySet().iterator().next(), ((Map)localObject1).values().iterator().next());
          if ((parama.aaOi) || (this.aaNV != null))
          {
            if (this.aaNV == null) {
              break label913;
            }
            localObject1 = this.aaNV;
            ((p)localObject4).aaNV = ((t)localObject1).c((kotlin.l.b.a.b.m.ba)localObject5);
          }
          if ((parama.aaOh) && (!iFh().iEL().isEmpty()))
          {
            if (!parama.aaOa.isEmpty()) {
              break label931;
            }
            parama = this.aaNS;
            if (parama == null) {
              break label919;
            }
            ((p)localObject4).aaNS = parama;
          }
        }
        for (;;)
        {
          label810:
          label837:
          return localObject4;
          ((p)localObject4).aaNW = ((Map)localObject1);
          break;
          label913:
          localObject1 = this;
          break label837;
          label919:
          ((p)localObject4).v(iEL());
          continue;
          label931:
          ((p)localObject4).aaNS = new kotlin.g.a.a() {};
        }
        localObject2 = null;
      }
      localObject1 = null;
    }
  }
  
  public final <V> void a(a.a<V> parama, Object paramObject)
  {
    if (this.aaNW == null) {
      this.aaNW = new LinkedHashMap();
    }
    this.aaNW.put(parama, paramObject);
  }
  
  public t b(l paraml, w paramw, kotlin.l.b.a.b.b.ba paramba, b.a parama, boolean paramBoolean)
  {
    paraml = iFo().h(paraml).a(paramw).a(paramba).a(parama).Jg(paramBoolean).iFu();
    if (paraml == null) {
      aDG(24);
    }
    return paraml;
  }
  
  public t c(kotlin.l.b.a.b.m.ba paramba)
  {
    if (paramba == null) {
      aDG(20);
    }
    if (paramba.aaOa.isEmpty()) {
      return this;
    }
    return h(paramba).f(iFh()).iGs().iGt().iFu();
  }
  
  protected final a h(kotlin.l.b.a.b.m.ba paramba)
  {
    if (paramba == null) {
      aDG(22);
    }
    return new a(paramba.iQc(), iDJ(), iDO(), iDQ(), iEN(), iEJ(), this.aaND, iEH());
  }
  
  public final w iDO()
  {
    w localw = this.aaNk;
    if (localw == null) {
      aDG(13);
    }
    return localw;
  }
  
  public final kotlin.l.b.a.b.b.ba iDQ()
  {
    kotlin.l.b.a.b.b.ba localba = this.aaNF;
    if (localba == null) {
      aDG(14);
    }
    return localba;
  }
  
  public boolean iDU()
  {
    return this.aaNI;
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
    List localList = this.aaKr;
    if (localList == null) {
      aDG(16);
    }
    return localList;
  }
  
  public ab iEH()
  {
    return this.aaNC;
  }
  
  public final List<av> iEJ()
  {
    List localList = this.aaNB;
    if (localList == null) {
      aDG(17);
    }
    return localList;
  }
  
  public boolean iEK()
  {
    return this.aaNQ;
  }
  
  public Collection<? extends t> iEL()
  {
    Object localObject = this.aaNS;
    if (localObject != null)
    {
      this.aaNR = ((Collection)((kotlin.g.a.a)localObject).invoke());
      this.aaNS = null;
    }
    if (this.aaNR != null) {}
    for (localObject = this.aaNR;; localObject = Collections.emptyList())
    {
      if (localObject == null) {
        aDG(12);
      }
      return localObject;
    }
  }
  
  public final b.a iEN()
  {
    b.a locala = this.aaNU;
    if (locala == null) {
      aDG(19);
    }
    return locala;
  }
  
  public boolean iEk()
  {
    return this.aaNJ;
  }
  
  public t iFh()
  {
    if (this.aaNT == this) {}
    for (Object localObject = this;; localObject = this.aaNT.iFh())
    {
      if (localObject == null) {
        aDG(18);
      }
      return localObject;
    }
  }
  
  public final t iFi()
  {
    return this.aaNV;
  }
  
  public final boolean iFj()
  {
    return this.aaNM;
  }
  
  public final boolean iFk()
  {
    if (this.aaNG) {
      return true;
    }
    Iterator localIterator = iFh().iEL().iterator();
    while (localIterator.hasNext()) {
      if (((t)localIterator.next()).iFk()) {
        return true;
      }
    }
    return false;
  }
  
  public final boolean iFl()
  {
    if (this.aaNH) {
      return true;
    }
    Iterator localIterator = iFh().iEL().iterator();
    while (localIterator.hasNext()) {
      if (((t)localIterator.next()).iFl()) {
        return true;
      }
    }
    return false;
  }
  
  public final boolean iFm()
  {
    return this.aaNN;
  }
  
  public boolean iFn()
  {
    return this.aaNO;
  }
  
  public t.a<? extends t> iFo()
  {
    return h(kotlin.l.b.a.b.m.ba.abrf);
  }
  
  public boolean iGr()
  {
    return this.aaNP;
  }
  
  public void v(Collection<? extends kotlin.l.b.a.b.b.b> paramCollection)
  {
    if (paramCollection == null) {
      aDG(15);
    }
    this.aaNR = paramCollection;
    paramCollection = this.aaNR.iterator();
    while (paramCollection.hasNext()) {
      if (((t)paramCollection.next()).iFm()) {
        this.aaNN = true;
      }
    }
  }
  
  public final class a
    implements t.a<t>
  {
    protected f aaMN;
    protected ak aaNE;
    boolean aaNM;
    boolean aaNN;
    protected t aaNT;
    protected b.a aaNU;
    Map<a.a<?>, Object> aaNW;
    protected ay aaOa;
    protected l aaOb;
    protected w aaOc;
    protected kotlin.l.b.a.b.b.ba aaOd;
    protected List<av> aaOe;
    protected ak aaOf;
    protected ab aaOg;
    protected boolean aaOh;
    protected boolean aaOi;
    protected boolean aaOj;
    protected boolean aaOk;
    List<as> aaOl;
    g aaOm;
    public Boolean aaOn;
    protected boolean aaOo;
    
    public a(l paraml, w paramw, kotlin.l.b.a.b.b.ba paramba, b.a parama, List<av> paramList, ak paramak, ab paramab)
    {
      AppMethodBeat.i(57101);
      this.aaNT = null;
      this.aaNE = p.a(p.this);
      this.aaOh = true;
      this.aaOi = false;
      this.aaOj = false;
      this.aaOk = false;
      this.aaNM = p.this.aaNM;
      this.aaOl = null;
      this.aaOm = null;
      this.aaNN = p.this.aaNN;
      this.aaNW = new LinkedHashMap();
      this.aaOn = null;
      this.aaOo = false;
      this.aaOa = paraml;
      this.aaOb = paramw;
      this.aaOc = paramba;
      this.aaOd = parama;
      this.aaNU = paramList;
      this.aaOe = paramak;
      this.aaOf = paramab;
      this.aaOg = localObject;
      this.aaMN = null;
      AppMethodBeat.o(57101);
    }
    
    public final a f(kotlin.l.b.a.b.b.b paramb)
    {
      AppMethodBeat.i(57103);
      this.aaNT = ((t)paramb);
      if (this == null) {
        aDG(26);
      }
      AppMethodBeat.o(57103);
      return this;
    }
    
    public final t iFu()
    {
      AppMethodBeat.i(57104);
      t localt = p.this.a(this);
      AppMethodBeat.o(57104);
      return localt;
    }
    
    public final a iGs()
    {
      AppMethodBeat.i(258197);
      this.aaOj = true;
      if (this == null) {
        aDG(28);
      }
      AppMethodBeat.o(258197);
      return this;
    }
    
    public final a iGt()
    {
      AppMethodBeat.i(57105);
      this.aaOo = true;
      if (this == null) {
        aDG(39);
      }
      AppMethodBeat.o(57105);
      return this;
    }
    
    public final a ly(List<av> paramList)
    {
      AppMethodBeat.i(57102);
      if (paramList == null) {
        aDG(18);
      }
      this.aaOe = paramList;
      if (this == null) {
        aDG(19);
      }
      AppMethodBeat.o(57102);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.b.c.p
 * JD-Core Version:    0.7.0.1
 */