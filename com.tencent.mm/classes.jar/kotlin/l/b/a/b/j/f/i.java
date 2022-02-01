package kotlin.l.b.a.b.j.f;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.a.v;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.am;
import kotlin.l.b.a.b.b.ax;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.c.a.a;
import kotlin.l.b.a.b.f.f;

public abstract class i
  implements h
{
  public Collection<? extends ah> a(f paramf, a parama)
  {
    p.k(paramf, "name");
    p.k(parama, "location");
    return (Collection)v.aaAd;
  }
  
  public Collection<l> a(d paramd, b<? super f, Boolean> paramb)
  {
    p.k(paramd, "kindFilter");
    p.k(paramb, "nameFilter");
    return (Collection)v.aaAd;
  }
  
  public Collection<? extends am> b(f paramf, a parama)
  {
    p.k(paramf, "name");
    p.k(parama, "location");
    return (Collection)v.aaAd;
  }
  
  public kotlin.l.b.a.b.b.h c(f paramf, a parama)
  {
    p.k(paramf, "name");
    p.k(parama, "location");
    return null;
  }
  
  public void d(f paramf, a parama)
  {
    p.k(paramf, "name");
    p.k(parama, "location");
    p.k(paramf, "name");
    p.k(parama, "location");
    j localj = (j)this;
    p.k(paramf, "name");
    p.k(parama, "location");
    localj.b(paramf, parama);
  }
  
  public Set<f> iGp()
  {
    Object localObject1 = (Iterable)a(d.abmn, kotlin.l.b.a.b.o.d.iQj());
    Collection localCollection = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if ((localObject2 instanceof am)) {
        localCollection.add(localObject2);
      }
    }
    localObject1 = (Iterable)localCollection;
    localCollection = (Collection)new LinkedHashSet();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      localCollection.add(((am)((Iterator)localObject1).next()).iEU());
    }
    return (Set)localCollection;
  }
  
  public Set<f> iGq()
  {
    Object localObject1 = (Iterable)a(d.abmo, kotlin.l.b.a.b.o.d.iQj());
    Collection localCollection = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if ((localObject2 instanceof ax)) {
        localCollection.add(localObject2);
      }
    }
    localObject1 = (Iterable)localCollection;
    localCollection = (Collection)new LinkedHashSet();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      localCollection.add(((ax)((Iterator)localObject1).next()).iEU());
    }
    return (Set)localCollection;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.j.f.i
 * JD-Core Version:    0.7.0.1
 */