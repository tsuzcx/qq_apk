package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.bzt;
import com.tencent.mm.protocal.protobuf.bzu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class t
  extends w
{
  private g callback;
  private com.tencent.mm.al.b rr;
  
  public t(String paramString)
  {
    this(paramString, null, null, -1, -1, -1);
  }
  
  public t(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(72794);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new bzt();
    ((b.a)localObject).gUV = new bzu();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/paysubscribe";
    ((b.a)localObject).funcId = 421;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    ((b.a)localObject).routeInfo = com.tencent.mm.wallet_core.ui.e.aNn(paramString2);
    this.rr = ((b.a)localObject).atI();
    localObject = (bzt)this.rr.gUS.gUX;
    ((bzt)localObject).DWw = paramString1;
    ((bzt)localObject).CPi = k.ebS();
    ((bzt)localObject).DWx = paramString3;
    if (!bt.isNullOrNil(paramString2)) {
      ((bzt)localObject).DWy = new com.tencent.mm.bx.b(paramString2.getBytes());
    }
    if (paramInt1 >= 0) {
      ((bzt)localObject).CPd = paramInt1;
    }
    if (paramInt2 >= 0) {
      ((bzt)localObject).Ctl = paramInt2;
    }
    if (paramInt3 >= 0) {
      ((bzt)localObject).DWz = paramInt3;
    }
    AppMethodBeat.o(72794);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(72795);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(72795);
    return i;
  }
  
  public final int getType()
  {
    return 421;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(72796);
    ad.d("MicroMsg.NetScenePaySubscribe", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(72796);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.t
 * JD-Core Version:    0.7.0.1
 */