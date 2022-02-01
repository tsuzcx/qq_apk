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
      aDG(7);
    }
    if (paramb == null) {
      aDG(8);
    }
    if (paramb1 == null) {
      aDG(9);
    }
    paramCollection = (Boolean)a(paramCollection, paramb, new a()
    {
      public final boolean ft(N paramAnonymousN)
      {
        AppMethodBeat.i(61347);
        if (((Boolean)this.abtU.invoke(paramAnonymousN)).booleanValue()) {
          this.GyW[0] = true;
        }
        if (this.GyW[0] == 0)
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
      aDG(4);
    }
    if (paramb == null) {
      aDG(5);
    }
    paramCollection = a(paramCollection, paramb, new b.e(), paramc);
    AppMethodBeat.o(61352);
    return paramCollection;
  }
  
  private static <N, R> R a(Collection<N> paramCollection, b<N> paramb, b.d<N> paramd, c<N, R> paramc)
  {
    AppMethodBeat.i(61351);
    if (paramCollection == null) {
      aDG(0);
    }
    if (paramb == null) {
      aDG(1);
    }
    if (paramc == null) {
      aDG(3);
    }
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      a(paramCollection.next(), paramb, paramd, paramc);
    }
    paramCollection = paramc.iED();
    AppMethodBeat.o(61351);
    return paramCollection;
  }
  
  private static <N> void a(N paramN, b<N> paramb, b.d<N> paramd, c<N, ?> paramc)
  {
    AppMethodBeat.i(61354);
    if (paramN == null) {
      aDG(22);
    }
    if (paramb == null) {
      aDG(23);
    }
    if (paramd == null) {
      aDG(24);
    }
    if (paramc == null) {
      aDG(25);
    }
    if (!paramd.fM(paramN))
    {
      AppMethodBeat.o(61354);
      return;
    }
    if (!paramc.ft(paramN))
    {
      AppMethodBeat.o(61354);
      return;
    }
    Iterator localIterator = paramb.fs(paramN).iterator();
    while (localIterator.hasNext()) {
      a(localIterator.next(), paramb, paramd, paramc);
    }
    paramc.fG(paramN);
    AppMethodBeat.o(61354);
  }
  
  public static abstract class a<N, R>
    implements b.c<N, R>
  {
    public void fG(N paramN) {}
    
    public boolean ft(N paramN)
    {
      return true;
    }
  }
  
  public static abstract interface b<N>
  {
    public abstract Iterable<? extends N> fs(N paramN);
  }
  
  public static abstract interface c<N, R>
  {
    public abstract void fG(N paramN);
    
    public abstract boolean ft(N paramN);
    
    public abstract R iED();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.o.b
 * JD-Core Version:    0.7.0.1
 */