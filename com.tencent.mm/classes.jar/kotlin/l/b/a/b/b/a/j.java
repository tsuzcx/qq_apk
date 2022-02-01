package kotlin.l.b.a.b.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.k;
import kotlin.l.b.a.b.a.h;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.j.b.g;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.al;
import kotlin.o;

public final class j
  implements c
{
  final h aiIk;
  final kotlin.l.b.a.b.f.c aiIl;
  private final Map<f, g<?>> aiIm;
  private final kotlin.j aiIn;
  
  public j(h paramh, kotlin.l.b.a.b.f.c paramc, Map<f, ? extends g<?>> paramMap)
  {
    AppMethodBeat.i(56960);
    this.aiIk = paramh;
    this.aiIl = paramc;
    this.aiIm = paramMap;
    this.aiIn = k.a(o.aiuG, (a)new a(this));
    AppMethodBeat.o(56960);
  }
  
  public final av knm()
  {
    AppMethodBeat.i(56959);
    av localav = av.aiHu;
    s.s(localav, "NO_SOURCE");
    AppMethodBeat.o(56959);
    return localav;
  }
  
  public final ad koG()
  {
    AppMethodBeat.i(56958);
    Object localObject = this.aiIn.getValue();
    s.s(localObject, "<get-type>(...)");
    localObject = (ad)localObject;
    AppMethodBeat.o(56958);
    return localObject;
  }
  
  public final kotlin.l.b.a.b.f.c koY()
  {
    return this.aiIl;
  }
  
  public final Map<f, g<?>> kpA()
  {
    return this.aiIm;
  }
  
  static final class a
    extends u
    implements a<al>
  {
    a(j paramj)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.a.j
 * JD-Core Version:    0.7.0.1
 */