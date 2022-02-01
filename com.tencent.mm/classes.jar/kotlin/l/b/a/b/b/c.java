package kotlin.l.b.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.l.m;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.al;
import kotlin.l.b.a.b.m.ax;
import kotlin.l.b.a.b.m.bl;

final class c
  implements ba
{
  private final ba aiGq;
  private final l aiGr;
  private final int aiGs;
  
  public c(ba paramba, l paraml, int paramInt)
  {
    AppMethodBeat.i(56835);
    this.aiGq = paramba;
    this.aiGr = paraml;
    this.aiGs = paramInt;
    AppMethodBeat.o(56835);
  }
  
  public final <R, D> R a(n<R, D> paramn, D paramD)
  {
    AppMethodBeat.i(56837);
    paramn = this.aiGq.a(paramn, paramD);
    AppMethodBeat.o(56837);
    return paramn;
  }
  
  public final int getIndex()
  {
    AppMethodBeat.i(56833);
    int i = this.aiGs;
    int j = this.aiGq.getIndex();
    AppMethodBeat.o(56833);
    return i + j;
  }
  
  public final List<ad> klF()
  {
    AppMethodBeat.i(56842);
    List localList = this.aiGq.klF();
    AppMethodBeat.o(56842);
    return localList;
  }
  
  public final ax kmZ()
  {
    AppMethodBeat.i(56841);
    ax localax = this.aiGq.kmZ();
    AppMethodBeat.o(56841);
    return localax;
  }
  
  public final g knl()
  {
    AppMethodBeat.i(56836);
    g localg = this.aiGq.knl();
    AppMethodBeat.o(56836);
    return localg;
  }
  
  public final av knm()
  {
    AppMethodBeat.i(56840);
    av localav = this.aiGq.knm();
    AppMethodBeat.o(56840);
    return localav;
  }
  
  public final l knp()
  {
    return this.aiGr;
  }
  
  public final al koj()
  {
    AppMethodBeat.i(56838);
    al localal = this.aiGq.koj();
    AppMethodBeat.o(56838);
    return localal;
  }
  
  public final f kok()
  {
    AppMethodBeat.i(56839);
    f localf = this.aiGq.kok();
    AppMethodBeat.o(56839);
    return localf;
  }
  
  public final m kol()
  {
    AppMethodBeat.i(191774);
    m localm = this.aiGq.kol();
    AppMethodBeat.o(191774);
    return localm;
  }
  
  public final bl kom()
  {
    AppMethodBeat.i(56843);
    bl localbl = this.aiGq.kom();
    AppMethodBeat.o(56843);
    return localbl;
  }
  
  public final boolean kon()
  {
    AppMethodBeat.i(56844);
    boolean bool = this.aiGq.kon();
    AppMethodBeat.o(56844);
    return bool;
  }
  
  public final boolean koo()
  {
    return true;
  }
  
  public final ba kop()
  {
    AppMethodBeat.i(56830);
    ba localba = this.aiGq.kop();
    s.s(localba, "originalDescriptor.original");
    AppMethodBeat.o(56830);
    return localba;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(56834);
    String str = this.aiGq + "[inner-copy]";
    AppMethodBeat.o(56834);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.c
 * JD-Core Version:    0.7.0.1
 */