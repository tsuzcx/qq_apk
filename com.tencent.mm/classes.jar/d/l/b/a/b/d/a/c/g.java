package d.l.b.a.b.d.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d;
import d.f;
import d.g.b.p;
import d.g.b.q;
import d.l.b.a.b.b.ac;
import d.l.b.a.b.d.a.e.t;
import java.util.List;

public final class g
  implements ac
{
  final h NeA;
  private final d.l.b.a.b.l.a<d.l.b.a.b.f.b, d.l.b.a.b.d.a.c.a.h> NeD;
  
  public g(b paramb)
  {
    AppMethodBeat.i(57758);
    this.NeA = new h(paramb, (m)m.a.NeS, (f)new d(null));
    this.NeD = this.NeA.NeI.MQa.gtN();
    AppMethodBeat.o(57758);
  }
  
  private final d.l.b.a.b.d.a.c.a.h o(d.l.b.a.b.f.b paramb)
  {
    AppMethodBeat.i(57755);
    final t localt = this.NeA.NeI.Ned.i(paramb);
    paramb = (d.l.b.a.b.d.a.c.a.h)this.NeD.b(paramb, (d.g.a.a)new a(this, localt));
    AppMethodBeat.o(57755);
    return paramb;
  }
  
  public final List<d.l.b.a.b.d.a.c.a.h> f(d.l.b.a.b.f.b paramb)
  {
    AppMethodBeat.i(57756);
    p.h(paramb, "fqName");
    paramb = d.a.j.eM(o(paramb));
    AppMethodBeat.o(57756);
    return paramb;
  }
  
  static final class a
    extends q
    implements d.g.a.a<d.l.b.a.b.d.a.c.a.h>
  {
    a(g paramg, t paramt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.d.a.c.g
 * JD-Core Version:    0.7.0.1
 */