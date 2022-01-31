package com.tencent.mm.plugin.wallet.pay.a.b;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.gd;
import com.tencent.mm.protocal.c.lk;
import com.tencent.mm.protocal.c.ll;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.s;

public class a
  extends s
{
  private b dmK;
  private f dmL;
  
  public a(String paramString, int paramInt1, int paramInt2)
  {
    b.a locala = new b.a();
    lk locallk = new lk();
    locallk.sye = paramString;
    locallk.sHe = paramInt1;
    locallk.sHf = paramInt2;
    locala.ecH = locallk;
    locala.ecI = new ll();
    locala.uri = getUri();
    locala.ecG = HH();
    locala.ecJ = 0;
    locala.ecK = 0;
    locala.ecM = com.tencent.mm.wallet_core.ui.e.afr(paramString);
    this.dmK = locala.Kt();
    y.i("MicroMsg.NetSceneCancelPay", "request uri: %s, reqKey: %s, payScene: %d, payChannel:%d", new Object[] { getUri(), paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public int HH()
  {
    return 2823;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void e(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    y.d("MicroMsg.NetSceneCancelPay", "response uri: %s, errType: %d, errCode: %d, errMsg: %s", new Object[] { getUri(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0)) {}
    try
    {
      paramq = (ll)((b)paramq).ecF.ecN;
      y.i("MicroMsg.NetSceneCancelPay", "NetSceneCancelPay BaseResponse.Ret is %d, BaseResponse.ErrMsg is %s", new Object[] { Integer.valueOf(paramq.tFx.sze), paramq.tFx.sAn });
      if (this.dmL != null) {
        this.dmL.onSceneEnd(paramInt1, paramInt2, paramString, this);
      }
      return;
    }
    catch (Exception paramq)
    {
      for (;;)
      {
        y.i("MicroMsg.NetSceneCancelPay", paramq.getMessage());
      }
    }
  }
  
  public final int getType()
  {
    return HH();
  }
  
  public String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/ts_cancelpay";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.a.b.a
 * JD-Core Version:    0.7.0.1
 */