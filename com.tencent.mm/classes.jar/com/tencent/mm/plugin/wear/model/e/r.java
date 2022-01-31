package com.tencent.mm.plugin.wear.model.e;

import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.d;
import com.tencent.mm.sdk.platformtools.y;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public final class r
{
  private static AtomicInteger qSN = new AtomicInteger();
  
  public static void b(int paramInt, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramBoolean) {
      arrayOfByte = a.bYL().qRu.be(paramArrayOfByte);
    }
    int i = qSN.incrementAndGet();
    paramArrayOfByte = new ByteArrayOutputStream();
    DataOutputStream localDataOutputStream = new DataOutputStream(paramArrayOfByte);
    try
    {
      localDataOutputStream.writeInt(0);
      localDataOutputStream.writeInt(i);
      localDataOutputStream.writeInt(paramInt);
      if ((arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        localDataOutputStream.writeInt(arrayOfByte.length);
        localDataOutputStream.write(arrayOfByte);
      }
      for (;;)
      {
        a.bYL().qRu.bc(paramArrayOfByte.toByteArray());
        return;
        localDataOutputStream.writeInt(0);
      }
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      y.printErrStackTrace("MicroMsg.Wear.WearPushServerLogic", paramArrayOfByte, "gen response data error connectType=%d, sessionId=%d, funId=%d", new Object[] { Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(paramInt) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.r
 * JD-Core Version:    0.7.0.1
 */