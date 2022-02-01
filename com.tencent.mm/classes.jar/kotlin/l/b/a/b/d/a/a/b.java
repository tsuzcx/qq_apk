package kotlin.l.b.a.b.d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import kotlin.a.ae;
import kotlin.g.b.aa;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.y;
import kotlin.l.b.a.b.b.a.c;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.d.a.b.i;
import kotlin.l.b.a.b.d.a.c.h;
import kotlin.l.b.a.b.d.a.e.l;
import kotlin.l.b.a.b.j.b.g;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.k;

public class b
  implements c, i
{
  final kotlin.l.b.a.b.f.b TiI;
  private final an Tik;
  private final kotlin.l.b.a.b.l.f TpP;
  final kotlin.l.b.a.b.d.a.e.b TpQ;
  private final boolean TpR;
  
  static
  {
    AppMethodBeat.i(57654);
    cLI = new k[] { (k)aa.a(new y(aa.bp(b.class), "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;")) };
    AppMethodBeat.o(57654);
  }
  
  public b(final h paramh, kotlin.l.b.a.b.d.a.e.a parama, kotlin.l.b.a.b.f.b paramb)
  {
    AppMethodBeat.i(57657);
    this.TiI = paramb;
    if (parama != null)
    {
      paramb = (an)paramh.Trv.TqY.a((l)parama);
      this.Tik = paramb;
      this.TpP = paramh.Trv.TcN.al((kotlin.g.a.a)new a(this, paramh));
      if (parama == null) {
        break label132;
      }
    }
    label132:
    for (paramh = (kotlin.l.b.a.b.d.a.e.b)kotlin.a.j.f((Iterable)parama.hCD());; paramh = null)
    {
      this.TpQ = paramh;
      this.TpR = false;
      AppMethodBeat.o(57657);
      return;
      paramb = an.ThK;
      p.g(paramb, "SourceElement.NO_SOURCE");
      break;
    }
  }
  
  public Map<kotlin.l.b.a.b.f.f, g<?>> hBO()
  {
    AppMethodBeat.i(57656);
    Map localMap = ae.emptyMap();
    AppMethodBeat.o(57656);
    return localMap;
  }
  
  public final kotlin.l.b.a.b.f.b hBk()
  {
    return this.TiI;
  }
  
  public final boolean hDF()
  {
    return this.TpR;
  }
  
  public final an hzM()
  {
    return this.Tik;
  }
  
  static final class a
    extends q
    implements kotlin.g.a.a<aj>
  {
    a(b paramb, h paramh)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.a.b
 * JD-Core Version:    0.7.0.1
 */