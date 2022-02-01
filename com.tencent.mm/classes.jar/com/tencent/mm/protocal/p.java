package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.c;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
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
    public String FGD;
    public byte[] FGE;
    public int dEu;
    public int dto;
    public int iqb;
    
    public a()
    {
      AppMethodBeat.i(32087);
      this.dto = 0;
      this.dEu = 0;
      this.iqb = 0;
      this.FGD = "";
      this.FGE = new byte[0];
      AppMethodBeat.o(32087);
    }
    
    private byte[] cq(byte[] paramArrayOfByte)
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
        localDataOutputStream.writeByte(this.dto);
        localDataOutputStream.writeByte(this.dEu);
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
          ae.e("MicroMsg.MMDirectSend", "direct merge all failed, err=" + paramArrayOfByte.getMessage());
        }
      }
    }
    
    private byte[] fkl()
    {
      AppMethodBeat.i(32088);
      Object localObject = new ByteArrayOutputStream();
      try
      {
        DataOutputStream localDataOutputStream = new DataOutputStream((OutputStream)localObject);
        localDataOutputStream.writeInt(this.iqb);
        localDataOutputStream.writeShort(this.FGD.getBytes().length);
        localDataOutputStream.write(this.FGD.getBytes());
        localDataOutputStream.writeShort(this.FGE.length);
        localDataOutputStream.write(this.FGE);
        localDataOutputStream.close();
        localObject = ((ByteArrayOutputStream)localObject).toByteArray();
        AppMethodBeat.o(32088);
        return localObject;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          ae.e("MicroMsg.MMDirectSend", "direct merge tail failed, err=" + localIOException.getMessage());
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
      byte[] arrayOfByte = fkl();
      PByteArray localPByteArray = new PByteArray();
      c.a(localPByteArray, arrayOfByte, p.aPB(super.getDeviceID()));
      arrayOfByte = cq(localPByteArray.value);
      AppMethodBeat.o(32090);
      return arrayOfByte;
    }
  }
  
  public static final class b
    extends l.e
    implements l.c
  {
    public byte[] content;
    private int dEu;
    public String deviceID;
    private int dto;
    public String inW;
    private int iqb;
    
    public b()
    {
      AppMethodBeat.i(32091);
      this.inW = "";
      this.content = new byte[0];
      this.deviceID = "";
      this.dto = 0;
      this.dEu = 0;
      this.iqb = 0;
      this.inW = "";
      this.content = new byte[0];
      AppMethodBeat.o(32091);
    }
    
    private byte[] cr(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(32092);
      if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 2))
      {
        ae.e("MicroMsg.MMDirectSend", "parse all failed, empty buf");
        AppMethodBeat.o(32092);
        return null;
      }
      byte[] arrayOfByte = new byte[paramArrayOfByte.length - 2];
      try
      {
        paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
        DataInputStream localDataInputStream = new DataInputStream(paramArrayOfByte);
        this.dto = localDataInputStream.readByte();
        this.dEu = localDataInputStream.readByte();
        localDataInputStream.readFully(arrayOfByte);
        ae.d("MicroMsg.MMDirectSend", "cmdId:" + this.dto + ", flag=" + this.dEu + ", tail len=" + arrayOfByte.length);
        paramArrayOfByte.close();
        AppMethodBeat.o(32092);
        return arrayOfByte;
      }
      catch (IOException paramArrayOfByte)
      {
        for (;;)
        {
          ae.e("MicroMsg.MMDirectSend", "direct parse all failed, err=" + paramArrayOfByte.getMessage());
        }
      }
    }
    
    public final int fromProtoBuf(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(32093);
      byte[] arrayOfByte1 = p.aPB(this.deviceID);
      PByteArray localPByteArray = new PByteArray();
      int i;
      if (c.b(localPByteArray, cr(paramArrayOfByte), arrayOfByte1) != 0)
      {
        byte[] arrayOfByte2 = new byte[16];
        i = 0;
        while (i < 16)
        {
          arrayOfByte2[i] = 0;
          i += 1;
        }
        if (c.b(localPByteArray, cr(paramArrayOfByte), arrayOfByte2) != 0)
        {
          ae.e("MicroMsg.MMDirectSend", "decrypting from buffer using key=%s error", new Object[] { bu.cE(arrayOfByte1) });
          AppMethodBeat.o(32093);
          return -1;
        }
      }
      paramArrayOfByte = localPByteArray.value;
      if (paramArrayOfByte == null) {
        ae.e("MicroMsg.MMDirectSend", "parse tail failed, empty buf");
      }
      for (;;)
      {
        AppMethodBeat.o(32093);
        return 0;
        try
        {
          paramArrayOfByte = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte));
          this.iqb = paramArrayOfByte.readInt();
          ae.d("MicroMsg.MMDirectSend", "seq=" + this.iqb);
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
          ae.e("MicroMsg.MMDirectSend", "direct parse all failed, err=" + paramArrayOfByte.getMessage());
        }
        continue;
        label232:
        arrayOfByte1 = new byte[i];
        paramArrayOfByte.readFully(arrayOfByte1);
        this.inW = new String(arrayOfByte1);
        ae.d("MicroMsg.MMDirectSend", "recievers len=" + i + ", sender=" + this.inW);
        i = paramArrayOfByte.readShort();
        if (i < 0)
        {
          paramArrayOfByte = new IOException("content empty");
          AppMethodBeat.o(32093);
          throw paramArrayOfByte;
        }
        this.content = new byte[i];
        paramArrayOfByte.readFully(this.content);
        ae.d("MicroMsg.MMDirectSend", "content len=" + this.content.length);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.p
 * JD-Core Version:    0.7.0.1
 */