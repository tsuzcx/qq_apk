package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.c;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public final class p$b
  extends l.e
  implements l.c
{
  public String deviceID;
  private int eQp;
  private int hId;
  public byte[] hVd;
  public String oSj;
  private int oUj;
  
  public p$b()
  {
    AppMethodBeat.i(32091);
    this.oSj = "";
    this.hVd = new byte[0];
    this.deviceID = "";
    this.hId = 0;
    this.eQp = 0;
    this.oUj = 0;
    this.oSj = "";
    this.hVd = new byte[0];
    AppMethodBeat.o(32091);
  }
  
  private byte[] dc(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(32092);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 2))
    {
      Log.e("MicroMsg.MMDirectSend", "parse all failed, empty buf");
      AppMethodBeat.o(32092);
      return null;
    }
    byte[] arrayOfByte = new byte[paramArrayOfByte.length - 2];
    try
    {
      paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
      DataInputStream localDataInputStream = new DataInputStream(paramArrayOfByte);
      this.hId = localDataInputStream.readByte();
      this.eQp = localDataInputStream.readByte();
      localDataInputStream.readFully(arrayOfByte);
      Log.d("MicroMsg.MMDirectSend", "cmdId:" + this.hId + ", flag=" + this.eQp + ", tail len=" + arrayOfByte.length);
      paramArrayOfByte.close();
      AppMethodBeat.o(32092);
      return arrayOfByte;
    }
    catch (IOException paramArrayOfByte)
    {
      for (;;)
      {
        Log.e("MicroMsg.MMDirectSend", "direct parse all failed, err=" + paramArrayOfByte.getMessage());
      }
    }
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(32093);
    byte[] arrayOfByte1 = p.bsn(this.deviceID);
    PByteArray localPByteArray = new PByteArray();
    int i;
    if (c.b(localPByteArray, dc(paramArrayOfByte), arrayOfByte1) != 0)
    {
      byte[] arrayOfByte2 = new byte[16];
      i = 0;
      while (i < 16)
      {
        arrayOfByte2[i] = 0;
        i += 1;
      }
      if (c.b(localPByteArray, dc(paramArrayOfByte), arrayOfByte2) != 0)
      {
        Log.e("MicroMsg.MMDirectSend", "decrypting from buffer using key=%s error", new Object[] { Util.dumpHex(arrayOfByte1) });
        AppMethodBeat.o(32093);
        return -1;
      }
    }
    paramArrayOfByte = localPByteArray.value;
    if (paramArrayOfByte == null) {
      Log.e("MicroMsg.MMDirectSend", "parse tail failed, empty buf");
    }
    for (;;)
    {
      AppMethodBeat.o(32093);
      return 0;
      try
      {
        paramArrayOfByte = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte));
        this.oUj = paramArrayOfByte.readInt();
        Log.d("MicroMsg.MMDirectSend", "seq=" + this.oUj);
        i = paramArrayOfByte.readShort();
        if (i >= 0) {
          break label232;
        }
        paramArrayOfByte = new IOException("sender empty");
        AppMethodBeat.o(32093);
        throw paramArrayOfByte;
      }
      catch (IOException paramArrayOfByte)
      {
        Log.e("MicroMsg.MMDirectSend", "direct parse all failed, err=" + paramArrayOfByte.getMessage());
      }
      continue;
      label232:
      arrayOfByte1 = new byte[i];
      paramArrayOfByte.readFully(arrayOfByte1);
      this.oSj = new String(arrayOfByte1);
      Log.d("MicroMsg.MMDirectSend", "recievers len=" + i + ", sender=" + this.oSj);
      i = paramArrayOfByte.readShort();
      if (i < 0)
      {
        paramArrayOfByte = new IOException("content empty");
        AppMethodBeat.o(32093);
        throw paramArrayOfByte;
      }
      this.hVd = new byte[i];
      paramArrayOfByte.readFully(this.hVd);
      Log.d("MicroMsg.MMDirectSend", "content len=" + this.hVd.length);
    }
  }
  
  public final int getCmdId()
  {
    return 8;
  }
  
  public final boolean isRawData()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.p.b
 * JD-Core Version:    0.7.0.1
 */