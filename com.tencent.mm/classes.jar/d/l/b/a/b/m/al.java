package d.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l.b.a.b.b.a.g;
import d.l.b.a.b.m.a.i;
import d.v;

public final class al
  extends n
  implements bd
{
  private final aj NEl;
  private final ab NZh;
  
  public al(aj paramaj, ab paramab)
  {
    AppMethodBeat.i(60801);
    this.NEl = paramaj;
    this.NZh = paramab;
    AppMethodBeat.o(60801);
  }
  
  private al l(i parami)
  {
    AppMethodBeat.i(60797);
    p.h(parami, "kotlinTypeRefiner");
    ab localab = parami.aL((ab)this.NEl);
    if (localab == null)
    {
      parami = new v("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
      AppMethodBeat.o(60797);
      throw parami;
    }
    parami = new al((aj)localab, parami.aL(this.NZh));
    AppMethodBeat.o(60797);
    return parami;
  }
  
  public final aj Ap(boolean paramBoolean)
  {
    AppMethodBeat.i(60794);
    Object localObject = be.b(((bg)this.NEl).Ao(paramBoolean), (ab)this.NZh.gyC().Ao(paramBoolean));
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
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
    paramg = be.b(((bg)this.NEl).b(paramg), this.NZh);
    if (paramg == null)
    {
      paramg = new v("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
      AppMethodBeat.o(60792);
      throw paramg;
    }
    paramg = (aj)paramg;
    AppMethodBeat.o(60792);
    return paramg;
  }
  
  protected final aj gqu()
  {
    return this.NEl;
  }
  
  public final ab gyA()
  {
    return this.NZh;
  }
  
  public final bg gyz()
  {
    return (bg)this.NEl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.m.al
 * JD-Core Version:    0.7.0.1
 */