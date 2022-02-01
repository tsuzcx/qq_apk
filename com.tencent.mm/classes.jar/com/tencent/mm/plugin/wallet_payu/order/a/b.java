package com.tencent.mm.plugin.wallet_payu.order.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bzx;
import com.tencent.mm.protocal.protobuf.bzy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.c.w;

public final class b
  extends w
{
  private g callback;
  private com.tencent.mm.al.b rr;
  
  public b(String paramString)
  {
    AppMethodBeat.i(72059);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new bzx();
    ((b.a)localObject).gUV = new bzy();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/payudeluserroll";
    ((b.a)localObject).funcId = 1544;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (bzx)this.rr.gUS.gUX;
    if (!bt.isNullOrNil(paramString)) {
      ((bzx)localObject).uoY = paramString;
    }
    AppMethodBeat.o(72059);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(72061);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(72061);
    return i;
  }
  
  public final int getType()
  {
    return 1544;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(72060);
    ad.d("MicroMsg.NetScenePayUDelUserRoll", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(72060);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.order.a.b
 * JD-Core Version:    0.7.0.1
 */