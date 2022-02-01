package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.b.e;

public final class a
  extends s.a.a<a>
{
  public byte Mzs;
  public k Mzt;
  
  public a(int paramInt, byte paramByte, k paramk)
  {
    super(paramInt);
    this.Mzs = paramByte;
    this.Mzt = paramk;
  }
  
  private int a(a parama)
  {
    int i = this.Mzt.b(parama.Mzt);
    if (i != 0) {
      return i;
    }
    return c.a(this.Mzs, parama.Mzs);
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
    return e.hash(new Object[] { Byte.valueOf(this.Mzs), this.Mzt });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.a.a.a
 * JD-Core Version:    0.7.0.1
 */