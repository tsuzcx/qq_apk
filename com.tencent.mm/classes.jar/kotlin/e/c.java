package kotlin.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"differenceModulo", "", "a", "b", "c", "", "getProgressionLastElement", "start", "end", "step", "mod", "kotlin-stdlib"})
public final class c
{
  private static final long aL(long paramLong1, long paramLong2)
  {
    paramLong1 %= paramLong2;
    if (paramLong1 >= 0L) {
      return paramLong1;
    }
    return paramLong1 + paramLong2;
  }
  
  public static final int bf(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(128993);
    paramInt1 = mW(mW(paramInt1, paramInt3) - mW(paramInt2, paramInt3), paramInt3);
    AppMethodBeat.o(128993);
    return paramInt1;
  }
  
  private static final int mW(int paramInt1, int paramInt2)
  {
    paramInt1 %= paramInt2;
    if (paramInt1 >= 0) {
      return paramInt1;
    }
    return paramInt1 + paramInt2;
  }
  
  public static final long t(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(128994);
    paramLong1 = aL(aL(paramLong1, paramLong3) - aL(paramLong2, paramLong3), paramLong3);
    AppMethodBeat.o(128994);
    return paramLong1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.e.c
 * JD-Core Version:    0.7.0.1
 */