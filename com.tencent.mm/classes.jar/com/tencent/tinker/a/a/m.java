package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.a;

public final class m
{
  protected final a IBp;
  public int IBq;
  private int IBr;
  private int type = -1;
  
  public m(a parama, int paramInt)
  {
    this.IBp = parama;
    this.type = paramInt;
  }
  
  public m(k paramk, int paramInt)
  {
    this(new k.1(paramk), paramInt);
  }
  
  private void ace(int paramInt)
  {
    if (xM() != paramInt) {
      throw new IllegalStateException(String.format("Expected %x but was %x", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(xM()) }));
    }
  }
  
  public final int foH()
  {
    ace(28);
    this.type = -1;
    return o.b(this.IBp);
  }
  
  public final int foI()
  {
    ace(29);
    this.type = -1;
    this.IBq = o.b(this.IBp);
    return o.b(this.IBp);
  }
  
  public final int foJ()
  {
    return o.b(this.IBp);
  }
  
  public final int foK()
  {
    ace(23);
    this.type = -1;
    return l.a(this.IBp, this.IBr, false);
  }
  
  public final int foL()
  {
    ace(24);
    this.type = -1;
    return l.a(this.IBp, this.IBr, false);
  }
  
  public final int foM()
  {
    ace(25);
    this.type = -1;
    return l.a(this.IBp, this.IBr, false);
  }
  
  public final int foN()
  {
    ace(27);
    this.type = -1;
    return l.a(this.IBp, this.IBr, false);
  }
  
  public final int foO()
  {
    ace(26);
    this.type = -1;
    return l.a(this.IBp, this.IBr, false);
  }
  
  public final void foP()
  {
    ace(30);
    this.type = -1;
  }
  
  public final boolean readBoolean()
  {
    ace(31);
    this.type = -1;
    return this.IBr != 0;
  }
  
  public final byte readByte()
  {
    ace(0);
    this.type = -1;
    return (byte)l.a(this.IBp, this.IBr);
  }
  
  public final char readChar()
  {
    ace(3);
    this.type = -1;
    return (char)l.a(this.IBp, this.IBr, false);
  }
  
  public final double readDouble()
  {
    ace(17);
    this.type = -1;
    a locala = this.IBp;
    int i = this.IBr;
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
    ace(16);
    this.type = -1;
    return Float.intBitsToFloat(l.a(this.IBp, this.IBr, true));
  }
  
  public final int readInt()
  {
    ace(4);
    this.type = -1;
    return l.a(this.IBp, this.IBr);
  }
  
  public final long readLong()
  {
    ace(6);
    this.type = -1;
    a locala = this.IBp;
    int j = this.IBr;
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
    ace(2);
    this.type = -1;
    return (short)l.a(this.IBp, this.IBr);
  }
  
  public final void skipValue()
  {
    int j = 0;
    int i = 0;
    switch (xM())
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
      foK();
      return;
    case 24: 
      foL();
      return;
    case 25: 
      foM();
      return;
    case 27: 
      foN();
      return;
    case 26: 
      foO();
      return;
    case 28: 
      j = foH();
      while (i < j)
      {
        skipValue();
        i += 1;
      }
    case 29: 
      int k = foI();
      i = j;
      while (i < k)
      {
        o.b(this.IBp);
        skipValue();
        i += 1;
      }
    case 30: 
      foP();
      return;
    }
    readBoolean();
  }
  
  public final int xM()
  {
    if (this.type == -1)
    {
      int i = this.IBp.readByte() & 0xFF;
      this.type = (i & 0x1F);
      this.IBr = ((i & 0xE0) >> 5);
    }
    return this.type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.a.a.m
 * JD-Core Version:    0.7.0.1
 */