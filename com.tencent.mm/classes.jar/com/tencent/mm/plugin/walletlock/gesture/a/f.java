package com.tencent.mm.plugin.walletlock.gesture.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;

public final class f
{
  private static f[][] uEL;
  public int uEJ = 0;
  public int uEK = 0;
  
  static
  {
    AppMethodBeat.i(51583);
    uEL = (f[][])Array.newInstance(f.class, new int[] { 3, 3 });
    int i = 0;
    while (i < 3)
    {
      int j = 0;
      while (j < 3)
      {
        uEL[i][j] = new f(i, j);
        j += 1;
      }
      i += 1;
    }
    AppMethodBeat.o(51583);
  }
  
  private f(int paramInt1, int paramInt2)
  {
    this.uEJ = paramInt1;
    this.uEK = paramInt2;
  }
  
  public static f gA(int paramInt1, int paramInt2)
  {
    try
    {
      AppMethodBeat.i(51581);
      if ((paramInt1 < 0) || (paramInt1 > 2))
      {
        IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("row id should be in range [0..2]");
        AppMethodBeat.o(51581);
        throw localIllegalArgumentException;
      }
    }
    finally {}
    if ((paramInt2 < 0) || (paramInt2 > 2))
    {
      localObject2 = new IllegalArgumentException("col id should be in range [0..2]");
      AppMethodBeat.o(51581);
      throw ((Throwable)localObject2);
    }
    Object localObject2 = uEL[paramInt1][paramInt2];
    AppMethodBeat.o(51581);
    return localObject2;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(51582);
    String str = String.format("{row: %d, col: %d}", new Object[] { Integer.valueOf(this.uEJ), Integer.valueOf(this.uEK) });
    AppMethodBeat.o(51582);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.a.f
 * JD-Core Version:    0.7.0.1
 */