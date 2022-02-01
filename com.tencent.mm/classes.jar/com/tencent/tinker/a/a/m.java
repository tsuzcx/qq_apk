package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.a;

public final class m
{
  private int KnA;
  protected final a Kny;
  public int Knz;
  private int type = -1;
  
  public m(a parama, int paramInt)
  {
    this.Kny = parama;
    this.type = paramInt;
  }
  
  public m(k paramk, int paramInt)
  {
    this(new k.1(paramk), paramInt);
  }
  
  private void afa(int paramInt)
  {
    if (xz() != paramInt) {
      throw new IllegalStateException(String.format("Expected %x but was %x", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(xz()) }));
    }
  }
  
  public final int fGP()
  {
    afa(28);
    this.type = -1;
    return o.b(this.Kny);
  }
  
  public final int fGQ()
  {
    afa(29);
    this.type = -1;
    this.Knz = o.b(this.Kny);
    return o.b(this.Kny);
  }
  
  public final int fGR()
  {
    return o.b(this.Kny);
  }
  
  public final int fGS()
  {
    afa(23);
    this.type = -1;
    return l.a(this.Kny, this.KnA, false);
  }
  
  public final int fGT()
  {
    afa(24);
    this.type = -1;
    return l.a(this.Kny, this.KnA, false);
  }
  
  public final int fGU()
  {
    afa(25);
    this.type = -1;
    return l.a(this.Kny, this.KnA, false);
  }
  
  public final int fGV()
  {
    afa(27);
    this.type = -1;
    return l.a(this.Kny, this.KnA, false);
  }
  
  public final int fGW()
  {
    afa(26);
    this.type = -1;
    return l.a(this.Kny, this.KnA, false);
  }
  
  public final void fGX()
  {
    afa(30);
    this.type = -1;
  }
  
  public final boolean readBoolean()
  {
    afa(31);
    this.type = -1;
    return this.KnA != 0;
  }
  
  public final byte readByte()
  {
    afa(0);
    this.type = -1;
    return (byte)l.a(this.Kny, this.KnA);
  }
  
  public final char readChar()
  {
    afa(3);
    this.type = -1;
    return (char)l.a(this.Kny, this.KnA, false);
  }
  
  public final double readDouble()
  {
    afa(17);
    this.type = -1;
    a locala = this.Kny;
    int i = this.KnA;
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
    afa(16);
    this.type = -1;
    return Float.intBitsToFloat(l.a(this.Kny, this.KnA, true));
  }
  
  public final int readInt()
  {
    afa(4);
    this.type = -1;
    return l.a(this.Kny, this.KnA);
  }
  
  public final long readLong()
  {
    afa(6);
    this.type = -1;
    a locala = this.Kny;
    int j = this.KnA;
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
    afa(2);
    this.type = -1;
    return (short)l.a(this.Kny, this.KnA);
  }
  
  public final void skipValue()
  {
    int j = 0;
    int i = 0;
    switch (xz())
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
      fGS();
      return;
    case 24: 
      fGT();
      return;
    case 25: 
      fGU();
      return;
    case 27: 
      fGV();
      return;
    case 26: 
      fGW();
      return;
    case 28: 
      j = fGP();
      while (i < j)
      {
        skipValue();
        i += 1;
      }
    case 29: 
      int k = fGQ();
      i = j;
      while (i < k)
      {
        o.b(this.Kny);
        skipValue();
        i += 1;
      }
    case 30: 
      fGX();
      return;
    }
    readBoolean();
  }
  
  public final int xz()
  {
    if (this.type == -1)
    {
      int i = this.Kny.readByte() & 0xFF;
      this.type = (i & 0x1F);
      this.KnA = ((i & 0xE0) >> 5);
    }
    return this.type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.a.a.m
 * JD-Core Version:    0.7.0.1
 */