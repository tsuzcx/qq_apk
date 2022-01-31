package com.tencent.mm.plugin.nfc.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.nfc.c.a;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;

public final class c
  implements Serializable
{
  public byte[] pgd;
  
  public c(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23021);
    if (paramArrayOfByte == null)
    {
      paramArrayOfByte = new IllegalArgumentException("apdu is null");
      AppMethodBeat.o(23021);
      throw paramArrayOfByte;
    }
    paramArrayOfByte = (byte[])paramArrayOfByte.clone();
    be(paramArrayOfByte);
    this.pgd = paramArrayOfByte;
    AppMethodBeat.o(23021);
  }
  
  private static void be(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23022);
    if (paramArrayOfByte.length < 2)
    {
      paramArrayOfByte = new IllegalArgumentException("apdu must be at least 2 bytes long");
      AppMethodBeat.o(23022);
      throw paramArrayOfByte;
    }
    AppMethodBeat.o(23022);
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
  {
    AppMethodBeat.i(23028);
    this.pgd = ((byte[])(byte[])paramObjectInputStream.readUnshared());
    be(this.pgd);
    AppMethodBeat.o(23028);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(23025);
    int j = this.pgd.length;
    this.pgd = Arrays.copyOf(this.pgd, this.pgd.length + paramc.pgd.length - 2);
    j -= 2;
    paramc = (byte[])paramc.pgd.clone();
    int m = paramc.length;
    int k = 0;
    while (k < m)
    {
      int i = paramc[k];
      this.pgd[j] = i;
      k += 1;
      j += 1;
    }
    AppMethodBeat.o(23025);
  }
  
  public final short bWV()
  {
    return (short)(this.pgd[(this.pgd.length - 2)] & 0xFF);
  }
  
  public final short bWW()
  {
    return (short)(this.pgd[(this.pgd.length - 1)] & 0xFF);
  }
  
  public final boolean bWX()
  {
    AppMethodBeat.i(23023);
    if ((short)(bWV() << 8 | bWW()) == -28672)
    {
      AppMethodBeat.o(23023);
      return true;
    }
    AppMethodBeat.o(23023);
    return false;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(23026);
    if (this == paramObject)
    {
      AppMethodBeat.o(23026);
      return true;
    }
    if (!(paramObject instanceof c))
    {
      AppMethodBeat.o(23026);
      return false;
    }
    paramObject = (c)paramObject;
    boolean bool = Arrays.equals(this.pgd, paramObject.pgd);
    AppMethodBeat.o(23026);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(23027);
    int i = Arrays.hashCode(this.pgd);
    AppMethodBeat.o(23027);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(23024);
    String str = a.byteArrayToHexString(this.pgd);
    AppMethodBeat.o(23024);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.nfc.a.c
 * JD-Core Version:    0.7.0.1
 */