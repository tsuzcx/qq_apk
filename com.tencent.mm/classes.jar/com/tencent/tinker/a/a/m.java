package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.a;

public final class m
{
  protected final a ZJg;
  public int ZJh;
  private int ZJi;
  private int type = -1;
  
  public m(a parama, int paramInt)
  {
    this.ZJg = parama;
    this.type = paramInt;
  }
  
  public m(k paramk, int paramInt)
  {
    this(new k.1(paramk), paramInt);
  }
  
  private void aBx(int paramInt)
  {
    if (zY() != paramInt) {
      throw new IllegalStateException(String.format("Expected %x but was %x", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(zY()) }));
    }
  }
  
  public final int AF()
  {
    aBx(27);
    this.type = -1;
    return l.a(this.ZJg, this.ZJi, false);
  }
  
  public final int isk()
  {
    aBx(28);
    this.type = -1;
    return o.b(this.ZJg);
  }
  
  public final int isl()
  {
    aBx(29);
    this.type = -1;
    this.ZJh = o.b(this.ZJg);
    return o.b(this.ZJg);
  }
  
  public final int ism()
  {
    return o.b(this.ZJg);
  }
  
  public final int isn()
  {
    aBx(23);
    this.type = -1;
    return l.a(this.ZJg, this.ZJi, false);
  }
  
  public final int iso()
  {
    aBx(24);
    this.type = -1;
    return l.a(this.ZJg, this.ZJi, false);
  }
  
  public final int isp()
  {
    aBx(25);
    this.type = -1;
    return l.a(this.ZJg, this.ZJi, false);
  }
  
  public final int isq()
  {
    aBx(26);
    this.type = -1;
    return l.a(this.ZJg, this.ZJi, false);
  }
  
  public final void isr()
  {
    aBx(30);
    this.type = -1;
  }
  
  public final boolean readBoolean()
  {
    aBx(31);
    this.type = -1;
    return this.ZJi != 0;
  }
  
  public final byte readByte()
  {
    aBx(0);
    this.type = -1;
    return (byte)l.a(this.ZJg, this.ZJi);
  }
  
  public final char readChar()
  {
    aBx(3);
    this.type = -1;
    return (char)l.a(this.ZJg, this.ZJi, false);
  }
  
  public final double readDouble()
  {
    aBx(17);
    this.type = -1;
    a locala = this.ZJg;
    int i = this.ZJi;
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
    aBx(16);
    this.type = -1;
    return Float.intBitsToFloat(l.a(this.ZJg, this.ZJi, true));
  }
  
  public final int readInt()
  {
    aBx(4);
    this.type = -1;
    return l.a(this.ZJg, this.ZJi);
  }
  
  public final long readLong()
  {
    aBx(6);
    this.type = -1;
    a locala = this.ZJg;
    int j = this.ZJi;
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
    aBx(2);
    this.type = -1;
    return (short)l.a(this.ZJg, this.ZJi);
  }
  
  public final void zE()
  {
    int j = 0;
    int i = 0;
    switch (zY())
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
      isn();
      return;
    case 24: 
      iso();
      return;
    case 25: 
      isp();
      return;
    case 27: 
      AF();
      return;
    case 26: 
      isq();
      return;
    case 28: 
      j = isk();
      while (i < j)
      {
        zE();
        i += 1;
      }
    case 29: 
      int k = isl();
      i = j;
      while (i < k)
      {
        o.b(this.ZJg);
        zE();
        i += 1;
      }
    case 30: 
      isr();
      return;
    }
    readBoolean();
  }
  
  public final int zY()
  {
    if (this.type == -1)
    {
      int i = this.ZJg.readByte() & 0xFF;
      this.type = (i & 0x1F);
      this.ZJi = ((i & 0xE0) >> 5);
    }
    return this.type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.tinker.a.a.m
 * JD-Core Version:    0.7.0.1
 */