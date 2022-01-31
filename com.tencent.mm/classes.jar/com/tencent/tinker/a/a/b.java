package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import java.util.Arrays;

public final class b
  extends t.a.a<b>
{
  public int[] Box;
  
  public b(int paramInt, int[] paramArrayOfInt)
  {
    super(paramInt);
    this.Box = paramArrayOfInt;
  }
  
  private int a(b paramb)
  {
    int k = 0;
    int m = this.Box.length;
    int i = paramb.Box.length;
    if (m != i)
    {
      i = c.ip(m, i);
      return i;
    }
    int j = 0;
    for (;;)
    {
      i = k;
      if (j >= m) {
        break;
      }
      if (this.Box[j] != paramb.Box[j]) {
        return c.ip(this.Box[j], paramb.Box[j]);
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
    return Arrays.hashCode(this.Box);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.a.a.b
 * JD-Core Version:    0.7.0.1
 */