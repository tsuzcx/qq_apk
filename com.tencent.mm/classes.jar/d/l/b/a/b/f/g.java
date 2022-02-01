package d.l.b.a.b.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
{
  private static final d.n.k Lzt;
  public static final g Lzu;
  
  static
  {
    AppMethodBeat.i(59333);
    Lzu = new g();
    Lzt = new d.n.k("[^\\p{L}\\p{Digit}]");
    AppMethodBeat.o(59333);
  }
  
  public static final String aWF(String paramString)
  {
    AppMethodBeat.i(59332);
    d.g.b.k.h(paramString, "name");
    paramString = Lzt.d((CharSequence)paramString, "_");
    AppMethodBeat.o(59332);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.f.g
 * JD-Core Version:    0.7.0.1
 */