package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.protocal.protobuf.oc;
import com.tencent.mm.protocal.protobuf.od;
import com.tencent.mm.sdk.platformtools.ab;

public final class l
  extends u
{
  private f callback;
  private b rr;
  
  public l(String paramString1, String paramString2)
  {
    AppMethodBeat.i(49058);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new oc();
    ((b.a)localObject).fsY = new od();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/cancelqrpay";
    ((b.a)localObject).funcId = 410;
    ((b.a)localObject).reqCmdId = 198;
    ((b.a)localObject).respCmdId = 1000000198;
    ((b.a)localObject).routeInfo = com.tencent.mm.wallet_core.ui.e.awk(paramString2);
    this.rr = ((b.a)localObject).ado();
    localObject = (oc)this.rr.fsV.fta;
    ((oc)localObject).wDG = paramString1;
    ((oc)localObject).wrH = paramString2;
    ((oc)localObject).wDH = m.cTC();
    AppMethodBeat.o(49058);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(49060);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(49060);
    return i;
  }
  
  public final int getType()
  {
    return 410;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(142655);
    ab.d("MicroMsg.NetSceneCancelQRPay", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(142655);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.l
 * JD-Core Version:    0.7.0.1
 */