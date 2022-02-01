package d.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import d.g.b.q;
import d.l.b.a.b.l.f;
import d.l.b.a.b.l.j;
import d.l.b.a.b.m.a.i;

public final class ae
  extends bi
{
  private final j MQa;
  final a<ab> NAV;
  private final f<ab> NCp;
  
  public ae(j paramj, a<? extends ab> parama)
  {
    AppMethodBeat.i(60778);
    this.MQa = paramj;
    this.NAV = parama;
    this.NCp = this.MQa.S(this.NAV);
    AppMethodBeat.o(60778);
  }
  
  public final boolean gtO()
  {
    AppMethodBeat.i(60776);
    boolean bool = this.NCp.gtO();
    AppMethodBeat.o(60776);
    return bool;
  }
  
  protected final ab gub()
  {
    AppMethodBeat.i(60775);
    ab localab = (ab)this.NCp.invoke();
    AppMethodBeat.o(60775);
    return localab;
  }
  
  static final class a
    extends q
    implements a<ab>
  {
    a(ae paramae, i parami)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.m.ae
 * JD-Core Version:    0.7.0.1
 */