package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import java.util.Arrays;

public final class t
  extends s.a.a<t>
{
  public static final t MBa = new t(0, i.MAf);
  public short[] MBb;
  
  public t(int paramInt, short[] paramArrayOfShort)
  {
    super(paramInt);
    this.MBb = paramArrayOfShort;
  }
  
  private int b(t paramt)
  {
    return c.a(this.MBb, paramt.MBb);
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
    return Arrays.hashCode(this.MBb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.a.a.t
 * JD-Core Version:    0.7.0.1
 */