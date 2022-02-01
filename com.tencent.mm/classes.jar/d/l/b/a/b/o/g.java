package d.l.b.a.b.o;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum g
{
  public static final a LPd;
  final String description;
  
  static
  {
    AppMethodBeat.i(61373);
    g localg1 = new g("IGNORE", 0, "ignore");
    LOZ = localg1;
    g localg2 = new g("WARN", 1, "warn");
    LPa = localg2;
    g localg3 = new g("STRICT", 2, "strict");
    LPb = localg3;
    LPc = new g[] { localg1, localg2, localg3 };
    LPd = new a((byte)0);
    AppMethodBeat.o(61373);
  }
  
  private g(String paramString)
  {
    this.description = paramString;
  }
  
  public final boolean gcO()
  {
    return (g)this == LPa;
  }
  
  public final boolean gcP()
  {
    return (g)this == LOZ;
  }
  
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.o.g
 * JD-Core Version:    0.7.0.1
 */