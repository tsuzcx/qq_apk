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
  private final aj Nhg;
  
  public f(aj paramaj)
  {
    AppMethodBeat.i(58036);
    this.Nhg = paramaj;
    AppMethodBeat.o(58036);
  }
  
  private static aj a(aj paramaj)
  {
    AppMethodBeat.i(58029);
    aj localaj = paramaj.Ac(false);
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
    paramg = new f(this.Nhg.d(paramg));
    AppMethodBeat.o(58030);
    return paramg;
  }
  
  public final aj Ac(boolean paramBoolean)
  {
    AppMethodBeat.i(58033);
    if (paramBoolean)
    {
      localaj = this.Nhg.Ac(true);
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
    paramab = paramab.gua();
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
      paramab = (ab)be.b(ac.a(a(((v)paramab).NBV), a(((v)paramab).NBW)), be.aK((ab)paramab));
      AppMethodBeat.o(58028);
      return paramab;
    }
    paramab = (Throwable)new IllegalStateException("Incorrect type: ".concat(String.valueOf(paramab)).toString());
    AppMethodBeat.o(58028);
    throw paramab;
  }
  
  public final aj glS()
  {
    return this.Nhg;
  }
  
  public final boolean glV()
  {
    return true;
  }
  
  public final boolean glW()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.d.a.f.f
 * JD-Core Version:    0.7.0.1
 */