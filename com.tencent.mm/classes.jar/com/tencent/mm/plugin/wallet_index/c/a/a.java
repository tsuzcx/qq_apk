package com.tencent.mm.plugin.wallet_index.c.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ciy;
import com.tencent.mm.protocal.protobuf.ciz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.c.w;

public final class a
  extends w
{
  public String DpS;
  public String Dqf;
  private f callback;
  public String jumpUrl;
  public String prepayId;
  private b rr;
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt)
  {
    AppMethodBeat.i(71846);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new ciy();
    ((b.a)localObject).hNN = new ciz();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/payibggenprepay";
    ((b.a)localObject).funcId = 1563;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (ciy)this.rr.hNK.hNQ;
    ((ciy)localObject).iht = paramString1;
    ((ciy)localObject).FXf = paramString4;
    ((ciy)localObject).FXe = paramString2;
    ((ciy)localObject).FXg = paramString5;
    ((ciy)localObject).FXh = paramString6;
    ((ciy)localObject).FDD = paramString3;
    ((ciy)localObject).FWa = paramString7;
    ((ciy)localObject).GsQ = paramString8;
    ((ciy)localObject).FqH = paramInt;
    ad.d("MicroMsg.NetSceneIbgPayGenPrepay", String.format("appid:%s,packageExt:%s,nonceStr:%s,paySignature:%s,signtype:%s,timeStamp:%s,url:%s,bizUsername:%s,", new Object[] { paramString1, paramString4, paramString2, paramString5, paramString6, paramString3, paramString7, paramString8 }));
    AppMethodBeat.o(71846);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(71848);
    this.callback = paramf;
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
    paramq = (ciz)((b)paramq).hNL.hNQ;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      ad.i("MicroMsg.NetSceneIbgPayGenPrepay", "hy: gen ibg prepay jump url. biz_errcode: %d, biz_errmsg: %s", new Object[] { Integer.valueOf(paramq.qel), paramq.qem });
      paramString = paramq.qem;
      paramInt3 = paramq.qel;
      this.jumpUrl = paramq.ueY;
      this.prepayId = paramq.GsR;
      this.DpS = paramq.GsS;
      this.Dqf = paramq.HcL;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.a.a
 * JD-Core Version:    0.7.0.1
 */