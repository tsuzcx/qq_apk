package kotlin.l.b.a.b.j.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.g.a.a;
import kotlin.g.b.q;
import kotlin.g.b.y;
import kotlin.l.b.a.b.b.am;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.l.j;

public final class k
  extends i
{
  private final e TJS;
  private final kotlin.l.b.a.b.l.f TKb;
  
  static
  {
    AppMethodBeat.i(60219);
    cLI = new kotlin.l.k[] { (kotlin.l.k)kotlin.g.b.aa.a(new y(kotlin.g.b.aa.bp(k.class), "functions", "getFunctions()Ljava/util/List;")) };
    AppMethodBeat.o(60219);
  }
  
  public k(j paramj, e parame)
  {
    AppMethodBeat.i(60224);
    this.TJS = parame;
    if (this.TJS.hzB() == kotlin.l.b.a.b.b.f.Thg) {}
    for (int i = 1; (kotlin.aa.SXc) && (i == 0); i = 0)
    {
      paramj = (Throwable)new AssertionError("Class should be an enum: " + this.TJS);
      AppMethodBeat.o(60224);
      throw paramj;
    }
    this.TKb = paramj.al((a)new a(this));
    AppMethodBeat.o(60224);
  }
  
  private final List<am> hLa()
  {
    AppMethodBeat.i(60221);
    List localList = (List)kotlin.l.b.a.b.l.i.a(this.TKb, cLI[0]);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.j.f.k
 * JD-Core Version:    0.7.0.1
 */