package kotlin.l.b.a.b.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.n.k;

public final class g
{
  private static final k TDb;
  public static final g TDc;
  
  static
  {
    AppMethodBeat.i(59333);
    TDc = new g();
    TDb = new k("[^\\p{L}\\p{Digit}]");
    AppMethodBeat.o(59333);
  }
  
  public static final String buc(String paramString)
  {
    AppMethodBeat.i(59332);
    p.h(paramString, "name");
    paramString = TDb.e((CharSequence)paramString, "_");
    AppMethodBeat.o(59332);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlin.l.b.a.b.f.g
 * JD-Core Version:    0.7.0.1
 */