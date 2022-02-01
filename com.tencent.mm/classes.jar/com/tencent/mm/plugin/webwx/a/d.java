package com.tencent.mm.plugin.webwx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.afl;
import com.tencent.mm.protocal.protobuf.afm;
import com.tencent.mm.sdk.platformtools.ac;

public final class d
  extends n
  implements k
{
  private g callback;
  final b hEg;
  
  public d(String paramString)
  {
    AppMethodBeat.i(30175);
    b.a locala = new b.a();
    afl localafl = new afl();
    afm localafm = new afm();
    locala.hvt = localafl;
    locala.hvu = localafm;
    locala.uri = "/cgi-bin/micromsg-bin/extdeviceloginconfirmget";
    locala.funcId = 971;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.hEg = locala.aAz();
    localafl.ExD = paramString;
    ac.d("MicroMsg.NetSceneExtDeviceLoginConfirmGet", "[oneliang][NetSceneExtDeviceLoginConfirmGet]loginUrl:%s", new Object[] { paramString });
    AppMethodBeat.o(30175);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(30176);
    this.callback = paramg;
    int i = dispatch(parame, this.hEg, this);
    AppMethodBeat.o(30176);
    return i;
  }
  
  public final int getType()
  {
    return 971;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(30177);
    ac.d("MicroMsg.NetSceneExtDeviceLoginConfirmGet", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3 + " errMsg:" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(30177);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.a.d
 * JD-Core Version:    0.7.0.1
 */