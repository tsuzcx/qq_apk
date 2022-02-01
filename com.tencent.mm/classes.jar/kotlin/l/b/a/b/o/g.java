package kotlin.l.b.a.b.o;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum g
{
  public static final a TRY;
  final String description;
  
  static
  {
    AppMethodBeat.i(61373);
    g localg1 = new g("IGNORE", 0, "ignore");
    TRU = localg1;
    g localg2 = new g("WARN", 1, "warn");
    TRV = localg2;
    g localg3 = new g("STRICT", 2, "strict");
    TRW = localg3;
    TRX = new g[] { localg1, localg2, localg3 };
    TRY = new a((byte)0);
    AppMethodBeat.o(61373);
  }
  
  private g(String paramString)
  {
    this.description = paramString;
  }
  
  public final boolean hLU()
  {
    return (g)this == TRV;
  }
  
  public final boolean hLV()
  {
    return (g)this == TRU;
  }
  
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.o.g
 * JD-Core Version:    0.7.0.1
 */