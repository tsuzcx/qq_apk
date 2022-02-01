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
      adP(7);
    }
    if (paramb == null) {
      adP(8);
    }
    if (paramb1 == null) {
      adP(9);
    }
    paramCollection = (Boolean)a(paramCollection, paramb, new a()
    {
      public final boolean eZ(N paramAnonymousN)
      {
        AppMethodBeat.i(61347);
        if (((Boolean)this.Kbf.aA(paramAnonymousN)).booleanValue()) {
          this.ugl[0] = true;
        }
        if (this.ugl[0] == 0)
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
      adP(4);
    }
    if (paramb == null) {
      adP(5);
    }
    paramCollection = a(paramCollection, paramb, new b.e(), paramc);
    AppMethodBeat.o(61352);
    return paramCollection;
  }
  
  private static <N, R> R a(Collection<N> paramCollection, b<N> paramb, b.d<N> paramd, c<N, R> paramc)
  {
    AppMethodBeat.i(61351);
    if (paramCollection == null) {
      adP(0);
    }
    if (paramb == null) {
      adP(1);
    }
    if (paramc == null) {
      adP(3);
    }
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      a(paramCollection.next(), paramb, paramd, paramc);
    }
    paramCollection = paramc.fyk();
    AppMethodBeat.o(61351);
    return paramCollection;
  }
  
  private static <N> void a(N paramN, b<N> paramb, b.d<N> paramd, c<N, ?> paramc)
  {
    AppMethodBeat.i(61354);
    if (paramN == null) {
      adP(22);
    }
    if (paramb == null) {
      adP(23);
    }
    if (paramd == null) {
      adP(24);
    }
    if (paramc == null) {
      adP(25);
    }
    if (!paramd.ft(paramN))
    {
      AppMethodBeat.o(61354);
      return;
    }
    if (!paramc.eZ(paramN))
    {
      AppMethodBeat.o(61354);
      return;
    }
    Iterator localIterator = paramb.eY(paramN).iterator();
    while (localIterator.hasNext()) {
      a(localIterator.next(), paramb, paramd, paramc);
    }
    paramc.fo(paramN);
    AppMethodBeat.o(61354);
  }
  
  public static abstract class a<N, R>
    implements b.c<N, R>
  {
    public boolean eZ(N paramN)
    {
      return true;
    }
    
    public void fo(N paramN) {}
  }
  
  public static abstract interface b<N>
  {
    public abstract Iterable<? extends N> eY(N paramN);
  }
  
  public static abstract interface c<N, R>
  {
    public abstract boolean eZ(N paramN);
    
    public abstract void fo(N paramN);
    
    public abstract R fyk();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.o.b
 * JD-Core Version:    0.7.0.1
 */