package kotlin.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"differenceModulo", "", "a", "b", "c", "", "getProgressionLastElement", "start", "end", "step", "mod", "kotlin-stdlib"}, k=2, mv={1, 5, 1})
public final class c
{
  public static final long A(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(190899);
    if (paramLong3 > 0L)
    {
      if (paramLong1 >= paramLong2)
      {
        AppMethodBeat.o(190899);
        return paramLong2;
      }
      paramLong1 = z(paramLong2, paramLong1, paramLong3);
      AppMethodBeat.o(190899);
      return paramLong2 - paramLong1;
    }
    if (paramLong3 < 0L)
    {
      if (paramLong1 <= paramLong2)
      {
        AppMethodBeat.o(190899);
        return paramLong2;
      }
      paramLong1 = z(paramLong1, paramLong2, -paramLong3);
      AppMethodBeat.o(190899);
      return paramLong2 + paramLong1;
    }
    Throwable localThrowable = (Throwable)new IllegalArgumentException("Step is zero.");
    AppMethodBeat.o(190899);
    throw localThrowable;
  }
  
  private static final int bN(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(128993);
    paramInt1 = qp(qp(paramInt1, paramInt3) - qp(paramInt2, paramInt3), paramInt3);
    AppMethodBeat.o(128993);
    return paramInt1;
  }
  
  public static final int bO(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(190896);
    if (paramInt3 > 0)
    {
      if (paramInt1 >= paramInt2)
      {
        AppMethodBeat.o(190896);
        return paramInt2;
      }
      paramInt1 = bN(paramInt2, paramInt1, paramInt3);
      AppMethodBeat.o(190896);
      return paramInt2 - paramInt1;
    }
    if (paramInt3 < 0)
    {
      if (paramInt1 <= paramInt2)
      {
        AppMethodBeat.o(190896);
        return paramInt2;
      }
      paramInt1 = bN(paramInt1, paramInt2, -paramInt3);
      AppMethodBeat.o(190896);
      return paramInt2 + paramInt1;
    }
    Throwable localThrowable = (Throwable)new IllegalArgumentException("Step is zero.");
    AppMethodBeat.o(190896);
    throw localThrowable;
  }
  
  private static final long bQ(long paramLong1, long paramLong2)
  {
    paramLong1 %= paramLong2;
    if (paramLong1 >= 0L) {
      return paramLong1;
    }
    return paramLong1 + paramLong2;
  }
  
  private static final int qp(int paramInt1, int paramInt2)
  {
    paramInt1 %= paramInt2;
    if (paramInt1 >= 0) {
      return paramInt1;
    }
    return paramInt1 + paramInt2;
  }
  
  private static final long z(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(128994);
    paramLong1 = bQ(bQ(paramLong1, paramLong3) - bQ(paramLong2, paramLong3), paramLong3);
    AppMethodBeat.o(128994);
    return paramLong1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlin.e.c
 * JD-Core Version:    0.7.0.1
 */