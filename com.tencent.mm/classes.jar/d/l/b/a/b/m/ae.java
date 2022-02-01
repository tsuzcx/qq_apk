package d.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import d.g.b.l;
import d.l.b.a.b.l.f;

public final class ae
  extends bi
{
  final a<ab> JWE;
  private final f<ab> JYb;
  private final d.l.b.a.b.l.i JlL;
  
  public ae(d.l.b.a.b.l.i parami, a<? extends ab> parama)
  {
    AppMethodBeat.i(60778);
    this.JlL = parami;
    this.JWE = parama;
    this.JYb = this.JlL.H(this.JWE);
    AppMethodBeat.o(60778);
  }
  
  public final boolean fJM()
  {
    AppMethodBeat.i(60776);
    boolean bool = this.JYb.fJM();
    AppMethodBeat.o(60776);
    return bool;
  }
  
  protected final ab fJX()
  {
    AppMethodBeat.i(60775);
    ab localab = (ab)this.JYb.invoke();
    AppMethodBeat.o(60775);
    return localab;
  }
  
  static final class a
    extends l
    implements a<ab>
  {
    a(ae paramae, d.l.b.a.b.m.a.i parami)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.m.ae
 * JD-Core Version:    0.7.0.1
 */