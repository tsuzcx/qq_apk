package kotlin.l.b.a.b.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;

public final class h
  implements g
{
  private final List<c> aYF;
  
  public h(List<? extends c> paramList)
  {
    AppMethodBeat.i(56952);
    this.aYF = paramList;
    AppMethodBeat.o(56952);
  }
  
  public final c h(kotlin.l.b.a.b.f.c paramc)
  {
    AppMethodBeat.i(56953);
    paramc = g.b.a(this, paramc);
    AppMethodBeat.o(56953);
    return paramc;
  }
  
  public final boolean i(kotlin.l.b.a.b.f.c paramc)
  {
    AppMethodBeat.i(56954);
    boolean bool = g.b.b(this, paramc);
    AppMethodBeat.o(56954);
    return bool;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(56949);
    boolean bool = this.aYF.isEmpty();
    AppMethodBeat.o(56949);
    return bool;
  }
  
  public final Iterator<c> iterator()
  {
    AppMethodBeat.i(56950);
    Iterator localIterator = this.aYF.iterator();
    AppMethodBeat.o(56950);
    return localIterator;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(56951);
    String str = this.aYF.toString();
    AppMethodBeat.o(56951);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.a.h
 * JD-Core Version:    0.7.0.1
 */