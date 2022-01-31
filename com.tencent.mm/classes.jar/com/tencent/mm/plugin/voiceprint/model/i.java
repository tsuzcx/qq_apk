package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ciw;
import com.tencent.mm.protocal.protobuf.cix;
import com.tencent.mm.sdk.platformtools.ab;

public final class i
  extends m
  implements k
{
  private f callback;
  public int mStatus;
  private final b rr;
  public int tro;
  
  public i(int paramInt)
  {
    AppMethodBeat.i(26101);
    b.a locala = new b.a();
    locala.fsX = new ciw();
    locala.fsY = new cix();
    locala.uri = "/cgi-bin/micromsg-bin/switchopvoiceprint";
    locala.funcId = 615;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    ((ciw)this.rr.fsV.fta).cut = paramInt;
    AppMethodBeat.o(26101);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(26102);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(26102);
    return i;
  }
  
  public final int getType()
  {
    return 615;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26103);
    ab.d("MicroMsg.NetSceneSwitchOpVoicePrint", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    paramq = (cix)((b)paramq).fsW.fta;
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(26103);
      return;
    }
    this.mStatus = paramq.xCL;
    this.tro = paramq.xTf;
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(26103);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.i
 * JD-Core Version:    0.7.0.1
 */