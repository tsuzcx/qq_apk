package com.tencent.tinker.a.b.a;

public final class h
  extends a
{
  public short[] Kov;
  
  public h(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("initSize < 0");
    }
    this.Kov = new short[paramInt];
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
    int i = this.anh;
    if (this.Kov.length - i <= 0)
    {
      short[] arrayOfShort = new short[this.Kov.length + (this.Kov.length >> 1)];
      System.arraycopy(this.Kov, 0, arrayOfShort, 0, i);
      this.Kov = arrayOfShort;
    }
    this.Kov[this.anh] = paramShort;
    fHf();
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