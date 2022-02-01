package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.s;

public final class a
  extends o
{
  public final al aiUV;
  public final al ajoN;
  
  public a(al paramal1, al paramal2)
  {
    AppMethodBeat.i(60568);
    this.aiUV = paramal1;
    this.ajoN = paramal2;
    AppMethodBeat.o(60568);
  }
  
  private a PD(boolean paramBoolean)
  {
    AppMethodBeat.i(60560);
    a locala = new a(this.aiUV.Pq(paramBoolean), this.ajoN.Pq(paramBoolean));
    AppMethodBeat.o(60560);
    return locala;
  }
  
  private a f(kotlin.l.b.a.b.b.a.g paramg)
  {
    AppMethodBeat.i(60557);
    s.u(paramg, "newAnnotations");
    paramg = new a(this.aiUV.d(paramg), this.ajoN);
    AppMethodBeat.o(60557);
    return paramg;
  }
  
  private a i(kotlin.l.b.a.b.m.a.g paramg)
  {
    AppMethodBeat.i(60564);
    s.u(paramg, "kotlinTypeRefiner");
    paramg = new a((al)paramg.aD((ad)this.aiUV), (al)paramg.aD((ad)this.ajoN));
    AppMethodBeat.o(60564);
    return paramg;
  }
  
  protected final al ksx()
  {
    return this.aiUV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.m.a
 * JD-Core Version:    0.7.0.1
 */