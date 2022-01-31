package com.tencent.mm.plugin.nfc.a;

import java.io.Serializable;
import java.util.Arrays;

public final class a
  implements Serializable
{
  private byte[] mFX;
  private transient int mFY;
  private transient int mFZ;
  private transient int mGa;
  
  public a(String paramString)
  {
    this.mFX = com.tencent.mm.plugin.nfc.c.a.hexStringToByteArray(paramString);
    parse();
  }
  
  public a(byte[] paramArrayOfByte)
  {
    this.mFX = ((byte[])paramArrayOfByte.clone());
    parse();
  }
  
  private void parse()
  {
    int j = 65536;
    int i = 256;
    if (this.mFX.length < 4) {
      throw new IllegalArgumentException("apdu must be at least 4 bytes long");
    }
    if (this.mFX.length == 4) {
      return;
    }
    int k = this.mFX[4] & 0xFF;
    if (this.mFX.length == 5)
    {
      if (k == 0) {}
      for (;;)
      {
        this.mFZ = i;
        return;
        i = k;
      }
    }
    if (k != 0)
    {
      if (this.mFX.length == k + 5)
      {
        this.mFY = k;
        this.mGa = 5;
        return;
      }
      if (this.mFX.length == k + 6)
      {
        this.mFY = k;
        this.mGa = 5;
        j = this.mFX[(this.mFX.length - 1)] & 0xFF;
        if (j == 0) {}
        for (;;)
        {
          this.mFZ = i;
          return;
          i = j;
        }
      }
      throw new IllegalArgumentException("Invalid APDU: length=" + this.mFX.length + ", b1=" + k);
    }
    if (this.mFX.length < 7) {
      throw new IllegalArgumentException("Invalid APDU: length=" + this.mFX.length + ", b1=" + k);
    }
    int m = (this.mFX[5] & 0xFF) << 8 | this.mFX[6] & 0xFF;
    if (this.mFX.length == 7)
    {
      i = m;
      if (m == 0) {
        i = 65536;
      }
      this.mFZ = i;
      return;
    }
    if (m == 0) {
      throw new IllegalArgumentException("Invalid APDU: length=" + this.mFX.length + ", b1=" + k + ", b2||b3=" + m);
    }
    if (this.mFX.length == m + 7)
    {
      this.mFY = m;
      this.mGa = 7;
      return;
    }
    if (this.mFX.length == m + 9)
    {
      this.mFY = m;
      this.mGa = 7;
      i = this.mFX.length - 2;
      k = this.mFX[i];
      i = this.mFX[(i + 1)] & 0xFF | (k & 0xFF) << 8;
      if (i == 0) {
        i = j;
      }
      for (;;)
      {
        this.mFZ = i;
        return;
      }
    }
    throw new IllegalArgumentException("Invalid APDU: length=" + this.mFX.length + ", b1=" + k + ", b2||b3=" + m);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof a)) {
      return false;
    }
    paramObject = (a)paramObject;
    return Arrays.equals(this.mFX, paramObject.mFX);
  }
  
  public final byte[] getBytes()
  {
    return (byte[])this.mFX.clone();
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(this.mFX);
  }
  
  public final String toString()
  {
    return com.tencent.mm.plugin.nfc.c.a.byteArrayToHexString(this.mFX);
  }
  
  public final void vk(int paramInt)
  {
    this.mFZ = paramInt;
    this.mFX[(this.mFX.length - 1)] = ((byte)paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.nfc.a.a
 * JD-Core Version:    0.7.0.1
 */