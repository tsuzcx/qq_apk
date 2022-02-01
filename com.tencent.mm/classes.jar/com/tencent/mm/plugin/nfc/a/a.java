package com.tencent.mm.plugin.nfc.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;

public final class a
  implements Serializable
{
  private byte[] wII;
  private transient int wIJ;
  private transient int wIK;
  private transient int wIL;
  
  public a(String paramString)
  {
    AppMethodBeat.i(26641);
    this.wII = com.tencent.mm.plugin.nfc.c.a.hexStringToByteArray(paramString);
    parse();
    AppMethodBeat.o(26641);
  }
  
  public a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26640);
    this.wII = ((byte[])paramArrayOfByte.clone());
    parse();
    AppMethodBeat.o(26640);
  }
  
  private void parse()
  {
    int i = 256;
    AppMethodBeat.i(26642);
    if (this.wII.length < 4)
    {
      localIllegalArgumentException = new IllegalArgumentException("apdu must be at least 4 bytes long");
      AppMethodBeat.o(26642);
      throw localIllegalArgumentException;
    }
    if (this.wII.length == 4)
    {
      AppMethodBeat.o(26642);
      return;
    }
    int j = this.wII[4] & 0xFF;
    if (this.wII.length == 5)
    {
      if (j == 0) {}
      for (;;)
      {
        this.wIK = i;
        AppMethodBeat.o(26642);
        return;
        i = j;
      }
    }
    if (j != 0)
    {
      if (this.wII.length == j + 5)
      {
        this.wIJ = j;
        this.wIL = 5;
        AppMethodBeat.o(26642);
        return;
      }
      if (this.wII.length == j + 6)
      {
        this.wIJ = j;
        this.wIL = 5;
        j = this.wII[(this.wII.length - 1)] & 0xFF;
        if (j == 0) {}
        for (;;)
        {
          this.wIK = i;
          AppMethodBeat.o(26642);
          return;
          i = j;
        }
      }
      localIllegalArgumentException = new IllegalArgumentException("Invalid APDU: length=" + this.wII.length + ", b1=" + j);
      AppMethodBeat.o(26642);
      throw localIllegalArgumentException;
    }
    if (this.wII.length < 7)
    {
      localIllegalArgumentException = new IllegalArgumentException("Invalid APDU: length=" + this.wII.length + ", b1=" + j);
      AppMethodBeat.o(26642);
      throw localIllegalArgumentException;
    }
    int k = (this.wII[5] & 0xFF) << 8 | this.wII[6] & 0xFF;
    if (this.wII.length == 7)
    {
      i = k;
      if (k == 0) {
        i = 65536;
      }
      this.wIK = i;
      AppMethodBeat.o(26642);
      return;
    }
    if (k == 0)
    {
      localIllegalArgumentException = new IllegalArgumentException("Invalid APDU: length=" + this.wII.length + ", b1=" + j + ", b2||b3=" + k);
      AppMethodBeat.o(26642);
      throw localIllegalArgumentException;
    }
    if (this.wII.length == k + 7)
    {
      this.wIJ = k;
      this.wIL = 7;
      AppMethodBeat.o(26642);
      return;
    }
    if (this.wII.length == k + 9)
    {
      this.wIJ = k;
      this.wIL = 7;
      i = this.wII.length - 2;
      j = this.wII[i];
      j = this.wII[(i + 1)] & 0xFF | (j & 0xFF) << 8;
      i = j;
      if (j == 0) {
        i = 65536;
      }
      this.wIK = i;
      AppMethodBeat.o(26642);
      return;
    }
    IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Invalid APDU: length=" + this.wII.length + ", b1=" + j + ", b2||b3=" + k);
    AppMethodBeat.o(26642);
    throw localIllegalArgumentException;
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
  {
    AppMethodBeat.i(26647);
    this.wII = ((byte[])(byte[])paramObjectInputStream.readUnshared());
    parse();
    AppMethodBeat.o(26647);
  }
  
  public final void MA(int paramInt)
  {
    this.wIK = paramInt;
    this.wII[(this.wII.length - 1)] = ((byte)paramInt);
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
    boolean bool = Arrays.equals(this.wII, paramObject.wII);
    AppMethodBeat.o(26645);
    return bool;
  }
  
  public final byte[] getBytes()
  {
    AppMethodBeat.i(26643);
    byte[] arrayOfByte = (byte[])this.wII.clone();
    AppMethodBeat.o(26643);
    return arrayOfByte;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(26646);
    int i = Arrays.hashCode(this.wII);
    AppMethodBeat.o(26646);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(26644);
    String str = com.tencent.mm.plugin.nfc.c.a.byteArrayToHexString(this.wII);
    AppMethodBeat.o(26644);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.nfc.a.a
 * JD-Core Version:    0.7.0.1
 */