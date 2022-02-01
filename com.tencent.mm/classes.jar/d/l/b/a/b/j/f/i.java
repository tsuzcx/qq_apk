package d.l.b.a.b.j.f;

import d.a.v;
import d.g.a.b;
import d.g.b.k;
import d.l.b.a.b.b.ah;
import d.l.b.a.b.b.am;
import d.l.b.a.b.b.ax;
import d.l.b.a.b.b.l;
import d.l.b.a.b.c.a.a;
import d.l.b.a.b.f.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public abstract class i
  implements h
{
  public Collection<? extends ah> a(f paramf, a parama)
  {
    k.h(paramf, "name");
    k.h(parama, "location");
    return (Collection)v.Jgl;
  }
  
  public Collection<l> a(d paramd, b<? super f, Boolean> paramb)
  {
    k.h(paramd, "kindFilter");
    k.h(paramb, "nameFilter");
    return (Collection)v.Jgl;
  }
  
  public Collection<? extends am> b(f paramf, a parama)
  {
    k.h(paramf, "name");
    k.h(parama, "location");
    return (Collection)v.Jgl;
  }
  
  public d.l.b.a.b.b.h c(f paramf, a parama)
  {
    k.h(paramf, "name");
    k.h(parama, "location");
    return null;
  }
  
  public void d(f paramf, a parama)
  {
    k.h(paramf, "name");
    k.h(parama, "location");
    k.h(paramf, "name");
    k.h(parama, "location");
    j localj = (j)this;
    k.h(paramf, "name");
    k.h(parama, "location");
    localj.b(paramf, parama);
  }
  
  public Set<f> fzU()
  {
    Object localObject1 = (Iterable)a(d.JTr, d.l.b.a.b.o.d.fKi());
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
      localCollection.add(((am)((Iterator)localObject1).next()).fyB());
    }
    return (Set)localCollection;
  }
  
  public Set<f> fzV()
  {
    Object localObject1 = (Iterable)a(d.JTs, d.l.b.a.b.o.d.fKi());
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
      localCollection.add(((ax)((Iterator)localObject1).next()).fyB());
    }
    return (Set)localCollection;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.j.f.i
 * JD-Core Version:    0.7.0.1
 */