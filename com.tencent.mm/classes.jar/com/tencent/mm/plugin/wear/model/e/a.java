package com.tencent.mm.plugin.wear.model.e;

import com.tencent.mm.plugin.wear.model.d;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.y;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public abstract class a
{
  protected boolean Bg(int paramInt)
  {
    return false;
  }
  
  protected boolean Bh(int paramInt)
  {
    return false;
  }
  
  public boolean Bi(int paramInt)
  {
    return false;
  }
  
  public final void b(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    Object localObject = paramArrayOfByte;
    if (Bh(paramInt3))
    {
      localObject = paramArrayOfByte;
      if (paramArrayOfByte != null)
      {
        paramArrayOfByte = com.tencent.mm.plugin.wear.model.a.bYL().qRu.bd(paramArrayOfByte);
        localObject = paramArrayOfByte;
        if (paramArrayOfByte == null) {
          y.e("MicroMsg.Wear.BaseHttpServer", "request data decrypt error");
        }
      }
    }
    do
    {
      return;
      localObject = p(paramInt3, (byte[])localObject);
    } while (!bYZ());
    paramArrayOfByte = (byte[])localObject;
    if (Bg(paramInt3)) {
      paramArrayOfByte = com.tencent.mm.plugin.wear.model.a.bYL().qRu.be((byte[])localObject);
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
          y.i("MicroMsg.Wear.BaseHttpServer", "send data funId=%d length=%d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramArrayOfByte.length) });
          if (Bi(paramInt3)) {
            break;
          }
          com.tencent.mm.plugin.wear.model.a.bYL().qRu.bc(paramArrayOfByte);
          return;
        }
      }
      catch (IOException paramArrayOfByte)
      {
        y.printErrStackTrace("MicroMsg.Wear.BaseHttpServer", paramArrayOfByte, "gen response data error connectType=%d, sessionId=%d, funId=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
        return;
      }
      localDataOutputStream.writeInt(0);
    }
    e.post(new a.1(this, paramArrayOfByte), "WearSendResponseTask");
  }
  
  public abstract List<Integer> bYY();
  
  public boolean bYZ()
  {
    return true;
  }
  
  protected abstract byte[] p(int paramInt, byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.a
 * JD-Core Version:    0.7.0.1
 */