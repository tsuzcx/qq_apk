package com.tencent.mm.plugin.webwx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aff;
import com.tencent.mm.protocal.protobuf.afg;
import com.tencent.mm.sdk.platformtools.ac;

public final class b
  extends n
  implements k
{
  private g callback;
  public int dgm;
  private final com.tencent.mm.ak.b hEg;
  
  public b(int paramInt)
  {
    AppMethodBeat.i(30169);
    this.dgm = paramInt;
    b.a locala = new b.a();
    aff localaff = new aff();
    afg localafg = new afg();
    locala.hvt = localaff;
    locala.hvu = localafg;
    locala.uri = "/cgi-bin/micromsg-bin/extdevicecontrol";
    locala.funcId = 792;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    localaff.fZz = paramInt;
    localaff.ExC = 1;
    this.hEg = locala.aAz();
    AppMethodBeat.o(30169);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(30171);
    this.callback = paramg;
    int i = dispatch(parame, this.hEg, this);
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
    ac.d("MicroMsg.NetSceneExtDeviceControl", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3 + " errMsg:" + paramString);
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