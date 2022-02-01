package com.tencent.tinker.a.b.a;

public final class h
  extends a
{
  public short[] ZKd;
  
  public h(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("initSize < 0");
    }
    this.ZKd = new short[paramInt];
  }
  
  public final void a(short paramShort1, short paramShort2, short paramShort3)
  {
    d(paramShort1);
    d(paramShort2);
    d(paramShort3);
  }
  
  public final void b(short paramShort1, short paramShort2)
  {
    d(paramShort1);
    d(paramShort2);
  }
  
  public final void bV(int paramInt)
  {
    d((short)paramInt);
    d((short)(paramInt >> 16));
  }
  
  public final void d(short paramShort)
  {
    int i = this.YO;
    if (this.ZKd.length - i <= 0)
    {
      short[] arrayOfShort = new short[this.ZKd.length + (this.ZKd.length >> 1)];
      System.arraycopy(this.ZKd, 0, arrayOfShort, 0, i);
      this.ZKd = arrayOfShort;
    }
    this.ZKd[this.YO] = paramShort;
    isz();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.tinker.a.b.a.h
 * JD-Core Version:    0.7.0.1
 */