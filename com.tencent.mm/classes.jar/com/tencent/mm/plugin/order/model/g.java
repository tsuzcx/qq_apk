package com.tencent.mm.plugin.order.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.byu;
import com.tencent.mm.protocal.protobuf.byv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.c.w;

public final class g
  extends w
{
  private com.tencent.mm.al.g callback;
  private b rr;
  
  public g(String paramString1, String paramString2)
  {
    AppMethodBeat.i(66686);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new byu();
    ((b.a)localObject).gUV = new byv();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/paydeluserroll";
    ((b.a)localObject).funcId = 389;
    ((b.a)localObject).reqCmdId = 187;
    ((b.a)localObject).respCmdId = 1000000187;
    this.rr = ((b.a)localObject).atI();
    localObject = (byu)this.rr.gUS.gUX;
    ((byu)localObject).DVC = 1;
    if (!bt.isNullOrNil(paramString1)) {
      ((byu)localObject).uoY = paramString1;
    }
    if (!bt.isNullOrNil(paramString2)) {
      ((byu)localObject).upq = paramString2;
    }
    ((byu)localObject).CPi = k.ebS();
    AppMethodBeat.o(66686);
  }
  
  public final int dah()
  {
    return ((byu)this.rr.gUS.gUX).DVC;
  }
  
  public final String dai()
  {
    return ((byu)this.rr.gUS.gUX).uoY;
  }
  
  public final int doScene(e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(66688);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(66688);
    return i;
  }
  
  public final int getType()
  {
    return 389;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(66687);
    ad.d("MicroMsg.NetScenePayDelUserRoll", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(66687);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.g
 * JD-Core Version:    0.7.0.1
 */