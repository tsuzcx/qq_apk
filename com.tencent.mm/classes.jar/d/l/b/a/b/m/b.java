package d.l.b.a.b.m;

import d.l.b.a.b.a.g;
import d.l.b.a.b.b.e;
import d.l.b.a.b.b.l;
import d.l.b.a.b.b.y;
import d.l.b.a.b.f.f;
import d.l.b.a.b.j.d.a;
import d.l.b.a.b.l.j;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public abstract class b
  extends h
  implements at
{
  private int aHQ = 0;
  
  public b(j paramj)
  {
    super(paramj);
  }
  
  private static boolean d(d.l.b.a.b.b.h paramh)
  {
    if (paramh == null) {
      ajW(2);
    }
    return (!u.L(paramh)) && (!d.l.b.a.b.j.c.m(paramh));
  }
  
  protected final Collection<ab> AE(boolean paramBoolean)
  {
    Object localObject2 = gmr().glU();
    if (!(localObject2 instanceof e))
    {
      localObject1 = Collections.emptyList();
      if (localObject1 == null) {
        ajW(3);
      }
      return localObject1;
    }
    Object localObject1 = new d.l.b.a.b.o.h();
    localObject2 = (e)localObject2;
    ((Collection)localObject1).add(((e)localObject2).gne());
    localObject2 = ((e)localObject2).glX();
    if ((paramBoolean) && (localObject2 != null)) {
      ((Collection)localObject1).add(((e)localObject2).gne());
    }
    return localObject1;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof at)) {
      return false;
    }
    if (paramObject.hashCode() != hashCode()) {
      return false;
    }
    if (((at)paramObject).getParameters().size() != getParameters().size()) {
      return false;
    }
    Object localObject = gmr();
    paramObject = ((at)paramObject).gmq();
    if ((!d((d.l.b.a.b.b.h)localObject)) || ((paramObject != null) && (!d(paramObject)))) {
      return false;
    }
    if ((paramObject instanceof e))
    {
      localObject = (e)localObject;
      paramObject = (e)paramObject;
      if (!((e)localObject).gnf().equals(paramObject.gnf())) {
        return false;
      }
      localObject = ((e)localObject).glU();
      for (paramObject = paramObject.glU(); (localObject != null) && (paramObject != null); paramObject = paramObject.glU())
      {
        if ((localObject instanceof y)) {
          return paramObject instanceof y;
        }
        if ((paramObject instanceof y)) {
          return false;
        }
        if ((localObject instanceof d.l.b.a.b.b.ab))
        {
          if (((paramObject instanceof d.l.b.a.b.b.ab)) && (((d.l.b.a.b.b.ab)localObject).gnI().equals(((d.l.b.a.b.b.ab)paramObject).gnI()))) {
            break;
          }
          return false;
        }
        if ((paramObject instanceof d.l.b.a.b.b.ab)) {
          return false;
        }
        if (!((l)localObject).gnf().equals(paramObject.gnf())) {
          return false;
        }
        localObject = ((l)localObject).glU();
      }
      return true;
    }
    return false;
  }
  
  public abstract e gmr();
  
  public final g gnF()
  {
    g localg = a.G(gmr());
    if (localg == null) {
      ajW(1);
    }
    return localg;
  }
  
  protected final ab gov()
  {
    if (g.e(gmr())) {
      return null;
    }
    return gnF().glF();
  }
  
  public final int hashCode()
  {
    int i = this.aHQ;
    if (i != 0) {
      return i;
    }
    e locale = gmr();
    if (d(locale)) {}
    for (i = d.l.b.a.b.j.c.n(locale).hashCode();; i = System.identityHashCode(this))
    {
      this.aHQ = i;
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.m.b
 * JD-Core Version:    0.7.0.1
 */