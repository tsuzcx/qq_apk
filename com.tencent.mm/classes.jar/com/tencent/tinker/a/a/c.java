package com.tencent.tinker.a.a;

import java.util.Arrays;

public final class c
  extends t.a.a<c>
{
  public int[] Boy;
  
  public c(int paramInt, int[] paramArrayOfInt)
  {
    super(paramInt);
    this.Boy = paramArrayOfInt;
  }
  
  private int a(c paramc)
  {
    int k = 0;
    int m = this.Boy.length;
    int i = paramc.Boy.length;
    if (m != i)
    {
      i = com.tencent.tinker.a.a.b.c.ip(m, i);
      return i;
    }
    int j = 0;
    for (;;)
    {
      i = k;
      if (j >= m) {
        break;
      }
      if (this.Boy[j] != paramc.Boy[j]) {
        return com.tencent.tinker.a.a.b.c.ip(this.Boy[j], paramc.Boy[j]);
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
    return Arrays.hashCode(this.Boy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tinker.a.a.c
 * JD-Core Version:    0.7.0.1
 */