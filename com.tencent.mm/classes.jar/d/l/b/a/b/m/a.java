package d.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l.b.a.b.b.a.g;
import d.l.b.a.b.m.a.i;
import d.v;

public final class a
  extends n
{
  public final aj JCQ;
  public final aj JWP;
  
  public a(aj paramaj1, aj paramaj2)
  {
    AppMethodBeat.i(60568);
    this.JCQ = paramaj1;
    this.JWP = paramaj2;
    AppMethodBeat.o(60568);
  }
  
  private a f(g paramg)
  {
    AppMethodBeat.i(60557);
    k.h(paramg, "newAnnotations");
    paramg = new a(this.JCQ.d(paramg), this.JWP);
    AppMethodBeat.o(60557);
    return paramg;
  }
  
  private a h(i parami)
  {
    AppMethodBeat.i(60564);
    k.h(parami, "kotlinTypeRefiner");
    Object localObject = parami.aL((ab)this.JCQ);
    if (localObject == null)
    {
      parami = new v("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
      AppMethodBeat.o(60564);
      throw parami;
    }
    localObject = (aj)localObject;
    parami = parami.aL((ab)this.JWP);
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
  
  private a yk(boolean paramBoolean)
  {
    AppMethodBeat.i(60560);
    a locala = new a(this.JCQ.xW(paramBoolean), this.JWP.xW(paramBoolean));
    AppMethodBeat.o(60560);
    return locala;
  }
  
  protected final aj fBP()
  {
    return this.JCQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.m.a
 * JD-Core Version:    0.7.0.1
 */