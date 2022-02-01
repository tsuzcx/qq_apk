package kotlin.l.b.a.b.o;

import TT;;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.a.ae;
import kotlin.a.e;
import kotlin.g.b.a.d;
import kotlin.g.b.ag;
import kotlin.g.b.b;
import kotlin.g.b.p;
import kotlin.t;

public final class i<T>
  extends AbstractSet<T>
{
  public static final b abuE;
  private Object bnW;
  private int size;
  
  static
  {
    AppMethodBeat.i(61401);
    abuE = new b((byte)0);
    AppMethodBeat.o(61401);
  }
  
  public static final <T> i<T> iQq()
  {
    AppMethodBeat.i(61402);
    i locali = b.iQq();
    AppMethodBeat.o(61402);
    return locali;
  }
  
  public final boolean add(T paramT)
  {
    AppMethodBeat.i(61399);
    if (size() == 0) {
      this.bnW = paramT;
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
        if (p.h(this.bnW, paramT))
        {
          AppMethodBeat.o(61399);
          return false;
        }
        this.bnW = new Object[] { this.bnW, paramT };
      }
      if (size() < 5)
      {
        localObject = this.bnW;
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
          p.k(localObject, "elements");
          localObject = (LinkedHashSet)e.b((Object[])localObject, (Collection)new LinkedHashSet(ae.aDD(localObject.length)));
          ((LinkedHashSet)localObject).add(paramT);
        }
        for (paramT = (TT)localObject;; paramT = (TT)localObject)
        {
          this.bnW = paramT;
          break;
          localObject = Arrays.copyOf((Object[])localObject, size() + 1);
          p.j(localObject, "java.util.Arrays.copyOf(this, newSize)");
          localObject[(localObject.length - 1)] = paramT;
        }
      }
      localObject = this.bnW;
      if (localObject == null)
      {
        paramT = new t("null cannot be cast to non-null type kotlin.collections.MutableSet<T>");
        AppMethodBeat.o(61399);
        throw paramT;
      }
    } while (ag.fi(localObject).add(paramT));
    AppMethodBeat.o(61399);
    return false;
  }
  
  public final void clear()
  {
    this.bnW = null;
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
      bool = p.h(this.bnW, paramObject);
      AppMethodBeat.o(61400);
      return bool;
    }
    if (size() < 5)
    {
      localObject = this.bnW;
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
    Object localObject = this.bnW;
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
      localObject = (Iterator)new c(this.bnW);
      AppMethodBeat.o(61398);
      return localObject;
    }
    if (size() < 5)
    {
      localObject = this.bnW;
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(61398);
        throw ((Throwable)localObject);
      }
      localObject = (Iterator)new a((Object[])localObject);
      AppMethodBeat.o(61398);
      return localObject;
    }
    Object localObject = this.bnW;
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type kotlin.collections.MutableSet<T>");
      AppMethodBeat.o(61398);
      throw ((Throwable)localObject);
    }
    localObject = ag.fi(localObject).iterator();
    AppMethodBeat.o(61398);
    return localObject;
  }
  
  static final class a<T>
    implements Iterator<T>, d
  {
    private final Iterator<T> abuF;
    
    public a(T[] paramArrayOfT)
    {
      AppMethodBeat.i(61394);
      this.abuF = b.aj(paramArrayOfT);
      AppMethodBeat.o(61394);
    }
    
    public final boolean hasNext()
    {
      AppMethodBeat.i(61391);
      boolean bool = this.abuF.hasNext();
      AppMethodBeat.o(61391);
      return bool;
    }
    
    public final T next()
    {
      AppMethodBeat.i(61392);
      Object localObject = this.abuF.next();
      AppMethodBeat.o(61392);
      return localObject;
    }
  }
  
  public static final class b
  {
    public static <T> i<T> iQq()
    {
      AppMethodBeat.i(61395);
      i locali = new i((byte)0);
      AppMethodBeat.o(61395);
      return locali;
    }
  }
  
  static final class c<T>
    implements Iterator<T>, d
  {
    private final T aaBC;
    private boolean zca;
    
    public c(T paramT)
    {
      this.aaBC = paramT;
      this.zca = true;
    }
    
    public final boolean hasNext()
    {
      return this.zca;
    }
    
    public final T next()
    {
      AppMethodBeat.i(61396);
      if (this.zca)
      {
        this.zca = false;
        localObject = this.aaBC;
        AppMethodBeat.o(61396);
        return localObject;
      }
      Object localObject = (Throwable)new NoSuchElementException();
      AppMethodBeat.o(61396);
      throw ((Throwable)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.l.b.a.b.o.i
 * JD-Core Version:    0.7.0.1
 */