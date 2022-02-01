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
    p.h(paramf, "name");
    p.h(parama, "location");
    return (Collection)v.SXr;
  }
  
  public Collection<l> a(d paramd, b<? super f, Boolean> paramb)
  {
    p.h(paramd, "kindFilter");
    p.h(paramb, "nameFilter");
    return (Collection)v.SXr;
  }
  
  public Collection<? extends am> b(f paramf, a parama)
  {
    p.h(paramf, "name");
    p.h(parama, "location");
    return (Collection)v.SXr;
  }
  
  public kotlin.l.b.a.b.b.h c(f paramf, a parama)
  {
    p.h(paramf, "name");
    p.h(parama, "location");
    return null;
  }
  
  public void d(f paramf, a parama)
  {
    p.h(paramf, "name");
    p.h(parama, "location");
    p.h(paramf, "name");
    p.h(parama, "location");
    j localj = (j)this;
    p.h(paramf, "name");
    p.h(parama, "location");
    localj.b(paramf, parama);
  }
  
  public Set<f> hCa()
  {
    Object localObject1 = (Iterable)a(d.TJL, kotlin.l.b.a.b.o.d.hLR());
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
      localCollection.add(((am)((Iterator)localObject1).next()).hAH());
    }
    return (Set)localCollection;
  }
  
  public Set<f> hCb()
  {
    Object localObject1 = (Iterable)a(d.TJM, kotlin.l.b.a.b.o.d.hLR());
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
      localCollection.add(((ax)((Iterator)localObject1).next()).hAH());
    }
    return (Set)localCollection;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.j.f.i
 * JD-Core Version:    0.7.0.1
 */