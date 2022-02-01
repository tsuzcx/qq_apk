package com.tencent.tinker.a.a;

import java.util.Arrays;

public final class c
  extends s.a.a<c>
{
  public int[] KmC;
  
  public c(int paramInt, int[] paramArrayOfInt)
  {
    super(paramInt);
    this.KmC = paramArrayOfInt;
  }
  
  private int a(c paramc)
  {
    int k = 0;
    int m = this.KmC.length;
    int i = paramc.KmC.length;
    if (m != i)
    {
      i = com.tencent.tinker.a.a.b.c.kJ(m, i);
      return i;
    }
    int j = 0;
    for (;;)
    {
      i = k;
      if (j >= m) {
        break;
      }
      if (this.KmC[j] != paramc.KmC[j]) {
        return com.tencent.tinker.a.a.b.c.kJ(this.KmC[j], paramc.KmC[j]);
      }
      j += 1;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof c)) {}
    while (a((c)paramObject) != 0) {
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(this.KmC);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.a.a.c
 * JD-Core Version:    0.7.0.1
 */