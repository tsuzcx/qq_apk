package com.tencent.mm.plugin.wear.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public final class r
{
  private static AtomicInteger Wjx;
  
  static
  {
    AppMethodBeat.i(30112);
    Wjx = new AtomicInteger();
    AppMethodBeat.o(30112);
  }
  
  public static void a(int paramInt, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(30111);
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramBoolean) {
      arrayOfByte = a.inI().cR(paramArrayOfByte);
    }
    int i = Wjx.incrementAndGet();
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
        a.inI().cP(paramArrayOfByte.toByteArray());
        AppMethodBeat.o(30111);
        return;
        localDataOutputStream.writeInt(0);
      }
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      Log.printErrStackTrace("MicroMsg.Wear.WearPushServerLogic", paramArrayOfByte, "gen response data error connectType=%d, sessionId=%d, funId=%d", new Object[] { Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(paramInt) });
      AppMethodBeat.o(30111);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.r
 * JD-Core Version:    0.7.0.1
 */