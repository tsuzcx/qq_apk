package com.tencent.tinker.a.a;

import java.util.Arrays;

public final class c
  extends s.a.a<c>
{
  public int[] ahNn;
  
  public c(int paramInt, int[] paramArrayOfInt)
  {
    super(paramInt);
    this.ahNn = paramArrayOfInt;
  }
  
  private int a(c paramc)
  {
    int k = 0;
    int m = this.ahNn.length;
    int i = paramc.ahNn.length;
    if (m != i)
    {
      i = com.tencent.tinker.a.a.b.c.pR(m, i);
      return i;
    }
    int j = 0;
    for (;;)
    {
      i = k;
      if (j >= m) {
        break;
      }
      if (this.ahNn[j] != paramc.ahNn[j]) {
        return com.tencent.tinker.a.a.b.c.pR(this.ahNn[j], paramc.ahNn[j]);
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
    return Arrays.hashCode(this.ahNn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.tinker.a.a.c
 * JD-Core Version:    0.7.0.1
 */