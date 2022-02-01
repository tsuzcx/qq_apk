package com.tencent.mm.plugin.webwx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.akp;
import com.tencent.mm.protocal.protobuf.akq;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  extends q
  implements m
{
  private i callback;
  public int dJY;
  private final d iUB;
  
  public b(int paramInt)
  {
    AppMethodBeat.i(30169);
    this.dJY = paramInt;
    d.a locala = new d.a();
    akp localakp = new akp();
    akq localakq = new akq();
    locala.iLN = localakp;
    locala.iLO = localakq;
    locala.uri = "/cgi-bin/micromsg-bin/extdevicecontrol";
    locala.funcId = 792;
    locala.iLP = 0;
    locala.respCmdId = 0;
    localakp.him = paramInt;
    localakp.Ltz = 1;
    this.iUB = locala.aXF();
    AppMethodBeat.o(30169);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(30171);
    this.callback = parami;
    int i = dispatch(paramg, this.iUB, this);
    AppMethodBeat.o(30171);
    return i;
  }
  
  public final int getType()
  {
    return 792;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(30170);
    Log.d("MicroMsg.NetSceneExtDeviceControl", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3 + " errMsg:" + paramString);
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