package kotlin.l.b.a.b.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.n.k;

public final class g
{
  private static final k abfO;
  public static final g abfP;
  
  static
  {
    AppMethodBeat.i(59333);
    abfP = new g();
    abfO = new k("[^\\p{L}\\p{Digit}]");
    AppMethodBeat.o(59333);
  }
  
  public static final String bHf(String paramString)
  {
    AppMethodBeat.i(59332);
    p.k(paramString, "name");
    paramString = abfO.e((CharSequence)paramString, "_");
    AppMethodBeat.o(59332);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.l.b.a.b.f.g
 * JD-Core Version:    0.7.0.1
 */