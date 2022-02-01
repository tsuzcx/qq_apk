package com.tencent.mm.plugin.nfc_open.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.adx;
import com.tencent.mm.protocal.protobuf.ady;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  extends q
  implements m
{
  private i callback;
  public d rr;
  
  public b(int paramInt)
  {
    AppMethodBeat.i(26686);
    d.a locala = new d.a();
    locala.iLN = new adx();
    locala.iLO = new ady();
    locala.uri = "/cgi-bin/mmpay-bin/cpucardgetconfig2";
    locala.funcId = 1561;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    ((adx)this.rr.iLK.iLR).version = paramInt;
    AppMethodBeat.o(26686);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(26687);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(26687);
    return i;
  }
  
  public final int getType()
  {
    return 1561;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26688);
    Log.d("MicroMsg.NetSceneCpuCardGetConfig", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " errMsg:" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(26688);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.nfc_open.a.b
 * JD-Core Version:    0.7.0.1
 */