package com.tencent.mm.plugin.webwx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ahz;
import com.tencent.mm.protocal.protobuf.aia;
import com.tencent.mm.sdk.platformtools.ad;

public final class d
  extends n
  implements k
{
  private f callback;
  final b hWL;
  
  public d(String paramString)
  {
    AppMethodBeat.i(30175);
    b.a locala = new b.a();
    ahz localahz = new ahz();
    aia localaia = new aia();
    locala.hNM = localahz;
    locala.hNN = localaia;
    locala.uri = "/cgi-bin/micromsg-bin/extdeviceloginconfirmget";
    locala.funcId = 971;
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.hWL = locala.aDC();
    localahz.Gfj = paramString;
    ad.d("MicroMsg.NetSceneExtDeviceLoginConfirmGet", "[oneliang][NetSceneExtDeviceLoginConfirmGet]loginUrl:%s", new Object[] { paramString });
    AppMethodBeat.o(30175);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(30176);
    this.callback = paramf;
    int i = dispatch(parame, this.hWL, this);
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
    ad.d("MicroMsg.NetSceneExtDeviceLoginConfirmGet", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3 + " errMsg:" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(30177);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.a.d
 * JD-Core Version:    0.7.0.1
 */