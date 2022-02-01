package d.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import d.g.b.l;
import d.l.b.a.b.l.f;

public final class ae
  extends bi
{
  private final d.l.b.a.b.l.i KZf;
  final a<ab> LJX;
  private final f<ab> LLu;
  
  public ae(d.l.b.a.b.l.i parami, a<? extends ab> parama)
  {
    AppMethodBeat.i(60778);
    this.KZf = parami;
    this.LJX = parama;
    this.LLu = this.KZf.O(this.LJX);
    AppMethodBeat.o(60778);
  }
  
  protected final ab gcA()
  {
    AppMethodBeat.i(60775);
    ab localab = (ab)this.LLu.invoke();
    AppMethodBeat.o(60775);
    return localab;
  }
  
  public final boolean gcp()
  {
    AppMethodBeat.i(60776);
    boolean bool = this.LLu.gcp();
    AppMethodBeat.o(60776);
    return bool;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.m.ae
 * JD-Core Version:    0.7.0.1
 */