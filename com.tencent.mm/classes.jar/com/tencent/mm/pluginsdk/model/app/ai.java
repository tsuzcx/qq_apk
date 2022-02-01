package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.s.a.a;
import com.tencent.mm.plugin.s.a.a.a;
import com.tencent.mm.protocal.protobuf.dcq;
import com.tencent.mm.protocal.protobuf.dcr;
import com.tencent.mm.sdk.platformtools.ae;

public final class ai
  extends aa
{
  private String FfU;
  private int cmdId;
  
  public ai(String paramString1, String paramString2)
  {
    AppMethodBeat.i(31060);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new dcq();
    ((b.a)localObject).hQG = new dcr();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/setappsetting";
    ((b.a)localObject).funcId = 396;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.gux = ((b.a)localObject).aDS();
    localObject = (dcq)this.gux.hQD.hQJ;
    ((dcq)localObject).gvv = paramString1;
    ((dcq)localObject).HKW = 0;
    ((dcq)localObject).HKX = paramString2;
    this.cmdId = 0;
    this.FfU = paramString2;
    AppMethodBeat.o(31060);
  }
  
  public final void ck(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(31063);
    if (paramArrayOfByte == null)
    {
      ae.e("MicroMsg.NetSceneSetAppSetting", "buf is null");
      AppMethodBeat.o(31063);
      return;
    }
    try
    {
      this.gux.hQE.fromProtoBuf(paramArrayOfByte);
      AppMethodBeat.o(31063);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      ae.e("MicroMsg.NetSceneSetAppSetting", "parse error: " + paramArrayOfByte.getMessage());
      ae.printErrStackTrace("MicroMsg.NetSceneSetAppSetting", paramArrayOfByte, "", new Object[0]);
      AppMethodBeat.o(31063);
    }
  }
  
  public final byte[] fdr()
  {
    AppMethodBeat.i(31062);
    try
    {
      byte[] arrayOfByte = ((b.b)this.gux.getReqObj()).toProtoBuf();
      AppMethodBeat.o(31062);
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.NetSceneSetAppSetting", "toProtBuf failed: " + localException.getMessage());
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
    ae.i("MicroMsg.NetSceneSetAppSetting", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 == 0) && (paramInt2 == 0))
    {
      paramString = (dcr)this.gux.hQE.hQJ;
      if (paramString != null)
      {
        paramq = a.a.dBn().dBl();
        paramArrayOfByte = h.m(paramString.gvv, false, false);
        if (paramArrayOfByte != null)
        {
          paramArrayOfByte.field_authFlag = paramString.FQE;
          boolean bool = paramq.a(paramArrayOfByte, new String[0]);
          ae.d("MicroMsg.NetSceneSetAppSetting", "onGYNetEnd, update ret = " + bool + ", appId = " + paramString.gvv);
        }
      }
    }
    AppMethodBeat.o(31061);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ai
 * JD-Core Version:    0.7.0.1
 */