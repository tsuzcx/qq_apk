package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.network.q;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.byp;
import com.tencent.mm.protocal.protobuf.byq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.c.j;
import com.tencent.mm.wallet_core.c.w;

public class g
  extends w
  implements j
{
  private com.tencent.mm.al.g callback;
  public b rr;
  
  public g(PayReq paramPayReq, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(71822);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new byp();
    ((b.a)localObject).gUV = new byq();
    ((b.a)localObject).uri = getUri();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).reqCmdId = 188;
    ((b.a)localObject).respCmdId = 1000000188;
    ((b.a)localObject).routeInfo = com.tencent.mm.wallet_core.ui.e.aNn(paramPayReq.prepayId);
    this.rr = ((b.a)localObject).atI();
    localObject = (byp)this.rr.gUS.gUX;
    ((byp)localObject).hnC = paramPayReq.appId;
    ((byp)localObject).DVt = paramPayReq.partnerId;
    ((byp)localObject).DoP = paramPayReq.prepayId;
    ((byp)localObject).CXk = paramPayReq.nonceStr;
    ((byp)localObject).DVu = paramPayReq.timeStamp;
    ((byp)localObject).CXl = paramPayReq.packageValue;
    ((byp)localObject).CXm = paramPayReq.sign;
    ((byp)localObject).CXn = paramPayReq.signType;
    ((byp)localObject).DVv = paramString1;
    ((byp)localObject).rZy = paramString2;
    ((byp)localObject).scR = paramString3;
    ((byp)localObject).CPi = k.ebS();
    ((byp)localObject).DVx = paramString4;
    AppMethodBeat.o(71822);
  }
  
  public int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(71823);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(71823);
    return i;
  }
  
  public int getType()
  {
    return 397;
  }
  
  public String getUri()
  {
    return "/cgi-bin/mmpay-bin/payauthapp";
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(71824);
    ad.d("MicroMsg.NetScenePayAuthApp", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(71824);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.g
 * JD-Core Version:    0.7.0.1
 */