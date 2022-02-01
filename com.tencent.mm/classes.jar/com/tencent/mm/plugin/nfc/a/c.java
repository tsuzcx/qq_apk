package com.tencent.mm.plugin.nfc.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.nfc.c.a;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;

public final class c
  implements Serializable
{
  public byte[] vnG;
  
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
    bt(paramArrayOfByte);
    this.vnG = paramArrayOfByte;
    AppMethodBeat.o(26648);
  }
  
  private static void bt(byte[] paramArrayOfByte)
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
    this.vnG = ((byte[])(byte[])paramObjectInputStream.readUnshared());
    bt(this.vnG);
    AppMethodBeat.o(26655);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(26652);
    int j = this.vnG.length;
    this.vnG = Arrays.copyOf(this.vnG, this.vnG.length + paramc.vnG.length - 2);
    j -= 2;
    paramc = (byte[])paramc.vnG.clone();
    int m = paramc.length;
    int k = 0;
    while (k < m)
    {
      int i = paramc[k];
      this.vnG[j] = i;
      k += 1;
      j += 1;
    }
    AppMethodBeat.o(26652);
  }
  
  public final short dkj()
  {
    return (short)(this.vnG[(this.vnG.length - 2)] & 0xFF);
  }
  
  public final short dkk()
  {
    return (short)(this.vnG[(this.vnG.length - 1)] & 0xFF);
  }
  
  public final boolean dkl()
  {
    AppMethodBeat.i(26650);
    if ((short)(dkj() << 8 | dkk()) == -28672)
    {
      AppMethodBeat.o(26650);
      return true;
    }
    AppMethodBeat.o(26650);
    return false;
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
    boolean bool = Arrays.equals(this.vnG, paramObject.vnG);
    AppMethodBeat.o(26653);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(26654);
    int i = Arrays.hashCode(this.vnG);
    AppMethodBeat.o(26654);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(26651);
    String str = a.byteArrayToHexString(this.vnG);
    AppMethodBeat.o(26651);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.nfc.a.c
 * JD-Core Version:    0.7.0.1
 */