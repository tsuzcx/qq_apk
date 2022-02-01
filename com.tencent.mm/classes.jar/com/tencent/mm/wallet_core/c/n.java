package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.qh;
import com.tencent.mm.protocal.protobuf.qi;
import com.tencent.mm.sdk.platformtools.ad;

public final class n
  extends w
{
  private g callback;
  private b rr;
  
  public n(String paramString1, String paramString2)
  {
    AppMethodBeat.i(72778);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new qh();
    ((b.a)localObject).gUV = new qi();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/cancelqrpay";
    ((b.a)localObject).funcId = 410;
    ((b.a)localObject).reqCmdId = 198;
    ((b.a)localObject).respCmdId = 1000000198;
    ((b.a)localObject).routeInfo = com.tencent.mm.wallet_core.ui.e.aNn(paramString2);
    this.rr = ((b.a)localObject).atI();
    localObject = (qh)this.rr.gUS.gUX;
    ((qh)localObject).CPh = paramString1;
    ((qh)localObject).CAV = paramString2;
    ((qh)localObject).CPi = k.ebS();
    AppMethodBeat.o(72778);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(72780);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(72780);
    return i;
  }
  
  public final int getType()
  {
    return 410;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(72779);
    ad.d("MicroMsg.NetSceneCancelQRPay", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(72779);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.n
 * JD-Core Version:    0.7.0.1
 */