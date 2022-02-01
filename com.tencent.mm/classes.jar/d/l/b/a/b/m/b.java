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
  private int aFZ = 0;
  
  public b(i parami)
  {
    super(parami);
  }
  
  private static boolean d(d.l.b.a.b.b.h paramh)
  {
    if (paramh == null) {
      agL(2);
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
    Object localObject = fQr();
    paramObject = ((at)paramObject).fQq();
    if ((!d((d.l.b.a.b.b.h)localObject)) || ((paramObject != null) && (!d(paramObject)))) {
      return false;
    }
    if ((paramObject instanceof e))
    {
      localObject = (e)localObject;
      paramObject = (e)paramObject;
      if (!((e)localObject).fRf().equals(paramObject.fRf())) {
        return false;
      }
      localObject = ((e)localObject).fPU();
      for (paramObject = paramObject.fPU(); (localObject != null) && (paramObject != null); paramObject = paramObject.fPU())
      {
        if ((localObject instanceof y)) {
          return paramObject instanceof y;
        }
        if ((paramObject instanceof y)) {
          return false;
        }
        if ((localObject instanceof d.l.b.a.b.b.ab))
        {
          if (((paramObject instanceof d.l.b.a.b.b.ab)) && (((d.l.b.a.b.b.ab)localObject).fRH().equals(((d.l.b.a.b.b.ab)paramObject).fRH()))) {
            break;
          }
          return false;
        }
        if ((paramObject instanceof d.l.b.a.b.b.ab)) {
          return false;
        }
        if (!((l)localObject).fRf().equals(paramObject.fRf())) {
          return false;
        }
        localObject = ((l)localObject).fPU();
      }
      return true;
    }
    return false;
  }
  
  public abstract e fQr();
  
  public final g fRE()
  {
    g localg = a.G(fQr());
    if (localg == null) {
      agL(1);
    }
    return localg;
  }
  
  protected final ab fSv()
  {
    if (g.e(fQr())) {
      return null;
    }
    return fRE().fPF();
  }
  
  public final int hashCode()
  {
    int i = this.aFZ;
    if (i != 0) {
      return i;
    }
    e locale = fQr();
    if (d(locale)) {}
    for (i = d.l.b.a.b.j.c.n(locale).hashCode();; i = System.identityHashCode(this))
    {
      this.aFZ = i;
      return i;
    }
  }
  
  protected final Collection<ab> zD(boolean paramBoolean)
  {
    Object localObject2 = fQr().fPU();
    if (!(localObject2 instanceof e))
    {
      localObject1 = Collections.emptyList();
      if (localObject1 == null) {
        agL(3);
      }
      return localObject1;
    }
    Object localObject1 = new d.l.b.a.b.o.h();
    localObject2 = (e)localObject2;
    ((Collection)localObject1).add(((e)localObject2).fRe());
    localObject2 = ((e)localObject2).fPX();
    if ((paramBoolean) && (localObject2 != null)) {
      ((Collection)localObject1).add(((e)localObject2).fRe());
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.m.b
 * JD-Core Version:    0.7.0.1
 */