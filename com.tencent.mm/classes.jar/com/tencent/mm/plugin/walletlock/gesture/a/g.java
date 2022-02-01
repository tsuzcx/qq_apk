package com.tencent.mm.plugin.walletlock.gesture.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class g
{
  public long ABS = -1L;
  public long ABT = 0L;
  
  public final g bU(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(129790);
    paramArrayOfByte = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte));
    try
    {
      this.ABS = paramArrayOfByte.readLong();
      this.ABT = paramArrayOfByte.readLong();
      paramArrayOfByte.close();
      AppMethodBeat.o(129790);
      return this;
    }
    catch (IOException paramArrayOfByte)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.TimeInfo", paramArrayOfByte, "", new Object[0]);
      }
    }
  }
  
  public final byte[] toByteArray()
  {
    AppMethodBeat.i(129789);
    Object localObject = new ByteArrayOutputStream();
    DataOutputStream localDataOutputStream = new DataOutputStream((OutputStream)localObject);
    try
    {
      localDataOutputStream.writeLong(this.ABS);
      localDataOutputStream.writeLong(this.ABT);
      localDataOutputStream.close();
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      AppMethodBeat.o(129789);
      return localObject;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.TimeInfo", localIOException, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.a.g
 * JD-Core Version:    0.7.0.1
 */