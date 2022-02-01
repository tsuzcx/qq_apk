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
  private final as Nrt;
  private final l Nru;
  private final int Nrv;
  
  public c(as paramas, l paraml, int paramInt)
  {
    AppMethodBeat.i(56835);
    this.Nrt = paramas;
    this.Nru = paraml;
    this.Nrv = paramInt;
    AppMethodBeat.o(56835);
  }
  
  public final <R, D> R a(n<R, D> paramn, D paramD)
  {
    AppMethodBeat.i(56837);
    paramn = this.Nrt.a(paramn, paramD);
    AppMethodBeat.o(56837);
    return paramn;
  }
  
  public final int getIndex()
  {
    AppMethodBeat.i(56833);
    int i = this.Nrv;
    int j = this.Nrt.getIndex();
    AppMethodBeat.o(56833);
    return i + j;
  }
  
  public final List<ab> gkL()
  {
    AppMethodBeat.i(56842);
    List localList = this.Nrt.gkL();
    AppMethodBeat.o(56842);
    return localList;
  }
  
  public final l glU()
  {
    return this.Nru;
  }
  
  public final at glW()
  {
    AppMethodBeat.i(56841);
    at localat = this.Nrt.glW();
    AppMethodBeat.o(56841);
    return localat;
  }
  
  public final g gmj()
  {
    AppMethodBeat.i(56836);
    g localg = this.Nrt.gmj();
    AppMethodBeat.o(56836);
    return localg;
  }
  
  public final an gmk()
  {
    AppMethodBeat.i(56840);
    an localan = this.Nrt.gmk();
    AppMethodBeat.o(56840);
    return localan;
  }
  
  public final boolean gna()
  {
    return true;
  }
  
  public final as gnb()
  {
    AppMethodBeat.i(56830);
    as localas = this.Nrt.gnb();
    p.g(localas, "originalDescriptor.original");
    AppMethodBeat.o(56830);
    return localas;
  }
  
  public final aj gne()
  {
    AppMethodBeat.i(56838);
    aj localaj = this.Nrt.gne();
    AppMethodBeat.o(56838);
    return localaj;
  }
  
  public final f gnf()
  {
    AppMethodBeat.i(56839);
    f localf = this.Nrt.gnf();
    AppMethodBeat.o(56839);
    return localf;
  }
  
  public final j gng()
  {
    AppMethodBeat.i(193291);
    j localj = this.Nrt.gng();
    AppMethodBeat.o(193291);
    return localj;
  }
  
  public final bh gnh()
  {
    AppMethodBeat.i(56843);
    bh localbh = this.Nrt.gnh();
    AppMethodBeat.o(56843);
    return localbh;
  }
  
  public final boolean gni()
  {
    AppMethodBeat.i(56844);
    boolean bool = this.Nrt.gni();
    AppMethodBeat.o(56844);
    return bool;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(56834);
    String str = this.Nrt + "[inner-copy]";
    AppMethodBeat.o(56834);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.b.c
 * JD-Core Version:    0.7.0.1
 */