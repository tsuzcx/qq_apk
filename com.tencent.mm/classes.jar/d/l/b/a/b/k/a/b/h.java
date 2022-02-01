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
  final n LIl;
  private final d.l.b.a.b.l.f LJA;
  private final Map<d.l.b.a.b.f.f, byte[]> LJv;
  private final Map<d.l.b.a.b.f.f, byte[]> LJw;
  private final Map<d.l.b.a.b.f.f, byte[]> LJx;
  private final d.l.b.a.b.l.d<d.l.b.a.b.f.f, ar> LJy;
  private final d.l.b.a.b.l.f LJz;
  private final c<d.l.b.a.b.f.f, Collection<am>> LgP;
  private final c<d.l.b.a.b.f.f, Collection<ah>> LgQ;
  private final d.l.b.a.b.l.f LoY;
  
  protected h(n paramn, Collection<a.h> paramCollection, Collection<a.m> paramCollection1, Collection<a.q> paramCollection2, d.g.a.a<? extends Collection<d.l.b.a.b.f.f>> parama)
  {
    this.LIl = paramn;
    paramn = (Iterable)paramCollection;
    Object localObject1 = (Map)new LinkedHashMap();
    Object localObject2 = paramn.iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      paramn = (q)localObject3;
      d.l.b.a.b.f.f localf = x.b(this.LIl.KVO, ((a.h)paramn).LuF);
      paramCollection = ((Map)localObject1).get(localf);
      paramn = paramCollection;
      if (paramCollection == null)
      {
        paramn = new ArrayList();
        ((Map)localObject1).put(localf, paramn);
      }
      ((List)paramn).add(localObject3);
    }
    this.LJv = cf((Map)localObject1);
    paramn = (Iterable)paramCollection1;
    paramCollection1 = (Map)new LinkedHashMap();
    localObject1 = paramn.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      paramn = (q)localObject2;
      localObject3 = x.b(this.LIl.KVO, ((a.m)paramn).LuF);
      paramCollection = paramCollection1.get(localObject3);
      paramn = paramCollection;
      if (paramCollection == null)
      {
        paramn = new ArrayList();
        paramCollection1.put(localObject3, paramn);
      }
      ((List)paramn).add(localObject2);
    }
    this.LJw = cf(paramCollection1);
    paramn = (Iterable)paramCollection2;
    paramCollection1 = (Map)new LinkedHashMap();
    paramCollection2 = paramn.iterator();
    while (paramCollection2.hasNext())
    {
      localObject1 = paramCollection2.next();
      paramn = (q)localObject1;
      localObject2 = x.b(this.LIl.KVO, ((a.q)paramn).LuF);
      paramCollection = paramCollection1.get(localObject2);
      paramn = paramCollection;
      if (paramCollection == null)
      {
        paramn = new ArrayList();
        paramCollection1.put(localObject2, paramn);
      }
      ((List)paramn).add(localObject1);
    }
    this.LJx = cf(paramCollection1);
    this.LgP = this.LIl.LrK.KZf.I((b)new e(this));
    this.LgQ = this.LIl.LrK.KZf.I((b)new f(this));
    this.LJy = this.LIl.LrK.KZf.J((b)new g(this));
    this.LoY = this.LIl.LrK.KZf.O((d.g.a.a)new d(this));
    this.LJz = this.LIl.LrK.KZf.O((d.g.a.a)new h(this));
    this.LJA = this.LIl.LrK.KZf.O((d.g.a.a)new a(parama));
  }
  
  private final e B(d.l.b.a.b.f.f paramf)
  {
    return this.LIl.LrK.g(z(paramf));
  }
  
  private final void a(Collection<d.l.b.a.b.b.l> paramCollection, d.l.b.a.b.j.f.d paramd, b<? super d.l.b.a.b.f.f, Boolean> paramb, d.l.b.a.b.c.a.a parama)
  {
    Object localObject1 = d.l.b.a.b.j.f.d.LGP;
    Object localObject2;
    if (paramd.aiL(d.l.b.a.b.j.f.d.gbQ()))
    {
      localObject2 = (Collection)fSz();
      localObject1 = new ArrayList();
      localObject2 = ((Collection)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (d.l.b.a.b.f.f)((Iterator)localObject2).next();
        if (((Boolean)paramb.ay(localObject3)).booleanValue()) {
          ((ArrayList)localObject1).addAll(a((d.l.b.a.b.f.f)localObject3, parama));
        }
      }
      localObject2 = (List)localObject1;
      Object localObject3 = f.a.LEM;
      k.g(localObject3, "MemberComparator.NameAnd…MemberComparator.INSTANCE");
      j.a((List)localObject2, (Comparator)localObject3);
      paramCollection.addAll((Collection)localObject1);
    }
    localObject1 = d.l.b.a.b.j.f.d.LGP;
    if (paramd.aiL(d.l.b.a.b.j.f.d.gbP()))
    {
      localObject1 = (Collection)fSy();
      paramd = new ArrayList();
      localObject1 = ((Collection)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (d.l.b.a.b.f.f)((Iterator)localObject1).next();
        if (((Boolean)paramb.ay(localObject2)).booleanValue()) {
          paramd.addAll(b((d.l.b.a.b.f.f)localObject2, parama));
        }
      }
      paramb = (List)paramd;
      parama = f.a.LEM;
      k.g(parama, "MemberComparator.NameAnd…MemberComparator.INSTANCE");
      j.a(paramb, (Comparator)parama);
      paramCollection.addAll((Collection)paramd);
    }
  }
  
  private static Map<d.l.b.a.b.f.f, byte[]> cf(Map<d.l.b.a.b.f.f, ? extends Collection<? extends d.l.b.a.b.h.a>> paramMap)
  {
    Map localMap = (Map)new LinkedHashMap(ae.agH(paramMap.size()));
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
        ((Collection)localObject3).add(y.KTp);
      }
      localMap.put(localObject1, ((ByteArrayOutputStream)localObject2).toByteArray());
    }
    return localMap;
  }
  
  private final Set<d.l.b.a.b.f.f> gck()
  {
    return this.LJx.keySet();
  }
  
  protected boolean C(d.l.b.a.b.f.f paramf)
  {
    k.h(paramf, "name");
    return gcl().contains(paramf);
  }
  
  public Collection<ah> a(d.l.b.a.b.f.f paramf, d.l.b.a.b.c.a.a parama)
  {
    k.h(paramf, "name");
    k.h(parama, "location");
    if (!fSz().contains(paramf)) {
      return (Collection)v.KTF;
    }
    return (Collection)this.LgQ.ay(paramf);
  }
  
  protected final Collection<d.l.b.a.b.b.l> a(d.l.b.a.b.j.f.d paramd, b<? super d.l.b.a.b.f.f, Boolean> paramb, d.l.b.a.b.c.a.a parama)
  {
    k.h(paramd, "kindFilter");
    k.h(paramb, "nameFilter");
    k.h(parama, "location");
    ArrayList localArrayList = new ArrayList(0);
    Object localObject = d.l.b.a.b.j.f.d.LGP;
    if (paramd.aiL(d.l.b.a.b.j.f.d.gbM())) {
      c((Collection)localArrayList, paramb);
    }
    a((Collection)localArrayList, paramd, paramb, parama);
    parama = d.l.b.a.b.j.f.d.LGP;
    if (paramd.aiL(d.l.b.a.b.j.f.d.gbS()))
    {
      parama = gcl().iterator();
      while (parama.hasNext())
      {
        localObject = (d.l.b.a.b.f.f)parama.next();
        if (((Boolean)paramb.ay(localObject)).booleanValue()) {
          d.l.b.a.b.o.a.c((Collection)localArrayList, B((d.l.b.a.b.f.f)localObject));
        }
      }
    }
    parama = d.l.b.a.b.j.f.d.LGP;
    if (paramd.aiL(d.l.b.a.b.j.f.d.gbN()))
    {
      paramd = gck().iterator();
      while (paramd.hasNext())
      {
        parama = (d.l.b.a.b.f.f)paramd.next();
        if (((Boolean)paramb.ay(parama)).booleanValue()) {
          d.l.b.a.b.o.a.c((Collection)localArrayList, this.LJy.ay(parama));
        }
      }
    }
    return (Collection)d.l.b.a.b.o.a.bf(localArrayList);
  }
  
  public Collection<am> b(d.l.b.a.b.f.f paramf, d.l.b.a.b.c.a.a parama)
  {
    k.h(paramf, "name");
    k.h(parama, "location");
    if (!fSy().contains(paramf)) {
      return (Collection)v.KTF;
    }
    return (Collection)this.LgP.ay(paramf);
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
    if (gck().contains(paramf)) {
      return (d.l.b.a.b.b.h)this.LJy.ay(paramf);
    }
    return null;
  }
  
  protected void c(d.l.b.a.b.f.f paramf, Collection<am> paramCollection)
  {
    k.h(paramf, "name");
    k.h(paramCollection, "functions");
  }
  
  protected abstract void c(Collection<d.l.b.a.b.b.l> paramCollection, b<? super d.l.b.a.b.f.f, Boolean> paramb);
  
  public final Set<d.l.b.a.b.f.f> fSy()
  {
    return (Set)d.l.b.a.b.l.h.a(this.LoY, $$delegatedProperties[0]);
  }
  
  public final Set<d.l.b.a.b.f.f> fSz()
  {
    return (Set)d.l.b.a.b.l.h.a(this.LJz, $$delegatedProperties[1]);
  }
  
  protected abstract Set<d.l.b.a.b.f.f> gci();
  
  protected abstract Set<d.l.b.a.b.f.f> gcj();
  
  public final Set<d.l.b.a.b.f.f> gcl()
  {
    return (Set)d.l.b.a.b.l.h.a(this.LJA, $$delegatedProperties[2]);
  }
  
  protected abstract d.l.b.a.b.f.a z(d.l.b.a.b.f.f paramf);
  
  static final class a
    extends d.g.b.l
    implements d.g.a.a<Set<? extends d.l.b.a.b.f.f>>
  {
    a(d.g.a.a parama)
    {
      super();
    }
  }
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.k.a.b.h
 * JD-Core Version:    0.7.0.1
 */