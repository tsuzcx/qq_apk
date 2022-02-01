package kotlin.l.b.a.b.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.am;
import kotlin.l.b.a.b.b.d;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.m.ab;

public abstract interface a
{
  public abstract Collection<am> a(f paramf, e parame);
  
  public abstract Collection<ab> l(e parame);
  
  public abstract Collection<f> m(e parame);
  
  public abstract Collection<d> o(e parame);
  
  public static final class a
    implements a
  {
    public static final a aaMJ;
    
    static
    {
      AppMethodBeat.i(56986);
      aaMJ = new a();
      AppMethodBeat.o(56986);
    }
    
    public final Collection<am> a(f paramf, e parame)
    {
      AppMethodBeat.i(56983);
      p.k(paramf, "name");
      p.k(parame, "classDescriptor");
      paramf = (Collection)v.aaAd;
      AppMethodBeat.o(56983);
      return paramf;
    }
    
    public final Collection<ab> l(e parame)
    {
      AppMethodBeat.i(56982);
      p.k(parame, "classDescriptor");
      parame = (Collection)v.aaAd;
      AppMethodBeat.o(56982);
      return parame;
    }
    
    public final Collection<f> m(e parame)
    {
      AppMethodBeat.i(56984);
      p.k(parame, "classDescriptor");
      parame = (Collection)v.aaAd;
      AppMethodBeat.o(56984);
      return parame;
    }
    
    public final Collection<d> o(e parame)
    {
      AppMethodBeat.i(56985);
      p.k(parame, "classDescriptor");
      parame = (Collection)v.aaAd;
      AppMethodBeat.o(56985);
      return parame;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.b.b.a
 * JD-Core Version:    0.7.0.1
 */