package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.e;

public final class a
  extends s.a.a<a>
{
  public byte IAq;
  public k IAr;
  
  public a(int paramInt, byte paramByte, k paramk)
  {
    super(paramInt);
    this.IAq = paramByte;
    this.IAr = paramk;
  }
  
  private int a(a parama)
  {
    return this.IAr.b(parama.IAr);
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
    return e.hash(new Object[] { Byte.valueOf(this.IAq), this.IAr });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.a.a.a
 * JD-Core Version:    0.7.0.1
 */