package kotlin.l.b.a.b.d.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.ac;
import kotlin.l.b.a.b.m.ag;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.b.a.b.m.bc;
import kotlin.l.b.a.b.m.be;
import kotlin.l.b.a.b.m.d.a;
import kotlin.l.b.a.b.m.n;
import kotlin.l.b.a.b.m.v;

public final class f
  extends n
  implements ag
{
  private final aj aaWM;
  
  public f(aj paramaj)
  {
    AppMethodBeat.i(58036);
    this.aaWM = paramaj;
    AppMethodBeat.o(58036);
  }
  
  private static aj a(aj paramaj)
  {
    AppMethodBeat.i(58029);
    aj localaj = paramaj.Jn(false);
    if (!a.aH((ab)paramaj))
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
    p.k(paramg, "newAnnotations");
    paramg = new f(this.aaWM.d(paramg));
    AppMethodBeat.o(58030);
    return paramg;
  }
  
  public final aj Jn(boolean paramBoolean)
  {
    AppMethodBeat.i(58033);
    if (paramBoolean)
    {
      localaj = this.aaWM.Jn(true);
      AppMethodBeat.o(58033);
      return localaj;
    }
    aj localaj = (aj)this;
    AppMethodBeat.o(58033);
    return localaj;
  }
  
  public final ab Q(ab paramab)
  {
    AppMethodBeat.i(58028);
    p.k(paramab, "replacement");
    paramab = paramab.iPX();
    if ((!bc.aE((ab)paramab)) && (!a.aH((ab)paramab)))
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
      paramab = (ab)be.b(ac.a(a(((v)paramab).abqv), a(((v)paramab).abqw)), be.aJ((ab)paramab));
      AppMethodBeat.o(58028);
      return paramab;
    }
    paramab = (Throwable)new IllegalStateException("Incorrect type: ".concat(String.valueOf(paramab)).toString());
    AppMethodBeat.o(58028);
    throw paramab;
  }
  
  public final aj iIq()
  {
    return this.aaWM;
  }
  
  public final boolean iIt()
  {
    return true;
  }
  
  public final boolean iIu()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.f.f
 * JD-Core Version:    0.7.0.1
 */