package kotlin.l.b.a.b.j.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.m.ab;
import kotlin.z;

public final class b
  extends g<List<? extends g<?>>>
{
  private final kotlin.g.a.b<y, ab> abkW;
  
  public b(List<? extends g<?>> paramList, kotlin.g.a.b<? super y, ? extends ab> paramb)
  {
    super(paramList);
    AppMethodBeat.i(60041);
    this.abkW = paramb;
    AppMethodBeat.o(60041);
  }
  
  public final ab b(y paramy)
  {
    AppMethodBeat.i(60040);
    p.k(paramy, "module");
    paramy = this.abkW.invoke(paramy);
    ab localab = (ab)paramy;
    if ((kotlin.l.b.a.b.a.g.m(localab)) || (kotlin.l.b.a.b.a.g.n(localab))) {}
    for (int i = 1; (z.aazO) && (i == 0); i = 0)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.j.b.b
 * JD-Core Version:    0.7.0.1
 */