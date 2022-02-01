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
import kotlin.l.b.a.b.b.a.a;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.a.i;
import kotlin.l.b.a.b.b.ab;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.b.a;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.bd;
import kotlin.l.b.a.b.b.bf;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.n;
import kotlin.l.b.a.b.b.s;
import kotlin.l.b.a.b.b.t;
import kotlin.l.b.a.b.b.x;
import kotlin.l.b.a.b.b.x.a;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.bc;
import kotlin.l.b.a.b.m.be;
import kotlin.l.b.a.b.m.bl;
import kotlin.l.b.a.b.m.q;

public abstract class p
  extends k
  implements x
{
  public boolean aiJU = false;
  private ab aiJV;
  private boolean aiKA = true;
  private boolean aiKB = false;
  private Collection<? extends x> aiKC = null;
  private volatile kotlin.g.a.a<Collection<x>> aiKD = null;
  private final x aiKE;
  private final b.a aiKF;
  private x aiKG = null;
  protected Map<a.a<?>, Object> aiKH = null;
  private List<ba> aiKl;
  private List<bd> aiKm;
  private ad aiKn;
  private as aiKo;
  private as aiKp;
  public t aiKq = s.aiGK;
  public boolean aiKr = false;
  public boolean aiKs = false;
  public boolean aiKt = false;
  public boolean aiKu = false;
  public boolean aiKv = false;
  private boolean aiKw = false;
  boolean aiKx = false;
  boolean aiKy = false;
  public boolean aiKz = false;
  
  protected p(l paraml, x paramx, g paramg, f paramf, b.a parama, av paramav)
  {
    super(paraml, paramg, paramf, paramav);
    paraml = paramx;
    if (paramx == null) {
      paraml = this;
    }
    this.aiKE = paraml;
    this.aiKF = parama;
  }
  
  public static List<bd> a(x paramx, List<bd> paramList, be parambe, boolean paramBoolean1, boolean paramBoolean2, boolean[] paramArrayOfBoolean)
  {
    if (paramList == null) {
      aKu(28);
    }
    if (parambe == null) {
      aKu(29);
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      Object localObject3 = (bd)localIterator.next();
      ad localad = parambe.c(((bd)localObject3).koG(), bl.ajqN);
      Object localObject1 = ((bd)localObject3).kpq();
      if (localObject1 == null) {}
      for (paramList = null; localad == null; paramList = parambe.c((ad)localObject1, bl.ajqN)) {
        return null;
      }
      if (((localad != ((bd)localObject3).koG()) || (localObject1 != paramList)) && (paramArrayOfBoolean != null)) {
        paramArrayOfBoolean[0] = true;
      }
      localObject1 = null;
      if ((localObject3 instanceof ak.b)) {
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
        i = ((bd)localObject3).getIndex();
        localg = ((bd)localObject3).knl();
        localf = ((bd)localObject3).kok();
        bool1 = ((bd)localObject3).kpp();
        bool2 = ((bd)localObject3).kps();
        bool3 = ((bd)localObject3).kpt();
        if (!paramBoolean2) {
          break label289;
        }
      }
      label289:
      for (localObject3 = ((bd)localObject3).knm();; localObject3 = av.aiHu)
      {
        localArrayList.add(ak.a(paramx, (bd)localObject2, i, localg, localf, localad, bool1, bool2, bool3, paramList, (av)localObject3, (kotlin.g.a.a)localObject1));
        break;
        localObject2 = localObject3;
        break label178;
      }
    }
    return localArrayList;
  }
  
  public final void B(ad paramad)
  {
    if (paramad == null) {
      aKu(10);
    }
    this.aiKn = paramad;
  }
  
  public void M(Collection<? extends kotlin.l.b.a.b.b.b> paramCollection)
  {
    if (paramCollection == null) {
      aKu(15);
    }
    this.aiKC = paramCollection;
    paramCollection = this.aiKC.iterator();
    while (paramCollection.hasNext()) {
      if (((x)paramCollection.next()).koM()) {
        this.aiKy = true;
      }
    }
  }
  
  public final void Pk(boolean paramBoolean)
  {
    this.aiKw = paramBoolean;
  }
  
  public void Pl(boolean paramBoolean)
  {
    this.aiKA = paramBoolean;
  }
  
  public void Pm(boolean paramBoolean)
  {
    this.aiKB = paramBoolean;
  }
  
  public <V> V a(a.a<V> parama)
  {
    if (this.aiKH == null) {
      return null;
    }
    return this.aiKH.get(parama);
  }
  
  public <R, D> R a(n<R, D> paramn, D paramD)
  {
    return paramn.a(this, paramD);
  }
  
  public p a(as paramas1, as paramas2, List<? extends ba> paramList, List<bd> paramList1, ad paramad, ab paramab, t paramt)
  {
    int k = 0;
    if (paramList == null) {
      aKu(5);
    }
    if (paramList1 == null) {
      aKu(6);
    }
    if (paramt == null) {
      aKu(7);
    }
    this.aiKl = kotlin.a.p.p(paramList);
    this.aiKm = kotlin.a.p.p(paramList1);
    this.aiKn = paramad;
    this.aiJV = paramab;
    this.aiKq = paramt;
    this.aiKo = paramas1;
    this.aiKp = paramas2;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= paramList.size()) {
        break;
      }
      paramas1 = (ba)paramList.get(i);
      if (paramas1.getIndex() != i) {
        throw new IllegalStateException(paramas1 + " index is " + paramas1.getIndex() + " but position is " + i);
      }
      i += 1;
    }
    do
    {
      j += 1;
      if (j >= paramList1.size()) {
        break;
      }
      paramas1 = (bd)paramList1.get(j);
    } while (paramas1.getIndex() == j + 0);
    throw new IllegalStateException(paramas1 + "index is " + paramas1.getIndex() + " but position is " + j);
    if (this == null) {
      aKu(8);
    }
    return this;
  }
  
  protected abstract p a(l paraml, x paramx, b.a parama, f paramf, g paramg, av paramav);
  
  protected x a(a parama)
  {
    if (parama == null) {
      aKu(23);
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
    if (parama.aiKX != null)
    {
      localObject1 = i.a(knl(), parama.aiKX);
      localObject4 = parama.aiKM;
      localObject5 = parama.aiKE;
      localObject6 = parama.aiKF;
      localObject7 = parama.aiJy;
      boolean bool1 = parama.aiKU;
      localObject2 = parama.aiKE;
      if (!bool1) {
        break label214;
      }
      if (localObject2 == null) {
        break label205;
      }
      localObject2 = ((x)localObject2).knm();
      if (localObject2 == null) {
        aKu(25);
      }
      localObject4 = a((l)localObject4, (x)localObject5, (b.a)localObject6, (f)localObject7, (g)localObject1, (av)localObject2);
      if (parama.aiKW != null) {
        break label222;
      }
      localObject1 = koa();
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
      localObject5 = q.a((List)localObject1, parama.aiKL, (l)localObject4, (List)localObject6, (boolean[])localObject3);
      if (localObject5 != null) {
        break label236;
      }
      localObject3 = null;
      return localObject3;
      localObject1 = knl();
      break;
      localObject2 = koH();
      break label78;
      localObject2 = av.aiHu;
      break label87;
      localObject1 = parama.aiKW;
      break label128;
    }
    label236:
    if (parama.aiKQ != null)
    {
      localObject2 = ((be)localObject5).c(parama.aiKQ.koG(), bl.ajqN);
      if (localObject2 == null) {
        return null;
      }
      localObject1 = new ae((l)localObject4, new kotlin.l.b.a.b.j.g.a.b((kotlin.l.b.a.b.b.a)localObject4, (ad)localObject2, parama.aiKQ.kpi()), parama.aiKQ.knl());
      j = localObject3[0];
      if (localObject2 != parama.aiKQ.koG())
      {
        i = 1;
        localObject3[0] = (i | j);
      }
    }
    for (;;)
    {
      label330:
      if (parama.aiKp != null)
      {
        localObject2 = parama.aiKp.e((be)localObject5);
        if (localObject2 == null)
        {
          return null;
          i = 0;
          break label330;
        }
        j = localObject3[0];
        if (localObject2 != parama.aiKp)
        {
          i = 1;
          localObject3[0] = (i | j);
        }
      }
      for (;;)
      {
        label385:
        localObject7 = a((x)localObject4, parama.aiKP, (be)localObject5, parama.aiKV, parama.aiKU, (boolean[])localObject3);
        if (localObject7 == null)
        {
          return null;
          i = 0;
          break label385;
        }
        ad localad = ((be)localObject5).c(parama.aiKR, bl.ajqO);
        if (localad == null) {
          return null;
        }
        j = localObject3[0];
        if (localad != parama.aiKR)
        {
          i = 1;
          localObject3[0] = (i | j);
          if (localObject3[0] == 0)
          {
            localObject3 = this;
            if (parama.aiKZ) {
              break;
            }
          }
          ((p)localObject4).a((as)localObject1, (as)localObject2, (List)localObject6, (List)localObject7, localad, parama.aiKN, parama.aiKO);
          ((p)localObject4).aiKr = this.aiKr;
          ((p)localObject4).aiKs = this.aiKs;
          ((p)localObject4).aiJU = this.aiJU;
          ((p)localObject4).aiKt = this.aiKt;
          ((p)localObject4).aiKu = this.aiKu;
          ((p)localObject4).aiKz = this.aiKz;
          ((p)localObject4).aiKv = this.aiKv;
          ((p)localObject4).aiKw = this.aiKw;
          ((p)localObject4).Pl(this.aiKA);
          ((p)localObject4).aiKx = parama.aiKx;
          ((p)localObject4).aiKy = parama.aiKy;
          if (parama.aiKY == null) {
            break label749;
          }
        }
        label749:
        for (boolean bool2 = parama.aiKY.booleanValue();; bool2 = this.aiKB)
        {
          ((p)localObject4).Pm(bool2);
          if ((parama.aiKH.isEmpty()) && (this.aiKH == null)) {
            break label810;
          }
          localObject1 = parama.aiKH;
          if (this.aiKH == null) {
            break label757;
          }
          localObject2 = this.aiKH.entrySet().iterator();
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
          ((p)localObject4).aiKH = Collections.singletonMap(((Map)localObject1).keySet().iterator().next(), ((Map)localObject1).values().iterator().next());
          if ((parama.aiKT) || (this.aiKG != null))
          {
            if (this.aiKG == null) {
              break label913;
            }
            localObject1 = this.aiKG;
            ((p)localObject4).aiKG = ((x)localObject1).c((be)localObject5);
          }
          if ((parama.aiKS) && (!koH().kof().isEmpty()))
          {
            if (!parama.aiKL.isEmpty()) {
              break label931;
            }
            parama = this.aiKD;
            if (parama == null) {
              break label919;
            }
            ((p)localObject4).aiKD = parama;
          }
        }
        for (;;)
        {
          label810:
          label837:
          return localObject4;
          ((p)localObject4).aiKH = ((Map)localObject1);
          break;
          label913:
          localObject1 = this;
          break label837;
          label919:
          ((p)localObject4).M(kof());
          continue;
          label931:
          ((p)localObject4).aiKD = new kotlin.g.a.a() {};
        }
        localObject2 = null;
      }
      localObject1 = null;
    }
  }
  
  public final <V> void a(a.a<V> parama, Object paramObject)
  {
    if (this.aiKH == null) {
      this.aiKH = new LinkedHashMap();
    }
    this.aiKH.put(parama, paramObject);
  }
  
  public x b(l paraml, ab paramab, t paramt, b.a parama, boolean paramBoolean)
  {
    paraml = koO().h(paraml).a(paramab).d(paramt).a(parama).Pj(paramBoolean).koU();
    if (paraml == null) {
      aKu(24);
    }
    return paraml;
  }
  
  public x c(be parambe)
  {
    if (parambe == null) {
      aKu(20);
    }
    if (parambe.aiKL.isEmpty()) {
      return this;
    }
    return h(parambe).f(koH()).kpP().kpQ().koU();
  }
  
  protected final a h(be parambe)
  {
    if (parambe == null) {
      aKu(22);
    }
    return new a(parambe.kAR(), knp(), knb(), knc(), koh(), kod(), this.aiKo, kob());
  }
  
  public boolean knC()
  {
    return this.aiKu;
  }
  
  public final as knY()
  {
    return this.aiKo;
  }
  
  public final as knZ()
  {
    return this.aiKp;
  }
  
  public final ab knb()
  {
    ab localab = this.aiJV;
    if (localab == null) {
      aKu(13);
    }
    return localab;
  }
  
  public final t knc()
  {
    t localt = this.aiKq;
    if (localt == null) {
      aKu(14);
    }
    return localt;
  }
  
  public boolean kng()
  {
    return this.aiKt;
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
  
  public x koH()
  {
    if (this.aiKE == this) {}
    for (Object localObject = this;; localObject = this.aiKE.koH())
    {
      if (localObject == null) {
        aKu(18);
      }
      return localObject;
    }
  }
  
  public final x koI()
  {
    return this.aiKG;
  }
  
  public final boolean koJ()
  {
    return this.aiKx;
  }
  
  public final boolean koK()
  {
    if (this.aiKr) {
      return true;
    }
    Iterator localIterator = koH().kof().iterator();
    while (localIterator.hasNext()) {
      if (((x)localIterator.next()).koK()) {
        return true;
      }
    }
    return false;
  }
  
  public final boolean koL()
  {
    if (this.aiKs) {
      return true;
    }
    Iterator localIterator = koH().kof().iterator();
    while (localIterator.hasNext()) {
      if (((x)localIterator.next()).koL()) {
        return true;
      }
    }
    return false;
  }
  
  public final boolean koM()
  {
    return this.aiKy;
  }
  
  public boolean koN()
  {
    return this.aiKz;
  }
  
  public x.a<? extends x> koO()
  {
    a locala = h(be.ajqz);
    if (locala == null) {
      aKu(21);
    }
    return locala;
  }
  
  public final List<ba> koa()
  {
    List localList = this.aiKl;
    if (localList == null) {
      throw new IllegalStateException("typeParameters == null for ".concat(String.valueOf(this)));
    }
    if (localList == null) {
      aKu(16);
    }
    return localList;
  }
  
  public ad kob()
  {
    return this.aiKn;
  }
  
  public final List<bd> kod()
  {
    List localList = this.aiKm;
    if (localList == null) {
      aKu(17);
    }
    return localList;
  }
  
  public boolean koe()
  {
    return this.aiKB;
  }
  
  public Collection<? extends x> kof()
  {
    Object localObject = this.aiKD;
    if (localObject != null)
    {
      this.aiKC = ((Collection)((kotlin.g.a.a)localObject).invoke());
      this.aiKD = null;
    }
    if (this.aiKC != null) {}
    for (localObject = this.aiKC;; localObject = Collections.emptyList())
    {
      if (localObject == null) {
        aKu(12);
      }
      return localObject;
    }
  }
  
  public final b.a koh()
  {
    b.a locala = this.aiKF;
    if (locala == null) {
      aKu(19);
    }
    return locala;
  }
  
  public boolean kpO()
  {
    return this.aiKA;
  }
  
  public final class a
    implements x.a<x>
  {
    protected f aiJy;
    protected x aiKE;
    protected b.a aiKF;
    Map<a.a<?>, Object> aiKH;
    protected bc aiKL;
    protected l aiKM;
    protected ab aiKN;
    protected t aiKO;
    protected List<bd> aiKP;
    protected as aiKQ;
    protected ad aiKR;
    protected boolean aiKS;
    protected boolean aiKT;
    protected boolean aiKU;
    protected boolean aiKV;
    List<ba> aiKW;
    g aiKX;
    public Boolean aiKY;
    protected boolean aiKZ;
    protected as aiKp;
    boolean aiKx;
    boolean aiKy;
    
    public a(l paraml, ab paramab, t paramt, b.a parama, List<bd> paramList, as paramas, ad paramad)
    {
      AppMethodBeat.i(191874);
      this.aiKE = null;
      this.aiKp = p.a(p.this);
      this.aiKS = true;
      this.aiKT = false;
      this.aiKU = false;
      this.aiKV = false;
      this.aiKx = p.this.aiKx;
      this.aiKW = null;
      this.aiKX = null;
      this.aiKy = p.this.aiKy;
      this.aiKH = new LinkedHashMap();
      this.aiKY = null;
      this.aiKZ = false;
      this.aiKL = paraml;
      this.aiKM = paramab;
      this.aiKN = paramt;
      this.aiKO = parama;
      this.aiKF = paramList;
      this.aiKP = paramas;
      this.aiKQ = paramad;
      this.aiKR = localObject;
      this.aiJy = null;
      AppMethodBeat.o(191874);
    }
    
    public final a f(kotlin.l.b.a.b.b.b paramb)
    {
      AppMethodBeat.i(57103);
      this.aiKE = ((x)paramb);
      if (this == null) {
        aKu(26);
      }
      AppMethodBeat.o(57103);
      return this;
    }
    
    public final x koU()
    {
      AppMethodBeat.i(57104);
      x localx = p.this.a(this);
      AppMethodBeat.o(57104);
      return localx;
    }
    
    public final a kpP()
    {
      AppMethodBeat.i(191886);
      this.aiKU = true;
      if (this == null) {
        aKu(28);
      }
      AppMethodBeat.o(191886);
      return this;
    }
    
    public final a kpQ()
    {
      AppMethodBeat.i(57105);
      this.aiKZ = true;
      if (this == null) {
        aKu(39);
      }
      AppMethodBeat.o(57105);
      return this;
    }
    
    public final a oW(List<bd> paramList)
    {
      AppMethodBeat.i(57102);
      if (paramList == null) {
        aKu(18);
      }
      this.aiKP = paramList;
      if (this == null) {
        aKu(19);
      }
      AppMethodBeat.o(57102);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.c.p
 * JD-Core Version:    0.7.0.1
 */