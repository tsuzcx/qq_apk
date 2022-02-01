package kotlin.l.b.a.b.d.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.d.a.e.x;
import kotlin.l.b.a.b.d.a.e.y;
import kotlin.l.b.a.b.l.g;
import kotlin.l.b.a.b.o.a;

public final class i
  implements l
{
  final kotlin.l.b.a.b.b.l aiJT;
  final h aiSh;
  final int aiSu;
  final Map<x, Integer> aiSv;
  private final g<x, kotlin.l.b.a.b.d.a.c.a.m> aiSw;
  
  public i(h paramh, kotlin.l.b.a.b.b.l paraml, y paramy, int paramInt)
  {
    AppMethodBeat.i(57764);
    this.aiSh = paramh;
    this.aiJT = paraml;
    this.aiSu = paramInt;
    this.aiSv = a.J((Iterable)paramy.koa());
    this.aiSw = this.aiSh.aiSp.aiBu.be((b)new a(this));
    AppMethodBeat.o(57764);
  }
  
  public final ba a(x paramx)
  {
    AppMethodBeat.i(57763);
    s.u(paramx, "javaTypeParameter");
    kotlin.l.b.a.b.d.a.c.a.m localm = (kotlin.l.b.a.b.d.a.c.a.m)this.aiSw.invoke(paramx);
    if (localm == null)
    {
      paramx = this.aiSh.aiSq.a(paramx);
      AppMethodBeat.o(57763);
      return paramx;
    }
    paramx = (ba)localm;
    AppMethodBeat.o(57763);
    return paramx;
  }
  
  static final class a
    extends u
    implements b<x, kotlin.l.b.a.b.d.a.c.a.m>
  {
    a(i parami)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.c.i
 * JD-Core Version:    0.7.0.1
 */