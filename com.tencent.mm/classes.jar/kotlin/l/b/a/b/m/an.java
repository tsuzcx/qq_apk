package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.s;

public final class an
  extends o
  implements bh
{
  public final al aiUV;
  private final ad ajpJ;
  
  public an(al paramal, ad paramad)
  {
    AppMethodBeat.i(60801);
    this.aiUV = paramal;
    this.ajpJ = paramad;
    AppMethodBeat.o(60801);
  }
  
  private an n(kotlin.l.b.a.b.m.a.g paramg)
  {
    AppMethodBeat.i(60797);
    s.u(paramg, "kotlinTypeRefiner");
    paramg = new an((al)paramg.aD((ad)this.aiUV), paramg.aD(this.ajpJ));
    AppMethodBeat.o(60797);
    return paramg;
  }
  
  public final al Pq(boolean paramBoolean)
  {
    AppMethodBeat.i(60794);
    al localal = (al)bi.b((bk)this.aiUV.Pq(paramBoolean), (ad)this.ajpJ.kAK().Pp(paramBoolean));
    AppMethodBeat.o(60794);
    return localal;
  }
  
  public final al d(kotlin.l.b.a.b.b.a.g paramg)
  {
    AppMethodBeat.i(60792);
    s.u(paramg, "newAnnotations");
    paramg = (al)bi.b((bk)this.aiUV.d(paramg), this.ajpJ);
    AppMethodBeat.o(60792);
    return paramg;
  }
  
  public final ad kAG()
  {
    return this.ajpJ;
  }
  
  protected final al ksx()
  {
    return this.aiUV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.m.an
 * JD-Core Version:    0.7.0.1
 */