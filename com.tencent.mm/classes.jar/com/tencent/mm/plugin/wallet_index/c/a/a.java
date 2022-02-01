package com.tencent.mm.plugin.wallet_index.c.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bzd;
import com.tencent.mm.protocal.protobuf.bze;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.c.w;

public final class a
  extends w
{
  public String Axg;
  public String Axt;
  private g callback;
  public String jumpUrl;
  public String prepayId;
  private b rr;
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt)
  {
    AppMethodBeat.i(71846);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new bzd();
    ((b.a)localObject).gUV = new bze();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/payibggenprepay";
    ((b.a)localObject).funcId = 1563;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (bzd)this.rr.gUS.gUX;
    ((bzd)localObject).hnC = paramString1;
    ((bzd)localObject).CXl = paramString4;
    ((bzd)localObject).CXk = paramString2;
    ((bzd)localObject).CXm = paramString5;
    ((bzd)localObject).CXn = paramString6;
    ((bzd)localObject).CFH = paramString3;
    ((bzd)localObject).CWf = paramString7;
    ((bzd)localObject).DoO = paramString8;
    ((bzd)localObject).Ctl = paramInt;
    ad.d("MicroMsg.NetSceneIbgPayGenPrepay", String.format("appid:%s,packageExt:%s,nonceStr:%s,paySignature:%s,signtype:%s,timeStamp:%s,url:%s,bizUsername:%s,", new Object[] { paramString1, paramString4, paramString2, paramString5, paramString6, paramString3, paramString7, paramString8 }));
    AppMethodBeat.o(71846);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(71848);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(71848);
    return i;
  }
  
  public final int getType()
  {
    return 1563;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(71847);
    ad.i("MicroMsg.NetSceneIbgPayGenPrepay", "hy: gen ibg prepay raw net errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = (bze)((b)paramq).gUT.gUX;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      ad.i("MicroMsg.NetSceneIbgPayGenPrepay", "hy: gen ibg prepay jump url. biz_errcode: %d, biz_errmsg: %s", new Object[] { Integer.valueOf(paramq.oXv), paramq.oXw });
      paramString = paramq.oXw;
      paramInt3 = paramq.oXv;
      this.jumpUrl = paramq.rZo;
      this.prepayId = paramq.DoP;
      this.Axg = paramq.DoQ;
      this.Axt = paramq.DVQ;
    }
    for (;;)
    {
      paramq = paramString;
      if (bt.isNullOrNil(paramString)) {
        paramq = aj.getContext().getString(2131765224);
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramq, this);
      AppMethodBeat.o(71847);
      return;
      ad.e("MicroMsg.NetSceneIbgPayGenPrepay", "hy: gen ibg prepay jump url failed");
      this.jumpUrl = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.a.a
 * JD-Core Version:    0.7.0.1
 */