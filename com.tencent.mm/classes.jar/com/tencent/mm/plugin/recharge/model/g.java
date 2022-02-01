package com.tencent.mm.plugin.recharge.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.mall.c;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.dff;
import com.tencent.mm.protocal.protobuf.dfg;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.wallet_core.c.j;
import com.tencent.mm.wallet_core.c.w;

public final class g
  extends w
  implements j
{
  private com.tencent.mm.ak.g callback;
  public String mAppId;
  private b rr;
  public PayInfo wfX;
  
  public g(MallRechargeProduct paramMallRechargeProduct, String paramString)
  {
    this(paramMallRechargeProduct.appId, paramMallRechargeProduct.wfu, paramMallRechargeProduct.dcO, paramString);
  }
  
  public g(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(67113);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new dff();
    ((b.a)localObject).hvu = new dfg();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/submitpayproductbuyinfo";
    ((b.a)localObject).funcId = 498;
    ((b.a)localObject).reqCmdId = 230;
    ((b.a)localObject).respCmdId = 1000000230;
    this.rr = ((b.a)localObject).aAz();
    localObject = (dff)this.rr.hvr.hvw;
    ac.d("MicroMsg.NetSceneSubmitPayProductBuyInfo", "remark: %s", new Object[] { paramString4 });
    this.mAppId = paramString1;
    ((dff)localObject).EIk = paramString1;
    ((dff)localObject).EIj = paramString2;
    ((dff)localObject).EPZ = paramString3;
    ((dff)localObject).EIl = paramString4;
    ((dff)localObject).Ewu = c.esN().azr(paramString2);
    AppMethodBeat.o(67113);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
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
    this.wfX = new PayInfo();
    paramArrayOfByte = (dfg)((b)paramq).hvs.hvw;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      ac.d("MicroMsg.NetSceneSubmitPayProductBuyInfo", "resp.ReqKey " + paramArrayOfByte.DTt);
      this.wfX.appId = this.mAppId;
      this.wfX.BPA = paramArrayOfByte.EJQ;
      this.wfX.dac = paramArrayOfByte.DTt;
    }
    paramInt1 = paramInt3;
    if (paramInt3 == 0) {
      paramInt1 = paramArrayOfByte.EIm;
    }
    paramq = paramString;
    if (bs.isNullOrNil(paramString)) {
      paramq = paramArrayOfByte.EIn;
    }
    this.wfX.DGK = String.valueOf(paramInt1);
    paramArrayOfByte = this.wfX;
    if (paramq != null) {}
    for (paramString = String.valueOf(paramq);; paramString = "")
    {
      paramArrayOfByte.errMsg = paramString;
      ac.d("MicroMsg.NetSceneSubmitPayProductBuyInfo", "errCode " + paramInt1 + ", errMsg " + paramq);
      this.callback.onSceneEnd(paramInt2, paramInt1, paramq, this);
      AppMethodBeat.o(67114);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.model.g
 * JD-Core Version:    0.7.0.1
 */