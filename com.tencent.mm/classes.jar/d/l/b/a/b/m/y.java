package d.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.m;

public final class y
{
  public static final boolean am(ab paramab)
  {
    AppMethodBeat.i(60747);
    k.h(paramab, "$this$isFlexible");
    boolean bool = paramab.fJW() instanceof v;
    AppMethodBeat.o(60747);
    return bool;
  }
  
  public static final v an(ab paramab)
  {
    AppMethodBeat.i(60748);
    k.h(paramab, "$this$asFlexibleType");
    paramab = paramab.fJW();
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
    k.h(paramab, "$this$lowerIfFlexible");
    paramab = paramab.fJW();
    if ((paramab instanceof v))
    {
      paramab = ((v)paramab).JXH;
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
    k.h(paramab, "$this$upperIfFlexible");
    paramab = paramab.fJW();
    if ((paramab instanceof v))
    {
      paramab = ((v)paramab).JXI;
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