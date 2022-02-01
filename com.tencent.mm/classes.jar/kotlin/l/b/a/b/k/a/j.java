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
  private static final Set<a> abnh;
  public static final b abni;
  private final l aaYm;
  private final b<a, e> abng;
  
  static
  {
    AppMethodBeat.i(60299);
    abni = new b((byte)0);
    abnh = ak.setOf(a.p(g.aaFI.aaFO.iND()));
    AppMethodBeat.o(60299);
  }
  
  public j(l paraml)
  {
    AppMethodBeat.i(60298);
    this.aaYm = paraml;
    this.abng = ((b)this.aaYm.aaFH.al((b)new c(this)));
    AppMethodBeat.o(60298);
  }
  
  public final e a(a parama, h paramh)
  {
    AppMethodBeat.i(60296);
    p.k(parama, "classId");
    parama = (e)this.abng.invoke(new a(parama, paramh));
    AppMethodBeat.o(60296);
    return parama;
  }
  
  static final class a
  {
    final a aaId;
    final h abnj;
    
    public a(a parama, h paramh)
    {
      AppMethodBeat.i(60294);
      this.aaId = parama;
      this.abnj = paramh;
      AppMethodBeat.o(60294);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(60292);
      if (((paramObject instanceof a)) && (p.h(this.aaId, ((a)paramObject).aaId)))
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
      int i = this.aaId.hashCode();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.k.a.j
 * JD-Core Version:    0.7.0.1
 */