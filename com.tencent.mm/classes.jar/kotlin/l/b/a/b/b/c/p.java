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
  private List<as> Thx;
  private List<av> TkH;
  private ab TkI;
  private ak TkJ;
  protected ak TkK;
  public kotlin.l.b.a.b.b.ba TkL = az.ThY;
  public boolean TkM = false;
  public boolean TkN = false;
  public boolean TkO = false;
  public boolean TkP = false;
  public boolean TkQ = false;
  boolean TkR = false;
  boolean TkS = false;
  boolean TkT = false;
  public boolean TkU = false;
  private boolean TkV = true;
  private boolean TkW = false;
  private Collection<? extends t> TkX = null;
  private volatile kotlin.g.a.a<Collection<t>> TkY = null;
  private final t TkZ;
  public boolean Tkp = false;
  private w Tkq;
  private final b.a Tla;
  private t Tlb = null;
  protected Map<a.a<?>, Object> Tlc = null;
  
  protected p(l paraml, t paramt, g paramg, f paramf, b.a parama, an paraman)
  {
    super(paraml, paramg, paramf, paraman);
    paraml = paramt;
    if (paramt == null) {
      paraml = this;
    }
    this.TkZ = paraml;
    this.Tla = parama;
  }
  
  public static List<av> a(t paramt, List<av> paramList, kotlin.l.b.a.b.m.ba paramba, boolean paramBoolean1, boolean paramBoolean2, boolean[] paramArrayOfBoolean)
  {
    if (paramList == null) {
      atM(28);
    }
    if (paramba == null) {
      atM(29);
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      Object localObject3 = (av)localIterator.next();
      ab localab = paramba.c(((av)localObject3).hBy(), bh.TOR);
      Object localObject1 = ((av)localObject3).hBB();
      if (localObject1 == null) {}
      for (paramList = null; localab == null; paramList = paramba.c((ab)localObject1, bh.TOR)) {
        return null;
      }
      if (((localab != ((av)localObject3).hBy()) || (localObject1 != paramList)) && (paramArrayOfBoolean != null)) {
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
        localg = ((av)localObject3).hzL();
        localf = ((av)localObject3).hAH();
        bool1 = ((av)localObject3).hBA();
        bool2 = ((av)localObject3).hBD();
        bool3 = ((av)localObject3).hBE();
        if (!paramBoolean2) {
          break label289;
        }
      }
      label289:
      for (localObject3 = ((av)localObject3).hzM();; localObject3 = an.ThK)
      {
        localArrayList.add(aj.a(paramt, (av)localObject2, i, localg, localf, localab, bool1, bool2, bool3, paramList, (an)localObject3, (kotlin.g.a.a)localObject1));
        break;
        localObject2 = localObject3;
        break label178;
      }
    }
    return localArrayList;
  }
  
  public void EC(boolean paramBoolean)
  {
    this.TkV = paramBoolean;
  }
  
  public void ED(boolean paramBoolean)
  {
    this.TkW = paramBoolean;
  }
  
  public final void I(ab paramab)
  {
    if (paramab == null) {
      atM(10);
    }
    this.TkI = paramab;
  }
  
  public <V> V a(a.a<V> parama)
  {
    if (this.Tlc == null) {
      return null;
    }
    return this.Tlc.get(parama);
  }
  
  public <R, D> R a(n<R, D> paramn, D paramD)
  {
    return paramn.a(this, paramD);
  }
  
  public p a(ak paramak1, ak paramak2, List<? extends as> paramList, List<av> paramList1, ab paramab, w paramw, kotlin.l.b.a.b.b.ba paramba)
  {
    int k = 0;
    if (paramList == null) {
      atM(5);
    }
    if (paramList1 == null) {
      atM(6);
    }
    if (paramba == null) {
      atM(7);
    }
    this.Thx = j.p(paramList);
    this.TkH = j.p(paramList1);
    this.TkI = paramab;
    this.Tkq = paramw;
    this.TkL = paramba;
    this.TkJ = paramak1;
    this.TkK = paramak2;
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
      atM(8);
    }
    return this;
  }
  
  protected abstract p a(l paraml, t paramt, b.a parama, f paramf, g paramg, an paraman);
  
  protected t a(a parama)
  {
    if (parama == null) {
      atM(23);
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
    if (parama.Tls != null)
    {
      localObject1 = i.a(hzL(), parama.Tls);
      localObject4 = parama.Tlh;
      localObject5 = parama.TkZ;
      localObject6 = parama.Tla;
      localObject7 = parama.TjT;
      boolean bool1 = parama.Tlp;
      localObject2 = parama.TkZ;
      if (!bool1) {
        break label214;
      }
      if (localObject2 == null) {
        break label205;
      }
      localObject2 = ((t)localObject2).hzM();
      if (localObject2 == null) {
        atM(25);
      }
      localObject4 = a((l)localObject4, (t)localObject5, (b.a)localObject6, (f)localObject7, (g)localObject1, (an)localObject2);
      if (parama.Tlr != null) {
        break label222;
      }
      localObject1 = hAt();
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
      localObject5 = kotlin.l.b.a.b.m.p.a((List)localObject1, parama.Tlg, (l)localObject4, (List)localObject6, (boolean[])localObject3);
      if (localObject5 != null) {
        break label236;
      }
      localObject3 = null;
      return localObject3;
      localObject1 = hzL();
      break;
      localObject2 = hAT();
      break label78;
      localObject2 = an.ThK;
      break label87;
      localObject1 = parama.Tlr;
      break label128;
    }
    label236:
    if (parama.Tll != null)
    {
      localObject2 = ((kotlin.l.b.a.b.m.ba)localObject5).c(parama.Tll.hBy(), bh.TOR);
      if (localObject2 == null) {
        return null;
      }
      localObject1 = new ad((l)localObject4, new kotlin.l.b.a.b.j.f.a.b((kotlin.l.b.a.b.b.a)localObject4, (ab)localObject2, parama.Tll.hBt()), parama.Tll.hzL());
      j = localObject3[0];
      if (localObject2 != parama.Tll.hBy())
      {
        i = 1;
        localObject3[0] = (i | j);
      }
    }
    for (;;)
    {
      label330:
      if (parama.TkK != null)
      {
        localObject2 = parama.TkK.e((kotlin.l.b.a.b.m.ba)localObject5);
        if (localObject2 == null)
        {
          return null;
          i = 0;
          break label330;
        }
        j = localObject3[0];
        if (localObject2 != parama.TkK)
        {
          i = 1;
          localObject3[0] = (i | j);
        }
      }
      for (;;)
      {
        label385:
        localObject7 = a((t)localObject4, parama.Tlk, (kotlin.l.b.a.b.m.ba)localObject5, parama.Tlq, parama.Tlp, (boolean[])localObject3);
        if (localObject7 == null)
        {
          return null;
          i = 0;
          break label385;
        }
        ab localab = ((kotlin.l.b.a.b.m.ba)localObject5).c(parama.Tlm, bh.TOS);
        if (localab == null) {
          return null;
        }
        j = localObject3[0];
        if (localab != parama.Tlm)
        {
          i = 1;
          localObject3[0] = (i | j);
          if (localObject3[0] == 0)
          {
            localObject3 = this;
            if (parama.Tlu) {
              break;
            }
          }
          ((p)localObject4).a((ak)localObject1, (ak)localObject2, (List)localObject6, (List)localObject7, localab, parama.Tli, parama.Tlj);
          ((p)localObject4).TkM = this.TkM;
          ((p)localObject4).TkN = this.TkN;
          ((p)localObject4).Tkp = this.Tkp;
          ((p)localObject4).TkO = this.TkO;
          ((p)localObject4).TkP = this.TkP;
          ((p)localObject4).TkU = this.TkU;
          ((p)localObject4).TkQ = this.TkQ;
          ((p)localObject4).TkR = this.TkR;
          ((p)localObject4).EC(this.TkV);
          ((p)localObject4).TkS = parama.TkS;
          ((p)localObject4).TkT = parama.TkT;
          if (parama.Tlt == null) {
            break label749;
          }
        }
        label749:
        for (boolean bool2 = parama.Tlt.booleanValue();; bool2 = this.TkW)
        {
          ((p)localObject4).ED(bool2);
          if ((parama.Tlc.isEmpty()) && (this.Tlc == null)) {
            break label810;
          }
          localObject1 = parama.Tlc;
          if (this.Tlc == null) {
            break label757;
          }
          localObject2 = this.Tlc.entrySet().iterator();
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
          ((p)localObject4).Tlc = Collections.singletonMap(((Map)localObject1).keySet().iterator().next(), ((Map)localObject1).values().iterator().next());
          if ((parama.Tlo) || (this.Tlb != null))
          {
            if (this.Tlb == null) {
              break label913;
            }
            localObject1 = this.Tlb;
            ((p)localObject4).Tlb = ((t)localObject1).c((kotlin.l.b.a.b.m.ba)localObject5);
          }
          if ((parama.Tln) && (!hAT().hAy().isEmpty()))
          {
            if (!parama.Tlg.isEmpty()) {
              break label931;
            }
            parama = this.TkY;
            if (parama == null) {
              break label919;
            }
            ((p)localObject4).TkY = parama;
          }
        }
        for (;;)
        {
          label810:
          label837:
          return localObject4;
          ((p)localObject4).Tlc = ((Map)localObject1);
          break;
          label913:
          localObject1 = this;
          break label837;
          label919:
          ((p)localObject4).x(hAy());
          continue;
          label931:
          ((p)localObject4).TkY = new kotlin.g.a.a() {};
        }
        localObject2 = null;
      }
      localObject1 = null;
    }
  }
  
  public final <V> void a(a.a<V> parama, Object paramObject)
  {
    if (this.Tlc == null) {
      this.Tlc = new LinkedHashMap();
    }
    this.Tlc.put(parama, paramObject);
  }
  
  public t b(l paraml, w paramw, kotlin.l.b.a.b.b.ba paramba, b.a parama, boolean paramBoolean)
  {
    paraml = hBa().h(paraml).a(paramw).a(paramba).a(parama).EB(paramBoolean).hBg();
    if (paraml == null) {
      atM(24);
    }
    return paraml;
  }
  
  public t c(kotlin.l.b.a.b.m.ba paramba)
  {
    if (paramba == null) {
      atM(20);
    }
    if (paramba.Tlg.isEmpty()) {
      return this;
    }
    return h(paramba).f(hAT()).hCd().hCe().hBg();
  }
  
  protected final a h(kotlin.l.b.a.b.m.ba paramba)
  {
    if (paramba == null) {
      atM(22);
    }
    return new a(paramba.hLK(), hzx(), hzC(), hzE(), hAA(), hAw(), this.TkJ, hAu());
  }
  
  public final b.a hAA()
  {
    b.a locala = this.Tla;
    if (locala == null) {
      atM(19);
    }
    return locala;
  }
  
  public t hAT()
  {
    if (this.TkZ == this) {}
    for (Object localObject = this;; localObject = this.TkZ.hAT())
    {
      if (localObject == null) {
        atM(18);
      }
      return localObject;
    }
  }
  
  public final t hAU()
  {
    return this.Tlb;
  }
  
  public final boolean hAV()
  {
    return this.TkS;
  }
  
  public final boolean hAW()
  {
    if (this.TkM) {
      return true;
    }
    Iterator localIterator = hAT().hAy().iterator();
    while (localIterator.hasNext()) {
      if (((t)localIterator.next()).hAW()) {
        return true;
      }
    }
    return false;
  }
  
  public final boolean hAX()
  {
    if (this.TkN) {
      return true;
    }
    Iterator localIterator = hAT().hAy().iterator();
    while (localIterator.hasNext()) {
      if (((t)localIterator.next()).hAX()) {
        return true;
      }
    }
    return false;
  }
  
  public final boolean hAY()
  {
    return this.TkT;
  }
  
  public boolean hAZ()
  {
    return this.TkU;
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
    List localList = this.Thx;
    if (localList == null) {
      atM(16);
    }
    return localList;
  }
  
  public ab hAu()
  {
    return this.TkI;
  }
  
  public final List<av> hAw()
  {
    List localList = this.TkH;
    if (localList == null) {
      atM(17);
    }
    return localList;
  }
  
  public boolean hAx()
  {
    return this.TkW;
  }
  
  public Collection<? extends t> hAy()
  {
    Object localObject = this.TkY;
    if (localObject != null)
    {
      this.TkX = ((Collection)((kotlin.g.a.a)localObject).invoke());
      this.TkY = null;
    }
    if (this.TkX != null) {}
    for (localObject = this.TkX;; localObject = Collections.emptyList())
    {
      if (localObject == null) {
        atM(12);
      }
      return localObject;
    }
  }
  
  public t.a<? extends t> hBa()
  {
    return h(kotlin.l.b.a.b.m.ba.TOF);
  }
  
  public boolean hCc()
  {
    return this.TkV;
  }
  
  public final w hzC()
  {
    w localw = this.Tkq;
    if (localw == null) {
      atM(13);
    }
    return localw;
  }
  
  public final kotlin.l.b.a.b.b.ba hzE()
  {
    kotlin.l.b.a.b.b.ba localba = this.TkL;
    if (localba == null) {
      atM(14);
    }
    return localba;
  }
  
  public boolean hzI()
  {
    return this.TkO;
  }
  
  public final boolean hzJ()
  {
    return this.TkQ;
  }
  
  public final boolean hzK()
  {
    return this.TkR;
  }
  
  public boolean hzX()
  {
    return this.TkP;
  }
  
  public boolean isExternal()
  {
    return this.Tkp;
  }
  
  public void x(Collection<? extends kotlin.l.b.a.b.b.b> paramCollection)
  {
    if (paramCollection == null) {
      atM(15);
    }
    this.TkX = paramCollection;
    paramCollection = this.TkX.iterator();
    while (paramCollection.hasNext()) {
      if (((t)paramCollection.next()).hAY()) {
        this.TkT = true;
      }
    }
  }
  
  public final class a
    implements t.a<t>
  {
    protected f TjT;
    protected ak TkK;
    boolean TkS;
    boolean TkT;
    protected t TkZ;
    protected b.a Tla;
    Map<a.a<?>, Object> Tlc;
    protected ay Tlg;
    protected l Tlh;
    protected w Tli;
    protected kotlin.l.b.a.b.b.ba Tlj;
    protected List<av> Tlk;
    protected ak Tll;
    protected ab Tlm;
    protected boolean Tln;
    protected boolean Tlo;
    protected boolean Tlp;
    protected boolean Tlq;
    List<as> Tlr;
    g Tls;
    public Boolean Tlt;
    protected boolean Tlu;
    
    public a(l paraml, w paramw, kotlin.l.b.a.b.b.ba paramba, b.a parama, List<av> paramList, ak paramak, ab paramab, f paramf)
    {
      AppMethodBeat.i(57101);
      this.TkZ = null;
      this.TkK = p.a(p.this);
      this.Tln = true;
      this.Tlo = false;
      this.Tlp = false;
      this.Tlq = false;
      this.TkS = p.this.TkS;
      this.Tlr = null;
      this.Tls = null;
      this.TkT = p.this.TkT;
      this.Tlc = new LinkedHashMap();
      this.Tlt = null;
      this.Tlu = false;
      this.Tlg = paraml;
      this.Tlh = paramw;
      this.Tli = paramba;
      this.Tlj = parama;
      this.Tla = paramList;
      this.Tlk = paramak;
      this.Tll = paramab;
      this.Tlm = paramf;
      this.TjT = null;
      AppMethodBeat.o(57101);
    }
    
    public final a f(kotlin.l.b.a.b.b.b paramb)
    {
      AppMethodBeat.i(57103);
      this.TkZ = ((t)paramb);
      if (this == null) {
        atM(26);
      }
      AppMethodBeat.o(57103);
      return this;
    }
    
    public final t hBg()
    {
      AppMethodBeat.i(57104);
      t localt = p.this.a(this);
      AppMethodBeat.o(57104);
      return localt;
    }
    
    public final a hCd()
    {
      AppMethodBeat.i(186243);
      this.Tlp = true;
      if (this == null) {
        atM(28);
      }
      AppMethodBeat.o(186243);
      return this;
    }
    
    public final a hCe()
    {
      AppMethodBeat.i(57105);
      this.Tlu = true;
      if (this == null) {
        atM(39);
      }
      AppMethodBeat.o(57105);
      return this;
    }
    
    public final a kB(List<av> paramList)
    {
      AppMethodBeat.i(57102);
      if (paramList == null) {
        atM(18);
      }
      this.Tlk = paramList;
      if (this == null) {
        atM(19);
      }
      AppMethodBeat.o(57102);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.b.c.p
 * JD-Core Version:    0.7.0.1
 */