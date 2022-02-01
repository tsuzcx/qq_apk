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
  private List<as> NrP;
  public boolean NuH = false;
  private w NuI;
  private List<av> NuZ;
  private ab Nva;
  private ak Nvb;
  protected ak Nvc;
  public d.l.b.a.b.b.ba Nvd = az.Nsq;
  public boolean Nve = false;
  public boolean Nvf = false;
  public boolean Nvg = false;
  public boolean Nvh = false;
  public boolean Nvi = false;
  boolean Nvj = false;
  boolean Nvk = false;
  boolean Nvl = false;
  public boolean Nvm = false;
  private boolean Nvn = true;
  private boolean Nvo = false;
  private Collection<? extends t> Nvp = null;
  private volatile d.g.a.a<Collection<t>> Nvq = null;
  private final t Nvr;
  private final b.a Nvs;
  private t Nvt = null;
  protected Map<a.a<?>, Object> Nvu = null;
  
  protected p(l paraml, t paramt, g paramg, f paramf, b.a parama, an paraman)
  {
    super(paraml, paramg, paramf, paraman);
    paraml = paramt;
    if (paramt == null) {
      paraml = this;
    }
    this.Nvr = paraml;
    this.Nvs = parama;
  }
  
  public static List<av> a(t paramt, List<av> paramList, d.l.b.a.b.m.ba paramba, boolean paramBoolean1, boolean paramBoolean2, boolean[] paramArrayOfBoolean)
  {
    if (paramList == null) {
      ajW(28);
    }
    if (paramba == null) {
      ajW(29);
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      Object localObject3 = (av)localIterator.next();
      ab localab = paramba.c(((av)localObject3).gnW(), bh.NZX);
      Object localObject1 = ((av)localObject3).gnZ();
      if (localObject1 == null) {}
      for (paramList = null; localab == null; paramList = paramba.c((ab)localObject1, bh.NZX)) {
        return null;
      }
      if (((localab != ((av)localObject3).gnW()) || (localObject1 != paramList)) && (paramArrayOfBoolean != null)) {
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
        localg = ((av)localObject3).gmj();
        localf = ((av)localObject3).gnf();
        bool1 = ((av)localObject3).gnY();
        bool2 = ((av)localObject3).gob();
        bool3 = ((av)localObject3).goc();
        if (!paramBoolean2) {
          break label289;
        }
      }
      label289:
      for (localObject3 = ((av)localObject3).gmk();; localObject3 = an.Nsc)
      {
        localArrayList.add(aj.a(paramt, (av)localObject2, i, localg, localf, localab, bool1, bool2, bool3, paramList, (an)localObject3, (d.g.a.a)localObject1));
        break;
        localObject2 = localObject3;
        break label178;
      }
    }
    return localArrayList;
  }
  
  public void Al(boolean paramBoolean)
  {
    this.Nvn = paramBoolean;
  }
  
  public void Am(boolean paramBoolean)
  {
    this.Nvo = paramBoolean;
  }
  
  public final void J(ab paramab)
  {
    if (paramab == null) {
      ajW(10);
    }
    this.Nva = paramab;
  }
  
  public p a(ak paramak1, ak paramak2, List<? extends as> paramList, List<av> paramList1, ab paramab, w paramw, d.l.b.a.b.b.ba paramba)
  {
    int k = 0;
    if (paramList == null) {
      ajW(5);
    }
    if (paramList1 == null) {
      ajW(6);
    }
    if (paramba == null) {
      ajW(7);
    }
    this.NrP = j.l(paramList);
    this.NuZ = j.l(paramList1);
    this.Nva = paramab;
    this.NuI = paramw;
    this.Nvd = paramba;
    this.Nvb = paramak1;
    this.Nvc = paramak2;
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
      ajW(8);
    }
    return this;
  }
  
  protected abstract p a(l paraml, t paramt, b.a parama, f paramf, g paramg, an paraman);
  
  protected t a(a parama)
  {
    if (parama == null) {
      ajW(23);
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
    if (parama.NvK != null)
    {
      localObject1 = i.a(gmj(), parama.NvK);
      localObject4 = parama.Nvz;
      localObject5 = parama.Nvr;
      localObject6 = parama.Nvs;
      localObject7 = parama.Nul;
      boolean bool1 = parama.NvH;
      localObject2 = parama.Nvr;
      if (!bool1) {
        break label214;
      }
      if (localObject2 == null) {
        break label205;
      }
      localObject2 = ((t)localObject2).gmk();
      if (localObject2 == null) {
        ajW(25);
      }
      localObject4 = a((l)localObject4, (t)localObject5, (b.a)localObject6, (f)localObject7, (g)localObject1, (an)localObject2);
      if (parama.NvJ != null) {
        break label222;
      }
      localObject1 = gmR();
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
      localObject5 = d.l.b.a.b.m.p.a((List)localObject1, parama.Nvy, (l)localObject4, (List)localObject6, (boolean[])localObject3);
      if (localObject5 != null) {
        break label236;
      }
      localObject3 = null;
      return localObject3;
      localObject1 = gmj();
      break;
      localObject2 = gnr();
      break label78;
      localObject2 = an.Nsc;
      break label87;
      localObject1 = parama.NvJ;
      break label128;
    }
    label236:
    if (parama.NvD != null)
    {
      localObject2 = ((d.l.b.a.b.m.ba)localObject5).c(parama.NvD.gnW(), bh.NZX);
      if (localObject2 == null) {
        return null;
      }
      localObject1 = new ad((l)localObject4, new d.l.b.a.b.j.f.a.b((d.l.b.a.b.b.a)localObject4, (ab)localObject2, parama.NvD.gnR()), parama.NvD.gmj());
      j = localObject3[0];
      if (localObject2 != parama.NvD.gnW())
      {
        i = 1;
        localObject3[0] = (i | j);
      }
    }
    for (;;)
    {
      label330:
      if (parama.Nvc != null)
      {
        localObject2 = parama.Nvc.e((d.l.b.a.b.m.ba)localObject5);
        if (localObject2 == null)
        {
          return null;
          i = 0;
          break label330;
        }
        j = localObject3[0];
        if (localObject2 != parama.Nvc)
        {
          i = 1;
          localObject3[0] = (i | j);
        }
      }
      for (;;)
      {
        label385:
        localObject7 = a((t)localObject4, parama.NvC, (d.l.b.a.b.m.ba)localObject5, parama.NvI, parama.NvH, (boolean[])localObject3);
        if (localObject7 == null)
        {
          return null;
          i = 0;
          break label385;
        }
        ab localab = ((d.l.b.a.b.m.ba)localObject5).c(parama.NvE, bh.NZY);
        if (localab == null) {
          return null;
        }
        j = localObject3[0];
        if (localab != parama.NvE)
        {
          i = 1;
          localObject3[0] = (i | j);
          if (localObject3[0] == 0)
          {
            localObject3 = this;
            if (parama.NvM) {
              break;
            }
          }
          ((p)localObject4).a((ak)localObject1, (ak)localObject2, (List)localObject6, (List)localObject7, localab, parama.NvA, parama.NvB);
          ((p)localObject4).Nve = this.Nve;
          ((p)localObject4).Nvf = this.Nvf;
          ((p)localObject4).NuH = this.NuH;
          ((p)localObject4).Nvg = this.Nvg;
          ((p)localObject4).Nvh = this.Nvh;
          ((p)localObject4).Nvm = this.Nvm;
          ((p)localObject4).Nvi = this.Nvi;
          ((p)localObject4).Nvj = this.Nvj;
          ((p)localObject4).Al(this.Nvn);
          ((p)localObject4).Nvk = parama.Nvk;
          ((p)localObject4).Nvl = parama.Nvl;
          if (parama.NvL == null) {
            break label749;
          }
        }
        label749:
        for (boolean bool2 = parama.NvL.booleanValue();; bool2 = this.Nvo)
        {
          ((p)localObject4).Am(bool2);
          if ((parama.Nvu.isEmpty()) && (this.Nvu == null)) {
            break label810;
          }
          localObject1 = parama.Nvu;
          if (this.Nvu == null) {
            break label757;
          }
          localObject2 = this.Nvu.entrySet().iterator();
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
          ((p)localObject4).Nvu = Collections.singletonMap(((Map)localObject1).keySet().iterator().next(), ((Map)localObject1).values().iterator().next());
          if ((parama.NvG) || (this.Nvt != null))
          {
            if (this.Nvt == null) {
              break label913;
            }
            localObject1 = this.Nvt;
            ((p)localObject4).Nvt = ((t)localObject1).c((d.l.b.a.b.m.ba)localObject5);
          }
          if ((parama.NvF) && (!gnr().gmW().isEmpty()))
          {
            if (!parama.Nvy.isEmpty()) {
              break label931;
            }
            parama = this.Nvq;
            if (parama == null) {
              break label919;
            }
            ((p)localObject4).Nvq = parama;
          }
        }
        for (;;)
        {
          label810:
          label837:
          return localObject4;
          ((p)localObject4).Nvu = ((Map)localObject1);
          break;
          label913:
          localObject1 = this;
          break label837;
          label919:
          ((p)localObject4).u(gmW());
          continue;
          label931:
          ((p)localObject4).Nvq = new d.g.a.a() {};
        }
        localObject2 = null;
      }
      localObject1 = null;
    }
  }
  
  public <V> V a(a.a<V> parama)
  {
    if (this.Nvu == null) {
      return null;
    }
    return this.Nvu.get(parama);
  }
  
  public <R, D> R a(n<R, D> paramn, D paramD)
  {
    return paramn.a(this, paramD);
  }
  
  public final <V> void a(a.a<V> parama, Object paramObject)
  {
    if (this.Nvu == null) {
      this.Nvu = new LinkedHashMap();
    }
    this.Nvu.put(parama, paramObject);
  }
  
  public t b(l paraml, w paramw, d.l.b.a.b.b.ba paramba, b.a parama, boolean paramBoolean)
  {
    paraml = gny().h(paraml).a(paramw).a(paramba).a(parama).Ak(paramBoolean).gnE();
    if (paraml == null) {
      ajW(24);
    }
    return paraml;
  }
  
  public t c(d.l.b.a.b.m.ba paramba)
  {
    if (paramba == null) {
      ajW(20);
    }
    if (paramba.Nvy.isEmpty()) {
      return this;
    }
    return h(paramba).f(gnr()).goB().goC().gnE();
  }
  
  public final w glZ()
  {
    w localw = this.NuI;
    if (localw == null) {
      ajW(13);
    }
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
    List localList = this.NrP;
    if (localList == null) {
      ajW(16);
    }
    return localList;
  }
  
  public ab gmS()
  {
    return this.Nva;
  }
  
  public final List<av> gmU()
  {
    List localList = this.NuZ;
    if (localList == null) {
      ajW(17);
    }
    return localList;
  }
  
  public boolean gmV()
  {
    return this.Nvo;
  }
  
  public Collection<? extends t> gmW()
  {
    Object localObject = this.Nvq;
    if (localObject != null)
    {
      this.Nvp = ((Collection)((d.g.a.a)localObject).invoke());
      this.Nvq = null;
    }
    if (this.Nvp != null) {}
    for (localObject = this.Nvp;; localObject = Collections.emptyList())
    {
      if (localObject == null) {
        ajW(12);
      }
      return localObject;
    }
  }
  
  public final b.a gmY()
  {
    b.a locala = this.Nvs;
    if (locala == null) {
      ajW(19);
    }
    return locala;
  }
  
  public final d.l.b.a.b.b.ba gmb()
  {
    d.l.b.a.b.b.ba localba = this.Nvd;
    if (localba == null) {
      ajW(14);
    }
    return localba;
  }
  
  public boolean gmf()
  {
    return this.Nvg;
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
  
  public boolean gmv()
  {
    return this.Nvh;
  }
  
  public t gnr()
  {
    if (this.Nvr == this) {}
    for (Object localObject = this;; localObject = this.Nvr.gnr())
    {
      if (localObject == null) {
        ajW(18);
      }
      return localObject;
    }
  }
  
  public final t gns()
  {
    return this.Nvt;
  }
  
  public final boolean gnt()
  {
    return this.Nvk;
  }
  
  public final boolean gnu()
  {
    if (this.Nve) {
      return true;
    }
    Iterator localIterator = gnr().gmW().iterator();
    while (localIterator.hasNext()) {
      if (((t)localIterator.next()).gnu()) {
        return true;
      }
    }
    return false;
  }
  
  public final boolean gnv()
  {
    if (this.Nvf) {
      return true;
    }
    Iterator localIterator = gnr().gmW().iterator();
    while (localIterator.hasNext()) {
      if (((t)localIterator.next()).gnv()) {
        return true;
      }
    }
    return false;
  }
  
  public final boolean gnw()
  {
    return this.Nvl;
  }
  
  public boolean gnx()
  {
    return this.Nvm;
  }
  
  public t.a<? extends t> gny()
  {
    return h(d.l.b.a.b.m.ba.NZM);
  }
  
  public boolean goA()
  {
    return this.Nvn;
  }
  
  protected final a h(d.l.b.a.b.m.ba paramba)
  {
    if (paramba == null) {
      ajW(22);
    }
    return new a(paramba.gyH(), glU(), glZ(), gmb(), gmY(), gmU(), this.Nvb, gmS());
  }
  
  public void u(Collection<? extends d.l.b.a.b.b.b> paramCollection)
  {
    if (paramCollection == null) {
      ajW(15);
    }
    this.Nvp = paramCollection;
    paramCollection = this.Nvp.iterator();
    while (paramCollection.hasNext()) {
      if (((t)paramCollection.next()).gnw()) {
        this.Nvl = true;
      }
    }
  }
  
  public final class a
    implements t.a<t>
  {
    protected f Nul;
    protected w NvA;
    protected d.l.b.a.b.b.ba NvB;
    protected List<av> NvC;
    protected ak NvD;
    protected ab NvE;
    protected boolean NvF;
    protected boolean NvG;
    protected boolean NvH;
    protected boolean NvI;
    List<as> NvJ;
    g NvK;
    public Boolean NvL;
    protected boolean NvM;
    protected ak Nvc;
    boolean Nvk;
    boolean Nvl;
    protected t Nvr;
    protected b.a Nvs;
    Map<a.a<?>, Object> Nvu;
    protected ay Nvy;
    protected l Nvz;
    
    public a(l paraml, w paramw, d.l.b.a.b.b.ba paramba, b.a parama, List<av> paramList, ak paramak, ab paramab, f paramf)
    {
      AppMethodBeat.i(57101);
      this.Nvr = null;
      this.Nvc = p.a(p.this);
      this.NvF = true;
      this.NvG = false;
      this.NvH = false;
      this.NvI = false;
      this.Nvk = p.this.Nvk;
      this.NvJ = null;
      this.NvK = null;
      this.Nvl = p.this.Nvl;
      this.Nvu = new LinkedHashMap();
      this.NvL = null;
      this.NvM = false;
      this.Nvy = paraml;
      this.Nvz = paramw;
      this.NvA = paramba;
      this.NvB = parama;
      this.Nvs = paramList;
      this.NvC = paramak;
      this.NvD = paramab;
      this.NvE = paramf;
      this.Nul = null;
      AppMethodBeat.o(57101);
    }
    
    public final a f(d.l.b.a.b.b.b paramb)
    {
      AppMethodBeat.i(57103);
      this.Nvr = ((t)paramb);
      if (this == null) {
        ajW(26);
      }
      AppMethodBeat.o(57103);
      return this;
    }
    
    public final t gnE()
    {
      AppMethodBeat.i(57104);
      t localt = p.this.a(this);
      AppMethodBeat.o(57104);
      return localt;
    }
    
    public final a goB()
    {
      AppMethodBeat.i(193293);
      this.NvH = true;
      if (this == null) {
        ajW(28);
      }
      AppMethodBeat.o(193293);
      return this;
    }
    
    public final a goC()
    {
      AppMethodBeat.i(57105);
      this.NvM = true;
      if (this == null) {
        ajW(39);
      }
      AppMethodBeat.o(57105);
      return this;
    }
    
    public final a jv(List<av> paramList)
    {
      AppMethodBeat.i(57102);
      if (paramList == null) {
        ajW(18);
      }
      this.NvC = paramList;
      if (this == null) {
        ajW(19);
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