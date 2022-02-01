package kotlin.l.b.a.b.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.a.g;
import kotlin.l.b.a.b.a.g.a;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.f.a;
import kotlin.l.b.a.b.f.c;

public final class j
{
  private static final Set<a> TKE;
  public static final b TKF;
  private final b<a, e> TKD;
  private final l Tvt;
  
  static
  {
    AppMethodBeat.i(60299);
    TKF = new b((byte)0);
    TKE = ak.setOf(a.p(g.TcO.TcU.hJj()));
    AppMethodBeat.o(60299);
  }
  
  public j(l paraml)
  {
    AppMethodBeat.i(60298);
    this.Tvt = paraml;
    this.TKD = ((b)this.Tvt.TcN.V((b)new c(this)));
    AppMethodBeat.o(60298);
  }
  
  public final e a(a parama, h paramh)
  {
    AppMethodBeat.i(60296);
    p.h(parama, "classId");
    parama = (e)this.TKD.invoke(new a(parama, paramh));
    AppMethodBeat.o(60296);
    return parama;
  }
  
  static final class a
  {
    final h TKG;
    final a Tfj;
    
    public a(a parama, h paramh)
    {
      AppMethodBeat.i(60294);
      this.Tfj = parama;
      this.TKG = paramh;
      AppMethodBeat.o(60294);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(60292);
      if (((paramObject instanceof a)) && (p.j(this.Tfj, ((a)paramObject).Tfj)))
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
      int i = this.Tfj.hashCode();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.k.a.j
 * JD-Core Version:    0.7.0.1
 */