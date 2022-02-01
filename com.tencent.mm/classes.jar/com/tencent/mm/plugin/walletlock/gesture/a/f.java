package com.tencent.mm.plugin.walletlock.gesture.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;

public final class f
{
  private static f[][] ABR;
  public int ABP = 0;
  public int ABQ = 0;
  
  static
  {
    AppMethodBeat.i(129788);
    ABR = (f[][])Array.newInstance(f.class, new int[] { 3, 3 });
    int i = 0;
    while (i < 3)
    {
      int j = 0;
      while (j < 3)
      {
        ABR[i][j] = new f(i, j);
        j += 1;
      }
      i += 1;
    }
    AppMethodBeat.o(129788);
  }
  
  private f(int paramInt1, int paramInt2)
  {
    this.ABP = paramInt1;
    this.ABQ = paramInt2;
  }
  
  public static f ik(int paramInt1, int paramInt2)
  {
    try
    {
      AppMethodBeat.i(129786);
      if ((paramInt1 < 0) || (paramInt1 > 2))
      {
        IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("row id should be in range [0..2]");
        AppMethodBeat.o(129786);
        throw localIllegalArgumentException;
      }
    }
    finally {}
    if ((paramInt2 < 0) || (paramInt2 > 2))
    {
      localObject2 = new IllegalArgumentException("col id should be in range [0..2]");
      AppMethodBeat.o(129786);
      throw ((Throwable)localObject2);
    }
    Object localObject2 = ABR[paramInt1][paramInt2];
    AppMethodBeat.o(129786);
    return localObject2;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(129787);
    String str = String.format("{row: %d, col: %d}", new Object[] { Integer.valueOf(this.ABP), Integer.valueOf(this.ABQ) });
    AppMethodBeat.o(129787);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.a.f
 * JD-Core Version:    0.7.0.1
 */