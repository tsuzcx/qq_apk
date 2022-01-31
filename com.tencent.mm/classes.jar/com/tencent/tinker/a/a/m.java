package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.a;

public final class m
{
  private int type = -1;
  protected final a wSN;
  public int wSO;
  private int wSP;
  
  public m(a parama, int paramInt)
  {
    this.wSN = parama;
    this.type = paramInt;
  }
  
  public m(k paramk, int paramInt)
  {
    this(new k.1(paramk), paramInt);
  }
  
  private void Jy(int paramInt)
  {
    if (cQn() != paramInt) {
      throw new IllegalStateException(String.format("Expected %x but was %x", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(cQn()) }));
    }
  }
  
  public final int cQn()
  {
    if (this.type == -1)
    {
      int i = this.wSN.readByte() & 0xFF;
      this.type = (i & 0x1F);
      this.wSP = ((i & 0xE0) >> 5);
    }
    return this.type;
  }
  
  public final int cQo()
  {
    Jy(28);
    this.type = -1;
    return o.b(this.wSN);
  }
  
  public final int cQp()
  {
    Jy(29);
    this.type = -1;
    this.wSO = o.b(this.wSN);
    return o.b(this.wSN);
  }
  
  public final int cQq()
  {
    return o.b(this.wSN);
  }
  
  public final int cQr()
  {
    Jy(23);
    this.type = -1;
    return l.a(this.wSN, this.wSP, false);
  }
  
  public final int cQs()
  {
    Jy(24);
    this.type = -1;
    return l.a(this.wSN, this.wSP, false);
  }
  
  public final int cQt()
  {
    Jy(25);
    this.type = -1;
    return l.a(this.wSN, this.wSP, false);
  }
  
  public final int cQu()
  {
    Jy(27);
    this.type = -1;
    return l.a(this.wSN, this.wSP, false);
  }
  
  public final int cQv()
  {
    Jy(26);
    this.type = -1;
    return l.a(this.wSN, this.wSP, false);
  }
  
  public final void cQw()
  {
    Jy(30);
    this.type = -1;
  }
  
  public final boolean readBoolean()
  {
    Jy(31);
    this.type = -1;
    return this.wSP != 0;
  }
  
  public final byte readByte()
  {
    Jy(0);
    this.type = -1;
    return (byte)l.a(this.wSN, this.wSP);
  }
  
  public final char readChar()
  {
    Jy(3);
    this.type = -1;
    return (char)l.a(this.wSN, this.wSP, false);
  }
  
  public final double readDouble()
  {
    Jy(17);
    this.type = -1;
    a locala = this.wSN;
    int i = this.wSP;
    long l = 0L;
    while (i >= 0)
    {
      l = l >>> 8 | (locala.readByte() & 0xFF) << 56;
      i -= 1;
    }
    return Double.longBitsToDouble(l);
  }
  
  public final float readFloat()
  {
    Jy(16);
    this.type = -1;
    return Float.intBitsToFloat(l.a(this.wSN, this.wSP, true));
  }
  
  public final int readInt()
  {
    Jy(4);
    this.type = -1;
    return l.a(this.wSN, this.wSP);
  }
  
  public final long readLong()
  {
    Jy(6);
    this.type = -1;
    a locala = this.wSN;
    int j = this.wSP;
    long l = 0L;
    int i = j;
    while (i >= 0)
    {
      l = l >>> 8 | (locala.readByte() & 0xFF) << 56;
      i -= 1;
    }
    return l >> (7 - j) * 8;
  }
  
  public final short readShort()
  {
    Jy(2);
    this.type = -1;
    return (short)l.a(this.wSN, this.wSP);
  }
  
  public final void skipValue()
  {
    int j = 0;
    int i = 0;
    switch (cQn())
    {
    case 1: 
    case 5: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 18: 
    case 19: 
    case 20: 
    case 21: 
    case 22: 
    default: 
      throw new j("Unexpected type: " + Integer.toHexString(this.type));
    case 0: 
      readByte();
      return;
    case 2: 
      readShort();
      return;
    case 3: 
      readChar();
      return;
    case 4: 
      readInt();
      return;
    case 6: 
      readLong();
      return;
    case 16: 
      readFloat();
      return;
    case 17: 
      readDouble();
      return;
    case 23: 
      cQr();
      return;
    case 24: 
      cQs();
      return;
    case 25: 
      cQt();
      return;
    case 27: 
      cQu();
      return;
    case 26: 
      cQv();
      return;
    case 28: 
      j = cQo();
      while (i < j)
      {
        skipValue();
        i += 1;
      }
    case 29: 
      int k = cQp();
      i = j;
      while (i < k)
      {
        o.b(this.wSN);
        skipValue();
        i += 1;
      }
    case 30: 
      cQw();
      return;
    }
    readBoolean();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tinker.a.a.m
 * JD-Core Version:    0.7.0.1
 */