package kotlin.l.b.a.b.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.s;
import kotlin.n.k;

public final class g
{
  public static final g ajeH;
  private static final k ajeI;
  
  static
  {
    AppMethodBeat.i(59333);
    ajeH = new g();
    ajeI = new k("[^\\p{L}\\p{Digit}]");
    AppMethodBeat.o(59333);
  }
  
  public static final String bJi(String paramString)
  {
    AppMethodBeat.i(59332);
    s.u(paramString, "name");
    paramString = ajeI.e((CharSequence)paramString, "_");
    AppMethodBeat.o(59332);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.l.b.a.b.f.g
 * JD-Core Version:    0.7.0.1
 */