package d.l.b.a.b.d.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l.b.a.b.b.a.g;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.ac;
import d.l.b.a.b.m.ag;
import d.l.b.a.b.m.aj;
import d.l.b.a.b.m.bc;
import d.l.b.a.b.m.be;
import d.l.b.a.b.m.d.a;
import d.l.b.a.b.m.n;
import d.l.b.a.b.m.v;

public final class f
  extends n
  implements ag
{
  private final aj NEl;
  
  public f(aj paramaj)
  {
    AppMethodBeat.i(58036);
    this.NEl = paramaj;
    AppMethodBeat.o(58036);
  }
  
  private static aj a(aj paramaj)
  {
    AppMethodBeat.i(58029);
    aj localaj = paramaj.Ap(false);
    if (!a.aI((ab)paramaj))
    {
      AppMethodBeat.o(58029);
      return localaj;
    }
    paramaj = (aj)new f(localaj);
    AppMethodBeat.o(58029);
    return paramaj;
  }
  
  private f c(g paramg)
  {
    AppMethodBeat.i(58030);
    p.h(paramg, "newAnnotations");
    paramg = new f(this.NEl.d(paramg));
    AppMethodBeat.o(58030);
    return paramg;
  }
  
  public final aj Ap(boolean paramBoolean)
  {
    AppMethodBeat.i(58033);
    if (paramBoolean)
    {
      localaj = this.NEl.Ap(true);
      AppMethodBeat.o(58033);
      return localaj;
    }
    aj localaj = (aj)this;
    AppMethodBeat.o(58033);
    return localaj;
  }
  
  public final ab R(ab paramab)
  {
    AppMethodBeat.i(58028);
    p.h(paramab, "replacement");
    paramab = paramab.gyC();
    if ((!bc.aF((ab)paramab)) && (!a.aI((ab)paramab)))
    {
      paramab = (ab)paramab;
      AppMethodBeat.o(58028);
      return paramab;
    }
    if ((paramab instanceof aj))
    {
      paramab = (ab)a((aj)paramab);
      AppMethodBeat.o(58028);
      return paramab;
    }
    if ((paramab instanceof v))
    {
      paramab = (ab)be.b(ac.a(a(((v)paramab).NZc), a(((v)paramab).NZd)), be.aK((ab)paramab));
      AppMethodBeat.o(58028);
      return paramab;
    }
    paramab = (Throwable)new IllegalStateException("Incorrect type: ".concat(String.valueOf(paramab)).toString());
    AppMethodBeat.o(58028);
    throw paramab;
  }
  
  public final aj gqu()
  {
    return this.NEl;
  }
  
  public final boolean gqx()
  {
    return true;
  }
  
  public final boolean gqy()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.d.a.f.f
 * JD-Core Version:    0.7.0.1
 */