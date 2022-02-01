package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.b.e;

public final class a
  extends s.a.a<a>
{
  public byte ZIh;
  public k ZIi;
  
  public a(int paramInt, byte paramByte, k paramk)
  {
    super(paramInt);
    this.ZIh = paramByte;
    this.ZIi = paramk;
  }
  
  private int a(a parama)
  {
    int i = this.ZIi.b(parama.ZIi);
    if (i != 0) {
      return i;
    }
    return c.a(this.ZIh, parama.ZIh);
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
    return e.hash(new Object[] { Byte.valueOf(this.ZIh), this.ZIi });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.tinker.a.a.a
 * JD-Core Version:    0.7.0.1
 */