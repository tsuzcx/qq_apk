package com.tencent.mm.plugin.wear.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.d;
import com.tencent.mm.sdk.platformtools.ae;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public final class r
{
  private static AtomicInteger DPr;
  
  static
  {
    AppMethodBeat.i(30112);
    DPr = new AtomicInteger();
    AppMethodBeat.o(30112);
  }
  
  public static void a(int paramInt, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(30111);
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramBoolean) {
      arrayOfByte = a.eOd().cg(paramArrayOfByte);
    }
    int i = DPr.incrementAndGet();
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
        a.eOd().ce(paramArrayOfByte.toByteArray());
        AppMethodBeat.o(30111);
        return;
        localDataOutputStream.writeInt(0);
      }
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      ae.printErrStackTrace("MicroMsg.Wear.WearPushServerLogic", paramArrayOfByte, "gen response data error connectType=%d, sessionId=%d, funId=%d", new Object[] { Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(paramInt) });
      AppMethodBeat.o(30111);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.r
 * JD-Core Version:    0.7.0.1
 */