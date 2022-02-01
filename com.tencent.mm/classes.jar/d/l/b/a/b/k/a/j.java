package d.l.b.a.b.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.ak;
import d.g.a.b;
import d.g.b.p;
import d.g.b.q;
import d.l.b.a.b.a.g;
import d.l.b.a.b.a.g.a;
import d.l.b.a.b.b.e;
import d.l.b.a.b.f.a;
import d.l.b.a.b.f.c;
import java.util.Set;

public final class j
{
  private static final Set<a> NyB;
  public static final b NyC;
  private final l NiH;
  private final b<a, e> NyA;
  
  static
  {
    AppMethodBeat.i(60299);
    NyC = new b((byte)0);
    NyB = ak.setOf(a.p(g.MQb.MQh.grk()));
    AppMethodBeat.o(60299);
  }
  
  public j(l paraml)
  {
    AppMethodBeat.i(60298);
    this.NiH = paraml;
    this.NyA = ((b)this.NiH.MQa.J((b)new c(this)));
    AppMethodBeat.o(60298);
  }
  
  public final e a(a parama, h paramh)
  {
    AppMethodBeat.i(60296);
    p.h(parama, "classId");
    parama = (e)this.NyA.invoke(new a(parama, paramh));
    AppMethodBeat.o(60296);
    return parama;
  }
  
  static final class a
  {
    final a MSw;
    final h NyD;
    
    public a(a parama, h paramh)
    {
      AppMethodBeat.i(60294);
      this.MSw = parama;
      this.NyD = paramh;
      AppMethodBeat.o(60294);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(60292);
      if (((paramObject instanceof a)) && (p.i(this.MSw, ((a)paramObject).MSw)))
      {
        AppMethodBeat.o(60292);
        return true;
      }
      AppMethodBeat.o(60292);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(60293);
      int i = this.MSw.hashCode();
      AppMethodBeat.o(60293);
      return i;
    }
  }
  
  public static final class b {}
  
  static final class c
    extends q
    implements b<j.a, e>
  {
    c(j paramj)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.k.a.j
 * JD-Core Version:    0.7.0.1
 */