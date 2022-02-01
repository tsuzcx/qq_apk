package d.l.b.a.b.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;

public final class b
{
  public static <N> Boolean a(Collection<N> paramCollection, b<N> paramb, d.g.a.b<N, Boolean> paramb1)
  {
    AppMethodBeat.i(61353);
    if (paramCollection == null) {
      ajm(7);
    }
    if (paramb == null) {
      ajm(8);
    }
    if (paramb1 == null) {
      ajm(9);
    }
    paramCollection = (Boolean)a(paramCollection, paramb, new a()
    {
      public final boolean fe(N paramAnonymousN)
      {
        AppMethodBeat.i(61347);
        if (((Boolean)this.NFv.invoke(paramAnonymousN)).booleanValue()) {
          this.wuC[0] = true;
        }
        if (this.wuC[0] == 0)
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
      ajm(4);
    }
    if (paramb == null) {
      ajm(5);
    }
    paramCollection = a(paramCollection, paramb, new b.e(), paramc);
    AppMethodBeat.o(61352);
    return paramCollection;
  }
  
  private static <N, R> R a(Collection<N> paramCollection, b<N> paramb, b.d<N> paramd, c<N, R> paramc)
  {
    AppMethodBeat.i(61351);
    if (paramCollection == null) {
      ajm(0);
    }
    if (paramb == null) {
      ajm(1);
    }
    if (paramc == null) {
      ajm(3);
    }
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      a(paramCollection.next(), paramb, paramd, paramc);
    }
    paramCollection = paramc.gim();
    AppMethodBeat.o(61351);
    return paramCollection;
  }
  
  private static <N> void a(N paramN, b<N> paramb, b.d<N> paramd, c<N, ?> paramc)
  {
    AppMethodBeat.i(61354);
    if (paramN == null) {
      ajm(22);
    }
    if (paramb == null) {
      ajm(23);
    }
    if (paramd == null) {
      ajm(24);
    }
    if (paramc == null) {
      ajm(25);
    }
    if (!paramd.fz(paramN))
    {
      AppMethodBeat.o(61354);
      return;
    }
    if (!paramc.fe(paramN))
    {
      AppMethodBeat.o(61354);
      return;
    }
    Iterator localIterator = paramb.fd(paramN).iterator();
    while (localIterator.hasNext()) {
      a(localIterator.next(), paramb, paramd, paramc);
    }
    paramc.ft(paramN);
    AppMethodBeat.o(61354);
  }
  
  public static abstract class a<N, R>
    implements b.c<N, R>
  {
    public boolean fe(N paramN)
    {
      return true;
    }
    
    public void ft(N paramN) {}
  }
  
  public static abstract interface b<N>
  {
    public abstract Iterable<? extends N> fd(N paramN);
  }
  
  public static abstract interface c<N, R>
  {
    public abstract boolean fe(N paramN);
    
    public abstract void ft(N paramN);
    
    public abstract R gim();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.o.b
 * JD-Core Version:    0.7.0.1
 */