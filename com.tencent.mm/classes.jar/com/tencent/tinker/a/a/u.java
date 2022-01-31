package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import java.util.Arrays;

public final class u
  extends t.a.a<u>
{
  public static final u Bqb = new u(0, i.Bpi);
  public short[] Bqc;
  
  public u(int paramInt, short[] paramArrayOfShort)
  {
    super(paramInt);
    this.Bqc = paramArrayOfShort;
  }
  
  private int b(u paramu)
  {
    return c.a(this.Bqc, paramu.Bqc);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof u)) {}
    while (b((u)paramObject) != 0) {
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(this.Bqc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tinker.a.a.u
 * JD-Core Version:    0.7.0.1
 */