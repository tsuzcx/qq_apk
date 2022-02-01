package com.tencent.tinker.a.b.a;

public final class h
  extends a
{
  public short[] ICm;
  
  public h(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("initSize < 0");
    }
    this.ICm = new short[paramInt];
  }
  
  public final void a(short paramShort1, short paramShort2, short paramShort3)
  {
    c(paramShort1);
    c(paramShort2);
    c(paramShort3);
  }
  
  public final void b(short paramShort1, short paramShort2)
  {
    c(paramShort1);
    c(paramShort2);
  }
  
  public final void c(short paramShort)
  {
    int i = this.amn;
    if (this.ICm.length - i <= 0)
    {
      short[] arrayOfShort = new short[this.ICm.length + (this.ICm.length >> 1)];
      System.arraycopy(this.ICm, 0, arrayOfShort, 0, i);
      this.ICm = arrayOfShort;
    }
    this.ICm[this.amn] = paramShort;
    foX();
  }
  
  public final void writeInt(int paramInt)
  {
    c((short)paramInt);
    c((short)(paramInt >> 16));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.a.b.a.h
 * JD-Core Version:    0.7.0.1
 */