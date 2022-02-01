package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.c;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class p
{
  public static final class a
    extends l.d
    implements l.b
  {
    public String CqG;
    public byte[] CqH;
    public int djq;
    public int dtM;
    public int htk;
    
    public a()
    {
      AppMethodBeat.i(32087);
      this.djq = 0;
      this.dtM = 0;
      this.htk = 0;
      this.CqG = "";
      this.CqH = new byte[0];
      AppMethodBeat.o(32087);
    }
    
    private byte[] ch(byte[] paramArrayOfByte)
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
        localDataOutputStream.writeByte(this.djq);
        localDataOutputStream.writeByte(this.dtM);
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
          ad.e("MicroMsg.MMDirectSend", "direct merge all failed, err=" + paramArrayOfByte.getMessage());
        }
      }
    }
    
    private byte[] eBW()
    {
      AppMethodBeat.i(32088);
      Object localObject = new ByteArrayOutputStream();
      try
      {
        DataOutputStream localDataOutputStream = new DataOutputStream((OutputStream)localObject);
        localDataOutputStream.writeInt(this.htk);
        localDataOutputStream.writeShort(this.CqG.getBytes().length);
        localDataOutputStream.write(this.CqG.getBytes());
        localDataOutputStream.writeShort(this.CqH.length);
        localDataOutputStream.write(this.CqH);
        localDataOutputStream.close();
        localObject = ((ByteArrayOutputStream)localObject).toByteArray();
        AppMethodBeat.o(32088);
        return localObject;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          ad.e("MicroMsg.MMDirectSend", "direct merge tail failed, err=" + localIOException.getMessage());
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
      byte[] arrayOfByte = eBW();
      PByteArray localPByteArray = new PByteArray();
      c.a(localPByteArray, arrayOfByte, p.aDk(super.getDeviceID()));
      arrayOfByte = ch(localPByteArray.value);
      AppMethodBeat.o(32090);
      return arrayOfByte;
    }
  }
  
  public static final class b
    extends l.e
    implements l.c
  {
    public byte[] content;
    public String deviceID;
    private int djq;
    private int dtM;
    public String hrn;
    private int htk;
    
    public b()
    {
      AppMethodBeat.i(32091);
      this.hrn = "";
      this.content = new byte[0];
      this.deviceID = "";
      this.djq = 0;
      this.dtM = 0;
      this.htk = 0;
      this.hrn = "";
      this.content = new byte[0];
      AppMethodBeat.o(32091);
    }
    
    private byte[] ci(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(32092);
      if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 2))
      {
        ad.e("MicroMsg.MMDirectSend", "parse all failed, empty buf");
        AppMethodBeat.o(32092);
        return null;
      }
      byte[] arrayOfByte = new byte[paramArrayOfByte.length - 2];
      try
      {
        paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
        DataInputStream localDataInputStream = new DataInputStream(paramArrayOfByte);
        this.djq = localDataInputStream.readByte();
        this.dtM = localDataInputStream.readByte();
        localDataInputStream.readFully(arrayOfByte);
        ad.d("MicroMsg.MMDirectSend", "cmdId:" + this.djq + ", flag=" + this.dtM + ", tail len=" + arrayOfByte.length);
        paramArrayOfByte.close();
        AppMethodBeat.o(32092);
        return arrayOfByte;
      }
      catch (IOException paramArrayOfByte)
      {
        for (;;)
        {
          ad.e("MicroMsg.MMDirectSend", "direct parse all failed, err=" + paramArrayOfByte.getMessage());
        }
      }
    }
    
    public final int fromProtoBuf(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(32093);
      byte[] arrayOfByte1 = p.aDk(this.deviceID);
      PByteArray localPByteArray = new PByteArray();
      int i;
      if (c.b(localPByteArray, ci(paramArrayOfByte), arrayOfByte1) != 0)
      {
        byte[] arrayOfByte2 = new byte[16];
        i = 0;
        while (i < 16)
        {
          arrayOfByte2[i] = 0;
          i += 1;
        }
        if (c.b(localPByteArray, ci(paramArrayOfByte), arrayOfByte2) != 0)
        {
          ad.e("MicroMsg.MMDirectSend", "decrypting from buffer using key=%s error", new Object[] { bt.cv(arrayOfByte1) });
          AppMethodBeat.o(32093);
          return -1;
        }
      }
      paramArrayOfByte = localPByteArray.value;
      if (paramArrayOfByte == null) {
        ad.e("MicroMsg.MMDirectSend", "parse tail failed, empty buf");
      }
      for (;;)
      {
        AppMethodBeat.o(32093);
        return 0;
        try
        {
          paramArrayOfByte = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte));
          this.htk = paramArrayOfByte.readInt();
          ad.d("MicroMsg.MMDirectSend", "seq=" + this.htk);
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
          ad.e("MicroMsg.MMDirectSend", "direct parse all failed, err=" + paramArrayOfByte.getMessage());
        }
        continue;
        label232:
        arrayOfByte1 = new byte[i];
        paramArrayOfByte.readFully(arrayOfByte1);
        this.hrn = new String(arrayOfByte1);
        ad.d("MicroMsg.MMDirectSend", "recievers len=" + i + ", sender=" + this.hrn);
        i = paramArrayOfByte.readShort();
        if (i < 0)
        {
          paramArrayOfByte = new IOException("content empty");
          AppMethodBeat.o(32093);
          throw paramArrayOfByte;
        }
        this.content = new byte[i];
        paramArrayOfByte.readFully(this.content);
        ad.d("MicroMsg.MMDirectSend", "content len=" + this.content.length);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.p
 * JD-Core Version:    0.7.0.1
 */