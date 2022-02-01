package com.tencent.mm.plugin.recharge.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.mall.c;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.dln;
import com.tencent.mm.protocal.protobuf.dlo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.wallet_core.c.j;
import com.tencent.mm.wallet_core.c.w;

public final class g
  extends w
  implements j
{
  private f callback;
  public String mAppId;
  private b rr;
  public PayInfo xDC;
  
  public g(MallRechargeProduct paramMallRechargeProduct, String paramString)
  {
    this(paramMallRechargeProduct.appId, paramMallRechargeProduct.jFZ, paramMallRechargeProduct.dpp, paramString);
  }
  
  public g(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(67113);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new dln();
    ((b.a)localObject).hQG = new dlo();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/submitpayproductbuyinfo";
    ((b.a)localObject).funcId = 498;
    ((b.a)localObject).hQH = 230;
    ((b.a)localObject).respCmdId = 1000000230;
    this.rr = ((b.a)localObject).aDS();
    localObject = (dln)this.rr.hQD.hQJ;
    ae.d("MicroMsg.NetSceneSubmitPayProductBuyInfo", "remark: %s", new Object[] { paramString4 });
    this.mAppId = paramString1;
    ((dln)localObject).GKz = paramString1;
    ((dln)localObject).GKy = paramString2;
    ((dln)localObject).GSQ = paramString3;
    ((dln)localObject).GKA = paramString4;
    ((dln)localObject).xrf = c.eKB().aFV(paramString2);
    AppMethodBeat.o(67113);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(67115);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(67115);
    return i;
  }
  
  public final int getType()
  {
    return 498;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(67114);
    this.xDC = new PayInfo();
    paramArrayOfByte = (dlo)((b)paramq).hQE.hQJ;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      ae.d("MicroMsg.NetSceneSubmitPayProductBuyInfo", "resp.ReqKey " + paramArrayOfByte.FRk);
      this.xDC.appId = this.mAppId;
      this.xDC.DHy = paramArrayOfByte.GMq;
      this.xDC.dmw = paramArrayOfByte.FRk;
    }
    paramInt1 = paramInt3;
    if (paramInt3 == 0) {
      paramInt1 = paramArrayOfByte.GKB;
    }
    paramq = paramString;
    if (bu.isNullOrNil(paramString)) {
      paramq = paramArrayOfByte.GKC;
    }
    this.xDC.FEp = String.valueOf(paramInt1);
    paramArrayOfByte = this.xDC;
    if (paramq != null) {}
    for (paramString = String.valueOf(paramq);; paramString = "")
    {
      paramArrayOfByte.errMsg = paramString;
      ae.d("MicroMsg.NetSceneSubmitPayProductBuyInfo", "errCode " + paramInt1 + ", errMsg " + paramq);
      this.callback.onSceneEnd(paramInt2, paramInt1, paramq, this);
      AppMethodBeat.o(67114);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.model.g
 * JD-Core Version:    0.7.0.1
 */