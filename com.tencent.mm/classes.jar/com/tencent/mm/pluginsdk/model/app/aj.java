package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.s.a.a;
import com.tencent.mm.plugin.s.a.a.a;
import com.tencent.mm.protocal.protobuf.cra;
import com.tencent.mm.protocal.protobuf.crb;
import com.tencent.mm.sdk.platformtools.ad;

public final class aj
  extends aa
{
  private String BQv;
  private int cmdId;
  
  public aj(String paramString1, String paramString2)
  {
    AppMethodBeat.i(31060);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new cra();
    ((b.a)localObject).gUV = new crb();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/setappsetting";
    ((b.a)localObject).funcId = 396;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.fUF = ((b.a)localObject).atI();
    localObject = (cra)this.fUF.gUS.gUX;
    ((cra)localObject).fVC = paramString1;
    ((cra)localObject).EjO = 0;
    ((cra)localObject).EjP = paramString2;
    this.cmdId = 0;
    this.BQv = paramString2;
    AppMethodBeat.o(31060);
  }
  
  public final void cb(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(31063);
    if (paramArrayOfByte == null)
    {
      ad.e("MicroMsg.NetSceneSetAppSetting", "buf is null");
      AppMethodBeat.o(31063);
      return;
    }
    try
    {
      this.fUF.gUT.fromProtoBuf(paramArrayOfByte);
      AppMethodBeat.o(31063);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      ad.e("MicroMsg.NetSceneSetAppSetting", "parse error: " + paramArrayOfByte.getMessage());
      ad.printErrStackTrace("MicroMsg.NetSceneSetAppSetting", paramArrayOfByte, "", new Object[0]);
      AppMethodBeat.o(31063);
    }
  }
  
  public final byte[] evp()
  {
    AppMethodBeat.i(31062);
    try
    {
      byte[] arrayOfByte = ((b.b)this.fUF.getReqObj()).toProtoBuf();
      AppMethodBeat.o(31062);
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.NetSceneSetAppSetting", "toProtBuf failed: " + localException.getMessage());
      AppMethodBeat.o(31062);
    }
    return null;
  }
  
  public final int getType()
  {
    return 2;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(31061);
    ad.i("MicroMsg.NetSceneSetAppSetting", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 == 0) && (paramInt2 == 0))
    {
      paramString = (crb)this.fUF.gUT.gUX;
      if (paramString != null)
      {
        paramq = a.a.cZX().cZV();
        paramArrayOfByte = h.j(paramString.fVC, false, false);
        if (paramArrayOfByte != null)
        {
          paramArrayOfByte.field_authFlag = paramString.CAr;
          boolean bool = paramq.a(paramArrayOfByte, new String[0]);
          ad.d("MicroMsg.NetSceneSetAppSetting", "onGYNetEnd, update ret = " + bool + ", appId = " + paramString.fVC);
        }
      }
    }
    AppMethodBeat.o(31061);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.aj
 * JD-Core Version:    0.7.0.1
 */