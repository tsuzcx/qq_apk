package com.tencent.tinker.a.b.a;

public final class h
  extends a
{
  public short[] ahPf;
  
  public h(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("initSize < 0");
    }
    this.ahPf = new short[paramInt];
  }
  
  public final void a(short paramShort1, short paramShort2, short paramShort3)
  {
    g(paramShort1);
    g(paramShort2);
    g(paramShort3);
  }
  
  public final void aX(int paramInt)
  {
    g((short)paramInt);
    g((short)(paramInt >> 16));
  }
  
  public final void d(short paramShort1, short paramShort2)
  {
    g(paramShort1);
    g(paramShort2);
  }
  
  public final void g(short paramShort)
  {
    int i = this.bGj;
    if (this.ahPf.length - i <= 0)
    {
      short[] arrayOfShort = new short[this.ahPf.length + (this.ahPf.length >> 1)];
      System.arraycopy(this.ahPf, 0, arrayOfShort, 0, i);
      this.ahPf = arrayOfShort;
    }
    this.ahPf[this.bGj] = paramShort;
    kbZ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.tinker.a.b.a.h
 * JD-Core Version:    0.7.0.1
 */