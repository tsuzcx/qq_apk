package kotlin.l.b.a.b.d.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.a.c;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.a.g.b;

final class b
  implements g
{
  private final kotlin.l.b.a.b.f.b TtH;
  
  public b(kotlin.l.b.a.b.f.b paramb)
  {
    AppMethodBeat.i(58019);
    this.TtH = paramb;
    AppMethodBeat.o(58019);
  }
  
  public final boolean h(kotlin.l.b.a.b.f.b paramb)
  {
    AppMethodBeat.i(58020);
    p.h(paramb, "fqName");
    boolean bool = g.b.b(this, paramb);
    AppMethodBeat.o(58020);
    return bool;
  }
  
  public final boolean isEmpty()
  {
    return false;
  }
  
  public final Iterator<c> iterator()
  {
    AppMethodBeat.i(58018);
    Iterator localIterator = ((List)v.SXr).iterator();
    AppMethodBeat.o(58018);
    return localIterator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.f.b
 * JD-Core Version:    0.7.0.1
 */