package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.e;

public final class a
  extends t.a.a<a>
{
  public byte Bov;
  public k Bow;
  
  public a(int paramInt, byte paramByte, k paramk)
  {
    super(paramInt);
    this.Bov = paramByte;
    this.Bow = paramk;
  }
  
  private int a(a parama)
  {
    return this.Bow.b(parama.Bow);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof a)) {}
    while (a((a)paramObject) != 0) {
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    return e.hash(new Object[] { Byte.valueOf(this.Bov), this.Bow });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tinker.a.a.a
 * JD-Core Version:    0.7.0.1
 */