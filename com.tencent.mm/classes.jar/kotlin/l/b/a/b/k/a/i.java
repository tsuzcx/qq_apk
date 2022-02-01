package kotlin.l.b.a.b.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.a.a;
import kotlin.l.b.a.b.b.x;
import kotlin.l.b.a.b.e.a.h;
import kotlin.l.b.a.b.e.b.g;
import kotlin.r;

public abstract interface i
{
  public static final a ajlU = a.ajlV;
  
  public abstract r<a.a<?>, Object> a(a.h paramh, x paramx, g paramg, ac paramac);
  
  public static final class a
  {
    private static final i ajlW;
    
    static
    {
      AppMethodBeat.i(60302);
      ajlV = new a();
      ajlW = (i)new a();
      AppMethodBeat.o(60302);
    }
    
    public static i kzQ()
    {
      return ajlW;
    }
    
    public static final class a
      implements i
    {
      public final r a(a.h paramh, x paramx, g paramg, ac paramac)
      {
        AppMethodBeat.i(60301);
        s.u(paramh, "proto");
        s.u(paramx, "ownerFunction");
        s.u(paramg, "typeTable");
        s.u(paramac, "typeDeserializer");
        AppMethodBeat.o(60301);
        return null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.k.a.i
 * JD-Core Version:    0.7.0.1
 */