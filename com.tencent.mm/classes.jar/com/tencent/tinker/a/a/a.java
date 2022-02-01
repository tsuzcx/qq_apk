package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.b.e;

public final class a
  extends s.a.a<a>
{
  public byte ahNk;
  public k ahNl;
  
  public a(int paramInt, byte paramByte, k paramk)
  {
    super(paramInt);
    this.ahNk = paramByte;
    this.ahNl = paramk;
  }
  
  private int a(a parama)
  {
    int i = this.ahNl.b(parama.ahNl);
    if (i != 0) {
      return i;
    }
    return c.c(this.ahNk, parama.ahNk);
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
    return e.hash(new Object[] { Byte.valueOf(this.ahNk), this.ahNl });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.tinker.a.a.a
 * JD-Core Version:    0.7.0.1
 */