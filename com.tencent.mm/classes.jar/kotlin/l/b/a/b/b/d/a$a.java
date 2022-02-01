package kotlin.l.b.a.b.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.bh;
import kotlin.l.b.a.b.b.bh.g;
import kotlin.l.b.a.b.b.bi;

public final class a$a
  extends bi
{
  public static final a aiMr;
  
  static
  {
    AppMethodBeat.i(191869);
    aiMr = new a();
    AppMethodBeat.o(191869);
  }
  
  private a$a()
  {
    super("package", false);
  }
  
  public final Integer c(bi parambi)
  {
    AppMethodBeat.i(191871);
    s.u(parambi, "visibility");
    if (this == parambi)
    {
      AppMethodBeat.o(191871);
      return Integer.valueOf(0);
    }
    bh localbh = bh.aiHA;
    if (bh.b(parambi))
    {
      AppMethodBeat.o(191871);
      return Integer.valueOf(1);
    }
    AppMethodBeat.o(191871);
    return Integer.valueOf(-1);
  }
  
  public final String koC()
  {
    return "public/*package*/";
  }
  
  public final bi kpz()
  {
    return (bi)bh.g.aiHI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.d.a.a
 * JD-Core Version:    0.7.0.1
 */