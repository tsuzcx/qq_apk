package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.c;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public final class p
{
  public static final class b
    extends l.e
    implements l.c
  {
    private int bsY;
    public byte[] content;
    private int cut;
    public String deviceID;
    public String fOJ;
    private int fQD;
    
    public b()
    {
      AppMethodBeat.i(28287);
      this.fOJ = "";
      this.content = new byte[0];
      this.deviceID = "";
      this.cut = 0;
      this.bsY = 0;
      this.fQD = 0;
      this.fOJ = "";
      this.content = new byte[0];
      AppMethodBeat.o(28287);
    }
    
    private byte[] bQ(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(28288);
      if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 2))
      {
        ab.e("MicroMsg.MMDirectSend", "parse all failed, empty buf");
        AppMethodBeat.o(28288);
        return null;
      }
      byte[] arrayOfByte = new byte[paramArrayOfByte.length - 2];
      try
      {
        paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
        DataInputStream localDataInputStream = new DataInputStream(paramArrayOfByte);
        this.cut = localDataInputStream.readByte();
        this.bsY = localDataInputStream.readByte();
        localDataInputStream.readFully(arrayOfByte);
        ab.d("MicroMsg.MMDirectSend", "cmdId:" + this.cut + ", flag=" + this.bsY + ", tail len=" + arrayOfByte.length);
        paramArrayOfByte.close();
        AppMethodBeat.o(28288);
        return arrayOfByte;
      }
      catch (IOException paramArrayOfByte)
      {
        for (;;)
        {
          ab.e("MicroMsg.MMDirectSend", "direct parse all failed, err=" + paramArrayOfByte.getMessage());
        }
      }
    }
    
    public final int fromProtoBuf(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(28289);
      byte[] arrayOfByte1 = p.anp(this.deviceID);
      PByteArray localPByteArray = new PByteArray();
      int i;
      if (c.b(localPByteArray, bQ(paramArrayOfByte), arrayOfByte1) != 0)
      {
        byte[] arrayOfByte2 = new byte[16];
        i = 0;
        while (i < 16)
        {
          arrayOfByte2[i] = 0;
          i += 1;
        }
        if (c.b(localPByteArray, bQ(paramArrayOfByte), arrayOfByte2) != 0)
        {
          ab.e("MicroMsg.MMDirectSend", "decrypting from buffer using key=%s error", new Object[] { bo.cd(arrayOfByte1) });
          AppMethodBeat.o(28289);
          return -1;
        }
      }
      paramArrayOfByte = localPByteArray.value;
      if (paramArrayOfByte == null) {
        ab.e("MicroMsg.MMDirectSend", "parse tail failed, empty buf");
      }
      for (;;)
      {
        AppMethodBeat.o(28289);
        return 0;
        try
        {
          paramArrayOfByte = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte));
          this.fQD = paramArrayOfByte.readInt();
          ab.d("MicroMsg.MMDirectSend", "seq=" + this.fQD);
          i = paramArrayOfByte.readShort();
          if (i >= 0) {
            break label232;
          }
          paramArrayOfByte = new IOException("sender empty");
          AppMethodBeat.o(28289);
          throw paramArrayOfByte;
        }
        catch (IOException paramArrayOfByte)
        {
          ab.e("MicroMsg.MMDirectSend", "direct parse all failed, err=" + paramArrayOfByte.getMessage());
        }
        continue;
        label232:
        arrayOfByte1 = new byte[i];
        paramArrayOfByte.readFully(arrayOfByte1);
        this.fOJ = new String(arrayOfByte1);
        ab.d("MicroMsg.MMDirectSend", "recievers len=" + i + ", sender=" + this.fOJ);
        i = paramArrayOfByte.readShort();
        if (i < 0)
        {
          paramArrayOfByte = new IOException("content empty");
          AppMethodBeat.o(28289);
          throw paramArrayOfByte;
        }
        this.content = new byte[i];
        paramArrayOfByte.readFully(this.content);
        ab.d("MicroMsg.MMDirectSend", "content len=" + this.content.length);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.p
 * JD-Core Version:    0.7.0.1
 */