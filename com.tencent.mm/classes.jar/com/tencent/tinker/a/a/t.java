package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import java.util.Arrays;

public final class t
  extends s.a.a<t>
{
  public static final t ahOP = new t(0, i.ahNW);
  public short[] ahOQ;
  
  public t(int paramInt, short[] paramArrayOfShort)
  {
    super(paramInt);
    this.ahOQ = paramArrayOfShort;
  }
  
  private int b(t paramt)
  {
    return c.b(this.ahOQ, paramt.ahOQ);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof t)) {}
    while (b((t)paramObject) != 0) {
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(this.ahOQ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.tinker.a.a.t
 * JD-Core Version:    0.7.0.1
 */