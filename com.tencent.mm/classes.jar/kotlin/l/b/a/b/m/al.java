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
  private final ab TOa;
  private final aj TtS;
  
  public al(aj paramaj, ab paramab)
  {
    AppMethodBeat.i(60801);
    this.TtS = paramaj;
    this.TOa = paramab;
    AppMethodBeat.o(60801);
  }
  
  private al l(i parami)
  {
    AppMethodBeat.i(60797);
    p.h(parami, "kotlinTypeRefiner");
    ab localab = parami.aK((ab)this.TtS);
    if (localab == null)
    {
      parami = new t("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
      AppMethodBeat.o(60797);
      throw parami;
    }
    parami = new al((aj)localab, parami.aK(this.TOa));
    AppMethodBeat.o(60797);
    return parami;
  }
  
  public final aj EG(boolean paramBoolean)
  {
    AppMethodBeat.i(60794);
    Object localObject = be.b(((bg)this.TtS).EF(paramBoolean), (ab)this.TOa.hLF().EF(paramBoolean));
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
    p.h(paramg, "newAnnotations");
    paramg = be.b(((bg)this.TtS).b(paramg), this.TOa);
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
  
  protected final aj hDW()
  {
    return this.TtS;
  }
  
  public final bg hLC()
  {
    return (bg)this.TtS;
  }
  
  public final ab hLD()
  {
    return this.TOa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.m.al
 * JD-Core Version:    0.7.0.1
 */