package com.tencent.mm.plugin.recharge.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wallet_core.model.mall.c;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.efa;
import com.tencent.mm.protocal.protobuf.efb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c.j;
import com.tencent.mm.wallet_core.c.w;

public final class g
  extends w
  implements j
{
  public PayInfo BDB;
  private i callback;
  public String mAppId;
  private d rr;
  
  public g(MallRechargeProduct paramMallRechargeProduct, String paramString)
  {
    this(paramMallRechargeProduct.appId, paramMallRechargeProduct.kHR, paramMallRechargeProduct.productId, paramString);
  }
  
  public g(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(67113);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new efa();
    ((d.a)localObject).iLO = new efb();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/submitpayproductbuyinfo";
    ((d.a)localObject).funcId = 498;
    ((d.a)localObject).iLP = 230;
    ((d.a)localObject).respCmdId = 1000000230;
    this.rr = ((d.a)localObject).aXF();
    localObject = (efa)this.rr.iLK.iLR;
    Log.d("MicroMsg.NetSceneSubmitPayProductBuyInfo", "remark: %s", new Object[] { paramString4 });
    this.mAppId = paramString1;
    ((efa)localObject).LOt = paramString1;
    ((efa)localObject).LOs = paramString2;
    ((efa)localObject).LXc = paramString3;
    ((efa)localObject).LOu = paramString4;
    ((efa)localObject).Bri = c.fSg().aVu(paramString2);
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
    this.BDB = new PayInfo();
    paramArrayOfByte = (efb)((d)params).iLL.iLR;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      Log.d("MicroMsg.NetSceneSubmitPayProductBuyInfo", "resp.ReqKey " + paramArrayOfByte.KKR);
      this.BDB.appId = this.mAppId;
      this.BDB.IqM = paramArrayOfByte.LQw;
      this.BDB.dDL = paramArrayOfByte.KKR;
    }
    paramInt1 = paramInt3;
    if (paramInt3 == 0) {
      paramInt1 = paramArrayOfByte.LOv;
    }
    params = paramString;
    if (Util.isNullOrNil(paramString)) {
      params = paramArrayOfByte.LOw;
    }
    this.BDB.Kxt = String.valueOf(paramInt1);
    paramArrayOfByte = this.BDB;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.model.g
 * JD-Core Version:    0.7.0.1
 */