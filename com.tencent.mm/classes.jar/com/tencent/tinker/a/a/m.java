package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.a;

public final class m
{
  protected final a Sgv;
  public int Sgw;
  private int Sgx;
  private int type = -1;
  
  public m(a parama, int paramInt)
  {
    this.Sgv = parama;
    this.type = paramInt;
  }
  
  public m(k paramk, int paramInt)
  {
    this(new k.1(paramk), paramInt);
  }
  
  private void arJ(int paramInt)
  {
    if (hoI() != paramInt) {
      throw new IllegalStateException(String.format("Expected %x but was %x", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(hoI()) }));
    }
  }
  
  public final int hoI()
  {
    if (this.type == -1)
    {
      int i = this.Sgv.readByte() & 0xFF;
      this.type = (i & 0x1F);
      this.Sgx = ((i & 0xE0) >> 5);
    }
    return this.type;
  }
  
  public final int hoJ()
  {
    arJ(28);
    this.type = -1;
    return o.b(this.Sgv);
  }
  
  public final int hoK()
  {
    arJ(29);
    this.type = -1;
    this.Sgw = o.b(this.Sgv);
    return o.b(this.Sgv);
  }
  
  public final int hoL()
  {
    return o.b(this.Sgv);
  }
  
  public final int hoM()
  {
    arJ(23);
    this.type = -1;
    return l.a(this.Sgv, this.Sgx, false);
  }
  
  public final int hoN()
  {
    arJ(24);
    this.type = -1;
    return l.a(this.Sgv, this.Sgx, false);
  }
  
  public final int hoO()
  {
    arJ(25);
    this.type = -1;
    return l.a(this.Sgv, this.Sgx, false);
  }
  
  public final int hoP()
  {
    arJ(26);
    this.type = -1;
    return l.a(this.Sgv, this.Sgx, false);
  }
  
  public final void hoQ()
  {
    arJ(30);
    this.type = -1;
  }
  
  public final boolean readBoolean()
  {
    arJ(31);
    this.type = -1;
    return this.Sgx != 0;
  }
  
  public final byte readByte()
  {
    arJ(0);
    this.type = -1;
    return (byte)l.a(this.Sgv, this.Sgx);
  }
  
  public final char readChar()
  {
    arJ(3);
    this.type = -1;
    return (char)l.a(this.Sgv, this.Sgx, false);
  }
  
  public final double readDouble()
  {
    arJ(17);
    this.type = -1;
    a locala = this.Sgv;
    int i = this.Sgx;
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
    arJ(16);
    this.type = -1;
    return Float.intBitsToFloat(l.a(this.Sgv, this.Sgx, true));
  }
  
  public final int readInt()
  {
    arJ(4);
    this.type = -1;
    return l.a(this.Sgv, this.Sgx);
  }
  
  public final long readLong()
  {
    arJ(6);
    this.type = -1;
    a locala = this.Sgv;
    int j = this.Sgx;
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
    arJ(2);
    this.type = -1;
    return (short)l.a(this.Sgv, this.Sgx);
  }
  
  public final void skipValue()
  {
    int j = 0;
    int i = 0;
    switch (hoI())
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
      hoM();
      return;
    case 24: 
      hoN();
      return;
    case 25: 
      hoO();
      return;
    case 27: 
      zd();
      return;
    case 26: 
      hoP();
      return;
    case 28: 
      j = hoJ();
      while (i < j)
      {
        skipValue();
        i += 1;
      }
    case 29: 
      int k = hoK();
      i = j;
      while (i < k)
      {
        o.b(this.Sgv);
        skipValue();
        i += 1;
      }
    case 30: 
      hoQ();
      return;
    }
    readBoolean();
  }
  
  public final int zd()
  {
    arJ(27);
    this.type = -1;
    return l.a(this.Sgv, this.Sgx, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tinker.a.a.m
 * JD-Core Version:    0.7.0.1
 */