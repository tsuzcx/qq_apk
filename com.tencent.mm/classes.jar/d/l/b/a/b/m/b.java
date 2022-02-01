package d.l.b.a.b.m;

import d.l.b.a.b.a.g;
import d.l.b.a.b.b.e;
import d.l.b.a.b.b.l;
import d.l.b.a.b.b.y;
import d.l.b.a.b.f.f;
import d.l.b.a.b.j.d.a;
import d.l.b.a.b.l.i;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public abstract class b
  extends h
  implements at
{
  private int aFj = 0;
  
  public b(i parami)
  {
    super(parami);
  }
  
  private static boolean d(d.l.b.a.b.b.h paramh)
  {
    if (paramh == null) {
      adP(2);
    }
    return (!u.L(paramh)) && (!d.l.b.a.b.j.c.m(paramh));
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
    Object localObject = fxN();
    paramObject = ((at)paramObject).fxM();
    if ((!d((d.l.b.a.b.b.h)localObject)) || ((paramObject != null) && (!d(paramObject)))) {
      return false;
    }
    if ((paramObject instanceof e))
    {
      localObject = (e)localObject;
      paramObject = (e)paramObject;
      if (!((e)localObject).fyB().equals(paramObject.fyB())) {
        return false;
      }
      localObject = ((e)localObject).fxq();
      for (paramObject = paramObject.fxq(); (localObject != null) && (paramObject != null); paramObject = paramObject.fxq())
      {
        if ((localObject instanceof y)) {
          return paramObject instanceof y;
        }
        if ((paramObject instanceof y)) {
          return false;
        }
        if ((localObject instanceof d.l.b.a.b.b.ab))
        {
          if (((paramObject instanceof d.l.b.a.b.b.ab)) && (((d.l.b.a.b.b.ab)localObject).fzd().equals(((d.l.b.a.b.b.ab)paramObject).fzd()))) {
            break;
          }
          return false;
        }
        if ((paramObject instanceof d.l.b.a.b.b.ab)) {
          return false;
        }
        if (!((l)localObject).fyB().equals(paramObject.fyB())) {
          return false;
        }
        localObject = ((l)localObject).fxq();
      }
      return true;
    }
    return false;
  }
  
  public abstract e fxN();
  
  protected final ab fzR()
  {
    if (g.e(fxN())) {
      return null;
    }
    return fza().fxb();
  }
  
  public final g fza()
  {
    g localg = a.G(fxN());
    if (localg == null) {
      adP(1);
    }
    return localg;
  }
  
  public final int hashCode()
  {
    int i = this.aFj;
    if (i != 0) {
      return i;
    }
    e locale = fxN();
    if (d(locale)) {}
    for (i = d.l.b.a.b.j.c.n(locale).hashCode();; i = System.identityHashCode(this))
    {
      this.aFj = i;
      return i;
    }
  }
  
  protected final Collection<ab> yl(boolean paramBoolean)
  {
    Object localObject2 = fxN().fxq();
    if (!(localObject2 instanceof e))
    {
      localObject1 = Collections.emptyList();
      if (localObject1 == null) {
        adP(3);
      }
      return localObject1;
    }
    Object localObject1 = new d.l.b.a.b.o.h();
    localObject2 = (e)localObject2;
    ((Collection)localObject1).add(((e)localObject2).fyA());
    localObject2 = ((e)localObject2).fxt();
    if ((paramBoolean) && (localObject2 != null)) {
      ((Collection)localObject1).add(((e)localObject2).fyA());
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.m.b
 * JD-Core Version:    0.7.0.1
 */