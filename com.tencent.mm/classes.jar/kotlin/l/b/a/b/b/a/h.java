package kotlin.l.b.a.b.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l.b.a.b.f.b;

public final class h
  implements g
{
  private final List<c> TiF;
  
  public h(List<? extends c> paramList)
  {
    AppMethodBeat.i(56952);
    this.TiF = paramList;
    AppMethodBeat.o(56952);
  }
  
  public final c g(b paramb)
  {
    AppMethodBeat.i(56953);
    p.h(paramb, "fqName");
    paramb = g.b.a(this, paramb);
    AppMethodBeat.o(56953);
    return paramb;
  }
  
  public final boolean h(b paramb)
  {
    AppMethodBeat.i(56954);
    p.h(paramb, "fqName");
    boolean bool = g.b.b(this, paramb);
    AppMethodBeat.o(56954);
    return bool;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(56949);
    boolean bool = this.TiF.isEmpty();
    AppMethodBeat.o(56949);
    return bool;
  }
  
  public final Iterator<c> iterator()
  {
    AppMethodBeat.i(56950);
    Iterator localIterator = this.TiF.iterator();
    AppMethodBeat.o(56950);
    return localIterator;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(56951);
    String str = this.TiF.toString();
    AppMethodBeat.o(56951);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.b.a.h
 * JD-Core Version:    0.7.0.1
 */