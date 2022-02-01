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
  private List<as> MUK;
  public boolean MXB = false;
  private w MXC;
  private List<av> MXT;
  private ab MXU;
  private ak MXV;
  protected ak MXW;
  public d.l.b.a.b.b.ba MXX = az.MVl;
  public boolean MXY = false;
  public boolean MXZ = false;
  public boolean MYa = false;
  public boolean MYb = false;
  public boolean MYc = false;
  boolean MYd = false;
  boolean MYe = false;
  boolean MYf = false;
  public boolean MYg = false;
  private boolean MYh = true;
  private boolean MYi = false;
  private Collection<? extends t> MYj = null;
  private volatile d.g.a.a<Collection<t>> MYk = null;
  private final t MYl;
  private final b.a MYm;
  private t MYn = null;
  protected Map<a.a<?>, Object> MYo = null;
  
  protected p(l paraml, t paramt, g paramg, f paramf, b.a parama, an paraman)
  {
    super(paraml, paramg, paramf, paraman);
    paraml = paramt;
    if (paramt == null) {
      paraml = this;
    }
    this.MYl = paraml;
    this.MYm = parama;
  }
  
  public static List<av> a(t paramt, List<av> paramList, d.l.b.a.b.m.ba paramba, boolean paramBoolean1, boolean paramBoolean2, boolean[] paramArrayOfBoolean)
  {
    if (paramList == null) {
      ajm(28);
    }
    if (paramba == null) {
      ajm(29);
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      Object localObject3 = (av)localIterator.next();
      ab localab = paramba.c(((av)localObject3).gju(), bh.NCQ);
      Object localObject1 = ((av)localObject3).gjx();
      if (localObject1 == null) {}
      for (paramList = null; localab == null; paramList = paramba.c((ab)localObject1, bh.NCQ)) {
        return null;
      }
      if (((localab != ((av)localObject3).gju()) || (localObject1 != paramList)) && (paramArrayOfBoolean != null)) {
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
        localg = ((av)localObject3).ghH();
        localf = ((av)localObject3).giD();
        bool1 = ((av)localObject3).gjw();
        bool2 = ((av)localObject3).gjz();
        bool3 = ((av)localObject3).gjA();
        if (!paramBoolean2) {
          break label289;
        }
      }
      label289:
      for (localObject3 = ((av)localObject3).ghI();; localObject3 = an.MUX)
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
      ajm(10);
    }
    this.MXU = paramab;
  }
  
  public p a(ak paramak1, ak paramak2, List<? extends as> paramList, List<av> paramList1, ab paramab, w paramw, d.l.b.a.b.b.ba paramba)
  {
    int k = 0;
    if (paramList == null) {
      ajm(5);
    }
    if (paramList1 == null) {
      ajm(6);
    }
    if (paramba == null) {
      ajm(7);
    }
    this.MUK = j.l(paramList);
    this.MXT = j.l(paramList1);
    this.MXU = paramab;
    this.MXC = paramw;
    this.MXX = paramba;
    this.MXV = paramak1;
    this.MXW = paramak2;
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
      ajm(8);
    }
    return this;
  }
  
  protected abstract p a(l paraml, t paramt, b.a parama, f paramf, g paramg, an paraman);
  
  protected t a(a parama)
  {
    if (parama == null) {
      ajm(23);
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
    if (parama.MYE != null)
    {
      localObject1 = i.a(ghH(), parama.MYE);
      localObject4 = parama.MYt;
      localObject5 = parama.MYl;
      localObject6 = parama.MYm;
      localObject7 = parama.MXf;
      boolean bool1 = parama.MYB;
      localObject2 = parama.MYl;
      if (!bool1) {
        break label214;
      }
      if (localObject2 == null) {
        break label205;
      }
      localObject2 = ((t)localObject2).ghI();
      if (localObject2 == null) {
        ajm(25);
      }
      localObject4 = a((l)localObject4, (t)localObject5, (b.a)localObject6, (f)localObject7, (g)localObject1, (an)localObject2);
      if (parama.MYD != null) {
        break label222;
      }
      localObject1 = gip();
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
      localObject5 = d.l.b.a.b.m.p.a((List)localObject1, parama.MYs, (l)localObject4, (List)localObject6, (boolean[])localObject3);
      if (localObject5 != null) {
        break label236;
      }
      localObject3 = null;
      return localObject3;
      localObject1 = ghH();
      break;
      localObject2 = giP();
      break label78;
      localObject2 = an.MUX;
      break label87;
      localObject1 = parama.MYD;
      break label128;
    }
    label236:
    if (parama.MYx != null)
    {
      localObject2 = ((d.l.b.a.b.m.ba)localObject5).c(parama.MYx.gju(), bh.NCQ);
      if (localObject2 == null) {
        return null;
      }
      localObject1 = new ad((l)localObject4, new d.l.b.a.b.j.f.a.b((d.l.b.a.b.b.a)localObject4, (ab)localObject2, parama.MYx.gjp()), parama.MYx.ghH());
      j = localObject3[0];
      if (localObject2 != parama.MYx.gju())
      {
        i = 1;
        localObject3[0] = (i | j);
      }
    }
    for (;;)
    {
      label330:
      if (parama.MXW != null)
      {
        localObject2 = parama.MXW.e((d.l.b.a.b.m.ba)localObject5);
        if (localObject2 == null)
        {
          return null;
          i = 0;
          break label330;
        }
        j = localObject3[0];
        if (localObject2 != parama.MXW)
        {
          i = 1;
          localObject3[0] = (i | j);
        }
      }
      for (;;)
      {
        label385:
        localObject7 = a((t)localObject4, parama.MYw, (d.l.b.a.b.m.ba)localObject5, parama.MYC, parama.MYB, (boolean[])localObject3);
        if (localObject7 == null)
        {
          return null;
          i = 0;
          break label385;
        }
        ab localab = ((d.l.b.a.b.m.ba)localObject5).c(parama.MYy, bh.NCR);
        if (localab == null) {
          return null;
        }
        j = localObject3[0];
        if (localab != parama.MYy)
        {
          i = 1;
          localObject3[0] = (i | j);
          if (localObject3[0] == 0)
          {
            localObject3 = this;
            if (parama.MYG) {
              break;
            }
          }
          ((p)localObject4).a((ak)localObject1, (ak)localObject2, (List)localObject6, (List)localObject7, localab, parama.MYu, parama.MYv);
          ((p)localObject4).MXY = this.MXY;
          ((p)localObject4).MXZ = this.MXZ;
          ((p)localObject4).MXB = this.MXB;
          ((p)localObject4).MYa = this.MYa;
          ((p)localObject4).MYb = this.MYb;
          ((p)localObject4).MYg = this.MYg;
          ((p)localObject4).MYc = this.MYc;
          ((p)localObject4).MYd = this.MYd;
          ((p)localObject4).zY(this.MYh);
          ((p)localObject4).MYe = parama.MYe;
          ((p)localObject4).MYf = parama.MYf;
          if (parama.MYF == null) {
            break label749;
          }
        }
        label749:
        for (boolean bool2 = parama.MYF.booleanValue();; bool2 = this.MYi)
        {
          ((p)localObject4).zZ(bool2);
          if ((parama.MYo.isEmpty()) && (this.MYo == null)) {
            break label810;
          }
          localObject1 = parama.MYo;
          if (this.MYo == null) {
            break label757;
          }
          localObject2 = this.MYo.entrySet().iterator();
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
          ((p)localObject4).MYo = Collections.singletonMap(((Map)localObject1).keySet().iterator().next(), ((Map)localObject1).values().iterator().next());
          if ((parama.MYA) || (this.MYn != null))
          {
            if (this.MYn == null) {
              break label913;
            }
            localObject1 = this.MYn;
            ((p)localObject4).MYn = ((t)localObject1).c((d.l.b.a.b.m.ba)localObject5);
          }
          if ((parama.MYz) && (!giP().giu().isEmpty()))
          {
            if (!parama.MYs.isEmpty()) {
              break label931;
            }
            parama = this.MYk;
            if (parama == null) {
              break label919;
            }
            ((p)localObject4).MYk = parama;
          }
        }
        for (;;)
        {
          label810:
          label837:
          return localObject4;
          ((p)localObject4).MYo = ((Map)localObject1);
          break;
          label913:
          localObject1 = this;
          break label837;
          label919:
          ((p)localObject4).u(giu());
          continue;
          label931:
          ((p)localObject4).MYk = new d.g.a.a() {};
        }
        localObject2 = null;
      }
      localObject1 = null;
    }
  }
  
  public <V> V a(a.a<V> parama)
  {
    if (this.MYo == null) {
      return null;
    }
    return this.MYo.get(parama);
  }
  
  public <R, D> R a(n<R, D> paramn, D paramD)
  {
    return paramn.a(this, paramD);
  }
  
  public final <V> void a(a.a<V> parama, Object paramObject)
  {
    if (this.MYo == null) {
      this.MYo = new LinkedHashMap();
    }
    this.MYo.put(parama, paramObject);
  }
  
  public t b(l paraml, w paramw, d.l.b.a.b.b.ba paramba, b.a parama, boolean paramBoolean)
  {
    paraml = giW().h(paraml).a(paramw).a(paramba).a(parama).zX(paramBoolean).gjc();
    if (paraml == null) {
      ajm(24);
    }
    return paraml;
  }
  
  public t c(d.l.b.a.b.m.ba paramba)
  {
    if (paramba == null) {
      ajm(20);
    }
    if (paramba.MYs.isEmpty()) {
      return this;
    }
    return h(paramba).f(giP()).gjZ().gka().gjc();
  }
  
  public boolean ghD()
  {
    return this.MYa;
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
  
  public boolean ghT()
  {
    return this.MYb;
  }
  
  public final w ghx()
  {
    w localw = this.MXC;
    if (localw == null) {
      ajm(13);
    }
    return localw;
  }
  
  public final d.l.b.a.b.b.ba ghz()
  {
    d.l.b.a.b.b.ba localba = this.MXX;
    if (localba == null) {
      ajm(14);
    }
    return localba;
  }
  
  public t giP()
  {
    if (this.MYl == this) {}
    for (Object localObject = this;; localObject = this.MYl.giP())
    {
      if (localObject == null) {
        ajm(18);
      }
      return localObject;
    }
  }
  
  public final t giQ()
  {
    return this.MYn;
  }
  
  public final boolean giR()
  {
    return this.MYe;
  }
  
  public final boolean giS()
  {
    if (this.MXY) {
      return true;
    }
    Iterator localIterator = giP().giu().iterator();
    while (localIterator.hasNext()) {
      if (((t)localIterator.next()).giS()) {
        return true;
      }
    }
    return false;
  }
  
  public final boolean giT()
  {
    if (this.MXZ) {
      return true;
    }
    Iterator localIterator = giP().giu().iterator();
    while (localIterator.hasNext()) {
      if (((t)localIterator.next()).giT()) {
        return true;
      }
    }
    return false;
  }
  
  public final boolean giU()
  {
    return this.MYf;
  }
  
  public boolean giV()
  {
    return this.MYg;
  }
  
  public t.a<? extends t> giW()
  {
    return h(d.l.b.a.b.m.ba.NCF);
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
    List localList = this.MUK;
    if (localList == null) {
      ajm(16);
    }
    return localList;
  }
  
  public ab giq()
  {
    return this.MXU;
  }
  
  public final List<av> gis()
  {
    List localList = this.MXT;
    if (localList == null) {
      ajm(17);
    }
    return localList;
  }
  
  public boolean git()
  {
    return this.MYi;
  }
  
  public Collection<? extends t> giu()
  {
    Object localObject = this.MYk;
    if (localObject != null)
    {
      this.MYj = ((Collection)((d.g.a.a)localObject).invoke());
      this.MYk = null;
    }
    if (this.MYj != null) {}
    for (localObject = this.MYj;; localObject = Collections.emptyList())
    {
      if (localObject == null) {
        ajm(12);
      }
      return localObject;
    }
  }
  
  public final b.a giw()
  {
    b.a locala = this.MYm;
    if (locala == null) {
      ajm(19);
    }
    return locala;
  }
  
  public boolean gjY()
  {
    return this.MYh;
  }
  
  protected final a h(d.l.b.a.b.m.ba paramba)
  {
    if (paramba == null) {
      ajm(22);
    }
    return new a(paramba.guf(), ghs(), ghx(), ghz(), giw(), gis(), this.MXV, giq());
  }
  
  public void u(Collection<? extends d.l.b.a.b.b.b> paramCollection)
  {
    if (paramCollection == null) {
      ajm(15);
    }
    this.MYj = paramCollection;
    paramCollection = this.MYj.iterator();
    while (paramCollection.hasNext()) {
      if (((t)paramCollection.next()).giU()) {
        this.MYf = true;
      }
    }
  }
  
  public void zY(boolean paramBoolean)
  {
    this.MYh = paramBoolean;
  }
  
  public void zZ(boolean paramBoolean)
  {
    this.MYi = paramBoolean;
  }
  
  public final class a
    implements t.a<t>
  {
    protected ak MXW;
    protected f MXf;
    protected boolean MYA;
    protected boolean MYB;
    protected boolean MYC;
    List<as> MYD;
    g MYE;
    public Boolean MYF;
    protected boolean MYG;
    boolean MYe;
    boolean MYf;
    protected t MYl;
    protected b.a MYm;
    Map<a.a<?>, Object> MYo;
    protected ay MYs;
    protected l MYt;
    protected w MYu;
    protected d.l.b.a.b.b.ba MYv;
    protected List<av> MYw;
    protected ak MYx;
    protected ab MYy;
    protected boolean MYz;
    
    public a(l paraml, w paramw, d.l.b.a.b.b.ba paramba, b.a parama, List<av> paramList, ak paramak, ab paramab, f paramf)
    {
      AppMethodBeat.i(57101);
      this.MYl = null;
      this.MXW = p.a(p.this);
      this.MYz = true;
      this.MYA = false;
      this.MYB = false;
      this.MYC = false;
      this.MYe = p.this.MYe;
      this.MYD = null;
      this.MYE = null;
      this.MYf = p.this.MYf;
      this.MYo = new LinkedHashMap();
      this.MYF = null;
      this.MYG = false;
      this.MYs = paraml;
      this.MYt = paramw;
      this.MYu = paramba;
      this.MYv = parama;
      this.MYm = paramList;
      this.MYw = paramak;
      this.MYx = paramab;
      this.MYy = paramf;
      this.MXf = null;
      AppMethodBeat.o(57101);
    }
    
    public final a f(d.l.b.a.b.b.b paramb)
    {
      AppMethodBeat.i(57103);
      this.MYl = ((t)paramb);
      if (this == null) {
        ajm(26);
      }
      AppMethodBeat.o(57103);
      return this;
    }
    
    public final a gjZ()
    {
      AppMethodBeat.i(187769);
      this.MYB = true;
      if (this == null) {
        ajm(28);
      }
      AppMethodBeat.o(187769);
      return this;
    }
    
    public final t gjc()
    {
      AppMethodBeat.i(57104);
      t localt = p.this.a(this);
      AppMethodBeat.o(57104);
      return localt;
    }
    
    public final a gka()
    {
      AppMethodBeat.i(57105);
      this.MYG = true;
      if (this == null) {
        ajm(39);
      }
      AppMethodBeat.o(57105);
      return this;
    }
    
    public final a jm(List<av> paramList)
    {
      AppMethodBeat.i(57102);
      if (paramList == null) {
        ajm(18);
      }
      this.MYw = paramList;
      if (this == null) {
        ajm(19);
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