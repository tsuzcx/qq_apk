package com.tencent.mm.plugin.nfc.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import java.util.Arrays;

public final class a
  implements Serializable
{
  private byte[] MsX;
  private transient int MsY;
  private transient int MsZ;
  private transient int Mta;
  
  public a(String paramString)
  {
    AppMethodBeat.i(26641);
    this.MsX = com.tencent.mm.plugin.nfc.c.a.aQa(paramString);
    parse();
    AppMethodBeat.o(26641);
  }
  
  public a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26640);
    this.MsX = ((byte[])paramArrayOfByte.clone());
    parse();
    AppMethodBeat.o(26640);
  }
  
  private void parse()
  {
    int i = 256;
    AppMethodBeat.i(26642);
    if (this.MsX.length < 4)
    {
      localIllegalArgumentException = new IllegalArgumentException("apdu must be at least 4 bytes long");
      AppMethodBeat.o(26642);
      throw localIllegalArgumentException;
    }
    if (this.MsX.length == 4)
    {
      AppMethodBeat.o(26642);
      return;
    }
    int j = this.MsX[4] & 0xFF;
    if (this.MsX.length == 5)
    {
      if (j == 0) {}
      for (;;)
      {
        this.MsZ = i;
        AppMethodBeat.o(26642);
        return;
        i = j;
      }
    }
    if (j != 0)
    {
      if (this.MsX.length == j + 5)
      {
        this.MsY = j;
        this.Mta = 5;
        AppMethodBeat.o(26642);
        return;
      }
      if (this.MsX.length == j + 6)
      {
        this.MsY = j;
        this.Mta = 5;
        j = this.MsX[(this.MsX.length - 1)] & 0xFF;
        if (j == 0) {}
        for (;;)
        {
          this.MsZ = i;
          AppMethodBeat.o(26642);
          return;
          i = j;
        }
      }
      localIllegalArgumentException = new IllegalArgumentException("Invalid APDU: length=" + this.MsX.length + ", b1=" + j);
      AppMethodBeat.o(26642);
      throw localIllegalArgumentException;
    }
    if (this.MsX.length < 7)
    {
      localIllegalArgumentException = new IllegalArgumentException("Invalid APDU: length=" + this.MsX.length + ", b1=" + j);
      AppMethodBeat.o(26642);
      throw localIllegalArgumentException;
    }
    int k = (this.MsX[5] & 0xFF) << 8 | this.MsX[6] & 0xFF;
    if (this.MsX.length == 7)
    {
      i = k;
      if (k == 0) {
        i = 65536;
      }
      this.MsZ = i;
      AppMethodBeat.o(26642);
      return;
    }
    if (k == 0)
    {
      localIllegalArgumentException = new IllegalArgumentException("Invalid APDU: length=" + this.MsX.length + ", b1=" + j + ", b2||b3=" + k);
      AppMethodBeat.o(26642);
      throw localIllegalArgumentException;
    }
    if (this.MsX.length == k + 7)
    {
      this.MsY = k;
      this.Mta = 7;
      AppMethodBeat.o(26642);
      return;
    }
    if (this.MsX.length == k + 9)
    {
      this.MsY = k;
      this.Mta = 7;
      i = this.MsX.length - 2;
      j = this.MsX[i];
      j = this.MsX[(i + 1)] & 0xFF | (j & 0xFF) << 8;
      i = j;
      if (j == 0) {
        i = 65536;
      }
      this.MsZ = i;
      AppMethodBeat.o(26642);
      return;
    }
    IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Invalid APDU: length=" + this.MsX.length + ", b1=" + j + ", b2||b3=" + k);
    AppMethodBeat.o(26642);
    throw localIllegalArgumentException;
  }
  
  public final void aeN(int paramInt)
  {
    this.MsZ = paramInt;
    this.MsX[(this.MsX.length - 1)] = ((byte)paramInt);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(26645);
    if (this == paramObject)
    {
      AppMethodBeat.o(26645);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(26645);
      return false;
    }
    paramObject = (a)paramObject;
    boolean bool = Arrays.equals(this.MsX, paramObject.MsX);
    AppMethodBeat.o(26645);
    return bool;
  }
  
  public final byte[] getBytes()
  {
    AppMethodBeat.i(26643);
    byte[] arrayOfByte = (byte[])this.MsX.clone();
    AppMethodBeat.o(26643);
    return arrayOfByte;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(26646);
    int i = Arrays.hashCode(this.MsX);
    AppMethodBeat.o(26646);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(26644);
    String str = com.tencent.mm.plugin.nfc.c.a.byteArrayToHexString(this.MsX);
    AppMethodBeat.o(26644);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.nfc.a.a
 * JD-Core Version:    0.7.0.1
 */