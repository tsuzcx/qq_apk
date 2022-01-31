package com.tencent.tinker.a.b.a;

public final class h
  extends a
{
  public short[] wTN;
  
  public h(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("initSize < 0");
    }
    this.wTN = new short[paramInt];
  }
  
  public final void a(short paramShort1, short paramShort2, short paramShort3)
  {
    c(paramShort1);
    c(paramShort2);
    c(paramShort3);
  }
  
  public final void c(short paramShort)
  {
    int i = this.wTF;
    if (this.wTN.length - i <= 0)
    {
      short[] arrayOfShort = new short[this.wTN.length + (this.wTN.length >> 1)];
      System.arraycopy(this.wTN, 0, arrayOfShort, 0, i);
      this.wTN = arrayOfShort;
    }
    this.wTN[this.wTF] = paramShort;
    cQC();
  }
  
  public final void c(short paramShort1, short paramShort2)
  {
    c(paramShort1);
    c(paramShort2);
  }
  
  public final void writeInt(int paramInt)
  {
    c((short)paramInt);
    c((short)(paramInt >> 16));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tinker.a.b.a.h
 * JD-Core Version:    0.7.0.1
 */