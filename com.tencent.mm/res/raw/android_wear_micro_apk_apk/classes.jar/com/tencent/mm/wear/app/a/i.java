package com.tencent.mm.wear.app.a;

import com.tencent.mm.b.a.f;
import com.tencent.mm.c.a.a.b;
import com.tencent.mm.sdk.a.e;
import com.tencent.mm.wear.app.MMApplication;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.atomic.AtomicInteger;

public final class i
{
  private static AtomicInteger aaM = new AtomicInteger();
  private e aaE = new e() {};
  private int aaN;
  private k aaP;
  private c aay;
  
  public i(c paramc)
  {
    this.aay = paramc;
    this.aaN = aaM.incrementAndGet();
    com.tencent.mm.sdk.a.a.WJ.a(this.aaE);
  }
  
  public final void a(k paramk)
  {
    this.aaP = paramk;
  }
  
  public final void i(byte[] paramArrayOfByte)
  {
    Object localObject;
    try
    {
      localObject = new ByteArrayOutputStream();
      localDataOutputStream = new DataOutputStream((OutputStream)localObject);
      localDataOutputStream.writeInt(2);
      localDataOutputStream.writeInt(this.aaN);
      localDataOutputStream.writeInt(30001);
      if (paramArrayOfByte == null) {
        break label83;
      }
      localDataOutputStream.writeInt(paramArrayOfByte.length);
      localDataOutputStream.write(paramArrayOfByte);
      paramArrayOfByte = ((ByteArrayOutputStream)localObject).toByteArray();
    }
    catch (IOException paramArrayOfByte)
    {
      for (;;)
      {
        DataOutputStream localDataOutputStream;
        label83:
        com.tencent.mm.wear.a.c.d.a("MicroMsg.WearHttpClient", paramArrayOfByte);
        paramArrayOfByte = null;
      }
      MMApplication.getContext();
      localObject = b.A("wear");
      com.tencent.mm.wear.a.c.d.c("MicroMsg.WearHttpClient", "send data length = %d", new Object[] { Integer.valueOf(paramArrayOfByte.length) });
      if (paramArrayOfByte.length >= 92160) {
        break label180;
      }
    }
    if (paramArrayOfByte == null) {
      com.tencent.mm.wear.a.b.a.aiT.post(new j(this, 65536, 30001, null));
    }
    for (;;)
    {
      return;
      localDataOutputStream.writeInt(0);
      break;
      label180:
      for (paramArrayOfByte = this.aay.a((String)localObject, paramArrayOfByte); paramArrayOfByte.aaw != 0; paramArrayOfByte = this.aay.b((String)localObject, paramArrayOfByte))
      {
        com.tencent.mm.wear.a.b.a.aiT.post(new j(this, 65536, 30001, null));
        return;
      }
    }
  }
  
  public final void stop()
  {
    com.tencent.mm.sdk.a.a.WJ.b(this.aaE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.a.i
 * JD-Core Version:    0.7.0.1
 */