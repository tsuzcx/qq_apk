package kotlin.l.b.a.b.k.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.a.ab;
import kotlin.a.ak;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.af;
import kotlin.g.b.ag;
import kotlin.g.b.ai;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.l.b.a.b.b.ap;
import kotlin.l.b.a.b.b.au;
import kotlin.l.b.a.b.b.az;
import kotlin.l.b.a.b.e.a.h;
import kotlin.l.b.a.b.e.a.m;
import kotlin.l.b.a.b.e.a.q;
import kotlin.l.b.a.b.h.r;
import kotlin.l.b.a.b.h.t;
import kotlin.l.b.a.b.j.g.a;
import kotlin.l.b.a.b.j.g.d;
import kotlin.l.b.a.b.k.a.j;
import kotlin.l.b.a.b.k.a.k;
import kotlin.l.b.a.b.k.a.w;
import kotlin.l.b.a.b.l.g;
import kotlin.l.b.a.b.l.m;
import kotlin.l.o;

public abstract class i
  extends kotlin.l.b.a.b.j.g.i
{
  final kotlin.l.b.a.b.k.a.l ajmz;
  private final a ajnG;
  private final kotlin.l.b.a.b.l.h ajnH;
  private final kotlin.l.b.a.b.l.i ajnI;
  
  protected i(kotlin.l.b.a.b.k.a.l paraml, List<a.h> paramList, List<a.m> paramList1, List<a.q> paramList2, kotlin.g.a.a<? extends Collection<kotlin.l.b.a.b.f.f>> parama)
  {
    this.ajmz = paraml;
    if (this.ajmz.aiWx.ajlX.kzW()) {}
    for (paraml = (a)new b(paramList, paramList1, paramList2);; paraml = (a)new c(paramList, paramList1, paramList2))
    {
      this.ajnG = paraml;
      this.ajnH = this.ajmz.aiWx.aiBu.cq((kotlin.g.a.a)new i.d(parama));
      this.ajnI = this.ajmz.aiWx.aiBu.cr((kotlin.g.a.a)new e(this));
      return;
    }
  }
  
  private final kotlin.l.b.a.b.b.e C(kotlin.l.b.a.b.f.f paramf)
  {
    return this.ajmz.aiWx.i(A(paramf));
  }
  
  protected abstract kotlin.l.b.a.b.f.b A(kotlin.l.b.a.b.f.f paramf);
  
  protected boolean D(kotlin.l.b.a.b.f.f paramf)
  {
    s.u(paramf, "name");
    return kAm().contains(paramf);
  }
  
  public Collection<ap> a(kotlin.l.b.a.b.f.f paramf, kotlin.l.b.a.b.c.a.b paramb)
  {
    s.u(paramf, "name");
    s.u(paramb, "location");
    return this.ajnG.a(paramf, paramb);
  }
  
  protected final Collection<kotlin.l.b.a.b.b.l> a(d paramd, kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, Boolean> paramb, kotlin.l.b.a.b.c.a.b paramb1)
  {
    s.u(paramd, "kindFilter");
    s.u(paramb, "nameFilter");
    s.u(paramb1, "location");
    ArrayList localArrayList = new ArrayList(0);
    Object localObject = d.ajkC;
    if (paramd.aMn(d.kzB())) {
      c((Collection)localArrayList, paramb);
    }
    this.ajnG.a((Collection)localArrayList, paramd, paramb, paramb1);
    paramb1 = d.ajkC;
    if (paramd.aMn(d.kzH()))
    {
      paramb1 = kAm().iterator();
      while (paramb1.hasNext())
      {
        localObject = (kotlin.l.b.a.b.f.f)paramb1.next();
        if (((Boolean)paramb.invoke(localObject)).booleanValue()) {
          kotlin.l.b.a.b.o.a.c((Collection)localArrayList, C((kotlin.l.b.a.b.f.f)localObject));
        }
      }
    }
    paramb1 = d.ajkC;
    if (paramd.aMn(d.kzC()))
    {
      paramd = this.ajnG.kAn().iterator();
      while (paramd.hasNext())
      {
        paramb1 = (kotlin.l.b.a.b.f.f)paramd.next();
        if (((Boolean)paramb.invoke(paramb1)).booleanValue()) {
          kotlin.l.b.a.b.o.a.c((Collection)localArrayList, this.ajnG.E(paramb1));
        }
      }
    }
    return (Collection)kotlin.l.b.a.b.o.a.cn(localArrayList);
  }
  
  protected void a(kotlin.l.b.a.b.f.f paramf, List<au> paramList)
  {
    s.u(paramf, "name");
    s.u(paramList, "functions");
  }
  
  public Collection<au> b(kotlin.l.b.a.b.f.f paramf, kotlin.l.b.a.b.c.a.b paramb)
  {
    s.u(paramf, "name");
    s.u(paramb, "location");
    return this.ajnG.b(paramf, paramb);
  }
  
  protected void b(kotlin.l.b.a.b.f.f paramf, List<ap> paramList)
  {
    s.u(paramf, "name");
    s.u(paramList, "descriptors");
  }
  
  public kotlin.l.b.a.b.b.h c(kotlin.l.b.a.b.f.f paramf, kotlin.l.b.a.b.c.a.b paramb)
  {
    s.u(paramf, "name");
    s.u(paramb, "location");
    if (D(paramf)) {
      return (kotlin.l.b.a.b.b.h)C(paramf);
    }
    if (this.ajnG.kAn().contains(paramf)) {
      return (kotlin.l.b.a.b.b.h)this.ajnG.E(paramf);
    }
    return null;
  }
  
  protected abstract void c(Collection<kotlin.l.b.a.b.b.l> paramCollection, kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, Boolean> paramb);
  
  protected boolean i(au paramau)
  {
    s.u(paramau, "function");
    return true;
  }
  
  protected abstract Set<kotlin.l.b.a.b.f.f> kAj();
  
  protected abstract Set<kotlin.l.b.a.b.f.f> kAk();
  
  protected abstract Set<kotlin.l.b.a.b.f.f> kAl();
  
  public final Set<kotlin.l.b.a.b.f.f> kAm()
  {
    return (Set)kotlin.l.b.a.b.l.l.a(this.ajnH, aYe[0]);
  }
  
  public final Set<kotlin.l.b.a.b.f.f> kpL()
  {
    return this.ajnG.kpL();
  }
  
  public final Set<kotlin.l.b.a.b.f.f> kpM()
  {
    return (Set)kotlin.l.b.a.b.l.l.a(this.ajnI, aYe[1]);
  }
  
  public final Set<kotlin.l.b.a.b.f.f> kpN()
  {
    return this.ajnG.kpN();
  }
  
  static abstract interface a
  {
    public abstract az E(kotlin.l.b.a.b.f.f paramf);
    
    public abstract Collection<ap> a(kotlin.l.b.a.b.f.f paramf, kotlin.l.b.a.b.c.a.b paramb);
    
    public abstract void a(Collection<kotlin.l.b.a.b.b.l> paramCollection, d paramd, kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, Boolean> paramb, kotlin.l.b.a.b.c.a.b paramb1);
    
    public abstract Collection<au> b(kotlin.l.b.a.b.f.f paramf, kotlin.l.b.a.b.c.a.b paramb);
    
    public abstract Set<kotlin.l.b.a.b.f.f> kAn();
    
    public abstract Set<kotlin.l.b.a.b.f.f> kpL();
    
    public abstract Set<kotlin.l.b.a.b.f.f> kpN();
  }
  
  final class b
    implements i.a
  {
    private final List<a.h> ajnJ;
    private final List<a.m> ajnK;
    private final List<a.q> ajnL;
    private final kotlin.l.b.a.b.l.h ajnM;
    private final kotlin.l.b.a.b.l.h ajnN;
    private final kotlin.l.b.a.b.l.h ajnO;
    private final kotlin.l.b.a.b.l.h ajnP;
    private final kotlin.l.b.a.b.l.h ajnQ;
    private final kotlin.l.b.a.b.l.h ajnR;
    private final kotlin.l.b.a.b.l.h ajnS;
    private final kotlin.l.b.a.b.l.h ajnT;
    private final kotlin.l.b.a.b.l.h ajnU;
    private final kotlin.l.b.a.b.l.h ajnV;
    
    static
    {
      AppMethodBeat.i(192440);
      aYe = new o[] { (o)ai.a((af)new ag((kotlin.l.e)ai.cz(b.class), "declaredFunctions", "getDeclaredFunctions()Ljava/util/List;")), (o)ai.a((af)new ag((kotlin.l.e)ai.cz(b.class), "declaredProperties", "getDeclaredProperties()Ljava/util/List;")), (o)ai.a((af)new ag((kotlin.l.e)ai.cz(b.class), "allTypeAliases", "getAllTypeAliases()Ljava/util/List;")), (o)ai.a((af)new ag((kotlin.l.e)ai.cz(b.class), "allFunctions", "getAllFunctions()Ljava/util/List;")), (o)ai.a((af)new ag((kotlin.l.e)ai.cz(b.class), "allProperties", "getAllProperties()Ljava/util/List;")), (o)ai.a((af)new ag((kotlin.l.e)ai.cz(b.class), "typeAliasesByName", "getTypeAliasesByName()Ljava/util/Map;")), (o)ai.a((af)new ag((kotlin.l.e)ai.cz(b.class), "functionsByName", "getFunctionsByName()Ljava/util/Map;")), (o)ai.a((af)new ag((kotlin.l.e)ai.cz(b.class), "propertiesByName", "getPropertiesByName()Ljava/util/Map;")), (o)ai.a((af)new ag((kotlin.l.e)ai.cz(b.class), "functionNames", "getFunctionNames()Ljava/util/Set;")), (o)ai.a((af)new ag((kotlin.l.e)ai.cz(b.class), "variableNames", "getVariableNames()Ljava/util/Set;")) };
      AppMethodBeat.o(192440);
    }
    
    public b(List<a.m> paramList, List<a.q> paramList1)
    {
      AppMethodBeat.i(192330);
      this.ajnJ = paramList;
      this.ajnK = paramList1;
      if (i.this.ajmz.aiWx.ajlX.kzU()) {}
      for (;;)
      {
        this.ajnL = ((List)localObject);
        this.ajnM = i.this.ajmz.aiWx.aiBu.cq((kotlin.g.a.a)new d(this));
        this.ajnN = i.this.ajmz.aiWx.aiBu.cq((kotlin.g.a.a)new e(this));
        this.ajnO = i.this.ajmz.aiWx.aiBu.cq((kotlin.g.a.a)new c(this));
        this.ajnP = i.this.ajmz.aiWx.aiBu.cq((kotlin.g.a.a)new a(this));
        this.ajnQ = i.this.ajmz.aiWx.aiBu.cq((kotlin.g.a.a)new b(this));
        this.ajnR = i.this.ajmz.aiWx.aiBu.cq((kotlin.g.a.a)new i(this));
        this.ajnS = i.this.ajmz.aiWx.aiBu.cq((kotlin.g.a.a)new g(this));
        this.ajnT = i.this.ajmz.aiWx.aiBu.cq((kotlin.g.a.a)new h(this));
        this.ajnU = i.this.ajmz.aiWx.aiBu.cq((kotlin.g.a.a)new f(this, i.this));
        this.ajnV = i.this.ajmz.aiWx.aiBu.cq((kotlin.g.a.a)new j(this, i.this));
        AppMethodBeat.o(192330);
        return;
        localObject = (List)ab.aivy;
      }
    }
    
    private final List<au> F(kotlin.l.b.a.b.f.f paramf)
    {
      AppMethodBeat.i(192355);
      Object localObject1 = kAo();
      i locali = i.this;
      Object localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = ((Iterator)localObject2).next();
        if (s.p(((kotlin.l.b.a.b.b.l)localObject3).kok(), paramf)) {
          ((Collection)localObject1).add(localObject3);
        }
      }
      localObject1 = (List)localObject1;
      int i = ((List)localObject1).size();
      locali.a(paramf, (List)localObject1);
      paramf = ((List)localObject1).subList(i, ((List)localObject1).size());
      AppMethodBeat.o(192355);
      return paramf;
    }
    
    private final List<ap> G(kotlin.l.b.a.b.f.f paramf)
    {
      AppMethodBeat.i(192359);
      Object localObject1 = kAp();
      i locali = i.this;
      Object localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = ((Iterator)localObject2).next();
        if (s.p(((kotlin.l.b.a.b.b.l)localObject3).kok(), paramf)) {
          ((Collection)localObject1).add(localObject3);
        }
      }
      localObject1 = (List)localObject1;
      int i = ((List)localObject1).size();
      locali.b(paramf, (List)localObject1);
      paramf = ((List)localObject1).subList(i, ((List)localObject1).size());
      AppMethodBeat.o(192359);
      return paramf;
    }
    
    private final List<au> kAo()
    {
      AppMethodBeat.i(192338);
      List localList = (List)kotlin.l.b.a.b.l.l.a(this.ajnM, aYe[0]);
      AppMethodBeat.o(192338);
      return localList;
    }
    
    private final List<ap> kAp()
    {
      AppMethodBeat.i(192342);
      List localList = (List)kotlin.l.b.a.b.l.l.a(this.ajnN, aYe[1]);
      AppMethodBeat.o(192342);
      return localList;
    }
    
    private final List<au> kAq()
    {
      AppMethodBeat.i(192346);
      List localList = (List)kotlin.l.b.a.b.l.l.a(this.ajnP, aYe[3]);
      AppMethodBeat.o(192346);
      return localList;
    }
    
    private final List<ap> kAr()
    {
      AppMethodBeat.i(192351);
      List localList = (List)kotlin.l.b.a.b.l.l.a(this.ajnQ, aYe[4]);
      AppMethodBeat.o(192351);
      return localList;
    }
    
    public final az E(kotlin.l.b.a.b.f.f paramf)
    {
      AppMethodBeat.i(192482);
      s.u(paramf, "name");
      paramf = (az)((Map)kotlin.l.b.a.b.l.l.a(this.ajnR, aYe[5])).get(paramf);
      AppMethodBeat.o(192482);
      return paramf;
    }
    
    public final Collection<ap> a(kotlin.l.b.a.b.f.f paramf, kotlin.l.b.a.b.c.a.b paramb)
    {
      AppMethodBeat.i(192492);
      s.u(paramf, "name");
      s.u(paramb, "location");
      if (!kpN().contains(paramf))
      {
        paramf = (Collection)ab.aivy;
        AppMethodBeat.o(192492);
        return paramf;
      }
      paramb = (Collection)((Map)kotlin.l.b.a.b.l.l.a(this.ajnT, aYe[7])).get(paramf);
      paramf = paramb;
      if (paramb == null) {
        paramf = (Collection)ab.aivy;
      }
      AppMethodBeat.o(192492);
      return paramf;
    }
    
    public final void a(Collection<kotlin.l.b.a.b.b.l> paramCollection, d paramd, kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, Boolean> paramb, kotlin.l.b.a.b.c.a.b paramb1)
    {
      AppMethodBeat.i(192505);
      s.u(paramCollection, "result");
      s.u(paramd, "kindFilter");
      s.u(paramb, "nameFilter");
      s.u(paramb1, "location");
      paramb1 = d.ajkC;
      Object localObject;
      if (paramd.aMn(d.kzF()))
      {
        paramb1 = ((Iterable)kAr()).iterator();
        while (paramb1.hasNext())
        {
          localObject = paramb1.next();
          kotlin.l.b.a.b.f.f localf = ((ap)localObject).kok();
          s.s(localf, "it.name");
          if (((Boolean)paramb.invoke(localf)).booleanValue()) {
            paramCollection.add(localObject);
          }
        }
      }
      paramb1 = d.ajkC;
      if (paramd.aMn(d.kzE()))
      {
        paramd = ((Iterable)kAq()).iterator();
        while (paramd.hasNext())
        {
          paramb1 = paramd.next();
          localObject = ((au)paramb1).kok();
          s.s(localObject, "it.name");
          if (((Boolean)paramb.invoke(localObject)).booleanValue()) {
            paramCollection.add(paramb1);
          }
        }
      }
      AppMethodBeat.o(192505);
    }
    
    public final Collection<au> b(kotlin.l.b.a.b.f.f paramf, kotlin.l.b.a.b.c.a.b paramb)
    {
      AppMethodBeat.i(192473);
      s.u(paramf, "name");
      s.u(paramb, "location");
      if (!kpL().contains(paramf))
      {
        paramf = (Collection)ab.aivy;
        AppMethodBeat.o(192473);
        return paramf;
      }
      paramb = (Collection)((Map)kotlin.l.b.a.b.l.l.a(this.ajnS, aYe[6])).get(paramf);
      paramf = paramb;
      if (paramb == null) {
        paramf = (Collection)ab.aivy;
      }
      AppMethodBeat.o(192473);
      return paramf;
    }
    
    public final Set<kotlin.l.b.a.b.f.f> kAn()
    {
      AppMethodBeat.i(192462);
      Object localObject2 = (Iterable)this.ajnL;
      Object localObject1 = (Collection)new LinkedHashSet();
      i locali = i.this;
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        r localr = (r)((Iterator)localObject2).next();
        ((Collection)localObject1).add(w.b(i.a(locali).aiyk, ((a.q)localr).aiZC));
      }
      localObject1 = (Set)localObject1;
      AppMethodBeat.o(192462);
      return localObject1;
    }
    
    public final Set<kotlin.l.b.a.b.f.f> kpL()
    {
      AppMethodBeat.i(192450);
      Set localSet = (Set)kotlin.l.b.a.b.l.l.a(this.ajnU, aYe[8]);
      AppMethodBeat.o(192450);
      return localSet;
    }
    
    public final Set<kotlin.l.b.a.b.f.f> kpN()
    {
      AppMethodBeat.i(192457);
      Set localSet = (Set)kotlin.l.b.a.b.l.l.a(this.ajnV, aYe[9]);
      AppMethodBeat.o(192457);
      return localSet;
    }
    
    static final class a
      extends u
      implements kotlin.g.a.a<List<? extends au>>
    {
      a(i.b paramb)
      {
        super();
      }
    }
    
    static final class b
      extends u
      implements kotlin.g.a.a<List<? extends ap>>
    {
      b(i.b paramb)
      {
        super();
      }
    }
    
    static final class c
      extends u
      implements kotlin.g.a.a<List<? extends az>>
    {
      c(i.b paramb)
      {
        super();
      }
    }
    
    static final class d
      extends u
      implements kotlin.g.a.a<List<? extends au>>
    {
      d(i.b paramb)
      {
        super();
      }
    }
    
    static final class e
      extends u
      implements kotlin.g.a.a<List<? extends ap>>
    {
      e(i.b paramb)
      {
        super();
      }
    }
    
    static final class f
      extends u
      implements kotlin.g.a.a<Set<? extends kotlin.l.b.a.b.f.f>>
    {
      f(i.b paramb, i parami)
      {
        super();
      }
    }
    
    static final class g
      extends u
      implements kotlin.g.a.a<Map<kotlin.l.b.a.b.f.f, ? extends List<? extends au>>>
    {
      g(i.b paramb)
      {
        super();
      }
    }
    
    static final class h
      extends u
      implements kotlin.g.a.a<Map<kotlin.l.b.a.b.f.f, ? extends List<? extends ap>>>
    {
      h(i.b paramb)
      {
        super();
      }
    }
    
    static final class i
      extends u
      implements kotlin.g.a.a<Map<kotlin.l.b.a.b.f.f, ? extends az>>
    {
      i(i.b paramb)
      {
        super();
      }
    }
    
    static final class j
      extends u
      implements kotlin.g.a.a<Set<? extends kotlin.l.b.a.b.f.f>>
    {
      j(i.b paramb, i parami)
      {
        super();
      }
    }
  }
  
  final class c
    implements i.a
  {
    private final kotlin.l.b.a.b.l.f<kotlin.l.b.a.b.f.f, Collection<au>> aiKd;
    private final kotlin.l.b.a.b.l.f<kotlin.l.b.a.b.f.f, Collection<ap>> aiKe;
    private final kotlin.l.b.a.b.l.h ajnU;
    private final kotlin.l.b.a.b.l.h ajnV;
    private final Map<kotlin.l.b.a.b.f.f, byte[]> ajnZ;
    private final Map<kotlin.l.b.a.b.f.f, byte[]> ajoa;
    private final Map<kotlin.l.b.a.b.f.f, byte[]> ajob;
    private final g<kotlin.l.b.a.b.f.f, az> ajoc;
    
    static
    {
      AppMethodBeat.i(192361);
      aYe = new o[] { (o)ai.a((af)new ag((kotlin.l.e)ai.cz(c.class), "functionNames", "getFunctionNames()Ljava/util/Set;")), (o)ai.a((af)new ag((kotlin.l.e)ai.cz(c.class), "variableNames", "getVariableNames()Ljava/util/Set;")) };
      AppMethodBeat.o(192361);
    }
    
    public c(List<a.m> paramList, List<a.q> paramList1)
    {
      AppMethodBeat.i(192329);
      this$1 = (Iterable)paramList;
      Object localObject2 = i.this;
      Object localObject3 = (Map)new LinkedHashMap();
      Object localObject4 = i.this.iterator();
      Object localObject5;
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = ((Iterator)localObject4).next();
        this$1 = (r)localObject5;
        kotlin.l.b.a.b.f.f localf = w.b(i.a((i)localObject2).aiyk, ((a.h)i.this).aiZC);
        paramList = ((Map)localObject3).get(localf);
        this$1 = paramList;
        if (paramList == null)
        {
          this$1 = (List)new ArrayList();
          ((Map)localObject3).put(localf, i.this);
        }
        ((List)i.this).add(localObject5);
      }
      this.ajnZ = dD((Map)localObject3);
      this$1 = (Iterable)paramList1;
      paramList1 = i.this;
      localObject2 = (Map)new LinkedHashMap();
      localObject3 = i.this.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = ((Iterator)localObject3).next();
        this$1 = (r)localObject4;
        localObject5 = w.b(i.a(paramList1).aiyk, ((a.m)i.this).aiZC);
        paramList = ((Map)localObject2).get(localObject5);
        this$1 = paramList;
        if (paramList == null)
        {
          this$1 = (List)new ArrayList();
          ((Map)localObject2).put(localObject5, i.this);
        }
        ((List)i.this).add(localObject4);
      }
      this.ajoa = dD((Map)localObject2);
      if (i.this.ajmz.aiWx.ajlX.kzU())
      {
        this$1 = (Iterable)localObject1;
        paramList1 = i.this;
        localObject1 = (Map)new LinkedHashMap();
        localObject2 = i.this.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = ((Iterator)localObject2).next();
          this$1 = (r)localObject3;
          localObject4 = w.b(i.a(paramList1).aiyk, ((a.q)i.this).aiZC);
          paramList = ((Map)localObject1).get(localObject4);
          this$1 = paramList;
          if (paramList == null)
          {
            this$1 = (List)new ArrayList();
            ((Map)localObject1).put(localObject4, i.this);
          }
          ((List)i.this).add(localObject3);
        }
      }
      for (this$1 = dD((Map)localObject1);; this$1 = ak.kkZ())
      {
        this.ajob = i.this;
        this.aiKd = i.this.ajmz.aiWx.aiBu.bd((kotlin.g.a.b)new c(this));
        this.aiKe = i.this.ajmz.aiWx.aiBu.bd((kotlin.g.a.b)new d(this));
        this.ajoc = i.this.ajmz.aiWx.aiBu.be((kotlin.g.a.b)new e(this));
        this.ajnU = i.this.ajmz.aiWx.aiBu.cq((kotlin.g.a.a)new b(this, i.this));
        this.ajnV = i.this.ajmz.aiWx.aiBu.cq((kotlin.g.a.a)new f(this, i.this));
        AppMethodBeat.o(192329);
        return;
      }
    }
    
    private static Map<kotlin.l.b.a.b.f.f, byte[]> dD(Map<kotlin.l.b.a.b.f.f, ? extends Collection<? extends kotlin.l.b.a.b.h.a>> paramMap)
    {
      AppMethodBeat.i(192335);
      Map localMap = (Map)new LinkedHashMap(ak.aKi(paramMap.size()));
      paramMap = ((Iterable)paramMap.entrySet()).iterator();
      while (paramMap.hasNext())
      {
        Object localObject2 = paramMap.next();
        Object localObject1 = ((Map.Entry)localObject2).getKey();
        Object localObject3 = (Map.Entry)localObject2;
        localObject2 = new ByteArrayOutputStream();
        Object localObject4 = (Iterable)((Map.Entry)localObject3).getValue();
        localObject3 = (Collection)new ArrayList(p.a((Iterable)localObject4, 10));
        localObject4 = ((Iterable)localObject4).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          ((kotlin.l.b.a.b.h.a)((Iterator)localObject4).next()).writeDelimitedTo((OutputStream)localObject2);
          ((Collection)localObject3).add(ah.aiuX);
        }
        localMap.put(localObject1, ((ByteArrayOutputStream)localObject2).toByteArray());
      }
      AppMethodBeat.o(192335);
      return localMap;
    }
    
    public final az E(kotlin.l.b.a.b.f.f paramf)
    {
      AppMethodBeat.i(192380);
      s.u(paramf, "name");
      paramf = (az)this.ajoc.invoke(paramf);
      AppMethodBeat.o(192380);
      return paramf;
    }
    
    public final Collection<ap> a(kotlin.l.b.a.b.f.f paramf, kotlin.l.b.a.b.c.a.b paramb)
    {
      AppMethodBeat.i(192387);
      s.u(paramf, "name");
      s.u(paramb, "location");
      if (!kpN().contains(paramf))
      {
        paramf = (Collection)ab.aivy;
        AppMethodBeat.o(192387);
        return paramf;
      }
      paramf = (Collection)this.aiKe.invoke(paramf);
      AppMethodBeat.o(192387);
      return paramf;
    }
    
    public final void a(Collection<kotlin.l.b.a.b.b.l> paramCollection, d paramd, kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, Boolean> paramb, kotlin.l.b.a.b.c.a.b paramb1)
    {
      AppMethodBeat.i(192399);
      s.u(paramCollection, "result");
      s.u(paramd, "kindFilter");
      s.u(paramb, "nameFilter");
      s.u(paramb1, "location");
      Object localObject1 = d.ajkC;
      Object localObject2;
      if (paramd.aMn(d.kzF()))
      {
        localObject2 = (Collection)kpN();
        localObject1 = new ArrayList();
        localObject2 = ((Collection)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (kotlin.l.b.a.b.f.f)((Iterator)localObject2).next();
          if (((Boolean)paramb.invoke(localObject3)).booleanValue()) {
            ((ArrayList)localObject1).addAll(a((kotlin.l.b.a.b.f.f)localObject3, paramb1));
          }
        }
        localObject2 = (List)localObject1;
        Object localObject3 = g.a.ajiY;
        s.s(localObject3, "INSTANCE");
        p.a((List)localObject2, (Comparator)localObject3);
        paramCollection.addAll((Collection)localObject1);
      }
      localObject1 = d.ajkC;
      if (paramd.aMn(d.kzE()))
      {
        localObject1 = (Collection)kpL();
        paramd = new ArrayList();
        localObject1 = ((Collection)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (kotlin.l.b.a.b.f.f)((Iterator)localObject1).next();
          if (((Boolean)paramb.invoke(localObject2)).booleanValue()) {
            paramd.addAll(b((kotlin.l.b.a.b.f.f)localObject2, paramb1));
          }
        }
        paramb = (List)paramd;
        paramb1 = g.a.ajiY;
        s.s(paramb1, "INSTANCE");
        p.a(paramb, (Comparator)paramb1);
        paramCollection.addAll((Collection)paramd);
      }
      AppMethodBeat.o(192399);
    }
    
    public final Collection<au> b(kotlin.l.b.a.b.f.f paramf, kotlin.l.b.a.b.c.a.b paramb)
    {
      AppMethodBeat.i(192376);
      s.u(paramf, "name");
      s.u(paramb, "location");
      if (!kpL().contains(paramf))
      {
        paramf = (Collection)ab.aivy;
        AppMethodBeat.o(192376);
        return paramf;
      }
      paramf = (Collection)this.aiKd.invoke(paramf);
      AppMethodBeat.o(192376);
      return paramf;
    }
    
    public final Set<kotlin.l.b.a.b.f.f> kAn()
    {
      AppMethodBeat.i(192371);
      Set localSet = this.ajob.keySet();
      AppMethodBeat.o(192371);
      return localSet;
    }
    
    public final Set<kotlin.l.b.a.b.f.f> kpL()
    {
      AppMethodBeat.i(192365);
      Set localSet = (Set)kotlin.l.b.a.b.l.l.a(this.ajnU, aYe[0]);
      AppMethodBeat.o(192365);
      return localSet;
    }
    
    public final Set<kotlin.l.b.a.b.f.f> kpN()
    {
      AppMethodBeat.i(192367);
      Set localSet = (Set)kotlin.l.b.a.b.l.l.a(this.ajnV, aYe[1]);
      AppMethodBeat.o(192367);
      return localSet;
    }
    
    public static final class a
      extends u
      implements kotlin.g.a.a<M>
    {
      public a(t<M> paramt, ByteArrayInputStream paramByteArrayInputStream, i parami)
      {
        super();
      }
    }
    
    static final class b
      extends u
      implements kotlin.g.a.a<Set<? extends kotlin.l.b.a.b.f.f>>
    {
      b(i.c paramc, i parami)
      {
        super();
      }
    }
    
    static final class c
      extends u
      implements kotlin.g.a.b<kotlin.l.b.a.b.f.f, Collection<? extends au>>
    {
      c(i.c paramc)
      {
        super();
      }
    }
    
    static final class d
      extends u
      implements kotlin.g.a.b<kotlin.l.b.a.b.f.f, Collection<? extends ap>>
    {
      d(i.c paramc)
      {
        super();
      }
    }
    
    static final class e
      extends u
      implements kotlin.g.a.b<kotlin.l.b.a.b.f.f, az>
    {
      e(i.c paramc)
      {
        super();
      }
    }
    
    static final class f
      extends u
      implements kotlin.g.a.a<Set<? extends kotlin.l.b.a.b.f.f>>
    {
      f(i.c paramc, i parami)
      {
        super();
      }
    }
  }
  
  static final class e
    extends u
    implements kotlin.g.a.a<Set<? extends kotlin.l.b.a.b.f.f>>
  {
    e(i parami)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.k.a.b.i
 * JD-Core Version:    0.7.0.1
 */