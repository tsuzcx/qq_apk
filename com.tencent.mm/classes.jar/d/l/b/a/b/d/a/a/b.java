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
  final d.l.b.a.b.f.b JrG;
  private final an Jrj;
  private final d.l.b.a.b.l.f JyM;
  final d.l.b.a.b.d.a.e.b JyN;
  private final boolean JyO;
  
  static
  {
    AppMethodBeat.i(57654);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(b.class), "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;")) };
    AppMethodBeat.o(57654);
  }
  
  public b(final h paramh, d.l.b.a.b.d.a.e.a parama, d.l.b.a.b.f.b paramb)
  {
    AppMethodBeat.i(57657);
    this.JrG = paramb;
    if (parama != null)
    {
      paramb = (an)paramh.JAs.JzV.a((d.l.b.a.b.d.a.e.l)parama);
      this.Jrj = paramb;
      this.JyM = paramh.JAs.JlL.H((d.g.a.a)new a(this, paramh));
      if (parama == null) {
        break label132;
      }
    }
    label132:
    for (paramh = (d.l.b.a.b.d.a.e.b)j.d((Iterable)parama.fAw());; paramh = null)
    {
      this.JyN = paramh;
      this.JyO = false;
      AppMethodBeat.o(57657);
      return;
      paramb = an.JqJ;
      d.g.b.k.g(paramb, "SourceElement.NO_SOURCE");
      break;
    }
  }
  
  public final boolean fBy()
  {
    return this.JyO;
  }
  
  public final an fxG()
  {
    return this.Jrj;
  }
  
  public Map<d.l.b.a.b.f.f, g<?>> fzH()
  {
    AppMethodBeat.i(57656);
    Map localMap = ae.emptyMap();
    AppMethodBeat.o(57656);
    return localMap;
  }
  
  public final d.l.b.a.b.f.b fzd()
  {
    return this.JrG;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.d.a.a.b
 * JD-Core Version:    0.7.0.1
 */