package com.tencent.mm.plugin.walletlock.gesture.a;

import java.lang.reflect.Array;

public final class f
{
  private static f[][] qPD = (f[][])Array.newInstance(f.class, new int[] { 3, 3 });
  public int qPB = 0;
  public int qPC = 0;
  
  static
  {
    int i = 0;
    while (i < 3)
    {
      int j = 0;
      while (j < 3)
      {
        qPD[i][j] = new f(i, j);
        j += 1;
      }
      i += 1;
    }
  }
  
  private f(int paramInt1, int paramInt2)
  {
    this.qPB = paramInt1;
    this.qPC = paramInt2;
  }
  
  public static f ew(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 > 2)) {
      try
      {
        throw new IllegalArgumentException("row id should be in range [0..2]");
      }
      finally {}
    }
    if ((paramInt2 < 0) || (paramInt2 > 2)) {
      throw new IllegalArgumentException("col id should be in range [0..2]");
    }
    f localf = qPD[paramInt1][paramInt2];
    return localf;
  }
  
  public final String toString()
  {
    return String.format("{row: %d, col: %d}", new Object[] { Integer.valueOf(this.qPB), Integer.valueOf(this.qPC) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.a.f
 * JD-Core Version:    0.7.0.1
 */