package com.tencent.tinker.a.a;

import java.util.Arrays;

public final class c
  extends s.a.a<c>
{
  public int[] Mzv;
  
  public c(int paramInt, int[] paramArrayOfInt)
  {
    super(paramInt);
    this.Mzv = paramArrayOfInt;
  }
  
  private int a(c paramc)
  {
    int k = 0;
    int m = this.Mzv.length;
    int i = paramc.Mzv.length;
    if (m != i)
    {
      i = com.tencent.tinker.a.a.b.c.lf(m, i);
      return i;
    }
    int j = 0;
    for (;;)
    {
      i = k;
      if (j >= m) {
        break;
      }
      if (this.Mzv[j] != paramc.Mzv[j]) {
        return com.tencent.tinker.a.a.b.c.lf(this.Mzv[j], paramc.Mzv[j]);
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
    return Arrays.hashCode(this.Mzv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.a.a.c
 * JD-Core Version:    0.7.0.1
 */