package d.l.b.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l.b.a.b.b.a.g;
import d.l.b.a.b.f.f;
import d.l.b.a.b.l.j;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.aj;
import d.l.b.a.b.m.at;
import d.l.b.a.b.m.bh;
import java.util.List;

final class c
  implements as
{
  private final as MUo;
  private final l MUp;
  private final int MUq;
  
  public c(as paramas, l paraml, int paramInt)
  {
    AppMethodBeat.i(56835);
    this.MUo = paramas;
    this.MUp = paraml;
    this.MUq = paramInt;
    AppMethodBeat.o(56835);
  }
  
  public final <R, D> R a(n<R, D> paramn, D paramD)
  {
    AppMethodBeat.i(56837);
    paramn = this.MUo.a(paramn, paramD);
    AppMethodBeat.o(56837);
    return paramn;
  }
  
  public final int getIndex()
  {
    AppMethodBeat.i(56833);
    int i = this.MUq;
    int j = this.MUo.getIndex();
    AppMethodBeat.o(56833);
    return i + j;
  }
  
  public final List<ab> ggj()
  {
    AppMethodBeat.i(56842);
    List localList = this.MUo.ggj();
    AppMethodBeat.o(56842);
    return localList;
  }
  
  public final g ghH()
  {
    AppMethodBeat.i(56836);
    g localg = this.MUo.ghH();
    AppMethodBeat.o(56836);
    return localg;
  }
  
  public final an ghI()
  {
    AppMethodBeat.i(56840);
    an localan = this.MUo.ghI();
    AppMethodBeat.o(56840);
    return localan;
  }
  
  public final l ghs()
  {
    return this.MUp;
  }
  
  public final at ghu()
  {
    AppMethodBeat.i(56841);
    at localat = this.MUo.ghu();
    AppMethodBeat.o(56841);
    return localat;
  }
  
  public final aj giC()
  {
    AppMethodBeat.i(56838);
    aj localaj = this.MUo.giC();
    AppMethodBeat.o(56838);
    return localaj;
  }
  
  public final f giD()
  {
    AppMethodBeat.i(56839);
    f localf = this.MUo.giD();
    AppMethodBeat.o(56839);
    return localf;
  }
  
  public final j giE()
  {
    AppMethodBeat.i(187767);
    j localj = this.MUo.giE();
    AppMethodBeat.o(187767);
    return localj;
  }
  
  public final bh giF()
  {
    AppMethodBeat.i(56843);
    bh localbh = this.MUo.giF();
    AppMethodBeat.o(56843);
    return localbh;
  }
  
  public final boolean giG()
  {
    AppMethodBeat.i(56844);
    boolean bool = this.MUo.giG();
    AppMethodBeat.o(56844);
    return bool;
  }
  
  public final boolean giy()
  {
    return true;
  }
  
  public final as giz()
  {
    AppMethodBeat.i(56830);
    as localas = this.MUo.giz();
    p.g(localas, "originalDescriptor.original");
    AppMethodBeat.o(56830);
    return localas;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(56834);
    String str = this.MUo + "[inner-copy]";
    AppMethodBeat.o(56834);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.b.c
 * JD-Core Version:    0.7.0.1
 */