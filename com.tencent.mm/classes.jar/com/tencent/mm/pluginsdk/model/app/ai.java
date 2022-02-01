package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.s.a.a;
import com.tencent.mm.plugin.s.a.a.a;
import com.tencent.mm.protocal.protobuf.dbw;
import com.tencent.mm.protocal.protobuf.dbx;
import com.tencent.mm.sdk.platformtools.ad;

public final class ai
  extends aa
{
  private String ENx;
  private int cmdId;
  
  public ai(String paramString1, String paramString2)
  {
    AppMethodBeat.i(31060);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new dbw();
    ((b.a)localObject).hNN = new dbx();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/setappsetting";
    ((b.a)localObject).funcId = 396;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.grW = ((b.a)localObject).aDC();
    localObject = (dbw)this.grW.hNK.hNQ;
    ((dbw)localObject).gsT = paramString1;
    ((dbw)localObject).Hru = 0;
    ((dbw)localObject).Hrv = paramString2;
    this.cmdId = 0;
    this.ENx = paramString2;
    AppMethodBeat.o(31060);
  }
  
  public final void ch(byte[] paramArrayOfByte)
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
      this.grW.hNL.fromProtoBuf(paramArrayOfByte);
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
  
  public final byte[] eZD()
  {
    AppMethodBeat.i(31062);
    try
    {
      byte[] arrayOfByte = ((b.b)this.grW.getReqObj()).toProtoBuf();
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
      paramString = (dbx)this.grW.hNL.hNQ;
      if (paramString != null)
      {
        paramq = a.a.dxX().dxV();
        paramArrayOfByte = h.m(paramString.gsT, false, false);
        if (paramArrayOfByte != null)
        {
          paramArrayOfByte.field_authFlag = paramString.Fyg;
          boolean bool = paramq.a(paramArrayOfByte, new String[0]);
          ad.d("MicroMsg.NetSceneSetAppSetting", "onGYNetEnd, update ret = " + bool + ", appId = " + paramString.gsT);
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