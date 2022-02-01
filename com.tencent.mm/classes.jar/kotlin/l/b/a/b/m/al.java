package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.m.a.i;
import kotlin.t;

public final class al
  extends n
  implements bd
{
  private final aj aaWM;
  private final ab abqA;
  
  public al(aj paramaj, ab paramab)
  {
    AppMethodBeat.i(60801);
    this.aaWM = paramaj;
    this.abqA = paramab;
    AppMethodBeat.o(60801);
  }
  
  private al l(i parami)
  {
    AppMethodBeat.i(60797);
    p.k(parami, "kotlinTypeRefiner");
    ab localab = parami.aK((ab)this.aaWM);
    if (localab == null)
    {
      parami = new t("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
      AppMethodBeat.o(60797);
      throw parami;
    }
    parami = new al((aj)localab, parami.aK(this.abqA));
    AppMethodBeat.o(60797);
    return parami;
  }
  
  public final aj Jn(boolean paramBoolean)
  {
    AppMethodBeat.i(60794);
    Object localObject = be.b(((bg)this.aaWM).Jm(paramBoolean), (ab)this.abqA.iPX().Jm(paramBoolean));
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
      AppMethodBeat.o(60794);
      throw ((Throwable)localObject);
    }
    localObject = (aj)localObject;
    AppMethodBeat.o(60794);
    return localObject;
  }
  
  public final aj d(g paramg)
  {
    AppMethodBeat.i(60792);
    p.k(paramg, "newAnnotations");
    paramg = be.b(((bg)this.aaWM).b(paramg), this.abqA);
    if (paramg == null)
    {
      paramg = new t("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
      AppMethodBeat.o(60792);
      throw paramg;
    }
    paramg = (aj)paramg;
    AppMethodBeat.o(60792);
    return paramg;
  }
  
  protected final aj iIq()
  {
    return this.aaWM;
  }
  
  public final bg iPU()
  {
    return (bg)this.aaWM;
  }
  
  public final ab iPV()
  {
    return this.abqA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.m.al
 * JD-Core Version:    0.7.0.1
 */