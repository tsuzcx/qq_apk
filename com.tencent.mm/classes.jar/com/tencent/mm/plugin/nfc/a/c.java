package com.tencent.mm.plugin.nfc.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.nfc.c.a;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;

public final class c
  implements Serializable
{
  public byte[] GwX;
  
  public c(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26648);
    if (paramArrayOfByte == null)
    {
      paramArrayOfByte = new IllegalArgumentException("apdu is null");
      AppMethodBeat.o(26648);
      throw paramArrayOfByte;
    }
    paramArrayOfByte = (byte[])paramArrayOfByte.clone();
    cl(paramArrayOfByte);
    this.GwX = paramArrayOfByte;
    AppMethodBeat.o(26648);
  }
  
  private static void cl(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26649);
    if (paramArrayOfByte.length < 2)
    {
      paramArrayOfByte = new IllegalArgumentException("apdu must be at least 2 bytes long");
      AppMethodBeat.o(26649);
      throw paramArrayOfByte;
    }
    AppMethodBeat.o(26649);
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
  {
    AppMethodBeat.i(26655);
    this.GwX = ((byte[])(byte[])paramObjectInputStream.readUnshared());
    cl(this.GwX);
    AppMethodBeat.o(26655);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(26652);
    int j = this.GwX.length;
    this.GwX = Arrays.copyOf(this.GwX, this.GwX.length + paramc.GwX.length - 2);
    j -= 2;
    paramc = (byte[])paramc.GwX.clone();
    int m = paramc.length;
    int k = 0;
    while (k < m)
    {
      int i = paramc[k];
      this.GwX[j] = i;
      k += 1;
      j += 1;
    }
    AppMethodBeat.o(26652);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(26653);
    if (this == paramObject)
    {
      AppMethodBeat.o(26653);
      return true;
    }
    if (!(paramObject instanceof c))
    {
      AppMethodBeat.o(26653);
      return false;
    }
    paramObject = (c)paramObject;
    boolean bool = Arrays.equals(this.GwX, paramObject.GwX);
    AppMethodBeat.o(26653);
    return bool;
  }
  
  public final short fiW()
  {
    return (short)(this.GwX[(this.GwX.length - 2)] & 0xFF);
  }
  
  public final short fiX()
  {
    return (short)(this.GwX[(this.GwX.length - 1)] & 0xFF);
  }
  
  public final boolean fiY()
  {
    AppMethodBeat.i(26650);
    if ((short)(fiW() << 8 | fiX()) == -28672)
    {
      AppMethodBeat.o(26650);
      return true;
    }
    AppMethodBeat.o(26650);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(26654);
    int i = Arrays.hashCode(this.GwX);
    AppMethodBeat.o(26654);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(26651);
    String str = a.byteArrayToHexString(this.GwX);
    AppMethodBeat.o(26651);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.nfc.a.c
 * JD-Core Version:    0.7.0.1
 */