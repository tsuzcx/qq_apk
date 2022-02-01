package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.c;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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
    public String DIY;
    public byte[] DIZ;
    public int dgL;
    public int drx;
    public int hTM;
    
    public a()
    {
      AppMethodBeat.i(32087);
      this.dgL = 0;
      this.drx = 0;
      this.hTM = 0;
      this.DIY = "";
      this.DIZ = new byte[0];
      AppMethodBeat.o(32087);
    }
    
    private byte[] cg(byte[] paramArrayOfByte)
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
        localDataOutputStream.writeByte(this.dgL);
        localDataOutputStream.writeByte(this.drx);
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
          ac.e("MicroMsg.MMDirectSend", "direct merge all failed, err=" + paramArrayOfByte.getMessage());
        }
      }
    }
    
    private byte[] eRr()
    {
      AppMethodBeat.i(32088);
      Object localObject = new ByteArrayOutputStream();
      try
      {
        DataOutputStream localDataOutputStream = new DataOutputStream((OutputStream)localObject);
        localDataOutputStream.writeInt(this.hTM);
        localDataOutputStream.writeShort(this.DIY.getBytes().length);
        localDataOutputStream.write(this.DIY.getBytes());
        localDataOutputStream.writeShort(this.DIZ.length);
        localDataOutputStream.write(this.DIZ);
        localDataOutputStream.close();
        localObject = ((ByteArrayOutputStream)localObject).toByteArray();
        AppMethodBeat.o(32088);
        return localObject;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          ac.e("MicroMsg.MMDirectSend", "direct merge tail failed, err=" + localIOException.getMessage());
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
      byte[] arrayOfByte = eRr();
      PByteArray localPByteArray = new PByteArray();
      c.a(localPByteArray, arrayOfByte, p.aIB(super.getDeviceID()));
      arrayOfByte = cg(localPByteArray.value);
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
    private int dgL;
    private int drx;
    public String hRP;
    private int hTM;
    
    public b()
    {
      AppMethodBeat.i(32091);
      this.hRP = "";
      this.content = new byte[0];
      this.deviceID = "";
      this.dgL = 0;
      this.drx = 0;
      this.hTM = 0;
      this.hRP = "";
      this.content = new byte[0];
      AppMethodBeat.o(32091);
    }
    
    private byte[] ch(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(32092);
      if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 2))
      {
        ac.e("MicroMsg.MMDirectSend", "parse all failed, empty buf");
        AppMethodBeat.o(32092);
        return null;
      }
      byte[] arrayOfByte = new byte[paramArrayOfByte.length - 2];
      try
      {
        paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
        DataInputStream localDataInputStream = new DataInputStream(paramArrayOfByte);
        this.dgL = localDataInputStream.readByte();
        this.drx = localDataInputStream.readByte();
        localDataInputStream.readFully(arrayOfByte);
        ac.d("MicroMsg.MMDirectSend", "cmdId:" + this.dgL + ", flag=" + this.drx + ", tail len=" + arrayOfByte.length);
        paramArrayOfByte.close();
        AppMethodBeat.o(32092);
        return arrayOfByte;
      }
      catch (IOException paramArrayOfByte)
      {
        for (;;)
        {
          ac.e("MicroMsg.MMDirectSend", "direct parse all failed, err=" + paramArrayOfByte.getMessage());
        }
      }
    }
    
    public final int fromProtoBuf(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(32093);
      byte[] arrayOfByte1 = p.aIB(this.deviceID);
      PByteArray localPByteArray = new PByteArray();
      int i;
      if (c.b(localPByteArray, ch(paramArrayOfByte), arrayOfByte1) != 0)
      {
        byte[] arrayOfByte2 = new byte[16];
        i = 0;
        while (i < 16)
        {
          arrayOfByte2[i] = 0;
          i += 1;
        }
        if (c.b(localPByteArray, ch(paramArrayOfByte), arrayOfByte2) != 0)
        {
          ac.e("MicroMsg.MMDirectSend", "decrypting from buffer using key=%s error", new Object[] { bs.cu(arrayOfByte1) });
          AppMethodBeat.o(32093);
          return -1;
        }
      }
      paramArrayOfByte = localPByteArray.value;
      if (paramArrayOfByte == null) {
        ac.e("MicroMsg.MMDirectSend", "parse tail failed, empty buf");
      }
      for (;;)
      {
        AppMethodBeat.o(32093);
        return 0;
        try
        {
          paramArrayOfByte = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte));
          this.hTM = paramArrayOfByte.readInt();
          ac.d("MicroMsg.MMDirectSend", "seq=" + this.hTM);
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
          ac.e("MicroMsg.MMDirectSend", "direct parse all failed, err=" + paramArrayOfByte.getMessage());
        }
        continue;
        label232:
        arrayOfByte1 = new byte[i];
        paramArrayOfByte.readFully(arrayOfByte1);
        this.hRP = new String(arrayOfByte1);
        ac.d("MicroMsg.MMDirectSend", "recievers len=" + i + ", sender=" + this.hRP);
        i = paramArrayOfByte.readShort();
        if (i < 0)
        {
          paramArrayOfByte = new IOException("content empty");
          AppMethodBeat.o(32093);
          throw paramArrayOfByte;
        }
        this.content = new byte[i];
        paramArrayOfByte.readFully(this.content);
        ac.d("MicroMsg.MMDirectSend", "content len=" + this.content.length);
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