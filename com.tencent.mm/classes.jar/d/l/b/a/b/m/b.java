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
      ajm(2);
    }
    return (!u.L(paramh)) && (!d.l.b.a.b.j.c.m(paramh));
  }
  
  protected final Collection<ab> Ar(boolean paramBoolean)
  {
    Object localObject2 = ghP().ghs();
    if (!(localObject2 instanceof e))
    {
      localObject1 = Collections.emptyList();
      if (localObject1 == null) {
        ajm(3);
      }
      return localObject1;
    }
    Object localObject1 = new d.l.b.a.b.o.h();
    localObject2 = (e)localObject2;
    ((Collection)localObject1).add(((e)localObject2).giC());
    localObject2 = ((e)localObject2).ghv();
    if ((paramBoolean) && (localObject2 != null)) {
      ((Collection)localObject1).add(((e)localObject2).giC());
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
    Object localObject = ghP();
    paramObject = ((at)paramObject).ghO();
    if ((!d((d.l.b.a.b.b.h)localObject)) || ((paramObject != null) && (!d(paramObject)))) {
      return false;
    }
    if ((paramObject instanceof e))
    {
      localObject = (e)localObject;
      paramObject = (e)paramObject;
      if (!((e)localObject).giD().equals(paramObject.giD())) {
        return false;
      }
      localObject = ((e)localObject).ghs();
      for (paramObject = paramObject.ghs(); (localObject != null) && (paramObject != null); paramObject = paramObject.ghs())
      {
        if ((localObject instanceof y)) {
          return paramObject instanceof y;
        }
        if ((paramObject instanceof y)) {
          return false;
        }
        if ((localObject instanceof d.l.b.a.b.b.ab))
        {
          if (((paramObject instanceof d.l.b.a.b.b.ab)) && (((d.l.b.a.b.b.ab)localObject).gjg().equals(((d.l.b.a.b.b.ab)paramObject).gjg()))) {
            break;
          }
          return false;
        }
        if ((paramObject instanceof d.l.b.a.b.b.ab)) {
          return false;
        }
        if (!((l)localObject).giD().equals(paramObject.giD())) {
          return false;
        }
        localObject = ((l)localObject).ghs();
      }
      return true;
    }
    return false;
  }
  
  public abstract e ghP();
  
  protected final ab gjT()
  {
    if (g.e(ghP())) {
      return null;
    }
    return gjd().ghd();
  }
  
  public final g gjd()
  {
    g localg = a.G(ghP());
    if (localg == null) {
      ajm(1);
    }
    return localg;
  }
  
  public final int hashCode()
  {
    int i = this.aHQ;
    if (i != 0) {
      return i;
    }
    e locale = ghP();
    if (d(locale)) {}
    for (i = d.l.b.a.b.j.c.n(locale).hashCode();; i = System.identityHashCode(this))
    {
      this.aHQ = i;
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.m.b
 * JD-Core Version:    0.7.0.1
 */