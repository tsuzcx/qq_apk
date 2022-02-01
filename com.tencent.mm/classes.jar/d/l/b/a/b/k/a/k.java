package d.l.b.a.b.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.b.a.a;
import d.l.b.a.b.b.t;
import d.l.b.a.b.e.a.h;
import d.l.b.a.b.e.b.h;
import d.o;

public abstract interface k
{
  public static final a JUo = a.JUq;
  
  public abstract o<a.a<?>, Object> a(a.h paramh, t paramt, h paramh1, ad paramad);
  
  public static final class a
  {
    private static final k JUp;
    
    static
    {
      AppMethodBeat.i(60302);
      JUq = new a();
      JUp = (k)new a();
      AppMethodBeat.o(60302);
    }
    
    public static k fJw()
    {
      return JUp;
    }
    
    public static final class a
      implements k
    {
      public final o a(a.h paramh, t paramt, h paramh1, ad paramad)
      {
        AppMethodBeat.i(60301);
        d.g.b.k.h(paramh, "proto");
        d.g.b.k.h(paramt, "ownerFunction");
        d.g.b.k.h(paramh1, "typeTable");
        d.g.b.k.h(paramad, "typeDeserializer");
        AppMethodBeat.o(60301);
        return null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.k.a.k
 * JD-Core Version:    0.7.0.1
 */