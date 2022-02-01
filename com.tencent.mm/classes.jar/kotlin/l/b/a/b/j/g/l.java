package kotlin.l.b.a.b.j.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.ak;
import kotlin.g.a.a;
import kotlin.g.b.af;
import kotlin.g.b.ag;
import kotlin.g.b.ai;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.l.b.a.b.b.au;
import kotlin.l.b.a.b.b.f;
import kotlin.l.b.a.b.l.h;
import kotlin.l.b.a.b.l.m;
import kotlin.l.o;

public final class l
  extends i
{
  private final kotlin.l.b.a.b.b.e ajlc;
  private final h ajln;
  
  static
  {
    AppMethodBeat.i(60219);
    aYe = new o[] { (o)ai.a((af)new ag((kotlin.l.e)ai.cz(l.class), "functions", "getFunctions()Ljava/util/List;")) };
    AppMethodBeat.o(60219);
  }
  
  public l(m paramm, kotlin.l.b.a.b.b.e parame)
  {
    AppMethodBeat.i(60224);
    this.ajlc = parame;
    if (this.ajlc.kna() == f.aiGv) {}
    for (int i = 1; (ak.aiuY) && (i == 0); i = 0)
    {
      paramm = (Throwable)new AssertionError(s.X("Class should be an enum: ", this.ajlc));
      AppMethodBeat.o(60224);
      throw paramm;
    }
    this.ajln = paramm.cq((a)new a(this));
    AppMethodBeat.o(60224);
  }
  
  private final List<au> kzL()
  {
    AppMethodBeat.i(60221);
    List localList = (List)kotlin.l.b.a.b.l.l.a(this.ajln, aYe[0]);
    AppMethodBeat.o(60221);
    return localList;
  }
  
  static final class a
    extends u
    implements a<List<? extends au>>
  {
    a(l paraml)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.j.g.l
 * JD-Core Version:    0.7.0.1
 */