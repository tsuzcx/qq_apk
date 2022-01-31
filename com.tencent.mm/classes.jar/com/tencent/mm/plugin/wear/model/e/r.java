package com.tencent.mm.plugin.wear.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public final class r
{
  private static AtomicInteger uHU;
  
  static
  {
    AppMethodBeat.i(26430);
    uHU = new AtomicInteger();
    AppMethodBeat.o(26430);
  }
  
  public static void a(int paramInt, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(26429);
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramBoolean) {
      arrayOfByte = a.cYy().uGC.bF(paramArrayOfByte);
    }
    int i = uHU.incrementAndGet();
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
        a.cYy().uGC.bD(paramArrayOfByte.toByteArray());
        AppMethodBeat.o(26429);
        return;
        localDataOutputStream.writeInt(0);
      }
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      ab.printErrStackTrace("MicroMsg.Wear.WearPushServerLogic", paramArrayOfByte, "gen response data error connectType=%d, sessionId=%d, funId=%d", new Object[] { Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(paramInt) });
      AppMethodBeat.o(26429);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.r
 * JD-Core Version:    0.7.0.1
 */