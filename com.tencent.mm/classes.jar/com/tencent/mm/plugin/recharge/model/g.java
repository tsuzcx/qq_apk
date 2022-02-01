package com.tencent.mm.plugin.recharge.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.s;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.fka;
import com.tencent.mm.protocal.protobuf.fkb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.model.j;
import com.tencent.mm.wallet_core.model.w;

public final class g
  extends w
  implements j
{
  public PayInfo Nxi;
  private h callback;
  public String mAppId;
  private com.tencent.mm.am.c rr;
  
  public g(MallRechargeProduct paramMallRechargeProduct, String paramString)
  {
    this(paramMallRechargeProduct.appId, paramMallRechargeProduct.qBb, paramMallRechargeProduct.productId, paramString);
  }
  
  public g(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(67113);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new fka();
    ((c.a)localObject).otF = new fkb();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/submitpayproductbuyinfo";
    ((c.a)localObject).funcId = 498;
    ((c.a)localObject).otG = 230;
    ((c.a)localObject).respCmdId = 1000000230;
    this.rr = ((c.a)localObject).bEF();
    localObject = (fka)c.b.b(this.rr.otB);
    Log.d("MicroMsg.NetSceneSubmitPayProductBuyInfo", "remark: %s", new Object[] { paramString4 });
    this.mAppId = paramString1;
    ((fka)localObject).aaiI = paramString1;
    ((fka)localObject).aaiH = paramString2;
    ((fka)localObject).aatQ = paramString3;
    ((fka)localObject).aaiJ = paramString4;
    ((fka)localObject).Njp = com.tencent.mm.plugin.wallet_core.model.mall.c.ikd().bgN(paramString2);
    AppMethodBeat.o(67113);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, h paramh)
  {
    AppMethodBeat.i(67115);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(67115);
    return i;
  }
  
  public final int getType()
  {
    return 498;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(67114);
    this.Nxi = new PayInfo();
    paramArrayOfByte = (fkb)c.c.b(((com.tencent.mm.am.c)params).otC);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      Log.d("MicroMsg.NetSceneSubmitPayProductBuyInfo", "resp.ReqKey " + paramArrayOfByte.YIV);
      this.Nxi.appId = this.mAppId;
      this.Nxi.Wan = paramArrayOfByte.aalP;
      this.Nxi.hAT = paramArrayOfByte.YIV;
    }
    paramInt1 = paramInt3;
    if (paramInt3 == 0) {
      paramInt1 = paramArrayOfByte.aaiK;
    }
    params = paramString;
    if (Util.isNullOrNil(paramString)) {
      params = paramArrayOfByte.aaiL;
    }
    this.Nxi.YvF = String.valueOf(paramInt1);
    paramArrayOfByte = this.Nxi;
    if (params != null) {}
    for (paramString = String.valueOf(params);; paramString = "")
    {
      paramArrayOfByte.errMsg = paramString;
      Log.d("MicroMsg.NetSceneSubmitPayProductBuyInfo", "errCode " + paramInt1 + ", errMsg " + params);
      this.callback.onSceneEnd(paramInt2, paramInt1, params, this);
      AppMethodBeat.o(67114);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.model.g
 * JD-Core Version:    0.7.0.1
 */