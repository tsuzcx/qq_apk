package d.l.b.a.b.d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.q;
import d.g.b.x;
import d.g.b.z;
import d.l.b.a.b.j.b.g;
import d.l.b.a.b.l.i;
import d.l.b.a.b.l.j;
import d.l.k;
import java.util.Map;

public final class h
  extends b
{
  private final d.l.b.a.b.l.f NAB;
  
  static
  {
    AppMethodBeat.i(57680);
    cxA = new k[] { (k)z.a(new x(z.bp(h.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;")) };
    AppMethodBeat.o(57680);
  }
  
  public h(d.l.b.a.b.d.a.e.a parama, d.l.b.a.b.d.a.c.h paramh)
  {
    super(paramh, parama, localb);
    AppMethodBeat.i(57682);
    this.NAB = paramh.NBN.Nnf.S((d.g.a.a)new a(this));
    AppMethodBeat.o(57682);
  }
  
  public final Map<d.l.b.a.b.f.f, g<?>> gom()
  {
    AppMethodBeat.i(57681);
    Map localMap = (Map)i.a(this.NAB, cxA[0]);
    AppMethodBeat.o(57681);
    return localMap;
  }
  
  static final class a
    extends q
    implements d.g.a.a<Map<d.l.b.a.b.f.f, ? extends g<?>>>
  {
    a(h paramh)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.d.a.a.h
 * JD-Core Version:    0.7.0.1
 */