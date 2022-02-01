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
  private List<as> Jqw;
  private List<av> JtE;
  private ab JtF;
  private ak JtG;
  protected ak JtH;
  public d.l.b.a.b.b.ba JtI = az.JqX;
  public boolean JtJ = false;
  public boolean JtK = false;
  public boolean JtL = false;
  public boolean JtM = false;
  public boolean JtN = false;
  boolean JtO = false;
  boolean JtP = false;
  boolean JtQ = false;
  public boolean JtR = false;
  private boolean JtS = true;
  private boolean JtT = false;
  private Collection<? extends t> JtU = null;
  private volatile d.g.a.a<Collection<t>> JtV = null;
  private final t JtW;
  private final b.a JtX;
  private t JtY = null;
  protected Map<a.a<?>, Object> JtZ = null;
  public boolean Jtm = false;
  private w Jtn;
  
  protected p(l paraml, t paramt, g paramg, f paramf, b.a parama, an paraman)
  {
    super(paraml, paramg, paramf, paraman);
    paraml = paramt;
    if (paramt == null) {
      paraml = this;
    }
    this.JtW = paraml;
    this.JtX = parama;
  }
  
  public static List<av> a(t paramt, List<av> paramList, d.l.b.a.b.m.ba paramba, boolean paramBoolean1, boolean paramBoolean2, boolean[] paramArrayOfBoolean)
  {
    if (paramList == null) {
      adP(28);
    }
    if (paramba == null) {
      adP(29);
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      Object localObject3 = (av)localIterator.next();
      ab localab = paramba.c(((av)localObject3).fzr(), bh.JYD);
      Object localObject1 = ((av)localObject3).fzu();
      if (localObject1 == null) {}
      for (paramList = null; localab == null; paramList = paramba.c((ab)localObject1, bh.JYD)) {
        return null;
      }
      if (((localab != ((av)localObject3).fzr()) || (localObject1 != paramList)) && (paramArrayOfBoolean != null)) {
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
        localg = ((av)localObject3).fxF();
        localf = ((av)localObject3).fyB();
        bool1 = ((av)localObject3).fzt();
        bool2 = ((av)localObject3).fzw();
        bool3 = ((av)localObject3).fzx();
        if (!paramBoolean2) {
          break label289;
        }
      }
      label289:
      for (localObject3 = ((av)localObject3).fxG();; localObject3 = an.JqJ)
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
      adP(10);
    }
    this.JtF = paramab;
  }
  
  public p a(ak paramak1, ak paramak2, List<? extends as> paramList, List<av> paramList1, ab paramab, w paramw, d.l.b.a.b.b.ba paramba)
  {
    int k = 0;
    if (paramList == null) {
      adP(5);
    }
    if (paramList1 == null) {
      adP(6);
    }
    if (paramba == null) {
      adP(7);
    }
    this.Jqw = j.m(paramList);
    this.JtE = j.m(paramList1);
    this.JtF = paramab;
    this.Jtn = paramw;
    this.JtI = paramba;
    this.JtG = paramak1;
    this.JtH = paramak2;
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
      adP(8);
    }
    return this;
  }
  
  protected abstract p a(l paraml, t paramt, b.a parama, f paramf, g paramg, an paraman);
  
  protected t a(a parama)
  {
    if (parama == null) {
      adP(23);
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
    if (parama.Jup != null)
    {
      localObject1 = i.a(fxF(), parama.Jup);
      localObject4 = parama.Jue;
      localObject5 = parama.JtW;
      localObject6 = parama.JtX;
      localObject7 = parama.JsQ;
      boolean bool1 = parama.Jum;
      localObject2 = parama.JtW;
      if (!bool1) {
        break label214;
      }
      if (localObject2 == null) {
        break label205;
      }
      localObject2 = ((t)localObject2).fxG();
      if (localObject2 == null) {
        adP(25);
      }
      localObject4 = a((l)localObject4, (t)localObject5, (b.a)localObject6, (f)localObject7, (g)localObject1, (an)localObject2);
      if (parama.Juo != null) {
        break label222;
      }
      localObject1 = fyn();
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
      localObject5 = d.l.b.a.b.m.p.a((List)localObject1, parama.Jud, (l)localObject4, (List)localObject6, (boolean[])localObject3);
      if (localObject5 != null) {
        break label236;
      }
      localObject3 = null;
      return localObject3;
      localObject1 = fxF();
      break;
      localObject2 = fyM();
      break label78;
      localObject2 = an.JqJ;
      break label87;
      localObject1 = parama.Juo;
      break label128;
    }
    label236:
    if (parama.Jui != null)
    {
      localObject2 = ((d.l.b.a.b.m.ba)localObject5).c(parama.Jui.fzr(), bh.JYD);
      if (localObject2 == null) {
        return null;
      }
      localObject1 = new ad((l)localObject4, new d.l.b.a.b.j.f.a.b((d.l.b.a.b.b.a)localObject4, (ab)localObject2, parama.Jui.fzm()), parama.Jui.fxF());
      j = localObject3[0];
      if (localObject2 != parama.Jui.fzr())
      {
        i = 1;
        localObject3[0] = (i | j);
      }
    }
    for (;;)
    {
      label330:
      if (parama.JtH != null)
      {
        localObject2 = parama.JtH.e((d.l.b.a.b.m.ba)localObject5);
        if (localObject2 == null)
        {
          return null;
          i = 0;
          break label330;
        }
        j = localObject3[0];
        if (localObject2 != parama.JtH)
        {
          i = 1;
          localObject3[0] = (i | j);
        }
      }
      for (;;)
      {
        label385:
        localObject7 = a((t)localObject4, parama.Juh, (d.l.b.a.b.m.ba)localObject5, parama.Jun, parama.Jum, (boolean[])localObject3);
        if (localObject7 == null)
        {
          return null;
          i = 0;
          break label385;
        }
        ab localab = ((d.l.b.a.b.m.ba)localObject5).c(parama.Juj, bh.JYE);
        if (localab == null) {
          return null;
        }
        j = localObject3[0];
        if (localab != parama.Juj)
        {
          i = 1;
          localObject3[0] = (i | j);
          if (localObject3[0] == 0)
          {
            localObject3 = this;
            if (parama.Jur) {
              break;
            }
          }
          ((p)localObject4).a((ak)localObject1, (ak)localObject2, (List)localObject6, (List)localObject7, localab, parama.Juf, parama.Jug);
          ((p)localObject4).JtJ = this.JtJ;
          ((p)localObject4).JtK = this.JtK;
          ((p)localObject4).Jtm = this.Jtm;
          ((p)localObject4).JtL = this.JtL;
          ((p)localObject4).JtM = this.JtM;
          ((p)localObject4).JtR = this.JtR;
          ((p)localObject4).JtN = this.JtN;
          ((p)localObject4).JtO = this.JtO;
          ((p)localObject4).xS(this.JtS);
          ((p)localObject4).JtP = parama.JtP;
          ((p)localObject4).JtQ = parama.JtQ;
          if (parama.Juq == null) {
            break label749;
          }
        }
        label749:
        for (boolean bool2 = parama.Juq.booleanValue();; bool2 = this.JtT)
        {
          ((p)localObject4).xT(bool2);
          if ((parama.JtZ.isEmpty()) && (this.JtZ == null)) {
            break label810;
          }
          localObject1 = parama.JtZ;
          if (this.JtZ == null) {
            break label757;
          }
          localObject2 = this.JtZ.entrySet().iterator();
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
          ((p)localObject4).JtZ = Collections.singletonMap(((Map)localObject1).keySet().iterator().next(), ((Map)localObject1).values().iterator().next());
          if ((parama.Jul) || (this.JtY != null))
          {
            if (this.JtY == null) {
              break label913;
            }
            localObject1 = this.JtY;
            ((p)localObject4).JtY = ((t)localObject1).c((d.l.b.a.b.m.ba)localObject5);
          }
          if ((parama.Juk) && (!fyM().fys().isEmpty()))
          {
            if (!parama.Jud.isEmpty()) {
              break label931;
            }
            parama = this.JtV;
            if (parama == null) {
              break label919;
            }
            ((p)localObject4).JtV = parama;
          }
        }
        for (;;)
        {
          label810:
          label837:
          return localObject4;
          ((p)localObject4).JtZ = ((Map)localObject1);
          break;
          label913:
          localObject1 = this;
          break label837;
          label919:
          ((p)localObject4).s(fys());
          continue;
          label931:
          ((p)localObject4).JtV = new d.g.a.a() {};
        }
        localObject2 = null;
      }
      localObject1 = null;
    }
  }
  
  public <V> V a(a.a<V> parama)
  {
    if (this.JtZ == null) {
      return null;
    }
    return this.JtZ.get(parama);
  }
  
  public <R, D> R a(n<R, D> paramn, D paramD)
  {
    return paramn.a(this, paramD);
  }
  
  public final <V> void a(a.a<V> parama, Object paramObject)
  {
    if (this.JtZ == null) {
      this.JtZ = new LinkedHashMap();
    }
    this.JtZ.put(parama, paramObject);
  }
  
  public t b(l paraml, w paramw, d.l.b.a.b.b.ba paramba, b.a parama, boolean paramBoolean)
  {
    paraml = fyT().h(paraml).a(paramw).a(paramba).a(parama).xR(paramBoolean).fyZ();
    if (paraml == null) {
      adP(24);
    }
    return paraml;
  }
  
  public t c(d.l.b.a.b.m.ba paramba)
  {
    if (paramba == null) {
      adP(20);
    }
    if (paramba.Jud.isEmpty()) {
      return this;
    }
    return h(paramba).f(fyM()).fzX().fyZ();
  }
  
  public boolean fxB()
  {
    return this.JtL;
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
  
  public boolean fxR()
  {
    return this.JtM;
  }
  
  public final w fxv()
  {
    w localw = this.Jtn;
    if (localw == null) {
      adP(13);
    }
    return localw;
  }
  
  public final d.l.b.a.b.b.ba fxx()
  {
    d.l.b.a.b.b.ba localba = this.JtI;
    if (localba == null) {
      adP(14);
    }
    return localba;
  }
  
  public t fyM()
  {
    if (this.JtW == this) {}
    for (Object localObject = this;; localObject = this.JtW.fyM())
    {
      if (localObject == null) {
        adP(18);
      }
      return localObject;
    }
  }
  
  public final t fyN()
  {
    return this.JtY;
  }
  
  public final boolean fyO()
  {
    return this.JtP;
  }
  
  public final boolean fyP()
  {
    if (this.JtJ) {
      return true;
    }
    Iterator localIterator = fyM().fys().iterator();
    while (localIterator.hasNext()) {
      if (((t)localIterator.next()).fyP()) {
        return true;
      }
    }
    return false;
  }
  
  public final boolean fyQ()
  {
    if (this.JtK) {
      return true;
    }
    Iterator localIterator = fyM().fys().iterator();
    while (localIterator.hasNext()) {
      if (((t)localIterator.next()).fyQ()) {
        return true;
      }
    }
    return false;
  }
  
  public final boolean fyR()
  {
    return this.JtQ;
  }
  
  public boolean fyS()
  {
    return this.JtR;
  }
  
  public t.a<? extends t> fyT()
  {
    return h(d.l.b.a.b.m.ba.JYr);
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
    List localList = this.Jqw;
    if (localList == null) {
      adP(16);
    }
    return localList;
  }
  
  public ab fyo()
  {
    return this.JtF;
  }
  
  public final List<av> fyq()
  {
    List localList = this.JtE;
    if (localList == null) {
      adP(17);
    }
    return localList;
  }
  
  public boolean fyr()
  {
    return this.JtT;
  }
  
  public Collection<? extends t> fys()
  {
    Object localObject = this.JtV;
    if (localObject != null)
    {
      this.JtU = ((Collection)((d.g.a.a)localObject).invoke());
      this.JtV = null;
    }
    if (this.JtU != null) {}
    for (localObject = this.JtU;; localObject = Collections.emptyList())
    {
      if (localObject == null) {
        adP(12);
      }
      return localObject;
    }
  }
  
  public final b.a fyu()
  {
    b.a locala = this.JtX;
    if (locala == null) {
      adP(19);
    }
    return locala;
  }
  
  public boolean fzW()
  {
    return this.JtS;
  }
  
  protected final a h(d.l.b.a.b.m.ba paramba)
  {
    if (paramba == null) {
      adP(22);
    }
    return new a(paramba.fKb(), fxq(), fxv(), fxx(), fyu(), fyq(), this.JtG, fyo());
  }
  
  public void s(Collection<? extends d.l.b.a.b.b.b> paramCollection)
  {
    if (paramCollection == null) {
      adP(15);
    }
    this.JtU = paramCollection;
    paramCollection = this.JtU.iterator();
    while (paramCollection.hasNext()) {
      if (((t)paramCollection.next()).fyR()) {
        this.JtQ = true;
      }
    }
  }
  
  public void xS(boolean paramBoolean)
  {
    this.JtS = paramBoolean;
  }
  
  public void xT(boolean paramBoolean)
  {
    this.JtT = paramBoolean;
  }
  
  public final class a
    implements t.a<t>
  {
    protected f JsQ;
    protected ak JtH;
    boolean JtP;
    boolean JtQ;
    protected t JtW;
    protected b.a JtX;
    Map<a.a<?>, Object> JtZ;
    protected ay Jud;
    protected l Jue;
    protected w Juf;
    protected d.l.b.a.b.b.ba Jug;
    protected List<av> Juh;
    protected ak Jui;
    protected ab Juj;
    protected boolean Juk;
    protected boolean Jul;
    protected boolean Jum;
    protected boolean Jun;
    List<as> Juo;
    g Jup;
    public Boolean Juq;
    protected boolean Jur;
    
    public a(l paraml, w paramw, d.l.b.a.b.b.ba paramba, b.a parama, List<av> paramList, ak paramak, ab paramab, f paramf)
    {
      AppMethodBeat.i(57101);
      this.JtW = null;
      this.JtH = p.a(p.this);
      this.Juk = true;
      this.Jul = false;
      this.Jum = false;
      this.Jun = false;
      this.JtP = p.this.JtP;
      this.Juo = null;
      this.Jup = null;
      this.JtQ = p.this.JtQ;
      this.JtZ = new LinkedHashMap();
      this.Juq = null;
      this.Jur = false;
      this.Jud = paraml;
      this.Jue = paramw;
      this.Juf = paramba;
      this.Jug = parama;
      this.JtX = paramList;
      this.Juh = paramak;
      this.Jui = paramab;
      this.Juj = paramf;
      this.JsQ = null;
      AppMethodBeat.o(57101);
    }
    
    public final a f(d.l.b.a.b.b.b paramb)
    {
      AppMethodBeat.i(57103);
      this.JtW = ((t)paramb);
      if (this == null) {
        adP(26);
      }
      AppMethodBeat.o(57103);
      return this;
    }
    
    public final t fyZ()
    {
      AppMethodBeat.i(57104);
      t localt = p.this.a(this);
      AppMethodBeat.o(57104);
      return localt;
    }
    
    public final a fzX()
    {
      AppMethodBeat.i(57105);
      this.Jur = true;
      if (this == null) {
        adP(39);
      }
      AppMethodBeat.o(57105);
      return this;
    }
    
    public final a iI(List<av> paramList)
    {
      AppMethodBeat.i(57102);
      if (paramList == null) {
        adP(18);
      }
      this.Juh = paramList;
      if (this == null) {
        adP(19);
      }
      AppMethodBeat.o(57102);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.b.c.p
 * JD-Core Version:    0.7.0.1
 */