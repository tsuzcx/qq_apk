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
  private final as Thb;
  private final l Thc;
  private final int Thd;
  
  public c(as paramas, l paraml, int paramInt)
  {
    AppMethodBeat.i(56835);
    this.Thb = paramas;
    this.Thc = paraml;
    this.Thd = paramInt;
    AppMethodBeat.o(56835);
  }
  
  public final <R, D> R a(n<R, D> paramn, D paramD)
  {
    AppMethodBeat.i(56837);
    paramn = this.Thb.a(paramn, paramD);
    AppMethodBeat.o(56837);
    return paramn;
  }
  
  public final int getIndex()
  {
    AppMethodBeat.i(56833);
    int i = this.Thd;
    int j = this.Thb.getIndex();
    AppMethodBeat.o(56833);
    return i + j;
  }
  
  public final boolean hAC()
  {
    return true;
  }
  
  public final as hAD()
  {
    AppMethodBeat.i(56830);
    as localas = this.Thb.hAD();
    p.g(localas, "originalDescriptor.original");
    AppMethodBeat.o(56830);
    return localas;
  }
  
  public final aj hAG()
  {
    AppMethodBeat.i(56838);
    aj localaj = this.Thb.hAG();
    AppMethodBeat.o(56838);
    return localaj;
  }
  
  public final f hAH()
  {
    AppMethodBeat.i(56839);
    f localf = this.Thb.hAH();
    AppMethodBeat.o(56839);
    return localf;
  }
  
  public final j hAI()
  {
    AppMethodBeat.i(186241);
    j localj = this.Thb.hAI();
    AppMethodBeat.o(186241);
    return localj;
  }
  
  public final bh hAJ()
  {
    AppMethodBeat.i(56843);
    bh localbh = this.Thb.hAJ();
    AppMethodBeat.o(56843);
    return localbh;
  }
  
  public final boolean hAK()
  {
    AppMethodBeat.i(56844);
    boolean bool = this.Thb.hAK();
    AppMethodBeat.o(56844);
    return bool;
  }
  
  public final List<ab> hyo()
  {
    AppMethodBeat.i(56842);
    List localList = this.Thb.hyo();
    AppMethodBeat.o(56842);
    return localList;
  }
  
  public final g hzL()
  {
    AppMethodBeat.i(56836);
    g localg = this.Thb.hzL();
    AppMethodBeat.o(56836);
    return localg;
  }
  
  public final an hzM()
  {
    AppMethodBeat.i(56840);
    an localan = this.Thb.hzM();
    AppMethodBeat.o(56840);
    return localan;
  }
  
  public final l hzx()
  {
    return this.Thc;
  }
  
  public final at hzz()
  {
    AppMethodBeat.i(56841);
    at localat = this.Thb.hzz();
    AppMethodBeat.o(56841);
    return localat;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(56834);
    String str = this.Thb + "[inner-copy]";
    AppMethodBeat.o(56834);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.b.c
 * JD-Core Version:    0.7.0.1
 */