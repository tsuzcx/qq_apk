package d.l.b.a.b.d.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
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
  private final aj Lqj;
  
  public f(aj paramaj)
  {
    AppMethodBeat.i(58036);
    this.Lqj = paramaj;
    AppMethodBeat.o(58036);
  }
  
  private static aj a(aj paramaj)
  {
    AppMethodBeat.i(58029);
    aj localaj = paramaj.zo(false);
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
    k.h(paramg, "newAnnotations");
    paramg = new f(this.Lqj.d(paramg));
    AppMethodBeat.o(58030);
    return paramg;
  }
  
  public final ab R(ab paramab)
  {
    AppMethodBeat.i(58028);
    k.h(paramab, "replacement");
    paramab = paramab.gcz();
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
      paramab = (ab)be.b(ac.a(a(((v)paramab).LLa), a(((v)paramab).LLb)), be.aK((ab)paramab));
      AppMethodBeat.o(58028);
      return paramab;
    }
    paramab = (Throwable)new IllegalStateException("Incorrect type: ".concat(String.valueOf(paramab)).toString());
    AppMethodBeat.o(58028);
    throw paramab;
  }
  
  public final aj fUt()
  {
    return this.Lqj;
  }
  
  public final boolean fUw()
  {
    return true;
  }
  
  public final boolean fUx()
  {
    return false;
  }
  
  public final aj zo(boolean paramBoolean)
  {
    AppMethodBeat.i(58033);
    if (paramBoolean)
    {
      localaj = this.Lqj.zo(true);
      AppMethodBeat.o(58033);
      return localaj;
    }
    aj localaj = (aj)this;
    AppMethodBeat.o(58033);
    return localaj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.d.a.f.f
 * JD-Core Version:    0.7.0.1
 */