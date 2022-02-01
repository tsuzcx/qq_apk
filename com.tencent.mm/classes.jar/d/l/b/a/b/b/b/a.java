package d.l.b.a.b.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.v;
import d.g.b.k;
import d.l.b.a.b.b.am;
import d.l.b.a.b.b.d;
import d.l.b.a.b.b.e;
import d.l.b.a.b.f.f;
import d.l.b.a.b.m.ab;
import java.util.Collection;

public abstract interface a
{
  public abstract Collection<am> a(f paramf, e parame);
  
  public abstract Collection<ab> l(e parame);
  
  public abstract Collection<f> m(e parame);
  
  public abstract Collection<d> o(e parame);
  
  public static final class a
    implements a
  {
    public static final a Lgf;
    
    static
    {
      AppMethodBeat.i(56986);
      Lgf = new a();
      AppMethodBeat.o(56986);
    }
    
    public final Collection<am> a(f paramf, e parame)
    {
      AppMethodBeat.i(56983);
      k.h(paramf, "name");
      k.h(parame, "classDescriptor");
      paramf = (Collection)v.KTF;
      AppMethodBeat.o(56983);
      return paramf;
    }
    
    public final Collection<ab> l(e parame)
    {
      AppMethodBeat.i(56982);
      k.h(parame, "classDescriptor");
      parame = (Collection)v.KTF;
      AppMethodBeat.o(56982);
      return parame;
    }
    
    public final Collection<f> m(e parame)
    {
      AppMethodBeat.i(56984);
      k.h(parame, "classDescriptor");
      parame = (Collection)v.KTF;
      AppMethodBeat.o(56984);
      return parame;
    }
    
    public final Collection<d> o(e parame)
    {
      AppMethodBeat.i(56985);
      k.h(parame, "classDescriptor");
      parame = (Collection)v.KTF;
      AppMethodBeat.o(56985);
      return parame;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.b.b.a
 * JD-Core Version:    0.7.0.1
 */