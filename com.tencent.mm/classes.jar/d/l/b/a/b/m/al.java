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
  private final ab NCa;
  private final aj Nhg;
  
  public al(aj paramaj, ab paramab)
  {
    AppMethodBeat.i(60801);
    this.Nhg = paramaj;
    this.NCa = paramab;
    AppMethodBeat.o(60801);
  }
  
  private al l(i parami)
  {
    AppMethodBeat.i(60797);
    p.h(parami, "kotlinTypeRefiner");
    ab localab = parami.aL((ab)this.Nhg);
    if (localab == null)
    {
      parami = new v("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
      AppMethodBeat.o(60797);
      throw parami;
    }
    parami = new al((aj)localab, parami.aL(this.NCa));
    AppMethodBeat.o(60797);
    return parami;
  }
  
  public final aj Ac(boolean paramBoolean)
  {
    AppMethodBeat.i(60794);
    Object localObject = be.b(((bg)this.Nhg).Ab(paramBoolean), (ab)this.NCa.gua().Ab(paramBoolean));
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
    paramg = be.b(((bg)this.Nhg).b(paramg), this.NCa);
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
  
  protected final aj glS()
  {
    return this.Nhg;
  }
  
  public final bg gtX()
  {
    return (bg)this.Nhg;
  }
  
  public final ab gtY()
  {
    return this.NCa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.m.al
 * JD-Core Version:    0.7.0.1
 */