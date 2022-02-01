package d.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.l.b.a.b.b.a.a;
import d.l.b.a.b.b.a.g;
import d.l.b.a.b.b.a.i;
import d.l.b.a.b.b.ak;
import d.l.b.a.b.b.an;
import d.l.b.a.b.b.as;
import d.l.b.a.b.b.av;
import d.l.b.a.b.b.ax;
import d.l.b.a.b.b.az;
import d.l.b.a.b.b.b.a;
import d.l.b.a.b.b.l;
import d.l.b.a.b.b.n;
import d.l.b.a.b.b.t;
import d.l.b.a.b.b.t.a;
import d.l.b.a.b.b.w;
import d.l.b.a.b.f.f;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.ay;
import d.l.b.a.b.m.bh;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class p
  extends k
  implements t
{
  private List<as> LdP;
  public boolean LgF = false;
  private w LgG;
  private List<av> LgX;
  private ab LgY;
  private ak LgZ;
  protected ak Lha;
  public d.l.b.a.b.b.ba Lhb = az.Leq;
  public boolean Lhc = false;
  public boolean Lhd = false;
  public boolean Lhe = false;
  public boolean Lhf = false;
  public boolean Lhg = false;
  boolean Lhh = false;
  boolean Lhi = false;
  boolean Lhj = false;
  public boolean Lhk = false;
  private boolean Lhl = true;
  private boolean Lhm = false;
  private Collection<? extends t> Lhn = null;
  private volatile d.g.a.a<Collection<t>> Lho = null;
  private final t Lhp;
  private final b.a Lhq;
  private t Lhr = null;
  protected Map<a.a<?>, Object> Lhs = null;
  
  protected p(l paraml, t paramt, g paramg, f paramf, b.a parama, an paraman)
  {
    super(paraml, paramg, paramf, paraman);
    paraml = paramt;
    if (paramt == null) {
      paraml = this;
    }
    this.Lhp = paraml;
    this.Lhq = parama;
  }
  
  public static List<av> a(t paramt, List<av> paramList, d.l.b.a.b.m.ba paramba, boolean paramBoolean1, boolean paramBoolean2, boolean[] paramArrayOfBoolean)
  {
    if (paramList == null) {
      agL(28);
    }
    if (paramba == null) {
      agL(29);
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      Object localObject3 = (av)localIterator.next();
      ab localab = paramba.c(((av)localObject3).fRV(), bh.LLW);
      Object localObject1 = ((av)localObject3).fRY();
      if (localObject1 == null) {}
      for (paramList = null; localab == null; paramList = paramba.c((ab)localObject1, bh.LLW)) {
        return null;
      }
      if (((localab != ((av)localObject3).fRV()) || (localObject1 != paramList)) && (paramArrayOfBoolean != null)) {
        paramArrayOfBoolean[0] = true;
      }
      localObject1 = null;
      if ((localObject3 instanceof aj.b)) {
        localObject1 = new d.g.a.a() {};
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
        localg = ((av)localObject3).fQj();
        localf = ((av)localObject3).fRf();
        bool1 = ((av)localObject3).fRX();
        bool2 = ((av)localObject3).fSa();
        bool3 = ((av)localObject3).fSb();
        if (!paramBoolean2) {
          break label289;
        }
      }
      label289:
      for (localObject3 = ((av)localObject3).fQk();; localObject3 = an.Lec)
      {
        localArrayList.add(aj.a(paramt, (av)localObject2, i, localg, localf, localab, bool1, bool2, bool3, paramList, (an)localObject3, (d.g.a.a)localObject1));
        break;
        localObject2 = localObject3;
        break label178;
      }
    }
    return localArrayList;
  }
  
  public final void J(ab paramab)
  {
    if (paramab == null) {
      agL(10);
    }
    this.LgY = paramab;
  }
  
  public p a(ak paramak1, ak paramak2, List<? extends as> paramList, List<av> paramList1, ab paramab, w paramw, d.l.b.a.b.b.ba paramba)
  {
    int k = 0;
    if (paramList == null) {
      agL(5);
    }
    if (paramList1 == null) {
      agL(6);
    }
    if (paramba == null) {
      agL(7);
    }
    this.LdP = j.l(paramList);
    this.LgX = j.l(paramList1);
    this.LgY = paramab;
    this.LgG = paramw;
    this.Lhb = paramba;
    this.LgZ = paramak1;
    this.Lha = paramak2;
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
      agL(8);
    }
    return this;
  }
  
  protected abstract p a(l paraml, t paramt, b.a parama, f paramf, g paramg, an paraman);
  
  protected t a(a parama)
  {
    if (parama == null) {
      agL(23);
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
    if (parama.LhI != null)
    {
      localObject1 = i.a(fQj(), parama.LhI);
      localObject4 = parama.Lhx;
      localObject5 = parama.Lhp;
      localObject6 = parama.Lhq;
      localObject7 = parama.Lgj;
      boolean bool1 = parama.LhF;
      localObject2 = parama.Lhp;
      if (!bool1) {
        break label214;
      }
      if (localObject2 == null) {
        break label205;
      }
      localObject2 = ((t)localObject2).fQk();
      if (localObject2 == null) {
        agL(25);
      }
      localObject4 = a((l)localObject4, (t)localObject5, (b.a)localObject6, (f)localObject7, (g)localObject1, (an)localObject2);
      if (parama.LhH != null) {
        break label222;
      }
      localObject1 = fQR();
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
      localObject5 = d.l.b.a.b.m.p.a((List)localObject1, parama.Lhw, (l)localObject4, (List)localObject6, (boolean[])localObject3);
      if (localObject5 != null) {
        break label236;
      }
      localObject3 = null;
      return localObject3;
      localObject1 = fQj();
      break;
      localObject2 = fRq();
      break label78;
      localObject2 = an.Lec;
      break label87;
      localObject1 = parama.LhH;
      break label128;
    }
    label236:
    if (parama.LhB != null)
    {
      localObject2 = ((d.l.b.a.b.m.ba)localObject5).c(parama.LhB.fRV(), bh.LLW);
      if (localObject2 == null) {
        return null;
      }
      localObject1 = new ad((l)localObject4, new d.l.b.a.b.j.f.a.b((d.l.b.a.b.b.a)localObject4, (ab)localObject2, parama.LhB.fRQ()), parama.LhB.fQj());
      j = localObject3[0];
      if (localObject2 != parama.LhB.fRV())
      {
        i = 1;
        localObject3[0] = (i | j);
      }
    }
    for (;;)
    {
      label330:
      if (parama.Lha != null)
      {
        localObject2 = parama.Lha.e((d.l.b.a.b.m.ba)localObject5);
        if (localObject2 == null)
        {
          return null;
          i = 0;
          break label330;
        }
        j = localObject3[0];
        if (localObject2 != parama.Lha)
        {
          i = 1;
          localObject3[0] = (i | j);
        }
      }
      for (;;)
      {
        label385:
        localObject7 = a((t)localObject4, parama.LhA, (d.l.b.a.b.m.ba)localObject5, parama.LhG, parama.LhF, (boolean[])localObject3);
        if (localObject7 == null)
        {
          return null;
          i = 0;
          break label385;
        }
        ab localab = ((d.l.b.a.b.m.ba)localObject5).c(parama.LhC, bh.LLX);
        if (localab == null) {
          return null;
        }
        j = localObject3[0];
        if (localab != parama.LhC)
        {
          i = 1;
          localObject3[0] = (i | j);
          if (localObject3[0] == 0)
          {
            localObject3 = this;
            if (parama.LhK) {
              break;
            }
          }
          ((p)localObject4).a((ak)localObject1, (ak)localObject2, (List)localObject6, (List)localObject7, localab, parama.Lhy, parama.Lhz);
          ((p)localObject4).Lhc = this.Lhc;
          ((p)localObject4).Lhd = this.Lhd;
          ((p)localObject4).LgF = this.LgF;
          ((p)localObject4).Lhe = this.Lhe;
          ((p)localObject4).Lhf = this.Lhf;
          ((p)localObject4).Lhk = this.Lhk;
          ((p)localObject4).Lhg = this.Lhg;
          ((p)localObject4).Lhh = this.Lhh;
          ((p)localObject4).zk(this.Lhl);
          ((p)localObject4).Lhi = parama.Lhi;
          ((p)localObject4).Lhj = parama.Lhj;
          if (parama.LhJ == null) {
            break label749;
          }
        }
        label749:
        for (boolean bool2 = parama.LhJ.booleanValue();; bool2 = this.Lhm)
        {
          ((p)localObject4).zl(bool2);
          if ((parama.Lhs.isEmpty()) && (this.Lhs == null)) {
            break label810;
          }
          localObject1 = parama.Lhs;
          if (this.Lhs == null) {
            break label757;
          }
          localObject2 = this.Lhs.entrySet().iterator();
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
          ((p)localObject4).Lhs = Collections.singletonMap(((Map)localObject1).keySet().iterator().next(), ((Map)localObject1).values().iterator().next());
          if ((parama.LhE) || (this.Lhr != null))
          {
            if (this.Lhr == null) {
              break label913;
            }
            localObject1 = this.Lhr;
            ((p)localObject4).Lhr = ((t)localObject1).c((d.l.b.a.b.m.ba)localObject5);
          }
          if ((parama.LhD) && (!fRq().fQW().isEmpty()))
          {
            if (!parama.Lhw.isEmpty()) {
              break label931;
            }
            parama = this.Lho;
            if (parama == null) {
              break label919;
            }
            ((p)localObject4).Lho = parama;
          }
        }
        for (;;)
        {
          label810:
          label837:
          return localObject4;
          ((p)localObject4).Lhs = ((Map)localObject1);
          break;
          label913:
          localObject1 = this;
          break label837;
          label919:
          ((p)localObject4).t(fQW());
          continue;
          label931:
          ((p)localObject4).Lho = new d.g.a.a() {};
        }
        localObject2 = null;
      }
      localObject1 = null;
    }
  }
  
  public <V> V a(a.a<V> parama)
  {
    if (this.Lhs == null) {
      return null;
    }
    return this.Lhs.get(parama);
  }
  
  public <R, D> R a(n<R, D> paramn, D paramD)
  {
    return paramn.a(this, paramD);
  }
  
  public final <V> void a(a.a<V> parama, Object paramObject)
  {
    if (this.Lhs == null) {
      this.Lhs = new LinkedHashMap();
    }
    this.Lhs.put(parama, paramObject);
  }
  
  public t b(l paraml, w paramw, d.l.b.a.b.b.ba paramba, b.a parama, boolean paramBoolean)
  {
    paraml = fRx().h(paraml).a(paramw).a(paramba).a(parama).zj(paramBoolean).fRD();
    if (paraml == null) {
      agL(24);
    }
    return paraml;
  }
  
  public t c(d.l.b.a.b.m.ba paramba)
  {
    if (paramba == null) {
      agL(20);
    }
    if (paramba.Lhw.isEmpty()) {
      return this;
    }
    return h(paramba).f(fRq()).fSB().fRD();
  }
  
  public final w fPZ()
  {
    w localw = this.LgG;
    if (localw == null) {
      agL(13);
    }
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
    List localList = this.LdP;
    if (localList == null) {
      agL(16);
    }
    return localList;
  }
  
  public ab fQS()
  {
    return this.LgY;
  }
  
  public final List<av> fQU()
  {
    List localList = this.LgX;
    if (localList == null) {
      agL(17);
    }
    return localList;
  }
  
  public boolean fQV()
  {
    return this.Lhm;
  }
  
  public Collection<? extends t> fQW()
  {
    Object localObject = this.Lho;
    if (localObject != null)
    {
      this.Lhn = ((Collection)((d.g.a.a)localObject).invoke());
      this.Lho = null;
    }
    if (this.Lhn != null) {}
    for (localObject = this.Lhn;; localObject = Collections.emptyList())
    {
      if (localObject == null) {
        agL(12);
      }
      return localObject;
    }
  }
  
  public final b.a fQY()
  {
    b.a locala = this.Lhq;
    if (locala == null) {
      agL(19);
    }
    return locala;
  }
  
  public final d.l.b.a.b.b.ba fQb()
  {
    d.l.b.a.b.b.ba localba = this.Lhb;
    if (localba == null) {
      agL(14);
    }
    return localba;
  }
  
  public boolean fQf()
  {
    return this.Lhe;
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
  
  public boolean fQv()
  {
    return this.Lhf;
  }
  
  public t fRq()
  {
    if (this.Lhp == this) {}
    for (Object localObject = this;; localObject = this.Lhp.fRq())
    {
      if (localObject == null) {
        agL(18);
      }
      return localObject;
    }
  }
  
  public final t fRr()
  {
    return this.Lhr;
  }
  
  public final boolean fRs()
  {
    return this.Lhi;
  }
  
  public final boolean fRt()
  {
    if (this.Lhc) {
      return true;
    }
    Iterator localIterator = fRq().fQW().iterator();
    while (localIterator.hasNext()) {
      if (((t)localIterator.next()).fRt()) {
        return true;
      }
    }
    return false;
  }
  
  public final boolean fRu()
  {
    if (this.Lhd) {
      return true;
    }
    Iterator localIterator = fRq().fQW().iterator();
    while (localIterator.hasNext()) {
      if (((t)localIterator.next()).fRu()) {
        return true;
      }
    }
    return false;
  }
  
  public final boolean fRv()
  {
    return this.Lhj;
  }
  
  public boolean fRw()
  {
    return this.Lhk;
  }
  
  public t.a<? extends t> fRx()
  {
    return h(d.l.b.a.b.m.ba.LLK);
  }
  
  public boolean fSA()
  {
    return this.Lhl;
  }
  
  protected final a h(d.l.b.a.b.m.ba paramba)
  {
    if (paramba == null) {
      agL(22);
    }
    return new a(paramba.gcE(), fPU(), fPZ(), fQb(), fQY(), fQU(), this.LgZ, fQS());
  }
  
  public void t(Collection<? extends d.l.b.a.b.b.b> paramCollection)
  {
    if (paramCollection == null) {
      agL(15);
    }
    this.Lhn = paramCollection;
    paramCollection = this.Lhn.iterator();
    while (paramCollection.hasNext()) {
      if (((t)paramCollection.next()).fRv()) {
        this.Lhj = true;
      }
    }
  }
  
  public void zk(boolean paramBoolean)
  {
    this.Lhl = paramBoolean;
  }
  
  public void zl(boolean paramBoolean)
  {
    this.Lhm = paramBoolean;
  }
  
  public final class a
    implements t.a<t>
  {
    protected f Lgj;
    protected List<av> LhA;
    protected ak LhB;
    protected ab LhC;
    protected boolean LhD;
    protected boolean LhE;
    protected boolean LhF;
    protected boolean LhG;
    List<as> LhH;
    g LhI;
    public Boolean LhJ;
    protected boolean LhK;
    protected ak Lha;
    boolean Lhi;
    boolean Lhj;
    protected t Lhp;
    protected b.a Lhq;
    Map<a.a<?>, Object> Lhs;
    protected ay Lhw;
    protected l Lhx;
    protected w Lhy;
    protected d.l.b.a.b.b.ba Lhz;
    
    public a(l paraml, w paramw, d.l.b.a.b.b.ba paramba, b.a parama, List<av> paramList, ak paramak, ab paramab, f paramf)
    {
      AppMethodBeat.i(57101);
      this.Lhp = null;
      this.Lha = p.a(p.this);
      this.LhD = true;
      this.LhE = false;
      this.LhF = false;
      this.LhG = false;
      this.Lhi = p.this.Lhi;
      this.LhH = null;
      this.LhI = null;
      this.Lhj = p.this.Lhj;
      this.Lhs = new LinkedHashMap();
      this.LhJ = null;
      this.LhK = false;
      this.Lhw = paraml;
      this.Lhx = paramw;
      this.Lhy = paramba;
      this.Lhz = parama;
      this.Lhq = paramList;
      this.LhA = paramak;
      this.LhB = paramab;
      this.LhC = paramf;
      this.Lgj = null;
      AppMethodBeat.o(57101);
    }
    
    public final a f(d.l.b.a.b.b.b paramb)
    {
      AppMethodBeat.i(57103);
      this.Lhp = ((t)paramb);
      if (this == null) {
        agL(26);
      }
      AppMethodBeat.o(57103);
      return this;
    }
    
    public final t fRD()
    {
      AppMethodBeat.i(57104);
      t localt = p.this.a(this);
      AppMethodBeat.o(57104);
      return localt;
    }
    
    public final a fSB()
    {
      AppMethodBeat.i(57105);
      this.LhK = true;
      if (this == null) {
        agL(39);
      }
      AppMethodBeat.o(57105);
      return this;
    }
    
    public final a iY(List<av> paramList)
    {
      AppMethodBeat.i(57102);
      if (paramList == null) {
        agL(18);
      }
      this.LhA = paramList;
      if (this == null) {
        agL(19);
      }
      AppMethodBeat.o(57102);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.b.c.p
 * JD-Core Version:    0.7.0.1
 */