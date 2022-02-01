package com.tencent.mm.plugin.webwx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aid;
import com.tencent.mm.protocal.protobuf.aie;
import com.tencent.mm.sdk.platformtools.ae;

public final class b
  extends n
  implements k
{
  private f callback;
  public int dsO;
  private final com.tencent.mm.ak.b hZD;
  
  public b(int paramInt)
  {
    AppMethodBeat.i(30169);
    this.dsO = paramInt;
    b.a locala = new b.a();
    aid localaid = new aid();
    aie localaie = new aie();
    locala.hQF = localaid;
    locala.hQG = localaie;
    locala.uri = "/cgi-bin/micromsg-bin/extdevicecontrol";
    locala.funcId = 792;
    locala.hQH = 0;
    locala.respCmdId = 0;
    localaid.gvx = paramInt;
    localaid.GxQ = 1;
    this.hZD = locala.aDS();
    AppMethodBeat.o(30169);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(30171);
    this.callback = paramf;
    int i = dispatch(parame, this.hZD, this);
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
    ae.d("MicroMsg.NetSceneExtDeviceControl", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3 + " errMsg:" + paramString);
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