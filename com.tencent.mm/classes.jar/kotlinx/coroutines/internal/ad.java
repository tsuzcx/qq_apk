package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.n.n;

@Metadata(d1={"kotlinx/coroutines/internal/SystemPropsKt__SystemPropsKt", "kotlinx/coroutines/internal/SystemPropsKt__SystemProps_commonKt"}, k=4, mv={1, 5, 1}, xi=48)
public final class ad
{
  public static final long f(String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    int j = 0;
    AppMethodBeat.i(118123);
    String str = ae.bJL(paramString);
    if (str == null)
    {
      AppMethodBeat.o(118123);
      return paramLong1;
    }
    Long localLong = n.bJH(str);
    if (localLong == null)
    {
      paramString = (Throwable)new IllegalStateException(("System property '" + paramString + "' has unrecognized value '" + str + '\'').toString());
      AppMethodBeat.o(118123);
      throw paramString;
    }
    paramLong1 = localLong.longValue();
    int i = j;
    if (paramLong2 <= paramLong1)
    {
      i = j;
      if (paramLong1 <= paramLong3) {
        i = 1;
      }
    }
    if (i == 0)
    {
      paramString = (Throwable)new IllegalStateException(("System property '" + paramString + "' should be in range " + paramLong2 + ".." + paramLong3 + ", but is '" + paramLong1 + '\'').toString());
      AppMethodBeat.o(118123);
      throw paramString;
    }
    AppMethodBeat.o(118123);
    return paramLong1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.internal.ad
 * JD-Core Version:    0.7.0.1
 */