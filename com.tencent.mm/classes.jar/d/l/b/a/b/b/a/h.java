package d.l.b.a.b.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l.b.a.b.f.b;
import java.util.Iterator;
import java.util.List;

public final class h
  implements g
{
  private final List<c> NsX;
  
  public h(List<? extends c> paramList)
  {
    AppMethodBeat.i(56952);
    this.NsX = paramList;
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
    boolean bool = this.NsX.isEmpty();
    AppMethodBeat.o(56949);
    return bool;
  }
  
  public final Iterator<c> iterator()
  {
    AppMethodBeat.i(56950);
    Iterator localIterator = this.NsX.iterator();
    AppMethodBeat.o(56950);
    return localIterator;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(56951);
    String str = this.NsX.toString();
    AppMethodBeat.o(56951);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.b.a.h
 * JD-Core Version:    0.7.0.1
 */