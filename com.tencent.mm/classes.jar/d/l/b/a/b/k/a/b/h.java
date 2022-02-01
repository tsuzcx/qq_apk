package d.l.b.a.b.k.a.b;

import d.a.ae;
import d.a.v;
import d.g.a.b;
import d.g.b.p;
import d.l.b.a.b.b.ah;
import d.l.b.a.b.b.am;
import d.l.b.a.b.b.ar;
import d.l.b.a.b.b.e;
import d.l.b.a.b.e.a.h;
import d.l.b.a.b.e.a.m;
import d.l.b.a.b.e.a.q;
import d.l.b.a.b.h.s;
import d.l.b.a.b.j.f.a;
import d.l.b.a.b.k.a.n;
import d.l.b.a.b.k.a.x;
import d.l.b.a.b.l.c;
import d.z;
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
  private final c<d.l.b.a.b.f.f, Collection<am>> MXL;
  private final c<d.l.b.a.b.f.f, Collection<ah>> MXM;
  private final Map<d.l.b.a.b.f.f, byte[]> NAt;
  private final Map<d.l.b.a.b.f.f, byte[]> NAu;
  private final Map<d.l.b.a.b.f.f, byte[]> NAv;
  private final d.l.b.a.b.l.d<d.l.b.a.b.f.f, ar> NAw;
  private final d.l.b.a.b.l.f NAx;
  private final d.l.b.a.b.l.f NAy;
  private final d.l.b.a.b.l.f NfV;
  final n Nzj;
  
  protected h(n paramn, Collection<a.h> paramCollection, Collection<a.m> paramCollection1, Collection<a.q> paramCollection2, d.g.a.a<? extends Collection<d.l.b.a.b.f.f>> parama)
  {
    this.Nzj = paramn;
    paramn = (Iterable)paramCollection;
    Object localObject1 = (Map)new LinkedHashMap();
    Object localObject2 = paramn.iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      paramn = (d.l.b.a.b.h.q)localObject3;
      d.l.b.a.b.f.f localf = x.b(this.Nzj.MMU, ((a.h)paramn).NlC);
      paramCollection = ((Map)localObject1).get(localf);
      paramn = paramCollection;
      if (paramCollection == null)
      {
        paramn = new ArrayList();
        ((Map)localObject1).put(localf, paramn);
      }
      ((List)paramn).add(localObject3);
    }
    this.NAt = ci((Map)localObject1);
    paramn = (Iterable)paramCollection1;
    paramCollection1 = (Map)new LinkedHashMap();
    localObject1 = paramn.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      paramn = (d.l.b.a.b.h.q)localObject2;
      localObject3 = x.b(this.Nzj.MMU, ((a.m)paramn).NlC);
      paramCollection = paramCollection1.get(localObject3);
      paramn = paramCollection;
      if (paramCollection == null)
      {
        paramn = new ArrayList();
        paramCollection1.put(localObject3, paramn);
      }
      ((List)paramn).add(localObject2);
    }
    this.NAu = ci(paramCollection1);
    paramn = (Iterable)paramCollection2;
    paramCollection1 = (Map)new LinkedHashMap();
    paramCollection2 = paramn.iterator();
    while (paramCollection2.hasNext())
    {
      localObject1 = paramCollection2.next();
      paramn = (d.l.b.a.b.h.q)localObject1;
      localObject2 = x.b(this.Nzj.MMU, ((a.q)paramn).NlC);
      paramCollection = paramCollection1.get(localObject2);
      paramn = paramCollection;
      if (paramCollection == null)
      {
        paramn = new ArrayList();
        paramCollection1.put(localObject2, paramn);
      }
      ((List)paramn).add(localObject1);
    }
    this.NAv = ci(paramCollection1);
    this.MXL = this.Nzj.NiH.MQa.I((b)new e(this));
    this.MXM = this.Nzj.NiH.MQa.I((b)new f(this));
    this.NAw = this.Nzj.NiH.MQa.J((b)new g(this));
    this.NfV = this.Nzj.NiH.MQa.S((d.g.a.a)new d(this));
    this.NAx = this.Nzj.NiH.MQa.S((d.g.a.a)new h(this));
    this.NAy = this.Nzj.NiH.MQa.S((d.g.a.a)new a(parama));
  }
  
  private final e B(d.l.b.a.b.f.f paramf)
  {
    return this.Nzj.NiH.g(z(paramf));
  }
  
  private final void a(Collection<d.l.b.a.b.b.l> paramCollection, d.l.b.a.b.j.f.d paramd, b<? super d.l.b.a.b.f.f, Boolean> paramb, d.l.b.a.b.c.a.a parama)
  {
    Object localObject1 = d.l.b.a.b.j.f.d.NxN;
    Object localObject2;
    if (paramd.alm(d.l.b.a.b.j.f.d.gtp()))
    {
      localObject2 = (Collection)gjX();
      localObject1 = new ArrayList();
      localObject2 = ((Collection)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (d.l.b.a.b.f.f)((Iterator)localObject2).next();
        if (((Boolean)paramb.invoke(localObject3)).booleanValue()) {
          ((ArrayList)localObject1).addAll(a((d.l.b.a.b.f.f)localObject3, parama));
        }
      }
      localObject2 = (List)localObject1;
      Object localObject3 = f.a.NvL;
      p.g(localObject3, "MemberComparator.NameAnd…MemberComparator.INSTANCE");
      d.a.j.a((List)localObject2, (Comparator)localObject3);
      paramCollection.addAll((Collection)localObject1);
    }
    localObject1 = d.l.b.a.b.j.f.d.NxN;
    if (paramd.alm(d.l.b.a.b.j.f.d.gto()))
    {
      localObject1 = (Collection)gjW();
      paramd = new ArrayList();
      localObject1 = ((Collection)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (d.l.b.a.b.f.f)((Iterator)localObject1).next();
        if (((Boolean)paramb.invoke(localObject2)).booleanValue()) {
          paramd.addAll(b((d.l.b.a.b.f.f)localObject2, parama));
        }
      }
      paramb = (List)paramd;
      parama = f.a.NvL;
      p.g(parama, "MemberComparator.NameAnd…MemberComparator.INSTANCE");
      d.a.j.a(paramb, (Comparator)parama);
      paramCollection.addAll((Collection)paramd);
    }
  }
  
  private static Map<d.l.b.a.b.f.f, byte[]> ci(Map<d.l.b.a.b.f.f, ? extends Collection<? extends d.l.b.a.b.h.a>> paramMap)
  {
    Map localMap = (Map)new LinkedHashMap(ae.aji(paramMap.size()));
    paramMap = ((Iterable)paramMap.entrySet()).iterator();
    while (paramMap.hasNext())
    {
      Object localObject2 = paramMap.next();
      Object localObject1 = ((Map.Entry)localObject2).getKey();
      Object localObject3 = (Map.Entry)localObject2;
      localObject2 = new ByteArrayOutputStream();
      Object localObject4 = (Iterable)((Map.Entry)localObject3).getValue();
      localObject3 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject4, 10));
      localObject4 = ((Iterable)localObject4).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        ((d.l.b.a.b.h.a)((Iterator)localObject4).next()).d((OutputStream)localObject2);
        ((Collection)localObject3).add(z.MKo);
      }
      localMap.put(localObject1, ((ByteArrayOutputStream)localObject2).toByteArray());
    }
    return localMap;
  }
  
  private final Set<d.l.b.a.b.f.f> gtJ()
  {
    return this.NAv.keySet();
  }
  
  protected boolean C(d.l.b.a.b.f.f paramf)
  {
    p.h(paramf, "name");
    return gtK().contains(paramf);
  }
  
  public Collection<ah> a(d.l.b.a.b.f.f paramf, d.l.b.a.b.c.a.a parama)
  {
    p.h(paramf, "name");
    p.h(parama, "location");
    if (!gjX().contains(paramf)) {
      return (Collection)v.MKE;
    }
    return (Collection)this.MXM.invoke(paramf);
  }
  
  protected final Collection<d.l.b.a.b.b.l> a(d.l.b.a.b.j.f.d paramd, b<? super d.l.b.a.b.f.f, Boolean> paramb, d.l.b.a.b.c.a.a parama)
  {
    p.h(paramd, "kindFilter");
    p.h(paramb, "nameFilter");
    p.h(parama, "location");
    ArrayList localArrayList = new ArrayList(0);
    Object localObject = d.l.b.a.b.j.f.d.NxN;
    if (paramd.alm(d.l.b.a.b.j.f.d.gtl())) {
      c((Collection)localArrayList, paramb);
    }
    a((Collection)localArrayList, paramd, paramb, parama);
    parama = d.l.b.a.b.j.f.d.NxN;
    if (paramd.alm(d.l.b.a.b.j.f.d.gtr()))
    {
      parama = gtK().iterator();
      while (parama.hasNext())
      {
        localObject = (d.l.b.a.b.f.f)parama.next();
        if (((Boolean)paramb.invoke(localObject)).booleanValue()) {
          d.l.b.a.b.o.a.c((Collection)localArrayList, B((d.l.b.a.b.f.f)localObject));
        }
      }
    }
    parama = d.l.b.a.b.j.f.d.NxN;
    if (paramd.alm(d.l.b.a.b.j.f.d.gtm()))
    {
      paramd = gtJ().iterator();
      while (paramd.hasNext())
      {
        parama = (d.l.b.a.b.f.f)paramd.next();
        if (((Boolean)paramb.invoke(parama)).booleanValue()) {
          d.l.b.a.b.o.a.c((Collection)localArrayList, this.NAw.invoke(parama));
        }
      }
    }
    return (Collection)d.l.b.a.b.o.a.bc(localArrayList);
  }
  
  public Collection<am> b(d.l.b.a.b.f.f paramf, d.l.b.a.b.c.a.a parama)
  {
    p.h(paramf, "name");
    p.h(parama, "location");
    if (!gjW().contains(paramf)) {
      return (Collection)v.MKE;
    }
    return (Collection)this.MXL.invoke(paramf);
  }
  
  protected void b(d.l.b.a.b.f.f paramf, Collection<ah> paramCollection)
  {
    p.h(paramf, "name");
    p.h(paramCollection, "descriptors");
  }
  
  public d.l.b.a.b.b.h c(d.l.b.a.b.f.f paramf, d.l.b.a.b.c.a.a parama)
  {
    p.h(paramf, "name");
    p.h(parama, "location");
    if (C(paramf)) {
      return (d.l.b.a.b.b.h)B(paramf);
    }
    if (gtJ().contains(paramf)) {
      return (d.l.b.a.b.b.h)this.NAw.invoke(paramf);
    }
    return null;
  }
  
  protected void c(d.l.b.a.b.f.f paramf, Collection<am> paramCollection)
  {
    p.h(paramf, "name");
    p.h(paramCollection, "functions");
  }
  
  protected abstract void c(Collection<d.l.b.a.b.b.l> paramCollection, b<? super d.l.b.a.b.f.f, Boolean> paramb);
  
  public final Set<d.l.b.a.b.f.f> gjW()
  {
    return (Set)d.l.b.a.b.l.i.a(this.NfV, cwV[0]);
  }
  
  public final Set<d.l.b.a.b.f.f> gjX()
  {
    return (Set)d.l.b.a.b.l.i.a(this.NAx, cwV[1]);
  }
  
  protected abstract Set<d.l.b.a.b.f.f> gtH();
  
  protected abstract Set<d.l.b.a.b.f.f> gtI();
  
  public final Set<d.l.b.a.b.f.f> gtK()
  {
    return (Set)d.l.b.a.b.l.i.a(this.NAy, cwV[2]);
  }
  
  protected abstract d.l.b.a.b.f.a z(d.l.b.a.b.f.f paramf);
  
  static final class a
    extends d.g.b.q
    implements d.g.a.a<Set<? extends d.l.b.a.b.f.f>>
  {
    a(d.g.a.a parama)
    {
      super();
    }
  }
  
  public static final class b
    extends d.g.b.q
    implements d.g.a.a<M>
  {
    public b(ByteArrayInputStream paramByteArrayInputStream, h paramh, s params)
    {
      super();
    }
  }
  
  public static final class c
    extends d.g.b.q
    implements d.g.a.a<M>
  {
    public c(ByteArrayInputStream paramByteArrayInputStream, h paramh, s params)
    {
      super();
    }
  }
  
  static final class d
    extends d.g.b.q
    implements d.g.a.a<Set<? extends d.l.b.a.b.f.f>>
  {
    d(h paramh)
    {
      super();
    }
  }
  
  static final class e
    extends d.g.b.q
    implements b<d.l.b.a.b.f.f, Collection<? extends am>>
  {
    e(h paramh)
    {
      super();
    }
  }
  
  static final class f
    extends d.g.b.q
    implements b<d.l.b.a.b.f.f, Collection<? extends ah>>
  {
    f(h paramh)
    {
      super();
    }
  }
  
  static final class g
    extends d.g.b.q
    implements b<d.l.b.a.b.f.f, ar>
  {
    g(h paramh)
    {
      super();
    }
  }
  
  static final class h
    extends d.g.b.q
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