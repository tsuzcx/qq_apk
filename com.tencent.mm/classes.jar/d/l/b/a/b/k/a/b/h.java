package d.l.b.a.b.k.a.b;

import d.a.ae;
import d.a.j;
import d.a.v;
import d.g.a.b;
import d.g.b.k;
import d.l.b.a.b.b.ah;
import d.l.b.a.b.b.am;
import d.l.b.a.b.b.ar;
import d.l.b.a.b.b.e;
import d.l.b.a.b.e.a.h;
import d.l.b.a.b.e.a.m;
import d.l.b.a.b.e.a.q;
import d.l.b.a.b.h.q;
import d.l.b.a.b.h.s;
import d.l.b.a.b.j.f.a;
import d.l.b.a.b.k.a.n;
import d.l.b.a.b.k.a.x;
import d.l.b.a.b.l.c;
import d.y;
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

public abstract class h
  extends d.l.b.a.b.j.f.i
{
  private final d.l.b.a.b.l.f JBF;
  final n JUS;
  private final Map<d.l.b.a.b.f.f, byte[]> JWc;
  private final Map<d.l.b.a.b.f.f, byte[]> JWd;
  private final Map<d.l.b.a.b.f.f, byte[]> JWe;
  private final d.l.b.a.b.l.d<d.l.b.a.b.f.f, ar> JWf;
  private final d.l.b.a.b.l.f JWg;
  private final d.l.b.a.b.l.f JWh;
  private final c<d.l.b.a.b.f.f, Collection<am>> Jtw;
  private final c<d.l.b.a.b.f.f, Collection<ah>> Jtx;
  
  protected h(n paramn, Collection<a.h> paramCollection, Collection<a.m> paramCollection1, Collection<a.q> paramCollection2, d.g.a.a<? extends Collection<d.l.b.a.b.f.f>> parama)
  {
    this.JUS = paramn;
    paramn = (Iterable)paramCollection;
    Object localObject1 = (Map)new LinkedHashMap();
    Object localObject2 = paramn.iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      paramn = (q)localObject3;
      d.l.b.a.b.f.f localf = x.b(this.JUS.Jiu, ((a.h)paramn).JHm);
      paramCollection = ((Map)localObject1).get(localf);
      paramn = paramCollection;
      if (paramCollection == null)
      {
        paramn = new ArrayList();
        ((Map)localObject1).put(localf, paramn);
      }
      ((List)paramn).add(localObject3);
    }
    this.JWc = bW((Map)localObject1);
    paramn = (Iterable)paramCollection1;
    paramCollection1 = (Map)new LinkedHashMap();
    localObject1 = paramn.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      paramn = (q)localObject2;
      localObject3 = x.b(this.JUS.Jiu, ((a.m)paramn).JHm);
      paramCollection = paramCollection1.get(localObject3);
      paramn = paramCollection;
      if (paramCollection == null)
      {
        paramn = new ArrayList();
        paramCollection1.put(localObject3, paramn);
      }
      ((List)paramn).add(localObject2);
    }
    this.JWd = bW(paramCollection1);
    paramn = (Iterable)paramCollection2;
    paramCollection1 = (Map)new LinkedHashMap();
    paramCollection2 = paramn.iterator();
    while (paramCollection2.hasNext())
    {
      localObject1 = paramCollection2.next();
      paramn = (q)localObject1;
      localObject2 = x.b(this.JUS.Jiu, ((a.q)paramn).JHm);
      paramCollection = paramCollection1.get(localObject2);
      paramn = paramCollection;
      if (paramCollection == null)
      {
        paramn = new ArrayList();
        paramCollection1.put(localObject2, paramn);
      }
      ((List)paramn).add(localObject1);
    }
    this.JWe = bW(paramCollection1);
    this.Jtw = this.JUS.JEr.JlL.A((b)new e(this));
    this.Jtx = this.JUS.JEr.JlL.A((b)new f(this));
    this.JWf = this.JUS.JEr.JlL.B((b)new g(this));
    this.JBF = this.JUS.JEr.JlL.H((d.g.a.a)new d(this));
    this.JWg = this.JUS.JEr.JlL.H((d.g.a.a)new h(this));
    this.JWh = this.JUS.JEr.JlL.H((d.g.a.a)new h.a(parama));
  }
  
  private final e B(d.l.b.a.b.f.f paramf)
  {
    return this.JUS.JEr.g(z(paramf));
  }
  
  private final void a(Collection<d.l.b.a.b.b.l> paramCollection, d.l.b.a.b.j.f.d paramd, b<? super d.l.b.a.b.f.f, Boolean> paramb, d.l.b.a.b.c.a.a parama)
  {
    Object localObject1 = d.l.b.a.b.j.f.d.JTw;
    Object localObject2;
    if (paramd.afP(d.l.b.a.b.j.f.d.fJn()))
    {
      localObject2 = (Collection)fzV();
      localObject1 = new ArrayList();
      localObject2 = ((Collection)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (d.l.b.a.b.f.f)((Iterator)localObject2).next();
        if (((Boolean)paramb.aA(localObject3)).booleanValue()) {
          ((ArrayList)localObject1).addAll(a((d.l.b.a.b.f.f)localObject3, parama));
        }
      }
      localObject2 = (List)localObject1;
      Object localObject3 = f.a.JRt;
      k.g(localObject3, "MemberComparator.NameAnd…MemberComparator.INSTANCE");
      j.a((List)localObject2, (Comparator)localObject3);
      paramCollection.addAll((Collection)localObject1);
    }
    localObject1 = d.l.b.a.b.j.f.d.JTw;
    if (paramd.afP(d.l.b.a.b.j.f.d.fJm()))
    {
      localObject1 = (Collection)fzU();
      paramd = new ArrayList();
      localObject1 = ((Collection)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (d.l.b.a.b.f.f)((Iterator)localObject1).next();
        if (((Boolean)paramb.aA(localObject2)).booleanValue()) {
          paramd.addAll(b((d.l.b.a.b.f.f)localObject2, parama));
        }
      }
      paramb = (List)paramd;
      parama = f.a.JRt;
      k.g(parama, "MemberComparator.NameAnd…MemberComparator.INSTANCE");
      j.a(paramb, (Comparator)parama);
      paramCollection.addAll((Collection)paramd);
    }
  }
  
  private static Map<d.l.b.a.b.f.f, byte[]> bW(Map<d.l.b.a.b.f.f, ? extends Collection<? extends d.l.b.a.b.h.a>> paramMap)
  {
    Map localMap = (Map)new LinkedHashMap(ae.adL(paramMap.size()));
    paramMap = ((Iterable)paramMap.entrySet()).iterator();
    while (paramMap.hasNext())
    {
      Object localObject2 = paramMap.next();
      Object localObject1 = ((Map.Entry)localObject2).getKey();
      Object localObject3 = (Map.Entry)localObject2;
      localObject2 = new ByteArrayOutputStream();
      Object localObject4 = (Iterable)((Map.Entry)localObject3).getValue();
      localObject3 = (Collection)new ArrayList(j.a((Iterable)localObject4, 10));
      localObject4 = ((Iterable)localObject4).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        ((d.l.b.a.b.h.a)((Iterator)localObject4).next()).d((OutputStream)localObject2);
        ((Collection)localObject3).add(y.JfV);
      }
      localMap.put(localObject1, ((ByteArrayOutputStream)localObject2).toByteArray());
    }
    return localMap;
  }
  
  private final Set<d.l.b.a.b.f.f> fJH()
  {
    return this.JWe.keySet();
  }
  
  protected boolean C(d.l.b.a.b.f.f paramf)
  {
    k.h(paramf, "name");
    return fJI().contains(paramf);
  }
  
  public Collection<ah> a(d.l.b.a.b.f.f paramf, d.l.b.a.b.c.a.a parama)
  {
    k.h(paramf, "name");
    k.h(parama, "location");
    if (!fzV().contains(paramf)) {
      return (Collection)v.Jgl;
    }
    return (Collection)this.Jtx.aA(paramf);
  }
  
  protected final Collection<d.l.b.a.b.b.l> a(d.l.b.a.b.j.f.d paramd, b<? super d.l.b.a.b.f.f, Boolean> paramb, d.l.b.a.b.c.a.a parama)
  {
    k.h(paramd, "kindFilter");
    k.h(paramb, "nameFilter");
    k.h(parama, "location");
    ArrayList localArrayList = new ArrayList(0);
    Object localObject = d.l.b.a.b.j.f.d.JTw;
    if (paramd.afP(d.l.b.a.b.j.f.d.fJj())) {
      c((Collection)localArrayList, paramb);
    }
    a((Collection)localArrayList, paramd, paramb, parama);
    parama = d.l.b.a.b.j.f.d.JTw;
    if (paramd.afP(d.l.b.a.b.j.f.d.fJp()))
    {
      parama = fJI().iterator();
      while (parama.hasNext())
      {
        localObject = (d.l.b.a.b.f.f)parama.next();
        if (((Boolean)paramb.aA(localObject)).booleanValue()) {
          d.l.b.a.b.o.a.c((Collection)localArrayList, B((d.l.b.a.b.f.f)localObject));
        }
      }
    }
    parama = d.l.b.a.b.j.f.d.JTw;
    if (paramd.afP(d.l.b.a.b.j.f.d.fJk()))
    {
      paramd = fJH().iterator();
      while (paramd.hasNext())
      {
        parama = (d.l.b.a.b.f.f)paramd.next();
        if (((Boolean)paramb.aA(parama)).booleanValue()) {
          d.l.b.a.b.o.a.c((Collection)localArrayList, this.JWf.aA(parama));
        }
      }
    }
    return (Collection)d.l.b.a.b.o.a.aT(localArrayList);
  }
  
  public Collection<am> b(d.l.b.a.b.f.f paramf, d.l.b.a.b.c.a.a parama)
  {
    k.h(paramf, "name");
    k.h(parama, "location");
    if (!fzU().contains(paramf)) {
      return (Collection)v.Jgl;
    }
    return (Collection)this.Jtw.aA(paramf);
  }
  
  protected void b(d.l.b.a.b.f.f paramf, Collection<ah> paramCollection)
  {
    k.h(paramf, "name");
    k.h(paramCollection, "descriptors");
  }
  
  public d.l.b.a.b.b.h c(d.l.b.a.b.f.f paramf, d.l.b.a.b.c.a.a parama)
  {
    k.h(paramf, "name");
    k.h(parama, "location");
    if (C(paramf)) {
      return (d.l.b.a.b.b.h)B(paramf);
    }
    if (fJH().contains(paramf)) {
      return (d.l.b.a.b.b.h)this.JWf.aA(paramf);
    }
    return null;
  }
  
  protected void c(d.l.b.a.b.f.f paramf, Collection<am> paramCollection)
  {
    k.h(paramf, "name");
    k.h(paramCollection, "functions");
  }
  
  protected abstract void c(Collection<d.l.b.a.b.b.l> paramCollection, b<? super d.l.b.a.b.f.f, Boolean> paramb);
  
  protected abstract Set<d.l.b.a.b.f.f> fJF();
  
  protected abstract Set<d.l.b.a.b.f.f> fJG();
  
  public final Set<d.l.b.a.b.f.f> fJI()
  {
    return (Set)d.l.b.a.b.l.h.a(this.JWh, $$delegatedProperties[2]);
  }
  
  public final Set<d.l.b.a.b.f.f> fzU()
  {
    return (Set)d.l.b.a.b.l.h.a(this.JBF, $$delegatedProperties[0]);
  }
  
  public final Set<d.l.b.a.b.f.f> fzV()
  {
    return (Set)d.l.b.a.b.l.h.a(this.JWg, $$delegatedProperties[1]);
  }
  
  protected abstract d.l.b.a.b.f.a z(d.l.b.a.b.f.f paramf);
  
  public static final class b
    extends d.g.b.l
    implements d.g.a.a<M>
  {
    public b(ByteArrayInputStream paramByteArrayInputStream, h paramh, s params)
    {
      super();
    }
  }
  
  public static final class c
    extends d.g.b.l
    implements d.g.a.a<M>
  {
    public c(ByteArrayInputStream paramByteArrayInputStream, h paramh, s params)
    {
      super();
    }
  }
  
  static final class d
    extends d.g.b.l
    implements d.g.a.a<Set<? extends d.l.b.a.b.f.f>>
  {
    d(h paramh)
    {
      super();
    }
  }
  
  static final class e
    extends d.g.b.l
    implements b<d.l.b.a.b.f.f, Collection<? extends am>>
  {
    e(h paramh)
    {
      super();
    }
  }
  
  static final class f
    extends d.g.b.l
    implements b<d.l.b.a.b.f.f, Collection<? extends ah>>
  {
    f(h paramh)
    {
      super();
    }
  }
  
  static final class g
    extends d.g.b.l
    implements b<d.l.b.a.b.f.f, ar>
  {
    g(h paramh)
    {
      super();
    }
  }
  
  static final class h
    extends d.g.b.l
    implements d.g.a.a<Set<? extends d.l.b.a.b.f.f>>
  {
    h(h paramh)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.k.a.b.h
 * JD-Core Version:    0.7.0.1
 */