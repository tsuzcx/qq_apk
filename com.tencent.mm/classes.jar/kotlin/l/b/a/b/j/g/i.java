package kotlin.l.b.a.b.j.g;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.a.ab;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.ap;
import kotlin.l.b.a.b.b.au;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.f.f;

public abstract class i
  implements h
{
  public Collection<? extends ap> a(f paramf, kotlin.l.b.a.b.c.a.b paramb)
  {
    s.u(paramf, "name");
    s.u(paramb, "location");
    return (Collection)ab.aivy;
  }
  
  public Collection<l> a(d paramd, kotlin.g.a.b<? super f, Boolean> paramb)
  {
    s.u(paramd, "kindFilter");
    s.u(paramb, "nameFilter");
    return (Collection)ab.aivy;
  }
  
  public Collection<? extends au> b(f paramf, kotlin.l.b.a.b.c.a.b paramb)
  {
    s.u(paramf, "name");
    s.u(paramb, "location");
    return (Collection)ab.aivy;
  }
  
  public kotlin.l.b.a.b.b.h c(f paramf, kotlin.l.b.a.b.c.a.b paramb)
  {
    s.u(paramf, "name");
    s.u(paramb, "location");
    return null;
  }
  
  public void d(f paramf, kotlin.l.b.a.b.c.a.b paramb)
  {
    h.b.a((h)this, paramf, paramb);
  }
  
  public Set<f> kpL()
  {
    Object localObject1 = (Iterable)a(d.ajkX, kotlin.l.b.a.b.o.d.kAZ());
    Collection localCollection = (Collection)new LinkedHashSet();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if ((localObject2 instanceof au))
      {
        localObject2 = ((au)localObject2).kok();
        s.s(localObject2, "it.name");
        localCollection.add(localObject2);
      }
    }
    return (Set)localCollection;
  }
  
  public Set<f> kpM()
  {
    return null;
  }
  
  public Set<f> kpN()
  {
    Object localObject1 = (Iterable)a(d.ajkY, kotlin.l.b.a.b.o.d.kAZ());
    Collection localCollection = (Collection)new LinkedHashSet();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if ((localObject2 instanceof au))
      {
        localObject2 = ((au)localObject2).kok();
        s.s(localObject2, "it.name");
        localCollection.add(localObject2);
      }
    }
    return (Set)localCollection;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.j.g.i
 * JD-Core Version:    0.7.0.1
 */