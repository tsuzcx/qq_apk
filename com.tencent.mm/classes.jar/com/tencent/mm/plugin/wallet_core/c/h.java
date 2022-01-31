package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.agm;
import com.tencent.mm.protocal.protobuf.agn;
import com.tencent.mm.sdk.platformtools.ab;

public final class h
  extends m
  implements k
{
  private f callback;
  private b rr;
  public agn ubu;
  
  public h(String paramString)
  {
    AppMethodBeat.i(46500);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new agm();
    ((b.a)localObject).fsY = new agn();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/tenpay/getbanpaymobileinfo";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).routeInfo = com.tencent.mm.wallet_core.ui.e.awk(paramString);
    this.rr = ((b.a)localObject).ado();
    localObject = (agm)this.rr.fsV.fta;
    ab.d("MicroMsg.NetSceneGetBanpayMobileInfo", "req_key: %s", new Object[] { paramString });
    ((agm)localObject).cwk = paramString;
    AppMethodBeat.o(46500);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(46501);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(46501);
    return i;
  }
  
  public final int getType()
  {
    return 1667;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(46502);
    ab.i("MicroMsg.NetSceneGetBanpayMobileInfo", "NetSceneGetBanpayMobileInfo, netId: %s, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.ubu = ((agn)this.rr.fsW.fta);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(46502);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.h
 * JD-Core Version:    0.7.0.1
 */