package d.l.b.a.b.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.n.k;

public final class g
{
  private static final k NNw;
  public static final g NNx;
  
  static
  {
    AppMethodBeat.i(59333);
    NNx = new g();
    NNw = new k("[^\\p{L}\\p{Digit}]");
    AppMethodBeat.o(59333);
  }
  
  public static final String bem(String paramString)
  {
    AppMethodBeat.i(59332);
    p.h(paramString, "name");
    paramString = NNw.e((CharSequence)paramString, "_");
    AppMethodBeat.o(59332);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.f.g
 * JD-Core Version:    0.7.0.1
 */