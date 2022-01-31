package com.tencent.mm.plugin.nfc.a;

import com.tencent.mm.plugin.nfc.c.a;
import java.io.Serializable;
import java.util.Arrays;

public final class c
  implements Serializable
{
  public byte[] mFX;
  
  public c(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      throw new IllegalArgumentException("apdu is null");
    }
    paramArrayOfByte = (byte[])paramArrayOfByte.clone();
    if (paramArrayOfByte.length < 2) {
      throw new IllegalArgumentException("apdu must be at least 2 bytes long");
    }
    this.mFX = paramArrayOfByte;
  }
  
  public final void a(c paramc)
  {
    int j = this.mFX.length;
    this.mFX = Arrays.copyOf(this.mFX, this.mFX.length + paramc.mFX.length - 2);
    j -= 2;
    paramc = (byte[])paramc.mFX.clone();
    int m = paramc.length;
    int k = 0;
    while (k < m)
    {
      int i = paramc[k];
      this.mFX[j] = i;
      k += 1;
      j += 1;
    }
  }
  
  public final short bow()
  {
    return (short)(this.mFX[(this.mFX.length - 2)] & 0xFF);
  }
  
  public final short box()
  {
    return (short)(this.mFX[(this.mFX.length - 1)] & 0xFF);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof c)) {
      return false;
    }
    paramObject = (c)paramObject;
    return Arrays.equals(this.mFX, paramObject.mFX);
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(this.mFX);
  }
  
  public final String toString()
  {
    return a.byteArrayToHexString(this.mFX);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.nfc.a.c
 * JD-Core Version:    0.7.0.1
 */