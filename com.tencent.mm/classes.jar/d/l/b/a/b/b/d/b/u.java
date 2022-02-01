package d.l.b.a.b.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.v;
import d.g.b.k;
import d.l.b.a.b.d.a.e.a;
import d.l.b.a.b.d.a.e.g;
import d.l.b.a.b.d.a.e.t;
import d.l.b.a.b.f.f;
import java.util.Collection;

public final class u
  extends n
  implements t
{
  private final d.l.b.a.b.f.b JrG;
  
  public u(d.l.b.a.b.f.b paramb)
  {
    AppMethodBeat.i(57501);
    this.JrG = paramb;
    AppMethodBeat.o(57501);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(57498);
    if (((paramObject instanceof u)) && (k.g(this.JrG, ((u)paramObject).JrG)))
    {
      AppMethodBeat.o(57498);
      return true;
    }
    AppMethodBeat.o(57498);
    return false;
  }
  
  public final Collection<t> fAZ()
  {
    return (Collection)v.Jgl;
  }
  
  public final d.l.b.a.b.f.b fzd()
  {
    return this.JrG;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(57499);
    int i = this.JrG.hashCode();
    AppMethodBeat.o(57499);
    return i;
  }
  
  public final a l(d.l.b.a.b.f.b paramb)
  {
    AppMethodBeat.i(57497);
    k.h(paramb, "fqName");
    AppMethodBeat.o(57497);
    return null;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(57500);
    String str = getClass().getName() + ": " + this.JrG;
    AppMethodBeat.o(57500);
    return str;
  }
  
  public final Collection<g> y(d.g.a.b<? super f, Boolean> paramb)
  {
    AppMethodBeat.i(57496);
    k.h(paramb, "nameFilter");
    paramb = (Collection)v.Jgl;
    AppMethodBeat.o(57496);
    return paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.b.d.b.u
 * JD-Core Version:    0.7.0.1
 */