package com.tencent.mm.plugin.product.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cdc;
import com.tencent.mm.protocal.protobuf.cio;
import com.tencent.mm.protocal.protobuf.cip;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.u;

public final class l
  extends u
  implements k
{
  private f callback;
  public String puv;
  private b rr;
  
  public l(cdc paramcdc, String paramString)
  {
    AppMethodBeat.i(44000);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new cio();
    ((b.a)localObject).fsY = new cip();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/submitmallorder";
    ((b.a)localObject).funcId = 556;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (cio)this.rr.fsV.fta;
    ((cio)localObject).xSZ = paramcdc;
    ((cio)localObject).xTb = paramString;
    AppMethodBeat.o(44000);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(44001);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(44001);
    return i;
  }
  
  public final int getType()
  {
    return 556;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(142120);
    paramq = (cip)((b)paramq).fsW.fta;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      ab.d("MicroMsg.NetSceneMallSubmitMallOrder", "resp.ReqKey " + paramq.xTa);
      this.puv = paramq.xTa;
    }
    ab.d("MicroMsg.NetSceneMallSubmitMallOrder", "errCode " + paramInt3 + ", errMsg " + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(142120);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.l
 * JD-Core Version:    0.7.0.1
 */