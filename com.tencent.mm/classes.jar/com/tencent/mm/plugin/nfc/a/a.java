package com.tencent.mm.plugin.nfc.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;

public final class a
  implements Serializable
{
  private byte[] pgd;
  private transient int pge;
  private transient int pgf;
  private transient int pgg;
  
  public a(String paramString)
  {
    AppMethodBeat.i(23014);
    this.pgd = com.tencent.mm.plugin.nfc.c.a.hexStringToByteArray(paramString);
    parse();
    AppMethodBeat.o(23014);
  }
  
  public a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23013);
    this.pgd = ((byte[])paramArrayOfByte.clone());
    parse();
    AppMethodBeat.o(23013);
  }
  
  private void parse()
  {
    int i = 256;
    AppMethodBeat.i(23015);
    if (this.pgd.length < 4)
    {
      localIllegalArgumentException = new IllegalArgumentException("apdu must be at least 4 bytes long");
      AppMethodBeat.o(23015);
      throw localIllegalArgumentException;
    }
    if (this.pgd.length == 4)
    {
      AppMethodBeat.o(23015);
      return;
    }
    int j = this.pgd[4] & 0xFF;
    if (this.pgd.length == 5)
    {
      if (j == 0) {}
      for (;;)
      {
        this.pgf = i;
        AppMethodBeat.o(23015);
        return;
        i = j;
      }
    }
    if (j != 0)
    {
      if (this.pgd.length == j + 5)
      {
        this.pge = j;
        this.pgg = 5;
        AppMethodBeat.o(23015);
        return;
      }
      if (this.pgd.length == j + 6)
      {
        this.pge = j;
        this.pgg = 5;
        j = this.pgd[(this.pgd.length - 1)] & 0xFF;
        if (j == 0) {}
        for (;;)
        {
          this.pgf = i;
          AppMethodBeat.o(23015);
          return;
          i = j;
        }
      }
      localIllegalArgumentException = new IllegalArgumentException("Invalid APDU: length=" + this.pgd.length + ", b1=" + j);
      AppMethodBeat.o(23015);
      throw localIllegalArgumentException;
    }
    if (this.pgd.length < 7)
    {
      localIllegalArgumentException = new IllegalArgumentException("Invalid APDU: length=" + this.pgd.length + ", b1=" + j);
      AppMethodBeat.o(23015);
      throw localIllegalArgumentException;
    }
    int k = (this.pgd[5] & 0xFF) << 8 | this.pgd[6] & 0xFF;
    if (this.pgd.length == 7)
    {
      i = k;
      if (k == 0) {
        i = 65536;
      }
      this.pgf = i;
      AppMethodBeat.o(23015);
      return;
    }
    if (k == 0)
    {
      localIllegalArgumentException = new IllegalArgumentException("Invalid APDU: length=" + this.pgd.length + ", b1=" + j + ", b2||b3=" + k);
      AppMethodBeat.o(23015);
      throw localIllegalArgumentException;
    }
    if (this.pgd.length == k + 7)
    {
      this.pge = k;
      this.pgg = 7;
      AppMethodBeat.o(23015);
      return;
    }
    if (this.pgd.length == k + 9)
    {
      this.pge = k;
      this.pgg = 7;
      i = this.pgd.length - 2;
      j = this.pgd[i];
      j = this.pgd[(i + 1)] & 0xFF | (j & 0xFF) << 8;
      i = j;
      if (j == 0) {
        i = 65536;
      }
      this.pgf = i;
      AppMethodBeat.o(23015);
      return;
    }
    IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Invalid APDU: length=" + this.pgd.length + ", b1=" + j + ", b2||b3=" + k);
    AppMethodBeat.o(23015);
    throw localIllegalArgumentException;
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
  {
    AppMethodBeat.i(23020);
    this.pgd = ((byte[])(byte[])paramObjectInputStream.readUnshared());
    parse();
    AppMethodBeat.o(23020);
  }
  
  public final void AI(int paramInt)
  {
    this.pgf = paramInt;
    this.pgd[(this.pgd.length - 1)] = ((byte)paramInt);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(23018);
    if (this == paramObject)
    {
      AppMethodBeat.o(23018);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(23018);
      return false;
    }
    paramObject = (a)paramObject;
    boolean bool = Arrays.equals(this.pgd, paramObject.pgd);
    AppMethodBeat.o(23018);
    return bool;
  }
  
  public final byte[] getBytes()
  {
    AppMethodBeat.i(23016);
    byte[] arrayOfByte = (byte[])this.pgd.clone();
    AppMethodBeat.o(23016);
    return arrayOfByte;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(23019);
    int i = Arrays.hashCode(this.pgd);
    AppMethodBeat.o(23019);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(23017);
    String str = com.tencent.mm.plugin.nfc.c.a.byteArrayToHexString(this.pgd);
    AppMethodBeat.o(23017);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.nfc.a.a
 * JD-Core Version:    0.7.0.1
 */