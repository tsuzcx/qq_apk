package com.tencent.mm.plugin.sns.model;

import android.os.Looper;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ah;

public final class ab
{
  public static boolean lER;
  public static char[] orc;
  private ah handler = new ab.1(this, Looper.getMainLooper());
  public boolean oqZ = false;
  public long ora = 0L;
  private int orb = 0;
  
  static
  {
    int i = 0;
    lER = false;
    orc = new char[36];
    int j = 48;
    while (j <= 57)
    {
      orc[i] = ((char)j);
      j += 1;
      i += 1;
    }
    j = 97;
    while (j <= 122)
    {
      orc[i] = ((char)j);
      j += 1;
      i += 1;
    }
  }
  
  public static void b(PInt paramPInt1, PInt paramPInt2)
  {
    if (paramPInt2.value + 1 >= 36)
    {
      paramPInt2.value = 0;
      paramPInt1.value = ((paramPInt1.value + 1) % 36);
      return;
    }
    paramPInt2.value = ((paramPInt2.value + 1) % 36);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ab
 * JD-Core Version:    0.7.0.1
 */