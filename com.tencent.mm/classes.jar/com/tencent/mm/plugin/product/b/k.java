package com.tencent.mm.plugin.product.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cdc;
import com.tencent.mm.protocal.protobuf.cim;
import com.tencent.mm.protocal.protobuf.cin;
import com.tencent.mm.sdk.platformtools.ab;

public final class k
  extends m
  implements com.tencent.mm.network.k
{
  private f callback;
  public String puv;
  private b rr;
  
  public k(cdc paramcdc)
  {
    AppMethodBeat.i(43997);
    b.a locala = new b.a();
    locala.fsX = new cim();
    locala.fsY = new cin();
    locala.uri = "/cgi-bin/micromsg-bin/submitmallfreeorder";
    locala.funcId = 557;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    ((cim)this.rr.fsV.fta).xSZ = paramcdc;
    AppMethodBeat.o(43997);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(43999);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(43999);
    return i;
  }
  
  public final int getType()
  {
    return 557;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(43998);
    paramq = (cin)((b)paramq).fsW.fta;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      ab.d("MicroMsg.NetSceneMallSubmitMallFreeOrder", "resp.PrepareId " + paramq.xTa);
      this.puv = paramq.xTa;
    }
    ab.d("MicroMsg.NetSceneMallSubmitMallFreeOrder", "errCode " + paramInt3 + ", errMsg " + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(43998);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.k
 * JD-Core Version:    0.7.0.1
 */