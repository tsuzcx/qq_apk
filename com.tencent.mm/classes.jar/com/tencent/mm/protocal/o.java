package com.tencent.mm.protocal;

import com.tencent.mm.a.c;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.sdk.platformtools.y;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public final class o
{
  public static final class a
    extends k.d
    implements k.b
  {
    public int bNb = 0;
    public int bcw = 0;
    public int eAK = 0;
    public String spY = "";
    public byte[] spZ = new byte[0];
    
    private byte[] bo(byte[] paramArrayOfByte)
    {
      if (paramArrayOfByte == null) {
        return null;
      }
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      try
      {
        DataOutputStream localDataOutputStream = new DataOutputStream(localByteArrayOutputStream);
        localDataOutputStream.writeByte(this.bNb);
        localDataOutputStream.writeByte(this.bcw);
        localDataOutputStream.write(paramArrayOfByte);
        localDataOutputStream.close();
        return localByteArrayOutputStream.toByteArray();
      }
      catch (IOException paramArrayOfByte)
      {
        for (;;)
        {
          y.e("MicroMsg.MMDirectSend", "direct merge all failed, err=" + paramArrayOfByte.getMessage());
        }
      }
    }
    
    private byte[] cpf()
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      try
      {
        DataOutputStream localDataOutputStream = new DataOutputStream(localByteArrayOutputStream);
        localDataOutputStream.writeInt(this.eAK);
        localDataOutputStream.writeShort(this.spY.getBytes().length);
        localDataOutputStream.write(this.spY.getBytes());
        localDataOutputStream.writeShort(this.spZ.length);
        localDataOutputStream.write(this.spZ);
        localDataOutputStream.close();
        return localByteArrayOutputStream.toByteArray();
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          y.e("MicroMsg.MMDirectSend", "direct merge tail failed, err=" + localIOException.getMessage());
        }
      }
    }
    
    public final byte[] HG()
    {
      byte[] arrayOfByte = cpf();
      PByteArray localPByteArray = new PByteArray();
      c.a(localPByteArray, arrayOfByte, o.Xt(this.spH));
      return bo(localPByteArray.value);
    }
    
    public final int HH()
    {
      return 10;
    }
    
    public final boolean Lb()
    {
      return false;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.o
 * JD-Core Version:    0.7.0.1
 */