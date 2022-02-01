package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import java.util.Arrays;

public final class b
  extends s.a.a<b>
{
  public int[] Mcz;
  
  public b(int paramInt, int[] paramArrayOfInt)
  {
    super(paramInt);
    this.Mcz = paramArrayOfInt;
  }
  
  private int a(b paramb)
  {
    int k = 0;
    int m = this.Mcz.length;
    int i = paramb.Mcz.length;
    if (m != i)
    {
      i = c.kY(m, i);
      return i;
    }
    int j = 0;
    for (;;)
    {
      i = k;
      if (j >= m) {
        break;
      }
      if (this.Mcz[j] != paramb.Mcz[j]) {
        return c.kY(this.Mcz[j], paramb.Mcz[j]);
      }
      j += 1;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof b)) {}
    while (a((b)paramObject) != 0) {
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(this.Mcz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.a.a.b
 * JD-Core Version:    0.7.0.1
 */