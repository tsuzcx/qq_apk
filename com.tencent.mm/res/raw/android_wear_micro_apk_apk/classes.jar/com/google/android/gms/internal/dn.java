package com.google.android.gms.internal;

public final class dn
{
  private int SW;
  private int SX;
  private int SY;
  private int SZ;
  private int Ta;
  private int Tb = 2147483647;
  private int Tc;
  private int Td = 64;
  private int Te = 67108864;
  private final byte[] buffer;
  
  private dn(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.buffer = paramArrayOfByte;
    this.SW = paramInt1;
    this.SX = (paramInt1 + paramInt2);
    this.SZ = paramInt1;
  }
  
  public static dn a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new dn(paramArrayOfByte, 0, paramInt2);
  }
  
  private void bO(int paramInt)
  {
    if (paramInt < 0) {
      throw dv.kl();
    }
    if (this.SZ + paramInt > this.Tb)
    {
      bO(this.Tb - this.SZ);
      throw dv.kk();
    }
    if (paramInt <= this.SX - this.SZ)
    {
      this.SZ += paramInt;
      return;
    }
    throw dv.kk();
  }
  
  private void ke()
  {
    this.SX += this.SY;
    int i = this.SX;
    if (i > this.Tb)
    {
      this.SY = (i - this.Tb);
      this.SX -= this.SY;
      return;
    }
    this.SY = 0;
  }
  
  private byte kg()
  {
    if (this.SZ == this.SX) {
      throw dv.kk();
    }
    byte[] arrayOfByte = this.buffer;
    int i = this.SZ;
    this.SZ = (i + 1);
    return arrayOfByte[i];
  }
  
  public final void a(dw paramdw)
  {
    int i = ka();
    if (this.Tc >= this.Td) {
      throw dv.kq();
    }
    i = bL(i);
    this.Tc += 1;
    paramdw.a(this);
    bJ(0);
    this.Tc -= 1;
    bM(i);
  }
  
  public final byte[] ab(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      return dz.TD;
    }
    byte[] arrayOfByte = new byte[paramInt2];
    int i = this.SW;
    System.arraycopy(this.buffer, i + paramInt1, arrayOfByte, 0, paramInt2);
    return arrayOfByte;
  }
  
  public final void bJ(int paramInt)
  {
    if (this.Ta != paramInt) {
      throw dv.ko();
    }
  }
  
  public final boolean bK(int paramInt)
  {
    switch (dz.bY(paramInt))
    {
    default: 
      throw dv.kp();
    case 0: 
      ka();
      return true;
    case 1: 
      kd();
      return true;
    case 2: 
      bO(ka());
      return true;
    case 3: 
      int i;
      do
      {
        i = jZ();
      } while ((i != 0) && (bK(i)));
      bJ(dz.af(dz.bZ(paramInt), 4));
      return true;
    case 4: 
      return false;
    }
    kc();
    return true;
  }
  
  public final int bL(int paramInt)
  {
    if (paramInt < 0) {
      throw dv.kl();
    }
    paramInt = this.SZ + paramInt;
    int i = this.Tb;
    if (paramInt > i) {
      throw dv.kk();
    }
    this.Tb = paramInt;
    ke();
    return i;
  }
  
  public final void bM(int paramInt)
  {
    this.Tb = paramInt;
    ke();
  }
  
  public final void bN(int paramInt)
  {
    if (paramInt > this.SZ - this.SW)
    {
      int i = this.SZ;
      int j = this.SW;
      throw new IllegalArgumentException(50 + "Position " + paramInt + " is beyond current " + (i - j));
    }
    if (paramInt < 0) {
      throw new IllegalArgumentException(24 + "Bad position " + paramInt);
    }
    this.SZ = (this.SW + paramInt);
  }
  
  public final int getPosition()
  {
    return this.SZ - this.SW;
  }
  
  public final int jZ()
  {
    if (this.SZ == this.SX) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.Ta = 0;
      return 0;
    }
    this.Ta = ka();
    if (this.Ta == 0) {
      throw dv.kn();
    }
    return this.Ta;
  }
  
  public final int ka()
  {
    int i = kg();
    if (i >= 0) {}
    int k;
    do
    {
      return i;
      i &= 0x7F;
      j = kg();
      if (j >= 0) {
        return i | j << 7;
      }
      i |= (j & 0x7F) << 7;
      j = kg();
      if (j >= 0) {
        return i | j << 14;
      }
      i |= (j & 0x7F) << 14;
      k = kg();
      if (k >= 0) {
        return i | k << 21;
      }
      j = kg();
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
      if (kg() >= 0) {
        break;
      }
      j += 1;
    }
    label133:
    throw dv.km();
  }
  
  public final long kb()
  {
    int i = 0;
    long l = 0L;
    while (i < 64)
    {
      int j = kg();
      l |= (j & 0x7F) << i;
      if ((j & 0x80) == 0) {
        return l;
      }
      i += 7;
    }
    throw dv.km();
  }
  
  public final int kc()
  {
    return kg() & 0xFF | (kg() & 0xFF) << 8 | (kg() & 0xFF) << 16 | (kg() & 0xFF) << 24;
  }
  
  public final long kd()
  {
    int i = kg();
    int j = kg();
    int k = kg();
    int m = kg();
    int n = kg();
    int i1 = kg();
    int i2 = kg();
    int i3 = kg();
    long l = i;
    return (j & 0xFF) << 8 | l & 0xFF | (k & 0xFF) << 16 | (m & 0xFF) << 24 | (n & 0xFF) << 32 | (i1 & 0xFF) << 40 | (i2 & 0xFF) << 48 | (i3 & 0xFF) << 56;
  }
  
  public final int kf()
  {
    if (this.Tb == 2147483647) {
      return -1;
    }
    int i = this.SZ;
    return this.Tb - i;
  }
  
  public final byte[] readBytes()
  {
    int i = ka();
    if (i < 0) {
      throw dv.kl();
    }
    if (i == 0) {
      return dz.TD;
    }
    if (i > this.SX - this.SZ) {
      throw dv.kk();
    }
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(this.buffer, this.SZ, arrayOfByte, 0, i);
    this.SZ = (i + this.SZ);
    return arrayOfByte;
  }
  
  public final String readString()
  {
    int i = ka();
    if (i < 0) {
      throw dv.kl();
    }
    if (i > this.SX - this.SZ) {
      throw dv.kk();
    }
    String str = new String(this.buffer, this.SZ, i, du.UTF_8);
    this.SZ = (i + this.SZ);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.dn
 * JD-Core Version:    0.7.0.1
 */