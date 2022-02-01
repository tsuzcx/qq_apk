package d.l.b.a.b.j.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.aa;
import d.g.b.k;
import d.l.b.a.b.b.y;
import d.l.b.a.b.m.ab;
import java.util.List;

public final class b
  extends g<List<? extends g<?>>>
{
  private final d.g.a.b<y, ab> JRZ;
  
  public b(List<? extends g<?>> paramList, d.g.a.b<? super y, ? extends ab> paramb)
  {
    super(paramList);
    AppMethodBeat.i(60041);
    this.JRZ = paramb;
    AppMethodBeat.o(60041);
  }
  
  public final ab b(y paramy)
  {
    AppMethodBeat.i(60040);
    k.h(paramy, "module");
    paramy = this.JRZ.aA(paramy);
    ab localab = (ab)paramy;
    if ((d.l.b.a.b.a.g.m(localab)) || (d.l.b.a.b.a.g.n(localab))) {}
    for (int i = 1; (aa.JfW) && (i == 0); i = 0)
    {
      paramy = (Throwable)new AssertionError("Type should be an array, but was " + localab + ": " + (List)getValue());
      AppMethodBeat.o(60040);
      throw paramy;
    }
    paramy = (ab)paramy;
    AppMethodBeat.o(60040);
    return paramy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.j.b.b
 * JD-Core Version:    0.7.0.1
 */