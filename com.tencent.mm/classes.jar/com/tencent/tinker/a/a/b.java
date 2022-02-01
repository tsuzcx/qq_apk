package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import java.util.Arrays;

public final class b
  extends s.a.a<b>
{
  public int[] Sfy;
  
  public b(int paramInt, int[] paramArrayOfInt)
  {
    super(paramInt);
    this.Sfy = paramArrayOfInt;
  }
  
  private int a(b paramb)
  {
    int k = 0;
    int m = this.Sfy.length;
    int i = paramb.Sfy.length;
    if (m != i)
    {
      i = c.mD(m, i);
      return i;
    }
    int j = 0;
    for (;;)
    {
      i = k;
      if (j >= m) {
        break;
      }
      if (this.Sfy[j] != paramb.Sfy[j]) {
        return c.mD(this.Sfy[j], paramb.Sfy[j]);
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
    return Arrays.hashCode(this.Sfy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tinker.a.a.b
 * JD-Core Version:    0.7.0.1
 */