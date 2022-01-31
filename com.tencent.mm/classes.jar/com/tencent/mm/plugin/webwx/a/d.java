package com.tencent.mm.plugin.webwx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aav;
import com.tencent.mm.protocal.protobuf.aaw;
import com.tencent.mm.sdk.platformtools.ab;

public final class d
  extends m
  implements k
{
  private f callback;
  final b fBd;
  
  public d(String paramString)
  {
    AppMethodBeat.i(26500);
    b.a locala = new b.a();
    aav localaav = new aav();
    aaw localaaw = new aaw();
    locala.fsX = localaav;
    locala.fsY = localaaw;
    locala.uri = "/cgi-bin/micromsg-bin/extdeviceloginconfirmget";
    locala.funcId = 971;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.fBd = locala.ado();
    localaav.wRk = paramString;
    ab.d("MicroMsg.NetSceneExtDeviceLoginConfirmGet", "[oneliang][NetSceneExtDeviceLoginConfirmGet]loginUrl:%s", new Object[] { paramString });
    AppMethodBeat.o(26500);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(26501);
    this.callback = paramf;
    int i = dispatch(parame, this.fBd, this);
    AppMethodBeat.o(26501);
    return i;
  }
  
  public final int getType()
  {
    return 971;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26502);
    ab.d("MicroMsg.NetSceneExtDeviceLoginConfirmGet", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3 + " errMsg:" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(26502);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.a.d
 * JD-Core Version:    0.7.0.1
 */