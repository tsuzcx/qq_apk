package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.q;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.protocal.protobuf.bkp;
import com.tencent.mm.protocal.protobuf.bkq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.i;
import com.tencent.mm.wallet_core.c.u;

public final class g
  extends u
  implements i
{
  private f callback;
  public b rr;
  
  public g(PayReq paramPayReq, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(48187);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new bkp();
    ((b.a)localObject).fsY = new bkq();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/payauthapp";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).reqCmdId = 188;
    ((b.a)localObject).respCmdId = 1000000188;
    ((b.a)localObject).routeInfo = com.tencent.mm.wallet_core.ui.e.awk(paramPayReq.prepayId);
    this.rr = ((b.a)localObject).ado();
    localObject = (bkp)this.rr.fsV.fta;
    ((bkp)localObject).fKw = paramPayReq.appId;
    ((bkp)localObject).xzm = paramPayReq.partnerId;
    ((bkp)localObject).wXQ = paramPayReq.prepayId;
    ((bkp)localObject).wKV = paramPayReq.nonceStr;
    ((bkp)localObject).xzn = paramPayReq.timeStamp;
    ((bkp)localObject).wKW = paramPayReq.packageValue;
    ((bkp)localObject).wKX = paramPayReq.sign;
    ((bkp)localObject).wKY = paramPayReq.signType;
    ((bkp)localObject).xzo = paramString1;
    ((bkp)localObject).nqc = paramString2;
    ((bkp)localObject).ntp = paramString3;
    ((bkp)localObject).wDH = m.cTC();
    ((bkp)localObject).xzq = paramString4;
    AppMethodBeat.o(48187);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(48188);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(48188);
    return i;
  }
  
  public final int getType()
  {
    return 397;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(142581);
    ab.d("MicroMsg.NetScenePayAuthApp", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(142581);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.g
 * JD-Core Version:    0.7.0.1
 */