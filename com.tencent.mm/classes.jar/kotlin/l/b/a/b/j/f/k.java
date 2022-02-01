package kotlin.l.b.a.b.j.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.g.a.a;
import kotlin.g.b.ab;
import kotlin.g.b.q;
import kotlin.l.b.a.b.b.am;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.l.j;
import kotlin.l.n;

public final class k
  extends i
{
  private final kotlin.l.b.a.b.l.f abmD;
  private final e abmu;
  
  static
  {
    AppMethodBeat.i(60219);
    cMt = new n[] { (n)ab.a(new kotlin.g.b.z(ab.bO(k.class), "functions", "getFunctions()Ljava/util/List;")) };
    AppMethodBeat.o(60219);
  }
  
  public k(j paramj, e parame)
  {
    AppMethodBeat.i(60224);
    this.abmu = parame;
    if (this.abmu.iDN() == kotlin.l.b.a.b.b.f.aaKa) {}
    for (int i = 1; (kotlin.z.aazO) && (i == 0); i = 0)
    {
      paramj = (Throwable)new AssertionError("Class should be an enum: " + this.abmu);
      AppMethodBeat.o(60224);
      throw paramj;
    }
    this.abmD = paramj.av((a)new a(this));
    AppMethodBeat.o(60224);
  }
  
  private final List<am> iPq()
  {
    AppMethodBeat.i(60221);
    List localList = (List)kotlin.l.b.a.b.l.i.a(this.abmD, cMt[0]);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.j.f.k
 * JD-Core Version:    0.7.0.1
 */