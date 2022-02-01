package kotlin.l.b.a.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum ab
{
  public static final a aiQg;
  final String description;
  
  static
  {
    AppMethodBeat.i(191974);
    aiQh = new ab("IGNORE", 0, "ignore");
    aiQi = new ab("WARN", 1, "warn");
    aiQj = new ab("STRICT", 2, "strict");
    aiQk = new ab[] { aiQh, aiQi, aiQj };
    aiQg = new a((byte)0);
    AppMethodBeat.o(191974);
  }
  
  private ab(String paramString)
  {
    this.description = paramString;
  }
  
  public final boolean eDZ()
  {
    return this == aiQh;
  }
  
  public final boolean krU()
  {
    return this == aiQi;
  }
  
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.ab
 * JD-Core Version:    0.7.0.1
 */