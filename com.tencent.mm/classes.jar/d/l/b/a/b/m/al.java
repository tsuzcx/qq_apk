package d.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l.b.a.b.b.a.g;
import d.l.b.a.b.m.a.i;
import d.v;

public final class al
  extends n
  implements bd
{
  private final ab LLf;
  private final aj Lqj;
  
  public al(aj paramaj, ab paramab)
  {
    AppMethodBeat.i(60801);
    this.Lqj = paramaj;
    this.LLf = paramab;
    AppMethodBeat.o(60801);
  }
  
  private al l(i parami)
  {
    AppMethodBeat.i(60797);
    k.h(parami, "kotlinTypeRefiner");
    ab localab = parami.aL((ab)this.Lqj);
    if (localab == null)
    {
      parami = new v("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
      AppMethodBeat.o(60797);
      throw parami;
    }
    parami = new al((aj)localab, parami.aL(this.LLf));
    AppMethodBeat.o(60797);
    return parami;
  }
  
  public final aj d(g paramg)
  {
    AppMethodBeat.i(60792);
    k.h(paramg, "newAnnotations");
    paramg = be.b(((bg)this.Lqj).b(paramg), this.LLf);
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
  
  protected final aj fUt()
  {
    return this.Lqj;
  }
  
  public final bg gcw()
  {
    return (bg)this.Lqj;
  }
  
  public final ab gcx()
  {
    return this.LLf;
  }
  
  public final aj zo(boolean paramBoolean)
  {
    AppMethodBeat.i(60794);
    Object localObject = be.b(((bg)this.Lqj).zn(paramBoolean), (ab)this.LLf.gcz().zn(paramBoolean));
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.m.al
 * JD-Core Version:    0.7.0.1
 */