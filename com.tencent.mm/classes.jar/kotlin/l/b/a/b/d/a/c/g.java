package kotlin.l.b.a.b.d.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.List;
import kotlin.a.p;
import kotlin.e;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.ak;
import kotlin.l.b.a.b.d.a.e.t;
import kotlin.l.b.a.b.l.m;

public final class g
  implements ak
{
  final h aiSh;
  private final kotlin.l.b.a.b.l.a<kotlin.l.b.a.b.f.c, kotlin.l.b.a.b.d.a.c.a.h> aiSm;
  
  public g(c paramc)
  {
    AppMethodBeat.i(57758);
    this.aiSh = new h(paramc, (l)l.a.aiSz, (j)new e());
    this.aiSm = this.aiSh.aiSp.aiBu.kAu();
    AppMethodBeat.o(57758);
  }
  
  private final kotlin.l.b.a.b.d.a.c.a.h r(kotlin.l.b.a.b.f.c paramc)
  {
    AppMethodBeat.i(57755);
    final t localt = this.aiSh.aiSp.aiRK.j(paramc);
    if (localt == null)
    {
      AppMethodBeat.o(57755);
      return null;
    }
    paramc = (kotlin.l.b.a.b.d.a.c.a.h)this.aiSm.e(paramc, (kotlin.g.a.a)new a(this, localt));
    AppMethodBeat.o(57755);
    return paramc;
  }
  
  public final void a(kotlin.l.b.a.b.f.c paramc, Collection<ah> paramCollection)
  {
    AppMethodBeat.i(192134);
    s.u(paramc, "fqName");
    s.u(paramCollection, "packageFragments");
    kotlin.l.b.a.b.o.a.c(paramCollection, r(paramc));
    AppMethodBeat.o(192134);
  }
  
  public final List<kotlin.l.b.a.b.d.a.c.a.h> f(kotlin.l.b.a.b.f.c paramc)
  {
    AppMethodBeat.i(57756);
    s.u(paramc, "fqName");
    paramc = p.hs(r(paramc));
    AppMethodBeat.o(57756);
    return paramc;
  }
  
  public final boolean g(kotlin.l.b.a.b.f.c paramc)
  {
    AppMethodBeat.i(192138);
    s.u(paramc, "fqName");
    if (this.aiSh.aiSp.aiRK.j(paramc) == null)
    {
      AppMethodBeat.o(192138);
      return true;
    }
    AppMethodBeat.o(192138);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(192141);
    String str = s.X("LazyJavaPackageFragmentProvider of module ", this.aiSh.aiSp.aiEx);
    AppMethodBeat.o(192141);
    return str;
  }
  
  static final class a
    extends u
    implements kotlin.g.a.a<kotlin.l.b.a.b.d.a.c.a.h>
  {
    a(g paramg, t paramt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.c.g
 * JD-Core Version:    0.7.0.1
 */