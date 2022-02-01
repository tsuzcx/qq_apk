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
  private final d.l.b.a.b.a.g LeY;
  final b LeZ;
  private final Map<d.l.b.a.b.f.f, d.l.b.a.b.j.b.g<?>> Lfa;
  private final d.f nHL;
  
  static
  {
    AppMethodBeat.i(56957);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bn(j.class), "type", "getType()Lorg/jetbrains/kotlin/types/KotlinType;")) };
    AppMethodBeat.o(56957);
  }
  
  public j(d.l.b.a.b.a.g paramg, b paramb, Map<d.l.b.a.b.f.f, ? extends d.l.b.a.b.j.b.g<?>> paramMap)
  {
    AppMethodBeat.i(56960);
    this.LeY = paramg;
    this.LeZ = paramb;
    this.Lfa = paramMap;
    this.nHL = d.g.a(d.k.KTd, (a)new a(this));
    AppMethodBeat.o(56960);
  }
  
  public final an fQk()
  {
    AppMethodBeat.i(56959);
    an localan = an.Lec;
    d.g.b.k.g(localan, "SourceElement.NO_SOURCE");
    AppMethodBeat.o(56959);
    return localan;
  }
  
  public final b fRH()
  {
    return this.LeZ;
  }
  
  public final ab fRV()
  {
    AppMethodBeat.i(56958);
    ab localab = (ab)this.nHL.getValue();
    AppMethodBeat.o(56958);
    return localab;
  }
  
  public final Map<d.l.b.a.b.f.f, d.l.b.a.b.j.b.g<?>> fSl()
  {
    return this.Lfa;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.b.a.j
 * JD-Core Version:    0.7.0.1
 */