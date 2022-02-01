package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.fks;
import com.tencent.mm.protocal.protobuf.fkt;
import com.tencent.mm.sdk.platformtools.Log;

public final class i
  extends p
  implements m
{
  public int Utk;
  private h callback;
  public int mStatus;
  private final c rr;
  
  public i(int paramInt)
  {
    AppMethodBeat.i(29782);
    c.a locala = new c.a();
    locala.otE = new fks();
    locala.otF = new fkt();
    locala.uri = "/cgi-bin/micromsg-bin/switchopvoiceprint";
    locala.funcId = 615;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    ((fks)c.b.b(this.rr.otB)).hId = paramInt;
    AppMethodBeat.o(29782);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(29783);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(29783);
    return i;
  }
  
  public final int getType()
  {
    return 615;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(29784);
    Log.d("MicroMsg.NetSceneSwitchOpVoicePrint", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    params = (fkt)c.c.b(((c)params).otC);
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29784);
      return;
    }
    this.mStatus = params.abnq;
    this.Utk = params.abLs;
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(29784);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.i
 * JD-Core Version:    0.7.0.1
 */