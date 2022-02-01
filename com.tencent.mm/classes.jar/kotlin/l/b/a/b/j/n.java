package kotlin.l.b.a.b.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.ad;
import kotlin.l.b.a.b.b.ae;

public final class n
{
  private static final ad<m> ajjt;
  
  static
  {
    AppMethodBeat.i(192203);
    ajjt = new ad("ResolutionAnchorProvider");
    AppMethodBeat.o(192203);
  }
  
  public static final ae b(ae paramae)
  {
    AppMethodBeat.i(192200);
    s.u(paramae, "<this>");
    paramae = (m)paramae.a(ajjt);
    if (paramae == null)
    {
      AppMethodBeat.o(192200);
      return null;
    }
    paramae = paramae.kzl();
    AppMethodBeat.o(192200);
    return paramae;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.j.n
 * JD-Core Version:    0.7.0.1
 */