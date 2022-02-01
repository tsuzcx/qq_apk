package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.s.a.a;
import com.tencent.mm.plugin.s.a.a.a;
import com.tencent.mm.protocal.protobuf.cwj;
import com.tencent.mm.protocal.protobuf.cwk;
import com.tencent.mm.sdk.platformtools.ac;

public final class aj
  extends aa
{
  private String DiK;
  private int cmdId;
  
  public aj(String paramString1, String paramString2)
  {
    AppMethodBeat.i(31060);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new cwj();
    ((b.a)localObject).hvu = new cwk();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/setappsetting";
    ((b.a)localObject).funcId = 396;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.fYA = ((b.a)localObject).aAz();
    localObject = (cwj)this.fYA.hvr.hvw;
    ((cwj)localObject).fZx = paramString1;
    ((cwj)localObject).FGM = 0;
    ((cwj)localObject).FGN = paramString2;
    this.cmdId = 0;
    this.DiK = paramString2;
    AppMethodBeat.o(31060);
  }
  
  public final void ca(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(31063);
    if (paramArrayOfByte == null)
    {
      ac.e("MicroMsg.NetSceneSetAppSetting", "buf is null");
      AppMethodBeat.o(31063);
      return;
    }
    try
    {
      this.fYA.hvs.fromProtoBuf(paramArrayOfByte);
      AppMethodBeat.o(31063);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      ac.e("MicroMsg.NetSceneSetAppSetting", "parse error: " + paramArrayOfByte.getMessage());
      ac.printErrStackTrace("MicroMsg.NetSceneSetAppSetting", paramArrayOfByte, "", new Object[0]);
      AppMethodBeat.o(31063);
    }
  }
  
  public final byte[] eKJ()
  {
    AppMethodBeat.i(31062);
    try
    {
      byte[] arrayOfByte = ((b.b)this.fYA.getReqObj()).toProtoBuf();
      AppMethodBeat.o(31062);
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.NetSceneSetAppSetting", "toProtBuf failed: " + localException.getMessage());
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
    ac.i("MicroMsg.NetSceneSetAppSetting", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 == 0) && (paramInt2 == 0))
    {
      paramString = (cwk)this.fYA.hvs.hvw;
      if (paramString != null)
      {
        paramq = a.a.dnF().dnD();
        paramArrayOfByte = h.k(paramString.fZx, false, false);
        if (paramArrayOfByte != null)
        {
          paramArrayOfByte.field_authFlag = paramString.DSN;
          boolean bool = paramq.a(paramArrayOfByte, new String[0]);
          ac.d("MicroMsg.NetSceneSetAppSetting", "onGYNetEnd, update ret = " + bool + ", appId = " + paramString.fZx);
        }
      }
    }
    AppMethodBeat.o(31061);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.aj
 * JD-Core Version:    0.7.0.1
 */