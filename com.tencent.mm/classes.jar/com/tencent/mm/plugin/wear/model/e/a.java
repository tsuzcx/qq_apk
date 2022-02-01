package com.tencent.mm.plugin.wear.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wear.model.d;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public abstract class a
{
  protected boolean RR(int paramInt)
  {
    return false;
  }
  
  protected boolean RS(int paramInt)
  {
    return false;
  }
  
  public boolean RT(int paramInt)
  {
    return false;
  }
  
  public final void c(int paramInt1, int paramInt2, int paramInt3, final byte[] paramArrayOfByte)
  {
    Object localObject = paramArrayOfByte;
    if (RS(paramInt3))
    {
      localObject = paramArrayOfByte;
      if (paramArrayOfByte != null)
      {
        paramArrayOfByte = com.tencent.mm.plugin.wear.model.a.egV().bW(paramArrayOfByte);
        localObject = paramArrayOfByte;
        if (paramArrayOfByte == null) {
          ad.e("MicroMsg.Wear.BaseHttpServer", "request data decrypt error");
        }
      }
    }
    do
    {
      return;
      localObject = s(paramInt3, (byte[])localObject);
    } while (!eho());
    paramArrayOfByte = (byte[])localObject;
    if (RR(paramInt3)) {
      paramArrayOfByte = com.tencent.mm.plugin.wear.model.a.egV().bX((byte[])localObject);
    }
    localObject = new ByteArrayOutputStream();
    DataOutputStream localDataOutputStream = new DataOutputStream((OutputStream)localObject);
    for (;;)
    {
      try
      {
        localDataOutputStream.writeInt(paramInt1);
        localDataOutputStream.writeInt(paramInt2);
        localDataOutputStream.writeInt(paramInt3);
        if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
        {
          localDataOutputStream.writeInt(paramArrayOfByte.length);
          localDataOutputStream.write(paramArrayOfByte);
          paramArrayOfByte = ((ByteArrayOutputStream)localObject).toByteArray();
          ad.i("MicroMsg.Wear.BaseHttpServer", "send data funId=%d length=%d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramArrayOfByte.length) });
          if (RT(paramInt3)) {
            break;
          }
          com.tencent.mm.plugin.wear.model.a.egV().bV(paramArrayOfByte);
          return;
        }
      }
      catch (IOException paramArrayOfByte)
      {
        ad.printErrStackTrace("MicroMsg.Wear.BaseHttpServer", paramArrayOfByte, "gen response data error connectType=%d, sessionId=%d, funId=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
        return;
      }
      localDataOutputStream.writeInt(0);
    }
    b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(30066);
        com.tencent.mm.plugin.wear.model.a.egV().bV(paramArrayOfByte);
        AppMethodBeat.o(30066);
      }
    }, "WearSendResponseTask");
  }
  
  public abstract List<Integer> ehn();
  
  public boolean eho()
  {
    return true;
  }
  
  protected abstract byte[] s(int paramInt, byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.a
 * JD-Core Version:    0.7.0.1
 */