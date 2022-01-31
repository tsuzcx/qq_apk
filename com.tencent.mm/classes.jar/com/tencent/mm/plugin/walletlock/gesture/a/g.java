package com.tencent.mm.plugin.walletlock.gesture.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class g
{
  public long uEM = -1L;
  public long uEN = 0L;
  
  public final g bC(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(51585);
    paramArrayOfByte = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte));
    try
    {
      this.uEM = paramArrayOfByte.readLong();
      this.uEN = paramArrayOfByte.readLong();
      paramArrayOfByte.close();
      AppMethodBeat.o(51585);
      return this;
    }
    catch (IOException paramArrayOfByte)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.TimeInfo", paramArrayOfByte, "", new Object[0]);
      }
    }
  }
  
  public final byte[] toByteArray()
  {
    AppMethodBeat.i(51584);
    Object localObject = new ByteArrayOutputStream();
    DataOutputStream localDataOutputStream = new DataOutputStream((OutputStream)localObject);
    try
    {
      localDataOutputStream.writeLong(this.uEM);
      localDataOutputStream.writeLong(this.uEN);
      localDataOutputStream.close();
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      AppMethodBeat.o(51584);
      return localObject;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.TimeInfo", localIOException, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.a.g
 * JD-Core Version:    0.7.0.1
 */