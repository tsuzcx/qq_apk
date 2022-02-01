package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.a;

public final class m
{
  protected final a Mdw;
  public int Mdx;
  private int Mdy;
  private int type = -1;
  
  public m(a parama, int paramInt)
  {
    this.Mdw = parama;
    this.type = paramInt;
  }
  
  public m(k paramk, int paramInt)
  {
    this(new k.1(paramk), paramInt);
  }
  
  private void ahA(int paramInt)
  {
    if (yW() != paramInt) {
      throw new IllegalStateException(String.format("Expected %x but was %x", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(yW()) }));
    }
  }
  
  public final int fYb()
  {
    ahA(28);
    this.type = -1;
    return o.b(this.Mdw);
  }
  
  public final int fYc()
  {
    ahA(29);
    this.type = -1;
    this.Mdx = o.b(this.Mdw);
    return o.b(this.Mdw);
  }
  
  public final int fYd()
  {
    return o.b(this.Mdw);
  }
  
  public final int fYe()
  {
    ahA(23);
    this.type = -1;
    return l.a(this.Mdw, this.Mdy, false);
  }
  
  public final int fYf()
  {
    ahA(24);
    this.type = -1;
    return l.a(this.Mdw, this.Mdy, false);
  }
  
  public final int fYg()
  {
    ahA(25);
    this.type = -1;
    return l.a(this.Mdw, this.Mdy, false);
  }
  
  public final int fYh()
  {
    ahA(27);
    this.type = -1;
    return l.a(this.Mdw, this.Mdy, false);
  }
  
  public final int fYi()
  {
    ahA(26);
    this.type = -1;
    return l.a(this.Mdw, this.Mdy, false);
  }
  
  public final void fYj()
  {
    ahA(30);
    this.type = -1;
  }
  
  public final boolean readBoolean()
  {
    ahA(31);
    this.type = -1;
    return this.Mdy != 0;
  }
  
  public final byte readByte()
  {
    ahA(0);
    this.type = -1;
    return (byte)l.a(this.Mdw, this.Mdy);
  }
  
  public final char readChar()
  {
    ahA(3);
    this.type = -1;
    return (char)l.a(this.Mdw, this.Mdy, false);
  }
  
  public final double readDouble()
  {
    ahA(17);
    this.type = -1;
    a locala = this.Mdw;
    int i = this.Mdy;
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
    ahA(16);
    this.type = -1;
    return Float.intBitsToFloat(l.a(this.Mdw, this.Mdy, true));
  }
  
  public final int readInt()
  {
    ahA(4);
    this.type = -1;
    return l.a(this.Mdw, this.Mdy);
  }
  
  public final long readLong()
  {
    ahA(6);
    this.type = -1;
    a locala = this.Mdw;
    int j = this.Mdy;
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
    ahA(2);
    this.type = -1;
    return (short)l.a(this.Mdw, this.Mdy);
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
      fYe();
      return;
    case 24: 
      fYf();
      return;
    case 25: 
      fYg();
      return;
    case 27: 
      fYh();
      return;
    case 26: 
      fYi();
      return;
    case 28: 
      j = fYb();
      while (i < j)
      {
        skipValue();
        i += 1;
      }
    case 29: 
      int k = fYc();
      i = j;
      while (i < k)
      {
        o.b(this.Mdw);
        skipValue();
        i += 1;
      }
    case 30: 
      fYj();
      return;
    }
    readBoolean();
  }
  
  public final int yW()
  {
    if (this.type == -1)
    {
      int i = this.Mdw.readByte() & 0xFF;
      this.type = (i & 0x1F);
      this.Mdy = ((i & 0xE0) >> 5);
    }
    return this.type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.a.a.m
 * JD-Core Version:    0.7.0.1
 */