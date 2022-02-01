package d.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.m;

public final class y
{
  public static final boolean am(ab paramab)
  {
    AppMethodBeat.i(60747);
    p.h(paramab, "$this$isFlexible");
    boolean bool = paramab.gua() instanceof v;
    AppMethodBeat.o(60747);
    return bool;
  }
  
  public static final v an(ab paramab)
  {
    AppMethodBeat.i(60748);
    p.h(paramab, "$this$asFlexibleType");
    paramab = paramab.gua();
    if (paramab == null)
    {
      paramab = new d.v("null cannot be cast to non-null type org.jetbrains.kotlin.types.FlexibleType");
      AppMethodBeat.o(60748);
      throw paramab;
    }
    paramab = (v)paramab;
    AppMethodBeat.o(60748);
    return paramab;
  }
  
  public static final aj ao(ab paramab)
  {
    AppMethodBeat.i(60749);
    p.h(paramab, "$this$lowerIfFlexible");
    paramab = paramab.gua();
    if ((paramab instanceof v))
    {
      paramab = ((v)paramab).NBV;
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
  
  public static final aj ap(ab paramab)
  {
    AppMethodBeat.i(60750);
    p.h(paramab, "$this$upperIfFlexible");
    paramab = paramab.gua();
    if ((paramab instanceof v))
    {
      paramab = ((v)paramab).NBW;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.m.y
 * JD-Core Version:    0.7.0.1
 */