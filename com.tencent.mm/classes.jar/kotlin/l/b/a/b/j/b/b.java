package kotlin.l.b.a.b.j.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.ak;
import kotlin.g.b.s;
import kotlin.l.b.a.b.a.h;
import kotlin.l.b.a.b.b.ae;
import kotlin.l.b.a.b.m.ad;

public class b
  extends g<List<? extends g<?>>>
{
  private final kotlin.g.a.b<ae, ad> ajjC;
  
  public b(List<? extends g<?>> paramList, kotlin.g.a.b<? super ae, ? extends ad> paramb)
  {
    super(paramList);
    AppMethodBeat.i(60041);
    this.ajjC = paramb;
    AppMethodBeat.o(60041);
  }
  
  public final ad c(ae paramae)
  {
    AppMethodBeat.i(60040);
    s.u(paramae, "module");
    paramae = this.ajjC.invoke(paramae);
    ad localad = (ad)paramae;
    if ((h.m(localad)) || (h.n(localad)) || (h.q(localad))) {}
    for (int i = 1; (ak.aiuY) && (i == 0); i = 0)
    {
      paramae = (Throwable)new AssertionError("Type should be an array, but was " + localad + ": " + getValue());
      AppMethodBeat.o(60040);
      throw paramae;
    }
    paramae = (ad)paramae;
    AppMethodBeat.o(60040);
    return paramae;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.j.b.b
 * JD-Core Version:    0.7.0.1
 */