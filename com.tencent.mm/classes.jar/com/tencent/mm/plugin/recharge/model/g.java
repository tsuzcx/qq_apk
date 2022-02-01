package com.tencent.mm.plugin.recharge.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.mall.c;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.dks;
import com.tencent.mm.protocal.protobuf.dkt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.c.j;
import com.tencent.mm.wallet_core.c.w;

public final class g
  extends w
  implements j
{
  private f callback;
  public String mAppId;
  private b rr;
  public PayInfo xnF;
  
  public g(MallRechargeProduct paramMallRechargeProduct, String paramString)
  {
    this(paramMallRechargeProduct.appId, paramMallRechargeProduct.jDb, paramMallRechargeProduct.dok, paramString);
  }
  
  public g(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(67113);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new dks();
    ((b.a)localObject).hNN = new dkt();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/submitpayproductbuyinfo";
    ((b.a)localObject).funcId = 498;
    ((b.a)localObject).hNO = 230;
    ((b.a)localObject).respCmdId = 1000000230;
    this.rr = ((b.a)localObject).aDC();
    localObject = (dks)this.rr.hNK.hNQ;
    ad.d("MicroMsg.NetSceneSubmitPayProductBuyInfo", "remark: %s", new Object[] { paramString4 });
    this.mAppId = paramString1;
    ((dks)localObject).Grb = paramString1;
    ((dks)localObject).Gra = paramString2;
    ((dks)localObject).Gzq = paramString3;
    ((dks)localObject).Grc = paramString4;
    ((dks)localObject).xbo = c.eGT().aEB(paramString2);
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
    this.xnF = new PayInfo();
    paramArrayOfByte = (dkt)((b)paramq).hNL.hNQ;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      ad.d("MicroMsg.NetSceneSubmitPayProductBuyInfo", "resp.ReqKey " + paramArrayOfByte.FyM);
      this.xnF.appId = this.mAppId;
      this.xnF.DpS = paramArrayOfByte.GsS;
      this.xnF.dlu = paramArrayOfByte.FyM;
    }
    paramInt1 = paramInt3;
    if (paramInt3 == 0) {
      paramInt1 = paramArrayOfByte.Grd;
    }
    paramq = paramString;
    if (bt.isNullOrNil(paramString)) {
      paramq = paramArrayOfByte.Gre;
    }
    this.xnF.FlR = String.valueOf(paramInt1);
    paramArrayOfByte = this.xnF;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.model.g
 * JD-Core Version:    0.7.0.1
 */