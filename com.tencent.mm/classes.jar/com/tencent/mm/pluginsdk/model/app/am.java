package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.openapi.a.a;
import com.tencent.mm.plugin.openapi.a.a.a;
import com.tencent.mm.protocal.protobuf.ezp;
import com.tencent.mm.protocal.protobuf.ezq;
import com.tencent.mm.sdk.platformtools.Log;

public final class am
  extends ae
{
  private String XTc;
  private int cmdId;
  
  public am(String paramString1, String paramString2)
  {
    AppMethodBeat.i(31060);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new ezp();
    ((c.a)localObject).otF = new ezq();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/setappsetting";
    ((c.a)localObject).funcId = 396;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.mtC = ((c.a)localObject).bEF();
    localObject = (ezp)c.b.b(this.mtC.otB);
    ((ezp)localObject).muA = paramString1;
    ((ezp)localObject).abAz = 0;
    ((ezp)localObject).abAA = paramString2;
    this.cmdId = 0;
    this.XTc = paramString2;
    AppMethodBeat.o(31060);
  }
  
  public final void cV(byte[] paramArrayOfByte)
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
      this.mtC.otC.fromProtoBuf(paramArrayOfByte);
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
  
  public final byte[] iIa()
  {
    AppMethodBeat.i(31062);
    try
    {
      byte[] arrayOfByte = ((c.b)this.mtC.getReqObj()).toProtoBuf();
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
      paramString = (ezq)c.c.b(this.mtC.otC);
      if (paramString != null)
      {
        params = a.a.gxu().gxs();
        paramArrayOfByte = h.s(paramString.muA, false, false);
        if (paramArrayOfByte != null)
        {
          paramArrayOfByte.field_authFlag = paramString.YIo;
          boolean bool = params.a(paramArrayOfByte, new String[0]);
          Log.d("MicroMsg.NetSceneSetAppSetting", "onGYNetEnd, update ret = " + bool + ", appId = " + paramString.muA);
        }
      }
    }
    AppMethodBeat.o(31061);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.am
 * JD-Core Version:    0.7.0.1
 */