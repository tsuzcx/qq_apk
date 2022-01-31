package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.a;

public final class m
{
  protected final a Bpu;
  public int Bpv;
  private int Bpw;
  private int type = -1;
  
  public m(a parama, int paramInt)
  {
    this.Bpu = parama;
    this.type = paramInt;
  }
  
  public m(k paramk, int paramInt)
  {
    this(new k.1(paramk), paramInt);
  }
  
  private void St(int paramInt)
  {
    if (dWb() != paramInt) {
      throw new IllegalStateException(String.format("Expected %x but was %x", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(dWb()) }));
    }
  }
  
  public final int dWb()
  {
    if (this.type == -1)
    {
      int i = this.Bpu.readByte() & 0xFF;
      this.type = (i & 0x1F);
      this.Bpw = ((i & 0xE0) >> 5);
    }
    return this.type;
  }
  
  public final int dWc()
  {
    St(28);
    this.type = -1;
    return o.b(this.Bpu);
  }
  
  public final int dWd()
  {
    St(29);
    this.type = -1;
    this.Bpv = o.b(this.Bpu);
    return o.b(this.Bpu);
  }
  
  public final int dWe()
  {
    return o.b(this.Bpu);
  }
  
  public final int dWf()
  {
    St(23);
    this.type = -1;
    return l.a(this.Bpu, this.Bpw, false);
  }
  
  public final int dWg()
  {
    St(24);
    this.type = -1;
    return l.a(this.Bpu, this.Bpw, false);
  }
  
  public final int dWh()
  {
    St(25);
    this.type = -1;
    return l.a(this.Bpu, this.Bpw, false);
  }
  
  public final int dWi()
  {
    St(27);
    this.type = -1;
    return l.a(this.Bpu, this.Bpw, false);
  }
  
  public final int dWj()
  {
    St(26);
    this.type = -1;
    return l.a(this.Bpu, this.Bpw, false);
  }
  
  public final void dWk()
  {
    St(30);
    this.type = -1;
  }
  
  public final boolean readBoolean()
  {
    St(31);
    this.type = -1;
    return this.Bpw != 0;
  }
  
  public final byte readByte()
  {
    St(0);
    this.type = -1;
    return (byte)l.a(this.Bpu, this.Bpw);
  }
  
  public final char readChar()
  {
    St(3);
    this.type = -1;
    return (char)l.a(this.Bpu, this.Bpw, false);
  }
  
  public final double readDouble()
  {
    St(17);
    this.type = -1;
    a locala = this.Bpu;
    int i = this.Bpw;
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
    St(16);
    this.type = -1;
    return Float.intBitsToFloat(l.a(this.Bpu, this.Bpw, true));
  }
  
  public final int readInt()
  {
    St(4);
    this.type = -1;
    return l.a(this.Bpu, this.Bpw);
  }
  
  public final long readLong()
  {
    St(6);
    this.type = -1;
    a locala = this.Bpu;
    int j = this.Bpw;
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
    St(2);
    this.type = -1;
    return (short)l.a(this.Bpu, this.Bpw);
  }
  
  public final void skipValue()
  {
    int j = 0;
    int i = 0;
    switch (dWb())
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
      dWf();
      return;
    case 24: 
      dWg();
      return;
    case 25: 
      dWh();
      return;
    case 27: 
      dWi();
      return;
    case 26: 
      dWj();
      return;
    case 28: 
      j = dWc();
      while (i < j)
      {
        skipValue();
        i += 1;
      }
    case 29: 
      int k = dWd();
      i = j;
      while (i < k)
      {
        o.b(this.Bpu);
        skipValue();
        i += 1;
      }
    case 30: 
      dWk();
      return;
    }
    readBoolean();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.a.a.m
 * JD-Core Version:    0.7.0.1
 */