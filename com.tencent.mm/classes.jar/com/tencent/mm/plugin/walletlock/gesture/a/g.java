package com.tencent.mm.plugin.walletlock.gesture.a;

import com.tencent.mm.sdk.platformtools.y;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public final class g
{
  public long qPE = -1L;
  public long qPF = 0L;
  
  public final g bb(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte));
    try
    {
      this.qPE = paramArrayOfByte.readLong();
      this.qPF = paramArrayOfByte.readLong();
      paramArrayOfByte.close();
      return this;
    }
    catch (IOException paramArrayOfByte)
    {
      y.printErrStackTrace("MicroMsg.TimeInfo", paramArrayOfByte, "", new Object[0]);
    }
    return this;
  }
  
  public final byte[] toByteArray()
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    DataOutputStream localDataOutputStream = new DataOutputStream(localByteArrayOutputStream);
    try
    {
      localDataOutputStream.writeLong(this.qPE);
      localDataOutputStream.writeLong(this.qPF);
      localDataOutputStream.close();
      return localByteArrayOutputStream.toByteArray();
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.TimeInfo", localIOException, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.a.g
 * JD-Core Version:    0.7.0.1
 */