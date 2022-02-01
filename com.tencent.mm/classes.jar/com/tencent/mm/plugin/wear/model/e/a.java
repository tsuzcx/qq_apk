package com.tencent.mm.plugin.wear.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wear.model.d;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ae;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public abstract class a
{
  protected boolean WA(int paramInt)
  {
    return false;
  }
  
  protected boolean WB(int paramInt)
  {
    return false;
  }
  
  public boolean WC(int paramInt)
  {
    return false;
  }
  
  public final void c(int paramInt1, int paramInt2, int paramInt3, final byte[] paramArrayOfByte)
  {
    Object localObject = paramArrayOfByte;
    if (WB(paramInt3))
    {
      localObject = paramArrayOfByte;
      if (paramArrayOfByte != null)
      {
        paramArrayOfByte = com.tencent.mm.plugin.wear.model.a.eOd().cf(paramArrayOfByte);
        localObject = paramArrayOfByte;
        if (paramArrayOfByte == null) {
          ae.e("MicroMsg.Wear.BaseHttpServer", "request data decrypt error");
        }
      }
    }
    do
    {
      return;
      localObject = s(paramInt3, (byte[])localObject);
    } while (!eOw());
    paramArrayOfByte = (byte[])localObject;
    if (WA(paramInt3)) {
      paramArrayOfByte = com.tencent.mm.plugin.wear.model.a.eOd().cg((byte[])localObject);
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
          ae.i("MicroMsg.Wear.BaseHttpServer", "send data funId=%d length=%d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramArrayOfByte.length) });
          if (WC(paramInt3)) {
            break;
          }
          com.tencent.mm.plugin.wear.model.a.eOd().ce(paramArrayOfByte);
          return;
        }
      }
      catch (IOException paramArrayOfByte)
      {
        ae.printErrStackTrace("MicroMsg.Wear.BaseHttpServer", paramArrayOfByte, "gen response data error connectType=%d, sessionId=%d, funId=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
        return;
      }
      localDataOutputStream.writeInt(0);
    }
    b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(30066);
        com.tencent.mm.plugin.wear.model.a.eOd().ce(paramArrayOfByte);
        AppMethodBeat.o(30066);
      }
    }, "WearSendResponseTask");
  }
  
  public abstract List<Integer> eOv();
  
  public boolean eOw()
  {
    return true;
  }
  
  protected abstract byte[] s(int paramInt, byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.a
 * JD-Core Version:    0.7.0.1
 */