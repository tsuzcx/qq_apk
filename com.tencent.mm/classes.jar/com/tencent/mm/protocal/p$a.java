package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.c;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class p$a
  extends l.d
  implements l.b
{
  public String Yyh;
  public byte[] Yyi;
  public int eQp;
  public int hId;
  public int oUj;
  
  public p$a()
  {
    AppMethodBeat.i(32087);
    this.hId = 0;
    this.eQp = 0;
    this.oUj = 0;
    this.Yyh = "";
    this.Yyi = new byte[0];
    AppMethodBeat.o(32087);
  }
  
  private byte[] db(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(32089);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(32089);
      return null;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      DataOutputStream localDataOutputStream = new DataOutputStream(localByteArrayOutputStream);
      localDataOutputStream.writeByte(this.hId);
      localDataOutputStream.writeByte(this.eQp);
      localDataOutputStream.write(paramArrayOfByte);
      localDataOutputStream.close();
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      AppMethodBeat.o(32089);
      return paramArrayOfByte;
    }
    catch (IOException paramArrayOfByte)
    {
      for (;;)
      {
        Log.e("MicroMsg.MMDirectSend", "direct merge all failed, err=" + paramArrayOfByte.getMessage());
      }
    }
  }
  
  private byte[] iPZ()
  {
    AppMethodBeat.i(32088);
    Object localObject = new ByteArrayOutputStream();
    try
    {
      DataOutputStream localDataOutputStream = new DataOutputStream((OutputStream)localObject);
      localDataOutputStream.writeInt(this.oUj);
      localDataOutputStream.writeShort(this.Yyh.getBytes().length);
      localDataOutputStream.write(this.Yyh.getBytes());
      localDataOutputStream.writeShort(this.Yyi.length);
      localDataOutputStream.write(this.Yyi);
      localDataOutputStream.close();
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      AppMethodBeat.o(32088);
      return localObject;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.e("MicroMsg.MMDirectSend", "direct merge tail failed, err=" + localIOException.getMessage());
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
    AppMethodBeat.i(32090);
    byte[] arrayOfByte = iPZ();
    PByteArray localPByteArray = new PByteArray();
    c.a(localPByteArray, arrayOfByte, p.bsn(super.getDeviceID()));
    arrayOfByte = db(localPByteArray.value);
    AppMethodBeat.o(32090);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.p.a
 * JD-Core Version:    0.7.0.1
 */