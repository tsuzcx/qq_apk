package com.tencent.mm.plugin.wear.model.e;

import com.tencent.mm.sdk.platformtools.ab;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public abstract class a
{
  protected boolean IS(int paramInt)
  {
    return false;
  }
  
  protected boolean IT(int paramInt)
  {
    return false;
  }
  
  public boolean IU(int paramInt)
  {
    return false;
  }
  
  public abstract List<Integer> cYL();
  
  public boolean cYM()
  {
    return true;
  }
  
  public final void d(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    Object localObject = paramArrayOfByte;
    if (IT(paramInt3))
    {
      localObject = paramArrayOfByte;
      if (paramArrayOfByte != null)
      {
        paramArrayOfByte = com.tencent.mm.plugin.wear.model.a.cYy().uGC.bE(paramArrayOfByte);
        localObject = paramArrayOfByte;
        if (paramArrayOfByte == null) {
          ab.e("MicroMsg.Wear.BaseHttpServer", "request data decrypt error");
        }
      }
    }
    do
    {
      return;
      localObject = q(paramInt3, (byte[])localObject);
    } while (!cYM());
    paramArrayOfByte = (byte[])localObject;
    if (IS(paramInt3)) {
      paramArrayOfByte = com.tencent.mm.plugin.wear.model.a.cYy().uGC.bF((byte[])localObject);
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
          ab.i("MicroMsg.Wear.BaseHttpServer", "send data funId=%d length=%d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramArrayOfByte.length) });
          if (IU(paramInt3)) {
            break;
          }
          com.tencent.mm.plugin.wear.model.a.cYy().uGC.bD(paramArrayOfByte);
          return;
        }
      }
      catch (IOException paramArrayOfByte)
      {
        ab.printErrStackTrace("MicroMsg.Wear.BaseHttpServer", paramArrayOfByte, "gen response data error connectType=%d, sessionId=%d, funId=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
        return;
      }
      localDataOutputStream.writeInt(0);
    }
    com.tencent.mm.sdk.g.d.post(new a.1(this, paramArrayOfByte), "WearSendResponseTask");
  }
  
  protected abstract byte[] q(int paramInt, byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.a
 * JD-Core Version:    0.7.0.1
 */