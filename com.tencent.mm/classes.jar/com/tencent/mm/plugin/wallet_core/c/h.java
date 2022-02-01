package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.awv;
import com.tencent.mm.protocal.protobuf.aww;
import com.tencent.mm.sdk.platformtools.ad;

public final class h
  extends n
  implements k
{
  public aww COH;
  private f callback;
  private b rr;
  
  public h(String paramString)
  {
    AppMethodBeat.i(69902);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new awv();
    ((b.a)localObject).hNN = new aww();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/tenpay/getbanpaymobileinfo";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).routeInfo = com.tencent.mm.wallet_core.ui.e.aYP(paramString);
    this.rr = ((b.a)localObject).aDC();
    localObject = (awv)this.rr.hNK.hNQ;
    ad.d("MicroMsg.NetSceneGetBanpayMobileInfo", "req_key: %s", new Object[] { paramString });
    ((awv)localObject).dve = paramString;
    AppMethodBeat.o(69902);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(69903);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(69903);
    return i;
  }
  
  public final int getType()
  {
    return 1667;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(69904);
    ad.i("MicroMsg.NetSceneGetBanpayMobileInfo", "NetSceneGetBanpayMobileInfo, netId: %s, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.COH = ((aww)this.rr.hNL.hNQ);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(69904);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.h
 * JD-Core Version:    0.7.0.1
 */