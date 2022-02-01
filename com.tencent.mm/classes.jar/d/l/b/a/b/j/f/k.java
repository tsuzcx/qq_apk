package d.l.b.a.b.j.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.aa;
import d.g.a.a;
import d.g.b.l;
import d.g.b.u;
import d.g.b.w;
import d.l.b.a.b.b.am;
import d.l.b.a.b.b.e;
import d.l.b.a.b.l.h;
import java.util.List;

public final class k
  extends i
{
  private final d.l.b.a.b.l.f JTH;
  private final e JTy;
  
  static
  {
    AppMethodBeat.i(60219);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(k.class), "functions", "getFunctions()Ljava/util/List;")) };
    AppMethodBeat.o(60219);
  }
  
  public k(d.l.b.a.b.l.i parami, e parame)
  {
    AppMethodBeat.i(60224);
    this.JTy = parame;
    if (this.JTy.fxu() == d.l.b.a.b.b.f.Jqf) {}
    for (int i = 1; (aa.JfW) && (i == 0); i = 0)
    {
      parami = (Throwable)new AssertionError("Class should be an enum: " + this.JTy);
      AppMethodBeat.o(60224);
      throw parami;
    }
    this.JTH = parami.H((a)new a(this));
    AppMethodBeat.o(60224);
  }
  
  private final List<am> fJt()
  {
    AppMethodBeat.i(60221);
    List localList = (List)h.a(this.JTH, $$delegatedProperties[0]);
    AppMethodBeat.o(60221);
    return localList;
  }
  
  static final class a
    extends l
    implements a<List<? extends am>>
  {
    a(k paramk)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.j.f.k
 * JD-Core Version:    0.7.0.1
 */