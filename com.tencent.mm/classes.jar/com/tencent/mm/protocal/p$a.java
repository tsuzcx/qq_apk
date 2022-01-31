package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.c;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class p$a
  extends l.d
  implements l.b
{
  public int bsY;
  public int cut;
  public int fQD;
  public String wiC;
  public byte[] wiD;
  
  public p$a()
  {
    AppMethodBeat.i(28283);
    this.cut = 0;
    this.bsY = 0;
    this.fQD = 0;
    this.wiC = "";
    this.wiD = new byte[0];
    AppMethodBeat.o(28283);
  }
  
  private byte[] bP(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(28285);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(28285);
      return null;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      DataOutputStream localDataOutputStream = new DataOutputStream(localByteArrayOutputStream);
      localDataOutputStream.writeByte(this.cut);
      localDataOutputStream.writeByte(this.bsY);
      localDataOutputStream.write(paramArrayOfByte);
      localDataOutputStream.close();
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      AppMethodBeat.o(28285);
      return paramArrayOfByte;
    }
    catch (IOException paramArrayOfByte)
    {
      for (;;)
      {
        ab.e("MicroMsg.MMDirectSend", "direct merge all failed, err=" + paramArrayOfByte.getMessage());
      }
    }
  }
  
  private byte[] dqC()
  {
    AppMethodBeat.i(28284);
    Object localObject = new ByteArrayOutputStream();
    try
    {
      DataOutputStream localDataOutputStream = new DataOutputStream((OutputStream)localObject);
      localDataOutputStream.writeInt(this.fQD);
      localDataOutputStream.writeShort(this.wiC.getBytes().length);
      localDataOutputStream.write(this.wiC.getBytes());
      localDataOutputStream.writeShort(this.wiD.length);
      localDataOutputStream.write(this.wiD);
      localDataOutputStream.close();
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      AppMethodBeat.o(28284);
      return localObject;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ab.e("MicroMsg.MMDirectSend", "direct merge tail failed, err=" + localIOException.getMessage());
      }
    }
  }
  
  public final int getCmdId()
  {
    return 8;
  }
  
  public final int getFuncId()
  {
    return 10;
  }
  
  public final boolean getShortSupport()
  {
    return false;
  }
  
  public final boolean isRawData()
  {
    return true;
  }
  
  public final byte[] toProtoBuf()
  {
    AppMethodBeat.i(28286);
    byte[] arrayOfByte = dqC();
    PByteArray localPByteArray = new PByteArray();
    c.a(localPByteArray, arrayOfByte, p.anp(super.getDeviceID()));
    arrayOfByte = bP(localPByteArray.value);
    AppMethodBeat.o(28286);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.p.a
 * JD-Core Version:    0.7.0.1
 */