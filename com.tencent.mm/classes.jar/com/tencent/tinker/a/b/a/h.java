package com.tencent.tinker.a.b.a;

public final class h
  extends a
{
  public short[] Met;
  
  public h(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("initSize < 0");
    }
    this.Met = new short[paramInt];
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
    int i = this.aoY;
    if (this.Met.length - i <= 0)
    {
      short[] arrayOfShort = new short[this.Met.length + (this.Met.length >> 1)];
      System.arraycopy(this.Met, 0, arrayOfShort, 0, i);
      this.Met = arrayOfShort;
    }
    this.Met[this.aoY] = paramShort;
    fYr();
  }
  
  public final void writeInt(int paramInt)
  {
    c((short)paramInt);
    c((short)(paramInt >> 16));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.a.b.a.h
 * JD-Core Version:    0.7.0.1
 */