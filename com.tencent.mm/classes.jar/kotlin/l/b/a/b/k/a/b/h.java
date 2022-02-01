package kotlin.l.b.a.b.k.a.b;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.a.ae;
import kotlin.a.v;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.am;
import kotlin.l.b.a.b.b.ar;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.e.a.h;
import kotlin.l.b.a.b.e.a.m;
import kotlin.l.b.a.b.e.a.q;
import kotlin.l.b.a.b.h.s;
import kotlin.l.b.a.b.j.f.a;
import kotlin.l.b.a.b.k.a.n;
import kotlin.l.b.a.b.l.c;

public abstract class h
  extends kotlin.l.b.a.b.j.f.i
{
  final n TLm;
  private final Map<kotlin.l.b.a.b.f.f, byte[]> TMt;
  private final Map<kotlin.l.b.a.b.f.f, byte[]> TMu;
  private final Map<kotlin.l.b.a.b.f.f, byte[]> TMv;
  private final kotlin.l.b.a.b.l.d<kotlin.l.b.a.b.f.f, ar> TMw;
  private final kotlin.l.b.a.b.l.f TMx;
  private final kotlin.l.b.a.b.l.f TMy;
  private final c<kotlin.l.b.a.b.f.f, Collection<ah>> TkA;
  private final c<kotlin.l.b.a.b.f.f, Collection<am>> Tkz;
  private final kotlin.l.b.a.b.l.f TsH;
  
  protected h(n paramn, Collection<a.h> paramCollection, Collection<a.m> paramCollection1, Collection<a.q> paramCollection2, kotlin.g.a.a<? extends Collection<kotlin.l.b.a.b.f.f>> parama)
  {
    this.TLm = paramn;
    paramn = (Iterable)paramCollection;
    Object localObject1 = (Map)new LinkedHashMap();
    Object localObject2 = paramn.iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      paramn = (kotlin.l.b.a.b.h.q)localObject3;
      kotlin.l.b.a.b.f.f localf = kotlin.l.b.a.b.k.a.x.b(this.TLm.SZH, ((a.h)paramn).Tyk);
      paramCollection = ((Map)localObject1).get(localf);
      paramn = paramCollection;
      if (paramCollection == null)
      {
        paramn = new ArrayList();
        ((Map)localObject1).put(localf, paramn);
      }
      ((List)paramn).add(localObject3);
    }
    this.TMt = cA((Map)localObject1);
    paramn = (Iterable)paramCollection1;
    paramCollection1 = (Map)new LinkedHashMap();
    localObject1 = paramn.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      paramn = (kotlin.l.b.a.b.h.q)localObject2;
      localObject3 = kotlin.l.b.a.b.k.a.x.b(this.TLm.SZH, ((a.m)paramn).Tyk);
      paramCollection = paramCollection1.get(localObject3);
      paramn = paramCollection;
      if (paramCollection == null)
      {
        paramn = new ArrayList();
        paramCollection1.put(localObject3, paramn);
      }
      ((List)paramn).add(localObject2);
    }
    this.TMu = cA(paramCollection1);
    paramn = (Iterable)paramCollection2;
    paramCollection1 = (Map)new LinkedHashMap();
    paramCollection2 = paramn.iterator();
    while (paramCollection2.hasNext())
    {
      localObject1 = paramCollection2.next();
      paramn = (kotlin.l.b.a.b.h.q)localObject1;
      localObject2 = kotlin.l.b.a.b.k.a.x.b(this.TLm.SZH, ((a.q)paramn).Tyk);
      paramCollection = paramCollection1.get(localObject2);
      paramn = paramCollection;
      if (paramCollection == null)
      {
        paramn = new ArrayList();
        paramCollection1.put(localObject2, paramn);
      }
      ((List)paramn).add(localObject1);
    }
    this.TMv = cA(paramCollection1);
    this.Tkz = this.TLm.Tvt.TcN.U((b)new e(this));
    this.TkA = this.TLm.Tvt.TcN.U((b)new f(this));
    this.TMw = this.TLm.Tvt.TcN.V((b)new g(this));
    this.TsH = this.TLm.Tvt.TcN.al((kotlin.g.a.a)new d(this));
    this.TMx = this.TLm.Tvt.TcN.al((kotlin.g.a.a)new h(this));
    this.TMy = this.TLm.Tvt.TcN.al((kotlin.g.a.a)new h.a(parama));
  }
  
  private final e B(kotlin.l.b.a.b.f.f paramf)
  {
    return this.TLm.Tvt.g(z(paramf));
  }
  
  private final void a(Collection<kotlin.l.b.a.b.b.l> paramCollection, kotlin.l.b.a.b.j.f.d paramd, b<? super kotlin.l.b.a.b.f.f, Boolean> paramb, kotlin.l.b.a.b.c.a.a parama)
  {
    Object localObject1 = kotlin.l.b.a.b.j.f.d.TJQ;
    Object localObject2;
    if (paramd.avF(kotlin.l.b.a.b.j.f.d.hKU()))
    {
      localObject2 = (Collection)hCb();
      localObject1 = new ArrayList();
      localObject2 = ((Collection)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (kotlin.l.b.a.b.f.f)((Iterator)localObject2).next();
        if (((Boolean)paramb.invoke(localObject3)).booleanValue()) {
          ((ArrayList)localObject1).addAll(a((kotlin.l.b.a.b.f.f)localObject3, parama));
        }
      }
      localObject2 = (List)localObject1;
      Object localObject3 = f.a.THN;
      p.g(localObject3, "MemberComparator.NameAnd…MemberComparator.INSTANCE");
      kotlin.a.j.a((List)localObject2, (Comparator)localObject3);
      paramCollection.addAll((Collection)localObject1);
    }
    localObject1 = kotlin.l.b.a.b.j.f.d.TJQ;
    if (paramd.avF(kotlin.l.b.a.b.j.f.d.hKT()))
    {
      localObject1 = (Collection)hCa();
      paramd = new ArrayList();
      localObject1 = ((Collection)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (kotlin.l.b.a.b.f.f)((Iterator)localObject1).next();
        if (((Boolean)paramb.invoke(localObject2)).booleanValue()) {
          paramd.addAll(b((kotlin.l.b.a.b.f.f)localObject2, parama));
        }
      }
      paramb = (List)paramd;
      parama = f.a.THN;
      p.g(parama, "MemberComparator.NameAnd…MemberComparator.INSTANCE");
      kotlin.a.j.a(paramb, (Comparator)parama);
      paramCollection.addAll((Collection)paramd);
    }
  }
  
  private static Map<kotlin.l.b.a.b.f.f, byte[]> cA(Map<kotlin.l.b.a.b.f.f, ? extends Collection<? extends kotlin.l.b.a.b.h.a>> paramMap)
  {
    Map localMap = (Map)new LinkedHashMap(ae.atJ(paramMap.size()));
    paramMap = ((Iterable)paramMap.entrySet()).iterator();
    while (paramMap.hasNext())
    {
      Object localObject2 = paramMap.next();
      Object localObject1 = ((Map.Entry)localObject2).getKey();
      Object localObject3 = (Map.Entry)localObject2;
      localObject2 = new ByteArrayOutputStream();
      Object localObject4 = (Iterable)((Map.Entry)localObject3).getValue();
      localObject3 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject4, 10));
      localObject4 = ((Iterable)localObject4).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        ((kotlin.l.b.a.b.h.a)((Iterator)localObject4).next()).d((OutputStream)localObject2);
        ((Collection)localObject3).add(kotlin.x.SXb);
      }
      localMap.put(localObject1, ((ByteArrayOutputStream)localObject2).toByteArray());
    }
    return localMap;
  }
  
  private final Set<kotlin.l.b.a.b.f.f> hLo()
  {
    return this.TMv.keySet();
  }
  
  protected boolean C(kotlin.l.b.a.b.f.f paramf)
  {
    p.h(paramf, "name");
    return hLp().contains(paramf);
  }
  
  public Collection<ah> a(kotlin.l.b.a.b.f.f paramf, kotlin.l.b.a.b.c.a.a parama)
  {
    p.h(paramf, "name");
    p.h(parama, "location");
    if (!hCb().contains(paramf)) {
      return (Collection)v.SXr;
    }
    return (Collection)this.TkA.invoke(paramf);
  }
  
  protected final Collection<kotlin.l.b.a.b.b.l> a(kotlin.l.b.a.b.j.f.d paramd, b<? super kotlin.l.b.a.b.f.f, Boolean> paramb, kotlin.l.b.a.b.c.a.a parama)
  {
    p.h(paramd, "kindFilter");
    p.h(paramb, "nameFilter");
    p.h(parama, "location");
    ArrayList localArrayList = new ArrayList(0);
    Object localObject = kotlin.l.b.a.b.j.f.d.TJQ;
    if (paramd.avF(kotlin.l.b.a.b.j.f.d.hKQ())) {
      c((Collection)localArrayList, paramb);
    }
    a((Collection)localArrayList, paramd, paramb, parama);
    parama = kotlin.l.b.a.b.j.f.d.TJQ;
    if (paramd.avF(kotlin.l.b.a.b.j.f.d.hKW()))
    {
      parama = hLp().iterator();
      while (parama.hasNext())
      {
        localObject = (kotlin.l.b.a.b.f.f)parama.next();
        if (((Boolean)paramb.invoke(localObject)).booleanValue()) {
          kotlin.l.b.a.b.o.a.c((Collection)localArrayList, B((kotlin.l.b.a.b.f.f)localObject));
        }
      }
    }
    parama = kotlin.l.b.a.b.j.f.d.TJQ;
    if (paramd.avF(kotlin.l.b.a.b.j.f.d.hKR()))
    {
      paramd = hLo().iterator();
      while (paramd.hasNext())
      {
        parama = (kotlin.l.b.a.b.f.f)paramd.next();
        if (((Boolean)paramb.invoke(parama)).booleanValue()) {
          kotlin.l.b.a.b.o.a.c((Collection)localArrayList, this.TMw.invoke(parama));
        }
      }
    }
    return (Collection)kotlin.l.b.a.b.o.a.bC(localArrayList);
  }
  
  public Collection<am> b(kotlin.l.b.a.b.f.f paramf, kotlin.l.b.a.b.c.a.a parama)
  {
    p.h(paramf, "name");
    p.h(parama, "location");
    if (!hCa().contains(paramf)) {
      return (Collection)v.SXr;
    }
    return (Collection)this.Tkz.invoke(paramf);
  }
  
  protected void b(kotlin.l.b.a.b.f.f paramf, Collection<ah> paramCollection)
  {
    p.h(paramf, "name");
    p.h(paramCollection, "descriptors");
  }
  
  public kotlin.l.b.a.b.b.h c(kotlin.l.b.a.b.f.f paramf, kotlin.l.b.a.b.c.a.a parama)
  {
    p.h(paramf, "name");
    p.h(parama, "location");
    if (C(paramf)) {
      return (kotlin.l.b.a.b.b.h)B(paramf);
    }
    if (hLo().contains(paramf)) {
      return (kotlin.l.b.a.b.b.h)this.TMw.invoke(paramf);
    }
    return null;
  }
  
  protected abstract void c(Collection<kotlin.l.b.a.b.b.l> paramCollection, b<? super kotlin.l.b.a.b.f.f, Boolean> paramb);
  
  protected void c(kotlin.l.b.a.b.f.f paramf, Collection<am> paramCollection)
  {
    p.h(paramf, "name");
    p.h(paramCollection, "functions");
  }
  
  public final Set<kotlin.l.b.a.b.f.f> hCa()
  {
    return (Set)kotlin.l.b.a.b.l.i.a(this.TsH, cLI[0]);
  }
  
  public final Set<kotlin.l.b.a.b.f.f> hCb()
  {
    return (Set)kotlin.l.b.a.b.l.i.a(this.TMx, cLI[1]);
  }
  
  protected abstract Set<kotlin.l.b.a.b.f.f> hLm();
  
  protected abstract Set<kotlin.l.b.a.b.f.f> hLn();
  
  public final Set<kotlin.l.b.a.b.f.f> hLp()
  {
    return (Set)kotlin.l.b.a.b.l.i.a(this.TMy, cLI[2]);
  }
  
  protected abstract kotlin.l.b.a.b.f.a z(kotlin.l.b.a.b.f.f paramf);
  
  public static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<M>
  {
    public b(ByteArrayInputStream paramByteArrayInputStream, h paramh, s params)
    {
      super();
    }
  }
  
  public static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<M>
  {
    public c(ByteArrayInputStream paramByteArrayInputStream, h paramh, s params)
    {
      super();
    }
  }
  
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Set<? extends kotlin.l.b.a.b.f.f>>
  {
    d(h paramh)
    {
      super();
    }
  }
  
  static final class e
    extends kotlin.g.b.q
    implements b<kotlin.l.b.a.b.f.f, Collection<? extends am>>
  {
    e(h paramh)
    {
      super();
    }
  }
  
  static final class f
    extends kotlin.g.b.q
    implements b<kotlin.l.b.a.b.f.f, Collection<? extends ah>>
  {
    f(h paramh)
    {
      super();
    }
  }
  
  static final class g
    extends kotlin.g.b.q
    implements b<kotlin.l.b.a.b.f.f, ar>
  {
    g(h paramh)
    {
      super();
    }
  }
  
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Set<? extends kotlin.l.b.a.b.f.f>>
  {
    h(h paramh)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.k.a.b.h
 * JD-Core Version:    0.7.0.1
 */