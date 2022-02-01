package d.l.b.a.b.j.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.ac;
import d.g.a.a;
import d.g.b.q;
import d.g.b.x;
import d.g.b.z;
import d.l.b.a.b.b.am;
import d.l.b.a.b.b.e;
import d.l.b.a.b.l.j;
import java.util.List;

public final class k
  extends i
{
  private final e NUW;
  private final d.l.b.a.b.l.f NVf;
  
  static
  {
    AppMethodBeat.i(60219);
    cxA = new d.l.k[] { (d.l.k)z.a(new x(z.bp(k.class), "functions", "getFunctions()Ljava/util/List;")) };
    AppMethodBeat.o(60219);
  }
  
  public k(j paramj, e parame)
  {
    AppMethodBeat.i(60224);
    this.NUW = parame;
    if (this.NUW.glY() == d.l.b.a.b.b.f.Nry) {}
    for (int i = 1; (ac.Nhs) && (i == 0); i = 0)
    {
      paramj = (Throwable)new AssertionError("Class should be an enum: " + this.NUW);
      AppMethodBeat.o(60224);
      throw paramj;
    }
    this.NVf = paramj.S((a)new a(this));
    AppMethodBeat.o(60224);
  }
  
  private final List<am> gxX()
  {
    AppMethodBeat.i(60221);
    List localList = (List)d.l.b.a.b.l.i.a(this.NVf, cxA[0]);
    AppMethodBeat.o(60221);
    return localList;
  }
  
  static final class a
    extends q
    implements a<List<? extends am>>
  {
    a(k paramk)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.j.f.k
 * JD-Core Version:    0.7.0.1
 */