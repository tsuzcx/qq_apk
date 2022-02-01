package d.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"differenceModulo", "", "a", "b", "c", "", "getProgressionLastElement", "start", "end", "step", "mod", "kotlin-stdlib"})
public final class c
{
  private static final long aB(long paramLong1, long paramLong2)
  {
    paramLong1 %= paramLong2;
    if (paramLong1 >= 0L) {
      return paramLong1;
    }
    return paramLong1 + paramLong2;
  }
  
  public static final int aV(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(128993);
    paramInt1 = kH(kH(paramInt1, paramInt3) - kH(paramInt2, paramInt3), paramInt3);
    AppMethodBeat.o(128993);
    return paramInt1;
  }
  
  private static final int kH(int paramInt1, int paramInt2)
  {
    paramInt1 %= paramInt2;
    if (paramInt1 >= 0) {
      return paramInt1;
    }
    return paramInt1 + paramInt2;
  }
  
  public static final long s(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(128994);
    paramLong1 = aB(aB(paramLong1, paramLong3) - aB(paramLong2, paramLong3), paramLong3);
    AppMethodBeat.o(128994);
    return paramLong1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.e.c
 * JD-Core Version:    0.7.0.1
 */