package kotlin.l.b.a.b.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.bh;
import kotlin.l.b.a.b.b.bh.b;
import kotlin.l.b.a.b.b.bh.g;
import kotlin.l.b.a.b.b.bi;

public final class a$b
  extends bi
{
  public static final b aiMs;
  
  static
  {
    AppMethodBeat.i(191864);
    aiMs = new b();
    AppMethodBeat.o(191864);
  }
  
  private a$b()
  {
    super("protected_and_package", true);
  }
  
  public final Integer c(bi parambi)
  {
    AppMethodBeat.i(191868);
    s.u(parambi, "visibility");
    if (s.p(this, parambi))
    {
      AppMethodBeat.o(191868);
      return Integer.valueOf(0);
    }
    if (parambi == bh.b.aiHD)
    {
      AppMethodBeat.o(191868);
      return null;
    }
    bh localbh = bh.aiHA;
    if (bh.b(parambi))
    {
      AppMethodBeat.o(191868);
      return Integer.valueOf(1);
    }
    AppMethodBeat.o(191868);
    return Integer.valueOf(-1);
  }
  
  public final String koC()
  {
    return "protected/*protected and package*/";
  }
  
  public final bi kpz()
  {
    return (bi)bh.g.aiHI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.d.a.b
 * JD-Core Version:    0.7.0.1
 */