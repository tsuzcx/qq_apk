package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.c;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
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
    public String KzO;
    public byte[] KzP;
    public int cSx;
    public int dKy;
    public int jlm;
    
    public a()
    {
      AppMethodBeat.i(32087);
      this.dKy = 0;
      this.cSx = 0;
      this.jlm = 0;
      this.KzO = "";
      this.KzP = new byte[0];
      AppMethodBeat.o(32087);
    }
    
    private byte[] cH(byte[] paramArrayOfByte)
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
        localDataOutputStream.writeByte(this.dKy);
        localDataOutputStream.writeByte(this.cSx);
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
    
    private byte[] gtO()
    {
      AppMethodBeat.i(32088);
      Object localObject = new ByteArrayOutputStream();
      try
      {
        DataOutputStream localDataOutputStream = new DataOutputStream((OutputStream)localObject);
        localDataOutputStream.writeInt(this.jlm);
        localDataOutputStream.writeShort(this.KzO.getBytes().length);
        localDataOutputStream.write(this.KzO.getBytes());
        localDataOutputStream.writeShort(this.KzP.length);
        localDataOutputStream.write(this.KzP);
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
      byte[] arrayOfByte = gtO();
      PByteArray localPByteArray = new PByteArray();
      c.a(localPByteArray, arrayOfByte, p.bge(super.getDeviceID()));
      arrayOfByte = cH(localPByteArray.value);
      AppMethodBeat.o(32090);
      return arrayOfByte;
    }
  }
  
  public static final class b
    extends l.e
    implements l.c
  {
    private int cSx;
    public byte[] content;
    private int dKy;
    public String deviceID;
    public String jje;
    private int jlm;
    
    public b()
    {
      AppMethodBeat.i(32091);
      this.jje = "";
      this.content = new byte[0];
      this.deviceID = "";
      this.dKy = 0;
      this.cSx = 0;
      this.jlm = 0;
      this.jje = "";
      this.content = new byte[0];
      AppMethodBeat.o(32091);
    }
    
    private byte[] cI(byte[] paramArrayOfByte)
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
        this.dKy = localDataInputStream.readByte();
        this.cSx = localDataInputStream.readByte();
        localDataInputStream.readFully(arrayOfByte);
        Log.d("MicroMsg.MMDirectSend", "cmdId:" + this.dKy + ", flag=" + this.cSx + ", tail len=" + arrayOfByte.length);
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
      byte[] arrayOfByte1 = p.bge(this.deviceID);
      PByteArray localPByteArray = new PByteArray();
      int i;
      if (c.b(localPByteArray, cI(paramArrayOfByte), arrayOfByte1) != 0)
      {
        byte[] arrayOfByte2 = new byte[16];
        i = 0;
        while (i < 16)
        {
          arrayOfByte2[i] = 0;
          i += 1;
        }
        if (c.b(localPByteArray, cI(paramArrayOfByte), arrayOfByte2) != 0)
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
          this.jlm = paramArrayOfByte.readInt();
          Log.d("MicroMsg.MMDirectSend", "seq=" + this.jlm);
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
        this.jje = new String(arrayOfByte1);
        Log.d("MicroMsg.MMDirectSend", "recievers len=" + i + ", sender=" + this.jje);
        i = paramArrayOfByte.readShort();
        if (i < 0)
        {
          paramArrayOfByte = new IOException("content empty");
          AppMethodBeat.o(32093);
          throw paramArrayOfByte;
        }
        this.content = new byte[i];
        paramArrayOfByte.readFully(this.content);
        Log.d("MicroMsg.MMDirectSend", "content len=" + this.content.length);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.p
 * JD-Core Version:    0.7.0.1
 */