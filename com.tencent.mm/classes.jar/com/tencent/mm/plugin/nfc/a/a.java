package com.tencent.mm.plugin.nfc.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;

public final class a
  implements Serializable
{
  private byte[] ADT;
  private transient int ADU;
  private transient int ADV;
  private transient int ADW;
  
  public a(String paramString)
  {
    AppMethodBeat.i(26641);
    this.ADT = com.tencent.mm.plugin.nfc.c.a.hexStringToByteArray(paramString);
    parse();
    AppMethodBeat.o(26641);
  }
  
  public a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26640);
    this.ADT = ((byte[])paramArrayOfByte.clone());
    parse();
    AppMethodBeat.o(26640);
  }
  
  private void parse()
  {
    int i = 256;
    AppMethodBeat.i(26642);
    if (this.ADT.length < 4)
    {
      localIllegalArgumentException = new IllegalArgumentException("apdu must be at least 4 bytes long");
      AppMethodBeat.o(26642);
      throw localIllegalArgumentException;
    }
    if (this.ADT.length == 4)
    {
      AppMethodBeat.o(26642);
      return;
    }
    int j = this.ADT[4] & 0xFF;
    if (this.ADT.length == 5)
    {
      if (j == 0) {}
      for (;;)
      {
        this.ADV = i;
        AppMethodBeat.o(26642);
        return;
        i = j;
      }
    }
    if (j != 0)
    {
      if (this.ADT.length == j + 5)
      {
        this.ADU = j;
        this.ADW = 5;
        AppMethodBeat.o(26642);
        return;
      }
      if (this.ADT.length == j + 6)
      {
        this.ADU = j;
        this.ADW = 5;
        j = this.ADT[(this.ADT.length - 1)] & 0xFF;
        if (j == 0) {}
        for (;;)
        {
          this.ADV = i;
          AppMethodBeat.o(26642);
          return;
          i = j;
        }
      }
      localIllegalArgumentException = new IllegalArgumentException("Invalid APDU: length=" + this.ADT.length + ", b1=" + j);
      AppMethodBeat.o(26642);
      throw localIllegalArgumentException;
    }
    if (this.ADT.length < 7)
    {
      localIllegalArgumentException = new IllegalArgumentException("Invalid APDU: length=" + this.ADT.length + ", b1=" + j);
      AppMethodBeat.o(26642);
      throw localIllegalArgumentException;
    }
    int k = (this.ADT[5] & 0xFF) << 8 | this.ADT[6] & 0xFF;
    if (this.ADT.length == 7)
    {
      i = k;
      if (k == 0) {
        i = 65536;
      }
      this.ADV = i;
      AppMethodBeat.o(26642);
      return;
    }
    if (k == 0)
    {
      localIllegalArgumentException = new IllegalArgumentException("Invalid APDU: length=" + this.ADT.length + ", b1=" + j + ", b2||b3=" + k);
      AppMethodBeat.o(26642);
      throw localIllegalArgumentException;
    }
    if (this.ADT.length == k + 7)
    {
      this.ADU = k;
      this.ADW = 7;
      AppMethodBeat.o(26642);
      return;
    }
    if (this.ADT.length == k + 9)
    {
      this.ADU = k;
      this.ADW = 7;
      i = this.ADT.length - 2;
      j = this.ADT[i];
      j = this.ADT[(i + 1)] & 0xFF | (j & 0xFF) << 8;
      i = j;
      if (j == 0) {
        i = 65536;
      }
      this.ADV = i;
      AppMethodBeat.o(26642);
      return;
    }
    IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Invalid APDU: length=" + this.ADT.length + ", b1=" + j + ", b2||b3=" + k);
    AppMethodBeat.o(26642);
    throw localIllegalArgumentException;
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
  {
    AppMethodBeat.i(26647);
    this.ADT = ((byte[])(byte[])paramObjectInputStream.readUnshared());
    parse();
    AppMethodBeat.o(26647);
  }
  
  public final void TH(int paramInt)
  {
    this.ADV = paramInt;
    this.ADT[(this.ADT.length - 1)] = ((byte)paramInt);
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
    boolean bool = Arrays.equals(this.ADT, paramObject.ADT);
    AppMethodBeat.o(26645);
    return bool;
  }
  
  public final byte[] getBytes()
  {
    AppMethodBeat.i(26643);
    byte[] arrayOfByte = (byte[])this.ADT.clone();
    AppMethodBeat.o(26643);
    return arrayOfByte;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(26646);
    int i = Arrays.hashCode(this.ADT);
    AppMethodBeat.o(26646);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(26644);
    String str = com.tencent.mm.plugin.nfc.c.a.byteArrayToHexString(this.ADT);
    AppMethodBeat.o(26644);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.nfc.a.a
 * JD-Core Version:    0.7.0.1
 */