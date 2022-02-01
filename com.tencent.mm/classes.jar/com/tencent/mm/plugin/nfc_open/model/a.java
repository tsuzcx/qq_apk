package com.tencent.mm.plugin.nfc_open.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.agq;
import com.tencent.mm.protocal.protobuf.agr;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends p
  implements m
{
  private h callback;
  public c rr;
  
  public a(int paramInt)
  {
    AppMethodBeat.i(26686);
    c.a locala = new c.a();
    locala.otE = new agq();
    locala.otF = new agr();
    locala.uri = "/cgi-bin/mmpay-bin/cpucardgetconfig2";
    locala.funcId = 1561;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    ((agq)c.b.b(this.rr.otB)).version = paramInt;
    AppMethodBeat.o(26686);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(26687);
    this.callback = paramh;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.nfc_open.model.a
 * JD-Core Version:    0.7.0.1
 */