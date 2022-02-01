package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.cje;
import com.tencent.mm.protocal.protobuf.cjf;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.c.j;
import com.tencent.mm.wallet_core.c.w;

public class g
  extends w
  implements j
{
  private com.tencent.mm.ak.f callback;
  public b rr;
  
  public g(PayReq paramPayReq, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(71822);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new cje();
    ((b.a)localObject).hQG = new cjf();
    ((b.a)localObject).uri = getUri();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).hQH = 188;
    ((b.a)localObject).respCmdId = 1000000188;
    ((b.a)localObject).routeInfo = com.tencent.mm.wallet_core.ui.f.bas(paramPayReq.prepayId);
    this.rr = ((b.a)localObject).aDS();
    localObject = (cje)this.rr.hQD.hQJ;
    ((cje)localObject).ikm = paramPayReq.appId;
    ((cje)localObject).HvN = paramPayReq.partnerId;
    ((cje)localObject).GMp = paramPayReq.prepayId;
    ((cje)localObject).GpD = paramPayReq.nonceStr;
    ((cje)localObject).HvO = paramPayReq.timeStamp;
    ((cje)localObject).GpE = paramPayReq.packageValue;
    ((cje)localObject).GpF = paramPayReq.sign;
    ((cje)localObject).GpG = paramPayReq.signType;
    ((cje)localObject).HvP = paramString1;
    ((cje)localObject).uqs = paramString2;
    ((cje)localObject).uuo = paramString3;
    ((cje)localObject).Ghz = k.eIV();
    ((cje)localObject).HvR = paramString4;
    AppMethodBeat.o(71822);
  }
  
  public int doScene(e parame, com.tencent.mm.ak.f paramf)
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
    ae.d("MicroMsg.NetScenePayAuthApp", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(71824);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.g
 * JD-Core Version:    0.7.0.1
 */