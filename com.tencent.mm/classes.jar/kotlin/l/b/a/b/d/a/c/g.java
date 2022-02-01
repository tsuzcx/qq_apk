package kotlin.l.b.a.b.d.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.d;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.b.ac;
import kotlin.l.b.a.b.d.a.e.t;

public final class g
  implements ac
{
  final h Trn;
  private final kotlin.l.b.a.b.l.a<kotlin.l.b.a.b.f.b, kotlin.l.b.a.b.d.a.c.a.h> Trq;
  
  public g(b paramb)
  {
    AppMethodBeat.i(57758);
    this.Trn = new h(paramb, (m)m.a.TrF, (f)new d(null));
    this.Trq = this.Trn.Trv.TcN.hLs();
    AppMethodBeat.o(57758);
  }
  
  private final kotlin.l.b.a.b.d.a.c.a.h o(kotlin.l.b.a.b.f.b paramb)
  {
    AppMethodBeat.i(57755);
    final t localt = this.Trn.Trv.TqQ.i(paramb);
    paramb = (kotlin.l.b.a.b.d.a.c.a.h)this.Trq.b(paramb, (kotlin.g.a.a)new a(this, localt));
    AppMethodBeat.o(57755);
    return paramb;
  }
  
  public final List<kotlin.l.b.a.b.d.a.c.a.h> f(kotlin.l.b.a.b.f.b paramb)
  {
    AppMethodBeat.i(57756);
    p.h(paramb, "fqName");
    paramb = kotlin.a.j.eR(o(paramb));
    AppMethodBeat.o(57756);
    return paramb;
  }
  
  static final class a
    extends q
    implements kotlin.g.a.a<kotlin.l.b.a.b.d.a.c.a.h>
  {
    a(g paramg, t paramt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.c.g
 * JD-Core Version:    0.7.0.1
 */