package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.s;
import kotlin.l.b.a.b.i.c;
import kotlin.l.b.a.b.i.f;

public final class z
  extends x
  implements bh
{
  private final x ajpI;
  public final ad ajpJ;
  
  public z(x paramx, ad paramad)
  {
    super(paramx.ajpE, paramx.ajpF);
    AppMethodBeat.i(60746);
    this.ajpI = paramx;
    this.ajpJ = paramad;
    AppMethodBeat.o(60746);
  }
  
  private z l(kotlin.l.b.a.b.m.a.g paramg)
  {
    AppMethodBeat.i(60743);
    s.u(paramg, "kotlinTypeRefiner");
    paramg = new z((x)paramg.aD((ad)this.ajpI), paramg.aD(this.ajpJ));
    AppMethodBeat.o(60743);
    return paramg;
  }
  
  public final bk Pp(boolean paramBoolean)
  {
    AppMethodBeat.i(60740);
    bk localbk = bi.b(this.ajpI.Pp(paramBoolean), (ad)this.ajpJ.kAK().Pp(paramBoolean));
    AppMethodBeat.o(60740);
    return localbk;
  }
  
  public final String a(c paramc, f paramf)
  {
    AppMethodBeat.i(60741);
    s.u(paramc, "renderer");
    s.u(paramf, "options");
    if (paramf.kyJ())
    {
      paramc = paramc.b(this.ajpJ);
      AppMethodBeat.o(60741);
      return paramc;
    }
    paramc = this.ajpI.a(paramc, paramf);
    AppMethodBeat.o(60741);
    return paramc;
  }
  
  public final bk b(kotlin.l.b.a.b.b.a.g paramg)
  {
    AppMethodBeat.i(60739);
    s.u(paramg, "newAnnotations");
    paramg = bi.b(this.ajpI.b(paramg), this.ajpJ);
    AppMethodBeat.o(60739);
    return paramg;
  }
  
  public final ad kAG()
  {
    return this.ajpJ;
  }
  
  public final al ksx()
  {
    AppMethodBeat.i(60742);
    al localal = this.ajpI.ksx();
    AppMethodBeat.o(60742);
    return localal;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.m.z
 * JD-Core Version:    0.7.0.1
 */