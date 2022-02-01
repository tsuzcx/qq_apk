package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.axl;
import com.tencent.mm.protocal.protobuf.axm;
import com.tencent.mm.sdk.platformtools.ae;

public final class h
  extends n
  implements k
{
  public axm Dgm;
  private com.tencent.mm.ak.f callback;
  private b rr;
  
  public h(String paramString)
  {
    AppMethodBeat.i(69902);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new axl();
    ((b.a)localObject).hQG = new axm();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/tenpay/getbanpaymobileinfo";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).routeInfo = com.tencent.mm.wallet_core.ui.f.bas(paramString);
    this.rr = ((b.a)localObject).aDS();
    localObject = (axl)this.rr.hQD.hQJ;
    ae.d("MicroMsg.NetSceneGetBanpayMobileInfo", "req_key: %s", new Object[] { paramString });
    ((axl)localObject).dwj = paramString;
    AppMethodBeat.o(69902);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.f paramf)
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
    ae.i("MicroMsg.NetSceneGetBanpayMobileInfo", "NetSceneGetBanpayMobileInfo, netId: %s, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.Dgm = ((axm)this.rr.hQE.hQJ);
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