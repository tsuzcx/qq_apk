package kotlin.l.b.a.b.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;

public final class b
{
  public static <N> Boolean a(Collection<N> paramCollection, b<N> paramb, kotlin.g.a.b<N, Boolean> paramb1)
  {
    AppMethodBeat.i(61353);
    if (paramCollection == null) {
      aKu(7);
    }
    if (paramb == null) {
      aKu(8);
    }
    if (paramb1 == null) {
      aKu(9);
    }
    paramCollection = (Boolean)a(paramCollection, paramb, new a()
    {
      public final boolean hT(N paramAnonymousN)
      {
        AppMethodBeat.i(61347);
        if (((Boolean)this.ajtp.invoke(paramAnonymousN)).booleanValue()) {
          this.Mve[0] = true;
        }
        if (this.Mve[0] == 0)
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
      aKu(4);
    }
    if (paramb == null) {
      aKu(5);
    }
    paramCollection = a(paramCollection, paramb, new b.e(), paramc);
    AppMethodBeat.o(61352);
    return paramCollection;
  }
  
  private static <N, R> R a(Collection<N> paramCollection, b<N> paramb, b.d<N> paramd, c<N, R> paramc)
  {
    AppMethodBeat.i(61351);
    if (paramCollection == null) {
      aKu(0);
    }
    if (paramb == null) {
      aKu(1);
    }
    if (paramc == null) {
      aKu(3);
    }
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      a(paramCollection.next(), paramb, paramd, paramc);
    }
    paramCollection = paramc.knQ();
    AppMethodBeat.o(61351);
    return paramCollection;
  }
  
  private static <N> void a(N paramN, b<N> paramb, b.d<N> paramd, c<N, ?> paramc)
  {
    AppMethodBeat.i(61354);
    if (paramN == null) {
      aKu(22);
    }
    if (paramb == null) {
      aKu(23);
    }
    if (paramd == null) {
      aKu(24);
    }
    if (paramc == null) {
      aKu(25);
    }
    if (!paramd.io(paramN))
    {
      AppMethodBeat.o(61354);
      return;
    }
    if (!paramc.hT(paramN))
    {
      AppMethodBeat.o(61354);
      return;
    }
    Iterator localIterator = paramb.hS(paramN).iterator();
    while (localIterator.hasNext()) {
      a(localIterator.next(), paramb, paramd, paramc);
    }
    paramc.ig(paramN);
    AppMethodBeat.o(61354);
  }
  
  public static abstract class a<N, R>
    implements b.c<N, R>
  {
    public boolean hT(N paramN)
    {
      return true;
    }
    
    public void ig(N paramN) {}
  }
  
  public static abstract interface b<N>
  {
    public abstract Iterable<? extends N> hS(N paramN);
  }
  
  public static abstract interface c<N, R>
  {
    public abstract boolean hT(N paramN);
    
    public abstract void ig(N paramN);
    
    public abstract R knQ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.o.b
 * JD-Core Version:    0.7.0.1
 */