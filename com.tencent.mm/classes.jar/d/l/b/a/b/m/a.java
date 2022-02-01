package d.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l.b.a.b.b.a.g;
import d.l.b.a.b.m.a.i;
import d.v;

public final class a
  extends n
{
  public final aj NEl;
  public final aj NYo;
  
  public a(aj paramaj1, aj paramaj2)
  {
    AppMethodBeat.i(60568);
    this.NEl = paramaj1;
    this.NYo = paramaj2;
    AppMethodBeat.o(60568);
  }
  
  private a AD(boolean paramBoolean)
  {
    AppMethodBeat.i(60560);
    a locala = new a(this.NEl.Ap(paramBoolean), this.NYo.Ap(paramBoolean));
    AppMethodBeat.o(60560);
    return locala;
  }
  
  private a f(g paramg)
  {
    AppMethodBeat.i(60557);
    p.h(paramg, "newAnnotations");
    paramg = new a(this.NEl.d(paramg), this.NYo);
    AppMethodBeat.o(60557);
    return paramg;
  }
  
  private a h(i parami)
  {
    AppMethodBeat.i(60564);
    p.h(parami, "kotlinTypeRefiner");
    Object localObject = parami.aL((ab)this.NEl);
    if (localObject == null)
    {
      parami = new v("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
      AppMethodBeat.o(60564);
      throw parami;
    }
    localObject = (aj)localObject;
    parami = parami.aL((ab)this.NYo);
    if (parami == null)
    {
      parami = new v("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
      AppMethodBeat.o(60564);
      throw parami;
    }
    parami = new a((aj)localObject, (aj)parami);
    AppMethodBeat.o(60564);
    return parami;
  }
  
  protected final aj gqu()
  {
    return this.NEl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.m.a
 * JD-Core Version:    0.7.0.1
 */