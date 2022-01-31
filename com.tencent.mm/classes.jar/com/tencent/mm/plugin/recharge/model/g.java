package com.tencent.mm.plugin.recharge.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.mall.c;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.ciq;
import com.tencent.mm.protocal.protobuf.cir;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.i;
import com.tencent.mm.wallet_core.c.u;

public final class g
  extends u
  implements i
{
  private f callback;
  public String mAppId;
  public PayInfo pVo;
  private b rr;
  
  public g(MallRechargeProduct paramMallRechargeProduct, String paramString)
  {
    this(paramMallRechargeProduct.appId, paramMallRechargeProduct.pUM, paramMallRechargeProduct.cqx, paramString);
  }
  
  public g(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(44205);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new ciq();
    ((b.a)localObject).fsY = new cir();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/submitpayproductbuyinfo";
    ((b.a)localObject).funcId = 498;
    ((b.a)localObject).reqCmdId = 230;
    ((b.a)localObject).respCmdId = 1000000230;
    this.rr = ((b.a)localObject).ado();
    localObject = (ciq)this.rr.fsV.fta;
    ab.d("MicroMsg.NetSceneSubmitPayProductBuyInfo", "remark: %s", new Object[] { paramString4 });
    this.mAppId = paramString1;
    ((ciq)localObject).wWG = paramString1;
    ((ciq)localObject).wWF = paramString2;
    ((ciq)localObject).xcu = paramString3;
    ((ciq)localObject).wWH = paramString4;
    ((ciq)localObject).wQf = c.cUX().afq(paramString2);
    AppMethodBeat.o(44205);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(44207);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(44207);
    return i;
  }
  
  public final int getType()
  {
    return 498;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(142121);
    this.pVo = new PayInfo();
    paramArrayOfByte = (cir)((b)paramq).fsW.fta;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      ab.d("MicroMsg.NetSceneSubmitPayProductBuyInfo", "resp.ReqKey " + paramArrayOfByte.wrH);
      this.pVo.appId = this.mAppId;
      this.pVo.uAe = paramArrayOfByte.wXR;
      this.pVo.cnI = paramArrayOfByte.wrH;
    }
    paramInt1 = paramInt3;
    if (paramInt3 == 0) {
      paramInt1 = paramArrayOfByte.wWI;
    }
    paramq = paramString;
    if (bo.isNullOrNil(paramString)) {
      paramq = paramArrayOfByte.wWJ;
    }
    this.pVo.wgu = String.valueOf(paramInt1);
    paramArrayOfByte = this.pVo;
    if (paramq != null) {}
    for (paramString = String.valueOf(paramq);; paramString = "")
    {
      paramArrayOfByte.errMsg = paramString;
      ab.d("MicroMsg.NetSceneSubmitPayProductBuyInfo", "errCode " + paramInt1 + ", errMsg " + paramq);
      this.callback.onSceneEnd(paramInt2, paramInt1, paramq, this);
      AppMethodBeat.o(142121);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.model.g
 * JD-Core Version:    0.7.0.1
 */