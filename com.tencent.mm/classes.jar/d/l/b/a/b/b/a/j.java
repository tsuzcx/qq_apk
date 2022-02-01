package d.l.b.a.b.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import d.g.b.l;
import d.g.b.u;
import d.g.b.w;
import d.l.b.a.b.b.an;
import d.l.b.a.b.f.b;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.aj;
import java.util.Map;

public final class j
  implements c
{
  private final d.l.b.a.b.a.g JrF;
  final b JrG;
  private final Map<d.l.b.a.b.f.f, d.l.b.a.b.j.b.g<?>> JrH;
  private final d.f neY;
  
  static
  {
    AppMethodBeat.i(56957);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(j.class), "type", "getType()Lorg/jetbrains/kotlin/types/KotlinType;")) };
    AppMethodBeat.o(56957);
  }
  
  public j(d.l.b.a.b.a.g paramg, b paramb, Map<d.l.b.a.b.f.f, ? extends d.l.b.a.b.j.b.g<?>> paramMap)
  {
    AppMethodBeat.i(56960);
    this.JrF = paramg;
    this.JrG = paramb;
    this.JrH = paramMap;
    this.neY = d.g.a(d.k.JfJ, (a)new a(this));
    AppMethodBeat.o(56960);
  }
  
  public final an fxG()
  {
    AppMethodBeat.i(56959);
    an localan = an.JqJ;
    d.g.b.k.g(localan, "SourceElement.NO_SOURCE");
    AppMethodBeat.o(56959);
    return localan;
  }
  
  public final Map<d.l.b.a.b.f.f, d.l.b.a.b.j.b.g<?>> fzH()
  {
    return this.JrH;
  }
  
  public final b fzd()
  {
    return this.JrG;
  }
  
  public final ab fzr()
  {
    AppMethodBeat.i(56958);
    ab localab = (ab)this.neY.getValue();
    AppMethodBeat.o(56958);
    return localab;
  }
  
  static final class a
    extends l
    implements a<aj>
  {
    a(j paramj)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.b.a.j
 * JD-Core Version:    0.7.0.1
 */