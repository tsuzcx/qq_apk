package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.z.a.a;
import com.tencent.mm.plugin.z.a.a.a;
import com.tencent.mm.protocal.c.bqc;
import com.tencent.mm.protocal.c.bqd;
import com.tencent.mm.sdk.platformtools.y;

public final class ak
  extends x
{
  private int cmdId;
  private String rUW;
  
  public ak(String paramString1, String paramString2)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bqc();
    ((b.a)localObject).ecI = new bqd();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/setappsetting";
    ((b.a)localObject).ecG = 396;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.jvQ = ((b.a)localObject).Kt();
    localObject = (bqc)this.jvQ.ecE.ecN;
    ((bqc)localObject).kRX = paramString1;
    ((bqc)localObject).tHA = 0;
    ((bqc)localObject).tHB = paramString2;
    this.cmdId = 0;
    this.rUW = paramString2;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneSetAppSetting", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 == 0) && (paramInt2 == 0))
    {
      paramString = (bqd)this.jvQ.ecF.ecN;
      if (paramString != null)
      {
        paramq = a.a.bru().brs();
        paramArrayOfByte = g.by(paramString.kRX, false);
        if (paramArrayOfByte != null)
        {
          paramArrayOfByte.field_authFlag = paramString.sxz;
          boolean bool = paramq.a(paramArrayOfByte, new String[0]);
          y.d("MicroMsg.NetSceneSetAppSetting", "onGYNetEnd, update ret = " + bool + ", appId = " + paramString.kRX);
        }
      }
    }
  }
  
  public final void bi(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      y.e("MicroMsg.NetSceneSetAppSetting", "buf is null");
      return;
    }
    try
    {
      this.jvQ.ecF.A(paramArrayOfByte);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      y.e("MicroMsg.NetSceneSetAppSetting", "parse error: " + paramArrayOfByte.getMessage());
      y.printErrStackTrace("MicroMsg.NetSceneSetAppSetting", paramArrayOfByte, "", new Object[0]);
    }
  }
  
  public final byte[] ckB()
  {
    try
    {
      byte[] arrayOfByte = ((b.b)this.jvQ.Kv()).HG();
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.NetSceneSetAppSetting", "toProtBuf failed: " + localException.getMessage());
    }
    return null;
  }
  
  public final int getType()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ak
 * JD-Core Version:    0.7.0.1
 */