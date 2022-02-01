package d.l.b.a.b.d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.ae;
import d.g.b.p;
import d.g.b.q;
import d.g.b.x;
import d.g.b.z;
import d.l.b.a.b.b.a.c;
import d.l.b.a.b.b.an;
import d.l.b.a.b.d.a.b.i;
import d.l.b.a.b.d.a.c.h;
import d.l.b.a.b.d.a.e.l;
import d.l.b.a.b.j.b.g;
import d.l.b.a.b.m.aj;
import d.l.k;
import java.util.Map;

public class b
  implements c, i
{
  final d.l.b.a.b.f.b MVU;
  private final an MVx;
  private final d.l.b.a.b.l.f Ndc;
  final d.l.b.a.b.d.a.e.b Ndd;
  private final boolean Nde;
  
  static
  {
    AppMethodBeat.i(57654);
    cwV = new k[] { (k)z.a(new x(z.bp(b.class), "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;")) };
    AppMethodBeat.o(57654);
  }
  
  public b(final h paramh, d.l.b.a.b.d.a.e.a parama, d.l.b.a.b.f.b paramb)
  {
    AppMethodBeat.i(57657);
    this.MVU = paramb;
    if (parama != null)
    {
      paramb = (an)paramh.NeI.Nel.a((l)parama);
      this.MVx = paramb;
      this.Ndc = paramh.NeI.MQa.S((d.g.a.a)new a(this, paramh));
      if (parama == null) {
        break label132;
      }
    }
    label132:
    for (paramh = (d.l.b.a.b.d.a.e.b)d.a.j.d((Iterable)parama.gkz());; paramh = null)
    {
      this.Ndd = paramh;
      this.Nde = false;
      AppMethodBeat.o(57657);
      return;
      paramb = an.MUX;
      p.g(paramb, "SourceElement.NO_SOURCE");
      break;
    }
  }
  
  public final an ghI()
  {
    return this.MVx;
  }
  
  public Map<d.l.b.a.b.f.f, g<?>> gjK()
  {
    AppMethodBeat.i(57656);
    Map localMap = ae.emptyMap();
    AppMethodBeat.o(57656);
    return localMap;
  }
  
  public final d.l.b.a.b.f.b gjg()
  {
    return this.MVU;
  }
  
  public final boolean glB()
  {
    return this.Nde;
  }
  
  static final class a
    extends q
    implements d.g.a.a<aj>
  {
    a(b paramb, h paramh)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.d.a.a.b
 * JD-Core Version:    0.7.0.1
 */