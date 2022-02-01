package kotlin.l.b.a.b.o;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum g
{
  public static final a abux;
  final String description;
  
  static
  {
    AppMethodBeat.i(61373);
    g localg1 = new g("IGNORE", 0, "ignore");
    abut = localg1;
    g localg2 = new g("WARN", 1, "warn");
    abuu = localg2;
    g localg3 = new g("STRICT", 2, "strict");
    abuv = localg3;
    abuw = new g[] { localg1, localg2, localg3 };
    abux = new a((byte)0);
    AppMethodBeat.o(61373);
  }
  
  private g(String paramString)
  {
    this.description = paramString;
  }
  
  public final boolean dLi()
  {
    return (g)this == abut;
  }
  
  public final boolean iQm()
  {
    return (g)this == abuu;
  }
  
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.o.g
 * JD-Core Version:    0.7.0.1
 */