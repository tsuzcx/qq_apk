package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.network.q;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.cik;
import com.tencent.mm.protocal.protobuf.cil;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.c.j;
import com.tencent.mm.wallet_core.c.w;

public class g
  extends w
  implements j
{
  private f callback;
  public b rr;
  
  public g(PayReq paramPayReq, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(71822);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new cik();
    ((b.a)localObject).hNN = new cil();
    ((b.a)localObject).uri = getUri();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).hNO = 188;
    ((b.a)localObject).respCmdId = 1000000188;
    ((b.a)localObject).routeInfo = com.tencent.mm.wallet_core.ui.e.aYP(paramPayReq.prepayId);
    this.rr = ((b.a)localObject).aDC();
    localObject = (cik)this.rr.hNK.hNQ;
    ((cik)localObject).iht = paramPayReq.appId;
    ((cik)localObject).Hcn = paramPayReq.partnerId;
    ((cik)localObject).GsR = paramPayReq.prepayId;
    ((cik)localObject).FXe = paramPayReq.nonceStr;
    ((cik)localObject).Hco = paramPayReq.timeStamp;
    ((cik)localObject).FXf = paramPayReq.packageValue;
    ((cik)localObject).FXg = paramPayReq.sign;
    ((cik)localObject).FXh = paramPayReq.signType;
    ((cik)localObject).Hcp = paramString1;
    ((cik)localObject).ufi = paramString2;
    ((cik)localObject).uiR = paramString3;
    ((cik)localObject).FPa = k.eFo();
    ((cik)localObject).Hcr = paramString4;
    AppMethodBeat.o(71822);
  }
  
  public int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(71823);
    this.callback = paramf;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.g
 * JD-Core Version:    0.7.0.1
 */