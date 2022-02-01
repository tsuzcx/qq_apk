package com.tencent.mm.plugin.recharge.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.mall.c;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.czt;
import com.tencent.mm.protocal.protobuf.czu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.c.j;
import com.tencent.mm.wallet_core.c.w;

public final class g
  extends w
  implements j
{
  private com.tencent.mm.al.g callback;
  public String mAppId;
  private b rr;
  public PayInfo uXi;
  
  public g(MallRechargeProduct paramMallRechargeProduct, String paramString)
  {
    this(paramMallRechargeProduct.appId, paramMallRechargeProduct.uWF, paramMallRechargeProduct.dft, paramString);
  }
  
  public g(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(67113);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new czt();
    ((b.a)localObject).gUV = new czu();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/submitpayproductbuyinfo";
    ((b.a)localObject).funcId = 498;
    ((b.a)localObject).reqCmdId = 230;
    ((b.a)localObject).respCmdId = 1000000230;
    this.rr = ((b.a)localObject).atI();
    localObject = (czt)this.rr.gUS.gUX;
    ad.d("MicroMsg.NetSceneSubmitPayProductBuyInfo", "remark: %s", new Object[] { paramString4 });
    this.mAppId = paramString1;
    ((czt)localObject).Dnk = paramString1;
    ((czt)localObject).Dnj = paramString2;
    ((czt)localObject).DuQ = paramString3;
    ((czt)localObject).Dnl = paramString4;
    ((czt)localObject).Ddo = c.eds().atZ(paramString2);
    AppMethodBeat.o(67113);
  }
  
  public final int doScene(e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(67115);
    this.callback = paramg;
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
    this.uXi = new PayInfo();
    paramArrayOfByte = (czu)((b)paramq).gUT.gUX;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      ad.d("MicroMsg.NetSceneSubmitPayProductBuyInfo", "resp.ReqKey " + paramArrayOfByte.CAV);
      this.uXi.appId = this.mAppId;
      this.uXi.Axg = paramArrayOfByte.DoQ;
      this.uXi.dcE = paramArrayOfByte.CAV;
    }
    paramInt1 = paramInt3;
    if (paramInt3 == 0) {
      paramInt1 = paramArrayOfByte.Dnm;
    }
    paramq = paramString;
    if (bt.isNullOrNil(paramString)) {
      paramq = paramArrayOfByte.Dnn;
    }
    this.uXi.Cor = String.valueOf(paramInt1);
    paramArrayOfByte = this.uXi;
    if (paramq != null) {}
    for (paramString = String.valueOf(paramq);; paramString = "")
    {
      paramArrayOfByte.errMsg = paramString;
      ad.d("MicroMsg.NetSceneSubmitPayProductBuyInfo", "errCode " + paramInt1 + ", errMsg " + paramq);
      this.callback.onSceneEnd(paramInt2, paramInt1, paramq, this);
      AppMethodBeat.o(67114);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.model.g
 * JD-Core Version:    0.7.0.1
 */