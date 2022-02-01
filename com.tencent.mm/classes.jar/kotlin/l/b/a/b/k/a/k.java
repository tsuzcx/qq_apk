package kotlin.l.b.a.b.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.a.a;
import kotlin.l.b.a.b.b.t;
import kotlin.l.b.a.b.e.a.h;
import kotlin.l.b.a.b.e.b.h;
import kotlin.o;

public abstract interface k
{
  public static final a abnl = a.abnn;
  
  public abstract o<a.a<?>, Object> a(a.h paramh, t paramt, h paramh1, ad paramad);
  
  public static final class a
  {
    private static final k abnm;
    
    static
    {
      AppMethodBeat.i(60302);
      abnn = new a();
      abnm = (k)new a();
      AppMethodBeat.o(60302);
    }
    
    public static k iPv()
    {
      return abnm;
    }
    
    public static final class a
      implements k
    {
      public final o a(a.h paramh, t paramt, h paramh1, ad paramad)
      {
        AppMethodBeat.i(60301);
        p.k(paramh, "proto");
        p.k(paramt, "ownerFunction");
        p.k(paramh1, "typeTable");
        p.k(paramad, "typeDeserializer");
        AppMethodBeat.o(60301);
        return null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.k.a.k
 * JD-Core Version:    0.7.0.1
 */