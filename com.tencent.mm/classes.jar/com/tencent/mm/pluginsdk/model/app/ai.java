package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.r.a.a;
import com.tencent.mm.plugin.r.a.a.a;
import com.tencent.mm.protocal.protobuf.dvu;
import com.tencent.mm.protocal.protobuf.dvv;
import com.tencent.mm.sdk.platformtools.Log;

public final class ai
  extends aa
{
  private String JWL;
  private int cmdId;
  
  public ai(String paramString1, String paramString2)
  {
    AppMethodBeat.i(31060);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new dvu();
    ((d.a)localObject).iLO = new dvv();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/setappsetting";
    ((d.a)localObject).funcId = 396;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.hhm = ((d.a)localObject).aXF();
    localObject = (dvu)this.hhm.iLK.iLR;
    ((dvu)localObject).hik = paramString1;
    ((dvu)localObject).MWF = 0;
    ((dvu)localObject).MWG = paramString2;
    this.cmdId = 0;
    this.JWL = paramString2;
    AppMethodBeat.o(31060);
  }
  
  public final void cB(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(31063);
    if (paramArrayOfByte == null)
    {
      Log.e("MicroMsg.NetSceneSetAppSetting", "buf is null");
      AppMethodBeat.o(31063);
      return;
    }
    try
    {
      this.hhm.iLL.fromProtoBuf(paramArrayOfByte);
      AppMethodBeat.o(31063);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      Log.e("MicroMsg.NetSceneSetAppSetting", "parse error: " + paramArrayOfByte.getMessage());
      Log.printErrStackTrace("MicroMsg.NetSceneSetAppSetting", paramArrayOfByte, "", new Object[0]);
      AppMethodBeat.o(31063);
    }
  }
  
  public final int getType()
  {
    return 2;
  }
  
  public final byte[] gmB()
  {
    AppMethodBeat.i(31062);
    try
    {
      byte[] arrayOfByte = ((d.b)this.hhm.getReqObj()).toProtoBuf();
      AppMethodBeat.o(31062);
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.NetSceneSetAppSetting", "toProtBuf failed: " + localException.getMessage());
      AppMethodBeat.o(31062);
    }
    return null;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(31061);
    Log.i("MicroMsg.NetSceneSetAppSetting", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 == 0) && (paramInt2 == 0))
    {
      paramString = (dvv)this.hhm.iLL.iLR;
      if (paramString != null)
      {
        params = a.a.eAZ().eAX();
        paramArrayOfByte = h.o(paramString.hik, false, false);
        if (paramArrayOfByte != null)
        {
          paramArrayOfByte.field_authFlag = paramString.KKl;
          boolean bool = params.a(paramArrayOfByte, new String[0]);
          Log.d("MicroMsg.NetSceneSetAppSetting", "onGYNetEnd, update ret = " + bool + ", appId = " + paramString.hik);
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