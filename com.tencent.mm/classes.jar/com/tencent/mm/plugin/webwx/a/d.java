package com.tencent.mm.plugin.webwx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.akv;
import com.tencent.mm.protocal.protobuf.akw;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends q
  implements m
{
  private i callback;
  final com.tencent.mm.ak.d iUB;
  
  public d(String paramString)
  {
    AppMethodBeat.i(30175);
    d.a locala = new d.a();
    akv localakv = new akv();
    akw localakw = new akw();
    locala.iLN = localakv;
    locala.iLO = localakw;
    locala.uri = "/cgi-bin/micromsg-bin/extdeviceloginconfirmget";
    locala.funcId = 971;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.iUB = locala.aXF();
    localakv.LtA = paramString;
    Log.d("MicroMsg.NetSceneExtDeviceLoginConfirmGet", "[oneliang][NetSceneExtDeviceLoginConfirmGet]loginUrl:%s", new Object[] { paramString });
    AppMethodBeat.o(30175);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(30176);
    this.callback = parami;
    int i = dispatch(paramg, this.iUB, this);
    AppMethodBeat.o(30176);
    return i;
  }
  
  public final int getType()
  {
    return 971;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(30177);
    Log.d("MicroMsg.NetSceneExtDeviceLoginConfirmGet", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3 + " errMsg:" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(30177);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.a.d
 * JD-Core Version:    0.7.0.1
 */