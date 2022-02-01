package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.a;

public final class m
{
  protected final a MAr;
  public int MAs;
  private int MAt;
  private int type = -1;
  
  public m(a parama, int paramInt)
  {
    this.MAr = parama;
    this.type = paramInt;
  }
  
  public m(k paramk, int paramInt)
  {
    this(new k.1(paramk), paramInt);
  }
  
  private void aij(int paramInt)
  {
    if (yW() != paramInt) {
      throw new IllegalStateException(String.format("Expected %x but was %x", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(yW()) }));
    }
  }
  
  public final int gcA()
  {
    aij(28);
    this.type = -1;
    return o.b(this.MAr);
  }
  
  public final int gcB()
  {
    aij(29);
    this.type = -1;
    this.MAs = o.b(this.MAr);
    return o.b(this.MAr);
  }
  
  public final int gcC()
  {
    return o.b(this.MAr);
  }
  
  public final int gcD()
  {
    aij(23);
    this.type = -1;
    return l.a(this.MAr, this.MAt, false);
  }
  
  public final int gcE()
  {
    aij(24);
    this.type = -1;
    return l.a(this.MAr, this.MAt, false);
  }
  
  public final int gcF()
  {
    aij(25);
    this.type = -1;
    return l.a(this.MAr, this.MAt, false);
  }
  
  public final int gcG()
  {
    aij(27);
    this.type = -1;
    return l.a(this.MAr, this.MAt, false);
  }
  
  public final int gcH()
  {
    aij(26);
    this.type = -1;
    return l.a(this.MAr, this.MAt, false);
  }
  
  public final void gcI()
  {
    aij(30);
    this.type = -1;
  }
  
  public final boolean readBoolean()
  {
    aij(31);
    this.type = -1;
    return this.MAt != 0;
  }
  
  public final byte readByte()
  {
    aij(0);
    this.type = -1;
    return (byte)l.a(this.MAr, this.MAt);
  }
  
  public final char readChar()
  {
    aij(3);
    this.type = -1;
    return (char)l.a(this.MAr, this.MAt, false);
  }
  
  public final double readDouble()
  {
    aij(17);
    this.type = -1;
    a locala = this.MAr;
    int i = this.MAt;
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
    aij(16);
    this.type = -1;
    return Float.intBitsToFloat(l.a(this.MAr, this.MAt, true));
  }
  
  public final int readInt()
  {
    aij(4);
    this.type = -1;
    return l.a(this.MAr, this.MAt);
  }
  
  public final long readLong()
  {
    aij(6);
    this.type = -1;
    a locala = this.MAr;
    int j = this.MAt;
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
    aij(2);
    this.type = -1;
    return (short)l.a(this.MAr, this.MAt);
  }
  
  public final void skipValue()
  {
    int j = 0;
    int i = 0;
    switch (yW())
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
      gcD();
      return;
    case 24: 
      gcE();
      return;
    case 25: 
      gcF();
      return;
    case 27: 
      gcG();
      return;
    case 26: 
      gcH();
      return;
    case 28: 
      j = gcA();
      while (i < j)
      {
        skipValue();
        i += 1;
      }
    case 29: 
      int k = gcB();
      i = j;
      while (i < k)
      {
        o.b(this.MAr);
        skipValue();
        i += 1;
      }
    case 30: 
      gcI();
      return;
    }
    readBoolean();
  }
  
  public final int yW()
  {
    if (this.type == -1)
    {
      int i = this.MAr.readByte() & 0xFF;
      this.type = (i & 0x1F);
      this.MAt = ((i & 0xE0) >> 5);
    }
    return this.type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.a.a.m
 * JD-Core Version:    0.7.0.1
 */