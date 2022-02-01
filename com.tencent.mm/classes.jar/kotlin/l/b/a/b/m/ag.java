package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.a;
import kotlin.g.b.u;
import kotlin.l.b.a.b.l.h;
import kotlin.l.b.a.b.l.m;
import kotlin.l.b.a.b.m.a.g;

public final class ag
  extends bm
{
  private final m aiBu;
  final a<ad> ajoB;
  private final h<ad> ajqc;
  
  public ag(m paramm, a<? extends ad> parama)
  {
    AppMethodBeat.i(60778);
    this.aiBu = paramm;
    this.ajoB = parama;
    this.ajqc = this.aiBu.cq(this.ajoB);
    AppMethodBeat.o(60778);
  }
  
  protected final ad kAL()
  {
    AppMethodBeat.i(60775);
    ad localad = (ad)this.ajqc.invoke();
    AppMethodBeat.o(60775);
    return localad;
  }
  
  public final boolean kAv()
  {
    AppMethodBeat.i(60776);
    boolean bool = this.ajqc.kAv();
    AppMethodBeat.o(60776);
    return bool;
  }
  
  static final class a
    extends u
    implements a<ad>
  {
    a(g paramg, ag paramag)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.m.ag
 * JD-Core Version:    0.7.0.1
 */