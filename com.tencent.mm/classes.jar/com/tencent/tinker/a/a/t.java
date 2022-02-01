package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import java.util.Arrays;

public final class t
  extends s.a.a<t>
{
  public static final t Kof = new t(0, i.Knm);
  public short[] Kog;
  
  public t(int paramInt, short[] paramArrayOfShort)
  {
    super(paramInt);
    this.Kog = paramArrayOfShort;
  }
  
  private int b(t paramt)
  {
    return c.a(this.Kog, paramt.Kog);
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
    return Arrays.hashCode(this.Kog);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.a.a.t
 * JD-Core Version:    0.7.0.1
 */