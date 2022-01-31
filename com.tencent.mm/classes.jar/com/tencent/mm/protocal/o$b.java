package com.tencent.mm.protocal;

import com.tencent.mm.a.c;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public final class o$b
  extends k.e
  implements k.c
{
  private int bNb = 0;
  private int bcw = 0;
  public byte[] content = new byte[0];
  public String deviceID = "";
  private int eAK = 0;
  public String eyU = "";
  
  private byte[] bp(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 2))
    {
      y.e("MicroMsg.MMDirectSend", "parse all failed, empty buf");
      return null;
    }
    byte[] arrayOfByte = new byte[paramArrayOfByte.length - 2];
    try
    {
      paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
      DataInputStream localDataInputStream = new DataInputStream(paramArrayOfByte);
      this.bNb = localDataInputStream.readByte();
      this.bcw = localDataInputStream.readByte();
      localDataInputStream.readFully(arrayOfByte);
      y.d("MicroMsg.MMDirectSend", "cmdId:" + this.bNb + ", flag=" + this.bcw + ", tail len=" + arrayOfByte.length);
      paramArrayOfByte.close();
      return arrayOfByte;
    }
    catch (IOException paramArrayOfByte)
    {
      y.e("MicroMsg.MMDirectSend", "direct parse all failed, err=" + paramArrayOfByte.getMessage());
    }
    return arrayOfByte;
  }
  
  public final int A(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte1 = o.Xt(this.deviceID);
    PByteArray localPByteArray = new PByteArray();
    if (c.b(localPByteArray, bp(paramArrayOfByte), arrayOfByte1) != 0)
    {
      byte[] arrayOfByte2 = new byte[16];
      i = 0;
      while (i < 16)
      {
        arrayOfByte2[i] = 0;
        i += 1;
      }
      if (c.b(localPByteArray, bp(paramArrayOfByte), arrayOfByte2) != 0)
      {
        y.e("MicroMsg.MMDirectSend", "decrypting from buffer using key=%s error", new Object[] { bk.bD(arrayOfByte1) });
        return -1;
      }
    }
    paramArrayOfByte = localPByteArray.value;
    if (paramArrayOfByte == null)
    {
      y.e("MicroMsg.MMDirectSend", "parse tail failed, empty buf");
      return 0;
    }
    try
    {
      paramArrayOfByte = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte));
      this.eAK = paramArrayOfByte.readInt();
      y.d("MicroMsg.MMDirectSend", "seq=" + this.eAK);
      i = paramArrayOfByte.readShort();
      if (i < 0) {
        throw new IOException("sender empty");
      }
    }
    catch (IOException paramArrayOfByte)
    {
      y.e("MicroMsg.MMDirectSend", "direct parse all failed, err=" + paramArrayOfByte.getMessage());
      return 0;
    }
    arrayOfByte1 = new byte[i];
    paramArrayOfByte.readFully(arrayOfByte1);
    this.eyU = new String(arrayOfByte1);
    y.d("MicroMsg.MMDirectSend", "recievers len=" + i + ", sender=" + this.eyU);
    int i = paramArrayOfByte.readShort();
    if (i < 0) {
      throw new IOException("content empty");
    }
    this.content = new byte[i];
    paramArrayOfByte.readFully(this.content);
    y.d("MicroMsg.MMDirectSend", "content len=" + this.content.length);
    return 0;
  }
  
  public final boolean cpe()
  {
    return true;
  }
  
  public final int getCmdId()
  {
    return 8;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.o.b
 * JD-Core Version:    0.7.0.1
 */