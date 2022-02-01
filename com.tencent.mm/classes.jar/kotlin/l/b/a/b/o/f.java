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
import kotlin.a.ak;
import kotlin.a.k;
import kotlin.ah;
import kotlin.g.b.an;
import kotlin.g.b.s;

public final class f<T>
  extends AbstractSet<T>
{
  public static final f.b ajtJ;
  private Object cpt;
  private int size;
  
  static
  {
    AppMethodBeat.i(61401);
    ajtJ = new f.b((byte)0);
    AppMethodBeat.o(61401);
  }
  
  public static final <T> f<T> kBe()
  {
    AppMethodBeat.i(61402);
    f localf = f.b.kBe();
    AppMethodBeat.o(61402);
    return localf;
  }
  
  public final boolean add(T paramT)
  {
    AppMethodBeat.i(61399);
    if (size() == 0) {
      this.cpt = paramT;
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
        if (s.p(this.cpt, paramT))
        {
          AppMethodBeat.o(61399);
          return false;
        }
        this.cpt = new Object[] { this.cpt, paramT };
      }
      if (size() < 5)
      {
        localObject = this.cpt;
        if (localObject == null)
        {
          paramT = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
          AppMethodBeat.o(61399);
          throw paramT;
        }
        localObject = (Object[])localObject;
        if (k.contains((Object[])localObject, paramT))
        {
          AppMethodBeat.o(61399);
          return false;
        }
        if (size() == 4)
        {
          localObject = Arrays.copyOf((Object[])localObject, localObject.length);
          s.u(localObject, "elements");
          localObject = (LinkedHashSet)k.b((Object[])localObject, (Collection)new LinkedHashSet(ak.aKi(localObject.length)));
          ((LinkedHashSet)localObject).add(paramT);
          paramT = ah.aiuX;
        }
        for (paramT = (TT)localObject;; paramT = (TT)localObject)
        {
          this.cpt = paramT;
          break;
          localObject = Arrays.copyOf((Object[])localObject, size() + 1);
          s.s(localObject, "java.util.Arrays.copyOf(this, newSize)");
          localObject[(localObject.length - 1)] = paramT;
          paramT = ah.aiuX;
        }
      }
      localObject = this.cpt;
      if (localObject == null)
      {
        paramT = new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableSet<T of org.jetbrains.kotlin.utils.SmartSet>");
        AppMethodBeat.o(61399);
        throw paramT;
      }
    } while (an.hG(localObject).add(paramT));
    AppMethodBeat.o(61399);
    return false;
  }
  
  public final void clear()
  {
    this.cpt = null;
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
      bool = s.p(this.cpt, paramObject);
      AppMethodBeat.o(61400);
      return bool;
    }
    if (size() < 5)
    {
      localObject = this.cpt;
      if (localObject == null)
      {
        paramObject = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
        AppMethodBeat.o(61400);
        throw paramObject;
      }
      bool = k.contains((Object[])localObject, paramObject);
      AppMethodBeat.o(61400);
      return bool;
    }
    Object localObject = this.cpt;
    if (localObject == null)
    {
      paramObject = new NullPointerException("null cannot be cast to non-null type kotlin.collections.Set<T of org.jetbrains.kotlin.utils.SmartSet>");
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
      localObject = (Iterator)new f.c(this.cpt);
      AppMethodBeat.o(61398);
      return localObject;
    }
    if (size() < 5)
    {
      localObject = this.cpt;
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
        AppMethodBeat.o(61398);
        throw ((Throwable)localObject);
      }
      localObject = (Iterator)new f.a((Object[])localObject);
      AppMethodBeat.o(61398);
      return localObject;
    }
    Object localObject = this.cpt;
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableSet<T of org.jetbrains.kotlin.utils.SmartSet>");
      AppMethodBeat.o(61398);
      throw ((Throwable)localObject);
    }
    localObject = an.hG(localObject).iterator();
    AppMethodBeat.o(61398);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.o.f
 * JD-Core Version:    0.7.0.1
 */