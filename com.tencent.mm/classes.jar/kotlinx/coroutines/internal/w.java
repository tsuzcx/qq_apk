package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={"kotlinx/coroutines/internal/SystemPropsKt__SystemPropsKt", "kotlinx/coroutines/internal/SystemPropsKt__SystemProps_commonKt"})
public final class w
{
  public static final long e(String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(118123);
    String str = x.bHF(paramString);
    if (str == null)
    {
      AppMethodBeat.o(118123);
      return paramLong1;
    }
    Long localLong = n.bHD(str);
    if (localLong != null)
    {
      paramLong1 = localLong.longValue();
      if ((paramLong2 > paramLong1) || (paramLong3 < paramLong1))
      {
        paramString = (Throwable)new IllegalStateException(("System property '" + paramString + "' should be in range " + paramLong2 + ".." + paramLong3 + ", but is '" + paramLong1 + '\'').toString());
        AppMethodBeat.o(118123);
        throw paramString;
      }
    }
    else
    {
      paramString = (Throwable)new IllegalStateException(("System property '" + paramString + "' has unrecognized value '" + str + '\'').toString());
      AppMethodBeat.o(118123);
      throw paramString;
    }
    AppMethodBeat.o(118123);
    return paramLong1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.internal.w
 * JD-Core Version:    0.7.0.1
 */