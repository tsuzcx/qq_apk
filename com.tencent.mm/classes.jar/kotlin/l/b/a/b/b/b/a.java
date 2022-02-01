package kotlin.l.b.a.b.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import kotlin.a.ab;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.au;
import kotlin.l.b.a.b.b.d;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.m.ad;

public abstract interface a
{
  public abstract Collection<au> a(f paramf, e parame);
  
  public abstract Collection<ad> k(e parame);
  
  public abstract Collection<d> m(e parame);
  
  public abstract Collection<f> n(e parame);
  
  public static final class a
    implements a
  {
    public static final a aiJt;
    
    static
    {
      AppMethodBeat.i(56986);
      aiJt = new a();
      AppMethodBeat.o(56986);
    }
    
    public final Collection<au> a(f paramf, e parame)
    {
      AppMethodBeat.i(56983);
      s.u(paramf, "name");
      s.u(parame, "classDescriptor");
      paramf = (Collection)ab.aivy;
      AppMethodBeat.o(56983);
      return paramf;
    }
    
    public final Collection<ad> k(e parame)
    {
      AppMethodBeat.i(56982);
      s.u(parame, "classDescriptor");
      parame = (Collection)ab.aivy;
      AppMethodBeat.o(56982);
      return parame;
    }
    
    public final Collection<d> m(e parame)
    {
      AppMethodBeat.i(56985);
      s.u(parame, "classDescriptor");
      parame = (Collection)ab.aivy;
      AppMethodBeat.o(56985);
      return parame;
    }
    
    public final Collection<f> n(e parame)
    {
      AppMethodBeat.i(56984);
      s.u(parame, "classDescriptor");
      parame = (Collection)ab.aivy;
      AppMethodBeat.o(56984);
      return parame;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.b.a
 * JD-Core Version:    0.7.0.1
 */