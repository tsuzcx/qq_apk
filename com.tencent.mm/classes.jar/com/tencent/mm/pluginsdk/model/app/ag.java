package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.s.a.a;
import com.tencent.mm.plugin.s.a.a.a;
import com.tencent.mm.protocal.protobuf.cak;
import com.tencent.mm.protocal.protobuf.cal;
import com.tencent.mm.sdk.platformtools.ab;

public final class ag
  extends x
{
  private int cmdId;
  private String vLK;
  
  public ag(String paramString1, String paramString2)
  {
    AppMethodBeat.i(27366);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new cak();
    ((b.a)localObject).fsY = new cal();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/setappsetting";
    ((b.a)localObject).funcId = 396;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.lFp = ((b.a)localObject).ado();
    localObject = (cak)this.lFp.fsV.fta;
    ((cak)localObject).npZ = paramString1;
    ((cak)localObject).xLQ = 0;
    ((cak)localObject).xLR = paramString2;
    this.cmdId = 0;
    this.vLK = paramString2;
    AppMethodBeat.o(27366);
  }
  
  public final void bJ(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(27369);
    if (paramArrayOfByte == null)
    {
      ab.e("MicroMsg.NetSceneSetAppSetting", "buf is null");
      AppMethodBeat.o(27369);
      return;
    }
    try
    {
      this.lFp.fsW.fromProtoBuf(paramArrayOfByte);
      AppMethodBeat.o(27369);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      ab.e("MicroMsg.NetSceneSetAppSetting", "parse error: " + paramArrayOfByte.getMessage());
      ab.printErrStackTrace("MicroMsg.NetSceneSetAppSetting", paramArrayOfByte, "", new Object[0]);
      AppMethodBeat.o(27369);
    }
  }
  
  public final byte[] dli()
  {
    AppMethodBeat.i(27368);
    try
    {
      byte[] arrayOfByte = ((b.b)this.lFp.getReqObj()).toProtoBuf();
      AppMethodBeat.o(27368);
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.NetSceneSetAppSetting", "toProtBuf failed: " + localException.getMessage());
      AppMethodBeat.o(27368);
    }
    return null;
  }
  
  public final int getType()
  {
    return 2;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(27367);
    ab.i("MicroMsg.NetSceneSetAppSetting", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 == 0) && (paramInt2 == 0))
    {
      paramString = (cal)this.lFp.fsW.fta;
      if (paramString != null)
      {
        paramq = a.a.caj().cah();
        paramArrayOfByte = g.ca(paramString.npZ, false);
        if (paramArrayOfByte != null)
        {
          paramArrayOfByte.field_authFlag = paramString.wrd;
          boolean bool = paramq.a(paramArrayOfByte, new String[0]);
          ab.d("MicroMsg.NetSceneSetAppSetting", "onGYNetEnd, update ret = " + bool + ", appId = " + paramString.npZ);
        }
      }
    }
    AppMethodBeat.o(27367);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ag
 * JD-Core Version:    0.7.0.1
 */