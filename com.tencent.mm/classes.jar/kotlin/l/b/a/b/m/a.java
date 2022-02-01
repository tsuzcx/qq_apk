package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.m.a.i;
import kotlin.t;

public final class a
  extends n
{
  public final aj TNh;
  public final aj TtS;
  
  public a(aj paramaj1, aj paramaj2)
  {
    AppMethodBeat.i(60568);
    this.TtS = paramaj1;
    this.TNh = paramaj2;
    AppMethodBeat.o(60568);
  }
  
  private a ET(boolean paramBoolean)
  {
    AppMethodBeat.i(60560);
    a locala = new a(this.TtS.EG(paramBoolean), this.TNh.EG(paramBoolean));
    AppMethodBeat.o(60560);
    return locala;
  }
  
  private a f(g paramg)
  {
    AppMethodBeat.i(60557);
    p.h(paramg, "newAnnotations");
    paramg = new a(this.TtS.d(paramg), this.TNh);
    AppMethodBeat.o(60557);
    return paramg;
  }
  
  private a h(i parami)
  {
    AppMethodBeat.i(60564);
    p.h(parami, "kotlinTypeRefiner");
    Object localObject = parami.aK((ab)this.TtS);
    if (localObject == null)
    {
      parami = new t("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
      AppMethodBeat.o(60564);
      throw parami;
    }
    localObject = (aj)localObject;
    parami = parami.aK((ab)this.TNh);
    if (parami == null)
    {
      parami = new t("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
      AppMethodBeat.o(60564);
      throw parami;
    }
    parami = new a((aj)localObject, (aj)parami);
    AppMethodBeat.o(60564);
    return parami;
  }
  
  protected final aj hDW()
  {
    return this.TtS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.m.a
 * JD-Core Version:    0.7.0.1
 */