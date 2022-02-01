package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.b.a.b.a.h;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.i.c;
import kotlin.l.b.a.b.m.d.a;

public final class s
  extends x
  implements kotlin.l.b.a.b.m.c.f
{
  private final g aiHM;
  
  private s(h paramh, g paramg)
  {
    super(localal, paramh);
    AppMethodBeat.i(60653);
    this.aiHM = paramg;
    AppMethodBeat.o(60653);
  }
  
  public final String a(c paramc, kotlin.l.b.a.b.i.f paramf)
  {
    AppMethodBeat.i(60650);
    kotlin.g.b.s.u(paramc, "renderer");
    kotlin.g.b.s.u(paramf, "options");
    AppMethodBeat.o(60650);
    return "dynamic";
  }
  
  public final s j(g paramg)
  {
    AppMethodBeat.i(191631);
    kotlin.g.b.s.u(paramg, "newAnnotations");
    paramg = new s(a.aE((ad)this.ajpF), paramg);
    AppMethodBeat.o(191631);
    return paramg;
  }
  
  public final g knl()
  {
    return this.aiHM;
  }
  
  public final boolean ksB()
  {
    return false;
  }
  
  public final al ksx()
  {
    return this.ajpF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.m.s
 * JD-Core Version:    0.7.0.1
 */