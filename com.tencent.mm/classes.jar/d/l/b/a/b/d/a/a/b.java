package d.l.b.a.b.d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.ae;
import d.a.j;
import d.g.b.u;
import d.g.b.w;
import d.l.b.a.b.b.a.c;
import d.l.b.a.b.b.an;
import d.l.b.a.b.d.a.c.h;
import d.l.b.a.b.j.b.g;
import d.l.b.a.b.m.aj;
import java.util.Map;

public class b
  implements c, d.l.b.a.b.d.a.b.i
{
  private final an LeC;
  final d.l.b.a.b.f.b LeZ;
  private final d.l.b.a.b.l.f Lmf;
  final d.l.b.a.b.d.a.e.b Lmg;
  private final boolean Lmh;
  
  static
  {
    AppMethodBeat.i(57654);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bn(b.class), "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;")) };
    AppMethodBeat.o(57654);
  }
  
  public b(final h paramh, d.l.b.a.b.d.a.e.a parama, d.l.b.a.b.f.b paramb)
  {
    AppMethodBeat.i(57657);
    this.LeZ = paramb;
    if (parama != null)
    {
      paramb = (an)paramh.LnL.Lno.a((d.l.b.a.b.d.a.e.l)parama);
      this.LeC = paramb;
      this.Lmf = paramh.LnL.KZf.O((d.g.a.a)new a(this, paramh));
      if (parama == null) {
        break label132;
      }
    }
    label132:
    for (paramh = (d.l.b.a.b.d.a.e.b)j.d((Iterable)parama.fTa());; paramh = null)
    {
      this.Lmg = paramh;
      this.Lmh = false;
      AppMethodBeat.o(57657);
      return;
      paramb = an.Lec;
      d.g.b.k.g(paramb, "SourceElement.NO_SOURCE");
      break;
    }
  }
  
  public final an fQk()
  {
    return this.LeC;
  }
  
  public final d.l.b.a.b.f.b fRH()
  {
    return this.LeZ;
  }
  
  public Map<d.l.b.a.b.f.f, g<?>> fSl()
  {
    AppMethodBeat.i(57656);
    Map localMap = ae.emptyMap();
    AppMethodBeat.o(57656);
    return localMap;
  }
  
  public final boolean fUc()
  {
    return this.Lmh;
  }
  
  static final class a
    extends d.g.b.l
    implements d.g.a.a<aj>
  {
    a(b paramb, h paramh)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.d.a.a.b
 * JD-Core Version:    0.7.0.1
 */