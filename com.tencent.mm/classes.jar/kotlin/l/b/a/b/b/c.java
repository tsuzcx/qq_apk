package kotlin.l.b.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.l.j;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.b.a.b.m.at;
import kotlin.l.b.a.b.m.bh;

final class c
  implements as
{
  private final as aaJV;
  private final l aaJW;
  private final int aaJX;
  
  public c(as paramas, l paraml, int paramInt)
  {
    AppMethodBeat.i(56835);
    this.aaJV = paramas;
    this.aaJW = paraml;
    this.aaJX = paramInt;
    AppMethodBeat.o(56835);
  }
  
  public final <R, D> R a(n<R, D> paramn, D paramD)
  {
    AppMethodBeat.i(56837);
    paramn = this.aaJV.a(paramn, paramD);
    AppMethodBeat.o(56837);
    return paramn;
  }
  
  public final int getIndex()
  {
    AppMethodBeat.i(56833);
    int i = this.aaJX;
    int j = this.aaJV.getIndex();
    AppMethodBeat.o(56833);
    return i + j;
  }
  
  public final List<ab> iCz()
  {
    AppMethodBeat.i(56842);
    List localList = this.aaJV.iCz();
    AppMethodBeat.o(56842);
    return localList;
  }
  
  public final l iDJ()
  {
    return this.aaJW;
  }
  
  public final at iDL()
  {
    AppMethodBeat.i(56841);
    at localat = this.aaJV.iDL();
    AppMethodBeat.o(56841);
    return localat;
  }
  
  public final g iDY()
  {
    AppMethodBeat.i(56836);
    g localg = this.aaJV.iDY();
    AppMethodBeat.o(56836);
    return localg;
  }
  
  public final an iDZ()
  {
    AppMethodBeat.i(56840);
    an localan = this.aaJV.iDZ();
    AppMethodBeat.o(56840);
    return localan;
  }
  
  public final boolean iEP()
  {
    return true;
  }
  
  public final as iEQ()
  {
    AppMethodBeat.i(56830);
    as localas = this.aaJV.iEQ();
    p.j(localas, "originalDescriptor.original");
    AppMethodBeat.o(56830);
    return localas;
  }
  
  public final aj iET()
  {
    AppMethodBeat.i(56838);
    aj localaj = this.aaJV.iET();
    AppMethodBeat.o(56838);
    return localaj;
  }
  
  public final f iEU()
  {
    AppMethodBeat.i(56839);
    f localf = this.aaJV.iEU();
    AppMethodBeat.o(56839);
    return localf;
  }
  
  public final j iEV()
  {
    AppMethodBeat.i(252378);
    j localj = this.aaJV.iEV();
    AppMethodBeat.o(252378);
    return localj;
  }
  
  public final bh iEW()
  {
    AppMethodBeat.i(56843);
    bh localbh = this.aaJV.iEW();
    AppMethodBeat.o(56843);
    return localbh;
  }
  
  public final boolean iEX()
  {
    AppMethodBeat.i(56844);
    boolean bool = this.aaJV.iEX();
    AppMethodBeat.o(56844);
    return bool;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(56834);
    String str = this.aaJV + "[inner-copy]";
    AppMethodBeat.o(56834);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.b.c
 * JD-Core Version:    0.7.0.1
 */