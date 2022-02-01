package d.l.b.a.b.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class b
{
  public static <N> Boolean a(Collection<N> paramCollection, b<N> paramb, d.g.a.b<N, Boolean> paramb1)
  {
    AppMethodBeat.i(61353);
    if (paramCollection == null) {
      ajW(7);
    }
    if (paramb == null) {
      ajW(8);
    }
    if (paramb1 == null) {
      ajW(9);
    }
    paramCollection = (Boolean)a(paramCollection, paramb, new a()
    {
      public final boolean fh(N paramAnonymousN)
      {
        AppMethodBeat.i(61347);
        if (((Boolean)this.OcB.invoke(paramAnonymousN)).booleanValue()) {
          this.wKm[0] = true;
        }
        if (this.wKm[0] == 0)
        {
          AppMethodBeat.o(61347);
          return true;
        }
        AppMethodBeat.o(61347);
        return false;
      }
    });
    AppMethodBeat.o(61353);
    return paramCollection;
  }
  
  public static <N, R> R a(Collection<N> paramCollection, b<N> paramb, c<N, R> paramc)
  {
    AppMethodBeat.i(61352);
    if (paramCollection == null) {
      ajW(4);
    }
    if (paramb == null) {
      ajW(5);
    }
    paramCollection = a(paramCollection, paramb, new e(), paramc);
    AppMethodBeat.o(61352);
    return paramCollection;
  }
  
  private static <N, R> R a(Collection<N> paramCollection, b<N> paramb, d<N> paramd, c<N, R> paramc)
  {
    AppMethodBeat.i(61351);
    if (paramCollection == null) {
      ajW(0);
    }
    if (paramb == null) {
      ajW(1);
    }
    if (paramc == null) {
      ajW(3);
    }
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      a(paramCollection.next(), paramb, paramd, paramc);
    }
    paramCollection = paramc.gmO();
    AppMethodBeat.o(61351);
    return paramCollection;
  }
  
  private static <N> void a(N paramN, b<N> paramb, d<N> paramd, c<N, ?> paramc)
  {
    AppMethodBeat.i(61354);
    if (paramN == null) {
      ajW(22);
    }
    if (paramb == null) {
      ajW(23);
    }
    if (paramd == null) {
      ajW(24);
    }
    if (paramc == null) {
      ajW(25);
    }
    if (!paramd.fC(paramN))
    {
      AppMethodBeat.o(61354);
      return;
    }
    if (!paramc.fh(paramN))
    {
      AppMethodBeat.o(61354);
      return;
    }
    Iterator localIterator = paramb.fg(paramN).iterator();
    while (localIterator.hasNext()) {
      a(localIterator.next(), paramb, paramd, paramc);
    }
    paramc.fw(paramN);
    AppMethodBeat.o(61354);
  }
  
  public static abstract class a<N, R>
    implements b.c<N, R>
  {
    public boolean fh(N paramN)
    {
      return true;
    }
    
    public void fw(N paramN) {}
  }
  
  public static abstract interface b<N>
  {
    public abstract Iterable<? extends N> fg(N paramN);
  }
  
  public static abstract interface c<N, R>
  {
    public abstract boolean fh(N paramN);
    
    public abstract void fw(N paramN);
    
    public abstract R gmO();
  }
  
  public static abstract interface d<N>
  {
    public abstract boolean fC(N paramN);
  }
  
  public static final class e<N>
    implements b.d<N>
  {
    private final Set<N> OcC;
    
    public e()
    {
      this(new HashSet());
      AppMethodBeat.i(61349);
      AppMethodBeat.o(61349);
    }
    
    private e(Set<N> paramSet)
    {
      this.OcC = paramSet;
    }
    
    public final boolean fC(N paramN)
    {
      AppMethodBeat.i(61350);
      boolean bool = this.OcC.add(paramN);
      AppMethodBeat.o(61350);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.o.b
 * JD-Core Version:    0.7.0.1
 */