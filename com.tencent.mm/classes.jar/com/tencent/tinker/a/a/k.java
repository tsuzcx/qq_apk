package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.a;
import com.tencent.tinker.a.a.b.c;
import java.util.Arrays;

public final class k
  extends s.a.a<k>
{
  public byte[] data;
  
  public k(int paramInt, byte[] paramArrayOfByte)
  {
    super(paramInt);
    this.data = paramArrayOfByte;
  }
  
  public final int b(k paramk)
  {
    return c.r(this.data, paramk.data);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof k)) {}
    while (b((k)paramObject) != 0) {
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(this.data);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.tinker.a.a.k
 * JD-Core Version:    0.7.0.1
 */