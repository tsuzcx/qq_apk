package com.google.android.gms.internal;

public final class dn
{
  private int Rh;
  private int Ri;
  private int Rj;
  private int Rk;
  private int Rl;
  private int Rm = 2147483647;
  private int Rn;
  private int Ro = 64;
  private int Rp = 67108864;
  private final byte[] buffer;
  
  private dn(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.buffer = paramArrayOfByte;
    this.Rh = paramInt1;
    this.Ri = (paramInt1 + paramInt2);
    this.Rk = paramInt1;
  }
  
  public static dn a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new dn(paramArrayOfByte, 0, paramInt2);
  }
  
  private void bu(int paramInt)
  {
    if (paramInt < 0) {
      throw dv.kc();
    }
    if (this.Rk + paramInt > this.Rm)
    {
      bu(this.Rm - this.Rk);
      throw dv.kb();
    }
    if (paramInt <= this.Ri - this.Rk)
    {
      this.Rk += paramInt;
      return;
    }
    throw dv.kb();
  }
  
  private void jV()
  {
    this.Ri += this.Rj;
    int i = this.Ri;
    if (i > this.Rm)
    {
      this.Rj = (i - this.Rm);
      this.Ri -= this.Rj;
      return;
    }
    this.Rj = 0;
  }
  
  private byte jX()
  {
    if (this.Rk == this.Ri) {
      throw dv.kb();
    }
    byte[] arrayOfByte = this.buffer;
    int i = this.Rk;
    this.Rk = (i + 1);
    return arrayOfByte[i];
  }
  
  public final byte[] Z(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      return dz.RO;
    }
    byte[] arrayOfByte = new byte[paramInt2];
    int i = this.Rh;
    System.arraycopy(this.buffer, i + paramInt1, arrayOfByte, 0, paramInt2);
    return arrayOfByte;
  }
  
  public final void a(dw paramdw)
  {
    int i = jS();
    if (this.Rn >= this.Ro) {
      throw dv.kh();
    }
    i = br(i);
    this.Rn += 1;
    paramdw.a(this);
    bp(0);
    this.Rn -= 1;
    bs(i);
  }
  
  public final void bp(int paramInt)
  {
    if (this.Rl != paramInt) {
      throw dv.kf();
    }
  }
  
  public final boolean bq(int paramInt)
  {
    switch (dz.bD(paramInt))
    {
    default: 
      throw dv.kg();
    case 0: 
      jS();
      return true;
    case 1: 
      jU();
      return true;
    case 2: 
      bu(jS());
      return true;
    case 3: 
      int i;
      do
      {
        i = jQ();
      } while ((i != 0) && (bq(i)));
      bp(dz.ad(dz.bE(paramInt), 4));
      return true;
    case 4: 
      return false;
    }
    jT();
    return true;
  }
  
  public final int br(int paramInt)
  {
    if (paramInt < 0) {
      throw dv.kc();
    }
    paramInt = this.Rk + paramInt;
    int i = this.Rm;
    if (paramInt > i) {
      throw dv.kb();
    }
    this.Rm = paramInt;
    jV();
    return i;
  }
  
  public final void bs(int paramInt)
  {
    this.Rm = paramInt;
    jV();
  }
  
  public final void bt(int paramInt)
  {
    if (paramInt > this.Rk - this.Rh)
    {
      int i = this.Rk;
      int j = this.Rh;
      throw new IllegalArgumentException(50 + "Position " + paramInt + " is beyond current " + (i - j));
    }
    if (paramInt < 0) {
      throw new IllegalArgumentException(24 + "Bad position " + paramInt);
    }
    this.Rk = (this.Rh + paramInt);
  }
  
  public final int getPosition()
  {
    return this.Rk - this.Rh;
  }
  
  public final int jQ()
  {
    if (this.Rk == this.Ri) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.Rl = 0;
      return 0;
    }
    this.Rl = jS();
    if (this.Rl == 0) {
      throw dv.ke();
    }
    return this.Rl;
  }
  
  public final long jR()
  {
    int i = 0;
    long l = 0L;
    while (i < 64)
    {
      int j = jX();
      l |= (j & 0x7F) << i;
      if ((j & 0x80) == 0) {
        return l;
      }
      i += 7;
    }
    throw dv.kd();
  }
  
  public final int jS()
  {
    int i = jX();
    if (i >= 0) {}
    int k;
    do
    {
      return i;
      i &= 0x7F;
      j = jX();
      if (j >= 0) {
        return i | j << 7;
      }
      i |= (j & 0x7F) << 7;
      j = jX();
      if (j >= 0) {
        return i | j << 14;
      }
      i |= (j & 0x7F) << 14;
      k = jX();
      if (k >= 0) {
        return i | k << 21;
      }
      j = jX();
      k = i | (k & 0x7F) << 21 | j << 28;
      i = k;
    } while (j >= 0);
    int j = 0;
    for (;;)
    {
      if (j >= 5) {
        break label133;
      }
      i = k;
      if (jX() >= 0) {
        break;
      }
      j += 1;
    }
    label133:
    throw dv.kd();
  }
  
  public final int jT()
  {
    return jX() & 0xFF | (jX() & 0xFF) << 8 | (jX() & 0xFF) << 16 | (jX() & 0xFF) << 24;
  }
  
  public final long jU()
  {
    int i = jX();
    int j = jX();
    int k = jX();
    int m = jX();
    int n = jX();
    int i1 = jX();
    int i2 = jX();
    int i3 = jX();
    long l = i;
    return (j & 0xFF) << 8 | l & 0xFF | (k & 0xFF) << 16 | (m & 0xFF) << 24 | (n & 0xFF) << 32 | (i1 & 0xFF) << 40 | (i2 & 0xFF) << 48 | (i3 & 0xFF) << 56;
  }
  
  public final int jW()
  {
    if (this.Rm == 2147483647) {
      return -1;
    }
    int i = this.Rk;
    return this.Rm - i;
  }
  
  public final byte[] readBytes()
  {
    int i = jS();
    if (i < 0) {
      throw dv.kc();
    }
    if (i == 0) {
      return dz.RO;
    }
    if (i > this.Ri - this.Rk) {
      throw dv.kb();
    }
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(this.buffer, this.Rk, arrayOfByte, 0, i);
    this.Rk = (i + this.Rk);
    return arrayOfByte;
  }
  
  public final String readString()
  {
    int i = jS();
    if (i < 0) {
      throw dv.kc();
    }
    if (i > this.Ri - this.Rk) {
      throw dv.kb();
    }
    String str = new String(this.buffer, this.Rk, i, du.UTF_8);
    this.Rk = (i + this.Rk);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.dn
 * JD-Core Version:    0.7.0.1
 */