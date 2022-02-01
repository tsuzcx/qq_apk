package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.asx;
import com.tencent.mm.protocal.protobuf.asy;
import com.tencent.mm.sdk.platformtools.ac;

public final class h
  extends n
  implements k
{
  public asy Bos;
  private g callback;
  private b rr;
  
  public h(String paramString)
  {
    AppMethodBeat.i(69902);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new asx();
    ((b.a)localObject).hvu = new asy();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/tenpay/getbanpaymobileinfo";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).routeInfo = com.tencent.mm.wallet_core.ui.e.aSQ(paramString);
    this.rr = ((b.a)localObject).aAz();
    localObject = (asx)this.rr.hvr.hvw;
    ac.d("MicroMsg.NetSceneGetBanpayMobileInfo", "req_key: %s", new Object[] { paramString });
    ((asx)localObject).djr = paramString;
    AppMethodBeat.o(69902);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(69903);
    this.callback = paramg;
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
    ac.i("MicroMsg.NetSceneGetBanpayMobileInfo", "NetSceneGetBanpayMobileInfo, netId: %s, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.Bos = ((asy)this.rr.hvs.hvw);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(69904);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.h
 * JD-Core Version:    0.7.0.1
 */