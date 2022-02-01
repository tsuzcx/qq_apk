package com.tencent.mm.plugin.webwx.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.apa;
import com.tencent.mm.protocal.protobuf.apb;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  extends p
  implements m
{
  private h callback;
  public int hHC;
  private final c oDw;
  
  public b(int paramInt)
  {
    AppMethodBeat.i(30169);
    this.hHC = paramInt;
    c.a locala = new c.a();
    apa localapa = new apa();
    apb localapb = new apb();
    locala.otE = localapa;
    locala.otF = localapb;
    locala.uri = "/cgi-bin/micromsg-bin/extdevicecontrol";
    locala.funcId = 792;
    locala.otG = 0;
    locala.respCmdId = 0;
    localapa.muC = paramInt;
    localapa.Zwe = 1;
    this.oDw = locala.bEF();
    AppMethodBeat.o(30169);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(30171);
    this.callback = paramh;
    int i = dispatch(paramg, this.oDw, this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.model.b
 * JD-Core Version:    0.7.0.1
 */