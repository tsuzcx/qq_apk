package kotlin.l.b.a.b.b.e.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import kotlin.a.ab;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.l.b.a.b.d.a.e.a;
import kotlin.l.b.a.b.d.a.e.g;
import kotlin.l.b.a.b.d.a.e.t;
import kotlin.l.b.a.b.f.c;
import kotlin.l.b.a.b.f.f;

public final class u
  extends n
  implements t
{
  private final c aiIl;
  
  public u(c paramc)
  {
    AppMethodBeat.i(57501);
    this.aiIl = paramc;
    AppMethodBeat.o(57501);
  }
  
  public final Collection<g> bb(b<? super f, Boolean> paramb)
  {
    AppMethodBeat.i(57496);
    s.u(paramb, "nameFilter");
    paramb = (Collection)ab.aivy;
    AppMethodBeat.o(57496);
    return paramb;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(57498);
    if (((paramObject instanceof u)) && (s.p(this.aiIl, ((u)paramObject).aiIl)))
    {
      AppMethodBeat.o(57498);
      return true;
    }
    AppMethodBeat.o(57498);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(57499);
    int i = this.aiIl.hashCode();
    AppMethodBeat.o(57499);
    return i;
  }
  
  public final c koY()
  {
    return this.aiIl;
  }
  
  public final boolean kqA()
  {
    return false;
  }
  
  public final Collection<t> kri()
  {
    return (Collection)ab.aivy;
  }
  
  public final a m(c paramc)
  {
    AppMethodBeat.i(57497);
    s.u(paramc, "fqName");
    AppMethodBeat.o(57497);
    return null;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(57500);
    String str = getClass().getName() + ": " + this.aiIl;
    AppMethodBeat.o(57500);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.e.b.u
 * JD-Core Version:    0.7.0.1
 */