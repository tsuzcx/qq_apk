package d.l.b.a.b.o;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum g
{
  public static final a NFY;
  final String description;
  
  static
  {
    AppMethodBeat.i(61373);
    g localg1 = new g("IGNORE", 0, "ignore");
    NFU = localg1;
    g localg2 = new g("WARN", 1, "warn");
    NFV = localg2;
    g localg3 = new g("STRICT", 2, "strict");
    NFW = localg3;
    NFX = new g[] { localg1, localg2, localg3 };
    NFY = new a((byte)0);
    AppMethodBeat.o(61373);
  }
  
  private g(String paramString)
  {
    this.description = paramString;
  }
  
  public final boolean gup()
  {
    return (g)this == NFV;
  }
  
  public final boolean guq()
  {
    return (g)this == NFU;
  }
  
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.o.g
 * JD-Core Version:    0.7.0.1
 */