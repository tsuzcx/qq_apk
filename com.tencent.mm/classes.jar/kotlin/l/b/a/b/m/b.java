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
{
  private int aNf = 0;
  
  public b(j paramj)
  {
    super(paramj);
  }
  
  private static boolean d(kotlin.l.b.a.b.b.h paramh)
  {
    if (paramh == null) {
      aDG(2);
    }
    return (!u.L(paramh)) && (!kotlin.l.b.a.b.j.c.m(paramh));
  }
  
  protected final Collection<ab> JB(boolean paramBoolean)
  {
    Object localObject2 = iEg().iDJ();
    if (!(localObject2 instanceof e))
    {
      localObject1 = Collections.emptyList();
      if (localObject1 == null) {
        aDG(3);
      }
      return localObject1;
    }
    Object localObject1 = new kotlin.l.b.a.b.o.h();
    localObject2 = (e)localObject2;
    ((Collection)localObject1).add(((e)localObject2).iET());
    localObject2 = ((e)localObject2).iDM();
    if ((paramBoolean) && (localObject2 != null)) {
      ((Collection)localObject1).add(((e)localObject2).iET());
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
    if (((at)paramObject).iCb().size() != iCb().size()) {
      return false;
    }
    Object localObject = iEg();
    paramObject = ((at)paramObject).iEf();
    if ((!d((kotlin.l.b.a.b.b.h)localObject)) || ((paramObject != null) && (!d(paramObject)))) {
      return false;
    }
    if ((paramObject instanceof e))
    {
      localObject = (e)localObject;
      paramObject = (e)paramObject;
      if (!((e)localObject).iEU().equals(paramObject.iEU())) {
        return false;
      }
      localObject = ((e)localObject).iDJ();
      for (paramObject = paramObject.iDJ(); (localObject != null) && (paramObject != null); paramObject = paramObject.iDJ())
      {
        if ((localObject instanceof y)) {
          return paramObject instanceof y;
        }
        if ((paramObject instanceof y)) {
          return false;
        }
        if ((localObject instanceof kotlin.l.b.a.b.b.ab))
        {
          if (((paramObject instanceof kotlin.l.b.a.b.b.ab)) && (((kotlin.l.b.a.b.b.ab)localObject).iFy().equals(((kotlin.l.b.a.b.b.ab)paramObject).iFy()))) {
            break;
          }
          return false;
        }
        if ((paramObject instanceof kotlin.l.b.a.b.b.ab)) {
          return false;
        }
        if (!((l)localObject).iEU().equals(paramObject.iEU())) {
          return false;
        }
        localObject = ((l)localObject).iDJ();
      }
      return true;
    }
    return false;
  }
  
  public final int hashCode()
  {
    int i = this.aNf;
    if (i != 0) {
      return i;
    }
    e locale = iEg();
    if (d(locale)) {}
    for (i = kotlin.l.b.a.b.j.c.n(locale).hashCode();; i = System.identityHashCode(this))
    {
      this.aNf = i;
      return i;
    }
  }
  
  public abstract e iEg();
  
  public final g iFv()
  {
    g localg = a.G(iEg());
    if (localg == null) {
      aDG(1);
    }
    return localg;
  }
  
  protected final ab iGm()
  {
    if (g.e(iEg())) {
      return null;
    }
    return iFv().iDu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.m.b
 * JD-Core Version:    0.7.0.1
 */