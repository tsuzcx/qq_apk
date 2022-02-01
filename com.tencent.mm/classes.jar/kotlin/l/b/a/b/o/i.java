package kotlin.l.b.a.b.o;

import TT;;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.a.ae;
import kotlin.a.e;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.t;

public final class i<T>
  extends AbstractSet<T>
{
  public static final b TSf;
  private Object data;
  private int size;
  
  static
  {
    AppMethodBeat.i(61401);
    TSf = new b((byte)0);
    AppMethodBeat.o(61401);
  }
  
  public static final <T> i<T> hLZ()
  {
    AppMethodBeat.i(61402);
    i locali = b.hLZ();
    AppMethodBeat.o(61402);
    return locali;
  }
  
  public final boolean add(T paramT)
  {
    AppMethodBeat.i(61399);
    if (size() == 0) {
      this.data = paramT;
    }
    Object localObject;
    do
    {
      for (;;)
      {
        this.size = (size() + 1);
        AppMethodBeat.o(61399);
        return true;
        if (size() != 1) {
          break;
        }
        if (p.j(this.data, paramT))
        {
          AppMethodBeat.o(61399);
          return false;
        }
        this.data = new Object[] { this.data, paramT };
      }
      if (size() < 5)
      {
        localObject = this.data;
        if (localObject == null)
        {
          paramT = new t("null cannot be cast to non-null type kotlin.Array<T>");
          AppMethodBeat.o(61399);
          throw paramT;
        }
        localObject = (Object[])localObject;
        if (e.contains((Object[])localObject, paramT))
        {
          AppMethodBeat.o(61399);
          return false;
        }
        if (size() == 4)
        {
          localObject = Arrays.copyOf((Object[])localObject, localObject.length);
          p.h(localObject, "elements");
          localObject = (LinkedHashSet)e.b((Object[])localObject, (Collection)new LinkedHashSet(ae.atJ(localObject.length)));
          ((LinkedHashSet)localObject).add(paramT);
        }
        for (paramT = (TT)localObject;; paramT = (TT)localObject)
        {
          this.data = paramT;
          break;
          localObject = Arrays.copyOf((Object[])localObject, size() + 1);
          p.g(localObject, "java.util.Arrays.copyOf(this, newSize)");
          localObject[(localObject.length - 1)] = paramT;
        }
      }
      localObject = this.data;
      if (localObject == null)
      {
        paramT = new t("null cannot be cast to non-null type kotlin.collections.MutableSet<T>");
        AppMethodBeat.o(61399);
        throw paramT;
      }
    } while (af.fb(localObject).add(paramT));
    AppMethodBeat.o(61399);
    return false;
  }
  
  public final void clear()
  {
    this.data = null;
    this.size = 0;
  }
  
  public final boolean contains(Object paramObject)
  {
    AppMethodBeat.i(61400);
    if (size() == 0)
    {
      AppMethodBeat.o(61400);
      return false;
    }
    if (size() == 1)
    {
      bool = p.j(this.data, paramObject);
      AppMethodBeat.o(61400);
      return bool;
    }
    if (size() < 5)
    {
      localObject = this.data;
      if (localObject == null)
      {
        paramObject = new t("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(61400);
        throw paramObject;
      }
      bool = e.contains((Object[])localObject, paramObject);
      AppMethodBeat.o(61400);
      return bool;
    }
    Object localObject = this.data;
    if (localObject == null)
    {
      paramObject = new t("null cannot be cast to non-null type kotlin.collections.Set<T>");
      AppMethodBeat.o(61400);
      throw paramObject;
    }
    boolean bool = ((Set)localObject).contains(paramObject);
    AppMethodBeat.o(61400);
    return bool;
  }
  
  public final Iterator<T> iterator()
  {
    AppMethodBeat.i(61398);
    if (size() == 0)
    {
      localObject = Collections.emptySet().iterator();
      AppMethodBeat.o(61398);
      return localObject;
    }
    if (size() == 1)
    {
      localObject = (Iterator)new i.c(this.data);
      AppMethodBeat.o(61398);
      return localObject;
    }
    if (size() < 5)
    {
      localObject = this.data;
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(61398);
        throw ((Throwable)localObject);
      }
      localObject = (Iterator)new i.a((Object[])localObject);
      AppMethodBeat.o(61398);
      return localObject;
    }
    Object localObject = this.data;
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type kotlin.collections.MutableSet<T>");
      AppMethodBeat.o(61398);
      throw ((Throwable)localObject);
    }
    localObject = af.fb(localObject).iterator();
    AppMethodBeat.o(61398);
    return localObject;
  }
  
  public static final class b
  {
    public static <T> i<T> hLZ()
    {
      AppMethodBeat.i(61395);
      i locali = new i((byte)0);
      AppMethodBeat.o(61395);
      return locali;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.o.i
 * JD-Core Version:    0.7.0.1
 */