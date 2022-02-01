package kotlin.l.b.a.b.m;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.l.b.a.b.a.g;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.j.d.a;
import kotlin.l.b.a.b.l.j;

public abstract class b
  extends h
  implements at
{
  private int aHK = 0;
  
  public b(j paramj)
  {
    super(paramj);
  }
  
  private static boolean d(kotlin.l.b.a.b.b.h paramh)
  {
    if (paramh == null) {
      atM(2);
    }
    return (!u.L(paramh)) && (!kotlin.l.b.a.b.j.c.m(paramh));
  }
  
  protected final Collection<ab> EU(boolean paramBoolean)
  {
    Object localObject2 = hzT().hzx();
    if (!(localObject2 instanceof e))
    {
      localObject1 = Collections.emptyList();
      if (localObject1 == null) {
        atM(3);
      }
      return localObject1;
    }
    Object localObject1 = new kotlin.l.b.a.b.o.h();
    localObject2 = (e)localObject2;
    ((Collection)localObject1).add(((e)localObject2).hAG());
    localObject2 = ((e)localObject2).hzA();
    if ((paramBoolean) && (localObject2 != null)) {
      ((Collection)localObject1).add(((e)localObject2).hAG());
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
    Object localObject = hzT();
    paramObject = ((at)paramObject).hzS();
    if ((!d((kotlin.l.b.a.b.b.h)localObject)) || ((paramObject != null) && (!d(paramObject)))) {
      return false;
    }
    if ((paramObject instanceof e))
    {
      localObject = (e)localObject;
      paramObject = (e)paramObject;
      if (!((e)localObject).hAH().equals(paramObject.hAH())) {
        return false;
      }
      localObject = ((e)localObject).hzx();
      for (paramObject = paramObject.hzx(); (localObject != null) && (paramObject != null); paramObject = paramObject.hzx())
      {
        if ((localObject instanceof y)) {
          return paramObject instanceof y;
        }
        if ((paramObject instanceof y)) {
          return false;
        }
        if ((localObject instanceof kotlin.l.b.a.b.b.ab))
        {
          if (((paramObject instanceof kotlin.l.b.a.b.b.ab)) && (((kotlin.l.b.a.b.b.ab)localObject).hBk().equals(((kotlin.l.b.a.b.b.ab)paramObject).hBk()))) {
            break;
          }
          return false;
        }
        if ((paramObject instanceof kotlin.l.b.a.b.b.ab)) {
          return false;
        }
        if (!((l)localObject).hAH().equals(paramObject.hAH())) {
          return false;
        }
        localObject = ((l)localObject).hzx();
      }
      return true;
    }
    return false;
  }
  
  protected final ab hBX()
  {
    if (g.e(hzT())) {
      return null;
    }
    return hBh().hzi();
  }
  
  public final g hBh()
  {
    g localg = a.G(hzT());
    if (localg == null) {
      atM(1);
    }
    return localg;
  }
  
  public final int hashCode()
  {
    int i = this.aHK;
    if (i != 0) {
      return i;
    }
    e locale = hzT();
    if (d(locale)) {}
    for (i = kotlin.l.b.a.b.j.c.n(locale).hashCode();; i = System.identityHashCode(this))
    {
      this.aHK = i;
      return i;
    }
  }
  
  public abstract e hzT();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.m.b
 * JD-Core Version:    0.7.0.1
 */