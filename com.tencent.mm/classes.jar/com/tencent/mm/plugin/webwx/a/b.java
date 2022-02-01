package com.tencent.mm.plugin.webwx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aht;
import com.tencent.mm.protocal.protobuf.ahu;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
  extends n
  implements k
{
  private f callback;
  public int drI;
  private final com.tencent.mm.al.b hWL;
  
  public b(int paramInt)
  {
    AppMethodBeat.i(30169);
    this.drI = paramInt;
    b.a locala = new b.a();
    aht localaht = new aht();
    ahu localahu = new ahu();
    locala.hNM = localaht;
    locala.hNN = localahu;
    locala.uri = "/cgi-bin/micromsg-bin/extdevicecontrol";
    locala.funcId = 792;
    locala.hNO = 0;
    locala.respCmdId = 0;
    localaht.gsV = paramInt;
    localaht.Gfi = 1;
    this.hWL = locala.aDC();
    AppMethodBeat.o(30169);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(30171);
    this.callback = paramf;
    int i = dispatch(parame, this.hWL, this);
    AppMethodBeat.o(30171);
    return i;
  }
  
  public final int getType()
  {
    return 792;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(30170);
    ad.d("MicroMsg.NetSceneExtDeviceControl", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3 + " errMsg:" + paramString);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(30170);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.a.b
 * JD-Core Version:    0.7.0.1
 */