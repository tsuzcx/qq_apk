package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import java.util.Arrays;

public final class t
  extends s.a.a<t>
{
  public static final t ZJN = new t(0, i.ZIU);
  public short[] ZJO;
  
  public t(int paramInt, short[] paramArrayOfShort)
  {
    super(paramInt);
    this.ZJO = paramArrayOfShort;
  }
  
  private int b(t paramt)
  {
    return c.a(this.ZJO, paramt.ZJO);
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
    return Arrays.hashCode(this.ZJO);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.tinker.a.a.t
 * JD-Core Version:    0.7.0.1
 */