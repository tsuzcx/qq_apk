package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.m;
import kotlin.t;

public final class y
{
  public static final boolean al(ab paramab)
  {
    AppMethodBeat.i(60747);
    p.h(paramab, "$this$isFlexible");
    boolean bool = paramab.hLF() instanceof v;
    AppMethodBeat.o(60747);
    return bool;
  }
  
  public static final v am(ab paramab)
  {
    AppMethodBeat.i(60748);
    p.h(paramab, "$this$asFlexibleType");
    paramab = paramab.hLF();
    if (paramab == null)
    {
      paramab = new t("null cannot be cast to non-null type org.jetbrains.kotlin.types.FlexibleType");
      AppMethodBeat.o(60748);
      throw paramab;
    }
    paramab = (v)paramab;
    AppMethodBeat.o(60748);
    return paramab;
  }
  
  public static final aj an(ab paramab)
  {
    AppMethodBeat.i(60749);
    p.h(paramab, "$this$lowerIfFlexible");
    paramab = paramab.hLF();
    if ((paramab instanceof v))
    {
      paramab = ((v)paramab).TNV;
      AppMethodBeat.o(60749);
      return paramab;
    }
    if ((paramab instanceof aj))
    {
      paramab = (aj)paramab;
      AppMethodBeat.o(60749);
      return paramab;
    }
    paramab = new m();
    AppMethodBeat.o(60749);
    throw paramab;
  }
  
  public static final aj ao(ab paramab)
  {
    AppMethodBeat.i(60750);
    p.h(paramab, "$this$upperIfFlexible");
    paramab = paramab.hLF();
    if ((paramab instanceof v))
    {
      paramab = ((v)paramab).TNW;
      AppMethodBeat.o(60750);
      return paramab;
    }
    if ((paramab instanceof aj))
    {
      paramab = (aj)paramab;
      AppMethodBeat.o(60750);
      return paramab;
    }
    paramab = new m();
    AppMethodBeat.o(60750);
    throw paramab;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.m.y
 * JD-Core Version:    0.7.0.1
 */