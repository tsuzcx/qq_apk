package d.l.b.a.b.d.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d;
import d.f;
import d.g.b.k;
import d.g.b.l;
import d.l.b.a.b.b.ac;
import d.l.b.a.b.d.a.e.t;
import d.l.b.a.b.l.i;
import java.util.List;

public final class g
  implements ac
{
  final h JAk;
  private final d.l.b.a.b.l.a<d.l.b.a.b.f.b, d.l.b.a.b.d.a.c.a.h> JAn;
  
  public g(b paramb)
  {
    AppMethodBeat.i(57758);
    this.JAk = new h(paramb, (m)m.a.JAC, (f)new d(null));
    this.JAn = this.JAk.JAs.JlL.fJL();
    AppMethodBeat.o(57758);
  }
  
  private final d.l.b.a.b.d.a.c.a.h o(d.l.b.a.b.f.b paramb)
  {
    AppMethodBeat.i(57755);
    final t localt = this.JAk.JAs.JzN.i(paramb);
    paramb = (d.l.b.a.b.d.a.c.a.h)this.JAn.b(paramb, (d.g.a.a)new a(this, localt));
    AppMethodBeat.o(57755);
    return paramb;
  }
  
  public final List<d.l.b.a.b.d.a.c.a.h> f(d.l.b.a.b.f.b paramb)
  {
    AppMethodBeat.i(57756);
    k.h(paramb, "fqName");
    paramb = d.a.j.eG(o(paramb));
    AppMethodBeat.o(57756);
    return paramb;
  }
  
  static final class a
    extends l
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