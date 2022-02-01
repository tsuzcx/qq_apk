package com.tencent.mm.plugin.recharge.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wallet_core.model.mall.c;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.epb;
import com.tencent.mm.protocal.protobuf.epc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c.j;
import com.tencent.mm.wallet_core.c.w;

public final class g
  extends w
  implements j
{
  public PayInfo HzF;
  private i callback;
  public String mAppId;
  private d rr;
  
  public g(MallRechargeProduct paramMallRechargeProduct, String paramString)
  {
    this(paramMallRechargeProduct.appId, paramMallRechargeProduct.nBK, paramMallRechargeProduct.productId, paramString);
  }
  
  public g(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(67113);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new epb();
    ((d.a)localObject).lBV = new epc();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/submitpayproductbuyinfo";
    ((d.a)localObject).funcId = 498;
    ((d.a)localObject).lBW = 230;
    ((d.a)localObject).respCmdId = 1000000230;
    this.rr = ((d.a)localObject).bgN();
    localObject = (epb)d.b.b(this.rr.lBR);
    Log.d("MicroMsg.NetSceneSubmitPayProductBuyInfo", "remark: %s", new Object[] { paramString4 });
    this.mAppId = paramString1;
    ((epb)localObject).SWR = paramString1;
    ((epb)localObject).SWQ = paramString2;
    ((epb)localObject).TgA = paramString3;
    ((epb)localObject).SWS = paramString4;
    ((epb)localObject).HlB = c.gKL().bhd(paramString2);
    AppMethodBeat.o(67113);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(67115);
    this.callback = parami;
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
    this.HzF = new PayInfo();
    paramArrayOfByte = (epc)d.c.b(((d)params).lBS);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      Log.d("MicroMsg.NetSceneSubmitPayProductBuyInfo", "resp.ReqKey " + paramArrayOfByte.RLK);
      this.HzF.appId = this.mAppId;
      this.HzF.Pjv = paramArrayOfByte.SYX;
      this.HzF.fwv = paramArrayOfByte.RLK;
    }
    paramInt1 = paramInt3;
    if (paramInt3 == 0) {
      paramInt1 = paramArrayOfByte.SWT;
    }
    params = paramString;
    if (Util.isNullOrNil(paramString)) {
      params = paramArrayOfByte.SWU;
    }
    this.HzF.Rzh = String.valueOf(paramInt1);
    paramArrayOfByte = this.HzF;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.model.g
 * JD-Core Version:    0.7.0.1
 */