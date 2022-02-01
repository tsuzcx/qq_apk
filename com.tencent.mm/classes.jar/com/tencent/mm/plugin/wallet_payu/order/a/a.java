package com.tencent.mm.plugin.wallet_payu.order.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bzv;
import com.tencent.mm.protocal.protobuf.bzw;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.c.w;

public final class a
  extends w
{
  private g callback;
  public b rr;
  
  public a(int paramInt)
  {
    AppMethodBeat.i(72056);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new bzv();
    ((b.a)localObject).gUV = new bzw();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/payubatchuserroll";
    ((b.a)localObject).funcId = 1519;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (bzv)this.rr.gUS.gUX;
    ((bzv)localObject).scy = 10;
    ((bzv)localObject).CNt = paramInt;
    ad.d("MicroMsg.NetScenePayUPayQueryUserRoll", "limit:10,offset:".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(72056);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(72058);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(72058);
    return i;
  }
  
  public final int efL()
  {
    return ((bzw)this.rr.gUT.gUX).DWA;
  }
  
  public final int getType()
  {
    return 1519;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(72057);
    ad.w("MicroMsg.NetScenePayUPayQueryUserRoll", "errType = " + paramInt2 + " errCode " + paramInt3 + " errMsg " + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      ad.d("MicroMsg.NetScenePayUPayQueryUserRoll", "rr" + ((bzw)((b)paramq).gUT.gUX).DWA);
    }
    AppMethodBeat.o(72057);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.order.a.a
 * JD-Core Version:    0.7.0.1
 */