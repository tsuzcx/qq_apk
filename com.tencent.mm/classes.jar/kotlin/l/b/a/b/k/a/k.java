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
  public static final a TKI = a.TKK;
  
  public abstract o<a.a<?>, Object> a(a.h paramh, t paramt, h paramh1, ad paramad);
  
  public static final class a
  {
    private static final k TKJ;
    
    static
    {
      AppMethodBeat.i(60302);
      TKK = new a();
      TKJ = (k)new a();
      AppMethodBeat.o(60302);
    }
    
    public static k hLd()
    {
      return TKJ;
    }
    
    public static final class a
      implements k
    {
      public final o a(a.h paramh, t paramt, h paramh1, ad paramad)
      {
        AppMethodBeat.i(60301);
        p.h(paramh, "proto");
        p.h(paramt, "ownerFunction");
        p.h(paramh1, "typeTable");
        p.h(paramad, "typeDeserializer");
        AppMethodBeat.o(60301);
        return null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.k.a.k
 * JD-Core Version:    0.7.0.1
 */