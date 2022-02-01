package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.a;

public final class m
{
  private int OyR;
  protected final a ahOi;
  public int ahOj;
  private int type = -1;
  
  public m(a parama, int paramInt)
  {
    this.ahOi = parama;
    this.type = paramInt;
  }
  
  public m(k paramk, int paramInt)
  {
    this(new k.1(paramk), paramInt);
  }
  
  private void aIj(int paramInt)
  {
    if (px() != paramInt) {
      throw new IllegalStateException(String.format("Expected %x but was %x", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(px()) }));
    }
  }
  
  public final void Zp()
  {
    int j = 0;
    int i = 0;
    switch (px())
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
      kbN();
      return;
    case 24: 
      kbO();
      return;
    case 25: 
      kbP();
      return;
    case 27: 
      aam();
      return;
    case 26: 
      kbQ();
      return;
    case 28: 
      j = kbK();
      while (i < j)
      {
        Zp();
        i += 1;
      }
    case 29: 
      int k = kbL();
      i = j;
      while (i < k)
      {
        o.b(this.ahOi);
        Zp();
        i += 1;
      }
    case 30: 
      kbR();
      return;
    }
    readBoolean();
  }
  
  public final int aam()
  {
    aIj(27);
    this.type = -1;
    return l.a(this.ahOi, this.OyR, false);
  }
  
  public final int kbK()
  {
    aIj(28);
    this.type = -1;
    return o.b(this.ahOi);
  }
  
  public final int kbL()
  {
    aIj(29);
    this.type = -1;
    this.ahOj = o.b(this.ahOi);
    return o.b(this.ahOi);
  }
  
  public final int kbM()
  {
    return o.b(this.ahOi);
  }
  
  public final int kbN()
  {
    aIj(23);
    this.type = -1;
    return l.a(this.ahOi, this.OyR, false);
  }
  
  public final int kbO()
  {
    aIj(24);
    this.type = -1;
    return l.a(this.ahOi, this.OyR, false);
  }
  
  public final int kbP()
  {
    aIj(25);
    this.type = -1;
    return l.a(this.ahOi, this.OyR, false);
  }
  
  public final int kbQ()
  {
    aIj(26);
    this.type = -1;
    return l.a(this.ahOi, this.OyR, false);
  }
  
  public final void kbR()
  {
    aIj(30);
    this.type = -1;
  }
  
  public final int px()
  {
    if (this.type == -1)
    {
      int i = this.ahOi.readByte() & 0xFF;
      this.type = (i & 0x1F);
      this.OyR = ((i & 0xE0) >> 5);
    }
    return this.type;
  }
  
  public final boolean readBoolean()
  {
    aIj(31);
    this.type = -1;
    return this.OyR != 0;
  }
  
  public final byte readByte()
  {
    aIj(0);
    this.type = -1;
    return (byte)l.a(this.ahOi, this.OyR);
  }
  
  public final char readChar()
  {
    aIj(3);
    this.type = -1;
    return (char)l.a(this.ahOi, this.OyR, false);
  }
  
  public final double readDouble()
  {
    aIj(17);
    this.type = -1;
    a locala = this.ahOi;
    int i = this.OyR;
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
    aIj(16);
    this.type = -1;
    return Float.intBitsToFloat(l.a(this.ahOi, this.OyR, true));
  }
  
  public final int readInt()
  {
    aIj(4);
    this.type = -1;
    return l.a(this.ahOi, this.OyR);
  }
  
  public final long readLong()
  {
    aIj(6);
    this.type = -1;
    a locala = this.ahOi;
    int j = this.OyR;
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
    aIj(2);
    this.type = -1;
    return (short)l.a(this.ahOi, this.OyR);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.tinker.a.a.m
 * JD-Core Version:    0.7.0.1
 */